package com.google.mlkit.common.model;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.internal.mlkit_common.r0;
import com.google.android.gms.internal.mlkit_common.s0;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LocalModel {

    @Nullable
    private final String zza;

    @Nullable
    private final String zzb;

    @Nullable
    private final Uri zzc;
    private final boolean zzd;

    public /* synthetic */ LocalModel(String str, String str2, Uri uri, boolean z10, zzc zzcVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = uri;
        this.zzd = z10;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalModel)) {
            return false;
        }
        LocalModel localModel = (LocalModel) obj;
        return g.a(this.zza, localModel.zza) && g.a(this.zzb, localModel.zzb) && g.a(this.zzc, localModel.zzc) && this.zzd == localModel.zzd;
    }

    @RecentlyNullable
    public String getAbsoluteFilePath() {
        return this.zza;
    }

    @RecentlyNullable
    public String getAssetFilePath() {
        return this.zzb;
    }

    @RecentlyNullable
    public Uri getUri() {
        return this.zzc;
    }

    public int hashCode() {
        return g.b(this.zza, this.zzb, this.zzc, Boolean.valueOf(this.zzd));
    }

    public boolean isManifestFile() {
        return this.zzd;
    }

    @RecentlyNonNull
    public String toString() {
        r0 a10 = s0.a(this);
        a10.a("absoluteFilePath", this.zza);
        a10.a("assetFilePath", this.zzb);
        a10.a("uri", this.zzc);
        a10.b("isManifestFile", this.zzd);
        return a10.toString();
    }
}
