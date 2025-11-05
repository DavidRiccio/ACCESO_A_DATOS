<?php

$ruta = "ficheros/texto.txt";
echo str_word_count(file_get_contents($ruta));


?>