package com.huawei.quickcard.views.image.processor;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.views.image.extension.FitMode;
import com.huawei.quickcard.views.image.view.IImageHost;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ScaleStyle extends BaseProcessor {
    private FitMode a(Object obj) {
        return (FitMode) ParserHelper.object2Enum(FitMode.class, obj, FitMode.COVER);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        return new QuickCardValue.ObjectValue(a(obj));
    }

    @Override // com.huawei.quickcard.views.image.processor.BaseProcessor
    public void setProperty(@NonNull ImageView imageView, @NonNull IImageHost iImageHost, String str, QuickCardValue quickCardValue) {
        Object object = quickCardValue.getObject();
        if (object instanceof FitMode) {
            FitMode fitMode = (FitMode) object;
            if ("objectFit".equals(str)) {
                iImageHost.setFitMode(fitMode);
            }
        }
    }
}
