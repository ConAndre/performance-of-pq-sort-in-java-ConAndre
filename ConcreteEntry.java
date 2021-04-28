/*
 *
 * YOU NEED TO IMPLEMENT THIS!
 *
 */
public class ConcreteEntry implements Entry<String,String>{

    private final String key;
    private final String value;

    public ConcreteEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}