package prestamoescolar.controladores;

public class ControladorPrestamo {

    public String registrarPrestamo(
            int tipo,
            String nombre,
            String apellido,
            int telefono,
            String curso,
            int codigo,
            int material,
            int prestamo) {

        return ApiPrestamo
                .getInstancia()
                .getApp()
                .registrarPrestamo(
                        tipo,
                        nombre,
                        apellido,
                        telefono,
                        curso,
                        codigo,
                        material,
                        prestamo);
    }

    public String verPrestamos() {

        return ApiPrestamo
                .getInstancia()
                .getApp()
                .verPrestamos();
    }

    public String pasarDia() {

        return ApiPrestamo
                .getInstancia()
                .getApp()
                .pasarDia();
    }

    public String getFechaActual() {

        return ApiPrestamo
                .getInstancia()
                .getApp()
                .getFechaActual();
    }
}
