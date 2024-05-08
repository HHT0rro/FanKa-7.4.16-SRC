package com.google.mlkit.common.model;

import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CustomRemoteModel extends RemoteModel {
    private final RemoteModelSource zzb;

    public /* synthetic */ CustomRemoteModel(RemoteModelSource remoteModelSource, zza zzaVar) {
        super(TextUtils.isEmpty(remoteModelSource.a()) ? "no_model_name" : remoteModelSource.a(), null, ModelType.CUSTOM);
        this.zzb = remoteModelSource;
    }

    @RecentlyNonNull
    public RemoteModelSource getRemoteModelSource() {
        return this.zzb;
    }
}
