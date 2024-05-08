package com.kwad.components.ad.splashscreen.c.a;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends com.kwad.components.ad.splashscreen.c.e implements com.kwad.sdk.core.h.c {
    private CloseCountDownView EB;
    private ImageView EF;
    private TextView EG;
    private TextView EH;
    private ViewGroup EK;
    private ImageView EL;
    private KsLogoView EM;
    private TextView EN;
    private TextView EO;

    /* JADX INFO: Access modifiers changed from: private */
    public void V(String str) {
        TextView textView = this.EN;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_endcard_view_stub);
        if (viewStub != null) {
            this.EK = (ViewGroup) viewStub.inflate();
        } else {
            this.EK = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_root);
        }
        this.EL = (ImageView) findViewById(R.id.ksad_splash_end_card_native_bg);
        this.EF = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.EG = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.EH = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
        this.EM = (KsLogoView) findViewById(R.id.ksad_ad_endcard_logo);
        this.EN = (TextView) findViewById(R.id.ksad_ad_btn_title);
        this.EO = (TextView) findViewById(R.id.ksad_ad_btn_sub_title);
        this.EB = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
    }

    private void lC() {
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate))) {
            com.kwad.components.ad.splashscreen.f.a aVar = new com.kwad.components.ad.splashscreen.f.a(getContext(), this.Dg.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.c.a.d.1
                {
                    super(r3);
                }

                @Override // com.kwad.components.ad.splashscreen.f.a
                public final void k(int i10, String str) {
                    d.this.V(str);
                }
            };
            com.kwad.components.core.e.d.c cVar = this.Dg.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(aVar);
            }
        }
    }

    private void lD() {
        this.EK.setVisibility(0);
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.Dg.mAdTemplate);
        a(this.EL, com.kwad.sdk.core.response.b.a.aU(dQ).materialUrl, this.Dg.mAdTemplate);
        this.EF.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.EF, com.kwad.sdk.core.response.b.a.cf(dQ), this.Dg.mAdTemplate, 24);
        this.EG.setText(com.kwad.sdk.core.response.b.a.cc(dQ));
        this.EH.setText(com.kwad.sdk.core.response.b.a.au(dQ));
        this.EM.aD(this.Dg.mAdTemplate);
        if (!com.kwad.sdk.core.response.b.a.aF(dQ)) {
            this.EN.setText("点击查看");
            this.EO.setVisibility(0);
            this.EO.setText("跳转详情页/第三方应用");
        } else {
            y(dQ);
        }
        this.EB.a(dQ);
    }

    private void y(AdInfo adInfo) {
        h hVar = this.Dg;
        com.kwad.components.core.e.d.c cVar = hVar.mApkDownloadHelper;
        if (cVar == null) {
            return;
        }
        String a10 = com.kwad.components.ad.splashscreen.d.a(hVar.mAdTemplate, adInfo, cVar.nW(), 0);
        if (!TextUtils.isEmpty(a10)) {
            this.EN.setText(a10);
        } else {
            this.EN.setText(com.kwad.sdk.core.response.b.a.aE(adInfo));
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        this.EB.aM();
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        this.EB.aN();
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Dg.Cs.a(this);
        com.kwad.sdk.core.adlog.c.b(this.Dg.mAdTemplate, 87, (JSONObject) null);
        lC();
        lD();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.EB.bf();
        this.Dg.Cs.b(this);
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(20).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.c.a.d.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }
}
