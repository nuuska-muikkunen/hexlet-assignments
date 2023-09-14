package exercise;

import java.util.Map;

// BEGIN
public abstract class Tag {
    private String name;
    private Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
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
        StringBuilder str = new StringBuilder("<" + name + " ");
        for (String key: attributes.keySet()) {
            str.append(key).append("=").append("\"").append(attributes.get(key)).append("\"").append(" ");
        }
        return str.deleteCharAt(str.length() - 1).append(">").toString();
    }
}
// END
