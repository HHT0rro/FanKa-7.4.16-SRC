package com.huawei.quickcard.framework.processor;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.QuickCardRoot;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.f2;
import com.huawei.quickcard.framework.IComponentSupport;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.ui.IViewDirection;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickJSViewUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.utils.YogaUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MarginStyle<T extends View> implements PropertyProcessor<T> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33896a;

        static {
            int[] iArr = new int[YogaEdge.values().length];
            f33896a = iArr;
            try {
                iArr[YogaEdge.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33896a[YogaEdge.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33896a[YogaEdge.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33896a[YogaEdge.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33896a[YogaEdge.ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void a(T t2, String str, int i10) {
        if (YogaUtils.isParentYogaLayout(t2) && (a(t2) instanceof f2)) {
            t2.setLayoutParams(new ViewGroup.MarginLayoutParams(a(t2)));
        }
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1081309778:
                if (str.equals("margin")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    c4 = 1;
                    break;
                }
                break;
            case -676638021:
                if (str.equals(Attributes.Style.MARGIN_INLINE_START)) {
                    c4 = 2;
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    c4 = 3;
                    break;
                }
                break;
            case 611572084:
                if (str.equals(Attributes.Style.MARGIN_INLINE_END)) {
                    c4 = 4;
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    c4 = 6;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                a((MarginStyle<T>) t2, i10);
                return;
            case 1:
                g(t2, i10);
                return;
            case 2:
                f(t2, i10);
                return;
            case 3:
                b(t2, i10);
                return;
            case 4:
                c(t2, i10);
                return;
            case 5:
                e(t2, i10);
                return;
            case 6:
                d(t2, i10);
                return;
            default:
                return;
        }
    }

    private void b(T t2, int i10) {
        setEdgeMargin(t2, i10, YogaEdge.BOTTOM);
    }

    private void c(@NonNull T t2, int i10) {
        setEdgeMargin(t2, i10, YogaEdge.END);
    }

    private void d(T t2, int i10) {
        setEdgeMargin(t2, i10, YogaEdge.LEFT);
    }

    private void e(T t2, int i10) {
        setEdgeMargin(t2, i10, YogaEdge.RIGHT);
    }

    private void f(@NonNull T t2, int i10) {
        setEdgeMargin(t2, i10, YogaEdge.START);
    }

    private void g(T t2, int i10) {
        setEdgeMargin(t2, i10, YogaEdge.TOP);
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

    public void setEdgeMargin(@NonNull T t2, int i10, @NonNull YogaEdge yogaEdge) {
        if (YogaUtils.isParentYogaLayout(t2)) {
            YogaNode yogaNode = YogaUtils.getYogaNode(t2);
            if (yogaNode != null) {
                yogaNode.J(a((MarginStyle<T>) t2, yogaEdge), i10);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams a10 = a(t2);
        if (a10 instanceof ViewGroup.MarginLayoutParams) {
            a((ViewGroup.MarginLayoutParams) a10, i10, a((MarginStyle<T>) t2, yogaEdge));
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        int i10;
        if (quickCardValue != null) {
            if (quickCardValue.isDp()) {
                i10 = ViewUtils.dip2IntPx(ViewUtils.getConfigDensity(t2.getContext(), ViewUtils.getCardContext(t2)), quickCardValue.getDp());
            } else if (quickCardValue.isPx()) {
                i10 = QuickJSViewUtils.dipSize2IntPx(t2, quickCardValue.getPx());
            }
            a((MarginStyle<T>) t2, str, i10);
        }
        i10 = 0;
        a((MarginStyle<T>) t2, str, i10);
    }

    private int b(@NonNull T t2) {
        ViewParent parent;
        if (t2 instanceof IComponentSupport) {
            parent = ((IComponentSupport) t2).getViewParent(t2);
        } else {
            parent = t2.getParent();
        }
        if ((parent instanceof QuickCardRoot) && (parent instanceof ViewGroup)) {
            return ((ViewGroup) parent).getResources().getConfiguration().getLayoutDirection();
        }
        if (parent instanceof IViewDirection) {
            return ((IViewDirection) parent).getContentDirection();
        }
        return parent != null ? parent.getLayoutDirection() : t2.getTextDirection();
    }

    private void a(T t2, int i10) {
        setEdgeMargin(t2, i10, YogaEdge.ALL);
    }

    private ViewGroup.LayoutParams a(T t2) {
        if (t2 == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = t2.getLayoutParams();
        return layoutParams == null ? a() : layoutParams;
    }

    @NonNull
    private ViewGroup.LayoutParams a() {
        return new f2(-2, -2);
    }

    private YogaEdge a(@NonNull T t2, @NonNull YogaEdge yogaEdge) {
        return yogaEdge == YogaEdge.START ? b(t2) == 1 ? YogaEdge.RIGHT : YogaEdge.LEFT : yogaEdge == YogaEdge.END ? b(t2) == 1 ? YogaEdge.LEFT : YogaEdge.RIGHT : yogaEdge;
    }

    private void a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i10, @NonNull YogaEdge yogaEdge) {
        int i11 = a.f33896a[yogaEdge.ordinal()];
        if (i11 == 1) {
            marginLayoutParams.leftMargin = i10;
            return;
        }
        if (i11 == 2) {
            marginLayoutParams.rightMargin = i10;
            return;
        }
        if (i11 == 3) {
            marginLayoutParams.topMargin = i10;
        } else if (i11 == 4) {
            marginLayoutParams.bottomMargin = i10;
        } else {
            if (i11 != 5) {
                return;
            }
            marginLayoutParams.setMargins(i10, i10, i10, i10);
        }
    }
}
