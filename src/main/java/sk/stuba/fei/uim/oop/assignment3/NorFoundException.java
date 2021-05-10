package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NorFoundException extends RuntimeException{

}
