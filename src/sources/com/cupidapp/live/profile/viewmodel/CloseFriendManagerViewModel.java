package com.cupidapp.live.profile.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.android.internal.logging.nano.MetricsProto;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.recyclerview.model.FKEmptyViewModel;
import com.cupidapp.live.base.recyclerview.model.FKTitleModel;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.profile.model.CloseFriendListModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.model.PushAlertScene;
import com.cupidapp.live.push.model.PushAlertShowModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j3.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;
import z0.t;

/* compiled from: CloseFriendManagerViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CloseFriendManagerViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<StateResult<Pair<Integer, Boolean>>>> _closeFriendChangeEvent;

    @NotNull
    private final MutableLiveData<StateResult<Pair<List<Object>, Boolean>>> _listLiveData;

    @NotNull
    private final MutableLiveData<Event<p>> _tipPushOpenDialog;

    @NotNull
    private final LiveData<Event<StateResult<Pair<Integer, Boolean>>>> closeFriendChangeEvent;

    @NotNull
    private final LiveData<StateResult<Pair<List<Object>, Boolean>>> listLiveData;

    @Nullable
    private String nextCursorId;

    @Nullable
    private final FKSensorContext sensorContext;

    @NotNull
    private final LiveData<Event<p>> tipPushOpenDialog;

    public CloseFriendManagerViewModel(@Nullable FKSensorContext fKSensorContext) {
        this.sensorContext = fKSensorContext;
        MutableLiveData<StateResult<Pair<List<Object>, Boolean>>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        this.listLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<Event<StateResult<Pair<Integer, Boolean>>>> mutableLiveData2 = new MutableLiveData<>();
        this._closeFriendChangeEvent = mutableLiveData2;
        this.closeFriendChangeEvent = mutableLiveData2;
        MutableLiveData<Event<p>> mutableLiveData3 = new MutableLiveData<>();
        this._tipPushOpenDialog = mutableLiveData3;
        this.tipPushOpenDialog = mutableLiveData3;
        loadData(true);
        loadCount();
    }

    private final void loadCount() {
        Disposable disposed = NetworkClient.f11868a.N().v0().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<a, p>() { // from class: com.cupidapp.live.profile.viewmodel.CloseFriendManagerViewModel$loadCount$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(a aVar) {
                m2767invoke(aVar);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2767invoke(a aVar) {
                g gVar = g.f52734a;
                Integer a10 = aVar.a();
                gVar.Z1(a10 != null ? a10.intValue() : 0);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.CloseFriendManagerViewModel$loadCount$2
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
    }

    public final void changeCloseFriend(@NotNull final User user, final boolean z10, final int i10) {
        s.i(user, "user");
        Disposable disposed = NetworkClient.f11868a.N().O0(user.userId(), z10).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.profile.viewmodel.CloseFriendManagerViewModel$changeCloseFriend$$inlined$handle$1
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
                FKSensorContext fKSensorContext;
                User.this.setCloseFriend(z10);
                if (z10) {
                    g gVar = g.f52734a;
                    gVar.Z1(gVar.n() + 1);
                } else {
                    g gVar2 = g.f52734a;
                    if (gVar2.n() > 0) {
                        gVar2.Z1(gVar2.n() - 1);
                    }
                }
                mutableLiveData = this._closeFriendChangeEvent;
                mutableLiveData.setValue(new Event(new StateResult.c(new Pair(Integer.valueOf(i10), Boolean.valueOf(z10)), null, 2, null)));
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                String userId = User.this.userId();
                SensorPosition sensorPosition = SensorPosition.CloseFriend;
                fKSensorContext = this.sensorContext;
                groupSocialLog.Y(userId, sensorPosition, fKSensorContext != null ? fKSensorContext.getPosition() : null, z10);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.CloseFriendManagerViewModel$changeCloseFriend$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                s.i(it, "it");
                String a10 = j.f12008a.a(it);
                Integer valueOf = a10 != null ? Integer.valueOf(t.q(a10)) : null;
                int value = RequestErrorCode.CloseFriendNoRemains.getValue();
                boolean z11 = true;
                if (valueOf != null && valueOf.intValue() == value) {
                    mutableLiveData2 = CloseFriendManagerViewModel.this._closeFriendChangeEvent;
                    mutableLiveData2.setValue(new Event(new StateResult.a(it.getMessage(), new Pair(Integer.valueOf(i10), Boolean.valueOf(!z10)), null, 4, null)));
                } else {
                    mutableLiveData = CloseFriendManagerViewModel.this._closeFriendChangeEvent;
                    mutableLiveData.setValue(new Event(new StateResult.a(null, new Pair(Integer.valueOf(i10), Boolean.valueOf(true ^ z10)), null, 4, null)));
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void checkAlertPushTip() {
        Disposable disposed = NetworkClient.f11868a.F().f(PushAlertScene.CloseFriendManageScene.getValue()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<PushAlertShowModel, p>() { // from class: com.cupidapp.live.profile.viewmodel.CloseFriendManagerViewModel$checkAlertPushTip$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PushAlertShowModel pushAlertShowModel) {
                m2766invoke(pushAlertShowModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2766invoke(PushAlertShowModel pushAlertShowModel) {
                MutableLiveData mutableLiveData;
                if (pushAlertShowModel.getShow()) {
                    mutableLiveData = CloseFriendManagerViewModel.this._tipPushOpenDialog;
                    mutableLiveData.setValue(new Event(p.f51048a));
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.CloseFriendManagerViewModel$checkAlertPushTip$2
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
    }

    @NotNull
    public final LiveData<Event<StateResult<Pair<Integer, Boolean>>>> getCloseFriendChangeEvent() {
        return this.closeFriendChangeEvent;
    }

    @NotNull
    public final LiveData<StateResult<Pair<List<Object>, Boolean>>> getListLiveData() {
        return this.listLiveData;
    }

    @NotNull
    public final LiveData<Event<p>> getTipPushOpenDialog() {
        return this.tipPushOpenDialog;
    }

    public final void loadData(final boolean z10) {
        if (this.listLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        if (z10) {
            this.nextCursorId = null;
        } else if (this.nextCursorId == null) {
            return;
        }
        this._listLiveData.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = NetworkClient.f11868a.N().R(this.nextCursorId).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<CloseFriendListModel, p>() { // from class: com.cupidapp.live.profile.viewmodel.CloseFriendManagerViewModel$loadData$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(CloseFriendListModel closeFriendListModel) {
                m2768invoke(closeFriendListModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2768invoke(CloseFriendListModel closeFriendListModel) {
                MutableLiveData mutableLiveData;
                CloseFriendListModel closeFriendListModel2 = closeFriendListModel;
                ArrayList arrayList = new ArrayList();
                if (z10) {
                    List<User> closeFriendList = closeFriendListModel2.getCloseFriendList();
                    if (closeFriendList == null || closeFriendList.isEmpty()) {
                        List<User> recommendList = closeFriendListModel2.getRecommendList();
                        if (recommendList == null || recommendList.isEmpty()) {
                            arrayList.add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_focus_list_empty), Integer.valueOf(R$string.no_match_friend), null, -15066598, null, null, null, false, null, null, 1012, null));
                        }
                    }
                    arrayList.add(new FKTitleModel(R$string.my_close_friend));
                    List<User> closeFriendList2 = closeFriendListModel2.getCloseFriendList();
                    if (closeFriendList2 == null || closeFriendList2.isEmpty()) {
                        arrayList.add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_close_friend_list_empty), Integer.valueOf(R$string.no_close_friend), null, -15066598, null, Integer.valueOf(h.c(this, 160.0f)), Float.valueOf(13.0f), false, null, null, MetricsProto.MetricsEvent.AUTOFILL_SAVE_UI, null));
                    } else {
                        arrayList.addAll(closeFriendListModel2.getCloseFriendList());
                    }
                    String nextCursorId = closeFriendListModel2.getNextCursorId();
                    if ((nextCursorId == null || nextCursorId.length() == 0) && z10) {
                        arrayList.add(new FKTitleModel(R$string.recommend));
                        List<User> recommendList2 = closeFriendListModel2.getRecommendList();
                        if (recommendList2 == null || recommendList2.isEmpty()) {
                            arrayList.add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_focus_list_empty), Integer.valueOf(R$string.no_match_friend), null, -15066598, null, Integer.valueOf(h.c(this, 160.0f)), Float.valueOf(13.0f), false, null, null, MetricsProto.MetricsEvent.AUTOFILL_SAVE_UI, null));
                        } else {
                            arrayList.addAll(closeFriendListModel2.getRecommendList());
                        }
                    }
                } else {
                    List<User> closeFriendList3 = closeFriendListModel2.getCloseFriendList();
                    if (!(closeFriendList3 == null || closeFriendList3.isEmpty())) {
                        arrayList.addAll(closeFriendListModel2.getCloseFriendList());
                    }
                }
                mutableLiveData = this._listLiveData;
                mutableLiveData.setValue(new StateResult.c(new Pair(arrayList, Boolean.valueOf(z10)), null, 2, null));
                this.nextCursorId = closeFriendListModel2.getNextCursorId();
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.CloseFriendManagerViewModel$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = CloseFriendManagerViewModel.this._listLiveData;
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
