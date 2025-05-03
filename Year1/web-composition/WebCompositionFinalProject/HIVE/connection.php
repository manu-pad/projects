<?php
//hive
$dbhost = "localhost"; //Essa linha define o valor da variável $dbhost como "localhost". Isso indica que o banco de dados está hospedado no mesmo servidor em que o arquivo PHP está sendo executado.
$dbuser = "root"; // variável $dbuser é definida como "root". Isso representa o nome de usuário usado para autenticar a conexão com o banco de dados.
$dbpass = ""; //A variável $dbpass é definida como uma string vazia. Isso indica que não há uma senha definida para a conexão com o banco de dados. 
$db = "hive"; //Aqui, a variável $db é definida como "demo". Isso especifica o nome do banco de dados que será usado na conexão. "demo" provavelmente é o nome do banco de dados que contém as tabelas relevantes para este código.
$con = mysqli_connect($dbhost, $dbuser, $dbpass , $db) or die($con);
//Essa linha estabelece a conexão com o banco de dados usando a função mysqli_connect() do MySQLi (MySQL Improved Extension). Ela recebe os parâmetros $dbhost, $dbuser, $dbpass e $db para realizar a conexão.
//mysqli_connect() retorna um objeto de conexão ao banco de dados se a conexão for bem-sucedida, ou false em caso de falha.
//O operador or die($con) é usado para interromper a execução do script caso a conexão com o banco de dados falhe. 

if(!$con){
    echo "connection failed";
}
else
    echo "connection succes";
?>