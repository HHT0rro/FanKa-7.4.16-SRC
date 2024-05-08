package com.cupidapp.live.liveshow.fragment;

import android.view.View;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.recyclerview.helper.ExposureScene;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.liveshow.activity.LiveshowOpenSource;
import com.cupidapp.live.liveshow.model.LiveListResult;
import com.cupidapp.live.liveshow.model.LiveTabConfigModel;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;

/* compiled from: FKGeneralLiveListFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKGeneralLiveListFragment extends FKBaseRecommendLiveListFragment {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15005k = new LinkedHashMap();

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment, com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f15005k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.LiveConfigurable;
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment
    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15005k;
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
        return ExposureScene.LiveGeneral;
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment
    @NotNull
    public Observable<Result<LiveListResult>> i1(@Nullable LiveTabConfigModel liveTabConfigModel, @Nullable String str) {
        return a.C0826a.b(NetworkClient.f11868a.r(), liveTabConfigModel != null ? Integer.valueOf(liveTabConfigModel.getId()) : null, str, 0, 4, null);
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment
    @NotNull
    public SensorsLogLiveShow.EnterLiveShowSource j1() {
        return SensorsLogLiveShow.EnterLiveShowSource.LIVE_CONFIGURABLE;
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment
    @NotNull
    public LiveshowOpenSource k1() {
        return LiveshowOpenSource.General;
    }

    @Override // com.cupidapp.live.liveshow.fragment.FKBaseRecommendLiveListFragment, com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }
}
