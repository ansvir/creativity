package logic.language.editor.font.builder.schema.svgfont;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class MissingGlyph {
    @XmlAttribute
    private String d;

    public MissingGlyph() {
        this.d = "";
    }
}
