import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //打印题目数量
        int num = Utils.menu();
        for (int i = 0; i < num; i++) {
            String question = "";
            String answer = "";
            Utils.starter(question, answer,i);
        }
    }
}
