package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s5 extends n5 {
    public s5() {
        super();
    }

    public static <E> g5<E> e(Object obj, long j10) {
        return (g5) p7.F(obj, j10);
    }

    @Override // com.google.android.gms.internal.vision.n5
    public final <E> void b(Object obj, Object obj2, long j10) {
        g5 e2 = e(obj, j10);
        g5 e10 = e(obj2, j10);
        int size = e2.size();
        int size2 = e10.size();
        if (size > 0 && size2 > 0) {
            if (!e2.zza()) {
                e2 = e2.zza(size2 + size);
            }
            e2.addAll(e10);
        }
        if (size > 0) {
            e10 = e2;
        }
        p7.j(obj, j10, e10);
    }

    @Override // com.google.android.gms.internal.vision.n5
    public final void d(Object obj, long j10) {
        e(obj, j10).zzb();
    }
}
