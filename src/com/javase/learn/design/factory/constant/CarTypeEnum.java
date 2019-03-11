package com.javase.learn.design.factory.constant;

public enum CarTypeEnum {
    FENG_TIAN(1, "丰田"),
    BAO_MA(2, "宝马"),
    BEN_CHI(3, "奔驰");

    private int type;
    private String value;

    CarTypeEnum(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
