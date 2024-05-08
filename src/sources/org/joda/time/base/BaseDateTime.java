package org.joda.time.base;

import java.io.Serializable;
import je.a;
import ke.d;
import ke.h;
import org.joda.time.DateTimeZone;
import org.joda.time.c;
import org.joda.time.chrono.ISOChronology;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BaseDateTime extends a implements Serializable {
    private static final long serialVersionUID = -6728882245981L;
    private volatile org.joda.time.a iChronology;
    private volatile long iMillis;

    public BaseDateTime() {
        this(c.b(), ISOChronology.getInstance());
    }

    private void adjustForMinMax() {
        if (this.iMillis == Long.MIN_VALUE || this.iMillis == Long.MAX_VALUE) {
            this.iChronology = this.iChronology.withUTC();
        }
    }

    public org.joda.time.a checkChronology(org.joda.time.a aVar) {
        return c.c(aVar);
    }

    public long checkInstant(long j10, org.joda.time.a aVar) {
        return j10;
    }

    @Override // org.joda.time.i
    public org.joda.time.a getChronology() {
        return this.iChronology;
    }

    @Override // org.joda.time.i
    public long getMillis() {
        return this.iMillis;
    }

    public void setChronology(org.joda.time.a aVar) {
        this.iChronology = checkChronology(aVar);
    }

    public void setMillis(long j10) {
        this.iMillis = checkInstant(j10, this.iChronology);
    }

    public BaseDateTime(DateTimeZone dateTimeZone) {
        this(c.b(), ISOChronology.getInstance(dateTimeZone));
    }

    public BaseDateTime(org.joda.time.a aVar) {
        this(c.b(), aVar);
    }

    public BaseDateTime(long j10) {
        this(j10, ISOChronology.getInstance());
    }

    public BaseDateTime(long j10, DateTimeZone dateTimeZone) {
        this(j10, ISOChronology.getInstance(dateTimeZone));
    }

    public BaseDateTime(long j10, org.joda.time.a aVar) {
        this.iChronology = checkChronology(aVar);
        this.iMillis = checkInstant(j10, this.iChronology);
        adjustForMinMax();
    }

    public BaseDateTime(Object obj, DateTimeZone dateTimeZone) {
        h c4 = d.b().c(obj);
        org.joda.time.a checkChronology = checkChronology(c4.b(obj, dateTimeZone));
        this.iChronology = checkChronology;
        this.iMillis = checkInstant(c4.k(obj, checkChronology), checkChronology);
        adjustForMinMax();
    }

    public BaseDateTime(Object obj, org.joda.time.a aVar) {
        h c4 = d.b().c(obj);
        this.iChronology = checkChronology(c4.a(obj, aVar));
        this.iMillis = checkInstant(c4.k(obj, aVar), this.iChronology);
        adjustForMinMax();
    }

    public BaseDateTime(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this(i10, i11, i12, i13, i14, i15, i16, ISOChronology.getInstance());
    }

    public BaseDateTime(int i10, int i11, int i12, int i13, int i14, int i15, int i16, DateTimeZone dateTimeZone) {
        this(i10, i11, i12, i13, i14, i15, i16, ISOChronology.getInstance(dateTimeZone));
    }

    public BaseDateTime(int i10, int i11, int i12, int i13, int i14, int i15, int i16, org.joda.time.a aVar) {
        this.iChronology = checkChronology(aVar);
        this.iMillis = checkInstant(this.iChronology.getDateTimeMillis(i10, i11, i12, i13, i14, i15, i16), this.iChronology);
        adjustForMinMax();
    }
}
