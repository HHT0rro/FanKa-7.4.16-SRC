package com.huawei.quickcard.framework.processor;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.utils.YogaUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PositionStyle<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33903a = "PositionStyle";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33904b = "position";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33905c = "top";

    /* renamed from: d, reason: collision with root package name */
    private static final String f33906d = "bottom";

    /* renamed from: e, reason: collision with root package name */
    private static final String f33907e = "right";

    /* renamed from: f, reason: collision with root package name */
    private static final String f33908f = "left";

    /* renamed from: g, reason: collision with root package name */
    private static final float f33909g = 0.0f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33910a;

        static {
            int[] iArr = new int[YogaEdge.values().length];
            f33910a = iArr;
            try {
                iArr[YogaEdge.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33910a[YogaEdge.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33910a[YogaEdge.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33910a[YogaEdge.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final String f33911a = "none";

        /* renamed from: b, reason: collision with root package name */
        private static final String f33912b = "static";

        /* renamed from: c, reason: collision with root package name */
        private static final String f33913c = "absolute";

        /* renamed from: d, reason: collision with root package name */
        private static final String f33914d = "relative";
    }

    private void a(YogaNode yogaNode, @NonNull YogaEdge yogaEdge, View view, QuickCardValue quickCardValue) {
        if (quickCardValue != null && !TextUtils.isEmpty(quickCardValue.getString())) {
            float dip2FloatPx = ViewUtils.dip2FloatPx(ViewUtils.getConfigDensity(view.getContext(), ViewUtils.getCardContext(view)), ParserHelper.parseToDP(quickCardValue.getString(), 0.0f).getDp());
            if (a(view)) {
                a(yogaEdge, view, dip2FloatPx);
                return;
            } else {
                yogaNode.U(yogaEdge, dip2FloatPx);
                return;
            }
        }
        yogaNode.U(yogaEdge, Float.NaN);
    }

    private void b(YogaNode yogaNode) {
        yogaNode.V(YogaPositionType.RELATIVE);
        d(yogaNode);
    }

    private void c(YogaNode yogaNode) {
        yogaNode.V(YogaPositionType.RELATIVE);
        e(yogaNode);
    }

    private void d(YogaNode yogaNode) {
        yogaNode.U(YogaEdge.LEFT, 0.0f);
        yogaNode.U(YogaEdge.RIGHT, 0.0f);
        yogaNode.U(YogaEdge.TOP, 0.0f);
        yogaNode.U(YogaEdge.BOTTOM, 0.0f);
    }

    private void e(YogaNode yogaNode) {
        YogaEdge yogaEdge = YogaEdge.LEFT;
        yogaNode.U(yogaEdge, yogaNode.p(yogaEdge).f19201a);
        YogaEdge yogaEdge2 = YogaEdge.RIGHT;
        yogaNode.U(yogaEdge2, yogaNode.p(yogaEdge2).f19201a);
        YogaEdge yogaEdge3 = YogaEdge.TOP;
        yogaNode.U(yogaEdge3, yogaNode.p(yogaEdge3).f19201a);
        YogaEdge yogaEdge4 = YogaEdge.BOTTOM;
        yogaNode.U(yogaEdge4, yogaNode.p(yogaEdge4).f19201a);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public boolean isImmediate() {
        return true;
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
            case -1383228885:
                if (str.equals("bottom")) {
                    c4 = 0;
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c4 = 2;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c4 = 3;
                    break;
                }
                break;
            case 747804969:
                if (str.equals("position")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
                return ParserHelper.parseToString(obj, null);
            case 4:
                return ParserHelper.parseToString(obj, "relative");
            default:
                return QuickCardValue.EMPTY;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull View view, String str, QuickCardValue quickCardValue) {
        YogaNode yogaNode = YogaUtils.getYogaNode(view);
        if (yogaNode == null) {
            CardLogUtils.e(f33903a, "not support position style!");
            return;
        }
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals("bottom")) {
                    c4 = 0;
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c4 = 2;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c4 = 3;
                    break;
                }
                break;
            case 747804969:
                if (str.equals("position")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                a(yogaNode, YogaEdge.BOTTOM, view, quickCardValue);
                return;
            case 1:
                a(yogaNode, YogaEdge.TOP, view, quickCardValue);
                return;
            case 2:
                a(yogaNode, YogaEdge.LEFT, view, quickCardValue);
                return;
            case 3:
                a(yogaNode, YogaEdge.RIGHT, view, quickCardValue);
                return;
            case 4:
                a(yogaNode, view, quickCardValue);
                return;
            default:
                return;
        }
    }

    private void a(YogaEdge yogaEdge, View view, float f10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        int i10 = a.f33910a[yogaEdge.ordinal()];
        if (i10 == 1) {
            layoutParams2.leftMargin = (int) f10;
            a(layoutParams2, 3);
            return;
        }
        if (i10 == 2) {
            layoutParams2.topMargin = (int) f10;
            a(layoutParams2, 48);
        } else if (i10 == 3) {
            layoutParams2.rightMargin = (int) f10;
            a(layoutParams2, 5);
        } else {
            if (i10 != 4) {
                return;
            }
            layoutParams2.bottomMargin = (int) f10;
            a(layoutParams2, 80);
        }
    }

    private void a(FrameLayout.LayoutParams layoutParams, int i10) {
        int i11 = layoutParams.gravity;
        if (i11 == -1) {
            layoutParams.gravity = i10;
        } else {
            layoutParams.gravity = i10 | i11;
        }
    }

    private boolean a(View view) {
        return view.getLayoutParams() instanceof FrameLayout.LayoutParams;
    }

    private void a(YogaNode yogaNode, View view, QuickCardValue quickCardValue) {
        if (a(view)) {
            return;
        }
        if (quickCardValue != null && quickCardValue.isString()) {
            String string = quickCardValue.getString();
            string.hashCode();
            char c4 = 65535;
            switch (string.hashCode()) {
                case -892481938:
                    if (string.equals("static")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 3387192:
                    if (string.equals("none")) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 1728122231:
                    if (string.equals("absolute")) {
                        c4 = 2;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                case 1:
                    b(yogaNode);
                    return;
                case 2:
                    a(yogaNode);
                    return;
                default:
                    c(yogaNode);
                    return;
            }
        }
        c(yogaNode);
    }

    private void a(YogaNode yogaNode) {
        yogaNode.V(YogaPositionType.ABSOLUTE);
        e(yogaNode);
    }
}
