package com.cupidapp.live.notify.logic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.notify.model.DailyHeartModel;
import com.cupidapp.live.notify.model.DailyHeartType;
import com.cupidapp.live.notify.model.NotifyListResult;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: DailyHeartViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DailyHeartViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<StateResult<List<Object>>> _listLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _showBuyBtn;

    @NotNull
    private final MutableLiveData<String> _userFollowedLiveData;

    @NotNull
    private final LiveData<StateResult<List<Object>>> listLiveData;
    private boolean sVipRequired;

    @NotNull
    private final LiveData<Boolean> showBuyBtn;

    @NotNull
    private final LiveData<String> userFollowed;

    public DailyHeartViewModel() {
        MutableLiveData<StateResult<List<Object>>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        this.listLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._showBuyBtn = mutableLiveData2;
        this.showBuyBtn = Transformations.distinctUntilChanged(mutableLiveData2);
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this._userFollowedLiveData = mutableLiveData3;
        this.userFollowed = Transformations.distinctUntilChanged(mutableLiveData3);
    }

    public final void followUser(@Nullable final String str) {
        if (str == null) {
            return;
        }
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), str, null, null, null, 0, null, null, null, 254, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.notify.logic.DailyHeartViewModel$followUser$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2750invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2750invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                MutableLiveData mutableLiveData;
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                h.f12779a.b(R$string.has_followed);
                mutableLiveData = DailyHeartViewModel.this._userFollowedLiveData;
                String str2 = str;
                s.f(str2);
                mutableLiveData.setValue(str2);
                GroupSocialLog.f18708a.B(true, SensorScene.DailyHeart.getValue(), str, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(swipeCardUserLikeResult2.getUser().isAlohaMatched()), (r52 & 32) != 0 ? null : swipeCardUserLikeResult2.getRecommendContext(), (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : SensorPosition.DailyHeart, (r52 & 512) != 0 ? false : false, (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<StateResult<List<Object>>> getListLiveData() {
        return this.listLiveData;
    }

    public final boolean getSVipRequired() {
        return this.sVipRequired;
    }

    @NotNull
    public final LiveData<Boolean> getShowBuyBtn() {
        return this.showBuyBtn;
    }

    @NotNull
    public final LiveData<String> getUserFollowed() {
        return this.userFollowed;
    }

    public final void loadData() {
        if (this.listLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        this._listLiveData.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = NetworkClient.f11868a.C().f(DailyHeartType.Notify.getValue()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<NotifyListResult<DailyHeartModel>, p>() { // from class: com.cupidapp.live.notify.logic.DailyHeartViewModel$loadData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(NotifyListResult<DailyHeartModel> notifyListResult) {
                m2751invoke(notifyListResult);
                return p.f51048a;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
            /* renamed from: invoke, reason: collision with other method in class */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void m2751invoke(com.cupidapp.live.notify.model.NotifyListResult<com.cupidapp.live.notify.model.DailyHeartModel> r20) {
                /*
                    Method dump skipped, instructions count: 298
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.notify.logic.DailyHeartViewModel$loadData$$inlined$handle$1.m2751invoke(java.lang.Object):void");
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.notify.logic.DailyHeartViewModel$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                s.i(it, "it");
                StateResult<List<Object>> value = DailyHeartViewModel.this.getListLiveData().getValue();
                List<Object> data = value != null ? value.getData() : null;
                if (data == null || data.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.heart_beat_empty), Integer.valueOf(R$string.error_heart_beat), null, -15066598, null, null, Float.valueOf(16.0f), true, null, null, MetricsProto.MetricsEvent.ACTION_PICTURE_IN_PICTURE_EXPANDED_TO_FULLSCREEN, null));
                    DailyHeartViewModel.this.setSVipRequired(false);
                    mutableLiveData = DailyHeartViewModel.this._showBuyBtn;
                    mutableLiveData.setValue(Boolean.FALSE);
                    mutableLiveData2 = DailyHeartViewModel.this._listLiveData;
                    mutableLiveData2.setValue(new StateResult.a(null, arrayList, null, 5, null));
                    GroupOthersLog.f18702a.V(SensorPosition.DailyHeart, GroupOthersLog.EmptyPlaceHolderName.DAILY_HEART_ERROR.getValue());
                }
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void setSVipRequired(boolean z10) {
        this.sVipRequired = z10;
    }
}
