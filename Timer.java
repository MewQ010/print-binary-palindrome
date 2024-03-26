
public class Timer {
    private int seconds; // створюємо приватні поля
    private boolean isRunning;
    private Thread thread;

    public Timer() { // функція таймер
        seconds = 0; // початкові секунди 0
        isRunning = false; // запущенний таймер? поки ні
        thread = new Thread(new TimerThread()); //
    }

    public void start() { // функція початку таймера
        isRunning = true;
        thread.start();
    }

    public void stop() { // функція кінця таймеру
        isRunning = false;
    }

    public int getSeconds() { // отримання секунд з таймера
        return seconds;
    }

    private class TimerThread implements Runnable { // реалізуємо інтерфейс Runnable, поток таймера
        @Override // зміни для наслідування
        public void run() {
            while (isRunning) { // цикл поки isRunning == true
                try { // питаємо чи є вже 1000 мілісекунд
                    Thread.sleep(1000); // якщо мілісекунди == 1000, то добавити 1 до секунд
                    seconds++;
                } catch (InterruptedException e) { // відкидаємо помилку InterruptedException
                    e.printStackTrace();
                }
            }
        }
    }
}
