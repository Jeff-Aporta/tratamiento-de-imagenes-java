package tratamientoimagenes;

import java.awt.Color;
import java.awt.image.BufferedImage;

public interface filtro_de_imagen {

    public Color colorResultado(Color entrada);

    default Color transicion(Color entrada, double tr, double tg, double tb) {
        Color resultado = colorResultado(entrada);
        return new Color(
                lerpChanel(entrada.getRed(), resultado.getRed(), tr),
                lerpChanel(entrada.getGreen(), resultado.getGreen(), tg),
                lerpChanel(entrada.getBlue(), resultado.getBlue(), tb),
                entrada.getAlpha()
        );
    }

    default int lerpChanel(double n1, double n2, double t) {
        return (int) ((n2 - n1) * t + n1);
    }

    default public BufferedImage Filtro(BufferedImage img, double tr, double tg, double tb) {
        BufferedImage retorno = new BufferedImage(img.getWidth(), img.getHeight(), 2);
        for (int c = 0; c < img.getWidth(); c++) {
            for (int f = 0; f < img.getHeight(); f++) {
                Color entrada = new Color(img.getRGB(c, f), true);
                Color resultado = transicion(entrada, tr, tg, tb);
                retorno.setRGB(c, f, resultado.getRGB());
            }
        }
        return retorno;
    }

}
