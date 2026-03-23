package prestamoescolar;

import java.util.ArrayList;
import java.util.Scanner;
import prestamoescolar.modelo.*;

public class Principal {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    registrarPersona();
                    break;
                case 2:
                    registrarMaterial();
                    break;
                case 3:
                    registrarPrestamo();
                    break;
                case 4:
                	PrestamoEscolar.mostrarPersonas();
                    break;
                case 5:
                	PrestamoEscolar.mostrarMateriales();
                    break;
                case 6:
                	PrestamoEscolar.mostrarPrestamos();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ GESTIÓN DE PRÉSTAMOS ===");
        System.out.println("1. Registrar Persona");
        System.out.println("2. Registrar Material");
        System.out.println("3. Registrar Préstamo");
        System.out.println("4. Mostrar Personas");
        System.out.println("5. Mostrar Materiales");
        System.out.println("6. Mostrar Préstamos");
        System.out.println("0. Salir");
        System.out.print("Seleccione opción: ");
    }

    private static void registrarPersona() {
        System.out.println("Tipo de persona:");
        System.out.println("1. Alumno");
        System.out.println("2. Profesor");
        System.out.print("Opción: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Teléfono: ");
        int telefono = sc.nextInt();
        sc.nextLine();

        switch (tipo) {
            case 1:
                System.out.print("Curso: ");
                String curso = sc.nextLine();
                Alumno alumno = new Alumno(nombre, apellido, telefono, curso);
                PrestamoEscolar.registrarPersona(alumno);
                break;
            case 2:
                System.out.print("Código profesor: ");
                int codigo = sc.nextInt();
                sc.nextLine();
                Profesor profesor = new Profesor(nombre, apellido, telefono, codigo);
                PrestamoEscolar.registrarPersona(profesor);
                break;
            default:
                System.out.println("Tipo inválido");
        }
    }

    private static void registrarMaterial() {
        System.out.println("Tipos de material:");
        Tipo[] tipos = Tipo.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ". " + tipos[i]);
        }
        System.out.print("Seleccione tipo: ");
        int tipoIndex = sc.nextInt() - 1;

        System.out.println("Estados de material:");
        Estado[] estados = Estado.values();
        for (int i = 0; i < estados.length; i++) {
            System.out.println((i + 1) + ". " + estados[i]);
        }
        System.out.print("Seleccione estado: ");
        int estadoIndex = sc.nextInt() - 1;
        sc.nextLine();

        if (tipoIndex < 0 || tipoIndex >= tipos.length || estadoIndex < 0 || estadoIndex >= estados.length) {
            System.out.println("Opción inválida");
            return;
        }

        MaterialEscolar material = new MaterialEscolar(tipos[tipoIndex], estados[estadoIndex]);
        PrestamoEscolar.registrarMaterial(material);
    }

    private static void registrarPrestamo() {
        if (PrestamoEscolar.listaPersonas.isEmpty() || PrestamoEscolar.listaMateriales.isEmpty()) {
            System.out.println("Debe haber al menos una persona y un material registrado para hacer un préstamo.");
            return;
        }

        System.out.println("Seleccione persona:");
        for (int i = 0; i < PrestamoEscolar.listaPersonas.size(); i++) {
            System.out.println((i + 1) + ". " + PrestamoEscolar.listaPersonas.get(i));
        }
        System.out.print("Opción: ");
        int personaIndex = sc.nextInt() - 1;
        sc.nextLine();

        if (personaIndex < 0 || personaIndex >= PrestamoEscolar.listaPersonas.size()) {
            System.out.println("Persona inválida");
            return;
        }

        System.out.println("Seleccione material disponible:");
        ArrayList<MaterialEscolar> disponibles = new ArrayList<>();
        for (MaterialEscolar m : PrestamoEscolar.listaMateriales) {
            if (m.getEstado() == Estado.DISPONIBLE) {
                disponibles.add(m);
            }
        }

        if (disponibles.isEmpty()) {
            System.out.println("No hay materiales disponibles");
            return;
        }

        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i));
        }
        System.out.print("Opción: ");
        int materialIndex = sc.nextInt() - 1;
        sc.nextLine();

        if (materialIndex < 0 || materialIndex >= disponibles.size()) {
            System.out.println("Material inválido");
            return;
        }

        Persona persona = PrestamoEscolar.listaPersonas.get(personaIndex);
        MaterialEscolar material = disponibles.get(materialIndex);

        PrestamoEscolar.registrarPrestamo(persona, material);
    }
}