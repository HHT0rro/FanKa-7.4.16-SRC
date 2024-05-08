package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.appdialog.layout.FKAppRatingLayout;
import com.cupidapp.live.appdialog.model.AppDialogModel;
import com.cupidapp.live.appdialog.model.AppRatingModel;
import com.cupidapp.live.appdialog.model.RateScene;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorsLogAppRating;
import com.cupidapp.live.base.view.BaseLayout;
import e1.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.x;
import z0.y;
import z0.z;

/* compiled from: FKAppRatingLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKAppRatingLayout extends BaseLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f11658f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public static AppRatingModel f11659g;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public AlertDialog f11660d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11661e;

    /* compiled from: FKAppRatingLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final AppRatingModel a() {
            return FKAppRatingLayout.f11659g;
        }

        public final void b(@Nullable AppRatingModel appRatingModel) {
            FKAppRatingLayout.f11659g = appRatingModel;
        }

        public final void c(@Nullable List<? extends AppDialogModel> list) {
            Object obj;
            Object obj2;
            if (list != null) {
                Iterator<? extends AppDialogModel> iterator2 = list.iterator2();
                while (true) {
                    if (!iterator2.hasNext()) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = iterator2.next();
                        if (kotlin.jvm.internal.s.d(((AppDialogModel) obj2).getWindowType(), WindowType.AppRate.getType())) {
                            break;
                        }
                    }
                }
                obj = (AppDialogModel) obj2;
            } else {
                obj = null;
            }
            AppRatingModel appRatingModel = obj instanceof AppRatingModel ? (AppRatingModel) obj : null;
            if (appRatingModel != null) {
                b(appRatingModel);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAppRatingLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11661e = new LinkedHashMap();
        m();
    }

    public static final void q(RateScene rateScene, AppRatingModel appRate, FKAppRatingLayout this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(rateScene, "$rateScene");
        kotlin.jvm.internal.s.i(appRate, "$appRate");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        Disposable disposed = a.C0726a.c(NetworkClient.f11868a.i(), rateScene.getScene(), WindowType.AppRate.getType(), Long.valueOf(appRate.getRateRule()), null, null, null, null, null, null, null, 1016, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKAppRatingLayout$showAppRatingLayout$lambda$4$lambda$2$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this$0)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            this$0.H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        SensorsLogAppRating.f12207a.c(rateScene, appRate.isInternalRating());
    }

    public static final void r(FKAppRatingLayout this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        f11659g = null;
        this$0.f11660d = null;
    }

    @Nullable
    public View g(int i10) {
        Map<Integer, View> map = this.f11661e;
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

    public final void l() {
        ImageView closeAppRatingImage = (ImageView) g(R$id.closeAppRatingImage);
        kotlin.jvm.internal.s.h(closeAppRatingImage, "closeAppRatingImage");
        y.d(closeAppRatingImage, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKAppRatingLayout$bindClickEvent$1
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
                AlertDialog alertDialog;
                alertDialog = FKAppRatingLayout.this.f11660d;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                FKAppRatingLayout.this.o(SensorsLogAppRating.ButtonName.CloseButton);
            }
        });
        TextView negativeRatingButton = (TextView) g(R$id.negativeRatingButton);
        kotlin.jvm.internal.s.h(negativeRatingButton, "negativeRatingButton");
        y.d(negativeRatingButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKAppRatingLayout$bindClickEvent$2
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
                AlertDialog alertDialog;
                alertDialog = FKAppRatingLayout.this.f11660d;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                AppRatingModel a10 = FKAppRatingLayout.f11658f.a();
                if (a10 != null) {
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, FKAppRatingLayout.this.getContext(), x.a(a10.getSupportUrl(), "rate_scene", a10.getScene()), null, 4, null);
                }
                FKAppRatingLayout.this.o(SensorsLogAppRating.ButtonName.NegativeButton);
            }
        });
        TextView positiveRatingButton = (TextView) g(R$id.positiveRatingButton);
        kotlin.jvm.internal.s.h(positiveRatingButton, "positiveRatingButton");
        y.d(positiveRatingButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKAppRatingLayout$bindClickEvent$3
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
                AlertDialog alertDialog;
                String a10;
                alertDialog = FKAppRatingLayout.this.f11660d;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                FKAppRatingLayout.a aVar = FKAppRatingLayout.f11658f;
                AppRatingModel a11 = aVar.a();
                boolean z10 = a11 != null && a11.isInternalRating();
                String str = null;
                if (z10) {
                    AppRatingModel a12 = aVar.a();
                    if (a12 != null) {
                        FKAppRatingLayout fKAppRatingLayout = FKAppRatingLayout.this;
                        j.a aVar2 = com.cupidapp.live.base.router.j.f12156c;
                        Context context = fKAppRatingLayout.getContext();
                        String rateUrl = a12.getRateUrl();
                        if (rateUrl != null && (a10 = x.a(rateUrl, "rate_scene", a12.getScene())) != null) {
                            str = x.a(a10, "rate_rule", String.valueOf(a12.getRateRule()));
                        }
                        j.a.b(aVar2, context, str, null, 4, null);
                    }
                } else {
                    m1.a aVar3 = m1.a.f51796a;
                    Context context2 = FKAppRatingLayout.this.getContext();
                    kotlin.jvm.internal.s.h(context2, "context");
                    m1.a.c(aVar3, context2, null, 2, null);
                }
                FKAppRatingLayout.this.o(SensorsLogAppRating.ButtonName.PositiveButton);
            }
        });
    }

    public final void m() {
        z.a(this, R$layout.layout_app_rating, true);
        int i10 = R$id.appRatingTitle;
        ((TextView) g(i10)).getPaint().setFakeBoldText(true);
        ((TextView) g(R$id.negativeRatingButton)).getPaint().setFakeBoldText(true);
        ((TextView) g(R$id.positiveRatingButton)).getPaint().setFakeBoldText(true);
        TextView textView = (TextView) g(i10);
        AppRatingModel appRatingModel = f11659g;
        textView.setText(appRatingModel != null ? appRatingModel.getInviteText() : null);
        l();
    }

    public final void o(SensorsLogAppRating.ButtonName buttonName) {
        AppRatingModel appRatingModel = f11659g;
        if (appRatingModel != null) {
            SensorsLogAppRating.f12207a.a(buttonName.getButton(), appRatingModel.getRateScene(), appRatingModel.isInternalRating());
        }
    }

    public final void p(@NotNull final RateScene rateScene) {
        Window window;
        kotlin.jvm.internal.s.i(rateScene, "rateScene");
        final AppRatingModel appRatingModel = f11659g;
        if (appRatingModel != null && kotlin.jvm.internal.s.d(rateScene.getScene(), appRatingModel.getScene())) {
            if (!appRatingModel.isInternalRating()) {
                m1.a aVar = m1.a.f51796a;
                Context context = getContext();
                kotlin.jvm.internal.s.h(context, "context");
                if (!aVar.a(context)) {
                    return;
                }
            }
            AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
            create.setCanceledOnTouchOutside(false);
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.appdialog.layout.c
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FKAppRatingLayout.q(RateScene.this, appRatingModel, this, dialogInterface);
                }
            });
            create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.appdialog.layout.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FKAppRatingLayout.r(FKAppRatingLayout.this, dialogInterface);
                }
            });
            this.f11660d = create;
            create.show();
            AlertDialog alertDialog = this.f11660d;
            if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
                return;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_scale_in_alpha_out_anim);
            window.setLayout(-1, -2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAppRatingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11661e = new LinkedHashMap();
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAppRatingLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11661e = new LinkedHashMap();
        m();
    }
}
