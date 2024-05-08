package com.tencent.cloud.huiyansdkface.a.g;

import android.content.Context;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.a.a.a.d;
import com.tencent.cloud.huiyansdkface.a.g.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends FrameLayout implements b {

    /* renamed from: a, reason: collision with root package name */
    public a f40436a;

    /* renamed from: b, reason: collision with root package name */
    public View f40437b;

    /* renamed from: c, reason: collision with root package name */
    private CountDownLatch f40438c;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceView f40439d;

    /* renamed from: e, reason: collision with root package name */
    private volatile SurfaceHolder f40440e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f40441f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.c f40442g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.e.b f40443h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f40444i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c f40445j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f40446k;

    /* renamed from: com.tencent.cloud.huiyansdkface.a.g.c$4, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40450a;

        static {
            int[] iArr = new int[com.tencent.cloud.huiyansdkface.a.a.a.c.values().length];
            f40450a = iArr;
            try {
                iArr[com.tencent.cloud.huiyansdkface.a.a.a.c.CROP_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40450a[com.tencent.cloud.huiyansdkface.a.a.a.c.CROP_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40450a[com.tencent.cloud.huiyansdkface.a.a.a.c.CROP_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40450a[com.tencent.cloud.huiyansdkface.a.a.a.c.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40450a[com.tencent.cloud.huiyansdkface.a.a.a.c.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40450a[com.tencent.cloud.huiyansdkface.a.a.a.c.FIT_CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public c(Context context) {
        super(context);
        this.f40438c = new CountDownLatch(1);
        this.f40441f = false;
        this.f40446k = false;
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.cloud.huiyansdkface.a.c cVar, Object obj) {
        if (cVar != null) {
            cVar.a(obj);
        }
    }

    private void b(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i10;
        int i11;
        int i12;
        int width = getWidth();
        int height = getHeight();
        d dVar = new d(width, height);
        d b4 = this.f40443h.b();
        if (b()) {
            b4 = new d(b4.f40296b, b4.f40295a);
        }
        d a10 = this.f40442g.name().startsWith("FIT") ? com.tencent.cloud.huiyansdkface.a.f.b.a(b4, dVar) : com.tencent.cloud.huiyansdkface.a.f.b.b(b4, dVar);
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "container layout size:width=" + width + ",height=" + height, new Object[0]);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("preview size scale result:");
        sb2.append((Object) a10);
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", sb2.toString(), new Object[0]);
        int i13 = (a10.f40295a - width) / 2;
        int i14 = (a10.f40296b - height) / 2;
        switch (AnonymousClass4.f40450a[this.f40442g.ordinal()]) {
            case 1:
            case 6:
                i10 = -i13;
                i11 = -i14;
                i12 = width + i13;
                height += i14;
                break;
            case 2:
            case 4:
                i10 = -i13;
                i12 = width + i13;
                height += i14 * 2;
                i11 = 0;
                break;
            case 3:
            case 5:
                i10 = -i13;
                i11 = i14 * (-2);
                i12 = width + i13;
                break;
            default:
                i12 = 0;
                height = 0;
                i10 = 0;
                i11 = 0;
                break;
        }
        this.f40444i = new Rect(i10, i11, i12, height);
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "we camera view child rect size:" + this.f40444i.toShortString(), new Object[0]);
    }

    private boolean e() {
        if (this.f40438c.getCount() == 0 && this.f40440e == null) {
            com.tencent.cloud.huiyansdkface.a.d.a.c("CameraSurfaceView", "surfaceHolder==null and countDownLatch==0", new Object[0]);
            return true;
        }
        try {
            com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "attachCameraView:wait for surface create", new Object[0]);
            this.f40438c.await(1L, TimeUnit.SECONDS);
            return false;
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public SurfaceView a(Context context) {
        return new SurfaceView(context);
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.b
    public void a() {
        this.f40446k = true;
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "startPreview now and request layout", new Object[0]);
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.b
    public void a(com.tencent.cloud.huiyansdkface.a.a.a.c cVar, com.tencent.cloud.huiyansdkface.a.e.b bVar) {
        this.f40442g = cVar;
        this.f40443h = bVar;
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "setPreviewConfig", new Object[0]);
        c();
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.b
    public void a(com.tencent.cloud.huiyansdkface.a.c cVar) {
        this.f40445j = cVar;
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f40436a = aVar;
            this.f40437b = aVar.a(getContext());
            this.f40436a.a(new a.InterfaceC0616a() { // from class: com.tencent.cloud.huiyansdkface.a.g.c.1
                @Override // com.tencent.cloud.huiyansdkface.a.g.a.InterfaceC0616a
                public void a() {
                    com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "onPreviewCreated", new Object[0]);
                    c.this.f40441f = true;
                    c.this.f40438c.countDown();
                }

                @Override // com.tencent.cloud.huiyansdkface.a.g.a.InterfaceC0616a
                public void b() {
                    com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "onPreviewDestroy", new Object[0]);
                    c.this.f40442g = null;
                    com.tencent.cloud.huiyansdkface.a.c cVar = c.this.f40445j;
                    if (cVar != null) {
                        cVar.d();
                    }
                }
            });
            addView(this.f40437b, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        this.f40439d = a(getContext());
        if (this.f40440e != null) {
            com.tencent.cloud.huiyansdkface.a.d.a.c("CameraSurfaceView", "surfaceHolder already created", new Object[0]);
        } else {
            this.f40439d.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.tencent.cloud.huiyansdkface.a.g.c.2
                @Override // android.view.SurfaceHolder.Callback
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("surfaceChanged:");
                    sb2.append(surfaceHolder != null);
                    sb2.append(u.bD);
                    sb2.append(i10);
                    sb2.append(",width=");
                    sb2.append(i11);
                    sb2.append(",height=");
                    sb2.append(i12);
                    com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", sb2.toString(), new Object[0]);
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("surfaceCreated:");
                    sb2.append(surfaceHolder != null);
                    sb2.append(u.bD);
                    sb2.append(Thread.currentThread().getName());
                    com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", sb2.toString(), new Object[0]);
                    if (c.this.f40446k) {
                        c cVar = c.this;
                        cVar.a(cVar.f40445j, c.this.f40439d);
                    } else {
                        c.this.f40440e = surfaceHolder;
                        c.this.f40438c.countDown();
                    }
                }

                @Override // android.view.SurfaceHolder.Callback
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "surfaceDestroyed:" + ((Object) surfaceHolder), new Object[0]);
                    c.this.f40442g = null;
                    com.tencent.cloud.huiyansdkface.a.c cVar = c.this.f40445j;
                    if (cVar != null) {
                        cVar.d();
                    }
                }
            });
            addView(this.f40439d, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.a.g.b
    public boolean a(com.tencent.cloud.huiyansdkface.a.c cVar, com.tencent.cloud.huiyansdkface.a.c.a.a aVar, boolean z10) {
        Object obj;
        if (z10) {
            Object obj2 = this.f40436a;
            if (obj2 == null) {
                obj2 = this.f40439d;
            }
            a(cVar, obj2);
            return true;
        }
        a aVar2 = this.f40436a;
        if (aVar2 != null) {
            if (aVar2.b() && !this.f40441f && e()) {
                return false;
            }
            obj = this.f40436a;
        } else {
            if (this.f40440e == null && e()) {
                return false;
            }
            obj = this.f40439d;
        }
        a(cVar, obj);
        return true;
    }

    public boolean b() {
        return (this.f40443h.d() - this.f40443h.e()) % 180 != 0;
    }

    public void c() {
        post(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.g.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f40442g == null) {
                    return;
                }
                c.this.d();
                Rect rect = c.this.f40444i;
                View childAt = c.this.getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.width = rect.width();
                layoutParams.height = rect.height();
                layoutParams.topMargin = rect.top;
                layoutParams.leftMargin = rect.left;
                childAt.setLayoutParams(layoutParams);
            }
        });
    }

    public com.tencent.cloud.huiyansdkface.a.e.b getPreviewParameter() {
        return this.f40443h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f40438c.getCount() > 0) {
            this.f40438c.countDown();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        com.tencent.cloud.huiyansdkface.a.d.a.a("CameraSurfaceView", "onLayout:changed=" + z10, new Object[0]);
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f40443h == null || this.f40442g == null || !z10) {
            return;
        }
        c();
    }
}
