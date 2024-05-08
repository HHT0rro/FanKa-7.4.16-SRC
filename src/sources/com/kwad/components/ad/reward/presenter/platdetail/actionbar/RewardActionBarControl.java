package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class RewardActionBarControl {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private g qo;
    private b uE;

    @Nullable
    private d uI;

    @Nullable
    private c uJ;
    private final long uL;

    @NonNull
    private a uK = new a(0);
    private Handler fS = new Handler(Looper.getMainLooper());
    private boolean uM = false;
    private boolean uN = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum ShowActionBarResult {
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE,
        SHOW_NATIVE_ORIGIN_LIVE
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        private List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> uS;
        private ShowActionBarResult uT;

        private a() {
            this.uS = new CopyOnWriteArrayList();
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.uS.add(aVar);
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.uS.remove(aVar);
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view) {
            com.kwad.sdk.core.e.c.d("ActionBarControl", "onActionBarShown result: " + ((Object) showActionBarResult));
            this.uT = showActionBarResult;
            Iterator<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> iterator2 = this.uS.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(showActionBarResult, view);
            }
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface b {
        void a(boolean z10, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface d {
        boolean f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public RewardActionBarControl(g gVar, Context context, AdTemplate adTemplate) {
        this.qo = gVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        long cl = com.kwad.sdk.core.response.b.b.cl(adTemplate) > 0 ? com.kwad.sdk.core.response.b.b.cl(adTemplate) : 1000L;
        this.uL = cl > 0 ? cl : 1000L;
    }

    private ShowActionBarResult P(boolean z10) {
        c cVar;
        if (com.kwad.components.ad.reward.a.b.i(this.mAdInfo) && (cVar = this.uJ) != null) {
            cVar.e(this.uK);
            return ShowActionBarResult.SHOW_ORDER;
        }
        if (com.kwad.sdk.core.response.b.b.cm(this.mAdTemplate) && !com.kwad.sdk.core.response.b.a.bd(this.mAdInfo) && this.uI != null) {
            com.kwad.sdk.core.e.c.d("ActionBarControl", "showWebActionBar success in " + this.uL);
            if (this.uI.f(this.uK)) {
                return ShowActionBarResult.SHOW_H5_SUCCESS;
            }
            return ShowActionBarResult.SHOW_H5_FAILURE;
        }
        Q(z10);
        return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z10) {
        if (this.uE != null) {
            com.kwad.sdk.core.e.c.d("ActionBarControl", "showNativeActionBar");
            this.uN = true;
            this.uE.a(z10, this.uK);
        }
    }

    public final void O(boolean z10) {
        ShowActionBarResult P = P(z10);
        com.kwad.sdk.core.e.c.d("ActionBarControl", "showActionBarOnVideoStart result: " + ((Object) P));
        if (P != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.fS.postDelayed(new ay() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                RewardActionBarControl.a(RewardActionBarControl.this, true);
                com.kwad.sdk.core.e.c.d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.uI != null && !RewardActionBarControl.this.uN && RewardActionBarControl.this.uI.f(RewardActionBarControl.this.uK)) {
                    com.kwad.sdk.core.e.c.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.uL);
                } else {
                    com.kwad.sdk.core.e.c.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.uL);
                    com.kwad.components.core.o.a.qi().i(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.uL);
                    com.kwad.components.ad.reward.monitor.c.a(RewardActionBarControl.this.qo.mAdTemplate, RewardActionBarControl.this.qo.oY, "play_card", com.kwad.sdk.core.response.b.b.ck(RewardActionBarControl.this.qo.mAdTemplate), RewardActionBarControl.this.uL, 1);
                    RewardActionBarControl.this.Q(true);
                }
            }
        }, this.uL);
    }

    /* renamed from: if, reason: not valid java name */
    public final void m2862if() {
        if (this.uM) {
            com.kwad.sdk.core.e.c.i("ActionBarControl", "showWebActionBar time out on pageStatus");
        } else {
            this.fS.removeCallbacksAndMessages(null);
            P(true);
        }
    }

    @Nullable
    public final ShowActionBarResult ig() {
        return this.uK.uT;
    }

    public static /* synthetic */ boolean a(RewardActionBarControl rewardActionBarControl, boolean z10) {
        rewardActionBarControl.uM = true;
        return true;
    }

    @MainThread
    public final void a(b bVar) {
        this.uE = bVar;
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.uK.d(aVar);
    }

    @MainThread
    public final void a(d dVar) {
        this.uI = dVar;
    }

    @MainThread
    public final void a(@Nullable c cVar) {
        this.uJ = cVar;
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.uK.c(aVar);
    }

    public static void a(final com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, final View view, final ShowActionBarResult showActionBarResult) {
        if (aVar != null) {
            view.post(new ay() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    com.kwad.components.ad.reward.presenter.platdetail.actionbar.a.this.a(showActionBarResult, view);
                }
            });
        }
    }
}
