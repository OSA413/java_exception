package exception;

public class Snoopy {
    private boolean asleep = false;

    public void Sleep() {
        this.asleep = true;
    }

    public void Fly() throws SnoopyException {
        if (!this.asleep) throw new SnoopyException("Dogs don't fly in real life (they need to dream)");
        System.out.println("Hey look, a flying beagle! (on a plane)");
    }


    public static void NoExpections() {
        var a = new Snoopy();
        a.Sleep();
        try {
            a.Fly();
        } catch (SnoopyException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ErrorWrapper(Runnable func) {
        try {
            func.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void YesExceptions() {
        var a = new Snoopy();
        //Java не может догадаться, что я ловлю исключение внутри
        //Поэтому Снупи наследует RuntimeException, а не Exception
        ErrorWrapper(() -> a.Fly());
    }

    public static void main(String[] args) {
        NoExpections();
        YesExceptions();
    }
}


