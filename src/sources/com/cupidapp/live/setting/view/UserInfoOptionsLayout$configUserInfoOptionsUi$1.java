package com.cupidapp.live.setting.view;

import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorLogActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.setting.model.UserInfoOptionsUiModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserInfoOptionsLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class UserInfoOptionsLayout$configUserInfoOptionsUi$1 extends Lambda implements Function1<View, p> {
    public final /* synthetic */ UserInfoOptionsUiModel $model;
    public final /* synthetic */ UserInfoOptionsLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInfoOptionsLayout$configUserInfoOptionsUi$1(UserInfoOptionsLayout userInfoOptionsLayout, UserInfoOptionsUiModel userInfoOptionsUiModel) {
        super(1);
        this.this$0 = userInfoOptionsLayout;
        this.$model = userInfoOptionsUiModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(View view) {
        invoke2(view);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable View view) {
        this.this$0.a(R$id.red_tips_view).setVisibility(8);
        SensorLogActivity.f12204a.a(SensorPosition.Setting.getValue(), this.$model.getUrl(), SensorLogActivity.Type.PROFILE.getType());
        j.a.b(j.f12156c, this.this$0.getContext(), this.$model.getUrl(), null, 4, null);
    }
}
