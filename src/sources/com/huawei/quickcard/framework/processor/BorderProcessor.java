package com.huawei.quickcard.framework.processor;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.framework.background.DrawableUtils;
import com.huawei.quickcard.framework.background.IBorderRadiusDrawable;
import com.huawei.quickcard.framework.border.Border;
import com.huawei.quickcard.framework.border.BorderRadius;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.j;
import com.huawei.quickcard.n1;
import com.huawei.quickcard.o;
import com.huawei.quickcard.o1;
import com.huawei.quickcard.p;
import com.huawei.quickcard.utils.QuickJSViewUtils;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.utils.YogaUtils;
import org.apache.commons.lang3.CharUtils;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BorderProcessor<T extends View> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33866a = "BorderProcessor";

    /* renamed from: b, reason: collision with root package name */
    private static final String f33867b = "dotted";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33868c = "dashed";

    /* renamed from: d, reason: collision with root package name */
    private static final String f33869d = "solid";

    /* renamed from: e, reason: collision with root package name */
    private static final int f33870e = 0;

    /* renamed from: f, reason: collision with root package name */
    private static final int f33871f = 1;

    /* renamed from: g, reason: collision with root package name */
    private static final int f33872g = 2;

    /* renamed from: h, reason: collision with root package name */
    private static final int f33873h = 3;

    /* renamed from: i, reason: collision with root package name */
    private static final int f33874i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static final int f33875j = 1;

    /* renamed from: k, reason: collision with root package name */
    private static final int f33876k = 2;

    /* renamed from: l, reason: collision with root package name */
    private static final int f33877l = 3;

    /* renamed from: m, reason: collision with root package name */
    private static final int f33878m = 4;

    private void a(YogaNode yogaNode, int i10, float f10) {
        if (i10 == 0) {
            yogaNode.x(YogaEdge.LEFT, f10);
            return;
        }
        if (i10 == 1) {
            yogaNode.x(YogaEdge.TOP, f10);
            return;
        }
        if (i10 == 2) {
            yogaNode.x(YogaEdge.RIGHT, f10);
        } else if (i10 == 3) {
            yogaNode.x(YogaEdge.BOTTOM, f10);
        } else {
            if (i10 != 4) {
                return;
            }
            yogaNode.x(YogaEdge.ALL, f10);
        }
    }

    private void b(T t2, QuickCardValue quickCardValue, int i10) {
        Border a10 = a((BorderProcessor<T>) t2);
        a(a10, i10, a((BorderProcessor<T>) t2, quickCardValue));
        traverseBorder(t2, a10);
    }

    private void c(T t2, QuickCardValue quickCardValue, int i10) {
        Border a10 = a((BorderProcessor<T>) t2);
        a(a10, i10, a(quickCardValue));
        traverseBorder(t2, a10);
    }

    private void d(T t2, QuickCardValue quickCardValue, int i10) {
        YogaNode yogaNode;
        Border a10 = a((BorderProcessor<T>) t2);
        float a11 = a(quickCardValue, (QuickCardValue) t2);
        a(a10, i10, a11);
        traverseBorder(t2, a10);
        CardContext cardContext = ViewUtils.getCardContext(t2);
        if (cardContext == null || cardContext.getCardMinPlatformVer() < 1008 || (yogaNode = YogaUtils.getYogaNode(t2)) == null) {
            return;
        }
        a(yogaNode, i10, a11);
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
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals(Attributes.Style.BORDER_RIGHT_COLOR)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1974639039:
                if (str.equals(Attributes.Style.BORDER_RIGHT_STYLE)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1971292586:
                if (str.equals(Attributes.Style.BORDER_RIGHT_WIDTH)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1470826662:
                if (str.equals(Attributes.Style.BORDER_TOP_COLOR)) {
                    c4 = 3;
                    break;
                }
                break;
            case -1455888984:
                if (str.equals(Attributes.Style.BORDER_TOP_STYLE)) {
                    c4 = 4;
                    break;
                }
                break;
            case -1452542531:
                if (str.equals(Attributes.Style.BORDER_TOP_WIDTH)) {
                    c4 = 5;
                    break;
                }
                break;
            case -1308858324:
                if (str.equals(Attributes.Style.BORDER_BOTTOM_COLOR)) {
                    c4 = 6;
                    break;
                }
                break;
            case -1293920646:
                if (str.equals(Attributes.Style.BORDER_BOTTOM_STYLE)) {
                    c4 = 7;
                    break;
                }
                break;
            case -1290574193:
                if (str.equals(Attributes.Style.BORDER_BOTTOM_WIDTH)) {
                    c4 = '\b';
                    break;
                }
                break;
            case -1228066334:
                if (str.equals(Attributes.Style.BORDER_TOP_LEFT_RADIUS)) {
                    c4 = '\t';
                    break;
                }
                break;
            case -242276144:
                if (str.equals(Attributes.Style.BORDER_LEFT_COLOR)) {
                    c4 = '\n';
                    break;
                }
                break;
            case -227338466:
                if (str.equals(Attributes.Style.BORDER_LEFT_STYLE)) {
                    c4 = 11;
                    break;
                }
                break;
            case -223992013:
                if (str.equals(Attributes.Style.BORDER_LEFT_WIDTH)) {
                    c4 = '\f';
                    break;
                }
                break;
            case 333432965:
                if (str.equals(Attributes.Style.BORDER_TOP_RIGHT_RADIUS)) {
                    c4 = CharUtils.CR;
                    break;
                }
                break;
            case 581268560:
                if (str.equals(Attributes.Style.BORDER_BOTTOM_LEFT_RADIUS)) {
                    c4 = 14;
                    break;
                }
                break;
            case 588239831:
                if (str.equals(Attributes.Style.BORDER_BOTTOM_RIGHT_RADIUS)) {
                    c4 = 15;
                    break;
                }
                break;
            case 722830999:
                if (str.equals(Attributes.Style.BORDER_COLOR)) {
                    c4 = 16;
                    break;
                }
                break;
            case 737768677:
                if (str.equals(Attributes.Style.BORDER_STYLE)) {
                    c4 = 17;
                    break;
                }
                break;
            case 741115130:
                if (str.equals(Attributes.Style.BORDER_WIDTH)) {
                    c4 = 18;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals(Attributes.Style.BORDER_RADIUS)) {
                    c4 = 19;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 3:
            case 6:
            case '\n':
            case 16:
                return ParserHelper.parseToString(obj, null);
            case 1:
            case 4:
            case 7:
            case 11:
            case 17:
                return ParserHelper.parseToString(obj, f33869d);
            case 2:
            case 5:
            case '\b':
            case '\f':
            case 18:
                return ParserHelper.parseToDP(obj, 0.0f);
            case '\t':
            case '\r':
            case 14:
            case 15:
            case 19:
                return ParserHelper.parseToSize(obj);
            default:
                return QuickCardValue.EMPTY;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals(Attributes.Style.BORDER_RIGHT_COLOR)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1974639039:
                if (str.equals(Attributes.Style.BORDER_RIGHT_STYLE)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1971292586:
                if (str.equals(Attributes.Style.BORDER_RIGHT_WIDTH)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1470826662:
                if (str.equals(Attributes.Style.BORDER_TOP_COLOR)) {
                    c4 = 3;
                    break;
                }
                break;
            case -1455888984:
                if (str.equals(Attributes.Style.BORDER_TOP_STYLE)) {
                    c4 = 4;
                    break;
                }
                break;
            case -1452542531:
                if (str.equals(Attributes.Style.BORDER_TOP_WIDTH)) {
                    c4 = 5;
                    break;
                }
                break;
            case -1308858324:
                if (str.equals(Attributes.Style.BORDER_BOTTOM_COLOR)) {
                    c4 = 6;
                    break;
                }
                break;
            case -1293920646:
                if (str.equals(Attributes.Style.BORDER_BOTTOM_STYLE)) {
                    c4 = 7;
                    break;
                }
                break;
            case -1290574193:
                if (str.equals(Attributes.Style.BORDER_BOTTOM_WIDTH)) {
                    c4 = '\b';
                    break;
                }
                break;
            case -1228066334:
                if (str.equals(Attributes.Style.BORDER_TOP_LEFT_RADIUS)) {
                    c4 = '\t';
                    break;
                }
                break;
            case -242276144:
                if (str.equals(Attributes.Style.BORDER_LEFT_COLOR)) {
                    c4 = '\n';
                    break;
                }
                break;
            case -227338466:
                if (str.equals(Attributes.Style.BORDER_LEFT_STYLE)) {
                    c4 = 11;
                    break;
                }
                break;
            case -223992013:
                if (str.equals(Attributes.Style.BORDER_LEFT_WIDTH)) {
                    c4 = '\f';
                    break;
                }
                break;
            case 333432965:
                if (str.equals(Attributes.Style.BORDER_TOP_RIGHT_RADIUS)) {
                    c4 = CharUtils.CR;
                    break;
                }
                break;
            case 581268560:
                if (str.equals(Attributes.Style.BORDER_BOTTOM_LEFT_RADIUS)) {
                    c4 = 14;
                    break;
                }
                break;
            case 588239831:
                if (str.equals(Attributes.Style.BORDER_BOTTOM_RIGHT_RADIUS)) {
                    c4 = 15;
                    break;
                }
                break;
            case 722830999:
                if (str.equals(Attributes.Style.BORDER_COLOR)) {
                    c4 = 16;
                    break;
                }
                break;
            case 737768677:
                if (str.equals(Attributes.Style.BORDER_STYLE)) {
                    c4 = 17;
                    break;
                }
                break;
            case 741115130:
                if (str.equals(Attributes.Style.BORDER_WIDTH)) {
                    c4 = 18;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals(Attributes.Style.BORDER_RADIUS)) {
                    c4 = 19;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                a((BorderProcessor<T>) t2, quickCardValue, 2);
                return;
            case 1:
                c(t2, quickCardValue, 2);
                return;
            case 2:
                d(t2, quickCardValue, 2);
                return;
            case 3:
                a((BorderProcessor<T>) t2, quickCardValue, 1);
                return;
            case 4:
                c(t2, quickCardValue, 1);
                return;
            case 5:
                d(t2, quickCardValue, 1);
                return;
            case 6:
                a((BorderProcessor<T>) t2, quickCardValue, 3);
                return;
            case 7:
                c(t2, quickCardValue, 3);
                return;
            case '\b':
                d(t2, quickCardValue, 3);
                return;
            case '\t':
                b(t2, quickCardValue, 0);
                return;
            case '\n':
                a((BorderProcessor<T>) t2, quickCardValue, 0);
                return;
            case 11:
                c(t2, quickCardValue, 0);
                return;
            case '\f':
                d(t2, quickCardValue, 0);
                return;
            case '\r':
                b(t2, quickCardValue, 1);
                return;
            case 14:
                b(t2, quickCardValue, 2);
                return;
            case 15:
                b(t2, quickCardValue, 3);
                return;
            case 16:
                a((BorderProcessor<T>) t2, quickCardValue, 4);
                return;
            case 17:
                c(t2, quickCardValue, 4);
                return;
            case 18:
                d(t2, quickCardValue, 4);
                return;
            case 19:
                b(t2, quickCardValue, 4);
                return;
            default:
                return;
        }
    }

    public void traverseBorder(@NonNull T t2, @NonNull Border border) {
        Drawable background = t2.getBackground();
        if (background == null) {
            background = DrawableUtils.createLayerDrawable(t2.getContext());
        }
        if (!(background instanceof LayerDrawable)) {
            CardLogUtils.e(f33866a, "background not layer");
            return;
        }
        LayerDrawable layerDrawable = (LayerDrawable) background;
        layerDrawable.setDrawableByLayerId(R.id.quick_card_background_border, DrawableUtils.parseToBorderDrawable(t2, border));
        for (int i10 = 0; i10 < layerDrawable.getNumberOfLayers(); i10++) {
            Object drawable = layerDrawable.getDrawable(i10);
            if (drawable instanceof IBorderRadiusDrawable) {
                ((IBorderRadiusDrawable) drawable).setBorder(border);
            }
        }
        t2.setBackground(layerDrawable);
    }

    private void a(T t2, QuickCardValue quickCardValue, int i10) {
        Border a10 = a((BorderProcessor<T>) t2);
        j a11 = a(a10);
        a(a10, i10, a11, a(a11, quickCardValue));
        traverseBorder(t2, a10);
    }

    @NonNull
    private Border a(@NonNull T t2) {
        PropertyCacheBean obtainPropertyCacheBeanFromView = ValueUtils.obtainPropertyCacheBeanFromView(t2);
        Border border = obtainPropertyCacheBeanFromView.getBorder();
        if (border != null) {
            return border;
        }
        Border border2 = new Border();
        obtainPropertyCacheBeanFromView.setBorder(border2);
        return border2;
    }

    @NonNull
    private j a(@NonNull Border border) {
        j borderColor = border.getBorderColor();
        if (borderColor != null) {
            return borderColor;
        }
        j jVar = new j();
        border.setBorderColor(jVar);
        return jVar;
    }

    @NonNull
    private o1 a(T t2, QuickCardValue quickCardValue) {
        if (quickCardValue != null && !QuickCardValue.EMPTY.equals(quickCardValue) && (quickCardValue.isDp() || quickCardValue.isPercent())) {
            if (quickCardValue.isPercent()) {
                return new o1(quickCardValue.getPercent(), n1.PERCENT);
            }
            if (quickCardValue.isDp()) {
                return new o1(quickCardValue.getDp(), n1.DP);
            }
            return new o1(QuickJSViewUtils.dipSize2IntPx(t2, quickCardValue.getPx()), n1.PX);
        }
        return new o1(0.0f, n1.DP);
    }

    @NonNull
    private o.a a(QuickCardValue quickCardValue) {
        if (quickCardValue != null && !QuickCardValue.EMPTY.equals(quickCardValue) && quickCardValue.isString()) {
            String string = quickCardValue.isString() ? quickCardValue.getString() : "";
            if (TextUtils.isEmpty(string)) {
                return o.a.SOLID;
            }
            string.hashCode();
            if (string.equals(f33868c)) {
                return o.a.DASHED;
            }
            if (!string.equals(f33867b)) {
                return o.a.SOLID;
            }
            return o.a.DOTTED;
        }
        return o.a.SOLID;
    }

    private float a(QuickCardValue quickCardValue, @NonNull T t2) {
        if (quickCardValue != null && !QuickCardValue.EMPTY.equals(quickCardValue)) {
            if (quickCardValue.isDp()) {
                return ViewUtils.dip2FloatPx(t2, quickCardValue.getDp());
            }
            if (quickCardValue.isPx()) {
                return QuickJSViewUtils.dipSize2IntPx(t2, quickCardValue.getPx());
            }
        }
        return 0.0f;
    }

    private String a(@NonNull j jVar, QuickCardValue quickCardValue) {
        String b4 = jVar.b();
        if (quickCardValue == null || QuickCardValue.EMPTY.equals(quickCardValue) || !quickCardValue.isString()) {
            b4 = jVar.b();
        }
        return (quickCardValue == null || !quickCardValue.isString()) ? b4 : quickCardValue.getString();
    }

    private void a(@NonNull Border border, int i10, o1 o1Var) {
        BorderRadius borderRadius = border.getBorderRadius();
        if (borderRadius == null) {
            borderRadius = new BorderRadius();
        }
        if (i10 == 0) {
            borderRadius.setTopLeft(o1Var);
        } else if (i10 == 1) {
            borderRadius.setTopRight(o1Var);
        } else if (i10 == 2) {
            borderRadius.setBottomLeft(o1Var);
        } else if (i10 == 3) {
            borderRadius.setBottomRight(o1Var);
        } else if (i10 == 4) {
            borderRadius.setAllRadius(o1Var);
        }
        border.setBorderRadius(borderRadius);
    }

    private void a(@NonNull Border border, int i10, o.a aVar) {
        o borderStyle = border.getBorderStyle();
        if (borderStyle == null) {
            borderStyle = new o();
        }
        if (i10 == 0) {
            borderStyle.c(aVar);
        } else if (i10 == 1) {
            borderStyle.e(aVar);
        } else if (i10 == 2) {
            borderStyle.d(aVar);
        } else if (i10 == 3) {
            borderStyle.b(aVar);
        } else if (i10 == 4) {
            borderStyle.a(aVar);
        }
        border.setBorderStyle(borderStyle);
    }

    private void a(@NonNull Border border, int i10, float f10) {
        p borderWidth = border.getBorderWidth();
        if (borderWidth == null) {
            borderWidth = new p();
        }
        if (i10 == 0) {
            borderWidth.c(f10);
        } else if (i10 == 1) {
            borderWidth.e(f10);
        } else if (i10 == 2) {
            borderWidth.d(f10);
        } else if (i10 == 3) {
            borderWidth.b(f10);
        } else if (i10 == 4) {
            borderWidth.a(f10);
        }
        border.setBorderWidth(borderWidth);
    }

    private void a(@NonNull Border border, int i10, @NonNull j jVar, String str) {
        if (i10 == 0) {
            jVar.c(str);
        } else if (i10 == 1) {
            jVar.e(str);
        } else if (i10 == 2) {
            jVar.d(str);
        } else if (i10 == 3) {
            jVar.b(str);
        } else if (i10 == 4) {
            jVar.a(str);
        }
        border.setBorderColor(jVar);
    }
}
