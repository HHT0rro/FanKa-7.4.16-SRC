package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.base.view.FKItemSingleChoiceLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.setting.viewmodel.CustomPushViewModel;
import com.cupidapp.live.setting.viewmodel.PushRangeChoice;
import com.cupidapp.live.setting.viewmodel.PushTypeChoice;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CustomPushActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CustomPushActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f17944s = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17945q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17946r = new LinkedHashMap();

    /* compiled from: CustomPushActivity.kt */
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
            context.startActivity(new Intent(context, (Class<?>) CustomPushActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public CustomPushActivity() {
        final Function0 function0 = null;
        this.f17945q = new ViewModelLazy(kotlin.jvm.internal.v.b(CustomPushViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.setting.activity.CustomPushActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.setting.activity.CustomPushActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.setting.activity.CustomPushActivity$special$$inlined$viewModels$default$3
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

    public static final void q1(CustomPushActivity this$0, PushTypeChoice pushTypeChoice) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKItemSingleChoiceLayout) this$0.l1(R$id.custom_push_important_scl)).setChecked(pushTypeChoice == PushTypeChoice.IMPORTANT_PUSH);
        ((FKItemSingleChoiceLayout) this$0.l1(R$id.custom_push_all_scl)).setChecked(pushTypeChoice == PushTypeChoice.ALL_PUSH);
    }

    public static final void r1(CustomPushActivity this$0, PushRangeChoice pushRangeChoice) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((FKItemSingleChoiceLayout) this$0.l1(R$id.custom_push_privacy_scl)).setChecked(pushRangeChoice == PushRangeChoice.PRIVACY_FIRST);
        ((FKItemSingleChoiceLayout) this$0.l1(R$id.custom_push_convenient_scl)).setChecked(pushRangeChoice == PushRangeChoice.CONVINCE_FIRST);
    }

    @Nullable
    public View l1(int i10) {
        Map<Integer, View> map = this.f17946r;
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

    public final CustomPushViewModel n1() {
        return (CustomPushViewModel) this.f17945q.getValue();
    }

    public final void o1() {
        ((FKItemSingleChoiceLayout) l1(R$id.custom_push_important_scl)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.CustomPushActivity$initCheckListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                CustomPushViewModel n12;
                n12 = CustomPushActivity.this.n1();
                n12.changePushType(PushTypeChoice.IMPORTANT_PUSH);
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.PUSH_SYSTEM_OPT;
                String string = CustomPushActivity.this.getString(R$string.important_push);
                kotlin.jvm.internal.s.h(string, "getString(R.string.important_push)");
                iVar.c(popupName, string, SensorPosition.OpenPushGuide.getValue());
            }
        });
        ((FKItemSingleChoiceLayout) l1(R$id.custom_push_all_scl)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.CustomPushActivity$initCheckListener$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                CustomPushViewModel n12;
                n12 = CustomPushActivity.this.n1();
                n12.changePushType(PushTypeChoice.ALL_PUSH);
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.PUSH_SYSTEM_OPT;
                String string = CustomPushActivity.this.getString(R$string.all_push);
                kotlin.jvm.internal.s.h(string, "getString(R.string.all_push)");
                iVar.c(popupName, string, SensorPosition.OpenPushGuide.getValue());
            }
        });
        ((FKItemSingleChoiceLayout) l1(R$id.custom_push_privacy_scl)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.CustomPushActivity$initCheckListener$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                CustomPushViewModel n12;
                n12 = CustomPushActivity.this.n1();
                n12.changePushRange(PushRangeChoice.PRIVACY_FIRST);
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.PUSH_SYSTEM_OPT;
                String string = CustomPushActivity.this.getString(R$string.privacy_first);
                kotlin.jvm.internal.s.h(string, "getString(R.string.privacy_first)");
                iVar.c(popupName, string, SensorPosition.OpenPushGuide.getValue());
            }
        });
        ((FKItemSingleChoiceLayout) l1(R$id.custom_push_convenient_scl)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.CustomPushActivity$initCheckListener$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                CustomPushViewModel n12;
                n12 = CustomPushActivity.this.n1();
                n12.changePushRange(PushRangeChoice.CONVINCE_FIRST);
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.PUSH_SYSTEM_OPT;
                String string = CustomPushActivity.this.getString(R$string.convince_first);
                kotlin.jvm.internal.s.h(string, "getString(R.string.convince_first)");
                iVar.c(popupName, string, SensorPosition.OpenPushGuide.getValue());
            }
        });
        FKUniversalButton custom_push_confirm_btn = (FKUniversalButton) l1(R$id.custom_push_confirm_btn);
        kotlin.jvm.internal.s.h(custom_push_confirm_btn, "custom_push_confirm_btn");
        z0.y.d(custom_push_confirm_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.CustomPushActivity$initCheckListener$5
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
                CustomPushViewModel n12;
                n12 = CustomPushActivity.this.n1();
                n12.saveCustomPush();
                j1.i iVar = j1.i.f50236a;
                PopupName popupName = PopupName.PUSH_SYSTEM_OPT;
                String string = CustomPushActivity.this.getString(R$string.save_and_open_push);
                kotlin.jvm.internal.s.h(string, "getString(R.string.save_and_open_push)");
                iVar.c(popupName, string, SensorPosition.OpenPushGuide.getValue());
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.custom_push_activity);
        j1.i.g(j1.i.f50236a, PopupName.PUSH_SYSTEM_OPT, SensorPosition.OpenPushGuide, null, 4, null);
        ((FKTitleBarLayout) l1(R$id.custom_push_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.CustomPushActivity$onCreate$1
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
                CustomPushActivity.this.finish();
            }
        });
        s1();
        o1();
        p1();
    }

    public final void p1() {
        n1().getSelectPushTypeLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CustomPushActivity.q1(CustomPushActivity.this, (PushTypeChoice) obj);
            }
        });
        n1().getSelectPushRangeLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.setting.activity.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CustomPushActivity.r1(CustomPushActivity.this, (PushRangeChoice) obj);
            }
        });
        n1().getOpenSystemPushEvent().observe(this, new EventObserver(new Function1<kotlin.p, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.CustomPushActivity$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(kotlin.p pVar) {
                invoke2(pVar);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull kotlin.p it) {
                kotlin.jvm.internal.s.i(it, "it");
                r0.f12373a.c(CustomPushActivity.this);
                CustomPushActivity.this.finish();
            }
        }));
    }

    public final void s1() {
        ((TextView) l1(R$id.custom_push_type_txt)).getPaint().setFakeBoldText(true);
        ((TextView) l1(R$id.custom_push_range_txt)).getPaint().setFakeBoldText(true);
        ((TextView) l1(R$id.custom_push_close_txt)).getPaint().setFakeBoldText(true);
        ((FKItemSingleChoiceLayout) l1(R$id.custom_push_important_scl)).setItemFirstContent(getString(R$string.focus_feed_and_msg));
    }
}
