package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.a;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i extends com.tencent.liteav.videobase.frame.a<PixelFrame> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements a.InterfaceC0640a {

        /* renamed from: a, reason: collision with root package name */
        public final int f43452a;

        /* renamed from: b, reason: collision with root package name */
        public final int f43453b;

        /* renamed from: c, reason: collision with root package name */
        public final GLConstants.PixelBufferType f43454c;

        /* renamed from: d, reason: collision with root package name */
        public final GLConstants.PixelFormatType f43455d;

        public a(int i10, int i11, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
            this.f43452a = i10;
            this.f43453b = i11;
            this.f43454c = pixelBufferType;
            this.f43455d = pixelFormatType;
        }

        public final boolean equals(Object obj) {
            if (a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f43452a == aVar.f43452a && this.f43453b == aVar.f43453b && this.f43454c == aVar.f43454c && this.f43455d == aVar.f43455d;
        }

        public final int hashCode() {
            return (((((this.f43452a * 10001) + this.f43453b) << 2) + this.f43454c.ordinal()) << 2) + this.f43455d.ordinal();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends PixelFrame {
        public /* synthetic */ b(g gVar, int i10, int i11, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, byte b4) {
            this(gVar, i10, i11, pixelBufferType, pixelFormatType);
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setBuffer(ByteBuffer byteBuffer) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Buffer");
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setData(byte[] bArr) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its Data");
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setHeight(int i10) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its height");
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setPixelBufferType(GLConstants.PixelBufferType pixelBufferType) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its buffer type");
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setPixelFormatType(GLConstants.PixelFormatType pixelFormatType) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its format type");
        }

        @Override // com.tencent.liteav.videobase.frame.PixelFrame
        public final void setWidth(int i10) {
            throw new UnsupportedOperationException("Object is allocated by pool, can't change its width");
        }

        private b(g<PixelFrame> gVar, int i10, int i11, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
            super(gVar, i10, i11, pixelBufferType, pixelFormatType);
        }
    }

    public final PixelFrame a(int i10, int i11, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType) {
        PixelFrame pixelFrame = (PixelFrame) super.a(new a(i10, i11, pixelBufferType, pixelFormatType));
        pixelFrame.reset();
        return pixelFrame;
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final /* bridge */ /* synthetic */ void a(PixelFrame pixelFrame) {
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final /* synthetic */ a.InterfaceC0640a b(PixelFrame pixelFrame) {
        PixelFrame pixelFrame2 = pixelFrame;
        return new a(pixelFrame2.getWidth(), pixelFrame2.getHeight(), pixelFrame2.getPixelBufferType(), pixelFrame2.getPixelFormatType());
    }

    @Override // com.tencent.liteav.videobase.frame.a
    public final /* synthetic */ PixelFrame a(g<PixelFrame> gVar, a.InterfaceC0640a interfaceC0640a) {
        a aVar = (a) interfaceC0640a;
        return new b(gVar, aVar.f43452a, aVar.f43453b, aVar.f43454c, aVar.f43455d, (byte) 0);
    }
}
