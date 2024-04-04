/** Juan Francisco Martínez 23617
 * Clase que representa a un paciente en el programa y que implementa Comparable para comparar por código de emergencia.
 *      * @param nombre            El nombre del paciente.
 *     * @param sintoma           El síntoma del paciente.
 *      * @param codigoEmergencia  El código de emergencia del paciente.
 */
// Clase Paciente que implementa Comparable para comparar por código de emergencia
class PacientePriorityQueue implements Comparable<PacientePriorityQueue> {
    private String nombre;

    private String sintoma;
    private char codigoEmergencia;

    public PacientePriorityQueue(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    // Método para comparar pacientes por código de emergencia
    @Override
    public int compareTo(PacientePriorityQueue otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }

    // Método para imprimir los detalles del paciente
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
