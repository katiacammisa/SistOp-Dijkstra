import java.io.IOException;

public class Consumer implements ThreadRunnable {

  // Create consumer thread
  private final SharedArea shared;
  private final Thread cons_thread;

  public Consumer(SharedArea shared) {
    this.shared = shared;
    this.cons_thread = new Thread(this);
  }

  @Override
  public void start() {
    cons_thread.start();
  }

  @Override
  public void join() throws InterruptedException {
    cons_thread.join();
  }

  @Override
  public void run() {
    try {
      while (true) {
        Thread.sleep(1000);
        shared.consume();
      }
    } catch (InterruptedException | IOException e) {
      e.printStackTrace();
    }
  }
}
