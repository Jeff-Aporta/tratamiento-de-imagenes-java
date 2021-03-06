import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class EscalaDeGrises extends javax.swing.JFrame {

    public static void main(String[] args) {
          new EscalaDeGrises() {
              {
                  setSize(800, 600);
                  setLocationRelativeTo(null);
                  setDefaultCloseOperation(EXIT_ON_CLOSE);
                  setExtendedState(MAXIMIZED_BOTH);
                  setVisible(true);
              }
          };
    }

    
    public static BufferedImage Filtro(BufferedImage img) {
        BufferedImage retorno = new BufferedImage(img.getWidth(), img.getHeight(), 2);
        for (int c = 0; c < img.getWidth(); c++) {
            for (int f = 0; f < img.getHeight(); f++) {
                Color color = new Color(img.getRGB(c, f), true);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int a = color.getAlpha();
                int gris = (r + g + b) / 3;
                retorno.setRGB(c, f, new Color(gris, gris, gris, a).getRGB());
            }
        }
        return retorno;
    }

    public static BufferedImage cargarImagen(String ruta) {
        try {
            return ImageIO.read(new File(ruta));
        } catch (Exception e) {
            try {
                return ImageIO.read(new URL(ruta));
            } catch (Exception e2) {
                System.out.println("No se pudo cargar la imágen");
                return null;
            }
        }
    }

    public EscalaDeGrises() {
        initComponents();
        jLabel1.setIcon(
                new ImageIcon(
                        Filtro(
                                cargarImagen("https://i.ibb.co/1z89vCH/image.jpg")
                        )
                )
        );
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);

        pack();
    }

    private javax.swing.JLabel jLabel1;
}
