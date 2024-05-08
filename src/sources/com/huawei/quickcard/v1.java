package com.huawei.quickcard;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class v1 extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name */
    private final String f34318a;

    public v1(String str) {
        this.f34318a = str;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (TextUtils.isEmpty(this.f34318a)) {
            textPaint.setUnderlineText(false);
            textPaint.setStrikeThruText(false);
            return;
        }
        String str = this.f34318a;
        char c4 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1171789332) {
            if (hashCode != -1026963764) {
                if (hashCode == 3387192 && str.equals("none")) {
                    c4 = 2;
                }
            } else if (str.equals(Attributes.Style.UNDERLINE)) {
                c4 = 1;
            }
        } else if (str.equals("line-through")) {
            c4 = 0;
        }
        if (c4 == 0) {
            textPaint.setUnderlineText(false);
            textPaint.setStrikeThruText(true);
        } else if (c4 != 1) {
            textPaint.setUnderlineText(false);
            textPaint.setStrikeThruText(false);
        } else {
            textPaint.setUnderlineText(true);
            textPaint.setStrikeThruText(false);
        }
    }
}
