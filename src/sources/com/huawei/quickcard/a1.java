package com.huawei.quickcard;

import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a1 extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    private final a f33260a;

    public a1(a aVar) {
        this.f33260a = aVar;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(@NonNull View view) {
        String href = this.f33260a.getHref();
        if (TextUtils.isEmpty(href)) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(href));
            view.getContext().startActivity(intent);
        } catch (Exception unused) {
            CardLogUtils.e("The target uri can not open in href property  of Component A !");
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        textPaint.linkColor = this.f33260a.getTextColor().intValue();
        textPaint.setUnderlineText(this.f33260a.a());
    }
}
