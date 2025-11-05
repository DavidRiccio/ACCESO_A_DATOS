<?php
$ruta = "ficheros/chistes.txt";
$chistes = file($ruta,"w");
if (!$chistes) {
    ("No hay chistes en $ruta");
}

$chiste = $chistes[array_rand($chistes)];
echo $chiste;
