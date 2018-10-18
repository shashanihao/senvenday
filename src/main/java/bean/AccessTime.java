package bean;

public class AccessTime {
    private int id;
    private String startdata;
    private String pausedata;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartdata() {
        return startdata;
    }

    public void setStartdata(String startdata) {
        this.startdata = startdata;
    }

    public String getPausedata() {
        return pausedata;
    }

    public void setPausedata(String pausedata) {
        this.pausedata = pausedata;
    }

    @Override
    public String toString() {
        return "AccessTime{" +
                "id=" + id +
                ", startdata='" + startdata + '\'' +
                ", pausedata='" + pausedata + '\'' +
                '}';
    }
}
