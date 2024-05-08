package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import m7.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ExperimentTokens extends AbstractSafeParcelable {

    /* renamed from: j, reason: collision with root package name */
    public static final byte[][] f25787j;

    /* renamed from: k, reason: collision with root package name */
    public static final ExperimentTokens f25788k;

    /* renamed from: b, reason: collision with root package name */
    public final String f25793b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f25794c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[][] f25795d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[][] f25796e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[][] f25797f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[][] f25798g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f25799h;

    /* renamed from: i, reason: collision with root package name */
    public final byte[][] f25800i;
    public static final Parcelable.Creator<ExperimentTokens> CREATOR = new m7.c();

    /* renamed from: l, reason: collision with root package name */
    public static final a f25789l = new com.google.android.gms.phenotype.a();

    /* renamed from: m, reason: collision with root package name */
    public static final a f25790m = new b();

    /* renamed from: n, reason: collision with root package name */
    public static final a f25791n = new c();

    /* renamed from: o, reason: collision with root package name */
    public static final a f25792o = new d();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
    }

    static {
        byte[][] bArr = new byte[0];
        f25787j = bArr;
        f25788k = new ExperimentTokens("", null, bArr, bArr, bArr, bArr, null, null);
    }

    public ExperimentTokens(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.f25793b = str;
        this.f25794c = bArr;
        this.f25795d = bArr2;
        this.f25796e = bArr3;
        this.f25797f = bArr4;
        this.f25798g = bArr5;
        this.f25799h = iArr;
        this.f25800i = bArr6;
    }

    public static List<Integer> f(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<String> g(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] bArr2 : bArr) {
            arrayList.add(Base64.encodeToString(bArr2, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static void i(StringBuilder sb2, String str, byte[][] bArr) {
        String str2;
        sb2.append(str);
        sb2.append("=");
        if (bArr == null) {
            str2 = "null";
        } else {
            sb2.append("(");
            int length = bArr.length;
            boolean z10 = true;
            int i10 = 0;
            while (i10 < length) {
                byte[] bArr2 = bArr[i10];
                if (!z10) {
                    sb2.append(", ");
                }
                sb2.append("'");
                sb2.append(Base64.encodeToString(bArr2, 3));
                sb2.append("'");
                i10++;
                z10 = false;
            }
            str2 = ")";
        }
        sb2.append(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExperimentTokens) {
            ExperimentTokens experimentTokens = (ExperimentTokens) obj;
            if (h.a(this.f25793b, experimentTokens.f25793b) && Arrays.equals(this.f25794c, experimentTokens.f25794c) && h.a(g(this.f25795d), g(experimentTokens.f25795d)) && h.a(g(this.f25796e), g(experimentTokens.f25796e)) && h.a(g(this.f25797f), g(experimentTokens.f25797f)) && h.a(g(this.f25798g), g(experimentTokens.f25798g)) && h.a(f(this.f25799h), f(experimentTokens.f25799h)) && h.a(g(this.f25800i), g(experimentTokens.f25800i))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String sb2;
        StringBuilder sb3 = new StringBuilder("ExperimentTokens");
        sb3.append("(");
        String str = this.f25793b;
        if (str == null) {
            sb2 = "null";
        } else {
            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 2);
            sb4.append("'");
            sb4.append(str);
            sb4.append("'");
            sb2 = sb4.toString();
        }
        sb3.append(sb2);
        sb3.append(", ");
        byte[] bArr = this.f25794c;
        sb3.append("direct");
        sb3.append("=");
        if (bArr == null) {
            sb3.append("null");
        } else {
            sb3.append("'");
            sb3.append(Base64.encodeToString(bArr, 3));
            sb3.append("'");
        }
        sb3.append(", ");
        i(sb3, "GAIA", this.f25795d);
        sb3.append(", ");
        i(sb3, "PSEUDO", this.f25796e);
        sb3.append(", ");
        i(sb3, "ALWAYS", this.f25797f);
        sb3.append(", ");
        i(sb3, "OTHER", this.f25798g);
        sb3.append(", ");
        int[] iArr = this.f25799h;
        sb3.append("weak");
        sb3.append("=");
        if (iArr == null) {
            sb3.append("null");
        } else {
            sb3.append("(");
            int length = iArr.length;
            boolean z10 = true;
            int i10 = 0;
            while (i10 < length) {
                int i11 = iArr[i10];
                if (!z10) {
                    sb3.append(", ");
                }
                sb3.append(i11);
                i10++;
                z10 = false;
            }
            sb3.append(")");
        }
        sb3.append(", ");
        i(sb3, "directs", this.f25800i);
        sb3.append(")");
        return sb3.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.o(parcel, 2, this.f25793b, false);
        w6.a.e(parcel, 3, this.f25794c, false);
        w6.a.f(parcel, 4, this.f25795d, false);
        w6.a.f(parcel, 5, this.f25796e, false);
        w6.a.f(parcel, 6, this.f25797f, false);
        w6.a.f(parcel, 7, this.f25798g, false);
        w6.a.k(parcel, 8, this.f25799h, false);
        w6.a.f(parcel, 9, this.f25800i, false);
        w6.a.b(parcel, a10);
    }
}
