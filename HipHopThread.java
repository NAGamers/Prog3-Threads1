public class HipHopThread extends Thread{
    String text;
    public void run() {
       while (true){
           System.out.println("Name: " + getName() +", Priority: " + getPriority() + " ," + text);
       }
    }

    public void setText(String s) {
     text = s;
    }


    public static void main(String[] args){
        HipHopThread hip = new HipHopThread();
        hip.setText("Hip");
        HipHopThread hop = new HipHopThread();
        hop.setText("Hop");

        hip.start();
        hop.start();


    }
}
