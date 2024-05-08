package org.joda.time.field;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.k;

/* compiled from: BaseDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class b extends org.joda.time.b {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeFieldType f52529a;

    public b(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            this.f52529a = dateTimeFieldType;
            return;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public int a(String str, Locale locale) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new IllegalFieldValueException(getType(), str);
        }
    }

    @Override // org.joda.time.b
    public long add(long j10, int i10) {
        return getDurationField().add(j10, i10);
    }

    @Override // org.joda.time.b
    public long addWrapField(long j10, int i10) {
        return set(j10, e.c(get(j10), i10, getMinimumValue(j10), getMaximumValue(j10)));
    }

    @Override // org.joda.time.b
    public int[] addWrapPartial(k kVar, int i10, int[] iArr, int i11) {
        if (i11 == 0) {
            return iArr;
        }
        org.joda.time.b bVar = null;
        while (true) {
            if (i11 <= 0) {
                break;
            }
            int maximumValue = getMaximumValue(kVar, iArr);
            long j10 = iArr[i10] + i11;
            if (j10 <= maximumValue) {
                iArr[i10] = (int) j10;
                break;
            }
            if (bVar == null) {
                if (i10 == 0) {
                    i11 -= (maximumValue + 1) - iArr[i10];
                    iArr[i10] = getMinimumValue(kVar, iArr);
                } else {
                    bVar = kVar.getField(i10 - 1);
                    if (getRangeDurationField().getType() != bVar.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                }
            }
            i11 -= (maximumValue + 1) - iArr[i10];
            iArr = bVar.addWrapPartial(kVar, i10 - 1, iArr, 1);
            iArr[i10] = getMinimumValue(kVar, iArr);
        }
        while (true) {
            if (i11 >= 0) {
                break;
            }
            int minimumValue = getMinimumValue(kVar, iArr);
            long j11 = iArr[i10] + i11;
            if (j11 >= minimumValue) {
                iArr[i10] = (int) j11;
                break;
            }
            if (bVar == null) {
                if (i10 == 0) {
                    i11 -= (minimumValue - 1) - iArr[i10];
                    iArr[i10] = getMaximumValue(kVar, iArr);
                } else {
                    bVar = kVar.getField(i10 - 1);
                    if (getRangeDurationField().getType() != bVar.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                }
            }
            i11 -= (minimumValue - 1) - iArr[i10];
            iArr = bVar.addWrapPartial(kVar, i10 - 1, iArr, -1);
            iArr[i10] = getMaximumValue(kVar, iArr);
        }
        return set(kVar, i10, iArr, iArr[i10]);
    }

    @Override // org.joda.time.b
    public abstract int get(long j10);

    @Override // org.joda.time.b
    public String getAsShortText(long j10, Locale locale) {
        return getAsShortText(get(j10), locale);
    }

    @Override // org.joda.time.b
    public String getAsText(long j10, Locale locale) {
        return getAsText(get(j10), locale);
    }

    @Override // org.joda.time.b
    public int getDifference(long j10, long j11) {
        return getDurationField().getDifference(j10, j11);
    }

    @Override // org.joda.time.b
    public long getDifferenceAsLong(long j10, long j11) {
        return getDurationField().getDifferenceAsLong(j10, j11);
    }

    @Override // org.joda.time.b
    public abstract org.joda.time.d getDurationField();

    @Override // org.joda.time.b
    public int getLeapAmount(long j10) {
        return 0;
    }

    @Override // org.joda.time.b
    public org.joda.time.d getLeapDurationField() {
        return null;
    }

    @Override // org.joda.time.b
    public int getMaximumShortTextLength(Locale locale) {
        return getMaximumTextLength(locale);
    }

    @Override // org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        int maximumValue = getMaximumValue();
        if (maximumValue >= 0) {
            if (maximumValue < 10) {
                return 1;
            }
            if (maximumValue < 100) {
                return 2;
            }
            if (maximumValue < 1000) {
                return 3;
            }
        }
        return Integer.toString(maximumValue).length();
    }

    @Override // org.joda.time.b
    public abstract int getMaximumValue();

    @Override // org.joda.time.b
    public int getMaximumValue(long j10) {
        return getMaximumValue();
    }

    @Override // org.joda.time.b
    public abstract int getMinimumValue();

    @Override // org.joda.time.b
    public int getMinimumValue(long j10) {
        return getMinimumValue();
    }

    @Override // org.joda.time.b
    public final String getName() {
        return this.f52529a.getName();
    }

    @Override // org.joda.time.b
    public abstract org.joda.time.d getRangeDurationField();

    @Override // org.joda.time.b
    public final DateTimeFieldType getType() {
        return this.f52529a;
    }

    @Override // org.joda.time.b
    public boolean isLeap(long j10) {
        return false;
    }

    @Override // org.joda.time.b
    public final boolean isSupported() {
        return true;
    }

    @Override // org.joda.time.b
    public long remainder(long j10) {
        return j10 - roundFloor(j10);
    }

    @Override // org.joda.time.b
    public long roundCeiling(long j10) {
        long roundFloor = roundFloor(j10);
        return roundFloor != j10 ? add(roundFloor, 1) : j10;
    }

    @Override // org.joda.time.b
    public abstract long roundFloor(long j10);

    @Override // org.joda.time.b
    public long roundHalfCeiling(long j10) {
        long roundFloor = roundFloor(j10);
        long roundCeiling = roundCeiling(j10);
        return roundCeiling - j10 <= j10 - roundFloor ? roundCeiling : roundFloor;
    }

    @Override // org.joda.time.b
    public long roundHalfEven(long j10) {
        long roundFloor = roundFloor(j10);
        long roundCeiling = roundCeiling(j10);
        long j11 = j10 - roundFloor;
        long j12 = roundCeiling - j10;
        return j11 < j12 ? roundFloor : (j12 >= j11 && (get(roundCeiling) & 1) != 0) ? roundFloor : roundCeiling;
    }

    @Override // org.joda.time.b
    public long roundHalfFloor(long j10) {
        long roundFloor = roundFloor(j10);
        long roundCeiling = roundCeiling(j10);
        return j10 - roundFloor <= roundCeiling - j10 ? roundFloor : roundCeiling;
    }

    @Override // org.joda.time.b
    public abstract long set(long j10, int i10);

    @Override // org.joda.time.b
    public int[] set(k kVar, int i10, int[] iArr, int i11) {
        e.n(this, i11, getMinimumValue(kVar, iArr), getMaximumValue(kVar, iArr));
        iArr[i10] = i11;
        while (true) {
            i10++;
            if (i10 >= kVar.size()) {
                return iArr;
            }
            org.joda.time.b field = kVar.getField(i10);
            if (iArr[i10] > field.getMaximumValue(kVar, iArr)) {
                iArr[i10] = field.getMaximumValue(kVar, iArr);
            }
            if (iArr[i10] < field.getMinimumValue(kVar, iArr)) {
                iArr[i10] = field.getMinimumValue(kVar, iArr);
            }
        }
    }

    @Override // org.joda.time.b
    public String toString() {
        return "DateTimeField[" + getName() + ']';
    }

    @Override // org.joda.time.b
    public long add(long j10, long j11) {
        return getDurationField().add(j10, j11);
    }

    @Override // org.joda.time.b
    public final String getAsShortText(long j10) {
        return getAsShortText(j10, (Locale) null);
    }

    @Override // org.joda.time.b
    public final String getAsText(long j10) {
        return getAsText(j10, (Locale) null);
    }

    @Override // org.joda.time.b
    public int getMaximumValue(k kVar) {
        return getMaximumValue();
    }

    @Override // org.joda.time.b
    public int getMinimumValue(k kVar) {
        return getMinimumValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        if (r13 >= 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        r3 = getMinimumValue(r10, r12);
        r4 = r12[r11] + r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        if (r4 < r3) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (r0 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r11 == 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        r0 = r10.getField(r11 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        if (getRangeDurationField().getType() != r0.getDurationField().getType()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        throw new java.lang.IllegalArgumentException("Fields invalid for add");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
    
        r13 = r13 - ((r3 - 1) - r12[r11]);
        r12 = r0.add(r10, r11 - 1, r12, -1);
        r12[r11] = getMaximumValue(r10, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0093, code lost:
    
        throw new java.lang.IllegalArgumentException("Maximum value exceeded for add");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0067, code lost:
    
        r12[r11] = (int) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ae, code lost:
    
        return set(r10, r11, r12, r12[r11]);
     */
    @Override // org.joda.time.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int[] add(org.joda.time.k r10, int r11, int[] r12, int r13) {
        /*
            r9 = this;
            if (r13 != 0) goto L3
            return r12
        L3:
            r0 = 0
        L4:
            java.lang.String r1 = "Fields invalid for add"
            java.lang.String r2 = "Maximum value exceeded for add"
            if (r13 <= 0) goto L58
            int r3 = r9.getMaximumValue(r10, r12)
            r4 = r12[r11]
            int r4 = r4 + r13
            long r4 = (long) r4
            long r6 = (long) r3
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L1b
            int r3 = (int) r4
            r12[r11] = r3
            goto L58
        L1b:
            if (r0 != 0) goto L44
            if (r11 == 0) goto L3e
            int r0 = r11 + (-1)
            org.joda.time.b r0 = r10.getField(r0)
            org.joda.time.d r2 = r9.getRangeDurationField()
            org.joda.time.DurationFieldType r2 = r2.getType()
            org.joda.time.d r4 = r0.getDurationField()
            org.joda.time.DurationFieldType r4 = r4.getType()
            if (r2 != r4) goto L38
            goto L44
        L38:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>(r1)
            throw r10
        L3e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>(r2)
            throw r10
        L44:
            int r3 = r3 + 1
            r1 = r12[r11]
            int r3 = r3 - r1
            int r13 = r13 - r3
            int r1 = r11 + (-1)
            r2 = 1
            int[] r12 = r0.add(r10, r1, r12, r2)
            int r1 = r9.getMinimumValue(r10, r12)
            r12[r11] = r1
            goto L4
        L58:
            if (r13 >= 0) goto La8
            int r3 = r9.getMinimumValue(r10, r12)
            r4 = r12[r11]
            int r4 = r4 + r13
            long r4 = (long) r4
            long r6 = (long) r3
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L6b
            int r13 = (int) r4
            r12[r11] = r13
            goto La8
        L6b:
            if (r0 != 0) goto L94
            if (r11 == 0) goto L8e
            int r0 = r11 + (-1)
            org.joda.time.b r0 = r10.getField(r0)
            org.joda.time.d r4 = r9.getRangeDurationField()
            org.joda.time.DurationFieldType r4 = r4.getType()
            org.joda.time.d r5 = r0.getDurationField()
            org.joda.time.DurationFieldType r5 = r5.getType()
            if (r4 != r5) goto L88
            goto L94
        L88:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>(r1)
            throw r10
        L8e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>(r2)
            throw r10
        L94:
            int r3 = r3 + (-1)
            r4 = r12[r11]
            int r3 = r3 - r4
            int r13 = r13 - r3
            int r3 = r11 + (-1)
            r4 = -1
            int[] r12 = r0.add(r10, r3, r12, r4)
            int r3 = r9.getMaximumValue(r10, r12)
            r12[r11] = r3
            goto L58
        La8:
            r13 = r12[r11]
            int[] r10 = r9.set(r10, r11, r12, r13)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.field.b.add(org.joda.time.k, int, int[], int):int[]");
    }

    @Override // org.joda.time.b
    public String getAsShortText(k kVar, int i10, Locale locale) {
        return getAsShortText(i10, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(k kVar, int i10, Locale locale) {
        return getAsText(i10, locale);
    }

    @Override // org.joda.time.b
    public int getMaximumValue(k kVar, int[] iArr) {
        return getMaximumValue(kVar);
    }

    @Override // org.joda.time.b
    public int getMinimumValue(k kVar, int[] iArr) {
        return getMinimumValue(kVar);
    }

    @Override // org.joda.time.b
    public int[] addWrapField(k kVar, int i10, int[] iArr, int i11) {
        return set(kVar, i10, iArr, e.c(iArr[i10], i11, getMinimumValue(kVar), getMaximumValue(kVar)));
    }

    @Override // org.joda.time.b
    public final String getAsShortText(k kVar, Locale locale) {
        return getAsShortText(kVar, kVar.get(getType()), locale);
    }

    @Override // org.joda.time.b
    public final String getAsText(k kVar, Locale locale) {
        return getAsText(kVar, kVar.get(getType()), locale);
    }

    @Override // org.joda.time.b
    public String getAsShortText(int i10, Locale locale) {
        return getAsText(i10, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(int i10, Locale locale) {
        return Integer.toString(i10);
    }

    @Override // org.joda.time.b
    public long set(long j10, String str, Locale locale) {
        return set(j10, a(str, locale));
    }

    @Override // org.joda.time.b
    public final long set(long j10, String str) {
        return set(j10, str, null);
    }

    @Override // org.joda.time.b
    public int[] set(k kVar, int i10, int[] iArr, String str, Locale locale) {
        return set(kVar, i10, iArr, a(str, locale));
    }
}
