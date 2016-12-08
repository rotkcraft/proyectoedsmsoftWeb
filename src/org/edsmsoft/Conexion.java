package org.edsmsoft;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by rcraft on 11-29-16.
 */
public class Conexion {
private String url;
private String usu; 
private String clave;

public Conexion(HttpServletRequest request) {
    Archivo archivo=new Archivo( request.getServletContext().getRealPath("/WEB-INF/archivos/archivo.dat"));

	String s[]=new Encriptar().desencriptar(archivo.traeArchivo()).trim().split(",");
	this.url=s[0];
	this.usu=s[1];
	this.clave=s[2];
	
}
    public JSONArray traerInfo(String sql)
    {
        JSONArray info=new JSONArray();
        PreparedStatement stmt = null;
        Connection conn = null;


        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(url, usu, clave);

            stmt = conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            ResultSetMetaData rd=rs.getMetaData();
            while(rs.next())
            {
                JSONObject objeto= new JSONObject();
                for(int i=1;i<=rd.getColumnCount();i++)
                {
                    objeto.put(rd.getColumnLabel(i),rs.getString(i));

                }
                info.add(objeto);
            }

            rs.close();
            stmt.close();

            conn.close();
            return info;

        }
        catch(Exception e){
            JSONObject error=new JSONObject();
            error.put("error",e.getMessage());
            info.add(error);
            return info;}

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
public void insertar(String sql)
{
	try
	{
		Connection con=DriverManager.getConnection(url, usu, clave);
		Statement ps=con.createStatement();
		ps.execute(sql);
		
	}catch(Exception ex)
	{
		ex.printStackTrace();
	}
}

}
