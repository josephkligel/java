public class Main {
    public static void main(String[] args){
        String[] fruits = {"banana", "pear", "papaya", "kiwi"};
        // To swap the value at index 0 and index 3
        String temp = fruits[0]; // assigns temp to "banana"
        fruits[0] = fruits[3]; // { "kiwi", "pear", "papaya", "kiwi"}
        fruits[3] = temp; // { "kiwi", "pear", "papaya", "banana"}

        for(int i = 0; i < fruits.length; ++i){
            System.out.println(fruits[i]);
        }

    }
}
