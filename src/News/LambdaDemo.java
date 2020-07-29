package News;

/*
* 传统的oop
* */
/*
public class LambdaDemo {
    //函数定义
    public void printSomething(String something) {
        System.out.println(something);
    }
    //通过创建对象调用函数
    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();
        String something = "I am learning Lambda";
        demo.printSomething(something);
    }
}
*/

public class LambdaDemo {
    //抽象功能接口
    interface Printer {
        void print(String val);
    }
    //通过参数传递功能接口
    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }

    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();
        String something = "I am using a Functional interface";
        //实现Printer接口
//        Printer printer = new Printer() {
//            @Override
//            public void print(String val) {
//                //控制台打印
//                System.out.println(val);
//            }
//        };
        //实现Printer接口（请关注下面这行lambda表达式代码）
//        Printer printer = (String toPrint)->{System.out.println(toPrint);};
//        demo.printSomething(something, printer);
        //简洁版的
        Printer printer = toPrint->System.out.println(toPrint);
        demo.printSomething(something,toPrint->System.out.println(toPrint));
    }
}