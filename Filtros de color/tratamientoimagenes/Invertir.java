package tratamientoimagenes;

import java.awt.Color;

public class Invertir implements filtro_de_imagen {

    @Override
    public Color colorResultado(Color entrada) {
        int r = entrada.getRed();
        int g = entrada.getGreen();
        int b = entrada.getBlue();
        int a = entrada.getAlpha();
        return new Color(255 - r, 255 - g, 255 - b, a);
    }

}
