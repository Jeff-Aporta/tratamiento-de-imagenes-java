package tratamientoimagenes;

import java.awt.Color;

public class Binarizar implements filtro_de_imagen{

    @Override
    public Color colorResultado(Color entrada) {
        int r = entrada.getRed();
        int g = entrada.getGreen();
        int b = entrada.getBlue();
        int a = entrada.getAlpha();
        return new Color(r<128?0:255, g<128?0:255, b<128?0:255, a);
    }
    
}
