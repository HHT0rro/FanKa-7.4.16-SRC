package com.wangmai.common.enums;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum EnumPatchType {
    NORMAL("normal"),
    VIDEO("video");

    public String str;

    EnumPatchType(String str) {
        this.str = str;
    }

    public static EnumPatchType getTypeEnum(String str) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode != -1039745817) {
            if (hashCode == 112202875 && str.equals("video")) {
                c4 = 2;
            }
            c4 = 65535;
        } else {
            if (str.equals("normal")) {
                c4 = 1;
            }
            c4 = 65535;
        }
        if (c4 != 2) {
            return NORMAL;
        }
        return VIDEO;
    }
}
