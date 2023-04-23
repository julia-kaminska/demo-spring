package fast.dependency.injector;

public class ClassInitialization {

    private static int version = 1;
    static {
        System.out.println(version);
    }

    Integer x = 5;

    {
        System.out.println("initialization block");
    }

    public ClassInitialization(){
        System.out.println(x);
    }

    public static void main(String[] args) {
        new ClassInitialization();
    }
}
