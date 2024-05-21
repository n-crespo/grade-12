import java.util.Date;

/**
 * Ticket
 */
public class Ticket {
  private long ticketNumber; // to identify unique ticket
  private String category; // adult, child, senior
  private String TicketHolder; // name of person who bought ticket
  private Date date; // admission date
  private double price;
  private boolean isPurchased;

  public long getTicketNumber() {
    return ticketNumber;
  }

  public void setTicketNumber(long ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getTicketHolder() {
    return TicketHolder;
  }

  public void setTicketHolder(String ticketHolder) {
    TicketHolder = ticketHolder;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public double getPrice() {
    return price;
  }

  public boolean isPurchased() {
    return isPurchased;
  }

  public void setPurchased(boolean isPurchased) {
    this.isPurchased = isPurchased;
  }

  public Ticket(long ticketNumber, String category, String TicketHolder, Date date, double price, boolean isPurchased) {
    this.ticketNumber = ticketNumber;
    this.category = category;
    this.TicketHolder = TicketHolder;
    this.date = date;
    this.price = price;
    this.isPurchased = isPurchased;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void changePurchasedStatus() {
    isPurchased = !isPurchased;
  }

  public String toString() {
    return "Ticket{" +
        "ticketNumber=" + ticketNumber +
        ", \ncategory='" + category + '\'' +
        ", \nTicketHolder='" + TicketHolder + '\'' +
        ", \ndate=" + date +
        ", \nprice=" + price +
        ", \nisPurchased=" + isPurchased +
        '}';
  }
}
