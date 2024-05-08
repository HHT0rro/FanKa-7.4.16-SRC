package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.ui.IViewDirection;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickJSViewUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.utils.YogaUtils;
import com.huawei.quickcard.views.div.CardYogaLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PaddingStyle<T extends View> implements PropertyProcessor<T> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33902a;

        static {
            int[] iArr = new int[YogaEdge.values().length];
            f33902a = iArr;
            try {
                iArr[YogaEdge.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33902a[YogaEdge.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33902a[YogaEdge.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33902a[YogaEdge.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33902a[YogaEdge.ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private int a(T t2, @NonNull QuickCardValue quickCardValue) {
        if (quickCardValue.isDp()) {
            return ViewUtils.dip2IntPx(t2, quickCardValue.getDp());
        }
        if (quickCardValue.isPx()) {
            return QuickJSViewUtils.dipSize2IntPx(t2, quickCardValue.getPx());
        }
        return 0;
    }

    private void b(T t2, QuickCardValue quickCardValue) {
        a((PaddingStyle<T>) t2, quickCardValue, YogaEdge.ALL);
    }

    private void c(T t2, QuickCardValue quickCardValue) {
        a((PaddingStyle<T>) t2, quickCardValue, YogaEdge.BOTTOM);
    }

    private void d(T t2, QuickCardValue quickCardValue) {
        a((PaddingStyle<T>) t2, quickCardValue, YogaEdge.END);
    }

    private void e(T t2, QuickCardValue quickCardValue) {
        a((PaddingStyle<T>) t2, quickCardValue, YogaEdge.START);
    }

    private void f(T t2, QuickCardValue quickCardValue) {
        a((PaddingStyle<T>) t2, quickCardValue, YogaEdge.LEFT);
    }

    private void g(T t2, QuickCardValue quickCardValue) {
        a((PaddingStyle<T>) t2, quickCardValue, YogaEdge.RIGHT);
    }

    private void h(T t2, QuickCardValue quickCardValue) {
        a((PaddingStyle<T>) t2, quickCardValue, YogaEdge.TOP);
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
        return ParserHelper.parseToDP(obj, 0.0f);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -2109496719:
                if (str.equals(Attributes.Style.PADDING_INLINE_END)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    c4 = 1;
                    break;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    c4 = 2;
                    break;
                }
                break;
            case 11325560:
                if (str.equals(Attributes.Style.PADDING_INLINE_START)) {
                    c4 = 3;
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c4 = 4;
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c4 = 5;
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                d(t2, quickCardValue);
                return;
            case 1:
                f(t2, quickCardValue);
                return;
            case 2:
                b(t2, quickCardValue);
                return;
            case 3:
                e(t2, quickCardValue);
                return;
            case 4:
                h(t2, quickCardValue);
                return;
            case 5:
                c(t2, quickCardValue);
                return;
            case 6:
                g(t2, quickCardValue);
                return;
            default:
                return;
        }
    }

    private void b(@NonNull T t2, int i10, @NonNull YogaEdge yogaEdge) {
        YogaNode yogaNode = YogaUtils.getYogaNode(t2);
        if (yogaNode != null) {
            yogaNode.T(yogaEdge, i10);
        }
    }

    private void a(@NonNull T t2, @NonNull QuickCardValue quickCardValue, @NonNull YogaEdge yogaEdge) {
        int a10 = a((PaddingStyle<T>) t2, quickCardValue);
        if (t2 instanceof CardYogaLayout) {
            b(t2, a10, yogaEdge);
        } else {
            a((PaddingStyle<T>) t2, a10, a((PaddingStyle<T>) t2, yogaEdge));
        }
    }

    private void a(@NonNull T t2, int i10, @NonNull YogaEdge yogaEdge) {
        int paddingLeft = t2.getPaddingLeft();
        int paddingRight = t2.getPaddingRight();
        int paddingTop = t2.getPaddingTop();
        int paddingBottom = t2.getPaddingBottom();
        int i11 = a.f33902a[yogaEdge.ordinal()];
        if (i11 == 1) {
            t2.setPadding(i10, paddingTop, paddingRight, paddingBottom);
            return;
        }
        if (i11 == 2) {
            t2.setPadding(paddingLeft, paddingTop, i10, paddingBottom);
            return;
        }
        if (i11 == 3) {
            t2.setPadding(paddingLeft, i10, paddingRight, paddingBottom);
        } else if (i11 == 4) {
            t2.setPadding(paddingLeft, paddingTop, paddingRight, i10);
        } else {
            if (i11 != 5) {
                return;
            }
            t2.setPadding(i10, i10, i10, i10);
        }
    }

    private YogaEdge a(@NonNull T t2, @NonNull YogaEdge yogaEdge) {
        return yogaEdge == YogaEdge.START ? a(t2) == 1 ? YogaEdge.RIGHT : YogaEdge.LEFT : yogaEdge == YogaEdge.END ? a(t2) == 1 ? YogaEdge.LEFT : YogaEdge.RIGHT : yogaEdge;
    }

    private int a(@NonNull T t2) {
        if (t2 instanceof IViewDirection) {
            return ((IViewDirection) t2).getContentDirection();
        }
        return t2.getLayoutDirection();
    }
}
