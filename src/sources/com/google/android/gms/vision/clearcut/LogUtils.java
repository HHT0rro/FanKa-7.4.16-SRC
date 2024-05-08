package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.vision.e2;
import com.google.android.gms.internal.vision.i2;
import com.google.android.gms.internal.vision.j2;
import com.google.android.gms.internal.vision.x4;
import com.google.android.gms.internal.vision.z1;
import com.google.android.gms.internal.vision.zzfi$zzf;
import com.google.android.gms.internal.vision.zzfi$zzj;
import com.google.android.gms.internal.vision.zzs;
import d7.b;
import java.util.ArrayList;
import java.util.List;
import q7.a;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class LogUtils {
    public static j2 zza(long j10, int i10, @Nullable String str, String str2, @Nullable List<i2> list, zzs zzsVar) {
        e2.a x10 = e2.x();
        zzfi$zzf.a o10 = zzfi$zzf.x().n(str2).l(j10).o(i10);
        o10.m(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((zzfi$zzf) ((x4) o10.zzf()));
        return (j2) ((x4) j2.x().l((e2) ((x4) x10.m(arrayList).l((zzfi$zzj) ((x4) zzfi$zzj.x().m(zzsVar.f25779c).l(zzsVar.f25778b).n(zzsVar.f25780d).o(zzsVar.f25781e).zzf())).zzf())).zzf());
    }

    @Nullable
    private static String zzb(Context context) {
        try {
            return b.a(context).d(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            a.b(e2, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }

    public static z1 zza(Context context) {
        z1.a l10 = z1.x().l(context.getPackageName());
        String zzb = zzb(context);
        if (zzb != null) {
            l10.m(zzb);
        }
        return (z1) ((x4) l10.zzf());
    }
}
