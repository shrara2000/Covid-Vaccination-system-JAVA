<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Just Vaccine</title>
</head>

<body>

    <img src="icon.jpg" alt="" width="80 px" height="80 px">

    <H1 style="display: inline;">Just Vaccine</H1>


    <div>
        <a href="HomePage.jsp"><button class="button-33">
                 Back</button></a>
    </div>

    <div class="form-center">
        <form action="Login" method="POST" >
            <div>
                <br>
                <div><label for="un" style="color: #009688;font-weight: bold;">Username</label></div>
                <input type="text" name="un" id="un" class="button-33" required>
                <br>
                <br>
            </div>
            <div><label for="pw" style="color: #009688;font-weight: bold;">Password</label></div>
            <input type="password" name="pw" id="pw" class="button-33" required>
            <br>
            <br>
            <div class="form-center"><input type="submit" value="Login" class="button-33"></div>
        </form>
    </div>

</body>

</html>