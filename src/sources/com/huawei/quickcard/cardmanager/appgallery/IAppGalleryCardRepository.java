package com.huawei.quickcard.cardmanager.appgallery;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IAppGalleryCardRepository {
    @Nullable
    String getCardType(@NonNull String str);

    void setPresetCardStreamProvider(Context context, PresetCardStreamProvider presetCardStreamProvider);

    int storeCard(@NonNull String str, @NonNull String str2);
}
