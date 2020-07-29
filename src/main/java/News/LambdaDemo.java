package News;

public class LambdaDemo {
    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();
        String something = "I am using a Functional interface";

//        Printer printer = new Printer() {
//            @Override
//            public void print(String val) {
//                System.out.println(val);
//            }
//        };

//        Printer printer = (String toPrint)->{System.out.println(toPrint);};
//        demo.printSomething(something, printer);

        // Printer printer = toPrint->System.out.println(toPrint);
        demo.printSomething(something,toPrint->System.out.println(toPrint));
    }

    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }

    interface Printer {
        void print(String val);
    }
}