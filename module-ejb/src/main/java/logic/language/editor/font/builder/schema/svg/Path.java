package logic.language.editor.font.builder.schema.svg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Path {
    private String desc;
    private String fill;
    private String stroke;
    private String strokeWidth;
    private String opacity;
    private String d;
}
