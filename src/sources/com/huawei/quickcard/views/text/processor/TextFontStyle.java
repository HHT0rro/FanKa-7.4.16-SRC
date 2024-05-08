package com.huawei.quickcard.views.text.processor;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.QuickJSViewUtils;
import com.huawei.quickcard.utils.SystemUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.text.utils.TextStyleUtils;
import com.huawei.quickcard.views.text.view.IQuickText;
import org.json.JSONArray;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TextFontStyle<T extends TextView> implements PropertyProcessor<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34652a = "TextFontStyle";

    private void a(@NonNull TextView textView, int i10) {
        Typeface typeface = textView.getTypeface();
        if (typeface != null && typeface.getStyle() != 0 && typeface.getStyle() != 1) {
            if (typeface.getStyle() == 2 && i10 == 1) {
                textView.setTypeface(Typeface.create(typeface, 3));
                return;
            } else {
                textView.setTypeface(Typeface.create(typeface, 2));
                return;
            }
        }
        textView.setTypeface(typeface == null ? Typeface.defaultFromStyle(i10) : Typeface.create(typeface, i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(@NonNull TextView textView, QuickCardValue quickCardValue) {
        float sp2FloatPx;
        if (QuickCardValue.EMPTY.equals(quickCardValue)) {
            if (textView instanceof IQuickText) {
                ((IQuickText) textView).setFontSize(0, Float.valueOf(ViewUtils.sp2FloatPx(textView, 15.0f)));
                return;
            } else {
                textView.setTextSize(0, ViewUtils.sp2FloatPx(textView, 15.0f));
                return;
            }
        }
        if (quickCardValue.isDp()) {
            sp2FloatPx = ViewUtils.dip2FloatPx(textView, quickCardValue.getDp());
        } else if (quickCardValue.isPx()) {
            sp2FloatPx = QuickJSViewUtils.dipSize2IntPx(textView, quickCardValue.getPx());
        } else {
            sp2FloatPx = ViewUtils.sp2FloatPx(textView, quickCardValue.getSp());
        }
        if (sp2FloatPx <= 0.0f) {
            sp2FloatPx = ViewUtils.sp2FloatPx(textView, 15.0f);
        }
        if (textView instanceof IQuickText) {
            ((IQuickText) textView).setFontSize(0, Float.valueOf(sp2FloatPx));
        } else {
            textView.setTextSize(0, sp2FloatPx);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(@NonNull TextView textView, QuickCardValue quickCardValue) {
        String string = quickCardValue.getString();
        if (TextUtils.isEmpty(string)) {
            string = "normal";
        }
        if (textView instanceof IQuickText) {
            ((IQuickText) textView).setFontStyle(string);
        }
        if (SystemUtils.isOverAPI28()) {
            a(textView, string);
        } else {
            b(textView, string);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(@NonNull TextView textView, QuickCardValue quickCardValue) {
        String string = quickCardValue.getString();
        if (textView instanceof IQuickText) {
            ((IQuickText) textView).setFontWeight(string);
        }
        int fontWeight = TextStyleUtils.getFontWeight(string);
        if (SystemUtils.isOverAPI28()) {
            Typeface typeface = textView.getTypeface();
            textView.setTypeface(Typeface.create(typeface, fontWeight, typeface != null && typeface.isItalic()));
        } else {
            a(textView, fontWeight);
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
            case -734428249:
                if (str.equals("fontWeight")) {
                    c4 = 2;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 2:
                return ParserHelper.parseToString(obj, "");
            case 1:
                return a(obj);
            case 3:
                return ParserHelper.parseToSP(obj, 15.0f);
            default:
                return QuickCardValue.EMPTY;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (quickCardValue == null) {
            CardLogUtils.e(f34652a, "property value is empty!");
            return;
        }
        ViewUtils.dirty(t2);
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
            case -734428249:
                if (str.equals("fontWeight")) {
                    c4 = 2;
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
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
                a(t2, quickCardValue);
                return;
            case 2:
                d(t2, quickCardValue);
                return;
            case 3:
                b(t2, quickCardValue);
                return;
            default:
                return;
        }
    }

    @RequiresApi(api = 28)
    private void a(@NonNull TextView textView, String str) {
        Typeface create;
        Typeface typeface = textView.getTypeface();
        int a10 = a(str);
        if (typeface == null) {
            create = Typeface.defaultFromStyle(a10);
        } else {
            create = Typeface.create(typeface, typeface.getWeight(), a10 == 2);
        }
        textView.setTypeface(create);
    }

    private int a(String str) {
        return "italic".equals(str) ? 2 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(@NonNull TextView textView, QuickCardValue quickCardValue) {
        Object obj;
        if (quickCardValue.isJsonArray()) {
            obj = quickCardValue.getJsonArray();
        } else if (quickCardValue.isString()) {
            obj = quickCardValue.getString();
        } else {
            CardLogUtils.e(f34652a, "the value of font-family neither a String nor a JsonArray");
            obj = null;
        }
        if (textView instanceof IQuickText) {
            ((IQuickText) textView).setFontFamily(obj);
        }
        Typeface fontFamily = TextStyleUtils.getFontFamily(obj);
        if (fontFamily != null) {
            textView.setTypeface(fontFamily);
        }
    }

    private void b(@NonNull TextView textView, String str) {
        Typeface create;
        int i10 = "italic".equals(str) ? 2 : 0;
        Typeface typeface = textView.getTypeface();
        if (typeface != null && typeface.getStyle() != 0 && typeface.getStyle() != 2) {
            if (typeface.getStyle() == 1 && i10 == 2) {
                textView.setTypeface(Typeface.create(typeface, 3));
                return;
            } else {
                if (typeface.getStyle() == 3 && i10 == 0) {
                    textView.setTypeface(Typeface.create(typeface, 1));
                    return;
                }
                return;
            }
        }
        if (typeface == null) {
            create = Typeface.defaultFromStyle(i10);
        } else {
            create = Typeface.create(typeface, i10);
        }
        textView.setTypeface(create);
    }

    private QuickCardValue a(Object obj) {
        if (obj instanceof JSONArray) {
            return new QuickCardValue.JSONArrayValue((JSONArray) obj);
        }
        if (obj instanceof String) {
            return new QuickCardValue.StringValue((String) obj);
        }
        return QuickCardValue.EMPTY;
    }
}
