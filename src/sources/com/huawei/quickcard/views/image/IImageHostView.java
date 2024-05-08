package com.huawei.quickcard.views.image;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.unit.LengthValue;
import com.huawei.quickcard.views.image.extension.FitMode;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IImageHostView {
    void enableCache(boolean z10);

    Pair<String, Drawable> getPlaceHolder(String str);

    void loadImage();

    void setBorder(Border border);

    void setClipX(@Nullable LengthValue lengthValue);

    void setClipY(@Nullable LengthValue lengthValue);

    void setFitMode(@NonNull FitMode fitMode);

    void setImageHeight(int i10);

    void setImageWidth(int i10);

    void setNetworkEnhance(boolean z10);

    void setPlaceHolder(String str, @Nullable Drawable drawable);

    void setSrc(String str);
}
