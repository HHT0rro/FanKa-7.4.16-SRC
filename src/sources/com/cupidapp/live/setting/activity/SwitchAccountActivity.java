package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.login.activity.InputPhoneNumberActivity;
import com.cupidapp.live.login.model.AuthResult;
import com.cupidapp.live.setting.adapter.SwitchAccountAdapter;
import com.cupidapp.live.setting.helper.SwitchAccountHelper;
import com.cupidapp.live.setting.holder.AddSwitchAccountUiModel;
import com.cupidapp.live.setting.model.SwitchAccountStatus;
import com.cupidapp.live.setting.model.SwitchAccountUserModel;
import com.cupidapp.live.setting.viewmodel.SwitchAccountViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SwitchAccountActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SwitchAccountActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f18015t = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f18016q;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18018s = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final SwitchAccountAdapter f18017r = new SwitchAccountAdapter();

    /* compiled from: SwitchAccountActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            context.startActivity(new Intent(context, (Class<?>) SwitchAccountActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public SwitchAccountActivity() {
        final Function0 function0 = null;
        this.f18016q = new ViewModelLazy(kotlin.jvm.internal.v.b(SwitchAccountViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                kotlin.jvm.internal.s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                kotlin.jvm.internal.s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void A1(SwitchAccountActivity this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            com.cupidapp.live.base.view.dialog.h.d(com.cupidapp.live.base.view.dialog.h.f12743a, this$0.getString(R$string.account_switching), false, 2, null);
        } else if (stateResult instanceof StateResult.a) {
            com.cupidapp.live.base.view.dialog.h.f12743a.b();
        }
    }

    public static final void x1(SwitchAccountActivity this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        SwitchAccountAdapter switchAccountAdapter = this$0.f18017r;
        kotlin.jvm.internal.s.h(list, "list");
        switchAccountAdapter.u(list, this$0.Q0());
    }

    public static final void y1(SwitchAccountActivity this$0, SwitchAccountUserModel model) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        SwitchAccountAdapter switchAccountAdapter = this$0.f18017r;
        kotlin.jvm.internal.s.h(model, "model");
        switchAccountAdapter.x(model);
    }

    public static final void z1(SwitchAccountActivity this$0, AuthResult result) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        com.cupidapp.live.setting.helper.a aVar = new com.cupidapp.live.setting.helper.a(true, true, null, null, 12, null);
        SwitchAccountHelper switchAccountHelper = SwitchAccountHelper.f18181a;
        kotlin.jvm.internal.s.h(result, "result");
        switchAccountHelper.f(this$0, result, aVar);
    }

    public final void B1() {
        int c4 = z0.h.c(this, 8.0f);
        FKTitleBarLayout switch_account_title_bar = (FKTitleBarLayout) n1(R$id.switch_account_title_bar);
        kotlin.jvm.internal.s.h(switch_account_title_bar, "switch_account_title_bar");
        String string = getString(R$string.close_str);
        kotlin.jvm.internal.s.h(string, "getString(R.string.close_str)");
        switch_account_title_bar.setLeftImageEndText(string, (r12 & 2) != 0 ? -15066598 : 0, (r12 & 4) != 0 ? false : true, (r12 & 8) != 0 ? 16.0f : 14.0f, (r12 & 16) != 0 ? 0 : c4);
        FKTitleBarLayout remove_account_title_bar = (FKTitleBarLayout) n1(R$id.remove_account_title_bar);
        kotlin.jvm.internal.s.h(remove_account_title_bar, "remove_account_title_bar");
        String string2 = getString(2131886363);
        kotlin.jvm.internal.s.h(string2, "getString(R.string.cancel)");
        remove_account_title_bar.setLeftImageEndText(string2, (r12 & 2) != 0 ? -15066598 : 0, (r12 & 4) != 0 ? false : true, (r12 & 8) != 0 ? 16.0f : 14.0f, (r12 & 16) != 0 ? 0 : c4);
        RecyclerView initView$lambda$0 = (RecyclerView) n1(R$id.switch_account_recycler_view);
        initView$lambda$0.setItemAnimator(null);
        initView$lambda$0.setAdapter(this.f18017r);
        initView$lambda$0.setLayoutManager(new LinearLayoutManager(initView$lambda$0.getContext()));
        kotlin.jvm.internal.s.h(initView$lambda$0, "initView$lambda$0");
        initView$lambda$0.addItemDecoration(new FKAddExtraSpacingDecoration(0, z0.h.c(initView$lambda$0, 12.0f), 0, 0, 0, 0, 61, null));
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.SwitchAccount;
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f18018s;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_switch_account);
        B1();
        w1();
        v1().callGetAccountListDataApi();
        s1();
        j1.c.b(j1.c.f50228a, SensorPosition.SwitchAccount, "ACCOUNT_SWITCH", null, 4, null);
    }

    public final void s1() {
        this.f18017r.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$bindClickEvent$1
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
                    SensorsLogKeyButtonClick.SwitchAccount.ADD_ACCOUNT.click();
                    InputPhoneNumberActivity.f16098t.a(SwitchAccountActivity.this, InputPhoneNumberActivity.PageSource.SwitchAccount);
                } else if (obj instanceof SwitchAccountUserModel) {
                    SwitchAccountActivity.this.t1((SwitchAccountUserModel) obj);
                }
            }
        });
        this.f18017r.l().j(i0.h(kotlin.f.a(Integer.valueOf(R$id.account_remove_user_btn), new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$bindClickEvent$2
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
                if (obj instanceof SwitchAccountUserModel) {
                    SwitchAccountActivity.this.u1((SwitchAccountUserModel) obj);
                }
            }
        })));
        int i10 = R$id.switch_account_title_bar;
        ((FKTitleBarLayout) n1(i10)).setLeftImageEndTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$bindClickEvent$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                SwitchAccountActivity.this.onBackPressed();
            }
        });
        ((FKTitleBarLayout) n1(i10)).setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                SwitchAccountAdapter switchAccountAdapter;
                ((FKTitleBarLayout) SwitchAccountActivity.this.n1(R$id.switch_account_title_bar)).setVisibility(4);
                ((FKTitleBarLayout) SwitchAccountActivity.this.n1(R$id.remove_account_title_bar)).setVisibility(0);
                switchAccountAdapter = SwitchAccountActivity.this.f18017r;
                switchAccountAdapter.v(true);
                j1.c.b(j1.c.f50228a, SensorPosition.SwitchAccount, "ACCOUNT_MANAGE", null, 4, null);
            }
        });
        ((FKTitleBarLayout) n1(R$id.remove_account_title_bar)).setLeftImageEndTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$bindClickEvent$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                SwitchAccountAdapter switchAccountAdapter;
                ((FKTitleBarLayout) SwitchAccountActivity.this.n1(R$id.switch_account_title_bar)).setVisibility(0);
                ((FKTitleBarLayout) SwitchAccountActivity.this.n1(R$id.remove_account_title_bar)).setVisibility(4);
                switchAccountAdapter = SwitchAccountActivity.this.f18017r;
                switchAccountAdapter.v(false);
                j1.c.b(j1.c.f50228a, SensorPosition.SwitchAccount, "ACCOUNT_SWITCH", null, 4, null);
            }
        });
    }

    public final void t1(SwitchAccountUserModel switchAccountUserModel) {
        if (kotlin.jvm.internal.s.d(switchAccountUserModel.getUsed(), Boolean.TRUE) || switchAccountUserModel.isRemoveState()) {
            return;
        }
        z3.e.f54837a.J(switchAccountUserModel.getUserId(), Q0());
        if (switchAccountUserModel.getStatus() != SwitchAccountStatus.Normal.getValue()) {
            j.a.b(com.cupidapp.live.base.router.j.f12156c, this, switchAccountUserModel.getJumpUrl(), null, 4, null);
        } else {
            v1().callSwitchAccountApi(switchAccountUserModel);
        }
    }

    public final void u1(final SwitchAccountUserModel switchAccountUserModel) {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).D(R$string.are_you_sure_want_remove_account), R$string.remove_account_message, 0, 2, null), 0, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$clickRemoveAccountBtn$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                SwitchAccountViewModel v12;
                v12 = SwitchAccountActivity.this.v1();
                v12.callRemoveAccountApi(switchAccountUserModel);
            }
        }, 3, null), 0, null, 3, null), null, 1, null);
    }

    public final SwitchAccountViewModel v1() {
        return (SwitchAccountViewModel) this.f18016q.getValue();
    }

    public final void w1() {
        v1().getAccountListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SwitchAccountActivity.x1(SwitchAccountActivity.this, (List) obj);
            }
        });
        v1().getRemoveAccountLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SwitchAccountActivity.y1(SwitchAccountActivity.this, (SwitchAccountUserModel) obj);
            }
        });
        v1().getSwitchAccountLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SwitchAccountActivity.z1(SwitchAccountActivity.this, (AuthResult) obj);
            }
        });
        v1().getSwitchAccountFailRefreshList().observe(this, new EventObserver(new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$initObserve$4
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
                FKAlertDialog n10 = FKAlertDialog.a.c(FKAlertDialog.f12698l, SwitchAccountActivity.this, false, 2, null).n(errorMessage);
                final SwitchAccountActivity switchAccountActivity = SwitchAccountActivity.this;
                FKAlertDialog.G(FKAlertDialog.w(n10, R$string.i_know_it, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SwitchAccountActivity$initObserve$4.1
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
                        SwitchAccountViewModel v12;
                        v12 = SwitchAccountActivity.this.v1();
                        v12.callGetAccountListDataApi();
                    }
                }, 2, null), null, 1, null);
            }
        }));
        v1().getSwitchAccountLoadingState().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SwitchAccountActivity.A1(SwitchAccountActivity.this, (StateResult) obj);
            }
        });
    }
}
