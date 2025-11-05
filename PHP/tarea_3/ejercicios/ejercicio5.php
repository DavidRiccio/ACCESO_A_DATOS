<?php

$ruta = "ficheros/origen.txt";
$destino = "ficheros/destino.txt";
$file = fopen($ruta,"w");

file_put_contents($ruta, "Hola ,muy buenas");
echo(file_get_contents($ruta));
copy($ruta,$destino);
echo(file_get_contents($destino));
?>