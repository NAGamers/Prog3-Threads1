import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KontoManger extends Thread{
    public static List<Thread> threads = new ArrayList<Thread>(0);
    public static Double  Kontostand = 0.0;
    public static int  anzahl = 0;
    Random r = new Random();

    public void run() {

        for(int i = 0;i < r.nextInt(100)+5; i++){
            Double betrag = r.nextDouble() ;
            synchronized(getClass()){
            Kontostand += betrag;
            anzahl++;
            }
        System.out.println(getName() +"Kontostand: " + KontoManger.Kontostand);
        System.out.println(getName() +"Anzahl der Additionen: " + KontoManger.anzahl);

        }
        }

    public static void main(String[] args) {
        Random r = new Random();
        for(int i = 0;i < r.nextInt(100)+5; i++){
            KontoManger konto = new KontoManger();
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
        System.out.println("---------------------------Kontostand: " + KontoManger.Kontostand);
        System.out.println("---------------------------Anzahl der Additionen: " + KontoManger.anzahl);
    }
}
