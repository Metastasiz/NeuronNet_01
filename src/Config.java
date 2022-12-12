import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Config {
    public static boolean debug = false;
    private static final String[] configPrefix = {"debug","sep","nrows","header","footer","prefix","suffix","filler","decimal","thousands"};
    private static String[] configSettings = new String[configPrefix.length];
    //
    public static final int varSize = 14;
    public static final String rSeperator = "[\\\n]?[ ]{2,}|]";
    public static final Pattern pSeperator = Pattern.compile(rSeperator);
    public static Matcher mFlex = null;
    public static void main(String[] arg) throws IOException {
        String path = "src/testTrain";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String line;
        while((line = br.readLine()) != null){
            //process the line
            System.out.println(line);
        }
        br.close();
    }
    Config(){
        loadConfig();
    }
    private void loadConfig(){
        final String fileName = "src/config";
        Path path = Paths.get(fileName);
        String config = "";
        try{config = Files.readString(path, StandardCharsets.UTF_8);}
        catch(Exception e){System.out.println(e);}
        String[] arrConfig = config.split(",\n");
        for (int i = 0; i < configPrefix.length; i++){
            for (String e : arrConfig){
                if (e.matches("^" + configPrefix[i] + "=" + ".*")){
                    configSettings[i] = e.replaceFirst("^" + configPrefix[i] + "=","");
                    break;
                }
            }
        }
        if(configSettings[0].equalsIgnoreCase("true"))debug=true;
        //
        print(config);
        print(arrConfig);
        print(configSettings);
    }
    private void print(String... mIn){
        if(debug) {
            System.out.println("\nPRINTING DEBUG");
            for (String e : mIn) System.out.println(e);
        }
    }
}
