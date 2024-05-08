package org.joda.time.format;

import java.util.Arrays;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;

/* compiled from: DateTimeParserBucket.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final org.joda.time.a f52586a;

    /* renamed from: b, reason: collision with root package name */
    public final long f52587b;

    /* renamed from: c, reason: collision with root package name */
    public final Locale f52588c;

    /* renamed from: d, reason: collision with root package name */
    public final int f52589d;

    /* renamed from: e, reason: collision with root package name */
    public final DateTimeZone f52590e;

    /* renamed from: f, reason: collision with root package name */
    public final Integer f52591f;

    /* renamed from: g, reason: collision with root package name */
    public DateTimeZone f52592g;

    /* renamed from: h, reason: collision with root package name */
    public Integer f52593h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f52594i;

    /* renamed from: j, reason: collision with root package name */
    public a[] f52595j;

    /* renamed from: k, reason: collision with root package name */
    public int f52596k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f52597l;

    /* renamed from: m, reason: collision with root package name */
    public Object f52598m;

    /* compiled from: DateTimeParserBucket.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements Comparable<a> {

        /* renamed from: b, reason: collision with root package name */
        public org.joda.time.b f52599b;

        /* renamed from: c, reason: collision with root package name */
        public int f52600c;

        /* renamed from: d, reason: collision with root package name */
        public String f52601d;

        /* renamed from: e, reason: collision with root package name */
        public Locale f52602e;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            org.joda.time.b bVar = aVar.f52599b;
            int j10 = d.j(this.f52599b.getRangeDurationField(), bVar.getRangeDurationField());
            return j10 != 0 ? j10 : d.j(this.f52599b.getDurationField(), bVar.getDurationField());
        }

        public void b(org.joda.time.b bVar, int i10) {
            this.f52599b = bVar;
            this.f52600c = i10;
            this.f52601d = null;
            this.f52602e = null;
        }

        public void c(org.joda.time.b bVar, String str, Locale locale) {
            this.f52599b = bVar;
            this.f52600c = 0;
            this.f52601d = str;
            this.f52602e = locale;
        }

        public long f(long j10, boolean z10) {
            long j11;
            String str = this.f52601d;
            if (str == null) {
                j11 = this.f52599b.setExtended(j10, this.f52600c);
            } else {
                j11 = this.f52599b.set(j10, str, this.f52602e);
            }
            return z10 ? this.f52599b.roundFloor(j11) : j11;
        }
    }

    /* compiled from: DateTimeParserBucket.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public final DateTimeZone f52603a;

        /* renamed from: b, reason: collision with root package name */
        public final Integer f52604b;

        /* renamed from: c, reason: collision with root package name */
        public final a[] f52605c;

        /* renamed from: d, reason: collision with root package name */
        public final int f52606d;

        public b() {
            this.f52603a = d.this.f52592g;
            this.f52604b = d.this.f52593h;
            this.f52605c = d.this.f52595j;
            this.f52606d = d.this.f52596k;
        }

        public boolean a(d dVar) {
            if (dVar != d.this) {
                return false;
            }
            dVar.f52592g = this.f52603a;
            dVar.f52593h = this.f52604b;
            dVar.f52595j = this.f52605c;
            if (this.f52606d < dVar.f52596k) {
                dVar.f52597l = true;
            }
            dVar.f52596k = this.f52606d;
            return true;
        }
    }

    public d(long j10, org.joda.time.a aVar, Locale locale, Integer num, int i10) {
        org.joda.time.a c4 = org.joda.time.c.c(aVar);
        this.f52587b = j10;
        DateTimeZone zone = c4.getZone();
        this.f52590e = zone;
        this.f52586a = c4.withUTC();
        this.f52588c = locale == null ? Locale.getDefault() : locale;
        this.f52589d = i10;
        this.f52591f = num;
        this.f52592g = zone;
        this.f52594i = num;
        this.f52595j = new a[8];
    }

    public static void A(a[] aVarArr, int i10) {
        if (i10 > 10) {
            Arrays.sort(aVarArr, 0, i10);
            return;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            for (int i12 = i11; i12 > 0; i12--) {
                int i13 = i12 - 1;
                if (aVarArr[i13].compareTo(aVarArr[i12]) > 0) {
                    a aVar = aVarArr[i12];
                    aVarArr[i12] = aVarArr[i13];
                    aVarArr[i13] = aVar;
                }
            }
        }
    }

    public static int j(org.joda.time.d dVar, org.joda.time.d dVar2) {
        if (dVar == null || !dVar.isSupported()) {
            return (dVar2 == null || !dVar2.isSupported()) ? 0 : -1;
        }
        if (dVar2 == null || !dVar2.isSupported()) {
            return 1;
        }
        return -dVar.compareTo(dVar2);
    }

    public long k(boolean z10, CharSequence charSequence) {
        a[] aVarArr = this.f52595j;
        int i10 = this.f52596k;
        if (this.f52597l) {
            aVarArr = (a[]) aVarArr.clone();
            this.f52595j = aVarArr;
            this.f52597l = false;
        }
        A(aVarArr, i10);
        if (i10 > 0) {
            org.joda.time.d field = DurationFieldType.months().getField(this.f52586a);
            org.joda.time.d field2 = DurationFieldType.days().getField(this.f52586a);
            org.joda.time.d durationField = aVarArr[0].f52599b.getDurationField();
            if (j(durationField, field) >= 0 && j(durationField, field2) <= 0) {
                v(DateTimeFieldType.year(), this.f52589d);
                return k(z10, charSequence);
            }
        }
        long j10 = this.f52587b;
        for (int i11 = 0; i11 < i10; i11++) {
            try {
                j10 = aVarArr[i11].f(j10, z10);
            } catch (IllegalFieldValueException e2) {
                if (charSequence != null) {
                    e2.prependMessage("Cannot parse \"" + ((Object) charSequence) + '\"');
                }
                throw e2;
            }
        }
        if (z10) {
            int i12 = 0;
            while (i12 < i10) {
                if (!aVarArr[i12].f52599b.isLenient()) {
                    j10 = aVarArr[i12].f(j10, i12 == i10 + (-1));
                }
                i12++;
            }
        }
        if (this.f52593h != null) {
            return j10 - r9.intValue();
        }
        DateTimeZone dateTimeZone = this.f52592g;
        if (dateTimeZone == null) {
            return j10;
        }
        int offsetFromLocal = dateTimeZone.getOffsetFromLocal(j10);
        long j11 = j10 - offsetFromLocal;
        if (offsetFromLocal == this.f52592g.getOffset(j11)) {
            return j11;
        }
        String str = "Illegal instant due to time zone offset transition (" + ((Object) this.f52592g) + ')';
        if (charSequence != null) {
            str = "Cannot parse \"" + ((Object) charSequence) + "\": " + str;
        }
        throw new IllegalInstantException(str);
    }

    public long l(boolean z10, String str) {
        return k(z10, str);
    }

    public long m(k kVar, CharSequence charSequence) {
        int parseInto = kVar.parseInto(this, charSequence, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= charSequence.length()) {
            return k(true, charSequence);
        }
        throw new IllegalArgumentException(h.h(charSequence.toString(), parseInto));
    }

    public org.joda.time.a n() {
        return this.f52586a;
    }

    public Locale o() {
        return this.f52588c;
    }

    public Integer p() {
        return this.f52593h;
    }

    public Integer q() {
        return this.f52594i;
    }

    public DateTimeZone r() {
        return this.f52592g;
    }

    public final a s() {
        a[] aVarArr = this.f52595j;
        int i10 = this.f52596k;
        if (i10 == aVarArr.length || this.f52597l) {
            a[] aVarArr2 = new a[i10 == aVarArr.length ? i10 * 2 : aVarArr.length];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, i10);
            this.f52595j = aVarArr2;
            this.f52597l = false;
            aVarArr = aVarArr2;
        }
        this.f52598m = null;
        a aVar = aVarArr[i10];
        if (aVar == null) {
            aVar = new a();
            aVarArr[i10] = aVar;
        }
        this.f52596k = i10 + 1;
        return aVar;
    }

    public boolean t(Object obj) {
        if (!(obj instanceof b) || !((b) obj).a(this)) {
            return false;
        }
        this.f52598m = obj;
        return true;
    }

    public void u(org.joda.time.b bVar, int i10) {
        s().b(bVar, i10);
    }

    public void v(DateTimeFieldType dateTimeFieldType, int i10) {
        s().b(dateTimeFieldType.getField(this.f52586a), i10);
    }

    public void w(DateTimeFieldType dateTimeFieldType, String str, Locale locale) {
        s().c(dateTimeFieldType.getField(this.f52586a), str, locale);
    }

    public Object x() {
        if (this.f52598m == null) {
            this.f52598m = new b();
        }
        return this.f52598m;
    }

    public void y(Integer num) {
        this.f52598m = null;
        this.f52593h = num;
    }

    public void z(DateTimeZone dateTimeZone) {
        this.f52598m = null;
        this.f52592g = dateTimeZone;
    }
}
