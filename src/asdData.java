public class asdData {
    private double[] data;
    //
    asdData(int weightLength){
        data = new double[weightLength];
        for (int i = 0; i < getLength(); i++)data[i] = Math.random()*2-1;
    }
    asdData(double[] arr){
        data = new double[arr.length];
        for (int i = 0; i < getLength(); i++)data[i] = arr[i];
    }
    asdData(String[] arr){
        data = new double[arr.length];
        for (int i = 0; i < getLength(); i++)data[i] = Double.parseDouble(arr[i]);
    }
    //
    int getLength(){return data.length;}
    double getElement(int index){return data[index];}
    double[] getData(){return data;}
}
