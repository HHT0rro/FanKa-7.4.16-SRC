package com.cupidapp.live.setting.view;

import android.view.View;
import com.cupidapp.live.setting.model.UserInfoOptionsUiModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserInfoOptionsLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
final class UserInfoOptionsLayout$configUserInfoOptionsUi$2 extends Lambda implements Function1<View, p> {
    public final /* synthetic */ UserInfoOptionsUiModel $model;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserInfoOptionsLayout$configUserInfoOptionsUi$2(UserInfoOptionsUiModel userInfoOptionsUiModel) {
        super(1);
        this.$model = userInfoOptionsUiModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(View view) {
        invoke2(view);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable View view) {
        this.$model.getAction().invoke();
    }
}
