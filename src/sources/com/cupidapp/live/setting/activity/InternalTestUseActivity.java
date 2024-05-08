package com.cupidapp.live.setting.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.safe.DigitalAllianceHelper;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InternalTestUseActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class InternalTestUseActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f17964r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17965q = new LinkedHashMap();

    /* compiled from: InternalTestUseActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, boolean z10) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) InternalTestUseActivity.class);
            intent.putExtra("INTERNAL_TEST_USE_IS_RELEASE", z10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: InternalTestUseActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements AdapterView.OnItemSelectedListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f17966b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String[] f17967c;

        public b(EditText editText, String[] strArr) {
            this.f17966b = editText;
            this.f17967c = strArr;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@Nullable AdapterView<?> adapterView, @Nullable View view, int i10, long j10) {
            if (i10 == 0) {
                return;
            }
            this.f17966b.setText(this.f17967c[i10]);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@Nullable AdapterView<?> adapterView) {
        }
    }

    public static final void o1(Spinner spinner, EditText editText, InternalTestUseActivity this$0, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.s.i(spinner, "$spinner");
        kotlin.jvm.internal.s.i(editText, "$editText");
        kotlin.jvm.internal.s.i(this$0, "this$0");
        p1.h.f52842c.a().b();
        if (kotlin.jvm.internal.s.d(spinner.getSelectedItem(), 1)) {
            NetworkClient.f11868a.e(false);
        } else {
            NetworkClient.f11868a.e(true);
        }
        p1.g gVar = p1.g.f52734a;
        gVar.M().d(editText.getText().toString());
        com.cupidapp.live.base.view.h.f12779a.d(this$0, gVar.M().c());
        this$0.finishAffinity();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f17965q;
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

    public final void n1(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        final EditText editText = new EditText(context);
        editText.setText(p1.g.f52734a.M().c());
        linearLayout.addView(editText);
        String[] strArr = {"选择域名", "https://api.finka.cn", "https://finka-api-qa.wowkaka.cn", "https://finka-api.wowkaka.cn", "https://finka-api-b.wowkaka.cn", "https://finka-api-c.wowkaka.cn", "https://finka-api-d.wowkaka.cn", "https://finka-api-e.wowkaka.cn", "https://finka-api-f.wowkaka.cn", "https://finka-api-g.wowkaka.cn", "https://api-alpha.finka.cn", "https://api-beta.finka.cn"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367049, strArr);
        final Spinner spinner = new Spinner(context);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setOnItemSelectedListener(new b(editText, strArr));
        linearLayout.addView(spinner);
        AlertDialog.Builder positiveButton = z0.b.f54812a.e(context).setTitle(context.getString(R$string.change_intranet_domain_name)).setView(linearLayout).setPositiveButton(2131886528, new DialogInterface.OnClickListener() { // from class: com.cupidapp.live.setting.activity.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                InternalTestUseActivity.o1(Spinner.this, editText, this, dialogInterface, i10);
            }
        });
        kotlin.jvm.internal.s.h(positiveButton, "AlertDialogExtension.cre…tProcess(0)\n            }");
        z0.d.b(positiveButton);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_internal_test_use);
        ((FKTitleBarLayout) k1(R$id.internal_test_use_title_bar)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.InternalTestUseActivity$onCreate$1
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
                InternalTestUseActivity.this.onBackPressed();
            }
        });
        if (getIntent().getBooleanExtra("INTERNAL_TEST_USE_IS_RELEASE", true)) {
            ((Button) k1(R$id.intranet_domain_name_btn)).setVisibility(8);
        } else {
            int i10 = R$id.intranet_domain_name_btn;
            ((Button) k1(i10)).setVisibility(0);
            Button intranet_domain_name_btn = (Button) k1(i10);
            kotlin.jvm.internal.s.h(intranet_domain_name_btn, "intranet_domain_name_btn");
            z0.y.d(intranet_domain_name_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.InternalTestUseActivity$onCreate$2
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
                    InternalTestUseActivity internalTestUseActivity = InternalTestUseActivity.this;
                    internalTestUseActivity.n1(internalTestUseActivity);
                }
            });
        }
        Button see_device_or_application_info_btn = (Button) k1(R$id.see_device_or_application_info_btn);
        kotlin.jvm.internal.s.h(see_device_or_application_info_btn, "see_device_or_application_info_btn");
        z0.y.d(see_device_or_application_info_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.InternalTestUseActivity$onCreate$3
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
                InternalTestUseActivity.this.p1();
            }
        });
        Button digital_alliance_btn = (Button) k1(R$id.digital_alliance_btn);
        kotlin.jvm.internal.s.h(digital_alliance_btn, "digital_alliance_btn");
        z0.y.d(digital_alliance_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.InternalTestUseActivity$onCreate$4
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
                DigitalAllianceHelper.f12175a.e(InternalTestUseActivity.this);
            }
        });
        ((Button) k1(R$id.build_type_btn)).setText("构建类型: release");
        Button change_location_btn = (Button) k1(R$id.change_location_btn);
        kotlin.jvm.internal.s.h(change_location_btn, "change_location_btn");
        z0.y.d(change_location_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.InternalTestUseActivity$onCreate$5
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
                TestChangeLocationActivity.f18021w.a(InternalTestUseActivity.this);
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((Button) k1(R$id.change_location_btn)).setText("当前地理位置: 线上默认");
    }

    public final void p1() {
        com.cupidapp.live.base.network.a aVar = com.cupidapp.live.base.network.a.f11902a;
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).D(R$string.see_device_or_application_info).n("HumeChannel:" + aVar.l() + "\nStoreName:" + aVar.r() + "\n"), 0, null, null, 7, null), null, 1, null);
    }
}
