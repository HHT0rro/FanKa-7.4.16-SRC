package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.clearcut.a5;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.Arrays;
import t6.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new d();

    /* renamed from: b, reason: collision with root package name */
    public zzr f23345b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f23346c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f23347d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f23348e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f23349f;

    /* renamed from: g, reason: collision with root package name */
    public byte[][] f23350g;

    /* renamed from: h, reason: collision with root package name */
    public ExperimentTokens[] f23351h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f23352i;

    /* renamed from: j, reason: collision with root package name */
    public final a5 f23353j;

    /* renamed from: k, reason: collision with root package name */
    public final a.c f23354k;

    /* renamed from: l, reason: collision with root package name */
    public final a.c f23355l;

    public zze(zzr zzrVar, a5 a5Var, a.c cVar, a.c cVar2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, ExperimentTokens[] experimentTokensArr, boolean z10) {
        this.f23345b = zzrVar;
        this.f23353j = a5Var;
        this.f23354k = cVar;
        this.f23355l = null;
        this.f23347d = iArr;
        this.f23348e = null;
        this.f23349f = iArr2;
        this.f23350g = null;
        this.f23351h = null;
        this.f23352i = z10;
    }

    public zze(zzr zzrVar, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z10, ExperimentTokens[] experimentTokensArr) {
        this.f23345b = zzrVar;
        this.f23346c = bArr;
        this.f23347d = iArr;
        this.f23348e = strArr;
        this.f23353j = null;
        this.f23354k = null;
        this.f23355l = null;
        this.f23349f = iArr2;
        this.f23350g = bArr2;
        this.f23351h = experimentTokensArr;
        this.f23352i = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zze) {
            zze zzeVar = (zze) obj;
            if (g.a(this.f23345b, zzeVar.f23345b) && Arrays.equals(this.f23346c, zzeVar.f23346c) && Arrays.equals(this.f23347d, zzeVar.f23347d) && Arrays.equals(this.f23348e, zzeVar.f23348e) && g.a(this.f23353j, zzeVar.f23353j) && g.a(this.f23354k, zzeVar.f23354k) && g.a(this.f23355l, zzeVar.f23355l) && Arrays.equals(this.f23349f, zzeVar.f23349f) && Arrays.deepEquals(this.f23350g, zzeVar.f23350g) && Arrays.equals(this.f23351h, zzeVar.f23351h) && this.f23352i == zzeVar.f23352i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return g.b(this.f23345b, this.f23346c, this.f23347d, this.f23348e, this.f23353j, this.f23354k, this.f23355l, this.f23349f, this.f23350g, this.f23351h, Boolean.valueOf(this.f23352i));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("LogEventParcelable[");
        sb2.append((Object) this.f23345b);
        sb2.append(", LogEventBytes: ");
        byte[] bArr = this.f23346c;
        sb2.append(bArr == null ? null : new String(bArr));
        sb2.append(", TestCodes: ");
        sb2.append(Arrays.toString(this.f23347d));
        sb2.append(", MendelPackages: ");
        sb2.append(Arrays.toString(this.f23348e));
        sb2.append(", LogEvent: ");
        sb2.append((Object) this.f23353j);
        sb2.append(", ExtensionProducer: ");
        sb2.append((Object) this.f23354k);
        sb2.append(", VeProducer: ");
        sb2.append((Object) this.f23355l);
        sb2.append(", ExperimentIDs: ");
        sb2.append(Arrays.toString(this.f23349f));
        sb2.append(", ExperimentTokens: ");
        sb2.append(Arrays.toString(this.f23350g));
        sb2.append(", ExperimentTokensParcelables: ");
        sb2.append(Arrays.toString(this.f23351h));
        sb2.append(", AddPhenotypeExperimentTokens: ");
        sb2.append(this.f23352i);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = w6.a.a(parcel);
        w6.a.n(parcel, 2, this.f23345b, i10, false);
        w6.a.e(parcel, 3, this.f23346c, false);
        w6.a.k(parcel, 4, this.f23347d, false);
        w6.a.p(parcel, 5, this.f23348e, false);
        w6.a.k(parcel, 6, this.f23349f, false);
        w6.a.f(parcel, 7, this.f23350g, false);
        w6.a.c(parcel, 8, this.f23352i);
        w6.a.r(parcel, 9, this.f23351h, i10, false);
        w6.a.b(parcel, a10);
    }
}
