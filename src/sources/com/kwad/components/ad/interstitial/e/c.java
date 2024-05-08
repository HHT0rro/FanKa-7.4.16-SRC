package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.sdk.mvp.a {

    @NonNull
    public KsAdVideoPlayConfig dU;
    public com.kwad.sdk.core.video.videoview.a eN;

    /* renamed from: ib, reason: collision with root package name */
    public com.kwad.components.ad.interstitial.f.b f36521ib;

    /* renamed from: ie, reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f36522ie;

    /* renamed from: io, reason: collision with root package name */
    public com.kwad.components.ad.interstitial.d f36523io;
    public com.kwad.components.ad.interstitial.g.d jL;
    public boolean jM;
    public boolean jN;
    public boolean jO;
    public a jP;
    public com.kwad.components.core.webview.tachikoma.e.e jR;

    @NonNull
    public KSFrameLayout jS;
    public d jT;
    public boolean jX;
    public boolean jY;
    public AdResultData mAdResultData;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public List<a> jQ = new CopyOnWriteArrayList();
    private Handler fS = new Handler(Looper.getMainLooper());
    public volatile boolean jW = false;
    public int jZ = -1;
    public List<a.c> jV = new CopyOnWriteArrayList();
    public List<InterfaceC0419c> jU = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.e.c$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass3 implements ImageLoadingListener {
        public final /* synthetic */ View fo;
        public final /* synthetic */ Context gq;

        public AnonymousClass3(Context context, View view) {
            this.gq = context;
            this.fo = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.ad.interstitial.e.c.3.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.e.c.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap stackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.e.c.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass3.this.gq.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    final RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(AnonymousClass3.this.gq.getResources(), stackBlur);
                    create.setCornerRadius(dimension);
                    AnonymousClass3.this.fo.post(new ay() { // from class: com.kwad.components.ad.interstitial.e.c.3.1.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            AnonymousClass3.this.fo.setBackground(create);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void b(long j10, long j11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {
        private final Context context;
        private int kj;
        private boolean kk;
        private int kl;
        private boolean km;
        private ac.a kn;
        public double ko;
        public boolean kp;

        public b(Context context) {
            this.context = context;
        }

        public final b A(int i10) {
            this.kl = i10;
            return this;
        }

        public final b a(ac.a aVar) {
            this.kn = aVar;
            return this;
        }

        public final int cU() {
            return this.kj;
        }

        public final boolean cV() {
            return this.kk;
        }

        public final boolean cW() {
            return this.km;
        }

        public final int cX() {
            return this.kl;
        }

        public final double cY() {
            return this.ko;
        }

        public final Context getContext() {
            return this.context;
        }

        public final ac.a getTouchCoords() {
            return this.kn;
        }

        public final b k(boolean z10) {
            this.kk = z10;
            return this;
        }

        public final b l(boolean z10) {
            this.km = true;
            return this;
        }

        public final b m(boolean z10) {
            this.kp = true;
            return this;
        }

        public final b z(int i10) {
            this.kj = i10;
            return this;
        }

        public final b c(double d10) {
            this.ko = d10;
            return this;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.e.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface InterfaceC0419c {
        void cZ();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface d {
        void da();
    }

    public final boolean K(Context context) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null && context != null) {
            return com.kwad.sdk.core.response.b.a.bH(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
        }
        com.kwad.sdk.core.e.c.w("InterstitialCallerContext", "isPlayable illegal params: " + ((Object) this.mAdTemplate) + ", context: " + ((Object) context));
        return false;
    }

    public final void b(a.c cVar) {
        this.jV.remove(cVar);
    }

    public final void cR() {
        d dVar = this.jT;
        if (dVar != null) {
            dVar.da();
        }
    }

    public final void cS() {
        Iterator<InterfaceC0419c> iterator2 = this.jU.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().cZ();
        }
    }

    public final boolean cT() {
        com.kwad.components.ad.interstitial.g.d dVar = this.jL;
        boolean z10 = dVar == null || dVar.getParent() == null;
        com.kwad.sdk.core.e.c.d("InterstitialCallerContext", "isH5Interstitial :" + z10);
        return z10;
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.n(adResultData);
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.fS.removeCallbacksAndMessages(null);
        this.jV.clear();
        this.jU.clear();
        com.kwad.components.ad.interstitial.f.b bVar = this.f36521ib;
        if (bVar != null) {
            bVar.tx();
        }
    }

    public final void a(a.c cVar) {
        if (this.jV.contains(cVar)) {
            return;
        }
        this.jV.add(cVar);
    }

    public final void b(b bVar) {
        com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
        bVar2.f(bVar.getTouchCoords());
        if (!bVar.cV() && !bVar.km) {
            bVar.A(153);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cK(bVar.cX()).f(bVar.getTouchCoords()).cY(ai.LZ() ? 2 : 1).l(bVar.cY()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.eN;
        if (aVar != null) {
            long a10 = a(aVar);
            int b4 = b(this.eN);
            bVar2.ah(a10);
            bVar2.cS(b4);
        }
        this.jM = true;
        if (this.jO) {
            return;
        }
        b(1L, bVar.kl);
    }

    public final void a(final b bVar) {
        com.kwad.components.ad.interstitial.report.a.dM().a(this.mAdTemplate, 1L, bVar.kl);
        boolean z10 = bVar.cU() == 1;
        if (com.kwad.components.ad.interstitial.b.b.cH() || z10 || bVar.cW() || bVar.kp) {
            com.kwad.components.core.e.d.a.a(new a.C0461a(bVar.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(z10).al(1).am(bVar.kl).v(this.eN.getCurrentPosition()).an(bVar.cU()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.e.c.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.b(bVar);
                    if (c.this.f36523io == null || !com.kwad.components.ad.interstitial.b.b.cK()) {
                        return;
                    }
                    c cVar = c.this;
                    cVar.a(false, -1, cVar.eN);
                    c.this.fS.postDelayed(new ay() { // from class: com.kwad.components.ad.interstitial.e.c.1.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            c.this.f36523io.dismiss();
                        }
                    }, 500L);
                }
            }));
        }
    }

    public final void a(final Context context, final int i10, int i11, int i12) {
        com.kwad.components.ad.interstitial.report.a.dM().a(this.mAdTemplate, 6L, i10);
        final int i13 = 9;
        com.kwad.components.core.e.d.a.a(new a.C0461a(context).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).an(2).al(6).am(i10).a(new a.b() { // from class: com.kwad.components.ad.interstitial.e.c.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c cVar = c.this;
                int i14 = i13;
                int i15 = i10;
                cVar.a(i14, i15, context, 6L, i15);
            }
        }));
    }

    public final void b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jQ.remove(aVar);
    }

    public final void b(long j10, long j11) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Iterator<a> iterator2 = this.jQ.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().b(j10, j11);
        }
        a aVar = this.jP;
        if (aVar != null) {
            aVar.b(j10, j11);
        }
        if (this.jO || (adInteractionListener = this.f36522ie) == null) {
            return;
        }
        adInteractionListener.onAdClicked();
    }

    public final void b(Context context, AdTemplate adTemplate) {
        if (this.jW) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.jW = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, int i11, Context context, long j10, long j11) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cR(i10).cK(i11).cY(ai.LZ() ? 2 : 1).Bs(), (JSONObject) null);
        this.jM = true;
        if (this.jO) {
            return;
        }
        b(j10, j11);
    }

    private static int b(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            return Math.round((((float) currentPosition) / ((float) duration)) * 100.0f);
        }
        return -1;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jQ.add(aVar);
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.aW(adInfo) && !ai.LZ();
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.br(adInfo).getUrl();
        if (bg.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass3(context, view));
    }

    public final void a(boolean z10, int i10, @Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        long j10;
        int a10;
        com.kwad.components.ad.interstitial.report.a.dM().l(this.mAdTemplate);
        if (aVar != null) {
            j10 = a(aVar);
            a10 = b(aVar);
        } else {
            j10 = i10;
            a10 = a(j10, this.mAdTemplate);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, z10 ? 14 : 1, j10, a10, this.f36523io.getTimerHelper().getTime(), null);
    }

    private static long a(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    private static int a(long j10, @NonNull AdTemplate adTemplate) {
        if (j10 == -1) {
            return -1;
        }
        float M = ((float) com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.dQ(adTemplate))) / 1000.0f;
        if (M != 0.0f) {
            return Math.round((((float) j10) / M) * 100.0f);
        }
        return -1;
    }
}
