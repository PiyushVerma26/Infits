package hello.tech.infits.Modals;

public class GraphModal {
    private  String month;
    private String date;
    private String item;
    private String quantity;
    private String time;

    public GraphModal(String month, String date, String item, String quantity, String time) {
        this.month = month;
        this.date = date;
        this.item = item;
        this.quantity = quantity;
        this.time = time;
    }

    public GraphModal() {
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
