package org.joda.time.tz;

import com.google.android.material.datepicker.UtcDates;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DateTimeZoneBuilder {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DSTZone extends DateTimeZone {
        private static final long serialVersionUID = 6941492635554961361L;
        public final b iEndRecurrence;
        public final int iStandardOffset;
        public final b iStartRecurrence;

        public DSTZone(String str, int i10, b bVar, b bVar2) {
            super(str);
            this.iStandardOffset = i10;
            this.iStartRecurrence = bVar;
            this.iEndRecurrence = bVar2;
        }

        private b findMatchingRecurrence(long j10) {
            long j11;
            int i10 = this.iStandardOffset;
            b bVar = this.iStartRecurrence;
            b bVar2 = this.iEndRecurrence;
            try {
                j11 = bVar.c(j10, i10, bVar2.b());
            } catch (ArithmeticException | IllegalArgumentException unused) {
                j11 = j10;
            }
            try {
                j10 = bVar2.c(j10, i10, bVar.b());
            } catch (ArithmeticException | IllegalArgumentException unused2) {
            }
            return j11 > j10 ? bVar : bVar2;
        }

        public static DSTZone readFrom(DataInput dataInput, String str) throws IOException {
            return new DSTZone(str, (int) DateTimeZoneBuilder.c(dataInput), b.e(dataInput), b.e(dataInput));
        }

        @Override // org.joda.time.DateTimeZone
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DSTZone)) {
                return false;
            }
            DSTZone dSTZone = (DSTZone) obj;
            return getID().equals(dSTZone.getID()) && this.iStandardOffset == dSTZone.iStandardOffset && this.iStartRecurrence.equals(dSTZone.iStartRecurrence) && this.iEndRecurrence.equals(dSTZone.iEndRecurrence);
        }

        @Override // org.joda.time.DateTimeZone
        public String getNameKey(long j10) {
            return findMatchingRecurrence(j10).a();
        }

        @Override // org.joda.time.DateTimeZone
        public int getOffset(long j10) {
            return this.iStandardOffset + findMatchingRecurrence(j10).b();
        }

        @Override // org.joda.time.DateTimeZone
        public int getStandardOffset(long j10) {
            return this.iStandardOffset;
        }

        @Override // org.joda.time.DateTimeZone
        public boolean isFixed() {
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        
            if (r5 < 0) goto L8;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
        @Override // org.joda.time.DateTimeZone
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long nextTransition(long r9) {
            /*
                r8 = this;
                int r0 = r8.iStandardOffset
                org.joda.time.tz.DateTimeZoneBuilder$b r1 = r8.iStartRecurrence
                org.joda.time.tz.DateTimeZoneBuilder$b r2 = r8.iEndRecurrence
                r3 = 0
                int r5 = r2.b()     // Catch: java.lang.Throwable -> L18
                long r5 = r1.c(r9, r0, r5)     // Catch: java.lang.Throwable -> L18
                int r7 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r7 <= 0) goto L19
                int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r7 >= 0) goto L19
            L18:
                r5 = r9
            L19:
                int r1 = r1.b()     // Catch: java.lang.Throwable -> L2c
                long r0 = r2.c(r9, r0, r1)     // Catch: java.lang.Throwable -> L2c
                int r2 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
                if (r2 <= 0) goto L2a
                int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r2 >= 0) goto L2a
                goto L2d
            L2a:
                r9 = r0
                goto L2d
            L2c:
            L2d:
                int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r0 <= 0) goto L32
                r5 = r9
            L32:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DateTimeZoneBuilder.DSTZone.nextTransition(long):long");
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        
            if (r7 > 0) goto L8;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
        @Override // org.joda.time.DateTimeZone
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long previousTransition(long r11) {
            /*
                r10 = this;
                r0 = 1
                long r11 = r11 + r0
                int r2 = r10.iStandardOffset
                org.joda.time.tz.DateTimeZoneBuilder$b r3 = r10.iStartRecurrence
                org.joda.time.tz.DateTimeZoneBuilder$b r4 = r10.iEndRecurrence
                r5 = 0
                int r7 = r4.b()     // Catch: java.lang.Throwable -> L1b
                long r7 = r3.d(r11, r2, r7)     // Catch: java.lang.Throwable -> L1b
                int r9 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r9 >= 0) goto L1c
                int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r9 <= 0) goto L1c
            L1b:
                r7 = r11
            L1c:
                int r3 = r3.b()     // Catch: java.lang.Throwable -> L2f
                long r2 = r4.d(r11, r2, r3)     // Catch: java.lang.Throwable -> L2f
                int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r4 >= 0) goto L2d
                int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r4 <= 0) goto L2d
                goto L30
            L2d:
                r11 = r2
                goto L30
            L2f:
            L30:
                int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r2 <= 0) goto L35
                goto L36
            L35:
                r7 = r11
            L36:
                long r7 = r7 - r0
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DateTimeZoneBuilder.DSTZone.previousTransition(long):long");
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            DateTimeZoneBuilder.d(dataOutput, this.iStandardOffset);
            this.iStartRecurrence.h(dataOutput);
            this.iEndRecurrence.h(dataOutput);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class PrecalculatedZone extends DateTimeZone {
        private static final long serialVersionUID = 7811976468055766265L;
        private final String[] iNameKeys;
        private final int[] iStandardOffsets;
        private final DSTZone iTailZone;
        private final long[] iTransitions;
        private final int[] iWallOffsets;

        private PrecalculatedZone(String str, long[] jArr, int[] iArr, int[] iArr2, String[] strArr, DSTZone dSTZone) {
            super(str);
            this.iTransitions = jArr;
            this.iWallOffsets = iArr;
            this.iStandardOffsets = iArr2;
            this.iNameKeys = strArr;
            this.iTailZone = dSTZone;
        }

        public static PrecalculatedZone create(String str, boolean z10, ArrayList<c> arrayList, DSTZone dSTZone) {
            DSTZone dSTZone2;
            DSTZone dSTZone3;
            DSTZone dSTZone4 = dSTZone;
            int size = arrayList.size();
            if (size != 0) {
                long[] jArr = new long[size];
                int[] iArr = new int[size];
                int[] iArr2 = new int[size];
                String[] strArr = new String[size];
                c cVar = null;
                int i10 = 0;
                int i11 = 0;
                while (i11 < size) {
                    c cVar2 = arrayList.get(i11);
                    if (cVar2.e(cVar)) {
                        jArr[i11] = cVar2.a();
                        iArr[i11] = cVar2.d();
                        iArr2[i11] = cVar2.c();
                        strArr[i11] = cVar2.b();
                        i11++;
                        cVar = cVar2;
                    } else {
                        throw new IllegalArgumentException(str);
                    }
                }
                String[] strArr2 = new String[5];
                for (String[] strArr3 : new DateFormatSymbols(Locale.ENGLISH).getZoneStrings()) {
                    if (strArr3 != null && strArr3.length == 5 && str.equals(strArr3[0])) {
                        strArr2 = strArr3;
                    }
                }
                ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
                while (i10 < size - 1) {
                    String str2 = strArr[i10];
                    int i12 = i10 + 1;
                    String str3 = strArr[i12];
                    long j10 = iArr[i10];
                    long j11 = iArr[i12];
                    String[] strArr4 = strArr;
                    String[] strArr5 = strArr2;
                    long j12 = iArr2[i10];
                    int[] iArr3 = iArr;
                    int[] iArr4 = iArr2;
                    long j13 = iArr2[i12];
                    int i13 = size;
                    Period period = new Period(jArr[i10], jArr[i12], PeriodType.yearMonthDay(), instanceUTC);
                    if (j10 != j11 && j12 == j13 && str2.equals(str3) && period.getYears() == 0 && period.getMonths() > 4 && period.getMonths() < 8 && str2.equals(strArr5[2]) && str2.equals(strArr5[4])) {
                        if (e.a()) {
                            System.out.println("Fixing duplicate name key - " + str3);
                            System.out.println("     - " + ((Object) new DateTime(jArr[i10], instanceUTC)) + " - " + ((Object) new DateTime(jArr[i12], instanceUTC)));
                        }
                        if (j10 > j11) {
                            strArr4[i10] = (str2 + "-Summer").intern();
                        } else if (j10 < j11) {
                            strArr4[i12] = (str3 + "-Summer").intern();
                            i10 = i12;
                        }
                    }
                    i10++;
                    strArr2 = strArr5;
                    dSTZone4 = dSTZone;
                    strArr = strArr4;
                    iArr = iArr3;
                    iArr2 = iArr4;
                    size = i13;
                }
                DSTZone dSTZone5 = dSTZone4;
                int[] iArr5 = iArr;
                int[] iArr6 = iArr2;
                String[] strArr6 = strArr;
                if (dSTZone5 == null || !dSTZone5.iStartRecurrence.a().equals(dSTZone5.iEndRecurrence.a())) {
                    dSTZone2 = dSTZone5;
                } else {
                    if (e.a()) {
                        System.out.println("Fixing duplicate recurrent name key - " + dSTZone5.iStartRecurrence.a());
                    }
                    if (dSTZone5.iStartRecurrence.b() > 0) {
                        dSTZone3 = new DSTZone(dSTZone.getID(), dSTZone5.iStandardOffset, dSTZone5.iStartRecurrence.g("-Summer"), dSTZone5.iEndRecurrence);
                    } else {
                        dSTZone3 = new DSTZone(dSTZone.getID(), dSTZone5.iStandardOffset, dSTZone5.iStartRecurrence, dSTZone5.iEndRecurrence.g("-Summer"));
                    }
                    dSTZone2 = dSTZone3;
                }
                return new PrecalculatedZone(z10 ? str : "", jArr, iArr5, iArr6, strArr6, dSTZone2);
            }
            throw new IllegalArgumentException();
        }

        public static PrecalculatedZone readFrom(DataInput dataInput, String str) throws IOException {
            int readUnsignedByte;
            int readUnsignedShort = dataInput.readUnsignedShort();
            String[] strArr = new String[readUnsignedShort];
            for (int i10 = 0; i10 < readUnsignedShort; i10++) {
                strArr[i10] = dataInput.readUTF();
            }
            int readInt = dataInput.readInt();
            long[] jArr = new long[readInt];
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            String[] strArr2 = new String[readInt];
            for (int i11 = 0; i11 < readInt; i11++) {
                jArr[i11] = DateTimeZoneBuilder.c(dataInput);
                iArr[i11] = (int) DateTimeZoneBuilder.c(dataInput);
                iArr2[i11] = (int) DateTimeZoneBuilder.c(dataInput);
                if (readUnsignedShort < 256) {
                    try {
                        readUnsignedByte = dataInput.readUnsignedByte();
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw new IOException("Invalid encoding");
                    }
                } else {
                    readUnsignedByte = dataInput.readUnsignedShort();
                }
                strArr2[i11] = strArr[readUnsignedByte];
            }
            return new PrecalculatedZone(str, jArr, iArr, iArr2, strArr2, dataInput.readBoolean() ? DSTZone.readFrom(dataInput, str) : null);
        }

        @Override // org.joda.time.DateTimeZone
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PrecalculatedZone)) {
                return false;
            }
            PrecalculatedZone precalculatedZone = (PrecalculatedZone) obj;
            if (getID().equals(precalculatedZone.getID()) && Arrays.equals(this.iTransitions, precalculatedZone.iTransitions) && Arrays.equals(this.iNameKeys, precalculatedZone.iNameKeys) && Arrays.equals(this.iWallOffsets, precalculatedZone.iWallOffsets) && Arrays.equals(this.iStandardOffsets, precalculatedZone.iStandardOffsets)) {
                DSTZone dSTZone = this.iTailZone;
                DSTZone dSTZone2 = precalculatedZone.iTailZone;
                if (dSTZone == null) {
                    if (dSTZone2 == null) {
                        return true;
                    }
                } else if (dSTZone.equals(dSTZone2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.joda.time.DateTimeZone
        public String getNameKey(long j10) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j10);
            if (binarySearch >= 0) {
                return this.iNameKeys[binarySearch];
            }
            int i10 = ~binarySearch;
            if (i10 < jArr.length) {
                return i10 > 0 ? this.iNameKeys[i10 - 1] : UtcDates.UTC;
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone == null) {
                return this.iNameKeys[i10 - 1];
            }
            return dSTZone.getNameKey(j10);
        }

        @Override // org.joda.time.DateTimeZone
        public int getOffset(long j10) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j10);
            if (binarySearch >= 0) {
                return this.iWallOffsets[binarySearch];
            }
            int i10 = ~binarySearch;
            if (i10 < jArr.length) {
                if (i10 > 0) {
                    return this.iWallOffsets[i10 - 1];
                }
                return 0;
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone == null) {
                return this.iWallOffsets[i10 - 1];
            }
            return dSTZone.getOffset(j10);
        }

        @Override // org.joda.time.DateTimeZone
        public int getStandardOffset(long j10) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j10);
            if (binarySearch >= 0) {
                return this.iStandardOffsets[binarySearch];
            }
            int i10 = ~binarySearch;
            if (i10 < jArr.length) {
                if (i10 > 0) {
                    return this.iStandardOffsets[i10 - 1];
                }
                return 0;
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone == null) {
                return this.iStandardOffsets[i10 - 1];
            }
            return dSTZone.getStandardOffset(j10);
        }

        public boolean isCachable() {
            if (this.iTailZone != null) {
                return true;
            }
            long[] jArr = this.iTransitions;
            if (jArr.length <= 1) {
                return false;
            }
            double d10 = ShadowDrawableWrapper.COS_45;
            int i10 = 0;
            for (int i11 = 1; i11 < jArr.length; i11++) {
                long j10 = jArr[i11] - jArr[i11 - 1];
                if (j10 < 63158400000L) {
                    d10 += j10;
                    i10++;
                }
            }
            return i10 > 0 && (d10 / ((double) i10)) / 8.64E7d >= 25.0d;
        }

        @Override // org.joda.time.DateTimeZone
        public boolean isFixed() {
            return false;
        }

        @Override // org.joda.time.DateTimeZone
        public long nextTransition(long j10) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j10);
            int i10 = binarySearch >= 0 ? binarySearch + 1 : ~binarySearch;
            if (i10 < jArr.length) {
                return jArr[i10];
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone == null) {
                return j10;
            }
            long j11 = jArr[jArr.length - 1];
            if (j10 < j11) {
                j10 = j11;
            }
            return dSTZone.nextTransition(j10);
        }

        @Override // org.joda.time.DateTimeZone
        public long previousTransition(long j10) {
            long[] jArr = this.iTransitions;
            int binarySearch = Arrays.binarySearch(jArr, j10);
            if (binarySearch >= 0) {
                return j10 > Long.MIN_VALUE ? j10 - 1 : j10;
            }
            int i10 = ~binarySearch;
            if (i10 < jArr.length) {
                if (i10 > 0) {
                    long j11 = jArr[i10 - 1];
                    if (j11 > Long.MIN_VALUE) {
                        return j11 - 1;
                    }
                }
                return j10;
            }
            DSTZone dSTZone = this.iTailZone;
            if (dSTZone != null) {
                long previousTransition = dSTZone.previousTransition(j10);
                if (previousTransition < j10) {
                    return previousTransition;
                }
            }
            long j12 = jArr[i10 - 1];
            return j12 > Long.MIN_VALUE ? j12 - 1 : j10;
        }

        public void writeTo(DataOutput dataOutput) throws IOException {
            int length = this.iTransitions.length;
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < length; i10++) {
                hashSet.add(this.iNameKeys[i10]);
            }
            int size = hashSet.size();
            if (size <= 65535) {
                String[] strArr = new String[size];
                Iterator<E> iterator2 = hashSet.iterator2();
                int i11 = 0;
                while (iterator2.hasNext()) {
                    strArr[i11] = (String) iterator2.next();
                    i11++;
                }
                dataOutput.writeShort(size);
                for (int i12 = 0; i12 < size; i12++) {
                    dataOutput.writeUTF(strArr[i12]);
                }
                dataOutput.writeInt(length);
                for (int i13 = 0; i13 < length; i13++) {
                    DateTimeZoneBuilder.d(dataOutput, this.iTransitions[i13]);
                    DateTimeZoneBuilder.d(dataOutput, this.iWallOffsets[i13]);
                    DateTimeZoneBuilder.d(dataOutput, this.iStandardOffsets[i13]);
                    String str = this.iNameKeys[i13];
                    int i14 = 0;
                    while (true) {
                        if (i14 >= size) {
                            break;
                        }
                        if (!strArr[i14].equals(str)) {
                            i14++;
                        } else if (size < 256) {
                            dataOutput.writeByte(i14);
                        } else {
                            dataOutput.writeShort(i14);
                        }
                    }
                }
                dataOutput.writeBoolean(this.iTailZone != null);
                DSTZone dSTZone = this.iTailZone;
                if (dSTZone != null) {
                    dSTZone.writeTo(dataOutput);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("String pool is too large");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final char f52692a;

        /* renamed from: b, reason: collision with root package name */
        public final int f52693b;

        /* renamed from: c, reason: collision with root package name */
        public final int f52694c;

        /* renamed from: d, reason: collision with root package name */
        public final int f52695d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f52696e;

        /* renamed from: f, reason: collision with root package name */
        public final int f52697f;

        public a(char c4, int i10, int i11, int i12, boolean z10, int i13) {
            if (c4 != 'u' && c4 != 'w' && c4 != 's') {
                throw new IllegalArgumentException("Unknown mode: " + c4);
            }
            this.f52692a = c4;
            this.f52693b = i10;
            this.f52694c = i11;
            this.f52695d = i12;
            this.f52696e = z10;
            this.f52697f = i13;
        }

        public static a c(DataInput dataInput) throws IOException {
            return new a((char) dataInput.readUnsignedByte(), dataInput.readUnsignedByte(), dataInput.readByte(), dataInput.readUnsignedByte(), dataInput.readBoolean(), (int) DateTimeZoneBuilder.c(dataInput));
        }

        public long a(long j10, int i10, int i11) {
            char c4 = this.f52692a;
            if (c4 == 'w') {
                i10 += i11;
            } else if (c4 != 's') {
                i10 = 0;
            }
            long j11 = i10;
            long j12 = j10 + j11;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long e2 = e(instanceUTC, instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(j12, this.f52693b), 0), this.f52697f));
            if (this.f52695d != 0) {
                e2 = g(instanceUTC, e2);
                if (e2 <= j12) {
                    e2 = g(instanceUTC, e(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(e2, 1), this.f52693b)));
                }
            } else if (e2 <= j12) {
                e2 = e(instanceUTC, instanceUTC.year().add(e2, 1));
            }
            return instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(e2, 0), this.f52697f) - j11;
        }

        public long b(long j10, int i10, int i11) {
            char c4 = this.f52692a;
            if (c4 == 'w') {
                i10 += i11;
            } else if (c4 != 's') {
                i10 = 0;
            }
            long j11 = i10;
            long j12 = j10 + j11;
            ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
            long f10 = f(instanceUTC, instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(instanceUTC.monthOfYear().set(j12, this.f52693b), 0), this.f52697f));
            if (this.f52695d != 0) {
                f10 = g(instanceUTC, f10);
                if (f10 >= j12) {
                    f10 = g(instanceUTC, f(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(f10, -1), this.f52693b)));
                }
            } else if (f10 >= j12) {
                f10 = f(instanceUTC, instanceUTC.year().add(f10, -1));
            }
            return instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(f10, 0), this.f52697f) - j11;
        }

        public final long d(org.joda.time.a aVar, long j10) {
            if (this.f52694c >= 0) {
                return aVar.dayOfMonth().set(j10, this.f52694c);
            }
            return aVar.dayOfMonth().add(aVar.monthOfYear().add(aVar.dayOfMonth().set(j10, 1), 1), this.f52694c);
        }

        public final long e(org.joda.time.a aVar, long j10) {
            try {
                return d(aVar, j10);
            } catch (IllegalArgumentException e2) {
                if (this.f52693b == 2 && this.f52694c == 29) {
                    while (!aVar.year().isLeap(j10)) {
                        j10 = aVar.year().add(j10, 1);
                    }
                    return d(aVar, j10);
                }
                throw e2;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f52692a == aVar.f52692a && this.f52693b == aVar.f52693b && this.f52694c == aVar.f52694c && this.f52695d == aVar.f52695d && this.f52696e == aVar.f52696e && this.f52697f == aVar.f52697f;
        }

        public final long f(org.joda.time.a aVar, long j10) {
            try {
                return d(aVar, j10);
            } catch (IllegalArgumentException e2) {
                if (this.f52693b == 2 && this.f52694c == 29) {
                    while (!aVar.year().isLeap(j10)) {
                        j10 = aVar.year().add(j10, -1);
                    }
                    return d(aVar, j10);
                }
                throw e2;
            }
        }

        public final long g(org.joda.time.a aVar, long j10) {
            int i10 = this.f52695d - aVar.dayOfWeek().get(j10);
            if (i10 == 0) {
                return j10;
            }
            if (this.f52696e) {
                if (i10 < 0) {
                    i10 += 7;
                }
            } else if (i10 > 0) {
                i10 -= 7;
            }
            return aVar.dayOfWeek().add(j10, i10);
        }

        public void h(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(this.f52692a);
            dataOutput.writeByte(this.f52693b);
            dataOutput.writeByte(this.f52694c);
            dataOutput.writeByte(this.f52695d);
            dataOutput.writeBoolean(this.f52696e);
            DateTimeZoneBuilder.d(dataOutput, this.f52697f);
        }

        public String toString() {
            return "[OfYear]\nMode: " + this.f52692a + "\nMonthOfYear: " + this.f52693b + "\nDayOfMonth: " + this.f52694c + "\nDayOfWeek: " + this.f52695d + "\nAdvanceDayOfWeek: " + this.f52696e + "\nMillisOfDay: " + this.f52697f + '\n';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final a f52698a;

        /* renamed from: b, reason: collision with root package name */
        public final String f52699b;

        /* renamed from: c, reason: collision with root package name */
        public final int f52700c;

        public b(a aVar, String str, int i10) {
            this.f52698a = aVar;
            this.f52699b = str;
            this.f52700c = i10;
        }

        public static b e(DataInput dataInput) throws IOException {
            return new b(a.c(dataInput), dataInput.readUTF(), (int) DateTimeZoneBuilder.c(dataInput));
        }

        public String a() {
            return this.f52699b;
        }

        public int b() {
            return this.f52700c;
        }

        public long c(long j10, int i10, int i11) {
            return this.f52698a.a(j10, i10, i11);
        }

        public long d(long j10, int i10, int i11) {
            return this.f52698a.b(j10, i10, i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f52700c == bVar.f52700c && this.f52699b.equals(bVar.f52699b) && this.f52698a.equals(bVar.f52698a);
        }

        public b f(String str) {
            return new b(this.f52698a, str, this.f52700c);
        }

        public b g(String str) {
            return f((this.f52699b + str).intern());
        }

        public void h(DataOutput dataOutput) throws IOException {
            this.f52698a.h(dataOutput);
            dataOutput.writeUTF(this.f52699b);
            DateTimeZoneBuilder.d(dataOutput, this.f52700c);
        }

        public String toString() {
            return ((Object) this.f52698a) + " named " + this.f52699b + " at " + this.f52700c;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f52701a;

        /* renamed from: b, reason: collision with root package name */
        public final String f52702b;

        /* renamed from: c, reason: collision with root package name */
        public final int f52703c;

        /* renamed from: d, reason: collision with root package name */
        public final int f52704d;

        public long a() {
            return this.f52701a;
        }

        public String b() {
            return this.f52702b;
        }

        public int c() {
            return this.f52704d;
        }

        public int d() {
            return this.f52703c;
        }

        public boolean e(c cVar) {
            if (cVar == null) {
                return true;
            }
            return this.f52701a > cVar.f52701a && !(this.f52703c == cVar.f52703c && this.f52704d == cVar.f52704d && this.f52702b.equals(cVar.f52702b));
        }

        public String toString() {
            return ((Object) new DateTime(this.f52701a, DateTimeZone.UTC)) + " " + this.f52704d + " " + this.f52703c;
        }
    }

    public static DateTimeZone a(DataInput dataInput, String str) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 67) {
            return CachedDateTimeZone.forZone(PrecalculatedZone.readFrom(dataInput, str));
        }
        if (readUnsignedByte != 70) {
            if (readUnsignedByte == 80) {
                return PrecalculatedZone.readFrom(dataInput, str);
            }
            throw new IOException("Invalid encoding");
        }
        FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone(str, dataInput.readUTF(), (int) c(dataInput), (int) c(dataInput));
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        return fixedDateTimeZone.equals(dateTimeZone) ? dateTimeZone : fixedDateTimeZone;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static DateTimeZone b(InputStream inputStream, String str) throws IOException {
        if (inputStream instanceof DataInput) {
            return a((DataInput) inputStream, str);
        }
        return a(new DataInputStream(inputStream), str);
    }

    public static long c(DataInput dataInput) throws IOException {
        long readUnsignedByte;
        long j10;
        int readUnsignedByte2 = dataInput.readUnsignedByte();
        int i10 = readUnsignedByte2 >> 6;
        if (i10 == 1) {
            readUnsignedByte = dataInput.readUnsignedByte() | ((readUnsignedByte2 << 26) >> 2) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8);
            j10 = 60000;
        } else if (i10 == 2) {
            readUnsignedByte = ((readUnsignedByte2 << 58) >> 26) | (dataInput.readUnsignedByte() << 24) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8) | dataInput.readUnsignedByte();
            j10 = 1000;
        } else {
            if (i10 == 3) {
                return dataInput.readLong();
            }
            readUnsignedByte = (readUnsignedByte2 << 26) >> 26;
            j10 = 1800000;
        }
        return readUnsignedByte * j10;
    }

    public static void d(DataOutput dataOutput, long j10) throws IOException {
        if (j10 % 1800000 == 0) {
            long j11 = j10 / 1800000;
            if (((j11 << 58) >> 58) == j11) {
                dataOutput.writeByte((int) (j11 & 63));
                return;
            }
        }
        if (j10 % 60000 == 0) {
            long j12 = j10 / 60000;
            if (((j12 << 34) >> 34) == j12) {
                dataOutput.writeInt(1073741824 | ((int) (j12 & 1073741823)));
                return;
            }
        }
        if (j10 % 1000 == 0) {
            long j13 = j10 / 1000;
            if (((j13 << 26) >> 26) == j13) {
                dataOutput.writeByte(((int) ((j13 >> 32) & 63)) | 128);
                dataOutput.writeInt((int) ((-1) & j13));
                return;
            }
        }
        dataOutput.writeByte(j10 < 0 ? 255 : 192);
        dataOutput.writeLong(j10);
    }
}
