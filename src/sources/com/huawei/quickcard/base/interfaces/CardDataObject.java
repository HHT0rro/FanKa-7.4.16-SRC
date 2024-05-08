package com.huawei.quickcard.base.interfaces;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface CardDataObject extends IQuickCardData {
    Object call(Object... objArr);

    boolean getBooleanValue(String str, boolean z10);

    CardDataObject getCardDataObject(String str);

    Double getDouble(String str);

    double getDoubleValue(String str, double d10);

    int getIntValue(String str, int i10);

    Integer getInteger(String str);

    Object getOriginalObject();

    String getString(int i10);

    String getString(int i10, String str);

    String getString(String str);

    String getString(String str, String str2);

    void setPath(String str);
}
