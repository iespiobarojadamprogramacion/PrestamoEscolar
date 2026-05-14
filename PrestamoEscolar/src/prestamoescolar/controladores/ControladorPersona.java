package prestamoescolar.controladores;

public class ControladorPersona {

    public String registrarPersona(
            int tipo,
            String nombre,
            String apellido,
            int telefono,
            String curso,
            int codigo) {

        return ApiPrestamo
                .getInstancia()
                .getApp()
                .altaPersona(
                        tipo,
                        nombre,
                        apellido,
                        telefono,
                        curso,
                        codigo);
    }
}