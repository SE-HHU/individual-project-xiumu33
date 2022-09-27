import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Utils {
    public static HashMap<String, String> hashmap = new HashMap<>();

    //判断题目数量，已经做出输入判断，并且将数量返回
    public static int menu() {
        System.out.println("请输入想打印的题数:>");
        int input = 0;
        int temp = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt() && (temp = scanner.nextInt()) > 0) {
                input = temp;
                break;
            } else {
                System.out.println("输入有误,请重试:>");
            }
        }
        return input;
    }

    public static void starter(String question, String answer, int round) throws IOException {
        //随机生成两个100以内的整数包括100
        Random random = new Random();
        while (hashmap.size() != round) {
            if (random.nextInt(101) % 2 == 0) {
                int left = random.nextInt(101);
                int right = random.nextInt(101);
                char symbol = (left < right ? '+' : '-');
                question = left + " " + symbol + " " + right + " =";
                answer = "";
                if (symbol == '+') {
                    answer = String.valueOf(left + right);
                } else {
                    answer = String.valueOf(left - right);
                }
            } else {
                int left = random.nextInt(101);
                int mid = random.nextInt(101);
                int right = random.nextInt(101);
                char symbol1 = (left > mid ? '-' : '+');
                int temp = 0;
                if (symbol1 == '+') {
                    temp = left + mid;
                } else {
                    temp = left - mid;
                }
                char symbol2 = (temp > right ? '-' : '+');
                if (symbol2 == '+') {
                    answer = String.valueOf((temp + right));
                } else {
                    answer = String.valueOf(temp - right);
                }
                question = left + " " + symbol1 + " " + mid + " " + symbol2 + " " + right + " =";
            }
            question = (":> " + question);
            answer = (":> " + answer);
            hashmap.put(question, answer);
        }
    }


    public static void writeQuestion() throws IOException {
        int flag = 0;
        String src = "E:\\javacode\\Individual Project\\Question.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(src, true));
        Set<String> set = hashmap.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            flag++;
            bw.write(flag + " " + iterator.next());
            bw.newLine();
            bw.flush();
        }
        if (bw != null) {
            bw.close();
        }
    }

    public static void writeAnswer() throws IOException {
        int flag = 0;
        String src = "E:\\javacode\\Individual Project\\Answer.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(src, true));
        Set<String> set = hashmap.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            flag++;
            bw.write(flag + " " + hashmap.get(iterator.next()));
            bw.newLine();
            bw.flush();
        }
        if (bw != null) {
            bw.close();
        }
    }
}
