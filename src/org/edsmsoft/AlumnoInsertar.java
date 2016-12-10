package org.edsmsoft;


import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
        String info= request.getParameter("infotoda");
        JSONParser jsonParser=new JSONParser();

        PreparedStatement stmt = null;
        Connection conn = null;
        PrintWriter printWriter=response.getWriter();
        if(info!=null)
        {
            Conexion conexion=new Conexion(request);

            try {

//            try {
//                Class.forName("com.mysql.jdbc.Driver");//Mysql Connection
//            } catch (ClassNotFoundException ex) {
//                System.out.println(ex);
//            }


                //String sql = "insert into alumno(mac,fecha,punto) values('"+mac.trim()+"',now(),POINT("+latitud.trim()+","+longitud.trim()+"))";

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
