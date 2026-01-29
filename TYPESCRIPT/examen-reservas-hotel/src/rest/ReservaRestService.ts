import { Reserva } from "../domain/models";
const API_URL = "http://localhost:3000/reservas";

export class ReservaRestService {
  
  async getReservas(): Promise<Reserva[]> {
    const res = await fetch(`${API_URL}/reservas`);
    if (!res.ok) throw new Error(`Error ${res.status}: ${res.statusText}`);
    return res.json();
  }

  async getReserva(id: string): Promise<Reserva> {
    const res = await fetch(`${API_URL}/reservas/${id}`);
    if (!res.ok) throw new Error(`Error ${res.status}: ${res.statusText}`);
    return res.json();  }

  async createReserva(reserva: Reserva): Promise<Reserva> {
    const res = await fetch(`${API_URL}/reservas/${reserva.id}`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(reserva)
    });
    if (!res.ok) throw new Error(`Error ${res.status}: ${res.statusText}`);
    return res.json();
  }

  async updateReserva(id: string, patch: Partial<Reserva>): Promise<Reserva> {
    throw new Error("TODO");
  }

  async deleteReserva(id: string): Promise<void> {
    throw new Error("TODO");
  }
}
