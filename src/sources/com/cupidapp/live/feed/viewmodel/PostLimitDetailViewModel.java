package com.cupidapp.live.feed.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import com.cupidapp.live.feed.model.PostLimitDetailResult;
import com.cupidapp.live.profile.model.PostLimitReadStatus;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.model.FollowType;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: PostLimitDetailViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitDetailViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<String>> _delPostEvent;

    @NotNull
    private final MutableLiveData<StateResult<PostLimitDetailModel>> _resultLiveData;

    @NotNull
    private final LiveData<Event<String>> delPostEvent;

    @Nullable
    private PostLimitReadStatus meReadStatus;

    @Nullable
    private final String messageId;

    @Nullable
    private final String postLimitId;

    @NotNull
    private final Set<String> readList;

    @NotNull
    private final LiveData<StateResult<PostLimitDetailModel>> resultLiveData;

    @NotNull
    private final FKSensorContext sensorContext;

    public PostLimitDetailViewModel(@Nullable String str, @Nullable String str2, @NotNull FKSensorContext sensorContext) {
        s.i(sensorContext, "sensorContext");
        this.postLimitId = str;
        this.messageId = str2;
        this.sensorContext = sensorContext;
        MutableLiveData<StateResult<PostLimitDetailModel>> mutableLiveData = new MutableLiveData<>();
        this._resultLiveData = mutableLiveData;
        this.resultLiveData = mutableLiveData;
        MutableLiveData<Event<String>> mutableLiveData2 = new MutableLiveData<>();
        this._delPostEvent = mutableLiveData2;
        this.delPostEvent = mutableLiveData2;
        this.readList = new LinkedHashSet();
    }

    public final void deleteLimitPost(@NotNull final String postLimitId) {
        s.i(postLimitId, "postLimitId");
        Disposable disposed = NetworkClient.f11868a.l().F(postLimitId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitDetailViewModel$deleteLimitPost$$inlined$handle$default$1
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
                mutableLiveData = PostLimitDetailViewModel.this._delPostEvent;
                mutableLiveData.setValue(new Event(postLimitId));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void follow(@Nullable final String str) {
        if (str == null) {
            return;
        }
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), str, null, null, FollowPrefer.PostLimitRefer.getValue(), FollowType.Default.getValue(), null, null, null, 224, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitDetailViewModel$follow$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2581invoke(swipeCardUserLikeResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2581invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                MutableLiveData mutableLiveData;
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                StateResult<PostLimitDetailModel> value = PostLimitDetailViewModel.this.getResultLiveData().getValue();
                PostLimitDetailModel data = value != null ? value.getData() : null;
                if (data != null) {
                    User user = data.getUser();
                    if (user != null) {
                        user.setAloha(swipeCardUserLikeResult2.getUser().getAloha());
                    }
                    User user2 = data.getUser();
                    if (user2 != null) {
                        user2.setMatch(swipeCardUserLikeResult2.getUser().getMatch());
                    }
                    User user3 = data.getUser();
                    if (user3 != null) {
                        user3.setCanSendInboxMessage(swipeCardUserLikeResult2.getUser().getCanSendInboxMessage());
                    }
                    mutableLiveData = PostLimitDetailViewModel.this._resultLiveData;
                    mutableLiveData.setValue(new StateResult.c(data, null, 2, null));
                }
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                SensorScene scene = PostLimitDetailViewModel.this.getSensorContext().getScene();
                String value2 = scene != null ? scene.getValue() : null;
                groupSocialLog.B(true, value2, str, (r52 & 8) != 0 ? 1 : 1, (r52 & 16) != 0 ? null : Boolean.valueOf(swipeCardUserLikeResult2.getUser().isAlohaMatched()), (r52 & 32) != 0 ? null : swipeCardUserLikeResult2.getRecommendContext(), (r52 & 64) != 0 ? false : false, (r52 & 128) != 0 ? null : null, (r52 & 256) != 0 ? null : SensorPosition.PostLimit, (r52 & 512) != 0 ? false : swipeCardUserLikeResult2.getUser().getSuperLikedByMe(), (r52 & 1024) != 0 ? null : null, (r52 & 2048) != 0 ? null : null, (r52 & 4096) != 0 ? 0 : 0, (r52 & 8192) != 0 ? null : null, (r52 & 16384) != 0 ? false : false, (32768 & r52) != 0 ? null : null, (65536 & r52) != 0 ? null : null, (131072 & r52) != 0 ? null : null, (262144 & r52) != 0 ? null : null, (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : null, (2097152 & r52) != 0 ? null : null, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : null);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<String>> getDelPostEvent() {
        return this.delPostEvent;
    }

    @Nullable
    public final PostLimitReadStatus getMeReadStatus() {
        return this.meReadStatus;
    }

    @Nullable
    public final String getMessageId() {
        return this.messageId;
    }

    @Nullable
    public final String getPostLimitId() {
        return this.postLimitId;
    }

    @NotNull
    public final Set<String> getReadList() {
        return this.readList;
    }

    @NotNull
    public final LiveData<StateResult<PostLimitDetailModel>> getResultLiveData() {
        return this.resultLiveData;
    }

    @NotNull
    public final FKSensorContext getSensorContext() {
        return this.sensorContext;
    }

    public final void loadData() {
        String str = this.postLimitId;
        if (str != null) {
            this._resultLiveData.setValue(new StateResult.b(null, null, 3, null));
            Disposable disposed = NetworkClient.f11868a.l().Z(str, this.messageId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<PostLimitDetailResult, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitDetailViewModel$loadData$lambda$1$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(PostLimitDetailResult postLimitDetailResult) {
                    m2582invoke(postLimitDetailResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2582invoke(PostLimitDetailResult postLimitDetailResult) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = PostLimitDetailViewModel.this._resultLiveData;
                    mutableLiveData.setValue(new StateResult.c(postLimitDetailResult.getPostLimit(), null, 2, null));
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitDetailViewModel$loadData$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    MutableLiveData mutableLiveData;
                    s.i(it, "it");
                    mutableLiveData = PostLimitDetailViewModel.this._resultLiveData;
                    mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                    return Boolean.FALSE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public final void readPostLimit(@NotNull String postLimitId, @Nullable String str) {
        s.i(postLimitId, "postLimitId");
        if (str != null) {
            Disposable disposed = NetworkClient.f11868a.l().i(postLimitId, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitDetailViewModel$readPostLimit$$inlined$handle$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.feed.viewmodel.PostLimitDetailViewModel$readPostLimit$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    return Boolean.TRUE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
            this.readList.add(str);
        }
    }

    public final void setData(@NotNull PostLimitDetailModel model) {
        s.i(model, "model");
        this._resultLiveData.setValue(new StateResult.c(model, null, 2, null));
    }

    public final void setMeReadStatus(@Nullable PostLimitReadStatus postLimitReadStatus) {
        this.meReadStatus = postLimitReadStatus;
    }

    public final void uploadUserFocus(@NotNull User user) {
        s.i(user, "user");
        StateResult<PostLimitDetailModel> value = this.resultLiveData.getValue();
        PostLimitDetailModel data = value != null ? value.getData() : null;
        if (data != null) {
            User user2 = data.getUser();
            if (user2 != null) {
                user2.setAloha(user.getAloha());
            }
            User user3 = data.getUser();
            if (user3 != null) {
                user3.setMatch(user.getMatch());
            }
            User user4 = data.getUser();
            if (user4 != null) {
                user4.setCanSendInboxMessage(user.getCanSendInboxMessage());
            }
            this._resultLiveData.setValue(new StateResult.c(data, null, 2, null));
        }
    }
}
