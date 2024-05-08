package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogUserStatusSwitch;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.view.FKItemCheckLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SettingAssistantActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SettingAssistantActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f18009s = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18011r = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f18010q = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.setting.activity.SettingAssistantActivity$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            SettingAssistantActivity settingAssistantActivity = SettingAssistantActivity.this;
            Lifecycle lifecycle = settingAssistantActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(settingAssistantActivity, lifecycle);
        }
    });

    /* compiled from: SettingAssistantActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            if (context == null) {
                return;
            }
            context.startActivity(new Intent(context, (Class<?>) SettingAssistantActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f18011r;
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

    public final PurchaseDialogManager m1() {
        return (PurchaseDialogManager) this.f18010q.getValue();
    }

    public final void n1(boolean z10) {
        SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.AD_PRIVILEGE, z10, null, 4, null);
        if (com.cupidapp.live.vip.c.f18740a.g()) {
            p1(z10);
        } else {
            if (!z10 || com.cupidapp.live.profile.logic.c.f17839a.f()) {
                return;
            }
            ((FKItemCheckLayout) j1(R$id.vipNoAd)).setChecked(false);
            PurchaseDialogManager.j(m1(), VipPurchaseEntranceType.SettingNoAd, null, null, false, 14, null);
        }
    }

    public final void o1() {
        j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
        User X = p1.g.f52734a.X();
        aVar.a("vipPrivilegeState", String.valueOf(X != null ? Integer.valueOf(X.getVipAd()) : null));
        int i10 = R$id.vipNoAd;
        ((FKItemCheckLayout) j1(i10)).setChecked(com.cupidapp.live.vip.c.f18740a.i());
        ((FKItemCheckLayout) j1(i10)).setOnCheckedChangeListener(new SettingAssistantActivity$initViews$1(this));
        ((FKTitleBarLayout) j1(R$id.configSettingTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingAssistantActivity$initViews$2
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
                SettingAssistantActivity.this.onBackPressed();
            }
        });
        ((FKItemCheckLayout) j1(i10)).f();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_setting_assistant);
        o1();
        GroupOthersLog.d(GroupOthersLog.f18702a, SensorPosition.Accessibility.getValue(), null, null, 6, null);
    }

    public final void p1(final boolean z10) {
        Disposable disposed = NetworkClient.f11868a.N().G0(z10 ? "1" : "0").flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingAssistantActivity$onReportAdStatus$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                p1.g gVar = p1.g.f52734a;
                User X = gVar.X();
                if (X != null) {
                    X.setVipAd(z10 ? 1 : 0);
                }
                gVar.A2(X);
                this.q1();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void q1() {
        Disposable disposed = NetworkClient.f11868a.i().o().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ConstantsResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingAssistantActivity$updateConstantsAndroidData$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ConstantsResult constantsResult) {
                m2794invoke(constantsResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2794invoke(ConstantsResult constantsResult) {
                p1.g.f52734a.b2(constantsResult);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }
}
