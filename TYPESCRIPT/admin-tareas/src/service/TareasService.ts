import { Tarea, IdTarea } from "../model/Tarea";
import { TareasSqliteRepository } from "../repository/TareaRepositoryLocal";
import { TareasRemoteClient } from "../repository/TareaRepositoryRemoto";

type Origen = 'local' | 'remoto';

export class TareasService {
  constructor(
    private localRepo: TareasSqliteRepository,
    private remoteClient: TareasRemoteClient
  ) {
    this.localRepo.init();
  }

  async listarTareas(origen: Origen): Promise<Tarea[]> {
    return origen === 'local' 
      ? this.localRepo.findAll()
      : this.remoteClient.findAll();
  }

  async obtenerTarea(id: IdTarea, origen: Origen): Promise<Tarea | null> {
    return origen === 'local'
      ? this.localRepo.findById(id)
      : this.remoteClient.findById(id);
  }

  async crearTarea(tarea: Omit<Tarea, 'id'>, origen: Origen): Promise<Tarea> {
    return origen === 'local'
      ? this.localRepo.create(tarea)
      : this.remoteClient.create(tarea);
  }

  async actualizarTarea(tarea: Tarea, origen: Origen): Promise<void> {
    if (origen === 'local') {
      this.localRepo.update(tarea);
    } else {
      await this.remoteClient.update(tarea);
    }
  }

  async borrarTarea(id: IdTarea, origen: Origen): Promise<void> {
    origen === 'local'
      ? this.localRepo.delete(id)
      : await this.remoteClient.delete(id);
  }

  async sincronizarRemotoALocal(): Promise<{ importadas: number }> {
    const remotas = await this.remoteClient.findAll();
    this.localRepo.deleteAll();
    
    let importadas = 0;
    for (const tarea of remotas) {
      try {
        this.localRepo.create({
          titulo: tarea.titulo,
          descripcion: tarea.descripcion,
          completada: tarea.completada
        });
        importadas++;
      } catch (err) {
        console.error(`Error importando "${tarea.titulo}":`, err);
      }
    }
    
    return { importadas };
  }
}
