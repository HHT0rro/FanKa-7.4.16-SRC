package com.cupidapp.live.liveshow.view.tag;

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

/* compiled from: MarqueeView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MarqueeView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public final int f15982b;

    /* renamed from: c, reason: collision with root package name */
    public int f15983c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15984d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15984d = new LinkedHashMap();
        this.f15982b = 6;
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15984d;
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
        z.a(this, R$layout.layout_scroll_view, true);
        int i10 = R$id.textContent;
        ((TextView) a(i10)).getPaint().setFakeBoldText(true);
        this.f15983c = (int) (((TextView) a(i10)).getPaint().getTextSize() * this.f15982b);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15984d = new LinkedHashMap();
        this.f15982b = 6;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15984d = new LinkedHashMap();
        this.f15982b = 6;
        b();
    }
}
