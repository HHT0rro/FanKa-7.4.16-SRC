package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKOpenPushSettingHelpActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKOpenPushSettingHelpActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17958r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17959q = new LinkedHashMap();

    /* compiled from: FKOpenPushSettingHelpActivity.kt */
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
            context.startActivity(new Intent(context, (Class<?>) FKOpenPushSettingHelpActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17959q;
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
        ((FKTitleBarLayout) j1(R$id.open_push_setting_title_layout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.FKOpenPushSettingHelpActivity$bindClickEvent$1
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
                FKOpenPushSettingHelpActivity.this.finish();
            }
        });
        FKItemLayout huawei_item_layout = (FKItemLayout) j1(R$id.huawei_item_layout);
        kotlin.jvm.internal.s.h(huawei_item_layout, "huawei_item_layout");
        z0.y.d(huawei_item_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.FKOpenPushSettingHelpActivity$bindClickEvent$2
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
                SensorsLogKeyButtonClick.OpenPush.Huawei.click();
                FKOpenPushSettingHelpActivity.this.n1("huawei");
            }
        });
        FKItemLayout xiaomi_item_layout = (FKItemLayout) j1(R$id.xiaomi_item_layout);
        kotlin.jvm.internal.s.h(xiaomi_item_layout, "xiaomi_item_layout");
        z0.y.d(xiaomi_item_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.FKOpenPushSettingHelpActivity$bindClickEvent$3
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
                SensorsLogKeyButtonClick.OpenPush.Xiaomi.click();
                FKOpenPushSettingHelpActivity.this.n1("XIAOMI");
            }
        });
        FKItemLayout oppo_item_layout = (FKItemLayout) j1(R$id.oppo_item_layout);
        kotlin.jvm.internal.s.h(oppo_item_layout, "oppo_item_layout");
        z0.y.d(oppo_item_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.FKOpenPushSettingHelpActivity$bindClickEvent$4
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
                SensorsLogKeyButtonClick.OpenPush.Oppo.click();
                FKOpenPushSettingHelpActivity.this.n1("OPPO");
            }
        });
        FKItemLayout oneplus_item_layout = (FKItemLayout) j1(R$id.oneplus_item_layout);
        kotlin.jvm.internal.s.h(oneplus_item_layout, "oneplus_item_layout");
        z0.y.d(oneplus_item_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.FKOpenPushSettingHelpActivity$bindClickEvent$5
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
                SensorsLogKeyButtonClick.OpenPush.Oneplus.click();
                FKOpenPushSettingHelpActivity.this.n1("yijia");
            }
        });
        FKItemLayout vivo_item_layout = (FKItemLayout) j1(R$id.vivo_item_layout);
        kotlin.jvm.internal.s.h(vivo_item_layout, "vivo_item_layout");
        z0.y.d(vivo_item_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.FKOpenPushSettingHelpActivity$bindClickEvent$6
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
                SensorsLogKeyButtonClick.OpenPush.Vivo.click();
                FKOpenPushSettingHelpActivity.this.n1("VIVO");
            }
        });
    }

    public final void m1() {
        ((TextView) j1(R$id.choose_phone_text_view)).getPaint().setFakeBoldText(true);
    }

    public final void n1(String str) {
        j.a.b(com.cupidapp.live.base.router.j.f12156c, this, NetworkClient.f11868a.n() + "/hd/doc/android-push-desc?deviceType=" + str, null, 4, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_open_push_setting_help);
        m1();
        l1();
    }
}
