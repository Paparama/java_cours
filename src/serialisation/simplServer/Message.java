package serialisation.simplServer;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private String messText;
    private String sender;
    private Date senTime;

    public Message(String text, String sender) {
        this.messText = text;
        this.sender = sender;
        this.senTime = new Date();
    }

    public String getMessageText(){
        return this.messText;
    }

    public String getSender(){
        return this.sender;
    }

    public Date getDate(){
        return this.senTime;
    }

}
