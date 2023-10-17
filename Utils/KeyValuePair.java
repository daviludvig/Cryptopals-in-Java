package Utils;

public class KeyValuePair {
    private float distance;
    private int key;


    public KeyValuePair(int key, float distance) {
        this.distance = distance;
        this.key = key;
    }

    public float getDistance() {
        return distance;
    }

    public int getKey() {
        return key;
    }

    public void updateIfLower(KeyValuePair pair) {
        if (pair.getDistance() < this.distance) {
            this.distance = pair.getDistance();
            this.key = pair.getKey();
        }
    }
}