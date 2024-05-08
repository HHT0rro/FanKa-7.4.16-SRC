package o2;

import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;

/* compiled from: ProgramManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public com.cupidapp.live.liveshow.beauty.databeauty.opengl.a f52263a;

    /* renamed from: b, reason: collision with root package name */
    public com.cupidapp.live.liveshow.beauty.databeauty.opengl.b f52264b;

    /* compiled from: ProgramManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52265a;

        static {
            int[] iArr = new int[EffectsSDKEffectConstants.TextureFormat.values().length];
            f52265a = iArr;
            try {
                iArr[EffectsSDKEffectConstants.TextureFormat.Texure2D.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52265a[EffectsSDKEffectConstants.TextureFormat.Texture_Oes.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b a(EffectsSDKEffectConstants.TextureFormat textureFormat) {
        int i10 = a.f52265a[textureFormat.ordinal()];
        if (i10 == 1) {
            if (this.f52263a == null) {
                this.f52263a = new com.cupidapp.live.liveshow.beauty.databeauty.opengl.a();
            }
            return this.f52263a;
        }
        if (i10 != 2) {
            return null;
        }
        if (this.f52264b == null) {
            this.f52264b = new com.cupidapp.live.liveshow.beauty.databeauty.opengl.b();
        }
        return this.f52264b;
    }

    public void b() {
        com.cupidapp.live.liveshow.beauty.databeauty.opengl.a aVar = this.f52263a;
        if (aVar != null) {
            aVar.h();
            this.f52263a = null;
        }
        com.cupidapp.live.liveshow.beauty.databeauty.opengl.b bVar = this.f52264b;
        if (bVar != null) {
            bVar.h();
            this.f52264b = null;
        }
    }
}
