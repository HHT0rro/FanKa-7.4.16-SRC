package b3;

import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.match.model.ActivityJumpModel;
import com.cupidapp.live.match.model.AlohaGuideModel;
import com.cupidapp.live.match.model.CheckTravelUseResult;
import com.cupidapp.live.match.model.IntelligentFilterKeywordResult;
import com.cupidapp.live.match.model.LocationChangedModel;
import com.cupidapp.live.match.model.MatchResult;
import com.cupidapp.live.match.model.MatchSettingResult;
import com.cupidapp.live.match.model.NearByFloatModel;
import com.cupidapp.live.match.model.NearByTopTipModel;
import com.cupidapp.live.match.model.NearMatchModel;
import com.cupidapp.live.match.model.NearbyResult;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.match.model.NearbyUserResult;
import com.cupidapp.live.match.model.SearchHideResult;
import com.cupidapp.live.match.model.TravelUseResult;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import io.reactivex.Observable;
import kotlin.d;
import ne.c;
import ne.e;
import ne.f;
import ne.o;
import ne.t;
import okhttp3.FormBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {

    /* compiled from: MatchService.kt */
    @d
    /* renamed from: b3.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0021a {
        public static /* synthetic */ Observable a(a aVar, String str, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNearbySuperBoost");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                i10 = 30;
            }
            return aVar.g(str, i10);
        }

        public static /* synthetic */ Observable b(a aVar, Double d10, Double d11, int i10, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nearby");
            }
            if ((i11 & 1) != 0) {
                d10 = Double.valueOf(ShadowDrawableWrapper.COS_45);
            }
            if ((i11 & 2) != 0) {
                d11 = Double.valueOf(ShadowDrawableWrapper.COS_45);
            }
            if ((i11 & 4) != 0) {
                i10 = 24;
            }
            if ((i11 & 8) != 0) {
                str = null;
            }
            return aVar.k(d10, d11, i10, str);
        }
    }

    @o("/user/recommend/card/exposure")
    @e
    @NotNull
    Observable<Result<Object>> a(@c("type") @Nullable String str, @c("configKey") @Nullable String str2, @c("activityId") @Nullable String str3, @c("groupId") @Nullable String str4);

    @f("/vas/nearby/user")
    @NotNull
    Observable<Result<NearbyUserResult>> b(@t("userId") @NotNull String str, @t("source") @Nullable String str2, @t("isUsingMap") boolean z10);

    @o("/user/setting/relation")
    @NotNull
    Observable<Result<MatchSettingResult>> c(@ne.a @NotNull FormBody formBody);

    @o("/vas/location/set-priority")
    @NotNull
    Observable<Result<LocationChangedModel>> d();

    @f("/user/recommend")
    @NotNull
    Observable<Result<MatchResult>> e(@t("multiInfo") boolean z10);

    @o("/vas/nearby/match")
    @e
    @NotNull
    Observable<Result<ListResult<NearMatchModel>>> f(@c("cursor") @Nullable String str);

    @f("/vas/nearby/superboost")
    @NotNull
    Observable<Result<ListResult<NearbyUserModel>>> g(@t("cursor") @Nullable String str, @t("count") int i10);

    @f("/feed/v5/newUser/nearbyFloat")
    @NotNull
    Observable<Result<NearByFloatModel>> h();

    @o("/user/setting/match/save-keywords")
    @NotNull
    Observable<Result<MatchSettingResult>> i(@ne.a @NotNull FormBody formBody);

    @o("/recommend/live/exposure")
    @e
    @NotNull
    Observable<Result<Object>> j(@c("showId") @NotNull String str, @c("position") @NotNull String str2, @c("anchorId") @NotNull String str3);

    @o("/vas/nearby/v2")
    @e
    @NotNull
    Observable<Result<NearbyResult>> k(@c("latitude") @Nullable Double d10, @c("longitude") @Nullable Double d11, @c("count") int i10, @c("cursor") @Nullable String str);

    @o("/vas/superboost/travelboost/use-check")
    @e
    @NotNull
    Observable<Result<CheckTravelUseResult>> l(@c("lat") @Nullable Double d10, @c("lon") @Nullable Double d11, @c("poiAdName") @Nullable String str, @c("poiPName") @Nullable String str2, @c("poiAddress") @Nullable String str3, @c("poiCityName") @Nullable String str4);

    @f("/user/setting/relation")
    @NotNull
    Observable<Result<MatchSettingResult>> m(@t("latitude") @Nullable Double d10, @t("longitude") @Nullable Double d11);

    @f("/vas/marketing/nearby-offer-info")
    @NotNull
    Observable<Result<NearByTopTipModel>> n();

    @f("/vas/new-user/homepage/card")
    @NotNull
    Observable<Result<AlohaGuideModel>> o();

    @f("/user/setting/match/v4")
    @NotNull
    Observable<Result<MatchSettingResult>> p(@t("latitude") @Nullable Double d10, @t("longitude") @Nullable Double d11);

    @o("/vas/superboost/use")
    @e
    @NotNull
    Observable<Result<TravelUseResult>> q(@c("lat") @Nullable Double d10, @c("lon") @Nullable Double d11, @c("poiAdName") @Nullable String str, @c("poiPName") @Nullable String str2, @c("poiAddress") @Nullable String str3, @c("poiCityName") @Nullable String str4, @c("times") @Nullable Integer num, @c("type") @Nullable Integer num2);

    @f("/recommend/live/match")
    @NotNull
    Observable<Result<ListResult<LiveShowModel>>> r();

    @o("/user/setting/match/v4")
    @NotNull
    Observable<Result<MatchSettingResult>> s(@ne.a @NotNull FormBody formBody);

    @f("/search/hide")
    @NotNull
    Observable<Result<SearchHideResult>> t();

    @o("/vas/nearby/map/data")
    @e
    @NotNull
    Observable<Result<Object>> u(@c("lat") @Nullable Double d10, @c("lon") @Nullable Double d11, @c("poiAdName") @Nullable String str, @c("poiPName") @Nullable String str2, @c("poiAddress") @Nullable String str3, @c("poiCityName") @Nullable String str4, @c("clear") boolean z10);

    @f("/activity/activity-jump/popup")
    @NotNull
    Observable<Result<ActivityJumpModel>> v(@t("token") @NotNull String str);

    @f("/user/setting/match-keyword-v2")
    @NotNull
    Observable<Result<IntelligentFilterKeywordResult>> w();
}
