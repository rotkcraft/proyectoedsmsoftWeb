package org.edsmsoft;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Alexander on 09/12/2016.
 */
@WebServlet(name = "TraerGN")
public class TraerGN extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String s=request.getParameter("tipo");

        JSONParser jsonParser=new JSONParser();


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=response.getWriter();
        if(s!=null)
        {
            JSONObject enviar=new JSONObject();

            Conexion conexion=new Conexion(request);
            if(s.equals("genero"))
            {
                  enviar.put("generos",conexion.traerInfo("select idgenero,tgenero from genero"));
            }
            if(s.equals("nacionalidad"))
            {

                enviar.put("generos",conexion.traerInfo("select idnacionalidad,nacionalidad as \"Nacionalidad\" from nacionalidad"));
            }
            if(s.equals("estadocivil"))
            {

                enviar.put("generos",conexion.traerInfo("select idestadocivil,civil as \"NCivil\" from estadocivil"));
            }

            printWriter.print(enviar.toString());
            printWriter.close();


        }

    }
}
