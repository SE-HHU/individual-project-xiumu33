import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //打印题目数量
        int num = Utils.menu();
        String question="";
        String answer="";
        Utils.starter(question,answer,num);
        Utils.writeAnswer();
        Utils.writeQuestion();
    }
}
