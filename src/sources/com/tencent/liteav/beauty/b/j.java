package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import com.tencent.liteav.videobase.utils.OpenGlUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f43050a;

    /* renamed from: b, reason: collision with root package name */
    private final float f43051b;

    /* renamed from: c, reason: collision with root package name */
    private final float f43052c;

    /* renamed from: d, reason: collision with root package name */
    private final float f43053d;

    /* renamed from: e, reason: collision with root package name */
    private final Bitmap f43054e;

    /* renamed from: f, reason: collision with root package name */
    private final Bitmap f43055f;

    private j(i iVar, float f10, float f11, float f12, Bitmap bitmap, Bitmap bitmap2) {
        this.f43050a = iVar;
        this.f43051b = f10;
        this.f43052c = f11;
        this.f43053d = f12;
        this.f43054e = bitmap;
        this.f43055f = bitmap2;
    }

    public static Runnable a(i iVar, float f10, float f11, float f12, Bitmap bitmap, Bitmap bitmap2) {
        return new j(iVar, f10, f11, f12, bitmap, bitmap2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.f43050a;
        float f10 = this.f43051b;
        float f11 = this.f43052c;
        float f12 = this.f43053d;
        Bitmap bitmap = this.f43054e;
        Bitmap bitmap2 = this.f43055f;
        iVar.f43044e.put(0, f10);
        iVar.f43044e.put(1, f11);
        iVar.f43044e.put(2, f12);
        if (bitmap == null) {
            OpenGlUtils.deleteTexture(iVar.f43041b);
            iVar.f43041b = -1;
            iVar.f43045f.put(0, 0.0f);
        } else if (bitmap != iVar.f43040a) {
            iVar.f43041b = OpenGlUtils.loadTexture(bitmap, iVar.f43041b, false);
            iVar.f43045f.put(0, 1.0f);
        }
        if (bitmap2 == null) {
            OpenGlUtils.deleteTexture(iVar.f43043d);
            iVar.f43043d = -1;
            iVar.f43045f.put(1, 0.0f);
        } else if (bitmap2 != iVar.f43042c) {
            iVar.f43043d = OpenGlUtils.loadTexture(bitmap2, iVar.f43043d, false);
            iVar.f43045f.put(1, 1.0f);
        }
        iVar.f43040a = bitmap;
        iVar.f43042c = bitmap2;
    }
}
