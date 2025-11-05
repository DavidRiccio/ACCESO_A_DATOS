<?php
$ruta = "./ejercicio-3/palabras.txt";
$destino ="./ejercicio-3/resultados.txt";
$file = fopen($ruta,"r");
$file_destino  = fopen($destino, "w");
$content = file_get_contents($ruta);
$content = explode("\n",$content);

/**
 * Larga
 * Calcula la palabra mas larga
 * @param  array $contenido
 * @return String
 */
function Larga($contenido){
    $palabra = $contenido[0];
    foreach ($contenido as $p) {
        if (strlen($p) >strlen($palabra) ){
            $palabra = $p;
        }
    }
    $resultado= "+larga: " . $palabra ."\n";
    echo $resultado;
    return $resultado;
}

/**
 * Corta
 * Calcula la palabra mas corta de un array
 * @param  array $contenido
 * @return String
 */
function Corta($contenido){
    $palabra = $contenido[0];
    foreach ($contenido as $p) {
        if (strlen($p) <= strlen($palabra) ){
            $palabra = $p;
        }
    }
    $resultado= "+corta: " . $palabra ."\n";
    return $resultado;
}

/**
 * Total
 *Calcula la longitud de un array
 * @param  array $contenido
 * @return String
 */
function Total(array $contenido){
 $resultado = "total: ". count($contenido);
 return $resultado;
}

/**
 * Frecuencia
 * Calcula la frecuencia de cada item en el array
 * @param  array $contenido
 * @return array
 */
function Frecuencia(array $contenido){
    $frecuencia = [];
    foreach ($contenido as $palabra) {
    $palabra = trim($palabra);
    if ($palabra !== "") {
        if (array_key_exists($palabra, $frecuencia)) {
            $frecuencia[$palabra] += 1;
        } else {
            $frecuencia[$palabra] = 1;
        }
    }
}
return $frecuencia;
    
}

/**
 * Unicas
 *Calcula las palabras que son unicas en el array.
 * @param  array $contenido
 * @return array
 */
function Unicas(array $contenido){
 $unicas=[];
 $frecuencias = Frecuencia($contenido);
 foreach ($frecuencias as $key => $value) {
    if ($value ==1){
        echo $value;
        $unicas[]=$key; 
    }
}
return $unicas;
 
}
/**
 * Ordenar
 * Funcion para ordenar el contenido
 * @param  array $contenido
 * @return array
 */
function Ordenar(array $contenido){
    $resultado = arsort($contenido);
    print_r($resultado);
    return $resultado;
}



/**
 * Escribir
 * Escribe en el archivo todos los parametros
 * @param  array $contenido
 * @return void
 */

function Escribir(array $contenido){
fwrite($file_destino,$corta);
$total = Total($contenido);
$larga = Larga($contenido);
$corta = Corta($contenido);
$frecuencia = Frecuencia($contenido);
print_r($unicas);
    
}

Escribir($content);
?>