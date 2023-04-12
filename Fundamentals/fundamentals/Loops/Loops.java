import java.util.ArrayList;

public class Loops {

    public static void main(String[] args){
        ArrayList<String> dynamicArray = new ArrayList<String>();
        dynamicArray.add("hello");
        dynamicArray.add("world");
        dynamicArray.add("etc");
        for (int i = 0; i < dynamicArray.size(); i++){
            System.out.println(dynamicArray.get(i));

        ArrayList<String> snacks = new ArrayList<String> ();
        snacks.add("Apples");
        snacks.add("Pretzels");
        snacks.add("Almonds");
        snacks.add("Yogurt");
        for(int j=0; j<snacks.size(); j++) {
            if(snacks.get(j).charAt(0) == 'A') {
                snacks.remove(j);
            }
        }
        
        // this will encounter an error like
        // Exception in thread "main" java.util.ConcurrentModificationException
            
}


    }
    
}
