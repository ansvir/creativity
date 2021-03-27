package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;

@Entity(name = "TSYMBOL")
@NamedQueries({
        @NamedQuery(name = Symbol.FIND_ALL, query = "SELECT s FROM TSYMBOL s"),
        @NamedQuery(name = Symbol.FIND_BY_ID, query = "SELECT s FROM TSYMBOL s WHERE s.id = :id")
})
public class Symbol implements Serializable {

    public static final String FIND_ALL = "Symbol.findAllSymbols";
    public static final String FIND_BY_ID = "Symbol.findById";
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String key;
    @Lob
    private byte[] figure;
    private String transcription;
    @Transient
    private String base64Image;
    public Symbol() {
    }

    public Symbol(String key, byte[] figure, String transcription) {
        this.key = key;
        this.figure = figure;
        this.transcription = transcription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public byte[] getFigure() {
        return figure;
    }

    public void setFigure(byte[] photo) {
        this.figure = photo;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    @Transient
    public String getBase64Image() {
        base64Image = Base64.getEncoder().encodeToString(this.figure);
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", figure=" + Arrays.toString(figure) +
                ", transcription='" + transcription + '\'' +
                '}';
    }
}
