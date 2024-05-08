package com.cupidapp.live.appdialog.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.appdialog.model.AppBetaModel;
import com.cupidapp.live.appdialog.model.WindowType;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.update.FKUpdateNewVersionDownloader;
import e1.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKAppBetaDialogLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKAppBetaDialogLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11657d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAppBetaDialogLayout(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11657d = new LinkedHashMap();
        j();
    }

    public static final void l(AppBetaModel model, FKAppBetaDialogLayout this$0, SensorPosition position, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.i(model, "$model");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(position, "$position");
        Disposable disposed = a.C0726a.c(NetworkClient.f11868a.i(), model.getScene(), WindowType.TestVersion.getType(), null, null, model.getTestVersionId(), null, null, null, null, null, 1004, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKAppBetaDialogLayout$showAppBetaDialog$lambda$2$$inlined$handle$default$1
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
        j1.i.g(j1.i.f50236a, PopupName.TEST_POPUP, position, null, 4, null);
    }

    @Nullable
    public View f(int i10) {
        Map<Integer, View> map = this.f11657d;
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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
    
        if ((r0.length() > 0) == true) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(com.cupidapp.live.appdialog.model.AppBetaModel r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getTitle()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L15
            int r0 = r0.length()
            if (r0 <= 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 != r1) goto L15
            r0 = 1
            goto L16
        L15:
            r0 = 0
        L16:
            if (r0 == 0) goto L3d
            int r0 = com.cupidapp.live.R$id.appBetaTitleTextView
            android.view.View r3 = r4.f(r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setVisibility(r2)
            android.view.View r3 = r4.f(r0)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.text.TextPaint r3 = r3.getPaint()
            r3.setFakeBoldText(r1)
            android.view.View r0 = r4.f(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = r5.getTitle()
            r0.setText(r3)
        L3d:
            java.lang.String r0 = r5.getContent()
            if (r0 == 0) goto L4f
            int r0 = r0.length()
            if (r0 <= 0) goto L4b
            r0 = 1
            goto L4c
        L4b:
            r0 = 0
        L4c:
            if (r0 != r1) goto L4f
            goto L50
        L4f:
            r1 = 0
        L50:
            if (r1 == 0) goto L6c
            int r0 = com.cupidapp.live.R$id.appBetaMessageLayout
            android.view.View r0 = r4.f(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r0.setVisibility(r2)
            int r0 = com.cupidapp.live.R$id.appBetaMessageTextView
            android.view.View r0 = r4.f(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = r5.getContent()
            r0.setText(r1)
        L6c:
            java.lang.String r5 = r5.getBtnText()
            if (r5 == 0) goto L80
            int r0 = com.cupidapp.live.R$id.joinAppBetaButton
            android.view.View r0 = r4.f(r0)
            com.cupidapp.live.base.view.button.FKUniversalButton r0 = (com.cupidapp.live.base.view.button.FKUniversalButton) r0
            if (r0 != 0) goto L7d
            goto L80
        L7d:
            r0.setText(r5)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.appdialog.layout.FKAppBetaDialogLayout.h(com.cupidapp.live.appdialog.model.AppBetaModel):void");
    }

    public final void i(Activity activity, String str) {
        if (activity != null) {
            if (str == null || str.length() == 0) {
                return;
            }
            com.cupidapp.live.base.view.h.f12779a.c(getContext(), R$string.downloading);
            FKUpdateNewVersionDownloader.f18715a.c(activity, str);
        }
    }

    public final void j() {
        z.a(this, R$layout.layout_app_beta_dialog, true);
    }

    public final void k(@NotNull final AppBetaModel model, @NotNull final SensorPosition position) {
        kotlin.jvm.internal.s.i(model, "model");
        kotlin.jvm.internal.s.i(position, "position");
        h(model);
        final AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        create.setCanceledOnTouchOutside(false);
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.appdialog.layout.a
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                FKAppBetaDialogLayout.l(AppBetaModel.this, this, position, dialogInterface);
            }
        });
        create.show();
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(-1, -2);
        }
        FKUniversalButton joinAppBetaButton = (FKUniversalButton) f(R$id.joinAppBetaButton);
        kotlin.jvm.internal.s.h(joinAppBetaButton, "joinAppBetaButton");
        y.d(joinAppBetaButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKAppBetaDialogLayout$showAppBetaDialog$3
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
                FKAppBetaDialogLayout fKAppBetaDialogLayout = FKAppBetaDialogLayout.this;
                Context context = fKAppBetaDialogLayout.getContext();
                fKAppBetaDialogLayout.i(context instanceof Activity ? (Activity) context : null, model.getUrl());
                Observable<Result<Object>> j10 = NetworkClient.f11868a.i().j(model.getTestVersionId());
                FKAppBetaDialogLayout fKAppBetaDialogLayout2 = FKAppBetaDialogLayout.this;
                final AlertDialog alertDialog = create;
                Disposable disposed = j10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKAppBetaDialogLayout$showAppBetaDialog$3$invoke$$inlined$handle$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        alertDialog.dismiss();
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.appdialog.layout.FKAppBetaDialogLayout$showAppBetaDialog$3.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        kotlin.jvm.internal.s.i(it, "it");
                        alertDialog.dismiss();
                        return Boolean.FALSE;
                    }
                }, fKAppBetaDialogLayout2)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (fKAppBetaDialogLayout2 != null) {
                        fKAppBetaDialogLayout2.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
                j1.i.f50236a.a(PopupName.TEST_POPUP, PopupButtonName.Download, position);
            }
        });
        ImageView appBetaCloseImageView = (ImageView) f(R$id.appBetaCloseImageView);
        kotlin.jvm.internal.s.h(appBetaCloseImageView, "appBetaCloseImageView");
        y.d(appBetaCloseImageView, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKAppBetaDialogLayout$showAppBetaDialog$4
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
                j1.i.f50236a.a(PopupName.TEST_POPUP, PopupButtonName.Close, SensorPosition.this);
                create.dismiss();
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAppBetaDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11657d = new LinkedHashMap();
        j();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAppBetaDialogLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.s.i(context, "context");
        this.f11657d = new LinkedHashMap();
        j();
    }
}
