<?php
/**
 * Created by PhpStorm.
 * User: viniciusthiengo
 * Date: 10/11/15
 * Time: 10:28 PM
 */

class Country extends Obj {
     public country_id;
     public iso2;
     public short_name;
     public long_name;
     public iso3;
     public numcode;
     public un_memmber;
     public calling_code;
     public cctld;


    public function __construct( $name, $pathImg, Brand $brand, Engine $engine ){
        $this->country_id = $country_id;
        $this->iso2 = $iso2;
        $this->country_id = $country_id;
        $this->short_name = $short_name;
        $this->long_name = $long_name;
        $this->iso3 = $iso3;
        $this->numcode = $numcode;
        $this->un_memmber = $un_memmber;
        $this->calling_code = $calling_code;
        $this->cctld = $cctld;
    }
}