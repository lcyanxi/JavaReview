package com.javareview.common.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;

/**
 * Created by lcyanxi on 2017/7/27.
 */
public class TestForPoxy {
    public static void main(String args[]){
        PersonService personService=new PersonServiceImpl();
        System.out.println(personService.getClass().getSimpleName());
        JDKProxyFactory jdkProxyFactory=new JDKProxyFactory();
        Object o =jdkProxyFactory.createProxyIntance(personService);
        System.out.println(o.getClass().getSuperclass());

    }
}
class JdkPoxy{
    public static Object getPoxyObject(final Object object){
       Object o= Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object reobject=null;
                System.out.println("you say...............");
                reobject=method.invoke(object,args);
                System.out.println("["+ Calendar.getInstance().get(Calendar.HOUR)+":"
                +Calendar.getInstance().get(Calendar.MINUTE)+Calendar.getInstance().get(Calendar.SECOND));
                return reobject;
            }
        });
        return o;
    }
}

class JDKProxyFactory implements InvocationHandler{
    private  Object targetObject;
    public Object createProxyIntance(Object targetObject){
        this.targetObject=targetObject;
        return  Proxy.newProxyInstance(this.getClass().getClassLoader(),this.getClass().getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PersonServiceImpl personServiceImpl=(PersonServiceImpl) this.targetObject;
        return  method.invoke(targetObject,args);
    }
}
