import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Clase principal que maneja la lógica principal del programa
public class MainVectorHeap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VectorHeap<PacienteVectorHeap> colaEmergencias = new VectorHeap<>();

        boolean continuar = true;
        while (continuar) {
            // Leer el archivo de pacientes
            try {
                File archivo = new File("pacientes.txt");
                Scanner archivoScanner = new Scanner(archivo);
                while (archivoScanner.hasNextLine()) {
                    String linea = archivoScanner.nextLine();
                    String[] datos = linea.split(",");
                    if (datos.length == 3) {
                        String nombre = datos[0].trim();
                        String sintoma = datos[1].trim();
                        char codigoEmergencia = datos[2].trim().charAt(0);
                        colaEmergencias.add(new PacienteVectorHeap(nombre, sintoma, codigoEmergencia));
                    }
                }
                archivoScanner.close();
            } catch (IOException e) {
                System.out.println("Error al leer el archivo pacientes.txt");
                e.printStackTrace();
            }

            // Atender a los pacientes según su prioridad
            System.out.println("Orden de atención de los pacientes:");
            while (!colaEmergencias.isEmpty()) {
                PacienteVectorHeap paciente = colaEmergencias.remove();
                System.out.println(paciente);
            }

            System.out.println("¿Desea agregar más pacientes? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Ingrese los datos del paciente (nombre, sintoma, código de emergencia separados por comas):");
                String datosPaciente = scanner.nextLine();
                try {
                    FileWriter writer = new FileWriter("pacientes.txt", true);
                    writer.write("\n" + datosPaciente);
                    writer.close();
                    System.out.println("Paciente agregado correctamente.");
                } catch (IOException e) {
                    System.out.println("Error al agregar el paciente.");
                    e.printStackTrace();
                }
            } else {
                continuar = false;
            }
        }
        scanner.close();
    }
}