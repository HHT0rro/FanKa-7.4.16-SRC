package p8;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.mlkit_vision_face.h7;
import com.google.android.gms.internal.mlkit_vision_face.i6;
import com.google.android.gms.internal.mlkit_vision_face.i7;
import com.google.android.gms.internal.mlkit_vision_face.i9;
import com.google.android.gms.internal.mlkit_vision_face.r6;
import com.google.android.gms.internal.mlkit_vision_face.t8;
import com.google.android.gms.internal.mlkit_vision_face.u8;
import com.google.android.gms.internal.mlkit_vision_face.w1;
import com.google.android.gms.internal.mlkit_vision_face.w8;
import com.google.android.gms.internal.mlkit_vision_face.x1;
import com.google.android.gms.internal.mlkit_vision_face.x8;
import com.google.android.gms.internal.mlkit_vision_face.y1;
import com.google.android.gms.internal.mlkit_vision_face.y6;
import com.google.android.gms.internal.mlkit_vision_face.zzin;
import com.google.android.gms.internal.mlkit_vision_face.zzio;
import com.google.mlkit.common.MlKitException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class h extends com.google.mlkit.common.sdkinternal.f<List<o8.a>, m8.a> {

    /* renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    public static final AtomicBoolean f52956i = new AtomicBoolean(true);

    /* renamed from: j, reason: collision with root package name */
    public static final n8.d f52957j = n8.d.b();

    /* renamed from: d, reason: collision with root package name */
    public final o8.d f52958d;

    /* renamed from: e, reason: collision with root package name */
    public final w8 f52959e;

    /* renamed from: f, reason: collision with root package name */
    public final b f52960f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f52961g;

    /* renamed from: h, reason: collision with root package name */
    public final n8.a f52962h = new n8.a();

    @VisibleForTesting
    public h(@NonNull w8 w8Var, @NonNull o8.d dVar, @NonNull b bVar) {
        com.google.android.gms.common.internal.h.i(dVar, "FaceDetectorOptions can not be null");
        this.f52958d = dVar;
        this.f52959e = w8Var;
        this.f52960f = bVar;
    }

    public static void j(@NonNull List<o8.a> list) {
        Iterator<o8.a> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().f(-1);
        }
    }

    @Override // com.google.mlkit.common.sdkinternal.k
    @WorkerThread
    public final synchronized void b() throws MlKitException {
        this.f52961g = this.f52960f.zza();
    }

    @Override // com.google.mlkit.common.sdkinternal.k
    @WorkerThread
    public final synchronized void d() {
        this.f52960f.zzc();
        f52956i.set(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        r2 = (java.util.List) com.google.android.gms.common.internal.h.h(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0116 A[Catch: MlKitException -> 0x012c, all -> 0x014b, TryCatch #1 {MlKitException -> 0x012c, blocks: (B:16:0x0107, B:21:0x011b, B:32:0x0116, B:33:0x010d, B:51:0x00ac, B:53:0x00d2, B:55:0x00e1, B:62:0x00f4, B:67:0x00ff), top: B:50:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010d A[Catch: MlKitException -> 0x012c, all -> 0x014b, TryCatch #1 {MlKitException -> 0x012c, blocks: (B:16:0x0107, B:21:0x011b, B:32:0x0116, B:33:0x010d, B:51:0x00ac, B:53:0x00d2, B:55:0x00e1, B:62:0x00f4, B:67:0x00ff), top: B:50:0x00ac }] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.List] */
    @Override // com.google.mlkit.common.sdkinternal.f
    @androidx.annotation.WorkerThread
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<o8.a> h(@androidx.annotation.NonNull m8.a r21) throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p8.h.h(m8.a):java.util.List");
    }

    public final /* synthetic */ x8 k(y1 y1Var, int i10, i6 i6Var) {
        y6 y6Var = new y6();
        y6Var.c(Boolean.valueOf(this.f52961g));
        w1 w1Var = new w1();
        w1Var.b(Integer.valueOf(i10));
        w1Var.a(y1Var);
        w1Var.c(i6Var);
        y6Var.e(w1Var.d());
        return x8.c(y6Var);
    }

    public final /* synthetic */ x8 l(long j10, zzin zzinVar, int i10, int i11, m8.a aVar) {
        h7 h7Var = new h7();
        r6 r6Var = new r6();
        r6Var.a(Long.valueOf(j10));
        r6Var.b(zzinVar);
        r6Var.c(Boolean.valueOf(f52956i.get()));
        Boolean bool = Boolean.TRUE;
        r6Var.d(bool);
        r6Var.e(bool);
        h7Var.a(r6Var.f());
        h7Var.c(i.a(this.f52958d));
        h7Var.d(Integer.valueOf(i10));
        h7Var.e(Integer.valueOf(i11));
        n8.d dVar = f52957j;
        h7Var.b(i9.a(dVar.c(aVar), dVar.d(aVar)));
        i7 f10 = h7Var.f();
        y6 y6Var = new y6();
        y6Var.c(Boolean.valueOf(this.f52961g));
        y6Var.d(f10);
        return x8.c(y6Var);
    }

    @WorkerThread
    public final synchronized void m(final zzin zzinVar, long j10, final m8.a aVar, final int i10, final int i11) {
        final long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
        this.f52959e.a(new u8(this, elapsedRealtime, zzinVar, i10, i11, aVar) { // from class: p8.f

            /* renamed from: a, reason: collision with root package name */
            public final h f52949a;

            /* renamed from: b, reason: collision with root package name */
            public final long f52950b;

            /* renamed from: c, reason: collision with root package name */
            public final zzin f52951c;

            /* renamed from: d, reason: collision with root package name */
            public final int f52952d;

            /* renamed from: e, reason: collision with root package name */
            public final int f52953e;

            /* renamed from: f, reason: collision with root package name */
            public final m8.a f52954f;

            {
                this.f52949a = this;
                this.f52950b = elapsedRealtime;
                this.f52951c = zzinVar;
                this.f52952d = i10;
                this.f52953e = i11;
                this.f52954f = aVar;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.u8
            public final x8 zza() {
                return this.f52949a.l(this.f52950b, this.f52951c, this.f52952d, this.f52953e, this.f52954f);
            }
        }, zzio.ON_DEVICE_FACE_DETECT);
        x1 x1Var = new x1();
        x1Var.a(zzinVar);
        x1Var.b(Boolean.valueOf(f52956i.get()));
        n8.d dVar = f52957j;
        x1Var.c(i9.a(dVar.c(aVar), dVar.d(aVar)));
        x1Var.e(Integer.valueOf(i10));
        x1Var.f(Integer.valueOf(i11));
        x1Var.d(i.a(this.f52958d));
        this.f52959e.b(x1Var.g(), elapsedRealtime, zzio.AGGREGATED_ON_DEVICE_FACE_DETECTION, new t8(this) { // from class: p8.g

            /* renamed from: a, reason: collision with root package name */
            public final h f52955a;

            {
                this.f52955a = this;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_face.t8
            public final x8 a(Object obj, int i12, i6 i6Var) {
                return this.f52955a.k((y1) obj, i12, i6Var);
            }
        });
    }
}
