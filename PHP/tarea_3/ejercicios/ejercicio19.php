<?php
$ruta = "ficheros/tweets.txt";


$tweet = "Este es un tweet de prueba";  
$fecha = date("Y-m-d H:i:s");
$linea = "[$fecha] $tweet" ;


file_put_contents($ruta, $linea);


if (is_readable($ruta)) {
    $lineas = file($ruta);
    $ultimos = array_slice($lineas, -5);

    echo "Últimos 5 tweets:";
    foreach ($ultimos as $t) {
        echo $t ;
    }
}
