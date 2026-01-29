import { Habitacion, Reserva, EstadoReserva } from "./models";

const MS_DIA = 1000 * 60 * 60 * 24;

function toDateOnlyUTC(isoYMD: string): Date {
  return new Date(isoYMD);
}

export function calcularNoches(fechaEntrada: string, fechaSalida: string): number {
 const fecha1= toDateOnlyUTC(fechaEntrada);
 const fecha2= toDateOnlyUTC(fechaSalida);
 return Math.floor((fecha2.getTime() - fecha1.getTime()) / (1000 * 60 * 60 * 24))
}

export function calcularPrecioTotal(reserva: Reserva, habitacion: Habitacion): number {
  const noches = calcularNoches(reserva.fechaSalida, reserva.fechaEntrada);
  const precio = habitacion.precioPorNoche;
  return precio * noches;
}


export function hayConflicto(a: Reserva, b: Reserva): boolean {
  if (a.habitacionId != b.habitacionId || a.estado == "CANCELADA" || b.estado == "CANCELADA"){
    return false;
  }
  return true;
}
