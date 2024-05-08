package com.cupidapp.live.maskparty.view.script;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.maskparty.model.GuessIdentityModel;
import com.cupidapp.live.maskparty.model.IdentityModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: RevealedIdentityLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class RevealedIdentityLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super IdentityModel, p> f16467b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16468c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevealedIdentityLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16468c = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16468c;
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

    public final void b(@NotNull GuessIdentityModel identity) {
        s.i(identity, "identity");
        ((TextView) a(R$id.revealed_identity_content_textview)).setText(identity.getQuestion());
        ((LinearLayout) a(R$id.answer_layout)).removeAllViews();
        int i10 = 0;
        for (IdentityModel identityModel : identity.getOptions()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            final IdentityModel identityModel2 = identityModel;
            final TextView textView = new TextView(getContext());
            textView.setText(identityModel2.getIdentityInfo());
            textView.setTextSize(16.0f);
            textView.setTextColor(-15066598);
            textView.setGravity(17);
            textView.setBackgroundResource(R$drawable.script_options_selector);
            textView.setPadding(0, h.c(textView, 10.0f), 0, h.c(textView, 10.0f));
            y.d(textView, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.script.RevealedIdentityLayout$configIdentityLayout$1$answerView$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    TextView.this.setSelected(true);
                    TextView.this.getPaint().setFakeBoldText(true);
                    TextView.this.setTextColor(-49088);
                    Function1<IdentityModel, p> selectIdentityCallback = this.getSelectIdentityCallback();
                    if (selectIdentityCallback != null) {
                        selectIdentityCallback.invoke(identityModel2);
                    }
                }
            });
            ((LinearLayout) a(R$id.answer_layout)).addView(textView, new LinearLayout.LayoutParams(-1, -2));
            if (i10 == 0) {
                y.l(textView, 0, 0, 0, Integer.valueOf(h.c(this, 8.0f)));
            } else if (i10 == r11.size() - 1) {
                y.l(textView, 0, Integer.valueOf(h.c(this, 8.0f)), 0, 0);
            }
            i10 = i11;
        }
    }

    public final void c() {
        z.a(this, R$layout.layout_revealed_identity, true);
        ((TextView) a(R$id.revealed_identity_content_textview)).getPaint().setFakeBoldText(true);
    }

    @Nullable
    public final Function1<IdentityModel, p> getSelectIdentityCallback() {
        return this.f16467b;
    }

    public final void setSelectIdentityCallback(@Nullable Function1<? super IdentityModel, p> function1) {
        this.f16467b = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevealedIdentityLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16468c = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevealedIdentityLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16468c = new LinkedHashMap();
        c();
    }
}
