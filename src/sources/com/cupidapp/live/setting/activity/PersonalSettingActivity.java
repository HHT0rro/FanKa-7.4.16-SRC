package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PersonalSettingActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PersonalSettingActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17987r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17988q = new LinkedHashMap();

    /* compiled from: PersonalSettingActivity.kt */
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
            context.startActivity(new Intent(context, (Class<?>) PersonalSettingActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PERSONAL_SETTING;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17988q;
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
        ((FKTitleBarLayout) j1(R$id.personal_setting_title_bar)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalSettingActivity$bindClickEvent$1
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
                PersonalSettingActivity.this.onBackPressed();
            }
        });
        FKItemLayout personal_icon_layout = (FKItemLayout) j1(R$id.personal_icon_layout);
        kotlin.jvm.internal.s.h(personal_icon_layout, "personal_icon_layout");
        z0.y.d(personal_icon_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalSettingActivity$bindClickEvent$2
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
                PersonalAppIconActivity.f17982u.a(PersonalSettingActivity.this);
            }
        });
        FKItemLayout match_card_border_layout = (FKItemLayout) j1(R$id.match_card_border_layout);
        kotlin.jvm.internal.s.h(match_card_border_layout, "match_card_border_layout");
        z0.y.d(match_card_border_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalSettingActivity$bindClickEvent$3
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
                ConstantsUrlModel urlModel;
                SensorsLogKeyButtonClick.PersonalSetting.PERSONAL_FRAME.click();
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                PersonalSettingActivity personalSettingActivity = PersonalSettingActivity.this;
                ConstantsResult q10 = p1.g.f52734a.q();
                j.a.b(aVar, personalSettingActivity, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getIndividuationFrameConfigJumpUrl(), null, 4, null);
            }
        });
        FKItemLayout custom_chat_bubble_layout = (FKItemLayout) j1(R$id.custom_chat_bubble_layout);
        kotlin.jvm.internal.s.h(custom_chat_bubble_layout, "custom_chat_bubble_layout");
        z0.y.d(custom_chat_bubble_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.PersonalSettingActivity$bindClickEvent$4
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
                ConstantsUrlModel urlModel;
                SensorsLogKeyButtonClick.PersonalSetting.CUSTOM_CHAT_BUBBLE.click();
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                PersonalSettingActivity personalSettingActivity = PersonalSettingActivity.this;
                ConstantsResult q10 = p1.g.f52734a.q();
                j.a.b(aVar, personalSettingActivity, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getIndividuationInboxBubbleConfigJumpUrl(), null, 4, null);
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_personal_setting);
        FKItemLayout match_card_border_layout = (FKItemLayout) j1(R$id.match_card_border_layout);
        kotlin.jvm.internal.s.h(match_card_border_layout, "match_card_border_layout");
        match_card_border_layout.setVisibility(0);
        FKItemLayout custom_chat_bubble_layout = (FKItemLayout) j1(R$id.custom_chat_bubble_layout);
        kotlin.jvm.internal.s.h(custom_chat_bubble_layout, "custom_chat_bubble_layout");
        custom_chat_bubble_layout.setVisibility(0);
        k1();
    }
}
