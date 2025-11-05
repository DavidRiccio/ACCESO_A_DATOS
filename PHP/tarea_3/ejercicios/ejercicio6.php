<?php

$ruta = "ficheros/frase.txt";
$reversa = "ficheros/reversa.txt";

$frase =strrev(file_get_contents($ruta));
file_put_contents($reversa,$frase);
echo file_get_contents($reversa);
?>