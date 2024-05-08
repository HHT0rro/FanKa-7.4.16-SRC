package com.cupidapp.live.liveshow.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.g;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.view.indicator.PagerIndicatorLayout;
import com.cupidapp.live.liveshow.adapter.HeatIntroAdapter;
import com.cupidapp.live.liveshow.model.HeatIntroModel;
import com.cupidapp.live.liveshow.model.HeatValuesModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.b;
import z0.m;
import z0.t;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: LiveHeatCountDesDialog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveHeatCountDesDialog extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f15405e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f15406b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15407c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15408d;

    /* compiled from: LiveHeatCountDesDialog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LiveHeatCountDesDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new LiveHeatCountDesDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveHeatCountDesDialog(Context context) {
        super(context);
        this.f15408d = new LinkedHashMap();
        this.f15407c = true;
        e();
    }

    public /* synthetic */ LiveHeatCountDesDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15408d;
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

    @NotNull
    public final LiveHeatCountDesDialog b(@Nullable HeatValuesModel heatValuesModel) {
        ((TextView) a(R$id.heat_total_txt)).setText(d(heatValuesModel != null ? heatValuesModel.getTotal() : 0));
        ((TextView) a(R$id.base_heat_txt)).setText(d(heatValuesModel != null ? heatValuesModel.getFixed() : 0));
        ((TextView) a(R$id.increase_heat_txt)).setText(d(heatValuesModel != null ? heatValuesModel.getDynamic() : 0));
        return this;
    }

    public final void c() {
        AlertDialog alertDialog = this.f15406b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final String d(int i10) {
        if (i10 > 10000000) {
            Context context = getContext();
            s.h(context, "context");
            return m.e(i10, context);
        }
        return m.a(i10);
    }

    public final void e() {
        z.a(this, R$layout.dialog_live_hot_count, true);
        int i10 = R$id.hot_title;
        TextView hot_title = (TextView) a(i10);
        s.h(hot_title, "hot_title");
        u.a(hot_title);
        TextView heat_total_txt = (TextView) a(R$id.heat_total_txt);
        s.h(heat_total_txt, "heat_total_txt");
        u.a(heat_total_txt);
        TextView base_heat_txt = (TextView) a(R$id.base_heat_txt);
        s.h(base_heat_txt, "base_heat_txt");
        u.a(base_heat_txt);
        TextView increase_heat_txt = (TextView) a(R$id.increase_heat_txt);
        s.h(increase_heat_txt, "increase_heat_txt");
        u.a(increase_heat_txt);
        TextView hot_equals_txt = (TextView) a(R$id.hot_equals_txt);
        s.h(hot_equals_txt, "hot_equals_txt");
        u.a(hot_equals_txt);
        TextView hot_add_txt = (TextView) a(R$id.hot_add_txt);
        s.h(hot_add_txt, "hot_add_txt");
        u.a(hot_add_txt);
        TextView textView = (TextView) a(i10);
        String string = getContext().getString(R$string.current_hot_count);
        s.h(string, "context.getString(R.string.current_hot_count)");
        textView.setText(t.a(string, -49088));
        ((ViewPager2) a(R$id.hot_viewpager)).registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.liveshow.view.dialog.LiveHeatCountDesDialog$initView$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i11) {
                ((PagerIndicatorLayout) LiveHeatCountDesDialog.this.a(R$id.hot_indicator)).setCurrentPager(i11);
            }
        });
        ImageView ic_heat_close = (ImageView) a(R$id.ic_heat_close);
        s.h(ic_heat_close, "ic_heat_close");
        y.d(ic_heat_close, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.dialog.LiveHeatCountDesDialog$initView$2
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
                LiveHeatCountDesDialog.this.c();
            }
        });
        g();
    }

    public final boolean f() {
        AlertDialog alertDialog = this.f15406b;
        return alertDialog != null && alertDialog.isShowing();
    }

    public final void g() {
        Observable<Result<HeatIntroModel>> o10 = NetworkClient.f11868a.r().o();
        Object context = getContext();
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = o10.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<HeatIntroModel, p>() { // from class: com.cupidapp.live.liveshow.view.dialog.LiveHeatCountDesDialog$renderIntro$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(HeatIntroModel heatIntroModel) {
                m2641invoke(heatIntroModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2641invoke(HeatIntroModel heatIntroModel) {
                HeatIntroModel heatIntroModel2 = heatIntroModel;
                ((PagerIndicatorLayout) LiveHeatCountDesDialog.this.a(R$id.hot_indicator)).setPagerCount(heatIntroModel2.getHeatValuesDescs().size());
                HeatIntroAdapter heatIntroAdapter = new HeatIntroAdapter();
                heatIntroAdapter.e(heatIntroModel2.getHeatValuesDescs());
                ((ViewPager2) LiveHeatCountDesDialog.this.a(R$id.hot_viewpager)).setAdapter(heatIntroAdapter);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void h() {
        Window window;
        AlertDialog create = b.f54812a.e(getContext()).setView(this).create();
        this.f15406b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f15407c);
        }
        AlertDialog alertDialog = this.f15406b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f15406b;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-2, -2);
        window.setGravity(17);
    }
}
