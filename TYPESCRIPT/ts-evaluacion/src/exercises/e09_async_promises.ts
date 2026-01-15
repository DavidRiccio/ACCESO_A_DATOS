/**
 * E09 – Async/Promises
 */

export async function delay(ms: number): Promise<void> {
  // resuelve tras ms; Error si ms<0 o no finito
  if (ms < 0 || !isFinite(ms)) {
    throw new Error("Invalid ms");
  }

  return new Promise((resolve) => setTimeout(resolve, ms));
}

export async function retry<T>(fn: () => Promise<T>, attempts: number): Promise<T> {
  // reintenta attempts veces; si resuelve devuelve; si falla siempre lanza último error
  for (let i = 0; i < attempts; i++) {
    try {
      return await fn();
    } catch (error) {
      if (i === attempts - 1) {
        throw error;
      }
    }
  }
  throw new Error("Invalid attempts");
}

export async function parallelSum(values: Array<Promise<number>>): Promise<number> {
  // Promise.all y suma; Error si alguno no es finito
  try {
    const results = await Promise.all(values);
    return results.reduce((acc, val) => acc + val, 0);
  } catch (error) {
    throw new Error("Invalid values");
  }
}
