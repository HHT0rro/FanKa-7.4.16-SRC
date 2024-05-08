package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.dialog.FKCustomViewAlertDialog;
import com.cupidapp.live.profile.model.User;
import j1.i;
import java.util.LinkedHashMap;
import java.util.Map;
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

/* compiled from: ConsultConnectGuideLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultConnectGuideLayout extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Companion f13854e = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static FKCustomViewAlertDialog f13855f;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f13856b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function0<p> f13857c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13858d;

    /* compiled from: ConsultConnectGuideLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            FKCustomViewAlertDialog fKCustomViewAlertDialog;
            FKCustomViewAlertDialog fKCustomViewAlertDialog2 = ConsultConnectGuideLayout.f13855f;
            if (!(fKCustomViewAlertDialog2 != null && fKCustomViewAlertDialog2.g()) || (fKCustomViewAlertDialog = ConsultConnectGuideLayout.f13855f) == null) {
                return;
            }
            fKCustomViewAlertDialog.f();
        }

        public final void b(@NotNull Context context, @NotNull User user, @NotNull final Function0<p> connectCallback) {
            s.i(context, "context");
            s.i(user, "user");
            s.i(connectCallback, "connectCallback");
            FKCustomViewAlertDialog fKCustomViewAlertDialog = ConsultConnectGuideLayout.f13855f;
            boolean z10 = false;
            if (fKCustomViewAlertDialog != null && fKCustomViewAlertDialog.g()) {
                z10 = true;
            }
            if (z10) {
                return;
            }
            ConsultConnectGuideLayout consultConnectGuideLayout = new ConsultConnectGuideLayout(context);
            consultConnectGuideLayout.h(user);
            consultConnectGuideLayout.f13856b = new Function0<p>() { // from class: com.cupidapp.live.consult.view.ConsultConnectGuideLayout$Companion$showGuide$layout$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKCustomViewAlertDialog fKCustomViewAlertDialog2 = ConsultConnectGuideLayout.f13855f;
                    if (fKCustomViewAlertDialog2 != null) {
                        fKCustomViewAlertDialog2.f();
                    }
                }
            };
            consultConnectGuideLayout.f13857c = new Function0<p>() { // from class: com.cupidapp.live.consult.view.ConsultConnectGuideLayout$Companion$showGuide$layout$1$2
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
                    FKCustomViewAlertDialog fKCustomViewAlertDialog2 = ConsultConnectGuideLayout.f13855f;
                    if (fKCustomViewAlertDialog2 != null) {
                        fKCustomViewAlertDialog2.f();
                    }
                    connectCallback.invoke();
                    i.f50236a.a(PopupName.CONSULT_ROOM_CONNECT_GUIDE, PopupButtonName.Connect, SensorPosition.CONSULT_ROOM);
                }
            };
            FKCustomViewAlertDialog a10 = FKCustomViewAlertDialog.f12713e.a(context);
            ConsultConnectGuideLayout.f13855f = a10 != null ? a10.c() : null;
            FKCustomViewAlertDialog fKCustomViewAlertDialog2 = ConsultConnectGuideLayout.f13855f;
            if (fKCustomViewAlertDialog2 != null) {
                fKCustomViewAlertDialog2.i(true);
            }
            FKCustomViewAlertDialog fKCustomViewAlertDialog3 = ConsultConnectGuideLayout.f13855f;
            if (fKCustomViewAlertDialog3 != null) {
                fKCustomViewAlertDialog3.j(consultConnectGuideLayout);
            }
            FKCustomViewAlertDialog fKCustomViewAlertDialog4 = ConsultConnectGuideLayout.f13855f;
            if (fKCustomViewAlertDialog4 != null) {
                fKCustomViewAlertDialog4.k();
            }
            FKCustomViewAlertDialog fKCustomViewAlertDialog5 = ConsultConnectGuideLayout.f13855f;
            if (fKCustomViewAlertDialog5 != null) {
                FKCustomViewAlertDialog.setDialogWindow$default(fKCustomViewAlertDialog5, 0, 0, 0, 80, 7, null);
            }
            i.g(i.f50236a, PopupName.CONSULT_ROOM_CONNECT_GUIDE, SensorPosition.CONSULT_ROOM, null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultConnectGuideLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13858d = new LinkedHashMap();
        i();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13858d;
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

    public final void h(@NotNull User user) {
        s.i(user, "user");
        ImageLoaderView consult_user_avatar_img = (ImageLoaderView) a(R$id.consult_user_avatar_img);
        s.h(consult_user_avatar_img, "consult_user_avatar_img");
        ImageLoaderView.g(consult_user_avatar_img, user.getAvatarImage(), null, null, 6, null);
        ((TextView) a(R$id.consult_user_name_txt)).setText(user.getName());
    }

    public final void i() {
        z.a(this, R$layout.layout_consult_connect_guide, true);
        TextView consult_user_name_txt = (TextView) a(R$id.consult_user_name_txt);
        s.h(consult_user_name_txt, "consult_user_name_txt");
        u.a(consult_user_name_txt);
        int i10 = R$id.connect_chat_txt;
        TextView connect_chat_txt = (TextView) a(i10);
        s.h(connect_chat_txt, "connect_chat_txt");
        u.a(connect_chat_txt);
        ImageView close_guide_img = (ImageView) a(R$id.close_guide_img);
        s.h(close_guide_img, "close_guide_img");
        y.d(close_guide_img, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultConnectGuideLayout$initView$1
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
                Function0 function0;
                function0 = ConsultConnectGuideLayout.this.f13856b;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        TextView connect_chat_txt2 = (TextView) a(i10);
        s.h(connect_chat_txt2, "connect_chat_txt");
        y.d(connect_chat_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultConnectGuideLayout$initView$2
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
                Function0 function0;
                function0 = ConsultConnectGuideLayout.this.f13857c;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultConnectGuideLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13858d = new LinkedHashMap();
        i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultConnectGuideLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13858d = new LinkedHashMap();
        i();
    }
}
