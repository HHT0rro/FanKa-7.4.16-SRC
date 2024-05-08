package com.tencent.liteav.beauty.b;

import android.content.Context;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.beauty.a.a;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a, reason: collision with root package name */
    public GLConstants.GLScaleType f43029a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f43030b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f43031c;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.liteav.videobase.frame.j f43033e;

    /* renamed from: f, reason: collision with root package name */
    private d f43034f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.liteav.beauty.a.a f43036h;

    /* renamed from: d, reason: collision with root package name */
    private final PixelFrame f43032d = new PixelFrame();

    /* renamed from: g, reason: collision with root package name */
    private boolean f43035g = false;

    /* renamed from: i, reason: collision with root package name */
    private a f43037i = null;

    /* renamed from: j, reason: collision with root package name */
    private a.InterfaceC0638a f43038j = new a.InterfaceC0638a() { // from class: com.tencent.liteav.beauty.b.h.1
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
    }

    public h(Context context) {
        this.f43031c = context;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onDraw(int i10, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int a10;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            if (this.f43032d.getTextureId() == -1) {
                super.onDraw(i10, dVar, floatBuffer, floatBuffer2);
                return;
            }
            com.tencent.liteav.videobase.frame.e eVar = this.mTexturePool;
            Size size = this.mOutputSize;
            com.tencent.liteav.videobase.frame.d a11 = eVar.a(size.width, size.height);
            if (this.f43033e == null) {
                Size size2 = this.mOutputSize;
                this.f43033e = new com.tencent.liteav.videobase.frame.j(size2.width, size2.height);
            }
            if (!this.f43032d.hasTransformParams() && this.f43032d.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D && this.f43032d.getPixelFormatType() == GLConstants.PixelFormatType.RGBA) {
                a10 = this.f43032d.getTextureId();
            } else {
                this.f43033e.a(this.f43032d, this.f43029a, a11);
                a10 = a11.a();
            }
            d dVar2 = this.f43034f;
            dVar2.setFloatOnDraw(dVar2.f43004a, this.f43030b ? 1.0f : 0.0f);
            this.f43034f.a("inputImageTexture2", i10);
            this.f43034f.a("inputImageTexture3", a10);
            this.f43034f.onDraw(i10, dVar, floatBuffer, floatBuffer2);
            a11.release();
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        d dVar = new d();
        this.f43034f = dVar;
        dVar.initialize(eVar);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i10, int i11) {
        super.onOutputSizeChanged(i10, i11);
        this.f43034f.onOutputSizeChanged(i10, i11);
        com.tencent.liteav.videobase.frame.j jVar = this.f43033e;
        if (jVar != null) {
            jVar.a();
            this.f43033e = null;
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        com.tencent.liteav.beauty.a.a aVar = this.f43036h;
        if (aVar != null) {
            aVar.f42932c = null;
            aVar.f42931b = true;
            Thread thread = aVar.f42930a;
            if (thread != null) {
                thread.interrupt();
                aVar.f42930a = null;
            }
            this.f43036h = null;
        }
        d dVar = this.f43034f;
        if (dVar != null) {
            dVar.uninitialize();
            this.f43034f = null;
        }
        com.tencent.liteav.videobase.frame.j jVar = this.f43033e;
        if (jVar != null) {
            jVar.a();
            this.f43033e = null;
        }
        super.onUninit();
    }
}
