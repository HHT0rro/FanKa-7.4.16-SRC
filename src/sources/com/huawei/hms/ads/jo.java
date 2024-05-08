package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.huawei.hms.ads.fi;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.b;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.c;
import com.huawei.openalliance.ad.views.PPSBannerView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class jo extends hn<lj> implements ke<lj> {
    private int B;
    private com.huawei.openalliance.ad.inter.i C;
    private RequestOptions D;
    private com.huawei.openalliance.ad.inter.data.g F;
    private Location L;
    private Context S;

    /* renamed from: a, reason: collision with root package name */
    private com.huawei.openalliance.ad.inter.data.t f29324a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f29325b;

    /* renamed from: c, reason: collision with root package name */
    private Integer f29326c;

    /* renamed from: d, reason: collision with root package name */
    private Integer f29327d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f29328e = false;

    /* renamed from: f, reason: collision with root package name */
    private String f29329f;

    public jo(Context context, lj ljVar) {
        Code((jo) ljVar);
        this.S = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        com.huawei.openalliance.ad.inter.data.g gVar;
        final long parseLong;
        if (this.B == 1 || (gVar = this.F) == null) {
            return;
        }
        String ak = gVar instanceof com.huawei.openalliance.ad.inter.data.n ? ((com.huawei.openalliance.ad.inter.data.n) gVar).ak() : null;
        gl.V("BannerPresenter", "setBannerRefresh: %s", ak);
        if (TextUtils.isEmpty(ak)) {
            return;
        }
        if ("N".equalsIgnoreCase(ak)) {
            parseLong = 0;
        } else if ("Y".equalsIgnoreCase(ak)) {
            parseLong = fr.Code(this.S).o();
        } else {
            try {
                parseLong = Long.parseLong(ak);
            } catch (NumberFormatException e2) {
                gl.I("BannerPresenter", "parseIntOrDefault exception: " + e2.getClass().getSimpleName());
                return;
            }
        }
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jo.4
            @Override // java.lang.Runnable
            public void run() {
                jo.this.I().Code(parseLong);
            }
        });
    }

    private SourceParam Code(com.huawei.openalliance.ad.inter.data.k kVar) {
        if (kVar == null) {
            return null;
        }
        fr Code = fr.Code(this.S);
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(kVar.Z());
        sourceParam.V(kVar.I());
        sourceParam.V(kVar.S());
        sourceParam.I(true);
        sourceParam.Code(Code == null ? 52428800 : Code.q());
        return sourceParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.huawei.openalliance.ad.inter.data.g Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
        if (map == null) {
            return null;
        }
        Iterator<Map.Entry<String, List<com.huawei.openalliance.ad.inter.data.g>>> iterator2 = map.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Iterator<com.huawei.openalliance.ad.inter.data.g> iterator22 = iterator2.next().getValue().iterator2();
            if (iterator22.hasNext()) {
                return iterator22.next();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i10) {
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jo.6
            @Override // java.lang.Runnable
            public void run() {
                jo.this.I().Code(i10);
                if (i10 == 499) {
                    jo.this.I().B();
                }
            }
        });
    }

    private void Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.f29328e = gVar.d_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        com.huawei.openalliance.ad.inter.data.g gVar = this.F;
        if (gVar == null) {
            gl.I("BannerPresenter", "downLoadBitmap nativeAd is null");
            Code(499);
            return;
        }
        List<com.huawei.openalliance.ad.inter.data.k> Z = gVar.Z();
        if (aa.Code(Z)) {
            gl.I("BannerPresenter", "downLoadBitmap imageInfo is null");
            Code(499);
            return;
        }
        final com.huawei.openalliance.ad.inter.data.k kVar = Z.get(0);
        Code(this.F);
        SourceParam Code = Code(kVar);
        Code.Code(this.Code);
        com.huawei.openalliance.ad.utils.y.Code(this.S, Code, this.F.D(), new com.huawei.openalliance.ad.utils.aj() { // from class: com.huawei.hms.ads.jo.5
            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code() {
                gl.I("BannerPresenter", "loadImage onFail");
                jo.this.Code(499);
            }

            @Override // com.huawei.openalliance.ad.utils.aj
            public void Code(String str, final Drawable drawable) {
                if (TextUtils.equals(str, kVar.Z())) {
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jo.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            jo.this.I().Code(drawable, jo.this.F);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final Context context, final ImageView imageView, final Drawable drawable) {
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.hms.ads.jo.8
            @Override // java.lang.Runnable
            public void run() {
                final Drawable Code = com.huawei.openalliance.ad.utils.w.Code(context, drawable, 5.0f, 8.0f);
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jo.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setBackground(Code);
                    }
                });
            }
        });
    }

    @Override // com.huawei.hms.ads.ke
    public boolean B() {
        return com.huawei.openalliance.ad.utils.v.Code(this.S);
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(final Context context, final ImageView imageView, Drawable drawable) {
        if (this.f29328e) {
            try {
                if (drawable instanceof BitmapDrawable) {
                    imageView.setBackground(com.huawei.openalliance.ad.utils.w.Code(context, drawable, 5.0f, 8.0f));
                } else if (drawable instanceof fi) {
                    ((fi) drawable).Code(new fi.a() { // from class: com.huawei.hms.ads.jo.7
                        @Override // com.huawei.hms.ads.fi.a
                        public void Code(Bitmap bitmap) {
                            jo.this.V(context, imageView, new BitmapDrawable(context.getResources(), bitmap));
                        }
                    });
                }
            } catch (Throwable th) {
                gl.I("BannerPresenter", "set banner background encounter exception: " + th.getClass().getSimpleName());
            }
        }
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(Location location) {
        this.L = location;
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(RequestOptions requestOptions) {
        this.D = requestOptions;
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.F = nVar;
        this.Code = nVar != null ? nVar.l() : null;
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(com.huawei.openalliance.ad.inter.data.t tVar) {
        this.f29324a = tVar;
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(Integer num) {
        this.f29325b = num;
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(String str, int i10, List<String> list, int i11) {
        if (str == null || str.isEmpty()) {
            gl.I("BannerPresenter", "adId is null or empty when load ad");
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jo.1
                @Override // java.lang.Runnable
                public void run() {
                    jo.this.I().Code(702);
                }
            });
            return;
        }
        gl.Code("BannerPresenter", "loadAd ,adId:%s", str);
        this.B = i11;
        com.huawei.openalliance.ad.inter.m mVar = new com.huawei.openalliance.ad.inter.m(this.S, new String[]{str}, i10, list);
        this.C = mVar;
        if (mVar instanceof com.huawei.openalliance.ad.inter.m) {
            mVar.Code(this.L);
            ((com.huawei.openalliance.ad.inter.m) this.C).Z(Integer.valueOf(this.B));
        }
        this.C.Code(dy.Code(this.D));
        this.C.Code(this.f29325b);
        b bannerSize = (I() == null || !(I() instanceof PPSBannerView)) ? null : ((PPSBannerView) I()).getBannerSize();
        if (bannerSize != null) {
            this.C.V(Integer.valueOf(bannerSize.I()));
            this.C.I(Integer.valueOf(bannerSize.Z()));
        } else {
            this.C.V(this.f29326c);
            this.C.I(this.f29327d);
        }
        String str2 = this.f29329f;
        if (str2 != null) {
            this.C.Z(str2);
        }
        com.huawei.openalliance.ad.inter.data.t tVar = this.f29324a;
        if (tVar != null) {
            this.C.Code(tVar.Code());
            this.C.Code(this.f29324a.V());
            this.C.V(this.f29324a.I());
            this.C.I(this.f29324a.Z());
        }
        this.C.Code(new com.huawei.openalliance.ad.inter.listeners.l() { // from class: com.huawei.hms.ads.jo.2
            @Override // com.huawei.openalliance.ad.inter.listeners.l
            public void Code(final int i12) {
                gl.Code("BannerPresenter", "loadAd onAdFailed");
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jo.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        jo.this.I().Code(i12);
                    }
                });
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.l
            public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
                gl.Code("BannerPresenter", "loadAd onAdsLoaded");
                jo joVar = jo.this;
                joVar.F = joVar.Code(map);
                com.huawei.openalliance.ad.utils.f.V(new Runnable() { // from class: com.huawei.hms.ads.jo.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        jo.this.S();
                    }
                });
                jo.this.C();
            }
        });
        this.C.Code(new com.huawei.openalliance.ad.inter.listeners.d() { // from class: com.huawei.hms.ads.jo.3
            @Override // com.huawei.openalliance.ad.inter.listeners.d
            public void Code(final List<String> list2) {
                gl.Code("BannerPresenter", "loadAd onInValidContentIdsGot");
                com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.jo.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        jo.this.I().Code(list2);
                    }
                });
            }
        });
        this.C.Code(com.huawei.openalliance.ad.utils.l.I(this.S), null, false);
    }

    @Override // com.huawei.hms.ads.ke
    public void Code(String str, com.huawei.openalliance.ad.inter.data.g gVar, long j10) {
        if (gVar instanceof com.huawei.openalliance.ad.inter.data.n) {
            AdContentData l10 = ((com.huawei.openalliance.ad.inter.data.n) gVar).l();
            AnalysisEventReport analysisEventReport = new AnalysisEventReport();
            analysisEventReport.V(str);
            analysisEventReport.Code(l10);
            analysisEventReport.Code(j10);
            if (l10 != null) {
                analysisEventReport.S(l10.az());
                analysisEventReport.F(l10.C());
                analysisEventReport.C(l10.S());
                analysisEventReport.I(l10.aA());
            }
            com.huawei.openalliance.ad.ipc.g.V(this.S).Code("rptAdInvalidEvt", com.huawei.openalliance.ad.utils.z.V(analysisEventReport), null, null);
        }
    }

    @Override // com.huawei.hms.ads.ke
    public boolean Code(b bVar, float f10) {
        if (!(I() instanceof PPSBannerView)) {
            return false;
        }
        PPSBannerView pPSBannerView = (PPSBannerView) I();
        Context applicationContext = pPSBannerView.getContext().getApplicationContext();
        int width = pPSBannerView.getWidth();
        int height = pPSBannerView.getHeight();
        if (gl.Code()) {
            gl.Code("BannerPresenter", "banner view width: %s, height: %s", Integer.valueOf(width), Integer.valueOf(height));
        }
        DisplayMetrics C = c.C(this.S);
        if (width > C.widthPixels || height > C.heightPixels) {
            gl.I("BannerPresenter", "Ad view is off screen");
            return false;
        }
        int Code = bVar.Code();
        int V = bVar.V();
        float f11 = Code - width;
        float f12 = Code;
        float f13 = V - height;
        float f14 = V;
        boolean z10 = f11 / f12 < f10 && f13 / f14 < f10;
        if (!z10) {
            float a10 = c.a(applicationContext);
            if (a10 > 0.0f) {
                gl.I("BannerPresenter", "Not enough space to show ad. Needs %s×%s dp, but only has %s×%s dp", Integer.valueOf(Math.round(f12 / a10)), Integer.valueOf(Math.round(f14 / a10)), Integer.valueOf(Math.round(width / a10)), Integer.valueOf(Math.round(height / a10)));
            }
        }
        return z10;
    }

    @Override // com.huawei.hms.ads.ke
    public void I(Integer num) {
        this.f29327d = num;
    }

    @Override // com.huawei.hms.ads.ke
    public void V(Integer num) {
        this.f29326c = num;
    }

    @Override // com.huawei.hms.ads.ke
    public void V(String str) {
        this.f29329f = str;
    }
}
