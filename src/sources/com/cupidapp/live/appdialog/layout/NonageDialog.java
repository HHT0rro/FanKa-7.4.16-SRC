package com.cupidapp.live.appdialog.layout;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.view.View;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.activity.BindPhoneActivity;
import com.cupidapp.live.setting.helper.SwitchAccountHelper;
import com.cupidapp.live.setting.model.CheckNonageModel;
import java.util.ArrayList;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NonageDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NonageDialog {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public FKAlertDialog f11702a;

    /* compiled from: NonageDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CheckNonageModel f11703b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f11704c;

        public a(CheckNonageModel checkNonageModel, Activity activity) {
            this.f11703b = checkNonageModel;
            this.f11704c = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Boolean bindMobile;
            kotlin.jvm.internal.s.i(widget, "widget");
            CheckNonageModel checkNonageModel = this.f11703b;
            if (checkNonageModel != null ? kotlin.jvm.internal.s.d(checkNonageModel.getHasPassword(), Boolean.FALSE) : false) {
                com.cupidapp.live.base.view.h.f12779a.l(this.f11704c, R$string.set_password_first);
                return;
            }
            p1.g gVar = p1.g.f52734a;
            Boolean bool = Boolean.FALSE;
            CheckNonageModel checkNonageModel2 = this.f11703b;
            User X = gVar.X();
            gVar.V2(new Triple<>(bool, checkNonageModel2, X != null ? X.userId() : null));
            BindPhoneActivity.a aVar = BindPhoneActivity.f17923t;
            Activity activity = this.f11704c;
            CheckNonageModel checkNonageModel3 = this.f11703b;
            aVar.a(activity, (checkNonageModel3 == null || (bindMobile = checkNonageModel3.getBindMobile()) == null) ? true : bindMobile.booleanValue());
            j1.i.d(j1.i.f50236a, PopupName.NONAGE_REMIND, PopupButtonName.OTHER_NUMBER, null, 4, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (kotlin.jvm.internal.s.d(r1, r3 != null ? r3.userId() : null) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@org.jetbrains.annotations.NotNull final com.cupidapp.live.base.activity.FKBaseActivity r6) {
        /*
            r5 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.s.i(r6, r0)
            p1.g r0 = p1.g.f52734a
            com.cupidapp.live.profile.model.User r1 = r0.X()
            if (r1 != 0) goto Le
            return
        Le:
            kotlin.Triple r1 = r0.y0()
            r2 = 0
            if (r1 == 0) goto L1c
            java.lang.Object r1 = r1.getThird()
            java.lang.String r1 = (java.lang.String) r1
            goto L1d
        L1c:
            r1 = r2
        L1d:
            if (r1 == 0) goto L3f
            kotlin.Triple r1 = r0.y0()
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r1.getThird()
            java.lang.String r1 = (java.lang.String) r1
            goto L2d
        L2c:
            r1 = r2
        L2d:
            com.cupidapp.live.profile.model.User r3 = r0.X()
            if (r3 == 0) goto L38
            java.lang.String r3 = r3.userId()
            goto L39
        L38:
            r3 = r2
        L39:
            boolean r1 = kotlin.jvm.internal.s.d(r1, r3)
            if (r1 != 0) goto L42
        L3f:
            r0.V2(r2)
        L42:
            boolean r1 = r6 instanceof com.cupidapp.live.base.web.activity.FKBaseWebActivity
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L4c
            boolean r1 = r6 instanceof com.cupidapp.live.setting.activity.BindPhoneActivity
            if (r1 == 0) goto L64
        L4c:
            kotlin.Triple r1 = r0.y0()
            if (r1 == 0) goto L60
            java.lang.Object r1 = r1.getFirst()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L60
            r1 = 1
            goto L61
        L60:
            r1 = 0
        L61:
            if (r1 == 0) goto L64
            return
        L64:
            kotlin.Triple r1 = r0.y0()
            if (r1 == 0) goto L77
            java.lang.Object r1 = r1.getFirst()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != r3) goto L77
            goto L78
        L77:
            r3 = 0
        L78:
            if (r3 == 0) goto L8b
            kotlin.Triple r0 = r0.y0()
            if (r0 == 0) goto L87
            java.lang.Object r0 = r0.getSecond()
            r2 = r0
            com.cupidapp.live.setting.model.CheckNonageModel r2 = (com.cupidapp.live.setting.model.CheckNonageModel) r2
        L87:
            r5.c(r2, r6)
            goto Ld4
        L8b:
            com.cupidapp.live.base.network.NetworkClient r0 = com.cupidapp.live.base.network.NetworkClient.f11868a
            e1.a r0 = r0.i()
            io.reactivex.Observable r0 = r0.d()
            com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2 r1 = new kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Boolean>() { // from class: com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2
                static {
                    /*
                        com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2 r0 = new com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2) com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2.INSTANCE com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ java.lang.Boolean invoke(java.lang.Throwable r1) {
                    /*
                        r0 = this;
                        java.lang.Throwable r1 = (java.lang.Throwable) r1
                        java.lang.Boolean r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2.invoke(java.lang.Object):java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function1
                @org.jetbrains.annotations.NotNull
                public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull java.lang.Throwable r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.s.i(r2, r0)
                        p1.g r2 = p1.g.f52734a
                        r0 = 0
                        r2.V2(r0)
                        java.lang.Boolean r2 = java.lang.Boolean.FALSE
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$2.invoke(java.lang.Throwable):java.lang.Boolean");
                }
            }
            boolean r3 = r6 instanceof com.cupidapp.live.base.network.g
            if (r3 == 0) goto L9c
            r2 = r6
        L9c:
            com.cupidapp.live.base.network.i r3 = new com.cupidapp.live.base.network.i
            r3.<init>()
            io.reactivex.Observable r0 = r0.flatMap(r3)
            io.reactivex.Scheduler r3 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Observable r0 = r0.observeOn(r3)
            com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$$inlined$handleByContext$1 r3 = new com.cupidapp.live.appdialog.layout.NonageDialog$checkShowNonageDialog$$inlined$handleByContext$1
            r3.<init>()
            com.cupidapp.live.base.network.e r6 = new com.cupidapp.live.base.network.e
            r6.<init>(r3)
            com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2 r3 = new com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2
            r3.<init>(r1, r2)
            com.cupidapp.live.base.network.e r1 = new com.cupidapp.live.base.network.e
            r1.<init>(r3)
            io.reactivex.disposables.Disposable r6 = r0.subscribe(r6, r1)
            java.lang.String r0 = "disposed"
            if (r6 == 0) goto Ld1
            kotlin.jvm.internal.s.h(r6, r0)
            if (r2 == 0) goto Ld1
            r2.H(r6)
        Ld1:
            kotlin.jvm.internal.s.h(r6, r0)
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.appdialog.layout.NonageDialog.a(com.cupidapp.live.base.activity.FKBaseActivity):void");
    }

    public final SpannableStringBuilder b(Activity activity, CheckNonageModel checkNonageModel) {
        SpannableStringBuilder c4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(checkNonageModel, activity));
        q1.d dVar = q1.d.f53006a;
        String string = activity.getString(R$string.nonage_tip);
        kotlin.jvm.internal.s.h(string, "activity.getString(R.string.nonage_tip)");
        String string2 = activity.getString(R$string.nonage_tip_clickable);
        kotlin.jvm.internal.s.h(string2, "activity.getString(R.string.nonage_tip_clickable)");
        c4 = dVar.c(string, kotlin.collections.s.o(string2), (r18 & 4) != 0 ? null : -49088, (r18 & 8) != 0 ? null : 0, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList, (r18 & 64) != 0 ? null : null);
        return c4;
    }

    public final void c(final CheckNonageModel checkNonageModel, final FKBaseActivity fKBaseActivity) {
        String jumpUrl = checkNonageModel != null ? checkNonageModel.getJumpUrl() : null;
        if (jumpUrl == null || jumpUrl.length() == 0) {
            FKAlertDialog fKAlertDialog = this.f11702a;
            if (fKAlertDialog != null) {
                fKAlertDialog.g();
            }
            this.f11702a = null;
            return;
        }
        FKAlertDialog fKAlertDialog2 = this.f11702a;
        if (fKAlertDialog2 != null && fKAlertDialog2.i()) {
            return;
        }
        FKAlertDialog fKAlertDialog3 = this.f11702a;
        if (fKAlertDialog3 != null) {
            fKAlertDialog3.g();
        }
        FKAlertDialog q10 = FKAlertDialog.w(FKAlertDialog.f12698l.b(fKBaseActivity, true).m(b(fKBaseActivity, checkNonageModel), true).p(false).j(false), 2131886528, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.NonageDialog$showNonageDialog$1
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
                p1.g gVar = p1.g.f52734a;
                Boolean bool = Boolean.FALSE;
                CheckNonageModel checkNonageModel2 = CheckNonageModel.this;
                User X = gVar.X();
                gVar.V2(new Triple<>(bool, checkNonageModel2, X != null ? X.userId() : null));
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                FKBaseActivity fKBaseActivity2 = fKBaseActivity;
                CheckNonageModel checkNonageModel3 = CheckNonageModel.this;
                j.a.b(aVar, fKBaseActivity2, checkNonageModel3 != null ? checkNonageModel3.getJumpUrl() : null, null, 4, null);
                j1.i.d(j1.i.f50236a, PopupName.NONAGE_REMIND, PopupButtonName.Confirm, null, 4, null);
            }
        }, 2, null).q(R$string.log_out, new Function0<kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.NonageDialog$showNonageDialog$2
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
                p1.g gVar = p1.g.f52734a;
                Boolean bool = Boolean.FALSE;
                CheckNonageModel checkNonageModel2 = CheckNonageModel.this;
                User X = gVar.X();
                gVar.V2(new Triple<>(bool, checkNonageModel2, X != null ? X.userId() : null));
                SwitchAccountHelper.f18181a.d(fKBaseActivity);
            }
        });
        this.f11702a = q10;
        if (q10 != null) {
            FKAlertDialog.G(q10, null, 1, null);
        }
        j1.i.g(j1.i.f50236a, PopupName.NONAGE_REMIND, null, null, 6, null);
    }
}
