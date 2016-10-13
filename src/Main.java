import util.World;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        World wd = new World(3);
        wd.Init(1);
        PrintWriter fout = new PrintWriter(new File("out.txt"));
        fout.print(wd.toString());
        fout.close();
    }
}
