package com.cupidapp.live.liveshow.view.comment;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.utils.i;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveCommentGuideType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.track.group.GroupLiveLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: LiveAlohaActorGuideLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveAlohaActorGuideLayout extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f15382f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f15383b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AlertDialog f15384c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final Lazy f15385d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15386e;

    /* compiled from: LiveAlohaActorGuideLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull Function0<p> alohaCallback) {
            s.i(alohaCallback, "alohaCallback");
            if (context == null) {
                return;
            }
            new LiveAlohaActorGuideLayout(context).e(alohaCallback);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAlohaActorGuideLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15386e = new LinkedHashMap();
        this.f15385d = kotlin.c.b(LiveAlohaActorGuideLayout$countDownTimer$2.INSTANCE);
        d();
    }

    private final i getCountDownTimer() {
        return (i) this.f15385d.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15386e;
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

    public final void d() {
        z.a(this, R$layout.layout_live_aloha_actor_guide, true);
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            ImageLoaderView actor_avatar_imageview = (ImageLoaderView) a(R$id.actor_avatar_imageview);
            s.h(actor_avatar_imageview, "actor_avatar_imageview");
            ImageLoaderView.g(actor_avatar_imageview, liveShowModel.getUser().getAvatarImage(), null, null, 6, null);
        }
        FKUniversalButton aloha_actor_button = (FKUniversalButton) a(R$id.aloha_actor_button);
        s.h(aloha_actor_button, "aloha_actor_button");
        y.d(aloha_actor_button, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.comment.LiveAlohaActorGuideLayout$initView$2
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
                AlertDialog alertDialog;
                Function0 function0;
                alertDialog = LiveAlohaActorGuideLayout.this.f15384c;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                function0 = LiveAlohaActorGuideLayout.this.f15383b;
                if (function0 != null) {
                    function0.invoke();
                }
                GroupLiveLog.f18698a.F(LiveCommentGuideType.AlohaAlertType);
            }
        });
    }

    public final void e(@NotNull Function0<p> alohaCallback) {
        Window window;
        s.i(alohaCallback, "alohaCallback");
        this.f15383b = alohaCallback;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f15384c = create;
        if (create != null) {
            create.show();
        }
        AlertDialog alertDialog = this.f15384c;
        if (alertDialog != null && (window = alertDialog.getWindow()) != null) {
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
        i.d(getCountDownTimer(), 3, 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.comment.LiveAlohaActorGuideLayout$showGuide$2
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
                AlertDialog alertDialog2;
                alertDialog2 = LiveAlohaActorGuideLayout.this.f15384c;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
            }
        }, null, 8, null);
        GroupLiveLog.f18698a.G(LiveCommentGuideType.AlohaAlertType);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getCountDownTimer().g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAlohaActorGuideLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15386e = new LinkedHashMap();
        this.f15385d = kotlin.c.b(LiveAlohaActorGuideLayout$countDownTimer$2.INSTANCE);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAlohaActorGuideLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15386e = new LinkedHashMap();
        this.f15385d = kotlin.c.b(LiveAlohaActorGuideLayout$countDownTimer$2.INSTANCE);
        d();
    }
}
