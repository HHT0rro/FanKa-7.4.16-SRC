package z3;

import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.login.helper.LoginMethod;
import com.cupidapp.live.login.helper.OnePassLoginStage;
import com.cupidapp.live.login.model.VendorType;
import com.irisdt.client.login.LoginAndRegisterProtos;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: GroupLoginLog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f54837a = new e();

    public final void A() {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_SET_PASSWORD_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void B() {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_SET_PASSWORD_SUCCESS_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void C(@Nullable String str, @NotNull LoginAndRegisterProtos.Enum_type enumType) {
        s.i(enumType, "enumType");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_SUCCESS_REGISTER, (r38 & 2) != 0 ? null : str, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? enumType : null);
    }

    public final void D(@NotNull String processType, @Nullable String str, @NotNull OnePassLoginStage stage) {
        s.i(processType, "processType");
        s.i(stage, "stage");
        c.f54829a.x(LoginAndRegisterProtos.Event.ONE_CLICK_LOGIN_FAIL, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : stage.name(), (r38 & 64) != 0 ? null : str, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : processType, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void E(@Nullable String str) {
        LoginAndRegisterProtos.Enum_type enum_type;
        if (s.d(str, VendorType.CMCC.getVendor())) {
            enum_type = LoginAndRegisterProtos.Enum_type.CHINA_MOBILE;
        } else if (s.d(str, VendorType.CUCC.getVendor())) {
            enum_type = LoginAndRegisterProtos.Enum_type.CHINA_UNICOM;
        } else {
            enum_type = s.d(str, VendorType.CTCC.getVendor()) ? LoginAndRegisterProtos.Enum_type.CHINA_TELECOM : null;
        }
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OPERATOR_AUTH_ICON_CLICK, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? enum_type : null);
    }

    public final void F() {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_USER_AND_PRIVACY_AUTH_ICON_CLICK, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void G(boolean z10, @Nullable String str, @Nullable Long l10, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        c.f54829a.x(LoginAndRegisterProtos.Event.PUSH_OPEN_APP, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : str5, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : Boolean.valueOf(z10), (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : l10, (r38 & 4096) != 0 ? null : str, (r38 & 8192) != 0 ? null : str2, (r38 & 16384) != 0 ? null : str4, (r38 & 32768) != 0 ? null : str3, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void H() {
        c.f54829a.x(LoginAndRegisterProtos.Event.REGISTER_SUCCESS, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void I(@NotNull String targetUserId) {
        s.i(targetUserId, "targetUserId");
        c.f54829a.x(LoginAndRegisterProtos.Event.REMOVE_ACCOUNT_SUCCESS, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : targetUserId, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void J(@NotNull String targetUserId, @NotNull SensorPosition position) {
        s.i(targetUserId, "targetUserId");
        s.i(position, "position");
        c.f54829a.x(LoginAndRegisterProtos.Event.SWITCH_ACCOUNT_CLICK, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : position.getValue(), (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : targetUserId, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void a() {
        g gVar = g.f52734a;
        if (s.d(gVar.J1(), Boolean.TRUE)) {
            gVar.o2(Boolean.FALSE);
            c.f54829a.x(LoginAndRegisterProtos.Event.APP_ACTIVATION, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
        }
    }

    public final void b() {
        c.f54829a.x(LoginAndRegisterProtos.Event.FILL_IN_ACCOUNT_PAGE_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void c(boolean z10, @Nullable String str) {
        c.f54829a.x(LoginAndRegisterProtos.Event.GET_VERIFY_CODE_RESULT, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : str, (r38 & 128) != 0 ? null : Boolean.valueOf(z10), (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void d(@Nullable String str, @Nullable LoginMethod loginMethod) {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOG_IN_FAIL, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : str, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : loginMethod != null ? loginMethod.getMethod() : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void e() {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_CLICK, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void f(@NotNull String type, @Nullable String str, @Nullable String str2, @NotNull String method) {
        s.i(type, "type");
        s.i(method, "method");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_LOGIN_SUCCESS, (r38 & 2) != 0 ? null : str2, (r38 & 4) != 0 ? null : str, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : type, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : method, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void g(@Nullable String str, @Nullable String str2) {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_ONE_CLICK, (r38 & 2) != 0 ? null : str, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : str2, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void h(@NotNull String account) {
        s.i(account, "account");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_ACCOUNT_NEXT_CLICK, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : account, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void i(@NotNull String account) {
        s.i(account, "account");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_CLICK, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : account, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void j(@NotNull String account) {
        s.i(account, "account");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_ERROR_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : account, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void k(@NotNull String account) {
        s.i(account, "account");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_ACCOUNT_USE_PASSWORD_LEAST_SIX_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : account, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void l() {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_HELP_CLICK, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void m(@NotNull String accountType, @Nullable String str) {
        s.i(accountType, "accountType");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_NEXT_CLICK, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : str, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : accountType, (r38 & 131072) == 0 ? null : null);
    }

    public final void n(@NotNull String phone) {
        s.i(phone, "phone");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_PHONE_INVALID_CLICK, (r38 & 2) != 0 ? null : phone, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void o(@NotNull String phone) {
        s.i(phone, "phone");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_PHONE_NEXT_CLICK, (r38 & 2) != 0 ? null : phone, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void p(@NotNull String phone) {
        s.i(phone, "phone");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_PHONE_PASSWORD_NEXT_CLICK, (r38 & 2) != 0 ? null : phone, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void q(@NotNull String phone) {
        s.i(phone, "phone");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_PHONE_USE_PASSWORD_CLICK, (r38 & 2) != 0 ? null : phone, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void r(@NotNull String accountType, @Nullable String str) {
        s.i(accountType, "accountType");
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_USE_PASSWORD_ERROR_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : str, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : accountType, (r38 & 131072) == 0 ? null : null);
    }

    public final void s(@Nullable String str, @Nullable String str2) {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_USE_PASSWORD_FORGET_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : str2, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : str, (r38 & 131072) == 0 ? null : null);
    }

    public final void t(@Nullable String str, @Nullable String str2) {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_USE_PASSWORD_NEXT_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : str2, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : str, (r38 & 131072) == 0 ? null : null);
    }

    public final void u(@Nullable String str, @Nullable String str2) {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_USE_PASSWORD_TOO_SHORT_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : str2, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : str, (r38 & 131072) == 0 ? null : null);
    }

    public final void v(@Nullable String str, @Nullable String str2) {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_USE_PASSWORD_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : str2, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : str, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void w(@Nullable String str) {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_VERIFY_ACC_FAIL_RETURN_SHOW, (r38 & 2) != 0 ? null : str, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void x(@Nullable String str) {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_VERIFY_ACC_RESEND_CLICK, (r38 & 2) != 0 ? null : str, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void y(@Nullable String str) {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_OTHER_VERIFY_ACC_SHOW, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : str, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }

    public final void z() {
        c.f54829a.x(LoginAndRegisterProtos.Event.LOGIN_REGISTER_SET_PASSWORD_SAVE_CLICK, (r38 & 2) != 0 ? null : null, (r38 & 4) != 0 ? null : null, (r38 & 8) != 0 ? null : null, (r38 & 16) != 0 ? null : null, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & 256) != 0 ? null : null, (r38 & 512) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & 8192) != 0 ? null : null, (r38 & 16384) != 0 ? null : null, (r38 & 32768) != 0 ? null : null, (r38 & 65536) != 0 ? null : null, (r38 & 131072) == 0 ? null : null);
    }
}
