package logic.language.editor.font.builder.schema.svgfont;

import logic.language.editor.font.builder.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.text.html.CSS;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Map;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class FontFace {
    @XmlAttribute(name = "font-family")
    private String fontFamily;
    @XmlAttribute(name = "units-per-em")
    private String unitsPerEm;
    @XmlAttribute(name = "ascent")
    private String ascent;
    @XmlAttribute(name = "descent")
    private String descent;

    public FontFace() {
        this.fontFamily = "User font";
        this.unitsPerEm = "1000";
        this.ascent = "800";
        this.descent = "-200";
    }
}
