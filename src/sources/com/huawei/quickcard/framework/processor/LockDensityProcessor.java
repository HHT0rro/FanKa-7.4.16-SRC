package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.div.CardRootLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class LockDensityProcessor<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33892a = "LockDensityProcessor";

    /* renamed from: b, reason: collision with root package name */
    private static final int f33893b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final String f33894c = "auto";

    /* renamed from: d, reason: collision with root package name */
    private static final String f33895d = "none";

    private void a(@NonNull T t2, QuickCardValue quickCardValue) {
        if (!(t2 instanceof CardRootLayout)) {
            CardLogUtils.print2Ide(5, "style", "locked-density should be attached on root div");
            return;
        }
        CardContext cardContext = ViewUtils.getCardContext(t2);
        if (cardContext == null) {
            return;
        }
        if (quickCardValue.isString()) {
            String string = quickCardValue.getString();
            if ("auto".equals(string)) {
                cardContext.lockDensity(true, 0.0f);
                return;
            }
            try {
                cardContext.lockDensity(true, Float.parseFloat(string));
                return;
            } catch (NumberFormatException unused) {
                cardContext.lockDensity(false, 0.0f);
                return;
            }
        }
        if (quickCardValue.isNumber()) {
            cardContext.lockDensity(true, quickCardValue.getNumber().floatValue());
        } else {
            cardContext.lockDensity(false, 0.0f);
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
        return QuickCardValue.wrap(obj);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (Attributes.Style.LOCKED_DENSITY.equals(str)) {
            a(t2, quickCardValue);
        }
    }
}
