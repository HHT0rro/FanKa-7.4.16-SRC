package e9;

import com.huawei.appgallery.agd.agdpro.api.AppDownloadListener;
import com.huawei.appgallery.agd.agdpro.api.DislikeClickListener;
import com.huawei.appgallery.agd.agdpro.api.ICardAd;
import com.huawei.appgallery.agd.agdpro.api.VideoAdListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class b implements ICardAd {

    /* renamed from: a, reason: collision with root package name */
    public AppDownloadListener f48938a;

    /* renamed from: b, reason: collision with root package name */
    public DislikeClickListener f48939b;

    /* renamed from: c, reason: collision with root package name */
    public VideoAdListener f48940c;

    public DislikeClickListener a() {
        return this.f48939b;
    }

    public AppDownloadListener b() {
        return this.f48938a;
    }

    public abstract long c();

    public VideoAdListener d() {
        return this.f48940c;
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.ICardAd
    public void setDislikeClickListener(DislikeClickListener dislikeClickListener) {
        this.f48939b = dislikeClickListener;
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.ICardAd
    public void setDownloadListener(AppDownloadListener appDownloadListener) {
        this.f48938a = appDownloadListener;
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.ICardAd
    public void setVideoAdListener(VideoAdListener videoAdListener) {
        this.f48940c = videoAdListener;
    }
}
