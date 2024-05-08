package com.cupidapp.live.liveshow.view.remoteconnect.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.TripleCombineLiveData;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveConnectRequestResult;
import com.cupidapp.live.liveshow.model.LiveConnectType;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.track.group.GroupLiveLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;

/* compiled from: RequestLiveConnectViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RequestLiveConnectViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Object> _cancelRequestLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _checkBoxStatus;

    @NotNull
    private final MutableLiveData<LiveConnectType> _connectButtonClickLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _connectButtonStatus;

    @NotNull
    private final MutableLiveData<LiveConnectType> _connectTypeLiveData;

    @NotNull
    private final MutableLiveData<Integer> _requestConnectLiveData;

    @NotNull
    private final LiveData<Object> cancelRequestLiveData;

    @NotNull
    private final LiveData<LiveConnectType> connectButtonClickLiveData;

    @NotNull
    private final LiveData<Boolean> connectButtonStatus;

    @NotNull
    private final LiveData<Integer> requestConnectLiveData;

    public RequestLiveConnectViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._requestConnectLiveData = mutableLiveData;
        this.requestConnectLiveData = mutableLiveData;
        MutableLiveData<Object> mutableLiveData2 = new MutableLiveData<>();
        this._cancelRequestLiveData = mutableLiveData2;
        this.cancelRequestLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._checkBoxStatus = mutableLiveData3;
        MutableLiveData<LiveConnectType> mutableLiveData4 = new MutableLiveData<>();
        this._connectTypeLiveData = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this._connectButtonStatus = mutableLiveData5;
        this.connectButtonStatus = new TripleCombineLiveData(mutableLiveData3, mutableLiveData4, mutableLiveData5, new Function3<Boolean, LiveConnectType, Boolean, Boolean>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.viewmodel.RequestLiveConnectViewModel$connectButtonStatus$1
            @Override // kotlin.jvm.functions.Function3
            @Nullable
            public final Boolean invoke(@Nullable Boolean bool, @Nullable LiveConnectType liveConnectType, @Nullable Boolean bool2) {
                return (!s.d(bool, Boolean.TRUE) || liveConnectType == null) ? Boolean.FALSE : bool2;
            }
        });
        MutableLiveData<LiveConnectType> mutableLiveData6 = new MutableLiveData<>();
        this._connectButtonClickLiveData = mutableLiveData6;
        this.connectButtonClickLiveData = mutableLiveData6;
    }

    public final void cancelRequestConnect() {
        a r10 = NetworkClient.f11868a.r();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        Disposable disposed = r10.k(liveShowModel != null ? liveShowModel.getItemId() : null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.viewmodel.RequestLiveConnectViewModel$cancelRequestConnect$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                MutableLiveData mutableLiveData;
                mutableLiveData = RequestLiveConnectViewModel.this._cancelRequestLiveData;
                mutableLiveData.setValue(obj);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void connectClick() {
        this._connectButtonClickLiveData.setValue(this._connectTypeLiveData.getValue());
    }

    @NotNull
    public final LiveData<Object> getCancelRequestLiveData() {
        return this.cancelRequestLiveData;
    }

    @NotNull
    public final LiveData<LiveConnectType> getConnectButtonClickLiveData() {
        return this.connectButtonClickLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getConnectButtonStatus() {
        return this.connectButtonStatus;
    }

    @NotNull
    public final LiveData<Integer> getRequestConnectLiveData() {
        return this.requestConnectLiveData;
    }

    public final void requestLiveConnect() {
        final LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || this._connectTypeLiveData.getValue() == null) {
            return;
        }
        a r10 = NetworkClient.f11868a.r();
        String itemId = liveShowModel.getItemId();
        LiveConnectType value = this._connectTypeLiveData.getValue();
        s.f(value);
        Disposable disposed = r10.R(itemId, value.getType()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LiveConnectRequestResult, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.viewmodel.RequestLiveConnectViewModel$requestLiveConnect$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveConnectRequestResult liveConnectRequestResult) {
                m2657invoke(liveConnectRequestResult);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2657invoke(LiveConnectRequestResult liveConnectRequestResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = RequestLiveConnectViewModel.this._requestConnectLiveData;
                int waitingToConnectCount = liveConnectRequestResult.getWaitingToConnectCount();
                if (waitingToConnectCount == null) {
                    waitingToConnectCount = 0;
                }
                mutableLiveData.setValue(waitingToConnectCount);
                GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
                String itemId2 = liveShowModel.getItemId();
                String userId = liveShowModel.getUser().userId();
                mutableLiveData2 = RequestLiveConnectViewModel.this._connectTypeLiveData;
                T value2 = mutableLiveData2.getValue();
                s.f(value2);
                groupLiveLog.y(itemId2, userId, ((LiveConnectType) value2).getType());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void setCheckBoxStatus(boolean z10) {
        this._checkBoxStatus.setValue(Boolean.valueOf(z10));
        this._connectButtonStatus.setValue(Boolean.valueOf(z10));
    }

    public final void setConnectType(@NotNull LiveConnectType connectType) {
        s.i(connectType, "connectType");
        this._connectTypeLiveData.setValue(connectType);
        this._connectButtonStatus.setValue(Boolean.TRUE);
    }
}
