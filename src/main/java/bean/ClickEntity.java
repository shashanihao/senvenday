package bean;

public class ClickEntity {
    public int id;

    public String clickBtnTime;
    public String clickBtnText;
    public String btnNextDecriber;
    public String whichPage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClickBtnTime() {
        return clickBtnTime;
    }

    public void setClickBtnTime(String clickBtnTime) {
        this.clickBtnTime = clickBtnTime;
    }

    public String getClickBtnText() {
        return clickBtnText;
    }

    public void setClickBtnText(String clickBtnText) {
        this.clickBtnText = clickBtnText;
    }

    public String getBtnNextDecriber() {
        return btnNextDecriber;
    }

    public void setBtnNextDecriber(String btnNextDecriber) {
        this.btnNextDecriber = btnNextDecriber;
    }

    public String getWhichPage() {
        return whichPage;
    }

    public void setWhichPage(String whichPage) {
        this.whichPage = whichPage;
    }

    @Override
    public String toString() {
        return "ClickEntity{" +
                "id=" + id +
                ", clickBtnTime='" + clickBtnTime + '\'' +
                ", clickBtnText='" + clickBtnText + '\'' +
                ", btnNextDecriber='" + btnNextDecriber + '\'' +
                ", whichPage='" + whichPage + '\'' +
                '}';
    }
}
