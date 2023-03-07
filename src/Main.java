import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет! Этот мини софт поможет рассчитать твою зп, а так же выплаты 15 числа:)");
        System.out.println("Напиши цифру месяца, 1 это январь, 12 декабрь");
        int month = scanner.nextInt();

        int[] days = {17, 18, 22, 20, 20, 21, 21, 23, 21, 22, 21, 21};

        double zarplata = 0; // Зарплата
        int plan = 480; //План по заявка
        int planp = 480; //Факт по заявкам
        double oklad = 25000; //Оклад
        double prem = 25;
        double sutki = 0;
        month = month - 1; // Корректируем дни из массива
        int dopy = 0; //количество переводов.
        final int dopys = 300;//Ставка переводов, не изменяемая
        int day = days[month]; //Дней отработано.

        while (true) {
            if (sutki == 0) {
                System.out.println("1 - Рассчитать зп, оклад " + oklad + "Р, " + day + " рабочих смен, план по заявкам " + plan + " Выполненых заявок " + planp + ", переводов " + dopy);
                System.out.println("2 - Изменить оклад");
            } else {
                System.out.println("1 - Рассчитать зп, сутки " + oklad + "Р, " + day + " рабочих суток, план по заявкам " + plan + " Выполненых заявок " + planp + ", переводов " + dopy);
                System.out.println("2 - Изменить суточные");
            }
            System.out.println("3 - Изменить кол-во отработанных смен");
            System.out.println("4 - Изменить план заявок");
            System.out.println("5 - Изменить факт заявок");
            System.out.println("6 - Изменить оплату за сверх заявки");
            System.out.println("7 - Указать количество переводов/запусков");
            System.out.println("8 - Переключить режим суточник/дневной");
            System.out.println("9 - Заработать миллион");
            System.out.println("0 - Выход");
            double otvet = scanner.nextInt();

            if (otvet == 1) {
                if (sutki == 0) {
                    if (plan < planp) {
                        zarplata = (oklad + ((day - days[month]) * (oklad / days[month])) + ((planp - plan) * prem) + (dopy * dopys));
                    } else {
                        zarplata = (oklad + ((day - days[month]) * (oklad / days[month])) + (dopy * dopys));
                    }
                } else {
                    if (plan < planp) {
                        zarplata = ((oklad * day) * ((planp - plan) * prem) + (dopy * dopys));
                    } else {
                        zarplata = ((oklad * day) + (dopy * dopys));
                    }
                }
                System.out.printf("Ваша зарплата за месяц " + "%.2f", zarplata);
                break;
            } else if(otvet == 2) {
                System.out.println("Введите новый оклад");
                oklad = scanner.nextDouble();
            } else if (otvet == 3) {
                System.out.println("Введите кол-во рабочих дней");
                day = scanner.nextInt();
            } else if (otvet == 4) {
                System.out.println("Введите новый план заявок");
                plan = scanner.nextInt();
            } else if (otvet == 5) {
                System.out.println("Введите новый факт заявок");
                planp = scanner.nextInt();
            } else if (otvet == 6) {
                System.out.println("Введите новую оплату сверх выполненных заявок");
                prem = scanner.nextInt();
            } else if (otvet == 7) {
                System.out.println("Введите количество переводов/запусков");
                dopy = scanner.nextInt();
            } else if (otvet ==8) {
                if (sutki == 0) {
                    sutki = 1;
                    oklad = 3572;
                }
                else if (sutki == 1){
                    sutki = 0;
                    oklad = 25000;
                }
            } else if (otvet == 9) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            } else if (otvet == 0) {
                System.out.println("Выход");
                System.out.println("Спасибо за тест (C)Кир");
                break;
            } else {
                System.out.println("Ошибка, такого пунка нет");
            }
        }
    }
}