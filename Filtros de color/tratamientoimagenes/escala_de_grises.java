package tratamientoimagenes;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class escala_de_grises implements filtro_de_imagen {

    @Override
    public Color colorResultado(Color entrada) {
        int r = entrada.getRed();
        int g = entrada.getGreen();
        int b = entrada.getBlue();
        int a = entrada.getAlpha();
        int gris = (r + g + b) / 3;
        return new Color(gris, gris, gris, a);
    }

}
