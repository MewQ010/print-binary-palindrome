public class BinaryPalindrome {
    public static void main(String[] args) {
        Timer timer = new Timer(); // створюємо таймер
        timer.start(); // запускаємо таймер
        for (int i = -2147483647; i <= 2147483647; i++) { // цикл для перебору
            if (binPal(i)) {
                System.out.println(i + " : " + binStr(i)); // вивід числа якщо він відповідає умовам
            }
            if (i == 2147483647) { // зупинка циклу при максимальному числі
                break;
            }
        }
        timer.stop(); // зупиняємо таймер після виконання циклу
        long seconds = timer.getSeconds(); // отримуємо секунди з таймера
        long minutes = seconds / 60; // перевід секунд в хвилини
        System.out.println("Программа виконалась за " + minutes + " хв. " + (seconds - minutes * 60) + " сек.");// вивід
        // часу
    }

    public static boolean binPal(int num) { // перевіряємо чи є двійковий код палендромом
        int revNum = revBit(num);
        int numBits = 31 - Integer.numberOfLeadingZeros(num); // тут я згрішив і добавив функцію колекцій, вичислення
                                                              // значущих нулів
        for (int i = 0; i <= numBits / 2; i++) {
            int leftBit = (num >>> i) & 1;
            int rightBit = (revNum >>> i) & 1;
            if (leftBit != rightBit) {
                return false;
            }
        }
        return true;
    }

    public static int revBit(int num) { // перервід числа задом наперед
        int revNum = 0;
        int numBits = 31 - Integer.numberOfLeadingZeros(num); // цю функцію я вже використовував тому це не рахується :)
                                                              // , вичислення значущих нулів
        for (int i = 0; i <= numBits; i++) {
            revNum |= ((num >>> i) & 1) << (numBits - i);
        }
        return revNum;
    }

    public static String binStr(int num) {
        StringBuilder builder = new StringBuilder(); // другий гріх, тут нажаль я створив білдер :(
        int numBits = 31 - Integer.numberOfLeadingZeros(num); // цю функцію я вже використовував, тому це не рахується,
                                                              // я використав це щоб убрати лишні нулі
        for (int i = 0; i <= numBits; i++) {
            builder.insert(0, num & 1); // ну тут все зрозуміло, зибраємо двоїчне число
            num >>>= 1; // здвиг вправо і присвоювання значення
        }
        return builder.toString(); // бог любить трійцю, тому я ще раз згрішив :) , тут перетворюємо тип поля на
        // Str
    }

}
