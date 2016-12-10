package org.edsmsoft;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by rcraft on 11-29-16.
 */
@WebServlet(name = "AlumnoTraer")
public class AlumnoTraer extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
//        String id= request.getParameter("id");

         response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=response.getWriter();
   //     Archivo archivo=new Archivo( request.getServletContext().getRealPath("/WEB-INF/archivos/archivo.dat"));
        //   archivo.limpiarArchivo();
        //archivo.guardar(new Encriptar().encriptar("jdbc:postgresql://localhost:5432/edsmsoft,postgres,123"));



        Conexion conexion=new Conexion(request);


//        try {
//            DriverManager.registerDriver(new org.postgresql.Driver());
//            try {
//                Class.forName("com.mysql.jdbc.Driver");//Mysql Connection
//            } catch (ClassNotFoundException ex) {
//                System.out.println(ex);
//            }
//            conn = DriverManager.getConnection(request.getServletContext().getInitParameter("url"),request.getServletContext().getInitParameter("usuario"),request.getServletContext().getInitParameter("clave"));


            String sql = "select" +
                    " idalumno,persona.idpersona,persona.pnombre,persona.snombre,genero.tgenero,fechanac,nacionalidad.nacionalidad  " +
                    "from alumno" +
                    " inner join persona on alumno.idpersona=persona.idpersona " +
                    "inner join nacionalidad on alumno.idnacionalidad=nacionalidad.idnacionalidad " +
                    "inner join genero on alumno.idgenero=genero.idgenero;";
                JSONArray alumnos=conexion.traerInfo(sql);
//            stmt = conn.prepareStatement(sql);
//            ResultSet rs=stmt.executeQuery();
//            ResultSetMetaData rd=rs.getMetaData();
//            while(rs.next())
//            {
//                JSONObject objeto= new JSONObject();
//                for(int i=1;i<=rd.getColumnCount();i++)
//                {
//                    objeto.put(rd.getColumnLabel(i),rs.getString(i));
//
//                }
//                alumnos.add(objeto);
//            }

//            rs.close();
//            stmt.close();


        JSONObject infoAlumno=new JSONObject();
        infoAlumno.put("Objeto","holamundo");
        infoAlumno.put("alumnos", alumnos);

            printWriter.print(infoAlumno.toString());
            printWriter.close();


//            conn.close();
//
//        }
//        catch(Exception e){printWriter.print(e) ;}
//
//        finally {
//
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException sqlex) {
//                }
//
//                stmt = null;
//            }
//
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException sqlex) {
//                }
//
//                conn = null;
//            }
//        }


    }
}
