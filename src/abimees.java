

public class abimees {

    public static void main(String[] args) {

        readfile readObject = new readfile();
        readObject.createDatabase();
        readObject.openFile();
        readObject.readFile();
        readObject.closeFile();
        readObject.getTable();



    }
}
