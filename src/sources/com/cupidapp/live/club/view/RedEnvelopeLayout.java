package com.cupidapp.live.club.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.club.model.ClubRedEnvelopeModel;
import com.cupidapp.live.club.model.OpenRedEnvelopeResult;
import com.cupidapp.live.club.model.RedPacketStatus;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: RedEnvelopeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RedEnvelopeLayout extends BaseLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f13664f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public static AlertDialog f13665g;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public AnimatorSet f13666d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13667e;

    /* compiled from: RedEnvelopeLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull ClubRedEnvelopeModel redEnvelope, @NotNull Function1<? super Integer, p> openCallback) {
            Window window;
            s.i(redEnvelope, "redEnvelope");
            s.i(openCallback, "openCallback");
            if (context == null) {
                return;
            }
            AlertDialog alertDialog = RedEnvelopeLayout.f13665g;
            if (alertDialog != null && alertDialog.isShowing()) {
                return;
            }
            RedEnvelopeLayout redEnvelopeLayout = new RedEnvelopeLayout(context);
            redEnvelopeLayout.j(redEnvelope, openCallback);
            RedEnvelopeLayout.f13665g = z0.b.f54812a.e(context).create();
            AlertDialog alertDialog2 = RedEnvelopeLayout.f13665g;
            if (alertDialog2 != null) {
                alertDialog2.show();
            }
            AlertDialog alertDialog3 = RedEnvelopeLayout.f13665g;
            if (alertDialog3 != null) {
                alertDialog3.setContentView(redEnvelopeLayout);
            }
            AlertDialog alertDialog4 = RedEnvelopeLayout.f13665g;
            if (alertDialog4 == null || (window = alertDialog4.getWindow()) == null) {
                return;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedEnvelopeLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13667e = new LinkedHashMap();
        k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(RedEnvelopeLayout redEnvelopeLayout, String str, String str2, boolean z10, Function1 function1, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            function1 = null;
        }
        redEnvelopeLayout.l(str, str2, z10, function1);
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f13667e;
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

    public final void j(final ClubRedEnvelopeModel clubRedEnvelopeModel, final Function1<? super Integer, p> function1) {
        if (clubRedEnvelopeModel.getOpened()) {
            m(this, clubRedEnvelopeModel.getClubId(), clubRedEnvelopeModel.getRedPacketId(), false, null, 8, null);
            return;
        }
        ((OpenRedEnvelopeLayout) e(R$id.open_red_envelope_layout)).e(clubRedEnvelopeModel, new Function0<p>() { // from class: com.cupidapp.live.club.view.RedEnvelopeLayout$configLayout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                RedEnvelopeLayout.this.l(clubRedEnvelopeModel.getClubId(), clubRedEnvelopeModel.getRedPacketId(), true, function1);
            }
        });
        AnimatorSet animatorSet = this.f13666d;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public final void k() {
        z.a(this, R$layout.layout_red_envelope, true);
        ImageView close_envelop_imageview = (ImageView) e(R$id.close_envelop_imageview);
        s.h(close_envelop_imageview, "close_envelop_imageview");
        y.d(close_envelop_imageview, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.RedEnvelopeLayout$initView$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog = RedEnvelopeLayout.f13665g;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this, (Property<RedEnvelopeLayout, Float>) View.SCALE_X, 0.0f, 1.1f)).with(ObjectAnimator.ofFloat(this, (Property<RedEnvelopeLayout, Float>) View.SCALE_Y, 0.0f, 1.1f));
        animatorSet.setDuration(200L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ObjectAnimator.ofFloat(this, (Property<RedEnvelopeLayout, Float>) View.SCALE_X, 1.1f, 1.0f)).with(ObjectAnimator.ofFloat(this, (Property<RedEnvelopeLayout, Float>) View.SCALE_Y, 1.1f, 1.0f));
        animatorSet2.setStartDelay(200L);
        animatorSet2.setDuration(80L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(animatorSet).with(animatorSet2);
        this.f13666d = animatorSet3;
    }

    public final void l(String str, String str2, final boolean z10, final Function1<? super Integer, p> function1) {
        ProgressBar loading_view = (ProgressBar) e(R$id.loading_view);
        s.h(loading_view, "loading_view");
        loading_view.setVisibility(0);
        Disposable disposed = NetworkClient.f11868a.u().u(str, str2).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<OpenRedEnvelopeResult, p>() { // from class: com.cupidapp.live.club.view.RedEnvelopeLayout$openRedEnvelope$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(OpenRedEnvelopeResult openRedEnvelopeResult) {
                m2514invoke(openRedEnvelopeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2514invoke(OpenRedEnvelopeResult openRedEnvelopeResult) {
                OpenRedEnvelopeResult openRedEnvelopeResult2 = openRedEnvelopeResult;
                ProgressBar loading_view2 = (ProgressBar) RedEnvelopeLayout.this.e(R$id.loading_view);
                s.h(loading_view2, "loading_view");
                loading_view2.setVisibility(8);
                if (z10) {
                    ((OpenRedEnvelopeLayout) RedEnvelopeLayout.this.e(R$id.open_red_envelope_layout)).g();
                }
                ((OpenedEnvelopeLayout) RedEnvelopeLayout.this.e(R$id.opened_red_envelope_layout)).b(openRedEnvelopeResult2);
                Function1 function12 = function1;
                if (function12 != null) {
                    function12.invoke(Integer.valueOf(RedPacketStatus.Opened.getStatus()));
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.club.view.RedEnvelopeLayout$openRedEnvelope$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                ProgressBar loading_view2 = (ProgressBar) RedEnvelopeLayout.this.e(R$id.loading_view);
                s.h(loading_view2, "loading_view");
                loading_view2.setVisibility(8);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.view.BaseLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.f13666d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedEnvelopeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13667e = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedEnvelopeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13667e = new LinkedHashMap();
        k();
    }
}
