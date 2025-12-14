import { TareasSqliteRepository } from "./repository/TareaRepositoryLocal";
import { TareasRemoteClient } from "./repository/TareaRepositoryRemoto";
import { TareasService } from "./service/TareasService";

const API_URL = "http://localhost:8080/api/tareas";

async function main() {
  console.log("=== Gestor de Tareas ===\n");

  try {
    const localRepo = new TareasSqliteRepository();
    const remoteClient = new TareasRemoteClient(API_URL);
    const service = new TareasService(localRepo, remoteClient);

    console.log("Servicio inicializado correctamente\n");

    // Listar las tareas que hay en remoto
    console.log("-> Listando tareas remotas");
    const remotas = await service.listarTareas('remoto');
    console.log(`Hay ${remotas.length} tareas en el servidor\n`);

    // Sincronizar todo del servidor a local
    console.log("-> Sincronizando desde servidor a local");
    const { importadas } = await service.sincronizarRemotoALocal();
    console.log(`Se han importado ${importadas} tareas\n`);

    // Crear una tarea nueva solo en local
    console.log("-> Creando tarea en local");
    const tareaLocal = await service.crearTarea({
      titulo: "Revisar código TypeScript",
      descripcion: "Comprobar que SQLite funciona bien",
      completada: false
    }, 'local');
    console.log(`Tarea creada con ID: ${tareaLocal.id}\n`);

    // Crear otra tarea en remoto
    console.log("-> Creando tarea en remoto");
    const tareaRemota = await service.crearTarea({
      titulo: "Subir proyecto a Git",
      descripcion: "Hacer push del código final",
      completada: true
    }, 'remoto');
    console.log(`Tarea remota creada con ID: ${tareaRemota.id}\n`);

    // Actualizar la tarea local
    console.log("-> Actualizando tarea local");
    await service.actualizarTarea({
      ...tareaLocal,
      completada: true
    }, 'local');
    console.log(`Tarea ${tareaLocal.id} actualizada\n`);

    // Ver todas las tareas locales
    console.log("-> Tareas guardadas en local:");
    const locales = await service.listarTareas('local');
    
    locales.forEach(t => {
      const estado = t.completada ? '[X]' : '[ ]';
      console.log(`  ${estado} ${t.id} - ${t.titulo}`);
    });

    console.log("\nDemo completada");

  } catch (error) {
    console.error("Error:", error);
    process.exit(1);
  }
}

main();
