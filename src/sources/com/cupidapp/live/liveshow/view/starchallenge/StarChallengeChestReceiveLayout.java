package com.cupidapp.live.liveshow.view.starchallenge;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.StarChallengeChestModel;
import com.cupidapp.live.liveshow.model.StarChallengeChestReceiveModel;
import com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestReceiveLayout;
import com.cupidapp.live.profile.model.User;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: StarChallengeChestReceiveLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StarChallengeChestReceiveLayout extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Companion f15900e = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Boolean f15901b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function0<p> f15902c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15903d;

    /* compiled from: StarChallengeChestReceiveLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void d(Function0 dismissCallback, DialogInterface dialogInterface) {
            s.i(dismissCallback, "$dismissCallback");
            dismissCallback.invoke();
        }

        public static final void e(SensorPosition position, DialogInterface dialogInterface) {
            s.i(position, "$position");
            i.g(i.f50236a, PopupName.TREASURE_BOX_GET, position, null, 4, null);
        }

        public final void c(@NotNull Context context, @NotNull StarChallengeChestReceiveLayout layout, @NotNull final SensorPosition position, @NotNull final Function0<p> dismissCallback) {
            s.i(context, "context");
            s.i(layout, "layout");
            s.i(position, "position");
            s.i(dismissCallback, "dismissCallback");
            final AlertDialog create = z0.b.f54812a.e(context).setView(layout).create();
            layout.setDismissCallback(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestReceiveLayout$Companion$show$1
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
                    create.dismiss();
                }
            });
            create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.liveshow.view.starchallenge.a
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    StarChallengeChestReceiveLayout.Companion.d(Function0.this, dialogInterface);
                }
            });
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.liveshow.view.starchallenge.b
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    StarChallengeChestReceiveLayout.Companion.e(SensorPosition.this, dialogInterface);
                }
            });
            create.show();
            Window window = create.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setLayout(-1, -2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarChallengeChestReceiveLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15903d = new LinkedHashMap();
        g();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15903d;
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

    public final void d(String str) {
        SpannableStringBuilder c4;
        String obj = str.length() >= 6 ? StringsKt__StringsKt.t0(str, 6, str.length(), "...").toString() : str;
        String string = getContext().getString(R$string.accept_gift_prepared_by_anchor_for_you, obj);
        s.h(string, "context.getString(R.stri…_by_anchor_for_you, name)");
        c4 = q1.d.f53006a.c(string, kotlin.collections.s.o(obj), (r18 & 4) != 0 ? null : -8951042, (r18 & 8) != 0 ? null : 0, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
        ((TextView) a(R$id.chest_receive_content_text)).setText(c4);
    }

    public final void e(@NotNull final StarChallengeChestModel chest, @NotNull final SensorPosition position) {
        String str;
        User user;
        User user2;
        s.i(chest, "chest");
        s.i(position, "position");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        ImageLoaderView chest_receive_avatar_img = (ImageLoaderView) a(R$id.chest_receive_avatar_img);
        s.h(chest_receive_avatar_img, "chest_receive_avatar_img");
        ImageLoaderView.g(chest_receive_avatar_img, (liveShowModel == null || (user2 = liveShowModel.getUser()) == null) ? null : user2.getAvatarImage(), null, null, 6, null);
        if (liveShowModel == null || (user = liveShowModel.getUser()) == null || (str = user.getName()) == null) {
            str = "";
        }
        d(str);
        FKUniversalButton chest_receive_btn = (FKUniversalButton) a(R$id.chest_receive_btn);
        s.h(chest_receive_btn, "chest_receive_btn");
        y.d(chest_receive_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestReceiveLayout$configData$1
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
                Boolean bool;
                bool = StarChallengeChestReceiveLayout.this.f15901b;
                if (s.d(bool, Boolean.TRUE)) {
                    i.f50236a.a(PopupName.TREASURE_BOX_GET, PopupButtonName.GET, position);
                    Observable<Result<StarChallengeChestReceiveModel>> o02 = NetworkClient.f11868a.r().o0(chest.getId());
                    Object context = StarChallengeChestReceiveLayout.this.getContext();
                    final StarChallengeChestReceiveLayout starChallengeChestReceiveLayout = StarChallengeChestReceiveLayout.this;
                    Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestReceiveLayout$configData$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull Throwable it) {
                            Function0 function0;
                            s.i(it, "it");
                            function0 = StarChallengeChestReceiveLayout.this.f15902c;
                            if (function0 != null) {
                                function0.invoke();
                            }
                            return Boolean.FALSE;
                        }
                    };
                    g gVar = context instanceof g ? (g) context : null;
                    Disposable disposed = o02.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<StarChallengeChestReceiveModel, p>() { // from class: com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestReceiveLayout$configData$1$invoke$$inlined$handleByContext$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ p invoke(StarChallengeChestReceiveModel starChallengeChestReceiveModel) {
                            m2659invoke(starChallengeChestReceiveModel);
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2659invoke(StarChallengeChestReceiveModel starChallengeChestReceiveModel) {
                            Function0 function0;
                            h.f12779a.m(StarChallengeChestReceiveLayout.this.getContext(), starChallengeChestReceiveModel.getMessage());
                            function0 = StarChallengeChestReceiveLayout.this.f15902c;
                            if (function0 != null) {
                                function0.invoke();
                            }
                        }
                    }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
                    if (disposed != null) {
                        s.h(disposed, "disposed");
                        if (gVar != null) {
                            gVar.H(disposed);
                        }
                    }
                    s.h(disposed, "disposed");
                }
            }
        });
    }

    public final void f(@Nullable Boolean bool, @Nullable String str) {
        if (bool != null) {
            bool.booleanValue();
            FKUniversalButton configReceiveBtnStyle$lambda$0 = (FKUniversalButton) a(R$id.chest_receive_btn);
            if (bool.booleanValue()) {
                if (!s.d(this.f15901b, Boolean.TRUE)) {
                    s.h(configReceiveBtnStyle$lambda$0, "configReceiveBtnStyle$lambda$0");
                    configReceiveBtnStyle$lambda$0.setBackground(FKUniversalButton.c(configReceiveBtnStyle$lambda$0, -8951042, 0, 0, 0, 14, null));
                    configReceiveBtnStyle$lambda$0.setTextColor(-1);
                    configReceiveBtnStyle$lambda$0.setText(configReceiveBtnStyle$lambda$0.getContext().getString(R$string.acquire));
                }
                this.f15901b = bool;
                return;
            }
            if (!s.d(this.f15901b, Boolean.FALSE)) {
                s.h(configReceiveBtnStyle$lambda$0, "configReceiveBtnStyle$lambda$0");
                configReceiveBtnStyle$lambda$0.setBackground(FKUniversalButton.c(configReceiveBtnStyle$lambda$0, com.cupidapp.live.base.utils.h.a(-8951042, 0.2f), 0, 0, 0, 14, null));
                configReceiveBtnStyle$lambda$0.setTextColor(-8951042);
            }
            configReceiveBtnStyle$lambda$0.setText(configReceiveBtnStyle$lambda$0.getContext().getString(R$string.count_down_time, str));
            this.f15901b = bool;
        }
    }

    public final void g() {
        z.a(this, R$layout.layout_star_challenge_chest_receive, true);
        FKAlertDialog.a aVar = FKAlertDialog.f12698l;
        ConstraintLayout chest_receive_root_layout = (ConstraintLayout) a(R$id.chest_receive_root_layout);
        s.h(chest_receive_root_layout, "chest_receive_root_layout");
        aVar.a(chest_receive_root_layout);
    }

    public final void setDismissCallback(@NotNull Function0<p> callback) {
        s.i(callback, "callback");
        this.f15902c = callback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarChallengeChestReceiveLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15903d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StarChallengeChestReceiveLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15903d = new LinkedHashMap();
        g();
    }
}
