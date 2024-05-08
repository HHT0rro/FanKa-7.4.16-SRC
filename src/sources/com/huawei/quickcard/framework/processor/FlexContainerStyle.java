package com.huawei.quickcard.framework.processor;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaWrap;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.YogaUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FlexContainerStyle<T extends ViewGroup> implements PropertyProcessor<T> {
    private void a(T t2, QuickCardValue quickCardValue) {
        YogaAlign a10 = a(quickCardValue, YogaAlign.FLEX_START);
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.t(a10);
        }
    }

    private void b(T t2, QuickCardValue quickCardValue) {
        YogaAlign a10 = a(quickCardValue, YogaAlign.STRETCH);
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.u(a10);
        }
    }

    private void c(T t2, QuickCardValue quickCardValue) {
        YogaAlign a10 = a(quickCardValue, YogaAlign.AUTO);
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.v(a10);
        }
    }

    private void d(T t2, QuickCardValue quickCardValue) {
        YogaFlexDirection a10 = a(quickCardValue);
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.C(a10);
        }
    }

    private void e(T t2, QuickCardValue quickCardValue) {
        YogaWrap b4 = b(quickCardValue);
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.Z(b4);
        }
    }

    private void f(T t2, QuickCardValue quickCardValue) {
        YogaJustify c4 = c(quickCardValue);
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.I(c4);
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public boolean isImmediate() {
        return true;
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return b.b(this);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        return ParserHelper.parseToString(obj, "");
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1063257157:
                if (str.equals(Attributes.Style.ALIGN_ITEMS)) {
                    c4 = 0;
                    break;
                }
                break;
            case -975171706:
                if (str.equals("flexDirection")) {
                    c4 = 1;
                    break;
                }
                break;
            case -752601676:
                if (str.equals(Attributes.Style.ALIGN_CONTENT)) {
                    c4 = 2;
                    break;
                }
                break;
            case 1744216035:
                if (str.equals(Attributes.Style.FLEX_WRAP)) {
                    c4 = 3;
                    break;
                }
                break;
            case 1767100401:
                if (str.equals(Attributes.Style.ALIGN_SELF)) {
                    c4 = 4;
                    break;
                }
                break;
            case 1860657097:
                if (str.equals(Attributes.Style.JUSTIFY_CONTENT)) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                b(t2, quickCardValue);
                return;
            case 1:
                d(t2, quickCardValue);
                return;
            case 2:
                a((FlexContainerStyle<T>) t2, quickCardValue);
                return;
            case 3:
                e(t2, quickCardValue);
                return;
            case 4:
                c(t2, quickCardValue);
                return;
            case 5:
                f(t2, quickCardValue);
                return;
            default:
                return;
        }
    }

    private YogaFlexDirection a(QuickCardValue quickCardValue) {
        String string = quickCardValue.getString();
        if (TextUtils.isEmpty(string)) {
            return YogaFlexDirection.ROW;
        }
        if ("column".equals(string)) {
            return YogaFlexDirection.COLUMN;
        }
        if ("column-reverse".equals(string)) {
            return YogaFlexDirection.COLUMN_REVERSE;
        }
        if ("row-reverse".equals(string)) {
            return YogaFlexDirection.ROW_REVERSE;
        }
        return YogaFlexDirection.ROW;
    }

    private YogaWrap b(QuickCardValue quickCardValue) {
        String string = quickCardValue.getString();
        if (TextUtils.isEmpty(string)) {
            return YogaWrap.NO_WRAP;
        }
        if ("wrap".equals(string)) {
            return YogaWrap.WRAP;
        }
        if ("wrap-reverse".equals(string)) {
            return YogaWrap.WRAP_REVERSE;
        }
        return YogaWrap.NO_WRAP;
    }

    private YogaJustify c(QuickCardValue quickCardValue) {
        String string = quickCardValue.getString();
        if (TextUtils.isEmpty(string)) {
            return YogaJustify.FLEX_START;
        }
        if ("flex-end".equals(string)) {
            return YogaJustify.FLEX_END;
        }
        if (CSSAlignValue.AlignKey.CENTER.equals(string)) {
            return YogaJustify.CENTER;
        }
        if ("space-between".equals(string)) {
            return YogaJustify.SPACE_BETWEEN;
        }
        if ("space-around".equals(string)) {
            return YogaJustify.SPACE_AROUND;
        }
        return YogaJustify.FLEX_START;
    }

    private YogaAlign a(QuickCardValue quickCardValue, YogaAlign yogaAlign) {
        String string = quickCardValue.getString();
        if (TextUtils.isEmpty(string)) {
            return yogaAlign;
        }
        string.hashCode();
        char c4 = 65535;
        switch (string.hashCode()) {
            case -1881872635:
                if (string.equals("stretch")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1364013995:
                if (string.equals(CSSAlignValue.AlignKey.CENTER)) {
                    c4 = 1;
                    break;
                }
                break;
            case -46581362:
                if (string.equals("flex-start")) {
                    c4 = 2;
                    break;
                }
                break;
            case 3005871:
                if (string.equals(Attributes.LayoutDirection.AUTO)) {
                    c4 = 3;
                    break;
                }
                break;
            case 441309761:
                if (string.equals("space-between")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1742952711:
                if (string.equals("flex-end")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1937124468:
                if (string.equals("space-around")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return YogaAlign.STRETCH;
            case 1:
                return YogaAlign.CENTER;
            case 2:
                return YogaAlign.FLEX_START;
            case 3:
                return YogaAlign.AUTO;
            case 4:
                return YogaAlign.SPACE_BETWEEN;
            case 5:
                return YogaAlign.FLEX_END;
            case 6:
                return YogaAlign.SPACE_AROUND;
            default:
                return yogaAlign;
        }
    }
}
