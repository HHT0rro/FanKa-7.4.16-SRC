package com.huawei.quickcard.views.image.processor;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.views.image.ImageUtils;
import com.huawei.quickcard.views.image.view.IImageHost;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class BaseProcessor implements PropertyProcessor<ImageView> {
    public IImageHost castViewToImageHost(ImageView imageView) {
        return ImageUtils.castViewToImageHost(imageView);
    }

    public boolean isBase64Img(@NonNull String str) {
        return ImageUtils.isBase64Img(str);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean isImmediate() {
        return b.a(this);
    }

    public boolean isNetWorkImg(@NonNull String str) {
        return str.startsWith("http://") || str.startsWith("https://");
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return b.b(this);
    }

    public abstract void setProperty(@NonNull ImageView imageView, @NonNull IImageHost iImageHost, String str, QuickCardValue quickCardValue);

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull ImageView imageView, String str, QuickCardValue quickCardValue) {
        IImageHost castViewToImageHost = castViewToImageHost(imageView);
        if (castViewToImageHost == null) {
            return;
        }
        setProperty(imageView, castViewToImageHost, str, quickCardValue);
    }
}
