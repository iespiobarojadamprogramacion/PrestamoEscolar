package prestamoescolar.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class PrestamoEscolar {

    private int diaActual;
    private int mesActual;
    private int anioActual;

    // ================= INICIALIZAR =================

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

    // ================= ALTA PERSONA =================

    public String altaPersona(int tipo, String nombre, String apellido, int telefono, String curso, int codigo) {

        if (tipo == 1) {
            Persona.personas.add(new Alumno(nombre, apellido, telefono, curso));
            return "Alumno registrado correctamente";
        } else if (tipo == 2) {
            Persona.personas.add(new Profesor(nombre, apellido, telefono, codigo));
            return "Profesor registrado correctamente";
        }

        return "Error al registrar persona";
    }

    // ================= REGISTRAR MATERIAL =================

    public String registrarMaterial(int opcion) {

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
            return "Material registrado: " + tipo;
        }

        return "Opcion invalida";
    }

    // ================= MOSTRAR MATERIALES DISPONIBLES =================

    public String mostrarMaterialesDisponibles() {

        String resultado = "\n--- MATERIALES DISPONIBLES ---\n";

        int contador = 1;

        for (MaterialEscolar m : MaterialEscolar.materiales) {
            if (m.isDisponible()) {
                resultado += contador + ". " + m + "\n";
                contador++;
            }
        }

        if (contador == 1) {
            return "No hay materiales disponibles";
        }

        return resultado;
    }

    // ================= REGISTRAR PRESTAMO =================

    public String registrarPrestamo(int tipo, String nombre, String apellido, int telefono,
                                   String curso, int codigo, int indexMaterial, int tipoPrestamo) {

        Persona personaEncontrada = null;

        for (Persona p : Persona.personas) {

            if (p.getNombre().equalsIgnoreCase(nombre) &&
                p.getApellido().equalsIgnoreCase(apellido) &&
                p.getTelefono() == telefono) {

                if (tipo == 1 && p instanceof Alumno &&
                    ((Alumno)p).getCurso().equalsIgnoreCase(curso)) {

                    personaEncontrada = p;
                }

                if (tipo == 2 && p instanceof Profesor &&
                    ((Profesor)p).getCodigoProfesor() == codigo) {

                    personaEncontrada = p;
                }
            }
        }

        if (personaEncontrada == null) {
            return "Persona no encontrada";
        }

        ArrayList<MaterialEscolar> disponibles = new ArrayList<>();

        for (MaterialEscolar m : MaterialEscolar.materiales) {
            if (m.isDisponible()) {
                disponibles.add(m);
            }
        }

        if (disponibles.isEmpty()) {
            return "No hay materiales disponibles";
        }

        if (indexMaterial <= 0 || indexMaterial > disponibles.size()) {
            return "Material invalido";
        }

        MaterialEscolar material = disponibles.get(indexMaterial - 1);

        Date fecha = new Date(System.currentTimeMillis());

        TiposDePrestamo p = null;

        switch (tipoPrestamo) {
            case 1: p = new LargaDuracion(personaEncontrada, material, fecha); break;
            case 2: p = new CortaDuracion(personaEncontrada, material, fecha); break;
            case 3: p = new Especial(personaEncontrada, material, fecha); break;
        }

        if (p == null) return "Tipo de prestamo invalido";

        TiposDePrestamo.prestamos.add(p);
        material.setEstado(Estado_Material.Prestado);

        return "Prestamo registrado correctamente a " +
                personaEncontrada.getNombre() + " " + personaEncontrada.getApellido();
    }

    // ================= PASAR DIA =================

    public String pasarDia() {

        diaActual++;
        if (diaActual > 30) { diaActual = 1; mesActual++; }
        if (mesActual > 12) { mesActual = 1; anioActual++; }

        Calendar cal = Calendar.getInstance();
        cal.set(anioActual, mesActual - 1, diaActual);
        Date fecha = new Date(cal.getTimeInMillis());

        String resultado = "Fecha actual: " + getFechaActual() + "\n";

        for (TiposDePrestamo p : TiposDePrestamo.prestamos) {

            if (p.isActivo() && fecha.after(p.getFechaFinal())) {

                p.setActivo(false);

                MaterialEscolar mat = p.getMaterialEscolar();
                int dias = (int)(Math.random() * 10) + 1;

                mat.setEstado(Estado_Material.En_mantenimiento);
                mat.setDiasMantenimiento(dias);

                resultado += "Prestamo finalizado de " + p.getPersona() +
                        ". Material en mantenimiento (" + dias + " dias)\n";
            }
        }

        for (MaterialEscolar m : MaterialEscolar.materiales) {

            if (m.getEstado() == Estado_Material.En_mantenimiento) {

                int dias = m.getDiasMantenimiento() - 1;
                m.setDiasMantenimiento(dias);

                if (dias <= 0) {
                    m.setEstado(Estado_Material.Disponible);
                    resultado += "Material disponible nuevamente: " + m + "\n";
                }
            }
        }

        return resultado;
    }

    // ================= VER PRESTAMOS =================

    public String verPrestamos() {

        String res = "\n--- PRESTAMOS ACTIVOS ---\n";

        for (TiposDePrestamo p : TiposDePrestamo.prestamos) {
            if (p.isActivo()) {
                res += p + "\n";
            }
        }

        res += "\n--- PRESTAMOS FINALIZADOS ---\n";

        for (TiposDePrestamo p : TiposDePrestamo.prestamos) {
            if (!p.isActivo()) {
                res += p + "\n";
            }
        }

        return res;
    }

    // ================= VER MATERIALES =================

    public String verMateriales() {

        String res = "\n--- ESTADO DE MATERIALES ---\n";

        for (MaterialEscolar m : MaterialEscolar.materiales) {

            String info = m.toString();

            if (m.getEstado() == Estado_Material.Prestado) {

                for (TiposDePrestamo p : TiposDePrestamo.prestamos) {

                    if (p.getMaterialEscolar() == m && p.isActivo()) {
                        info += " | Prestado a: " + p.getPersona();
                        break;
                    }
                }

            } else if (m.getEstado() == Estado_Material.En_mantenimiento) {

                info += " | Dias mantenimiento: " + m.getDiasMantenimiento();
            }

            res += info + "\n";
        }

        return res;
    }
}