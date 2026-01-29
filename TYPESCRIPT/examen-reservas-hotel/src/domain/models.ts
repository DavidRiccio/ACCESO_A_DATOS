export enum EstadoReserva {
  CONFIRMADA = "CONFIRMADA",
  CANCELADA = "CANCELADA",
  FINALIZADA = "FINALIZADA"
}

export interface cliente {
  id: string
  nombre: string
  email: string
}


export interface Habitacion {
  id: string
  numero: string
  tipo: string
  precioPorNoche: number
}

export interface Reserva {
  id: string
  clienteId: string
  habitacionId: string
  fechaEntrada: string
  fechaSalida: string
  estado: EstadoReserva
}
