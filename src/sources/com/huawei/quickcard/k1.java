package com.huawei.quickcard;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k1 implements LineHeightSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f34087a;

    public k1(int i10) {
        this.f34087a = i10;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i10, int i11, int i12, int i13, Paint.FontMetricsInt fontMetricsInt) {
        int i14 = this.f34087a;
        int i15 = fontMetricsInt.descent;
        int i16 = fontMetricsInt.ascent;
        int i17 = (i14 - (i15 - i16)) / 2;
        fontMetricsInt.top -= i17;
        fontMetricsInt.ascent = i16 - i17;
        fontMetricsInt.descent = i15 + i17;
        fontMetricsInt.bottom += i17;
    }
}
