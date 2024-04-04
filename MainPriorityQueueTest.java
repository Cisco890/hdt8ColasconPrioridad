import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MainPriorityQueueTest {

    @Test
    public void testPacientePriorityQueue() {
        // Prueba la comparación de pacientes por código de emergencia

        PacientePriorityQueue paciente1 = new PacientePriorityQueue("Juan", "Dolor abdominal", 'B');
        PacientePriorityQueue paciente2 = new PacientePriorityQueue("Maria", "Herida profunda", 'A');
        PacientePriorityQueue paciente3 = new PacientePriorityQueue("Pedro", "Fiebre alta", 'C');

        // Verificar que paciente2 (código A) tiene mayor prioridad que paciente1 (código B)
        assertTrue(paciente2.compareTo(paciente1) < 0);

        // Verificar que paciente1 (código B) tiene mayor prioridad que paciente3 (código C)
        assertTrue(paciente1.compareTo(paciente3) < 0);
    }
}
