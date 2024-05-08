package com.kwad.components.ad.reward.presenter;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c extends b {

    /* renamed from: sc, reason: collision with root package name */
    private ImageView f36576sc;

    /* renamed from: sd, reason: collision with root package name */
    private AdInfo f36577sd;

    public c(AdInfo adInfo) {
        this.f36577sd = adInfo;
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.c.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.qo.mAdTemplate;
        if (hq() || adTemplate.adInfoList.size() <= 0) {
            return;
        }
        String X = com.kwad.sdk.core.response.b.a.X(adTemplate.adInfoList.get(0));
        this.f36576sc.setVisibility(hs());
        try {
            a(this.f36576sc, X, adTemplate);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    public int hr() {
        return R.id.ksad_blur_video_cover;
    }

    public int hs() {
        getContext();
        if (com.kwad.components.ad.reward.g.F(this.qo.mAdTemplate) && !ai.LZ()) {
            return 0;
        }
        if (com.kwad.components.ad.reward.g.E(this.qo.mAdTemplate) && !ai.LZ()) {
            return 0;
        }
        if ((!com.kwad.sdk.core.response.b.e.ec(this.qo.mAdTemplate) || ai.LZ()) && !com.kwad.components.ad.reward.g.g(this.f36577sd)) {
            return (com.kwad.sdk.core.response.b.a.cD(this.f36577sd) && com.kwad.components.ad.reward.a.b.gC() && !ai.LZ()) ? 0 : 8;
        }
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f36576sc = (ImageView) findViewById(hr());
    }
}
