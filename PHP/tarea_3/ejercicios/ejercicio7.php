<?php

$ruta = "ficheros/datos_numericos.txt";
$reversa = "ficheros/reversa.txt";
$array_datos=(explode(",",file_get_contents($ruta)));

echo(array_sum($array_datos));
?>