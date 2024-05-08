package com.cupidapp.live.liveshow.view.liveinfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.base.web.b;
import com.cupidapp.live.liveshow.activity.FKBaseLiveActivity;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKLiveShowActivityLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveActivityWebViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final b f15705c = new b(null);

    /* compiled from: FKLiveShowActivityLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements b.a {
        @Override // com.cupidapp.live.base.web.b.a
        public void a(@Nullable WebView webView, int i10, boolean z10) {
            b.a.C0148a.a(this, webView, i10, z10);
        }

        @Override // com.cupidapp.live.base.web.b.a
        public void b(int i10) {
        }

        @Override // com.cupidapp.live.base.web.b.a
        public void c(@NotNull String str) {
            b.a.C0148a.b(this, str);
        }
    }

    /* compiled from: FKLiveShowActivityLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveActivityWebViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveActivityWebViewHolder(z.b(parent, R$layout.view_holder_live_activity_web, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveActivityWebViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        j jVar = new j(itemView.getContext());
        FKWebView lambda$1$lambda$0 = (FKWebView) itemView.findViewById(R$id.activity_web_view);
        lambda$1$lambda$0.setBackgroundColor(0);
        lambda$1$lambda$0.getBackground().setAlpha(0);
        Context context = itemView.getContext();
        FKBaseLiveActivity fKBaseLiveActivity = context instanceof FKBaseLiveActivity ? (FKBaseLiveActivity) context : null;
        if (fKBaseLiveActivity != null) {
            s.h(lambda$1$lambda$0, "lambda$1$lambda$0");
            Lifecycle lifecycle = fKBaseLiveActivity.getLifecycle();
            s.h(lifecycle, "it.lifecycle");
            FKWebView.w(lambda$1$lambda$0, fKBaseLiveActivity, lifecycle, null, null, 12, null);
            Lifecycle lifecycle2 = fKBaseLiveActivity.getLifecycle();
            s.h(lifecycle2, "it.lifecycle");
            jVar.f(lifecycle2, null);
            lambda$1$lambda$0.q(jVar);
            lambda$1$lambda$0.setLoadProgressListener(new a());
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveActivityWebModel) {
            View view = this.itemView;
            int i10 = R$id.activity_web_view;
            ((FKWebView) view.findViewById(i10)).stopLoading();
            ((FKWebView) this.itemView.findViewById(i10)).u(((LiveActivityWebModel) obj).getWebUrl());
        }
    }
}
