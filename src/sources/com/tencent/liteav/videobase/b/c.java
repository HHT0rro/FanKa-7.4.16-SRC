package com.tencent.liteav.videobase.b;

import com.tencent.liteav.videobase.utils.PerspectiveTransformMatrixCalculator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43280a;

    /* renamed from: b, reason: collision with root package name */
    private final List f43281b;

    /* renamed from: c, reason: collision with root package name */
    private final List f43282c;

    private c(b bVar, List list, List list2) {
        this.f43280a = bVar;
        this.f43281b = list;
        this.f43282c = list2;
    }

    public static Runnable a(b bVar, List list, List list2) {
        return new c(bVar, list, list2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43280a;
        float[] perspectiveTransformMatrix = PerspectiveTransformMatrixCalculator.getPerspectiveTransformMatrix(this.f43281b, this.f43282c);
        float[] fArr = new float[9];
        for (int i10 = 0; i10 < 3; i10++) {
            for (int i11 = 0; i11 < 3; i11++) {
                fArr[(i11 * 3) + i10] = perspectiveTransformMatrix[(i10 * 3) + i11];
            }
        }
        bVar.f43278a = fArr;
    }
}
