package com.huawei.quickcard;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import androidx.annotation.RequiresApi;
import com.huawei.quickcard.utils.SystemUtils;
import com.huawei.quickcard.views.text.utils.TextStyleUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i0 extends CharacterStyle {

    /* renamed from: d, reason: collision with root package name */
    private static final float f34024d = -0.25f;

    /* renamed from: e, reason: collision with root package name */
    private static final int f34025e = 400;

    /* renamed from: a, reason: collision with root package name */
    private final Typeface f34026a;

    /* renamed from: b, reason: collision with root package name */
    private final String f34027b;

    /* renamed from: c, reason: collision with root package name */
    private final String f34028c;

    public i0(Typeface typeface, String str, String str2) {
        this.f34026a = typeface;
        this.f34027b = str;
        this.f34028c = str2;
    }

    private void a(TextPaint textPaint) {
        int fontStyle = !TextUtils.isEmpty(this.f34027b) ? TextStyleUtils.getFontStyle(this.f34027b) : 0;
        int fontWeight = !TextUtils.isEmpty(this.f34028c) ? TextStyleUtils.getFontWeight(this.f34028c) : 0;
        Typeface typeface = this.f34026a;
        textPaint.setFakeBoldText((typeface != null && typeface.isBold()) || fontWeight == 1);
        Typeface typeface2 = this.f34026a;
        if ((typeface2 != null && typeface2.isItalic()) || fontStyle == 2) {
            textPaint.setTextSkewX(f34024d);
        } else {
            textPaint.setTextSkewX(0.0f);
        }
        Typeface typeface3 = this.f34026a;
        if (typeface3 != null) {
            textPaint.setTypeface(typeface3);
        }
    }

    @RequiresApi(api = 28)
    private void b(TextPaint textPaint) {
        int i10;
        int i11;
        Typeface typeface = this.f34026a;
        if (typeface != null) {
            i11 = typeface.getStyle();
            i10 = this.f34026a.getWeight();
        } else {
            i10 = 400;
            i11 = 0;
        }
        if (!TextUtils.isEmpty(this.f34027b)) {
            i11 = TextStyleUtils.getFontStyle(this.f34027b);
        }
        if (!TextUtils.isEmpty(this.f34028c)) {
            i10 = TextStyleUtils.getFontWeight(this.f34028c);
        }
        if (i11 == 2) {
            textPaint.setTextSkewX(f34024d);
        } else {
            textPaint.setTextSkewX(0.0f);
        }
        textPaint.setTypeface(Typeface.create(this.f34026a, i10, i11 == 2));
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (SystemUtils.isOverAPI28()) {
            b(textPaint);
        } else {
            a(textPaint);
        }
    }
}
