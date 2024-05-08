package com.cupidapp.live.profile.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.profile.model.FriendPraiseDetailModel;
import com.cupidapp.live.profile.model.FriendPraiseResult;
import com.cupidapp.live.profile.model.MyFriendPraisePageType;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import x2.a;

/* compiled from: FriendPraiseViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FriendPraiseViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<FriendPraiseDetailModel> _receivedDeleteItemData;

    @NotNull
    private final MutableLiveData<StateResult<FriendPraiseResult>> _receivedLiveData;

    @NotNull
    private final MutableLiveData<FriendPraiseDetailModel> _receivedShowInProfile;

    @NotNull
    private final MutableLiveData<FriendPraiseDetailModel> _receivedUpdateItemData;

    @NotNull
    private final MutableLiveData<FriendPraiseDetailModel> _sendDeleteItemData;

    @NotNull
    private final MutableLiveData<StateResult<FriendPraiseResult>> _sendLiveData;

    @NotNull
    private final MutableLiveData<FriendPraiseDetailModel> _sendUpdateItemData;

    @Nullable
    private String mReceivedNextCursorId;

    @Nullable
    private String mSendNextCursorId;

    @NotNull
    private final LiveData<FriendPraiseDetailModel> receivedDeleteItemData;

    @NotNull
    private final LiveData<StateResult<FriendPraiseResult>> receivedLiveData;

    @NotNull
    private final LiveData<FriendPraiseDetailModel> receivedShowInProfile;

    @NotNull
    private final LiveData<FriendPraiseDetailModel> receivedUpdateItemData;

    @NotNull
    private final LiveData<FriendPraiseDetailModel> sendDeleteItemData;

    @NotNull
    private final LiveData<StateResult<FriendPraiseResult>> sendLiveData;

    @NotNull
    private final LiveData<FriendPraiseDetailModel> sendUpdateItemData;

    public FriendPraiseViewModel() {
        MutableLiveData<StateResult<FriendPraiseResult>> mutableLiveData = new MutableLiveData<>();
        this._receivedLiveData = mutableLiveData;
        this.receivedLiveData = mutableLiveData;
        MutableLiveData<FriendPraiseDetailModel> mutableLiveData2 = new MutableLiveData<>();
        this._receivedUpdateItemData = mutableLiveData2;
        this.receivedUpdateItemData = mutableLiveData2;
        MutableLiveData<FriendPraiseDetailModel> mutableLiveData3 = new MutableLiveData<>();
        this._receivedDeleteItemData = mutableLiveData3;
        this.receivedDeleteItemData = mutableLiveData3;
        MutableLiveData<FriendPraiseDetailModel> mutableLiveData4 = new MutableLiveData<>();
        this._receivedShowInProfile = mutableLiveData4;
        this.receivedShowInProfile = mutableLiveData4;
        MutableLiveData<StateResult<FriendPraiseResult>> mutableLiveData5 = new MutableLiveData<>();
        this._sendLiveData = mutableLiveData5;
        this.sendLiveData = mutableLiveData5;
        MutableLiveData<FriendPraiseDetailModel> mutableLiveData6 = new MutableLiveData<>();
        this._sendUpdateItemData = mutableLiveData6;
        this.sendUpdateItemData = mutableLiveData6;
        MutableLiveData<FriendPraiseDetailModel> mutableLiveData7 = new MutableLiveData<>();
        this._sendDeleteItemData = mutableLiveData7;
        this.sendDeleteItemData = mutableLiveData7;
    }

    public static /* synthetic */ void callReceivedFriendPraiseApi$default(FriendPraiseViewModel friendPraiseViewModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        friendPraiseViewModel.callReceivedFriendPraiseApi(z10);
    }

    public static /* synthetic */ void callSendFriendPraiseApi$default(FriendPraiseViewModel friendPraiseViewModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        friendPraiseViewModel.callSendFriendPraiseApi(z10);
    }

    public final void callReceivedFriendPraiseApi(final boolean z10) {
        if (z10) {
            String str = this.mReceivedNextCursorId;
            if (str == null || str.length() == 0) {
                return;
            }
        }
        if (!z10) {
            this.mReceivedNextCursorId = null;
        }
        Disposable disposed = a.C0836a.b(NetworkClient.f11868a.N(), MyFriendPraisePageType.RECEIVED.getValue(), this.mReceivedNextCursorId, 0, 4, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FriendPraiseResult, p>() { // from class: com.cupidapp.live.profile.viewmodel.FriendPraiseViewModel$callReceivedFriendPraiseApi$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FriendPraiseResult friendPraiseResult) {
                m2773invoke(friendPraiseResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2773invoke(FriendPraiseResult friendPraiseResult) {
                MutableLiveData mutableLiveData;
                FriendPraiseResult friendPraiseResult2 = friendPraiseResult;
                FriendPraiseViewModel.this.mReceivedNextCursorId = friendPraiseResult2.getNextCursorId();
                mutableLiveData = FriendPraiseViewModel.this._receivedLiveData;
                mutableLiveData.setValue(new StateResult.c(friendPraiseResult2, Boolean.valueOf(z10)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.FriendPraiseViewModel$callReceivedFriendPraiseApi$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = FriendPraiseViewModel.this._receivedLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callSendFriendPraiseApi(final boolean z10) {
        if (z10) {
            String str = this.mSendNextCursorId;
            if (str == null || str.length() == 0) {
                return;
            }
        }
        if (!z10) {
            this.mSendNextCursorId = null;
        }
        Disposable disposed = a.C0836a.b(NetworkClient.f11868a.N(), MyFriendPraisePageType.SEND.getValue(), this.mSendNextCursorId, 0, 4, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FriendPraiseResult, p>() { // from class: com.cupidapp.live.profile.viewmodel.FriendPraiseViewModel$callSendFriendPraiseApi$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FriendPraiseResult friendPraiseResult) {
                m2774invoke(friendPraiseResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2774invoke(FriendPraiseResult friendPraiseResult) {
                MutableLiveData mutableLiveData;
                FriendPraiseResult friendPraiseResult2 = friendPraiseResult;
                FriendPraiseViewModel.this.mSendNextCursorId = friendPraiseResult2.getNextCursorId();
                mutableLiveData = FriendPraiseViewModel.this._sendLiveData;
                mutableLiveData.setValue(new StateResult.c(friendPraiseResult2, Boolean.valueOf(z10)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.FriendPraiseViewModel$callSendFriendPraiseApi$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = FriendPraiseViewModel.this._sendLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void deleteFriendPraise(@NotNull final FriendPraiseDetailModel model, final boolean z10) {
        s.i(model, "model");
        String id2 = model.getId();
        if (id2 == null || id2.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.N().w0(model.getId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.viewmodel.FriendPraiseViewModel$deleteFriendPraise$$inlined$handle$default$1
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
                MutableLiveData mutableLiveData2;
                if (z10) {
                    mutableLiveData2 = this._receivedDeleteItemData;
                    mutableLiveData2.setValue(model);
                } else {
                    mutableLiveData = this._sendDeleteItemData;
                    mutableLiveData.setValue(model);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<FriendPraiseDetailModel> getReceivedDeleteItemData() {
        return this.receivedDeleteItemData;
    }

    @NotNull
    public final LiveData<StateResult<FriendPraiseResult>> getReceivedLiveData() {
        return this.receivedLiveData;
    }

    @NotNull
    public final LiveData<FriendPraiseDetailModel> getReceivedShowInProfile() {
        return this.receivedShowInProfile;
    }

    @NotNull
    public final LiveData<FriendPraiseDetailModel> getReceivedUpdateItemData() {
        return this.receivedUpdateItemData;
    }

    @NotNull
    public final LiveData<FriendPraiseDetailModel> getSendDeleteItemData() {
        return this.sendDeleteItemData;
    }

    @NotNull
    public final LiveData<StateResult<FriendPraiseResult>> getSendLiveData() {
        return this.sendLiveData;
    }

    @NotNull
    public final LiveData<FriendPraiseDetailModel> getSendUpdateItemData() {
        return this.sendUpdateItemData;
    }

    public final void likeFriendPraise(@NotNull final FriendPraiseDetailModel model, final boolean z10) {
        s.i(model, "model");
        String id2 = model.getId();
        if (id2 == null || id2.length() == 0) {
            return;
        }
        boolean z11 = !s.d(model.getLiked(), Boolean.TRUE);
        Disposable disposed = NetworkClient.f11868a.N().k(model.getId(), !z11).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.viewmodel.FriendPraiseViewModel$likeFriendPraise$$inlined$handle$default$1
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
                String userId;
                if (z10) {
                    User X = g.f52734a.X();
                    userId = X != null ? X.userId() : null;
                } else {
                    userId = model.getUserId();
                }
                GroupSocialLog.f18708a.K(model.getId(), userId);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
        int likeCount = model.getLikeCount();
        model.setLikeCount(z11 ? likeCount + 1 : likeCount - 1);
        model.setLiked(Boolean.valueOf(z11));
        if (z10) {
            this._receivedUpdateItemData.setValue(model);
        } else {
            this._sendUpdateItemData.setValue(model);
        }
    }

    public final void showFriendPraiseInProfile(@NotNull final FriendPraiseDetailModel model, final boolean z10) {
        s.i(model, "model");
        String id2 = model.getId();
        if (id2 == null || id2.length() == 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.N().I0(model.getId(), z10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.viewmodel.FriendPraiseViewModel$showFriendPraiseInProfile$$inlined$handle$default$1
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
                MutableLiveData mutableLiveData2;
                boolean z11 = z10;
                if (z11) {
                    mutableLiveData2 = this._receivedShowInProfile;
                    mutableLiveData2.setValue(model);
                } else {
                    model.setHomePageDisplay(Boolean.valueOf(z11));
                    mutableLiveData = this._receivedUpdateItemData;
                    mutableLiveData.setValue(model);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }
}
