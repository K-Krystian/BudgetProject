import java.time.LocalDate;

public class AmoutModel {

    private Integer id;
    private Double amount;
    private CategoryModel categoryModel;
    private LocalDate localDate;

    public AmoutModel() {
    }

    @Override
    public String toString() {
        return "AmoutModel{" +
                "id=" + id +
                ", amount=" + amount +
                ", categoryModel=" + categoryModel +
                ", localDate=" + localDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
