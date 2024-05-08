package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Comparator;
import m7.e;
import m7.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzi extends AbstractSafeParcelable implements Comparable<zzi> {
    public static final Parcelable.Creator<zzi> CREATOR = new e();

    /* renamed from: j, reason: collision with root package name */
    public static final Comparator<zzi> f25801j = new m7.d();

    /* renamed from: b, reason: collision with root package name */
    public final String f25802b;

    /* renamed from: c, reason: collision with root package name */
    public final long f25803c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f25804d;

    /* renamed from: e, reason: collision with root package name */
    public final double f25805e;

    /* renamed from: f, reason: collision with root package name */
    public final String f25806f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f25807g;

    /* renamed from: h, reason: collision with root package name */
    public final int f25808h;

    /* renamed from: i, reason: collision with root package name */
    public final int f25809i;

    public zzi(String str, long j10, boolean z10, double d10, String str2, byte[] bArr, int i10, int i11) {
        this.f25802b = str;
        this.f25803c = j10;
        this.f25804d = z10;
        this.f25805e = d10;
        this.f25806f = str2;
        this.f25807g = bArr;
        this.f25808h = i10;
        this.f25809i = i11;
    }

    public static int f(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzi zziVar) {
        zzi zziVar2 = zziVar;
        int compareTo = this.f25802b.compareTo(zziVar2.f25802b);
        if (compareTo != 0) {
            return compareTo;
        }
        int f10 = f(this.f25808h, zziVar2.f25808h);
        if (f10 != 0) {
            return f10;
        }
        int i10 = this.f25808h;
        if (i10 == 1) {
            long j10 = this.f25803c;
            long j11 = zziVar2.f25803c;
            if (j10 < j11) {
                return -1;
            }
            return j10 == j11 ? 0 : 1;
        }
        if (i10 == 2) {
            boolean z10 = this.f25804d;
            if (z10 == zziVar2.f25804d) {
                return 0;
            }
            return z10 ? 1 : -1;
        }
        if (i10 == 3) {
            return Double.compare(this.f25805e, zziVar2.f25805e);
        }
        if (i10 == 4) {
            String str = this.f25806f;
            String str2 = zziVar2.f25806f;
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return str.compareTo(str2);
        }
        if (i10 != 5) {
            int i11 = this.f25808h;
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Invalid enum value: ");
            sb2.append(i11);
            throw new AssertionError((Object) sb2.toString());
        }
        byte[] bArr = this.f25807g;
        byte[] bArr2 = zziVar2.f25807g;
        if (bArr == bArr2) {
            return 0;
        }
        if (bArr == null) {
            return -1;
        }
        if (bArr2 == null) {
            return 1;
        }
        for (int i12 = 0; i12 < Math.min(this.f25807g.length, zziVar2.f25807g.length); i12++) {
            int i13 = this.f25807g[i12] - zziVar2.f25807g[i12];
            if (i13 != 0) {
                return i13;
            }
        }
        return f(this.f25807g.length, zziVar2.f25807g.length);
    }

    public final boolean equals(Object obj) {
        int i10;
        if (obj instanceof zzi) {
            zzi zziVar = (zzi) obj;
            if (h.a(this.f25802b, zziVar.f25802b) && (i10 = this.f25808h) == zziVar.f25808h && this.f25809i == zziVar.f25809i) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        return this.f25804d == zziVar.f25804d;
                    }
                    if (i10 == 3) {
                        return this.f25805e == zziVar.f25805e;
                    }
                    if (i10 == 4) {
                        return h.a(this.f25806f, zziVar.f25806f);
                    }
                    if (i10 == 5) {
                        return Arrays.equals(this.f25807g, zziVar.f25807g);
                    }
                    int i11 = this.f25808h;
                    StringBuilder sb2 = new StringBuilder(31);
                    sb2.append("Invalid enum value: ");
                    sb2.append(i11);
                    throw new AssertionError((Object) sb2.toString());
                }
                if (this.f25803c == zziVar.f25803c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Flag(");
        sb2.append(this.f25802b);
        sb2.append(", ");
        int i10 = this.f25808h;
        if (i10 == 1) {
            sb2.append(this.f25803c);
        } else if (i10 == 2) {
            sb2.append(this.f25804d);
        } else if (i10 != 3) {
            if (i10 == 4) {
                sb2.append("'");
                str = this.f25806f;
            } else {
                if (i10 != 5) {
                    String str2 = this.f25802b;
                    int i11 = this.f25808h;
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 27);
                    sb3.append("Invalid type: ");
                    sb3.append(str2);
                    sb3.append(", ");
                    sb3.append(i11);
                    throw new AssertionError((Object) sb3.toString());
                }
                if (this.f25807g == null) {
                    sb2.append("null");
                } else {
                    sb2.append("'");
                    str = Base64.encodeToString(this.f25807g, 3);
                }
            }
            sb2.append(str);
            sb2.append("'");
        } else {
            sb2.append(this.f25805e);
        }
        sb2.append(", ");
        sb2.append(this.f25808h);
        sb2.append(", ");
        sb2.append(this.f25809i);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.o(parcel, 2, this.f25802b, false);
        w6.a.l(parcel, 3, this.f25803c);
        w6.a.c(parcel, 4, this.f25804d);
        w6.a.g(parcel, 5, this.f25805e);
        w6.a.o(parcel, 6, this.f25806f, false);
        w6.a.e(parcel, 7, this.f25807g, false);
        w6.a.j(parcel, 8, this.f25808h);
        w6.a.j(parcel, 9, this.f25809i);
        w6.a.b(parcel, a10);
    }
}
