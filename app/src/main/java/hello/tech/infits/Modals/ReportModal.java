package hello.tech.infits.Modals;

public class ReportModal {
    private String type;
    private String kcal;
    private String date;
    private String time;

    public ReportModal(String type, String kcal, String date, String time) {
        this.type = type;
        this.kcal = kcal;
        this.date = date;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
