package part2;

/*
@ASSESSME.USERID: ar6367
@ASSESSME.AUTHOR: Andrija Radic
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/


public class Woolie extends Thread{
    private String name;
    private int crossingTime;
    private String startCity;
    private String endCity;
    private Bridge bridge;


    public Woolie(String name, int crossingTime, String startCity, String endCity, Bridge bridge){
        this.name = name;
        this.crossingTime = crossingTime;
        this.startCity = startCity;
        this.endCity =  endCity;
        this.bridge = bridge;
    }

    @Override
    public void run(){
        try{
            System.out.println(name + "has arrived at the bridge at" + startCity + ".");
            bridge.enterBridge(name);
            System.out.println(name + "is starting to cross.");
            for(int i=1; i<=crossingTime; i++){
                Thread.sleep(1000);
                System.out.println("\t" + name + ":" + i + "seconds.");
            }
            bridge.leaveBridge(name);
            System.out.println(name + "arrives at" + endCity + ".");
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Bridge bridge = new Bridge();
        Woolie woolie1 = new Woolie("Woolie1", 5, "Courtwald", "Glassdell", bridge);
        Woolie woolie2 = new Woolie("Woolie2", 3, "Courtwald", "Glassdell", bridge);
        Woolie woolie3 = new Woolie("Woolie3", 4, "Courtwald", "Glassdell", bridge);
        Woolie woolie4 = new Woolie("Woolie4", 2, "Courtwald", "Glassdell", bridge);


        woolie1.start();
        woolie2.start();
        woolie3.start();
        woolie4.start();
    }
}