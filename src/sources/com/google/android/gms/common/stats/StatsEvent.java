package com.google.android.gms.common.stats;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public String toString() {
        long zza = zza();
        int zzb = zzb();
        long zzc = zzc();
        String zzd = zzd();
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzd).length() + 53);
        sb2.append(zza);
        sb2.append("\t");
        sb2.append(zzb);
        sb2.append("\t");
        sb2.append(zzc);
        sb2.append(zzd);
        return sb2.toString();
    }

    @RecentlyNonNull
    public abstract long zza();

    @RecentlyNonNull
    public abstract int zzb();

    @RecentlyNonNull
    public abstract long zzc();

    @RecentlyNonNull
    public abstract String zzd();
}
