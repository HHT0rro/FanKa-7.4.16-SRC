package com.cupidapp.live.login.layout;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.safe.e;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.h0;
import com.cupidapp.live.base.view.button.FKWithLoadingUniversalButton;
import com.cupidapp.live.base.view.dialog.FKBottomLoft;
import com.cupidapp.live.login.helper.LoginMethod;
import com.cupidapp.live.login.helper.SignInResultHelper;
import com.cupidapp.live.mediapicker.view.CustomAnimationLayout;
import com.cupidapp.live.profile.model.User;
import e1.b;
import j1.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: QuickLoginLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class QuickLoginLayout extends CustomAnimationLayout implements LifecycleObserver {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f16187f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static boolean f16188g = true;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final SignInResultHelper f16189c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public b f16190d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16191e;

    /* compiled from: QuickLoginLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return QuickLoginLayout.f16188g;
        }

        public final void b(boolean z10) {
            QuickLoginLayout.f16188g = z10;
        }
    }

    /* compiled from: QuickLoginLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a();
    }

    /* compiled from: QuickLoginLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends h0 {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f16193c;

        public c(int i10) {
            this.f16193c = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, QuickLoginLayout.this.getContext(), PrivacyPermissionLayout.f16177e.a().get(this.f16193c), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickLoginLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16191e = new LinkedHashMap();
        this.f16189c = new SignInResultHelper();
        m();
    }

    private final CharSequence getProtocol() {
        SpannableStringBuilder c4;
        int i10 = 0;
        List o10 = kotlin.collections.s.o(getContext().getString(R$string.user_agreement), getContext().getString(R$string.privacy_policy));
        ArrayList arrayList = new ArrayList();
        for (Object obj : o10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            arrayList.add(new c(i10));
            i10 = i11;
        }
        q1.d dVar = q1.d.f53006a;
        String string = getContext().getString(R$string.login_and_register_protocol_prompt);
        s.h(string, "context.getString(R.stri…register_protocol_prompt)");
        c4 = dVar.c(string, o10, (r18 & 4) != 0 ? null : -8618884, (r18 & 8) != 0 ? null : null, (r18 & 16) != 0 ? false : true, (r18 & 32) != 0 ? null : arrayList, (r18 & 64) != 0 ? null : null);
        return c4;
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f16191e;
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

    public final void k(final User user) {
        FKWithLoadingUniversalButton quick_login_btn = (FKWithLoadingUniversalButton) f(R$id.quick_login_btn);
        s.h(quick_login_btn, "quick_login_btn");
        y.d(quick_login_btn, new Function1<View, p>() { // from class: com.cupidapp.live.login.layout.QuickLoginLayout$bindClickEvent$1
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
                i.f50236a.a(PopupName.CONVENIENT_LOG_IN, PopupButtonName.LOG_THIS_ACCOUNT, SensorPosition.Welcome);
                QuickLoginLayout.this.o(true, user);
            }
        });
        TextView other_login_btn = (TextView) f(R$id.other_login_btn);
        s.h(other_login_btn, "other_login_btn");
        y.d(other_login_btn, new Function1<View, p>() { // from class: com.cupidapp.live.login.layout.QuickLoginLayout$bindClickEvent$2
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
                i.f50236a.a(PopupName.CONVENIENT_LOG_IN, PopupButtonName.OTHERS_WAY_CLICK, SensorPosition.Welcome);
                QuickLoginLayout.this.o(false, user);
            }
        });
        ImageView quick_login_agree_img = (ImageView) f(R$id.quick_login_agree_img);
        s.h(quick_login_agree_img, "quick_login_agree_img");
        y.d(quick_login_agree_img, new Function1<View, p>() { // from class: com.cupidapp.live.login.layout.QuickLoginLayout$bindClickEvent$3
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
                ((ImageView) QuickLoginLayout.this.f(R$id.quick_login_agree_img)).setSelected(!((ImageView) QuickLoginLayout.this.f(r0)).isSelected());
            }
        });
    }

    public final void l(@NotNull Lifecycle lifecycle, @NotNull User user, @NotNull b listener) {
        s.i(lifecycle, "lifecycle");
        s.i(user, "user");
        s.i(listener, "listener");
        this.f16190d = listener;
        Property<View, Float> ALPHA = View.ALPHA;
        s.h(ALPHA, "ALPHA");
        e(ALPHA);
        lifecycle.addObserver(this);
        ImageLoaderView quick_login_avatar_img = (ImageLoaderView) f(R$id.quick_login_avatar_img);
        s.h(quick_login_avatar_img, "quick_login_avatar_img");
        ImageLoaderView.g(quick_login_avatar_img, user.getAvatarImage(), null, null, 6, null);
        ((TextView) f(R$id.quick_login_user_name_text)).setText(user.getName());
        int i10 = R$id.quick_login_protocol_text;
        ((TextView) f(i10)).setText(getProtocol());
        ((TextView) f(i10)).setMovementMethod(LinkMovementMethod.getInstance());
        TextView other_login_btn = (TextView) f(R$id.other_login_btn);
        s.h(other_login_btn, "other_login_btn");
        u.a(other_login_btn);
        k(user);
        i.g(i.f50236a, PopupName.CONVENIENT_LOG_IN, SensorPosition.Welcome, null, 4, null);
    }

    public final void m() {
        z.a(this, R$layout.layout_quick_login, true);
    }

    public final void o(final boolean z10, final User user) {
        if (((ImageView) f(R$id.quick_login_agree_img)).isSelected()) {
            p(z10, user);
        } else {
            FKBottomLoft.h(FKBottomLoft.f12709e.a(getContext()), getProtocol(), 0, 0, 6, null).k(R$string.agree_and_continue, new Function0<p>() { // from class: com.cupidapp.live.login.layout.QuickLoginLayout$judgmentBeforeLogin$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    i.f50236a.a(PopupName.CONVENIENT_AGREEMENT_PRIVACY, PopupButtonName.Agree, SensorPosition.Welcome);
                    ((ImageView) QuickLoginLayout.this.f(R$id.quick_login_agree_img)).setSelected(true);
                    QuickLoginLayout.this.p(z10, user);
                }
            }).n();
            i.g(i.f50236a, PopupName.CONVENIENT_AGREEMENT_PRIVACY, SensorPosition.Welcome, null, 4, null);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        ((FKWithLoadingUniversalButton) f(R$id.quick_login_btn)).c();
    }

    public final void p(boolean z10, User user) {
        Context context = getContext();
        if (z10 && (context instanceof FKBaseActivity)) {
            this.f16189c.f((FKBaseActivity) context, b.a.a(NetworkClient.f11868a.J(), null, null, null, e.f12185a.a(), null, user.userId(), false, 87, null), LoginMethod.CONVENIENT, (r16 & 8) != 0 ? null : null, (r16 & 16) != 0 ? null : new Function0<p>() { // from class: com.cupidapp.live.login.layout.QuickLoginLayout$login$1$1
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
                    ((FKWithLoadingUniversalButton) QuickLoginLayout.this.f(R$id.quick_login_btn)).f();
                }
            }, (r16 & 32) != 0 ? null : new Function1<Boolean, p>() { // from class: com.cupidapp.live.login.layout.QuickLoginLayout$login$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(boolean z11) {
                    if (z11) {
                        ((FKWithLoadingUniversalButton) QuickLoginLayout.this.f(R$id.quick_login_btn)).c();
                    }
                }
            });
        } else {
            b bVar = this.f16190d;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickLoginLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16191e = new LinkedHashMap();
        this.f16189c = new SignInResultHelper();
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickLoginLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16191e = new LinkedHashMap();
        this.f16189c = new SignInResultHelper();
        m();
    }
}
