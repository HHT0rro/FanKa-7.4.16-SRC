package com.cupidapp.live.main.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.view.View;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$string;
import com.cupidapp.live.appdialog.model.AgreementDialogModel;
import com.cupidapp.live.appdialog.model.AgreementModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.event.InvalidEvent;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import e1.a;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.i;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKUpdatePrivacyHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKUpdatePrivacyHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FKUpdatePrivacyHelper f16202a = new FKUpdatePrivacyHelper();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static AgreementDialogModel f16203b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static FKAlertDialog f16204c;

    /* compiled from: FKUpdatePrivacyHelper.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f16205b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AgreementModel f16206c;

        public a(Context context, AgreementModel agreementModel) {
            this.f16205b = context;
            this.f16206c = agreementModel;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(j.f12156c, this.f16205b, this.f16206c.getUrl(), null, 4, null);
        }
    }

    @Nullable
    public final AgreementDialogModel e() {
        return f16203b;
    }

    public final SpannableStringBuilder f(Context context, AgreementDialogModel agreementDialogModel) {
        SpannableStringBuilder c4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        for (AgreementModel agreementModel : agreementDialogModel.getReplaceTexts()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            AgreementModel agreementModel2 = agreementModel;
            arrayList.add(i10, agreementModel2.getTitle());
            arrayList2.add(i10, new a(context, agreementModel2));
            i10 = i11;
        }
        c4 = q1.d.f53006a.c(agreementDialogModel.getAgreement(), arrayList, (r18 & 4) != 0 ? null : -15066598, (r18 & 8) != 0 ? null : -1, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
        return c4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(Context context, AgreementDialogModel agreementDialogModel, SensorPosition sensorPosition) {
        i.f50236a.a(PopupName.PrivacyProvisionAlert, PopupButtonName.AgreeAndContinue, sensorPosition);
        Observable<Result<Object>> s2 = NetworkClient.f11868a.i().s(agreementDialogModel.getScene(), agreementDialogModel.getWindowType(), agreementDialogModel.getCallbackIds());
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = s2.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.main.view.FKUpdatePrivacyHelper$handleClickPositiveBtn$$inlined$handleByContext$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                FKAlertDialog fKAlertDialog;
                p1.g.f52734a.R1(Boolean.TRUE);
                FKUpdatePrivacyHelper.f16202a.j(null);
                fKAlertDialog = FKUpdatePrivacyHelper.f16204c;
                if (fKAlertDialog != null) {
                    fKAlertDialog.g();
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void h() {
        FKAlertDialog fKAlertDialog = f16204c;
        if (fKAlertDialog != null) {
            fKAlertDialog.g();
        }
        p1.g gVar = p1.g.f52734a;
        gVar.M1(true);
        gVar.R1(Boolean.FALSE);
        EventBus.c().l(new InvalidEvent());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(Context context, AgreementDialogModel agreementDialogModel, SensorPosition sensorPosition) {
        Observable c4 = a.C0726a.c(NetworkClient.f11868a.i(), agreementDialogModel.getScene(), agreementDialogModel.getWindowType(), null, null, null, agreementDialogModel.getCallbackIds(), null, null, null, null, MetricsProto.MetricsEvent.DIALOG_HANDLE_ANOMALY, null);
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = c4.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.main.view.FKUpdatePrivacyHelper$handleDialogShow$$inlined$handleByContext$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
        i.g(i.f50236a, PopupName.PrivacyProvisionAlert, sensorPosition, null, 4, null);
    }

    public final void j(@Nullable AgreementDialogModel agreementDialogModel) {
        f16203b = agreementDialogModel;
    }

    public final void k(@NotNull final Context context, @NotNull final AgreementDialogModel agreement, @NotNull final SensorPosition position) {
        s.i(context, "context");
        s.i(agreement, "agreement");
        s.i(position, "position");
        FKAlertDialog fKAlertDialog = f16204c;
        if (fKAlertDialog != null && fKAlertDialog.i()) {
            return;
        }
        f16203b = agreement;
        FKAlertDialog u10 = FKAlertDialog.w(FKAlertDialog.f12698l.b(context, false).D(R$string.agreement_update).m(f(context, agreement), true).j(false).p(false), R$string.agree_and_continue, null, new Function0<p>() { // from class: com.cupidapp.live.main.view.FKUpdatePrivacyHelper$showAgreementDialog$1
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
                FKUpdatePrivacyHelper.f16202a.g(context, agreement, position);
            }
        }, 2, null).B(R$string.disagree_and_quit_app, new Function0<p>() { // from class: com.cupidapp.live.main.view.FKUpdatePrivacyHelper$showAgreementDialog$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKUpdatePrivacyHelper.f16202a.h();
            }
        }).t(new Function0<p>() { // from class: com.cupidapp.live.main.view.FKUpdatePrivacyHelper$showAgreementDialog$3
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKUpdatePrivacyHelper.f16202a.h();
            }
        }).u(new Function0<p>() { // from class: com.cupidapp.live.main.view.FKUpdatePrivacyHelper$showAgreementDialog$4
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
                FKUpdatePrivacyHelper.f16202a.i(context, agreement, position);
            }
        });
        f16204c = u10;
        if (u10 != null) {
            FKAlertDialog.G(u10, null, 1, null);
        }
    }
}
