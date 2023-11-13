package exception;

// Тип выбран RuntimeException, так как джава иначе не позволяет написать мне простой код в Snoopy.java
public class SnoopyException extends RuntimeException{

    public SnoopyException(String message) {
        super(message);
    }
}

