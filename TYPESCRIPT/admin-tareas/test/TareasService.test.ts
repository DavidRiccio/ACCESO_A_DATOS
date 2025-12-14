import { TareasService } from '../src/service/TareasService';
import { TareasSqliteRepository } from '../src/repository/TareaRepositoryLocal';
import { TareasRemoteClient } from '../src/repository/TareaRepositoryRemoto';

jest.mock('../src/repository/TareaRepositoryLocal');
jest.mock('../src/repository/TareaRepositoryRemoto');

describe('TareasService', () => {
  let service: TareasService;
  let mockLocalRepo: jest.Mocked<TareasSqliteRepository>;
  let mockRemoteClient: jest.Mocked<TareasRemoteClient>;

  beforeEach(() => {
    mockLocalRepo = new TareasSqliteRepository() as jest.Mocked<TareasSqliteRepository>;
    mockRemoteClient = new TareasRemoteClient() as jest.Mocked<TareasRemoteClient>;
    
    mockLocalRepo.init = jest.fn();
    service = new TareasService(mockLocalRepo, mockRemoteClient);
  });

  test('debe listar tareas locales', async () => {
    const mockTareas = [{ id: '1', titulo: 'Test', completada: false }];
    mockLocalRepo.findAll = jest.fn().mockReturnValue(mockTareas);

    const tareas = await service.listarTareas('local');
    
    expect(mockLocalRepo.findAll).toHaveBeenCalled();
    expect(tareas).toEqual(mockTareas);
  });

  test('debe crear tarea en remoto', async () => {
    const nueva = { titulo: 'Nueva', completada: false };
    const mockCreada = { id: '1', ...nueva };

    mockRemoteClient.create = jest.fn().mockResolvedValue(mockCreada);

    const tarea = await service.crearTarea(nueva, 'remoto');
    
    expect(mockRemoteClient.create).toHaveBeenCalledWith(nueva);
    expect(tarea.id).toBe('1');
  });

  test('debe sincronizar remoto a local', async () => {
    const tareasRemotas = [
      { id: '1', titulo: 'Tarea 1', completada: false },
      { id: '2', titulo: 'Tarea 2', completada: true }
    ];

    mockRemoteClient.findAll = jest.fn().mockResolvedValue(tareasRemotas);
    mockLocalRepo.deleteAll = jest.fn();
    mockLocalRepo.create = jest.fn();

    const resultado = await service.sincronizarRemotoALocal();

    expect(mockRemoteClient.findAll).toHaveBeenCalled();
    expect(mockLocalRepo.deleteAll).toHaveBeenCalled();
    expect(mockLocalRepo.create).toHaveBeenCalledTimes(2);
    expect(resultado.importadas).toBe(2);
  });
});
