package com.cupidapp.live.chat.util;

import android.content.Context;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.chat.model.InboxSessionType;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.setting.activity.PrivacySettingActivity;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import com.irisdt.client.chat.ChatProtos;
import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z3.b;

/* compiled from: FKDeleteSessionUtil.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKDeleteSessionUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FKDeleteSessionUtil f13177a = new FKDeleteSessionUtil();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static Boolean f13178b = Boolean.FALSE;

    @Nullable
    public final Boolean b() {
        return f13178b;
    }

    public final void c(@Nullable Boolean bool) {
        f13178b = bool;
    }

    public final void d(@Nullable final Context context, @NotNull final PurchaseDialogManager purchaseManager, @NotNull final VipPurchaseEntranceType entranceType, @NotNull String sessionType, @Nullable final Function0<p> function0) {
        s.i(purchaseManager, "purchaseManager");
        s.i(entranceType, "entranceType");
        s.i(sessionType, "sessionType");
        if (context == null) {
            return;
        }
        Boolean bool = f13178b;
        final boolean booleanValue = bool != null ? bool.booleanValue() : false;
        ArrayList arrayList = new ArrayList();
        FKActionSheetItemModel fKActionSheetItemModel = new FKActionSheetItemModel(booleanValue ? R$string.close_view_privately : R$string.view_privately, null, null, Integer.valueOf(R$mipmap.super_aplus_logo), null, new Function0<p>() { // from class: com.cupidapp.live.chat.util.FKDeleteSessionUtil$showDeleteSessionDialog$viewPrivately$1
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
                FKDeleteSessionUtil.f13177a.e(context, purchaseManager, entranceType, booleanValue);
            }
        }, 22, null);
        FKActionSheetItemModel fKActionSheetItemModel2 = new FKActionSheetItemModel(R$string.delete, ActionSheetItemType.Warning, null, null, null, new Function0<p>() { // from class: com.cupidapp.live.chat.util.FKDeleteSessionUtil$showDeleteSessionDialog$delete$1
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
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                b.f54828a.a(ChatProtos.Enum_type.DELETE);
            }
        }, 28, null);
        if (s.d(sessionType, InboxSessionType.InboxSession.getType())) {
            arrayList.add(fKActionSheetItemModel);
        }
        arrayList.add(fKActionSheetItemModel2);
        FKActionSheetDialog.f12692f.a(context).f(arrayList).g(true).h();
    }

    public final void e(Context context, PurchaseDialogManager purchaseDialogManager, VipPurchaseEntranceType vipPurchaseEntranceType, boolean z10) {
        if (c.f17839a.d()) {
            PrivacySettingActivity.B.a(context);
        } else {
            PurchaseDialogManager.q(purchaseDialogManager, vipPurchaseEntranceType, null, null, false, false, 30, null);
        }
        b.f54828a.a(z10 ? ChatProtos.Enum_type.CLOSE : ChatProtos.Enum_type.OPEN);
    }
}
