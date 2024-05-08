package com.tencent.turingface.sdk.mfa;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class KKOXW extends ucT3w {

    /* renamed from: j, reason: collision with root package name */
    public byte[] f45621j;

    /* renamed from: l, reason: collision with root package name */
    public Map<String, String> f45623l;

    /* renamed from: m, reason: collision with root package name */
    public Map<String, String> f45624m;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f45614c = true;

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f45612a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, String> f45613b = null;

    /* renamed from: d, reason: collision with root package name */
    public short f45615d = 0;

    /* renamed from: e, reason: collision with root package name */
    public byte f45616e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f45617f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f45618g = 0;

    /* renamed from: h, reason: collision with root package name */
    public String f45619h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f45620i = null;

    /* renamed from: k, reason: collision with root package name */
    public int f45622k = 0;

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(d5HOq d5hoq) {
        d5hoq.a(this.f45615d, 1);
        d5hoq.a(this.f45616e, 2);
        d5hoq.a(this.f45617f, 3);
        d5hoq.a(this.f45618g, 4);
        d5hoq.a(this.f45619h, 5);
        d5hoq.a(this.f45620i, 6);
        d5hoq.a(this.f45621j, 7);
        d5hoq.a(this.f45622k, 8);
        d5hoq.a((Map) this.f45623l, 9);
        d5hoq.a((Map) this.f45624m, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f45614c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        KKOXW kkoxw = (KKOXW) obj;
        Integer num = 1;
        return fi6GY.a(1, (int) kkoxw.f45615d) && fi6GY.a(1, (int) kkoxw.f45616e) && fi6GY.a(1, kkoxw.f45617f) && fi6GY.a(1, kkoxw.f45618g) && num.equals(kkoxw.f45619h) && num.equals(kkoxw.f45620i) && num.equals(kkoxw.f45621j) && fi6GY.a(1, kkoxw.f45622k) && num.equals(kkoxw.f45623l) && num.equals(kkoxw.f45624m);
    }

    @Override // com.tencent.turingface.sdk.mfa.ucT3w
    public final void a(nyvKz nyvkz) {
        String str;
        try {
            this.f45615d = nyvkz.a(this.f45615d, 1, true);
            this.f45616e = nyvkz.a(this.f45616e, 2, true);
            this.f45617f = nyvkz.a(this.f45617f, 3, true);
            this.f45618g = nyvkz.a(this.f45618g, 4, true);
            this.f45619h = nyvkz.b(5, true);
            this.f45620i = nyvkz.b(6, true);
            if (f45612a == null) {
                f45612a = new byte[]{0};
            }
            this.f45621j = nyvkz.a(7, true);
            this.f45622k = nyvkz.a(this.f45622k, 8, true);
            if (f45613b == null) {
                HashMap hashMap = new HashMap();
                f45613b = hashMap;
                hashMap.put("", "");
            }
            this.f45623l = (Map) nyvkz.a((nyvKz) f45613b, 9, true);
            if (f45613b == null) {
                HashMap hashMap2 = new HashMap();
                f45613b = hashMap2;
                hashMap2.put("", "");
            }
            this.f45624m = (Map) nyvkz.a((nyvKz) f45613b, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder b4 = com.tencent.turingcam.oqKCa.b("RequestPacket decode error ");
            byte[] bArr = this.f45621j;
            if (bArr == null || bArr.length == 0) {
                str = null;
            } else {
                char[] cArr = new char[bArr.length * 2];
                for (int i10 = 0; i10 < bArr.length; i10++) {
                    byte b10 = bArr[i10];
                    int i11 = i10 * 2;
                    char[] cArr2 = NbXuL.f45641a;
                    cArr[i11 + 1] = cArr2[b10 & 15];
                    cArr[i11 + 0] = cArr2[((byte) (b10 >>> 4)) & 15];
                }
                str = new String(cArr);
            }
            b4.append(str);
            printStream.println(b4.toString());
            throw new RuntimeException(e2);
        }
    }
}
