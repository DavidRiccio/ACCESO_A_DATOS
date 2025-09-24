<?php

$nombres = ["Juan","Pepe","David","Cesar"];
$ruta = "ficheros/nombres.txt";
$file=fopen($ruta,"w");

foreach ($nombres as $n) {
    fwrite($file, $n . "\n" );
}
fclose($file);
echo(file_get_contents($ruta));

?>