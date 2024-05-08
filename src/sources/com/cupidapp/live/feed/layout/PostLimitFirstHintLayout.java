package com.cupidapp.live.feed.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.feed.layout.PostLimitFirstHintLayout;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: PostLimitFirstHintLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitFirstHintLayout extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Companion f14548c = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14549b;

    /* compiled from: PostLimitFirstHintLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void c(Function0 showComplete, DialogInterface dialogInterface) {
            kotlin.jvm.internal.s.i(showComplete, "$showComplete");
            showComplete.invoke();
        }

        public final void b(@NotNull Context context, @NotNull final Function0<kotlin.p> showComplete) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(showComplete, "showComplete");
            p1.g gVar = p1.g.f52734a;
            Boolean j12 = gVar.j1();
            Boolean bool = Boolean.FALSE;
            if (kotlin.jvm.internal.s.d(j12, bool)) {
                showComplete.invoke();
                return;
            }
            gVar.v3(bool);
            PostLimitFirstHintLayout postLimitFirstHintLayout = new PostLimitFirstHintLayout(context);
            final AlertDialog create = z0.b.f54812a.e(context).setView(postLimitFirstHintLayout).create();
            postLimitFirstHintLayout.b(new Function0<kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitFirstHintLayout$Companion$show$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    create.dismiss();
                }
            });
            create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.feed.layout.s
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PostLimitFirstHintLayout.Companion.c(Function0.this, dialogInterface);
                }
            });
            create.setCanceledOnTouchOutside(false);
            create.show();
            Window window = create.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitFirstHintLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14549b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f14549b;
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

    public final void b(@NotNull final Function0<kotlin.p> knowClick) {
        kotlin.jvm.internal.s.i(knowClick, "knowClick");
        ImageLoaderView post_limit_first_hint_avatar_img = (ImageLoaderView) a(R$id.post_limit_first_hint_avatar_img);
        kotlin.jvm.internal.s.h(post_limit_first_hint_avatar_img, "post_limit_first_hint_avatar_img");
        User X = p1.g.f52734a.X();
        ImageLoaderView.g(post_limit_first_hint_avatar_img, X != null ? X.getAvatarImage() : null, null, null, 6, null);
        FKUniversalButton post_limit_first_hint_know_btn = (FKUniversalButton) a(R$id.post_limit_first_hint_know_btn);
        kotlin.jvm.internal.s.h(post_limit_first_hint_know_btn, "post_limit_first_hint_know_btn");
        y.d(post_limit_first_hint_know_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.feed.layout.PostLimitFirstHintLayout$configData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                knowClick.invoke();
            }
        });
    }

    public final void c() {
        z.a(this, R$layout.layout_post_limit_first_hint, true);
        FKAlertDialog.a aVar = FKAlertDialog.f12698l;
        ConstraintLayout post_limit_first_hint_root_layout = (ConstraintLayout) a(R$id.post_limit_first_hint_root_layout);
        kotlin.jvm.internal.s.h(post_limit_first_hint_root_layout, "post_limit_first_hint_root_layout");
        aVar.a(post_limit_first_hint_root_layout);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitFirstHintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14549b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostLimitFirstHintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f14549b = new LinkedHashMap();
        c();
    }
}
