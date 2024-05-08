package org.joda.time;

import java.io.Serializable;
import org.joda.convert.FromString;
import org.joda.time.chrono.ISOChronology;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Instant extends je.c implements Serializable {
    public static final Instant EPOCH = new Instant(0);
    private static final long serialVersionUID = 3299096530934209741L;
    private final long iMillis;

    public Instant() {
        this.iMillis = c.b();
    }

    public static Instant now() {
        return new Instant();
    }

    public static Instant ofEpochMilli(long j10) {
        return new Instant(j10);
    }

    public static Instant ofEpochSecond(long j10) {
        return new Instant(org.joda.time.field.e.i(j10, 1000));
    }

    @FromString
    public static Instant parse(String str) {
        return parse(str, org.joda.time.format.i.i());
    }

    @Override // org.joda.time.i
    public a getChronology() {
        return ISOChronology.getInstanceUTC();
    }

    @Override // org.joda.time.i
    public long getMillis() {
        return this.iMillis;
    }

    public Instant minus(long j10) {
        return withDurationAdded(j10, -1);
    }

    public Instant plus(long j10) {
        return withDurationAdded(j10, 1);
    }

    @Override // je.c, org.joda.time.g
    public DateTime toDateTime() {
        return new DateTime(getMillis(), ISOChronology.getInstance());
    }

    @Override // je.c
    @Deprecated
    public DateTime toDateTimeISO() {
        return toDateTime();
    }

    @Override // je.c, org.joda.time.i
    public Instant toInstant() {
        return this;
    }

    @Override // je.c
    public MutableDateTime toMutableDateTime() {
        return new MutableDateTime(getMillis(), ISOChronology.getInstance());
    }

    @Override // je.c
    @Deprecated
    public MutableDateTime toMutableDateTimeISO() {
        return toMutableDateTime();
    }

    public Instant withDurationAdded(long j10, int i10) {
        return (j10 == 0 || i10 == 0) ? this : withMillis(getChronology().add(getMillis(), j10, i10));
    }

    public Instant withMillis(long j10) {
        return j10 == this.iMillis ? this : new Instant(j10);
    }

    public static Instant parse(String str, org.joda.time.format.b bVar) {
        return bVar.f(str).toInstant();
    }

    public Instant minus(h hVar) {
        return withDurationAdded(hVar, -1);
    }

    public Instant plus(h hVar) {
        return withDurationAdded(hVar, 1);
    }

    public Instant(long j10) {
        this.iMillis = j10;
    }

    public Instant withDurationAdded(h hVar, int i10) {
        return (hVar == null || i10 == 0) ? this : withDurationAdded(hVar.getMillis(), i10);
    }

    public Instant(Object obj) {
        this.iMillis = ke.d.b().c(obj).k(obj, ISOChronology.getInstanceUTC());
    }
}
