package com.cupidapp.live.base.utils.text;

import android.text.TextPaint;
import android.text.style.StyleSpan;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKSpannableUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FakeBoldForegroundSpan extends StyleSpan {
    public FakeBoldForegroundSpan(int i10) {
        super(i10);
    }

    @Override // android.text.style.StyleSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint ds) {
        s.i(ds, "ds");
        ds.setFakeBoldText(true);
        super.updateDrawState(ds);
    }

    @Override // android.text.style.StyleSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NotNull TextPaint paint) {
        s.i(paint, "paint");
        paint.setFakeBoldText(true);
        super.updateMeasureState(paint);
    }
}
