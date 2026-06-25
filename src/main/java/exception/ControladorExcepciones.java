package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControladorExcepciones {
     @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> manejarRuntimeException(RuntimeException ex) {

        Map<String, String> respuestaError = new HashMap<>();
        respuestaError.put("error", "Recurso no encontrado");
        respuestaError.put("mensaje", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuestaError);
    }
    public ResponseEntity<Map<String, String>> manejarErroresGenerales(RuntimeException ex) {

        Map<String, String> respuestaError = new HashMap<>();
        respuestaError.put("error", "Error interno del servidor");
        respuestaError.put("ocurrio un problema", ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaError);
    }
}
