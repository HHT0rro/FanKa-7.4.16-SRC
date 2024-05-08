package com.cupidapp.live.setting.view;

import android.view.View;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.setting.model.UserFunctionEntranceUiModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserFunctionEntranceLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class UserFunctionEntranceLayout$configUserInfoOptionsUi$1 extends Lambda implements Function1<View, p> {
    public final /* synthetic */ UserFunctionEntranceUiModel $model;
    public final /* synthetic */ UserFunctionEntranceLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserFunctionEntranceLayout$configUserInfoOptionsUi$1(UserFunctionEntranceUiModel userFunctionEntranceUiModel, UserFunctionEntranceLayout userFunctionEntranceLayout) {
        super(1);
        this.$model = userFunctionEntranceUiModel;
        this.this$0 = userFunctionEntranceLayout;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(View view) {
        invoke2(view);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable View view) {
        SensorsLogKeyButtonClick.UserSetting userSetting = SensorsLogKeyButtonClick.UserSetting.CustomName;
        String trackName = this.$model.getTrackName();
        if (trackName == null) {
            trackName = "";
        }
        userSetting.setButtonName(trackName);
        userSetting.click();
        j.a.b(j.f12156c, this.this$0.getContext(), this.$model.getUrl(), null, 4, null);
    }
}
