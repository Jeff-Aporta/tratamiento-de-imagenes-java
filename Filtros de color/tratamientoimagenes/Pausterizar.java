package tratamientoimagenes;

import java.awt.Color;

public class Pausterizar implements filtro_de_imagen {

    @Override
    public Color colorResultado(Color entrada) {
        int r = entrada.getRed();
        int g = entrada.getGreen();
        int b = entrada.getBlue();
        int a = entrada.getAlpha();
        return new Color(
                (int) ((255 / 7f) * Math.round(7 * r / 255f)),
                (int) ((255 / 7f) * Math.round(7 * g / 255f)),
                (int) ((255 / 7f) * Math.round(7 * b / 255f)),
                a
        );
    }

}
