import java.io.File;
import java.util.*;


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
            HashMap<Integer, String> devices = new HashMap<>();
            while (x.hasNext()) {
                String a = x.next();
                String b = x.next();
                String c = x.next();
                Integer newA = Integer.valueOf(a);
                devices.put(newA,b);
                //System.out.printf("%s %s %s\n", a, b, c);
                //String device[] = {a, b, c};


                Set set = devices.entrySet();
                Iterator iterator = set.iterator();
                while(iterator.hasNext()) {
                    Map.Entry mentry = (Map.Entry)iterator.next();
                    System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
                    System.out.println(mentry.getValue());

                }
            }
        }

        public void closeFile() {
            x.close();
        }



        }
