import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ImportData {
    //private static final String[] configPrefix = {"debug","sep","nrows","header","footer","prefix","suffix","filler","decimal","thousands"};

    public static void importTo(List<RawData> data, String filePath){
        String[] config = Config.getConfig();
        int cI = 1;
        String sep = config[cI++].replaceAll("(^\\\")|(\\\"$)","");
        int nrows = Integer.parseInt(config[cI++]);
        int header = Integer.parseInt(config[cI++]);
        int footer = Integer.parseInt(config[cI++]);
        String prefix = checkNone(config[cI++]);
        String suffix = checkNone(config[cI++]);
        String filler = checkNone(config[cI++]);
        String decimal = checkNone(config[cI++]);
        String thousands = checkNone(config[cI++]);
        //
        System.out.println(sep);
        System.out.println(decimal);

        File file = new File(filePath);
        try{
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while((line = br.readLine()) != null){
                for (int i = 0; i < header; i++){
                    line=br.readLine();
                }
                for (int i = 0; i < nrows-1; i++){
                    line+=br.readLine();
                }
                for (int i = 0; i < footer; i++){
                    br.readLine();
                }
                line=line.replaceAll("^("+prefix+")?","");
                line=line.replaceAll("("+suffix+")$?","");
                line=line.replaceAll("("+filler+")", Config._filler);
                line=line.replaceAll("("+decimal+")",Config._decimal);
                line=line.replaceAll("("+thousands+")","");
                String[] l = line.split(sep);
                data.add(new RawData(l));
            }
            br.close();
            for(RawData e : data)System.out.println(e.getData()[0]);
            System.out.println("jkl");
        }
        catch (Exception e){System.out.println(e);}
    }
    private static String checkNone(String configString){
        if (configString.equalsIgnoreCase("None"))return "";
        return configString.replaceAll("(^\")|(\"$)","").replaceAll("\\.","\\\\.");
    }
}
