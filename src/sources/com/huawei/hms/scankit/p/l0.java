package com.huawei.hms.scankit.p;

import android.graphics.Rect;
import android.hardware.Camera;
import com.huawei.hms.scankit.p.k0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraMeteringManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    private Camera f31219a;

    public synchronized void a(Camera camera) {
        this.f31219a = camera;
    }

    public synchronized k0 a() {
        RuntimeException e2;
        int i10;
        Rect rect;
        try {
            i10 = this.f31219a.getParameters().getMaxNumMeteringAreas();
            try {
                rect = this.f31219a.getParameters().getMeteringAreas().get(0).rect;
            } catch (RuntimeException e10) {
                e2 = e10;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CameraMeteringManager::getCameraMeteringData failed: ");
                sb2.append(e2.getMessage());
                rect = null;
                return new k0(i10, rect);
            }
        } catch (RuntimeException e11) {
            e2 = e11;
            i10 = 0;
        }
        return new k0(i10, rect);
    }

    public synchronized void a(List<k0.a> list) {
        Camera camera = this.f31219a;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(new Camera.Area(list.get(i10).f31196a, list.get(i10).f31197b));
        }
        parameters.setMeteringAreas(arrayList);
        try {
            this.f31219a.setParameters(parameters);
        } catch (RuntimeException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CameraMeteringManager::setCameraMeteringArea failed: ");
            sb2.append(e2.getMessage());
        }
    }
}
