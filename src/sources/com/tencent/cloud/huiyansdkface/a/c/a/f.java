package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private Camera f40359a;

    /* renamed from: b, reason: collision with root package name */
    private int f40360b;

    /* renamed from: c, reason: collision with root package name */
    private Camera.CameraInfo f40361c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.a f40362d;

    /* renamed from: e, reason: collision with root package name */
    private List<com.tencent.cloud.huiyansdkface.a.c.d> f40363e = new ArrayList();

    private com.tencent.cloud.huiyansdkface.a.a.a.a a(int i10) {
        return i10 == 0 ? com.tencent.cloud.huiyansdkface.a.a.a.a.BACK : i10 == 1 ? com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT : com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT;
    }

    private a a(Camera.CameraInfo cameraInfo, int i10) {
        this.f40359a = Camera.open(i10);
        this.f40361c = cameraInfo;
        this.f40360b = i10;
        return b();
    }

    public static boolean a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar, int i10, int i11) {
        if (i10 == 0 && aVar == com.tencent.cloud.huiyansdkface.a.a.a.a.BACK) {
            return true;
        }
        return (i10 == 1 && aVar == com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT) || aVar.a() == i11;
    }

    private boolean b(int i10) {
        return i10 == 1;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        String str;
        this.f40362d = aVar;
        com.tencent.cloud.huiyansdkface.a.d.a.a("V1Connector", "需要的摄像头:" + aVar.toString(), new Object[0]);
        int numberOfCameras = Camera.getNumberOfCameras();
        com.tencent.cloud.huiyansdkface.a.d.a.a("V1Connector", "open camera:number of cameras=%d", Integer.valueOf(numberOfCameras));
        if (numberOfCameras <= 0) {
            str = "no camera can use:numberOfCameras is 0";
        } else {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (numberOfCameras == 1) {
                Camera.getCameraInfo(0, cameraInfo);
                this.f40362d.a(b(cameraInfo.facing));
                a a10 = a(cameraInfo, 0);
                this.f40363e.add(a10);
                return a10;
            }
            for (int i10 = 0; i10 < numberOfCameras; i10++) {
                Camera.getCameraInfo(i10, cameraInfo);
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1Connector", "camera:" + i10 + ":face=" + cameraInfo.facing, new Object[0]);
                if (a(aVar, cameraInfo.facing, i10)) {
                    com.tencent.cloud.huiyansdkface.a.d.a.b("V1Connector", "camera open:find dest camera:face=%s,camera id=%d", aVar.toString(), Integer.valueOf(i10));
                    a a11 = a(cameraInfo, i10);
                    this.f40363e.add(a11);
                    this.f40362d.a(b(cameraInfo.facing));
                    return a11;
                }
                this.f40363e.add(new a().a(a(cameraInfo.facing)).b(i10).a(cameraInfo).a(cameraInfo.orientation));
            }
            str = "no camera can use:numberOfCameras is " + this.f40363e.size() + u.bD + ((Object) this.f40363e);
        }
        com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.b(11, str, null));
        return null;
    }

    public synchronized void a() {
        if (this.f40359a != null) {
            com.tencent.cloud.huiyansdkface.a.d.a.a("V1Connector", "close camera:" + ((Object) this.f40359a), new Object[0]);
            this.f40359a.release();
            this.f40361c = null;
            this.f40359a = null;
        }
    }

    public a b() {
        return new a().a(this.f40359a).a(this.f40361c.orientation).a(this.f40361c).a(this.f40362d).b(this.f40360b);
    }
}
