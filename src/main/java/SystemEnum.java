import java.util.HashMap;
import java.util.Map;

public enum SystemEnum {

    /**运帮*/
    YB("YB","运帮"),
    /**云仓*/
    YC("YC","云仓");

    private String value;
    private String name;

    private static final Map<String, SystemEnum> MAP = new HashMap<>();

    static {
        for (SystemEnum item : SystemEnum.values()) {
            MAP.put(item.value, item);
        }
    }

    /**
     * 根据 类型 获取该枚举
     * @param String 类型标识
     * @return 获取值集类型
     */
    public static SystemEnum getByValue(String String) {
        return MAP.get(String);
    }


    public static String getNameByValue(String value ) {
        for (SystemEnum item : SystemEnum.values()) {
            if (item.getValue().equals( value )){
                return item.getName();
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    SystemEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }
}