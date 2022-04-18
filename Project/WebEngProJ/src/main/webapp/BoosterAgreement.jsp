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
        <link rel="stylesheet" href="styles.css">
        <title>Booster-Agreement</title>
    </head>

    <body>
        <img src="icon.jpg" alt="" width="80 px" height="80 px">
        <H1 style="display: inline;">Agreement</H1>

        <div class="form-center">
            <form action="Agreement" method ="POST" >
                <div>
                    <p>We need your agreement to schedual your booster shot.</p>
                    <br>
                    <div><label for="Id" style="color: #009688;font-weight: bold;">Do you agree?</label></div>
                    <br>
                    <br>
                </div>

                <div>
                    <input type="radio" id="disagree" name="agreement" value="2"
                           checked>
                    <label for="disagree" style="font-weight: bold ; color: #000">I do not</label>
                </div>

                <div>
                    <input type="radio" id="agree" name="agreement" value="1">
                    <label for="agree" style="font-weight: bold ; color: #000">I do</label>
                </div>

                <div class="form-center"><input type="submit" value="Submit" class="button-33"> </div>
            </form>
        </div>

    </body>
</html>
