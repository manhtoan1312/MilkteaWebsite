package milkteaorder.exception;

import java.time.format.DateTimeParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import milkteaorder.controller.customer.dto.MessageDto;

@RestControllerAdvice
public class CRUDException {
//	@ExceptionHandler({NoSuchElementException.class, })
//	public ResponseEntity<String> handleCRUDException(Exception e) {
//		return ResponseEntity.status(500).body("Bắt lỗi nè!!");
//	}
	
	@ExceptionHandler({NullPointerException.class})
	public ResponseEntity<?> handleCRUDException(Exception e) {
		return ResponseEntity.status(500).body(new MessageDto("Null pointer or no data found!!"));
	}
	
	@ExceptionHandler({DateTimeParseException.class})
	public ResponseEntity<?> localDateTimeInvalid(Exception e) {
		return ResponseEntity.status(500).body(new MessageDto("Wrong format yyyy-mm-dd!!"));
	}
}
