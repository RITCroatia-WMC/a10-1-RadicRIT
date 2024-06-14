package part1;

/*
@ASSESSME.USERID: ar6367
@ASSESSME.AUTHOR: aAndrija Radic
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/


public class Woolie extends Thread{
    private String name;
    private int crossingTime;
    private String startCity;
    private String endCity;


    public Woolie(String name, int crossingTime, String startCity, String endCity){
        this.name = name;
        this.crossingTime = crossingTime;
        this.startCity = startCity;
        this.endCity =  endCity;
    }

    @Override
    public void run(){
        try{
            System.out.println(name + "has arrived at the bridge at" + startCity + ".");
            System.out.println(name + "is starting to cross.");
            for(int i=1; i<=crossingTime; i++){
                Thread.sleep(1000);
                System.out.println("\t" + name + ":" + i + "seconds.");
            }
            System.out.println(name + "arrives at" + endCity + ".");
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Woolie woolie1 = new Woolie("Woolie1", 5, "Courtwald", "Glassdell");
        Woolie woolie2 = new Woolie("Woolie2", 3, "Courtwald", "Glassdell");
        Woolie woolie3 = new Woolie("Woolie3", 4, "Courtwald", "Glassdell");
        Woolie woolie4 = new Woolie("Woolie4", 2, "Courtwald", "Glassdell");


        woolie1.start();
        woolie2.start();
        woolie3.start();
        woolie4.start();
    }
}