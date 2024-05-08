package com.cupidapp.live.liveshow.view.liveinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.utils.e;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveTopStartPositionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveTopStartPositionLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15722b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveTopStartPositionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15722b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15722b;
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

    public final void b(@NotNull LiveShowModel model) {
        s.i(model, "model");
        String title = model.getTitle();
        if (title == null || title.length() == 0) {
            ((TextView) a(R$id.liveTitleTextView)).setVisibility(8);
            return;
        }
        ((ConstraintLayout) a(R$id.liveTopStartPositionRootLayout)).setVisibility(0);
        int i10 = R$id.liveTitleTextView;
        ((TextView) a(i10)).setVisibility(0);
        ((TextView) a(i10)).setText(getResources().getString(R$string.live_title, model.getTitle()));
        e eVar = e.f12311a;
        TextView liveTitleTextView = (TextView) a(i10);
        s.h(liveTitleTextView, "liveTitleTextView");
        eVar.a(liveTitleTextView, 5000L, 200L);
    }

    public final void c() {
        z.a(this, R$layout.layout_live_top_start_position, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.c(e.f12311a, (TextView) a(R$id.liveTitleTextView), 0, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveTopStartPositionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15722b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveTopStartPositionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15722b = new LinkedHashMap();
        c();
    }
}
