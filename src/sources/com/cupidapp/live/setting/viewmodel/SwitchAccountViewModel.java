package com.cupidapp.live.setting.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.login.model.AuthResult;
import com.cupidapp.live.setting.helper.MultiAccountUserIdManager;
import com.cupidapp.live.setting.model.MultiAccountUserIdsModel;
import com.cupidapp.live.setting.model.SwitchAccountResult;
import com.cupidapp.live.setting.model.SwitchAccountUserModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import n3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: SwitchAccountViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwitchAccountViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<List<SwitchAccountUserModel>> _accountListLiveData;

    @NotNull
    private final MutableLiveData<SwitchAccountUserModel> _removeAccountLiveData;

    @NotNull
    private final MutableLiveData<Event<String>> _switchAccountFailRefreshList;

    @NotNull
    private final MutableLiveData<AuthResult> _switchAccountLiveData;

    @NotNull
    private final MutableLiveData<StateResult<Boolean>> _switchAccountLoadingState;

    @NotNull
    private final LiveData<List<SwitchAccountUserModel>> accountListLiveData;

    @NotNull
    private final LiveData<SwitchAccountUserModel> removeAccountLiveData;

    @NotNull
    private final LiveData<Event<String>> switchAccountFailRefreshList;

    @NotNull
    private final LiveData<AuthResult> switchAccountLiveData;

    @NotNull
    private final LiveData<StateResult<Boolean>> switchAccountLoadingState;

    public SwitchAccountViewModel() {
        MutableLiveData<List<SwitchAccountUserModel>> mutableLiveData = new MutableLiveData<>();
        this._accountListLiveData = mutableLiveData;
        this.accountListLiveData = mutableLiveData;
        MutableLiveData<SwitchAccountUserModel> mutableLiveData2 = new MutableLiveData<>();
        this._removeAccountLiveData = mutableLiveData2;
        this.removeAccountLiveData = mutableLiveData2;
        MutableLiveData<AuthResult> mutableLiveData3 = new MutableLiveData<>();
        this._switchAccountLiveData = mutableLiveData3;
        this.switchAccountLiveData = mutableLiveData3;
        MutableLiveData<Event<String>> mutableLiveData4 = new MutableLiveData<>();
        this._switchAccountFailRefreshList = mutableLiveData4;
        this.switchAccountFailRefreshList = mutableLiveData4;
        MutableLiveData<StateResult<Boolean>> mutableLiveData5 = new MutableLiveData<>();
        this._switchAccountLoadingState = mutableLiveData5;
        this.switchAccountLoadingState = mutableLiveData5;
    }

    public final void callGetAccountListDataApi() {
        MultiAccountUserIdsModel p02 = g.f52734a.p0();
        List<String> list = p02 != null ? p02.getList() : null;
        if (list == null || list.isEmpty()) {
            return;
        }
        Disposable disposed = b.a.a(NetworkClient.f11868a.w(), list, false, false, 6, null).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SwitchAccountResult, p>() { // from class: com.cupidapp.live.setting.viewmodel.SwitchAccountViewModel$callGetAccountListDataApi$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SwitchAccountResult switchAccountResult) {
                m2809invoke(switchAccountResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2809invoke(SwitchAccountResult switchAccountResult) {
                MutableLiveData mutableLiveData;
                List<SwitchAccountUserModel> accountList = switchAccountResult.getAccountList();
                if (accountList != null) {
                    mutableLiveData = SwitchAccountViewModel.this._accountListLiveData;
                    mutableLiveData.setValue(accountList);
                    MultiAccountUserIdManager.f18178a.c(accountList);
                }
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callRemoveAccountApi(@NotNull final SwitchAccountUserModel model) {
        s.i(model, "model");
        Disposable disposed = NetworkClient.f11868a.w().b(model.getUserId()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.setting.viewmodel.SwitchAccountViewModel$callRemoveAccountApi$$inlined$handle$default$1
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
                mutableLiveData = SwitchAccountViewModel.this._removeAccountLiveData;
                mutableLiveData.setValue(model);
                MultiAccountUserIdManager.f18178a.b(model.getUserId());
                z3.e.f54837a.I(model.getUserId());
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    public final void callSwitchAccountApi(@NotNull SwitchAccountUserModel model) {
        s.i(model, "model");
        this._switchAccountLoadingState.setValue(new StateResult.b(null, null, 3, null));
        Disposable disposed = NetworkClient.f11868a.w().c(model.getUserId(), false).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<AuthResult, p>() { // from class: com.cupidapp.live.setting.viewmodel.SwitchAccountViewModel$callSwitchAccountApi$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AuthResult authResult) {
                m2810invoke(authResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2810invoke(AuthResult authResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = SwitchAccountViewModel.this._switchAccountLoadingState;
                mutableLiveData.setValue(new StateResult.c(null, null, 3, null));
                mutableLiveData2 = SwitchAccountViewModel.this._switchAccountLiveData;
                mutableLiveData2.setValue(authResult);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.viewmodel.SwitchAccountViewModel$callSwitchAccountApi$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                MutableLiveData mutableLiveData;
                s.i(it, "it");
                mutableLiveData = SwitchAccountViewModel.this._switchAccountLoadingState;
                mutableLiveData.setValue(new StateResult.a(null, null, null, 7, null));
                Integer valueOf = Integer.valueOf(RequestErrorCode.MultiAccountSwitchFail.getValue());
                final SwitchAccountViewModel switchAccountViewModel = SwitchAccountViewModel.this;
                j.f(j.f12008a, it, null, i0.h(f.a(valueOf, new Function1<String, p>() { // from class: com.cupidapp.live.setting.viewmodel.SwitchAccountViewModel$callSwitchAccountApi$2$interceptor$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(String str) {
                        invoke2(str);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable String str) {
                        MutableLiveData mutableLiveData2;
                        if (str == null || str.length() == 0) {
                            return;
                        }
                        mutableLiveData2 = SwitchAccountViewModel.this._switchAccountFailRefreshList;
                        mutableLiveData2.setValue(new Event(str));
                    }
                })), null, 10, null);
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            s.h(disposed, "disposed");
        }
        s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<List<SwitchAccountUserModel>> getAccountListLiveData() {
        return this.accountListLiveData;
    }

    @NotNull
    public final LiveData<SwitchAccountUserModel> getRemoveAccountLiveData() {
        return this.removeAccountLiveData;
    }

    @NotNull
    public final LiveData<Event<String>> getSwitchAccountFailRefreshList() {
        return this.switchAccountFailRefreshList;
    }

    @NotNull
    public final LiveData<AuthResult> getSwitchAccountLiveData() {
        return this.switchAccountLiveData;
    }

    @NotNull
    public final LiveData<StateResult<Boolean>> getSwitchAccountLoadingState() {
        return this.switchAccountLoadingState;
    }

    public final void setSwitchAccountResult(@NotNull SwitchAccountResult result) {
        s.i(result, "result");
        List<SwitchAccountUserModel> accountList = result.getAccountList();
        if (accountList != null) {
            this._accountListLiveData.setValue(accountList);
        }
    }
}
