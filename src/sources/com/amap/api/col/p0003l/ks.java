package com.amap.api.col.p0003l;

import com.huawei.openalliance.ad.constant.u;

/* compiled from: AmapWifi.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ks {

    /* renamed from: a, reason: collision with root package name */
    public long f6685a;

    /* renamed from: b, reason: collision with root package name */
    public String f6686b;

    /* renamed from: d, reason: collision with root package name */
    public int f6688d;

    /* renamed from: e, reason: collision with root package name */
    public long f6689e;

    /* renamed from: g, reason: collision with root package name */
    public short f6691g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6692h;

    /* renamed from: c, reason: collision with root package name */
    public int f6687c = -113;

    /* renamed from: f, reason: collision with root package name */
    public long f6690f = 0;

    public ks(boolean z10) {
        this.f6692h = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ks clone() {
        ks ksVar = new ks(this.f6692h);
        ksVar.f6685a = this.f6685a;
        ksVar.f6686b = this.f6686b;
        ksVar.f6687c = this.f6687c;
        ksVar.f6688d = this.f6688d;
        ksVar.f6689e = this.f6689e;
        ksVar.f6690f = this.f6690f;
        ksVar.f6691g = this.f6691g;
        ksVar.f6692h = this.f6692h;
        return ksVar;
    }

    public final String a() {
        return this.f6692h + "#" + this.f6685a;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f6685a + ", ssid='" + this.f6686b + "', rssi=" + this.f6687c + ", frequency=" + this.f6688d + ", timestamp=" + this.f6689e + ", lastUpdateUtcMills=" + this.f6690f + ", freshness=" + ((int) this.f6691g) + ", connected=" + this.f6692h + '}';
    }

    public static String a(long j10) {
        if (j10 < 0 || j10 > 281474976710655L) {
            return null;
        }
        return la.a(la.a(j10), u.bD);
    }

    public static long a(String str) {
        long j10;
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i10 = 0;
        long j11 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long charAt = str.charAt(length);
            if (charAt < 48 || charAt > 57) {
                long j12 = 97;
                if (charAt < 97 || charAt > 102) {
                    j12 = 65;
                    if (charAt < 65 || charAt > 70) {
                        if (charAt != 58 && charAt != 124) {
                            return 0L;
                        }
                    }
                }
                j10 = (charAt - j12) + 10;
            } else {
                j10 = charAt - 48;
            }
            j11 += j10 << i10;
            i10 += 4;
        }
        if (i10 != 48) {
            return 0L;
        }
        return j11;
    }
}
