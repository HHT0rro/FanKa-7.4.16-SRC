package f3;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.feed.model.FeedModel;
import com.cupidapp.live.mediapicker.model.ImageResult;
import com.cupidapp.live.mediapicker.model.UserVideoListModel;
import com.cupidapp.live.mediapicker.model.VideoResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.d;
import ne.c;
import ne.e;
import ne.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PublishService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {
    @o("/feed/publish/v4/image")
    @e
    @NotNull
    Observable<Result<ImageResult<FeedModel>>> a(@c("imageId[]") @NotNull List<String> list, @c("title") @Nullable String str, @c("description") @Nullable String str2, @c("venue") @Nullable String str3, @c("hashtagId") @Nullable String str4, @c("tagMap") @Nullable String str5, @c("replaceAtList") @Nullable String str6, @c("closeFriendOnly") boolean z10, @c("poiAddress") @Nullable String str7, @c("poiName") @Nullable String str8, @c("venueLatitude") @Nullable Double d10, @c("venueLongitude") @Nullable Double d11, @c("poiCityName") @Nullable String str9, @c("webTitle") @Nullable String str10);

    @o("/feed/publish/v4/video")
    @e
    @NotNull
    Observable<Result<VideoResult<UserVideoListModel>>> b(@c("imageId") @NotNull String str, @c("videoId") @NotNull String str2, @c("firstFrameId") @NotNull String str3, @c("title") @Nullable String str4, @c("description") @Nullable String str5, @c("venue") @Nullable String str6, @c("hashtagId") @Nullable String str7, @c("replaceAtList") @Nullable String str8, @c("closeFriendOnly") boolean z10, @c("poiAddress") @Nullable String str9, @c("poiName") @Nullable String str10, @c("venueLatitude") @Nullable Double d10, @c("venueLongitude") @Nullable Double d11, @c("poiCityName") @Nullable String str11, @c("webTitle") @Nullable String str12);

    @o("/feed/publish/v4/check")
    @e
    @NotNull
    Observable<Result<Object>> c(@c("description") @NotNull String str);
}
