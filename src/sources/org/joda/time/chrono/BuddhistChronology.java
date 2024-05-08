package org.joda.time.chrono;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DelegatedDateTimeField;
import org.joda.time.field.SkipUndoDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class BuddhistChronology extends AssembledChronology {
    public static final int BE = 1;
    private static final int BUDDHIST_OFFSET = 543;
    private static final long serialVersionUID = -3474595157769370126L;
    private static final org.joda.time.b ERA_FIELD = new d("BE");
    private static final ConcurrentHashMap<DateTimeZone, BuddhistChronology> cCache = new ConcurrentHashMap<>();
    private static final BuddhistChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);

    private BuddhistChronology(org.joda.time.a aVar, Object obj) {
        super(aVar, obj);
    }

    public static BuddhistChronology getInstance() {
        return getInstance(DateTimeZone.getDefault());
    }

    public static BuddhistChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object readResolve() {
        org.joda.time.a base = getBase();
        return base == null ? getInstanceUTC() : getInstance(base.getZone());
    }

    @Override // org.joda.time.chrono.AssembledChronology
    public void assemble(AssembledChronology.a aVar) {
        if (getParam() == null) {
            aVar.f52460l = UnsupportedDurationField.getInstance(DurationFieldType.eras());
            org.joda.time.field.f fVar = new org.joda.time.field.f(new SkipUndoDateTimeField(this, aVar.E), 543);
            aVar.E = fVar;
            aVar.F = new DelegatedDateTimeField(fVar, aVar.f52460l, DateTimeFieldType.yearOfEra());
            aVar.B = new org.joda.time.field.f(new SkipUndoDateTimeField(this, aVar.B), 543);
            org.joda.time.field.d dVar = new org.joda.time.field.d(new org.joda.time.field.f(aVar.F, 99), aVar.f52460l, DateTimeFieldType.centuryOfEra(), 100);
            aVar.H = dVar;
            aVar.f52459k = dVar.getDurationField();
            aVar.G = new org.joda.time.field.f(new org.joda.time.field.i((org.joda.time.field.d) aVar.H), DateTimeFieldType.yearOfCentury(), 1);
            aVar.C = new org.joda.time.field.f(new org.joda.time.field.i(aVar.B, aVar.f52459k, DateTimeFieldType.weekyearOfCentury(), 100), DateTimeFieldType.weekyearOfCentury(), 1);
            aVar.I = ERA_FIELD;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BuddhistChronology) {
            return getZone().equals(((BuddhistChronology) obj).getZone());
        }
        return false;
    }

    public int hashCode() {
        return 499287079 + getZone().hashCode();
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        DateTimeZone zone = getZone();
        if (zone == null) {
            return "BuddhistChronology";
        }
        return "BuddhistChronology[" + zone.getID() + ']';
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return INSTANCE_UTC;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    public static BuddhistChronology getInstance(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap<DateTimeZone, BuddhistChronology> concurrentHashMap = cCache;
        BuddhistChronology buddhistChronology = concurrentHashMap.get(dateTimeZone);
        if (buddhistChronology != null) {
            return buddhistChronology;
        }
        BuddhistChronology buddhistChronology2 = new BuddhistChronology(GJChronology.getInstance(dateTimeZone, null), null);
        BuddhistChronology buddhistChronology3 = new BuddhistChronology(LimitChronology.getInstance(buddhistChronology2, new DateTime(1, 1, 1, 0, 0, 0, 0, buddhistChronology2), null), "");
        BuddhistChronology putIfAbsent = concurrentHashMap.putIfAbsent(dateTimeZone, buddhistChronology3);
        return putIfAbsent != null ? putIfAbsent : buddhistChronology3;
    }
}
