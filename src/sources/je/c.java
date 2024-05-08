package je;

import java.util.Date;
import org.joda.convert.ToString;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.i;

/* compiled from: AbstractInstant.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class c implements i {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return getMillis() == iVar.getMillis() && org.joda.time.field.e.a(getChronology(), iVar.getChronology());
    }

    @Override // org.joda.time.i
    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return dateTimeFieldType.getField(getChronology()).get(getMillis());
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public DateTimeZone getZone() {
        return getChronology().getZone();
    }

    public int hashCode() {
        return ((int) (getMillis() ^ (getMillis() >>> 32))) + getChronology().hashCode();
    }

    public boolean isAfter(long j10) {
        return getMillis() > j10;
    }

    public boolean isAfterNow() {
        return isAfter(org.joda.time.c.b());
    }

    public boolean isBefore(long j10) {
        return getMillis() < j10;
    }

    public boolean isBeforeNow() {
        return isBefore(org.joda.time.c.b());
    }

    public boolean isEqual(long j10) {
        return getMillis() == j10;
    }

    public boolean isEqualNow() {
        return isEqual(org.joda.time.c.b());
    }

    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            return false;
        }
        return dateTimeFieldType.getField(getChronology()).isSupported();
    }

    public Date toDate() {
        return new Date(getMillis());
    }

    public DateTime toDateTime() {
        return new DateTime(getMillis(), getZone());
    }

    public DateTime toDateTimeISO() {
        return new DateTime(getMillis(), ISOChronology.getInstance(getZone()));
    }

    @Override // org.joda.time.i
    public Instant toInstant() {
        return new Instant(getMillis());
    }

    public MutableDateTime toMutableDateTime() {
        return new MutableDateTime(getMillis(), getZone());
    }

    public MutableDateTime toMutableDateTimeISO() {
        return new MutableDateTime(getMillis(), ISOChronology.getInstance(getZone()));
    }

    @ToString
    public String toString() {
        return org.joda.time.format.i.h().k(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(i iVar) {
        if (this == iVar) {
            return 0;
        }
        long millis = iVar.getMillis();
        long millis2 = getMillis();
        if (millis2 == millis) {
            return 0;
        }
        return millis2 < millis ? -1 : 1;
    }

    public boolean isAfter(i iVar) {
        return isAfter(org.joda.time.c.h(iVar));
    }

    @Override // org.joda.time.i
    public boolean isBefore(i iVar) {
        return isBefore(org.joda.time.c.h(iVar));
    }

    public boolean isEqual(i iVar) {
        return isEqual(org.joda.time.c.h(iVar));
    }

    public DateTime toDateTime(DateTimeZone dateTimeZone) {
        return new DateTime(getMillis(), org.joda.time.c.c(getChronology()).withZone(dateTimeZone));
    }

    public MutableDateTime toMutableDateTime(DateTimeZone dateTimeZone) {
        return new MutableDateTime(getMillis(), org.joda.time.c.c(getChronology()).withZone(dateTimeZone));
    }

    public String toString(org.joda.time.format.b bVar) {
        if (bVar == null) {
            return toString();
        }
        return bVar.k(this);
    }

    public int get(org.joda.time.b bVar) {
        if (bVar != null) {
            return bVar.get(getMillis());
        }
        throw new IllegalArgumentException("The DateTimeField must not be null");
    }

    public DateTime toDateTime(org.joda.time.a aVar) {
        return new DateTime(getMillis(), aVar);
    }

    public MutableDateTime toMutableDateTime(org.joda.time.a aVar) {
        return new MutableDateTime(getMillis(), aVar);
    }
}
