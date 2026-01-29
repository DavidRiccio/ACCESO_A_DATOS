import { Reserva } from "../domain/models";

export class ReservaRestService {
  private readonly baseUrl = "http://localhost:3000/reservas"; 

  private async handleResponse<T>(response: Response): Promise<T> {
    if (!response.ok) {
      const errorData = await response.json().catch(() => ({}));
      throw new Error(errorData.message || `Error en la petición: ${response.status}`);
    }
    return response.json();
  }

  async getReservas(): Promise<Reserva[]> {
    const response = await fetch(this.baseUrl);
    return this.handleResponse<Reserva[]>(response);
  }

  async getReserva(id: string): Promise<Reserva> {
    const response = await fetch(`${this.baseUrl}/${id}`);
    return this.handleResponse<Reserva>(response);
  }

  async createReserva(reserva: Reserva): Promise<Reserva> {
    const response = await fetch(this.baseUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(reserva),
    });
    return this.handleResponse<Reserva>(response);
  }

  async updateReserva(id: string, patch: Partial<Reserva>): Promise<Reserva> {
    const response = await fetch(`${this.baseUrl}/${id}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(patch),
    });
    return this.handleResponse<Reserva>(response);
  }

  async deleteReserva(id: string): Promise<void> {
    const response = await fetch(`${this.baseUrl}/${id}`, {
      method: "DELETE",
    });
    
    if (!response.ok) {
      throw new Error(`No se pudo eliminar la reserva: ${response.status}`);
    }
  }
}