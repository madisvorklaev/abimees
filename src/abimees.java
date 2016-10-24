import java.util.Scanner;

public class abimees {

    public static void main(String[] args) {
        int devNumber = 0;

        readfile readObject = new readfile();
        readObject.createDatabase();
        readObject.openFile();
        readObject.readFile();
        readObject.closeFile();

        System.out.println("Vali, millise seadme andmeid soovid näha:");
        readObject.getTable();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        devNumber = Integer.valueOf(input);
        readObject.getValues(devNumber);



    }
}
