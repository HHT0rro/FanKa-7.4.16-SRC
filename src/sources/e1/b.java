package e1;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.login.model.AuthResult;
import com.cupidapp.live.login.model.QuickLoginResult;
import io.reactivex.Observable;
import kotlin.d;
import ne.e;
import ne.f;
import ne.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignInService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface b {

    /* compiled from: SignInService.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public static /* synthetic */ Observable a(b bVar, String str, String str2, String str3, String str4, String str5, String str6, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userAuth");
            }
            if ((i10 & 1) != 0) {
                str = null;
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            if ((i10 & 4) != 0) {
                str3 = null;
            }
            if ((i10 & 8) != 0) {
                str4 = null;
            }
            if ((i10 & 16) != 0) {
                str5 = null;
            }
            if ((i10 & 32) != 0) {
                str6 = null;
            }
            if ((i10 & 64) != 0) {
                z10 = false;
            }
            return bVar.a(str, str2, str3, str4, str5, str6, z10);
        }
    }

    @o("/user/auth/v3")
    @e
    @NotNull
    Observable<Result<AuthResult>> a(@ne.c("account") @Nullable String str, @ne.c("passwordMd5") @Nullable String str2, @ne.c("code") @Nullable String str3, @ne.c("deviceId") @Nullable String str4, @ne.c("token") @Nullable String str5, @ne.c("appUser") @Nullable String str6, @ne.c("multiAccountSource") boolean z10);

    @o("/user/auth/v3/code")
    @e
    @NotNull
    Observable<Result<Object>> b(@ne.c("number") @Nullable String str, @ne.c("multiAccountSource") boolean z10);

    @o("/connect/check")
    @NotNull
    Observable<Result<Object>> c();

    @f("/user/auth/v3/info")
    @NotNull
    Observable<Result<QuickLoginResult>> d();
}
