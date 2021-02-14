class Racer extends Thread {
    int count_max = 0;
    RaceCondition father;

    public Racer(int count_max, RaceCondition raceCondition) {
        this.count_max = count_max;
        this.father = raceCondition;
    }

    @Override
    public void run() {
        for (int i = 0; i < count_max; i++) {
            // raus kopieren
            int next_free_slot = father.in;
            // erhöhen
            next_free_slot++;
            // rein kopieren
            father.in = next_free_slot;
        }
    }
}
