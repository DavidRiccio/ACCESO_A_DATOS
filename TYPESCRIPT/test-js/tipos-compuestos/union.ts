// ejemplos/02-tipos-compuestos.ts
type Id = number | string;

let id1: Id = 123;
let id2: Id = "abc-123";

let v1 : any ="Hola"
let v2 : string = "Hola"
type ConFecha = { creadoEn: Date };
type ConId = { id: number };

type EntidadConIdYFecha = ConFecha & ConId;

const registro: EntidadConIdYFecha = {
  id: 1,
  creadoEn: new Date(),
};
console.log(registro);

if (v1 === v2){
    console.log("Son iguales");
    
}
console.log(typeof(v1));
