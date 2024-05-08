package com.cupidapp.live.base.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import org.jetbrains.annotations.NotNull;

/* compiled from: NoUnderlineClickableSpan.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class h0 extends ClickableSpan {
    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint ds) {
        kotlin.jvm.internal.s.i(ds, "ds");
        ds.setUnderlineText(false);
    }
}
