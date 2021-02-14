public class RaceCondition {

    public int in = 0;

    public RaceCondition(String[] args) {

        // read args
        int count_max = 0;
        try {
            count_max = Integer.parseInt(args[0])/2;
        } catch (Exception e) {
            System.out.println("There was no number in args[0] exiting");
            System.exit(-1);
        }
        // start with two normal racers, let them collectively count to count_max
        Racer racer1 = new Racer(count_max, this);
        Racer racer2 = new Racer(count_max, this);
        // start both of them
        racer1.start();
        racer2.start();
        // wait till they are done
        try {
            racer1.join();
            racer2.join();
        } catch (InterruptedException ie) {
            System.out.println("There was an Error with joining the two racers");
            System.exit(-1);
        }
        // print result
        System.out.println("normal racers count sum: \t" + in);

        // restart with synchronized racers
        in = 0;
        SynchronizedRacer racer3 = new SynchronizedRacer(count_max, this);
        SynchronizedRacer racer4 = new SynchronizedRacer(count_max, this);
        // start both of them
        racer3.start();
        racer4.start();
        // wait till they are done
        try {
            racer3.join();
            racer4.join();
        } catch (InterruptedException ie) {
            System.out.println("There was an Error with joining the two racers");
            System.exit(-1);
        }
        // print result
        System.out.println("synchronized racers count sum: \t" + in);
    }

    public static void main(String[] args) {
        new RaceCondition(args);
    }
}
