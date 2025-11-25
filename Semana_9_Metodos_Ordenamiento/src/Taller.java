import java.util.ArrayList;
import java.util.List;

public class Taller {
    private List<Motocicleta> taller;

    public Taller() {
        taller = new ArrayList<>();
        predefinir();
    }

    private void predefinir() {
        taller.add(new Motocicleta(1, "BMW", 200, 2000, 1500f));
        taller.add(new Motocicleta(22, "Suzuki", 230, 1000, 1143500f));
        taller.add(new Motocicleta(13, "Honda", 250, 1230, 1600f));
        taller.add(new Motocicleta(45, "Ducatti", 310, 1760, 134500f));
        taller.add(new Motocicleta(25, "Yamaha", 850, 124560, 1352500f));
    }

    public void agregar(Motocicleta moto) {
        taller.add(moto);
    }

    public void ordenarId() {
        Motocicleta aux;
        for (int i = 0; i < taller.size()-1; i++) {
            for (int j = i+1; j < taller.size(); j++) {
                if (taller.get(i).getCodigo() > taller.get(j).getCodigo()) {
                    aux = taller.get(i);
                    taller.set(i, taller.get(j));
                    taller.set(j, aux);
                }
            }

        }
    }

    public void ordenarPrecio(){
        Motocicleta aux;
        int j;
        for (int i = 1; i < taller.size(); i++) {
            aux = taller.get(i);
            j = i - 1;
            while (j >= 0 && taller.get(j).getPrecio() > aux.getPrecio()) {
                taller.set(j + 1, taller.get(j));
                j--;
            }
            taller.set(j + 1, aux);
        }
    }

    public List<Motocicleta> getTaller() {
        return taller;
    }
}
