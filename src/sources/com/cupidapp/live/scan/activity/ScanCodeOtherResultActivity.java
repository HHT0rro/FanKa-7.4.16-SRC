package com.cupidapp.live.scan.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: ScanCodeOtherResultActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ScanCodeOtherResultActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17913r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17914q = new LinkedHashMap();

    /* compiled from: ScanCodeOtherResultActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String resultStr) {
            s.i(context, "context");
            s.i(resultStr, "resultStr");
            Intent intent = new Intent(context, (Class<?>) ScanCodeOtherResultActivity.class);
            intent.putExtra("SCAN_CODE_OTHER_RESULT", resultStr);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17914q;
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
        setContentView(R$layout.activity_scan_code_other_result);
        d1(R$anim.anim_activity_nothing, Integer.valueOf(R$anim.alpha_out));
        ((FKTitleBarLayout) j1(R$id.other_result_title_bar)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.scan.activity.ScanCodeOtherResultActivity$onCreate$1
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
                ScanCodeOtherResultActivity.this.onBackPressed();
            }
        });
        final String stringExtra = getIntent().getStringExtra("SCAN_CODE_OTHER_RESULT");
        if (stringExtra == null || stringExtra.length() == 0) {
            return;
        }
        if (kotlin.text.p.D(stringExtra, "https://", true) || kotlin.text.p.D(stringExtra, "http://", true)) {
            ((ImageView) j1(R$id.other_result_exclamation_mark_img)).setVisibility(0);
            ((TextView) j1(R$id.other_result_title_text)).setText(getString(R$string.about_to_leave_finka_app));
            ((TextView) j1(R$id.scan_code_other_result_desc)).setText(getString(R$string.scan_result_jump_tip, new Object[]{stringExtra}));
            FKUniversalButton other_result_continue_visit_btn = (FKUniversalButton) j1(R$id.other_result_continue_visit_btn);
            s.h(other_result_continue_visit_btn, "other_result_continue_visit_btn");
            y.d(other_result_continue_visit_btn, new Function1<View, p>() { // from class: com.cupidapp.live.scan.activity.ScanCodeOtherResultActivity$onCreate$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    j.a.b(j.f12156c, ScanCodeOtherResultActivity.this, stringExtra, null, 4, null);
                    ScanCodeOtherResultActivity.this.finish();
                }
            });
            return;
        }
        ((ImageView) j1(R$id.other_result_exclamation_mark_img)).setVisibility(8);
        ((TextView) j1(R$id.other_result_title_text)).setText(getString(R$string.scan_results));
        ((TextView) j1(R$id.scan_code_other_result_desc)).setText(stringExtra);
        ((FKUniversalButton) j1(R$id.other_result_continue_visit_btn)).setVisibility(8);
    }
}
