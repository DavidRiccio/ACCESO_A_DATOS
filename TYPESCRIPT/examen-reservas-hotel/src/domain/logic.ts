import { Habitacion, Reserva, EstadoReserva } from "./models";

const MS_DIA = 1000 * 60 * 60 * 24;

function toDateOnlyUTC(isoYMD: string): Date {
  return new Date(isoYMD)

}

export function calcularNoches(fechaEntrada: string, fechaSalida: string): number {

  const inicio = new Date(fechaEntrada).getTime();
  const fin = new Date(fechaSalida).getTime();

  if (isNaN(inicio) || isNaN(fin)) {
    throw new Error("Fecha inválida");
  }

  if (fin <= inicio) {
    throw new Error("La fecha de salida debe ser posterior a la de entrada.");
  }

  const diferencia = fin - inicio;
  return Math.floor(diferencia / MS_DIA);
}

export function calcularPrecioTotal(reserva: Reserva, habitacion: Habitacion): number {
  const noches = calcularNoches(reserva.fechaEntrada, reserva.fechaSalida);
  return noches * habitacion.precioPorNoche;
}


export function hayConflicto(a: Reserva, b: Reserva): boolean {
  if (a.habitacionId !== b.habitacionId) {
    return false;
  }
  if (a.estado === EstadoReserva.CANCELADA || b.estado === EstadoReserva.CANCELADA) {
    return false;
  }
  const maxEntrada = a.fechaEntrada > b.fechaEntrada ? a.fechaEntrada : b.fechaEntrada;
  const minSalida = a.fechaSalida < b.fechaSalida ? a.fechaSalida : b.fechaSalida;

  return maxEntrada < minSalida;
}
