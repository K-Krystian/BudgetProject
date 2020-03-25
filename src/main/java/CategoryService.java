import java.util.Scanner;

public class CategoryService {

    private static int c = 0;

    public static final CategoryModel addCategory() {
        CategoryModel categoryModel = new CategoryModel();

        categoryModel.setId(c++);
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Wpisz I jeśli to przychód. Wpisz O jeśli to wydatek");

            String inp = s.nextLine().toLowerCase();

            switch (inp) {
                case "i":
                    categoryModel.setInOut(InOut.IN.getDescription());
                    break;
                case "o":
                    categoryModel.setInOut(InOut.OUT.getDescription());
                    break;
                    default:
                        System.out.println("coś poszło nie tak z tą kategorią, matole!");
            }

        } while (categoryModel.getInOut()== null);

        System.out.println("Wpisz dodatkowy opis: ");
        categoryModel.setDecribe(s.nextLine());

        System.out.println("Wpisz kategorię: ");
        categoryModel.setCategory(s.nextLine());

    return categoryModel;}
}
