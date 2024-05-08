package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.setting.adapter.PersonalIconAdapter;
import com.cupidapp.live.setting.model.AppIconLocalDataModel;
import com.cupidapp.live.setting.viewmodel.PersonalAppIconViewModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PersonalAppIconActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PersonalAppIconActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f17982u = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17984r;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17986t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17983q = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.setting.activity.PersonalAppIconActivity$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            PersonalAppIconActivity personalAppIconActivity = PersonalAppIconActivity.this;
            Lifecycle lifecycle = personalAppIconActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(personalAppIconActivity, lifecycle);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f17985s = kotlin.c.b(new Function0<PersonalIconAdapter>() { // from class: com.cupidapp.live.setting.activity.PersonalAppIconActivity$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PersonalIconAdapter invoke() {
            PersonalIconAdapter personalIconAdapter = new PersonalIconAdapter((z0.h.l(PersonalAppIconActivity.this) - z0.h.c(PersonalAppIconActivity.this, 64.0f)) / 3);
            final PersonalAppIconActivity personalAppIconActivity = PersonalAppIconActivity.this;
            personalIconAdapter.l().g(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalAppIconActivity$adapter$2$1$1
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
                    PersonalAppIconViewModel r12;
                    if (obj instanceof AppIconLocalDataModel) {
                        r12 = PersonalAppIconActivity.this.r1();
                        r12.changeSelectItem((AppIconLocalDataModel) obj);
                    }
                }
            });
            return personalIconAdapter;
        }
    });

    /* compiled from: PersonalAppIconActivity.kt */
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
            context.startActivity(new Intent(context, (Class<?>) PersonalAppIconActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public PersonalAppIconActivity() {
        final Function0 function0 = null;
        this.f17984r = new ViewModelLazy(kotlin.jvm.internal.v.b(PersonalAppIconViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.setting.activity.PersonalAppIconActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.setting.activity.PersonalAppIconActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.setting.activity.PersonalAppIconActivity$special$$inlined$viewModels$default$3
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

    public static final void t1(PersonalAppIconActivity this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.p1().j().clear();
        this$0.p1().e(list);
    }

    public static final void u1(PersonalAppIconActivity this$0, AppIconLocalDataModel appIconLocalDataModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.p1().v(appIconLocalDataModel.getName());
        this$0.p1().notifyDataSetChanged();
    }

    public static final void v1(PersonalAppIconActivity this$0, AppIconLocalDataModel appIconLocalDataModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.p1().u(appIconLocalDataModel.getName());
        this$0.p1().notifyDataSetChanged();
    }

    public static final void w1(PersonalAppIconActivity this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "it");
        int color = ContextCompat.getColor(this$0, it.booleanValue() ? R$color.app_white : R$color.gray_7C7C7C);
        int i10 = R$id.personal_icon_confirm;
        ((FKUniversalButton) this$0.n1(i10)).setTextColor(color);
        ((FKUniversalButton) this$0.n1(i10)).a(it.booleanValue());
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f17986t;
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
        setContentView(R$layout.activity_personal_icon);
        x1();
        s1();
        GroupOthersLog.d(GroupOthersLog.f18702a, SensorPosition.PersonalIcon.getValue(), null, null, 6, null);
    }

    public final PersonalIconAdapter p1() {
        return (PersonalIconAdapter) this.f17985s.getValue();
    }

    public final PurchaseDialogManager q1() {
        return (PurchaseDialogManager) this.f17983q.getValue();
    }

    public final PersonalAppIconViewModel r1() {
        return (PersonalAppIconViewModel) this.f17984r.getValue();
    }

    public final void s1() {
        r1().getListLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PersonalAppIconActivity.t1(PersonalAppIconActivity.this, (List) obj);
            }
        });
        r1().isUsingItemLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PersonalAppIconActivity.u1(PersonalAppIconActivity.this, (AppIconLocalDataModel) obj);
            }
        });
        r1().getSelectItemLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PersonalAppIconActivity.v1(PersonalAppIconActivity.this, (AppIconLocalDataModel) obj);
            }
        });
        r1().getConfirmBtnStatus().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PersonalAppIconActivity.w1(PersonalAppIconActivity.this, (Boolean) obj);
            }
        });
    }

    public final void x1() {
        ((FKTitleBarLayout) n1(R$id.custom_icon_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalAppIconActivity$initView$1
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
                PersonalAppIconActivity.this.finish();
            }
        });
        FKUniversalButton personal_icon_confirm = (FKUniversalButton) n1(R$id.personal_icon_confirm);
        kotlin.jvm.internal.s.h(personal_icon_confirm, "personal_icon_confirm");
        z0.y.d(personal_icon_confirm, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalAppIconActivity$initView$2
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
                PersonalAppIconViewModel r12;
                r12 = PersonalAppIconActivity.this.r1();
                AppIconLocalDataModel value = r12.getSelectItemLiveData().getValue();
                if (value != null) {
                    PersonalAppIconActivity personalAppIconActivity = PersonalAppIconActivity.this;
                    SensorsLogKeyButtonClick.PersonalAppIcon.SAVE.click();
                    personalAppIconActivity.y1(value);
                }
            }
        });
        int i10 = R$id.personal_icon_rv;
        ((RecyclerView) n1(i10)).setLayoutManager(new GridLayoutManager((Context) this, 3, 1, false));
        ((RecyclerView) n1(i10)).setAdapter(p1());
    }

    public final void y1(@NotNull final AppIconLocalDataModel item) {
        kotlin.jvm.internal.s.i(item, "item");
        if (kotlin.text.p.r(item.getGrade(), "SVIP", true) && !com.cupidapp.live.profile.logic.c.f17839a.d()) {
            PurchaseDialogManager.q(q1(), VipPurchaseEntranceType.PersonalAppIcon, null, null, false, false, 30, null);
        } else if (kotlin.text.p.r(item.getGrade(), "VIP", true) && !com.cupidapp.live.profile.logic.c.f17839a.f()) {
            PurchaseDialogManager.j(q1(), VipPurchaseEntranceType.PersonalAppIcon, null, null, false, 14, null);
        } else {
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).n(getString(R$string.change_custom_icon_tip)), 0, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalAppIconActivity$saveIcon$1
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
                    PersonalAppIconViewModel r12;
                    r12 = PersonalAppIconActivity.this.r1();
                    r12.saveIcon(item);
                }
            }, 3, null), 0, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalAppIconActivity$saveIcon$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, 1, null), null, 1, null);
        }
    }
}
