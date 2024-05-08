package com.cupidapp.live.maskparty.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.maskparty.model.GuessIdentityModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatConnectorMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatRoomModel;
import com.cupidapp.live.maskparty.model.MaskPartyScriptModel;
import com.cupidapp.live.maskparty.model.MaskPartyScriptTaskModel;
import com.cupidapp.live.maskparty.model.MaskPartyType;
import com.cupidapp.live.maskparty.model.ScriptRoleModel;
import com.cupidapp.live.maskparty.model.ScriptTaskScoreModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.post.PostAndSocialProtos;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyScriptKillViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyScriptKillViewModel extends BaseMaskPartyChatViewModel {

    @NotNull
    private final MutableLiveData<Integer> _currentProgressLiveData;

    @NotNull
    private final MutableLiveData<Event<GuessIdentityModel>> _judgeIdentityEventLiveData;

    @NotNull
    private final MutableLiveData<Pair<Boolean, String>> _openAlbumLiveData;

    @NotNull
    private final MutableLiveData<User> _openProfileLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _othersPublicProfileLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _publicMyProfileLiveData;

    @NotNull
    private final MutableLiveData<Event<MaskPartyScriptModel>> _scriptInfoEventLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<MaskPartyScriptTaskModel, Boolean>>> _scriptTaskEventLiveData;

    @NotNull
    private final MutableLiveData<ScriptTaskScoreModel> _scriptTaskScoreLiveData;

    @NotNull
    private final MutableLiveData<Event<List<ScriptRoleModel>>> _showChooseRoleEventLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _showOpenProfilePromptEventLiveData;

    @NotNull
    private final MutableLiveData<Integer> _showPublicProfileLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<Boolean, Boolean>>> _showPublicProfilePromptEventLiveData;

    @NotNull
    private final MutableLiveData<Event<Pair<Integer, Integer>>> _startCountDownEventLiveData;

    @NotNull
    private final LiveData<Integer> currentProgressLiveData;

    @NotNull
    private final LiveData<Event<GuessIdentityModel>> judgeIdentityEventLiveData;

    @NotNull
    private final LiveData<Pair<Boolean, String>> openAlbumLiveData;

    @NotNull
    private final LiveData<User> openProfileLiveData;

    @NotNull
    private final LiveData<Boolean> othersPublicProfileLiveData;

    @NotNull
    private final LiveData<Boolean> publicMyProfileLiveData;

    @NotNull
    private final LiveData<Event<MaskPartyScriptModel>> scriptInfoEventLiveData;

    @NotNull
    private final LiveData<Event<Pair<MaskPartyScriptTaskModel, Boolean>>> scriptTaskEventLiveData;

    @NotNull
    private final LiveData<ScriptTaskScoreModel> scriptTaskScoreLiveData;

    @NotNull
    private final LiveData<Event<List<ScriptRoleModel>>> showChooseRoleEventLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> showOpenProfilePromptEventLiveData;

    @NotNull
    private final LiveData<Integer> showPublicProfileLiveData;

    @NotNull
    private final LiveData<Event<Pair<Boolean, Boolean>>> showPublicProfilePromptEventLiveData;

    @NotNull
    private final LiveData<Event<Pair<Integer, Integer>>> startCountDownEventLiveData;

    /* compiled from: MaskPartyScriptKillViewModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16480a;

        static {
            int[] iArr = new int[CuConnectorOuterClass.MessageType.values().length];
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchDoublePlayRoleInfo.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchScriptTechnicalScore.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.GameShowProfile.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16480a = iArr;
        }
    }

    public MaskPartyScriptKillViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._currentProgressLiveData = mutableLiveData;
        this.currentProgressLiveData = mutableLiveData;
        MutableLiveData<Event<MaskPartyScriptModel>> mutableLiveData2 = new MutableLiveData<>();
        this._scriptInfoEventLiveData = mutableLiveData2;
        this.scriptInfoEventLiveData = mutableLiveData2;
        MutableLiveData<Event<List<ScriptRoleModel>>> mutableLiveData3 = new MutableLiveData<>();
        this._showChooseRoleEventLiveData = mutableLiveData3;
        this.showChooseRoleEventLiveData = mutableLiveData3;
        MutableLiveData<Event<Pair<MaskPartyScriptTaskModel, Boolean>>> mutableLiveData4 = new MutableLiveData<>();
        this._scriptTaskEventLiveData = mutableLiveData4;
        this.scriptTaskEventLiveData = mutableLiveData4;
        MutableLiveData<Event<GuessIdentityModel>> mutableLiveData5 = new MutableLiveData<>();
        this._judgeIdentityEventLiveData = mutableLiveData5;
        this.judgeIdentityEventLiveData = mutableLiveData5;
        MutableLiveData<Event<Pair<Integer, Integer>>> mutableLiveData6 = new MutableLiveData<>();
        this._startCountDownEventLiveData = mutableLiveData6;
        this.startCountDownEventLiveData = mutableLiveData6;
        MutableLiveData<User> mutableLiveData7 = new MutableLiveData<>();
        this._openProfileLiveData = mutableLiveData7;
        this.openProfileLiveData = mutableLiveData7;
        MutableLiveData<Event<Boolean>> mutableLiveData8 = new MutableLiveData<>();
        this._showOpenProfilePromptEventLiveData = mutableLiveData8;
        this.showOpenProfilePromptEventLiveData = mutableLiveData8;
        MutableLiveData<Event<Pair<Boolean, Boolean>>> mutableLiveData9 = new MutableLiveData<>();
        this._showPublicProfilePromptEventLiveData = mutableLiveData9;
        this.showPublicProfilePromptEventLiveData = mutableLiveData9;
        MutableLiveData<Pair<Boolean, String>> mutableLiveData10 = new MutableLiveData<>();
        this._openAlbumLiveData = mutableLiveData10;
        this.openAlbumLiveData = mutableLiveData10;
        MutableLiveData<ScriptTaskScoreModel> mutableLiveData11 = new MutableLiveData<>();
        this._scriptTaskScoreLiveData = mutableLiveData11;
        this.scriptTaskScoreLiveData = mutableLiveData11;
        MutableLiveData<Boolean> mutableLiveData12 = new MutableLiveData<>();
        this._publicMyProfileLiveData = mutableLiveData12;
        this.publicMyProfileLiveData = mutableLiveData12;
        MutableLiveData<Boolean> mutableLiveData13 = new MutableLiveData<>();
        this._othersPublicProfileLiveData = mutableLiveData13;
        this.othersPublicProfileLiveData = mutableLiveData13;
        MutableLiveData<Integer> mutableLiveData14 = new MutableLiveData<>();
        this._showPublicProfileLiveData = mutableLiveData14;
        this.showPublicProfileLiveData = mutableLiveData14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void publicProfileLog() {
        User targetUserInfo;
        if (getPublicMyProfile() && getOthersPublicProfile()) {
            MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
            GroupSocialLog.f18708a.R(PostAndSocialProtos.Type.SHOW_PROFILE, (r15 & 2) != 0 ? null : value != null ? value.getRoomId() : null, (r15 & 4) != 0 ? null : (value == null || (targetUserInfo = value.getTargetUserInfo()) == null) ? null : targetUserInfo.userId(), (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? r.e(MaskPartyType.ScriptKill) : null);
        }
    }

    public final void addPublicProfilePrompt(int i10) {
        User targetUserInfo;
        if (getPublicMyProfile()) {
            return;
        }
        this._showPublicProfileLiveData.setValue(Integer.valueOf(i10 / 60));
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        GroupSocialLog.f18708a.R(PostAndSocialProtos.Type.SHOW_PROFILE_GUIDE, (r15 & 2) != 0 ? null : value != null ? value.getRoomId() : null, (r15 & 4) != 0 ? null : (value == null || (targetUserInfo = value.getTargetUserInfo()) == null) ? null : targetUserInfo.userId(), (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? null : null);
    }

    @NotNull
    public final LiveData<Integer> getCurrentProgressLiveData() {
        return this.currentProgressLiveData;
    }

    @NotNull
    public final LiveData<Event<GuessIdentityModel>> getJudgeIdentityEventLiveData() {
        return this.judgeIdentityEventLiveData;
    }

    @NotNull
    public final LiveData<Pair<Boolean, String>> getOpenAlbumLiveData() {
        return this.openAlbumLiveData;
    }

    @NotNull
    public final LiveData<User> getOpenProfileLiveData() {
        return this.openProfileLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getOthersPublicProfileLiveData() {
        return this.othersPublicProfileLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getPublicMyProfileLiveData() {
        return this.publicMyProfileLiveData;
    }

    public final void getScript() {
        String roomId;
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value == null || (roomId = value.getRoomId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.z().b(roomId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MaskPartyScriptModel, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyScriptKillViewModel$getScript$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MaskPartyScriptModel maskPartyScriptModel) {
                m2695invoke(maskPartyScriptModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2695invoke(MaskPartyScriptModel maskPartyScriptModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = MaskPartyScriptKillViewModel.this._scriptInfoEventLiveData;
                mutableLiveData.setValue(new Event(maskPartyScriptModel));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<MaskPartyScriptModel>> getScriptInfoEventLiveData() {
        return this.scriptInfoEventLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<MaskPartyScriptTaskModel, Boolean>>> getScriptTaskEventLiveData() {
        return this.scriptTaskEventLiveData;
    }

    public final void getScriptTaskInfo(final boolean z10) {
        String roomId;
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value == null || (roomId = value.getRoomId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.z().o(roomId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<MaskPartyScriptTaskModel, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyScriptKillViewModel$getScriptTaskInfo$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MaskPartyScriptTaskModel maskPartyScriptTaskModel) {
                m2696invoke(maskPartyScriptTaskModel);
                return p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2696invoke(MaskPartyScriptTaskModel maskPartyScriptTaskModel) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MaskPartyScriptModel maskPartyScriptModel;
                MaskPartyScriptTaskModel maskPartyScriptTaskModel2 = maskPartyScriptTaskModel;
                mutableLiveData = MaskPartyScriptKillViewModel.this._scriptInfoEventLiveData;
                Event event = (Event) mutableLiveData.getValue();
                maskPartyScriptTaskModel2.setStory((event == null || (maskPartyScriptModel = (MaskPartyScriptModel) event.peekContent()) == null) ? null : maskPartyScriptModel.getStory());
                mutableLiveData2 = MaskPartyScriptKillViewModel.this._scriptTaskEventLiveData;
                mutableLiveData2.setValue(new Event(new Pair(maskPartyScriptTaskModel2, Boolean.valueOf(z10))));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<ScriptTaskScoreModel> getScriptTaskScoreLiveData() {
        return this.scriptTaskScoreLiveData;
    }

    @NotNull
    public final LiveData<Event<List<ScriptRoleModel>>> getShowChooseRoleEventLiveData() {
        return this.showChooseRoleEventLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getShowOpenProfilePromptEventLiveData() {
        return this.showOpenProfilePromptEventLiveData;
    }

    @NotNull
    public final LiveData<Integer> getShowPublicProfileLiveData() {
        return this.showPublicProfileLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<Boolean, Boolean>>> getShowPublicProfilePromptEventLiveData() {
        return this.showPublicProfilePromptEventLiveData;
    }

    @NotNull
    public final LiveData<Event<Pair<Integer, Integer>>> getStartCountDownEventLiveData() {
        return this.startCountDownEventLiveData;
    }

    public final void judgeIdentity(int i10) {
        final MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.z().v(value.getRoomId(), i10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyScriptKillViewModel$judgeIdentity$$inlined$handle$default$1
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
                GroupSocialLog.f18708a.R(PostAndSocialProtos.Type.GUESS_IDENTITY, (r15 & 2) != 0 ? null : MaskPartyChatRoomModel.this.getRoomId(), (r15 & 4) != 0 ? null : MaskPartyChatRoomModel.this.getTargetUserInfo().userId(), (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? null : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel
    public void openAlbum() {
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value != null) {
            this._openAlbumLiveData.setValue(new Pair<>(Boolean.valueOf(isMaskState()), value.getTargetUserInfo().userId()));
        }
    }

    @Override // com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel
    public void openProfile() {
        Integer value = this._currentProgressLiveData.getValue();
        if (value == null) {
            value = 0;
        }
        if (value.intValue() < 100) {
            this._showOpenProfilePromptEventLiveData.setValue(new Event<>(Boolean.TRUE));
            return;
        }
        if (getPublicMyProfile() && getOthersPublicProfile()) {
            MaskPartyChatRoomModel value2 = get_chatRoomModelLiveData().getValue();
            if (value2 != null) {
                this._openProfileLiveData.setValue(value2.getTargetUserInfo());
                return;
            }
            return;
        }
        this._showPublicProfilePromptEventLiveData.setValue(new Event<>(new Pair(Boolean.valueOf(getPublicMyProfile()), Boolean.valueOf(getOthersPublicProfile()))));
    }

    public final void publicProfile() {
        String roomId;
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value == null || (roomId = value.getRoomId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.z().g(roomId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyScriptKillViewModel$publicProfile$$inlined$handle$default$1
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
                MaskPartyScriptKillViewModel.this.setPublicMyProfile(true);
                mutableLiveData = MaskPartyScriptKillViewModel.this._publicMyProfileLiveData;
                mutableLiveData.setValue(Boolean.TRUE);
                MaskPartyScriptKillViewModel.this.publicProfileLog();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.maskparty.viewmodel.BaseMaskPartyChatViewModel
    public void receiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType type, @NotNull Object model) {
        User targetUserInfo;
        s.i(type, "type");
        s.i(model, "model");
        int i10 = a.f16480a[type.ordinal()];
        if (i10 == 1) {
            if (model instanceof MaskPartyChatConnectorMessageModel) {
                getScriptTaskInfo(false);
            }
        } else {
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                setOthersPublicProfile(true);
                this._othersPublicProfileLiveData.setValue(Boolean.TRUE);
                publicProfileLog();
                return;
            }
            if (model instanceof ScriptTaskScoreModel) {
                MutableLiveData<ScriptTaskScoreModel> mutableLiveData = this._scriptTaskScoreLiveData;
                ((ScriptTaskScoreModel) model).setPublic(getPublicMyProfile());
                mutableLiveData.setValue(model);
                MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
                GroupSocialLog.f18708a.R(PostAndSocialProtos.Type.TASK_COMPLETE, (r15 & 2) != 0 ? null : value != null ? value.getRoomId() : null, (r15 & 4) != 0 ? null : (value == null || (targetUserInfo = value.getTargetUserInfo()) == null) ? null : targetUserInfo.userId(), (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? null : null);
            }
        }
    }

    public final void selectRole(int i10) {
        final MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.z().c(value.getRoomId(), i10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.maskparty.viewmodel.MaskPartyScriptKillViewModel$selectRole$$inlined$handle$default$1
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
                MaskPartyScriptKillViewModel.this.getScriptTaskInfo(false);
                GroupSocialLog.f18708a.R(PostAndSocialProtos.Type.CHOOSE_ROLE, (r15 & 2) != 0 ? null : value.getRoomId(), (r15 & 4) != 0 ? null : value.getTargetUserInfo().userId(), (r15 & 8) != 0 ? null : null, (r15 & 16) != 0 ? null : null, (r15 & 32) != 0 ? false : false, (r15 & 64) == 0 ? null : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void showChooseRoleDialog() {
        Event<MaskPartyScriptModel> value = this._scriptInfoEventLiveData.getValue();
        if (value != null) {
            this._showChooseRoleEventLiveData.setValue(new Event<>(value.peekContent().getRole()));
        }
    }

    public final void showJudgeIdentityDialog() {
        Pair<MaskPartyScriptTaskModel, Boolean> peekContent;
        MaskPartyScriptTaskModel first;
        Event<Pair<MaskPartyScriptTaskModel, Boolean>> value = this._scriptTaskEventLiveData.getValue();
        GuessIdentityModel identity = (value == null || (peekContent = value.peekContent()) == null || (first = peekContent.getFirst()) == null) ? null : first.getIdentity();
        if (identity != null) {
            this._judgeIdentityEventLiveData.setValue(new Event<>(identity));
        }
    }

    public final void startCountDown() {
        MaskPartyChatRoomModel value = get_chatRoomModelLiveData().getValue();
        if (value != null) {
            MutableLiveData<Event<Pair<Integer, Integer>>> mutableLiveData = this._startCountDownEventLiveData;
            Integer judgeTime = value.getJudgeTime();
            Integer valueOf = Integer.valueOf(judgeTime != null ? judgeTime.intValue() : 0);
            Integer publicHomepageTime = value.getPublicHomepageTime();
            mutableLiveData.setValue(new Event<>(new Pair(valueOf, Integer.valueOf(publicHomepageTime != null ? publicHomepageTime.intValue() : 0))));
        }
    }

    public final void updateCurrentProgress(int i10) {
        Integer value = this._currentProgressLiveData.getValue();
        if (value == null) {
            value = 0;
        }
        if (value.intValue() < 100) {
            this._currentProgressLiveData.setValue(Integer.valueOf(i10));
        }
    }
}
