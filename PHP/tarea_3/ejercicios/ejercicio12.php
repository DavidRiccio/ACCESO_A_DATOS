<?php

$ruta = "ficheros/ranking.txt";
$lineas = file($ruta);
$resultado = [];


foreach ($lineas as $l) {
    $helper = explode(": ",$l) ;
    $resultado[$helper[0]] = $helper[1];
    arsort($resultado);
}
print_r($resultado);
?>