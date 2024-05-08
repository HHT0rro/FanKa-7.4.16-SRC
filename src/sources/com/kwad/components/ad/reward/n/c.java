package com.kwad.components.ad.reward.n;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSRatingBar;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends com.kwad.sdk.core.download.a.a implements com.kwad.sdk.widget.c {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private View xZ;

    /* renamed from: ya, reason: collision with root package name */
    private View f36561ya;

    /* renamed from: yb, reason: collision with root package name */
    private Button f36562yb;

    /* renamed from: yc, reason: collision with root package name */
    private Button f36563yc;

    /* renamed from: yd, reason: collision with root package name */
    private TextView f36564yd;
    private ImageView ye;
    private TextView yf;
    private TextView yg;
    private KSRatingBar yh;
    private KsAppTagsView yi;
    private a yj;
    private volatile boolean yk = false;
    private com.kwad.components.ad.i.a yl;
    private Runnable ym;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void d(boolean z10, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {
        private String appName;

        /* renamed from: qa, reason: collision with root package name */
        private String f36565qa;

        /* renamed from: qb, reason: collision with root package name */
        private String f36566qb;
        private float yo;
        private List<String> yp;
        private int yq = 15;
        private String yr;

        public static b P(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
            b bVar = new b();
            if (com.kwad.sdk.core.response.b.e.F(adTemplate)) {
                bVar.appName = com.kwad.sdk.core.response.b.a.ax(dQ);
            } else {
                bVar.appName = com.kwad.sdk.core.response.b.a.av(dQ);
            }
            bVar.yo = com.kwad.sdk.core.response.b.a.aC(dQ);
            bVar.f36566qb = com.kwad.sdk.core.response.b.a.au(dQ);
            if (com.kwad.sdk.core.response.b.e.F(adTemplate)) {
                bVar.f36565qa = com.kwad.sdk.core.response.b.a.cI(dQ);
            } else {
                bVar.f36565qa = com.kwad.sdk.core.response.b.a.cf(dQ);
            }
            if (com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dQ(adTemplate)))) {
                bVar.yq = com.kwad.components.ad.reward.a.b.gr();
                bVar.yr = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.yq = com.kwad.sdk.core.config.d.Cg();
                bVar.yr = "浏览详情页%s秒，领取奖励";
            }
            bVar.yp = com.kwad.sdk.core.response.b.d.dH(adTemplate);
            return bVar;
        }

        public final String jR() {
            return String.format(this.yr, Integer.valueOf(this.yq));
        }
    }

    public c(View view) {
        this.xZ = view;
        initView();
        this.yl = new com.kwad.components.ad.i.a(view);
    }

    private void initView() {
        this.f36562yb = (Button) this.xZ.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.f36563yc = (Button) this.xZ.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.f36561ya = this.xZ.findViewById(R.id.ksad_reward_apk_info_install_container);
        this.ye = (ImageView) this.xZ.findViewById(R.id.ksad_reward_apk_info_icon);
        this.f36564yd = (TextView) this.xZ.findViewById(R.id.ksad_reward_apk_info_name);
        this.yf = (TextView) this.xZ.findViewById(R.id.ksad_reward_apk_info_desc);
        this.yh = (KSRatingBar) this.xZ.findViewById(R.id.ksad_reward_apk_info_score);
        this.yi = (KsAppTagsView) this.xZ.findViewById(R.id.ksad_reward_apk_info_tags);
    }

    public final void jP() {
        Runnable runnable;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.i.a aVar = this.yl;
        if (aVar != null) {
            aVar.jP();
        }
        View view = this.f36561ya;
        if (view == null || (runnable = this.ym) == null) {
            return;
        }
        view.removeCallbacks(runnable);
        this.ym = null;
    }

    public final void jQ() {
        this.yl.mc();
    }

    public final void k(String str, int i10) {
        Button button = this.f36563yc;
        if (button == null || str == null || i10 == 0) {
            return;
        }
        button.setText(str);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.f36563yc.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.f36563yc.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.b.a.bY(adTemplate));
    }

    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.f36563yc.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.f36563yc.setText(adTemplate != null ? com.kwad.sdk.core.response.b.a.ac(com.kwad.sdk.core.response.b.e.dQ(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i10) {
        super.onPaused(i10);
        if (i10 != 0) {
            this.yl.mc();
            this.f36563yc.setText(com.kwad.sdk.core.response.b.a.dn(i10));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i10) {
        if (i10 != 0) {
            this.yl.mc();
            this.f36563yc.setText(com.kwad.sdk.core.response.b.a.dm(i10));
        }
    }

    public final void a(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dF(this.mAdTemplate)) {
            c(view, false);
        }
    }

    public final void c(AdTemplate adTemplate, boolean z10) {
        this.mAdTemplate = adTemplate;
        b P = b.P(adTemplate);
        if (P == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.ye, P.f36565qa, adTemplate, 12);
        this.f36564yd.setText(P.appName);
        this.yf.setText(P.f36566qb);
        this.yh.setStar(P.yo);
        if (com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dQ(adTemplate)))) {
            this.f36563yc.setText(com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
            this.yh.setVisibility(0);
        } else {
            this.f36563yc.setText("查看详情");
            this.yh.setVisibility(8);
        }
        this.f36562yb.setText(P.jR());
        this.f36562yb.setClickable(true);
        this.f36563yc.setClickable(true);
        this.f36561ya.setClickable(true);
        new com.kwad.sdk.widget.f(this.f36562yb, this);
        new com.kwad.sdk.widget.f(this.f36563yc, this);
        new com.kwad.sdk.widget.f(this.f36561ya, this);
        List<String> list = P.yp;
        if (z10 && list.size() == 0) {
            this.yf.setVisibility(8);
            TextView textView = (TextView) this.xZ.findViewById(R.id.ksad_reward_apk_info_desc_2);
            this.yg = textView;
            textView.setVisibility(0);
            this.yg.setText(P.f36566qb);
        }
        if (list.size() == 0) {
            this.yi.setVisibility(8);
        }
        this.yi.setAppTags(list);
        if (this.ym == null) {
            this.ym = new Runnable() { // from class: com.kwad.components.ad.reward.n.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.e.c.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + c.this.f36561ya.getHeight());
                    if (c.this.yk) {
                        return;
                    }
                    c.this.yl.hT();
                }
            };
        }
        this.f36561ya.postDelayed(this.ym, 1600L);
    }

    public final void a(a aVar) {
        this.yj = aVar;
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        c(view, true);
    }

    private void c(View view, boolean z10) {
        int id2 = view.getId();
        if (id2 == R.id.ksad_reward_apk_info_install_container || id2 == R.id.ksad_reward_apk_info_install_action || id2 == R.id.ksad_reward_apk_info_install_start) {
            com.kwad.sdk.core.e.c.d("ApkInfoCardViewHelper", "onClick install");
            this.yk = true;
            a aVar = this.yj;
            if (aVar != null) {
                aVar.d(z10, 1);
            }
        }
    }
}
