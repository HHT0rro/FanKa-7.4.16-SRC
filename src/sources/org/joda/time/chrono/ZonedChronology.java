package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.BaseDurationField;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZonedChronology extends AssembledChronology {
    private static final long NEAR_ZERO = 604800000;
    private static final long serialVersionUID = -1079258847191166848L;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ZonedDurationField extends BaseDurationField {
        private static final long serialVersionUID = -485345310999208286L;
        public final org.joda.time.d iField;
        public final boolean iTimeField;
        public final DateTimeZone iZone;

        public ZonedDurationField(org.joda.time.d dVar, DateTimeZone dateTimeZone) {
            super(dVar.getType());
            if (dVar.isSupported()) {
                this.iField = dVar;
                this.iTimeField = ZonedChronology.useTimeArithmetic(dVar);
                this.iZone = dateTimeZone;
                return;
            }
            throw new IllegalArgumentException();
        }

        private long addOffset(long j10) {
            return this.iZone.convertUTCToLocal(j10);
        }

        private int getOffsetFromLocalToSubtract(long j10) {
            int offsetFromLocal = this.iZone.getOffsetFromLocal(j10);
            long j11 = offsetFromLocal;
            if (((j10 - j11) ^ j10) >= 0 || (j10 ^ j11) >= 0) {
                return offsetFromLocal;
            }
            throw new ArithmeticException("Subtracting time zone offset caused overflow");
        }

        private int getOffsetToAdd(long j10) {
            int offset = this.iZone.getOffset(j10);
            long j11 = offset;
            if (((j10 + j11) ^ j10) >= 0 || (j10 ^ j11) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        @Override // org.joda.time.d
        public long add(long j10, int i10) {
            int offsetToAdd = getOffsetToAdd(j10);
            long add = this.iField.add(j10 + offsetToAdd, i10);
            if (!this.iTimeField) {
                offsetToAdd = getOffsetFromLocalToSubtract(add);
            }
            return add - offsetToAdd;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ZonedDurationField)) {
                return false;
            }
            ZonedDurationField zonedDurationField = (ZonedDurationField) obj;
            return this.iField.equals(zonedDurationField.iField) && this.iZone.equals(zonedDurationField.iZone);
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
        public int getDifference(long j10, long j11) {
            return this.iField.getDifference(j10 + (this.iTimeField ? r0 : getOffsetToAdd(j10)), j11 + getOffsetToAdd(j11));
        }

        @Override // org.joda.time.d
        public long getDifferenceAsLong(long j10, long j11) {
            return this.iField.getDifferenceAsLong(j10 + (this.iTimeField ? r0 : getOffsetToAdd(j10)), j11 + getOffsetToAdd(j11));
        }

        @Override // org.joda.time.d
        public long getMillis(int i10, long j10) {
            return this.iField.getMillis(i10, addOffset(j10));
        }

        @Override // org.joda.time.d
        public long getUnitMillis() {
            return this.iField.getUnitMillis();
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
        public int getValue(long j10, long j11) {
            return this.iField.getValue(j10, addOffset(j11));
        }

        @Override // org.joda.time.d
        public long getValueAsLong(long j10, long j11) {
            return this.iField.getValueAsLong(j10, addOffset(j11));
        }

        public int hashCode() {
            return this.iField.hashCode() ^ this.iZone.hashCode();
        }

        @Override // org.joda.time.d
        public boolean isPrecise() {
            return this.iTimeField ? this.iField.isPrecise() : this.iField.isPrecise() && this.iZone.isFixed();
        }

        @Override // org.joda.time.d
        public long getMillis(long j10, long j11) {
            return this.iField.getMillis(j10, addOffset(j11));
        }

        @Override // org.joda.time.d
        public long add(long j10, long j11) {
            int offsetToAdd = getOffsetToAdd(j10);
            long add = this.iField.add(j10 + offsetToAdd, j11);
            if (!this.iTimeField) {
                offsetToAdd = getOffsetFromLocalToSubtract(add);
            }
            return add - offsetToAdd;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a extends org.joda.time.field.b {

        /* renamed from: b, reason: collision with root package name */
        public final org.joda.time.b f52489b;

        /* renamed from: c, reason: collision with root package name */
        public final DateTimeZone f52490c;

        /* renamed from: d, reason: collision with root package name */
        public final org.joda.time.d f52491d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f52492e;

        /* renamed from: f, reason: collision with root package name */
        public final org.joda.time.d f52493f;

        /* renamed from: g, reason: collision with root package name */
        public final org.joda.time.d f52494g;

        public a(org.joda.time.b bVar, DateTimeZone dateTimeZone, org.joda.time.d dVar, org.joda.time.d dVar2, org.joda.time.d dVar3) {
            super(bVar.getType());
            if (bVar.isSupported()) {
                this.f52489b = bVar;
                this.f52490c = dateTimeZone;
                this.f52491d = dVar;
                this.f52492e = ZonedChronology.useTimeArithmetic(dVar);
                this.f52493f = dVar2;
                this.f52494g = dVar3;
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long add(long j10, int i10) {
            if (this.f52492e) {
                long b4 = b(j10);
                return this.f52489b.add(j10 + b4, i10) - b4;
            }
            return this.f52490c.convertLocalToUTC(this.f52489b.add(this.f52490c.convertUTCToLocal(j10), i10), false, j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long addWrapField(long j10, int i10) {
            if (this.f52492e) {
                long b4 = b(j10);
                return this.f52489b.addWrapField(j10 + b4, i10) - b4;
            }
            return this.f52490c.convertLocalToUTC(this.f52489b.addWrapField(this.f52490c.convertUTCToLocal(j10), i10), false, j10);
        }

        public final int b(long j10) {
            int offset = this.f52490c.getOffset(j10);
            long j11 = offset;
            if (((j10 + j11) ^ j10) >= 0 || (j10 ^ j11) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f52489b.equals(aVar.f52489b) && this.f52490c.equals(aVar.f52490c) && this.f52491d.equals(aVar.f52491d) && this.f52493f.equals(aVar.f52493f);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int get(long j10) {
            return this.f52489b.get(this.f52490c.convertUTCToLocal(j10));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsShortText(long j10, Locale locale) {
            return this.f52489b.getAsShortText(this.f52490c.convertUTCToLocal(j10), locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsText(long j10, Locale locale) {
            return this.f52489b.getAsText(this.f52490c.convertUTCToLocal(j10), locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getDifference(long j10, long j11) {
            return this.f52489b.getDifference(j10 + (this.f52492e ? r0 : b(j10)), j11 + b(j11));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long getDifferenceAsLong(long j10, long j11) {
            return this.f52489b.getDifferenceAsLong(j10 + (this.f52492e ? r0 : b(j10)), j11 + b(j11));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public final org.joda.time.d getDurationField() {
            return this.f52491d;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getLeapAmount(long j10) {
            return this.f52489b.getLeapAmount(this.f52490c.convertUTCToLocal(j10));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public final org.joda.time.d getLeapDurationField() {
            return this.f52494g;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumShortTextLength(Locale locale) {
            return this.f52489b.getMaximumShortTextLength(locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumTextLength(Locale locale) {
            return this.f52489b.getMaximumTextLength(locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumValue() {
            return this.f52489b.getMaximumValue();
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMinimumValue() {
            return this.f52489b.getMinimumValue();
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public final org.joda.time.d getRangeDurationField() {
            return this.f52493f;
        }

        public int hashCode() {
            return this.f52489b.hashCode() ^ this.f52490c.hashCode();
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public boolean isLeap(long j10) {
            return this.f52489b.isLeap(this.f52490c.convertUTCToLocal(j10));
        }

        @Override // org.joda.time.b
        public boolean isLenient() {
            return this.f52489b.isLenient();
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long remainder(long j10) {
            return this.f52489b.remainder(this.f52490c.convertUTCToLocal(j10));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long roundCeiling(long j10) {
            if (this.f52492e) {
                long b4 = b(j10);
                return this.f52489b.roundCeiling(j10 + b4) - b4;
            }
            return this.f52490c.convertLocalToUTC(this.f52489b.roundCeiling(this.f52490c.convertUTCToLocal(j10)), false, j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long roundFloor(long j10) {
            if (this.f52492e) {
                long b4 = b(j10);
                return this.f52489b.roundFloor(j10 + b4) - b4;
            }
            return this.f52490c.convertLocalToUTC(this.f52489b.roundFloor(this.f52490c.convertUTCToLocal(j10)), false, j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long set(long j10, int i10) {
            long j11 = this.f52489b.set(this.f52490c.convertUTCToLocal(j10), i10);
            long convertLocalToUTC = this.f52490c.convertLocalToUTC(j11, false, j10);
            if (get(convertLocalToUTC) == i10) {
                return convertLocalToUTC;
            }
            IllegalInstantException illegalInstantException = new IllegalInstantException(j11, this.f52490c.getID());
            IllegalFieldValueException illegalFieldValueException = new IllegalFieldValueException(this.f52489b.getType(), Integer.valueOf(i10), illegalInstantException.getMessage());
            illegalFieldValueException.initCause(illegalInstantException);
            throw illegalFieldValueException;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumValue(long j10) {
            return this.f52489b.getMaximumValue(this.f52490c.convertUTCToLocal(j10));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMinimumValue(long j10) {
            return this.f52489b.getMinimumValue(this.f52490c.convertUTCToLocal(j10));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsShortText(int i10, Locale locale) {
            return this.f52489b.getAsShortText(i10, locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsText(int i10, Locale locale) {
            return this.f52489b.getAsText(i10, locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumValue(org.joda.time.k kVar) {
            return this.f52489b.getMaximumValue(kVar);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMinimumValue(org.joda.time.k kVar) {
            return this.f52489b.getMinimumValue(kVar);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumValue(org.joda.time.k kVar, int[] iArr) {
            return this.f52489b.getMaximumValue(kVar, iArr);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMinimumValue(org.joda.time.k kVar, int[] iArr) {
            return this.f52489b.getMinimumValue(kVar, iArr);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long add(long j10, long j11) {
            if (this.f52492e) {
                long b4 = b(j10);
                return this.f52489b.add(j10 + b4, j11) - b4;
            }
            return this.f52490c.convertLocalToUTC(this.f52489b.add(this.f52490c.convertUTCToLocal(j10), j11), false, j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long set(long j10, String str, Locale locale) {
            return this.f52490c.convertLocalToUTC(this.f52489b.set(this.f52490c.convertUTCToLocal(j10), str, locale), false, j10);
        }
    }

    private ZonedChronology(org.joda.time.a aVar, DateTimeZone dateTimeZone) {
        super(aVar, dateTimeZone);
    }

    private org.joda.time.d convertField(org.joda.time.d dVar, HashMap<Object, Object> hashMap) {
        if (dVar == null || !dVar.isSupported()) {
            return dVar;
        }
        if (hashMap.containsKey(dVar)) {
            return (org.joda.time.d) hashMap.get(dVar);
        }
        ZonedDurationField zonedDurationField = new ZonedDurationField(dVar, getZone());
        hashMap.put(dVar, zonedDurationField);
        return zonedDurationField;
    }

    public static ZonedChronology getInstance(org.joda.time.a aVar, DateTimeZone dateTimeZone) {
        if (aVar != null) {
            org.joda.time.a withUTC = aVar.withUTC();
            if (withUTC == null) {
                throw new IllegalArgumentException("UTC chronology must not be null");
            }
            if (dateTimeZone != null) {
                return new ZonedChronology(withUTC, dateTimeZone);
            }
            throw new IllegalArgumentException("DateTimeZone must not be null");
        }
        throw new IllegalArgumentException("Must supply a chronology");
    }

    private long localToUTC(long j10) {
        if (j10 == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        if (j10 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        DateTimeZone zone = getZone();
        int offsetFromLocal = zone.getOffsetFromLocal(j10);
        long j11 = j10 - offsetFromLocal;
        if (j10 > 604800000 && j11 < 0) {
            return Long.MAX_VALUE;
        }
        if (j10 < -604800000 && j11 > 0) {
            return Long.MIN_VALUE;
        }
        if (offsetFromLocal == zone.getOffset(j11)) {
            return j11;
        }
        throw new IllegalInstantException(j10, zone.getID());
    }

    public static boolean useTimeArithmetic(org.joda.time.d dVar) {
        return dVar != null && dVar.getUnitMillis() < 43200000;
    }

    @Override // org.joda.time.chrono.AssembledChronology
    public void assemble(AssembledChronology.a aVar) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        aVar.f52460l = convertField(aVar.f52460l, hashMap);
        aVar.f52459k = convertField(aVar.f52459k, hashMap);
        aVar.f52458j = convertField(aVar.f52458j, hashMap);
        aVar.f52457i = convertField(aVar.f52457i, hashMap);
        aVar.f52456h = convertField(aVar.f52456h, hashMap);
        aVar.f52455g = convertField(aVar.f52455g, hashMap);
        aVar.f52454f = convertField(aVar.f52454f, hashMap);
        aVar.f52453e = convertField(aVar.f52453e, hashMap);
        aVar.f52452d = convertField(aVar.f52452d, hashMap);
        aVar.f52451c = convertField(aVar.f52451c, hashMap);
        aVar.f52450b = convertField(aVar.f52450b, hashMap);
        aVar.f52449a = convertField(aVar.f52449a, hashMap);
        aVar.E = convertField(aVar.E, hashMap);
        aVar.F = convertField(aVar.F, hashMap);
        aVar.G = convertField(aVar.G, hashMap);
        aVar.H = convertField(aVar.H, hashMap);
        aVar.I = convertField(aVar.I, hashMap);
        aVar.f52472x = convertField(aVar.f52472x, hashMap);
        aVar.f52473y = convertField(aVar.f52473y, hashMap);
        aVar.f52474z = convertField(aVar.f52474z, hashMap);
        aVar.D = convertField(aVar.D, hashMap);
        aVar.A = convertField(aVar.A, hashMap);
        aVar.B = convertField(aVar.B, hashMap);
        aVar.C = convertField(aVar.C, hashMap);
        aVar.f52461m = convertField(aVar.f52461m, hashMap);
        aVar.f52462n = convertField(aVar.f52462n, hashMap);
        aVar.f52463o = convertField(aVar.f52463o, hashMap);
        aVar.f52464p = convertField(aVar.f52464p, hashMap);
        aVar.f52465q = convertField(aVar.f52465q, hashMap);
        aVar.f52466r = convertField(aVar.f52466r, hashMap);
        aVar.f52467s = convertField(aVar.f52467s, hashMap);
        aVar.f52469u = convertField(aVar.f52469u, hashMap);
        aVar.f52468t = convertField(aVar.f52468t, hashMap);
        aVar.f52470v = convertField(aVar.f52470v, hashMap);
        aVar.f52471w = convertField(aVar.f52471w, hashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedChronology)) {
            return false;
        }
        ZonedChronology zonedChronology = (ZonedChronology) obj;
        return getBase().equals(zonedChronology.getBase()) && getZone().equals(zonedChronology.getZone());
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(i10, i11, i12, i13));
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public DateTimeZone getZone() {
        return (DateTimeZone) getParam();
    }

    public int hashCode() {
        return (getZone().hashCode() * 11) + 326565 + (getBase().hashCode() * 7);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        return "ZonedChronology[" + ((Object) getBase()) + ", " + getZone().getID() + ']';
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return getBase();
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getParam()) {
            return this;
        }
        if (dateTimeZone == DateTimeZone.UTC) {
            return getBase();
        }
        return new ZonedChronology(getBase(), dateTimeZone);
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13, int i14, int i15, int i16) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(i10, i11, i12, i13, i14, i15, i16));
    }

    private org.joda.time.b convertField(org.joda.time.b bVar, HashMap<Object, Object> hashMap) {
        if (bVar == null || !bVar.isSupported()) {
            return bVar;
        }
        if (hashMap.containsKey(bVar)) {
            return (org.joda.time.b) hashMap.get(bVar);
        }
        a aVar = new a(bVar, getZone(), convertField(bVar.getDurationField(), hashMap), convertField(bVar.getRangeDurationField(), hashMap), convertField(bVar.getLeapDurationField(), hashMap));
        hashMap.put(bVar, aVar);
        return aVar;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(long j10, int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(getZone().getOffset(j10) + j10, i10, i11, i12, i13));
    }
}
