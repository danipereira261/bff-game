package br.com.fiap.bffjogos.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.UnexpectedTypeException;
import java.util.Arrays;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class HandlerConfig {

    @ExceptionHandler(value = GameNotFoundExeption.class)
    public ResponseEntity<ErroResponse> TesteException() {
        return
                status(HttpStatus.BAD_REQUEST)
                        .body(
                                ErroResponse
                                        .builder()
                                        .message("GAME NOT FOUND")
                                        .status(HttpStatus.BAD_REQUEST.value())
                                        .build()
                        );
    }


    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<ErroResponse> invalidArgument(UnexpectedTypeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErroResponse.builder().message("atribute is required").status(HttpStatus.BAD_REQUEST.value()).build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> invalidArgument(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErroResponse.builder().message(tratamentoDeMensagem(e)).status(HttpStatus.BAD_REQUEST.value()).build());
    }

    private String tratamentoDeMensagem(MethodArgumentNotValidException e) {
        String[] textoSeparado = e.getMessage().split(";");
        long count = Arrays.stream(textoSeparado).count();
        String msg = Arrays.stream(textoSeparado).skip(count - 1).findFirst().get();
        String nMsg = msg.replace(" default message [", "").replace("]]", "");
        return nMsg;
    }
}
