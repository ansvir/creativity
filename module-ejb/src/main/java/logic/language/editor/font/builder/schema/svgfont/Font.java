package logic.language.editor.font.builder.schema.svgfont;

import logic.language.editor.font.builder.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Font {
    @XmlAttribute
    private String id;
    @XmlElement(name = "font-face")
    private FontFace fontFace;
    @XmlElement(name = "missing-glyph")
    private MissingGlyph missingGlyph;
    @XmlElement(name = "glyph")
    private List<Glyph> glyphs;
}
