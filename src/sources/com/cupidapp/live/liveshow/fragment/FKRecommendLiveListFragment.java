package com.cupidapp.live.liveshow.fragment;

import android.view.View;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.liveshow.activity.LiveshowOpenSource;
import com.cupidapp.live.liveshow.model.LiveListResult;
import com.cupidapp.live.liveshow.model.LiveTabConfigModel;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;

/* compiled from: FKRecommendLiveListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKRecommendLiveListFragment extends FKBaseRecommendLiveListFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15058k = new LinkedHashMap();

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f15058k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.LiveRecommend;
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment
    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15058k;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment
    @NotNull
    public ExposureScene f1() {
        return ExposureScene.LiveRecommend;
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment
    @NotNull
    public Observable<Result<LiveListResult>> i1(@Nullable LiveTabConfigModel liveTabConfigModel, @Nullable String str) {
        CoordinateModel j10 = LocationUtils.f12270h.a().j();
        return a.C0826a.k(NetworkClient.f11868a.r(), Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude()), str, 0, 8, null);
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment
    @NotNull
    public SensorsLogLiveShow.EnterLiveShowSource j1() {
        return SensorsLogLiveShow.EnterLiveShowSource.LIVE_RECOMMEND;
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment
    @NotNull
    public LiveshowOpenSource k1() {
        return LiveshowOpenSource.RecommendLive;
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }
}
