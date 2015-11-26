<?php

    require_once('../autoload.php');
	require_once '../repositorio/conexao.php';
    require_once '../repositorio/crud.php';
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

	$con = new conexao(); // instancia classe de conxao
    $con->connect(); // abre conexao com o banco
		
    if( strcasecmp( $_SG['method'], 'one-country' ) == 0 ){

		$_SG['codCountry'] = trim($_SG['codCountry'], '"');
	
		// echo 'entrou aqui';
		$country;
		$consulta = mysql_query("SELECT * FROM country_t WHERE iso2 = '".$_SG['codCountry']."'");// .$_SG['codCountry']);
        while($campo = mysql_fetch_array($consulta)){
			$country = new Country($campo['country_id'], $campo['iso2'], $campo['short_name'], 
										$campo['long_name'], $campo['iso3'], $campo['numcode'], 
										$campo['un_number'], $campo['calling_code'], $campo['cctld'],
										$campo['min_size_phone'], $campo['max_size_phone']);
		};
		
		
	
        //$country = new Country(236, 'US', 'United States', 'United States of America', 'USA',
        //                                                       '840', 'yes', '1', '.us', '10', '11');

        header('Content-Type: application/json; charset=utf-8');
        echo json_encode( array('country'=>$country) );

    }
