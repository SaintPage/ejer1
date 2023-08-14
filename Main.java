import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        Comprador comprador = new Comprador();
        Localidad localidad1 = new Localidad("Localidad 1", 20, 100);
        Localidad localidad5 = new Localidad("Localidad 5", 20, 500);
        Localidad localidad10 = new Localidad("Localidad 10", 20, 1000);
        while(!salir){
            mostrarMenu();
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i){
                case 1:
                    comprador =  nuevComprador();
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad de boletos a comprar");
                    int boletosCant = sc.nextInt();
                    System.out.println("Ingrese el presupuesto maximo");
                    int presupuesto = sc.nextInt();
                    if(validarTicket()){
                        Random rand = new Random();
                        int localidadRandom = rand.nextInt(3);
                        if(localidadRandom == 0){
                            //localidad 1
                            int tickets = validarCompra(localidad1, boletosCant, presupuesto);
                            if(tickets > 0){
                                localidad1.agregarTicketsVendidos(tickets);
                                System.out.println("################");
                                System.out.println(tickets +" tickets vendidos a "+localidad1.getNombre());
                                System.out.println("################");
                            }
                        } else if (localidadRandom == 1) {
                            //localidad 5
                            int tickets = validarCompra(localidad5, boletosCant, presupuesto);
                            if(tickets > 0){
                                localidad5.agregarTicketsVendidos(tickets);
                                System.out.println("################");
                                System.out.println(tickets +" tickets vendidos a "+localidad5.getNombre());
                                System.out.println("################");
                            }
                        }else {
                            //localidad 10
                            int tickets = validarCompra(localidad10, boletosCant, presupuesto);
                            if(tickets > 0){
                                localidad10.agregarTicketsVendidos(tickets);
                                System.out.println("################");
                                System.out.println(tickets +" tickets vendidos a "+localidad10.getNombre());
                                System.out.println("################");
                            }
                        }
                    }
                    else{
                        System.out.println("El ticket no esta dentro del rango permitido");
                    }
                    break;
                case 3:
                    localidad1.mostrarDisponibilidad();
                    localidad5.mostrarDisponibilidad();
                    localidad10.mostrarDisponibilidad();
                    break;
                case 4:
                    System.out.println("Ingrese la localidad a validar");
                    String lugar = sc.nextLine();
                    if(lugar.toLowerCase().equals(localidad1.getNombre().toLowerCase())){
                        localidad1.mostrarDisponibilidad();
                    } else if (lugar.toLowerCase().equals(localidad5.getNombre().toLowerCase())) {
                        localidad5.mostrarDisponibilidad();
                    } else if (lugar.toLowerCase().equals(localidad10.getNombre().toLowerCase())) {
                        localidad10.mostrarDisponibilidad();
                    }
                    break;
                case 5:
                    int total = localidad1.reporteCaja();
                    total += localidad5.reporteCaja();
                    total += localidad10.reporteCaja();
                    System.out.println("El total es de $"+total);
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("OPCION NO VALIDA");
            }
            System.out.println("-----------------------------");
        }
    }

    public static Comprador nuevComprador(){
        Scanner scc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del comprador");
        String nombre = scc.next();
        System.out.println("Ingrese el email del comprador");
        String email = scc.next();
        Comprador comprador = new Comprador();
        comprador.setEmail(email);
        comprador.setNombre(nombre);
        return  comprador;
    }
    public static void mostrarMenu(){
        System.out.println("Elija una opcion");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
    }

    public static boolean validarTicket(){
        Random rand = new Random();
        int limite = 15000;
        int ticket = rand.nextInt(limite) + 1;
        int rangoA = rand.nextInt(limite) + 1;
        int rangoB = rand.nextInt(limite) + 1;
        System.out.println("ticket:"+ticket + " rangoA:"+rangoA + " rangoB:"+rangoB);
        if (rangoA > rangoB){
            return rangoA > ticket && ticket > rangoB;
        }
        else {
            return rangoB > ticket && ticket > rangoA;
        }
    }

    public static int validarCompra(Localidad localidad, int boletos, int presupuesto){
        int espaciosDisponibles = localidad.getTotalTickets() - localidad.getTicketsVendidos();
        int espaciosVendidos = boletos;
        if( espaciosDisponibles == 0){
            return -1;
        }

        if (espaciosDisponibles < boletos){
            espaciosVendidos = espaciosDisponibles;
        }

        if(espaciosVendidos * localidad.getPrecio() > presupuesto){
            System.out.println("El valor de los tickets supera el presupuesto!!");
            return -1;
        }

        return espaciosVendidos;
    }
}