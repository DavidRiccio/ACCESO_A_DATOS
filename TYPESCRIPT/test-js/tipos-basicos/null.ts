// ejemplos/01-tipos-basicos.ts
let valorNulo: null = null;
let valorIndefinido: undefined = undefined;

let datoFlexible: any = "hola";
datoFlexible = 123; // permitido, pero peligroso

let datoDesconocido: unknown = "podría ser cualquier cosa";

function lanzarError(mensaje: string): never {
  throw new Error(mensaje);
}