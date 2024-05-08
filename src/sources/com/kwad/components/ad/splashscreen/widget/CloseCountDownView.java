package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.n.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CloseCountDownView extends LinearLayout {
    private a EI;
    private String FJ;
    private int FK;
    private TextView FL;
    private TextView FM;
    private ImageView FN;
    private Runnable FO;
    private boolean nD;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface a {
        void df();

        void lb();
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.FJ = "%ss";
        this.FK = 5;
        this.nD = false;
        this.FO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nD) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.FK > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ab(closeCountDownView.FK);
                    CloseCountDownView.d(CloseCountDownView.this);
                    return;
                }
                if (CloseCountDownView.this.EI != null) {
                    CloseCountDownView.this.EI.lb();
                }
            }
        };
        V(context);
    }

    private void V(Context context) {
        setOrientation(0);
        l.inflate(context, R.layout.ksad_endcard_close_view, this);
        this.FL = (TextView) findViewById(R.id.ksad_ad_endcard_second);
        this.FM = (TextView) findViewById(R.id.ksad_ad_endcard_line);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_splash_endcard_close_img);
        this.FN = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CloseCountDownView.this.EI != null) {
                    CloseCountDownView.this.EI.df();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i10) {
        this.FL.setText(String.format(this.FJ, Integer.valueOf(i10)));
    }

    public static /* synthetic */ int d(CloseCountDownView closeCountDownView) {
        int i10 = closeCountDownView.FK;
        closeCountDownView.FK = i10 - 1;
        return i10;
    }

    private void eF() {
        post(this.FO);
    }

    private void eG() {
        this.nD = true;
    }

    private void eH() {
        this.nD = false;
    }

    public final void aM() {
        eH();
    }

    public final void aN() {
        eG();
    }

    public final void bf() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public void setOnViewClickListener(a aVar) {
        this.EI = aVar;
    }

    public final void a(AdInfo adInfo) {
        boolean cm = com.kwad.sdk.core.response.b.a.cm(adInfo);
        this.FK = com.kwad.sdk.core.response.b.a.cl(adInfo);
        if (cm) {
            this.FL.setVisibility(0);
            this.FM.setVisibility(0);
            ab(this.FK);
            setPadding(com.kwad.sdk.d.a.a.a(getContext(), 12.0f), 0, com.kwad.sdk.d.a.a.a(getContext(), 12.0f), 0);
        } else {
            setPadding(com.kwad.sdk.d.a.a.a(getContext(), 4.0f), 0, com.kwad.sdk.d.a.a.a(getContext(), 4.0f), 0);
        }
        eF();
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.FJ = "%ss";
        this.FK = 5;
        this.nD = false;
        this.FO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nD) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.FK > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ab(closeCountDownView.FK);
                    CloseCountDownView.d(CloseCountDownView.this);
                    return;
                }
                if (CloseCountDownView.this.EI != null) {
                    CloseCountDownView.this.EI.lb();
                }
            }
        };
        V(context);
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.FJ = "%ss";
        this.FK = 5;
        this.nD = false;
        this.FO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nD) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.FK > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ab(closeCountDownView.FK);
                    CloseCountDownView.d(CloseCountDownView.this);
                    return;
                }
                if (CloseCountDownView.this.EI != null) {
                    CloseCountDownView.this.EI.lb();
                }
            }
        };
        V(context);
    }

    @RequiresApi(api = 21)
    public CloseCountDownView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.FJ = "%ss";
        this.FK = 5;
        this.nD = false;
        this.FO = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nD) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.FK > 0) {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ab(closeCountDownView.FK);
                    CloseCountDownView.d(CloseCountDownView.this);
                    return;
                }
                if (CloseCountDownView.this.EI != null) {
                    CloseCountDownView.this.EI.lb();
                }
            }
        };
        V(context);
    }
}
