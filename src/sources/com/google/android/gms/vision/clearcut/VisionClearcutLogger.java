package com.google.android.gms.vision.clearcut;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.internal.vision.j2;
import com.google.android.gms.internal.vision.l4;
import com.google.android.gms.internal.vision.v1;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class VisionClearcutLogger {
    private final a zza;
    private boolean zzb = true;

    public VisionClearcutLogger(@RecentlyNonNull Context context) {
        this.zza = new a(context, "VISION", null);
    }

    public final void zza(int i10, j2 j2Var) {
        byte[] d10 = j2Var.d();
        if (i10 < 0 || i10 > 3) {
            q7.a.c("Illegal event code: %d", Integer.valueOf(i10));
            return;
        }
        try {
            if (this.zzb) {
                this.zza.b(d10).b(i10).a();
                return;
            }
            j2.a x10 = j2.x();
            try {
                x10.d(d10, 0, d10.length, l4.e());
                q7.a.a("Would have logged:\n%s", x10.toString());
            } catch (Exception e2) {
                q7.a.b(e2, "Parsing error", new Object[0]);
            }
        } catch (Exception e10) {
            v1.b(e10);
            q7.a.b(e10, "Failed to log", new Object[0]);
        }
    }
}
