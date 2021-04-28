package logic.language.editor.font.builder.schema.svgfont;

import logic.language.editor.font.builder.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Glyph {
    @XmlAttribute
    private String unicode;
    @XmlAttribute(name = "horiz-adv-x")
    private String horizAdvX;
    @XmlAttribute
    private String d;

    public Glyph() {
        this.horizAdvX = "792";
    }
}
