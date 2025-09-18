Variables y Condicionales

Pide dos números y muestra cuál es mayor o si son iguales.

CODIGO:
```php
<?php

$num1 = (int) readline("Introduce el primer número: ");
$num2 = (int) readline("Introduce el segundo número: ");

if ($num1 > $num2){
    echo "Numero 1 es mayor\n";
}else if ($num2 > $num1){
    echo "Numero 2 es mayor\n";
}else {
    echo "Son iguales\n";
}

?>
```

SALIDA:
```code
root@f78e7eba6dfb:/var/www/html/public# php index.php 
Introduce el primer número: 2
Introduce el segundo número: 4
Numero 2 es mayor
```

Pide la edad de una persona y muestra:

"Eres menor de edad" si es < 18.

"Eres mayor de edad" si es ≥ 18.

CODIGO:
```php

<?php

$age = (int) readline("Introduce tu edad\n");
if ($age >= 18){
    echo "Eres mayor de edad\n";
}else{
    echo "Eres menor de edad\n";
}
?>
```
SALIDA:
```code
root@f78e7eba6dfb:/var/www/html/public# php index.php 
Introduce tu edad
17
Es menor de edad

Introduce tu edad
18
Es mayor de edad
```

Comprueba si un número almacenado en una variable es positivo, negativo o cero.

CODIGO:
```php
<?php

$number = -10;
$result = "Es postivo";

if ($number < 0){
    $result = "Es Negativo";
}
if ($number == 0){
    $result = "Es Cero";
}
echo $result

?>
```

SALIDA:
```code
number -10 = Es Negativo
number 0 = Es Cero
number 2 = Es Positivo
```

Pide la nota de un alumno y muestra:

"Suspenso" (< 5), "Aprobado" (5–6), "Notable" (7–8), "Sobresaliente" (9–10).

CODIGO:
```php
<?php
$grade = (float) readline("Introduce la nota: ");

if ($grade < 5) {
    $result = "Suspenso";
} elseif ($grade <= 6) {  
    $result = "Aprobado";
} elseif ($grade <= 8) {   
    $result = "Notable";
} elseif ($grade <= 10) { 
    $result = "Sobresaliente";
} else {
    $result = "Nota inválida";
}
echo "$result\n";
?>

```

SALIDA:
```code

root@f78e7eba6dfb:/var/www/html/public# php index.php 
Introduce la nota: 3
Suspenso


root@f78e7eba6dfb:/var/www/html/public# php index.php 
Introduce la nota: 5
Aprobado

root@f78e7eba6dfb:/var/www/html/public# php index.php 
Introduce la nota: 8
Notable

root@f78e7eba6dfb:/var/www/html/public# php index.php 
Introduce la nota: 10
Sobresaliente
```

Bucles (for, while, foreach)

Muestra los números del 1 al 100 en pantalla.

CODIGO:
```php
<?php
for ($i = 0; $i <= 100; $i++) {
    echo "$i\n";
}
?>
```

SALIDA:
```code
root@f78e7eba6dfb:/var/www/html/public# php index.php 
0
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
82
83
84
85
86
87
88
89
90
91
92
93
94
95
96
97
98
99
100
```

Calcula la suma de los números del 1 al 50 usando un bucle.

CODIGO:
```php
<?php
$sum = 0;
for ($i = 0; $i <= 50; $i++) {
    $sum += $i;
}
echo "La suma de numeros de 1 al 50 es $sum\n";
?>
```

SALIDA:
```
root@f78e7eba6dfb:/var/www/html/public# php index.php 
La suma de numeros de 1 al 50 es 1275
```

Pide un número y genera su tabla de multiplicar del 1 al 10.

CODIGO:
```php
<?php
$num1 = (int) readline("Introduce el número: ");

for ($i = 1; $i <= 10; $i++) {
    $mult = $i * $num1;
    echo "$num1 x $i = $mult\n";
}

```

SALIDA:
```
36912151821242730root@f78e7eba6dfb:/var/www/html/public# php index.php 
Introduce el número: 3
3 x 1 = 3
3 x 2 = 6
3 x 3 = 9
3 x 4 = 12
3 x 5 = 15
3 x 6 = 18
3 x 7 = 21
3 x 8 = 24
3 x 9 = 27
3 x 10 = 30
```

Muestra todos los números pares entre 1 y 50.

CODIGO:
```php
for ($i = 1; $i <= 50; $i++) {
    if ($i % 2 == 0){
        echo "$i\n";
    };
}

```

SALIDA:
```
2
4
6
8
10
12
14
16
18
20
22
24
26
28
30
32
34
36
38
40
42
44
46
48
50
```

Haz un bucle que cuente de 10 a 1 y luego muestre "¡Fin!".

CODIGO:

SALIDA:

Calcula el factorial de un número introducido (ejemplo: 5! = 120).

CODIGO:
```php
```

SALIDA:

Combinando Condicionales y Bucles

Escribe un algoritmo que muestre los números primos entre 1 y 50.

CODIGO:

SALIDA:

Genera los primeros 20 términos de la secuencia de Fibonacci.

CODIGO:

SALIDA:

Pide un número n y muestra sus múltiplos hasta 100.

CODIGO:

SALIDA:

Calcula la suma de los números pares e impares entre 1 y 100 por separado.

CODIGO:

SALIDA:

Genera un número aleatorio entre 1 y 20. Pide al usuario que lo adivine y usa un bucle con condicionales para dar pistas: "Mayor" o "Menor".

CODIGO:

SALIDA:

Construcción de Algorítmicos

Comprueba si un número es perfecto (la suma de sus divisores propios es igual al número).

CODIGO:

SALIDA:

Escribe un algoritmo que invierta los dígitos de un número (ejemplo: 123 → 321).

CODIGO:

SALIDA:

Comprueba si una palabra almacenada en una variable es palíndroma.

CODIGO:

SALIDA:

Escribe un algoritmo que calcule el máximo común divisor (MCD) de dos números.

CODIGO:

SALIDA:

Muestra en pantalla un triángulo de altura n usando *.

Ejemplo con n = 5:

*
**
***
****
*****


CODIGO:

SALIDA: