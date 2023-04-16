package fast.dependency.injector;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Context {
    Map<String, Object> worekZBeanami;

    public Context() {
        this.worekZBeanami = new HashMap<>();
    }

    public <T> T getBean(Class<T> expectedClass){
        return expectedClass.cast(worekZBeanami.get(expectedClass.getName()));
    }

    public void addBean(Object object){
        worekZBeanami.put(object.getClass().getName(), object);
    }

    public <T> void createBeanOfType(Class<T> expectedClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T> constructor = expectedClass.getConstructor();
        T t = constructor.newInstance();
        worekZBeanami.put(t.getClass().getName(), t);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Context context = new Context();
        context.addBean("String");
        context.addBean(new Random().nextInt());
        context.createBeanOfType(ArrayList.class);

        //@Autowired
        String string = context.getBean(String.class);
        Integer randomNumber = context.getBean(Integer.class);
        ArrayList emptyList = context.getBean(ArrayList.class);
        System.out.println(string);
        System.out.println(randomNumber);
        System.out.println(emptyList);
    }
}
