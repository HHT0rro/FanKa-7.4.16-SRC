package n3;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.login.model.AuthResult;
import com.cupidapp.live.setting.model.SwitchAccountResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.d;
import ne.c;
import ne.e;
import ne.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: SettingService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface b {

    /* compiled from: SettingService.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public static /* synthetic */ Observable a(b bVar, List list, boolean z10, boolean z11, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userAccountMultiGet");
            }
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            if ((i10 & 4) != 0) {
                z11 = false;
            }
            return bVar.a(list, z10, z11);
        }
    }

    @o("/user/account/multi/get")
    @e
    @NotNull
    Observable<Result<SwitchAccountResult>> a(@c("accountList[]") @NotNull List<String> list, @c("isProfile") boolean z10, @c("isFilterNotNormalAccount") boolean z11);

    @o("/user/account/multi/remove")
    @e
    @NotNull
    Observable<Result<Object>> b(@c("userId") @NotNull String str);

    @o("/user/account/multi/switch")
    @e
    @NotNull
    Observable<Result<AuthResult>> c(@c("account") @NotNull String str, @c("isLogout") boolean z10);
}
