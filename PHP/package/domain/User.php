<?php
/**
 * Created by PhpStorm.
 * User: viniciusthiengo
 * Date: 10/11/15
 * Time: 10:28 PM
 */

class User {
     public $name;
     public $phone;
     public $email;
	 public $imei;
	 public $serial_sim

    public function __construct( $name, $phone, $email, $imei, $serial_sim){
        $this->name = $name;
        $this->phone = $phone;
        $this->email = $email;
		$this->imei = $imei;
		$this->serial_sim = $serial_sim;
    }
	
	
}

