package org.joda.time;

/* compiled from: ReadablePartial.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface k extends Comparable<k> {
    int get(DateTimeFieldType dateTimeFieldType);

    a getChronology();

    b getField(int i10);

    DateTimeFieldType getFieldType(int i10);

    int getValue(int i10);

    boolean isSupported(DateTimeFieldType dateTimeFieldType);

    int size();
}
