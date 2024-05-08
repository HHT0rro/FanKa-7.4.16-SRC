package com.cupidapp.live.setting.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.login.activity.InputPhoneNumberActivity;
import com.cupidapp.live.login.model.AuthResult;
import com.cupidapp.live.setting.adapter.SwitchAccountAdapter;
import com.cupidapp.live.setting.helper.SwitchAccountHelper;
import com.cupidapp.live.setting.holder.AddSwitchAccountUiModel;
import com.cupidapp.live.setting.model.SwitchAccountResult;
import com.cupidapp.live.setting.model.SwitchAccountStatus;
import com.cupidapp.live.setting.model.SwitchAccountUserModel;
import com.cupidapp.live.setting.viewmodel.SwitchAccountViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SwitchAccountDialogFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwitchAccountDialogFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f18132l = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f18133e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final SwitchAccountAdapter f18134f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final SensorPosition f18135g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public b f18136h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f18137i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f18138j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18139k = new LinkedHashMap();

    /* compiled from: SwitchAccountDialogFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager manager, @Nullable SwitchAccountResult switchAccountResult, @NotNull b listener) {
            kotlin.jvm.internal.s.i(manager, "manager");
            kotlin.jvm.internal.s.i(listener, "listener");
            SwitchAccountDialogFragment switchAccountDialogFragment = new SwitchAccountDialogFragment();
            Bundle bundle = new Bundle();
            if (switchAccountResult != null) {
                z0.g.d(bundle, switchAccountResult);
            }
            switchAccountDialogFragment.setArguments(bundle);
            switchAccountDialogFragment.f18136h = listener;
            switchAccountDialogFragment.show(manager, SwitchAccountDialogFragment.class.getSimpleName());
        }
    }

    /* compiled from: SwitchAccountDialogFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a();
    }

    public SwitchAccountDialogFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.setting.fragment.SwitchAccountDialogFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f18133e = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(SwitchAccountViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.setting.fragment.SwitchAccountDialogFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.f18134f = new SwitchAccountAdapter();
        this.f18135g = SensorPosition.Setting;
        this.f18138j = true;
    }

    public static final void g1(SwitchAccountDialogFragment this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        SwitchAccountAdapter switchAccountAdapter = this$0.f18134f;
        kotlin.jvm.internal.s.h(list, "list");
        switchAccountAdapter.u(list, null);
    }

    public static final void h1(SwitchAccountDialogFragment this$0, AuthResult result) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity instanceof FKBaseActivity) {
            com.cupidapp.live.base.view.dialog.h.d(com.cupidapp.live.base.view.dialog.h.f12743a, this$0.getString(R$string.account_switching), false, 2, null);
            com.cupidapp.live.setting.helper.a aVar = new com.cupidapp.live.setting.helper.a(true, true, null, null, 12, null);
            kotlin.jvm.internal.s.h(result, "result");
            SwitchAccountHelper.f18181a.f((FKBaseActivity) activity, result, aVar);
            this$0.Q0();
        }
    }

    public static final void i1(SwitchAccountDialogFragment this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        boolean z10 = false;
        if (stateResult instanceof StateResult.b) {
            z10 = true;
        } else if (!(stateResult instanceof StateResult.a) && !(stateResult instanceof StateResult.c)) {
            throw new NoWhenBranchMatchedException();
        }
        this$0.f18137i = z10;
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f18139k.clear();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public boolean P0() {
        return this.f18138j;
    }

    @Nullable
    public View Y0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18139k;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void c1() {
        this.f18134f.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.SwitchAccountDialogFragment$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof AddSwitchAccountUiModel) {
                    SensorsLogKeyButtonClick.UserSetting.ADD_ACCOUNT.click();
                    InputPhoneNumberActivity.f16098t.a(SwitchAccountDialogFragment.this.getContext(), InputPhoneNumberActivity.PageSource.SwitchAccount);
                    SwitchAccountDialogFragment.this.Q0();
                } else if (obj instanceof SwitchAccountUserModel) {
                    SwitchAccountDialogFragment.this.d1((SwitchAccountUserModel) obj);
                }
            }
        });
    }

    public final void d1(SwitchAccountUserModel switchAccountUserModel) {
        if (kotlin.jvm.internal.s.d(switchAccountUserModel.getUsed(), Boolean.TRUE) || this.f18137i) {
            return;
        }
        z3.e.f54837a.J(switchAccountUserModel.getUserId(), this.f18135g);
        if (switchAccountUserModel.getStatus() != SwitchAccountStatus.Normal.getValue()) {
            j.a.b(com.cupidapp.live.base.router.j.f12156c, getContext(), switchAccountUserModel.getJumpUrl(), null, 4, null);
            Q0();
        } else {
            e1().callSwitchAccountApi(switchAccountUserModel);
        }
    }

    public final SwitchAccountViewModel e1() {
        return (SwitchAccountViewModel) this.f18133e.getValue();
    }

    public final void f1() {
        e1().getAccountListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.fragment.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SwitchAccountDialogFragment.g1(SwitchAccountDialogFragment.this, (List) obj);
            }
        });
        e1().getSwitchAccountLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.fragment.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SwitchAccountDialogFragment.h1(SwitchAccountDialogFragment.this, (AuthResult) obj);
            }
        });
        e1().getSwitchAccountFailRefreshList().observe(this, new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.SwitchAccountDialogFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str) {
                invoke2(str);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String errorMessage) {
                kotlin.jvm.internal.s.i(errorMessage, "errorMessage");
                FKAlertDialog n10 = FKAlertDialog.a.c(FKAlertDialog.f12698l, SwitchAccountDialogFragment.this.getContext(), false, 2, null).n(errorMessage);
                final SwitchAccountDialogFragment switchAccountDialogFragment = SwitchAccountDialogFragment.this;
                FKAlertDialog.G(FKAlertDialog.w(n10, R$string.i_know_it, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.SwitchAccountDialogFragment$initObserve$3.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ kotlin.p invoke() {
                        invoke2();
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        SwitchAccountViewModel e12;
                        e12 = SwitchAccountDialogFragment.this.e1();
                        e12.callGetAccountListDataApi();
                    }
                }, 2, null), null, 1, null);
            }
        }));
        e1().getSwitchAccountLoadingState().observe(this, new Observer() { // from class: com.cupidapp.live.setting.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SwitchAccountDialogFragment.i1(SwitchAccountDialogFragment.this, (StateResult) obj);
            }
        });
    }

    public final void j1() {
        SwitchAccountResult switchAccountResult;
        Bundle arguments = getArguments();
        if (arguments != null && (switchAccountResult = (SwitchAccountResult) z0.g.b(arguments, SwitchAccountResult.class)) != null) {
            e1().setSwitchAccountResult(switchAccountResult);
        }
        e1().callGetAccountListDataApi();
    }

    public final void k1() {
        RecyclerView recyclerView = (RecyclerView) Y0(R$id.switch_account_dialog_recycler_view);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(this.f18134f);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        kotlin.jvm.internal.s.h(recyclerView, "this");
        U0(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_switch_account_dialog, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        kotlin.jvm.internal.s.i(dialog, "dialog");
        super.onDismiss(dialog);
        b bVar = this.f18136h;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        k1();
        f1();
        j1();
        c1();
        j1.i.g(j1.i.f50236a, PopupName.SWITCH_ACCOUNT_ALERT, this.f18135g, null, 4, null);
    }
}
