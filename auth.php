<?php
	$array = array("ServerDB");
	if (in_array($_GET['authkey'], $array)) {
	$obj->state = 'VAILD';
	$obj = json_encode($obj);
	echo $obj;
	return;
	}
	$obj->state = 'WRONG';
	$obj = json_encode($obj);
	echo $obj;
?>