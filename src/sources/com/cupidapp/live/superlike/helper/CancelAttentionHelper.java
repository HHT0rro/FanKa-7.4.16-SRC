package com.cupidapp.live.superlike.helper;

import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.match.model.NearbyUserProfileModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancelAttentionHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CancelAttentionHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CancelAttentionHelper f18615a = new CancelAttentionHelper();

    public final void a(@Nullable Context context, @Nullable NearbyUserProfileModel nearbyUserProfileModel, @NotNull Function0<p> confirmCallback) {
        s.i(confirmCallback, "confirmCallback");
        d(context, nearbyUserProfileModel != null ? Boolean.valueOf(nearbyUserProfileModel.getSuperLikedByMe()) : null, confirmCallback);
    }

    public final void b(@Nullable Context context, @Nullable User user, @NotNull Function0<p> confirmCallback) {
        s.i(confirmCallback, "confirmCallback");
        d(context, user != null ? Boolean.valueOf(user.getSuperLikedByMe()) : null, confirmCallback);
    }

    public final int c(@Nullable Boolean bool) {
        return s.d(bool, Boolean.TRUE) ? R$string.cancel_super_like_tip : R$string.confirm_to_cancel_follow;
    }

    public final void d(Context context, Boolean bool, final Function0<p> function0) {
        boolean d10 = s.d(bool, Boolean.TRUE);
        int i10 = d10 ? R$string.cancel_follow : 2131886528;
        int i11 = d10 ? R$string.think_again : 2131886363;
        FKAlertDialog c4 = FKAlertDialog.a.c(FKAlertDialog.f12698l, context, false, 2, null);
        if (d10) {
            c4.D(R$string.confirm_to_cancel_follow);
        }
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(c4, c(bool), 0, 2, null), i10, null, new Function0<p>() { // from class: com.cupidapp.live.superlike.helper.CancelAttentionHelper$handleCancelAttention$1
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
                function0.invoke();
            }
        }, 2, null), i11, null, 2, null), null, 1, null);
    }
}
