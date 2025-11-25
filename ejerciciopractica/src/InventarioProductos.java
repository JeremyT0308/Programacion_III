import java.util.ArrayList;
import java.util.List;

public class InventarioProductos {
    private List<Producto> inventario;

    public InventarioProductos() {
        inventario = new ArrayList<Producto>();
        predefinir();
    }

    public void predefinir() {
        inventario.add(new Producto(1,"bmw",2.5));
        inventario.add(new Producto(20,"suzuki",1.5));
        inventario.add(new Producto(15,"honda",5));
        inventario.add(new Producto(11,"yamaha",30));
        inventario.add(new Producto(18,"ducati",20));
    }

    public void agregar(Producto producto) {
        inventario.add(producto);
    }

    public boolean idExiste(int id) {
        for (Producto p : inventario) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void ordenarID(){
        Producto aux;
        for(int i = 0; i < inventario.size() - 1 ; i++){
            for (int j = i + 1; j < inventario.size(); j++){
                if(inventario.get(i).getId() > inventario.get(j).getId()){
                    aux = inventario.get(i);
                    inventario.set(i, inventario.get(j));
                    inventario.set(j, aux);
                }
            }
        }
    }
    public void ordenarPrecio(){
        Producto aux;
        for(int i = 0; i < inventario.size() - 1 ; i++){
            for (int j = i + 1; j < inventario.size(); j++){
                if(inventario.get(i).getPrecio() < inventario.get(j).getPrecio()){
                    aux = inventario.get(i);
                    inventario.set(i, inventario.get(j));
                    inventario.set(j, aux);
                }
            }
        }
    }
    public Producto buscarPorNombre(String nombre) {
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public Producto buscar(int id) {
        int i=0;
        int s=inventario.size()-1;
        int c;
        while(i<=s){
            c=(i+s)/2;
            if(id==inventario.get(c).getId()){
                return inventario.get(c);
            }else if(id<inventario.get(c).getId()){
                s=c-1;
            }else{
                i=c+1;
            }
        }
        return null;

    }

    public List<Producto> getInventario() {
        return inventario;
    }




}
