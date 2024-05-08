package com.huawei.quickcard.views.text.utils;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.huawei.quickcard.a;
import com.huawei.quickcard.a1;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.utils.ResourceUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.i0;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.text.TextDefaultAttrValue;
import com.huawei.quickcard.views.text.span.Span;
import com.huawei.quickcard.views.text.view.IQuickText;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SpannableUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34675a = "SpannableUtils";

    private static void a(Span span, QuickCardValue quickCardValue) {
        if (quickCardValue.isSp()) {
            span.setFontSize(2, Float.valueOf(quickCardValue.getSp()));
        } else {
            span.setFontSize(1, Float.valueOf(quickCardValue.getDp()));
        }
    }

    public static void applySpanAttr(Span span, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1550943582:
                if (str.equals("fontStyle")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1224696685:
                if (str.equals("fontFamily")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1026963764:
                if (str.equals(Attributes.Style.UNDERLINE)) {
                    c4 = 2;
                    break;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    c4 = 3;
                    break;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    c4 = 4;
                    break;
                }
                break;
            case 3211051:
                if (str.equals(Attributes.Style.HREF)) {
                    c4 = 5;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c4 = 6;
                    break;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    c4 = 7;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    c4 = '\b';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                span.setFontStyle(quickCardValue.getString());
                return;
            case 1:
                if (quickCardValue.isJsonArray()) {
                    span.setFontFamily(quickCardValue.getJsonArray());
                    return;
                } else {
                    span.setFontFamily(quickCardValue.getString());
                    return;
                }
            case 2:
                if (span instanceof a) {
                    ((a) span).a(quickCardValue.getBoolean());
                    return;
                }
                return;
            case 3:
                span.setTextDecoration(quickCardValue.getString());
                return;
            case 4:
                span.setFontWeight(quickCardValue.getString());
                return;
            case 5:
                span.setHref(quickCardValue.getString());
                return;
            case 6:
                span.setTextColor(quickCardValue.getNumber().intValue());
                return;
            case 7:
                span.setValue(quickCardValue.getString());
                return;
            case '\b':
                a(span, quickCardValue);
                return;
            default:
                return;
        }
    }

    private static QuickCardValue b(Object obj) {
        if (obj instanceof JSONArray) {
            return new QuickCardValue.JSONArrayValue((JSONArray) obj);
        }
        if (obj instanceof String) {
            return new QuickCardValue.StringValue((String) obj);
        }
        return QuickCardValue.EMPTY;
    }

    public static SpannableString makeSpan(Span span, IQuickText iQuickText) {
        String value = span.getValue();
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(value);
        setColor(spannableString, span.getTextColor(), iQuickText);
        setFontSize(spannableString, span.getTextUnit(), span.getFontSize(), iQuickText);
        setTextDecoration(spannableString, span.getTextDecoration(), iQuickText);
        a(spannableString, span, iQuickText);
        b(spannableString, span, iQuickText);
        return spannableString;
    }

    public static void setColor(SpannableString spannableString, Integer num, IQuickText iQuickText) {
        if (num == null) {
            if (iQuickText.getTextColor() == null) {
                return;
            } else {
                num = iQuickText.getTextColor();
            }
        }
        spannableString.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableString.length(), 34);
    }

    public static void setFontSize(SpannableString spannableString, int i10, Float f10, IQuickText iQuickText) {
        Float fontSize = iQuickText.getFontSize();
        if (f10 == null) {
            if (fontSize == null) {
                return;
            }
            if (i10 < 0) {
                i10 = iQuickText.getTextUnit();
            }
            f10 = fontSize;
        }
        if (i10 == 1) {
            f10 = Float.valueOf(ViewUtils.dip2FloatPx(iQuickText, f10.floatValue()));
        } else if (i10 == 2) {
            f10 = ViewUtils.sp2FloatPx(iQuickText, f10.floatValue());
        }
        spannableString.setSpan(new AbsoluteSizeSpan(f10.intValue()), 0, spannableString.length(), 34);
    }

    public static void setTextDecoration(SpannableString spannableString, String str, IQuickText iQuickText) {
        if (str == null) {
            str = iQuickText.getTextDecoration();
        }
        spannableString.setSpan(TextStyleUtils.getTextDecoration(str), 0, spannableString.length(), 34);
    }

    public static void updateChildrenAttrsOrStyles(String str, Map<String, Span> map, IQuickText iQuickText) {
        Iterator<Map.Entry<String, Span>> iterator2 = map.entrySet().iterator2();
        while (iterator2.hasNext()) {
            a(str, iterator2.next().getValue(), iQuickText);
        }
    }

    public static QuickCardValue wrapQuickcardValue(String str, Object obj) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1550943582:
                if (str.equals("fontStyle")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1224696685:
                if (str.equals("fontFamily")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1026963764:
                if (str.equals(Attributes.Style.UNDERLINE)) {
                    c4 = 2;
                    break;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    c4 = 3;
                    break;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    c4 = 4;
                    break;
                }
                break;
            case 3211051:
                if (str.equals(Attributes.Style.HREF)) {
                    c4 = 5;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c4 = 6;
                    break;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    c4 = 7;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    c4 = '\b';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return ParserHelper.parseToString(obj, "normal");
            case 1:
                return b(obj);
            case 2:
                return ParserHelper.parseToBool(obj, false);
            case 3:
                return ParserHelper.parseToString(obj, "none");
            case 4:
                return ParserHelper.parseToString(obj, "normal");
            case 5:
            case 7:
                return ParserHelper.parseToString(obj, "");
            case 6:
                return ParserHelper.parseToColor(obj, ResourceUtils.getColor(TextDefaultAttrValue.DEFAULT_TEXT_COLOR));
            case '\b':
                return ParserHelper.parseToSP(obj, 15.0f);
            default:
                return QuickCardValue.EMPTY;
        }
    }

    private static void a(SpannableString spannableString, Span span, IQuickText iQuickText) {
        String fontStyle = span.getFontStyle();
        String fontStyle2 = iQuickText.getFontStyle();
        Object fontFamily = span.getFontFamily();
        Object fontFamily2 = iQuickText.getFontFamily();
        String fontWeight = span.getFontWeight();
        String fontWeight2 = iQuickText.getFontWeight();
        if (!a(fontFamily)) {
            fontFamily = a(fontFamily2) ? fontFamily2 : null;
        }
        spannableString.setSpan(new i0(fontFamily != null ? TextStyleUtils.getFontFamily(fontFamily) : null, a(fontStyle, fontStyle2), a(fontWeight, fontWeight2)), 0, spannableString.length(), 34);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void b(SpannableString spannableString, Span span, IQuickText iQuickText) {
        if ((iQuickText instanceof TextView) && (span instanceof a)) {
            spannableString.setSpan(new a1((a) span), 0, spannableString.length(), 34);
            ((TextView) iQuickText).setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    private static boolean a(Object obj) {
        if (obj instanceof JSONArray) {
            return ((JSONArray) obj).length() > 0;
        }
        if (obj instanceof String) {
            return !TextUtils.isEmpty((CharSequence) obj);
        }
        return false;
    }

    private static void a(String str, Span span, IQuickText iQuickText) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1550943582:
                if (str.equals("fontStyle")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1224696685:
                if (str.equals("fontFamily")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1063571914:
                if (str.equals(IQuickText.Attrs.TEXT_COLOR)) {
                    c4 = 2;
                    break;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    c4 = 3;
                    break;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    c4 = 4;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                span.setParentFontStyle(iQuickText.getFontStyle());
                return;
            case 1:
                span.setParentFontFamily(iQuickText.getFontFamily());
                return;
            case 2:
                span.setParentTextColor(iQuickText.getTextColor());
                return;
            case 3:
                span.setParentTextDecoration(iQuickText.getTextDecoration());
                return;
            case 4:
                span.setParentFontWeight(iQuickText.getFontWeight());
                return;
            case 5:
                span.setParentFontSize(iQuickText.getTextUnit(), iQuickText.getFontSize());
                return;
            default:
                return;
        }
    }
}
