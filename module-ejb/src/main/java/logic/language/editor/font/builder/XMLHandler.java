package logic.language.editor.font.builder;

import logic.language.editor.font.builder.schema.svg.Path;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLHandler {

    public String parsePath(InputStream is) throws SAXException, ParserConfigurationException, IOException {
        String xml = IOUtils.toString(is, StandardCharsets.UTF_8);
        Pattern dValuePattern = Pattern.compile(".*\"(M.*Z)\".*");
        Matcher matcher = dValuePattern.matcher(xml);
        while (matcher.find()) {
            String result = matcher.group(1);
            return result.substring(0, result.length()-2);
        }
        return null;
    }
}
