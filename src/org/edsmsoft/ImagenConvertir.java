package org.edsmsoft;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by rcraft on 12-07-16.
 */
public class ImagenConvertir
{
    public static BufferedImage convertirImagen(String imageString)
    {
        BufferedImage image = null;
        byte[] imageByte;
        try
        {
            BASE64Decoder desencriptar = new BASE64Decoder();
            imageByte = desencriptar.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return image;
    }

    public static InputStream sacarArchivoImagen(String imagen)
    {
        ByteArrayOutputStream imagenbyte = new ByteArrayOutputStream();
        try
        {
            ImageIO.write(convertirImagen(imagen), "png", imagenbyte);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        InputStream is = new ByteArrayInputStream(imagenbyte.toByteArray());
        return is;
    }

    public static String convertirString(BufferedImage imagen)
    {
        String imagenString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try
        {

            ImageIO.write(imagen,"png", bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encriptar = new BASE64Encoder();
            imagenString = encriptar.encode(imageBytes);

            bos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return imagenString;
    }

}
