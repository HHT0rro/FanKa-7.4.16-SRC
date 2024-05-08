package com.cupidapp.live.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.profile.viewmodel.CancelFollowRemindRange;
import com.cupidapp.live.profile.viewmodel.ContactManagerViewModel;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactManagerActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ContactManagerActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f17601t = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17602q;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17604s = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17603r = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.profile.activity.ContactManagerActivity$purchaseManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            ContactManagerActivity contactManagerActivity = ContactManagerActivity.this;
            Lifecycle lifecycle = contactManagerActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(contactManagerActivity, lifecycle);
        }
    });

    /* compiled from: ContactManagerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, boolean z10) {
            kotlin.jvm.internal.s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) ContactManagerActivity.class);
            intent.putExtra("canOneClickClear", z10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public ContactManagerActivity() {
        final Function0 function0 = null;
        this.f17602q = new ViewModelLazy(kotlin.jvm.internal.v.b(ContactManagerViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.profile.activity.ContactManagerActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.profile.activity.ContactManagerActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.profile.activity.ContactManagerActivity$special$$inlined$viewModels$default$3
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

    public static final void s1(ContactManagerActivity this$0, Integer num) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKItemLayout) this$0.k1(R$id.cancel_follow_remind_layout)).setFkValueText(this$0.p1(num));
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.CONTACT_MANAGEMENT;
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f17604s;
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

    public final PurchaseDialogManager o1() {
        return (PurchaseDialogManager) this.f17603r.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_contact_manager);
        GroupOthersLog.d(GroupOthersLog.f18702a, Q0().getValue(), null, null, 6, null);
        t1();
        r1();
    }

    public final String p1(Integer num) {
        int value = CancelFollowRemindRange.MATCH_REMIND.getValue();
        if (num != null && num.intValue() == value) {
            return getString(R$string.match_user);
        }
        int value2 = CancelFollowRemindRange.ALL_REMIND.getValue();
        if (num != null && num.intValue() == value2) {
            return getString(R$string.all_follow_user);
        }
        return getString(R$string.no_remind);
    }

    public final ContactManagerViewModel q1() {
        return (ContactManagerViewModel) this.f17602q.getValue();
    }

    public final void r1() {
        q1().getUnFollowRemindLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.profile.activity.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ContactManagerActivity.s1(ContactManagerActivity.this, (Integer) obj);
            }
        });
    }

    public final void t1() {
        boolean booleanExtra = getIntent().getBooleanExtra("canOneClickClear", true);
        int i10 = R$id.contact_un_match_layout;
        ((FKItemLayout) k1(i10)).setVisibility(booleanExtra ? 0 : 8);
        ((FKTitleBarLayout) k1(R$id.contact_manage_layout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactManagerActivity$initView$1
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
                ContactManagerActivity.this.finish();
            }
        });
        FKItemLayout contact_un_match_layout = (FKItemLayout) k1(i10);
        kotlin.jvm.internal.s.h(contact_un_match_layout, "contact_un_match_layout");
        z0.y.d(contact_un_match_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactManagerActivity$initView$2
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
                ContactLikedUnMatchActivity.f17593w.a(ContactManagerActivity.this, false);
            }
        });
        FKItemLayout cancel_follow_remind_layout = (FKItemLayout) k1(R$id.cancel_follow_remind_layout);
        kotlin.jvm.internal.s.h(cancel_follow_remind_layout, "cancel_follow_remind_layout");
        z0.y.d(cancel_follow_remind_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactManagerActivity$initView$3
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
                PurchaseDialogManager o12;
                if (com.cupidapp.live.profile.logic.c.f17839a.b()) {
                    ContactManagerActivity.this.v1();
                    return;
                }
                o12 = ContactManagerActivity.this.o1();
                VipPurchaseEntranceType vipPurchaseEntranceType = VipPurchaseEntranceType.ContactManager;
                PurchaseDialogManager.o(o12, vipPurchaseEntranceType, vipPurchaseEntranceType.getFrom(), false, false, 12, null);
            }
        });
    }

    public final void u1(CancelFollowRemindRange cancelFollowRemindRange) {
        q1().changeUnFollowRemind(cancelFollowRemindRange);
        j1.i.e(j1.i.f50236a, PopupName.CANCEL_FOLLOW_CHOOSE, cancelFollowRemindRange.name(), Q0(), null, 8, null);
    }

    public final void v1() {
        ArrayList arrayList = new ArrayList();
        ActionSheetItemType actionSheetItemType = ActionSheetItemType.Default;
        arrayList.add(new FKActionSheetItemModel(R$string.no_remind, actionSheetItemType, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactManagerActivity$showCancelFollowActionSheet$1
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
                ContactManagerActivity.this.u1(CancelFollowRemindRange.NOT_REMIND);
            }
        }, 28, null));
        arrayList.add(new FKActionSheetItemModel(R$string.match_user_cancel_remind, actionSheetItemType, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactManagerActivity$showCancelFollowActionSheet$2
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
                ContactManagerActivity.this.u1(CancelFollowRemindRange.MATCH_REMIND);
            }
        }, 28, null));
        arrayList.add(new FKActionSheetItemModel(R$string.all_follow_user_cancel_remind, actionSheetItemType, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ContactManagerActivity$showCancelFollowActionSheet$3
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
                ContactManagerActivity.this.u1(CancelFollowRemindRange.ALL_REMIND);
            }
        }, 28, null));
        FKActionSheetDialog.f12692f.a(this).f(arrayList).h();
        j1.i.g(j1.i.f50236a, PopupName.CANCEL_FOLLOW_CHOOSE, Q0(), null, 4, null);
    }
}
