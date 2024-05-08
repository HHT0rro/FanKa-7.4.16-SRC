package com.cupidapp.live.liveshow.view.miniprofile;

import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import j1.i;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveRoomManagementHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveRoomManagementHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LiveRoomManagementHelper f15768a = new LiveRoomManagementHelper();

    public final void b(PopupName popupName, PopupButtonName popupButtonName) {
        i.f50236a.a(popupName, popupButtonName, SensorPosition.AnchorLiveShowRoom);
    }

    public final void c(PopupName popupName) {
        i.g(i.f50236a, popupName, SensorPosition.AnchorLiveShowRoom, null, 4, null);
    }

    public final void d(@Nullable Context context, boolean z10, @Nullable String str, @NotNull final Function0<p> positiveCallback) {
        String str2;
        s.i(positiveCallback, "positiveCallback");
        final PopupName popupName = z10 ? PopupName.CANCEL_BAN_SPEAK_CONFIRM : PopupName.BAN_SPEAK_CONFIRM;
        FKAlertDialog D = FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).D(z10 ? R$string.not_ban_user : R$string.ban_user);
        if (context != null) {
            str2 = context.getString(z10 ? R$string.not_ban_user_content : R$string.ban_user_content, str);
        } else {
            str2 = null;
        }
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(D.n(str2), R$string.determine, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.LiveRoomManagementHelper$showBanUserConfirmDialog$1
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
                positiveCallback.invoke();
                LiveRoomManagementHelper.f15768a.b(popupName, PopupButtonName.Confirm);
            }
        }, 2, null), 0, null, 3, null), null, 1, null);
        c(popupName);
    }

    public final void e(@Nullable Context context, @Nullable String str, @NotNull final Function0<p> positiveCallback) {
        s.i(positiveCallback, "positiveCallback");
        final PopupName popupName = PopupName.KICK_OUT_ROOM_CONFIRM;
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).D(R$string.kick_out_the_live_room).n(context != null ? context.getString(R$string.kick_out_the_live_room_content, str) : null), R$string.determine, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.LiveRoomManagementHelper$showKickOutRoomConfirmDialog$1
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
                positiveCallback.invoke();
                LiveRoomManagementHelper.f15768a.b(popupName, PopupButtonName.Confirm);
            }
        }, 2, null), 0, null, 3, null), null, 1, null);
        c(popupName);
    }

    public final void f(@Nullable Context context, boolean z10, boolean z11, boolean z12, boolean z13, @NotNull Function0<p> banUserCallback, @NotNull Function0<p> kickOutCallback, @NotNull Function0<p> setAdminCallback) {
        s.i(banUserCallback, "banUserCallback");
        s.i(kickOutCallback, "kickOutCallback");
        s.i(setAdminCallback, "setAdminCallback");
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add(new FKActionSheetItemModel(z13 ? R$string.not_ban_user : R$string.ban_user, null, null, null, null, banUserCallback, 30, null));
        }
        if (z11) {
            arrayList.add(new FKActionSheetItemModel(R$string.kick_out_the_live_room, ActionSheetItemType.Warning, null, null, null, kickOutCallback, 28, null));
        }
        if (z12) {
            arrayList.add(new FKActionSheetItemModel(R$string.set_as_admin, null, null, null, null, setAdminCallback, 30, null));
        }
        FKActionSheetDialog.f12692f.a(context).f(arrayList).h();
        c(z12 ? PopupName.MANAGE_ADMINISTRATOR : PopupName.ADMINISTRATOR_OPERATION);
    }

    public final void g(@Nullable Context context, @Nullable String str, @NotNull final Function0<p> positiveCallback) {
        s.i(positiveCallback, "positiveCallback");
        final PopupName popupName = PopupName.SET_ADMINISTRATOR_CONFIRM;
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null).D(R$string.set_administrator).n(context != null ? context.getString(R$string.set_administrator_content, str) : null), R$string.determine, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.miniprofile.LiveRoomManagementHelper$showSetAdminConfirmDialog$1
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
                positiveCallback.invoke();
                LiveRoomManagementHelper.f15768a.b(popupName, PopupButtonName.Confirm);
            }
        }, 2, null), 0, null, 3, null), null, 1, null);
        c(popupName);
    }
}
