package com.huawei.hms.scankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.e5;
import com.huawei.hms.scankit.p.f5;
import com.huawei.hms.scankit.p.i8;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.u6;
import com.huawei.hms.scankit.p.v5;
import com.huawei.hms.scankit.p.v6;
import java.util.Collection;
import java.util.Map;

/* compiled from: CaptureHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends Handler implements v6 {

    /* renamed from: a, reason: collision with root package name */
    private final f5 f30511a;

    /* renamed from: b, reason: collision with root package name */
    private d f30512b;

    /* renamed from: c, reason: collision with root package name */
    private final int f30513c;

    /* renamed from: d, reason: collision with root package name */
    private EnumC0324a f30514d;

    /* renamed from: e, reason: collision with root package name */
    private Context f30515e;

    /* renamed from: f, reason: collision with root package name */
    private final j0 f30516f;

    /* renamed from: g, reason: collision with root package name */
    private final ViewfinderView f30517g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f30518h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f30519i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f30520j;

    /* renamed from: k, reason: collision with root package name */
    private e5 f30521k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f30522l;

    /* compiled from: CaptureHandler.java */
    /* renamed from: com.huawei.hms.scankit.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum EnumC0324a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public a(Context context, ViewfinderView viewfinderView, f5 f5Var, Collection<BarcodeFormat> collection, Map<l1, ?> map, String str, j0 j0Var, Rect rect, int i10, boolean z10, boolean z11) {
        this.f30517g = viewfinderView;
        this.f30511a = f5Var;
        this.f30513c = i10;
        this.f30515e = context;
        d dVar = new d(context, j0Var, this, collection, map, str, this);
        this.f30512b = dVar;
        dVar.a(rect);
        this.f30512b.a(z11);
        this.f30512b.start();
        this.f30522l = z10;
        j0Var.a(new j(this.f30512b));
        this.f30514d = EnumC0324a.SUCCESS;
        this.f30516f = j0Var;
        j0Var.p();
        o4.a("scan-time", "start preview time:" + System.currentTimeMillis());
        f();
        v5.a(null);
    }

    public void a(e5 e5Var) {
        this.f30521k = e5Var;
    }

    public int b() {
        return this.f30513c;
    }

    public void c(boolean z10) {
        this.f30518h = z10;
    }

    public boolean d() {
        return this.f30520j;
    }

    public void e() {
        this.f30514d = EnumC0324a.DONE;
        this.f30516f.q();
        Message.obtain(this.f30512b.a(), R.id.scankit_quit).sendToTarget();
        try {
            this.f30512b.b();
            this.f30512b.join(50L);
        } catch (InterruptedException unused) {
            o4.e("CaptureHandler", "quitSynchronously   wait interrupt");
        }
        this.f30512b = null;
        removeMessages(R.id.scankit_decode_succeeded);
        removeMessages(R.id.scankit_decode_failed);
    }

    public void f() {
        if (this.f30514d == EnumC0324a.SUCCESS) {
            this.f30514d = EnumC0324a.PREVIEW;
            this.f30516f.o();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == R.id.scankit_restart_preview) {
            f();
            return;
        }
        if (i10 == R.id.scankit_decode_succeeded) {
            this.f30514d = EnumC0324a.SUCCESS;
            Object obj = message.obj;
            if (obj instanceof HmsScan[]) {
                HmsScan[] hmsScanArr = (HmsScan[]) obj;
                if (hmsScanArr.length > 0 && hmsScanArr[0] != null && !TextUtils.isEmpty(hmsScanArr[0].originalValue)) {
                    o4.d("CaptureHandler", "scan successful");
                    Bitmap bitmap = null;
                    float f10 = 0.0f;
                    if (this.f30519i) {
                        o4.d("CaptureHandler", "scan successful & return bitmap");
                        Bundle data = message.getData();
                        if (data != null) {
                            byte[] byteArray = data.getByteArray("barcode_bitmap");
                            f10 = data.getFloat("barcode_scaled_factor", 0.0f);
                            if (byteArray != null && byteArray.length > 0) {
                                bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                            }
                        }
                        this.f30511a.a(hmsScanArr, bitmap, f10);
                    } else {
                        this.f30511a.a(hmsScanArr, null, 0.0f);
                    }
                    if (!this.f30522l) {
                        return;
                    }
                } else {
                    o4.d("CaptureHandler", "retrieve  HmsScan lenth is 0");
                }
                f();
                return;
            }
            return;
        }
        if (i10 == R.id.scankit_decode_failed) {
            this.f30514d = EnumC0324a.PREVIEW;
            this.f30516f.o();
        }
    }

    private u6 b(u6 u6Var) {
        float b4;
        float c4;
        int max;
        Point b10 = i8.b(this.f30515e);
        Point e2 = this.f30516f.e();
        int i10 = b10.x;
        int i11 = b10.y;
        if (i10 < i11) {
            b4 = (u6Var.b() * ((i10 * 1.0f) / e2.y)) - (Math.max(b10.x, e2.y) / 2.0f);
            c4 = u6Var.c() * ((i11 * 1.0f) / e2.x);
            max = Math.min(b10.y, e2.x);
        } else {
            b4 = (u6Var.b() * ((i10 * 1.0f) / e2.x)) - (Math.min(b10.y, e2.y) / 2.0f);
            c4 = u6Var.c() * ((i11 * 1.0f) / e2.y);
            max = Math.max(b10.x, e2.x);
        }
        return new u6(b4, c4 - (max / 2.0f));
    }

    public boolean a() {
        e5 e5Var = this.f30521k;
        if (e5Var != null) {
            return e5Var.a();
        }
        return false;
    }

    public boolean c() {
        return this.f30519i;
    }

    @Override // com.huawei.hms.scankit.p.v6
    public void a(u6 u6Var) {
        if (this.f30517g != null) {
            this.f30517g.a(b(u6Var));
        }
    }

    public void a(boolean z10) {
        this.f30519i = z10;
    }

    public void b(boolean z10) {
        this.f30520j = z10;
    }
}
