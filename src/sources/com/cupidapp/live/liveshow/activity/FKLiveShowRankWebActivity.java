package com.cupidapp.live.liveshow.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.liveshow.fragment.FKLiveShowRankWebFragment;
import com.cupidapp.live.liveshow.fragment.MultiWebTitleModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowRankWebActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveShowRankWebActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f14784s = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public FKLiveShowRankWebFragment f14785q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f14786r = new LinkedHashMap();

    /* compiled from: FKLiveShowRankWebActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull MultiWebTitleModel model) {
            s.i(model, "model");
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) FKLiveShowRankWebActivity.class);
            z0.g.c(intent, model);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: FKLiveShowRankWebActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.base.activity.g {
        public b() {
        }

        @Override // com.cupidapp.live.base.activity.g
        public boolean a() {
            FKLiveShowRankWebFragment fKLiveShowRankWebFragment = FKLiveShowRankWebActivity.this.f14785q;
            if (fKLiveShowRankWebFragment != null) {
                return fKLiveShowRankWebFragment.onBackPressed();
            }
            return false;
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_fragment_container);
        Intent intent = getIntent();
        s.h(intent, "intent");
        MultiWebTitleModel multiWebTitleModel = (MultiWebTitleModel) z0.g.a(intent, MultiWebTitleModel.class);
        if (multiWebTitleModel != null) {
            FKLiveShowRankWebFragment a10 = FKLiveShowRankWebFragment.f15052g.a(multiWebTitleModel);
            this.f14785q = a10;
            FKBaseActivity.g1(this, a10, false, R$id.containerLayout, false, false, 24, null);
        }
        z0(new b());
    }
}
