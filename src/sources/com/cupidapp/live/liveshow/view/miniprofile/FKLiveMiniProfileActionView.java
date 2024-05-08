package com.cupidapp.live.liveshow.view.miniprofile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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

/* compiled from: FKLiveMiniProfileActionView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMiniProfileActionView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15749b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniProfileActionView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15749b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15749b;
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

    public final void b(int i10, int i11) {
        ((ImageView) a(R$id.menuActionImageView)).setImageResource(i10);
        ((TextView) a(R$id.menuActionNameView)).setText(getContext().getString(i11));
    }

    public final void c() {
        z.a(this, R$layout.layout_live_mini_profile_action_view, true);
        ((TextView) a(R$id.menuActionNameView)).getPaint().setFakeBoldText(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniProfileActionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15749b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveMiniProfileActionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15749b = new LinkedHashMap();
        c();
    }
}
