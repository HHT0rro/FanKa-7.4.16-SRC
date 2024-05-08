package com.cupidapp.live.profile.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.timepicker.OptionsModel;
import com.cupidapp.live.base.view.timepicker.OptionsPickerWrapper;
import com.cupidapp.live.base.view.timepicker.h;
import com.cupidapp.live.profile.model.ProfileSpecListModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileNumberPickerActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileNumberPickerActivity extends FKBaseProfileSpecActivity {

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17663w = new LinkedHashMap();

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public final Lazy f17662v = kotlin.c.b(new Function0<OptionsPickerWrapper>() { // from class: com.cupidapp.live.profile.activity.ProfileNumberPickerActivity$optionPicker$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final OptionsPickerWrapper invoke() {
            return new OptionsPickerWrapper();
        }
    });

    /* compiled from: ProfileNumberPickerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements com.cupidapp.live.base.view.timepicker.h {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<String> f17665b;

        public a(List<String> list) {
            this.f17665b = list;
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void a(int i10, int i11, int i12) {
            ProfileNumberPickerActivity.this.m1(kotlin.collections.r.e(this.f17665b.get(i10)));
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void b(int i10, int i11, int i12) {
            h.a.c(this, i10, i11, i12);
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void onCancel() {
            h.a.a(this);
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void onConfirm() {
            h.a.b(this);
        }
    }

    @Nullable
    public View n1(int i10) {
        Map<Integer, View> map = this.f17663w;
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
        OptionsPickerWrapper p10;
        List<String> labelList;
        super.onCreate(bundle);
        setContentView(R$layout.activity_profile_number_picker);
        ArrayList arrayList = new ArrayList();
        ProfileSpecListModel k12 = k1();
        if (k12 != null) {
            int parseInt = Integer.parseInt(k12.getMinValue());
            int parseInt2 = Integer.parseInt(k12.getMaxValue());
            if (parseInt <= parseInt2) {
                while (true) {
                    arrayList.add(String.valueOf(parseInt));
                    if (parseInt == parseInt2) {
                        break;
                    } else {
                        parseInt++;
                    }
                }
            }
            ProfileSpecListModel k13 = k1();
            OptionsPickerWrapper s2 = OptionsPickerWrapper.i(p1(), this, new OptionsModel(arrayList, (k13 == null || (labelList = k13.getLabelList()) == null) ? null : (String) CollectionsKt___CollectionsKt.V(labelList)), null, null, 12, null).s(new a(arrayList));
            Typeface MONOSPACE = Typeface.MONOSPACE;
            kotlin.jvm.internal.s.h(MONOSPACE, "MONOSPACE");
            p10 = OptionsPickerWrapper.o(s2, 20, 1.5f, 9, null, null, null, MONOSPACE, false, (FrameLayout) n1(R$id.numberPickerFrameLayout), 56, null).p((r18 & 1) != 0 ? null : null, (r18 & 2) != 0, (r18 & 4) != 0 ? R$string.determine : 0, (r18 & 8) != 0 ? 16.0f : 0.0f, (r18 & 16) != 0 ? -15395563 : 0, (r18 & 32) != 0 ? 2131886363 : 0, (r18 & 64) == 0 ? 0.0f : 16.0f, (r18 & 128) != 0 ? -3750202 : 0);
            p10.f(false).t(false);
            FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) n1(R$id.numberPickerTitleBarLayout);
            fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileNumberPickerActivity$onCreate$1$2$1
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
                    ProfileNumberPickerActivity.this.finish();
                }
            });
            fKTitleBarLayout.setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.profile.activity.ProfileNumberPickerActivity$onCreate$1$2$2
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
                    OptionsPickerWrapper p12;
                    p12 = ProfileNumberPickerActivity.this.p1();
                    p12.m();
                }
            });
        }
    }

    public final OptionsPickerWrapper p1() {
        return (OptionsPickerWrapper) this.f17662v.getValue();
    }
}
