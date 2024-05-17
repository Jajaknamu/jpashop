package jpabook.jpashop.exception;

public class NoEnoughStockExecption extends RuntimeException{
    public NoEnoughStockExecption() {
        super();
    }

    public NoEnoughStockExecption(String message) {
        super(message);
    }

    public NoEnoughStockExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public NoEnoughStockExecption(Throwable cause) {
        super(cause);
    }
}
