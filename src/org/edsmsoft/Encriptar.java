package org.edsmsoft;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by rcraft on 11-29-16.
 */
public class Encriptar
{
    private String llave;

    public Encriptar()
    {
        this("Sdf!hi,234dget!u");
    }

    public Encriptar(String llave)
    {
        this.llave = llave;
    }

    public static void main(String[] args)
    {
        Encriptar encriptar = new Encriptar();
        String s = encriptar.encriptar("Hola mundo");
        System.out.println("s = " + s);

        System.out.println("s = " + encriptar.desencriptar(s));

    }

    public String encriptar(String fuente)
    {
        Key llaveAes = new SecretKeySpec(llave.getBytes(), "AES");
        String s = null;
        try
        {
            Cipher cifrado = Cipher.getInstance("AES");

            cifrado.init(Cipher.ENCRYPT_MODE, llaveAes);
            byte[] encripcion = cifrado.doFinal(fuente.getBytes());
            s = Base64.getEncoder().encodeToString(encripcion);

        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        catch (BadPaddingException e)
        {
            e.printStackTrace();
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }

        return s;

    }

    public String desencriptar(String fuente)
    {
        Key llaveAes = new SecretKeySpec(llave.getBytes(), "AES");
        String s = null;
        try
        {
            Cipher cifrado = Cipher.getInstance("AES");
            byte[] decodificar = Base64.getDecoder().decode(fuente);

            cifrado.init(Cipher.DECRYPT_MODE, llaveAes);

            s = new String(cifrado.doFinal(decodificar));

        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        catch (BadPaddingException e)
        {
            e.printStackTrace();
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }


        return s;

    }
}
