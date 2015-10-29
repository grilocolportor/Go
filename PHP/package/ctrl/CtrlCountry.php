<?php

    require_once('../autoload.php');
    /*if (!ini_get('display_errors')) {
        ini_set('display_errors', 1);
    }*/

    // HACK CODE
        $_SG = empty($_POST) ? $_GET : $_POST;
        $_SG = empty($HTTP_RAW_POST_DATA) ? $_SG : $HTTP_RAW_POST_DATA;
        $_SG['method'] = trim($_SG['method'], '"');
        if( !is_array( $_SG ) ){
            $_SG = json_decode($_SG, true);
        }

    if( strcasecmp( $_SG['method'], 'one-country' ) == 0 ){

        $engine = new Engine( 325, 2005, '4.9' );
        $brand = new Brand('Cadillac', null);
        $car = new Car('ZT06', null, $brand, $engine);

        header('Content-Type: application/json; charset=utf-8');
        echo json_encode( array('car'=>$car) );

    }
?>