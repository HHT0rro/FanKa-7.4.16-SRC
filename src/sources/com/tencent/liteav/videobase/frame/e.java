package com.tencent.liteav.videobase.frame;

import androidx.annotation.NonNull;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.a;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends com.tencent.liteav.videobase.frame.a<d> {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f43435a = new AtomicInteger();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends d {

        /* renamed from: a, reason: collision with root package name */
        public int f43436a;

        /* renamed from: b, reason: collision with root package name */
        public final int f43437b;

        /* renamed from: c, reason: collision with root package name */
        public final int f43438c;

        /* renamed from: d, reason: collision with root package name */
        private FrameMetaData f43439d;

        /* renamed from: e, reason: collision with root package name */
        private ProducerChainTimestamp f43440e;

        /* renamed from: f, reason: collision with root package name */
        private ConsumerChainTimestamp f43441f;

        public /* synthetic */ a(g gVar, int i10, int i11, byte b4) {
            this(gVar, i10, i11);
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int a() {
            return this.f43436a;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int b() {
            return this.f43437b;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int c() {
            return this.f43438c;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final FrameMetaData d() {
            return this.f43439d;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final ProducerChainTimestamp e() {
            return this.f43440e;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final ConsumerChainTimestamp f() {
            return this.f43441f;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final void g() {
            this.f43439d = null;
            this.f43440e = null;
            this.f43441f = null;
        }

        @Override // com.tencent.liteav.videobase.frame.k
        public final void release() {
            super.release();
        }

        private a(g<d> gVar, int i10, int i11) {
            super(gVar);
            this.f43436a = -1;
            this.f43437b = i10;
            this.f43438c = i11;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final void a(FrameMetaData frameMetaData) {
            this.f43439d = frameMetaData;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final void a(ProducerChainTimestamp producerChainTimestamp) {
            this.f43440e = producerChainTimestamp;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final void a(ConsumerChainTimestamp consumerChainTimestamp) {
            this.f43441f = consumerChainTimestamp;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final PixelFrame a(Object obj) {
            b bVar = new b(this, obj, (byte) 0);
            bVar.retain();
            return bVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends PixelFrame {

        /* renamed from: b, reason: collision with root package name */
        private static final g<b> f43442b = f.a();

        /* renamed from: a, reason: collision with root package name */
        private final d f43443a;

        public /* synthetic */ b(d dVar, Object obj, byte b4) {
            this(dVar, obj);
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setTextureId(int i10) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }

        private b(d dVar, Object obj) {
            super(f43442b);
            dVar.retain();
            this.mWidth = dVar.b();
            this.mHeight = dVar.c();
            this.f43443a = dVar;
            this.mTextureId = dVar.a();
            this.mGLContext = obj;
            this.mPixelBufferType = GLConstants.PixelBufferType.TEXTURE_2D;
            this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
            this.mMetaData = dVar.d();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c implements a.InterfaceC0640a {

        /* renamed from: a, reason: collision with root package name */
        public final int f43444a;

        /* renamed from: b, reason: collision with root package name */
        public final int f43445b;

        public c(int i10, int i11) {
            this.f43444a = i10;
            this.f43445b = i11;
        }

        public final boolean equals(Object obj) {
            if (obj.getClass() != c.class) {
                return false;
            }
            c cVar = (c) obj;
            return this.f43444a == cVar.f43444a && this.f43445b == cVar.f43445b;
        }

        public final int hashCode() {
            return (this.f43444a * 37213) + this.f43445b;
        }
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final /* synthetic */ void a(d dVar) {
        a aVar = (a) dVar;
        OpenGlUtils.deleteTexture(aVar.f43436a);
        aVar.f43436a = -1;
        f43435a.getAndDecrement();
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final /* synthetic */ a.InterfaceC0640a b(d dVar) {
        d dVar2 = dVar;
        return new c(dVar2.b(), dVar2.c());
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final void b() {
        super.b();
    }

    @NonNull
    public final d a(int i10, int i11) {
        d dVar = (d) super.a(new c(i10, i11));
        dVar.g();
        return dVar;
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final void a() {
        super.a();
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final /* synthetic */ d a(g<d> gVar, a.InterfaceC0640a interfaceC0640a) {
        c cVar = (c) interfaceC0640a;
        a aVar = new a(gVar, cVar.f43444a, cVar.f43445b, (byte) 0);
        aVar.f43436a = OpenGlUtils.createTexture(aVar.f43437b, aVar.f43438c, 6408, 6408);
        f43435a.incrementAndGet();
        return aVar;
    }
}
