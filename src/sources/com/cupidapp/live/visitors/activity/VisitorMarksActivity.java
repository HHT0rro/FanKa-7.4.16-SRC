package com.cupidapp.live.visitors.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorMarksActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorMarksActivity extends FKBaseActivity {

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f18895r = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18896q = new LinkedHashMap();

    /* compiled from: VisitorMarksActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) VisitorMarksActivity.class);
            intent.putExtra("operation_source", str);
            intent.putExtra("title", str2);
            intent.putExtra("type", str3);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f18896q;
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
        setContentView(R$layout.activity_visitor_marks);
        int i10 = R$id.visitor_marks_title_layout;
        FKTitleBarLayout visitor_marks_title_layout = (FKTitleBarLayout) j1(i10);
        s.h(visitor_marks_title_layout, "visitor_marks_title_layout");
        FKTitleBarLayout.setSingleTitle$default(visitor_marks_title_layout, getIntent().getStringExtra("title"), null, 2, null);
        ((FKTitleBarLayout) j1(i10)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorMarksActivity$onCreate$1
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
                VisitorMarksActivity.this.finish();
            }
        });
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R$id.visitor_marks_container, VisitorMarksListFragment.f18897j.a(getIntent().getStringExtra("operation_source"), getIntent().getStringExtra("type"))).commitNow();
        }
    }
}
