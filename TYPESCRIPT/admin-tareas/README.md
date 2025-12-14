
# Gestor de Tareas con Doble Persistencia

Aplicación TypeScript que gestiona tareas utilizando dos fuentes de datos: una base de datos local SQLite3 y una API REST remota con Spring Boot y H2.

## Cómo Ejecutar el Proyecto

### 1. Instalar dependencias

```
npm install
```

### 2. Iniciar el backend Spring Boot

```
cd backend
./mvnw spring-boot:run
```

El servidor se iniciará en `http://localhost:8080`

### 3. Ejecutar la aplicación

```
npm start
```

### 4. Ejecutar los tests

```
npm test
```

## Estructura de Carpetas

```
proyecto/
├── src/
│   ├── model/
│   │   └── Tarea.ts
│   ├── repository/
│   │   ├── TareaRepositoryLocal.ts
│   │   └── TareaRepositoryRemoto.ts
│   ├── service/
│   │   └── TareasService.ts
│   ├── db/
│   │   └── db.ts
│   └── index.ts
├── tests/
│   ├── TareaRepositoryLocal.test.ts
│   ├── TareaRepositoryRemoto.test.ts
│   └── TareasService.test.ts
├── tareas.db
├── package.json
└── tsconfig.json
```

### Descripción de Componentes

`src/model/Tarea.ts`  
Define la interfaz `Tarea` con las propiedades: id, titulo, descripcion y completada.

`src/repository/TareaRepositoryLocal.ts`  
Repositorio que gestiona operaciones CRUD con SQLite3. Incluye métodos para crear la tabla, listar, buscar por id, crear, actualizar y borrar tareas.

`src/repository/TareaRepositoryRemoto.ts`  
Cliente HTTP que se comunica con la API REST del backend. Usa `fetch` para realizar peticiones GET, POST, PUT y DELETE.

`src/service/TareasService.ts`  
Capa de servicio que coordina las operaciones. Decide si usar el repositorio local o remoto según el parámetro recibido. Contiene la lógica de sincronización.

`src/db/db.ts`  
Configura y devuelve la conexión a la base de datos SQLite.

`src/index.ts`  
Punto de entrada que demuestra todas las operaciones: listar, crear, actualizar y sincronizar tareas.

## Endpoints Remotos

### Configuración de URL Base

La URL base se configura en `index.ts`:

```
const API_URL = "http://localhost:8080/api/tareas";
```

### Endpoints Disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/tareas` | Obtiene todas las tareas |
| GET | `/api/tareas/{id}` | Obtiene una tarea por ID |
| POST | `/api/tareas` | Crea una nueva tarea |
| PUT | `/api/tareas/{id}` | Actualiza una tarea existente |
| DELETE | `/api/tareas/{id}` | Elimina una tarea |

### Formato de Datos

```
{
  "id": "1",
  "titulo": "Hacer la compra",
  "descripcion": "Comprar leche y pan",
  "completada": false
}
```

## Sincronización Remoto → Local

### Funcionamiento

El método `sincronizarRemotoALocal()` realiza los siguientes pasos:

1. **Obtiene todas las tareas del servidor remoto**
```
const remotas = await this.remoteClient.findAll();
```

2. **Borra todas las tareas de la base de datos local**
```
this.localRepo.deleteAll();
```

3. **Inserta cada tarea remota en la base de datos local**
```
for (const tarea of remotas) {
  this.localRepo.create({
    titulo: tarea.titulo,
    descripcion: tarea.descripcion,
    completada: tarea.completada
  });
}
```

4. **Devuelve el número de tareas importadas**

### Flujo de Sincronización

```
Servidor Spring Boot (H2)
          ↓
    1. Obtener tareas
          ↓
    TareasService
          ↓
    2. Borrar local
    3. Insertar remotas
          ↓
Base de Datos Local (SQLite3)
```

## Tests Automáticos

Así quedaría actualizado, acorde a los tests simples que implementamos:

`Tests Implementados ` 

tests/TareaRepositoryLocal.test.ts  
- Creación y listado de tareas  
- Actualización de una tarea  
- Eliminación de todas las tareas  

tests/TareaRepositoryRemoto.test.ts  
- Obtención de todas las tareas remotas  
- Creación de una tarea remota  

tests/TareasService.test.ts  
- Listado de tareas locales  
- Creación de tarea en remoto desde el servicio  
- Sincronización remoto → local con conteo de tareas importadas
### Ejecutar Tests

```
npm test
```

### Cobertura

- ✅ Operaciones CRUD en ambos repositorios
- ✅ Conversión de tipos de datos
- ✅ Manejo de errores
- ✅ Sincronización remoto → local
- ✅ Delegación en el servicio

## Verificación Manual

### Verificar Backend

```
curl http://localhost:8080/api/tareas
```

O abre `http://localhost:8080/api/tareas` en el navegador.

### Verificar Base de Datos Local

```
sqlite3 tareas.db "SELECT * FROM tareas;"
```

O usa una extensión de VSCode como **SQLite Viewer**.

### Verificar Sincronización

1. Añade tareas en el backend (Postman o consola H2)
2. Ejecuta `npm start`
3. Verifica que las tareas aparecen en `tareas.db`
