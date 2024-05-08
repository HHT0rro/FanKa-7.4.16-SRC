package org.joda.time;

/* compiled from: Chronology.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class a {
    public abstract long add(long j10, long j11, int i10);

    public abstract long add(l lVar, long j10, int i10);

    public abstract d centuries();

    public abstract b centuryOfEra();

    public abstract b clockhourOfDay();

    public abstract b clockhourOfHalfday();

    public abstract b dayOfMonth();

    public abstract b dayOfWeek();

    public abstract b dayOfYear();

    public abstract d days();

    public abstract b era();

    public abstract d eras();

    public abstract int[] get(k kVar, long j10);

    public abstract int[] get(l lVar, long j10);

    public abstract int[] get(l lVar, long j10, long j11);

    public abstract long getDateTimeMillis(int i10, int i11, int i12, int i13);

    public abstract long getDateTimeMillis(int i10, int i11, int i12, int i13, int i14, int i15, int i16);

    public abstract long getDateTimeMillis(long j10, int i10, int i11, int i12, int i13);

    public abstract DateTimeZone getZone();

    public abstract b halfdayOfDay();

    public abstract d halfdays();

    public abstract b hourOfDay();

    public abstract b hourOfHalfday();

    public abstract d hours();

    public abstract d millis();

    public abstract b millisOfDay();

    public abstract b millisOfSecond();

    public abstract b minuteOfDay();

    public abstract b minuteOfHour();

    public abstract d minutes();

    public abstract b monthOfYear();

    public abstract d months();

    public abstract b secondOfDay();

    public abstract b secondOfMinute();

    public abstract d seconds();

    public abstract long set(k kVar, long j10);

    public abstract String toString();

    public abstract void validate(k kVar, int[] iArr);

    public abstract b weekOfWeekyear();

    public abstract d weeks();

    public abstract b weekyear();

    public abstract b weekyearOfCentury();

    public abstract d weekyears();

    public abstract a withUTC();

    public abstract a withZone(DateTimeZone dateTimeZone);

    public abstract b year();

    public abstract b yearOfCentury();

    public abstract b yearOfEra();

    public abstract d years();
}
