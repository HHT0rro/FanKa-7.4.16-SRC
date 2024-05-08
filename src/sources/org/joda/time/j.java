package org.joda.time;

/* compiled from: ReadableInterval.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface j {
    a getChronology();

    DateTime getEnd();

    long getEndMillis();

    DateTime getStart();

    long getStartMillis();

    long toDurationMillis();

    Period toPeriod(PeriodType periodType);
}
