public class VideoJuego {
    private String titulo;
    private int edadRecomendada;

    public VideoJuego(String titulo, int edadRecomendada) {
        this.titulo = titulo;
        this.edadRecomendada = edadRecomendada;
    }

    public VideoJuego(int edadRecomendada, String t) {
        this.edadRecomendada = edadRecomendada;
        titulo = t;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    @Override
    public String toString() {
        return "VideoJuego: " + "titulo: " + titulo + '\'' + ", edadRecomendada: " + edadRecomendada;
    }
}
