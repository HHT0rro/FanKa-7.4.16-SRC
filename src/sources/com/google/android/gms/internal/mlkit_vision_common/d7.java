package com.google.android.gms.internal.mlkit_vision_common;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d7 {
    @WorkerThread
    public static void a(q6 q6Var, final int i10, final int i11, long j10, final int i12, final int i13, final int i14, final int i15) {
        final long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
        q6Var.a(new o6(i10, i11, i14, i12, i13, elapsedRealtime, i15) { // from class: com.google.android.gms.internal.mlkit_vision_common.c7

            /* renamed from: a, reason: collision with root package name */
            public final int f24264a;

            /* renamed from: b, reason: collision with root package name */
            public final int f24265b;

            /* renamed from: c, reason: collision with root package name */
            public final int f24266c;

            /* renamed from: d, reason: collision with root package name */
            public final int f24267d;

            /* renamed from: e, reason: collision with root package name */
            public final int f24268e;

            /* renamed from: f, reason: collision with root package name */
            public final long f24269f;

            /* renamed from: g, reason: collision with root package name */
            public final int f24270g;

            {
                this.f24264a = i10;
                this.f24265b = i11;
                this.f24266c = i14;
                this.f24267d = i12;
                this.f24268e = i13;
                this.f24269f = elapsedRealtime;
                this.f24270g = i15;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.o6
            public final r6 zza() {
                zzff zzffVar;
                zzfk zzfkVar;
                int i16 = this.f24264a;
                int i17 = this.f24265b;
                int i18 = this.f24266c;
                int i19 = this.f24267d;
                int i20 = this.f24268e;
                long j11 = this.f24269f;
                int i21 = this.f24270g;
                n4 n4Var = new n4();
                if (i16 == -1) {
                    zzffVar = zzff.BITMAP;
                } else if (i16 == 35) {
                    zzffVar = zzff.YUV_420_888;
                } else if (i16 == 842094169) {
                    zzffVar = zzff.YV12;
                } else if (i16 == 16) {
                    zzffVar = zzff.NV16;
                } else if (i16 != 17) {
                    zzffVar = zzff.UNKNOWN_FORMAT;
                } else {
                    zzffVar = zzff.NV21;
                }
                n4Var.c(zzffVar);
                if (i17 == 1) {
                    zzfkVar = zzfk.BITMAP;
                } else if (i17 == 2) {
                    zzfkVar = zzfk.BYTEARRAY;
                } else if (i17 == 3) {
                    zzfkVar = zzfk.BYTEBUFFER;
                } else if (i17 != 4) {
                    zzfkVar = zzfk.ANDROID_MEDIA_IMAGE;
                } else {
                    zzfkVar = zzfk.FILEPATH;
                }
                n4Var.b(zzfkVar);
                n4Var.d(Integer.valueOf(i18));
                n4Var.f(Integer.valueOf(i19));
                n4Var.e(Integer.valueOf(i20));
                n4Var.a(Long.valueOf(j11));
                n4Var.g(Integer.valueOf(i21));
                o4 h10 = n4Var.h();
                t4 t4Var = new t4();
                t4Var.c(h10);
                return r6.c(t4Var);
            }
        }, zzfp.INPUT_IMAGE_CONSTRUCTION);
    }
}
