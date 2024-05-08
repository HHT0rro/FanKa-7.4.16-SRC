package com.cupidapp.live.profile.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.extension.DateFormatPattern;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.profile.model.ProfileSpecListModel;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileDatePickerActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileDatePickerActivity extends FKBaseProfileSpecActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17656v = new LinkedHashMap();

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f17656v;
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
        setContentView(R$layout.activity_profile_date_picker);
        ProfileSpecListModel k12 = k1();
        if (k12 != null) {
            List<String> labelList = k12.getLabelList();
            com.cupidapp.live.base.view.timepicker.o e2 = com.cupidapp.live.base.view.timepicker.o.e(new com.cupidapp.live.base.view.timepicker.o(this, labelList != null ? (String) CollectionsKt___CollectionsKt.V(labelList) : null, k12.getMinValue(), k12.getMaxValue(), new Function1<Date, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileDatePickerActivity$onCreate$1$timePicker$1
                {
                    super(1);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Date date) {
                    if (date != null) {
                        ProfileDatePickerActivity.this.m1(kotlin.collections.r.e(z0.v.t(date, DateFormatPattern.YyyyMMdd)));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(Date date) {
                    invoke2(date);
                    return kotlin.p.f51048a;
                }
            }), 20, 1.5f, false, 4, null);
            int i10 = R$id.datePickerLayout;
            FrameLayout datePickerLayout = (FrameLayout) n1(i10);
            kotlin.jvm.internal.s.h(datePickerLayout, "datePickerLayout");
            final com.cupidapp.live.base.view.timepicker.o g3 = e2.g(datePickerLayout);
            FKTitleBarLayout onCreate$lambda$1$lambda$0 = (FKTitleBarLayout) n1(R$id.profileDatePickerTitleLayout);
            kotlin.jvm.internal.s.h(onCreate$lambda$1$lambda$0, "onCreate$lambda$1$lambda$0");
            FKTitleBarLayout.setSingleTitle$default(onCreate$lambda$1$lambda$0, k12.getName(), null, 2, null);
            onCreate$lambda$1$lambda$0.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileDatePickerActivity$onCreate$1$1$1
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
                    ProfileDatePickerActivity.this.finish();
                }
            });
            onCreate$lambda$1$lambda$0.setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileDatePickerActivity$onCreate$1$1$2
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
                    com.cupidapp.live.base.view.timepicker.o.this.c();
                }
            });
            g3.i((FrameLayout) n1(i10), false);
        }
    }
}
