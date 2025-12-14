import { TareasRemoteClient } from '../src/repository/TareaRepositoryRemoto';

global.fetch = jest.fn();

describe('TareasRemoteClient', () => {
  let client: TareasRemoteClient;

  beforeEach(() => {
    client = new TareasRemoteClient('http://localhost:8080/api/tareas');
    jest.clearAllMocks();
  });

  test('debe obtener todas las tareas', async () => {
    const mockTareas = [
      { id: '1', titulo: 'Tarea 1', completada: false }
    ];

    (fetch as jest.Mock).mockResolvedValueOnce({
      ok: true,
      json: async () => mockTareas
    });

    const tareas = await client.findAll();
    expect(tareas).toEqual(mockTareas);
  });

  test('debe crear una tarea', async () => {
    const nueva = { titulo: 'Nueva', completada: false };
    const mockRespuesta = { id: '1', ...nueva };

    (fetch as jest.Mock).mockResolvedValueOnce({
      ok: true,
      json: async () => mockRespuesta
    });

    const tarea = await client.create(nueva);
    expect(tarea.id).toBe('1');
  });
});
