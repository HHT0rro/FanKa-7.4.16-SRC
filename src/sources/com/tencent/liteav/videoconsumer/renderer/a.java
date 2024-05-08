package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.liteav.base.util.Size;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f44038a = "PostProcessor_" + hashCode();

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Size f44039b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final com.tencent.liteav.videobase.frame.e f44040c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public com.tencent.liteav.videobase.b.b f44041d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FloatBuffer f44042e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public FloatBuffer f44043f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public com.tencent.liteav.videobase.frame.j f44044g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Matrix f44045h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public List<PointF> f44046i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public List<PointF> f44047j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f44048k;

    public a(@NonNull com.tencent.liteav.videobase.frame.e eVar, int i10, int i11) {
        Size size = new Size();
        this.f44039b = size;
        this.f44048k = false;
        this.f44040c = eVar;
        size.set(i10, i11);
    }

    public final void a(List<PointF> list, List<PointF> list2) {
        this.f44046i = list;
        this.f44047j = list2;
        this.f44048k = true;
    }

    public final void b(List<PointF> list, List<PointF> list2) {
        if (list == null || list.size() != 4 || list2 == null || list2.size() != 4 || !this.f44039b.isValid() || this.f44041d == null) {
            return;
        }
        List<PointF> a10 = a(list);
        List<PointF> a11 = a(list2);
        com.tencent.liteav.videobase.b.b bVar = this.f44041d;
        if (a10.size() == 4 && a11.size() == 4) {
            bVar.runOnDraw(com.tencent.liteav.videobase.b.c.a(bVar, a11, a10));
        }
    }

    private List<PointF> a(List<PointF> list) {
        ArrayList arrayList = new ArrayList();
        for (PointF pointF : list) {
            float f10 = pointF.x;
            Size size = this.f44039b;
            PointF a10 = a(new PointF(f10 * size.width, pointF.y * size.height), this.f44045h);
            float f11 = a10.x;
            Size size2 = this.f44039b;
            PointF pointF2 = new PointF(f11 / size2.width, a10.y / size2.height);
            pointF2.y = 1.0f - pointF2.y;
            arrayList.add(pointF2);
        }
        return arrayList;
    }

    private static PointF a(PointF pointF, Matrix matrix) {
        if (matrix == null) {
            return pointF;
        }
        Matrix matrix2 = new Matrix();
        if (!matrix.invert(matrix2)) {
            return pointF;
        }
        float[] fArr = new float[2];
        matrix2.mapPoints(fArr, new float[]{pointF.x, pointF.y});
        return new PointF(fArr[0], fArr[1]);
    }

    public final void a() {
        com.tencent.liteav.videobase.frame.j jVar = this.f44044g;
        if (jVar != null) {
            jVar.a();
            this.f44044g = null;
        }
        com.tencent.liteav.videobase.b.b bVar = this.f44041d;
        if (bVar != null) {
            bVar.uninitialize();
            this.f44041d = null;
        }
    }
}
