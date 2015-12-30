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
		
    if( strcasecmp( $_SG['method'], 'one-friend' ) == 0 ){

		$_SG['userPhone'] = trim($_SG['userPhone'], '"');
	
		// echo 'entrou aqui';
		$user;
		$consulta = mysql_query("SELECT * FROM user WHERE phone = '".$_SG['userPhone']."'");
        while($campo = mysql_fetch_array($consulta)){
			$user = new User($campo['name'], $campo['phone'], $campo['email'], $campo['imei'], $campo['serial_sim']);
		};

        header('Content-Type: application/json; charset=utf-8');
        echo json_encode( array('user'=>$user) );

    }else if( strcasecmp( $_SG['method'], 'save-user' ) == 0 ){
        $data = json_decode($_SG['user'], true);
		$string="";
		foreach ($data as  $value) {
			$string = $string."".$value.",";	
		}
		
		$str = preg_split("/[\,]+/", $string); 
		
			$email = $str[0];
			$imei =  $str[1];
			$name =  $str[2];
			$phone =  $str[3];
			$serial_sim = $str[4];		
			
			 
			$crud = new crud('user');  // instancia classe com as operaçoes crud, passando o nome da tabela como parametro
			$crud->inserir("name, phone, email, imei, serial_sim", "'$name','$phone', '$email', '$imei', '$serial_sim' "); // utiliza a funçao INSERIR da classe crud
			
			//$numAleatorio = rand(1,99999);
			
			//$GCM = new GCM('1', $numAleatorio);
			
			
		$data = var_export($data, true);
		
		/*header('Content-Type: application/json; charset=utf-8');
		echo json_encode( array('user'=>$data) );*/
		
		File::writeInFile($data, 'w', '../debug/save-user.txt');
		
		header('Content-Type: application/json; charset=utf-8');
        echo json_encode( array('gcm'=>$GCM) );
    }
	
	else if( strcasecmp( $_SG['method'], 'save-contacts' ) == 0 ){
        $data = json_decode($_SG['contacts'], true);
		$phone1 = $_SG['user'];
		//File::writeInFile($data, 'w', '../debug/log.txt');
		$string="";
		
		$i = 0;
		foreach ($data as  $value) {
			if(is_array($value)){
				
				foreach($value as $v3){
			
						$str =  preg_replace("/[^0-9]/", "", $v3);
						$_sb = "";
						if(strlen($str) === 8 || strlen($str) === 9){
							$_sb = substr($phone1, 0, 4);
						}else if(strlen($str) === 10 || strlen($str) === 11){
							$_sb = substr($phone1, 0, 2);
						}else{
							$_sb = $str;
						}
						
						
						
						$sql = "SELECT * FROM user WHERE phone like '". $_sb ."%". $str ."'";
						//File::writeInFile($sql, 'w', '../debug/log.txt');
						$consulta = mysql_query($sql);
						//File::writeInFile(mysql_num_rows($consulta), 'w', '../debug/log.txt');
						if(mysql_num_rows($consulta)===1){
							$row = mysql_fetch_assoc($consulta);
							$phoneFound = $row['phone'];
							if(strcasecmp($phoneFound,$phone1) != 0){
								//File::writeInFile($phoneFound, 'w', '../debug/log.txt');
								$sqls = "SELECT * FROM friends WHERE phone1 = '". $phone1 ."  and phone2 = ". $str ."'";
								$consultas = mysql_query($sqls);
								if(mysql_num_rows($consultas)===0){
									//File::writeInFile($i, 'w', '../debug/log.txt');
									$crud = new crud('friends');  // instancia classe com as operaçoes crud, passando o nome da tabela como parametro
									$crud->inserir("phone1, phone2", "'$phone1','$phoneFound'"); // utiliza a funçao INSERIR da classe crud
								}
							}
							
						}
				}
			}
		}
		
		$data = var_export($data, true);
        File::writeInFile($data, 'w', '../debug/saver-contacts.txt');
    }
