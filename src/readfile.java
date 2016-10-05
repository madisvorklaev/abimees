import java.io.File;
import java.util.Scanner;

public class readfile {

        private Scanner x;

        public void openFile() {
            try{
                x = new Scanner(new File("data.txt"));
            }
            catch (Exception e){
                System.out.println("Faili ei leitud");
            }
        }

        public void readFile() {
            while (x.hasNext()) {
                String a = x.next();
                String b = x.next();
                String c = x.next();

                System.out.printf("%s %s %s\n", a, b, c);
                String device[] = {a, b, c};
                for (int i = 0; i < device.length; i++) {
                    System.out.println(device[i]);
                }
            }
        }

        public void closeFile() {
            x.close();
        }
}
