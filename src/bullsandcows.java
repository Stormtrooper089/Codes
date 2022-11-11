public class bullsandcows {
    public static void main(String[] args) {
        //Input: secret = "1807", guess = "7810"
        String secret = "1807";
        String guess = "7810";
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        int length = secret.length();

        for(int i = 0 ; i < length ;i++){
            if(secret.charAt(i) == guess.charAt(i))
            {
                bulls++ ;
            }else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
    }
}
