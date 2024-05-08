package com.huawei.quickcard;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i1 {

    /* renamed from: a, reason: collision with root package name */
    private int f34029a;

    /* renamed from: b, reason: collision with root package name */
    private float f34030b;

    /* renamed from: c, reason: collision with root package name */
    private float f34031c;

    /* renamed from: d, reason: collision with root package name */
    private MotionEvent f34032d;

    /* renamed from: e, reason: collision with root package name */
    private List<j1> f34033e = new ArrayList();

    public i1(i1 i1Var) {
        this.f34029a = i1Var.a();
        this.f34030b = i1Var.e();
        this.f34031c = i1Var.f();
        this.f34032d = i1Var.f34032d;
        int d10 = i1Var.d();
        for (int i10 = 0; i10 < d10; i10++) {
            j1 j1Var = new j1();
            j1Var.a(i1Var.a(i10));
            j1Var.a(i1Var.b(i10));
            j1Var.b(i1Var.c(i10));
            this.f34033e.add(j1Var);
        }
    }

    public int a() {
        return this.f34029a;
    }

    public MotionEvent b() {
        return this.f34032d;
    }

    public List<j1> c() {
        return this.f34033e;
    }

    public void d(int i10) {
        this.f34029a = i10;
    }

    public float e() {
        return this.f34030b;
    }

    public float f() {
        return this.f34031c;
    }

    public int a(int i10) {
        j1 j1Var;
        if (i10 >= this.f34033e.size() || (j1Var = this.f34033e.get(i10)) == null) {
            return 0;
        }
        return j1Var.a();
    }

    public float b(int i10) {
        j1 j1Var;
        if (i10 >= this.f34033e.size() || (j1Var = this.f34033e.get(i10)) == null) {
            return 0.0f;
        }
        return j1Var.b();
    }

    public float c(int i10) {
        j1 j1Var;
        if (i10 >= this.f34033e.size() || (j1Var = this.f34033e.get(i10)) == null) {
            return 0.0f;
        }
        return j1Var.c();
    }

    public int d() {
        return this.f34033e.size();
    }

    public i1(MotionEvent motionEvent) {
        this.f34029a = motionEvent.getAction();
        this.f34030b = motionEvent.getRawX();
        this.f34031c = motionEvent.getRawY();
        this.f34032d = motionEvent;
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            j1 j1Var = new j1();
            j1Var.a(motionEvent.getPointerId(i10));
            j1Var.a(motionEvent.getX(i10));
            j1Var.b(motionEvent.getY(i10));
            this.f34033e.add(j1Var);
        }
    }
}
