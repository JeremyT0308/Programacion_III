public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private int prioridad;
    private String enfermedad;

    public Paciente(String nombre, int prioridad, String enfermedad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.enfermedad = enfermedad;
    }

    @Override
    public int compareTo(Paciente o) {
        if (this.prioridad < o.prioridad) {
            return -1;
        }else {
            return 1;
        }
        //return this.prioridad - o.prioridad;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", prioridad=" + prioridad + ", enfermedad=" + enfermedad + '\n';
    }
}
