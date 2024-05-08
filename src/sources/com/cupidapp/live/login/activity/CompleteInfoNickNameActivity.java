package com.cupidapp.live.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
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
import com.cupidapp.live.base.extension.NetworkStateConstants;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.login.activity.CompleteInfoAgeActivity;
import com.cupidapp.live.login.helper.LogoutHelper;
import com.cupidapp.live.login.layout.LoginNextButton;
import com.cupidapp.live.login.viewmodel.CompleteInfoViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: CompleteInfoNickNameActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CompleteInfoNickNameActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f16082s = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16083q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16084r = new LinkedHashMap();

    /* compiled from: CompleteInfoNickNameActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            Intent intent = new Intent(context, (Class<?>) CompleteInfoNickNameActivity.class);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.f11750o.b(context, 0, R$anim.alpha_out_duration_180);
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            boolean z10 = editable != null && editable.length() == 0;
            ((ImageView) CompleteInfoNickNameActivity.this.k1(R$id.clear_nickname_button)).setVisibility(z10 ? 8 : 0);
            ((LoginNextButton) CompleteInfoNickNameActivity.this.k1(R$id.nickname_next_button)).setSelected(!z10);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public CompleteInfoNickNameActivity() {
        final Function0 function0 = null;
        this.f16083q = new ViewModelLazy(v.b(CompleteInfoViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.login.activity.CompleteInfoNickNameActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.login.activity.CompleteInfoNickNameActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.login.activity.CompleteInfoNickNameActivity$special$$inlined$viewModels$default$3
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

    public static final void p1(CompleteInfoNickNameActivity this$0, StateResult stateResult) {
        s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.b) {
            ((LoginNextButton) this$0.k1(R$id.nickname_next_button)).e();
        } else if (stateResult instanceof StateResult.c) {
            CompleteInfoAgeActivity.a.b(CompleteInfoAgeActivity.f16060v, this$0, false, 2, null);
        } else if (stateResult instanceof StateResult.a) {
            ((LoginNextButton) this$0.k1(R$id.nickname_next_button)).b();
        }
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f16084r;
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

    public final void m1() {
        ImageView clear_nickname_button = (ImageView) k1(R$id.clear_nickname_button);
        s.h(clear_nickname_button, "clear_nickname_button");
        y.d(clear_nickname_button, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoNickNameActivity$bindClickEvent$1
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
                ((EditText) CompleteInfoNickNameActivity.this.k1(R$id.nickname_edittext)).getText().clear();
            }
        });
        LoginNextButton nickname_next_button = (LoginNextButton) k1(R$id.nickname_next_button);
        s.h(nickname_next_button, "nickname_next_button");
        y.d(nickname_next_button, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoNickNameActivity$bindClickEvent$2
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
                CompleteInfoViewModel n12;
                String obj = StringsKt__StringsKt.P0(((EditText) CompleteInfoNickNameActivity.this.k1(R$id.nickname_edittext)).getText().toString()).toString();
                if (obj.length() == 0) {
                    h.f12779a.r(CompleteInfoNickNameActivity.this, R$string.nick_name_can_not_empty);
                } else {
                    n12 = CompleteInfoNickNameActivity.this.n1();
                    n12.saveNickName(obj);
                }
                SensorsLogKeyButtonClick.NickNameFill.Next.click();
            }
        });
    }

    public final CompleteInfoViewModel n1() {
        return (CompleteInfoViewModel) this.f16083q.getValue();
    }

    public final void o1() {
        n1().getSaveNickNameLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.login.activity.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CompleteInfoNickNameActivity.p1(CompleteInfoNickNameActivity.this, (StateResult) obj);
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        r1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_complete_info_nick_name);
        d1(0, Integer.valueOf(R$anim.alpha_out_duration_180));
        q1();
        o1();
        m1();
        j1.c.b(j1.c.f50228a, SensorPosition.NickNameFill, null, null, 6, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.login.helper.d.f16155a.a(kotlin.collections.s.m(k1(R$id.nickname_title), (LinearLayout) k1(R$id.edittext_layout), (LoginNextButton) k1(R$id.nickname_next_button), null));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ((LoginNextButton) k1(R$id.nickname_next_button)).b();
    }

    public final void q1() {
        View k12 = k1(R$id.nickname_title);
        ((ImageView) k12.findViewById(R$id.title_imageview)).setImageResource(R$mipmap.icon_nickname);
        ((TextView) k12.findViewById(R$id.subtitle_textview)).setText(getString(R$string.nickname_effect));
        int i10 = R$id.nickname_edittext;
        ((EditText) k1(i10)).getPaint().setFakeBoldText(true);
        ((EditText) k1(i10)).requestFocus();
        EditText nickname_edittext = (EditText) k1(i10);
        s.h(nickname_edittext, "nickname_edittext");
        nickname_edittext.addTextChangedListener(new b());
        ((LoginNextButton) k1(R$id.nickname_next_button)).setSelected(false);
    }

    public final void r1() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.improving_information_are_you_want_quit, 0, 2, null), R$string.sign_out, null, new Function0<p>() { // from class: com.cupidapp.live.login.activity.CompleteInfoNickNameActivity$showExitCompleteInformationTips$1
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
                if (z0.h.g(CompleteInfoNickNameActivity.this) == NetworkStateConstants.DISCONNECT) {
                    h.f12779a.r(CompleteInfoNickNameActivity.this, R$string.please_check_your_network);
                    return;
                }
                CompleteInfoNickNameActivity.this.e1();
                LogoutHelper.f(new LogoutHelper(), CompleteInfoNickNameActivity.this, false, null, 4, null);
                h.f12779a.c(CompleteInfoNickNameActivity.this, R$string.exited_next_time_to_complete_information);
            }
        }, 2, null), R$string.back_show, null, 2, null), null, 1, null);
    }
}
