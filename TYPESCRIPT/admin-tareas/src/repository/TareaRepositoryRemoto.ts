import { Tarea, IdTarea } from "../model/Tarea";

export class TareasRemoteClient {
  constructor(private baseUrl: string = "http://localhost:8080/api/tareas") {}

  async findAll(): Promise<Tarea[]> {
    const res = await fetch(this.baseUrl);
    if (!res.ok) throw new Error(`Error ${res.status}: ${res.statusText}`);
    return res.json();
  }

  async findById(id: IdTarea): Promise<Tarea | null> {
    const res = await fetch(`${this.baseUrl}/${id}`);
    if (res.status === 404) return null;
    if (!res.ok) throw new Error(`Error ${res.status}: ${res.statusText}`);
    return res.json();
  }

  async create(tarea: Omit<Tarea, 'id'>): Promise<Tarea> {
    const res = await fetch(this.baseUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(tarea)
    });
    if (!res.ok) throw new Error(`Error ${res.status}: ${res.statusText}`);
    return res.json();
  }

  async update(tarea: Tarea): Promise<Tarea> {
    const res = await fetch(`${this.baseUrl}/${tarea.id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(tarea)
    });
    if (!res.ok) throw new Error(`Error ${res.status}: ${res.statusText}`);
    return res.json();
  }

  async delete(id: IdTarea): Promise<void> {
    const res = await fetch(`${this.baseUrl}/${id}`, { method: "DELETE" });
    if (!res.ok && res.status !== 404) {
      throw new Error(`Error ${res.status}: ${res.statusText}`);
    }
  }
}
