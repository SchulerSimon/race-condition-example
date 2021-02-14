class SynchronizedRacer extends Racer {
    public SynchronizedRacer(int count_max, RaceCondition raceCondition) {
        super(count_max, raceCondition);
    }

    @Override
    public void run() {
        // synchronize the run method of the racers
        synchronized (father) {
            super.run();
        }
    }
}