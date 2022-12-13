import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arg){
        new Config();
        List<RawData> data = new ArrayList<>();
        ImportData.importTo(data,"src/testTrain");
    }
}
