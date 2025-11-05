<?php
$ruta = "ficheros/excusas.txt";
$lineas = file($ruta);
$random = rand(0,2);
echo($lineas[$random]);
?>