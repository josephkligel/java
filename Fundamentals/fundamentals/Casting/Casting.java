public class Casting {
    public static void main (String[] args){
        double d = 35.25;
        double dd = 35.99;
        // Casting doubles to integers
        int i = (int) d;
        int ii = (int) dd;

        System.out.println(i);
        System.out.println(ii);

        // Implicit/automatic conversion from integer to float
        i = 35;
        float f = i;
        System.out.println(f);
    }
}   
