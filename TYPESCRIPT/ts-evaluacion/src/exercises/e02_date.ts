/**
 * E02 – Date: parseo YYYY-MM-DD, validación y diferencias en días.
 */

export function isValidISODate(iso: string): boolean {
  // regex yyyy-mm-dd + Date válida + conserva componentes (evita 2026-02-30)
  const regex = /^\d{4}-\d{2}-\d{2}$/;
  if (!regex.test(iso)) {
    return false;
  }

  const date = new Date(iso);
  if (isNaN(date.getTime())) {
    return false;
  }
  return date.toISOString().slice(0, 10) === iso;
}

export function nightsBetween(entrada: string, salida: string): number {
  // intervalo [entrada, salida) => noches. Error si salida<=entrada o fechas inválidas
  const date1 = new Date(entrada);
  const date2 = new Date(salida);

  if (isNaN(date1.getTime()) || isNaN(date2.getTime())) {
    throw new Error("Invalid dates");
  }

  if (date1 >= date2) {
    throw new Error("Invalid dates");
  }

  return Math.floor((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
}

export function toIsoDateOnly(date: Date): string {
  // "YYYY-MM-DD" desde Date (UTC). Error si date inválida.
  if (isNaN(date.getTime())) {
    throw new Error("Invalid date");
  }

  return date.toISOString().split("T")[0];
}
