package org.edsmsoft;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
       // BufferedReader bufferedReader=request.getReader();
        String linea="";
        JSONObject otracosa=new JSONObject();
        StringBuffer respuesta=new StringBuffer();

        //while ((linea=bufferedReader.readLine())!=null){
         //   respuesta.append(linea);
        //}
       // bufferedReader.close();

        JSONParser jsonParser=new JSONParser();
       JSONObject prueba=new JSONObject();
        try
        {
            String in=request.getParameter("info");
            System.out.println(in);
            prueba=(JSONObject)jsonParser.parse(in);
        }catch (Exception ex){ex.printStackTrace();}

        PreparedStatement stmt = null;
        Connection conn = null;
        PrintWriter printWriter=response.getWriter();
        if(!respuesta.toString().isEmpty())
        {
            System.out.println(respuesta);
            try {
                JSONObject objeto= (JSONObject) jsonParser.parse(respuesta.toString());

                for(Object ob:objeto.keySet())
                {
                    prueba.put(ob,objeto.get(ob));
                    System.out.println(ob+" "+objeto.get(ob));
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
            Conexion conexion=new Conexion(request);

            try {

//            try {
//                Class.forName("com.mysql.jdbc.Driver");//Mysql Connection
//            } catch (ClassNotFoundException ex) {
//                System.out.println(ex);
//            }


                //String sql = "insert into alumno(mac,fecha,punto) values('"+mac.trim()+"',now(),POINT("+latitud.trim()+","+longitud.trim()+"))";

                printWriter.print(prueba.toString());
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
