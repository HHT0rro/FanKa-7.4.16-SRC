package com.bef.effectsdk.view;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.android.internal.logging.nano.MetricsProto;
import com.bef.effectsdk.AssetResourceFinder;
import com.bef.effectsdk.GLTextureView;
import com.bef.effectsdk.ResourceFinder;
import com.bef.effectsdk.message.MessageCenter;
import com.bef.effectsdk.view.ViewControllerInterface;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@h0.a
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BEFView extends GLTextureView implements GLSurfaceView.Renderer, ViewControllerInterface.NativeMessageListener, MessageCenter.a {

    /* renamed from: b, reason: collision with root package name */
    public long f10525b;

    /* renamed from: c, reason: collision with root package name */
    public String f10526c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10527d;

    /* renamed from: e, reason: collision with root package name */
    public int f10528e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f10529f;

    /* renamed from: g, reason: collision with root package name */
    public HashSet<m> f10530g;

    /* renamed from: h, reason: collision with root package name */
    public Queue<Runnable> f10531h;

    /* renamed from: i, reason: collision with root package name */
    public long f10532i;

    /* renamed from: j, reason: collision with root package name */
    public Builder.a f10533j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f10534k;

    /* renamed from: l, reason: collision with root package name */
    public float[] f10535l;

    /* renamed from: m, reason: collision with root package name */
    public float[] f10536m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10537n;

    /* renamed from: o, reason: collision with root package name */
    public long f10538o;

    /* renamed from: p, reason: collision with root package name */
    public long f10539p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10540q;

    /* renamed from: r, reason: collision with root package name */
    public AssetResourceFinder f10541r;

    @h0.a
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum BEFViewSceneKey {
        SHOOT,
        LIVE,
        LIVE_OGC,
        GAME,
        M10N
    }

    @h0.a
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum FitMode {
        FIT_WIDTH,
        FIT_HEIGHT,
        FILL_SCREEN,
        FIT_WIDTH_BOTTOM,
        NO_CLIP
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10556b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f10557c;

        public a(String str, String str2) {
            this.f10556b = str;
            this.f10557c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BEFView.this.getNativeInited()) {
                ViewControllerInterface.m(BEFView.this.f10525b, this.f10556b, this.f10557c);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10559b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f10560c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f10561d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f10562e;

        public b(String str, byte[] bArr, int i10, int i11) {
            this.f10559b = str;
            this.f10560c = bArr;
            this.f10561d = i10;
            this.f10562e = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BEFView.this.getNativeInited()) {
                ViewControllerInterface.n(BEFView.this.f10525b, this.f10559b, this.f10560c, this.f10561d, this.f10562e);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10564a;

        static {
            int[] iArr = new int[FitMode.values().length];
            f10564a = iArr;
            try {
                iArr[FitMode.FIT_WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10564a[FitMode.FIT_HEIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10564a[FitMode.FILL_SCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10564a[FitMode.NO_CLIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class d implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10565b;

        public d(String str) {
            this.f10565b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BEFView.this.getNativeInited()) {
                BEFView bEFView = BEFView.this;
                String str = this.f10565b;
                bEFView.f10526c = str;
                ViewControllerInterface.p(bEFView.f10525b, str);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f10567b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f10568c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f10569d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f10570e;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                ViewControllerInterface.i(BEFView.this.f10525b, eVar.f10567b, eVar.f10568c, eVar.f10569d, eVar.f10570e);
            }
        }

        public e(long j10, long j11, long j12, String str) {
            this.f10567b = j10;
            this.f10568c = j11;
            this.f10569d = j12;
            this.f10570e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            BEFView.this.f10531h.add(new a());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f10573b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float[] f10574c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float[] f10575d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f10576e;

        public f(int[] iArr, float[] fArr, float[] fArr2, int i10) {
            this.f10573b = iArr;
            this.f10574c = fArr;
            this.f10575d = fArr2;
            this.f10576e = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewControllerInterface.q(BEFView.this.f10525b, this.f10573b, this.f10574c, this.f10575d, this.f10576e);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class g implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f10578b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float[] f10579c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float[] f10580d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f10581e;

        public g(int[] iArr, float[] fArr, float[] fArr2, int i10) {
            this.f10578b = iArr;
            this.f10579c = fArr;
            this.f10580d = fArr2;
            this.f10581e = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewControllerInterface.s(BEFView.this.f10525b, this.f10578b, this.f10579c, this.f10580d, this.f10581e);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class h implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f10583b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float[] f10584c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float[] f10585d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f10586e;

        public h(int[] iArr, float[] fArr, float[] fArr2, int i10) {
            this.f10583b = iArr;
            this.f10584c = fArr;
            this.f10585d = fArr2;
            this.f10586e = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewControllerInterface.r(BEFView.this.f10525b, this.f10583b, this.f10584c, this.f10585d, this.f10586e);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BEFView.this.f10533j.f10548f != BEFViewSceneKey.GAME && !BEFView.this.f10533j.f10550h) {
                BEFView.this.g();
            } else {
                ViewControllerInterface.g(BEFView.this.f10525b);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!BEFView.this.getNativeInited()) {
                BEFView.this.j();
            } else {
                ViewControllerInterface.h(BEFView.this.f10525b);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BEFView.this.g();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class l implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10591b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f10592c;

        public l(String str, String str2) {
            this.f10591b = str;
            this.f10592c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BEFView.this.getNativeInited()) {
                ViewControllerInterface.l(BEFView.this.f10525b, this.f10591b, this.f10592c);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface m {
        void a(long j10, long j11, long j12, String str);
    }

    public /* synthetic */ BEFView(Context context, AttributeSet attributeSet, d dVar) {
        this(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(Builder.a aVar) {
        this.f10533j = aVar;
    }

    @h0.a
    public synchronized int addMessageListener(m mVar) {
        if (mVar == null) {
            return -1;
        }
        this.f10530g.add(mVar);
        return 0;
    }

    @h0.a
    public synchronized void attachEffect(long j10) {
        this.f10538o = j10;
    }

    public final void e(float[] fArr, float[] fArr2, int i10) {
        PointF h10;
        int width = getWidth();
        int height = getHeight();
        for (int i11 = 0; i11 < i10; i11++) {
            float f10 = fArr[i11];
            float f11 = fArr2[i11];
            PointF pointF = new PointF(f10, f11);
            float f12 = width;
            float f13 = height;
            RectF rectF = new RectF(0.0f, 0.0f, f12, f13);
            new PointF();
            FitMode fitMode = this.f10533j.f10546d;
            FitMode fitMode2 = FitMode.FILL_SCREEN;
            if (fitMode == fitMode2) {
                h10 = h(pointF, rectF, new RectF(0.0f, 0.0f, this.f10533j.f10543a, this.f10533j.f10544b), FitMode.NO_CLIP);
            } else if (this.f10533j.f10546d == FitMode.NO_CLIP) {
                h10 = h(pointF, rectF, new RectF(0.0f, 0.0f, this.f10533j.f10543a, this.f10533j.f10544b), fitMode2);
            } else if (this.f10533j.f10546d == FitMode.FIT_WIDTH_BOTTOM) {
                float f14 = ((f12 * 1.0f) / this.f10533j.f10543a) * this.f10533j.f10544b;
                fArr[i11] = (f10 * 1.0f) / f12;
                fArr2[i11] = ((f11 - (f13 - f14)) * 1.0f) / f14;
            } else {
                h10 = h(pointF, rectF, new RectF(0.0f, 0.0f, this.f10533j.f10543a, this.f10533j.f10544b), this.f10533j.f10546d);
            }
            fArr[i11] = h10.x / this.f10533j.f10543a;
            fArr2[i11] = h10.y / this.f10533j.f10544b;
        }
    }

    public final void f(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int i10 = pointerCount > 10 ? 10 : pointerCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f10534k[i11] = motionEvent.getPointerId(i11);
            this.f10535l[i11] = motionEvent.getX(i11);
            this.f10536m[i11] = motionEvent.getY(i11);
        }
        e(this.f10535l, this.f10536m, i10);
        int actionIndex = motionEvent.getActionIndex();
        if (this.f10537n || actionIndex == 0) {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int[] iArr = new int[i10];
                        float[] fArr = new float[i10];
                        float[] fArr2 = new float[i10];
                        for (int i12 = 0; i12 < i10; i12++) {
                            iArr[i12] = this.f10534k[i12];
                            fArr[i12] = this.f10535l[i12];
                            fArr2[i12] = this.f10536m[i12];
                        }
                        queueEvent(new g(iArr, fArr, fArr2, i10));
                        return;
                    }
                    if (action != 5) {
                        if (action != 6) {
                            return;
                        }
                    }
                }
                queueEvent(new h(new int[]{this.f10534k[actionIndex]}, new float[]{this.f10535l[actionIndex]}, new float[]{this.f10536m[actionIndex]}, i10));
                return;
            }
            queueEvent(new f(new int[]{this.f10534k[actionIndex]}, new float[]{this.f10535l[actionIndex]}, new float[]{this.f10536m[actionIndex]}, i10));
        }
    }

    public final void g() {
        if (getNativeInited()) {
            setNativeInited(false);
            if (this.f10533j.f10547e != null) {
                this.f10533j.f10547e.release(this.f10525b);
            }
            AssetResourceFinder assetResourceFinder = this.f10541r;
            if (assetResourceFinder != null) {
                assetResourceFinder.release(0L);
            }
            ViewControllerInterface.k(this.f10525b, this);
            ViewControllerInterface.e(this.f10525b);
            this.f10525b = 0L;
            ViewControllerInterface.d(this.f10528e);
            this.f10528e = 0;
            MessageCenter.f(this);
            MessageCenter.c();
            this.f10539p = 0L;
        }
    }

    @h0.a
    public boolean getNativeInited() {
        return this.f10527d;
    }

    public final PointF h(PointF pointF, RectF rectF, RectF rectF2, FitMode fitMode) {
        PointF pointF2 = new PointF();
        float f10 = rectF2.left;
        float f11 = rectF2.top;
        float width = rectF2.width();
        float height = rectF2.height();
        float width2 = (pointF.x - rectF.left) / rectF.width();
        float height2 = (pointF.y - rectF.top) / rectF.height();
        int i10 = c.f10564a[fitMode.ordinal()];
        if (i10 == 1) {
            float width3 = width / rectF.width();
            pointF2.x = (int) (f10 + (width2 * width));
            pointF2.y = (int) (f11 + ((height - (rectF.height() * width3)) / 2.0f) + (height2 * width3 * rectF.height()));
        } else if (i10 == 2) {
            float height3 = height / rectF.height();
            pointF2.x = (int) (f10 + ((width - (rectF.width() * height3)) / 2.0f) + (width2 * height3 * rectF.width()));
            pointF2.y = (int) (f11 + (height2 * height));
        } else {
            if (i10 == 3) {
                if (width / rectF.width() < height / rectF.height()) {
                    return h(pointF, rectF, rectF2, FitMode.FIT_HEIGHT);
                }
                return h(pointF, rectF, rectF2, FitMode.FIT_WIDTH);
            }
            if (i10 == 4) {
                if (width / rectF.width() > height / rectF.height()) {
                    return h(pointF, rectF, rectF2, FitMode.FIT_HEIGHT);
                }
                return h(pointF, rectF, rectF2, FitMode.FIT_WIDTH);
            }
        }
        return pointF2;
    }

    public final void i(Context context) {
        setPreserveEGLContextOnPause(true);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        setRenderMode(1);
        this.f10530g = new HashSet<>();
        this.f10531h = new LinkedList();
        AssetResourceFinder assetResourceFinder = new AssetResourceFinder(context.getAssets(), "");
        this.f10541r = assetResourceFinder;
        assetResourceFinder.createNativeResourceFinder(0L);
        this.f10540q = false;
    }

    public final void j() {
        setNativeInited(false);
        long j10 = this.f10525b;
        if (j10 != 0) {
            try {
                ViewControllerInterface.e(j10);
                this.f10525b = 0L;
            } catch (Exception unused) {
            }
        }
        int i10 = this.f10528e;
        if (i10 > 0) {
            ViewControllerInterface.d(i10);
        }
        if (this.f10525b == 0) {
            long[] jArr = new long[2];
            ViewControllerInterface.c(jArr, this.f10533j.f10548f.ordinal());
            this.f10525b = jArr[0];
            if (this.f10533j.f10547e != null) {
                ViewControllerInterface.o(this.f10525b, this.f10533j.f10547e.createNativeResourceFinder(this.f10525b), 0L);
            } else {
                ViewControllerInterface.o(this.f10525b, 0L, 0L);
            }
            ViewControllerInterface.f(this.f10525b, this.f10533j.f10543a, this.f10533j.f10544b);
        }
        ViewControllerInterface.a(this.f10525b, this);
        MessageCenter.e();
        MessageCenter.b(this);
        this.f10532i = System.nanoTime();
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        int[] iArr3 = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glTexImage2D(3553, 0, 6408, this.f10533j.f10543a, this.f10533j.f10544b, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        GLES20.glGetIntegerv(36006, iArr3, 0);
        GLES20.glGenFramebuffers(1, iArr2, 0);
        GLES20.glBindFramebuffer(36160, iArr2[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr[0], 0);
        GLES20.glViewport(0, 0, this.f10533j.f10543a, this.f10533j.f10544b);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glBindFramebuffer(36160, iArr3[0]);
        GLES20.glDeleteFramebuffers(1, iArr2, 0);
        this.f10528e = iArr[0];
        String str = this.f10526c;
        if (str != "") {
            ViewControllerInterface.p(this.f10525b, str);
        }
        this.f10539p = 0L;
        setNativeInited(true);
    }

    @h0.a
    public synchronized int nativeOnMsgReceived(long j10, long j11, long j12, String str) {
        Iterator<m> iterator2 = this.f10530g.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(j10, j11, j12, str);
        }
        return 0;
    }

    @Override // com.bef.effectsdk.GLTextureView
    public void onDestroy() {
        if (this.f10540q) {
            return;
        }
        queueEvent(new k());
        super.onDestroy();
        this.f10540q = true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (getNativeInited()) {
            if (this.f10538o != this.f10539p) {
                ViewControllerInterface.b(this.f10525b, this.f10538o);
                this.f10539p = this.f10538o;
            }
            long nanoTime = System.nanoTime() - this.f10532i;
            double d10 = (1.0d / this.f10533j.f10545c) * 1.0E9d;
            double d11 = nanoTime;
            if (d11 < d10) {
                try {
                    Thread.sleep((long) (((d10 - d11) * 1.0d) / 1000000.0d));
                } catch (Exception unused) {
                }
            }
            this.f10532i = System.nanoTime();
            while (!this.f10531h.isEmpty()) {
                this.f10531h.poll().run();
            }
            double nanoTime2 = System.nanoTime() / 1.0E9d;
            int width = getWidth();
            int height = getHeight();
            Matrix.setIdentityM(this.f10529f, 0);
            RectF rectF = new RectF(0.0f, 0.0f, this.f10533j.f10543a, this.f10533j.f10544b);
            float f10 = width;
            RectF rectF2 = new RectF(0.0f, 0.0f, f10, height);
            PointF h10 = h(new PointF(0.0f, 0.0f), rectF, rectF2, this.f10533j.f10546d);
            PointF h11 = h(new PointF(this.f10533j.f10543a, this.f10533j.f10544b), rectF, rectF2, this.f10533j.f10546d);
            if (this.f10533j.f10546d == FitMode.FIT_WIDTH_BOTTOM) {
                h10 = new PointF(0.0f, 0.0f);
                h11 = new PointF(f10, (this.f10533j.f10544b * width) / this.f10533j.f10543a);
            }
            float f11 = h10.x;
            float f12 = h10.y;
            ViewControllerInterface.j(this.f10525b, this.f10528e, this.f10533j.f10543a, this.f10533j.f10544b, this.f10529f, new float[]{f11, f12, h11.x - f11, h11.y - f12}, nanoTime2);
        }
    }

    @Override // com.bef.effectsdk.GLTextureView
    public void onExitContext() {
        g();
    }

    @Override // com.bef.effectsdk.message.MessageCenter.a
    public void onMessageReceived(int i10, int i11, int i12, String str) {
        postMessage(i10, i11, i12, str);
    }

    @Override // com.bef.effectsdk.GLTextureView
    public void onPause() {
        if (this.f10540q) {
            return;
        }
        queueEvent(new i());
        super.onPause();
    }

    @Override // com.bef.effectsdk.GLTextureView
    public void onResume() {
        if (this.f10540q) {
            return;
        }
        super.onResume();
        queueEvent(new j());
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i10, int i11) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        j();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!getNativeInited() || this.f10526c == "" || this.f10533j.f10549g) {
            return false;
        }
        f(motionEvent);
        ((ViewGroup) getParent()).requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @h0.a
    public synchronized int postMessage(long j10, long j11, long j12, String str) {
        queueEvent(new e(j10, j11, j12, str));
        return 0;
    }

    @h0.a
    public synchronized int removeMessageListener(m mVar) {
        if (mVar == null) {
            return -1;
        }
        this.f10530g.remove(mVar);
        return 0;
    }

    @h0.a
    public synchronized boolean setExternalTouchEvent(MotionEvent motionEvent) {
        if (getNativeInited() && this.f10526c != "") {
            f(motionEvent);
            return true;
        }
        return false;
    }

    public void setNativeInited(boolean z10) {
        this.f10527d = z10;
    }

    @h0.a
    public synchronized void setRenderCacheData(String str, String str2) {
        queueEvent(new l(str, str2));
    }

    @h0.a
    public synchronized void setRenderCacheTexture(String str, String str2) {
        queueEvent(new a(str, str2));
    }

    @h0.a
    public synchronized void setRenderCacheTextureWithBuffer(String str, byte[] bArr, int i10, int i11) {
        queueEvent(new b(str, bArr, i10, i11));
    }

    @h0.a
    public synchronized void setStickerPath(String str) {
        queueEvent(new d(str));
    }

    @h0.a
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public a f10542a = new a(this, null);

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            public int f10543a;

            /* renamed from: b, reason: collision with root package name */
            public int f10544b;

            /* renamed from: c, reason: collision with root package name */
            public double f10545c;

            /* renamed from: d, reason: collision with root package name */
            public FitMode f10546d;

            /* renamed from: e, reason: collision with root package name */
            public ResourceFinder f10547e;

            /* renamed from: f, reason: collision with root package name */
            public BEFViewSceneKey f10548f;

            /* renamed from: g, reason: collision with root package name */
            public boolean f10549g;

            /* renamed from: h, reason: collision with root package name */
            public boolean f10550h;

            public a() {
            }

            public /* synthetic */ a(Builder builder, d dVar) {
                this();
            }
        }

        @h0.a
        public static Builder obtain() {
            Builder builder = new Builder();
            builder.f10542a.f10543a = MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH;
            builder.f10542a.f10544b = 1280;
            builder.f10542a.f10545c = 30.0d;
            builder.f10542a.f10546d = FitMode.FILL_SCREEN;
            builder.f10542a.f10547e = null;
            builder.f10542a.f10548f = BEFViewSceneKey.SHOOT;
            builder.f10542a.f10549g = false;
            builder.f10542a.f10550h = false;
            return builder;
        }

        @h0.a
        public BEFView build(Context context) {
            BEFView bEFView = new BEFView(context, (d) null);
            bEFView.setParams(this.f10542a);
            return bEFView;
        }

        @h0.a
        public Builder setFPS(double d10) {
            this.f10542a.f10545c = d10;
            return this;
        }

        @h0.a
        public Builder setFitMode(FitMode fitMode) {
            this.f10542a.f10546d = fitMode;
            return this;
        }

        @h0.a
        public Builder setKeepStatusAtPause(boolean z10) {
            this.f10542a.f10550h = z10;
            return this;
        }

        @h0.a
        public Builder setNeglectTouchEvent(boolean z10) {
            this.f10542a.f10549g = z10;
            return this;
        }

        @h0.a
        public Builder setRenderSize(int i10, int i11) {
            this.f10542a.f10543a = i10;
            this.f10542a.f10544b = i11;
            return this;
        }

        @h0.a
        public Builder setResourceFinder(ResourceFinder resourceFinder) {
            this.f10542a.f10547e = resourceFinder;
            return this;
        }

        @h0.a
        public Builder setSceneKey(BEFViewSceneKey bEFViewSceneKey) {
            this.f10542a.f10548f = bEFViewSceneKey;
            return this;
        }

        @h0.a
        public BEFView build(Context context, AttributeSet attributeSet) {
            BEFView bEFView = new BEFView(context, attributeSet, null);
            bEFView.setParams(this.f10542a);
            return bEFView;
        }
    }

    @h0.a
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Color {

        /* renamed from: a, reason: collision with root package name */
        public float f10552a;

        /* renamed from: b, reason: collision with root package name */
        public float f10553b;

        /* renamed from: c, reason: collision with root package name */
        public float f10554c;

        /* renamed from: d, reason: collision with root package name */
        public float f10555d;

        @h0.a
        public Color() {
            setColor(0.0f, 0.0f, 0.0f, 0.0f);
        }

        @h0.a
        public float alpha() {
            return this.f10555d;
        }

        @h0.a
        public float blue() {
            return this.f10554c;
        }

        @h0.a
        public float green() {
            return this.f10553b;
        }

        @h0.a
        public float red() {
            return this.f10552a;
        }

        @h0.a
        public void setColor(float f10, float f11, float f12, float f13) {
            this.f10552a = f10;
            this.f10553b = f11;
            this.f10554c = f12;
            this.f10555d = f13;
        }

        @h0.a
        public Color(float f10, float f11, float f12, float f13) {
            setColor(f10, f11, f12, f13);
        }
    }

    public /* synthetic */ BEFView(Context context, d dVar) {
        this(context);
    }

    public BEFView(Context context) {
        super(context);
        this.f10525b = 0L;
        this.f10526c = "";
        this.f10527d = false;
        this.f10529f = new float[16];
        this.f10534k = new int[10];
        this.f10535l = new float[10];
        this.f10536m = new float[10];
        this.f10537n = true;
        this.f10538o = 0L;
        this.f10539p = 0L;
        this.f10540q = false;
        this.f10541r = null;
        i(context);
    }

    public BEFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10525b = 0L;
        this.f10526c = "";
        this.f10527d = false;
        this.f10529f = new float[16];
        this.f10534k = new int[10];
        this.f10535l = new float[10];
        this.f10536m = new float[10];
        this.f10537n = true;
        this.f10538o = 0L;
        this.f10539p = 0L;
        this.f10540q = false;
        this.f10541r = null;
        i(context);
    }
}
