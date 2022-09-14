package hello.tech.infits.Modals;

public class InviteModal {
    private int image;
    private  String source;
    private  String name;
    private boolean invite;

    public InviteModal(int image, String source, String name, boolean invite) {
        this.image = image;
        this.source = source;
        this.name = name;
        this.invite = invite;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInvite() {
        return invite;
    }

    public void setInvite(boolean invite) {
        this.invite = invite;
    }
}
