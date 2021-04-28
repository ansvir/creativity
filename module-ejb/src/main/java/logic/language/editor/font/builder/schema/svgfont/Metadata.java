package logic.language.editor.font.builder.schema.svgfont;

import com.sun.xml.internal.txw2.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Metadata {
    @XmlValue
    private String text;

    public Metadata() {
        this.text = "Font";
    }
}
