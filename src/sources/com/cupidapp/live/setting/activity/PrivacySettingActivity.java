package com.cupidapp.live.setting.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.R$color;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.sensorslog.SensorsLogUserStatusSwitch;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKItemSwitchLayout;
import com.cupidapp.live.base.view.FKSVipImgLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.chat.util.FKDeleteSessionUtil;
import com.cupidapp.live.profile.activity.FKBaseListActivity;
import com.cupidapp.live.profile.activity.FKBaseListType;
import com.cupidapp.live.setting.model.PrivacySettingDataResult;
import com.cupidapp.live.track.group.GroupOthersLog;
import com.cupidapp.live.vip.PurchaseDialogManager;
import com.cupidapp.live.vip.VipDiscountDescription;
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
import x2.a;

/* compiled from: PrivacySettingActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PrivacySettingActivity extends FKBaseActivity {

    @NotNull
    public static final a B = new a(null);

    @NotNull
    public Map<Integer, View> A = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f17996q = kotlin.c.b(new Function0<PurchaseDialogManager>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$purchaseDialogManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final PurchaseDialogManager invoke() {
            PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
            Lifecycle lifecycle = privacySettingActivity.getLifecycle();
            kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
            return new PurchaseDialogManager(privacySettingActivity, lifecycle);
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f17997r = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$rxPermissions$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final xb.b invoke() {
            return new xb.b(PrivacySettingActivity.this);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    public final int f17998s = 1;

    /* renamed from: t, reason: collision with root package name */
    public final int f17999t = 201;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public PrivacySettingDataResult f18000u;

    /* renamed from: v, reason: collision with root package name */
    @Nullable
    public FKItemSwitchLayout f18001v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public FKItemSwitchLayout f18002w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public View f18003x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public SeekBar f18004y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    public TextView f18005z;

    /* compiled from: PrivacySettingActivity.kt */
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
            context.startActivity(new Intent(context, (Class<?>) PrivacySettingActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: PrivacySettingActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@Nullable SeekBar seekBar, int i10, boolean z10) {
            if (i10 < PrivacySettingActivity.this.f17998s && seekBar != null) {
                seekBar.setProgress(PrivacySettingActivity.this.f17998s);
            }
            PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
            privacySettingActivity.E1(seekBar != null ? seekBar.getProgress() : privacySettingActivity.f17998s);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
            PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
            if (privacySettingDataResult != null) {
                privacySettingDataResult.setMatchExcludeDistanceKm(Integer.valueOf(Math.max(PrivacySettingActivity.this.f17998s, seekBar != null ? seekBar.getProgress() : 0)));
            }
            PrivacySettingActivity.this.K1();
        }
    }

    /* compiled from: PrivacySettingActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements SeekBar.OnSeekBarChangeListener {
        public c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@Nullable SeekBar seekBar, int i10, boolean z10) {
            if (i10 < PrivacySettingActivity.this.f17998s && seekBar != null) {
                seekBar.setProgress(PrivacySettingActivity.this.f17998s);
            }
            PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
            privacySettingActivity.E1(seekBar != null ? seekBar.getProgress() : privacySettingActivity.f17998s);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
            PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
            if (privacySettingDataResult != null) {
                privacySettingDataResult.setMatchExcludeDistanceKm(Integer.valueOf(Math.max(PrivacySettingActivity.this.f17998s, seekBar != null ? seekBar.getProgress() : 0)));
            }
            PrivacySettingActivity.this.K1();
        }
    }

    /* compiled from: PrivacySettingActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements VipDiscountDescription.a {
        public d() {
        }

        @Override // com.cupidapp.live.vip.VipDiscountDescription.a
        public void a(@Nullable String str) {
            ((FKSVipImgLayout) PrivacySettingActivity.this.j1(R$id.settting_svip_layout)).c(str);
        }
    }

    public final void A1(PrivacySettingDataResult privacySettingDataResult) {
        int i10 = R$id.hideFootmarkLayout;
        ((FKItemSwitchLayout) j1(i10)).setChecked(privacySettingDataResult.getHiddenFootmark());
        if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
            FKItemSwitchLayout fKItemSwitchLayout = (FKItemSwitchLayout) j1(i10);
            String string = getString(R$string.hide_footmark_count, new Object[]{privacySettingDataResult.getFootmarkDelCount()});
            kotlin.jvm.internal.s.h(string, "getString(R.string.hide_…setting.footmarkDelCount)");
            fKItemSwitchLayout.setItemSubTitleContent(z0.t.k(string, -49088, new String[]{String.valueOf(privacySettingDataResult.getFootmarkDelCount())}, false, 4, null));
        } else {
            ((FKItemSwitchLayout) j1(i10)).setItemSubTitleContent(null);
        }
        ((FKItemSwitchLayout) j1(i10)).setItemSwitchContent(getString(R$string.hide_footmark_des, new Object[]{privacySettingDataResult.getFootmarkDelPerMonth()}));
    }

    public final void B1() {
        FKItemSwitchLayout fKItemSwitchLayout = this.f18002w;
        if (fKItemSwitchLayout != null) {
            fKItemSwitchLayout.setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$configNewPrivateConfig$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(boolean z10) {
                    FKItemSwitchLayout fKItemSwitchLayout2;
                    PurchaseDialogManager H1;
                    FKItemSwitchLayout fKItemSwitchLayout3;
                    View view;
                    FKItemSwitchLayout fKItemSwitchLayout4;
                    View view2;
                    fKItemSwitchLayout2 = PrivacySettingActivity.this.f18002w;
                    if (fKItemSwitchLayout2 != null) {
                        fKItemSwitchLayout2.setChecked(!z10);
                    }
                    if (!com.cupidapp.live.profile.logic.c.f17839a.d()) {
                        PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                        String hidePopInfo = privacySettingDataResult != null ? privacySettingDataResult.getHidePopInfo() : null;
                        if (!(hidePopInfo == null || hidePopInfo.length() == 0) && !z10) {
                            p1.g gVar = p1.g.f52734a;
                            if (kotlin.jvm.internal.s.d(gVar.W0(), Boolean.TRUE)) {
                                gVar.n3(Boolean.FALSE);
                                PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
                                PrivacySettingDataResult privacySettingDataResult2 = privacySettingActivity.f18000u;
                                privacySettingActivity.N1(privacySettingDataResult2 != null ? privacySettingDataResult2.getHidePopInfo() : null);
                            } else {
                                fKItemSwitchLayout3 = PrivacySettingActivity.this.f18002w;
                                if (fKItemSwitchLayout3 != null) {
                                    fKItemSwitchLayout3.setChecked(z10);
                                }
                                PrivacySettingDataResult privacySettingDataResult3 = PrivacySettingActivity.this.f18000u;
                                if (privacySettingDataResult3 != null) {
                                    privacySettingDataResult3.setMatchExcludeDistanceKm(0);
                                }
                                view = PrivacySettingActivity.this.f18003x;
                                if (view != null) {
                                    view.setVisibility(8);
                                }
                                PrivacySettingActivity.this.K1();
                            }
                        } else {
                            H1 = PrivacySettingActivity.this.H1();
                            PurchaseDialogManager.q(H1, VipPurchaseEntranceType.PrivacyHideMe, null, null, false, false, 30, null);
                        }
                    } else if (z10) {
                        LocationUtils.Companion companion = LocationUtils.f12270h;
                        PrivacySettingActivity privacySettingActivity2 = PrivacySettingActivity.this;
                        xb.b I1 = privacySettingActivity2.I1();
                        final PrivacySettingActivity privacySettingActivity3 = PrivacySettingActivity.this;
                        companion.e(privacySettingActivity2, I1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$configNewPrivateConfig$1.1
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
                                FKItemSwitchLayout fKItemSwitchLayout5;
                                View view3;
                                SeekBar seekBar;
                                fKItemSwitchLayout5 = PrivacySettingActivity.this.f18002w;
                                if (fKItemSwitchLayout5 != null) {
                                    fKItemSwitchLayout5.setChecked(true);
                                }
                                view3 = PrivacySettingActivity.this.f18003x;
                                if (view3 != null) {
                                    view3.setVisibility(0);
                                }
                                PrivacySettingDataResult privacySettingDataResult4 = PrivacySettingActivity.this.f18000u;
                                if (privacySettingDataResult4 != null) {
                                    privacySettingDataResult4.setMatchExcludeDistanceKm(Integer.valueOf(PrivacySettingActivity.this.f17998s));
                                }
                                seekBar = PrivacySettingActivity.this.f18004y;
                                if (seekBar != null) {
                                    seekBar.setProgress(PrivacySettingActivity.this.f17998s);
                                }
                                PrivacySettingActivity privacySettingActivity4 = PrivacySettingActivity.this;
                                privacySettingActivity4.E1(privacySettingActivity4.f17998s);
                                PrivacySettingActivity.this.K1();
                            }
                        });
                    } else {
                        fKItemSwitchLayout4 = PrivacySettingActivity.this.f18002w;
                        if (fKItemSwitchLayout4 != null) {
                            fKItemSwitchLayout4.setChecked(false);
                        }
                        view2 = PrivacySettingActivity.this.f18003x;
                        if (view2 != null) {
                            view2.setVisibility(8);
                        }
                        PrivacySettingDataResult privacySettingDataResult4 = PrivacySettingActivity.this.f18000u;
                        if (privacySettingDataResult4 != null) {
                            privacySettingDataResult4.setMatchExcludeDistanceKm(0);
                        }
                        PrivacySettingActivity.this.K1();
                    }
                    SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.NOT_RECOMMEND_ME_TO_NEARBY, z10, null, 4, null);
                }
            });
        }
        FKItemSwitchLayout fKItemSwitchLayout2 = this.f18001v;
        if (fKItemSwitchLayout2 != null) {
            fKItemSwitchLayout2.setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$configNewPrivateConfig$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(final boolean z10) {
                    FKItemSwitchLayout fKItemSwitchLayout3;
                    PurchaseDialogManager H1;
                    FKItemSwitchLayout fKItemSwitchLayout4;
                    FKItemSwitchLayout fKItemSwitchLayout5;
                    fKItemSwitchLayout3 = PrivacySettingActivity.this.f18001v;
                    if (fKItemSwitchLayout3 != null) {
                        fKItemSwitchLayout3.setChecked(!z10);
                    }
                    if (!com.cupidapp.live.profile.logic.c.f17839a.d()) {
                        PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                        String distancePopInfo = privacySettingDataResult != null ? privacySettingDataResult.getDistancePopInfo() : null;
                        if (!(distancePopInfo == null || distancePopInfo.length() == 0) && !z10) {
                            p1.g gVar = p1.g.f52734a;
                            if (kotlin.jvm.internal.s.d(gVar.e1(), Boolean.TRUE)) {
                                gVar.q3(Boolean.FALSE);
                                PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
                                PrivacySettingDataResult privacySettingDataResult2 = privacySettingActivity.f18000u;
                                privacySettingActivity.M1(privacySettingDataResult2 != null ? privacySettingDataResult2.getDistancePopInfo() : null);
                            } else {
                                fKItemSwitchLayout4 = PrivacySettingActivity.this.f18001v;
                                if (fKItemSwitchLayout4 != null) {
                                    fKItemSwitchLayout4.setChecked(z10);
                                }
                                PrivacySettingDataResult privacySettingDataResult3 = PrivacySettingActivity.this.f18000u;
                                if (privacySettingDataResult3 != null) {
                                    privacySettingDataResult3.setHidden(false);
                                }
                                PrivacySettingActivity.this.K1();
                            }
                        } else {
                            H1 = PrivacySettingActivity.this.H1();
                            PurchaseDialogManager.q(H1, VipPurchaseEntranceType.PrivacyHideLocation, null, null, false, false, 30, null);
                        }
                    } else if (z10) {
                        LocationUtils.Companion companion = LocationUtils.f12270h;
                        PrivacySettingActivity privacySettingActivity2 = PrivacySettingActivity.this;
                        xb.b I1 = privacySettingActivity2.I1();
                        final PrivacySettingActivity privacySettingActivity3 = PrivacySettingActivity.this;
                        companion.e(privacySettingActivity2, I1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$configNewPrivateConfig$2.1
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
                                FKItemSwitchLayout fKItemSwitchLayout6;
                                fKItemSwitchLayout6 = PrivacySettingActivity.this.f18001v;
                                if (fKItemSwitchLayout6 != null) {
                                    fKItemSwitchLayout6.setChecked(z10);
                                }
                                PrivacySettingDataResult privacySettingDataResult4 = PrivacySettingActivity.this.f18000u;
                                if (privacySettingDataResult4 != null) {
                                    privacySettingDataResult4.setHidden(z10);
                                }
                                PrivacySettingActivity.this.K1();
                            }
                        });
                    } else {
                        fKItemSwitchLayout5 = PrivacySettingActivity.this.f18001v;
                        if (fKItemSwitchLayout5 != null) {
                            fKItemSwitchLayout5.setChecked(z10);
                        }
                        PrivacySettingDataResult privacySettingDataResult4 = PrivacySettingActivity.this.f18000u;
                        if (privacySettingDataResult4 != null) {
                            privacySettingDataResult4.setHidden(z10);
                        }
                        PrivacySettingActivity.this.K1();
                    }
                    SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.HIDE_POSITION, z10, null, 4, null);
                }
            });
        }
        SeekBar seekBar = this.f18004y;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new b());
        }
    }

    public final void C1() {
        FKItemSwitchLayout fKItemSwitchLayout = this.f18001v;
        if (fKItemSwitchLayout != null) {
            fKItemSwitchLayout.setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$configOldPrivateSetting$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(final boolean z10) {
                    FKItemSwitchLayout fKItemSwitchLayout2;
                    FKItemSwitchLayout fKItemSwitchLayout3;
                    if (z10) {
                        fKItemSwitchLayout3 = PrivacySettingActivity.this.f18001v;
                        if (fKItemSwitchLayout3 != null) {
                            fKItemSwitchLayout3.setChecked(!z10);
                        }
                        LocationUtils.Companion companion = LocationUtils.f12270h;
                        PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
                        xb.b I1 = privacySettingActivity.I1();
                        final PrivacySettingActivity privacySettingActivity2 = PrivacySettingActivity.this;
                        companion.e(privacySettingActivity, I1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$configOldPrivateSetting$1.1
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
                                FKItemSwitchLayout fKItemSwitchLayout4;
                                fKItemSwitchLayout4 = PrivacySettingActivity.this.f18001v;
                                if (fKItemSwitchLayout4 != null) {
                                    fKItemSwitchLayout4.setChecked(z10);
                                }
                                PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                                if (privacySettingDataResult != null) {
                                    privacySettingDataResult.setHidden(z10);
                                }
                                PrivacySettingActivity.this.K1();
                            }
                        });
                    } else {
                        fKItemSwitchLayout2 = PrivacySettingActivity.this.f18001v;
                        if (fKItemSwitchLayout2 != null) {
                            fKItemSwitchLayout2.setChecked(z10);
                        }
                        PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                        if (privacySettingDataResult != null) {
                            privacySettingDataResult.setHidden(z10);
                        }
                        PrivacySettingActivity.this.K1();
                    }
                    SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.HIDE_POSITION, z10, null, 4, null);
                }
            });
        }
        FKItemSwitchLayout fKItemSwitchLayout2 = this.f18002w;
        if (fKItemSwitchLayout2 != null) {
            fKItemSwitchLayout2.setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$configOldPrivateSetting$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(boolean z10) {
                    FKItemSwitchLayout fKItemSwitchLayout3;
                    View view;
                    FKItemSwitchLayout fKItemSwitchLayout4;
                    if (z10) {
                        fKItemSwitchLayout4 = PrivacySettingActivity.this.f18002w;
                        if (fKItemSwitchLayout4 != null) {
                            fKItemSwitchLayout4.setChecked(false);
                        }
                        LocationUtils.Companion companion = LocationUtils.f12270h;
                        PrivacySettingActivity privacySettingActivity = PrivacySettingActivity.this;
                        xb.b I1 = privacySettingActivity.I1();
                        final PrivacySettingActivity privacySettingActivity2 = PrivacySettingActivity.this;
                        companion.e(privacySettingActivity, I1, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$configOldPrivateSetting$2.1
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
                                FKItemSwitchLayout fKItemSwitchLayout5;
                                View view2;
                                SeekBar seekBar;
                                fKItemSwitchLayout5 = PrivacySettingActivity.this.f18002w;
                                if (fKItemSwitchLayout5 != null) {
                                    fKItemSwitchLayout5.setChecked(true);
                                }
                                view2 = PrivacySettingActivity.this.f18003x;
                                if (view2 != null) {
                                    view2.setVisibility(0);
                                }
                                PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                                if (privacySettingDataResult != null) {
                                    privacySettingDataResult.setMatchExcludeDistanceKm(Integer.valueOf(PrivacySettingActivity.this.f17998s));
                                }
                                seekBar = PrivacySettingActivity.this.f18004y;
                                if (seekBar != null) {
                                    seekBar.setProgress(PrivacySettingActivity.this.f17998s);
                                }
                                PrivacySettingActivity privacySettingActivity3 = PrivacySettingActivity.this;
                                privacySettingActivity3.E1(privacySettingActivity3.f17998s);
                                PrivacySettingActivity.this.K1();
                            }
                        });
                    } else {
                        fKItemSwitchLayout3 = PrivacySettingActivity.this.f18002w;
                        if (fKItemSwitchLayout3 != null) {
                            fKItemSwitchLayout3.setChecked(false);
                        }
                        view = PrivacySettingActivity.this.f18003x;
                        if (view != null) {
                            view.setVisibility(8);
                        }
                        PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                        if (privacySettingDataResult != null) {
                            privacySettingDataResult.setMatchExcludeDistanceKm(0);
                        }
                        PrivacySettingActivity.this.K1();
                    }
                    SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.NOT_RECOMMEND_ME_TO_NEARBY, z10, null, 4, null);
                }
            });
        }
        SeekBar seekBar = this.f18004y;
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new c());
        }
    }

    public final void D1() {
        Boolean upgradeFlag;
        PrivacySettingDataResult privacySettingDataResult = this.f18000u;
        boolean booleanValue = (privacySettingDataResult == null || (upgradeFlag = privacySettingDataResult.getUpgradeFlag()) == null) ? true : upgradeFlag.booleanValue();
        if (booleanValue) {
            j1(R$id.layout_normal_private).setVisibility(8);
            int i10 = R$id.layout_svip_private;
            j1(i10).setVisibility(0);
            this.f18002w = (FKItemSwitchLayout) j1(i10).findViewById(R$id.hideRangeSwitchLayout);
            this.f18001v = (FKItemSwitchLayout) j1(i10).findViewById(R$id.hideLocationSwitchLayout);
            this.f18003x = j1(i10).findViewById(R$id.privacyRangeLayout);
            this.f18004y = (SeekBar) j1(i10).findViewById(R$id.privacyRangeSeekBar);
            this.f18005z = (TextView) j1(i10).findViewById(R$id.rangePromptTextView);
            FKItemSwitchLayout fKItemSwitchLayout = this.f18001v;
            if (fKItemSwitchLayout != null) {
                fKItemSwitchLayout.setSwitchButton(R$drawable.fk_svip_check_button_selector);
            }
            FKItemSwitchLayout fKItemSwitchLayout2 = this.f18002w;
            if (fKItemSwitchLayout2 != null) {
                fKItemSwitchLayout2.setSwitchButton(R$drawable.fk_svip_check_button_selector);
            }
            SeekBar seekBar = this.f18004y;
            if (seekBar != null) {
                seekBar.setProgressTintList(null);
            }
            B1();
            return;
        }
        if (booleanValue) {
            return;
        }
        j1(R$id.layout_svip_private).setVisibility(8);
        int i11 = R$id.layout_normal_private;
        j1(i11).setVisibility(0);
        this.f18002w = (FKItemSwitchLayout) j1(i11).findViewById(R$id.hideRangeSwitchLayout);
        this.f18001v = (FKItemSwitchLayout) j1(i11).findViewById(R$id.hideLocationSwitchLayout);
        this.f18003x = j1(i11).findViewById(R$id.privacyRangeLayout);
        this.f18004y = (SeekBar) j1(i11).findViewById(R$id.privacyRangeSeekBar);
        this.f18005z = (TextView) j1(i11).findViewById(R$id.rangePromptTextView);
        FKItemSwitchLayout fKItemSwitchLayout3 = this.f18001v;
        if (fKItemSwitchLayout3 != null) {
            fKItemSwitchLayout3.setSwitchButton(R$drawable.fk_check_button_selector);
        }
        FKItemSwitchLayout fKItemSwitchLayout4 = this.f18002w;
        if (fKItemSwitchLayout4 != null) {
            fKItemSwitchLayout4.setSwitchButton(R$drawable.fk_check_button_selector);
        }
        SeekBar seekBar2 = this.f18004y;
        if (seekBar2 != null) {
            seekBar2.setProgressTintList(ColorStateList.valueOf(-49088));
        }
        C1();
    }

    public final void E1(int i10) {
        int color;
        PrivacySettingDataResult privacySettingDataResult = this.f18000u;
        if (privacySettingDataResult != null ? kotlin.jvm.internal.s.d(privacySettingDataResult.getUpgradeFlag(), Boolean.FALSE) : false) {
            color = ContextCompat.getColor(this, R$color.prime_red);
        } else {
            color = ContextCompat.getColor(this, R$color.yellow_EAAD5B);
        }
        int i11 = color;
        int i12 = this.f17998s;
        int i13 = this.f17999t;
        if (i10 < i13 && i12 <= i10) {
            TextView textView = this.f18005z;
            if (textView != null) {
                textView.setTextColor(-15066598);
            }
            TextView textView2 = this.f18005z;
            if (textView2 == null) {
                return;
            }
            String string = getString(R$string.hide_range_prompt, new Object[]{Integer.valueOf(i10)});
            kotlin.jvm.internal.s.h(string, "getString(R.string.hide_range_prompt, progress)");
            textView2.setText(z0.t.k(string, i11, new String[]{String.valueOf(i10), "km"}, false, 4, null));
            return;
        }
        if (i10 >= i13) {
            TextView textView3 = this.f18005z;
            if (textView3 != null) {
                textView3.setText(R$string.all_account_dont_look);
            }
            TextView textView4 = this.f18005z;
            if (textView4 != null) {
                textView4.setTextColor(i11);
                return;
            }
            return;
        }
        TextView textView5 = this.f18005z;
        if (textView5 != null) {
            textView5.setTextColor(-15066598);
        }
        TextView textView6 = this.f18005z;
        if (textView6 == null) {
            return;
        }
        String string2 = getString(R$string.hide_range_prompt, new Object[]{Integer.valueOf(this.f17998s)});
        kotlin.jvm.internal.s.h(string2, "getString(R.string.hide_range_prompt, minDistance)");
        textView6.setText(z0.t.k(string2, i11, new String[]{String.valueOf(this.f17998s), "km"}, false, 4, null));
    }

    public final void F1(PrivacySettingDataResult privacySettingDataResult) {
        if (privacySettingDataResult == null) {
            return;
        }
        this.f18000u = privacySettingDataResult;
        D1();
        ((FKItemSwitchLayout) j1(R$id.activeLayout)).setChecked(privacySettingDataResult.getHiddenActive());
        FKItemSwitchLayout fKItemSwitchLayout = this.f18001v;
        if (fKItemSwitchLayout != null) {
            fKItemSwitchLayout.setChecked(privacySettingDataResult.getHidden());
        }
        ((FKItemSwitchLayout) j1(R$id.showVipIconLayout)).setChecked(privacySettingDataResult.isShowVipIcon());
        ((FKItemSwitchLayout) j1(R$id.wealthLevelLayout)).setChecked(privacySettingDataResult.getHideBalanceLevel());
        L1(privacySettingDataResult.getMatchExcludeDistanceKm());
        A1(privacySettingDataResult);
        ((FKItemSwitchLayout) j1(R$id.view_message_privately)).setChecked(privacySettingDataResult.getStealthMessage());
        ((FKItemSwitchLayout) j1(R$id.expireTextRemindLayout)).setChecked(privacySettingDataResult.getExpireTextRemind());
        z1(privacySettingDataResult);
        ((FKItemSwitchLayout) j1(R$id.notNearBoostShow)).setChecked(privacySettingDataResult.getNotInNearbyForBoot());
    }

    public final void G1() {
        Disposable disposed = NetworkClient.f11868a.N().F0().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<PrivacySettingDataResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$getPrivacySettingData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(PrivacySettingDataResult privacySettingDataResult) {
                m2792invoke(privacySettingDataResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2792invoke(PrivacySettingDataResult privacySettingDataResult) {
                PrivacySettingDataResult privacySettingDataResult2 = privacySettingDataResult;
                p1.g.f52734a.I0().d(privacySettingDataResult2);
                PrivacySettingActivity.this.F1(privacySettingDataResult2);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        VipDiscountDescription.f18726b.b(this, new d());
    }

    public final PurchaseDialogManager H1() {
        return (PurchaseDialogManager) this.f17996q.getValue();
    }

    @NotNull
    public final xb.b I1() {
        return (xb.b) this.f17997r.getValue();
    }

    public final void J1() {
        p1.g gVar = p1.g.f52734a;
        ConstantsResult q10 = gVar.q();
        if (q10 != null ? kotlin.jvm.internal.s.d(q10.getVasSubExpireMsgRemind(), Boolean.TRUE) : false) {
            ((FKItemSwitchLayout) j1(R$id.expireTextRemindLayout)).setVisibility(0);
        } else {
            ((FKItemSwitchLayout) j1(R$id.expireTextRemindLayout)).setVisibility(8);
        }
        F1(gVar.I0().c());
        ((FKItemSwitchLayout) j1(R$id.forbidAiFindMe)).setVisibility(0);
    }

    public final void K1() {
        final PrivacySettingDataResult privacySettingDataResult = this.f18000u;
        if (privacySettingDataResult != null) {
            Disposable disposed = a.C0836a.f(NetworkClient.f11868a.N(), privacySettingDataResult.getMatchExcludeDistanceKm(), Boolean.valueOf(privacySettingDataResult.getHiddenActive()), Boolean.valueOf(privacySettingDataResult.getHidden()), Boolean.valueOf(privacySettingDataResult.getHiddenFootmark()), Boolean.valueOf(privacySettingDataResult.getStealthMessage()), Boolean.valueOf(privacySettingDataResult.getVipIconHide()), null, null, Boolean.valueOf(privacySettingDataResult.getHideBalanceLevel()), Boolean.valueOf(privacySettingDataResult.getAiGraphHide()), Boolean.valueOf(privacySettingDataResult.getExpireTextRemind()), Boolean.valueOf(privacySettingDataResult.getNotInNearbyForBoot()), 192, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<PrivacySettingDataResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$saveConfigSetting$lambda$2$$inlined$handle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(PrivacySettingDataResult privacySettingDataResult2) {
                    m2793invoke(privacySettingDataResult2);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2793invoke(PrivacySettingDataResult privacySettingDataResult2) {
                    FKDeleteSessionUtil.f13177a.c(Boolean.valueOf(PrivacySettingDataResult.this.getStealthMessage()));
                    p1.g.f52734a.I0().d(PrivacySettingDataResult.this);
                    this.A1(PrivacySettingDataResult.this);
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$saveConfigSetting$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    PrivacySettingActivity.this.F1(p1.g.f52734a.I0().c());
                    return Boolean.FALSE;
                }
            }, this)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
                H(disposed);
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
    }

    public final void L1(Integer num) {
        boolean z10 = num != null && num.intValue() > 0;
        View view = this.f18003x;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
        }
        SeekBar seekBar = this.f18004y;
        if (seekBar != null) {
            seekBar.setProgress(num != null ? num.intValue() : this.f17998s);
        }
        FKItemSwitchLayout fKItemSwitchLayout = this.f18002w;
        if (fKItemSwitchLayout != null) {
            fKItemSwitchLayout.setChecked(z10);
        }
        E1(num != null ? num.intValue() : this.f17998s);
    }

    public final void M1(String str) {
        final AlertDialog g3;
        if (str == null || str.length() == 0) {
            return;
        }
        View layout = View.inflate(this, R$layout.dialog_notitle_base_view, null);
        z0.b bVar = z0.b.f54812a;
        kotlin.jvm.internal.s.h(layout, "layout");
        g3 = bVar.g(this, layout, 0, 0, z0.h.c(this, 300.0f), -2, (r32 & 64) != 0 ? 17 : 0, (r32 & 128) != 0 ? null : null, (r32 & 256) != 0 ? null : null, (r32 & 512) != 0 ? null : null, (r32 & 1024) != 0 ? null : null, (r32 & 2048) != 0 ? null : null, (r32 & 4096) != 0 ? null : null, (r32 & 8192) != 0 ? null : null);
        ((TextView) layout.findViewById(R$id.content_txt)).setText(str);
        View findViewById = layout.findViewById(R$id.cancel_txt);
        kotlin.jvm.internal.s.h(findViewById, "layout.findViewById<TextView>(R.id.cancel_txt)");
        z0.y.d(findViewById, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$showHideLocationDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                g3.dismiss();
            }
        });
        TextView confirmTxt = (TextView) layout.findViewById(R$id.confirm_txt);
        confirmTxt.setText(getString(R$string.close_str));
        kotlin.jvm.internal.s.h(confirmTxt, "confirmTxt");
        z0.y.d(confirmTxt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$showHideLocationDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FKItemSwitchLayout fKItemSwitchLayout;
                fKItemSwitchLayout = PrivacySettingActivity.this.f18001v;
                if (fKItemSwitchLayout != null) {
                    fKItemSwitchLayout.setChecked(false);
                }
                PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                if (privacySettingDataResult != null) {
                    privacySettingDataResult.setHidden(false);
                }
                PrivacySettingActivity.this.K1();
                g3.dismiss();
            }
        });
    }

    public final void N1(String str) {
        final AlertDialog g3;
        if (str == null || str.length() == 0) {
            return;
        }
        View layout = View.inflate(this, R$layout.dialog_notitle_base_view, null);
        z0.b bVar = z0.b.f54812a;
        kotlin.jvm.internal.s.h(layout, "layout");
        g3 = bVar.g(this, layout, 0, 0, z0.h.c(this, 300.0f), -2, (r32 & 64) != 0 ? 17 : 0, (r32 & 128) != 0 ? null : null, (r32 & 256) != 0 ? null : null, (r32 & 512) != 0 ? null : null, (r32 & 1024) != 0 ? null : null, (r32 & 2048) != 0 ? null : null, (r32 & 4096) != 0 ? null : null, (r32 & 8192) != 0 ? null : null);
        ((TextView) layout.findViewById(R$id.content_txt)).setText(str);
        View findViewById = layout.findViewById(R$id.cancel_txt);
        kotlin.jvm.internal.s.h(findViewById, "layout.findViewById<TextView>(R.id.cancel_txt)");
        z0.y.d(findViewById, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$showHideRangeCloseDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                g3.dismiss();
            }
        });
        View findViewById2 = layout.findViewById(R$id.confirm_txt);
        kotlin.jvm.internal.s.h(findViewById2, "layout.findViewById<TextView>(R.id.confirm_txt)");
        z0.y.d(findViewById2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$showHideRangeCloseDialog$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                if (privacySettingDataResult != null) {
                    privacySettingDataResult.setMatchExcludeDistanceKm(0);
                }
                PrivacySettingActivity.this.L1(0);
                PrivacySettingActivity.this.K1();
                g3.dismiss();
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PrivacySetting;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.A;
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
        setContentView(R$layout.activity_privacy_setting);
        J1();
        G1();
        y1();
        j1.c.b(j1.c.f50228a, SensorPosition.PrivacySetting, null, null, 6, null);
    }

    public final void y1() {
        ((FKTitleBarLayout) j1(R$id.privacySettingTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$1
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
                PrivacySettingActivity.this.finish();
            }
        });
        FKItemLayout setPrivacyAdSetting = (FKItemLayout) j1(R$id.setPrivacyAdSetting);
        kotlin.jvm.internal.s.h(setPrivacyAdSetting, "setPrivacyAdSetting");
        z0.y.d(setPrivacyAdSetting, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$2
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
                PersonalizationOptionsActivity.f17989r.a(PrivacySettingActivity.this);
            }
        });
        FKItemLayout system_permission_manage_layout = (FKItemLayout) j1(R$id.system_permission_manage_layout);
        kotlin.jvm.internal.s.h(system_permission_manage_layout, "system_permission_manage_layout");
        z0.y.d(system_permission_manage_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$3
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
                SystemPermissionManageActivity.f18019r.a(PrivacySettingActivity.this);
            }
        });
        ((FKItemSwitchLayout) j1(R$id.expireTextRemindLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                if (privacySettingDataResult != null) {
                    privacySettingDataResult.setExpireTextRemind(z10);
                }
                PrivacySettingActivity.this.K1();
                SensorsLogUserStatusSwitch.f12217a.a(AppSetting.AUTO_PAY_REMIND, z10, PrivacySettingActivity.this.Q0());
            }
        });
        ((FKItemSwitchLayout) j1(R$id.notNearBoostShow)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                if (privacySettingDataResult != null) {
                    privacySettingDataResult.setNotInNearbyForBoot(z10);
                }
                PrivacySettingActivity.this.K1();
                SensorsLogUserStatusSwitch.f12217a.a(AppSetting.SUPER_BOOST_NEARBY_NOT_SHOW, z10, PrivacySettingActivity.this.Q0());
            }
        });
        ((FKItemSwitchLayout) j1(R$id.wealthLevelLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                PurchaseDialogManager H1;
                SensorsLogKeyButtonClick.PrivacySetting.HideWealthLevel.click();
                if (!com.cupidapp.live.profile.logic.c.f17839a.f()) {
                    H1 = PrivacySettingActivity.this.H1();
                    PurchaseDialogManager.j(H1, VipPurchaseEntranceType.WealthLevelHide, null, null, false, 14, null);
                    ((FKItemSwitchLayout) PrivacySettingActivity.this.j1(R$id.wealthLevelLayout)).setChecked(false);
                } else {
                    PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                    if (privacySettingDataResult != null) {
                        privacySettingDataResult.setHideBalanceLevel(z10);
                    }
                    PrivacySettingActivity.this.K1();
                    SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.HIDE_WEALTH_LEVEL, z10, null, 4, null);
                }
            }
        });
        ((FKItemSwitchLayout) j1(R$id.activeLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                PurchaseDialogManager H1;
                SensorsLogKeyButtonClick.PrivacySetting.HideMyActiveTime.click();
                if (!com.cupidapp.live.profile.logic.c.f17839a.f()) {
                    H1 = PrivacySettingActivity.this.H1();
                    PurchaseDialogManager.j(H1, VipPurchaseEntranceType.PrivacyHideActive, null, null, false, 14, null);
                    ((FKItemSwitchLayout) PrivacySettingActivity.this.j1(R$id.activeLayout)).setChecked(false);
                } else {
                    PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                    if (privacySettingDataResult != null) {
                        privacySettingDataResult.setHiddenActive(z10);
                    }
                    PrivacySettingActivity.this.K1();
                    SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.HIDE_ACTIVE_TIME, z10, null, 4, null);
                }
            }
        });
        ((FKItemSwitchLayout) j1(R$id.hideFootmarkLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                PurchaseDialogManager H1;
                if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
                    PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                    if (privacySettingDataResult != null) {
                        privacySettingDataResult.setHiddenFootmark(z10);
                    }
                    PrivacySettingActivity.this.K1();
                    GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.HIDE_VISIT, z10, SensorPosition.PrivacySetting, null, 8, null);
                    return;
                }
                ((FKItemSwitchLayout) PrivacySettingActivity.this.j1(R$id.hideFootmarkLayout)).setChecked(false);
                H1 = PrivacySettingActivity.this.H1();
                PurchaseDialogManager.q(H1, VipPurchaseEntranceType.HiddenFootmarkPrivacySetting, null, null, false, false, 30, null);
            }
        });
        ((FKItemSwitchLayout) j1(R$id.showVipIconLayout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                PurchaseDialogManager H1;
                if (com.cupidapp.live.profile.logic.c.f17839a.f()) {
                    PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                    if (privacySettingDataResult != null) {
                        privacySettingDataResult.setVipIconHide(!z10);
                    }
                    PrivacySettingActivity.this.K1();
                    GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.HIDE_VIP_IDENTIFICATION, z10, SensorPosition.PrivacySetting, null, 8, null);
                    return;
                }
                FKItemSwitchLayout fKItemSwitchLayout = (FKItemSwitchLayout) PrivacySettingActivity.this.j1(R$id.showVipIconLayout);
                PrivacySettingDataResult privacySettingDataResult2 = PrivacySettingActivity.this.f18000u;
                fKItemSwitchLayout.setChecked(privacySettingDataResult2 != null ? privacySettingDataResult2.isShowVipIcon() : false);
                H1 = PrivacySettingActivity.this.H1();
                PurchaseDialogManager.j(H1, VipPurchaseEntranceType.PrivacyHideVipIcon, null, null, false, 14, null);
            }
        });
        FKItemLayout dont_look_him_layout = (FKItemLayout) j1(R$id.dont_look_him_layout);
        kotlin.jvm.internal.s.h(dont_look_him_layout, "dont_look_him_layout");
        z0.y.d(dont_look_him_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$10
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
                FKBaseListActivity.f17609r.a(PrivacySettingActivity.this, FKBaseListType.DontLookHimList);
            }
        });
        FKItemLayout blackListLayout = (FKItemLayout) j1(R$id.blackListLayout);
        kotlin.jvm.internal.s.h(blackListLayout, "blackListLayout");
        z0.y.d(blackListLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$11
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
                FKBaseListActivity.f17609r.a(PrivacySettingActivity.this, FKBaseListType.BlackList);
            }
        });
        ((FKItemSwitchLayout) j1(R$id.view_message_privately)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$bindClickEvent$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                PurchaseDialogManager H1;
                if (com.cupidapp.live.profile.logic.c.f17839a.d()) {
                    PrivacySettingDataResult privacySettingDataResult = PrivacySettingActivity.this.f18000u;
                    if (privacySettingDataResult != null) {
                        privacySettingDataResult.setStealthMessage(z10);
                    }
                    PrivacySettingActivity.this.K1();
                    GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.SECRET_VIEW, z10, SensorPosition.PrivacySetting, null, 8, null);
                    return;
                }
                ((FKItemSwitchLayout) PrivacySettingActivity.this.j1(R$id.view_message_privately)).setChecked(false);
                H1 = PrivacySettingActivity.this.H1();
                PurchaseDialogManager.q(H1, VipPurchaseEntranceType.ViewPrivatelyPrivacySetting, null, null, false, false, 30, null);
            }
        });
    }

    public final void z1(PrivacySettingDataResult privacySettingDataResult) {
        int i10 = R$id.forbidAiFindMe;
        ((FKItemSwitchLayout) j1(i10)).setChecked(privacySettingDataResult.getAiGraphHide());
        FKItemSwitchLayout fKItemSwitchLayout = (FKItemSwitchLayout) j1(i10);
        if (fKItemSwitchLayout != null) {
            fKItemSwitchLayout.setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PrivacySettingActivity$configForbidAiFindMe$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return kotlin.p.f51048a;
                }

                public final void invoke(boolean z10) {
                    PrivacySettingDataResult privacySettingDataResult2 = PrivacySettingActivity.this.f18000u;
                    if (privacySettingDataResult2 != null) {
                        privacySettingDataResult2.setAiGraphHide(z10);
                    }
                    PrivacySettingActivity.this.K1();
                    SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.FORBID_AI_IDENTITY_FIND, z10, null, 4, null);
                }
            });
        }
    }
}
