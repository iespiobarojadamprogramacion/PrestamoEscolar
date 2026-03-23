package prestamoescolar.principal;

import prestamoescolar.modelo.*;
import java.util.Scanner;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Fecha del sistema
        Calendar cal = Calendar.getInstance();
        int diaActual = cal.get(Calendar.DAY_OF_MONTH);
        int mesActual = cal.get(Calendar.MONTH) + 1; // OJO: Calendar.MONTH va de 0 a 11
        int anioActual = cal.get(Calendar.YEAR);

        boolean salir = false;
        int opcion;

        while (!salir) {

            // Menú principal
            System.out.println("\n--- SISTEMA DE PRÉSTAMOS ESCOLARES ---");
            System.out.println("Fecha actual: " + diaActual + "/" + mesActual + "/" + anioActual);
            System.out.println("1. Dar de alta persona");
            System.out.println("2. Registrar material");
            System.out.println("3. Registrar préstamo");
            System.out.println("8. Pasar día");
            System.out.println("9. Consultar historial de préstamos");
            System.out.println("10. Consultar historial de material");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // ===== 1: Dar de alta persona =====
                case 1:
                    System.out.println("\nAlta de persona:");
                    System.out.println("1. Alumno");
                    System.out.println("2. Profesor");
                    int tipoPersona = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    int telefono;
                    do {
                        System.out.print("Teléfono (9 dígitos): ");
                        telefono = sc.nextInt();
                        sc.nextLine();
                    } while (telefono < 100000000 || telefono > 999999999);

                    switch (tipoPersona) {
                        case 1:
                            System.out.print("Curso: ");
                            String curso = sc.nextLine();
                            Persona.personas.add(new Alumno(nombre, apellido, telefono, curso));
                            System.out.println("✅ Alumno añadido");
                            break;
                        case 2:
                            System.out.print("Código profesor: ");
                            int codigo = sc.nextInt();
                            sc.nextLine();
                            Persona.personas.add(new Profesor(nombre, apellido, telefono, codigo));
                            System.out.println("✅ Profesor añadido");
                            break;
                        default:
                            System.out.println("❌ Opción no válida");
                    }
                    break;

                // ===== 2: Registrar material =====
                case 2:
                    // ===== REGISTRAR MATERIAL =====
                    System.out.println("\n--- REGISTRAR MATERIAL ---");
                    
                    // Menú de tipos de material
                    String menuMateriales = "\nTipos de material:\n" +
                                            "1. Ordenadores_Portatiles\n" +
                                            "2. Tablets\n" +
                                            "3. Calculadoras\n" +
                                            "4. Libros\n" +
                                            "5. Material_Audiovisual\n" +
                                            "0. Cancelar\n" +
                                            "Elige el tipo de material: ";
                    
                    int opcionMat;
                    do {
                        System.out.print(menuMateriales);
                        opcionMat = sc.nextInt();
                        sc.nextLine();
                        switch (opcionMat) {
                            case 1:
                                MaterialEscolar.materiales.add(new MaterialEscolar("Ordenador Portátil"));
                                System.out.println("✅ Ordenador portátil añadido");
                                break;
                            case 2:
                                MaterialEscolar.materiales.add(new MaterialEscolar("Tablet"));
                                System.out.println("✅ Tablet añadida");
                                break;
                            case 3:
                                MaterialEscolar.materiales.add(new MaterialEscolar("Calculadora"));
                                System.out.println("✅ Calculadora añadida");
                                break;
                            case 4:
                                MaterialEscolar.materiales.add(new MaterialEscolar("Libro"));
                                System.out.println("✅ Libro añadido");
                                break;
                            case 5:
                                MaterialEscolar.materiales.add(new MaterialEscolar("Material Audiovisual"));
                                System.out.println("✅ Material audiovisual añadido");
                                break;
                            case 0:
                                System.out.println("Cancelado");
                                break;
                            default:
                                System.out.println("❌ Opción no válida");
                        }
                    } while (opcionMat != 0);
                    break;

                // ===== 3: Registrar préstamo =====
                case 3:
                	System.out.println("\n--- REGISTRAR PRÉSTAMO ---");

                	// Selección de persona
                	System.out.println("¿Para quién es el préstamo?");
                	System.out.println("1. Alumno");
                	System.out.println("2. Profesor");
                	int tipoPer = sc.nextInt();
                	sc.nextLine();

                	System.out.print("Nombre: ");
                	String nombreBus = sc.nextLine();
                	System.out.print("Apellido: ");
                	String apellidoBus = sc.nextLine();

                	String curso = null;
                	Integer codigoProfesor = null;

                	Persona personaEncontrada = null;
                	for (Persona p : Persona.personas) {
                	    if (p.getNombre().equalsIgnoreCase(nombreBus) &&
                	        p.getApellido().equalsIgnoreCase(apellidoBus)) {
                	        if ((tipoPer == 1 && p instanceof Alumno) ||
                	            (tipoPer == 2 && p instanceof Profesor)) {
                	            personaEncontrada = p;

                	            // Pedir curso o código si no está definido
                	            if (p instanceof Alumno) {
                	                System.out.print("Curso del alumno: ");
                	                curso = sc.nextLine();
                	                ((Alumno) p).setCurso(curso);
                	            } else if (p instanceof Profesor) {
                	                System.out.print("Código del profesor: ");
                	                codigoProfesor = sc.nextInt();
                	                sc.nextLine();
                	                ((Profesor) p).setCodigoProfesor(codigoProfesor);
                	            }

                	            break;
                	        }
                	    }
                	}

                	if (personaEncontrada == null) {
                	    System.out.println("❌ Persona no encontrada");
                	    break;
                	}

                	// 2️⃣ Mostrar materiales disponibles y elegir
                	ArrayList<MaterialEscolar> disponibles = new ArrayList<>();
                	for (MaterialEscolar m : MaterialEscolar.materiales) {
                	    if (m.isDisponible()) {
                	        disponibles.add(m);
                	    }
                	}

                	if (disponibles.isEmpty()) {
                	    System.out.println("❌ No hay materiales disponibles");
                	    break;
                	}

                	System.out.println("\nMateriales disponibles:");
                	for (int i = 0; i < disponibles.size(); i++) {
                	    System.out.println((i + 1) + ". " + disponibles.get(i).getNombre());
                	}
                	System.out.print("Elige un material (opción número): ");
                	opcionMat = sc.nextInt();
                	sc.nextLine();

                	if (opcionMat < 1 || opcionMat > disponibles.size()) {
                	    System.out.println("❌ Opción inválida");
                	    break;
                	}

                	MaterialEscolar materialSeleccionado = disponibles.get(opcionMat - 1);

                	// 3️⃣ Elegir tipo de préstamo
                	System.out.println("\nTipo de préstamo:");
                	System.out.println("1. Larga duración (30 días)");
                	System.out.println("2. Corta duración (7 días)");
                	System.out.println("3. Especial (15 días)");
                	int opcionPrest = sc.nextInt();
                	sc.nextLine();

                	// Fecha inicio
                	cal = Calendar.getInstance();
                	Date fechaInicio = new Date(cal.getTimeInMillis());

                	Prestamos prestamo = null;
                	switch (opcionPrest) {
                	    case 1:
                	        prestamo = new LargaDuracion(personaEncontrada, materialSeleccionado, fechaInicio);
                	        break;
                	    case 2:
                	        prestamo = new CortaDuracion(personaEncontrada, materialSeleccionado, fechaInicio);
                	        break;
                	    case 3:
                	        prestamo = new Especial(personaEncontrada, materialSeleccionado, fechaInicio);
                	        break;
                	    default:
                	        System.out.println("❌ Opción no válida");
                	        break;
                	}

                	if (prestamo != null) {
                	    Prestamos.prestamos.add(prestamo);
                	    materialSeleccionado.setEstado(MaterialEscolar.EstadoMaterial.EN_PRESTAMO);
                	    System.out.println("✅ Préstamo registrado:");
                	    System.out.println(prestamo);
                	}
                	
                	break;
                // ===== 8: Pasar día =====
                case 8:
                    // ===== PASAR DÍA =====
                    // Avanzar un día
                    diaActual++;
                    if (diaActual > 30) { // suponiendo meses de 30 días
                        diaActual = 1;
                        mesActual++;
                    }
                    if (mesActual > 12) {
                        mesActual = 1;
                        anioActual++;
                    }

                    // Crear fecha actual del "sistema" para comparación
                    Calendar calActual = Calendar.getInstance();
                    calActual.set(anioActual, mesActual - 1, diaActual); // mes-1 porque Calendar usa 0-11
                    Date fechaActual = new Date(calActual.getTimeInMillis());

                    // 1️⃣ Revisar préstamos
                    for (Prestamos p : Prestamos.prestamos) {
                        if (p.isActivo() && fechaActual.after(p.getFechaFinal())) {
                            p.setActivo(false); // préstamo finalizado
                            MaterialEscolar mat = p.getMaterialEscolar();
                            mat.setEstado(MaterialEscolar.EstadoMaterial.EN_MANTENIMIENTO);
                            mat.setDiasMantenimiento(2); // 2 días de mantenimiento
                            System.out.println("⚠️ Préstamo finalizado: " + p);
                        }
                    }

                    // 2️⃣ Actualizar materiales en mantenimiento
                    for (MaterialEscolar m : MaterialEscolar.materiales) {
                        if (m.getEstado() == MaterialEscolar.EstadoMaterial.EN_MANTENIMIENTO) {
                            int dias = m.getDiasMantenimiento() - 1;
                            m.setDiasMantenimiento(dias);
                            if (dias <= 0) {
                                m.setEstado(MaterialEscolar.EstadoMaterial.DISPONIBLE);
                                System.out.println("✅ Material disponible: " + m.getNombre());
                            }
                        }
                    }

                    System.out.println("📅 Día avanzado: " + diaActual + "/" + mesActual + "/" + anioActual);
                    break;

                // ===== 9: Consultar historial =====
                case 9:
                    System.out.println("\n--- PRÉSTAMOS ACTIVOS ---");
                    for (Prestamos p : Prestamos.prestamos) {
                        if (p.isActivo()) System.out.println(p);
                    }
                    System.out.println("\n--- PRÉSTAMOS ANTERIORES ---");
                    for (Prestamos p : Prestamos.prestamos) {
                        if (!p.isActivo()) System.out.println(p);
                    }
                    break;
                    
                case 10:
                    System.out.println("\n--- HISTORIAL DE MATERIALES ---");
                    for (MaterialEscolar m : MaterialEscolar.materiales) {
                        String info = "Material: " + m.getNombre() + " | Estado: " + m.getEstado();

                        if (m.getEstado() == MaterialEscolar.EstadoMaterial.EN_PRESTAMO) {
                            // Buscar préstamo activo de ese material
                            Prestamos prestamoActivo = null;
                            for (Prestamos p : Prestamos.prestamos) {
                                if (p.getMaterialEscolar() == m && p.isActivo()) {
                                    prestamoActivo = p;
                                    break;
                                }
                            }
                            if (prestamoActivo != null) {
                                info += " | Prestado a: " + prestamoActivo.getPersona().getNombre() + " " +
                                        prestamoActivo.getPersona().getApellido();
                                if (prestamoActivo.getPersona() instanceof Alumno) {
                                    info += " | Curso: " + ((Alumno) prestamoActivo.getPersona()).getCurso();
                                } else if (prestamoActivo.getPersona() instanceof Profesor) {
                                    info += " | Código profesor: " + ((Profesor) prestamoActivo.getPersona()).getCodigoProfesor();
                                }

                                long diasRestantes = (prestamoActivo.getFechaFinal().getTime() - prestamoActivo.getFechaInicio().getTime()) / (1000*60*60*24);
                                info += " | Días restantes: " + diasRestantes;
                            }
                        } else if (m.getEstado() == MaterialEscolar.EstadoMaterial.EN_MANTENIMIENTO) {
                            info += " | Material en mantenimiento | Días restantes: " + m.getDiasMantenimiento();
                        } else if (m.getEstado() == MaterialEscolar.EstadoMaterial.DISPONIBLE) {
                            info += " | Material disponible";
                        }

                        System.out.println(info);
                    }
                    break;

                // ===== 0: Salir =====
                case 0:
                    salir = true;
                    break;

                default:
                    System.out.println("❌ Opción no válida");
            }
        }

        sc.close();
    }
}
