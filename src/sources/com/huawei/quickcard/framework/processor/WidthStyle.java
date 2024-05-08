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
public class WidthStyle<T extends View> implements PropertyProcessor<T> {
    private void a(PropertyCacheBean propertyCacheBean, int i10, T t2, YogaNode yogaNode) {
        propertyCacheBean.setWidthDefined(true);
        ViewGroup.LayoutParams layoutParams = t2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i10;
        }
        yogaNode.W(i10);
    }

    private void b(@NonNull T t2, YogaNode yogaNode, QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            yogaNode.R(0.0f);
            return;
        }
        if (quickCardValue.isPercent()) {
            yogaNode.S(quickCardValue.getPercent() * 100.0f);
        } else if (quickCardValue.isDp()) {
            yogaNode.R(ViewUtils.dip2IntPx(t2, quickCardValue.getDp()));
        } else if (quickCardValue.isPx()) {
            yogaNode.R(QuickJSViewUtils.dipSize2IntPx(t2, quickCardValue.getPx()));
        }
    }

    private void c(@NonNull T t2, YogaNode yogaNode, QuickCardValue quickCardValue) {
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(t2);
        if (obtainPropertyCacheBeanFromView.isAnimationView()) {
            obtainPropertyCacheBeanFromView.getQAnimatorSet(t2).b().put("width", quickCardValue);
        }
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            obtainPropertyCacheBeanFromView.setViewWidthPercent(0.0f);
            obtainPropertyCacheBeanFromView.setWidthDefined(false);
            yogaNode.X();
        } else if (quickCardValue.isPercent()) {
            obtainPropertyCacheBeanFromView.setViewWidthPercent(quickCardValue.getPercent());
            obtainPropertyCacheBeanFromView.setWidthDefined(true);
            yogaNode.Y(quickCardValue.getPercent() * 100.0f);
        } else if (quickCardValue.isDp()) {
            a(obtainPropertyCacheBeanFromView, ViewUtils.dip2IntPx(t2, quickCardValue.getDp()), t2, yogaNode);
        } else if (quickCardValue.isPx()) {
            a(obtainPropertyCacheBeanFromView, QuickJSViewUtils.dipSize2IntPx(t2, quickCardValue.getPx()), t2, yogaNode);
        } else {
            yogaNode.X();
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
            case -1375815020:
                if (str.equals(Attributes.Style.MIN_WIDTH)) {
                    c4 = 0;
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c4 = 1;
                    break;
                }
                break;
            case 400381634:
                if (str.equals("maxWidth")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                b(t2, yogaNode, quickCardValue);
                return;
            case 1:
                c(t2, yogaNode, quickCardValue);
                return;
            case 2:
                a(t2, yogaNode, quickCardValue);
                return;
            default:
                return;
        }
    }

    private void a(@NonNull T t2, YogaNode yogaNode, QuickCardValue quickCardValue) {
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            yogaNode.M(SystemUtils.getScreenWidth(t2.getContext()));
            return;
        }
        if (quickCardValue.isPercent()) {
            yogaNode.N(quickCardValue.getPercent() * 100.0f);
        } else if (quickCardValue.isDp()) {
            yogaNode.M(ViewUtils.dip2IntPx(t2, quickCardValue.getDp()));
        } else if (quickCardValue.isPx()) {
            yogaNode.M(QuickJSViewUtils.dipSize2IntPx(t2, quickCardValue.getPx()));
        }
    }
}
