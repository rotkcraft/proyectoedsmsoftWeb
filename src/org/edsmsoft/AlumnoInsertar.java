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
import java.io.PrintWriter;

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

        PrintWriter printWriter=response.getWriter();
        if(info!=null)
        {
            System.out.println(info.toString());
            System.out.println("Entramos aqui");

                 JSONObject objeto= (JSONObject) info.get("info");
            System.out.println(objeto.toString());

                for (Object ob:objeto.keySet().toArray())
                {

                    prueba.put(ob,objeto.get(ob));
                    System.out.println(ob+" "+objeto.get(ob));
                }

//            Conexion conexion=new Conexion(request);

                printWriter.print(prueba.toString());
                printWriter.close();


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
