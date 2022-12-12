public class Data {
    private double[] data;
    //
    Data(int l){
        data = new double[l];
        for (int i = 0; i < getLength(); i++)data[i] = Math.random()*2-1;
    }
    //
    int getLength(){return data.length;}
    double getIElement(int i){return data[i];}
}
