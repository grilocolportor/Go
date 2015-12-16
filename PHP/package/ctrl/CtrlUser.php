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
		
    if( strcasecmp( $_SG['method'], 'one-user' ) == 0 ){

		$_SG['userPhone'] = trim($_SG['userPhone'], '"');
	
		// echo 'entrou aqui';
		$user;
		$consulta = mysql_query("SELECT * FROM user WHERE phone = '".$_SG['userPhone']."'");
        while($campo = mysql_fetch_array($consulta)){
			$user = new User($campo['name'], $campo['phone'], $campo['email'], $campo['imei'], $campo['serial_sim']);
		};
		
		
	
        //$country = new Country(236, 'US', 'United States', 'United States of America', 'USA',
        //                                                       '840', 'yes', '1', '.us', '10', '11');

        header('Content-Type: application/json; charset=utf-8');
        echo json_encode( array('user'=>$user) );

    }else if( strcasecmp( $_SG['method'], 'save-user' ) == 0 ){
        $data = json_decode($_SG['user'], true);
		//$string="";
		foreach ($data as  $value) {
			$string = $string."".$value.",";
				//$email = $value//$str[1];
				//$imei =  $value//$str[2];
				//$name =  $value//$str[3];
				//$phone =  $value//$str[4];
				//$serial_sim = //$value$str[5];	
			
			 
		//	$crud = new crud('user');  // instancia classe com as operaçoes crud, passando o nome da tabela como parametro
		//	$crud->inserir("name,phone, email, imei, serial_sim", "'$name','$phone', '$email', '$imei', '$serial_sim' "); // utiliza a funçao INSERIR da classe crud
			
		}
		//$string = $string.",1";
		
		$str = preg_split("/[\,]+/", $string); 
		
			$email = $str[1];
			$imei =  $str[5];
			$name =  $str[2];
			$phone =  $str[4];
			$serial_sim = $str[4];		
			
			 
			$crud = new crud('user');  // instancia classe com as operaçoes crud, passando o nome da tabela como parametro
			$crud->inserir("name, phone, email, imei, serial_sim", "'$name','$phone', '$email', '$imei', '$serial_sim' "); // utiliza a funçao INSERIR da classe crud
			
			
			//echo $value["name"] . ", " . $value["imei"] . "<br>";
		
		
		
		$data = var_export($data, true);
		
		/*header('Content-Type: application/json; charset=utf-8');
		echo json_encode( array('user'=>$data) );*/
		
		// $data = var_export($data, true);
		
		
		//eval('$teste = ' . $data);
		//$email = $data->{'email'};
		//$imei = $data->{'imei'};
		//$name = $data->{'nome'};
		//$phone = $data->{'phone'};
		//$serial_sim = $data->{'serialSim'};
		
		File::writeInFile($data, 'w', '../debug/save-user.txt');
		
		
		
		//$crud = new crud('user');  // instancia classe com as operaçoes crud, passando o nome da tabela como parametro
        //$crud->inserir("name,phone, email, imei, serial_sim", "'$name','$phone', '$email', '$imei', '$serial_sim' "); // utiliza a funçao INSERIR da classe crud

       
    }
	
	//editar
	// $nome = $_POST['nome']; //pega o elemento com o pelo NAME
    //    $descricao = $_POST['descricao']; //pega o elemento com o pelo NAME
    //    $crud = new crud('produto'); // instancia classe com as operaçoes crud, passando o nome da tabela como parametro
    //    $crud->atualizar("nome='$nome',descricao='$descricao'", "id='$getId'"); // utiliza a funçao ATUALIZAR da classe crud
    //    header("Location: index.php"); // redireciona para a listagem
