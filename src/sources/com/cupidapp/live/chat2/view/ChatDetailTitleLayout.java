package com.cupidapp.live.chat2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.chat.view.AntiFraudTipsLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.view.SuperLikeTagView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ChatDetailTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatDetailTitleLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f13442d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public h f13443b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13444c;

    /* compiled from: ChatDetailTitleLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull String userId) {
            s.i(userId, "userId");
            return kotlin.collections.s.m("YUZzqAXuczM", "4_Hmv6KJNls", "Bax4dT3goO0").contains(userId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailTitleLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13444c = new LinkedHashMap();
        g();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13444c;
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
        ConstraintLayout chat_detail_title_root_layout = (ConstraintLayout) a(R$id.chat_detail_title_root_layout);
        s.h(chat_detail_title_root_layout, "chat_detail_title_root_layout");
        y.d(chat_detail_title_root_layout, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailTitleLayout$bindClickEvent$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
        ImageView chat_detail_back_image = (ImageView) a(R$id.chat_detail_back_image);
        s.h(chat_detail_back_image, "chat_detail_back_image");
        y.d(chat_detail_back_image, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailTitleLayout$bindClickEvent$2
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
                h hVar;
                hVar = ChatDetailTitleLayout.this.f13443b;
                if (hVar != null) {
                    hVar.a();
                }
            }
        });
        ImageLoaderView chat_detail_avatar_image = (ImageLoaderView) a(R$id.chat_detail_avatar_image);
        s.h(chat_detail_avatar_image, "chat_detail_avatar_image");
        y.d(chat_detail_avatar_image, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailTitleLayout$bindClickEvent$3
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
                h hVar;
                hVar = ChatDetailTitleLayout.this.f13443b;
                if (hVar != null) {
                    hVar.c();
                }
            }
        });
        ImageView chat_detail_more_btn = (ImageView) a(R$id.chat_detail_more_btn);
        s.h(chat_detail_more_btn, "chat_detail_more_btn");
        y.d(chat_detail_more_btn, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatDetailTitleLayout$bindClickEvent$4
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
                h hVar;
                hVar = ChatDetailTitleLayout.this.f13443b;
                if (hVar != null) {
                    hVar.b();
                }
            }
        });
    }

    public final void d(boolean z10) {
        if (z10) {
            a(R$id.chat_detail_living_bg).setBackgroundResource(R$drawable.shape_chat_living_gradient_bg);
            int i10 = R$id.chat_detail_living_svga_img;
            ((FKSVGAImageView) a(i10)).setVisibility(0);
            ((FKSVGAImageView) a(i10)).s();
            return;
        }
        a(R$id.chat_detail_living_bg).setBackgroundResource(0);
        int i11 = R$id.chat_detail_living_svga_img;
        ((FKSVGAImageView) a(i11)).setVisibility(8);
        ((FKSVGAImageView) a(i11)).w();
    }

    public final void e(@Nullable String str) {
        if (str == null || str.length() == 0) {
            ((TextView) a(R$id.chat_detail_source_desc_text)).setVisibility(8);
            return;
        }
        int i10 = R$id.chat_detail_source_desc_text;
        ((TextView) a(i10)).setText(str);
        ((TextView) a(i10)).setVisibility(0);
    }

    public final void f(@NotNull User user) {
        s.i(user, "user");
        ImageLoaderView chat_detail_avatar_image = (ImageLoaderView) a(R$id.chat_detail_avatar_image);
        s.h(chat_detail_avatar_image, "chat_detail_avatar_image");
        ImageLoaderView.g(chat_detail_avatar_image, user.getAvatarImage(), null, null, 6, null);
        ((TextView) a(R$id.chat_detail_user_name_text)).setText(user.getName());
        ((ImageView) a(R$id.chat_detail_focus_image)).setVisibility(user.getFocus() ? 0 : 8);
        String label = user.getLabel();
        if (label == null || label.length() == 0) {
            ((TextView) a(R$id.chat_detail_distance_text)).setVisibility(8);
        } else {
            int i10 = R$id.chat_detail_distance_text;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(i10)).setText(user.getLabel());
        }
        Integer superLikedMeCombos = user.getSuperLikedMeCombos();
        if ((superLikedMeCombos != null ? superLikedMeCombos.intValue() : 0) <= 0) {
            ((SuperLikeTagView) a(R$id.chat_detail_super_like_me_image)).c(0);
            ((SuperLikeTagView) a(R$id.chat_detail_super_like_image)).c(user.getSuperLikedByMeCombos());
        } else {
            ((SuperLikeTagView) a(R$id.chat_detail_super_like_me_image)).c(user.getSuperLikedMeCombos());
            ((SuperLikeTagView) a(R$id.chat_detail_super_like_image)).c(0);
        }
        ((TextView) a(R$id.chat_detail_black_list_tip)).setVisibility(user.getBlock() ? 0 : 8);
        if (f13442d.a(user.userId())) {
            ((AntiFraudTipsLayout) a(R$id.chat_detail_anti_fraud_tip)).setVisibility(8);
        } else {
            int i11 = R$id.chat_detail_anti_fraud_tip;
            if (((AntiFraudTipsLayout) a(i11)).getVisibility() != 0) {
                z3.b.f54828a.c();
            }
            ((AntiFraudTipsLayout) a(i11)).setVisibility(0);
        }
        c();
    }

    public final void g() {
        z.a(this, R$layout.layout_chat_detail_title, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((FKSVGAImageView) a(R$id.chat_detail_living_svga_img)).w();
    }

    public final void setListener(@NotNull h listener) {
        s.i(listener, "listener");
        this.f13443b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13444c = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailTitleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13444c = new LinkedHashMap();
        g();
    }
}