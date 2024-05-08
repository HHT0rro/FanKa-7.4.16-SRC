package com.huawei.quickcard.views.text.processor;

import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.text.utils.TextStyleUtils;
import com.huawei.quickcard.views.text.view.IQuickText;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ValueAttribute implements PropertyProcessor<TextView> {
    private boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return TextUtils.isDigitsOnly(charSequence) && TextUtils.isDigitsOnly(charSequence2);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public boolean isImmediate() {
        return true;
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public boolean needRefresh() {
        return false;
    }

    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        return ParserHelper.parseToString(obj, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull TextView textView, String str, QuickCardValue quickCardValue) {
        CharSequence text = textView.getText();
        IQuickText iQuickText = (IQuickText) textView;
        String textDecoration = iQuickText.getTextDecoration();
        String string = quickCardValue.getString();
        if (TextUtils.isEmpty(string)) {
            if (!TextUtils.isEmpty(text)) {
                ViewUtils.refreshSelf(textView);
            }
            textView.setText("");
            return;
        }
        if (string.equals(text)) {
            return;
        }
        if (!TextUtils.isEmpty(textDecoration)) {
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(TextStyleUtils.getTextDecoration(textDecoration), 0, spannableString.length(), 34);
            string = spannableString;
        }
        int textLineHeight = iQuickText.getTextLineHeight();
        if (textLineHeight > 0) {
            SpannableString spannableString2 = new SpannableString(string);
            spannableString2.setSpan(TextStyleUtils.getLineHeightSpan(textLineHeight), 0, spannableString2.length(), 34);
            string = spannableString2;
        }
        textView.setText(string);
        if (iQuickText.getForceRefresh()) {
            boolean z10 = true;
            if (!TextUtils.isEmpty(text) && string.length() == text.length()) {
                z10 = true ^ a(text, string);
            }
            if (z10) {
                ViewUtils.refreshSelf(textView);
            }
        }
    }
}
