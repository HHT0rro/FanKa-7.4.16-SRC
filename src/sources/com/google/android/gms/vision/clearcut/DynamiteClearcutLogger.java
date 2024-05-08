package com.google.android.gms.vision.clearcut;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.vision.b4;
import com.google.android.gms.internal.vision.h1;
import com.google.android.gms.internal.vision.j2;
import java.util.concurrent.ExecutorService;
import q7.a;
import r7.b;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DynamiteClearcutLogger {
    private static final ExecutorService zza = h1.a().i(2, b4.f25434a);
    private b zzb = new b(0.03333333333333333d);
    private VisionClearcutLogger zzc;

    public DynamiteClearcutLogger(@RecentlyNonNull Context context) {
        this.zzc = new VisionClearcutLogger(context);
    }

    public final void zza(int i10, j2 j2Var) {
        if (i10 == 3 && !this.zzb.a()) {
            a.d("Skipping image analysis log due to rate limiting", new Object[0]);
        } else {
            zza.execute(new r7.a(this, i10, j2Var));
        }
    }
}
