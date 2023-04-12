public class TestNull {
    public static void main(String[] args){
        Integer a = 10;
        int b = 10;
        a = null; // Will work because an object can point to null
        b = null; // Will not compile because null cannot be converted to an int
    }   
}
