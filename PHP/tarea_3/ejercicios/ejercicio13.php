<?php
$ruta = "ficheros/canciones.txt";
$lineas = file($ruta);
$random = rand(0,5);
echo($lineas[$random]);
?>