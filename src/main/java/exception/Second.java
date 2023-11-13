package exception;

import java.io.Console;
import java.io.PrintStream;
import java.util.concurrent.Callable;


public class Second {

    public static void WhenThePointerGoesNull(Object a) {
        ((PrintStream)a).println("123");
    }

    public static void OutOfBounds(int index) {
        var a = new int []{1,2,3,4};
        var b = a[index];
    }

    public static void IRanOutOfIdeas(Object a) {
        ((String)a).length();
    }

    public static void NoExpections() {
        WhenThePointerGoesNull(System.out);
        OutOfBounds(2);
        IRanOutOfIdeas("123");
    }

    public static void ErrorWrapper(Runnable func) {
        try {
            func.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void YesExceptions() {
        ErrorWrapper(() -> WhenThePointerGoesNull(null));
        ErrorWrapper(() -> OutOfBounds(999));
        ErrorWrapper(() -> IRanOutOfIdeas(123));
    }

    public static void main(String[] args) {
        NoExpections();
        YesExceptions();
    }

}
