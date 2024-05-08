package com.huawei.quickcard.framework.processor;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ViewUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class OutLineProcessor<T extends View> implements PropertyProcessor<T> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f33899a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f33900b;

        public a(View view, float f10) {
            this.f33899a = view;
            this.f33900b = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, this.f33899a.getWidth(), this.f33899a.getHeight(), this.f33900b);
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean isImmediate() {
        return b.a(this);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return b.b(this);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        return ParserHelper.parseToSP(obj, Float.NEGATIVE_INFINITY);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            t2.setClipToOutline(false);
            return;
        }
        float f10 = Float.NEGATIVE_INFINITY;
        if (quickCardValue.isDp() && quickCardValue.getDp() > 0.0f) {
            f10 = ViewUtils.dip2FloatPx(t2, quickCardValue.getDp());
        }
        if (quickCardValue.isSp() && quickCardValue.getSp() > 0.0f) {
            f10 = ViewUtils.sp2FloatPx(t2, quickCardValue.getSp());
        }
        if (f10 <= 0.0f) {
            t2.setClipToOutline(false);
        } else {
            t2.setClipToOutline(true);
            t2.setOutlineProvider(new a(t2, f10));
        }
    }
}
