package com.huawei.quickcard.video.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.processor.BorderProcessor;
import com.huawei.quickcard.video.view.IVideoHost;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PosterRadiusStyle<T extends View> extends BorderProcessor<T> {
    @Override // com.huawei.quickcard.framework.processor.BorderProcessor
    public void traverseBorder(@NonNull T t2, @NonNull Border border) {
        if (t2 instanceof IVideoHost) {
            ((IVideoHost) t2).setBorderRadius(border.getBorderRadius());
        }
    }
}
