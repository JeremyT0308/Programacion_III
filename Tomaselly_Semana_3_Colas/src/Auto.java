public class Auto {
    private String placa;
    private String marca;
    private String modelo;
    private int anio;

    public Auto(String placa, String marca, String modelo, int anio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "AUTO" + " placa: " + placa +" marca: " + marca + " modelo: " + modelo + " año: " + anio;
    }
}
