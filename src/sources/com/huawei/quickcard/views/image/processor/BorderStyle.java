package com.huawei.quickcard.views.image.processor;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.processor.BorderProcessor;
import com.huawei.quickcard.views.image.ImageUtils;
import com.huawei.quickcard.views.image.view.IImageHost;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BorderStyle extends BorderProcessor<ImageView> {
    @Override // com.huawei.quickcard.framework.processor.BorderProcessor
    public void traverseBorder(@NonNull ImageView imageView, @NonNull Border border) {
        IImageHost castViewToImageHost = ImageUtils.castViewToImageHost(imageView);
        if (castViewToImageHost != null) {
            castViewToImageHost.setBorder(border);
        }
    }
}
