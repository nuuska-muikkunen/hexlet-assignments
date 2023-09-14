package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    private String name;
    private Map<String, String> attributes;

    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
        this.name = name;
        this.attributes = attributes;
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

    @Override
    public String toString() {
        return super.toString();
    }
}
// END
