import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class CalendarDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 年月を入力する
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Enter the month: ");
        int month = scanner.nextInt();

        // カレンダーを作成する
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        // カレンダーのヘッダーを表示する
        System.out.println("     " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, Locale.getDefault()) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        // 最初の日を求める
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        for (int i = 0; i < firstDayOfWeek; i++) {
            System.out.print("   ");
        }

        // カレンダーの日付を表示する
        int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= lastDayOfMonth; i++) {
            System.out.printf("%2d ", i);
            if ((i + firstDayOfWeek) % 7 == 0) {
                System.out.println();
            }
        }

        scanner.close();
    }
}
