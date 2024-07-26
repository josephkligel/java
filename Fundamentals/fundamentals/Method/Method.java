public class Method {
    public String basicGreeting(){
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name){
        return "Hello, " + name + "!";
    }

    public String guestGreeting(String name, String dayPeriod){
        return "Hello, " + name + ". It is " + dayPeriod;
    }

    public static void main(String[] args){
        Method greetingObj = new Method();
        String greeting = greetingObj.basicGreeting();
        System.out.println(greeting);

        System.out.println(greetingObj.guestGreeting("Joseph"));
        System.out.println(greetingObj.guestGreeting("Joseph", "Sunday"));
    }
    
}
