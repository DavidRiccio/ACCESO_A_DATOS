<?php

$ruta = "ficheros/numeros.txt";
$file = fopen($ruta,"w");
for ($i=1; $i <=10 ; $i++) { 
    fwrite($file, $i . "\n");
}
fclose($file);

echo file_get_contents($ruta);

?>