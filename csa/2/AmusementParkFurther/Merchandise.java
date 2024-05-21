/**
 * Merchandise
 */
public class Merchandise {

  private long id;
  private String category; // "T-Shirt", Sweatshirt, Stuffed Animal, UNKOWN
  private String description;
  private double price;
  private boolean inStock; // inStock or onOrder

  public Merchandise(long id, String category, String description, double price, boolean inStock) {
    this.id = id;
    this.category = category;
    this.description = description;
    this.price = price;
    this.inStock = inStock;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public boolean isInStock() {
    return inStock;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setInStock(boolean inStock) {
    this.inStock = inStock;
  }

}
