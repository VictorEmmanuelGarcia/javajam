import java.io.*;

class FileReadWrite {
    public void execute() {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(
                            "D:\\1KERR\\THIRD YEAR\\FIRST SEM\\C1\\CSIT321(APPDEVTECH)\\Practice\\output(copy).txt"));
            BufferedReader br = new BufferedReader(
                    new FileReader("D:\\1KERR\\THIRD YEAR\\FIRST SEM\\C1\\CSIT321(APPDEVTECH)\\Practice\\output.txt"));
            String holder;
            while ((holder = br.readLine()) != null) {
                bw.write(holder + "\n");
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}

public class App {
    public static void main(String[] args) {
        new FileReadWrite().execute();
        System.out.println("FileReadWrite sample success");
    }
}