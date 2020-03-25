import java.sql.Struct;

public class CategoryModel {


    private Integer id;
    private String inOut;
    private String decribe;
    private String category;

    public CategoryModel() {
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "id=" + id +
                ", inOut='" + inOut + '\'' +
                ", decribe='" + decribe + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public String getDecribe() {
        return decribe;
    }

    public void setDecribe(String decribe) {
        this.decribe = decribe;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
