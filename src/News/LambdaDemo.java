package News;

/*
* ��ͳ��oop
* */
/*
public class LambdaDemo {
    //��������
    public void printSomething(String something) {
        System.out.println(something);
    }
    //ͨ������������ú���
    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();
        String something = "I am learning Lambda";
        demo.printSomething(something);
    }
}
*/

public class LambdaDemo {
    //�����ܽӿ�
    interface Printer {
        void print(String val);
    }
    //ͨ���������ݹ��ܽӿ�
    public void printSomething(String something, Printer printer) {
        printer.print(something);
    }

    public static void main(String[] args) {
        LambdaDemo demo = new LambdaDemo();
        String something = "I am using a Functional interface";
        //ʵ��Printer�ӿ�
//        Printer printer = new Printer() {
//            @Override
//            public void print(String val) {
//                //����̨��ӡ
//                System.out.println(val);
//            }
//        };
        //ʵ��Printer�ӿڣ����ע��������lambda���ʽ���룩
//        Printer printer = (String toPrint)->{System.out.println(toPrint);};
//        demo.printSomething(something, printer);
        //�����
        Printer printer = toPrint->System.out.println(toPrint);
        demo.printSomething(something,toPrint->System.out.println(toPrint));
    }
}