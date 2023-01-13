import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Para receber a lista dos feriados, digite 'todos'");
        System.out.println("Para sair, digite 'fechar'");

        while(isRunning) {
            System.out.println("Digite que feriado você quer conferir!");
            String entry = scanner.nextLine();

            if(entry.equals("fechar")) {
                System.out.println("Fechando aplicação...");
                isRunning = false;
            } else {
                System.out.println(getMessage(entry));
            }
        }
    }

    private static String getMessage(String entry) {
        Holiday holiday = new Holiday();
        if(entry.equals("todos")) {
            return holiday.getAllHolidays().toString();
        } else {
            return treatMessage(entry, holiday);
        }
    }

    private static String treatMessage(String entry, Holiday holiday) {
        String result = holiday.getHoliday(entry);

        if(result == null) {
            return "Feriado não encontrado!";
        }
        return result;
    }
}