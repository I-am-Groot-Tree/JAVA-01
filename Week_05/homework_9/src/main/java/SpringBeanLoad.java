
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanLoad {

    public static void main(String[] args) {
        //xml方式 加载bean实例
        ApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");
        xmlLoad(contex);
        // annotation方式
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(StudentConfig.class);
        context.refresh();
        annotationLoad(context);
        //beanFactory方式
        method3();
    }

    /**
     * Xml方式加载bean
     */
    private static void xmlLoad(ApplicationContext context) {
        Student groot = (Student) context.getBean("groot");
        System.out.println(groot.toString());
    }

    /**
     * annotation方式加载bean
     */
    private static void annotationLoad(ApplicationContext context) {
        Student student = (Student) context.getBean("student01");
        System.out.println(student.toString());
    }

    //    /**
//     * beanFactory方式加载bean
//     * */
    private static void method3() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        ConstructorArgumentValues cargs = new ConstructorArgumentValues();
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("id", 3);
        propertyValues.addPropertyValue("age", 30);
        propertyValues.addPropertyValue("name", "kimmking");
        AbstractBeanDefinition bean03 = new RootBeanDefinition(Student.class, cargs, propertyValues);
        beanFactory.registerBeanDefinition("student03", bean03);
        Student student03 = (Student) beanFactory.getBean("student03");
        System.out.println(student03.toString());
    }
}
