import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainVectorHeapTest {

    
    @Test
    public void testPacienteVectorHeap() {
        // Prueba la comparación de pacientes por código de emergencia
    
        PacienteVectorHeap paciente1 = new PacienteVectorHeap("Juan", "Dolor de cabeza", 'D');
        PacienteVectorHeap paciente2 = new PacienteVectorHeap("Maria", "Dolor de espalda", 'E');
        PacienteVectorHeap paciente3 = new PacienteVectorHeap("Pedro", "Fiebre alta", 'C');
    
        // Verificar que paciente2 (código E) tiene menor prioridad que paciente1 (código D)
        assertFalse(paciente2.compareTo(paciente1) < 0); 
    
        // Verificar que paciente1 (código D) tiene menor prioridad que paciente3 (código C)
        assertFalse(paciente1.compareTo(paciente3) < 0); 
    }
} 