public class Comprador {
    private String nombre;
    private String email;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    @Override
    public String toString() {
        return "El nombre es: "+this.nombre + " y el correo: "+this.email;
    }
}
