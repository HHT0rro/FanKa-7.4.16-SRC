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
import com.cupidapp.live.profile.logic.UserRepository;
import com.cupidapp.live.profile.model.FocusResultModel;
import com.cupidapp.live.profile.model.FocusUserListModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.model.PushAlertScene;
import com.cupidapp.live.push.model.PushAlertShowModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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

/* compiled from: FocusUserManageViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FocusUserManageViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Event<StateResult<Pair<Integer, Boolean>>>> _focusChangeEvent;

    @NotNull
    private final MutableLiveData<StateResult<List<Object>>> _listLiveData;

    @NotNull
    private final MutableLiveData<Event<p>> _tipPushOpenDialog;

    @NotNull
    private final LiveData<Event<StateResult<Pair<Integer, Boolean>>>> focusChangeEvent;

    @NotNull
    private final LiveData<StateResult<List<Object>>> listLiveData;

    @Nullable
    private final FKSensorContext sensorContext;

    @NotNull
    private final LiveData<Event<p>> tipPushOpenDialog;

    @NotNull
    private final UserRepository userRepository;

    public FocusUserManageViewModel(@NotNull UserRepository userRepository, @Nullable FKSensorContext fKSensorContext) {
        s.i(userRepository, "userRepository");
        this.userRepository = userRepository;
        this.sensorContext = fKSensorContext;
        MutableLiveData<StateResult<List<Object>>> mutableLiveData = new MutableLiveData<>();
        this._listLiveData = mutableLiveData;
        this.listLiveData = Transformations.distinctUntilChanged(mutableLiveData);
        MutableLiveData<Event<StateResult<Pair<Integer, Boolean>>>> mutableLiveData2 = new MutableLiveData<>();
        this._focusChangeEvent = mutableLiveData2;
        this.focusChangeEvent = mutableLiveData2;
        MutableLiveData<Event<p>> mutableLiveData3 = new MutableLiveData<>();
        this._tipPushOpenDialog = mutableLiveData3;
        this.tipPushOpenDialog = mutableLiveData3;
        loadData();
    }

    public final void changeFocus(@NotNull final User user, final boolean z10, final int i10) {
        s.i(user, "user");
        Disposable disposed = UserRepository.f(this.userRepository, user.userId(), z10, null, 4, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FocusResultModel, p>() { // from class: com.cupidapp.live.profile.viewmodel.FocusUserManageViewModel$changeFocus$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FocusResultModel focusResultModel) {
                m2770invoke(focusResultModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2770invoke(FocusResultModel focusResultModel) {
                MutableLiveData mutableLiveData;
                FKSensorContext fKSensorContext;
                User.this.setFocus(z10);
                if (z10) {
                    g gVar = g.f52734a;
                    gVar.p2(gVar.F() + 1);
                } else {
                    g gVar2 = g.f52734a;
                    if (gVar2.F() > 0) {
                        gVar2.p2(gVar2.F() - 1);
                    }
                }
                mutableLiveData = this._focusChangeEvent;
                mutableLiveData.setValue(new Event(new StateResult.c(new Pair(Integer.valueOf(i10), Boolean.valueOf(z10)), null, 2, null)));
                GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
                String userId = User.this.userId();
                SensorPosition sensorPosition = SensorPosition.Focus;
                fKSensorContext = this.sensorContext;
                groupSocialLog.Z(userId, sensorPosition, fKSensorContext != null ? fKSensorContext.getPosition() : null, z10);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.FocusUserManageViewModel$changeFocus$2
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
                int value = RequestErrorCode.FocusNoRemains.getValue();
                boolean z11 = true;
                if (valueOf != null && valueOf.intValue() == value) {
                    mutableLiveData2 = FocusUserManageViewModel.this._focusChangeEvent;
                    mutableLiveData2.setValue(new Event(new StateResult.a(it.getMessage(), new Pair(Integer.valueOf(i10), Boolean.valueOf(!z10)), null, 4, null)));
                } else {
                    mutableLiveData = FocusUserManageViewModel.this._focusChangeEvent;
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
        Disposable disposed = NetworkClient.f11868a.F().f(PushAlertScene.FocusManageListScene.getValue()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<PushAlertShowModel, p>() { // from class: com.cupidapp.live.profile.viewmodel.FocusUserManageViewModel$checkAlertPushTip$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(PushAlertShowModel pushAlertShowModel) {
                m2771invoke(pushAlertShowModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2771invoke(PushAlertShowModel pushAlertShowModel) {
                MutableLiveData mutableLiveData;
                if (pushAlertShowModel.getShow()) {
                    mutableLiveData = FocusUserManageViewModel.this._tipPushOpenDialog;
                    mutableLiveData.setValue(new Event(p.f51048a));
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.FocusUserManageViewModel$checkAlertPushTip$2
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
    public final LiveData<Event<StateResult<Pair<Integer, Boolean>>>> getFocusChangeEvent() {
        return this.focusChangeEvent;
    }

    @NotNull
    public final LiveData<StateResult<List<Object>>> getListLiveData() {
        return this.listLiveData;
    }

    @NotNull
    public final LiveData<Event<p>> getTipPushOpenDialog() {
        return this.tipPushOpenDialog;
    }

    public final void loadData() {
        if (this.listLiveData.getValue() instanceof StateResult.b) {
            return;
        }
        this._listLiveData.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = this.userRepository.g().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<FocusUserListModel, p>() { // from class: com.cupidapp.live.profile.viewmodel.FocusUserManageViewModel$loadData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(FocusUserListModel focusUserListModel) {
                m2772invoke(focusUserListModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2772invoke(FocusUserListModel focusUserListModel) {
                MutableLiveData mutableLiveData;
                FocusUserListModel focusUserListModel2 = focusUserListModel;
                ArrayList arrayList = new ArrayList();
                List<User> list = focusUserListModel2.getList();
                if (list == null || list.isEmpty()) {
                    List<User> rcmdList = focusUserListModel2.getRcmdList();
                    if (rcmdList == null || rcmdList.isEmpty()) {
                        arrayList.add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_focus_list_empty), Integer.valueOf(R$string.focus_more_people), null, -15066598, null, null, null, false, null, null, 1012, null));
                        mutableLiveData = FocusUserManageViewModel.this._listLiveData;
                        mutableLiveData.setValue(new StateResult.c(arrayList, null, 2, null));
                    }
                }
                arrayList.add(new FKTitleModel(R$string.my_focus));
                List<User> list2 = focusUserListModel2.getList();
                if (list2 == null || list2.isEmpty()) {
                    g.f52734a.p2(0);
                    arrayList.add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_my_focus_empty), Integer.valueOf(R$string.no_focus_empty), null, -15066598, null, Integer.valueOf(h.c(FocusUserManageViewModel.this, 160.0f)), Float.valueOf(13.0f), false, null, null, MetricsProto.MetricsEvent.AUTOFILL_SAVE_UI, null));
                } else {
                    g.f52734a.p2(focusUserListModel2.getList().size());
                    arrayList.addAll(focusUserListModel2.getList());
                }
                arrayList.add(new FKTitleModel(R$string.recommend));
                List<User> rcmdList2 = focusUserListModel2.getRcmdList();
                if (rcmdList2 == null || rcmdList2.isEmpty()) {
                    arrayList.add(new FKEmptyViewModel(Integer.valueOf(R$mipmap.ic_focus_list_empty), Integer.valueOf(R$string.focus_more_people), null, -15066598, null, Integer.valueOf(h.c(FocusUserManageViewModel.this, 160.0f)), Float.valueOf(13.0f), false, null, null, MetricsProto.MetricsEvent.AUTOFILL_SAVE_UI, null));
                } else {
                    arrayList.addAll(focusUserListModel2.getRcmdList());
                }
                mutableLiveData = FocusUserManageViewModel.this._listLiveData;
                mutableLiveData.setValue(new StateResult.c(arrayList, null, 2, null));
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.profile.viewmodel.FocusUserManageViewModel$loadData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = FocusUserManageViewModel.this._listLiveData;
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
