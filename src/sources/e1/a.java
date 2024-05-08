package e1;

import com.cupidapp.live.appdialog.model.ChangeTabModelResult;
import com.cupidapp.live.base.network.model.ABTestListResult;
import com.cupidapp.live.base.network.model.AdFreqControlResult;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ExtraResourceResult;
import com.cupidapp.live.base.network.model.FKNearbyGuideResult;
import com.cupidapp.live.base.network.model.LocationChangeModel;
import com.cupidapp.live.base.network.model.MatchPageActivityResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.UploadImageFileResult;
import com.cupidapp.live.base.network.model.UploadVideoFileResult;
import com.cupidapp.live.main.model.CountDataModel;
import com.cupidapp.live.setting.model.AppIconListModel;
import com.cupidapp.live.setting.model.CheckNonageModel;
import com.cupidapp.live.setting.model.PostLimitSettingModel;
import com.cupidapp.live.startup.model.ApiAdModel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.d;
import ne.e;
import ne.f;
import ne.o;
import ne.s;
import ne.t;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CommonService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {

    /* compiled from: CommonService.kt */
    @d
    /* renamed from: e1.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0726a {
        public static /* synthetic */ Observable a(a aVar, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAbTest");
            }
            if ((i10 & 1) != 0) {
                str = null;
            }
            return aVar.g(str);
        }

        public static /* synthetic */ Observable b(a aVar, String str, String str2, String str3, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: liveReport");
            }
            if ((i10 & 4) != 0) {
                str3 = null;
            }
            return aVar.i(str, str2, str3);
        }

        public static /* synthetic */ Observable c(a aVar, String str, String str2, Long l10, Long l11, Long l12, String str3, Long l13, Long l14, Long l15, String str4, int i10, Object obj) {
            if (obj == null) {
                return aVar.a(str, str2, (i10 & 4) != 0 ? null : l10, (i10 & 8) != 0 ? null : l11, (i10 & 16) != 0 ? null : l12, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : l13, (i10 & 128) != 0 ? null : l14, (i10 & 256) != 0 ? null : l15, (i10 & 512) != 0 ? null : str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showWindowRecord");
        }
    }

    @o("/window/show")
    @e
    @NotNull
    Observable<Result<Object>> a(@ne.c("scene") @NotNull String str, @ne.c("type") @NotNull String str2, @ne.c("appRateRuleId") @Nullable Long l10, @ne.c("webId") @Nullable Long l11, @ne.c("testVersionId") @Nullable Long l12, @ne.c("callbackIds") @Nullable String str3, @ne.c("pushRuleId") @Nullable Long l13, @ne.c("forceUpdateRuleId") @Nullable Long l14, @ne.c("amRuleId") @Nullable Long l15, @ne.c("liveRuleId") @Nullable String str4);

    @f("/v1/app-icon")
    @NotNull
    Observable<Result<AppIconListModel>> b();

    @o("/file/upload/video/w/{width}/h/{height}")
    @NotNull
    Observable<Result<UploadVideoFileResult>> c(@ne.a @NotNull RequestBody requestBody, @s("width") int i10, @s("height") int i11);

    @f("/v1/nonage/check")
    @NotNull
    Observable<Result<CheckNonageModel>> d();

    @o("/v1/user/guid/register")
    @e
    @NotNull
    Observable<Result<Object>> e(@ne.c("guid") @NotNull String str);

    @o("/file/upload/image/v2")
    @NotNull
    Observable<Result<UploadImageFileResult>> f(@ne.a @NotNull RequestBody requestBody, @t("hasFace") @Nullable Boolean bool);

    @f("/abtest")
    @NotNull
    Observable<Result<ABTestListResult>> g(@t("name") @Nullable String str);

    @f("/activity/new-user/update/icon")
    @NotNull
    Observable<Result<MatchPageActivityResult>> h(@t("userId") @NotNull String str);

    @o("/live/report")
    @e
    @NotNull
    Observable<Result<Object>> i(@ne.c("liveShowId") @NotNull String str, @ne.c("type") @NotNull String str2, @ne.c("summary") @Nullable String str3);

    @o("/window/test/click")
    @e
    @NotNull
    Observable<Result<Object>> j(@ne.c("testVersionId") @Nullable Long l10);

    @f("/client/advertising/freq/control")
    @NotNull
    Observable<Result<AdFreqControlResult>> k(@t("adType") int i10);

    @f("/vas/location/get-window")
    @NotNull
    Observable<Result<LocationChangeModel>> l();

    @o("/window/never-show")
    @e
    @NotNull
    Observable<Result<Object>> m(@ne.c("scene") @NotNull String str, @ne.c("windowType") @NotNull String str2);

    @f("/vas/nearby/guide/info")
    @NotNull
    Observable<Result<FKNearbyGuideResult>> n();

    @f("/constants/android")
    @NotNull
    Observable<Result<ConstantsResult>> o();

    @f("/user/setting/post/limit")
    @NotNull
    Observable<Result<PostLimitSettingModel>> p();

    @o("/ad/availability")
    @e
    @NotNull
    Observable<Result<ApiAdModel>> q(@ne.c("source") @Nullable String str, @ne.c("dspAid") @Nullable String str2, @ne.c("adStyle") @Nullable Integer num, @ne.c("ua") @Nullable String str3);

    @f("/count/v3")
    @NotNull
    Observable<Result<CountDataModel>> r();

    @o("/window/agree")
    @e
    @NotNull
    Observable<Result<Object>> s(@ne.c("scene") @NotNull String str, @ne.c("type") @NotNull String str2, @ne.c("callbackIds") @NotNull String str3);

    @o("/api/extra-resource/get")
    @e
    @NotNull
    Observable<Result<ExtraResourceResult>> t(@ne.c("key[]") @NotNull List<String> list, @ne.c("prefetch") boolean z10);

    @f("/tab/change")
    @NotNull
    Observable<Result<ChangeTabModelResult>> u(@t("tab") @NotNull String str);

    @o("/stat/event-log")
    @e
    @NotNull
    Observable<Result<Object>> v(@ne.c("type") @NotNull String str, @ne.c("code") @Nullable Integer num, @ne.c("message") @Nullable String str2);

    @o("/user/setting/post/limit")
    @e
    @NotNull
    Observable<Result<Object>> w(@ne.c("readLimit") int i10, @ne.c("messageLimit") int i11);

    @f("/constants/android/manual-update")
    @NotNull
    Observable<Result<ConstantsResult>> x();

    @o("/ad/exposure/count/new")
    @e
    @NotNull
    Observable<Result<Object>> y(@ne.c("adId") @NotNull String str);
}
