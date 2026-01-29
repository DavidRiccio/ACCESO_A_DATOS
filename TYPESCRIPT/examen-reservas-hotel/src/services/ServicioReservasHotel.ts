import { FiltroReserva, NuevaReserva, OrigenDatos, ReservaHotel } from "../models";
import { filtrarReservas } from "../reservas";
import { RepositorioReservasHotelSqlite } from "../db/repositorioReservasHotelSqlite";

export interface ClienteReservasRemoto {
  obtenerReservas(): Promise<ReservaHotel[]>;
  crearReservaRemota(reserva: NuevaReserva): Promise<ReservaHotel>;
}

export class ServicioReservasHotel {
  constructor(
    private repoLocal: RepositorioReservasHotelSqlite,
    private remoto: ClienteReservasRemoto
  ) { }

  async crear(origen: OrigenDatos, reserva: NuevaReserva): Promise<ReservaHotel> {
    if (origen === "remoto") {
      return this.remoto.crearReservaRemota(reserva);
    }
    return this.repoLocal.crear(reserva);
  }

  async listar(origen: OrigenDatos, filtro: FiltroReserva): Promise<ReservaHotel[]> {
    const reservas = (origen === "remoto")
      ? await this.remoto.obtenerReservas()
      : this.repoLocal.obtenerTodas();

    return filtrarReservas(reservas, filtro);
  }

  async sincronizarRemotoALocal(): Promise<{ importadas: number }> {
    const remotas = await this.remoto.obtenerReservas();

    this.repoLocal.borrarTodas();
    let cont = 0;
    for (const res of remotas) {
      this.repoLocal.crear(res);
      cont++;
    }

    return { importadas: cont };
  }
}