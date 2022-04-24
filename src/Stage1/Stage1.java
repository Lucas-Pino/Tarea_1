import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Stage1 {
    public static void main(String[] args) throws IOException {

//        if (args.length != 1) {
//            System.out.println("Usage: java Stage1 <configurationFile.txt>");
//            System.exit(-1);
//        }
        File file = new File("src/Stage1/configuration.txt");
        Scanner in = new Scanner(file);
        //System.out.println("File: " + args[0]);
        Cloud cloud = new Cloud();
        // reading <#_de_cortinas> <#_de_lámparas> <#_controles_cortinas> <#_controles_lámparas>
        in.nextInt();  // skip number of roller shades
        int numLamps = in.nextInt();
        in.nextInt();  // skip number of roller shade controls
        int numLampsControl = in.nextInt();
        // skipping <alfa0> <length0> <canal0> … <alfaN_1> <lengthN_1> <canalN_1>
        in.nextLine();
        // creating lamps according to <canal0>…..<canalL_1> for just one lamp
        int channel = in.nextInt();
        Lamp lamp = new Lamp(channel);
        cloud.addLamp(lamp);
        // skipping creation of roller shade's controls at <canal0>
        in.nextLine();
        // creating just one lamp's control at <canal0> channel = in.nextInt();
        LampControl lampControl = new LampControl(channel, cloud);
        Operator operator = new Operator(lampControl, cloud);

        File fileOut = new File("src/Stage1/output.csv");
        FileWriter outputfile = new FileWriter(fileOut);
        CSVWriter writer = new CSVWriter(outputfile);
        operator.executeCommands(in, writer);
    }
}
