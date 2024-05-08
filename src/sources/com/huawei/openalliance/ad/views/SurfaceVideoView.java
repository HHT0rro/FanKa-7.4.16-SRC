package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.splash.R;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SurfaceVideoView extends BaseGlVideoView {

    /* renamed from: q, reason: collision with root package name */
    private final int f33015q;

    /* renamed from: r, reason: collision with root package name */
    private SurfaceHolder.Callback f33016r;

    public SurfaceVideoView(Context context) {
        super(context);
        this.f33015q = hashCode();
        this.f33016r = new SurfaceHolder.Callback() { // from class: com.huawei.openalliance.ad.views.SurfaceVideoView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
                SurfaceVideoView.this.V(i11, i12);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                gl.V(SurfaceVideoView.this.getLogTag(), "surfaceCreated");
                SurfaceVideoView.this.Code(surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                SurfaceVideoView.this.C();
            }
        };
        V(context);
    }

    public SurfaceVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33015q = hashCode();
        this.f33016r = new SurfaceHolder.Callback() { // from class: com.huawei.openalliance.ad.views.SurfaceVideoView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
                SurfaceVideoView.this.V(i11, i12);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                gl.V(SurfaceVideoView.this.getLogTag(), "surfaceCreated");
                SurfaceVideoView.this.Code(surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                SurfaceVideoView.this.C();
            }
        };
        V(context);
    }

    public SurfaceVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f33015q = hashCode();
        this.f33016r = new SurfaceHolder.Callback() { // from class: com.huawei.openalliance.ad.views.SurfaceVideoView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i102, int i11, int i12) {
                SurfaceVideoView.this.V(i11, i12);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                gl.V(SurfaceVideoView.this.getLogTag(), "surfaceCreated");
                SurfaceVideoView.this.Code(surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                SurfaceVideoView.this.C();
            }
        };
        V(context);
    }

    private void V(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_surfaceview_video, this);
        ((SurfaceView) findViewById(R.id.hiad_id_video_surface_view)).getHolder().addCallback(this.f33016r);
    }

    @Override // com.huawei.openalliance.ad.views.BaseGlVideoView
    public String getLogTag() {
        return "SurfaceVideoView" + this.f33015q;
    }
}
