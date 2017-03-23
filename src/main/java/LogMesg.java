/**
 * Created by phuongdv on 23/03/2017.
 */
public class LogMesg {

    String id;
    int level;
    String mesg;

    public LogMesg(String id, int level, String mesg) {
        this.id = id;
        this.level = level;
        this.mesg = mesg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }
}
