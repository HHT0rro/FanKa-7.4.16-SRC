package com.huawei.quickcard.action;

import androidx.annotation.Nullable;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.QuickCardView;
import com.huawei.quickcard.extension.format.FormatNumberUtils;
import com.huawei.quickcard.extension.format.IQuickNumberFormat;
import com.huawei.quickcard.k0;
import com.huawei.quickcard.utils.MediaThemeUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class JsFunctionAction extends AbsQuickCardAction {
    public Object getElementById(String str) {
        CardContext cardContext = getCardContext();
        if (cardContext != null) {
            return k0.a(str, cardContext.getRoot());
        }
        return null;
    }

    public long getTime() {
        return System.currentTimeMillis();
    }

    public IQuickNumberFormat numberFormat(Object obj) {
        return FormatNumberUtils.createNumberFormatter(obj);
    }

    public void setMediaTheme(Object obj, Object obj2) {
        MediaThemeUtils.setMediaTheme(getCardContext(), obj, obj2);
    }

    public void setMediaTheme(QuickCardView quickCardView, Object obj, Object obj2) {
        MediaThemeUtils.setMediaTheme(quickCardView == null ? getCardContext() : quickCardView.getCardContext(), obj, obj2);
    }

    public Object getElementById(QuickCardView quickCardView, @Nullable String str) {
        return quickCardView != null ? k0.a(str, quickCardView) : getElementById(str);
    }
}
