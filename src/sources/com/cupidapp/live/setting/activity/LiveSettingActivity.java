package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogUserStatusSwitch;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKItemSwitchLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindowUtil;
import com.cupidapp.live.liveshow.model.LiveSettingModel;
import com.cupidapp.live.setting.activity.NewPushSettingDetailActivity;
import com.cupidapp.live.track.group.GroupOthersLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;

/* compiled from: LiveSettingActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LiveSettingActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17968r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17969q = new LinkedHashMap();

    /* compiled from: LiveSettingActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            Intent intent = new Intent(context, (Class<?>) LiveSettingActivity.class);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17969q;
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

    public final void l1() {
        ((FKTitleBarLayout) j1(R$id.live_setting_title_layout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$bindClickEvent$1
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
                LiveSettingActivity.this.finish();
            }
        });
        ((FKItemSwitchLayout) j1(R$id.mini_window_switch_layout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                if (z10) {
                    FKLiveMiniWindowUtil fKLiveMiniWindowUtil = FKLiveMiniWindowUtil.f15095a;
                    if (fKLiveMiniWindowUtil.b(LiveSettingActivity.this)) {
                        LiveSettingActivity.this.n1(true);
                    } else {
                        final LiveSettingActivity liveSettingActivity = LiveSettingActivity.this;
                        fKLiveMiniWindowUtil.e(liveSettingActivity, new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$bindClickEvent$2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return kotlin.p.f51048a;
                            }

                            public final void invoke(boolean z11) {
                                ((FKItemSwitchLayout) LiveSettingActivity.this.j1(R$id.mini_window_switch_layout)).setChecked(false);
                                LiveSettingActivity.this.n1(false);
                            }
                        });
                    }
                } else {
                    p1.g.f52734a.P().d(Boolean.TRUE);
                    LiveSettingActivity.this.n1(false);
                }
                SensorsLogUserStatusSwitch.b(SensorsLogUserStatusSwitch.f12217a, AppSetting.OPEN_MINI_WINDOWS, z10, null, 4, null);
            }
        });
        FKItemLayout open_live_remind_layout = (FKItemLayout) j1(R$id.open_live_remind_layout);
        kotlin.jvm.internal.s.h(open_live_remind_layout, "open_live_remind_layout");
        z0.y.d(open_live_remind_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$bindClickEvent$3
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
                NewPushSettingDetailActivity.f17974t.a(LiveSettingActivity.this, NewPushSettingDetailActivity.Companion.PushSettingDetail.OpenLiveNotification);
            }
        });
        ((FKItemSwitchLayout) j1(R$id.gift_expired_remind_switch_layout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$bindClickEvent$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(final boolean z10) {
                Observable i10 = a.C0826a.i(NetworkClient.f11868a.r(), Boolean.valueOf(z10), null, 2, null);
                final LiveSettingActivity liveSettingActivity = LiveSettingActivity.this;
                Disposable disposed = i10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$bindClickEvent$4$invoke$$inlined$handle$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$bindClickEvent$4.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        kotlin.jvm.internal.s.i(it, "it");
                        ((FKItemSwitchLayout) LiveSettingActivity.this.j1(R$id.gift_expired_remind_switch_layout)).setChecked(!z10);
                        return Boolean.FALSE;
                    }
                }, liveSettingActivity)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (liveSettingActivity != null) {
                        liveSettingActivity.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
                GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.EXPIRE_REMIND, z10, SensorPosition.LiveSetting, null, 8, null);
            }
        });
        ((FKItemSwitchLayout) j1(R$id.stealth_enter_switch_layout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$bindClickEvent$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(final boolean z10) {
                Observable i10 = a.C0826a.i(NetworkClient.f11868a.r(), null, Boolean.valueOf(z10), 1, null);
                final LiveSettingActivity liveSettingActivity = LiveSettingActivity.this;
                Disposable disposed = i10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$bindClickEvent$5$invoke$$inlined$handle$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                        invoke2(obj);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$bindClickEvent$5.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        kotlin.jvm.internal.s.i(it, "it");
                        ((FKItemSwitchLayout) LiveSettingActivity.this.j1(R$id.stealth_enter_switch_layout)).setChecked(!z10);
                        return Boolean.FALSE;
                    }
                }, liveSettingActivity)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (liveSettingActivity != null) {
                        liveSettingActivity.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
        });
    }

    public final void m1() {
        FKItemSwitchLayout fKItemSwitchLayout = (FKItemSwitchLayout) j1(R$id.mini_window_switch_layout);
        Boolean c4 = p1.g.f52734a.o0().c();
        fKItemSwitchLayout.setChecked(c4 != null ? c4.booleanValue() : true);
        Disposable disposed = NetworkClient.f11868a.r().f().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveSettingModel, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.LiveSettingActivity$initView$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(LiveSettingModel liveSettingModel) {
                m2784invoke(liveSettingModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2784invoke(LiveSettingModel liveSettingModel) {
                LiveSettingModel liveSettingModel2 = liveSettingModel;
                ((FKItemSwitchLayout) LiveSettingActivity.this.j1(R$id.gift_expired_remind_switch_layout)).setChecked(liveSettingModel2.getGiftExpirationReminder());
                ((FKItemSwitchLayout) LiveSettingActivity.this.j1(R$id.stealth_enter_switch_layout)).setChecked(liveSettingModel2.getStealthWatching());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void n1(boolean z10) {
        p1.g.f52734a.o0().d(Boolean.valueOf(z10));
        j1.l.f50239a.a(z10);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 200) {
            if (FKLiveMiniWindowUtil.f15095a.b(this)) {
                ((FKItemSwitchLayout) j1(R$id.mini_window_switch_layout)).setChecked(true);
                n1(true);
            } else {
                ((FKItemSwitchLayout) j1(R$id.mini_window_switch_layout)).setChecked(false);
                n1(false);
            }
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_live_setting);
        m1();
        l1();
    }
}
