package javaff.samples.beans;

import io.github.rhkiswani.javaff.json.JsonHandler;
import io.github.rhkiswani.javaff.json.JsonHandlerFactory;

public class Main {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Kiswani");
        emp.setEmpId(1000);

        // comment jakson in pom.xml
        System.out.println("\n======================= Default based on class path ========================");
        // default json handler gson
        System.out.println(JsonHandlerFactory.getJsonHandler(Employee.class).toJson(emp));
        System.out.println(JsonHandlerFactory.getJsonHandler(Employee.class).getImplementation());


        // when you uncomment jakson from the pom.xml
        System.out.println(JsonHandlerFactory.getJsonHandler(Employee.class).toJson(emp));
        System.out.println(JsonHandlerFactory.getJsonHandler(Employee.class).getImplementation());

        System.out.println("\n======================= Force to use Gson By annotation ========================");
        // you want to have jakson for all the classes except the student , student should use Gson
        // you need to add @GsonBean
        Student std = new Student();
        std.setId(100);
        std.setName("Kiswani");
        std.setStdId(1000);
        System.out.println(JsonHandlerFactory.getJsonHandler(Student.class).toJson(emp));
        System.out.println(JsonHandlerFactory.getJsonHandler(Student.class).getImplementation());

        System.out.println("\n======================= Custom Json Handler ========================");
        // you want to add your custom implantation
        // Note : if you set your custom it will be used everywhere
        JsonHandlerFactory.instance().setDefault(new MyJsonHandler());

        System.out.println(JsonHandlerFactory.getJsonHandler(Employee.class).toJson(emp));
        System.out.println(JsonHandlerFactory.getJsonHandler(Employee.class).getImplementation());

        System.out.println(JsonHandlerFactory.getJsonHandler(Student.class).toJson(emp));
        System.out.println(JsonHandlerFactory.getJsonHandler(Student.class).getImplementation());
    }

    private static class MyJsonHandler implements JsonHandler {
            public <T> T fromJson(String s, Class aClass) {
                return null;
            }

        public String toJson(Object o) {
            return o.toString();
        }

        public Object getImplementation() {
            return MyJsonHandler.class;
        }
    }
}
