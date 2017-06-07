import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KontoManger2 extends Thread{
    public static List<Thread> threads = new ArrayList<Thread>(0);
    public static Double  Kontostand = 0.0;
    public static int  anzahl = 0;

    public void run() {
        for(int i = 0;i < 100; i++){
           Double betrag = 1.0 ;
              synchronized(getClass()) {
             Kontostand += betrag;
                anzahl++;
              }
                System.out.println(getName() +"Kontostand: " + KontoManger2.Kontostand);
                System.out.println(getName() +"Anzahl der Additionen: " + KontoManger2.anzahl);

            } }


    public static void main(String[] args) {
       for(int i = 0;i < 100; i++){
            KontoManger2 konto = new KontoManger2();
            threads.add(konto);
            konto.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---------------------------Kontostand: " + KontoManger2.Kontostand);
        System.out.println("---------------------------Anzahl der Additionen: " + KontoManger2.anzahl);

    }
}
