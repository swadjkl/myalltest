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
         * ���ȣ�����ʹ��Stream()��������һ��Listת��Ϊ�ܵ���
         * ����filter������������Ԫ�أ����˷���ʹ��lambda���ʽ����L��ͷ��Ԫ�ط���true��������������ListԪ�ر����˵�
         * Ȼ�����Map�����Թܵ�����ÿ��Ԫ�ؽ��д�����ĸȫ��ת��Ϊ��д
         * Ȼ�����sort�������Թܵ��������ݽ�������
         * ������collect����toList�����ܵ���ת��ΪList����
         */
        List<String> list0 = nameStrs.stream()
                .filter(s -> s.startsWith("L"))
                .map(String::toUpperCase)
                .sorted()
                .collect(toList());

        System.out.println(list0);

        /**
         * ʹ��Stream.of()������������ת��Ϊ�ܵ�����
         */
        String[] array = {"Monkey", "Lion", "Giraffe", "Lemur"};
        Stream<String> nameStrs2 = Stream.of(array);
        Stream<String> nameStrs3 = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");

        /**
         * ͨ�����ü������stream()�����������������ת��Ϊ�ܵ�����
         */
        List<String> list = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");
        Stream<String> streamFromList = list.stream();

        Set<String> set = new HashSet<>(list);
        Stream<String> streamFromSet = set.stream();

        /**
         * ͨ��Files.lines�������ı��ļ�ת��Ϊ�ܵ�������ͼ�е�Paths.get()�������þ��ǻ�ȡ�ļ�����Java NIO��API��
         * Ҳ����˵�����ǿ��Ժܷ����ʹ��Java Stream�����ı��ļ���Ȼ�����еĶ��ļ����ݽ��д���
         */
        Stream<String> lines = Files.lines(Paths.get("file.txt"));
    }
}
