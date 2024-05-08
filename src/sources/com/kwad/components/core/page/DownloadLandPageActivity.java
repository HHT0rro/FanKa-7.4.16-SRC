package com.kwad.components.core.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.c.f;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.widget.DownloadProgressBar;
import com.kwad.sdk.widget.KSLinearLayout;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadLandPageActivity extends com.kwad.components.core.l.b<com.kwad.components.core.page.c.d> {
    public static final String KEY_NEED_CLOSE_REWARD = "key_close_reward";
    public static final String KEY_TEMPLATE = "key_template_json";
    private static final String TAG = "DownloadLandPageActivity";
    public static boolean showingAdWebViewLandPage;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private ImageView mBackIcon;
    private ImageView mCloseIcon;
    private DetailVideoView mDetailVideoView;
    private boolean mIsRewardLandPage;
    private KSRelativeLayout mKsadVideoContainer;
    private com.kwad.components.core.page.d.a mPlayModule;
    private ImageView mVideoBlurBg;
    private ImageView mVideoCover;
    private k mVideoPlayStateListener;

    private void buildView(ComplianceTextView complianceTextView, KSLinearLayout kSLinearLayout, KsLogoView ksLogoView) {
        if (com.kwad.sdk.core.response.b.a.bc(e.dQ(this.mAdTemplate))) {
            return;
        }
        ((FrameLayout.LayoutParams) complianceTextView.getLayoutParams()).gravity = 80;
        if (!ai.LZ()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ksLogoView.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, com.kwad.sdk.d.a.a.a(this.mContext, 100.0f));
            ksLogoView.setLayoutParams(marginLayoutParams);
        }
        ksLogoView.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) kSLinearLayout.getLayoutParams();
        layoutParams.gravity = 17;
        kSLinearLayout.setLayoutParams(layoutParams);
    }

    private k getVideoPlayStateListener() {
        l lVar = new l() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.6
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(0);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i10, int i11) {
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                DownloadLandPageActivity.this.mVideoCover.setVisibility(8);
            }
        };
        this.mVideoPlayStateListener = lVar;
        return lVar;
    }

    @NonNull
    private f.a getWebViewStateListener() {
        return new f.a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.3
            @Override // com.kwad.components.core.page.c.f.a
            public final void aA(int i10) {
                if (i10 != 1) {
                    DownloadLandPageActivity.this.initNativeLandPage();
                }
            }
        };
    }

    private void handleCloseBtn() {
        long am = com.kwad.sdk.core.response.b.a.am(this.mAdInfo);
        if (am == 0) {
            this.mCloseIcon.setVisibility(0);
        } else {
            this.mCloseIcon.postDelayed(new ay() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.7
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    if (DownloadLandPageActivity.this.getActivity() == null || DownloadLandPageActivity.this.getActivity().isFinishing()) {
                        return;
                    }
                    DownloadLandPageActivity.this.mCloseIcon.setVisibility(0);
                    DownloadLandPageActivity.this.mCloseIcon.setAlpha(0.0f);
                    DownloadLandPageActivity.this.mCloseIcon.animate().alpha(1.0f).setDuration(500L).start();
                }
            }, am);
        }
        this.mCloseIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    com.kwad.components.core.s.c.qZ().ra();
                    DownloadLandPageActivity.this.finish();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNativeLandPage() {
        findViewById(R.id.ksad_ad_land_page_native).setVisibility(0);
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        complianceTextView.setVisibility(0);
        complianceTextView.setAdTemplate(this.mAdTemplate);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_cover);
        TextView textView = (TextView) findViewById(R.id.ksad_ad_title);
        TextView textView2 = (TextView) findViewById(R.id.ksad_ad_info);
        KSLinearLayout kSLinearLayout = (KSLinearLayout) findViewById(R.id.ksad_info_container);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_land_page_logo);
        DownloadProgressBar downloadProgressBar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
        AdInfo dQ = e.dQ(this.mAdTemplate);
        setAdTitle(textView, dQ);
        textView2.setText(dQ.adBaseInfo.adDescription);
        roundAngleImageView.setRadius(32.0f);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.cf(dQ))) {
            KSImageLoader.loadImage(roundAngleImageView, com.kwad.sdk.core.response.b.a.cf(dQ), this.mAdTemplate);
        }
        setAdkDownload(downloadProgressBar, dQ);
        buildView(complianceTextView, kSLinearLayout, ksLogoView);
    }

    public static void launch(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z10) {
        Class cls = ai.LZ() ? AdWebViewActivity.class : KsFullScreenLandScapeVideoActivity.class;
        com.kwad.sdk.service.b.a(cls, DownloadLandPageActivity.class);
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.addFlags(268435456);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_NEED_CLOSE_REWARD, z10);
        context.startActivity(intent);
    }

    private void loadBlurImage(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setVisibility(0);
        KSImageLoader.loadImage(imageView, str, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }

    private void setAdTitle(TextView textView, AdInfo adInfo) {
        if (!TextUtils.isEmpty(adInfo.adBaseInfo.appName)) {
            textView.setText(adInfo.adBaseInfo.appName);
        } else {
            if (TextUtils.isEmpty(adInfo.advertiserInfo.rawUserName)) {
                return;
            }
            textView.setText(adInfo.advertiserInfo.rawUserName);
        }
    }

    private void setAdkDownload(final DownloadProgressBar downloadProgressBar, final AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.4
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.aE(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.bY(DownloadLandPageActivity.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.aE(adInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    downloadProgressBar.setProgress(100.0f);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.ac(adInfo));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i10) {
                    downloadProgressBar.setProgress(i10);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.dn(i10));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i10) {
                    downloadProgressBar.setProgress(i10);
                    downloadProgressBar.setText(com.kwad.sdk.core.response.b.a.dm(i10));
                }
            });
            downloadProgressBar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.kwad.sdk.core.adlog.c.p(DownloadLandPageActivity.this.mAdTemplate, 152);
                    DownloadLandPageActivity.this.mApkDownloadHelper.r(new a.C0461a(DownloadLandPageActivity.this.getActivity()).ao(true).ap(false).aq(DownloadLandPageActivity.this.mAdTemplate).ar(false));
                    if (DownloadLandPageActivity.this.mIsRewardLandPage) {
                        com.kwad.sdk.core.adlog.c.a(DownloadLandPageActivity.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b(), (JSONObject) null);
                    }
                }
            });
        }
    }

    private void setVideoData() {
        ViewGroup.LayoutParams layoutParams = this.mKsadVideoContainer.getLayoutParams();
        if (ai.LZ()) {
            layoutParams.height = (com.kwad.sdk.d.a.a.getScreenWidth(this.mContext) * 9) / 16;
            layoutParams.width = -1;
        } else {
            layoutParams.width = com.kwad.sdk.d.a.a.getScreenWidth(this.mContext) / 2;
            layoutParams.height = -1;
        }
        this.mKsadVideoContainer.setLayoutParams(layoutParams);
        this.mKsadVideoContainer.setVisibility(0);
        KSImageLoader.loadImage(this.mVideoCover, com.kwad.sdk.core.response.b.a.br(this.mAdInfo).getUrl(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c
    public boolean checkIntentData(@Nullable Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            if (stringExtra != null) {
                adTemplate.parseJson(new JSONObject(stringExtra));
            }
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        return this.mAdTemplate != null;
    }

    @Override // com.kwad.components.core.proxy.c
    public int getLayoutId() {
        if (ai.LZ()) {
            return R.layout.ksad_activity_ad_land_page;
        }
        return R.layout.ksad_activity_land_page_horizontal;
    }

    @Override // com.kwad.components.core.proxy.c
    public String getPageName() {
        return TAG;
    }

    @Override // com.kwad.components.core.proxy.c
    public void initData() {
        showingAdWebViewLandPage = true;
        this.mIsRewardLandPage = getIntent().getBooleanExtra(KEY_NEED_CLOSE_REWARD, false);
        this.mAdInfo = e.dQ(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.c
    public void initView() {
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) findViewById(R.id.ksad_root_container);
        this.mKsadVideoContainer = (KSRelativeLayout) findViewById(R.id.ksad_video_container);
        DetailVideoView detailVideoView = (DetailVideoView) kSRelativeLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.g(true, com.kwad.sdk.core.config.d.CC());
        this.mVideoBlurBg = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_video_blur_bg);
        this.mBackIcon = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_back_icon);
        this.mCloseIcon = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_right_close);
        this.mVideoCover = (ImageView) kSRelativeLayout.findViewById(R.id.ksad_video_cover);
        if (this.mAdTemplate.adInfoList.size() > 0) {
            loadBlurImage(com.kwad.sdk.core.response.b.a.X(this.mAdTemplate.adInfoList.get(0)), this.mVideoBlurBg);
        }
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.DownloadLandPageActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    com.kwad.sdk.core.adlog.c.p(DownloadLandPageActivity.this.mAdTemplate, 153);
                    DownloadLandPageActivity.this.finish();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.bc(e.dQ(this.mAdTemplate))) {
            setVideoData();
        }
        if (this.mIsRewardLandPage) {
            handleCloseBtn();
        }
    }

    @Override // com.kwad.components.core.l.b
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        if (com.kwad.sdk.core.response.b.a.bc(e.dQ(this.mAdTemplate))) {
            presenter.a(new com.kwad.components.core.page.c.e());
        }
        presenter.a(new f(getWebViewStateListener(), this.mIsRewardLandPage));
        return presenter;
    }

    @Override // com.kwad.components.core.l.b, com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            showingAdWebViewLandPage = false;
            com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.clear();
            }
            com.kwad.components.core.page.d.a aVar = this.mPlayModule;
            if (aVar != null) {
                aVar.release();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.l.b
    public com.kwad.components.core.page.c.d onCreateCallerContext() {
        com.kwad.components.core.page.c.d dVar = new com.kwad.components.core.page.c.d(this);
        AdTemplate adTemplate = this.mAdTemplate;
        dVar.mAdTemplate = adTemplate;
        if (com.kwad.sdk.core.response.b.a.bc(e.dQ(adTemplate))) {
            com.kwad.components.core.s.a.ah(this.mContext).aN(true);
            com.kwad.components.core.page.d.a aVar = new com.kwad.components.core.page.d.a(this.mAdTemplate, this.mDetailVideoView, new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
            this.mPlayModule = aVar;
            dVar.mPlayModule = aVar;
            aVar.a(getVideoPlayStateListener());
            dVar.Ms.add(this.mPlayModule);
        }
        return dVar;
    }
}
