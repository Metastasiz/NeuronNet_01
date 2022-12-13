public class RawData extends MyData<String> {
    RawData(String[] arr) {
        super(arr);
    }
    public int returnNumberOfFiller(){
        int counter = 0;
        for (String e : data){
            if (e.equalsIgnoreCase(Config._filler))counter++;
        }
        return counter;
    }
    @Override
    public String toString(){
        String out = "";
        for (String e : data)out+=e+", ";
        return out;
    }
}
