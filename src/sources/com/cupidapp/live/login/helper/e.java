package com.cupidapp.live.login.helper;

import android.content.Context;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.profile.model.User;
import com.huawei.quickcard.framework.bean.CardElement;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.x;

/* compiled from: LoginHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f16161a = new e();

    public final boolean a() {
        p1.g gVar = p1.g.f52734a;
        if (gVar.X() != null) {
            String G1 = gVar.G1();
            if (!(G1 == null || G1.length() == 0)) {
                return true;
            }
        }
        return false;
    }

    public final boolean b() {
        p1.g gVar = p1.g.f52734a;
        if (gVar.X() != null) {
            String G1 = gVar.G1();
            if (!(G1 == null || G1.length() == 0)) {
                User X = gVar.X();
                if ((X == null || X.getProfileIncomplete()) ? false : true) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void c(@Nullable Context context, @NotNull ForRecoverPasswordEnum ref) {
        ConstantsUrlModel urlModel;
        s.i(ref, "ref");
        ConstantsResult q10 = p1.g.f52734a.q();
        String urlLoginTrouble = (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getUrlLoginTrouble();
        if (urlLoginTrouble == null || urlLoginTrouble.length() == 0) {
            urlLoginTrouble = NetworkClient.f11868a.O() + "/user/login/trouble";
        }
        j.a.b(j.f12156c, context, x.a(urlLoginTrouble, CardElement.Field.REF, ref.getType()), null, 4, null);
    }
}
