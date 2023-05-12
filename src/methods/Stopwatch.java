class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public void elapsedTime() {
        long now = System.currentTimeMillis();
        System.out.println(now - start);

    }
}

