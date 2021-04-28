package redirect;

import java.util.Map;

public class Response {
    private String pageName;
    private Map<String, String> attributes;

    public Response(String pageName, Map<String, String> attributes) {
        this.pageName = pageName;
        this.attributes = attributes;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Response{" +
                "pageName='" + pageName + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
