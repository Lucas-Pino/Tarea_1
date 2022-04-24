import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;




public class Stage3 {
    public static void main(String [] args) throws IOException {
//        if (args.length != 1) {
//            System.out.println("Usage: java Stage1 <configurationFile.txt>");
//            System.exit(-1);
//        }
        File file = new File("src/Stage3/configuration.txt");
        Scanner in = new Scanner(file);
        //System.out.println("File: " + args[0]);
        Cloud cloud = new Cloud();
        // reading <#_de_cortinas> <#_de_lámparas> <#_controles_cortinas> <#_controles_lámparas>
        int numRollerShades = in.nextInt();
        int numLamps = in.nextInt();  // skip number of lamps
        int numShadeControls = in.nextInt();
        int numLampsControl = in.nextInt(); // skip number of lamp's controls
        // read <alfa0> <length0> <canal0> … <alfaN_1> <lengthN_1> <canalN_1>
        double alpha = 0;
        double maxLength = 0;
        int shadeChannel = 0;
        for (int i = 0; i<numRollerShades; i++){
            alpha = in.nextDouble();
            maxLength = in.nextDouble();
            shadeChannel = in.nextInt();
            RollerShade rollerShade = new RollerShade(shadeChannel, alpha, maxLength);
            cloud.addRollerShade(rollerShade);
        }
        int lampChannel = 0;
        for (int i=0; i<numLamps; i++){             // channels ctrl lamparas
            lampChannel = in.nextInt();
            Lamp lamp = new Lamp(lampChannel);
            cloud.addLamp(lamp);
        }
        // creating just one roller shade's control at <canal0>
        int channel = in.nextInt();
        for (int i=0; i<numLamps; i++){             // channels ctrl lamparas
            lampChannel = in.nextInt();
            Lamp lamp = new Lamp(lampChannel);
                    cloud.addLamp(lamp);
        }
        channel = in.nextInt();
        ShadeControl shadeControl = new ShadeControl(channel, cloud);
        in.nextLine(); // skipping creation of lamp's control at <canal0>
        Operator operator = new Operator(shadeControl, cloud);


        // Write CSV
        File Out_stage2 = new File("src/Stage3/output.csv");
        FileWriter outputfile = new FileWriter(Out_stage2);
        CSVWriter writer = new CSVWriter(outputfile);
        operator.executeCommands(in, writer);
        writer.close();                         // cierre del archivo escritura
    }
}
