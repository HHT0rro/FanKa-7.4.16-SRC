package com.google.android.gms.internal.clearcut;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f24037a;

    /* renamed from: b, reason: collision with root package name */
    public int f24038b = 0;

    public q2(String str) {
        this.f24037a = str;
    }

    public final boolean a() {
        return this.f24038b < this.f24037a.length();
    }

    public final int b() {
        String str = this.f24037a;
        int i10 = this.f24038b;
        this.f24038b = i10 + 1;
        char charAt = str.charAt(i10);
        if (charAt < 55296) {
            return charAt;
        }
        int i11 = charAt & 8191;
        int i12 = 13;
        while (true) {
            String str2 = this.f24037a;
            int i13 = this.f24038b;
            this.f24038b = i13 + 1;
            char charAt2 = str2.charAt(i13);
            if (charAt2 < 55296) {
                return i11 | (charAt2 << i12);
            }
            i11 |= (charAt2 & 8191) << i12;
            i12 += 13;
        }
    }
}
