package ok;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class dao {
    public static void main(String[] args) {
      new Thread(()->{
          System.out.println("hello from other thread");
      }).start();


    }
}
