import java.util.LinkedList;
import java.util.Queue;

public class ColaAutos {
    private Queue<Auto> cola;

    public ColaAutos() {
        cola = new LinkedList<>();
    }

    public void encolar(Auto auto) {
        cola.add(auto);
    }

    public Auto desencolar() throws Exception {
        if (cola.isEmpty()) {
            throw new Exception("Cola sin auto");
        }
        return cola.remove();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Auto auto : cola) {
            sb.append(auto+"\n");
        }
        return sb.toString();
    }

}
