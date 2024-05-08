package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public View.OnClickListener f41199a;

    /* renamed from: b, reason: collision with root package name */
    public int f41200b;

    public d(View.OnClickListener onClickListener, int i10) {
        this.f41199a = onClickListener;
        this.f41200b = i10;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        this.f41199a.onClick(view);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f41200b);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
