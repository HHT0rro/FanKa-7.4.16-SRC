package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l extends h<b> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends PixelFrame {

        /* renamed from: b, reason: collision with root package name */
        private static final g<a> f43471b = m.a();

        /* renamed from: a, reason: collision with root package name */
        private final b f43472a;

        public /* synthetic */ a(b bVar, Object obj, byte b4) {
            this(bVar, obj);
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setTextureId(int i10) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }

        private a(b bVar, Object obj) {
            super(f43471b);
            bVar.retain();
            this.mWidth = bVar.f43475c;
            this.mHeight = bVar.f43476d;
            this.f43472a = bVar;
            this.mTextureId = bVar.f43473a;
            this.mGLContext = obj;
            int i10 = bVar.f43474b;
            if (i10 == 3553) {
                this.mPixelBufferType = GLConstants.PixelBufferType.TEXTURE_2D;
            } else if (i10 == 36197) {
                this.mPixelBufferType = GLConstants.PixelBufferType.TEXTURE_OES;
            }
            this.mPixelFormatType = GLConstants.PixelFormatType.RGBA;
        }
    }

    @Override // com.tencent.liteav.videobase.frame.h
    public final /* synthetic */ b a(g<b> gVar) {
        return new b(gVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends d {

        /* renamed from: a, reason: collision with root package name */
        public int f43473a;

        /* renamed from: b, reason: collision with root package name */
        public int f43474b;

        /* renamed from: c, reason: collision with root package name */
        public int f43475c;

        /* renamed from: d, reason: collision with root package name */
        public int f43476d;

        /* renamed from: e, reason: collision with root package name */
        public FrameMetaData f43477e;

        /* renamed from: f, reason: collision with root package name */
        public ProducerChainTimestamp f43478f;

        /* renamed from: g, reason: collision with root package name */
        public ConsumerChainTimestamp f43479g;

        public b(g<? extends d> gVar) {
            super(gVar);
            this.f43473a = -1;
            this.f43474b = 3553;
            this.f43475c = 0;
            this.f43476d = 0;
        }

        public final void a(int i10, int i11, int i12, int i13) {
            this.f43474b = i10;
            this.f43473a = i11;
            this.f43475c = i12;
            this.f43476d = i13;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int b() {
            return this.f43475c;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int c() {
            return this.f43476d;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final FrameMetaData d() {
            return this.f43477e;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final ProducerChainTimestamp e() {
            return this.f43478f;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final ConsumerChainTimestamp f() {
            return this.f43479g;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final void g() {
            this.f43473a = -1;
            this.f43474b = 3553;
            this.f43475c = 0;
            this.f43476d = 0;
            this.f43477e = null;
            this.f43479g = null;
            this.f43478f = null;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final int a() {
            return this.f43473a;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final void a(FrameMetaData frameMetaData) {
            this.f43477e = frameMetaData;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final void a(ProducerChainTimestamp producerChainTimestamp) {
            this.f43478f = producerChainTimestamp;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final void a(ConsumerChainTimestamp consumerChainTimestamp) {
            this.f43479g = consumerChainTimestamp;
        }

        @Override // com.tencent.liteav.videobase.frame.d
        public final PixelFrame a(Object obj) {
            a aVar = new a(this, obj, (byte) 0);
            aVar.retain();
            return aVar;
        }
    }
}
