# PRACTICANDO TYPESCRIPT 02

## La API REST de Tareas

**Contexto Rápido:** Nuestra aplicación de TypeScript ahora se conecta a un *backend* de tareas. Esto utiliza el servicio que hemos hecho en **PGV**,.


### ¿Cómo hablarle a la API?

Todas las llamadas se dirigen a la URL base `http://localhost:8080/api/tareas`.


#### Para Obtener Tareas (GET)

* **Endpoint:** `/tareas`
    * **¿Qué hace?** Pide la lista completa de todas las tareas.
    * **¿Qué devuelve?** Un array con todas las tareas (`Tarea[]`).
* **Endpoint:** `/tareas/:id` (ej. `/tareas/1`)
    * **¿Qué hace?** Pide una tarea específica por su ID.
    * **¿Qué devuelve?** La tarea si existe, si no, devuelve un error 404.


#### Para Crear Tareas (POST)

* **Endpoint:** `/tareas`
    * **¿Qué hace?** Crea una tarea nueva.
    * **¿Qué le mandas?** Un JSON con el título, descripción (opcional) y si está completada, **sin incluir el ID**.
    * **¿Qué devuelve?** La tarea creada, que ahora sí incluye el ID asignado por el servidor (`201 Created`).


#### Para Actualizar Tareas (PUT)

* **Endpoint:** `/tareas/:id` (ej. `/tareas/1`)
    * **¿Qué hace?** Reemplaza por completo la tarea con ese ID.
    * **¿Qué le mandas?** Un JSON con **todos** los datos de la tarea, obligatoriamente incluyendo su ID.
    * **¿Qué devuelve?** La tarea actualizada (`Tarea`).


#### Para Borrar Tareas (DELETE)

* **Endpoint:** `/tareas/:id` (ej. `/tareas/1`)
    * **¿Qué hace?** Elimina la tarea con ese ID.
    * **¿Qué devuelve?** Confirma que se ha borrado (`200 OK` o `204 No Content`).


## Módulo de Servicio REST: `src/apiTareas.ts`

Este archivo centraliza todas las llamadas a la API (`fetch`) para el recurso `/tareas`, asegurando que la lógica HTTP esté separada del resto de la aplicación.


### Relación con el Manual (TypeScript y Peticiones)

El módulo se construye para manejar la comunicación asíncrona y tipada:

* **Asincronía:** Se usa `async/await` en todas las funciones para manejar las peticiones de red (`fetch`), haciendo que el código sea más limpio y secuencial, y todas devuelven una `Promise<T>`.
* **Tipado Genérico:** Se tipan las entradas y salidas para garantizar la seguridad de los datos.
    * **Salidas:** Se definen los tipos de la respuesta (ej. `Promise<Tarea[]>` o `Promise<Tarea>`).
    * **Entradas:** Para la creación (`POST`), se utiliza el tipo utilitario `Omit<Tarea, "id">` para asegurar que el `id` no se envíe, ya que lo crea el servidor.
* **Manejo de Errores:** Después de cada llamada a `fetch`, se verifica el estado de la respuesta con `if (!respuesta.ok)`. Si la respuesta no es OK (código 4xx o 5xx), se lanza un `Error` con el código de estado para que pueda ser capturado por un `try/catch`.


## 3. Integrar la API REST con la lógica de tareas




### Lo que ocurre en cada paso:

El programa sigue tres pasos principales, usando las funciones del módulo REST:

1.  **Carga Inicial:**
    * Llama a `obtenerTareas()`.
    * Resultado: Se realiza un `GET /tareas` a la API y se imprime la lista inicial de tareas en consola.
2.  **Creación de Tarea:**
    * Llama a `crearTareaRemota()` con un objeto de tarea nueva (sin `id`).
    * Resultado: Se realiza un `POST /tareas` a la API. El servidor devuelve la nueva tarea con su ID asignado (`201 Created`) y se imprime en consola.
3.  **Verificación:**
    * Llama de nuevo a `obtenerTareas()` para refrescar la lista.
    * Resultado: Se realiza otro `GET /tareas`. Se imprime la lista completa, confirmando que la tarea creada en el paso 2 fue persistida en el backend.

`Salida: `
```bash
david@david-HP:~/AED/TYPESCRIPT/mini-gestor-tareas$ npx ts-node src/index-rest.ts
Cargando tareas desde la API...
Tareas iniciales: [
  {
    id: 2,
    titulo: 'Hacer la práctica 1',
    descripcion: 'Proyecto tareas en memoria',
    completada: true
  },
  {
    id: 1,
    titulo: 'Estudiar TypeScript',
    descripcion: 'Repasar tipos y funciones',
    completada: false
  }
]
Creando una nueva tarea remota...
Tarea creada: {
  id: -5476769078360259000,
  titulo: 'Tarea creada desde index-rest.ts',
  descripcion: 'Probando POST contra json-server',
  completada: false
}
Tareas tras la creación: [
  {
    id: 2,
    titulo: 'Hacer la práctica 1',
    descripcion: 'Proyecto tareas en memoria',
    completada: true
  },
  {
    id: 1,
    titulo: 'Estudiar TypeScript',
    descripcion: 'Repasar tipos y funciones',
    completada: false
  },
  {
    id: -5476769078360259000,
    titulo: 'Tarea creada desde index-rest.ts',
    descripcion: 'Probando POST contra json-server',
    completada: false
  }
]
```


## 4. Tests del servicio REST (apiTareas.ts) mockeando fetch

**Objetivo:** Probar que las funciones (como `obtenerTareas` o `crearTareaRemota`) llaman a la red de la manera correcta y manejan las respuestas y errores correctamente.


### ¿Cómo Mockeamos `fetch`?

En lugar de dejar que `fetch` haga una llamada de red real, le decimos a Jest: **"Cuando se llame a la función global `fetch`, ignora la red y devuelve esta respuesta falsa que yo te doy"**.


#### Pasos Clave:

1.  **Reemplazar la función:** Antes de cada test, usamos `global.fetch = jest.fn()` para sustituir la función `fetch` original por una versión falsa que podemos controlar.

2.  **Definir la Respuesta:** Usamos `mockResolvedValue` para simular lo que devolvería la red. Esta respuesta falsa debe imitar la estructura de la respuesta real de `fetch`.

      * **Ejemplo de Mock Exitoso (200 OK):**
        ```typescript
        global.fetch.mockResolvedValue({
          ok: true, // Esto simula un código HTTP 2xx
          status: 200,
          json: async () => [/* aquí los datos falsos */], // Los datos que devuelve la API
        });
        ```

3.  **Verificar la Llamada:** Una vez que la función del servicio (`obtenerTareas`, por ejemplo) se ha ejecutado usando la respuesta falsa, comprobamos:

      * Que `fetch` fue llamada **solo una vez**.
      * Que fue llamada con la **URL y el método HTTP correctos** (ej. `http://localhost:3000/tareas` y `method: 'POST'`).

4.  **Probar Errores:** También simulamos respuestas fallidas haciendo que el mock devuelva `ok: false`. Esto nos permite verificar que nuestras funciones lanzan el error esperado (`rejects.toThrow`).
