package interview;

import java.util.*;

public class EggFloor {

    public static class Employee{
        String name ;
        String lastName;
        int id;
         public Employee(String name, int id,String lastname){
            this.name = name;
            this.id = id;
            this.lastName =lastname;
        }

        public String getLastName() {
            return lastName;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }

    public static String NameCollection(String[] strArr) {

        HashMap<String ,Integer> hashMap = new HashMap<>();
        ArrayList<Employee> employees = new ArrayList<>();

        for(int i =0 ; i < strArr.length;i++){
            int [] numSeq = new int[26];
            for(int k = 0 ; k < 26;k++){
                numSeq[k] = 0;
            }
            String first = strArr[i].split(" ")[0];
            String second = strArr[i].split(" ")[1].toLowerCase();

            for(int j = 0 ; j< second.length() ;j++){
                numSeq[second.charAt(j)-'a'] = numSeq[second.charAt(j)-'a']  + 1;
            }

            OptionalInt max = Arrays.stream(numSeq).max();
            hashMap.put(strArr[i], max.getAsInt());
            employees.add(new Employee(strArr[i], max.getAsInt(),second));

        }




        Comparator<Employee> compareByFirstName = Comparator.comparing( Employee::getId );

//last name comparator
        Comparator<Employee> compareByLastName = Comparator.comparing( Employee::getLastName );

//Compare by first name and then last name (multiple fields)
        Comparator<Employee> compareByFullName = compareByFirstName.thenComparing(compareByLastName);

//Use Comparator
        Collections.sort(employees, compareByFullName);


        String ans = "";
        for(int i =0 ; i < employees.size() ; i ++){
            if(ans.length() != 0){
                ans = ans+ ",";
            }
            ans = ans + employees.get(i).getName() ;
        }

        // code goes here
        return ans;
    }

    private static boolean checkIFExists(int[] arr, int start, int end,int a,int b) {
        for(int i = start ;i<end-1 ;i++){
            if(arr[i] == a && arr[i+1] == b){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(NameCollection(new String[] {"Brad Pitt","Leonardo DiCaprio","Charlize Theron"}
        ));

    }

}