package com.alibaba.wireless.security.open.litevm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LiteVMParamType {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum PARAM_TYPE {
        PARAM_TYPE_INT(1),
        PARAM_TYPE_UINT(2),
        PARAM_TYPE_LONG(3),
        PARAM_TYPE_ULONG(4),
        PARAM_TYPE_LONGLONG(5),
        PARAM_TYPE_ULONGLONG(6),
        PARAM_TYPE_STRING(7),
        PARAM_TYPE_DATA(8);

        private int mValue;

        PARAM_TYPE(int i10) {
            this.mValue = i10;
        }

        public int getValue() {
            return this.mValue;
        }
    }
}
