package com.cupidapp.live.liveshow.view.remoteconnect.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveConnectAcceptResult;
import com.cupidapp.live.liveshow.model.LiveRequestModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowViewerResult;
import com.cupidapp.live.profile.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;

/* compiled from: ConnectUserViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConnectUserViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Boolean> _connectSwitchLiveData;

    @NotNull
    private final MutableLiveData<LiveShowViewerResult> _requestListLiveData;

    @NotNull
    private final MutableLiveData<Event<Object>> _showCloseDialogEventLiveData;

    @NotNull
    private final MutableLiveData<Event<String>> _showMiniProfileEventLiveData;

    @NotNull
    private final MutableLiveData<LiveConnectAcceptResult> _startLiveConnectLiveData;

    @NotNull
    private final LiveData<Boolean> connectSwitchLiveData;

    @NotNull
    private final LiveData<LiveShowViewerResult> requestListLiveData;

    @NotNull
    private final LiveData<Event<Object>> showCloseDialogEventLiveData;

    @NotNull
    private final LiveData<Event<String>> showMiniProfileEventLiveData;

    @NotNull
    private final LiveData<LiveConnectAcceptResult> startLiveConnectLiveData;

    public ConnectUserViewModel() {
        MutableLiveData<LiveShowViewerResult> mutableLiveData = new MutableLiveData<>();
        this._requestListLiveData = mutableLiveData;
        this.requestListLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._connectSwitchLiveData = mutableLiveData2;
        this.connectSwitchLiveData = mutableLiveData2;
        MutableLiveData<Event<Object>> mutableLiveData3 = new MutableLiveData<>();
        this._showCloseDialogEventLiveData = mutableLiveData3;
        this.showCloseDialogEventLiveData = mutableLiveData3;
        MutableLiveData<Event<String>> mutableLiveData4 = new MutableLiveData<>();
        this._showMiniProfileEventLiveData = mutableLiveData4;
        this.showMiniProfileEventLiveData = mutableLiveData4;
        MutableLiveData<LiveConnectAcceptResult> mutableLiveData5 = new MutableLiveData<>();
        this._startLiveConnectLiveData = mutableLiveData5;
        this.startLiveConnectLiveData = mutableLiveData5;
    }

    public final void closeConnect(final boolean z10) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().f0(itemId, Boolean.valueOf(z10)).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.viewmodel.ConnectUserViewModel$closeConnect$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                mutableLiveData = ConnectUserViewModel.this._connectSwitchLiveData;
                mutableLiveData.setValue(Boolean.valueOf(z10));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Boolean> getConnectSwitchLiveData() {
        return this.connectSwitchLiveData;
    }

    public final void getRequestList() {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().a0(itemId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LiveShowViewerResult, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.viewmodel.ConnectUserViewModel$getRequestList$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowViewerResult liveShowViewerResult) {
                m2655invoke(liveShowViewerResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2655invoke(LiveShowViewerResult liveShowViewerResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                LiveShowViewerResult liveShowViewerResult2 = liveShowViewerResult;
                mutableLiveData = ConnectUserViewModel.this._requestListLiveData;
                mutableLiveData.setValue(liveShowViewerResult2);
                mutableLiveData2 = ConnectUserViewModel.this._connectSwitchLiveData;
                Boolean closeReceiveRequest = liveShowViewerResult2.getCloseReceiveRequest();
                if (closeReceiveRequest == null) {
                    closeReceiveRequest = Boolean.FALSE;
                }
                mutableLiveData2.setValue(closeReceiveRequest);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<LiveShowViewerResult> getRequestListLiveData() {
        return this.requestListLiveData;
    }

    @NotNull
    public final LiveData<Event<Object>> getShowCloseDialogEventLiveData() {
        return this.showCloseDialogEventLiveData;
    }

    @NotNull
    public final LiveData<Event<String>> getShowMiniProfileEventLiveData() {
        return this.showMiniProfileEventLiveData;
    }

    @NotNull
    public final LiveData<LiveConnectAcceptResult> getStartLiveConnectLiveData() {
        return this.startLiveConnectLiveData;
    }

    public final void showCloseConnectDialog() {
        this._showCloseDialogEventLiveData.setValue(new Event<>(new Object()));
    }

    public final void showMiniProfile(@NotNull String userId) {
        s.i(userId, "userId");
        this._showMiniProfileEventLiveData.setValue(new Event<>(userId));
    }

    public final void startConnect(@Nullable LiveRequestModel liveRequestModel) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null || liveRequestModel == null) {
            return;
        }
        a r10 = NetworkClient.f11868a.r();
        String id2 = liveRequestModel.getId();
        User user = liveRequestModel.getUser();
        Disposable disposed = r10.C(itemId, id2, user != null ? user.userId() : null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<LiveConnectAcceptResult, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.viewmodel.ConnectUserViewModel$startConnect$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveConnectAcceptResult liveConnectAcceptResult) {
                m2656invoke(liveConnectAcceptResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2656invoke(LiveConnectAcceptResult liveConnectAcceptResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ConnectUserViewModel.this._startLiveConnectLiveData;
                mutableLiveData.setValue(liveConnectAcceptResult);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}
