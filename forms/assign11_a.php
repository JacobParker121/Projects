<!DOCTYPE HTML>  
<html>
<head>
<title>Order</title>;
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

    
</style>
</head>
<body>




<?php
if (isset($_GET["confirm"])){
   echo "<p>Order Complete!!</p>";
   echo "<a href='assign11.html'>"."Go back to order form"."</a>";
  } else if (isset($_GET["cancel"])){
    echo "<p>Order cancelled</p>";
    echo "<a href='assign11.html'>"."Go back to order form"."</a>";
  }

?>

</body>
</html>
