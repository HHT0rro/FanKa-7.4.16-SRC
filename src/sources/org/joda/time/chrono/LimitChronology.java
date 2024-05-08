package org.joda.time.chrono;

import java.util.HashMap;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DecoratedDurationField;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class LimitChronology extends AssembledChronology {
    private static final long serialVersionUID = 7670866536893052522L;
    public final DateTime iLowerLimit;
    public final DateTime iUpperLimit;
    private transient LimitChronology iWithUTC;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class LimitException extends IllegalArgumentException {
        private static final long serialVersionUID = -5924689995607498581L;
        private final boolean iIsLow;

        public LimitException(String str, boolean z10) {
            super(str);
            this.iIsLow = z10;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuffer stringBuffer = new StringBuffer(85);
            stringBuffer.append("The");
            String message = super.getMessage();
            if (message != null) {
                stringBuffer.append(' ');
                stringBuffer.append(message);
            }
            stringBuffer.append(" instant is ");
            org.joda.time.format.b u10 = org.joda.time.format.i.h().u(LimitChronology.this.getBase());
            if (this.iIsLow) {
                stringBuffer.append("below the supported minimum of ");
                u10.q(stringBuffer, LimitChronology.this.getLowerLimit().getMillis());
            } else {
                stringBuffer.append("above the supported maximum of ");
                u10.q(stringBuffer, LimitChronology.this.getUpperLimit().getMillis());
            }
            stringBuffer.append(" (");
            stringBuffer.append((Object) LimitChronology.this.getBase());
            stringBuffer.append(')');
            return stringBuffer.toString();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IllegalArgumentException: " + getMessage();
        }
    }

    private LimitChronology(org.joda.time.a aVar, DateTime dateTime, DateTime dateTime2) {
        super(aVar, null);
        this.iLowerLimit = dateTime;
        this.iUpperLimit = dateTime2;
    }

    private org.joda.time.d convertField(org.joda.time.d dVar, HashMap<Object, Object> hashMap) {
        if (dVar == null || !dVar.isSupported()) {
            return dVar;
        }
        if (hashMap.containsKey(dVar)) {
            return (org.joda.time.d) hashMap.get(dVar);
        }
        LimitDurationField limitDurationField = new LimitDurationField(dVar);
        hashMap.put(dVar, limitDurationField);
        return limitDurationField;
    }

    public static LimitChronology getInstance(org.joda.time.a aVar, org.joda.time.g gVar, org.joda.time.g gVar2) {
        if (aVar != null) {
            DateTime dateTime = gVar == null ? null : gVar.toDateTime();
            DateTime dateTime2 = gVar2 != null ? gVar2.toDateTime() : null;
            if (dateTime != null && dateTime2 != null && !dateTime.isBefore(dateTime2)) {
                throw new IllegalArgumentException("The lower limit must be come before than the upper limit");
            }
            return new LimitChronology(aVar, dateTime, dateTime2);
        }
        throw new IllegalArgumentException("Must supply a chronology");
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

    public void checkLimits(long j10, String str) {
        DateTime dateTime = this.iLowerLimit;
        if (dateTime != null && j10 < dateTime.getMillis()) {
            throw new LimitException(str, true);
        }
        DateTime dateTime2 = this.iUpperLimit;
        if (dateTime2 != null && j10 >= dateTime2.getMillis()) {
            throw new LimitException(str, false);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitChronology)) {
            return false;
        }
        LimitChronology limitChronology = (LimitChronology) obj;
        return getBase().equals(limitChronology.getBase()) && org.joda.time.field.e.a(getLowerLimit(), limitChronology.getLowerLimit()) && org.joda.time.field.e.a(getUpperLimit(), limitChronology.getUpperLimit());
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        long dateTimeMillis = getBase().getDateTimeMillis(i10, i11, i12, i13);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    public DateTime getLowerLimit() {
        return this.iLowerLimit;
    }

    public DateTime getUpperLimit() {
        return this.iUpperLimit;
    }

    public int hashCode() {
        return (getLowerLimit() != null ? getLowerLimit().hashCode() : 0) + 317351877 + (getUpperLimit() != null ? getUpperLimit().hashCode() : 0) + (getBase().hashCode() * 7);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LimitChronology[");
        sb2.append(getBase().toString());
        sb2.append(", ");
        sb2.append(getLowerLimit() == null ? "NoLimit" : getLowerLimit().toString());
        sb2.append(", ");
        sb2.append(getUpperLimit() != null ? getUpperLimit().toString() : "NoLimit");
        sb2.append(']');
        return sb2.toString();
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return withZone(DateTimeZone.UTC);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        LimitChronology limitChronology;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
        if (dateTimeZone == dateTimeZone2 && (limitChronology = this.iWithUTC) != null) {
            return limitChronology;
        }
        DateTime dateTime = this.iLowerLimit;
        if (dateTime != null) {
            MutableDateTime mutableDateTime = dateTime.toMutableDateTime();
            mutableDateTime.setZoneRetainFields(dateTimeZone);
            dateTime = mutableDateTime.toDateTime();
        }
        DateTime dateTime2 = this.iUpperLimit;
        if (dateTime2 != null) {
            MutableDateTime mutableDateTime2 = dateTime2.toMutableDateTime();
            mutableDateTime2.setZoneRetainFields(dateTimeZone);
            dateTime2 = mutableDateTime2.toDateTime();
        }
        LimitChronology limitChronology2 = getInstance(getBase().withZone(dateTimeZone), dateTime, dateTime2);
        if (dateTimeZone == dateTimeZone2) {
            this.iWithUTC = limitChronology2;
        }
        return limitChronology2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class LimitDurationField extends DecoratedDurationField {
        private static final long serialVersionUID = 8049297699408782284L;

        public LimitDurationField(org.joda.time.d dVar) {
            super(dVar, dVar.getType());
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
        public long add(long j10, int i10) {
            LimitChronology.this.checkLimits(j10, null);
            long add = getWrappedField().add(j10, i10);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
        public int getDifference(long j10, long j11) {
            LimitChronology.this.checkLimits(j10, "minuend");
            LimitChronology.this.checkLimits(j11, "subtrahend");
            return getWrappedField().getDifference(j10, j11);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
        public long getDifferenceAsLong(long j10, long j11) {
            LimitChronology.this.checkLimits(j10, "minuend");
            LimitChronology.this.checkLimits(j11, "subtrahend");
            return getWrappedField().getDifferenceAsLong(j10, j11);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
        public long getMillis(int i10, long j10) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().getMillis(i10, j10);
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
        public int getValue(long j10, long j11) {
            LimitChronology.this.checkLimits(j11, null);
            return getWrappedField().getValue(j10, j11);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
        public long getValueAsLong(long j10, long j11) {
            LimitChronology.this.checkLimits(j11, null);
            return getWrappedField().getValueAsLong(j10, j11);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
        public long getMillis(long j10, long j11) {
            LimitChronology.this.checkLimits(j11, null);
            return getWrappedField().getMillis(j10, j11);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
        public long add(long j10, long j11) {
            LimitChronology.this.checkLimits(j10, null);
            long add = getWrappedField().add(j10, j11);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a extends org.joda.time.field.c {

        /* renamed from: c, reason: collision with root package name */
        public final org.joda.time.d f52485c;

        /* renamed from: d, reason: collision with root package name */
        public final org.joda.time.d f52486d;

        /* renamed from: e, reason: collision with root package name */
        public final org.joda.time.d f52487e;

        public a(org.joda.time.b bVar, org.joda.time.d dVar, org.joda.time.d dVar2, org.joda.time.d dVar3) {
            super(bVar, bVar.getType());
            this.f52485c = dVar;
            this.f52486d = dVar2;
            this.f52487e = dVar3;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long add(long j10, int i10) {
            LimitChronology.this.checkLimits(j10, null);
            long add = getWrappedField().add(j10, i10);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long addWrapField(long j10, int i10) {
            LimitChronology.this.checkLimits(j10, null);
            long addWrapField = getWrappedField().addWrapField(j10, i10);
            LimitChronology.this.checkLimits(addWrapField, "resulting");
            return addWrapField;
        }

        @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
        public int get(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().get(j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsShortText(long j10, Locale locale) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().getAsShortText(j10, locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsText(long j10, Locale locale) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().getAsText(j10, locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getDifference(long j10, long j11) {
            LimitChronology.this.checkLimits(j10, "minuend");
            LimitChronology.this.checkLimits(j11, "subtrahend");
            return getWrappedField().getDifference(j10, j11);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long getDifferenceAsLong(long j10, long j11) {
            LimitChronology.this.checkLimits(j10, "minuend");
            LimitChronology.this.checkLimits(j11, "subtrahend");
            return getWrappedField().getDifferenceAsLong(j10, j11);
        }

        @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
        public final org.joda.time.d getDurationField() {
            return this.f52485c;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getLeapAmount(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().getLeapAmount(j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public final org.joda.time.d getLeapDurationField() {
            return this.f52487e;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumShortTextLength(Locale locale) {
            return getWrappedField().getMaximumShortTextLength(locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumTextLength(Locale locale) {
            return getWrappedField().getMaximumTextLength(locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumValue(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().getMaximumValue(j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMinimumValue(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().getMinimumValue(j10);
        }

        @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
        public final org.joda.time.d getRangeDurationField() {
            return this.f52486d;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public boolean isLeap(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            return getWrappedField().isLeap(j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long remainder(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            long remainder = getWrappedField().remainder(j10);
            LimitChronology.this.checkLimits(remainder, "resulting");
            return remainder;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long roundCeiling(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            long roundCeiling = getWrappedField().roundCeiling(j10);
            LimitChronology.this.checkLimits(roundCeiling, "resulting");
            return roundCeiling;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long roundFloor(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            long roundFloor = getWrappedField().roundFloor(j10);
            LimitChronology.this.checkLimits(roundFloor, "resulting");
            return roundFloor;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long roundHalfCeiling(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            long roundHalfCeiling = getWrappedField().roundHalfCeiling(j10);
            LimitChronology.this.checkLimits(roundHalfCeiling, "resulting");
            return roundHalfCeiling;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long roundHalfEven(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            long roundHalfEven = getWrappedField().roundHalfEven(j10);
            LimitChronology.this.checkLimits(roundHalfEven, "resulting");
            return roundHalfEven;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long roundHalfFloor(long j10) {
            LimitChronology.this.checkLimits(j10, null);
            long roundHalfFloor = getWrappedField().roundHalfFloor(j10);
            LimitChronology.this.checkLimits(roundHalfFloor, "resulting");
            return roundHalfFloor;
        }

        @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
        public long set(long j10, int i10) {
            LimitChronology.this.checkLimits(j10, null);
            long j11 = getWrappedField().set(j10, i10);
            LimitChronology.this.checkLimits(j11, "resulting");
            return j11;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long add(long j10, long j11) {
            LimitChronology.this.checkLimits(j10, null);
            long add = getWrappedField().add(j10, j11);
            LimitChronology.this.checkLimits(add, "resulting");
            return add;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long set(long j10, String str, Locale locale) {
            LimitChronology.this.checkLimits(j10, null);
            long j11 = getWrappedField().set(j10, str, locale);
            LimitChronology.this.checkLimits(j11, "resulting");
            return j11;
        }
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13, int i14, int i15, int i16) throws IllegalArgumentException {
        long dateTimeMillis = getBase().getDateTimeMillis(i10, i11, i12, i13, i14, i15, i16);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }

    private org.joda.time.b convertField(org.joda.time.b bVar, HashMap<Object, Object> hashMap) {
        if (bVar == null || !bVar.isSupported()) {
            return bVar;
        }
        if (hashMap.containsKey(bVar)) {
            return (org.joda.time.b) hashMap.get(bVar);
        }
        a aVar = new a(bVar, convertField(bVar.getDurationField(), hashMap), convertField(bVar.getRangeDurationField(), hashMap), convertField(bVar.getLeapDurationField(), hashMap));
        hashMap.put(bVar, aVar);
        return aVar;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(long j10, int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        checkLimits(j10, null);
        long dateTimeMillis = getBase().getDateTimeMillis(j10, i10, i11, i12, i13);
        checkLimits(dateTimeMillis, "resulting");
        return dateTimeMillis;
    }
}
