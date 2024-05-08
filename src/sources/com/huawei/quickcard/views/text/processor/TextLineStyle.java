package com.huawei.quickcard.views.text.processor;

import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.b;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.k1;
import com.huawei.quickcard.utils.QuickCardValueUtil;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.views.text.utils.TextStyleUtils;
import com.huawei.quickcard.views.text.view.IQuickText;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TextLineStyle implements PropertyProcessor<TextView> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34653a = "TextLineStyle";

    /* renamed from: b, reason: collision with root package name */
    private static final int f34654b = -1;

    /* JADX WARN: Multi-variable type inference failed */
    private void a(TextView textView, QuickCardValue quickCardValue) {
        ViewUtils.dirty(textView);
        CharSequence text = textView.getText();
        if (QuickCardValueUtil.isInvalidValue(quickCardValue)) {
            a(text, textView);
            return;
        }
        int i10 = -1;
        if (quickCardValue.isDp() && quickCardValue.getDp() > 0.0f) {
            i10 = ViewUtils.dip2IntPx(textView, quickCardValue.getDp());
        }
        if (quickCardValue.isSp() && quickCardValue.getSp() > 0.0f) {
            i10 = (int) ViewUtils.sp2FloatPx(textView, quickCardValue.getSp());
        }
        if (i10 <= 0) {
            a(text, textView);
            return;
        }
        if (TextUtils.isEmpty(text)) {
            ((IQuickText) textView).setTextLineHeight(i10);
            return;
        }
        k1 lineHeightSpan = TextStyleUtils.getLineHeightSpan(i10);
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(lineHeightSpan, 0, spannableString.length(), 34);
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    private void b(TextView textView, QuickCardValue quickCardValue) {
        ViewUtils.dirty(textView);
        if (quickCardValue != null && quickCardValue.getNumber() != null) {
            int intValue = quickCardValue.getNumber().intValue();
            textView.setMaxLines(intValue >= 0 ? intValue : Integer.MAX_VALUE);
        } else {
            textView.setMaxLines(Integer.MAX_VALUE);
            CardLogUtils.w(f34653a, "value of lines is illegal!");
        }
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
        if (str.equals(Attributes.Style.LINE_HEIGHT)) {
            return ParserHelper.parseToSP(obj, -1.0f);
        }
        if (!str.equals(Attributes.Style.LINES)) {
            return QuickCardValue.EMPTY;
        }
        return ParserHelper.parseToNumber(obj, -1);
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull TextView textView, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        if (str.equals(Attributes.Style.LINE_HEIGHT)) {
            a(textView, quickCardValue);
        } else if (str.equals(Attributes.Style.LINES)) {
            b(textView, quickCardValue);
        }
    }

    private void a(CharSequence charSequence, TextView textView) {
        if (charSequence instanceof SpannableString) {
            a(k1.class, (SpannableString) charSequence);
        }
        textView.setText(charSequence, TextView.BufferType.SPANNABLE);
    }

    private void a(Class cls, SpannableString spannableString) {
        if (spannableString != null) {
            for (Object obj : spannableString.getSpans(0, spannableString.length(), cls)) {
                spannableString.removeSpan(obj);
            }
        }
    }
}
