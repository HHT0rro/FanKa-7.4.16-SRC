package com.tencent.cloud.huiyansdkface.facelight.ui.widget.a;

import android.graphics.Path;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f41160a = 0;

    /* renamed from: b, reason: collision with root package name */
    private Path f41161b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private int f41162c = 0;

    /* renamed from: d, reason: collision with root package name */
    private float[] f41163d = new float[6];

    public void a(Path path) {
        if (path == null) {
            throw new IllegalArgumentException("path 不能为 null");
        }
        this.f41161b = path;
        path.rewind();
    }
}
