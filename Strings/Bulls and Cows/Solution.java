class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] freq = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                int s = secret.charAt(i) - '0';
                int g = guess.charAt(i) - '0';

                if (freq[s] < 0) cows++;
                if (freq[g] > 0) cows++;

                freq[s]++;
                freq[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}