<?php 
$ruta = "ficheros/ops.csv";
$destino = "ficheros/resultados.csv";

$file = fopen($ruta, "r");

$cabecera = fgetcsv($file);

$out = fopen($destino, "w");

fputcsv($out, ["numero1", "numero2", "operacion", "resultado"]);

while (($csv = fgetcsv($file)) !== false) {
    $resultado = Operacion($csv);
    fputcsv($out, [$csv[0], $csv[1], $csv[2], $resultado]);
}

fclose($file);
fclose($out);


function Operacion(array $csv) {
    $num1 = (int)$csv[0];
    $num2 = (int)$csv[1];
    $operador = trim($csv[2]);

    switch ($operador) {
        case 'suma':
            return $num1 + $num2;
        case 'resta':
            return $num1 - $num2;
        case 'producto':
            return $num1 * $num2;
        case 'division':
            return $num2 != 0 ? $num1 / $num2 : "Error: div 0";
        default:
            return "Operacion no soportada";
    }
}
?>
