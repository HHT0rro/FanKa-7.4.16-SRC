package com.tencent.liteav.videobase.utils;

import android.graphics.Bitmap;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final n f43549a;

    /* renamed from: b, reason: collision with root package name */
    private final PixelFrame f43550b;

    private r(n nVar, PixelFrame pixelFrame) {
        this.f43549a = nVar;
        this.f43550b = pixelFrame;
    }

    public static Runnable a(n nVar, PixelFrame pixelFrame) {
        return new r(nVar, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar = this.f43549a;
        PixelFrame pixelFrame = this.f43550b;
        LiteavLog.i(nVar.f43533a, "snapshot pixelFrame");
        if (nVar.f43537e != null) {
            if (nVar.f43538f != 0 && nVar.f43539g != 0) {
                if (nVar.a(pixelFrame.getGLContext())) {
                    com.tencent.liteav.videobase.frame.d a10 = nVar.f43536d.a(nVar.f43538f, nVar.f43539g);
                    nVar.f43535c.a(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, a10);
                    nVar.f43534b.a(a10.a());
                    nVar.f43534b.b();
                    ByteBuffer b4 = j.b(nVar.f43538f * nVar.f43539g * 4);
                    if (b4 == null) {
                        LiteavLog.w(nVar.f43533a, "snapshotFromFrameBuffer, allocate direct buffer failed");
                        nVar.f43537e.onComplete(null);
                    } else {
                        b4.order(ByteOrder.nativeOrder());
                        b4.position(0);
                        OpenGlUtils.readPixels(0, 0, nVar.f43538f, nVar.f43539g, b4);
                        b4.position(0);
                        Bitmap createBitmap = Bitmap.createBitmap(nVar.f43538f, nVar.f43539g, Bitmap.Config.ARGB_8888);
                        createBitmap.copyPixelsFromBuffer(b4);
                        nVar.f43537e.onComplete(createBitmap);
                    }
                    nVar.f43537e = null;
                    OpenGlUtils.bindFramebuffer(36160, 0);
                    nVar.f43534b.c();
                    a10.release();
                    nVar.c();
                }
            } else {
                LiteavLog.w(nVar.f43533a, "snapshot when surface height or width is zero!");
            }
        }
        pixelFrame.release();
    }
}
