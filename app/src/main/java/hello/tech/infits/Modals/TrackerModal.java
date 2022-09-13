package hello.tech.infits.Modals;

public class TrackerModal {
    private int image;
    private  String Name;
    private  String description;

    public  TrackerModal()
    {

    }

    public TrackerModal(int image, String name, String description) {
        this.image = image;
        Name = name;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
