package com.huawei.quickcard.image;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.views.image.extension.IAppResProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b implements IAppResProvider {
    @Override // com.huawei.quickcard.views.image.extension.IAppResProvider
    @Nullable
    public String getAssetsImagePath(@NonNull Context context, @NonNull String str) {
        return "file:///android_asset/" + str;
    }

    @Override // com.huawei.quickcard.views.image.extension.IAppResProvider
    public int getResDrawableId(@NonNull Context context, @NonNull String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    @Override // com.huawei.quickcard.views.image.extension.IAppResProvider
    public int getResMipMapId(@NonNull Context context, @NonNull String str) {
        return context.getResources().getIdentifier(str, "mipmap", context.getPackageName());
    }

    @Override // com.huawei.quickcard.views.image.extension.IAppResProvider
    public int getResRawId(@NonNull Context context, @NonNull String str) {
        return context.getResources().getIdentifier(str, "raw", context.getPackageName());
    }
}
