<%-- 
    Document   : CitizenDashBoard
    Created on : Jan 5, 2022, 3:59:22 AM
    Author     : USER
--%>

<%@page import="Beans.DatePrinter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Citizen</title>
    <link rel="stylesheet" href="styles.css">
    

    <script>// Use Javascript
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0 so need to add 1 to make it 1!
        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        today = yyyy + '-' + mm + '-' + dd;
        document.getElementById("datefield").setAttribute("min", today);</script>
</head>

<body> 
    <jsp:useBean id="Citizen" type="Models.Citizen" scope="session" />
    
    <img src="icon.jpg" alt="" width="80 px" height="80 px">
    <H1 style="display: inline;">Just Vaccine</H1>
    
    <div>
        <a href="HomePage.jsp"><button class="button-33">
                 Back</button></a>
    </div>
    <div class="form-center"><H1><%out.print("Welcome "+Citizen.getFname());%></H1></div>
    <div style="margin-top: 80px; margin-left: 20px;">
         <div style="margin-top: 80px; margin-left: 20px;">
        <div><label for="" class="button-33" style="width:100px; margin-top: 20px;">First Shot</label>    <%out.print(DatePrinter.print(Citizen.getFirstVacD()));%></div>
        <div><label for="" class="button-33" style="width:100px; margin-top: 20px;">Second Shot</label>   <%out.print(DatePrinter.print(Citizen.getSecondVacD()));%></div>
        <div><label for="" class="button-33" style="width:100px; margin-top: 20px;">Booster Shot</label>  <%out.print(DatePrinter.print(Citizen.getThirdVacD()));%></div>
    </div>
    </div>

    <div class="form-center" style="margin-top: 40px">
        <form action="reserveAppointment" method="POST">
            <input type="date" name="VacD" id="" class="label-x" min="">
         <select name="VacT" class="label-x">
    <option value="Pfizer">Pfizer</option>
    <option value="Moderna">Moderna</option>
    <option value="Sinopharm">Sinopharm</option>   
         </select>
         <select name="VacP" class="label-x">
    <option value="Irbid-Alhasan">Irbid-Alhasan</option>
    <option value="Amman-H">Amman-H</option>
    <option value="Zarqa-H">Zarqa-H</option>   
         </select>
            
            <button class="label-x" style="margin-left: 10px;">Make Appointment</button>
        </form>
    </div>

</body>

</html>