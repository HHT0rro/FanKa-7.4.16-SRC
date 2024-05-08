package r2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.widget.ImageView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyButtonEnum;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyEditCacheModel;
import com.cupidapp.live.liveshow.beauty.view.FKLiveFilterViewModel;
import com.cupidapp.live.liveshow.beauty.zegocapture.VideoCaptureFromImage;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.s;
import l2.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.b;
import r2.i;

/* compiled from: FKLiveDataBeautyEffectEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i implements SurfaceTexture.OnFrameAvailableListener, a.InterfaceC0783a {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static i2.f f53232c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static GLSurfaceView f53233d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static l2.a f53234e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static j2.f f53235f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public static q2.b f53236g;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f53239j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f53240k;

    /* renamed from: l, reason: collision with root package name */
    public static int f53241l;

    /* renamed from: m, reason: collision with root package name */
    public static int f53242m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public static String f53243n;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final i f53231b = new i();

    /* renamed from: h, reason: collision with root package name */
    public static int f53237h = 1;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f53238i = true;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f53244o = true;

    /* compiled from: FKLiveDataBeautyEffectEntity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements j2.e {
        public static final void d() {
            i.f53231b.r();
        }

        @Override // j2.e
        public void a() {
            com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "changeCamera onOpenFail");
        }

        @Override // j2.e
        public void b() {
            com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "changeCamera onOpenSuccess");
            GLSurfaceView gLSurfaceView = i.f53233d;
            if (gLSurfaceView != null) {
                gLSurfaceView.queueEvent(new Runnable() { // from class: r2.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.a.d();
                    }
                });
            }
        }
    }

    /* compiled from: FKLiveDataBeautyEffectEntity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements j2.e {
        public static final void d() {
            i.f53231b.s();
        }

        @Override // j2.e
        public void a() {
            com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "openCamera onOpenFail");
        }

        @Override // j2.e
        public void b() {
            com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "openCamera onOpenSuccess");
            GLSurfaceView gLSurfaceView = i.f53233d;
            if (gLSurfaceView != null) {
                gLSurfaceView.queueEvent(new Runnable() { // from class: r2.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.b.d();
                    }
                });
            }
        }
    }

    public static final void F(String str) {
        l2.a aVar = f53234e;
        Boolean valueOf = aVar != null ? Boolean.valueOf(aVar.q(str)) : null;
        com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "filterPath: " + str + " filter: " + ((Object) valueOf));
    }

    public static final void J(String str) {
        l2.a aVar = f53234e;
        Boolean valueOf = aVar != null ? Boolean.valueOf(aVar.s(str)) : null;
        com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "stickerPath: " + str + " sticker: " + ((Object) valueOf));
    }

    public static final void L(String str) {
        String str2 = f53243n;
        if (str2 != null) {
            l2.a aVar = f53234e;
            Boolean valueOf = aVar != null ? Boolean.valueOf(aVar.l(new String[]{str2})) : null;
            f53243n = null;
            com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "node: " + str2 + " remove: " + ((Object) valueOf));
        }
        if (str != null) {
            l2.a aVar2 = f53234e;
            String g3 = aVar2 != null ? aVar2.g(str) : null;
            l2.a aVar3 = f53234e;
            Boolean valueOf2 = aVar3 != null ? Boolean.valueOf(aVar3.a(new String[]{g3})) : null;
            l2.a aVar4 = f53234e;
            Boolean valueOf3 = aVar4 != null ? Boolean.valueOf(aVar4.u(g3, "", 0.0f)) : null;
            f53243n = g3;
            com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "node: " + g3 + " append: " + ((Object) valueOf2) + " updateNode: " + ((Object) valueOf3));
        }
    }

    public static final void O(String nodeName, String effectId, float f10) {
        s.i(nodeName, "$nodeName");
        s.i(effectId, "$effectId");
        l2.a aVar = f53234e;
        Boolean valueOf = aVar != null ? Boolean.valueOf(aVar.u(nodeName, effectId, f10)) : null;
        com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "nodeName: " + nodeName + " effectId: " + effectId + " value: " + f10 + " update: " + ((Object) valueOf));
    }

    public static final void Q(Integer num) {
        l2.a aVar = f53234e;
        Boolean valueOf = aVar != null ? Boolean.valueOf(aVar.v(num.intValue() / 100.0f)) : null;
        com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "intensity: " + ((Object) num) + " filterIntensity: " + ((Object) valueOf));
    }

    public static final void m() {
        j2.f fVar = f53235f;
        if (fVar != null) {
            fVar.c(f53237h, new a());
        }
    }

    public static final void w() {
        q2.b bVar = f53236g;
        if (bVar != null) {
            bVar.f();
        }
        j2.f fVar = f53235f;
        if (fVar != null) {
            fVar.n();
        }
        l2.a aVar = f53234e;
        if (aVar != null) {
            aVar.e();
        }
    }

    public final void A() {
        j2.f fVar = f53235f;
        if (fVar != null) {
            fVar.m(f53237h, new b());
        }
    }

    public final n2.b B(n2.a aVar, long j10) {
        n2.b bVar = new n2.b();
        q2.b bVar2 = f53236g;
        s.f(bVar2);
        int e2 = bVar2.e(aVar.c(), aVar.a());
        if (f53244o) {
            l2.a aVar2 = f53234e;
            if (!(aVar2 != null ? aVar2.j(aVar.b(), e2, aVar.c(), aVar.a(), q2.d.c(), j10) : false)) {
                e2 = aVar.b();
            }
        } else {
            e2 = aVar.b();
            l2.a aVar3 = f53234e;
            if (aVar3 != null) {
                aVar3.c();
            }
        }
        bVar.f52095a = e2;
        bVar.f52096b = aVar.c();
        bVar.f52097c = aVar.a();
        return bVar;
    }

    public final void C(n2.b bVar, int i10) {
        VideoCaptureFromImage fkLiveVideoCaptureImage;
        if (!f53240k || (fkLiveVideoCaptureImage = FKLiveConstantsData.INSTANCE.getFkLiveVideoCaptureImage()) == null) {
            return;
        }
        fkLiveVideoCaptureImage.b(i10);
        fkLiveVideoCaptureImage.a(bVar.f52095a, bVar.f52096b, bVar.f52097c);
    }

    public final void D(boolean z10) {
        f53244o = z10;
    }

    public final void E(@Nullable final String str, @Nullable Integer num) {
        GLSurfaceView gLSurfaceView = f53233d;
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(new Runnable() { // from class: r2.c
                @Override // java.lang.Runnable
                public final void run() {
                    i.F(String.this);
                }
            });
        }
        P(num);
    }

    public final void G(boolean z10) {
        f53240k = z10;
    }

    public final void H() {
        if (f53232c == null) {
            i2.f fVar = new i2.f();
            f53232c = fVar;
            s.f(fVar);
            if (fVar.f()) {
                return;
            }
            i2.f fVar2 = f53232c;
            s.f(fVar2);
            fVar2.g();
        }
    }

    public final void I(@Nullable final String str) {
        GLSurfaceView gLSurfaceView = f53233d;
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(new Runnable() { // from class: r2.d
                @Override // java.lang.Runnable
                public final void run() {
                    i.J(String.this);
                }
            });
        }
    }

    public final void K(@Nullable final String str) {
        GLSurfaceView gLSurfaceView = f53233d;
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(new Runnable() { // from class: r2.b
                @Override // java.lang.Runnable
                public final void run() {
                    i.L(String.this);
                }
            });
        }
    }

    public final n2.a M(j2.f fVar) {
        n2.a aVar = new n2.a();
        int h10 = fVar.h();
        int f10 = fVar.f();
        int g3 = fVar.g();
        if (fVar.e() % 180 == 90) {
            h10 = fVar.f();
            f10 = fVar.h();
            b.a b4 = new b.a().e(fVar.e()).b(false, fVar.k());
            q2.b bVar = f53236g;
            s.f(bVar);
            g3 = bVar.g(fVar.g(), EffectsSDKEffectConstants.TextureFormat.Texture_Oes, EffectsSDKEffectConstants.TextureFormat.Texure2D, fVar.h(), fVar.f(), b4);
        }
        aVar.f(h10);
        aVar.d(f10);
        aVar.e(g3);
        return aVar;
    }

    public final void N(@NotNull final String nodeName, @NotNull final String effectId, final float f10) {
        s.i(nodeName, "nodeName");
        s.i(effectId, "effectId");
        GLSurfaceView gLSurfaceView = f53233d;
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(new Runnable() { // from class: r2.e
                @Override // java.lang.Runnable
                public final void run() {
                    i.O(String.this, effectId, f10);
                }
            });
        }
    }

    public final void P(@Nullable final Integer num) {
        if (num != null) {
            num.intValue();
            GLSurfaceView gLSurfaceView = f53233d;
            if (gLSurfaceView != null) {
                gLSurfaceView.queueEvent(new Runnable() { // from class: r2.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.Q(Integer.this);
                    }
                });
            }
        }
    }

    @Override // l2.a.InterfaceC0783a
    public void a() {
        List o10 = kotlin.collections.s.o("beauty_Android_lite", "reshape_lite", "beauty_4Items", "palette/color", "palette/contrast", "palette/light", "background_blur");
        String str = f53243n;
        if (!(str == null || str.length() == 0)) {
            String str2 = f53243n;
            s.f(str2);
            o10.add(str2);
        }
        l2.a aVar = f53234e;
        Boolean valueOf = aVar != null ? Boolean.valueOf(aVar.o((String[]) o10.toArray(new String[0]))) : null;
        com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "onEffectInitialized nodes: " + ((Object) valueOf));
        if (s.d(valueOf, Boolean.TRUE)) {
            p();
            o();
        }
    }

    public final void l() {
        if (f53233d == null || Camera.getNumberOfCameras() == 1 || f53238i) {
            return;
        }
        f53237h = 1 - f53237h;
        f53238i = true;
        GLSurfaceView gLSurfaceView = f53233d;
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(new Runnable() { // from class: r2.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.m();
                }
            });
        }
    }

    public final void n(n2.b bVar) {
        if (bVar.f52095a != -1) {
            b.a a10 = new b.a().a(ImageView.ScaleType.CENTER_CROP, 0, bVar.f52096b, bVar.f52097c, f53241l, f53242m);
            q2.b bVar2 = f53236g;
            if (bVar2 != null) {
                bVar2.c(bVar.f52095a, EffectsSDKEffectConstants.TextureFormat.Texure2D, f53241l, f53242m, a10.d());
            }
        }
    }

    public final void o() {
        FKLiveBeautyEditCacheModel c4 = p1.g.f52734a.S().c();
        FKLiveFilterViewModel filter = c4 != null ? c4.getFilter() : null;
        if (filter != null) {
            f53231b.E(filter.getFilterResource(), filter.getFilterIntensity());
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(@Nullable SurfaceTexture surfaceTexture) {
        GLSurfaceView gLSurfaceView;
        if (f53238i || (gLSurfaceView = f53233d) == null) {
            return;
        }
        gLSurfaceView.requestRender();
    }

    public final void p() {
        FKLiveBeautyEditCacheModel c4 = p1.g.f52734a.S().c();
        Map<String, Float> map = c4 != null ? c4.getMap() : null;
        if (map != null) {
            for (Map.Entry<String, Float> entry : map.entrySet()) {
                f53231b.N(FKLiveBeautyButtonEnum.Companion.a(entry.getKey()), entry.getKey(), entry.getValue().floatValue());
            }
        }
    }

    public final void q() {
        Context c4 = AppApplication.f11612d.c();
        if (f53235f == null) {
            f53235f = new j2.f(c4);
        }
        if (f53234e == null) {
            l2.a aVar = new l2.a(c4, new l2.b(c4), com.cupidapp.live.liveshow.beauty.databeauty.license.a.h(c4));
            aVar.r(this);
            f53234e = aVar;
        }
        if (f53236g == null) {
            f53236g = new q2.b();
        }
        q2.d.d(c4);
    }

    public final void r() {
        j2.f fVar = f53235f;
        if (fVar != null) {
            fVar.d();
        }
        s();
        GLSurfaceView gLSurfaceView = f53233d;
        if (gLSurfaceView != null) {
            gLSurfaceView.requestRender();
        }
        l2.a aVar = f53234e;
        if (aVar != null) {
            aVar.i();
        }
    }

    public final void s() {
        com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "onCameraOpen");
        f53238i = false;
        j2.f fVar = f53235f;
        if (fVar != null) {
            fVar.o(this);
        }
    }

    public final void t() {
        f53233d = null;
        f53234e = null;
        f53235f = null;
        f53236g = null;
        f53237h = 1;
        f53238i = true;
        f53239j = false;
        f53240k = false;
        f53243n = null;
        q2.d.e();
    }

    public final void u() {
        if (f53238i || f53239j || f53236g == null) {
            return;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        j2.f fVar = f53235f;
        if (fVar == null || !fVar.j()) {
            return;
        }
        fVar.p();
        l2.a aVar = f53234e;
        if (aVar != null) {
            aVar.n(fVar.k());
        }
        i iVar = f53231b;
        n2.b B = iVar.B(iVar.M(fVar), fVar.i());
        iVar.n(B);
        iVar.C(B, fVar.e() - (fVar.k() ? 90 : 270));
    }

    public final void v() {
        j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
        GLSurfaceView gLSurfaceView = f53233d;
        aVar.a("LiveDataBeautyEffectEntity", "onPause mSurfaceView: " + ((Object) gLSurfaceView) + " mIsPaused: " + f53239j);
        f53239j = true;
        GLSurfaceView gLSurfaceView2 = f53233d;
        if (gLSurfaceView2 != null) {
            gLSurfaceView2.onPause();
        }
        GLSurfaceView gLSurfaceView3 = f53233d;
        if (gLSurfaceView3 != null) {
            gLSurfaceView3.queueEvent(new Runnable() { // from class: r2.f
                @Override // java.lang.Runnable
                public final void run() {
                    i.w();
                }
            });
        }
    }

    public final void x() {
        j.a aVar = com.cupidapp.live.base.utils.j.f12332a;
        GLSurfaceView gLSurfaceView = f53233d;
        aVar.a("LiveDataBeautyEffectEntity", "onResume mSurfaceView: " + ((Object) gLSurfaceView) + " mIsPaused: " + f53239j);
        GLSurfaceView gLSurfaceView2 = f53233d;
        if (gLSurfaceView2 != null) {
            gLSurfaceView2.onResume();
        }
        f53239j = false;
    }

    public final void y(int i10, int i11) {
        com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "onSurfaceChanged mIsPaused: " + f53239j + " width: " + i10 + " height: " + i11);
        if (f53239j || i10 == 0 || i11 == 0) {
            return;
        }
        f53241l = i10;
        f53242m = i11;
    }

    public final void z(@NotNull GLSurfaceView surfaceView) {
        s.i(surfaceView, "surfaceView");
        com.cupidapp.live.base.utils.j.f12332a.a("LiveDataBeautyEffectEntity", "onSurfaceCreated");
        f53233d = surfaceView;
        A();
        l2.a aVar = f53234e;
        if (aVar != null) {
            aVar.h();
        }
        l2.a aVar2 = f53234e;
        if (aVar2 != null) {
            aVar2.k();
        }
    }
}
