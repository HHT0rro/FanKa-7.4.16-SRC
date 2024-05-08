package com.huawei.quickcard.framework.processor.animation;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.b;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.d1;
import com.huawei.quickcard.e1;
import com.huawei.quickcard.framework.animation.QAnimatorSet;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyCacheBean;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ValueUtils;
import java.lang.ref.WeakReference;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AnimationProcessor<T extends View> implements PropertyProcessor<T> {
    private void a(QAnimatorSet qAnimatorSet, QuickCardValue quickCardValue, @NonNull T t2) {
        PropertyCacheBean obtainRootPropertyCacheBeanFromView;
        JSONArray jsonArray = quickCardValue.getJsonArray();
        if (qAnimatorSet.e()) {
            qAnimatorSet.a();
        }
        if (jsonArray == null) {
            qAnimatorSet.a(false);
            return;
        }
        b.a(qAnimatorSet, jsonArray, t2);
        if (!qAnimatorSet.c() || (obtainRootPropertyCacheBeanFromView = ValueUtils.obtainRootPropertyCacheBeanFromView(t2)) == null) {
            return;
        }
        obtainRootPropertyCacheBeanFromView.getSavedAnimationList().add(new WeakReference<>(t2));
    }

    private void b(QAnimatorSet qAnimatorSet, QuickCardValue quickCardValue) {
        qAnimatorSet.b(b.a(quickCardValue.getString()));
    }

    private void c(QAnimatorSet qAnimatorSet, QuickCardValue quickCardValue) {
        qAnimatorSet.a(b.a(quickCardValue.getString()));
    }

    private void d(QAnimatorSet qAnimatorSet, QuickCardValue quickCardValue) {
        qAnimatorSet.a(quickCardValue.getString());
    }

    private void e(QAnimatorSet qAnimatorSet, QuickCardValue quickCardValue) {
        qAnimatorSet.a(new d1(quickCardValue.getString()));
    }

    private void f(QAnimatorSet qAnimatorSet, QuickCardValue quickCardValue) {
        qAnimatorSet.a(e1.a(quickCardValue.getString()));
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean isImmediate() {
        return com.huawei.quickcard.framework.processor.b.a(this);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return com.huawei.quickcard.framework.processor.b.b(this);
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1614280392:
                if (str.equals("animationDuration")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1472511905:
                if (str.equals("animationDelay")) {
                    c4 = 1;
                    break;
                }
                break;
            case -781597262:
                if (str.equals("transformOrigin")) {
                    c4 = 2;
                    break;
                }
                break;
            case -351541910:
                if (str.equals("animationFillMode")) {
                    c4 = 3;
                    break;
                }
                break;
            case 283944150:
                if (str.equals("animationIterationCount")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1928875750:
                if (str.equals("animationTimingFunction")) {
                    c4 = 5;
                    break;
                }
                break;
            case 2031003695:
                if (str.equals(Attributes.AnimationStyle.ANIMATION_NAME)) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
                return ParserHelper.parseToString(obj, "0");
            case 2:
                return ParserHelper.parseToString(obj, Attributes.AnimationCommons.DEFAULT_TRANSFORM_ORIGIN);
            case 3:
                return ParserHelper.parseToString(obj, "none");
            case 4:
                return ParserHelper.parseToNumber(obj, 1);
            case 5:
                return ParserHelper.parseToString(obj, "ease");
            case 6:
                return ParserHelper.parseToJsonArray(obj);
            default:
                return QuickCardValue.EMPTY;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        QAnimatorSet qAnimatorSet = ValueUtils.obtainPropertyCacheBeanFromView(t2).getQAnimatorSet(t2);
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1614280392:
                if (str.equals("animationDuration")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1472511905:
                if (str.equals("animationDelay")) {
                    c4 = 1;
                    break;
                }
                break;
            case -781597262:
                if (str.equals("transformOrigin")) {
                    c4 = 2;
                    break;
                }
                break;
            case -351541910:
                if (str.equals("animationFillMode")) {
                    c4 = 3;
                    break;
                }
                break;
            case 283944150:
                if (str.equals("animationIterationCount")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1928875750:
                if (str.equals("animationTimingFunction")) {
                    c4 = 5;
                    break;
                }
                break;
            case 2031003695:
                if (str.equals(Attributes.AnimationStyle.ANIMATION_NAME)) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                c(qAnimatorSet, quickCardValue);
                return;
            case 1:
                b(qAnimatorSet, quickCardValue);
                return;
            case 2:
                e(qAnimatorSet, quickCardValue);
                return;
            case 3:
                d(qAnimatorSet, quickCardValue);
                return;
            case 4:
                a(qAnimatorSet, quickCardValue);
                return;
            case 5:
                f(qAnimatorSet, quickCardValue);
                return;
            case 6:
                a(qAnimatorSet, quickCardValue, t2);
                return;
            default:
                return;
        }
    }

    private void a(QAnimatorSet qAnimatorSet, QuickCardValue quickCardValue) {
        qAnimatorSet.a(quickCardValue.getNumber().intValue());
    }
}
