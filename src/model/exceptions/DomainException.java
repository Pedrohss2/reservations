package model.exceptions;

import java.io.Serial;

public class DomainException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L; // Valor de versão..

    public DomainException(String message) {
        super(message);
    }

}
