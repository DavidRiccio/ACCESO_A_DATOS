<?php
$ruta1 = "ficheros/adjetivos.txt";
$ruta2 = "ficheros/animales.txt";

$lineas1 = file($ruta1);
$lineas2 = file($ruta2);
$random1 = rand(0,2);
$random2= rand(0,2);

echo($lineas1[$random1] . $lineas2[$random2]."\n");
?>