package x3;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.startup.model.FKStartupMediaResult;
import io.reactivex.Observable;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: SplashService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {
    @f("/ad/list")
    @NotNull
    Observable<Result<FKStartupMediaResult>> a();

    @o("/ad/request")
    @e
    @NotNull
    Observable<Result<Object>> b(@c("adId") @NotNull String str);

    @o("/ad/show")
    @e
    @NotNull
    Observable<Result<Object>> c(@c("adId") @NotNull String str);
}
