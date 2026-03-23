package prestamoescolar.modelo;

import java.util.ArrayList;

import prestamoescolar.modelo.*;

public class PrestamoEscolar {

    public static ArrayList<Persona> listaPersonas = new ArrayList<>();
    public static ArrayList<MaterialEscolar> listaMateriales = new ArrayList<>();
    public static ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    // Registrar persona (Alumno o Profesor)
    public static void registrarPersona(Persona persona) {
        listaPersonas.add(persona);
        System.out.println("Persona registrada: " + persona);
    }

    // Registrar material escolar
    public static void registrarMaterial(MaterialEscolar material) {
        listaMateriales.add(material);
        System.out.println("Material registrado: " + material);
    }

    // Registrar préstamo si la persona y material existen y material está disponible
    public static void registrarPrestamo(Persona persona, MaterialEscolar material) {
        if (!listaPersonas.contains(persona)) {
            System.out.println("La persona no está registrada.");
            return;
        }
        if (!listaMateriales.contains(material)) {
            System.out.println("El material no está registrado.");
            return;
        }
        if (material.getEstado() != Estado.DISPONIBLE) {
            System.out.println("El material no está disponible.");
            return;
        }
        material.setEstado(Estado.PRESTADO);
        Prestamo prestamo = new Prestamo(persona, material);
        listaPrestamos.add(prestamo);
        System.out.println("Préstamo registrado: " + prestamo);
    }

    // Mostrar todas las personas registradas
    public static void mostrarPersonas() {
        System.out.println("=== Personas Registradas ===");
        for (Persona p : listaPersonas) {
            System.out.println(p);
        }
    }

    // Mostrar todos los materiales registrados
    public static void mostrarMateriales() {
        System.out.println("=== Materiales Registrados ===");
        for (MaterialEscolar m : listaMateriales) {
            System.out.println(m);
        }
    }

    // Mostrar todos los préstamos activos
    public static void mostrarPrestamos() {
        System.out.println("=== Préstamos Activos ===");
        if (listaPrestamos.isEmpty()) {
            System.out.println("No hay préstamos activos.");
            return;
        }
        for (Prestamo p : listaPrestamos) {
            System.out.println(p);
        }
    }

    // Clase interna Prestamo
    public static class Prestamo {
        private Persona persona;
        private MaterialEscolar material;

        public Prestamo(Persona persona, MaterialEscolar material) {
            this.persona = persona;
            this.material = material;
        }

        @Override
        public String toString() {
            return persona.getNombre() + " " + persona.getApellido() +
                   " | Material: " + material.getTipo() +
                   " | Código: " + material.getCodigo();
        }
    }
}