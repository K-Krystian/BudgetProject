public class Main {

    public static void main(String[] args) {

        AmountService amountService = new AmountService();

        String userSelection;

        do {
            System.out.println();
            System.out.println("Wprować cyfrę opcji i zatwierdź enterem");
            System.out.println("[1] - dodaj kwotę");
            System.out.println("[2] - wyświetl listę wprowadzonych kwot");
            System.out.println("[3] - usuń kwotę");
            System.out.println("[x] - zakończ program");
            userSelection = amountService.getUserInput();
            if (userSelection.equals("1")) {
                amountService.addAmount();
            } else if (userSelection.equals("2")) {
                amountService.getAmountList();
            } else if (userSelection.equals("3")) {
                amountService.deleteAmount();
            }
        } while (!userSelection.equalsIgnoreCase("x"));
    }

}
