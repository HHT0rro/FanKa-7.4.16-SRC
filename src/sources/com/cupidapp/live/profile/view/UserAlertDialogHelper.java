package com.cupidapp.live.profile.view;

import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.setting.activity.CustomPushActivity;
import j1.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserAlertDialogHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserAlertDialogHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final UserAlertDialogHelper f17874a = new UserAlertDialogHelper();

    public final void a(@Nullable Context context, @NotNull final SensorPosition position, @Nullable String str, @NotNull final PopupName popName, @NotNull final Function0<p> positiveClick) {
        s.i(position, "position");
        s.i(popName, "popName");
        s.i(positiveClick, "positiveClick");
        if (str == null || context == null) {
            return;
        }
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.f12698l.b(context, true).n(str).j(false), R$string.goto_manage, null, new Function0<p>() { // from class: com.cupidapp.live.profile.view.UserAlertDialogHelper$showLimitDialog$1
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
                positiveClick.invoke();
                i.f50236a.a(popName, PopupButtonName.ToManage, position);
            }
        }, 2, null).q(R$string.i_know, new Function0<p>() { // from class: com.cupidapp.live.profile.view.UserAlertDialogHelper$showLimitDialog$2
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
                i.f50236a.a(PopupName.this, PopupButtonName.I_KNOW, position);
            }
        }), null, 1, null);
        i.g(i.f50236a, popName, position, null, 4, null);
    }

    public final void b(@Nullable final Context context, @NotNull String title, @NotNull String msg, @NotNull final PopupName popupName, @NotNull final SensorPosition sensorPosition) {
        s.i(title, "title");
        s.i(msg, "msg");
        s.i(popupName, "popupName");
        s.i(sensorPosition, "sensorPosition");
        if (context == null) {
            return;
        }
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.f12698l.b(context, true).E(title).j(false).n(msg), R$string.go_to_set, null, new Function0<p>() { // from class: com.cupidapp.live.profile.view.UserAlertDialogHelper$showPushAlertDialog$1
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
                CustomPushActivity.f17944s.a(context);
                i.f50236a.a(popupName, PopupButtonName.ToSet, sensorPosition);
            }
        }, 2, null).q(R$string.no_need, new Function0<p>() { // from class: com.cupidapp.live.profile.view.UserAlertDialogHelper$showPushAlertDialog$2
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
                i.f50236a.a(PopupName.this, PopupButtonName.NoNeed, sensorPosition);
            }
        }), null, 1, null);
        i.g(i.f50236a, popupName, sensorPosition, null, 4, null);
    }
}
