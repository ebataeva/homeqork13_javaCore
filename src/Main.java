public class Main {
    public static void main(String[] args) throws InterruptedException {


        Thread myThread = new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                System.out.println("привет");
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
        });
        myThread.start();
        myThread.join();
            System.out.println("поток окончил выполнениие");

    }
}