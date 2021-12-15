import java.util.ArrayList;

public class Album {

    private ArrayList<Cancion> canciones;

    public Album(ArrayList<Cancion> canciones){
        this.canciones = canciones;
    }

    public Album(){
        this.canciones = new ArrayList<>();
    }

    public void aniadirCancion(Cancion cancion){
        canciones.add(cancion);
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

}