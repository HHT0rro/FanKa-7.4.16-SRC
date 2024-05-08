package com.cupidapp.live.profile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.y;
import z0.z;

/* compiled from: FriendPraiseEmptyLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FriendPraiseEmptyLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17860b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendPraiseEmptyLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f17860b = new LinkedHashMap();
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17860b;
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
        z.a(this, R$layout.layout_friend_praise_empty, true);
    }

    public final void c(@StringRes int i10) {
        ((Group) a(R$id.empty_received_group)).setVisibility(8);
        ((Group) a(R$id.empty_send_group)).setVisibility(0);
        ((TextView) a(R$id.empty_send_text)).setText(getContext().getString(i10));
    }

    public final void d(boolean z10, @NotNull final Function0<p> clickShareBtnCallback) {
        s.i(clickShareBtnCallback, "clickShareBtnCallback");
        if (z10) {
            ((Group) a(R$id.empty_received_group)).setVisibility(0);
            ((Group) a(R$id.empty_send_group)).setVisibility(8);
            ImageLoaderView empty_received_avatar_img = (ImageLoaderView) a(R$id.empty_received_avatar_img);
            s.h(empty_received_avatar_img, "empty_received_avatar_img");
            User X = g.f52734a.X();
            ImageLoaderView.g(empty_received_avatar_img, X != null ? X.getAvatarImage() : null, null, null, 6, null);
            FKUniversalButton empty_received_invite_btn = (FKUniversalButton) a(R$id.empty_received_invite_btn);
            s.h(empty_received_invite_btn, "empty_received_invite_btn");
            y.d(empty_received_invite_btn, new Function1<View, p>() { // from class: com.cupidapp.live.profile.view.FriendPraiseEmptyLayout$showFriendPraiseEmptyLayout$1
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
                    clickShareBtnCallback.invoke();
                }
            });
            return;
        }
        ((Group) a(R$id.empty_received_group)).setVisibility(8);
        ((Group) a(R$id.empty_send_group)).setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendPraiseEmptyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f17860b = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendPraiseEmptyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17860b = new LinkedHashMap();
        b();
    }
}
