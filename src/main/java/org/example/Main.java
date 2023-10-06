package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        //Завдання 1:
        //Створіть і викличте наступні лямбда-вирази:
        // Підрахунок суми трьох чисел
        // Підрахунок добутку трьох цілих чисел
        // Вивід поточного часу
        // Вивід поточної дати
        CalculateSum calculateSum = (a, b, c) -> a + b + c;
        int sum = calculateSum.calculate(10, 20, 30);
        System.out.println("Sum: " + sum);

        CalculateMultiply calculateMultiply = (a, b, c) -> a * b * c;
        int multiply = calculateMultiply.calculate(10, 20, 30);
        System.out.println("Multiply: " + multiply);

        GetCurrentTimeAndDisplay currentTime = () -> {
            String time = LocalTime.now().toString();
            System.out.println("Current time: " + time);
        };
        currentTime.displayCurrentTime();

        GetCurrentDayAndDisplay currentDay = () -> {
            String day = LocalDate.now().toString();
            System.out.println("Current day: " + day);
        };
        currentDay.displayCurrentDay();

        //Завдання 2:
        //Створіть і викличте наступні лямбда-вирази:
        // Максимум із двох
        // Мінімум із двох
        // Факторіал числа
        // Перевірка просте число чи ні
        FindMaximum maximum = Math::max;
        int max = maximum.FindMax(10, 20);
        System.out.println("Maximum: " + max);

        FindMinimum minimum = Math::min;
        int min = minimum.FindMin(10, 20);
        System.out.println("Minimum: " + min);

        CalculateFactorial calculateFactorial = (n) -> {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        };
        int factorial = calculateFactorial.calculate(5);
        System.out.println("Factorial: " + factorial);

        CheckPrime checkPrime = (n) -> {
            if (n <= 1) {
                return false;
            }

            if (n <= 3) {
                return true;
            }

            if (n % 2 == 0 || n % 3 == 0) {
                return false;
            }

            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        };

        boolean isPrime = checkPrime.test(7);
        String answer = isPrime ? "7 is prime number" : "7 is not prime number";
        System.out.println(answer);

        //Завдання 3:
        //Створіть і викличте наступні лямбда-вирази. Обов’язково використайте шаблони:
        // Максимум із трьох
        // Мінімум із трьох
        FindMaximumOfThree findMaximumOfThree = (a, b, c) -> {
            Integer maxNum = (Integer) a;
            if (b.compareTo(maxNum) > 0) {
                maxNum = (Integer) b;
            }

            if (c.compareTo(maxNum) > 0) {
                maxNum = (Integer) c;
            }
            return maxNum;
        };

        Integer maxVal = (Integer) findMaximumOfThree.findMax(10, 20, 30);
        System.out.println("Maximum of three values: " + maxVal);

        FindMinimumOfThree minimumOfThree = (a, b, c) -> {
            Integer minNum = (Integer) a;
            if (b.compareTo(minNum) < 0) {
                minNum = (Integer) b;
            }

            if (c.compareTo(minNum) < 0) {
                minNum = (Integer) c;
            }
            return minNum;
        };

        Integer minVal = (Integer) minimumOfThree.findMin(10, 20, 30);
        System.out.println("Minimum of three values: " + minVal);

        //Завдання 4:
        //Створіть і викличте наступні лямбда-вирази. Обов’язково використайте лямбду, як параметр
        //методу. Метод знаходить суму елементів масиву, що відповідають умові лямбда-виразу. Варіанти
        //лямбда-виразів:
        // Перевірка на парність
        // Перевірка на непарність
        // Чи знаходить число в діапазоні від А до В
        // Перевірка на кратність параметру A
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sumOfEvens = sumMatchingCondition(numbers, n -> n % 2 == 0);
        System.out.println("Sum of evens: " + sumOfEvens);

        int sumOfOdds = sumMatchingCondition(numbers, n -> n % 2 != 0);
        System.out.println("Sum of odds: " + sumOfOdds);

        int a = 3, b = 7;
        int sumInRange = sumMatchingCondition(numbers, n -> n >= a && n <= b);
        System.out.println("Sum in range: " + sumInRange);

        int multiple = 3;
        int sumOfMultiples = sumMatchingCondition(numbers, n -> n % multiple == 0);
        System.out.println("Sum of multiples: " + sumOfMultiples);
    }

    @FunctionalInterface
    interface CalculateSum {
        int calculate(int a, int b, int c);
    }

    @FunctionalInterface
    interface CalculateMultiply {
        int calculate(int a, int b, int c);
    }

    @FunctionalInterface
    interface GetCurrentTimeAndDisplay {
        void displayCurrentTime();
    }

    @FunctionalInterface
    interface GetCurrentDayAndDisplay {
        void displayCurrentDay();
    }

    @FunctionalInterface
    interface FindMaximum {
        int FindMax(int a, int b);
    }

    @FunctionalInterface
    interface FindMinimum {
        int FindMin(int a, int b);
    }

    @FunctionalInterface
    interface CalculateFactorial {
        int calculate(int n);
    }

    @FunctionalInterface
    interface CheckPrime {
        boolean test(int n);
    }

    @FunctionalInterface
    interface FindMaximumOfThree<T extends Comparable<T>> {
        T findMax(T a, T b, T c);
    }

    @FunctionalInterface
    interface FindMinimumOfThree<T extends Comparable<T>> {
        T findMin(T a, T b, T c);
    }

    public static int sumMatchingCondition(Integer[] arr, Condition condition) {
        int sum = 0;
        for (Integer num : arr) {
            if (condition.test(num)) {
                sum += num;
            }
        }
        return sum;
    }

    @FunctionalInterface
    interface Condition {
        boolean test(int n);
    }
}