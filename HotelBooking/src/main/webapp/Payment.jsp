<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
String roomtype=(String)request.getAttribute("room_type");
System.out.println(roomtype);
String a=(String)request.getAttribute("finalprice");
String dates=(String)request.getAttribute("days");
String msg=(String)request.getAttribute("msg");

%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Paypal Payment</title>

    <link rel="stylesheet" href="style.css">
</head>
<body>

    <main id="cart-main">
        <div class="site-title text-center">
            <h1 class="font-title">Payment</h1>
        </div>

        <div class="container">
            <div class="grid">
                <div class="col-1">
                    <div class="flex item justify-content-between">
                        <div class="flex">
                            <div class="img text-center">
                                <img src="./images/hotelimagecup.jpg" alt="">
                            </div>
                            
                            <div class="title">
                                <h3><%=roomtype +" Room" %></h3><!-- Room Type -->
                                <span><%= dates +" Days" %></span><!-- Number of Dates -->
								<div>
									<%=msg %>
								</div>
                            </div>
                            
                        </div>
                        
                        <div class="price">
                            <h4 class="text-red"><%=a+" LKR" %></h4>
                        </div>
                    </div>
                </div>
                <div class="col-2">
                    <div class="subtotal text-center">
                        <h3>Price Details</h3>

                        <ul>
                            <li class="flex justify-content-between">
                                <label for="price">No of Days : <%= dates %> </label><!-- Number of Dates -->
                                <span><%=a+" LKR" %></span><!-- Total Bill -->
                            </li>
                         
                            <hr>
                            <li class="flex justify-content-between">
                                <label for="price">Amout Payble : </label>
                                <span class="text-red font-title"><%=a+" LKR" %></span><!-- Amount Payable -->
                            </li>
                        </ul>
                        <div id="paypal-payment-button">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>


    <script src="https://www.paypal.com/sdk/js?client-id=AZ9rsyWeLt_Eyso4BZM2EEjWre9f6sCOBGJyzsqPfTd8csUbuVZ3PAnf3dNd1spLHN47ck0yOBbPnsic&disable-funding=credit,card"></script>
    <script src="index.js"></script>
</body>
</html>
