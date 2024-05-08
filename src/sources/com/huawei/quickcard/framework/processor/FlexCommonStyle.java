package com.huawei.quickcard.framework.processor;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.utils.YogaUtils;
import com.huawei.quickcard.views.div.DivLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FlexCommonStyle<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33886a = "FlexCommonStyle";

    /* renamed from: b, reason: collision with root package name */
    private static final Float f33887b = Float.valueOf(0.0f);

    /* renamed from: c, reason: collision with root package name */
    private static final Float f33888c = Float.valueOf(-1.0f);

    /* renamed from: d, reason: collision with root package name */
    private static final Float f33889d = Float.valueOf(1.0f);

    private float a(T t2, QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            return f33888c.floatValue();
        }
        if (quickCardValue.isDp()) {
            if (quickCardValue.getDp() < 0.0f) {
                return f33888c.floatValue();
            }
            return ViewUtils.dip2IntPx(t2, r3);
        }
        return f33888c.floatValue();
    }

    private boolean b(T t2) {
        ViewParent parent = t2.getParent();
        if (!(parent instanceof DivLayout)) {
            return false;
        }
        DivLayout divLayout = (DivLayout) parent;
        YogaNode yogaNode = divLayout.getYogaNode();
        if (yogaNode.h() == YogaFlexDirection.ROW && yogaNode.i() > 0.0f && yogaNode.i() > 0.0f) {
            return false;
        }
        if (yogaNode.h() == YogaFlexDirection.COLUMN && yogaNode.i() > 0.0f && yogaNode.i() > 0.0f) {
            return false;
        }
        ViewParent parent2 = divLayout.getParent();
        if (!(parent2 instanceof DivLayout)) {
            return true;
        }
        YogaNode yogaNode2 = ((DivLayout) parent2).getYogaNode();
        return yogaNode.h() == yogaNode2.h() || yogaNode2.d() != YogaAlign.STRETCH;
    }

    private void c(T t2, QuickCardValue quickCardValue) {
        float a10 = a(t2, quickCardValue);
        if (!b((FlexCommonStyle<T>) t2)) {
            a10 = Float.NaN;
        }
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.B(a10);
        }
    }

    private void d(T t2, QuickCardValue quickCardValue) {
        float a10 = a(quickCardValue);
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.D(a10);
        }
    }

    private void e(T t2, QuickCardValue quickCardValue) {
        float b4 = b(quickCardValue);
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.E(b4);
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
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1783760955:
                if (str.equals(Attributes.Style.FLEX_BASIS)) {
                    c4 = 0;
                    break;
                }
                break;
            case 3145721:
                if (str.equals("flex")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1031115618:
                if (str.equals(Attributes.Style.FLEX_SHRINK)) {
                    c4 = 2;
                    break;
                }
                break;
            case 1743739820:
                if (str.equals(Attributes.Style.FLEX_GROW)) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return ParserHelper.parseToDP(obj, f33888c.floatValue());
            case 1:
            case 3:
                return ParserHelper.parseToNumber(obj, f33887b);
            case 2:
                return ParserHelper.parseToNumber(obj, f33889d);
            default:
                return QuickCardValue.EMPTY;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (!a((FlexCommonStyle<T>) t2)) {
            CardLogUtils.i(f33886a, "current view parent neither div nor list-item");
            return;
        }
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1783760955:
                if (str.equals(Attributes.Style.FLEX_BASIS)) {
                    c4 = 0;
                    break;
                }
                break;
            case 3145721:
                if (str.equals("flex")) {
                    c4 = 1;
                    break;
                }
                break;
            case 1031115618:
                if (str.equals(Attributes.Style.FLEX_SHRINK)) {
                    c4 = 2;
                    break;
                }
                break;
            case 1743739820:
                if (str.equals(Attributes.Style.FLEX_GROW)) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                c(t2, quickCardValue);
                return;
            case 1:
                b(t2, quickCardValue);
                return;
            case 2:
                e(t2, quickCardValue);
                return;
            case 3:
                d(t2, quickCardValue);
                return;
            default:
                return;
        }
    }

    private float c(QuickCardValue quickCardValue) {
        if (!QuickCardValueUtil.isInvalidValue(quickCardValue) && quickCardValue.isNumber()) {
            return quickCardValue.getNumber().floatValue();
        }
        return 0.0f;
    }

    private float a(QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            return f33887b.floatValue();
        }
        if (quickCardValue.isNumber()) {
            return quickCardValue.getNumber().floatValue();
        }
        return f33887b.floatValue();
    }

    private boolean a(T t2) {
        return t2.getParent() instanceof DivLayout;
    }

    private float b(QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            return f33889d.floatValue();
        }
        if (quickCardValue.isNumber()) {
            return quickCardValue.getNumber().floatValue();
        }
        return f33889d.floatValue();
    }

    private void b(T t2, QuickCardValue quickCardValue) {
        float c4 = c(quickCardValue);
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.D(c4);
            yogaNode.E(f33889d.floatValue());
            if (b((FlexCommonStyle<T>) t2)) {
                yogaNode.B(f33887b.floatValue());
            } else {
                yogaNode.B(Float.NaN);
            }
        }
    }
}
