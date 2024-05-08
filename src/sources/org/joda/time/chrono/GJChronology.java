package org.joda.time.chrono;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DecoratedDurationField;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class GJChronology extends AssembledChronology {
    public static final Instant DEFAULT_CUTOVER = new Instant(-12219292800000L);
    private static final ConcurrentHashMap<h, GJChronology> cCache = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -2545574827706931671L;
    private Instant iCutoverInstant;
    private long iCutoverMillis;
    private long iGapDuration;
    private GregorianChronology iGregorianChronology;
    private JulianChronology iJulianChronology;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class LinkedDurationField extends DecoratedDurationField {
        private static final long serialVersionUID = 4097975388007713084L;
        private final b iField;

        public LinkedDurationField(org.joda.time.d dVar, b bVar) {
            super(dVar, dVar.getType());
            this.iField = bVar;
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
        public long add(long j10, int i10) {
            return this.iField.add(j10, i10);
        }

        @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
        public int getDifference(long j10, long j11) {
            return this.iField.getDifference(j10, j11);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
        public long getDifferenceAsLong(long j10, long j11) {
            return this.iField.getDifferenceAsLong(j10, j11);
        }

        @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
        public long add(long j10, long j11) {
            return this.iField.add(j10, j11);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a extends org.joda.time.field.b {

        /* renamed from: b, reason: collision with root package name */
        public final org.joda.time.b f52477b;

        /* renamed from: c, reason: collision with root package name */
        public final org.joda.time.b f52478c;

        /* renamed from: d, reason: collision with root package name */
        public final long f52479d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f52480e;

        /* renamed from: f, reason: collision with root package name */
        public org.joda.time.d f52481f;

        /* renamed from: g, reason: collision with root package name */
        public org.joda.time.d f52482g;

        public a(GJChronology gJChronology, org.joda.time.b bVar, org.joda.time.b bVar2, long j10) {
            this(gJChronology, bVar, bVar2, j10, false);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long add(long j10, int i10) {
            return this.f52478c.add(j10, i10);
        }

        public long b(long j10) {
            if (this.f52480e) {
                return GJChronology.this.gregorianToJulianByWeekyear(j10);
            }
            return GJChronology.this.gregorianToJulianByYear(j10);
        }

        public long c(long j10) {
            if (this.f52480e) {
                return GJChronology.this.julianToGregorianByWeekyear(j10);
            }
            return GJChronology.this.julianToGregorianByYear(j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int get(long j10) {
            if (j10 >= this.f52479d) {
                return this.f52478c.get(j10);
            }
            return this.f52477b.get(j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsShortText(long j10, Locale locale) {
            if (j10 >= this.f52479d) {
                return this.f52478c.getAsShortText(j10, locale);
            }
            return this.f52477b.getAsShortText(j10, locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsText(long j10, Locale locale) {
            if (j10 >= this.f52479d) {
                return this.f52478c.getAsText(j10, locale);
            }
            return this.f52477b.getAsText(j10, locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getDifference(long j10, long j11) {
            return this.f52478c.getDifference(j10, j11);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long getDifferenceAsLong(long j10, long j11) {
            return this.f52478c.getDifferenceAsLong(j10, j11);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public org.joda.time.d getDurationField() {
            return this.f52481f;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getLeapAmount(long j10) {
            if (j10 >= this.f52479d) {
                return this.f52478c.getLeapAmount(j10);
            }
            return this.f52477b.getLeapAmount(j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public org.joda.time.d getLeapDurationField() {
            return this.f52478c.getLeapDurationField();
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumShortTextLength(Locale locale) {
            return Math.max(this.f52477b.getMaximumShortTextLength(locale), this.f52478c.getMaximumShortTextLength(locale));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumTextLength(Locale locale) {
            return Math.max(this.f52477b.getMaximumTextLength(locale), this.f52478c.getMaximumTextLength(locale));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumValue() {
            return this.f52478c.getMaximumValue();
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMinimumValue() {
            return this.f52477b.getMinimumValue();
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public org.joda.time.d getRangeDurationField() {
            return this.f52482g;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public boolean isLeap(long j10) {
            if (j10 >= this.f52479d) {
                return this.f52478c.isLeap(j10);
            }
            return this.f52477b.isLeap(j10);
        }

        @Override // org.joda.time.b
        public boolean isLenient() {
            return false;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long roundCeiling(long j10) {
            if (j10 >= this.f52479d) {
                return this.f52478c.roundCeiling(j10);
            }
            long roundCeiling = this.f52477b.roundCeiling(j10);
            return (roundCeiling < this.f52479d || roundCeiling - GJChronology.this.iGapDuration < this.f52479d) ? roundCeiling : c(roundCeiling);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long roundFloor(long j10) {
            if (j10 >= this.f52479d) {
                long roundFloor = this.f52478c.roundFloor(j10);
                return (roundFloor >= this.f52479d || GJChronology.this.iGapDuration + roundFloor >= this.f52479d) ? roundFloor : b(roundFloor);
            }
            return this.f52477b.roundFloor(j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long set(long j10, int i10) {
            long j11;
            if (j10 >= this.f52479d) {
                j11 = this.f52478c.set(j10, i10);
                if (j11 < this.f52479d) {
                    if (GJChronology.this.iGapDuration + j11 < this.f52479d) {
                        j11 = b(j11);
                    }
                    if (get(j11) != i10) {
                        throw new IllegalFieldValueException(this.f52478c.getType(), Integer.valueOf(i10), (Number) null, (Number) null);
                    }
                }
            } else {
                j11 = this.f52477b.set(j10, i10);
                if (j11 >= this.f52479d) {
                    if (j11 - GJChronology.this.iGapDuration >= this.f52479d) {
                        j11 = c(j11);
                    }
                    if (get(j11) != i10) {
                        throw new IllegalFieldValueException(this.f52477b.getType(), Integer.valueOf(i10), (Number) null, (Number) null);
                    }
                }
            }
            return j11;
        }

        public a(GJChronology gJChronology, org.joda.time.b bVar, org.joda.time.b bVar2, long j10, boolean z10) {
            this(bVar, bVar2, null, j10, z10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long add(long j10, long j11) {
            return this.f52478c.add(j10, j11);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumValue(long j10) {
            if (j10 >= this.f52479d) {
                return this.f52478c.getMaximumValue(j10);
            }
            int maximumValue = this.f52477b.getMaximumValue(j10);
            long j11 = this.f52477b.set(j10, maximumValue);
            long j12 = this.f52479d;
            if (j11 < j12) {
                return maximumValue;
            }
            org.joda.time.b bVar = this.f52477b;
            return bVar.get(bVar.add(j12, -1));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMinimumValue(org.joda.time.k kVar) {
            return this.f52477b.getMinimumValue(kVar);
        }

        public a(org.joda.time.b bVar, org.joda.time.b bVar2, org.joda.time.d dVar, long j10, boolean z10) {
            super(bVar2.getType());
            this.f52477b = bVar;
            this.f52478c = bVar2;
            this.f52479d = j10;
            this.f52480e = z10;
            this.f52481f = bVar2.getDurationField();
            if (dVar == null && (dVar = bVar2.getRangeDurationField()) == null) {
                dVar = bVar.getRangeDurationField();
            }
            this.f52482g = dVar;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int[] add(org.joda.time.k kVar, int i10, int[] iArr, int i11) {
            if (i11 == 0) {
                return iArr;
            }
            if (org.joda.time.c.n(kVar)) {
                long j10 = 0;
                int size = kVar.size();
                for (int i12 = 0; i12 < size; i12++) {
                    j10 = kVar.getFieldType(i12).getField(GJChronology.this).set(j10, iArr[i12]);
                }
                return GJChronology.this.get(kVar, add(j10, i11));
            }
            return super.add(kVar, i10, iArr, i11);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMinimumValue(org.joda.time.k kVar, int[] iArr) {
            return this.f52477b.getMinimumValue(kVar, iArr);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsShortText(int i10, Locale locale) {
            return this.f52478c.getAsShortText(i10, locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public String getAsText(int i10, Locale locale) {
            return this.f52478c.getAsText(i10, locale);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMinimumValue(long j10) {
            if (j10 < this.f52479d) {
                return this.f52477b.getMinimumValue(j10);
            }
            int minimumValue = this.f52478c.getMinimumValue(j10);
            long j11 = this.f52478c.set(j10, minimumValue);
            long j12 = this.f52479d;
            return j11 < j12 ? this.f52478c.get(j12) : minimumValue;
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumValue(org.joda.time.k kVar) {
            return getMaximumValue(GJChronology.getInstanceUTC().set(kVar, 0L));
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public int getMaximumValue(org.joda.time.k kVar, int[] iArr) {
            GJChronology instanceUTC = GJChronology.getInstanceUTC();
            int size = kVar.size();
            long j10 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                org.joda.time.b field = kVar.getFieldType(i10).getField(instanceUTC);
                if (iArr[i10] <= field.getMaximumValue(j10)) {
                    j10 = field.set(j10, iArr[i10]);
                }
            }
            return getMaximumValue(j10);
        }

        @Override // org.joda.time.field.b, org.joda.time.b
        public long set(long j10, String str, Locale locale) {
            if (j10 >= this.f52479d) {
                long j11 = this.f52478c.set(j10, str, locale);
                return (j11 >= this.f52479d || GJChronology.this.iGapDuration + j11 >= this.f52479d) ? j11 : b(j11);
            }
            long j12 = this.f52477b.set(j10, str, locale);
            return (j12 < this.f52479d || j12 - GJChronology.this.iGapDuration < this.f52479d) ? j12 : c(j12);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class b extends a {
        public b(GJChronology gJChronology, org.joda.time.b bVar, org.joda.time.b bVar2, long j10) {
            this(bVar, bVar2, (org.joda.time.d) null, j10, false);
        }

        @Override // org.joda.time.chrono.GJChronology.a, org.joda.time.field.b, org.joda.time.b
        public long add(long j10, int i10) {
            if (j10 >= this.f52479d) {
                long add = this.f52478c.add(j10, i10);
                if (add >= this.f52479d || GJChronology.this.iGapDuration + add >= this.f52479d) {
                    return add;
                }
                if (this.f52480e) {
                    if (GJChronology.this.iGregorianChronology.weekyear().get(add) <= 0) {
                        add = GJChronology.this.iGregorianChronology.weekyear().add(add, -1);
                    }
                } else if (GJChronology.this.iGregorianChronology.year().get(add) <= 0) {
                    add = GJChronology.this.iGregorianChronology.year().add(add, -1);
                }
                return b(add);
            }
            long add2 = this.f52477b.add(j10, i10);
            return (add2 < this.f52479d || add2 - GJChronology.this.iGapDuration < this.f52479d) ? add2 : c(add2);
        }

        @Override // org.joda.time.chrono.GJChronology.a, org.joda.time.field.b, org.joda.time.b
        public int getDifference(long j10, long j11) {
            long j12 = this.f52479d;
            if (j10 >= j12) {
                if (j11 >= j12) {
                    return this.f52478c.getDifference(j10, j11);
                }
                return this.f52477b.getDifference(b(j10), j11);
            }
            if (j11 < j12) {
                return this.f52477b.getDifference(j10, j11);
            }
            return this.f52478c.getDifference(c(j10), j11);
        }

        @Override // org.joda.time.chrono.GJChronology.a, org.joda.time.field.b, org.joda.time.b
        public long getDifferenceAsLong(long j10, long j11) {
            long j12 = this.f52479d;
            if (j10 >= j12) {
                if (j11 >= j12) {
                    return this.f52478c.getDifferenceAsLong(j10, j11);
                }
                return this.f52477b.getDifferenceAsLong(b(j10), j11);
            }
            if (j11 < j12) {
                return this.f52477b.getDifferenceAsLong(j10, j11);
            }
            return this.f52478c.getDifferenceAsLong(c(j10), j11);
        }

        @Override // org.joda.time.chrono.GJChronology.a, org.joda.time.field.b, org.joda.time.b
        public int getMaximumValue(long j10) {
            if (j10 >= this.f52479d) {
                return this.f52478c.getMaximumValue(j10);
            }
            return this.f52477b.getMaximumValue(j10);
        }

        @Override // org.joda.time.chrono.GJChronology.a, org.joda.time.field.b, org.joda.time.b
        public int getMinimumValue(long j10) {
            if (j10 >= this.f52479d) {
                return this.f52478c.getMinimumValue(j10);
            }
            return this.f52477b.getMinimumValue(j10);
        }

        public b(GJChronology gJChronology, org.joda.time.b bVar, org.joda.time.b bVar2, org.joda.time.d dVar, long j10) {
            this(bVar, bVar2, dVar, j10, false);
        }

        public b(GJChronology gJChronology, org.joda.time.b bVar, org.joda.time.b bVar2, org.joda.time.d dVar, org.joda.time.d dVar2, long j10) {
            this(bVar, bVar2, dVar, j10, false);
            this.f52482g = dVar2;
        }

        public b(org.joda.time.b bVar, org.joda.time.b bVar2, org.joda.time.d dVar, long j10, boolean z10) {
            super(GJChronology.this, bVar, bVar2, j10, z10);
            this.f52481f = dVar == null ? new LinkedDurationField(this.f52481f, this) : dVar;
        }

        @Override // org.joda.time.chrono.GJChronology.a, org.joda.time.field.b, org.joda.time.b
        public long add(long j10, long j11) {
            if (j10 >= this.f52479d) {
                long add = this.f52478c.add(j10, j11);
                if (add >= this.f52479d || GJChronology.this.iGapDuration + add >= this.f52479d) {
                    return add;
                }
                if (this.f52480e) {
                    if (GJChronology.this.iGregorianChronology.weekyear().get(add) <= 0) {
                        add = GJChronology.this.iGregorianChronology.weekyear().add(add, -1);
                    }
                } else if (GJChronology.this.iGregorianChronology.year().get(add) <= 0) {
                    add = GJChronology.this.iGregorianChronology.year().add(add, -1);
                }
                return b(add);
            }
            long add2 = this.f52477b.add(j10, j11);
            return (add2 < this.f52479d || add2 - GJChronology.this.iGapDuration < this.f52479d) ? add2 : c(add2);
        }
    }

    private GJChronology(JulianChronology julianChronology, GregorianChronology gregorianChronology, Instant instant) {
        super(null, new Object[]{julianChronology, gregorianChronology, instant});
    }

    private static long convertByWeekyear(long j10, org.joda.time.a aVar, org.joda.time.a aVar2) {
        return aVar2.millisOfDay().set(aVar2.dayOfWeek().set(aVar2.weekOfWeekyear().set(aVar2.weekyear().set(0L, aVar.weekyear().get(j10)), aVar.weekOfWeekyear().get(j10)), aVar.dayOfWeek().get(j10)), aVar.millisOfDay().get(j10));
    }

    private static long convertByYear(long j10, org.joda.time.a aVar, org.joda.time.a aVar2) {
        return aVar2.getDateTimeMillis(aVar.year().get(j10), aVar.monthOfYear().get(j10), aVar.dayOfMonth().get(j10), aVar.millisOfDay().get(j10));
    }

    public static GJChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), DEFAULT_CUTOVER, 4);
    }

    public static GJChronology getInstanceUTC() {
        return getInstance(DateTimeZone.UTC, DEFAULT_CUTOVER, 4);
    }

    private Object readResolve() {
        return getInstance(getZone(), this.iCutoverInstant, getMinimumDaysInFirstWeek());
    }

    @Override // org.joda.time.chrono.AssembledChronology
    public void assemble(AssembledChronology.a aVar) {
        Object[] objArr = (Object[]) getParam();
        JulianChronology julianChronology = (JulianChronology) objArr[0];
        GregorianChronology gregorianChronology = (GregorianChronology) objArr[1];
        Instant instant = (Instant) objArr[2];
        this.iCutoverMillis = instant.getMillis();
        this.iJulianChronology = julianChronology;
        this.iGregorianChronology = gregorianChronology;
        this.iCutoverInstant = instant;
        if (getBase() != null) {
            return;
        }
        if (julianChronology.getMinimumDaysInFirstWeek() == gregorianChronology.getMinimumDaysInFirstWeek()) {
            long j10 = this.iCutoverMillis;
            this.iGapDuration = j10 - julianToGregorianByYear(j10);
            aVar.a(gregorianChronology);
            if (gregorianChronology.millisOfDay().get(this.iCutoverMillis) == 0) {
                aVar.f52461m = new a(this, julianChronology.millisOfSecond(), aVar.f52461m, this.iCutoverMillis);
                aVar.f52462n = new a(this, julianChronology.millisOfDay(), aVar.f52462n, this.iCutoverMillis);
                aVar.f52463o = new a(this, julianChronology.secondOfMinute(), aVar.f52463o, this.iCutoverMillis);
                aVar.f52464p = new a(this, julianChronology.secondOfDay(), aVar.f52464p, this.iCutoverMillis);
                aVar.f52465q = new a(this, julianChronology.minuteOfHour(), aVar.f52465q, this.iCutoverMillis);
                aVar.f52466r = new a(this, julianChronology.minuteOfDay(), aVar.f52466r, this.iCutoverMillis);
                aVar.f52467s = new a(this, julianChronology.hourOfDay(), aVar.f52467s, this.iCutoverMillis);
                aVar.f52469u = new a(this, julianChronology.hourOfHalfday(), aVar.f52469u, this.iCutoverMillis);
                aVar.f52468t = new a(this, julianChronology.clockhourOfDay(), aVar.f52468t, this.iCutoverMillis);
                aVar.f52470v = new a(this, julianChronology.clockhourOfHalfday(), aVar.f52470v, this.iCutoverMillis);
                aVar.f52471w = new a(this, julianChronology.halfdayOfDay(), aVar.f52471w, this.iCutoverMillis);
            }
            aVar.I = new a(this, julianChronology.era(), aVar.I, this.iCutoverMillis);
            b bVar = new b(this, julianChronology.year(), aVar.E, this.iCutoverMillis);
            aVar.E = bVar;
            aVar.f52458j = bVar.getDurationField();
            aVar.F = new b(this, julianChronology.yearOfEra(), aVar.F, aVar.f52458j, this.iCutoverMillis);
            b bVar2 = new b(this, julianChronology.centuryOfEra(), aVar.H, this.iCutoverMillis);
            aVar.H = bVar2;
            aVar.f52459k = bVar2.getDurationField();
            aVar.G = new b(this, julianChronology.yearOfCentury(), aVar.G, aVar.f52458j, aVar.f52459k, this.iCutoverMillis);
            b bVar3 = new b(this, julianChronology.monthOfYear(), aVar.D, (org.joda.time.d) null, aVar.f52458j, this.iCutoverMillis);
            aVar.D = bVar3;
            aVar.f52457i = bVar3.getDurationField();
            b bVar4 = new b(julianChronology.weekyear(), aVar.B, (org.joda.time.d) null, this.iCutoverMillis, true);
            aVar.B = bVar4;
            aVar.f52456h = bVar4.getDurationField();
            aVar.C = new b(this, julianChronology.weekyearOfCentury(), aVar.C, aVar.f52456h, aVar.f52459k, this.iCutoverMillis);
            aVar.f52474z = new a(julianChronology.dayOfYear(), aVar.f52474z, aVar.f52458j, gregorianChronology.year().roundCeiling(this.iCutoverMillis), false);
            aVar.A = new a(julianChronology.weekOfWeekyear(), aVar.A, aVar.f52456h, gregorianChronology.weekyear().roundCeiling(this.iCutoverMillis), true);
            a aVar2 = new a(this, julianChronology.dayOfMonth(), aVar.f52473y, this.iCutoverMillis);
            aVar2.f52482g = aVar.f52457i;
            aVar.f52473y = aVar2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GJChronology)) {
            return false;
        }
        GJChronology gJChronology = (GJChronology) obj;
        return this.iCutoverMillis == gJChronology.iCutoverMillis && getMinimumDaysInFirstWeek() == gJChronology.getMinimumDaysInFirstWeek() && getZone().equals(gJChronology.getZone());
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        org.joda.time.a base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i10, i11, i12, i13);
        }
        long dateTimeMillis = this.iGregorianChronology.getDateTimeMillis(i10, i11, i12, i13);
        if (dateTimeMillis < this.iCutoverMillis) {
            dateTimeMillis = this.iJulianChronology.getDateTimeMillis(i10, i11, i12, i13);
            if (dateTimeMillis >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return dateTimeMillis;
    }

    public Instant getGregorianCutover() {
        return this.iCutoverInstant;
    }

    public int getMinimumDaysInFirstWeek() {
        return this.iGregorianChronology.getMinimumDaysInFirstWeek();
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public DateTimeZone getZone() {
        org.joda.time.a base = getBase();
        if (base != null) {
            return base.getZone();
        }
        return DateTimeZone.UTC;
    }

    public long gregorianToJulianByWeekyear(long j10) {
        return convertByWeekyear(j10, this.iGregorianChronology, this.iJulianChronology);
    }

    public long gregorianToJulianByYear(long j10) {
        return convertByYear(j10, this.iGregorianChronology, this.iJulianChronology);
    }

    public int hashCode() {
        return 25025 + getZone().hashCode() + getMinimumDaysInFirstWeek() + this.iCutoverInstant.hashCode();
    }

    public long julianToGregorianByWeekyear(long j10) {
        return convertByWeekyear(j10, this.iJulianChronology, this.iGregorianChronology);
    }

    public long julianToGregorianByYear(long j10) {
        return convertByYear(j10, this.iJulianChronology, this.iGregorianChronology);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public String toString() {
        org.joda.time.format.b h10;
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append("GJChronology");
        stringBuffer.append('[');
        stringBuffer.append(getZone().getID());
        if (this.iCutoverMillis != DEFAULT_CUTOVER.getMillis()) {
            stringBuffer.append(",cutover=");
            if (withUTC().dayOfYear().remainder(this.iCutoverMillis) == 0) {
                h10 = org.joda.time.format.i.c();
            } else {
                h10 = org.joda.time.format.i.h();
            }
            h10.u(withUTC()).q(stringBuffer, this.iCutoverMillis);
        }
        if (getMinimumDaysInFirstWeek() != 4) {
            stringBuffer.append(",mdfw=");
            stringBuffer.append(getMinimumDaysInFirstWeek());
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withUTC() {
        return withZone(DateTimeZone.UTC);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public org.joda.time.a withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone, this.iCutoverInstant, getMinimumDaysInFirstWeek());
    }

    private GJChronology(org.joda.time.a aVar, JulianChronology julianChronology, GregorianChronology gregorianChronology, Instant instant) {
        super(aVar, new Object[]{julianChronology, gregorianChronology, instant});
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, DEFAULT_CUTOVER, 4);
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, org.joda.time.i iVar) {
        return getInstance(dateTimeZone, iVar, 4);
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, org.joda.time.i iVar, int i10) {
        Instant instant;
        GJChronology gJChronology;
        DateTimeZone m10 = org.joda.time.c.m(dateTimeZone);
        if (iVar == null) {
            instant = DEFAULT_CUTOVER;
        } else {
            instant = iVar.toInstant();
            if (new LocalDate(instant.getMillis(), GregorianChronology.getInstance(m10)).getYear() <= 0) {
                throw new IllegalArgumentException("Cutover too early. Must be on or after 0001-01-01.");
            }
        }
        h hVar = new h(m10, instant, i10);
        ConcurrentHashMap<h, GJChronology> concurrentHashMap = cCache;
        GJChronology gJChronology2 = concurrentHashMap.get(hVar);
        if (gJChronology2 != null) {
            return gJChronology2;
        }
        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
        if (m10 == dateTimeZone2) {
            gJChronology = new GJChronology(JulianChronology.getInstance(m10, i10), GregorianChronology.getInstance(m10, i10), instant);
        } else {
            GJChronology gJChronology3 = getInstance(dateTimeZone2, instant, i10);
            gJChronology = new GJChronology(ZonedChronology.getInstance(gJChronology3, m10), gJChronology3.iJulianChronology, gJChronology3.iGregorianChronology, gJChronology3.iCutoverInstant);
        }
        GJChronology putIfAbsent = concurrentHashMap.putIfAbsent(hVar, gJChronology);
        return putIfAbsent != null ? putIfAbsent : gJChronology;
    }

    @Override // org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i10, int i11, int i12, int i13, int i14, int i15, int i16) throws IllegalArgumentException {
        long dateTimeMillis;
        org.joda.time.a base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i10, i11, i12, i13, i14, i15, i16);
        }
        try {
            dateTimeMillis = this.iGregorianChronology.getDateTimeMillis(i10, i11, i12, i13, i14, i15, i16);
        } catch (IllegalFieldValueException e2) {
            if (i11 == 2 && i12 == 29) {
                dateTimeMillis = this.iGregorianChronology.getDateTimeMillis(i10, i11, 28, i13, i14, i15, i16);
                if (dateTimeMillis >= this.iCutoverMillis) {
                    throw e2;
                }
            } else {
                throw e2;
            }
        }
        if (dateTimeMillis < this.iCutoverMillis) {
            dateTimeMillis = this.iJulianChronology.getDateTimeMillis(i10, i11, i12, i13, i14, i15, i16);
            if (dateTimeMillis >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return dateTimeMillis;
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, long j10, int i10) {
        return getInstance(dateTimeZone, j10 == DEFAULT_CUTOVER.getMillis() ? null : new Instant(j10), i10);
    }
}
