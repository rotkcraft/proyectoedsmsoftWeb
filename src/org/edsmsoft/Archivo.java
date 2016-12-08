package org.edsmsoft;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by hadexexplade on 21/05/15.
 */
public class Archivo
{
    String nombreArchivo;

    public Archivo()
    {

    }

    public Archivo(String nombreArchivo)
    {
        this.nombreArchivo = nombreArchivo;
    }

    public String traeArchivo(String direccion)
    {
        StringBuffer str = new StringBuffer();

        try
        {
            FileReader entrada = new FileReader(direccion);
            Scanner sc = new Scanner(entrada);

            while (sc.hasNextLine())
            {
                str.append(sc.nextLine());
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return str.toString();
    }

    public String traeArchivo()
    {
        StringBuffer str = new StringBuffer();

        try
        {
            FileReader entrada = new FileReader(nombreArchivo);
            Scanner sc = new Scanner(entrada);

            while (sc.hasNextLine())
            {
                str.append(sc.nextLine().toString());
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return str.toString();
    }

    public String traerLinea(int buscarlinea)
    {
        String linea = new String();
        int f = 0;
        try
        {
            FileReader entrada = new FileReader(nombreArchivo);
            Scanner sc = new Scanner(entrada);

            while (sc.hasNextLine())
            {
                if (f == buscarlinea)
                {
                    linea = sc.nextLine();
                }

                f++;

                sc.nextLine();

            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return linea;
    }

    public int contarRegistros()
    {
        int f = 0;
        try
        {
            FileReader entrada = new FileReader(nombreArchivo);
            Scanner sc = new Scanner(entrada);

            while (sc.hasNextLine())
            {
                f++;
                sc.nextLine();

            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return f;
    }

    public void guardar(String ultimaLinea)
    {

        try
        {
            FileWriter fichero = new FileWriter(nombreArchivo, true);
            PrintWriter g = new PrintWriter(fichero);
            g.println(ultimaLinea);
            g.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void guardarSinSaltoDeLinea(String ultimaLinea)
    {

        try
        {
            FileWriter fichero = new FileWriter(nombreArchivo, true);
            PrintWriter g = new PrintWriter(fichero);
            g.print(ultimaLinea);
            g.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void modificar(String modificar[])
    {

        try
        {
            PrintWriter g = new PrintWriter(nombreArchivo);
            g.flush();

            for (int i = 0; i < modificar.length; i++)
            {
                g.println(modificar[i]);

            }
            g.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void modificar(String modificar)
    {

        String linea[] = modificar.split("\n");

        try
        {
            PrintWriter g = new PrintWriter(nombreArchivo);
            g.flush();

            for (int i = 0; i < linea.length; i++)
            {
                g.println(linea[i]);
            }
            g.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void limpiarArchivo()
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreArchivo);
            pw = new PrintWriter(fichero);
            pw.flush();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {

                if (null != fichero)
                {
                    fichero.close();
                }
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
    }

    public void limpiarArchivo(String dir)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(dir);
            pw = new PrintWriter(fichero);
            pw.flush();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {

                if (null != fichero)
                {
                    fichero.close();
                }
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
    }

}