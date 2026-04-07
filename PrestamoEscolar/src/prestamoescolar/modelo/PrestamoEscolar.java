package prestamoescolar.modelo;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class PrestamoEscolar {

    private int diaActual;
    private int mesActual;
    private int anioActual;
    private String curso;
    private int codigoProfesor;

    public void inicializarDatos() {

        Persona.personas.add(new Alumno("Pablo", "Sierra", 123456789, "1ºDAM"));
        Persona.personas.add(new Alumno("Joel", "Esteban", 987654321, "2ºDAM"));

        Persona.personas.add(new Profesor("David", "Arroyo", 111222333, 1));
        Persona.personas.add(new Profesor("Ana", "Martinez", 444555666, 2));

        MaterialEscolar.materiales.add(new MaterialEscolar(Tipo_Material.Ordenadores_Portatiles));
        MaterialEscolar.materiales.add(new MaterialEscolar(Tipo_Material.Tablets));
        MaterialEscolar.materiales.add(new MaterialEscolar(Tipo_Material.Calculadoras));

        Calendar cal = Calendar.getInstance();
        Date fecha = new Date(cal.getTimeInMillis());

        // Prestamos iniciales activos
        TiposDePrestamo p1 = new CortaDuracion(Persona.personas.get(0), MaterialEscolar.materiales.get(0), fecha);
        MaterialEscolar.materiales.get(0).setEstado(Estado_Material.Prestado);
        TiposDePrestamo.prestamos.add(p1);

        TiposDePrestamo p2 = new LargaDuracion(Persona.personas.get(2), MaterialEscolar.materiales.get(1), fecha);
        MaterialEscolar.materiales.get(1).setEstado(Estado_Material.Prestado);
        TiposDePrestamo.prestamos.add(p2);
    }

    public void inicializarFecha() {
        Calendar cal = Calendar.getInstance();
        diaActual = cal.get(Calendar.DAY_OF_MONTH);
        mesActual = cal.get(Calendar.MONTH) + 1;
        anioActual = cal.get(Calendar.YEAR);
    }

    public String getFechaActual() {
        return diaActual + "-" + mesActual + "-" + anioActual;
    }

    public void separar() {
        for (int i = 0; i < 50; i++) System.out.println();
    }

    public void altaPersona(Scanner sc) {

        System.out.println("\n--- ALTA PERSONA ---");
        System.out.println("1. Alumno");
        System.out.println("2. Profesor");

        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        int telefono;
        do {
            System.out.print("Telefono (9 digitos): ");
            telefono = sc.nextInt();
            sc.nextLine();
        } while (telefono < 100000000 || telefono > 999999999);

        if (tipo == 1) {
            System.out.print("Curso: ");
            String curso = sc.nextLine();
            Persona.personas.add(new Alumno(nombre, apellido, telefono, curso));
        } else if (tipo == 2) {
            System.out.print("Codigo profesor: ");
            int codigo = sc.nextInt();
            sc.nextLine();
            Persona.personas.add(new Profesor(nombre, apellido, telefono, codigo));
        }
    }

    public void registrarMaterial(Scanner sc) {

        System.out.println("\n--- REGISTRAR MATERIAL ---");

        System.out.println("1. Portatil");
        System.out.println("2. Tablet");
        System.out.println("3. Calculadora");
        System.out.println("4. Libro Academico");
        System.out.println("5. Material Audiovisual");

        int opcion = sc.nextInt();
        sc.nextLine();

        Tipo_Material tipo = null;

        switch (opcion) {
            case 1: tipo = Tipo_Material.Ordenadores_Portatiles; break;
            case 2: tipo = Tipo_Material.Tablets; break;
            case 3: tipo = Tipo_Material.Calculadoras; break;
            case 4: tipo = Tipo_Material.Libros; break;
            case 5: tipo = Tipo_Material.Material_Audiovisual; break;
            
        }

        if (tipo != null) {
            MaterialEscolar.materiales.add(new MaterialEscolar(tipo));
            System.out.println("Material registrado: " + tipo);
        }
    }

    public void registrarPrestamo(Scanner sc) {

        System.out.println("\n--- REGISTRAR PRESTAMO ---");

        System.out.println("1. Alumno");
        System.out.println("2. Profesor");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        
        int telefono;
        do {
            System.out.print("Telefono (9 digitos): ");
            telefono = sc.nextInt();
            sc.nextLine();
        } while (telefono < 100000000 || telefono > 999999999);
        
        if(tipo==1) {
        	
        	System.out.print("Curso del alumno: ");
            curso = sc.nextLine();
        	
        }else if(tipo==2) {
        	
        	System.out.print("Codigo del profesor: ");
            codigoProfesor = sc.nextInt();
            sc.nextLine();
        	
        }

        Persona personaEncontrada = null;

        for (int i = 0; i < Persona.personas.size(); i++) {
            Persona p = Persona.personas.get(i);
            if (p.getNombre().equalsIgnoreCase(nombre) &&
                p.getApellido().equalsIgnoreCase(apellido) &&
                p.getTelefono() == telefono) {

                if (tipo == 1 && p instanceof Alumno && ((Alumno)p).getCurso().equalsIgnoreCase(curso)) {
                    personaEncontrada = p;
                    break;
                } else if (tipo == 2 && p instanceof Profesor && ((Profesor)p).getCodigoProfesor() == codigoProfesor) {
                    personaEncontrada = p;
                    break;
                }
            }
        }

        if (personaEncontrada == null) {
            System.out.println("Persona no encontrada");
            return;
        }

        ArrayList<MaterialEscolar> disponibles = new ArrayList<>();

        for (int i = 0; i < MaterialEscolar.materiales.size(); i++) {
            MaterialEscolar m = MaterialEscolar.materiales.get(i);
            if (m.isDisponible()) {
                disponibles.add(m);
            }
        }

        if (disponibles.isEmpty()) {
            System.out.println("No hay materiales disponibles");
            return;
        }

        System.out.println("\nMateriales disponibles:");
        for (int i = 0; i < disponibles.size(); i++) {
            System.out.println((i + 1) + ". " + disponibles.get(i));
        }

        int opcion = sc.nextInt();
        sc.nextLine();

        MaterialEscolar material = disponibles.get(opcion - 1);

        System.out.println("1. Larga (30 días)");
        System.out.println("2. Corta (7 días)");
        System.out.println("3. Especial (15 días)");

        int tipoPrestamo = sc.nextInt();
        sc.nextLine();

        Date fecha = new Date(Calendar.getInstance().getTimeInMillis());

        TiposDePrestamo p = null;

        switch (tipoPrestamo) {
            case 1: p = new LargaDuracion(personaEncontrada, material, fecha); break;
            case 2: p = new CortaDuracion(personaEncontrada, material, fecha); break;
            case 3: p = new Especial(personaEncontrada, material, fecha); break;
        }

        if (p != null) {
            TiposDePrestamo.prestamos.add(p);
            material.setEstado(Estado_Material.Prestado);
            System.out.println("Prestamo registrado para: " + personaEncontrada.getNombre() + " " + personaEncontrada.getApellido());
        }
    }

    public void pasarDia() {

        diaActual++;
        if (diaActual > 30) { diaActual = 1; mesActual++; }
        if (mesActual > 12) { mesActual = 1; anioActual++; }

        Calendar cal = Calendar.getInstance();
        cal.set(anioActual, mesActual - 1, diaActual);
        Date fecha = new Date(cal.getTimeInMillis());

        for (int i = 0; i < TiposDePrestamo.prestamos.size(); i++) {

            TiposDePrestamo p = TiposDePrestamo.prestamos.get(i);

            if (p.isActivo() && fecha.after(p.getFechaFinal())) {

                p.setActivo(false);

                MaterialEscolar mat = p.getMaterialEscolar();
                int dias = (int)(Math.random() * 10) + 1;
                mat.setEstado(Estado_Material.En_mantenimiento);
                mat.setDiasMantenimiento(dias);

                System.out.println("El prestamo de " + p.getPersona() +
                        " ha sido devuelto. El material " + mat + " pasa a mantenimiento por " + dias + " dias");
            }
        }

        for (int i = 0; i < MaterialEscolar.materiales.size(); i++) {

            MaterialEscolar m = MaterialEscolar.materiales.get(i);

            if (m.getEstado() == Estado_Material.En_mantenimiento) {
                int dias = m.getDiasMantenimiento() - 1;
                m.setDiasMantenimiento(dias);

                if (dias <= 0) {
                    m.setEstado(Estado_Material.Disponible);
                    System.out.println("Material " + m + " disponible nuevamente");
                }
            }
        }
    }

    public void verPrestamos() {

        System.out.println("\n--- PRESTAMOS ACTIVOS ---");
        for (int i = 0; i < TiposDePrestamo.prestamos.size(); i++) {

            TiposDePrestamo p = TiposDePrestamo.prestamos.get(i);

            if (p.isActivo()) {
                System.out.println(p + " | Dias restantes: " + p.diasRestantes(new Date(Calendar.getInstance().getTimeInMillis())));
            }
        }

        System.out.println("\n--- PRESTAMOS FINALIZADOS ---");
        for (int i = 0; i < TiposDePrestamo.prestamos.size(); i++) {

            TiposDePrestamo p = TiposDePrestamo.prestamos.get(i);

            if (!p.isActivo()) {
                System.out.println(p + " | Duracion total: " + p.getDuracionMaxima() + " dias");
            }
        }
    }

    public void verMateriales() {

        System.out.println("\n--- ESTADO DE MATERIALES ---");

        for (int i = 0; i < MaterialEscolar.materiales.size(); i++) {

            MaterialEscolar m = MaterialEscolar.materiales.get(i);
            String info = m.toString();

            if (m.getEstado() == Estado_Material.Prestado) {
                for (int j = 0; j < TiposDePrestamo.prestamos.size(); j++) {

                    TiposDePrestamo p = TiposDePrestamo.prestamos.get(j);

                    if (p.getMaterialEscolar() == m && p.isActivo()) {
                        info += " | Prestado a: " + p.getPersona() + " | Dias restantes: " + p.diasRestantes(new Date(Calendar.getInstance().getTimeInMillis()));
                        break;
                    }
                }
            } else if (m.getEstado() == Estado_Material.En_mantenimiento) {
                info += " | Dias restantes de mantenimiento: " + m.getDiasMantenimiento();
            }

            System.out.println(info);
        }
    }
}