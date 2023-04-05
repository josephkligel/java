public class StringDemo {
    public static void main(String[] args){
        String ninja = "Coding Dojo is awesome!";
        int length = ninja.length();
        System.out.println("String length is: " + length);

        // Concatenating strings
        String string1 = "My name is ";
        String string2 = "Michael";
        String string3 = string1.concat(string2);
        System.out.println(string3);

        // Formatting output
        ninja = String.format("Hi %s, you owe me $%.2f!", "Jack", 25.0);
        System.out.println(ninja);

        // Get the starting index of phrases in strings
        ninja = "Welcome to Coding Dojo!";
        int a = ninja.indexOf("Coding");
        int b = ninja.indexOf("co");
        int c = ninja.indexOf("pizza");
        String indexResult = String.format("The index for 'coding', 'co', and 'pizza' is %d, %d, and %d, respectively", a, b, c);
        System.out.println(indexResult);

        // Trimming strings
        String sentence = "    spaces everywhere!     ";
        System.out.println(sentence.trim());

        // Uppercase and lowercase
        String aString = "Hello";
        String bString = "world";
        System.out.println(aString.toLowerCase());
        System.out.println(bString.toUpperCase());

        // Equality
        aString = "same string";
        bString = "same string";
        System.out.println(aString == bString);

        // Creating strings with object notation
        aString = new String("same letters");
        bString = new String("same letters");
        System.out.println(aString == bString); // false, not the same object in memory
        System.out.println(aString.equals(bString)); // true, same exact characters

        
    }
}
