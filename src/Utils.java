import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Utils {
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

    public static void starter(String question, String answer, int flag) throws IOException {
        //随机生成两个100以内的整数包括100
        Random random = new Random();
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
        Utils.writeQuestion((flag + 1) + ":> " + question);
        Utils.writeAnswer((flag + 1) + ":> " + answer);
    }


    public static void writeQuestion(String question) throws IOException {
        String src = "E:\\javacode\\2022.9.26\\Question.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(src, true));
        bw.write(question);
        bw.newLine();
        bw.flush();
        if (bw != null) {
            bw.close();
        }
    }

    public static void writeAnswer(String answer) throws IOException {
        String src = "E:\\javacode\\2022.9.26\\Answer.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(src, true));
        bw.write(answer);
        bw.newLine();
        bw.flush();
        if (bw != null) {
            bw.close();
        }
    }
}

