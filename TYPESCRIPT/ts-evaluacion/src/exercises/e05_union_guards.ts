import { JwtPayload, Role } from "../models";

/**
 * E05 – Union + type guards (unknown) + JWT
 */

export function normalizeId(id: string | number): string {
  // number => String; string => trim; vacío => Error
  if (typeof id === "number") {
    return String(id);
  }

  if (id.trim() === "") {
    throw new Error("Invalid id");
  }

  return id.trim();
}

export function isJwtPayload(value: unknown): value is JwtPayload {
  // objeto no null con sub string no vacía, role USER/ADMIN, exp number finito >=0
  if (typeof value !== "object" || value === null) {
    return false;
  }
  const p = value as JwtPayload;

  if (typeof p.sub !== "string" || p.sub.trim() === "") {
    return false;
  }

  if (p.role !== Role.USER && p.role !== Role.ADMIN) {
    return false;
  }

  if (typeof p.exp !== "number" || !Number.isFinite(p.exp) || p.exp < 0) {
    return false;
  }

  return true;
}

export function requireRole(payload: JwtPayload, role: Role): void {
  // lanza Error si payload.role != role
  if (payload.role !== role) {
    throw new Error("Invalid role");
  }
}
