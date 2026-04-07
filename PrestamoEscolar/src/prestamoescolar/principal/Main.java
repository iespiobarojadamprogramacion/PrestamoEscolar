package prestamoescolar.principal;
import prestamoescolar.modelo.*;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrestamoEscolar app = new PrestamoEscolar();


        app.inicializarDatos();
        app.inicializarFecha();

        boolean salir = false;

        while (!salir) {
        	


           

            System.out.println("\n📚 --- SISTEMA DE PRESTAMOS ESCOLARES --- 📚");
            System.out.println("📅 Fecha actual: " + app.getFechaActual());
            System.out.println("────────────────────────────");
            System.out.println("1️.  Dar de alta persona");
            System.out.println("2️.  Registrar material");
            System.out.println("3️.  Registrar prestamo");
            System.out.println("8️.  Pasar dia");
            System.out.println("9️.  Ver prestamos");
            System.out.println("10. Ver materiales");
            System.out.println("0.  Salir");
            System.out.println("────────────────────────────");

            System.out.print("👉 Opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();


            switch (opcion) {

                case 1:
                	 app.separar();
                    System.out.println("\n👤 Has seleccionado dar de alta persona");
                    app.altaPersona(sc);
                    break;

                case 2:
                	 app.separar();
                    System.out.println("\n📦 Has seleccionado registrar material");
                    app.registrarMaterial(sc);
                   
                    break;

                case 3:
                	 app.separar();
                    System.out.println("\n📚 Has seleccionado registrar prestamo");
                    app.registrarPrestamo(sc);
                   
                    break;

                case 8:
                	 app.separar();
                    System.out.println("\n⏩ Avanzando un dia...");
                    app.pasarDia();
               
                    break;

                case 9:
                	 app.separar();
                    app.verPrestamos();
                   
                    break;

                case 10:
                	 app.separar();
                    app.verMateriales();
                  
                    break;

                case 0:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }

        sc.close();
    }
}