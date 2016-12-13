package org.edsmsoft;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by rcraft on 12-12-16.
 */
@WebServlet(name = "Configurar")
public class Configurar extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String dir=request.getParameter("url");
        String usuario=request.getParameter("usuario");
        String clave=request.getParameter("clave");
        Archivo archivo=new Archivo( request.getServletContext().getRealPath("/WEB-INF/archivos/archivo.dat"));
           archivo.limpiarArchivo();
        archivo.guardar(new Encriptar().encriptar(dir+","+usuario+","+clave));
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html");
        printWriter.println("<script type=\"text/javascript\">");
        printWriter.println("alert('Guardado Exitosamente');");
        printWriter.println("</script>");

        printWriter.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
