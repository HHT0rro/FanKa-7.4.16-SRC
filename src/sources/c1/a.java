package c1;

import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.match.model.AddressModel;
import com.cupidapp.live.mediapicker.model.InChinaModel;
import io.reactivex.Observable;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocationService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {
    @o("/v1/lbs/unregister")
    @NotNull
    Observable<Result<Object>> a();

    @o("/location/chinese")
    @e
    @NotNull
    Observable<Result<InChinaModel>> b(@c("lat") @Nullable Double d10, @c("lon") @Nullable Double d11);

    @o("/v1/lbs/register")
    @e
    @NotNull
    Observable<Result<Object>> c(@c("latitude") @Nullable Double d10, @c("longitude") @Nullable Double d11);

    @f("/vas/address/search/rcmd-order")
    @NotNull
    Observable<Result<ListResult<AddressModel>>> d();

    @o("/vas/nearby/v2/clean-record")
    @NotNull
    Observable<Result<Object>> e();

    @o("/vas/address/search/rcmd")
    @e
    @NotNull
    Observable<Result<ListResult<AddressModel>>> f(@c("cursor") @Nullable String str);

    @f("/vas/nearby/v2/records")
    @NotNull
    Observable<Result<ListResult<AddressModel>>> g();
}
