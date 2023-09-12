package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    String tagValue;
    TagInterface inputTag;
    public LabelTag(String tagValue, TagInterface inputTag) {
        this.tagValue = tagValue;
        this.inputTag = inputTag;
    }
    @Override
    public String render() {
        return "<label>" + tagValue + inputTag.render() + "</label>";
    }
}
// END
