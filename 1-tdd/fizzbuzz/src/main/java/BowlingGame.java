public class BowlingGame {
    public int bonus = 0;
    public int toSpare = 10;
    private int score = 0;
    private int rollNumber = 1;
    public BowlingGame () {}

    public void roll (int n) {
        if(n<0 || n>10) throw new IllegalArgumentException("Numero de pinos invalido");

        if(bonus>0) score += n;
        score += n;
        bonus = Math.max(0, bonus-1);

        boolean firstTryFrame = rollNumber%2 != 0;

        if(toSpare - n == 0){
            if(firstTryFrame){
                bonus += 2;
                rollNumber++;
            } else bonus += 1;
        }
        toSpare = firstTryFrame && toSpare - n != 0 ? toSpare-n : 10;
        rollNumber++;
    }

    public int score () {
        return score;
    }

    public int getRollNumber () {
        return rollNumber;
    }
}
