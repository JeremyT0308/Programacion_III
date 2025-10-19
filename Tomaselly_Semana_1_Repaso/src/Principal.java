import java.sql.SQLOutput;

public class Principal {

    public static void main(String[] args) {
        VideoJuego v1;
        VideoJuego v2 = new VideoJuego(12, "VideoJuego");
        VideoJuego v3 = new VideoJuego(13, "VideoJuego");

        v1=v3;

        if (v1.equals(v2)) {
            System.out.println("Son iguales");
        }else {
            System.out.println("No iguales");
            System.out.println("v1 "+v1.hashCode());
            System.out.println("v2 "+v2.hashCode());
        }
        if (v1.equals(v3)) {
            System.out.println("Son iguales");
        }

        String n1 = new String("Prueba");
        String n2 = new String("Prueba");

        if (n1.equals(n2)) {
            System.out.println("Son iguales");
            System.out.println("n1 "+n1.hashCode());
            System.out.println("n2 "+n2.hashCode());
        }
        n2 = null;
        System.out.println(n2);
        n2.hashCode();
    }

}
