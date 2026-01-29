import { Reserva } from "../domain/models";

export interface ReservaRepository {
  init(): Promise<void>;
  create(reserva: Reserva): Promise<void>;
  findAll(): Promise<Reserva[]>;
  findById(id: string): Promise<Reserva | null>;
  cancel(id: string): Promise<boolean>;
  upsertMany(reservas: Reserva[]): Promise<void>;
}
