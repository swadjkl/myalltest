package News.Stream;

import News.Class.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamSql {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Milan",
                "london",
                "San Francisco",
                "Tokyo",
                "New Delhi"
        );
        System.out.println(cities);//[Milan, london, San Francisco, Tokyo, New Delhi]
        cities.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(cities);//[london, Milan, New Delhi, San Francisco, Tokyo]
        cities.sort(Comparator.naturalOrder());
        System.out.println(cities);//[Milan, New Delhi, San Francisco, Tokyo, london]

        //Milan
        //New Delhi
        //San Francisco
        //Tokyo
        //london
        cities.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);


        List<Integer> numbers = Arrays.asList(6, 2, 1, 4, 9);
        System.out.println(numbers); //[6, 2, 1, 4, 9]

        numbers.sort(Comparator.naturalOrder());  //自然排序
        System.out.println(numbers); //[1, 2, 4, 6, 9]

        numbers.sort(Comparator.reverseOrder()); //倒序排序
        System.out.println(numbers);  //[9, 6, 4, 2, 1]

        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");


        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        employees.sort(Comparator.comparing(Employee::getAge));//年龄正序
        employees.sort(Comparator.comparing(Employee::getAge).reversed());//年龄倒序
        employees.forEach(System.out::println);
        System.out.println("1111");
        //都是正序 ，不加reversed
        //都是倒序，最后面加一个reserved
        //先是倒序（加reserved），然后正序
        //先是正序（加reserved），然后倒序（加reserved）,负负得正
        employees.sort(
                Comparator.comparing(Employee::getGender)
                        .reversed()
                        .thenComparing(Employee::getAge)
                        .reversed()
        );
        employees.forEach(System.out::println);
        System.out.println("2222");

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee em1, Employee em2) {
                if(em1.getAge() == em2.getAge()){
                    return 0;
                }
                return em1.getAge() - em2.getAge() > 0 ? -1:1;
            }
        });
        employees.forEach(System.out::println);

        System.out.println("3333");
        employees.sort((em1,em2) -> {
            if(em1.getAge() == em2.getAge()){
                return 0;
            }
            return em1.getAge() - em2.getAge() > 0 ? -1:1;
        });
        employees.forEach(System.out::println);

        boolean isExistAgeThan70 = false;
        for(Employee employee:employees){
            if(employee.getAge() > 70){
                isExistAgeThan70 = true;
                break;
            }
        }
        boolean isExistAgeThan71 = employees.stream().anyMatch(Employee.ageGreaterThan70);
        boolean isExistAgeThan72 = employees.stream().anyMatch(e -> e.getAge() > 70);

        //都符合
        boolean isExistAgeThan10 = employees.stream().allMatch(e -> e.getAge() > 10);
        //都不符合
        boolean isExistAgeLess18 = employees.stream().noneMatch(e -> e.getAge() < 18);

        System.out.println("4444");
        //查找第一个符合的findFirst（）
        Optional<Employee> employeeOptional
                =  employees.stream().filter(e -> e.getAge() > 40).findFirst();
        System.out.println(employeeOptional.get());
    }
}