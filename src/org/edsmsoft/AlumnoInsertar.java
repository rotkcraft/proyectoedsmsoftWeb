package org.edsmsoft;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by rcraft on 11-29-16.
 */
@WebServlet(name = "AlumnoInsertar")
public class AlumnoInsertar extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        StringBuilder sb=new StringBuilder();
         String json;
        BufferedReader bufferedReader = request.getReader();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));;
        try {
//            json=bufferedReader.readLine();
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                sb.append(linea).append('\n');
            }
        } finally {
            bufferedReader.close();
        }


        JSONParser jsonParser=new JSONParser();
        JSONObject info=null;
       JSONObject prueba=new JSONObject();
        try
        {
            info=(JSONObject)jsonParser.parse(sb.toString());
        }catch (Exception ex){ex.printStackTrace();}

//        PrintWriter printWriter=response.getWriter();
        if(info!=null)
        {
            System.out.println(info.toString());
            System.out.println("Entramos aqui");

                 JSONObject objeto= (JSONObject) info.get("info");
            System.out.println(objeto.toString());
            Conexion conexion=new Conexion(request);
           int idalumno= conexion.insertar("insert into persona(pnombre,snombre) values(\'"+objeto.get("nombre")+"'," +
                    "'"+objeto.get("apellido")+"')");
            System.out.println("insert into persona(pnombre,snombre) values('"+objeto.get("nombre")+"'," +
                    "'"+objeto.get("apellido")+"')");
            System.out.println("idalumno = " + idalumno);
            conexion.insertar("insert into " +
                    "alumno(idpersona,idgenero,idnacionalidad,identidad,fechanac) " +
                    "values("+idalumno+"," +
                    ""+objeto.get("genero")+","+objeto.get("nacionalidad") + "," +
                    ""+objeto.get("identidad")+"," +
                    "'"+objeto.get("fechanac")+"')");
            System.out.println(objeto.toString());

//                printWriter.close();


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
