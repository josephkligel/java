import java.util.Date;

public class Greetings {
    public String getCurrentData(){
        Date date = new Date();
        return "Current date is " + date;
    }

    public String greetEnglish(String name){
        return "Hello, " + name;
    }
}
