package part2;

/*
@ASSESSME.USERID: ar6367
@ASSESSME.AUTHOR: Andrija Radic
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.DESCRIPTION: ASS10.1
@ASSESSME.ANALYZE: YES
*/

public class Bridge{
    private boolean isBridgeOccupied = false;

    public synchronized void enterBridge(String name){
        while(isBridgeOccupied){
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        isBridgeOccupied = true;
        System.out.println(name + "is starting to cross the bridge.");
    }

    public synchronized void leaveBridge(String name){
        isBridgeOccupied = false;
        System.out.println(name + "has left the bridge.");
        notify();
    }
}