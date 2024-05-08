package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ai {

    /* renamed from: d, reason: collision with root package name */
    private Boolean f44275d;

    /* renamed from: a, reason: collision with root package name */
    public CameraControllerInterface.a f44272a = CameraControllerInterface.a.CAMERA_1;

    /* renamed from: b, reason: collision with root package name */
    public CameraControllerInterface.a f44273b = null;

    /* renamed from: e, reason: collision with root package name */
    private int f44276e = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public boolean f44274c = false;

    /* JADX WARN: Multi-variable type inference failed */
    public static Size a(List<Size> list, Rotation rotation, int i10, int i11) {
        double d10;
        Size size = new Size(i10, i11);
        LiteavLog.i("CameraSupervisor", "preview wanted: " + ((Object) size) + " cameraRotation:" + ((Object) rotation));
        if (list == null) {
            LiteavLog.e("CameraSupervisor", "findBestMatchedPreviewSize getPreviewSizes null");
            return size;
        }
        if (rotation == Rotation.ROTATION_90 || rotation == Rotation.ROTATION_270) {
            size.swap();
        }
        double aspectRatio = size.aspectRatio();
        Size size2 = new Size(640, 640);
        int i12 = size.width;
        int i13 = size2.width;
        if (i12 <= i13 && size.height <= size2.height) {
            size2.set(size);
        } else {
            int i14 = size.height;
            if (i12 > i14) {
                size2.height = (i13 * i14) / i12;
            } else {
                size2.width = (size2.height * i12) / i14;
            }
        }
        ArrayList<Size> arrayList = new ArrayList();
        long j10 = Long.MAX_VALUE;
        for (Size size3 : list) {
            LiteavLog.d("CameraSupervisor", "support preview size ".concat(String.valueOf(size3)));
            long round = (size3.width < size2.width || size3.height < size2.height) ? Long.MAX_VALUE : Math.round(Math.abs(size3.aspectRatio() - aspectRatio) * 10.0d);
            if (round < j10) {
                arrayList.clear();
                arrayList.add(size3);
                j10 = round;
            } else if (round == j10) {
                arrayList.add(size3);
            }
        }
        Collections.sort(arrayList, aj.a());
        Size size4 = (Size) arrayList.get(0);
        int area = size.getArea();
        double d11 = Double.MAX_VALUE;
        for (Size size5 : arrayList) {
            LiteavLog.i("CameraSupervisor", "size in same buck ".concat(String.valueOf(size5)));
            if (aspectRatio > size5.aspectRatio()) {
                int i15 = size5.width;
                d10 = (i15 * i15) / aspectRatio;
            } else {
                int i16 = size5.height;
                d10 = i16 * i16 * aspectRatio;
            }
            double d12 = area;
            if (d10 / d12 >= 0.9d) {
                double d13 = d10 - d12;
                if (Math.abs(d13) < d11) {
                    d11 = Math.abs(d13);
                    size4 = size5;
                }
            }
        }
        LiteavLog.i("CameraSupervisor", "best match preview size ".concat(String.valueOf(size4)));
        return new Size(size4.width, size4.height);
    }

    private boolean b() {
        if (this.f44275d == null) {
            this.f44275d = Boolean.valueOf(c());
        }
        return this.f44275d.booleanValue();
    }

    private boolean c() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            LiteavLog.w("CameraSupervisor", "isApiLevelSupportCamera2 false, current:" + LiteavSystemInfo.getSystemOSVersionInt() + " is low to:21");
            return false;
        }
        if (this.f44276e < 21) {
            LiteavLog.w("CameraSupervisor", "isApiLevelSupportCamera2 false, apiLevel:" + this.f44276e + " is too low.");
            return false;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() < this.f44276e) {
            LiteavLog.w("CameraSupervisor", "isApiLevelSupportCamera2 false, current:" + LiteavSystemInfo.getSystemOSVersionInt() + " is low to config api level:" + this.f44276e);
            return false;
        }
        int camera2SupportLevel = CameraAbilityProvider.getCamera2SupportLevel();
        boolean z10 = camera2SupportLevel == 1 || camera2SupportLevel == 3;
        LiteavLog.i("CameraSupervisor", "isApiLevelSupportCamera2 apiLevel:" + this.f44276e + " supportLevel:" + camera2SupportLevel + " result:" + z10);
        return z10;
    }

    public final void a(int i10) {
        this.f44276e = i10;
        LiteavLog.i("CameraSupervisor", "setCamera2SupportMinApiLevel apiLevel:".concat(String.valueOf(i10)));
    }

    public final CameraControllerInterface.a a() {
        CameraControllerInterface.a aVar = this.f44273b;
        boolean z10 = aVar == null || aVar == CameraControllerInterface.a.CAMERA_2;
        CameraControllerInterface.a aVar2 = CameraControllerInterface.a.MOCK;
        if (aVar == aVar2) {
            this.f44272a = aVar2;
        } else if (b() && !this.f44274c && z10) {
            this.f44272a = CameraControllerInterface.a.CAMERA_2;
        } else {
            this.f44272a = CameraControllerInterface.a.CAMERA_1;
        }
        return this.f44272a;
    }
}
