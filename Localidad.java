public class Localidad {
    private String nombre;
    private int totalTickets;
    private int precio;
    private int ticketsVendidos;

    public Localidad(String nombre, int totalTickets, int precio){
        this.nombre = nombre;
        this.totalTickets = totalTickets;
        this.precio = precio;
        this.ticketsVendidos = 0;
    }

    public void agregarTicketsVendidos(int ticketsVendidos){
        this.ticketsVendidos += ticketsVendidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTicketsVendidos() {
        return ticketsVendidos;
    }

    public void setTicketsVendidos(int ticketsVendidos) {
        this.ticketsVendidos = ticketsVendidos;
    }

    public void mostrarDisponibilidad(){
        int libres = this.totalTickets - this.ticketsVendidos;
        System.out.println("La localidad: "+this.nombre);
        System.out.println("Espacios vendidos: "+this.ticketsVendidos + ", espacios libres: " + libres);
    }
    public int reporteCaja(){
        int totalVendido = this.ticketsVendidos * this.precio;
        System.out.println(this.nombre + " se ha vendido $"+totalVendido);
        return  totalVendido;
    }
}

