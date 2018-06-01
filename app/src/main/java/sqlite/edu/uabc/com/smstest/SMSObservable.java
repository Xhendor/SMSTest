package sqlite.edu.uabc.com.smstest;


import java.io.Serializable;
import java.util.Observable;

public class SMSObservable extends Observable implements Serializable {

    private String value;
    private static SMSObservable instance;
    public static SMSObservable getInstance() {

        if(instance==null){
            instance=new SMSObservable();
            return instance;
        }
        return instance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        this.setChanged();
        this.notifyObservers(value);
    }



}
