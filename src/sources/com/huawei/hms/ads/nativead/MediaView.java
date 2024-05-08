package com.huawei.hms.ads.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.openalliance.ad.views.NativeVideoView;
import com.huawei.openalliance.ad.views.NativeWindowImageView;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class MediaView extends RelativeLayout {
    private ImageView.ScaleType B;
    private NativeVideoView Code;
    private b I;
    private NativeWindowImageView V;

    @GlobalApi
    public MediaView(Context context) {
        super(context);
        Code(context);
    }

    @GlobalApi
    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    @GlobalApi
    public MediaView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
    }

    @GlobalApi
    public MediaView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Code(context);
    }

    private void Code(Context context) {
        setGravity(17);
        NativeVideoView nativeVideoView = new NativeVideoView(context);
        this.Code = nativeVideoView;
        nativeVideoView.setAudioFocusType(1);
        this.Code.setVisibility(4);
        addView(this.Code);
        this.V = new NativeWindowImageView(context);
        this.V.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.V.setVisibility(4);
        addView(this.V);
        this.I = new b(this.Code, this.V);
    }

    public void Code() {
        this.Code.destroyView();
    }

    public b getMediaViewAdapter() {
        return this.I;
    }

    public NativeWindowImageView getNativeWindowImageView() {
        return this.V;
    }

    public NativeVideoView getVideoView() {
        return this.Code;
    }

    @GlobalApi
    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.B = scaleType;
    }

    @GlobalApi
    public void setMediaContent(MediaContent mediaContent) {
        this.Code.setMediaContent(mediaContent);
    }

    @GlobalApi
    public void setRectCornerRadius(float f10) {
        this.V.setRectCornerRadius(f10);
        this.Code.setRectCornerRadius(f10);
    }
}
