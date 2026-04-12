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
            System.out.println("1. Dar de alta persona");
            System.out.println("2. Registrar material");
            System.out.println("3. Registrar prestamo");
            System.out.println("8. Pasar dia");
            System.out.println("9. Ver prestamos");
            System.out.println("10. Ver materiales");
            System.out.println("0. Salir");

            System.out.print("👉 Opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("1. Alumno | 2. Profesor");
                    int tipo = sc.nextInt(); sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    System.out.print("Telefono: ");
                    int telefono = sc.nextInt(); sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Curso: ");
                        String curso = sc.nextLine();
                        System.out.println(app.altaPersona(tipo, nombre, apellido, telefono, curso, 0));
                    } else {
                        System.out.print("Codigo profesor: ");
                        int codigo = sc.nextInt(); sc.nextLine();
                        System.out.println(app.altaPersona(tipo, nombre, apellido, telefono, null, codigo));
                    }
                    break;

                case 2:
                    System.out.println("1.Portatil 2.Tablet 3.Calculadora 4.Libro 5.Audiovisual");
                    int tipoMat = sc.nextInt(); sc.nextLine();
                    System.out.println(app.registrarMaterial(tipoMat));
                    break;

                case 3:
                    System.out.println("1.Alumno 2.Profesor");
                    int tipoP = sc.nextInt(); sc.nextLine();

                    System.out.print("Nombre: ");
                    String n = sc.nextLine();

                    System.out.print("Apellido: ");
                    String a = sc.nextLine();

                    System.out.print("Telefono: ");
                    int t = sc.nextInt(); sc.nextLine();

                    String curso = null;
                    int codigo = 0;

                    if (tipoP == 1) {
                        System.out.print("Curso: ");
                        curso = sc.nextLine();
                    } else {
                        System.out.print("Codigo profesor: ");
                        codigo = sc.nextInt(); sc.nextLine();
                    }

                    System.out.println(app.mostrarMaterialesDisponibles());

                    int indexMaterial = sc.nextInt(); sc.nextLine();

                    System.out.println("1.Larga 2.Corta 3.Especial");
                    int tipoPrestamo = sc.nextInt(); sc.nextLine();

                    System.out.println(app.registrarPrestamo(
                            tipoP, n, a, t, curso, codigo,
                            indexMaterial, tipoPrestamo));
                    break;

                case 8:
                    System.out.println(app.pasarDia());
                    break;

                case 9:
                    System.out.println(app.verPrestamos());
                    break;

                case 10:
                    System.out.println(app.verMateriales());
                    break;

                case 0:
                    salir = true;
                    break;
            }
        }
        sc.close();
    }
}