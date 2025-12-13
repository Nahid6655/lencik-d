public class Main {

    public static void main(String[] args) {

        StringArrayByLength array = new StringArrayByLength(10);

        array.add("Java");
        array.add("C");
        array.add("Python");
        array.add("Go");
        array.add("JavaScript");

        System.out.println("All elements:");
        array.print();

        System.out.println("\nMax length element: " + array.getMax());

        System.out.println("Average length: " + array.getAverageLength());
    }
}

class StringArrayByLength {

    private final String[] data;
    private int size = 0;

    public StringArrayByLength(int capacity) {
        data = new String[capacity];
    }

    // Добавление элемента без сортировки (вставка на нужное место)
    public void add(String value) {
        if (size == data.length) {
            throw new RuntimeException("Array is full");
        }

        int index = 0;

        // ищем позицию для вставки
        while (index < size && data[index].length() <= value.length()) {
            index++;
        }

        // сдвигаем элементы вправо
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    // Возвращает максимальный (по длине) элемент
    public String getMax() {
        if (size == 0) {
            return null;
        }
        return data[size - 1];
    }

    // Возвращает среднюю длину строк
    public double getAverageLength() {
        if (size == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += data[i].length();
        }

        return (double) sum / size;
    }

    // Метод для тестирования
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i] + " (" + data[i].length() + ")");
        }
    }
}
