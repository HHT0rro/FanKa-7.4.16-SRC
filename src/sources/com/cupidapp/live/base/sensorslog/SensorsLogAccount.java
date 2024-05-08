package com.cupidapp.live.base.sensorslog;

import com.cupidapp.live.base.safe.c;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.login.helper.LoginMethod;
import com.cupidapp.live.login.helper.OnePassLoginStage;
import com.inno.innosdk.pb.InnoMain;
import com.irisdt.client.login.LoginAndRegisterProtos;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z3.e;

/* compiled from: SensorsLogAccount.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SensorsLogAccount {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SensorsLogAccount f12205a = new SensorsLogAccount();

    /* compiled from: SensorsLogAccount.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum LoginRegisterLoginSuccessType {
        Account(InnoMain.INNO_KEY_ACCOUNT),
        Phone("phone");


        @NotNull
        private final String value;

        LoginRegisterLoginSuccessType(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: SensorsLogAccount.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12206a;

        static {
            int[] iArr = new int[LoginMethod.values().length];
            try {
                iArr[LoginMethod.OneClickLogin.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f12206a = iArr;
        }
    }

    public final void a(@NotNull String serviceType, boolean z10, @Nullable String str) {
        s.i(serviceType, "serviceType");
        e.f54837a.c(z10, str);
    }

    public final void b(@NotNull LoginRegisterLoginSuccessType type, @Nullable String str, @Nullable String str2, @NotNull String loginMethod) {
        s.i(type, "type");
        s.i(loginMethod, "loginMethod");
        e.f54837a.f(type.getValue(), str, str2, loginMethod);
    }

    public final void c(@Nullable String str, @Nullable String str2) {
        e.f54837a.g(str, str2);
    }

    public final void d(@NotNull String account) {
        s.i(account, "account");
        e.f54837a.h(account);
    }

    public final void e(@Nullable String str) {
        if (str == null) {
            return;
        }
        e.f54837a.i(str);
    }

    public final void f(@Nullable String str) {
        if (str == null) {
            return;
        }
        e.f54837a.j(str);
    }

    public final void g(@Nullable String str) {
        if (str == null) {
            return;
        }
        e.f54837a.k(str);
    }

    public final void h(@Nullable String str) {
        SensorsLogKeyButtonClick.VerifySMSLogin.InvalidNumber.click();
        if (str != null) {
            e.f54837a.n(str);
        }
    }

    public final void i(@NotNull String phone) {
        s.i(phone, "phone");
        e.f54837a.o(phone);
    }

    public final void j(@Nullable String str) {
        if (str == null) {
            return;
        }
        e.f54837a.p(str);
    }

    public final void k(@Nullable String str) {
        SensorsLogKeyButtonClick.VerifySMSLogin.UsePasswordLogin.click();
        if (str != null) {
            e.f54837a.q(str);
        }
    }

    public final void l(@Nullable String str, @Nullable LoginMethod loginMethod) {
        LoginAndRegisterProtos.Enum_type enum_type;
        if ((loginMethod == null ? -1 : a.f12206a[loginMethod.ordinal()]) == 1) {
            enum_type = LoginAndRegisterProtos.Enum_type.ONE_CLICK_REGISTRATION;
        } else {
            enum_type = LoginAndRegisterProtos.Enum_type.MOBILE_REGISTRATION;
        }
        e.f54837a.C(str, enum_type);
        c.f12183a.g(2);
    }

    public final void m(@Nullable String str, @NotNull String sensorProcessType, @NotNull OnePassLoginStage stage) {
        s.i(sensorProcessType, "sensorProcessType");
        s.i(stage, "stage");
        e.f54837a.D(sensorProcessType, str, stage);
    }
}
