package houwing.top.cake_site.entity;

public class Cake {
    private int id;
    private String cakename;
    private int category;
    private String image;
    private String brand;
    private String taste;
    private int sweet;
    private double weight;
    private int size;
    private String ingredients;
    private String status;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private Catalog catalog;


    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", cakename='" + cakename + '\'' +
                ", category=" + category +
                ", image='" + image + '\'' +
                ", brand='" + brand + '\'' +
                ", taste='" + taste + '\'' +
                ", sweet=" + sweet +
                ", weight=" + weight +
                ", size=" + size +
                ", ingredients='" + ingredients + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", catalog=" + catalog +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCakename() {
        return cakename;
    }

    public void setCakename(String cakename) {
        this.cakename = cakename;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public int getSweet() {
        return sweet;
    }

    public void setSweet(int sweet) {
        this.sweet = sweet;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
