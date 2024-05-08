package com.huawei.quickcard.framework.processor;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.QuickJSViewUtils;
import com.huawei.quickcard.utils.SystemUtils;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.utils.YogaUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HeightStyle<T extends View> implements PropertyProcessor<T> {
    private void a(@NonNull T t2, YogaNode yogaNode, QuickCardValue quickCardValue) {
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(t2);
        if (obtainPropertyCacheBeanFromView.isAnimationView()) {
            obtainPropertyCacheBeanFromView.getQAnimatorSet(t2).b().put("height", quickCardValue);
        }
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            obtainPropertyCacheBeanFromView.setViewHeightPercent(0.0f);
            obtainPropertyCacheBeanFromView.setHeightDefined(false);
            yogaNode.G();
        } else if (quickCardValue.isPercent()) {
            obtainPropertyCacheBeanFromView.setViewHeightPercent(quickCardValue.getPercent());
            obtainPropertyCacheBeanFromView.setHeightDefined(true);
            yogaNode.H(quickCardValue.getPercent() * 100.0f);
        } else if (quickCardValue.isDp()) {
            a(obtainPropertyCacheBeanFromView, ViewUtils.dip2IntPx(t2, quickCardValue.getDp()), t2, yogaNode);
        } else if (quickCardValue.isPx()) {
            a(obtainPropertyCacheBeanFromView, QuickJSViewUtils.dipSize2IntPx(t2, quickCardValue.getPx()), t2, yogaNode);
        } else {
            yogaNode.G();
        }
    }

    private void b(@NonNull T t2, YogaNode yogaNode, QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            yogaNode.K(SystemUtils.getScreenHeight(t2.getContext()));
            return;
        }
        if (quickCardValue.isPercent()) {
            yogaNode.L(quickCardValue.getPercent() * 100.0f);
        } else if (quickCardValue.isDp()) {
            yogaNode.K(ViewUtils.dip2IntPx(t2, quickCardValue.getDp()));
        } else if (quickCardValue.isPx()) {
            yogaNode.K(QuickJSViewUtils.dipSize2IntPx(t2, quickCardValue.getPx()));
        }
    }

    private void c(@NonNull T t2, YogaNode yogaNode, QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            yogaNode.P(0.0f);
            return;
        }
        if (quickCardValue.isPercent()) {
            yogaNode.Q(quickCardValue.getPercent() * 100.0f);
        } else if (quickCardValue.isDp()) {
            yogaNode.P(ViewUtils.dip2IntPx(t2, quickCardValue.getDp()));
        } else if (quickCardValue.isPx()) {
            yogaNode.P(QuickJSViewUtils.dipSize2IntPx(t2, quickCardValue.getPx()));
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
        return ParserHelper.parseToSize(obj);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode == null) {
            return;
        }
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1221029593:
                if (str.equals("height")) {
                    c4 = 0;
                    break;
                }
                break;
            case -906066005:
                if (str.equals("maxHeight")) {
                    c4 = 1;
                    break;
                }
                break;
            case -133587431:
                if (str.equals(Attributes.Style.MIN_HEIGHT)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                a(t2, yogaNode, quickCardValue);
                return;
            case 1:
                b(t2, yogaNode, quickCardValue);
                return;
            case 2:
                c(t2, yogaNode, quickCardValue);
                return;
            default:
                return;
        }
    }

    private void a(PropertyCacheBean propertyCacheBean, int i10, T t2, YogaNode yogaNode) {
        propertyCacheBean.setHeightDefined(true);
        ViewGroup.LayoutParams layoutParams = t2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i10;
        }
        yogaNode.F(i10);
    }
}
