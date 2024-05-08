package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r6 implements a6 {

    /* renamed from: a, reason: collision with root package name */
    public final c6 f25626a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25627b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f25628c;

    /* renamed from: d, reason: collision with root package name */
    public final int f25629d;

    public r6(c6 c6Var, String str, Object[] objArr) {
        this.f25626a = c6Var;
        this.f25627b = str;
        this.f25628c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f25629d = charAt;
            return;
        }
        int i10 = charAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char charAt2 = str.charAt(i12);
            if (charAt2 < 55296) {
                this.f25629d = i10 | (charAt2 << i11);
                return;
            } else {
                i10 |= (charAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            }
        }
    }

    public final String a() {
        return this.f25627b;
    }

    public final Object[] b() {
        return this.f25628c;
    }

    @Override // com.google.android.gms.internal.vision.a6
    public final int zza() {
        return (this.f25629d & 1) == 1 ? q6.f25613a : q6.f25614b;
    }

    @Override // com.google.android.gms.internal.vision.a6
    public final boolean zzb() {
        return (this.f25629d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.vision.a6
    public final c6 zzc() {
        return this.f25626a;
    }
}
