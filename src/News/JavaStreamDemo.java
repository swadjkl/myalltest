package News;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class JavaStreamDemo {
    public static void main(String[] args) throws IOException {
        List<String> nameStrs = Arrays.asList("Monkey", "Lion", "Giraffe","Lemur");

        /**
         * 首先，我们使用Stream()函数，将一个List转换为管道流
         * 调用filter函数过滤数组元素，过滤方法使用lambda表达式，以L开头的元素返回true被保留，其他的List元素被过滤掉
         * 然后调用Map函数对管道流中每个元素进行处理，字母全部转换为大写
         * 然后调用sort函数，对管道流中数据进行排序
         * 最后调用collect函数toList，将管道流转换为List返回
         */
        List<String> list0 = nameStrs.stream()
                .filter(s -> s.startsWith("L"))
                .map(String::toUpperCase)
                .sorted()
                .collect(toList());

        System.out.println(list0);

        /**
         * 使用Stream.of()方法，将数组转换为管道流。
         */
        String[] array = {"Monkey", "Lion", "Giraffe", "Lemur"};
        Stream<String> nameStrs2 = Stream.of(array);
        Stream<String> nameStrs3 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");

        /**
         * 通过调用集合类的stream()方法，将集合类对象转换为管道流。
         */
        List<String> list = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");
        Stream<String> streamFromList = list.stream();

        Set<String> set = new HashSet<>(list);
        Stream<String> streamFromSet = set.stream();

        /**
         * 通过Files.lines方法将文本文件转换为管道流，下图中的Paths.get()方法作用就是获取文件，是Java NIO的API！
         * 也就是说：我们可以很方便的使用Java Stream加载文本文件，然后逐行的对文件内容进行处理。
         */
        Stream<String> lines = Files.lines(Paths.get("file.txt"));
    }
}
