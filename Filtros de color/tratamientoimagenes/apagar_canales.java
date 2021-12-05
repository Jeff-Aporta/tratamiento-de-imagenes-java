package tratamientoimagenes;

import java.awt.Color;

public class apagar_canales implements filtro_de_imagen{

    @Override
    public Color colorResultado(Color entrada) {
        return Color.BLACK;
    }
    
}
