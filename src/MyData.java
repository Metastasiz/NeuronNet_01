public abstract class MyData<dataType> {
    protected dataType[] data;
    MyData(dataType[] arr){
        data = new dataType[arr.length];
        for (int i = 0; i < arr.length; i++)data[i] = arr[i];
    }
    MyData<dataType> changeData(dataType[] arr){
        data = (dataType[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)data[i] = arr[i];
        return this;
    }
    dataType[] getData(){return data;}
}
