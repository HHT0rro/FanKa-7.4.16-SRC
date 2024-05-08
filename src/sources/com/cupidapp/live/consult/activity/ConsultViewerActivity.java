package com.cupidapp.live.consult.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.consult.adapter.ConsultViewerPagerAdapter;
import com.cupidapp.live.consult.fragment.ConsultViewerFragment;
import com.cupidapp.live.consult.helper.ConsultFloatWindowHelper;
import com.cupidapp.live.consult.model.ConsultApplyConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultLiveNextListResult;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.track.group.EnterConsultRoomSource;
import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;

/* compiled from: ConsultViewerActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultViewerActivity extends BaseConsultActivity implements ConsultViewerPagerAdapter.a {

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final a f13732x = new a(null);

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public ConsultViewerPagerAdapter f13733s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13734t;

    /* renamed from: u, reason: collision with root package name */
    public int f13735u;

    /* renamed from: v, reason: collision with root package name */
    public int f13736v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13737w = new LinkedHashMap();

    /* compiled from: ConsultViewerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable Config config) {
            if (context == null || config == null) {
                return;
            }
            FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodEnterLive, false, true, 2, null);
            Intent intent = new Intent(context, (Class<?>) ConsultViewerActivity.class);
            g.c(intent, config);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: ConsultViewerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.base.activity.g {
        public b() {
        }

        @Override // com.cupidapp.live.base.activity.g
        public boolean a() {
            List<Fragment> fragments = ConsultViewerActivity.this.getSupportFragmentManager().getFragments();
            s.h(fragments, "supportFragmentManager.fragments");
            boolean z10 = false;
            for (Fragment fragment : fragments) {
                if ((fragment instanceof FKBaseFragment) && ((FKBaseFragment) fragment).onBackPressed()) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    @Override // com.cupidapp.live.consult.adapter.ConsultViewerPagerAdapter.a
    public void Q(@NotNull List<String> roomIds, @Nullable String str, @NotNull final Function1<? super ConsultLiveNextListResult, p> successCallback, @NotNull final Function0<p> failCallback) {
        s.i(roomIds, "roomIds");
        s.i(successCallback, "successCallback");
        s.i(failCallback, "failCallback");
        Disposable disposed = NetworkClient.f11868a.v().i(roomIds, str).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<ConsultLiveNextListResult, p>() { // from class: com.cupidapp.live.consult.activity.ConsultViewerActivity$callVoiceRoomNextApi$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultLiveNextListResult consultLiveNextListResult) {
                m2534invoke(consultLiveNextListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2534invoke(ConsultLiveNextListResult consultLiveNextListResult) {
                Function1.this.invoke(consultLiveNextListResult);
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.consult.activity.ConsultViewerActivity$callVoiceRoomNextApi$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                failCallback.invoke();
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Nullable
    public View m1(int i10) {
        Map<Integer, View> map = this.f13737w;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        ConsultViewerFragment k10;
        super.onActivityResult(i10, i11, intent);
        ConsultViewerPagerAdapter consultViewerPagerAdapter = this.f13733s;
        if (consultViewerPagerAdapter == null || (k10 = consultViewerPagerAdapter.k()) == null) {
            return;
        }
        k10.onActivityResult(i10, i11, intent);
    }

    @Override // com.cupidapp.live.consult.activity.BaseConsultActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_consult_viewer);
        Intent intent = getIntent();
        s.h(intent, "intent");
        Config config = (Config) g.a(intent, Config.class);
        if (config != null) {
            if (!(config.getRoomId().length() == 0)) {
                ConsultFloatWindowHelper consultFloatWindowHelper = ConsultFloatWindowHelper.f13810b;
                String k10 = consultFloatWindowHelper.k();
                if (k10 == null || k10.length() == 0) {
                    IVoiceEngine a10 = d4.b.f48611a.a();
                    if (a10 != null) {
                        a10.a();
                    }
                } else if (s.d(config.getRoomId(), k10)) {
                    config.setSource(EnterConsultRoomSource.ConsultWindow.getSource());
                    consultFloatWindowHelper.p();
                } else {
                    consultFloatWindowHelper.j();
                }
                this.f13734t = true;
                v1(config);
                u1();
                return;
            }
        }
        finish();
    }

    @Override // com.cupidapp.live.consult.activity.BaseConsultActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ConsultViewerPagerAdapter consultViewerPagerAdapter = this.f13733s;
        if (consultViewerPagerAdapter != null) {
            consultViewerPagerAdapter.j();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        this.f13734t = true;
    }

    public final void u1() {
        z0(new b());
    }

    public final void v1(Config config) {
        int i10 = R$id.consult_viewer_view_pager;
        View childAt = ((ViewPager2) m1(i10)).getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.setItemPrefetchEnabled(false);
            }
            recyclerView.setItemViewCacheSize(0);
        }
        ((ViewPager2) m1(i10)).registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.consult.activity.ConsultViewerActivity$initViewPager$2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i11) {
                int i12;
                int i13;
                int i14;
                ConsultViewerPagerAdapter consultViewerPagerAdapter;
                int i15;
                if (i11 == 0) {
                    i12 = ConsultViewerActivity.this.f13735u;
                    i13 = ConsultViewerActivity.this.f13736v;
                    if (i12 == i13) {
                        return;
                    }
                    ConsultViewerActivity consultViewerActivity = ConsultViewerActivity.this;
                    i14 = consultViewerActivity.f13736v;
                    consultViewerActivity.f13735u = i14;
                    consultViewerPagerAdapter = ConsultViewerActivity.this.f13733s;
                    if (consultViewerPagerAdapter != null) {
                        i15 = ConsultViewerActivity.this.f13736v;
                        consultViewerPagerAdapter.o(i15);
                    }
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i11) {
                boolean z10;
                ConsultViewerPagerAdapter consultViewerPagerAdapter;
                z10 = ConsultViewerActivity.this.f13734t;
                if (z10) {
                    consultViewerPagerAdapter = ConsultViewerActivity.this.f13733s;
                    if (consultViewerPagerAdapter != null) {
                        consultViewerPagerAdapter.o(i11);
                    }
                    ConsultViewerActivity.this.f13734t = false;
                    ConsultViewerActivity.this.f13735u = i11;
                }
                ConsultViewerActivity.this.f13736v = i11;
            }
        });
        this.f13733s = new ConsultViewerPagerAdapter(this, config, this);
        ((ViewPager2) m1(i10)).setAdapter(this.f13733s);
        ((ViewPager2) m1(i10)).setCurrentItem(View.LAST_APP_AUTOFILL_ID, false);
    }

    public final void w1(boolean z10) {
        ((ViewPager2) m1(R$id.consult_viewer_view_pager)).setUserInputEnabled(z10);
    }

    /* compiled from: ConsultViewerActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Config implements Serializable {

        @NotNull
        private final String category;

        @Nullable
        private ConsultApplyConnectGrpcModel connectModel;

        @Nullable
        private String from;

        @NotNull
        private final String roomId;

        @Nullable
        private String source;

        public Config(@NotNull String roomId, @NotNull String category, @Nullable String str, @Nullable String str2, @Nullable ConsultApplyConnectGrpcModel consultApplyConnectGrpcModel) {
            s.i(roomId, "roomId");
            s.i(category, "category");
            this.roomId = roomId;
            this.category = category;
            this.from = str;
            this.source = str2;
            this.connectModel = consultApplyConnectGrpcModel;
        }

        public static /* synthetic */ Config copy$default(Config config, String str, String str2, String str3, String str4, ConsultApplyConnectGrpcModel consultApplyConnectGrpcModel, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = config.roomId;
            }
            if ((i10 & 2) != 0) {
                str2 = config.category;
            }
            String str5 = str2;
            if ((i10 & 4) != 0) {
                str3 = config.from;
            }
            String str6 = str3;
            if ((i10 & 8) != 0) {
                str4 = config.source;
            }
            String str7 = str4;
            if ((i10 & 16) != 0) {
                consultApplyConnectGrpcModel = config.connectModel;
            }
            return config.copy(str, str5, str6, str7, consultApplyConnectGrpcModel);
        }

        @NotNull
        public final String component1() {
            return this.roomId;
        }

        @NotNull
        public final String component2() {
            return this.category;
        }

        @Nullable
        public final String component3() {
            return this.from;
        }

        @Nullable
        public final String component4() {
            return this.source;
        }

        @Nullable
        public final ConsultApplyConnectGrpcModel component5() {
            return this.connectModel;
        }

        @NotNull
        public final Config copy(@NotNull String roomId, @NotNull String category, @Nullable String str, @Nullable String str2, @Nullable ConsultApplyConnectGrpcModel consultApplyConnectGrpcModel) {
            s.i(roomId, "roomId");
            s.i(category, "category");
            return new Config(roomId, category, str, str2, consultApplyConnectGrpcModel);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return s.d(this.roomId, config.roomId) && s.d(this.category, config.category) && s.d(this.from, config.from) && s.d(this.source, config.source) && s.d(this.connectModel, config.connectModel);
        }

        @NotNull
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        public final ConsultApplyConnectGrpcModel getConnectModel() {
            return this.connectModel;
        }

        @Nullable
        public final String getFrom() {
            return this.from;
        }

        @NotNull
        public final String getRoomId() {
            return this.roomId;
        }

        @Nullable
        public final String getSource() {
            return this.source;
        }

        public int hashCode() {
            int hashCode = ((this.roomId.hashCode() * 31) + this.category.hashCode()) * 31;
            String str = this.from;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.source;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            ConsultApplyConnectGrpcModel consultApplyConnectGrpcModel = this.connectModel;
            return hashCode3 + (consultApplyConnectGrpcModel != null ? consultApplyConnectGrpcModel.hashCode() : 0);
        }

        public final void setConnectModel(@Nullable ConsultApplyConnectGrpcModel consultApplyConnectGrpcModel) {
            this.connectModel = consultApplyConnectGrpcModel;
        }

        public final void setFrom(@Nullable String str) {
            this.from = str;
        }

        public final void setSource(@Nullable String str) {
            this.source = str;
        }

        @NotNull
        public String toString() {
            return "Config(roomId=" + this.roomId + ", category=" + this.category + ", from=" + this.from + ", source=" + this.source + ", connectModel=" + ((Object) this.connectModel) + ")";
        }

        public /* synthetic */ Config(String str, String str2, String str3, String str4, ConsultApplyConnectGrpcModel consultApplyConnectGrpcModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : consultApplyConnectGrpcModel);
        }
    }
}
