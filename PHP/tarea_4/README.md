## ✅ Preparación

```bash
php -v
```

Ejecuta:

```bash
php ejercicioX.php
```

## Ejercicio1: Operaciones con números naturales en PHP

### Enunciado

Dado un fichero `ops.csv` con columnas:

```code
z1,z2,op
```

donde:

- `op ∈ {suma, resta, producto, division}`

Se debe calcular `z1 (op) z2` y generar como salida un fichero `resultado.csv`.

---

### Codigo

```php
<?php
$ruta = "ficheros/ops.csv";
$destino = "ficheros/resultados.csv";

$file = fopen($ruta, "r");

$cabecera = fgetcsv($file);

$out = fopen($destino, "w");

fputcsv($out, ["numero1", "numero2", "operacion", "resultado"]);

while (($csv = fgetcsv($file)) !== false) {
    $resultado = Operacion($csv);
    fputcsv($out, [$csv[0], $csv[1], $csv[2], $resultado]);
}

fclose($file);
fclose($out);


function Operacion(array $csv) {
    $num1 = (int)$csv[0];
    $num2 = (int)$csv[1];
    $operador = trim($csv[2]);

    switch ($operador) {
        case 'suma':
            return $num1 + $num2;
        case 'resta':
            return $num1 - $num2;
        case 'producto':
            return $num1 * $num2;
        case 'division':
            return $num2 != 0 ? $num1 / $num2 : "Error: div 0";
        default:
            return "Operacion no soportada";
    }
}
?>

```

### Entrada:

```txt
z1,z2,op
3,1,suma
10,4,resta
2,8,resta
5,2,producto
7,0,producto
9,3,division
10,3,division
8,0,division
```

Archivo: `resultado.csv`

### Salida

```txt
numero1,numero2,operacion,resultado
3,1,suma,4
10,4,resta,6
2,8,resta,-6
5,2,producto,10
7,0,producto,0
9,3,division,3
10,3,division,3.3333333333333
8,0,division,"Error: div 0"

```

- **Entrada:** `ops.csv`
- **Salida:** `resultado.csv`

---

## Ejemplo de ejecución

```bash
php ejercicio1.php
```

### ops.csv

## Ejercicio 2: Estadísticas de palabras en PHP

### Enunciado

Dado un fichero `texto.txt`, contar cuántas palabras hay en total y cuántas veces aparece cada palabra.

La salida se debe guardar en `estadisticas.csv` con el formato:

```code
palabra,frecuencia
```

### Reglas:

- Ignorar mayúsculas/minúsculas (ejemplo: `PHP` y `php` cuentan como la misma palabra).
- Ignorar signos de puntuación.

---

## Archivos de ejemplo

### Entrada (`texto.txt`)

```code
Zeus gobernaba desde el Olimpo, lanzando rayos y truenos.
Atenea, diosa de la sabiduría, protegía a los héroes.
Hércules realizaba sus doce trabajos, mientras Poseidón agitaba los mares con su tridente.
Hades reinaba en el inframundo, y Afrodita inspiraba el amor entre los mortales.
```

### Salida esperada (`estadisticas.csv`)

```code
palabra,frecuencia
zeus,1
gobernaba,1
desde,1
el,3
olimpo,1
lanzando,1
rayos,1
y,2
truenos,1
atenea,1
diosa,1
de,1
la,1
sabiduría,1
protegía,1
a,1
los,3
héroes,1
hércules,1
realizaba,1
sus,1
doce,1
trabajos,1
mientras,1
poseidón,1
agitaba,1
mares,1
con,1
su,1
tridente,1
hades,1
reinaba,1
en,1
inframundo,1
afrodita,1
inspiraba,1
amor,1
entre,1
mortales,1
```

### Codigo

```php
<?php
$ruta = "ficheros/texto.txt";
$destino = "ficheros/estadisticas.csv";

$contenido = file_get_contents($ruta);
if ($contenido === false) {
    die("No se pudo abrir el archivo $ruta");
}

$contenido = strtolower($contenido);

$palabras = explode(" ", $contenido);

$frecuencia = [];
foreach ($palabras as $palabra) {
    $palabra = trim($palabra);
    if ($palabra !== "") {
        if (array_key_exists($palabra, $frecuencia)) {
            $frecuencia[$palabra] += 1;
        } else {
            $frecuencia[$palabra] = 1;
        }
    }
}

$out = fopen($destino, "w");
if ($out === false) {
    die("No se pudo crear el archivo $destino");
}

fputcsv($out, ["palabra", "frecuencia"]);

foreach ($frecuencia as $palabra => $veces) {
    fputcsv($out, [$palabra, $veces]);
}

fclose($out);

?>

```

### Entrada (`texto.txt`)

```code
PHP es divertido. PHP es potente y divertido. php php phph
```

### Salida (`estadisticas.csv`)

```code
palabra,frecuencia
php,4
es,2
divertido.,2
potente,1
y,1
phph,1

```
