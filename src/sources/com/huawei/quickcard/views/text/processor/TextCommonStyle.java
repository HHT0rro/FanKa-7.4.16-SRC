package com.huawei.quickcard.views.text.processor;

import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.css.adapter.value.integrate.align.CSSAlignValue;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.text.utils.TextStyleUtils;
import com.huawei.quickcard.views.text.view.IQuickText;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TextCommonStyle implements PropertyProcessor<TextView> {
    private void a(@NonNull TextView textView, QuickCardValue quickCardValue) {
        String string = quickCardValue.getString();
        if (TextUtils.isEmpty(string)) {
            string = "left";
        }
        string.hashCode();
        char c4 = 65535;
        int i10 = 5;
        switch (string.hashCode()) {
            case -1364013995:
                if (string.equals(CSSAlignValue.AlignKey.CENTER)) {
                    c4 = 0;
                    break;
                }
                break;
            case 108511772:
                if (string.equals("right")) {
                    c4 = 1;
                    break;
                }
                break;
            case 280523342:
                if (string.equals("gravity")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1194679731:
                if (string.equals("view-end")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1344062266:
                if (string.equals("view-start")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1946980603:
                if (string.equals("inherit")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                i10 = 4;
                break;
            case 1:
                i10 = 3;
                break;
            case 2:
                i10 = 1;
                break;
            case 3:
                i10 = 6;
                break;
            case 4:
                break;
            case 5:
                i10 = 0;
                break;
            default:
                i10 = 2;
                break;
        }
        ViewUtils.dirty(textView);
        textView.setTextAlignment(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(@NonNull TextView textView, QuickCardValue quickCardValue) {
        String string = quickCardValue.getString();
        CharSequence text = textView.getText();
        if (textView instanceof IQuickText) {
            ((IQuickText) textView).setTextDecoration(string);
        }
        if (TextUtils.isEmpty(text)) {
            return;
        }
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(TextStyleUtils.getTextDecoration(string), 0, text.length(), 33);
        ViewUtils.dirty(textView);
        textView.setText(spannableString);
    }

    private void c(@NonNull TextView textView, QuickCardValue quickCardValue) {
        String string = quickCardValue.getString();
        ViewUtils.dirty(textView);
        textView.setEllipsize(Attributes.TextOverflow.ELLIPSIS.equals(string) ? TextUtils.TruncateAt.END : null);
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
        return ParserHelper.parseToString(obj, "");
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull TextView textView, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1065511464:
                if (str.equals(Attributes.Style.TEXT_ALIGN)) {
                    c4 = 0;
                    break;
                }
                break;
            case -879295043:
                if (str.equals("textDecoration")) {
                    c4 = 1;
                    break;
                }
                break;
            case 261414991:
                if (str.equals(Attributes.Style.TEXT_OVERFLOW)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                a(textView, quickCardValue);
                return;
            case 1:
                b(textView, quickCardValue);
                return;
            case 2:
                c(textView, quickCardValue);
                return;
            default:
                return;
        }
    }
}
