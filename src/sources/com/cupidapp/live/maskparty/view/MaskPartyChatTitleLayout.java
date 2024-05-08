package com.cupidapp.live.maskparty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: MaskPartyChatTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatTitleLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public User f16394b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public g f16395c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f16396d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16397e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatTitleLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16397e = new LinkedHashMap();
        this.f16396d = kotlin.c.b(MaskPartyChatTitleLayout$countDownTimer$2.INSTANCE);
        h();
    }

    private final com.cupidapp.live.base.utils.i getCountDownTimer() {
        return (com.cupidapp.live.base.utils.i) this.f16396d.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16397e;
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

    public final void c() {
        ImageView mask_party_chat_back_img = (ImageView) a(R$id.mask_party_chat_back_img);
        s.h(mask_party_chat_back_img, "mask_party_chat_back_img");
        y.d(mask_party_chat_back_img, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatTitleLayout$bindClickEvent$1
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
                g gVar;
                gVar = MaskPartyChatTitleLayout.this.f16395c;
                if (gVar != null) {
                    gVar.a();
                }
            }
        });
        TextView mask_party_chat_profile_text = (TextView) a(R$id.mask_party_chat_profile_text);
        s.h(mask_party_chat_profile_text, "mask_party_chat_profile_text");
        y.d(mask_party_chat_profile_text, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatTitleLayout$bindClickEvent$2
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
                g gVar;
                gVar = MaskPartyChatTitleLayout.this.f16395c;
                if (gVar != null) {
                    gVar.b();
                }
            }
        });
        ImageLoaderView mask_party_chat_avatar_img = (ImageLoaderView) a(R$id.mask_party_chat_avatar_img);
        s.h(mask_party_chat_avatar_img, "mask_party_chat_avatar_img");
        y.d(mask_party_chat_avatar_img, new Function1<View, p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatTitleLayout$bindClickEvent$3
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
                g gVar;
                gVar = MaskPartyChatTitleLayout.this.f16395c;
                if (gVar != null) {
                    gVar.b();
                }
            }
        });
    }

    public final void d(int i10) {
        if (i10 < 100) {
            int i11 = R$id.mask_party_chat_score_text;
            ((TextView) a(i11)).setVisibility(0);
            ((TextView) a(i11)).setText(i10 + "%");
        } else {
            ((TextView) a(R$id.mask_party_chat_score_text)).setVisibility(8);
        }
        ((ProgressBar) a(R$id.mask_party_chat_score_progress)).setProgress(i10);
    }

    public final void e(boolean z10) {
        String name;
        TextView textView = (TextView) a(R$id.mask_party_chat_label_text);
        if (z10) {
            textView.setTextColor(-8618884);
            User user = this.f16394b;
            if (user != null) {
                name = user.getLabel();
            }
            name = null;
        } else {
            textView.setTextColor(-1);
            User user2 = this.f16394b;
            if (user2 != null) {
                name = user2.getName();
            }
            name = null;
        }
        textView.setText(name);
        ImageLoaderView mask_party_chat_avatar_img = (ImageLoaderView) a(R$id.mask_party_chat_avatar_img);
        s.h(mask_party_chat_avatar_img, "mask_party_chat_avatar_img");
        User user3 = this.f16394b;
        ImageLoaderView.g(mask_party_chat_avatar_img, user3 != null ? user3.getMaskOrRealAvatarImage(z10) : null, null, null, 6, null);
        ImageView mask_party_chat_match_imageview = (ImageView) a(R$id.mask_party_chat_match_imageview);
        s.h(mask_party_chat_match_imageview, "mask_party_chat_match_imageview");
        User user4 = this.f16394b;
        mask_party_chat_match_imageview.setVisibility(user4 != null ? user4.getMatch() : false ? 0 : 8);
    }

    public final void f(@Nullable User user, boolean z10) {
        if (user == null) {
            return;
        }
        this.f16394b = user;
        e(z10);
    }

    public final void g(@NotNull String prompt) {
        s.i(prompt, "prompt");
        ((TextView) a(R$id.mask_party_chat_label_text)).setVisibility(8);
        int i10 = R$id.typing_prompt_text;
        ((TextView) a(i10)).setVisibility(0);
        ((TextView) a(i10)).setText(prompt);
        com.cupidapp.live.base.utils.i.d(getCountDownTimer(), 2, 1, new Function0<p>() { // from class: com.cupidapp.live.maskparty.view.MaskPartyChatTitleLayout$configTypingPrompt$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((TextView) MaskPartyChatTitleLayout.this.a(R$id.mask_party_chat_label_text)).setVisibility(0);
                ((TextView) MaskPartyChatTitleLayout.this.a(R$id.typing_prompt_text)).setVisibility(8);
            }
        }, null, 8, null);
    }

    public final void h() {
        z.a(this, R$layout.layout_mask_party_chat_title, true);
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getCountDownTimer().g();
    }

    public final void setCallback(@NotNull g callback) {
        s.i(callback, "callback");
        this.f16395c = callback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16397e = new LinkedHashMap();
        this.f16396d = kotlin.c.b(MaskPartyChatTitleLayout$countDownTimer$2.INSTANCE);
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16397e = new LinkedHashMap();
        this.f16396d = kotlin.c.b(MaskPartyChatTitleLayout$countDownTimer$2.INSTANCE);
        h();
    }
}
