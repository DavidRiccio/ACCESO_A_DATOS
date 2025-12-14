import { TareasSqliteRepository } from '../src/repository/TareaRepositoryLocal';
import * as fs from 'fs';

const TEST_DB = './test-tareas.db';

describe('TareasSqliteRepository', () => {
  let repo: TareasSqliteRepository;

  beforeEach(() => {
    if (fs.existsSync(TEST_DB)) {
      fs.unlinkSync(TEST_DB);
    }
    repo = new TareasSqliteRepository();
    repo.init();
  });

  afterEach(() => {
    if (fs.existsSync(TEST_DB)) {
      fs.unlinkSync(TEST_DB);
    }
  });

  test('debe crear y listar tareas', () => {
    const tarea = repo.create({ titulo: 'Test', completada: false });
    const tareas = repo.findAll();

    expect(tareas).toHaveLength(1);
    expect(tareas[0].titulo).toBe('Test');
  });

  test('debe actualizar una tarea', () => {
    const tarea = repo.create({ titulo: 'Original', completada: false });
    
    repo.update({ ...tarea, titulo: 'Actualizada', completada: true });
    
    const actualizada = repo.findById(tarea.id);
    expect(actualizada?.titulo).toBe('Actualizada');
    expect(actualizada?.completada).toBe(true);
  });

  test('debe eliminar todas las tareas', () => {
    repo.create({ titulo: 'Tarea 1', completada: false });
    repo.create({ titulo: 'Tarea 2', completada: false });
    
    repo.deleteAll();
    
    expect(repo.findAll()).toHaveLength(0);
  });
});
