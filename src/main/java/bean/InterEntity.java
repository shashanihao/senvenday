package bean;

public class InterEntity {
    private int id;
    private String myurl;
    private String mymetnod;
    private boolean ishttp;
    private String mybody;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyurl() {
        return myurl;
    }

    public void setMyurl(String myurl) {
        this.myurl = myurl;
    }

    public String getMymetnod() {
        return mymetnod;
    }

    public void setMymetnod(String mymetnod) {
        this.mymetnod = mymetnod;
    }

    public boolean isIshttp() {
        return ishttp;
    }

    public void setIshttp(boolean ishttp) {
        this.ishttp = ishttp;
    }

    public String getMybody() {
        return mybody;
    }

    public void setMybody(String mybody) {
        this.mybody = mybody;
    }

    @Override
    public String toString() {
        return "InterEntity{" +
                "id=" + id +
                ", myurl='" + myurl + '\'' +
                ", mymetnod='" + mymetnod + '\'' +
                ", ishttp=" + ishttp +
                ", mybody='" + mybody + '\'' +
                '}';
    }
}
