public class HipHopRunnable implements Runnable {
    String text;
    String name;
    int p;
    @Override
    public void run() {
        while (true){
            System.out.println("Name: " + name +", Priority: " + p + " ," + text);
        }
    }

    public void setText(String s) {
        text = s;
    }

    public void setName(String s) {
        name = s;
    }
    public void setP(int s) {
        p = s;
    }



    public static void main(String[] args){
        HipHopRunnable hip = new HipHopRunnable();
        Thread hipT = new Thread(hip);
        hip.setText("Hip");
        hip.setName(hipT.getName());
        hip.setP(hipT.getPriority());
        HipHopRunnable hop = new HipHopRunnable();
        Thread hopT = new Thread(hop);
        hop.setText("Hop");
        hop.setName(hopT.getName());
        hop.setP(hopT.getPriority());

        hipT.start();
        hopT.start();
    }
}
