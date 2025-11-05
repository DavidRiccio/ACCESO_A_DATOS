<?php
$ruta = "ficheros/datos.json";
$json= file_get_contents($ruta);
echo json_decode($json);
?>