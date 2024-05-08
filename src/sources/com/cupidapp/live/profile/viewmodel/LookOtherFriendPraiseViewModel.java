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
import com.cupidapp.live.profile.model.LookOtherPraiseBundleData;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: LookOtherFriendPraiseViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LookOtherFriendPraiseViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Boolean> _canEditLiveData;

    @NotNull
    private final MutableLiveData<StateResult<FriendPraiseResult>> _otherPraiseLiveData;

    @NotNull
    private final MutableLiveData<FriendPraiseDetailModel> _updateItemLiveData;

    @NotNull
    private final LiveData<Boolean> canEditLiveData;

    @Nullable
    private LookOtherPraiseBundleData mBundleData;

    @Nullable
    private String mNextCursorId;

    @NotNull
    private final LiveData<StateResult<FriendPraiseResult>> otherPraiseLiveData;

    @NotNull
    private final LiveData<FriendPraiseDetailModel> updateItemLiveData;

    public LookOtherFriendPraiseViewModel() {
        MutableLiveData<StateResult<FriendPraiseResult>> mutableLiveData = new MutableLiveData<>();
        this._otherPraiseLiveData = mutableLiveData;
        this.otherPraiseLiveData = mutableLiveData;
        MutableLiveData<FriendPraiseDetailModel> mutableLiveData2 = new MutableLiveData<>();
        this._updateItemLiveData = mutableLiveData2;
        this.updateItemLiveData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._canEditLiveData = mutableLiveData3;
        this.canEditLiveData = mutableLiveData3;
    }

    public static /* synthetic */ void callOtherFriendPraiseApi$default(LookOtherFriendPraiseViewModel lookOtherFriendPraiseViewModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        lookOtherFriendPraiseViewModel.callOtherFriendPraiseApi(z10);
    }

    public final void callOtherFriendPraiseApi(final boolean z10) {
        LookOtherPraiseBundleData lookOtherPraiseBundleData = this.mBundleData;
        if (lookOtherPraiseBundleData == null) {
            return;
        }
        if (z10) {
            String str = this.mNextCursorId;
            if (str == null || str.length() == 0) {
                return;
            }
        }
        if (!z10) {
            this.mNextCursorId = null;
        }
        Disposable disposed = a.C0836a.c(NetworkClient.f11868a.N(), lookOtherPraiseBundleData.getUserId(), lookOtherPraiseBundleData.getFromShare(), this.mNextCursorId, 0, 8, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FriendPraiseResult, p>() { // from class: com.cupidapp.live.profile.viewmodel.LookOtherFriendPraiseViewModel$callOtherFriendPraiseApi$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FriendPraiseResult friendPraiseResult) {
                m2775invoke(friendPraiseResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2775invoke(FriendPraiseResult friendPraiseResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                FriendPraiseResult friendPraiseResult2 = friendPraiseResult;
                LookOtherFriendPraiseViewModel.this.mNextCursorId = friendPraiseResult2.getNextCursorId();
                if (!z10) {
                    mutableLiveData2 = LookOtherFriendPraiseViewModel.this._canEditLiveData;
                    Boolean canEdit = friendPraiseResult2.getCanEdit();
                    if (canEdit == null) {
                        canEdit = Boolean.FALSE;
                    }
                    mutableLiveData2.setValue(canEdit);
                }
                mutableLiveData = LookOtherFriendPraiseViewModel.this._otherPraiseLiveData;
                mutableLiveData.setValue(new StateResult.c(friendPraiseResult2, Boolean.valueOf(z10)));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.LookOtherFriendPraiseViewModel$callOtherFriendPraiseApi$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = LookOtherFriendPraiseViewModel.this._otherPraiseLiveData;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Boolean> getCanEditLiveData() {
        return this.canEditLiveData;
    }

    @NotNull
    public final LiveData<StateResult<FriendPraiseResult>> getOtherPraiseLiveData() {
        return this.otherPraiseLiveData;
    }

    @NotNull
    public final LiveData<FriendPraiseDetailModel> getUpdateItemLiveData() {
        return this.updateItemLiveData;
    }

    public final void initData(@NotNull LookOtherPraiseBundleData data) {
        s.i(data, "data");
        this.mBundleData = data;
    }

    public final void likeFriendPraise(@NotNull final FriendPraiseDetailModel model) {
        s.i(model, "model");
        String id2 = model.getId();
        if (id2 == null || id2.length() == 0) {
            return;
        }
        boolean z10 = !s.d(model.getLiked(), Boolean.TRUE);
        Disposable disposed = NetworkClient.f11868a.N().k(model.getId(), !z10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.viewmodel.LookOtherFriendPraiseViewModel$likeFriendPraise$$inlined$handle$default$1
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
                LookOtherPraiseBundleData lookOtherPraiseBundleData;
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                String id3 = FriendPraiseDetailModel.this.getId();
                lookOtherPraiseBundleData = this.mBundleData;
                groupSocialLog.K(id3, lookOtherPraiseBundleData != null ? lookOtherPraiseBundleData.getUserId() : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
        int likeCount = model.getLikeCount();
        model.setLikeCount(z10 ? likeCount + 1 : likeCount - 1);
        model.setLiked(Boolean.valueOf(z10));
        this._updateItemLiveData.setValue(model);
    }
}
