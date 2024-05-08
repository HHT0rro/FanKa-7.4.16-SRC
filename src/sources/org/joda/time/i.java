package org.joda.time;

/* compiled from: ReadableInstant.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface i extends Comparable<i> {
    int get(DateTimeFieldType dateTimeFieldType);

    a getChronology();

    long getMillis();

    boolean isBefore(i iVar);

    Instant toInstant();
}
