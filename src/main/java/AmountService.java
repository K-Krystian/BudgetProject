import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AmountService {

    List<AmoutModel> amountList = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public String getUserInput() {
        return sc.nextLine().trim();
    }

    private static int count = 0;

    public List<AmoutModel> addAmount() {
        AmoutModel amoutModel = new AmoutModel();
        CategoryModel categoryModel;
        CategoryService categoryService = new CategoryService();


        amoutModel.setId(count++);

        Pattern amountPattern = Pattern.compile("[0-9]+\\.?\\d{0,2}");
        String inputAmount;
        do {
            System.out.println("Podaj kwotę: ");
            inputAmount = getUserInput();
            if (amountPattern.matcher(inputAmount).matches()) {
                amoutModel.setAmount(Double.parseDouble(inputAmount));
            } else {
                System.out.println("Kwota musi być podana w formacie liczobym z separatorem \".\" np. X.X");
            }
        } while (amoutModel.getAmount() == null);
        System.out.println("podaj kategorię: ");
        categoryModel = categoryService.addCategory();
        amoutModel.setCategoryModel(categoryModel);
        amoutModel.setLocalDate(LocalDate.now());
        amountList.add(amoutModel);
        return amountList;
    }

    public void getAmountList() {
        for (int i = 0; i < amountList.size(); i++) {
            System.out.println(amountList.get(i));
        }
        System.out.println(amountList.size());

        System.out.println("Sortowanko! Wybierz opcję sortowania:");
        System.out.println("[1] - kwota rosnąco");
        System.out.println("[2] - kwota malejąco");
        System.out.println("[3] - Data od najnowszej");
        System.out.println("[4] - Data od najstarszej");
        System.out.println("[5] - Pokaż tylko przychody");
        System.out.println("[6] - Pokaż tylko wydatek");
        System.out.println("[x] - powrót do menu");

        String scIn = getUserInput().toLowerCase();

        do {
            if (scIn.equals("1")) {
                sortByAmount();
                break;
            } else if (scIn.equals("2")) {
                reverseSortByAmount();
                break;
            } else if (scIn.equals("3")) {
                sortedByDate();
                break;
            } else if (scIn.equals("4")) {
                reverseSortedByDate();
                break;
            }else if ((scIn.equals("5"))) {
                showOnlyIncoming();
                break;
            }else if (scIn.equals("6")) {
                showOnlyOutgoing();
                break;
            }

        } while (!scIn.equalsIgnoreCase("x"));
    }

    public List<AmoutModel> deleteAmount() {
        System.out.println("Podaj indeks do usunięcia: ");
        Iterator<AmoutModel> it = amountList.iterator();
        Integer scId = sc.nextInt();
        while (it.hasNext()) {
            AmoutModel am = it.next();
            if (am.getId().equals(scId)) {
                it.remove();
                break;
            }
        }
        return amountList;
    }

    public List<AmoutModel> sortByAmount() {
        amountList.sort(Comparator.comparing(AmoutModel::getAmount));
        for (int i = 0; i <amountList.size() ; i++) {
            System.out.println(amountList.get(i));
        }
        return amountList;
    }

    public List<AmoutModel> reverseSortByAmount() {
        amountList.sort(Comparator.comparing(AmoutModel::getAmount).reversed());
        for (int i = 0; i <amountList.size() ; i++) {
            System.out.println(amountList.get(i));
        }
        return amountList;
    }

    public List<AmoutModel> sortedByDate() {
        amountList.sort(Comparator.comparing(AmoutModel::getLocalDate));
        for (int i = 0; i <amountList.size() ; i++) {
            System.out.println(amountList.get(i));
        }
        return amountList;
    }

    public List<AmoutModel> reverseSortedByDate() {
        amountList.sort(Comparator.comparing(AmoutModel::getLocalDate).reversed());
        for (int i = 0; i <amountList.size() ; i++) {
            System.out.println(amountList.get(i));
        }
        return amountList;
    }
    public void showOnlyIncoming() {
        List<AmoutModel> aa = amountList.stream()
                .filter(amoutModel -> amoutModel.getCategoryModel().getInOut().equals("Przychód"))
                .collect(Collectors.toList());
        for (int i = 0; i <aa.size() ; i++) {
            System.out.println(aa.get(i));
        }
    }

    public void showOnlyOutgoing() {
        List<AmoutModel> bb = amountList.stream()
                .filter(amoutModel -> amoutModel.getCategoryModel().getInOut().equals("Wydatek"))
                .collect(Collectors.toList());
        for (int i = 0; i <bb.size() ; i++) {
            System.out.println(bb.get(i));
        }
    }
}

