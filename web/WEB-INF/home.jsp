<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        
    </head>
    
    <body>
        
        <h2>Home page</h2>
        <h3>Hello ${user.username}.</h3>
        <a href="login?logout" name="logout">Log out</a>
        
    </body>
    
</html>
