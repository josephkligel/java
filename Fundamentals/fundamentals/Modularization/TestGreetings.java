public class TestGreetings {
    public static void main(String[] args){
        Greetings greeterApp = new Greetings();

        String dateMessage = greeterApp.getCurrentData();

        System.out.println(dateMessage);
    }
}
