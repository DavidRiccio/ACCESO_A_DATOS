# Tarea practica en TypeScript

Esta tarea es una pequeña práctica guiada en la que practicaremos Typescript.



## 1. Modelo de datos: interfaz Tarea

Codigo: 

```typescript
    export interface Tarea {
    /**
     * Id de la tarea
     */
    id: number;
    /**
     * Tituo de la tarea
     */
    titulo: string;
    /**
     * Descripcion de la tarea
     */
    descripcion?: string;
    /**
     * Estado de la tarea
     */
    completada: boolean;
}

export type IdTarea = number;
export type FiltroTarea = "todas" | "pendientes" | "completadas";
```


  * **Tipos primitivos (`number`, `string`, `boolean`)**:

      * Usados en `id`, `titulo` y `completada`.
      * Garantizan que los datos base sean del tipo correcto (evitando, por ejemplo, que un ID sea un texto o que `completada` sea un número).

  * **Propiedades opcionales (`?`)**:

      * Usado en `descripcion?: string`.
      * Indica a TypeScript que esta propiedad puede tener un valor `string` o ser `undefined` (omitida), lo cual es útil para datos que no siempre son necesarios.

  * **Tipos unión (`|`) y Literales**:

      * Usado en `FiltroTarea`.
      * Restringe la variable a un conjunto específico de valores exactos (`"todas"`, `"pendientes"`, `"completadas"`). Si intentas asignar otro texto, TypeScript lanzará un error, protegiendo la lógica de filtrado.

## 2. Funciones puras para gestionar tareas

Codigo: 

```typescript
import { Tarea, IdTarea, FiltroTarea } from "./models";

/**
 * Crea una nueva tarea a partir de un titulo.
 *
 * @param id Identificador unico de la tarea.
 * @param titulo Titulo visible de la tarea.
 * @param descripcion (Opcional) Detalle adicional.
 * @returns Tarea inicializada como no completada.
 */
export function crearTarea(
  id: IdTarea,
  titulo: string,
  descripcion?: string
): Tarea {
  return {
    id,
    titulo,
    descripcion,
    completada: false,
  };
}

/**
 * Marca una tarea como completada.
 *
 * @param tareas Lista original de tareas.
 * @param id Identificador de la tarea a completar.
 * @returns Nueva lista de tareas con la tarea marcada.
 */
export function completarTarea(tareas: Tarea[], id: IdTarea): Tarea[] {
  return tareas.map((t) =>
    t.id === id ? { ...t, completada: true } : t
  );
}

/**
 * Filtra las tareas segun el filtro indicado.
 *
 * @param tareas Lista original de tareas.
 * @param filtro "todas", "pendientes" o "completadas".
 * @returns Lista filtrada de tareas.
 */
export function filtrarTareas(
  tareas: Tarea[],
  filtro: FiltroTarea
): Tarea[] {
  if (filtro === "pendientes") {
    return tareas.filter((t) => !t.completada);
  } else if (filtro === "completadas") {
    return tareas.filter((t) => t.completada);
  }
  return tareas;
}
 ```




  * **Tipado de parámetros y retorno:** Se definen interfaces (`Tarea`) y alias (`IdTarea`) para garantizar la integridad de los datos. Las funciones especifican explícitamente el tipo de entrada y salida (ej: `(tareas: Tarea[]): Tarea[]`), asegurando que el flujo de datos sea predecible.
  * **Comentarios de documentación:** Se emplea el estándar JSDoc (`/** ... */`) sobre cada función. Esto describe el propósito, los parámetros (`@param`) y el valor de retorno (`@returns`), facilitando la lectura y el intellisense en los editores.
  * **Uso de funciones de array:**
      * **`map`:** Se utiliza en `alternarEstadoTarea` para transformar un elemento específico sin mutar el array original.
      * **`filter`:** Se aplica en `obtenerPendientes` para generar un subconjunto de datos basado en una condición lógica.


## 3. Módulos: organizar el código con import / export
Los Módulos permiten dividir el código en archivos separados para que sea mantenible. Para que un archivo pueda usar código que está en otro, utilizamos export e import.

`export`: Hace que una variable, función, clase o interfaz sea pública y accesible desde fuera de su archivo.

`import`: Trae esas piezas exportadas a tu archivo actual para poder usarlas.


## 4. Compilar el proyecto con tsc y ejecutar con node


Aquí tienes la guía paso a paso para compilar y ejecutar tu proyecto, relacionándolo con los conceptos teóricos de la documentación.


#### 1\. `tsc` como Compilador Puro (Build Time)

A diferencia de `ts-node` (que usábamos antes para desarrollo rápido y compilaba "al vuelo" en memoria), **`tsc`** realiza el proceso formal de traducción.

  * **Acción:** Transforma tu código TypeScript (con tipos, interfaces, etc.) a JavaScript estándar (sin tipos).
  * **Resultado:** Crea archivos físicos en tu disco duro (`.js`).

#### 2\. `node` como Runtime (Run Time)

Node.js no sabe ejecutar TypeScript nativamente. Por eso, en este paso, usamos `node` para ejecutar el archivo `dist/index.js`.

  * **Diferencia clave:** `ts-node` es una herramienta de desarrollo (dev tool). La combinación `tsc` + `node` es el flujo real de producción.

#### 3\. La importancia de la carpeta `dist/`

En la documentación se menciona la separación de entornos. Tener una carpeta `dist` (distribution) es una buena práctica profesional porque:

  * **Limpieza:** Separa el código que *escribes* (`src`) del código que *ejecuta la máquina* (`dist`).
  * **Despliegue:** Cuando subas tu aplicación a un servidor real, generalmente solo subes la carpeta `dist` y el `package.json`, haciendo que la aplicación sea más ligera y rápida de iniciar, ya que no necesita compilarse cada vez que arranca.

