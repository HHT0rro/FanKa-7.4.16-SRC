package com.kwad.components.ad.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DownloadProgressView extends FrameLayout {
    public TextView HU;

    @ColorInt
    private int HV;

    @ColorInt
    private int HW;

    @ColorInt
    private int HX;
    private int HY;
    private Drawable HZ;
    private Drawable Ia;
    private String Ib;
    private final KsAppDownloadListener cx;
    public TextProgressBar dh;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.HV = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.HW = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.HX = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.HY = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.d.a.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.HZ = drawable;
        if (drawable == null) {
            this.HZ = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.Ia = drawable2;
        if (drawable2 == null) {
            this.Ia = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
        }
        String string = obtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.Ib = string;
        if (string == null) {
            this.Ib = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    private void initView() {
        l.inflate(getContext(), R.layout.ksad_download_progress_layout, this);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.dh = textProgressBar;
        textProgressBar.setTextDimen(this.HY);
        this.dh.setTextColor(this.HW, this.HX);
        this.dh.setProgressDrawable(this.HZ);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.HU = textView;
        textView.setTextColor(this.HV);
        this.HU.setTextSize(0, this.HY);
        this.HU.setVisibility(0);
        this.HU.setBackground(this.Ia);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public final void ai(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo dQ = e.dQ(adTemplate);
        this.mAdInfo = dQ;
        this.HU.setText(com.kwad.sdk.core.response.b.a.aE(dQ));
        this.dh.setVisibility(8);
        this.HU.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.cx;
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(l.wrapContextIfNeed(context), attributeSet, i10);
        this.cx = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.HU.setText(com.kwad.sdk.core.response.b.a.aE(downloadProgressView.mAdInfo));
                DownloadProgressView.this.HU.setVisibility(0);
                DownloadProgressView.this.dh.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.HU.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dh.e(com.kwad.sdk.core.response.b.a.bY(downloadProgressView.mAdTemplate), DownloadProgressView.this.dh.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.HU.setText(com.kwad.sdk.core.response.b.a.aE(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.HU.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dh.e(com.kwad.sdk.core.response.b.a.ac(downloadProgressView.mAdInfo), DownloadProgressView.this.dh.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i11) {
                DownloadProgressView.this.HU.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView.this.dh.e(com.kwad.sdk.core.response.b.a.Fg(), i11);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i11) {
                DownloadProgressView.this.HU.setVisibility(8);
                DownloadProgressView.this.dh.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dh.e(com.kwad.sdk.core.response.b.a.q(i11, downloadProgressView.Ib), i11);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }
}
