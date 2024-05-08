package y3;

import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.feed.model.FeedRecommendListResult;
import com.cupidapp.live.match.model.MatchResult;
import io.reactivex.Observable;
import kotlin.d;
import ne.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKTouristService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a {
    @f("/guest/rcmd")
    @NotNull
    Observable<Result<MatchResult>> a();

    @f("/guest/post/rcmd")
    @NotNull
    Observable<Result<FeedRecommendListResult>> b();
}
