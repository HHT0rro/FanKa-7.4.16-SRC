package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanFrame;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.y3;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HmsRemoteDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile IRemoteHmsDecoderDelegate f30305a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f30306b = "b";

    public static HmsScan[] a(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        DetailRect detailRect;
        HmsScan[] detectWithByteBuffer;
        HmsScan[] detectWithByteBuffer2;
        int i10;
        o4.d("scankit mul", "start detectForHmsDector");
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (f30305a == null) {
            IRemoteCreator c4 = g.c(context);
            if (c4 == null) {
                return hmsScanArr;
            }
            try {
                f30305a = c4.newRemoteHmsDecoderDelegate();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }
        if (f30305a != null) {
            try {
                if (mLFrame.acquireProperty() != null) {
                    detailRect = new DetailRect(mLFrame.acquireProperty().getWidth(), mLFrame.acquireProperty().getHeight());
                } else {
                    detailRect = new DetailRect();
                }
                Bundle bundle = new Bundle();
                if (hmsScanAnalyzerOptions != null && (i10 = hmsScanAnalyzerOptions.mode) != 0) {
                    bundle.putInt(DetailRect.FORMAT_FLAG, i10);
                    bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                }
                bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putBoolean(DetailRect.SUPPORT_ROLLBACK, g.f30318c);
                bundle.putBoolean(DetailRect.USE_APK, g.f30316a);
                bundle.putAll(y3.a(context));
                if (mLFrame.readBitmap() != null) {
                    o4.d("scankit mul", "end detectForHmsDector");
                    detectWithByteBuffer = f30305a.decodeInBitmap(detailRect, ObjectWrapper.wrap(mLFrame.readBitmap()), ObjectWrapper.wrap(bundle));
                } else {
                    detectWithByteBuffer = f30305a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(mLFrame.acquireGrayByteBuffer()), ObjectWrapper.wrap(bundle));
                }
                f.a(detectWithByteBuffer);
                if (g.a()) {
                    IRemoteCreator c10 = g.c(context);
                    if (c10 == null) {
                        return hmsScanArr;
                    }
                    try {
                        f30305a = c10.newRemoteHmsDecoderDelegate();
                    } catch (RemoteException unused2) {
                        o4.b(f30306b, "RemoteException");
                    }
                    o4.d("scankit mul", "iRemoteDecoderDelegate rollback");
                    if (mLFrame.readBitmap() != null) {
                        detectWithByteBuffer2 = f30305a.decodeInBitmap(detailRect, ObjectWrapper.wrap(mLFrame.readBitmap()), ObjectWrapper.wrap(bundle));
                    } else {
                        detectWithByteBuffer2 = f30305a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(mLFrame.acquireGrayByteBuffer()), ObjectWrapper.wrap(bundle));
                    }
                    detectWithByteBuffer = detectWithByteBuffer2;
                }
                if (detectWithByteBuffer != null) {
                    return detectWithByteBuffer;
                }
            } catch (RemoteException unused3) {
                o4.b("exception", "RemoteException");
            }
        }
        return hmsScanArr;
    }

    public static HmsScan[] a(Context context, HmsScanFrame hmsScanFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        HmsScan[] detectWithByteBuffer;
        HmsScan[] detectWithByteBuffer2;
        o4.d("scankit mul", "start detectForHmsDector");
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (f30305a == null) {
            IRemoteCreator c4 = g.c(context);
            if (c4 == null) {
                return hmsScanArr;
            }
            try {
                f30305a = c4.newRemoteHmsDecoderDelegate();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }
        if (f30305a != null) {
            try {
                DetailRect detailRect = new DetailRect(hmsScanFrame.getWidth(), hmsScanFrame.getHeight());
                Bundle bundle = new Bundle();
                if (hmsScanAnalyzerOptions != null) {
                    bundle.putInt(DetailRect.FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
                    bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
                    bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                }
                bundle.putBoolean(DetailRect.SUPPORT_ROLLBACK, g.f30318c);
                bundle.putBoolean(DetailRect.USE_APK, g.f30316a);
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putBoolean(DetailRect.NEW_VERSION, true);
                bundle.putString(DetailRect.CP_PACKAGE, y3.b(context));
                bundle.putAll(y3.a(context));
                if (hmsScanFrame.getBitmap() != null) {
                    o4.d("scankit mul", "end detectForHmsDector");
                    detectWithByteBuffer = f30305a.decodeInBitmap(detailRect, ObjectWrapper.wrap(hmsScanFrame.getBitmap()), ObjectWrapper.wrap(bundle));
                } else {
                    detectWithByteBuffer = f30305a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(ByteBuffer.wrap(hmsScanFrame.getYuvImage().getYuvData())), ObjectWrapper.wrap(bundle));
                }
                f.a(detectWithByteBuffer);
                if (g.a()) {
                    IRemoteCreator c10 = g.c(context);
                    if (c10 == null) {
                        return hmsScanArr;
                    }
                    try {
                        f30305a = c10.newRemoteHmsDecoderDelegate();
                    } catch (RemoteException unused2) {
                        o4.b(f30306b, "RemoteException");
                    }
                    o4.d("scankit mul", "iRemoteDecoderDelegate rollback");
                    if (hmsScanFrame.getBitmap() != null) {
                        detectWithByteBuffer2 = f30305a.decodeInBitmap(detailRect, ObjectWrapper.wrap(hmsScanFrame.getBitmap()), ObjectWrapper.wrap(bundle));
                    } else {
                        detectWithByteBuffer2 = f30305a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(ByteBuffer.wrap(hmsScanFrame.getYuvImage().getYuvData())), ObjectWrapper.wrap(bundle));
                    }
                    detectWithByteBuffer = detectWithByteBuffer2;
                }
                if (detectWithByteBuffer != null) {
                    return detectWithByteBuffer;
                }
            } catch (RemoteException unused3) {
                o4.b("exception", "RemoteException");
            }
        }
        return hmsScanArr;
    }
}
