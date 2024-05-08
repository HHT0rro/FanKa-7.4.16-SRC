package com.tencent.liteav.videoproducer.capture;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CameraCaptureParams extends CaptureSourceInterface.CaptureParams {

    /* renamed from: a, reason: collision with root package name */
    public Boolean f44172a;

    public CameraCaptureParams() {
        this.f44172a = null;
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof CameraCaptureParams)) {
            return false;
        }
        CameraCaptureParams cameraCaptureParams = (CameraCaptureParams) obj;
        return super.equals(cameraCaptureParams) && com.tencent.liteav.base.util.i.a(this.f44172a, cameraCaptureParams.f44172a);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface.CaptureParams
    @NonNull
    public String toString() {
        return String.format(Locale.ENGLISH, "%s, frontCamera: %b", super.toString(), this.f44172a);
    }

    public CameraCaptureParams(CameraCaptureParams cameraCaptureParams) {
        super(cameraCaptureParams);
        this.f44172a = null;
        this.f44172a = cameraCaptureParams.f44172a;
    }
}
