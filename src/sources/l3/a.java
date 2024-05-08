package l3;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.push.FKPushMessageModel;
import com.cupidapp.live.push.model.PushAlertShowModel;
import io.reactivex.Observable;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.k;
import ne.o;
import ne.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKPushService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {
    @o("/v1/user/push/bind/android/vivo/finka0a")
    @e
    @NotNull
    Observable<Result<Object>> a(@c("token") @NotNull String str, @c("pushOpen") boolean z10);

    @o("/v1/user/push/unbind/android/vivo/finka0a")
    @e
    @NotNull
    Observable<Result<Object>> b(@c("token") @Nullable String str);

    @k({"Content-Type:application/json; charset=utf-8"})
    @o("/push/log/click")
    @NotNull
    Observable<Result<Object>> c(@ne.a @Nullable FKPushMessageModel fKPushMessageModel);

    @o("/v1/user/push/bind/android/xiaomi/finka0a")
    @e
    @NotNull
    Observable<Result<Object>> d(@c("token") @NotNull String str, @c("pushOpen") boolean z10);

    @o("/v1/user/push/unbind/android/oppo/finka0a")
    @e
    @NotNull
    Observable<Result<Object>> e(@c("token") @Nullable String str);

    @f("/push/switch/alert/show")
    @NotNull
    Observable<Result<PushAlertShowModel>> f(@t("scene") int i10);

    @k({"Content-Type:application/json; charset=utf-8"})
    @o("/push/log/arrive")
    @NotNull
    Observable<Result<Object>> g(@ne.a @Nullable FKPushMessageModel fKPushMessageModel);

    @o("/client/setting/push-switch-status")
    @e
    @NotNull
    Observable<Result<Object>> h(@c("open") boolean z10);

    @o("/v1/user/push/unbind/android/huawei/finka0a")
    @e
    @NotNull
    Observable<Result<Object>> i(@c("token") @Nullable String str);

    @o("/v1/user/push/unbind/android/xiaomi/finka0a")
    @e
    @NotNull
    Observable<Result<Object>> j(@c("token") @Nullable String str);

    @o("/v1/user/push/bind/android/huawei/finka0a")
    @e
    @NotNull
    Observable<Result<Object>> k(@c("token") @NotNull String str, @c("pushOpen") boolean z10);

    @o("/v1/user/push/bind/android/oppo/finka0a")
    @e
    @NotNull
    Observable<Result<Object>> l(@c("token") @NotNull String str, @c("pushOpen") boolean z10);
}
