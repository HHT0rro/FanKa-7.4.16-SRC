package com.tencent.liteav.videoproducer.producer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.SystemUtil;
import com.tencent.liteav.base.util.w;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends OrientationEventListener implements w.a {

    /* renamed from: a, reason: collision with root package name */
    private final a f44979a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f44980b;

    /* renamed from: c, reason: collision with root package name */
    private Rotation f44981c;

    /* renamed from: d, reason: collision with root package name */
    private Rotation f44982d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.liteav.base.util.w f44983e;

    /* renamed from: f, reason: collision with root package name */
    private Rotation f44984f;

    /* renamed from: com.tencent.liteav.videoproducer.producer.d$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44985a;

        static {
            int[] iArr = new int[Rotation.values().length];
            f44985a = iArr;
            try {
                iArr[Rotation.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44985a[Rotation.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44985a[Rotation.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44985a[Rotation.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(Rotation rotation, Rotation rotation2);
    }

    public d(Context context, a aVar) {
        super(context);
        this.f44980b = new Handler(Looper.getMainLooper());
        this.f44979a = aVar;
    }

    public static /* synthetic */ void a(d dVar) {
        com.tencent.liteav.base.util.w wVar = dVar.f44983e;
        if (wVar != null) {
            wVar.a();
            dVar.f44983e = null;
        }
    }

    public static /* synthetic */ void b(d dVar) {
        if (dVar.f44983e == null) {
            com.tencent.liteav.base.util.w wVar = new com.tencent.liteav.base.util.w(dVar.f44980b.getLooper(), dVar);
            dVar.f44983e = wVar;
            wVar.a(0, 1000);
        }
    }

    @Override // android.view.OrientationEventListener
    public final synchronized void disable() {
        super.disable();
        this.f44980b.post(f.a(this));
    }

    @Override // android.view.OrientationEventListener
    public final synchronized void enable() {
        super.enable();
        this.f44980b.post(e.a(this));
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i10) {
        Rotation rotation;
        if (i10 == -1) {
            return;
        }
        if (i10 > 45) {
            if (i10 <= 135) {
                rotation = Rotation.ROTATION_90;
            } else if (i10 <= 225) {
                rotation = Rotation.ROTATION_180;
            } else if (i10 <= 315) {
                rotation = Rotation.ROTATION_270;
            }
            this.f44980b.post(h.a(this, rotation));
        }
        rotation = Rotation.NORMAL;
        this.f44980b.post(h.a(this, rotation));
    }

    @Override // com.tencent.liteav.base.util.w.a
    public final void onTimeout() {
        Rotation rotation;
        Rotation a10 = Rotation.a(SystemUtil.getDisplayRotationDegree());
        if (this.f44982d == a10) {
            return;
        }
        this.f44982d = a10;
        if (this.f44981c == null) {
            if (a10 != null) {
                int i10 = AnonymousClass1.f44985a[a10.ordinal()];
                if (i10 == 1) {
                    rotation = Rotation.ROTATION_270;
                } else if (i10 == 2) {
                    rotation = Rotation.ROTATION_180;
                } else if (i10 == 3) {
                    rotation = Rotation.ROTATION_90;
                }
                this.f44981c = rotation;
            }
            rotation = Rotation.NORMAL;
            this.f44981c = rotation;
        }
        a();
    }

    public static /* synthetic */ void b(d dVar, Rotation rotation) {
        dVar.f44984f = rotation;
        dVar.a();
    }

    public final void a(Rotation rotation) {
        this.f44980b.post(g.a(this, rotation));
    }

    public static /* synthetic */ void a(d dVar, Rotation rotation) {
        if (dVar.f44981c != rotation) {
            dVar.f44981c = rotation;
            dVar.f44982d = Rotation.a(SystemUtil.getDisplayRotationDegree());
            dVar.a();
        }
    }

    private void a() {
        Rotation rotation = this.f44984f;
        if (rotation == null) {
            rotation = this.f44981c;
        }
        a aVar = this.f44979a;
        if (aVar != null) {
            aVar.a(rotation, this.f44982d);
        }
    }
}
