package com.google.android.gms.common.stats;

import a7.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import java.util.List;
import w6.a;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class WakeLockEvent extends StatsEvent {

    @RecentlyNonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new b();
    private final int zza;
    private final long zzb;
    private int zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    private final List<String> zzh;
    private final String zzi;
    private final long zzj;
    private int zzk;
    private final String zzl;
    private final float zzm;
    private final long zzn;
    private final boolean zzo;
    private long zzp = -1;

    public WakeLockEvent(int i10, long j10, int i11, String str, int i12, List<String> list, String str2, long j11, int i13, String str3, String str4, float f10, long j12, String str5, boolean z10) {
        this.zza = i10;
        this.zzb = j10;
        this.zzc = i11;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i12;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j11;
        this.zzk = i13;
        this.zzl = str4;
        this.zzm = f10;
        this.zzn = j12;
        this.zzo = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 1, this.zza);
        a.l(parcel, 2, zza());
        a.o(parcel, 4, this.zzd, false);
        a.j(parcel, 5, this.zzg);
        a.q(parcel, 6, this.zzh, false);
        a.l(parcel, 8, this.zzj);
        a.o(parcel, 10, this.zze, false);
        a.j(parcel, 11, zzb());
        a.o(parcel, 12, this.zzi, false);
        a.o(parcel, 13, this.zzl, false);
        a.j(parcel, 14, this.zzk);
        a.h(parcel, 15, this.zzm);
        a.l(parcel, 16, this.zzn);
        a.o(parcel, 17, this.zzf, false);
        a.c(parcel, 18, this.zzo);
        a.b(parcel, a10);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @RecentlyNonNull
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @RecentlyNonNull
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @RecentlyNonNull
    public final long zzc() {
        return this.zzp;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @RecentlyNonNull
    public final String zzd() {
        List<String> list = this.zzh;
        String str = this.zzd;
        int i10 = this.zzg;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i11 = this.zzk;
        String str2 = this.zze;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.zzl;
        if (str3 == null) {
            str3 = "";
        }
        float f10 = this.zzm;
        String str4 = this.zzf;
        String str5 = str4 != null ? str4 : "";
        boolean z10 = this.zzo;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str5).length());
        sb2.append("\t");
        sb2.append(str);
        sb2.append("\t");
        sb2.append(i10);
        sb2.append("\t");
        sb2.append(join);
        sb2.append("\t");
        sb2.append(i11);
        sb2.append("\t");
        sb2.append(str2);
        sb2.append("\t");
        sb2.append(str3);
        sb2.append("\t");
        sb2.append(f10);
        sb2.append("\t");
        sb2.append(str5);
        sb2.append("\t");
        sb2.append(z10);
        return sb2.toString();
    }
}
