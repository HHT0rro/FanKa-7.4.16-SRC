package com.cupidapp.live.superlike.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: MatchSuccessSuperLikeText.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchSuccessSuperLikeText extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18629b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchSuccessSuperLikeText(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18629b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18629b;
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

    public final void b(boolean z10) {
        if (z10) {
            ((TextView) a(R$id.left_super_like_text)).setText(getContext().getString(R$string.you));
            ((ImageView) a(R$id.center_super_like_me_img)).setVisibility(8);
            ((ImageView) a(R$id.center_super_like_by_me_img)).setVisibility(0);
            ((TextView) a(R$id.right_super_like_text)).setText(getContext().getString(R$string.he_like_you_too));
            return;
        }
        ((TextView) a(R$id.left_super_like_text)).setText(getContext().getString(R$string.and));
        ((ImageView) a(R$id.center_super_like_me_img)).setVisibility(0);
        ((ImageView) a(R$id.center_super_like_by_me_img)).setVisibility(8);
        ((TextView) a(R$id.right_super_like_text)).setText(getContext().getString(R$string.chat_with_him));
    }

    public final void c() {
        z.a(this, R$layout.layout_match_success_super_like_text, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchSuccessSuperLikeText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18629b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchSuccessSuperLikeText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18629b = new LinkedHashMap();
        c();
    }
}
