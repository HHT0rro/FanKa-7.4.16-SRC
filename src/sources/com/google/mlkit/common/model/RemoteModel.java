package com.google.mlkit.common.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.gms.common.internal.g;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.internal.mlkit_common.r0;
import com.google.android.gms.internal.mlkit_common.s0;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class RemoteModel {

    @Nullable
    private final String zzb;

    @Nullable
    private final BaseModel zzc;
    private final ModelType zzd;
    private String zzf;
    private static final Map<BaseModel, String> zze = new EnumMap(BaseModel.class);

    @RecentlyNonNull
    @VisibleForTesting
    public static final Map<BaseModel, String> zza = new EnumMap(BaseModel.class);

    public RemoteModel(@Nullable String str, @Nullable BaseModel baseModel, @RecentlyNonNull ModelType modelType) {
        h.b(TextUtils.isEmpty(str) == (baseModel != null), "One of cloud model name and base model cannot be empty");
        this.zzb = str;
        this.zzc = baseModel;
        this.zzd = modelType;
    }

    public boolean baseModelHashMatches(@RecentlyNonNull String str) {
        BaseModel baseModel = this.zzc;
        if (baseModel == null) {
            return false;
        }
        return str.equals(zze.get(baseModel));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoteModel)) {
            return false;
        }
        RemoteModel remoteModel = (RemoteModel) obj;
        return g.a(this.zzb, remoteModel.zzb) && g.a(this.zzc, remoteModel.zzc) && g.a(this.zzd, remoteModel.zzd);
    }

    @RecentlyNonNull
    public String getModelHash() {
        return this.zzf;
    }

    @RecentlyNullable
    public String getModelName() {
        return this.zzb;
    }

    @RecentlyNonNull
    public String getModelNameForBackend() {
        String str = this.zzb;
        return str != null ? str : zza.get(this.zzc);
    }

    @RecentlyNonNull
    public ModelType getModelType() {
        return this.zzd;
    }

    @RecentlyNonNull
    public String getUniqueModelNameForPersist() {
        String str = this.zzb;
        if (str != null) {
            return str;
        }
        String valueOf = String.valueOf(zza.get(this.zzc));
        return valueOf.length() != 0 ? "COM.GOOGLE.BASE_".concat(valueOf) : new String("COM.GOOGLE.BASE_");
    }

    public int hashCode() {
        return g.b(this.zzb, this.zzc, this.zzd);
    }

    public boolean isBaseModel() {
        return this.zzc != null;
    }

    public void setModelHash(@RecentlyNonNull String str) {
        this.zzf = str;
    }

    @RecentlyNonNull
    public String toString() {
        r0 b4 = s0.b("RemoteModel");
        b4.a("modelName", this.zzb);
        b4.a("baseModel", this.zzc);
        b4.a(TTDownloadField.TT_MODEL_TYPE, this.zzd);
        return b4.toString();
    }
}
