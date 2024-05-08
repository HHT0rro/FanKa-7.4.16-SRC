package com.android.framework.protobuf;

import java.lang.reflect.Field;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@CheckReturnValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
final class OneofInfo {
    private final Field caseField;

    /* renamed from: id, reason: collision with root package name */
    private final int f9146id;
    private final Field valueField;

    public OneofInfo(int id2, Field caseField, Field valueField) {
        this.f9146id = id2;
        this.caseField = caseField;
        this.valueField = valueField;
    }

    public int getId() {
        return this.f9146id;
    }

    public Field getCaseField() {
        return this.caseField;
    }

    public Field getValueField() {
        return this.valueField;
    }
}
