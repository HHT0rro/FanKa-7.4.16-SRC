package n3;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.setting.model.NewPushLiveShowModel;
import com.cupidapp.live.setting.model.NewPushSafeEditResult;
import com.cupidapp.live.setting.model.NewPushSettingResult;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import ne.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewPushSettingService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {
    @f("/push/setting")
    @NotNull
    Observable<Result<NewPushSettingResult>> a();

    @o("/push/setting/live/batch")
    @e
    @NotNull
    Observable<Result<NewPushLiveShowModel>> b(@c("pushEnable") boolean z10);

    @o("/push/setting/pause")
    @e
    @NotNull
    Observable<Result<NewPushSettingResult>> c(@c("pushPauseLabelId") int i10);

    @o("/push/setting/live/edit")
    @e
    @NotNull
    Observable<Result<Object>> d(@c("pushLiveShow") boolean z10);

    @f("/push/setting/live")
    @NotNull
    Observable<Result<NewPushLiveShowModel>> e();

    @o("/push/setting/safe")
    @e
    @NotNull
    Observable<Result<NewPushSafeEditResult>> f(@c("pushSafeMode") boolean z10, @c("pushStartTime") @Nullable Long l10, @c("pushEndTime") @Nullable Long l11);

    @o("/push/setting/live/single")
    @e
    @NotNull
    Observable<Result<Object>> g(@c("userId") @NotNull String str, @c("pushEnable") boolean z10);

    @o("/push/setting/edit")
    @e
    @NotNull
    Observable<Result<NewPushSettingResult>> h(@c("pushEnable") boolean z10);

    @o("/push/setting/push/edit")
    @NotNull
    Observable<Result<Object>> i(@u @NotNull HashMap<String, Object> hashMap);
}