## 5. Sencilla “CLI” por parámetros

Codigo: 
```typescript
import { crearTarea, filtrarTareas } from "./tareas";
import { Tarea, FiltroTarea } from "./models";

let tareas: Tarea[] = [
  crearTarea(1, "Estudiar TS",),
  crearTarea(2, "Hacer ejercicio"),
  crearTarea(3, "Leer un libro"),
];
tareas[1].completada = true;
const [, , filtroArg] = process.argv;
const filtro: FiltroTarea = (filtroArg as FiltroTarea) ?? "todas";

console.log("Filtro:", filtro);
console.log(filtrarTareas(tareas, filtro));
```
`node dist/cli.js `: Al ejecutar esto por consola nos da todas las tareas

```bash

Filtro: todas
[
  {
    id: 1,
    titulo: 'Estudiar TS',
    descripcion: undefined,
    completada: false
  },
  {
    id: 2,
    titulo: 'Hacer ejercicio',
    descripcion: undefined,
    completada: false
  },
  {
    id: 3,
    titulo: 'Leer un libro',
    descripcion: undefined,
    completada: false
  }
]
```



`node dist/cli.js pendientes`: Al ejecutar esto nos da solo las pendientes aplicando el filtro que hemos hecho.
```bash
david@david-HP:~/AED/TYPESCRIPT/mini-gestor-tareas$ node dist/cli.js pendientes
Filtro: pendientes
[
  {
    id: 1,
    titulo: 'Estudiar TS',
    descripcion: undefined,
    completada: false
  },
  {
    id: 3,
    titulo: 'Leer un libro',
    descripcion: undefined,
    completada: false
  }
]
```

`node dist/cli.js completadas`

```bash
david@david-HP:~/AED/TYPESCRIPT/mini-gestor-tareas$ node dist/cli.js completadas
Filtro: completadas
[
  {
    id: 2,
    titulo: 'Hacer ejercicio',
    descripcion: undefined,
    completada: true
  }
]
```
## 6. Tests de las funciones de tareas

Codigo: 
```typescript
import { crearTarea, completarTarea, filtrarTareas } from "../src/tareas";
import { Tarea } from "../src/models";

describe("Funciones de tareas", () => {
  
  test("crearTarea crea una tarea no completada", () => {
    const tarea = crearTarea(1, "Probar función");
    expect(tarea.completada).toBe(false);
    expect(tarea.titulo).toBe("Probar función");
    expect(tarea.id).toBe(1);
  });

  test("completarTarea marca la tarea como completada", () => {
    const tareas = [
      crearTarea(1, "A"),
      crearTarea(2, "B"),
    ];
    const resultado = completarTarea(tareas, 2);
    const tarea2 = resultado.find((t) => t.id === 2)!;

    expect(tarea2.completada).toBe(true);
    // Verificamos que la otra tarea no se vio afectada
    expect(resultado.find(t => t.id === 1)?.completada).toBe(false);
  });

  test("filtrarTareas filtra por completadas", () => {
    const tareas: Tarea[] = [
      { id: 1, titulo: "A", completada: false },
      { id: 2, titulo: "B", completada: true },
    ];

    const completadas = filtrarTareas(tareas, "completadas");
    expect(completadas).toHaveLength(1);
    expect(completadas[0].id).toBe(2);
  });

  test("filtrarTareas filtra por pendientes", () => {
    const tareas: Tarea[] = [
      { id: 1, titulo: "A", completada: false },
      { id: 2, titulo: "B", completada: true },
      { id: 3, titulo: "C", completada: false },
    ];

    const pendientes = filtrarTareas(tareas, "pendientes");
    expect(pendientes).toHaveLength(2);
    expect(pendientes.map(t => t.id)).toEqual([1, 3]);
  });

  test("filtrarTareas devuelve la lista original si el filtro es 'todas'", () => {
    const tareas: Tarea[] = [
      { id: 1, titulo: "A", completada: false },
      { id: 2, titulo: "B", completada: true },
    ];

    const todas = filtrarTareas(tareas, "todas");
    expect(todas).toHaveLength(2);
    expect(todas).toEqual(tareas);
  });
});
``` 

`Test`:
```bash
david@david-HP:~/AED/TYPESCRIPT/mini-gestor-tareas$ npx jest
 PASS  dist/test/tareas.test.js
 PASS  src/test/tareas.test.js
 PASS  src/test/tareas.test.ts

Test Suites: 3 passed, 3 total
Tests:       13 passed, 13 total
Snapshots:   0 total
Time:        4.669 s
Ran all test suites.
```


## 7. Documentación y buenas prácticas

### Conceptos Clave de Documentación en TypeScript

#### JSDoc (`/** ... */`)

Es el estándar para documentar código en JavaScript y TypeScript. A diferencia de los comentarios normales (`//`), JSDoc permite que editores como VS Code muestren **tooltips** (ventanas emergentes) con información útil cuando pasas el ratón sobre una función.

  * **`@param`**: Describe qué parámetros recibe la función.
  * **`@returns`**: Describe qué devuelve la función.
  * **Descripción**: Texto libre al inicio para explicar el "qué" y el "por qué".

#### Convenciones de Nombres (Naming Conventions)

Para mantener el código limpio y predecible, seguimos estos patrones:

  * **camelCase**: Para **variables** (`misTareas`), **funciones** (`crearTarea`) y **parámetros** (`idTarea`). La primera letra minúscula, las siguientes palabras mayúsculas.
  * **PascalCase**: Para **Interfaces** (`Tarea`), **Tipos** (`FiltroTarea`) y **Clases**. Todas las palabras inician con mayúscula.

