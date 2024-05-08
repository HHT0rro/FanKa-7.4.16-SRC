package com.cupidapp.live.setting.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.permission.RxPermissionHelperKt;
import com.cupidapp.live.base.permission.b;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.setting.activity.NewPushSettingDetailActivity;
import com.cupidapp.live.setting.model.NewPushLiveShowModel;
import com.cupidapp.live.setting.view.PushBaseDetailSettingLayout;
import com.cupidapp.live.setting.view.RecoveryPushSettingLayout;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NewPushSettingDetailActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewPushSettingDetailActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final Companion f17974t = new Companion(null);

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17977s = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17975q = kotlin.c.b(new Function0<Companion.PushSettingDetail>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$pushSettingDetailEnum$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final NewPushSettingDetailActivity.Companion.PushSettingDetail invoke() {
            Serializable serializableExtra = NewPushSettingDetailActivity.this.getIntent().getSerializableExtra("PUSH_SETTING");
            if (serializableExtra instanceof NewPushSettingDetailActivity.Companion.PushSettingDetail) {
                return (NewPushSettingDetailActivity.Companion.PushSettingDetail) serializableExtra;
            }
            return null;
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17976r = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(NewPushSettingDetailActivity.this);
        }
    });

    /* compiled from: NewPushSettingDetailActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {

        /* compiled from: NewPushSettingDetailActivity.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public enum PushSettingDetail {
            RecoveryPushSetting,
            OpenLiveNotification
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, @NotNull PushSettingDetail pushSetting) {
            kotlin.jvm.internal.s.i(activity, "activity");
            kotlin.jvm.internal.s.i(pushSetting, "pushSetting");
            Intent intent = new Intent(activity, (Class<?>) NewPushSettingDetailActivity.class);
            intent.putExtra("PUSH_SETTING", pushSetting);
            activity.startActivityForResult(intent, 1);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, activity, 0, 0, 6, null);
        }
    }

    /* compiled from: NewPushSettingDetailActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17978a;

        static {
            int[] iArr = new int[Companion.PushSettingDetail.values().length];
            try {
                iArr[Companion.PushSettingDetail.RecoveryPushSetting.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.PushSettingDetail.OpenLiveNotification.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f17978a = iArr;
        }
    }

    /* compiled from: NewPushSettingDetailActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements com.cupidapp.live.base.permission.b {
        public b() {
        }

        @Override // com.cupidapp.live.base.permission.b
        public void a() {
            ((RecoveryPushSettingLayout) NewPushSettingDetailActivity.this.j1(R$id.recoveryPushSettingLayout)).setSelectItem();
        }

        @Override // com.cupidapp.live.base.permission.b
        public void b() {
            b.a.b(this);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void c() {
            b.a.c(this);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void d() {
            b.a.a(this);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, android.app.Activity
    public void finish() {
        Integer selectId;
        Companion.PushSettingDetail o12 = o1();
        if ((o12 == null ? -1 : a.f17978a[o12.ordinal()]) == 1 && (selectId = ((RecoveryPushSettingLayout) j1(R$id.recoveryPushSettingLayout)).getSelectId()) != null) {
            setResult(102, new Intent().putExtra("id", selectId.intValue()));
        }
        super.finish();
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17977s;
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

    public final void n1() {
        e1();
        Disposable disposed = NetworkClient.f11868a.B().e().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NewPushLiveShowModel, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$getOpenLiveShowList$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NewPushLiveShowModel newPushLiveShowModel) {
                m2789invoke(newPushLiveShowModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2789invoke(NewPushLiveShowModel newPushLiveShowModel) {
                NewPushLiveShowModel newPushLiveShowModel2 = newPushLiveShowModel;
                ((PushBaseDetailSettingLayout) NewPushSettingDetailActivity.this.j1(R$id.pushListLayout)).setData(newPushLiveShowModel2);
                ((FKTitleBarLayout) NewPushSettingDetailActivity.this.j1(R$id.newPushDetailTitleLayout)).setRightImageVisible(newPushLiveShowModel2.getPushLiveShow());
                NewPushSettingDetailActivity.this.V0();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$getOpenLiveShowList$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                NewPushSettingDetailActivity.this.V0();
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final Companion.PushSettingDetail o1() {
        return (Companion.PushSettingDetail) this.f17975q.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 103) {
            ((RecoveryPushSettingLayout) j1(R$id.recoveryPushSettingLayout)).setSelectItem();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_new_push_setting_detail);
        Companion.PushSettingDetail o12 = o1();
        int i10 = o12 == null ? -1 : a.f17978a[o12.ordinal()];
        if (i10 == 1) {
            r1();
        } else if (i10 == 2) {
            q1();
        }
        ((FKTitleBarLayout) j1(R$id.newPushDetailTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$onCreate$1
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
                NewPushSettingDetailActivity.this.finish();
            }
        });
    }

    public final xb.b p1() {
        return (xb.b) this.f17976r.getValue();
    }

    public final void q1() {
        s1();
        FKTitleBarLayout initLiveShowList$lambda$1 = (FKTitleBarLayout) j1(R$id.newPushDetailTitleLayout);
        kotlin.jvm.internal.s.h(initLiveShowList$lambda$1, "initLiveShowList$lambda$1");
        FKTitleBarLayout.setSingleTitle$default(initLiveShowList$lambda$1, getString(R$string.push_new_open_liveshow_notification), null, 2, null);
        initLiveShowList$lambda$1.setRightImageRes(Integer.valueOf(R$mipmap.icon_setting));
        initLiveShowList$lambda$1.setRightImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$initLiveShowList$1$1
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
                NewPushSettingDetailActivity.this.v1();
            }
        });
        n1();
        ((PushBaseDetailSettingLayout) j1(R$id.pushListLayout)).setVisibility(0);
    }

    public final void r1() {
        FKTitleBarLayout newPushDetailTitleLayout = (FKTitleBarLayout) j1(R$id.newPushDetailTitleLayout);
        kotlin.jvm.internal.s.h(newPushDetailTitleLayout, "newPushDetailTitleLayout");
        FKTitleBarLayout.setSingleTitle$default(newPushDetailTitleLayout, getString(R$string.push_new_recovery_push_setting), null, 2, null);
        int i10 = R$id.recoveryPushSettingLayout;
        ((RecoveryPushSettingLayout) j1(i10)).setVisibility(0);
        ((RecoveryPushSettingLayout) j1(i10)).setRequestLocationPermission(new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$initRecovery$1
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
                NewPushSettingDetailActivity.this.t1();
            }
        });
        ((RecoveryPushSettingLayout) j1(i10)).setRequestLocationServices(new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$initRecovery$2
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
                NewPushSettingDetailActivity.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 103);
            }
        });
    }

    public final void s1() {
        int i10 = R$id.pushListLayout;
        ((PushBaseDetailSettingLayout) j1(i10)).setItemClick(new Function3<String, Boolean, Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$initView$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str, Boolean bool, Boolean bool2) {
                invoke(str, bool.booleanValue(), bool2.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(@Nullable String str, boolean z10, boolean z11) {
                if (str != null) {
                    NewPushSettingDetailActivity newPushSettingDetailActivity = NewPushSettingDetailActivity.this;
                    if (z11) {
                        Disposable disposed = NetworkClient.f11868a.B().g(str, z10).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$initView$1$invoke$lambda$1$$inlined$handle$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                                invoke2(obj);
                                return kotlin.p.f51048a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Object obj) {
                            }
                        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$initView$1$1$2
                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final Boolean invoke(@NotNull Throwable it) {
                                kotlin.jvm.internal.s.i(it, "it");
                                return Boolean.TRUE;
                            }
                        }, newPushSettingDetailActivity)));
                        if (disposed != null) {
                            kotlin.jvm.internal.s.h(disposed, "disposed");
                            if (newPushSettingDetailActivity != null) {
                                newPushSettingDetailActivity.H(disposed);
                            }
                        }
                        kotlin.jvm.internal.s.h(disposed, "disposed");
                    }
                }
            }
        });
        ((PushBaseDetailSettingLayout) j1(i10)).setHeaderClick(new Function2<Boolean, Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$initView$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.p mo1743invoke(Boolean bool, Boolean bool2) {
                invoke(bool.booleanValue(), bool2.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(final boolean z10, boolean z11) {
                if (z11) {
                    Observable<Result<Object>> d10 = NetworkClient.f11868a.B().d(z10);
                    final NewPushSettingDetailActivity newPushSettingDetailActivity = NewPushSettingDetailActivity.this;
                    Disposable disposed = d10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$initView$2$invoke$$inlined$handle$1
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
                            ((FKTitleBarLayout) NewPushSettingDetailActivity.this.j1(R$id.newPushDetailTitleLayout)).setRightImageVisible(z10);
                        }
                    }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$initView$2.2
                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull Throwable it) {
                            kotlin.jvm.internal.s.i(it, "it");
                            return Boolean.TRUE;
                        }
                    }, newPushSettingDetailActivity)));
                    if (disposed != null) {
                        kotlin.jvm.internal.s.h(disposed, "disposed");
                        if (newPushSettingDetailActivity != null) {
                            newPushSettingDetailActivity.H(disposed);
                        }
                    }
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                }
            }
        });
    }

    public final void t1() {
        RxPermissionHelperKt.m(this, p1(), kotlin.collections.r.e(PermissionType.LocationPermission), new b(), false, 16, null);
    }

    public final void u1(boolean z10) {
        e1();
        Disposable disposed = NetworkClient.f11868a.B().b(z10).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<NewPushLiveShowModel, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$setLiveShowBatch$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(NewPushLiveShowModel newPushLiveShowModel) {
                m2790invoke(newPushLiveShowModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2790invoke(NewPushLiveShowModel newPushLiveShowModel) {
                NewPushSettingDetailActivity.this.V0();
                ((PushBaseDetailSettingLayout) NewPushSettingDetailActivity.this.j1(R$id.pushListLayout)).setData(newPushLiveShowModel);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$setLiveShowBatch$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                NewPushSettingDetailActivity.this.V0();
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void v1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FKActionSheetItemModel(R$string.new_push_all_open, ActionSheetItemType.Recommend, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$showLiveShowMenuFragment$1
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
                NewPushSettingDetailActivity.this.u1(true);
            }
        }, 28, null));
        arrayList.add(new FKActionSheetItemModel(R$string.new_push_all_close, null, null, null, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.NewPushSettingDetailActivity$showLiveShowMenuFragment$2
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
                NewPushSettingDetailActivity.this.u1(false);
            }
        }, 30, null));
        FKActionSheetDialog.f12692f.a(this).f(arrayList).h();
    }
}
