package org.joda.time.tz;

import org.joda.time.DateTimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CachedDateTimeZone extends DateTimeZone {
    private static final int cInfoCacheMask;
    private static final long serialVersionUID = 5472298452022250685L;
    private final transient a[] iInfoCache;
    private final DateTimeZone iZone;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f52686a;

        /* renamed from: b, reason: collision with root package name */
        public final DateTimeZone f52687b;

        /* renamed from: c, reason: collision with root package name */
        public a f52688c;

        /* renamed from: d, reason: collision with root package name */
        public String f52689d;

        /* renamed from: e, reason: collision with root package name */
        public int f52690e = Integer.MIN_VALUE;

        /* renamed from: f, reason: collision with root package name */
        public int f52691f = Integer.MIN_VALUE;

        public a(DateTimeZone dateTimeZone, long j10) {
            this.f52686a = j10;
            this.f52687b = dateTimeZone;
        }

        public String a(long j10) {
            a aVar = this.f52688c;
            if (aVar != null && j10 >= aVar.f52686a) {
                return aVar.a(j10);
            }
            if (this.f52689d == null) {
                this.f52689d = this.f52687b.getNameKey(this.f52686a);
            }
            return this.f52689d;
        }

        public int b(long j10) {
            a aVar = this.f52688c;
            if (aVar != null && j10 >= aVar.f52686a) {
                return aVar.b(j10);
            }
            if (this.f52690e == Integer.MIN_VALUE) {
                this.f52690e = this.f52687b.getOffset(this.f52686a);
            }
            return this.f52690e;
        }

        public int c(long j10) {
            a aVar = this.f52688c;
            if (aVar != null && j10 >= aVar.f52686a) {
                return aVar.c(j10);
            }
            if (this.f52691f == Integer.MIN_VALUE) {
                this.f52691f = this.f52687b.getStandardOffset(this.f52686a);
            }
            return this.f52691f;
        }
    }

    static {
        Integer num;
        int i10;
        try {
            num = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
        } catch (SecurityException unused) {
            num = null;
        }
        if (num == null) {
            i10 = 512;
        } else {
            int i11 = 0;
            for (int intValue = num.intValue() - 1; intValue > 0; intValue >>= 1) {
                i11++;
            }
            i10 = 1 << i11;
        }
        cInfoCacheMask = i10 - 1;
    }

    private CachedDateTimeZone(DateTimeZone dateTimeZone) {
        super(dateTimeZone.getID());
        this.iInfoCache = new a[cInfoCacheMask + 1];
        this.iZone = dateTimeZone;
    }

    private a createInfo(long j10) {
        long j11 = j10 & (-4294967296L);
        a aVar = new a(this.iZone, j11);
        long j12 = 4294967295L | j11;
        a aVar2 = aVar;
        while (true) {
            long nextTransition = this.iZone.nextTransition(j11);
            if (nextTransition == j11 || nextTransition > j12) {
                break;
            }
            a aVar3 = new a(this.iZone, nextTransition);
            aVar2.f52688c = aVar3;
            aVar2 = aVar3;
            j11 = nextTransition;
        }
        return aVar;
    }

    public static CachedDateTimeZone forZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone instanceof CachedDateTimeZone) {
            return (CachedDateTimeZone) dateTimeZone;
        }
        return new CachedDateTimeZone(dateTimeZone);
    }

    private a getInfo(long j10) {
        int i10 = (int) (j10 >> 32);
        a[] aVarArr = this.iInfoCache;
        int i11 = cInfoCacheMask & i10;
        a aVar = aVarArr[i11];
        if (aVar != null && ((int) (aVar.f52686a >> 32)) == i10) {
            return aVar;
        }
        a createInfo = createInfo(j10);
        aVarArr[i11] = createInfo;
        return createInfo;
    }

    @Override // org.joda.time.DateTimeZone
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CachedDateTimeZone) {
            return this.iZone.equals(((CachedDateTimeZone) obj).iZone);
        }
        return false;
    }

    @Override // org.joda.time.DateTimeZone
    public String getNameKey(long j10) {
        return getInfo(j10).a(j10);
    }

    @Override // org.joda.time.DateTimeZone
    public int getOffset(long j10) {
        return getInfo(j10).b(j10);
    }

    @Override // org.joda.time.DateTimeZone
    public int getStandardOffset(long j10) {
        return getInfo(j10).c(j10);
    }

    public DateTimeZone getUncachedZone() {
        return this.iZone;
    }

    @Override // org.joda.time.DateTimeZone
    public int hashCode() {
        return this.iZone.hashCode();
    }

    @Override // org.joda.time.DateTimeZone
    public boolean isFixed() {
        return this.iZone.isFixed();
    }

    @Override // org.joda.time.DateTimeZone
    public long nextTransition(long j10) {
        return this.iZone.nextTransition(j10);
    }

    @Override // org.joda.time.DateTimeZone
    public long previousTransition(long j10) {
        return this.iZone.previousTransition(j10);
    }
}
