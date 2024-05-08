package com.huawei.quickcard.views.image.processor;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.processor.WidthStyle;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.YogaUtils;
import com.huawei.quickcard.views.image.ImageUtils;
import com.huawei.quickcard.views.image.view.IImageHost;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class WidthProcessor extends WidthStyle<ImageView> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34540a = "WidthProcessor";

    @Override // com.huawei.quickcard.framework.processor.WidthStyle, com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull ImageView imageView, String str, QuickCardValue quickCardValue) {
        IImageHost castViewToImageHost;
        super.setProperty((WidthProcessor) imageView, str, quickCardValue);
        YogaNode yogaNode = YogaUtils.getYogaNode(imageView);
        if (yogaNode == null) {
            return;
        }
        YogaValue q10 = yogaNode.q();
        if (q10.f19202b != YogaUnit.POINT || (castViewToImageHost = ImageUtils.castViewToImageHost(imageView)) == null) {
            return;
        }
        int i10 = (int) q10.f19201a;
        castViewToImageHost.setImageWidth(i10);
        CardLogUtils.d(f34540a, "define image width :: " + i10);
    }
}
