package com.tencent.cloud.huiyansdkface.record;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeMediaManager {

    /* renamed from: a, reason: collision with root package name */
    private static String f42134a = "WeMediaManager";

    /* renamed from: i, reason: collision with root package name */
    private static WeMediaManager f42135i = new WeMediaManager();

    /* renamed from: b, reason: collision with root package name */
    private WeWrapMp4Jni f42136b = new WeWrapMp4Jni();

    /* renamed from: c, reason: collision with root package name */
    private boolean f42137c = false;

    /* renamed from: d, reason: collision with root package name */
    private WeMediaCodec f42138d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f42139e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f42140f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f42141g = false;

    /* renamed from: h, reason: collision with root package name */
    private int f42142h = 50;

    private WeMediaManager() {
    }

    public static WeMediaManager getInstance() {
        return f42135i;
    }

    public boolean createMediaCodec(Context context, int i10, int i11, int i12) {
        WeMediaCodec weMediaCodec = new WeMediaCodec(context, this.f42136b, i10, i11, i12, this.f42142h);
        this.f42138d = weMediaCodec;
        boolean z10 = weMediaCodec.initMediaCodec(context);
        this.f42140f = z10;
        return z10;
    }

    public void destroy() {
        WeMediaCodec weMediaCodec;
        stop(false);
        if (!this.f42140f || (weMediaCodec = this.f42138d) == null) {
            return;
        }
        try {
            weMediaCodec.destroy();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f42138d = null;
    }

    public void enableDebug() {
        this.f42141g = true;
    }

    public byte[] getVideoByte() {
        WeMediaCodec weMediaCodec = this.f42138d;
        return (weMediaCodec == null || weMediaCodec.getVideoByte() == null) ? new byte[0] : this.f42138d.getVideoByte().toByteArray();
    }

    public void init(int i10) {
        WLogger.i(f42134a, "init");
        this.f42142h = i10 + 1;
        WLogger.i(f42134a, "init maxFrameNum=" + this.f42142h);
    }

    public void onPreviewFrame(byte[] bArr) {
        if (this.f42137c) {
            this.f42138d.onPreviewFrame(bArr);
        }
    }

    public void resetVideoByte() {
        WeMediaCodec weMediaCodec = this.f42138d;
        if (weMediaCodec == null || weMediaCodec.getVideoByte() == null) {
            return;
        }
        this.f42138d.getVideoByte().reset();
    }

    public void start(WbRecordFinishListener wbRecordFinishListener) {
        WLogger.i(f42134a, "WeMediaManager start " + System.currentTimeMillis());
        if (this.f42137c) {
            return;
        }
        this.f42137c = true;
        this.f42138d.start(wbRecordFinishListener);
    }

    public void stop(boolean z10) {
        WLogger.i(f42134a, "WeMediaManager stop " + System.currentTimeMillis());
        if (this.f42137c) {
            this.f42137c = false;
            this.f42138d.stop();
        }
    }
}
