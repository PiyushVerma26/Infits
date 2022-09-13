package hello.tech.infits.Modals;

public class AchievementsModal {
    String clientsNumber;
    String achievementsNumber;
    String progress;

    public AchievementsModal(String clientsNumber, String achievementsNumber, String progress) {
        this.clientsNumber = clientsNumber;
        this.achievementsNumber = achievementsNumber;
        this.progress = progress;
    }
    public AchievementsModal(){
    }

    public String getClientsNumber() {
        return clientsNumber;
    }

    public void setClientsNumber(String clientsNumber) {
        this.clientsNumber = clientsNumber;
    }

    public String getAchievementsNumber() {
        return achievementsNumber;
    }

    public void setAchievementsNumber(String achievementsNumber) {
        this.achievementsNumber = achievementsNumber;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
