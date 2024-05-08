package h3;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.notify.model.AttentionNotifyModel;
import com.cupidapp.live.notify.model.CheckAvatarModel;
import com.cupidapp.live.notify.model.DailyHeartModel;
import com.cupidapp.live.notify.model.NotifyListResult;
import com.cupidapp.live.notify.model.PostNotifyModel;
import com.cupidapp.live.profile.model.NearByGuideModel;
import io.reactivex.Observable;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import ne.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NotifyService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {

    /* compiled from: NotifyService.kt */
    @d
    /* renamed from: h3.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0743a {
        public static /* synthetic */ Observable a(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attentionNotify");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.g(str, i10);
        }

        public static /* synthetic */ Observable b(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postCommentNotify");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.e(str, i10);
        }

        public static /* synthetic */ Observable c(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postLikeNotify");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.d(str, i10);
        }
    }

    @o("/user/profile/check/avatar")
    @NotNull
    Observable<Result<CheckAvatarModel>> a();

    @f("/vas/marketing/nearby-guide")
    @NotNull
    Observable<Result<NearByGuideModel>> b(@t("latitude") double d10, @t("longitude") double d11);

    @o("/vas/marketing/nearby-guide/close")
    @NotNull
    Observable<Result<Object>> c();

    @f("/feed/notify/post-like")
    @NotNull
    Observable<Result<NotifyListResult<PostNotifyModel>>> d(@t("cursor") @Nullable String str, @t("count") int i10);

    @f("/feed/notify/-aloha-like")
    @NotNull
    Observable<Result<NotifyListResult<PostNotifyModel>>> e(@t("cursor") @Nullable String str, @t("count") int i10);

    @f("/vas/daily-like/get")
    @NotNull
    Observable<Result<NotifyListResult<DailyHeartModel>>> f(@t("sourceType") int i10);

    @f("/feed/notify/aloha")
    @NotNull
    Observable<Result<NotifyListResult<AttentionNotifyModel>>> g(@t("cursor") @Nullable String str, @t("count") int i10);

    @o("/feed/notify/read")
    @e
    @NotNull
    Observable<Result<Object>> h(@c("type") @Nullable String str);
}
