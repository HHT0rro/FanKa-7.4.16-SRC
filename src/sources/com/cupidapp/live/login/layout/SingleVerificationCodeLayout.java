package com.cupidapp.live.login.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: SingleVerificationCodeLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SingleVerificationCodeLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16194b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleVerificationCodeLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16194b = new LinkedHashMap();
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16194b;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b() {
        z.a(this, R$layout.layout_single_verification_code, true);
        ((TextView) a(R$id.single_code_text)).getPaint().setFakeBoldText(true);
    }

    public final void setCodeText(@Nullable Character ch) {
        if (ch == null) {
            ((TextView) a(R$id.single_code_text)).setText((CharSequence) null);
        } else {
            ((TextView) a(R$id.single_code_text)).setText(ch.toString());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleVerificationCodeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16194b = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleVerificationCodeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16194b = new LinkedHashMap();
        b();
    }
}
