package prestamoescolar.principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prestamoescolar.modelo.MaterialEscolar;
import prestamoescolar.modelo.PrestamoEscolar;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L; // no se que es esto eclipse lo recomienda poner 

	private JPanel panel;

    private PrestamoEscolar app;

    private JTextField nombre;
    private JTextField apellido;
    private JTextField telefono;
    private JTextField extra;

    private JTextArea areaTexto;

    private JComboBox<String> tipoPersona;

    private JComboBox<String> tipoMaterial;

    private JComboBox<String> tipoPrestamo;

    private JComboBox<String> materialesDisponibles;

    private JLabel modo;

    private JLabel textoNombre;
    private JLabel textoApellido;
    private JLabel textoTelefono;
    private JLabel textoExtra;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    VentanaPrincipal ventana =
                            new VentanaPrincipal();

                    ventana.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaPrincipal() {

        app = new PrestamoEscolar();

        app.inicializarDatos();
        app.inicializarFecha();

        setTitle("Prestamo Escolar");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 1200, 800);

        panel = new JPanel();

        panel.setBorder(
                new EmptyBorder(5,5,5,5));

        setContentPane(panel);

        panel.setLayout(null);

        // ================= MENU =================

        JMenuBar barra = new JMenuBar();

        setJMenuBar(barra);

        JMenu registrar = new JMenu("Registrar");

        barra.add(registrar);

        JMenuItem persona =
                new JMenuItem("Persona");

        JMenuItem material =
                new JMenuItem("Material");

        JMenuItem prestamo =
                new JMenuItem("Prestamo");

        registrar.add(persona);
        registrar.add(material);
        registrar.add(prestamo);

        JMenu consultas = new JMenu("Consultas");

        barra.add(consultas);

        JMenuItem verPrestamos =
                new JMenuItem("Ver Prestamos");

        JMenuItem verMateriales =
                new JMenuItem("Ver Materiales");

        consultas.add(verPrestamos);
        consultas.add(verMateriales);

        // ================= TITULO =================

        JLabel titulo =
                new JLabel("BIENVENIDO A PRESTAMO ESCOLAR");

        titulo.setFont(
                new Font("Tahoma", Font.BOLD, 24));

        titulo.setBounds(330, 20, 500, 40);

        panel.add(titulo);

        JLabel fecha =
                new JLabel("Fecha actual: "
                        + app.getFechaActual());

        fecha.setBounds(500, 70, 200, 20);

        panel.add(fecha);

        // ================= MODO =================

        modo =
                new JLabel("REGISTRAR PERSONA");

        modo.setFont(
                new Font("Tahoma", Font.BOLD, 16));

        modo.setBounds(40, 120, 300, 30);

        panel.add(modo);

        // ================= NOMBRE =================

        textoNombre =
                new JLabel("Nombre");

        textoNombre.setBounds(40, 170, 100, 20);

        panel.add(textoNombre);

        nombre = new JTextField();

        nombre.setBounds(150, 170, 220, 25);

        panel.add(nombre);

        // ================= APELLIDO =================

        textoApellido =
                new JLabel("Apellido");

        textoApellido.setBounds(40, 210, 100, 20);

        panel.add(textoApellido);

        apellido = new JTextField();

        apellido.setBounds(150, 210, 220, 25);

        panel.add(apellido);

        // ================= TELEFONO =================

        textoTelefono =
                new JLabel("Telefono");

        textoTelefono.setBounds(40, 250, 100, 20);

        panel.add(textoTelefono);

        telefono = new JTextField();

        telefono.setBounds(150, 250, 220, 25);

        panel.add(telefono);

        // ================= EXTRA =================

        textoExtra =
                new JLabel("Curso");

        textoExtra.setBounds(40, 290, 120, 20);

        panel.add(textoExtra);

        extra = new JTextField();

        extra.setBounds(150, 290, 220, 25);

        panel.add(extra);

        // ================= TIPO PERSONA =================

        tipoPersona =
                new JComboBox<>();

        tipoPersona.addItem("Alumno");
        tipoPersona.addItem("Profesor");

        tipoPersona.setBounds(150, 330, 220, 25);

        panel.add(tipoPersona);

        tipoPersona.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (tipoPersona.getSelectedIndex() == 0) {

                    textoExtra.setText("Curso");

                } else {

                    textoExtra.setText("Codigo Profesor");
                }
            }
        });

        // ================= MATERIAL =================

        tipoMaterial =
                new JComboBox<>();

        tipoMaterial.addItem("Portatil");
        tipoMaterial.addItem("Tablet");
        tipoMaterial.addItem("Calculadora");
        tipoMaterial.addItem("Libro");
        tipoMaterial.addItem("Audiovisual");

        tipoMaterial.setBounds(150, 330, 220, 25);

        panel.add(tipoMaterial);

        // ================= PRESTAMO =================

        tipoPrestamo =
                new JComboBox<>();

        tipoPrestamo.addItem("Larga");
        tipoPrestamo.addItem("Corta");
        tipoPrestamo.addItem("Especial");

        tipoPrestamo.setBounds(150, 370, 220, 25);

        panel.add(tipoPrestamo);

        // ================= MATERIALES DISPONIBLES =================

        materialesDisponibles =
                new JComboBox<>();

        materialesDisponibles.setBounds(150, 410, 220, 25);

        panel.add(materialesDisponibles);

        // ================= BOTON =================

        JButton boton =
                new JButton("REGISTRAR");

        boton.setBounds(150, 470, 220, 40);

        panel.add(boton);

        // ================= PASAR DIA =================

        JButton pasarDia =
                new JButton("PASAR DIA");

        pasarDia.setBounds(900, 120, 200, 50);

        panel.add(pasarDia);

        // ================= AREA TEXTO =================

        JScrollPane scroll =
                new JScrollPane();

        scroll.setBounds(420, 200, 700, 500);

        panel.add(scroll);

        areaTexto = new JTextArea();

        scroll.setViewportView(areaTexto);

        // ================= MENU PERSONA =================

        persona.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                modo.setText(
                        "REGISTRAR PERSONA");

                actualizarFormulario(
                        "REGISTRAR PERSONA");
            }
        });

        // ================= MENU MATERIAL =================

        material.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                modo.setText(
                        "REGISTRAR MATERIAL");

                actualizarFormulario(
                        "REGISTRAR MATERIAL");
            }
        });

        // ================= MENU PRESTAMO =================

        prestamo.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                modo.setText(
                        "REGISTRAR PRESTAMO");

                actualizarFormulario(
                        "REGISTRAR PRESTAMO");
            }
        });

        // ================= BOTON REGISTRAR =================

        boton.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    String opcion =
                            modo.getText();

                    // ================= PERSONA =================

                    if (opcion.equals(
                            "REGISTRAR PERSONA")) {

                        int tipo =
                                tipoPersona.getSelectedIndex()+1;

                        String nom =
                                nombre.getText();

                        String ape =
                                apellido.getText();

                        int tel =
                                Integer.parseInt(
                                        telefono.getText());

                        String resultado = "";

                        if (tipo == 1) {

                            resultado =
                                    app.altaPersona(
                                            tipo,
                                            nom,
                                            ape,
                                            tel,
                                            extra.getText(),
                                            0);

                        } else {

                            resultado =
                                    app.altaPersona(
                                            tipo,
                                            nom,
                                            ape,
                                            tel,
                                            null,
                                            Integer.parseInt(
                                                    extra.getText()));
                        }

                        areaTexto.setText(resultado);
                    }

                    // ================= MATERIAL =================

                    else if (opcion.equals(
                            "REGISTRAR MATERIAL")) {

                        int tipo =
                                tipoMaterial.getSelectedIndex() + 1;

                        areaTexto.setText(
                                app.registrarMaterial(tipo));
                    }

                    // ================= PRESTAMO =================

                    else if (opcion.equals(
                            "REGISTRAR PRESTAMO")) {

                        int tipo =
                                tipoPersona.getSelectedIndex()+1;

                        String nom =
                                nombre.getText();

                        String ape =
                                apellido.getText();

                        int tel =
                                Integer.parseInt(
                                        telefono.getText());

                        String curso = null;

                        int codigo = 0;

                        if (tipo == 1) {

                            curso = extra.getText();

                        } else {

                            codigo =
                                    Integer.parseInt(
                                            extra.getText());
                        }

                        int material =
                                materialesDisponibles.getSelectedIndex() + 1;

                        int prestamo =
                                tipoPrestamo.getSelectedIndex() + 1;

                        String resultado =
                                app.registrarPrestamo(
                                        tipo,
                                        nom,
                                        ape,
                                        tel,
                                        curso,
                                        codigo,
                                        material,
                                        prestamo);

                        areaTexto.setText(resultado);
                    }

                } catch (Exception ex) {

                    areaTexto.setText(
                            "Error en los datos");
                }
            }
        });

        // ================= CONSULTAS =================

        verPrestamos.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                areaTexto.setText(
                        app.verPrestamos());
            }
        });

        verMateriales.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                areaTexto.setText(
                        app.verMateriales());
            }
        });

        // ================= PASAR DIA =================

        pasarDia.addActionListener(
                new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                areaTexto.setText(
                        app.pasarDia());

                fecha.setText(
                        "Fecha actual: "
                        + app.getFechaActual());

                actualizarMateriales();
            }
        });

        actualizarFormulario(
                "REGISTRAR PERSONA");
    }

    // ================= FORMULARIO =================

    private void actualizarFormulario(String opcion) {

        // ================= PERSONA =================

        if (opcion.equals("REGISTRAR PERSONA")) {

            textoNombre.setVisible(true);
            textoApellido.setVisible(true);
            textoTelefono.setVisible(true);
            textoExtra.setVisible(true);

            nombre.setVisible(true);
            apellido.setVisible(true);
            telefono.setVisible(true);
            extra.setVisible(true);

            tipoPersona.setVisible(true);

            tipoMaterial.setVisible(false);

            tipoPrestamo.setVisible(false);

            materialesDisponibles.setVisible(false);
        }

        // ================= MATERIAL =================

        else if (opcion.equals("REGISTRAR MATERIAL")) {

            textoNombre.setVisible(false);
            textoApellido.setVisible(false);
            textoTelefono.setVisible(false);
            textoExtra.setVisible(false);

            nombre.setVisible(false);
            apellido.setVisible(false);
            telefono.setVisible(false);
            extra.setVisible(false);

            tipoPersona.setVisible(false);

            tipoMaterial.setVisible(true);

            tipoPrestamo.setVisible(false);

            materialesDisponibles.setVisible(false);
        }

        // ================= PRESTAMO =================

        else if (opcion.equals("REGISTRAR PRESTAMO")) {

            textoNombre.setVisible(true);
            textoApellido.setVisible(true);
            textoTelefono.setVisible(true);
            textoExtra.setVisible(true);

            nombre.setVisible(true);
            apellido.setVisible(true);
            telefono.setVisible(true);
            extra.setVisible(true);

            tipoPersona.setVisible(true);

            tipoMaterial.setVisible(false);

            tipoPrestamo.setVisible(true);

            materialesDisponibles.setVisible(true);

            actualizarMateriales();
        }
    }

    // ================= ACTUALIZAR MATERIALES =================

    private void actualizarMateriales() {

        materialesDisponibles.removeAllItems();

        for (int i = 0;
             i < MaterialEscolar.materiales.size();
             i++) {

            MaterialEscolar material =
                    MaterialEscolar.materiales.get(i);

            if (material.isDisponible()) {

                materialesDisponibles.addItem(
                        (i + 1)
                        + " - "
                        + material.toString());
            }
        }
    }
}