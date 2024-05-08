package com.zego.zegoavkit2.videofilter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoDefaultVideoFilterFactory extends ZegoVideoFilterFactory {
    public static final ZegoDefaultVideoFilterFactory sFactory = new ZegoDefaultVideoFilterFactory();
    private ZegoVideoFilter mVideoFilter;

    private ZegoDefaultVideoFilterFactory() {
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory
    public ZegoVideoFilter create() {
        return this.mVideoFilter;
    }

    @Override // com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory
    public void destroy(ZegoVideoFilter zegoVideoFilter) {
        if (zegoVideoFilter == null || !zegoVideoFilter.equals(this.mVideoFilter)) {
            return;
        }
        this.mVideoFilter = null;
    }

    public ZegoVideoFilter getZegoVideoFilter() {
        return this.mVideoFilter;
    }

    public void setZegoVideoFilter(ZegoVideoFilter zegoVideoFilter) {
        this.mVideoFilter = zegoVideoFilter;
    }
}
