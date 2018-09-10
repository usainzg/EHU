package utilidades;

public class Temporizador {
    private long startTime;
    private long endTime;
    private long timeMili;
    private long timeNano;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
        setTime();
    }

    private void setTime() {
        timeNano = (endTime - startTime);
        timeMili = (endTime - startTime) / 1000000;
    }


    public void showTime() {
        System.out.println("Tiempo transcurrido: ");
        System.out.println("-> " + timeMili + " milisegundos");
        System.out.println("-> " + timeNano + " nanosegundos");
    }
}
