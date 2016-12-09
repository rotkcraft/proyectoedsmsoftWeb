package org.edsmsoft;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by rcraft on 11-29-16.
 */
@WebServlet(name = "AlumnoInsertar")
public class AlumnoInsertar extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String latitud= request.getParameter("infotoda");
        String longitud= request.getParameter("longitud");
        String mac= request.getParameter("mac");

        PreparedStatement stmt = null;
        Connection conn = null;
        PrintWriter printWriter=response.getWriter();
        if(latitud!=null && longitud!=null && mac!=null)
        {
            try {
                DriverManager.registerDriver(new org.postgresql.Driver());
//            try {
//                Class.forName("com.mysql.jdbc.Driver");//Mysql Connection
//            } catch (ClassNotFoundException ex) {
//                System.out.println(ex);
//            }
                conn = DriverManager.getConnection(request.getServletContext().getInitParameter("url"),request.getServletContext().getInitParameter("usuario"),request.getServletContext().getInitParameter("clave"));




                String sql = "insert into bitacoracliente(mac,fecha,punto) values('"+mac.trim()+"',now(),POINT("+latitud.trim()+","+longitud.trim()+"))";

                stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                stmt.close();
                printWriter.print("<p>Inserto Correctamente</p>");
                printWriter.close();


                conn.close();

            }
            catch(Exception e){printWriter.print(e.getMessage()); printWriter.close();}

            finally {

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException sqlex) {
                    }

                    stmt = null;
                }

                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException sqlex) {
                    }

                    conn = null;
                }
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
