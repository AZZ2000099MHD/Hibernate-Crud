import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import  org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private  static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){


        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();


        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Vehicle.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(Item.class)

//                .addAnnotatedClassName("org.hibernate.example.Customer")
//                .addResource("org/hibernate/example/Order.hbm.xml")
//                .addResource("org/hibernate/example/Product.orm.xml")
//
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();


               return   metadata.getSessionFactoryBuilder()
//                .applyBeanManager(getBeanManager())
                .build();
    }


    public Session openSession(){
        return  sessionFactory.openSession();
    }


}
