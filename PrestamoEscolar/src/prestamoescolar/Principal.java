package prestamoescolar;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String menu = "QUE QUIERES HACER?\n" + "1-Registrar nuevo prestamo\n" + "2-Prestamos activos\n"
				+ "3-devolucion\n" + "4-Disponibilidad de material\n" + "5-Consultar historial\n" + "-1-Salir\n";
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println(menu);
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case -1:

				break;
			default:
				System.out.println("Opcion incorrecta.");
			}
		} while (opcion != -1);

		sc.close();
	}

}
