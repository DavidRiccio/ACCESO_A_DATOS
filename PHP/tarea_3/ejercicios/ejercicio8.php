<?php

$ruta = "ficheros/tabla5.txt";
$file=fopen($ruta,"w");

for ($i=1; $i<=10 ; $i++) { 
    $resultado = $i * 5;
    $tabla = "5 * $i = $resultado";
    fwrite($file, $tabla . "\n");
}
fclose($file);


?>