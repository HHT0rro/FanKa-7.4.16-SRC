package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.ay;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativeVideoControlPanel extends AutoScaleSizeRelativeLayout {
    private ImageView B;
    private View C;
    private ImageView Code;
    private TextView D;
    private View F;
    private View I;
    private View S;
    private ImageView V;

    public NativeVideoControlPanel(Context context) {
        super(context);
        Code(context);
    }

    public NativeVideoControlPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public NativeVideoControlPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_native_video_control_panel, this);
        this.C = findViewById(R.id.hiad_native_video_control_panel);
        ImageView imageView = (ImageView) findViewById(R.id.hiad_cb_sound);
        this.V = imageView;
        imageView.setImageResource(R.drawable.hiad_selector_ic_sound_check);
        ay.Code(this.V);
        this.I = findViewById(R.id.hiad_pb_buffering);
        this.Code = (ImageView) findViewById(R.id.hiad_btn_play_or_pause);
        this.B = (ImageView) findViewById(R.id.hiad_iv_preview_video);
        this.S = findViewById(R.id.hiad_rl_non_wifi_alert);
        this.F = findViewById(R.id.hiad_btn_non_wifi_play);
        this.D = (TextView) findViewById(R.id.hiad_non_wifi_alert_msg);
    }

    public ImageView B() {
        return this.V;
    }

    public View C() {
        return this.I;
    }

    public ImageView Code() {
        return this.Code;
    }

    public void Code(boolean z10) {
        this.V.setVisibility(z10 ? 0 : 8);
    }

    public View D() {
        return this.F;
    }

    public View F() {
        return this.S;
    }

    public int I() {
        return R.drawable.hiad_pause;
    }

    public View L() {
        return this.C;
    }

    public ImageView S() {
        return this.B;
    }

    public int V() {
        return R.drawable.hiad_play;
    }

    public void setNonWifiAlertMsg(String str) {
        this.D.setText(str);
    }
}
