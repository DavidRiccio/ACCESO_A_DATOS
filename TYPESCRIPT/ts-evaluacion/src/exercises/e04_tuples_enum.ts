import { Role } from "../models";

/**
 * E04 – Tuples y enum
 */

export type JwtParts = [header: string, payload: string, signature: string];

export function splitJwt(token: string): JwtParts {
  const parts = token.split(".");
  if (parts.length !== 3) {
    throw new Error("JWT must have exactly 3 parts");
  }
  return [parts[0], parts[1], parts[2]];
}

export function roleFromString(value: string): Role {
  const normalized = value.toUpperCase();
  if (normalized === Role.ADMIN) {
    return Role.ADMIN;
  }
  if (normalized === Role.USER) {
    return Role.USER;
  }
  throw new Error(`Invalid role: ${value}`);
}

export function formatUserTag(username: string, role: Role): string {
  const cleanName = username.trim();
  if (!cleanName) {
    throw new Error("Username cannot be empty");
  }
  return `${cleanName}#${role}`;
}
