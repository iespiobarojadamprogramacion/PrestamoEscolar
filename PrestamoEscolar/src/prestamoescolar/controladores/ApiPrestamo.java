package prestamoescolar.controladores;

import prestamoescolar.modelo.PrestamoEscolar;

public class ApiPrestamo {

    private static ApiPrestamo instancia;

    private PrestamoEscolar app;

    private ApiPrestamo() {

        app = new PrestamoEscolar();

        app.inicializarDatos();

        app.inicializarFecha();
    }

    public static ApiPrestamo getInstancia() {

        if (instancia == null) {

            instancia = new ApiPrestamo();
        }

        return instancia;
    }

    public PrestamoEscolar getApp() {

        return app;
    }
}
