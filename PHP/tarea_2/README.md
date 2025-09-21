## Número capicúa (palíndromo numérico)

Implementa una función **esCapicua(int $n): bool** que determine si un número entero positivo es capicúa.

- Un número es capicúa si se lee igual de izquierda a derecha que de derecha a izquierda.

> Ejemplo: `12321` → `true`
> phpesCapicua(int $n): bool
> CODIGO:

```php
<?php

function esCapicua(int $n){
    $number = (string) $n;
    $result = '';
    $capicua = strrev($number);
    if ($capicua == $number){
        $result = 'Es capicua';
    }else{
       $result = 'No es capicua';
    }
    return $result . "\n";
}

echo esCapicua('111');
echo esCapicua('214');
```

SALIDA:

```bash
root@f78e7eba6dfb:/var/www/html# php public/index.php
Es capicua
No es capicua
```

## Suma de dígitos

Implementa una función **sumaDigitos(int $n): int** que calcule la suma de los dígitos de un número entero positivo.

- Descompón el número en dígitos y súmalos.

> Ejemplo: `2025` → `9` (2+0+2+5)

```php
<?php
function sumaDigitos(int $n): int {
    $digits = str_split((string) $n);
    $sum = 0;

    foreach ($digits as $d) {
        $sum += (int)$d;
    }

    return $sum;
}

echo sumaDigitos(10) . "\n";
echo sumaDigitos(1234) . "\n";
```

SALIDA:

```bash
root@f78e7eba6dfb:/var/www/html# php public/index.php
1
10
```

## Número secreto (múltiplos de 3 o 5)

Implementa una función **multiplosTresOCinco(int $n): array** que devuelva todos los múltiplos de 3 o 5 menores que `N`.

- Además, calcula la suma de dichos múltiplos.

> Ejemplo con entrada `10`:

```code
3, 5, 6, 9
Suma = 23
```

```php
<?php
function multiplosTresOCinco(int $n): array{
    $num_list=[];
    for ($i = 1; $i <= $n; $i++){
        if ($i % 3 == 0 || $i % 5 == 0){
            $num_list[]= $i;
        }
    }
    return $num_list;

}
print_r( multiplosTresOCinco(30));
```

SALIDA:

```bash
root@f78e7eba6dfb:/var/www/html# php public/index.php
Array
(
    [0] => 3
    [1] => 5
    [2] => 6
    [3] => 9
    [4] => 10
    [5] => 12
    [6] => 15
    [7] => 18
    [8] => 20
    [9] => 21
    [10] => 24
    [11] => 25
    [12] => 27
    [13] => 30
)

```

## Secuencia de Collatz

Implementa una función **secuenciaCollatz(int $n): array** que genere la secuencia de Collatz a partir de un entero positivo.

- Si el número es par → dividir entre 2.
- Si es impar → multiplicar por 3 y sumar 1.
- Repetir hasta llegar a 1.

> Ejemplo con entrada `6`:

```code
6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1
```

```php
 <?php
function secuenciaCollatz(int $n): array {
    $numeros = [$n];
    while ($n !== 1) {
        if ($n % 2 == 0) {
            $n = $n / 2;
        } else {
            $n = $n * 3 + 1;
        }
        $numeros[] = $n;
    }
    return $numeros;
}


print_r(secuenciaCollatz(6));

```

SALIDA:

```bash
Array
(
    [0] => 6
    [1] => 3
    [2] => 10
    [3] => 5
    [4] => 16
    [5] => 8
    [6] => 4
    [7] => 2
    [8] => 1
)
```

---
