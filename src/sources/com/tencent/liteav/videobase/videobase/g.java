package com.tencent.liteav.videobase.videobase;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.j;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.YUVReadTools;
import com.tencent.liteav.videobase.videobase.d;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final GLConstants.PixelFormatType[] f43567a = {GLConstants.PixelFormatType.I420, GLConstants.PixelFormatType.NV21, GLConstants.PixelFormatType.NV12};

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.liteav.videobase.videobase.a f43570d;

    /* renamed from: g, reason: collision with root package name */
    public j f43573g;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.liteav.videobase.frame.i f43575i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.liteav.videobase.frame.e f43576j;

    /* renamed from: k, reason: collision with root package name */
    private int f43577k = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f43574h = false;

    /* renamed from: b, reason: collision with root package name */
    public final FloatBuffer f43568b = OpenGlUtils.createNormalCubeVerticesBuffer();

    /* renamed from: c, reason: collision with root package name */
    public final FloatBuffer f43569c = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    /* renamed from: e, reason: collision with root package name */
    public final Map<GLConstants.PixelFormatType, List<a>> f43571e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final Map<GLConstants.PixelFormatType, com.tencent.liteav.videobase.a.b> f43572f = new HashMap();

    /* renamed from: com.tencent.liteav.videobase.videobase.g$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43578a;

        static {
            int[] iArr = new int[GLConstants.PixelFormatType.values().length];
            f43578a = iArr;
            try {
                iArr[GLConstants.PixelFormatType.I420.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43578a[GLConstants.PixelFormatType.NV12.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43578a[GLConstants.PixelFormatType.NV21.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final GLConstants.PixelBufferType f43579a;

        /* renamed from: b, reason: collision with root package name */
        public final int f43580b;

        /* renamed from: c, reason: collision with root package name */
        public final d.a f43581c;

        public a(GLConstants.PixelBufferType pixelBufferType, int i10, d.a aVar) {
            this.f43579a = pixelBufferType;
            this.f43580b = i10;
            this.f43581c = aVar;
        }
    }

    public g(com.tencent.liteav.videobase.videobase.a aVar) {
        this.f43570d = aVar;
    }

    public final void a(com.tencent.liteav.videobase.frame.e eVar) {
        if (!this.f43574h && eVar != null) {
            this.f43574h = true;
            this.f43575i = new com.tencent.liteav.videobase.frame.i();
            this.f43576j = eVar;
        } else {
            LiteavLog.i("SameParamsConverter", "SameParamsConverter mIsInitialized " + this.f43574h + " , texturePool " + ((Object) eVar));
        }
    }

    public final void a() {
        Iterator<com.tencent.liteav.videobase.a.b> iterator2 = this.f43572f.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().uninitialize();
        }
        this.f43572f.clear();
        j jVar = this.f43573g;
        if (jVar != null) {
            jVar.a();
            this.f43573g = null;
        }
        com.tencent.liteav.videobase.frame.i iVar = this.f43575i;
        if (iVar != null) {
            iVar.b();
            this.f43575i = null;
        }
        OpenGlUtils.deleteFrameBuffer(this.f43577k);
        this.f43577k = -1;
        this.f43574h = false;
    }

    public final PixelFrame a(long j10, com.tencent.liteav.videobase.frame.d dVar, GLConstants.PixelFormatType pixelFormatType) {
        GLConstants.PixelBufferType pixelBufferType = GLConstants.PixelBufferType.BYTE_BUFFER;
        int a10 = a(pixelFormatType, pixelBufferType);
        GLConstants.PixelBufferType pixelBufferType2 = GLConstants.PixelBufferType.BYTE_ARRAY;
        int a11 = a(pixelFormatType, pixelBufferType2);
        if (a10 == 0 && a11 == 0) {
            return null;
        }
        boolean z10 = a10 != 0;
        com.tencent.liteav.videobase.frame.i iVar = this.f43575i;
        int b4 = dVar.b();
        int c4 = dVar.c();
        if (!z10) {
            pixelBufferType = pixelBufferType2;
        }
        PixelFrame a12 = iVar.a(b4, c4, pixelBufferType, pixelFormatType);
        if (!a12.isFrameDataValid()) {
            a12.release();
            return null;
        }
        a(pixelFormatType, dVar, z10 ? a12.getBuffer() : a12.getData());
        a12.setMetaData(dVar.d());
        a12.setProducerChainTimestamp(dVar.e());
        a12.setConsumerChainTimestamp(dVar.f());
        a(a12, j10);
        a(j10, a12, a10, a11);
        return a12;
    }

    public final void a(long j10, PixelFrame pixelFrame, int i10, int i11) {
        GLConstants.PixelBufferType pixelBufferType = pixelFrame.getPixelBufferType();
        GLConstants.PixelBufferType pixelBufferType2 = GLConstants.PixelBufferType.BYTE_BUFFER;
        boolean z10 = pixelBufferType == pixelBufferType2 && i11 != 0;
        GLConstants.PixelBufferType pixelBufferType3 = pixelFrame.getPixelBufferType();
        GLConstants.PixelBufferType pixelBufferType4 = GLConstants.PixelBufferType.BYTE_ARRAY;
        boolean z11 = pixelBufferType3 == pixelBufferType4 && i10 != 0;
        if (z10 || z11) {
            com.tencent.liteav.videobase.frame.i iVar = this.f43575i;
            int width = pixelFrame.getWidth();
            int height = pixelFrame.getHeight();
            if (z10) {
                pixelBufferType2 = pixelBufferType4;
            }
            PixelFrame a10 = iVar.a(width, height, pixelBufferType2, pixelFrame.getPixelFormatType());
            if (!a10.isFrameDataValid()) {
                a10.release();
                return;
            }
            if (z10) {
                OpenGlUtils.nativeCopyDataFromByteBufferToByteArray(pixelFrame.getBuffer(), a10.getData(), a10.getData().length);
            } else {
                OpenGlUtils.nativeCopyDataFromByteArrayToByteBuffer(pixelFrame.getData(), a10.getBuffer(), pixelFrame.getData().length);
            }
            a(a10, j10);
            a10.release();
        }
    }

    private void a(GLConstants.PixelFormatType pixelFormatType, com.tencent.liteav.videobase.frame.d dVar, Object obj) {
        com.tencent.liteav.videobase.videobase.a aVar = this.f43570d;
        int i10 = aVar.f43558a;
        int i11 = aVar.f43559b;
        if (this.f43577k == -1) {
            this.f43577k = OpenGlUtils.generateFrameBufferId();
        }
        OpenGlUtils.attachTextureToFrameBuffer(dVar.a(), this.f43577k);
        GLES20.glBindFramebuffer(36160, this.f43577k);
        if (pixelFormatType == GLConstants.PixelFormatType.RGBA) {
            OpenGlUtils.readPixels(0, 0, i10, i11, obj);
            OpenGlUtils.detachTextureFromFrameBuffer(this.f43577k);
            return;
        }
        if (i11 % 16 == 0) {
            OpenGlUtils.readPixels(0, 0, i10, (i11 * 3) / 8, obj);
        } else if (obj instanceof ByteBuffer) {
            YUVReadTools.nativeReadYUVPlanesForByteBuffer(i10, i11, (ByteBuffer) obj);
        } else {
            YUVReadTools.nativeReadYUVPlanesForByteArray(i10, i11, (byte[]) obj);
        }
        OpenGlUtils.detachTextureFromFrameBuffer(this.f43577k);
    }

    public final void a(PixelFrame pixelFrame, long j10) {
        List<a> list = this.f43571e.get(pixelFrame.getPixelFormatType());
        if (list == null || list.isEmpty()) {
            return;
        }
        pixelFrame.setTimestamp(j10);
        for (a aVar : new ArrayList(list)) {
            if (aVar.f43579a == pixelFrame.getPixelBufferType()) {
                aVar.f43581c.a(aVar.f43580b, pixelFrame);
            }
        }
    }

    public final int a(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType) {
        List<a> list = this.f43571e.get(pixelFormatType);
        int i10 = 0;
        if (list != null) {
            Iterator<a> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (iterator2.next().f43579a == pixelBufferType) {
                    i10++;
                }
            }
        }
        return i10;
    }

    public final void a(int i10, d.a aVar) {
        for (Map.Entry<GLConstants.PixelFormatType, List<a>> entry : this.f43571e.entrySet()) {
            Iterator<a> iterator2 = entry.getValue().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                a next = iterator2.next();
                if (next.f43580b == i10 && next.f43581c == aVar) {
                    entry.getValue().remove(next);
                    break;
                }
            }
            if (entry.getValue().isEmpty()) {
                this.f43571e.remove(entry.getKey());
                return;
            }
        }
    }
}
