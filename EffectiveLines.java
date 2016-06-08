import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Predicate;

/**
 * ͳ��һ��Java�ļ�����Ч������
 *  1.��Ч����������
 *  2.�����Ǵ�����ж���ע�͵����
 *
 * Created by ŷ���� on 2016/6/4.
 * ������java8
 */
public class EffectiveLines {
    public static final String[] DEFAULT_FILENAMES = new String[] {"src/main/java/"};

    public static void main(String[] args) {

        String[] filenames = args.length > 0 ? args : DEFAULT_FILENAMES;    // ѡ�������в�����Ĭ�ϲ���

        for (String filename : filenames) {
            try {

                printEffectiveLinesRecursive(Paths.get(filename));

            } catch (IOException e) {
                System.out.println(filename + " : not exist");
            }
        }
    }

    /**
     * �ݹ�����ļ�
     *
     * @param file
     * @throws IOException
     */
    private static void printEffectiveLinesRecursive(Path file) throws IOException {
        Files.walk(file).forEach(EffectiveLines::printEffectiveLines);
    }

    /**
     * �����ļ�����
     *
     * @param file
     */
    private static void printEffectiveLines(Path file) {
        if (Files.isDirectory(file))
            return;

        try {
            Predicate<String> blankFilter = l -> !l.trim().isEmpty();     // ���й���
            Predicate<String> commentFilter = l -> !l.trim().startsWith("//");   // ����ע�͹���

            long count = Files.lines(file).filter(blankFilter.and(commentFilter)).count();

            System.out.println(file + " : " + count);
        } catch (IOException e) {
            System.out.println(file + " : read error");
        }

    }

}
