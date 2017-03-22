package tr.com.yusufgunduz.tests;

import org.hibernate.Session;
import tr.com.yusufgunduz.tests.entity.User;

/**
 * Created by Kambaa on 3/22/17.
 */
public class App {

    public static void main(String args[]) {
        // project main operations start here.

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Check database version
        String sql = "select version()";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User u = new User();
        u.setName("Kambaa");

        session.save(u);
        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();


    }
}
