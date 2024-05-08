package com.alibaba.security.biometrics.service.build;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;

/* compiled from: DetectEventListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface k {
    ABDetectType a(ABFaceFrame aBFaceFrame, ABDetectType aBDetectType);

    void a(int i10, Bundle bundle);

    void a(ABDetectFrame aBDetectFrame);

    void b(int i10, Bundle bundle);

    void c(int i10, Bundle bundle);
}
