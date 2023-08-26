package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

class  Employee<T>{
    int age ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }


    int salary ;
    int empId;

    public T returnMethod(T o ){
        return o;
    }
}

/*

1 million msgs in 15 mins

kafka()


--------------------
a  b  c  d
--------------------

application    (4   - consumer group)




 */

public class Clevertap {
    public static void main(String[] args) {
        String s1 = "eggmg";
        String s2 = "addmf";

        /*
        hashMap(e,a)
        hashMap(g,d)
        e g g m g
        a d d m fx
        //guaua redis mongo
        */

        List<Employee> empList = new ArrayList<Employee>();

        List<Employee> filteredList = empList.stream()
                .filter(e -> e.getAge() > 40)
                .filter(e->e.getSalary() > 40000)
                .collect(Collectors.toList());

        ExecutorService excutor = Executors.newFixedThreadPool(10);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("sampling the error");
            }
        };


        CompletableFuture completableFuture = new CompletableFuture<>();

    }
//
//    () -> {
//        System.out.println();
//    };
}
