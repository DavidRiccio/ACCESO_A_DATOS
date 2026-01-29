import { ReservaHotel, IdReserva, FiltroReserva } from "./models";

export function esIsoValida(iso: string): boolean {
  const timestamp = Date.parse(iso);
  return !isNaN(timestamp);
}

export function crearReserva(
  id: IdReserva,
  habitacion: number,
  cliente: string,
  fechaEntrada: string,
  fechaSalida: string,
  observaciones?: string
): ReservaHotel {
  if (!esIsoValida(fechaEntrada) || !esIsoValida(fechaSalida)) {
    throw new Error("Fechas no válidas");
  }

  return {
    id,
    habitacion,
    cliente,
    fechaEntrada,
    fechaSalida,
    confirmada: false,
    observaciones
  };
}

export function confirmarReserva(reservas: ReservaHotel[], id: IdReserva): ReservaHotel[] {
  return reservas.map(res =>
    res.id === id ? { ...res, confirmada: true } : res
  );
}

export function filtrarReservas(reservas: ReservaHotel[], filtro: FiltroReserva): ReservaHotel[] {
  if (filtro === "todas") return reservas;
  return reservas.filter(res =>
    filtro === "confirmadas" ? res.confirmada : !res.confirmada
  );
}

export function haySolapamiento(
  reservas: ReservaHotel[],
  habitacion: number,
  entradaISO: string,
  salidaISO: string
): boolean {
  if (!esIsoValida(entradaISO) || !esIsoValida(salidaISO)) {
    return true;
  }
  if (entradaISO >= salidaISO) {
    return true;
  }

  return reservas.some(res => {
    if (res.habitacion !== habitacion) return false;

    const maxEntrada = entradaISO > res.fechaEntrada ? entradaISO : res.fechaEntrada;
    const minSalida = salidaISO < res.fechaSalida ? salidaISO : res.fechaSalida;

    return maxEntrada < minSalida;
  });
}