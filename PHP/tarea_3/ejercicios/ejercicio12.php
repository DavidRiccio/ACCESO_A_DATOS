<?php

$ruta = "ficheros/ranking.txt";
$lineas = file($ruta);
$resultado = [];
foreach ($lineas as $l) {
   print_r( explode(": ",$l));
}

?>