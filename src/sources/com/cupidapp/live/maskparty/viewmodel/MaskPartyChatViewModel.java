package com.cupidapp.live.maskparty.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.maskparty.model.MaskPartyChatConnectorMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatRoomModel;
import com.cupidapp.live.maskparty.model.MaskPartyQuestionModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.post.PostAndSocialProtos;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatViewModel extends BaseMaskPartyChatViewModel {

    @NotNull
    private final MutableLiveData<Integer> _currentScoreLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<Boolean, String>>> _openAlbumEventLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<Boolean, User>>> _openProfileEventLiveData;

    @NotNull
    private final MutableLiveData<List<MaskPartyQuestionModel>> _questionLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _showPlayAgainEventLiveData;

    @NotNull
    private final LiveData<Integer> currentScoreLiveData;

    @NotNull
    private final LiveData<Event<Pair<Boolean, String>>> openAlbumEventLiveData;

    @NotNull
    private final LiveData<Event<Pair<Boolean, User>>> openProfileEventLiveData;

    @NotNull
    private final LiveData<List<MaskPartyQuestionModel>> questionLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> showPlayAgainEventLiveData;

    /* compiled from: MaskPartyChatViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16478a;

        static {
            int[] iArr = new int[CuConnectorOuterClass.MessageType.values().length];
            try {
                iArr[CuConnectorOuterClass.MessageType.CanPlayNewRound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f16478a = iArr;
        }
    }

    public MaskPartyChatViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._currentScoreLiveData = mutableLiveData;
        this.currentScoreLiveData = mutableLiveData;
        MutableLiveData<List<MaskPartyQuestionModel>> mutableLiveData2 = new MutableLiveData<>();
        this._questionLiveData = mutableLiveData2;
        this.questionLiveData = mutableLiveData2;
        MutableLiveData<Event<Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this._showPlayAgainEventLiveData = mutableLiveData3;
        this.showPlayAgainEventLiveData = mutableLiveData3;
        MutableLiveData<Event<Pair<Boolean, User>>> mutableLiveData4 = new MutableLiveData<>();
        this._openProfileEventLiveData = mutableLiveData4;
        this.openProfileEventLiveData = mutableLiveData4;
        MutableLiveData<Event<Pair<Boolean, String>>> mutableLiveData5 = new MutableLiveData<>();
        this._openAlbumEventLiveData = mutableLiveData5;
        this.openAlbumEventLiveData = mutableLiveData5;
    }

    public static /* synthetic */ void playAgain$default(MaskPartyChatViewModel maskPartyChatViewModel, MaskPartyChatMessageModel maskPartyChatMessageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            maskPartyChatMessageModel = null;
        }
        maskPartyChatViewModel.playAgain(maskPartyChatMessageModel);
    }

    @NotNull
    public final LiveData<Integer> getCurrentScoreLiveData() {
        return this.currentScoreLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<Boolean, String>>> getOpenAlbumEventLiveData() {
        return this.openAlbumEventLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<Boolean, User>>> getOpenProfileEventLiveData() {
        return this.openProfileEventLiveData;
    }

    public final void getQuestionList() {
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value != null) {
            Disposable disposed = NetworkClient.f11868a.z().u(value.getPlayType()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ListResult<MaskPartyQuestionModel>, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyChatViewModel$getQuestionList$lambda$1$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(ListResult<MaskPartyQuestionModel> listResult) {
                    m2689invoke(listResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2689invoke(ListResult<MaskPartyQuestionModel> listResult) {
                    MutableLiveData mutableLiveData;
                    ListResult<MaskPartyQuestionModel> listResult2 = listResult;
                    List<MaskPartyQuestionModel> list = listResult2.getList();
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    mutableLiveData = MaskPartyChatViewModel.this._questionLiveData;
                    List<MaskPartyQuestionModel> list2 = listResult2.getList();
                    s.f(list2);
                    mutableLiveData.setValue(list2);
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    @NotNull
    public final LiveData<List<MaskPartyQuestionModel>> getQuestionLiveData() {
        return this.questionLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getShowPlayAgainEventLiveData() {
        return this.showPlayAgainEventLiveData;
    }

    @Override // com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel
    public void openAlbum() {
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value != null) {
            this._openAlbumEventLiveData.setValue(new Event<>(new Pair(Boolean.valueOf(isMaskState()), value.getTargetUserInfo().userId())));
        }
    }

    @Override // com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel
    public void openProfile() {
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value != null) {
            this._openProfileEventLiveData.setValue(new Event<>(new Pair(Boolean.valueOf(isMaskState()), value.getTargetUserInfo())));
        }
    }

    public final void playAgain(@Nullable final MaskPartyChatMessageModel maskPartyChatMessageModel) {
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value != null) {
            GroupSocialLog.f18708a.R(PostAndSocialProtos.Type.ANOTHER_SHOT, (r15 & 2) != 0 ? null : value.getRoomId(), (r15 & 4) != 0 ? null : value.getTargetUserInfo().userId(), (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? null : null);
            Disposable disposed = NetworkClient.f11868a.z().l(value.getRoomId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyChatViewModel$playAgain$lambda$5$$inlined$handle$default$1
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
                    mutableLiveData = MaskPartyChatViewModel.this._showPlayAgainEventLiveData;
                    mutableLiveData.setValue(new Event(Boolean.FALSE));
                    MaskPartyChatMessageModel maskPartyChatMessageModel2 = maskPartyChatMessageModel;
                    if (maskPartyChatMessageModel2 != null) {
                        MaskPartyChatViewModel.this.updateNoticeMessage(maskPartyChatMessageModel2);
                    }
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    @Override // com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel
    public void receiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        User targetUserInfo;
        s.i(type, "type");
        s.i(model, "model");
        if (a.f16478a[type.ordinal()] == 1 && (model instanceof MaskPartyChatConnectorMessageModel)) {
            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
            PostAndSocialProtos.Type type2 = PostAndSocialProtos.Type.ANSWER_QUESTION;
            MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
            String roomId = value != null ? value.getRoomId() : null;
            MaskPartyChatRoomModel value2 = get_chatRoomModelLiveData().getValue();
            groupSocialLog.R(type2, (r15 & 2) != 0 ? null : roomId, (r15 & 4) != 0 ? null : (value2 == null || (targetUserInfo = value2.getTargetUserInfo()) == null) ? null : targetUserInfo.userId(), (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? null : null);
            this._showPlayAgainEventLiveData.setValue(new Event<>(Boolean.TRUE));
        }
    }

    public final void selectQuestionType(int i10) {
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value != null) {
            Disposable disposed = NetworkClient.f11868a.z().p(value.getRoomId(), i10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyChatViewModel$selectQuestionType$lambda$3$$inlined$handle$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    @Override // com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel
    public void updateCurrentScore(int i10) {
        this._currentScoreLiveData.setValue(Integer.valueOf(i10));
        MaskPartyChatRoomModel.Companion companion = MaskPartyChatRoomModel.Companion;
        setPublicMyProfile(!companion.a(Integer.valueOf(i10)));
        setOthersPublicProfile(!companion.a(Integer.valueOf(i10)));
    }
}
