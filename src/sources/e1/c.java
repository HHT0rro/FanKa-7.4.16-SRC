package e1;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.profile.model.UserRankModel;
import io.reactivex.Observable;
import kotlin.d;
import ne.f;
import ne.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserInfoService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface c {
    @f("/user/rank/get")
    @NotNull
    Observable<Result<UserRankModel>> a();

    @o("/v1/constants")
    @NotNull
    Observable<Result<Object>> b();
}
