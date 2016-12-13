<%--

  User: rcraft
  Date: 11-29-16
  Time: 12:52 PM
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <link rel="stylesheet" href="estilo.css">
    <title></title>
  </head>
  <body>
  <div class="centrarpanel">
  <form action="/Configurar" method="post">
   <input type="text" name="url" value="jdbc:postgresql://localhost:5432/edsmsoft" size="35">
      <br>
   <input type="text" name="usuario" value="postgres">
   <br>
      <input type="password" name="clave" value="root">
    <br>
      <input type="submit" name="aceptar" value="Enviar">
  </form>
  </div>
  </body>
</html>
