package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.PackageUtils;
import com.alibaba.security.common.videorecorder.ICameraVideoRecorder;
import com.alibaba.security.common.videorecorder.OnH264EncoderListener;

/* compiled from: X264CameraVideoRecorder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class an extends ah {

    /* renamed from: l, reason: collision with root package name */
    private ICameraVideoRecorder f2650l;

    public an(Context context) {
        super(context);
        try {
            this.f2650l = (ICameraVideoRecorder) Class.forName("com.alibaba.security.videorecorder.CameraVideoRecorderManager").newInstance();
        } catch (Exception e2) {
            if (PackageUtils.isApkInDebug(context)) {
                RPLogging.e(ah.f2595a, "no camera video recorder ability", e2);
            }
        }
    }

    private boolean b() {
        return this.f2650l != null;
    }

    @Override // com.alibaba.security.biometrics.service.build.ah
    public final void a(byte[] bArr) {
        this.f2650l.record(bArr);
    }

    @Override // com.alibaba.security.biometrics.service.build.ah
    public final boolean a() {
        return true;
    }

    @Override // com.alibaba.security.biometrics.service.build.ah
    public final void a(boolean z10) {
        this.f2650l.release(null, z10);
    }

    @Override // com.alibaba.security.biometrics.service.build.ah
    public final boolean a(int i10, int i11, int i12, int i13) {
        ICameraVideoRecorder iCameraVideoRecorder = this.f2650l;
        if (!(iCameraVideoRecorder != null)) {
            return false;
        }
        try {
            iCameraVideoRecorder.init(i10, i11, i12, i13);
            this.f2650l.setOnH264EncoderListener(new OnH264EncoderListener() { // from class: com.alibaba.security.biometrics.service.build.an.1
                @Override // com.alibaba.security.common.videorecorder.OnH264EncoderListener
                public final void h264(byte[] bArr, int i14) {
                    an.this.a(bArr, i14);
                }
            });
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
