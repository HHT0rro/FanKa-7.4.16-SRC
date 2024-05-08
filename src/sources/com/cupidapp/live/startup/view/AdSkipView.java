package com.cupidapp.live.startup.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.utils.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: AdSkipView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AdSkipView extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final i f18543b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18544c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSkipView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18544c = new LinkedHashMap();
        this.f18543b = new i();
        b(context);
    }

    public final void b(Context context) {
        setGravity(17);
        setTextSize(13.0f);
        setTextColor(ContextCompat.getColor(context, R$color.app_white));
        setBackground(ContextCompat.getDrawable(context, R$drawable.shape_black_30_alpha_twenty_corners_bg));
    }

    public final void c(int i10, @NotNull final Function0<p> clickCallback, @NotNull final Function0<p> finishedCallback) {
        s.i(clickCallback, "clickCallback");
        s.i(finishedCallback, "finishedCallback");
        y.d(this, new Function1<View, p>() { // from class: com.cupidapp.live.startup.view.AdSkipView$startSkipCountDown$1
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
                i iVar;
                clickCallback.invoke();
                iVar = this.f18543b;
                iVar.g();
            }
        });
        i.d(this.f18543b, Integer.valueOf(i10), 1, null, new Function1<Integer, p>() { // from class: com.cupidapp.live.startup.view.AdSkipView$startSkipCountDown$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i11) {
                AdSkipView adSkipView = AdSkipView.this;
                adSkipView.setText(adSkipView.getContext().getString(R$string.ad_skip_count, Integer.valueOf(i11)));
                if (i11 == 0) {
                    finishedCallback.invoke();
                }
            }
        }, 4, null);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f18543b.g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSkipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18544c = new LinkedHashMap();
        this.f18543b = new i();
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSkipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18544c = new LinkedHashMap();
        this.f18543b = new i();
        b(context);
    }
}
