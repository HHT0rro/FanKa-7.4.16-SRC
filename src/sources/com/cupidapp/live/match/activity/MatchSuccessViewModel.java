package com.cupidapp.live.match.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.abtest.ABTestGroup;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ABTestKey;
import com.cupidapp.live.base.network.model.ABTestListResult;
import com.cupidapp.live.base.network.model.ABTestModel;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogFeed;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.feed.layout.MsgType;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import e1.a;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

/* compiled from: MatchSuccessViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MatchSuccessViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<List<AvatarProfileModel>> _avatarsLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _matchSuccessAnimationLiveData;

    @NotNull
    private final MutableLiveData<Integer> _selectAvatarPosLiveData;

    @NotNull
    private final MutableLiveData<Event<StateResult<Boolean>>> _sendMsgStateResult;

    @NotNull
    private final MutableLiveData<FKStoryLabelItemModel> _storyLabelLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _superLikeState;

    @NotNull
    private final LiveData<List<AvatarProfileModel>> avatarsLiveData;
    private boolean initiativeMatch;

    @NotNull
    private final LiveData<Boolean> matchSuccessAnimationLiveData;

    @NotNull
    private final LiveData<Integer> selectAvatarPosLiveData;

    @NotNull
    private final LiveData<Event<StateResult<Boolean>>> sendMsgStateResult;

    @NotNull
    private final LiveData<FKStoryLabelItemModel> storyLabelLiveData;

    @NotNull
    private final LiveData<Boolean> superLikeState;
    private User user;

    public MatchSuccessViewModel() {
        MutableLiveData<List<AvatarProfileModel>> mutableLiveData = new MutableLiveData<>();
        this._avatarsLiveData = mutableLiveData;
        this.avatarsLiveData = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._selectAvatarPosLiveData = mutableLiveData2;
        this.selectAvatarPosLiveData = Transformations.distinctUntilChanged(mutableLiveData2);
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._superLikeState = mutableLiveData3;
        this.superLikeState = Transformations.distinctUntilChanged(mutableLiveData3);
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._matchSuccessAnimationLiveData = mutableLiveData4;
        this.matchSuccessAnimationLiveData = mutableLiveData4;
        MutableLiveData<FKStoryLabelItemModel> mutableLiveData5 = new MutableLiveData<>();
        this._storyLabelLiveData = mutableLiveData5;
        this.storyLabelLiveData = mutableLiveData5;
        MutableLiveData<Event<StateResult<Boolean>>> mutableLiveData6 = new MutableLiveData<>();
        this._sendMsgStateResult = mutableLiveData6;
        this.sendMsgStateResult = mutableLiveData6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportMatchSuccess() {
        SensorsLogMatch sensorsLogMatch = SensorsLogMatch.f12215a;
        boolean z10 = this.initiativeMatch;
        User user = this.user;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        String userId = user.userId();
        boolean d10 = kotlin.jvm.internal.s.d(this._matchSuccessAnimationLiveData.getValue(), Boolean.TRUE);
        FKStoryLabelItemModel value = this._storyLabelLiveData.getValue();
        sensorsLogMatch.c(z10, userId, d10, value != null ? value.getId() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportSendMessageLog(String str, FKSensorContext fKSensorContext, String str2) {
        MsgType msgType = w1.a.f54094a.a(str) != -1 ? MsgType.EMOJI : MsgType.TEXT;
        SensorsLogFeed sensorsLogFeed = SensorsLogFeed.f12208a;
        SensorPosition position = fKSensorContext.getPosition();
        SensorPosition source = fKSensorContext.getSource();
        User user = this.user;
        User user2 = null;
        if (user == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user = null;
        }
        String sensorRelationship = user.getSensorRelationship();
        User user3 = this.user;
        if (user3 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user3 = null;
        }
        Boolean valueOf = Boolean.valueOf(user3.getSuperLikedByMe());
        User user4 = this.user;
        if (user4 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user4 = null;
        }
        Boolean valueOf2 = Boolean.valueOf(user4.getFocus());
        User user5 = this.user;
        if (user5 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
            user5 = null;
        }
        Boolean valueOf3 = Boolean.valueOf(user5.getCloseFriend());
        User user6 = this.user;
        if (user6 == null) {
            kotlin.jvm.internal.s.A(UserData.NAME);
        } else {
            user2 = user6;
        }
        sensorsLogFeed.B(position, source, sensorRelationship, valueOf, valueOf2, valueOf3, str2, user2.userId(), msgType.name(), (r23 & 512) != 0 ? Boolean.FALSE : null);
    }

    public final void changeSelectAvatarPos(int i10) {
        this._selectAvatarPosLiveData.setValue(Integer.valueOf(i10));
    }

    @NotNull
    public final LiveData<List<AvatarProfileModel>> getAvatarsLiveData() {
        return this.avatarsLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getMatchSuccessAnimationLiveData() {
        return this.matchSuccessAnimationLiveData;
    }

    @NotNull
    public final LiveData<Integer> getSelectAvatarPosLiveData() {
        return this.selectAvatarPosLiveData;
    }

    @NotNull
    public final LiveData<Event<StateResult<Boolean>>> getSendMsgStateResult() {
        return this.sendMsgStateResult;
    }

    public final void getStoryLabel() {
        Disposable disposed = a.C0726a.a(NetworkClient.f11868a.i(), null, 1, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ABTestListResult, kotlin.p>() { // from class: com.cupidapp.live.match.activity.MatchSuccessViewModel$getStoryLabel$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ABTestListResult aBTestListResult) {
                m2700invoke(aBTestListResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2700invoke(ABTestListResult aBTestListResult) {
                ABTestModel aBTestModel;
                MutableLiveData mutableLiveData;
                User user;
                ABTestModel aBTestModel2;
                List<ABTestModel> testResults = aBTestListResult.getTestResults();
                if (testResults != null) {
                    Iterator<ABTestModel> iterator2 = testResults.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            aBTestModel2 = null;
                            break;
                        } else {
                            aBTestModel2 = iterator2.next();
                            if (kotlin.jvm.internal.s.d(aBTestModel2.getName(), ABTestKey.STORY_LABEL_TEST.getValue())) {
                                break;
                            }
                        }
                    }
                    aBTestModel = aBTestModel2;
                } else {
                    aBTestModel = null;
                }
                if (kotlin.jvm.internal.s.d(aBTestModel != null ? aBTestModel.getResult() : null, ABTestGroup.C.getValue())) {
                    mutableLiveData = MatchSuccessViewModel.this._storyLabelLiveData;
                    user = MatchSuccessViewModel.this.user;
                    if (user == null) {
                        kotlin.jvm.internal.s.A(UserData.NAME);
                        user = null;
                    }
                    List<FKStoryLabelItemModel> storyLabelList = user.getStoryLabelList();
                    mutableLiveData.setValue(storyLabelList != null ? (FKStoryLabelItemModel) CollectionsKt___CollectionsKt.m0(storyLabelList, Random.Default) : null);
                }
                MatchSuccessViewModel.this.reportMatchSuccess();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.activity.MatchSuccessViewModel$getStoryLabel$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                MatchSuccessViewModel.this.reportMatchSuccess();
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<FKStoryLabelItemModel> getStoryLabelLiveData() {
        return this.storyLabelLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getSuperLikeState() {
        return this.superLikeState;
    }

    public final void initData(@NotNull User user, boolean z10) {
        kotlin.jvm.internal.s.i(user, "user");
        this.user = user;
        this.initiativeMatch = z10;
        this._avatarsLiveData.setValue(user.getAvatarProfile());
        boolean z11 = false;
        boolean z12 = user.getSuperLikedMe() || user.getSuperLikedByMe();
        if (z12) {
            MutableLiveData<Boolean> mutableLiveData = this._superLikeState;
            if (user.getSuperLikedByMe() && !user.getSuperLikedMe()) {
                z11 = true;
            }
            mutableLiveData.setValue(Boolean.valueOf(z11));
        }
        this._matchSuccessAnimationLiveData.setValue(Boolean.valueOf(z12));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void prepareSendMsg(@org.jetbrains.annotations.NotNull final java.lang.String r13, @org.jetbrains.annotations.NotNull com.cupidapp.live.base.sensorslog.InboxMessageType r14, @org.jetbrains.annotations.NotNull final com.cupidapp.live.base.sensorslog.FKSensorContext r15) {
        /*
            r12 = this;
            java.lang.String r0 = "sendMsg"
            kotlin.jvm.internal.s.i(r13, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.s.i(r14, r0)
            java.lang.String r0 = "sensorContext"
            kotlin.jvm.internal.s.i(r15, r0)
            com.cupidapp.live.profile.model.User r0 = r12.user
            java.lang.String r1 = "user"
            r2 = 0
            if (r0 != 0) goto L1a
            kotlin.jvm.internal.s.A(r1)
            r0 = r2
        L1a:
            boolean r0 = r0.getSuperLikedMe()
            if (r0 != 0) goto L32
            com.cupidapp.live.profile.model.User r0 = r12.user
            if (r0 != 0) goto L28
            kotlin.jvm.internal.s.A(r1)
            r0 = r2
        L28:
            boolean r0 = r0.getSuperLikedByMe()
            if (r0 == 0) goto L2f
            goto L32
        L2f:
            r0 = 0
            r8 = 0
            goto L34
        L32:
            r0 = 1
            r8 = 1
        L34:
            com.cupidapp.live.base.sensorslog.SensorsLogMatch r3 = com.cupidapp.live.base.sensorslog.SensorsLogMatch.f12215a
            boolean r4 = r12.initiativeMatch
            com.cupidapp.live.profile.model.User r0 = r12.user
            if (r0 != 0) goto L40
            kotlin.jvm.internal.s.A(r1)
            r0 = r2
        L40:
            java.lang.String r5 = r0.userId()
            androidx.lifecycle.MutableLiveData<com.cupidapp.live.profile.model.FKStoryLabelItemModel> r0 = r12._storyLabelLiveData
            java.lang.Object r0 = r0.getValue()
            com.cupidapp.live.profile.model.FKStoryLabelItemModel r0 = (com.cupidapp.live.profile.model.FKStoryLabelItemModel) r0
            if (r0 == 0) goto L54
            java.lang.String r0 = r0.getId()
            r9 = r0
            goto L55
        L54:
            r9 = r2
        L55:
            r6 = r14
            r7 = r13
            r3.b(r4, r5, r6, r7, r8, r9)
            androidx.lifecycle.MutableLiveData<com.cupidapp.live.base.livedata.Event<com.cupidapp.live.base.network.model.StateResult<java.lang.Boolean>>> r14 = r12._sendMsgStateResult
            com.cupidapp.live.base.livedata.Event r0 = new com.cupidapp.live.base.livedata.Event
            com.cupidapp.live.base.network.model.StateResult$b r3 = new com.cupidapp.live.base.network.model.StateResult$b
            r4 = 3
            r3.<init>(r2, r2, r4, r2)
            r0.<init>(r3)
            r14.setValue(r0)
            long r3 = java.lang.System.currentTimeMillis()
            com.cupidapp.live.base.network.NetworkClient r14 = com.cupidapp.live.base.network.NetworkClient.f11868a
            x1.a r5 = r14.h()
            com.cupidapp.live.profile.model.User r14 = r12.user
            if (r14 != 0) goto L7c
            kotlin.jvm.internal.s.A(r1)
            r14 = r2
        L7c:
            java.lang.String r7 = r14.userId()
            r8 = 0
            java.lang.Long r9 = java.lang.Long.valueOf(r3)
            r10 = 0
            r11 = 0
            r6 = r13
            io.reactivex.Observable r14 = r5.x(r6, r7, r8, r9, r10, r11)
            com.cupidapp.live.match.activity.MatchSuccessViewModel$prepareSendMsg$2 r0 = new com.cupidapp.live.match.activity.MatchSuccessViewModel$prepareSendMsg$2
            r0.<init>()
            com.cupidapp.live.base.network.i r1 = new com.cupidapp.live.base.network.i
            r1.<init>()
            io.reactivex.Observable r14 = r14.flatMap(r1)
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Observable r14 = r14.observeOn(r1)
            com.cupidapp.live.match.activity.MatchSuccessViewModel$prepareSendMsg$$inlined$handle$1 r1 = new com.cupidapp.live.match.activity.MatchSuccessViewModel$prepareSendMsg$$inlined$handle$1
            r1.<init>()
            com.cupidapp.live.base.network.e r13 = new com.cupidapp.live.base.network.e
            r13.<init>(r1)
            com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2 r15 = new com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2
            r15.<init>(r0, r2)
            com.cupidapp.live.base.network.e r0 = new com.cupidapp.live.base.network.e
            r0.<init>(r15)
            io.reactivex.disposables.Disposable r13 = r14.subscribe(r13, r0)
            java.lang.String r14 = "disposed"
            if (r13 == 0) goto Lc1
            kotlin.jvm.internal.s.h(r13, r14)
        Lc1:
            kotlin.jvm.internal.s.h(r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.match.activity.MatchSuccessViewModel.prepareSendMsg(java.lang.String, com.cupidapp.live.base.sensorslog.InboxMessageType, com.cupidapp.live.base.sensorslog.FKSensorContext):void");
    }
}
