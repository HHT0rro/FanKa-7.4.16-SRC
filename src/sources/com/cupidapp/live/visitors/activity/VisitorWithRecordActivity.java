package com.cupidapp.live.visitors.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.BaseScrollViewPager;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.mediapicker.event.TabRedDotEvent;
import he.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VisitorWithRecordActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VisitorWithRecordActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f18904t = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public int f18905q;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18907s = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f18906r = kotlin.c.b(new Function0<VisitorWithRecordPagerAdapter>() { // from class: com.cupidapp.live.visitors.activity.VisitorWithRecordActivity$containerAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final VisitorWithRecordPagerAdapter invoke() {
            String stringExtra = VisitorWithRecordActivity.this.getIntent().getStringExtra("operation_position");
            FragmentManager supportFragmentManager = VisitorWithRecordActivity.this.getSupportFragmentManager();
            s.h(supportFragmentManager, "supportFragmentManager");
            return new VisitorWithRecordPagerAdapter(stringExtra, supportFragmentManager);
        }
    });

    /* compiled from: VisitorWithRecordActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable String str) {
            Intent intent = new Intent(context, (Class<?>) VisitorWithRecordActivity.class);
            intent.putExtra("operation_position", str);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f18907s;
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

    public final VisitorWithRecordPagerAdapter n1() {
        return (VisitorWithRecordPagerAdapter) this.f18906r.getValue();
    }

    public final void o1() {
        int i10 = R$id.visitor_title;
        ((FKTitleBarLayout) j1(i10)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorWithRecordActivity$initView$1
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
                VisitorWithRecordActivity.this.finish();
            }
        });
        FKTitleBarLayout visitor_title = (FKTitleBarLayout) j1(i10);
        s.h(visitor_title, "visitor_title");
        com.cupidapp.live.base.view.p pVar = new com.cupidapp.live.base.view.p(kotlin.collections.s.m(getString(R$string.my_visitors), getString(R$string.footmark)), 0.0f, 0, 0, false, 30, null);
        int i11 = R$id.containerViewPager;
        FKTitleBarLayout.f(visitor_title, pVar, (BaseScrollViewPager) j1(i11), 0, new Function1<Integer, p>() { // from class: com.cupidapp.live.visitors.activity.VisitorWithRecordActivity$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i12) {
                int i13;
                VisitorWithRecordActivity.this.f18905q = i12;
                VisitorWithRecordActivity.this.p1();
                i13 = VisitorWithRecordActivity.this.f18905q;
                if (i13 == 1) {
                    VisitorWithRecordActivity visitorWithRecordActivity = VisitorWithRecordActivity.this;
                    int i14 = R$id.visitor_title;
                    if (((FKTitleBarLayout) visitorWithRecordActivity.j1(i14)).j(1)) {
                        ((FKTitleBarLayout) VisitorWithRecordActivity.this.j1(i14)).setViewPagerTitleRedTip(1, false);
                    }
                }
            }
        }, 4, null);
        ((BaseScrollViewPager) j1(i11)).setAdapter(n1());
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.visitor_with_record_activity);
        o1();
        p1();
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull TabRedDotEvent event) {
        s.i(event, "event");
        if (event.getSensorPosition() == SensorPosition.HideFootmark) {
            if (this.f18905q == 1 && event.isShow()) {
                FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) j1(R$id.visitor_title);
                if (fKTitleBarLayout != null) {
                    fKTitleBarLayout.setViewPagerTitleRedTip(1, false);
                    return;
                }
                return;
            }
            FKTitleBarLayout fKTitleBarLayout2 = (FKTitleBarLayout) j1(R$id.visitor_title);
            if (fKTitleBarLayout2 != null) {
                fKTitleBarLayout2.setViewPagerTitleRedTip(1, event.isShow());
            }
        }
    }

    public final void p1() {
        SensorPosition sensorPosition;
        if (this.f18905q == 0) {
            sensorPosition = SensorPosition.MyVisitors;
        } else {
            sensorPosition = SensorPosition.HideFootmark;
        }
        j1.c.b(j1.c.f50228a, sensorPosition, null, null, 6, null);
    }
}
