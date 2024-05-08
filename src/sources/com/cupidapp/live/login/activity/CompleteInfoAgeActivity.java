package com.cupidapp.live.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.DateFormatPattern;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKBottomLoft;
import com.cupidapp.live.base.view.timepicker.g;
import com.cupidapp.live.base.view.timepicker.l;
import com.cupidapp.live.login.activity.CompleteInfoAvatarActivity;
import com.cupidapp.live.login.layout.LoginNextButton;
import com.cupidapp.live.login.viewmodel.CompleteInfoViewModel;
import com.cupidapp.live.profile.model.ProfileSpecListModel;
import j1.i;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.y;

/* compiled from: CompleteInfoAgeActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CompleteInfoAgeActivity extends FKBaseActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f16060v = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16061q;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public String f16064t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16065u = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16062r = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAgeActivity$returnBack$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(CompleteInfoAgeActivity.this.getIntent().getBooleanExtra("RETURN_BACK", true));
        }
    });

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f16063s = kotlin.c.b(new Function0<g>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAgeActivity$timePicker$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final g invoke() {
            return new g();
        }
    });

    /* compiled from: CompleteInfoAgeActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            aVar.a(context, z10);
        }

        public final void a(@Nullable Context context, boolean z10) {
            Intent intent = new Intent(context, (Class<?>) CompleteInfoAgeActivity.class);
            intent.putExtra("RETURN_BACK", z10);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.f11750o.b(context, 0, R$anim.alpha_out_duration_180);
        }
    }

    /* compiled from: CompleteInfoAgeActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements l {
        public b() {
        }

        @Override // com.cupidapp.live.base.view.timepicker.l
        public void a(@Nullable Date date) {
            ((LoginNextButton) CompleteInfoAgeActivity.this.l1(R$id.age_next_button)).setSelected(true);
            CompleteInfoAgeActivity.this.f16064t = date != null ? v.t(date, DateFormatPattern.YyyyMMdd) : null;
            if (CompleteInfoAgeActivity.this.f16064t == null) {
                ((TextView) CompleteInfoAgeActivity.this.l1(R$id.year_value_textview)).setText("-");
                ((TextView) CompleteInfoAgeActivity.this.l1(R$id.month_value_textview)).setText("-");
                ((TextView) CompleteInfoAgeActivity.this.l1(R$id.day_value_textview)).setText("-");
            } else {
                String str = CompleteInfoAgeActivity.this.f16064t;
                List z02 = str != null ? StringsKt__StringsKt.z0(str, new String[]{"-"}, false, 0, 6, null) : null;
                ((TextView) CompleteInfoAgeActivity.this.l1(R$id.year_value_textview)).setText(z02 != null ? (String) z02.get(0) : null);
                ((TextView) CompleteInfoAgeActivity.this.l1(R$id.month_value_textview)).setText(z02 != null ? (String) z02.get(1) : null);
                ((TextView) CompleteInfoAgeActivity.this.l1(R$id.day_value_textview)).setText(z02 != null ? (String) z02.get(2) : null);
            }
        }

        @Override // com.cupidapp.live.base.view.timepicker.l
        public void b(@Nullable Date date) {
            l.a.a(this, date);
        }
    }

    public CompleteInfoAgeActivity() {
        final Function0 function0 = null;
        this.f16061q = new ViewModelLazy(kotlin.jvm.internal.v.b(CompleteInfoViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAgeActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAgeActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAgeActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void u1(CompleteInfoAgeActivity this$0, ProfileSpecListModel profileSpecListModel) {
        List<String> labelList;
        s.i(this$0, "this$0");
        this$0.w1((profileSpecListModel == null || (labelList = profileSpecListModel.getLabelList()) == null) ? null : labelList.get(0), profileSpecListModel != null ? profileSpecListModel.getMinValue() : null, profileSpecListModel != null ? profileSpecListModel.getMaxValue() : null);
    }

    public static final void v1(CompleteInfoAgeActivity this$0, StateResult stateResult) {
        s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            ((LoginNextButton) this$0.l1(R$id.age_next_button)).e();
        } else if (stateResult instanceof StateResult.c) {
            CompleteInfoAvatarActivity.a.b(CompleteInfoAvatarActivity.f16069w, this$0, false, 2, null);
        } else if (stateResult instanceof StateResult.a) {
            ((LoginNextButton) this$0.l1(R$id.age_next_button)).b();
        }
    }

    @Nullable
    public View l1(int i10) {
        Map<Integer, View> map = this.f16065u;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (q1()) {
            super.onBackPressed();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_complete_info_age);
        d1(0, Integer.valueOf(R$anim.alpha_out_duration_180));
        x1();
        t1();
        p1();
        j1.c.b(j1.c.f50228a, SensorPosition.BirthdayFill, null, null, 6, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.login.helper.d.f16155a.a(kotlin.collections.s.m(l1(R$id.age_title), (ConstraintLayout) l1(R$id.birthday_layout), (LinearLayout) l1(R$id.age_next_layout), (FrameLayout) l1(R$id.date_picker_layout)));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ((LoginNextButton) l1(R$id.age_next_button)).b();
    }

    public final void p1() {
        ((FKTitleBarLayout) l1(R$id.age_title_layout)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAgeActivity$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                CompleteInfoAgeActivity.this.onBackPressed();
            }
        });
        LoginNextButton age_next_button = (LoginNextButton) l1(R$id.age_next_button);
        s.h(age_next_button, "age_next_button");
        y.d(age_next_button, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAgeActivity$bindClickEvent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                CompleteInfoViewModel s12;
                if (((LoginNextButton) CompleteInfoAgeActivity.this.l1(R$id.age_next_button)).isSelected()) {
                    if (CompleteInfoAgeActivity.this.f16064t == null) {
                        FKBottomLoft l10 = FKBottomLoft.l(FKBottomLoft.f12709e.a(CompleteInfoAgeActivity.this).m(R$string.not_fill_birthday_prompt), R$string.to_fill_in, null, 2, null);
                        final CompleteInfoAgeActivity completeInfoAgeActivity = CompleteInfoAgeActivity.this;
                        l10.i(R$string.not_to_fill_in, new Function0<p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoAgeActivity$bindClickEvent$2.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ p invoke() {
                                invoke2();
                                return p.f51048a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                CompleteInfoAvatarActivity.a.b(CompleteInfoAvatarActivity.f16069w, CompleteInfoAgeActivity.this, false, 2, null);
                                i.f50236a.a(PopupName.NOT_FILL_REMIND, PopupButtonName.NotFill, SensorPosition.BirthdayFill);
                            }
                        }).d(false).n();
                        i.g(i.f50236a, PopupName.NOT_FILL_REMIND, SensorPosition.BirthdayFill, null, 4, null);
                    } else {
                        s12 = CompleteInfoAgeActivity.this.s1();
                        String str = CompleteInfoAgeActivity.this.f16064t;
                        s.f(str);
                        s12.saveBirthday(str);
                    }
                }
                SensorsLogKeyButtonClick.BirthdayFill.Next.click();
            }
        });
    }

    public final boolean q1() {
        return ((Boolean) this.f16062r.getValue()).booleanValue();
    }

    public final g r1() {
        return (g) this.f16063s.getValue();
    }

    public final CompleteInfoViewModel s1() {
        return (CompleteInfoViewModel) this.f16061q.getValue();
    }

    public final void t1() {
        s1().getBirthdayRangeLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.login.activity.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CompleteInfoAgeActivity.u1(CompleteInfoAgeActivity.this, (ProfileSpecListModel) obj);
            }
        });
        s1().getSaveBirthdayLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.login.activity.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CompleteInfoAgeActivity.v1(CompleteInfoAgeActivity.this, (StateResult) obj);
            }
        });
    }

    public final void w1(String str, String str2, String str3) {
        g.i(r1().e(this, str, str2, str3).l(new b()), 28, 1.3f, 0, 0, -15395563, -3750202, true, false, (FrameLayout) l1(R$id.date_picker_layout), 4, null).j().d(false).m(false);
    }

    public final void x1() {
        ((FKTitleBarLayout) l1(R$id.age_title_layout)).setLeftImageVisible(q1());
        View l12 = l1(R$id.age_title);
        ((ImageView) l12.findViewById(R$id.title_imageview)).setImageResource(R$mipmap.icon_age);
        ((TextView) l12.findViewById(R$id.subtitle_textview)).setText(getString(R$string.age_effect));
        ((TextView) l1(R$id.year_value_textview)).getPaint().setFakeBoldText(true);
        ((TextView) l1(R$id.birthday_year_textview)).getPaint().setFakeBoldText(true);
        ((TextView) l1(R$id.month_value_textview)).getPaint().setFakeBoldText(true);
        ((TextView) l1(R$id.birthday_month_textview)).getPaint().setFakeBoldText(true);
        ((TextView) l1(R$id.day_value_textview)).getPaint().setFakeBoldText(true);
        ((TextView) l1(R$id.birthday_day_textview)).getPaint().setFakeBoldText(true);
        ((LoginNextButton) l1(R$id.age_next_button)).setSelected(false);
        s1().getBirthdayRange();
    }
}
