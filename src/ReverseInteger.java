public class ReverseInteger {
    public static void main(String[] args) {
        int nuumber =3120 ;
        reverseTheNumber(nuumber);
    }

    private static void reverseTheNumber(int number) {
        while(number > 10){
            int mod = number%10;
            number = number/10;
            System.out.print(mod);
        }
        System.out.print(number);
    }
}
