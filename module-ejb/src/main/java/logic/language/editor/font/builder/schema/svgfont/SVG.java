package logic.language.editor.font.builder.schema.svgfont;

import logic.language.editor.font.builder.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.Map;

@XmlRootElement
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class SVG {
    @XmlAttribute
    private String xmlns;
    @XmlAttribute(name = "xmlns:xlink")
    private String xlink;
    @XmlAttribute
    private String version;
    @XmlElement
    private Metadata metadata;
    @XmlElement
    private Defs defs;

    public SVG() {
        this.xmlns = "http://www.w3.org/2000/svg";
        this.xlink = "http://www.w3.org/1999/xlink";
        this.version = "1.0";
    }
}
