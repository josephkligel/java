import java.util.ArrayList;
public class Dynamic_Arrays {
    public static void main(String[] args){
        ArrayList<Object> myArray = new ArrayList<Object>();

        myArray.add(10);
        myArray.add("Hello");
        myArray.add(new ArrayList<Integer>());
        myArray.add(12.5);


        System.out.println(myArray);
    }
}
