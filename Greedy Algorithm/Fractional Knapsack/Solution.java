class Solution {

    class Item {
        int value, weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;
        Item[] items = new Item[n];

    
        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

    
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (items[i].weight <= capacity) {
                capacity -= items[i].weight;
                totalValue += items[i].value;
            } else {
                totalValue += items[i].ratio * capacity;
                break;
            }
        }

        return totalValue;
    }
}
