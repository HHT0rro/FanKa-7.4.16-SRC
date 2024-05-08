package p8;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.mlkit_vision_face.k6;
import com.google.android.gms.internal.mlkit_vision_face.m6;
import com.google.android.gms.internal.mlkit_vision_face.zzhx;
import com.google.android.gms.internal.mlkit_vision_face.zzhy;
import com.google.android.gms.internal.mlkit_vision_face.zzhz;
import com.google.android.gms.internal.mlkit_vision_face.zzia;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final AtomicReference<String> f52963a = new AtomicReference<>();

    public static m6 a(o8.d dVar) {
        zzhz zzhzVar;
        zzhx zzhxVar;
        zzia zziaVar;
        zzhy zzhyVar;
        k6 k6Var = new k6();
        int a10 = dVar.a();
        if (a10 == 1) {
            zzhzVar = zzhz.NO_LANDMARKS;
        } else if (a10 != 2) {
            zzhzVar = zzhz.UNKNOWN_LANDMARKS;
        } else {
            zzhzVar = zzhz.ALL_LANDMARKS;
        }
        k6Var.a(zzhzVar);
        int c4 = dVar.c();
        if (c4 == 1) {
            zzhxVar = zzhx.NO_CLASSIFICATIONS;
        } else if (c4 != 2) {
            zzhxVar = zzhx.UNKNOWN_CLASSIFICATIONS;
        } else {
            zzhxVar = zzhx.ALL_CLASSIFICATIONS;
        }
        k6Var.b(zzhxVar);
        int d10 = dVar.d();
        if (d10 == 1) {
            zziaVar = zzia.FAST;
        } else if (d10 != 2) {
            zziaVar = zzia.UNKNOWN_PERFORMANCE;
        } else {
            zziaVar = zzia.ACCURATE;
        }
        k6Var.c(zziaVar);
        int b4 = dVar.b();
        if (b4 == 1) {
            zzhyVar = zzhy.NO_CONTOURS;
        } else if (b4 != 2) {
            zzhyVar = zzhy.UNKNOWN_CONTOURS;
        } else {
            zzhyVar = zzhy.ALL_CONTOURS;
        }
        k6Var.d(zzhyVar);
        k6Var.e(Boolean.valueOf(dVar.e()));
        k6Var.f(Float.valueOf(dVar.f()));
        return k6Var.g();
    }

    public static String b() {
        AtomicReference<String> atomicReference = f52963a;
        if (atomicReference.get() != null) {
            return atomicReference.get();
        }
        String str = true != a.b(com.google.mlkit.common.sdkinternal.i.c().b()) ? "play-services-mlkit-face-detection" : "face-detection";
        atomicReference.set(str);
        return str;
    }
}
