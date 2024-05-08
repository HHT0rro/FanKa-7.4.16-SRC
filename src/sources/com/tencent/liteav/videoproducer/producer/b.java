package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final a f44974a;

    /* renamed from: b, reason: collision with root package name */
    private final GLConstants.PixelFormatType f44975b;

    /* renamed from: c, reason: collision with root package name */
    private final GLConstants.PixelBufferType f44976c;

    /* renamed from: d, reason: collision with root package name */
    private final CustomVideoProcessListener f44977d;

    private b(a aVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        this.f44974a = aVar;
        this.f44975b = pixelFormatType;
        this.f44976c = pixelBufferType;
        this.f44977d = customVideoProcessListener;
    }

    public static Runnable a(a aVar, GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        return new b(aVar, pixelFormatType, pixelBufferType, customVideoProcessListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.f44974a;
        GLConstants.PixelFormatType pixelFormatType = this.f44975b;
        GLConstants.PixelBufferType pixelBufferType = this.f44976c;
        CustomVideoProcessListener customVideoProcessListener = this.f44977d;
        boolean z10 = (aVar.f44891e == pixelFormatType && aVar.f44890d == pixelBufferType) ? false : true;
        if (z10) {
            LiteavLog.i("CustomVideoProcessListenerAdapter", "FormatOrBufferTypeChanged from (PixelFormat:" + ((Object) aVar.f44891e) + ",  PixelBuffer:" + ((Object) aVar.f44890d) + ") to (PixelFormat:" + ((Object) pixelFormatType) + ",  PixelBuffer:" + ((Object) pixelBufferType));
            aVar.f44892f = true;
        }
        if (aVar.f44889c == null) {
            aVar.a(customVideoProcessListener);
        }
        CustomVideoProcessListener customVideoProcessListener2 = aVar.f44889c;
        if (customVideoProcessListener2 != null && (z10 || customVideoProcessListener2 != customVideoProcessListener)) {
            aVar.b(customVideoProcessListener2);
            aVar.a(customVideoProcessListener);
        }
        aVar.f44891e = pixelFormatType;
        aVar.f44890d = pixelBufferType;
        aVar.f44889c = customVideoProcessListener;
    }
}
