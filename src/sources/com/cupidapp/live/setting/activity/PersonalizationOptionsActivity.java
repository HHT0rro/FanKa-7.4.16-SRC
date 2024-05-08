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
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.AppSetting;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKItemSwitchLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.setting.model.PrivacySettingDataResult;
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
import x2.a;

/* compiled from: PersonalizationOptionsActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PersonalizationOptionsActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17989r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17990q = new LinkedHashMap();

    /* compiled from: PersonalizationOptionsActivity.kt */
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
            context.startActivity(new Intent(context, (Class<?>) PersonalizationOptionsActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PersonalizationOptions;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17990q;
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

    public final void k1() {
        ((FKTitleBarLayout) j1(R$id.personalization_options_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalizationOptionsActivity$bindClickEvent$1
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
                PersonalizationOptionsActivity.this.finish();
            }
        });
    }

    public final void l1() {
        final PrivacySettingDataResult c4 = p1.g.f52734a.I0().c();
        if (c4 == null) {
            return;
        }
        int i10 = R$id.personalized_ad_display_layout;
        ((FKItemSwitchLayout) j1(i10)).setChecked(c4.getAdvertising());
        ((FKItemSwitchLayout) j1(i10)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalizationOptionsActivity$configPersonalizedAdDisplay$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(final boolean z10) {
                GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.PERSONALIZATION_AD_SHOW, z10, PersonalizationOptionsActivity.this.Q0(), null, 8, null);
                Observable<Result<Object>> f02 = NetworkClient.f11868a.N().f0(z10);
                PersonalizationOptionsActivity personalizationOptionsActivity = PersonalizationOptionsActivity.this;
                final PrivacySettingDataResult privacySettingDataResult = c4;
                Disposable disposed = f02.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalizationOptionsActivity$configPersonalizedAdDisplay$1$invoke$$inlined$handle$default$1
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
                        PrivacySettingDataResult.this.setAdvertising(z10);
                        p1.g.f52734a.I0().d(PrivacySettingDataResult.this);
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, personalizationOptionsActivity)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (personalizationOptionsActivity != null) {
                        personalizationOptionsActivity.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
        });
    }

    public final void m1() {
        final PrivacySettingDataResult c4 = p1.g.f52734a.I0().c();
        if (c4 == null) {
            return;
        }
        Boolean openPersonalizedRecommendation = c4.getOpenPersonalizedRecommendation();
        boolean booleanValue = openPersonalizedRecommendation != null ? openPersonalizedRecommendation.booleanValue() : true;
        int i10 = R$id.personalized_content_recommend_layout;
        ((FKItemSwitchLayout) j1(i10)).setChecked(booleanValue);
        ((FKItemSwitchLayout) j1(i10)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalizationOptionsActivity$configPersonalizedContentRecommend$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(final boolean z10) {
                GroupOthersLog.l0(GroupOthersLog.f18702a, AppSetting.PERSONALIZATION_RECOMMEND, z10, PersonalizationOptionsActivity.this.Q0(), null, 8, null);
                Observable f10 = a.C0836a.f(NetworkClient.f11868a.N(), null, null, null, null, null, null, Boolean.valueOf(z10), null, null, null, null, null, 4031, null);
                PersonalizationOptionsActivity personalizationOptionsActivity = PersonalizationOptionsActivity.this;
                final PrivacySettingDataResult privacySettingDataResult = c4;
                Disposable disposed = f10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<PrivacySettingDataResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalizationOptionsActivity$configPersonalizedContentRecommend$1$invoke$$inlined$handle$default$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(PrivacySettingDataResult privacySettingDataResult2) {
                        m2791invoke(privacySettingDataResult2);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2791invoke(PrivacySettingDataResult privacySettingDataResult2) {
                        PrivacySettingDataResult.this.setOpenPersonalizedRecommendation(Boolean.valueOf(z10));
                        p1.g gVar = p1.g.f52734a;
                        gVar.I0().d(PrivacySettingDataResult.this);
                        ConstantsResult q10 = gVar.q();
                        if (q10 != null) {
                            q10.setOpenPersonalizedRecommendation(Boolean.valueOf(z10));
                        }
                        gVar.b2(q10);
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, personalizationOptionsActivity)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (personalizationOptionsActivity != null) {
                        personalizationOptionsActivity.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_personalization_options);
        l1();
        m1();
        k1();
        j1.c.b(j1.c.f50228a, Q0(), null, null, 6, null);
    }
}
