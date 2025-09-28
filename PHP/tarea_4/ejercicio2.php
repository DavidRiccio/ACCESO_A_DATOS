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
