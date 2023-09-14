package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag {
    private String name;
    private Map<String, String> attributes;
    private String body;
    private List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.name = name;
        this.attributes = attributes;
        this.body = body;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Tag> getChildren() {
        return children;
    }

    public void setChildren(List<Tag> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        Tag tag = new SingleTag(name, attributes);
        StringBuilder str = new StringBuilder(tag.toString());
        str.append(body);
        for (Tag element: children) {
            str.append(new SingleTag(element.getName(), element.getAttributes()));
        }
        return str.append("</").append(name).append(">").toString();
    }
}
// END
