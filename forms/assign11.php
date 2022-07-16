
<!DOCTYPE HTML>  
<html>
<head>
    <title> Order Summery </title>
<style>
    body{
   
    }

    p{
    font: 95% Arial, Helvetica, sans-serif;
    max-width: 98%;
    margin: 10px auto;
    margin-bottom: 80px;
    border-radius: 28px;
    padding: 16px;
    background: #F7F7F7;
    text-align:center;
    }

    form{
        display:inline-block;
        margin-left:44%;
        width: 100%;
        max-width: 200px;
        box-sizing: border-box;
 
    }

    button{
        width: 100%;
        max-width: 290px;
        box-sizing: border-box;
    }

    h1{
        text-align:center;
        background: #58afef;
        border-radius: 4px;
        padding: 10px 0 10px 10px;
        font-size: 140%;
        font-weight: 300;
        text-align: left;
        color: #fff;
    }
</style>
</head>
<body>




<?php
if (isset($_GET["validate"])) {
    $firstName = $_GET["first_name"];
    $lastName = $_GET["last_name"];
    $phone = $_GET["phone"];
    $credit_card = $_GET["credit_card"];
    $exp_date = $_GET["exp_date"];
    $card = $_GET["card"];
    $address= $_GET["address"];
    $total = $_GET["total"];

    echo "<h1> Order summery </h1>";
    echo "<br>";
    echo "<br>";
    echo "<p> First Name: ". $firstName;
    echo "<br>";
    echo "<br>";
    echo "Last Name: ". $lastName;
    echo "<br>";
    echo "<br>";
    echo "Phone number: ". $phone;
    echo "<br>";
    echo "<br>";
    echo "Credit card number: ". $credit_card;
    echo "<br>";
    echo "<br>";
    echo "Expiry date: ". $exp_date;
    echo "<br>";
    echo "<br>";
    echo " Credit card type: ". $card;
    echo "<br>";
    echo "<br>";
    echo "Address: ". $address;
    echo "<br>";
    echo "<br>";
    echo "Total: ". $total;
    echo "</p>";
    echo "<br>";
    echo "<br>";
    
}
?>
<form method="GET" action="assign11_a.php">
<input type='submit' name='confirm' id="confirm" value='Confirm order'/>
<input type='submit' name='cancel' id="cancel" value='Cancel order'/>
</form>

</body>
</html>

