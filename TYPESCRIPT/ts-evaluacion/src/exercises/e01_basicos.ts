/**
 * E01 – Tipos básicos: string/number/boolean/null/undefined
 */

export function normalizeBearer(authHeader: string): string {
  // trim + "Bearer <token>" (case-insensitive), colapsa espacios a 1, Error si inválido
  const clean = authHeader.trim().replace(/\s+/g, " ");

  if (!clean.toLowerCase().startsWith("bearer ")) {
    throw new Error("Invalid auth header");
  }

  // Ensure "Bearer " prefix has correct casing
  return "Bearer " + clean.slice(7);
}


export function clamp01(value: number): number {
  // Devuelve value limitado a [0,1]. Error si NaN o no finito.
  if (isNaN(value) || !isFinite(value)) {
    throw new Error("Invalid value");
  }

  return Math.min(Math.max(value, 0), 1);
}

export function safeBool(value: boolean | null | undefined): boolean {
  // null/undefined => false; boolean => mismo valor
  if (value === null || value === undefined) {
    return false;
  }

  return value;
}
