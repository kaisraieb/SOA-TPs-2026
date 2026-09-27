import jakarta.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = {"to", "text", "from"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Message {
    private String from;
    private String to;
    private String text;
    private boolean isNew;

    public Message(String to, String from, String text, boolean isNew) {
        this.to = to;
        this.from = from;
        this.text = text;
        this.isNew = isNew;
    }

    public Message() {
    }

    @XmlElement(name = "emetteur", required = true)
    public String getFrom() {
        return from;
    }

    @XmlElement(name = "destinataire")
    public String getTo() {
        return to;
    }

    @XmlAttribute
    public String getText() {
        return text;
    }

    @XmlTransient
    public boolean isNew() {
        return isNew;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
