import { ReservaHotel, IdReserva, NuevaReserva, ActualizacionReserva } from "../models";

const API_URL = "http://localhost:3000/reservas";

async function validarRespuesta(res: Response, mensajeError: string) {
  if (!res.ok) {
    const cuerpo = await res.json().catch(() => ({}));
    throw new Error(`${mensajeError}: ${cuerpo.message || res.statusText}`);
  }
  return res;
}

export async function obtenerReservas(): Promise<ReservaHotel[]> {
  const res = await fetch(API_URL);
  await validarRespuesta(res, "Error al cargar reservas");
  return res.json();
}

export async function crearReservaRemota(nueva: NuevaReserva): Promise<ReservaHotel> {
  const res = await fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(nueva),
  });
  await validarRespuesta(res, "Error al crear la reserva");
  return res.json();
}

export async function actualizarReservaRemota(id: IdReserva, patch: ActualizacionReserva): Promise<ReservaHotel> {
  const res = await fetch(`${API_URL}/${id}`, {
    method: "PATCH",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(patch),
  });
  await validarRespuesta(res, `Error al actualizar reserva ${id}`);
  return res.json();
}

export async function borrarReservaRemota(id: IdReserva): Promise<void> {
  const res = await fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  });
  await validarRespuesta(res, "Error al borrar la reserva");
}