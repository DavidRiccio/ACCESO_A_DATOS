import { SQLiteReservaRepository } from "../src/repositories/SQLiteReservaRepository";
import { Reserva, EstadoReserva } from "../src/domain/models";

describe("SQLiteReservaRepository", () => {
  let repo: SQLiteReservaRepository;

  beforeEach(async () => {
    // We use a file-based db for tests or :memory: if supported by the driver/wrapper adequately
    // The implementation uses sqlite3 driver via 'sqlite' wrapper.
    repo = new SQLiteReservaRepository(":memory:");
    await repo.init();
  });

  test("init: crea tabla reservas y empieza vacía", async () => {
    const all = await repo.findAll();
    expect(all).toEqual([]);
  });

  test("create + findAll", async () => {
    const r: Reserva = {
      id: "1",
      clienteId: "c1",
      habitacionId: "h1",
      fechaEntrada: "2026-01-10",
      fechaSalida: "2026-01-15",
      estado: EstadoReserva.CONFIRMADA
    };
    await repo.create(r);
    const all = await repo.findAll();
    expect(all).toHaveLength(1);
    expect(all[0]).toEqual(r);
  });

  test("findById", async () => {
    const r: Reserva = {
      id: "2",
      clienteId: "c2",
      habitacionId: "h2",
      fechaEntrada: "2026-02-01",
      fechaSalida: "2026-02-05",
      estado: EstadoReserva.CONFIRMADA
    };
    await repo.create(r);

    const found = await repo.findById("2");
    expect(found).toEqual(r);

    const notFound = await repo.findById("999");
    expect(notFound).toBeNull();
  });

  test("cancel", async () => {
    const r: Reserva = {
      id: "3",
      clienteId: "c3",
      habitacionId: "h3",
      fechaEntrada: "2026-03-01",
      fechaSalida: "2026-03-05",
      estado: EstadoReserva.CONFIRMADA
    };
    await repo.create(r);

    const ok = await repo.cancel("3");
    expect(ok).toBe(true);

    const updated = await repo.findById("3");
    expect(updated?.estado).toBe(EstadoReserva.CANCELADA);

    const fail = await repo.cancel("999");
    expect(fail).toBe(false);
  });

  test("upsertMany", async () => {
    const rA: Reserva = { id: "A", clienteId: "c", habitacionId: "h", fechaEntrada: "2026-01-01", fechaSalida: "2026-01-02", estado: EstadoReserva.CONFIRMADA };
    const rB: Reserva = { id: "B", clienteId: "c", habitacionId: "h", fechaEntrada: "2026-01-03", fechaSalida: "2026-01-04", estado: EstadoReserva.CONFIRMADA };

    await repo.create(rA);

    // upsert A (existing) and B (new)
    await repo.upsertMany([rA, rB]);

    const all = await repo.findAll();
    // Expect 2 items (A not duplicated)
    expect(all).toHaveLength(2);
    expect(all.map(x => x.id).sort()).toEqual(["A", "B"]);
  });
});
