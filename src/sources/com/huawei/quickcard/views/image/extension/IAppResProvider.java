package com.huawei.quickcard.views.image.extension;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IAppResProvider {
    @Nullable
    String getAssetsImagePath(@NonNull Context context, @NonNull String str);

    int getResDrawableId(@NonNull Context context, @NonNull String str);

    int getResMipMapId(@NonNull Context context, @NonNull String str);

    int getResRawId(@NonNull Context context, @NonNull String str);
}
