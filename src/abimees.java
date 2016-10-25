import java.util.Scanner;

public class abimees {


    public static void main(String[] args) {
        int devNumber = 0;
        int mituSeadet = 0;
        boolean jahEi;

        readfile readObject = new readfile();
        readObject.createDatabase();
        readObject.openFile();
        readObject.readFile();
        readObject.closeFile();

       do {
        System.out.println("Vali, millise seadme andmeid soovid näha:");
        readObject.getTable();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        devNumber = Integer.valueOf(input);
        readObject.getValues(devNumber);

        System.out.println("Mitu tükki neid seadmeid on?:");

        Scanner sc2 = new Scanner(System.in);
        String input2 = sc2.nextLine();
        mituSeadet = Integer.valueOf(input2);
        readObject.paljuVoolu(mituSeadet);
       // readObject.dmx(mituSeadet);

        System.out.println("Kas soovid veel seadmeid lisada? (1 -jah, 2 -ei:)");
        Scanner sc3 = new Scanner(System.in);
        String input3 = sc3.nextLine();
        if (Integer.valueOf(input3) == 1){
            jahEi = true;
        }else {
            jahEi = false;
        }

       }while (jahEi == true);
        }




    }

