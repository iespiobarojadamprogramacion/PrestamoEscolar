package prestamoescolar.controladores;

public class ControladorMaterial {

    public String registrarMaterial(int tipo) {

        return ApiPrestamo
                .getInstancia()
                .getApp()
                .registrarMaterial(tipo);
    }

    public String verMateriales() {

        return ApiPrestamo
                .getInstancia()
                .getApp()
                .verMateriales();
    }
}
