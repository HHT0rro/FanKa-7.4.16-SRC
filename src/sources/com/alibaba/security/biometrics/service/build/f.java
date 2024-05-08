package com.alibaba.security.biometrics.service.build;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.Key;
import com.alibaba.security.biometrics.jni.ABJniDetectResult;
import com.alibaba.security.biometrics.jni.ABJniDetectState;
import com.alibaba.security.biometrics.jni.ABJniDetectType;
import com.alibaba.security.biometrics.jni.ABJniFailReason;
import com.alibaba.security.biometrics.jni.ABJniPromptMessage;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.ALBiometricsServiceEventListener;
import com.alibaba.security.biometrics.service.build.e;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.params.ABParamsHelper;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.FileUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.common.utils.SystemUtils;
import com.alibaba.security.realidentity.build.aq;
import com.huawei.hianalytics.core.transport.net.Response;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: ABFrameDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class f extends j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2735a = "fdmodel.bin";

    /* renamed from: b, reason: collision with root package name */
    public static final String f2736b = "ldmodel.bin";

    /* renamed from: c, reason: collision with root package name */
    public static final String f2737c = "ldClassifier.bin";

    /* renamed from: d, reason: collision with root package name */
    public static final String f2738d = "faceContinuity.bin";

    /* renamed from: x, reason: collision with root package name */
    private static final String f2739x = "ABFrameDetector";
    private float[] A;
    private Rect B;
    private byte[] C;
    private byte[] D;
    private byte[] E;
    private float[] F;

    /* renamed from: e, reason: collision with root package name */
    public final t f2740e;

    /* renamed from: f, reason: collision with root package name */
    public Context f2741f;

    /* renamed from: g, reason: collision with root package name */
    public ALBiometricsParams f2742g;

    /* renamed from: h, reason: collision with root package name */
    public String f2743h;

    /* renamed from: i, reason: collision with root package name */
    public ABDetectType f2744i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<ABFaceFrame> f2745j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2746k;

    /* renamed from: p, reason: collision with root package name */
    public int f2751p;

    /* renamed from: q, reason: collision with root package name */
    public e f2752q;

    /* renamed from: r, reason: collision with root package name */
    public byte[] f2753r;

    /* renamed from: y, reason: collision with root package name */
    private final ALBiometricsServiceEventListener f2755y;

    /* renamed from: z, reason: collision with root package name */
    private byte[] f2756z;

    /* renamed from: l, reason: collision with root package name */
    public int f2747l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f2748m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f2749n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f2750o = -1;

    /* renamed from: s, reason: collision with root package name */
    public float f2754s = -1.0f;

    /* compiled from: ABFrameDetector.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<f> f2757a;

        private a(f fVar) {
            this.f2757a = new WeakReference<>(fVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            this.f2757a.get();
            super.handleMessage(message);
        }
    }

    public f(t tVar, ALBiometricsServiceEventListener aLBiometricsServiceEventListener) {
        this.f2740e = tVar;
        this.f2755y = aLBiometricsServiceEventListener;
    }

    private void b(int i10) {
        a(TrackLog.createSdkExceptionLog("face recap fail: ".concat(String.valueOf(i10))));
    }

    private ABJniDetectResult n() {
        ABJniDetectResult aBJniDetectResult = new ABJniDetectResult();
        aBJniDetectResult.reflectCmd = this.f2750o;
        aBJniDetectResult.reflectDetectType = this.f2751p;
        aBJniDetectResult.illuminance = this.f2754s;
        return aBJniDetectResult;
    }

    private float o() {
        return this.f2754s;
    }

    private boolean p() {
        this.f2774w.e(GlobalErrorCode.ERROR_ALGO_MUCH_MINE, new Bundle());
        return true;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final String a() {
        return !this.f2746k ? ALBiometricsJni.getVersion() : "";
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final boolean c() {
        return this.f2746k && ALBiometricsJni.IsEnabled();
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final ABDetectType d() {
        return this.f2744i;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final ArrayList<ABFaceFrame> e() {
        if (this.f2746k) {
            return this.f2745j;
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final Rect f() {
        return this.B;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final byte[] g() {
        if (this.f2746k) {
            return this.f2756z;
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final float[] h() {
        return this.A;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final byte[] i() {
        if (this.f2746k) {
            return this.C;
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final byte[] j() {
        if (this.f2746k) {
            return this.D;
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final byte[] k() {
        if (this.f2746k) {
            return this.E;
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final float[] l() {
        return this.F;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final String m() {
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final void b() {
        Handler handler;
        this.f2745j = null;
        if (this.f2746k) {
            ALBiometricsJni.release();
        }
        e eVar = this.f2752q;
        if (eVar != null) {
            if (ALBiometricsJni.isLoaded()) {
                ALBiometricsJni.release();
            }
            if (eVar.f2712h != null && (handler = eVar.f2716l) != null) {
                handler.post(new e.AnonymousClass4());
            }
            eVar.f2713i = 0;
            eVar.f2714j = 0L;
            eVar.f2717m = false;
        }
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final boolean a(Context context, ALBiometricsParams aLBiometricsParams) {
        int checkLicense;
        if (!SystemUtils.supportNEON()) {
            a(GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_NEON, "");
            return false;
        }
        this.f2741f = context;
        this.f2742g = aLBiometricsParams;
        this.f2745j = new ArrayList<>();
        if (this.f2742g == null) {
            this.f2742g = new ABParamsHelper(new Bundle()).getParams();
        }
        this.f2743h = ((Object) context.getFilesDir()) + "/flm/";
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f2743h);
        String str = f2735a;
        sb2.append(f2735a);
        if (FileUtils.copyAssetData(context, f2735a, sb2.toString())) {
            arrayList.add(f2735a);
            if (FileUtils.copyAssetData(context, f2736b, this.f2743h + f2736b)) {
                arrayList.add(f2736b);
                if (FileUtils.copyAssetData(context, f2737c, this.f2743h + f2737c)) {
                    arrayList.add(f2737c);
                    if (FileUtils.copyAssetData(context, f2738d, this.f2743h + f2738d)) {
                        arrayList.add(f2738d);
                        str = null;
                    } else {
                        str = f2738d;
                    }
                } else {
                    str = f2737c;
                }
            } else {
                str = f2736b;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            a(GlobalErrorCode.ERROR_ALGO_MODEL_COPY_FAIL, str);
            return false;
        }
        ALBiometricsJni.bhL(4, "");
        ALBiometricsParams aLBiometricsParams2 = this.f2742g;
        byte[] bArr = aLBiometricsParams2.licenseData;
        if (bArr == null && aLBiometricsParams2.licenseTimeData == null) {
            checkLicense = ALBiometricsJni.checkLicense(context, this.f2755y);
        } else {
            checkLicense = ALBiometricsJni.checkLicense(context, bArr, aLBiometricsParams2.licenseTimeData);
        }
        boolean z10 = checkLicense == 0;
        this.f2746k = z10;
        if (!z10) {
            a(GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL, String.valueOf(checkLicense));
            return this.f2746k;
        }
        this.f2747l = 0;
        this.f2748m = 0;
        this.f2749n = 0;
        this.f2750o = -1;
        this.f2751p = -1;
        ALBiometricsJni.release();
        if (this.f2742g.recapEnable) {
            e a10 = e.a();
            this.f2752q = a10;
            a10.a(this.f2741f, this.f2742g, this.f2755y);
        }
        return this.f2746k;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final Bundle b(byte[] bArr, int i10, int i11, int i12) {
        try {
            if (!this.f2746k) {
                return null;
            }
            if ((ALBiometricsJni.IsEnabled() && (i10 != this.f2747l || i11 != this.f2748m || i12 != this.f2749n)) || !ALBiometricsJni.IsEnabled()) {
                return null;
            }
            ABJniDetectResult aBJniDetectResult = new ABJniDetectResult();
            if (ALBiometricsJni.doDetectContinue(bArr, aBJniDetectResult, GetCacheDataManager.getInstance().getUmidToken()) != 0 || !aBJniDetectResult.faceExist) {
                return null;
            }
            Bundle bundle = new Bundle();
            byte[] bArr2 = aBJniDetectResult.bigImgBuffer;
            if (bArr2 != null) {
                bundle.putByteArray("img", bArr2);
            }
            bundle.putInt("width", aBJniDetectResult.bigImgWidth);
            bundle.putInt("height", aBJniDetectResult.bigImgHeight);
            bundle.putIntArray("rect", new int[]{aBJniDetectResult.faceLeft, aBJniDetectResult.faceTop, aBJniDetectResult.faceWidth, aBJniDetectResult.faceHeight});
            float[] fArr = aBJniDetectResult.faceKeyPointInBigImg;
            if (fArr != null) {
                bundle.putFloatArray("landmarks", fArr);
            }
            return bundle;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String a(Context context) {
        ArrayList arrayList = new ArrayList();
        if (!FileUtils.copyAssetData(context, f2735a, this.f2743h + f2735a)) {
            return f2735a;
        }
        arrayList.add(f2735a);
        if (!FileUtils.copyAssetData(context, f2736b, this.f2743h + f2736b)) {
            return f2736b;
        }
        arrayList.add(f2736b);
        if (!FileUtils.copyAssetData(context, f2737c, this.f2743h + f2737c)) {
            return f2737c;
        }
        arrayList.add(f2737c);
        if (!FileUtils.copyAssetData(context, f2738d, this.f2743h + f2738d)) {
            return f2738d;
        }
        arrayList.add(f2738d);
        return null;
    }

    private static boolean a(Context context, String str, String str2) {
        return FileUtils.copyAssetData(context, str, str2);
    }

    public final void a(TrackLog trackLog) {
        s sVar = this.f2774w;
        if (sVar != null) {
            sVar.a(trackLog);
        }
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final void a(boolean z10) {
        if (this.f2746k) {
            ALBiometricsJni.Reset(z10);
        }
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final void a(ABDetectType aBDetectType, boolean z10) {
        if (this.f2746k) {
            this.f2744i = aBDetectType;
            if (ALBiometricsJni.IsEnabled()) {
                ALBiometricsJni.changeDetectType(a(aBDetectType), z10);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01b1  */
    @Override // com.alibaba.security.biometrics.service.build.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(byte[] r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.biometrics.service.build.f.a(byte[], int, int, int):boolean");
    }

    private void a(ABJniDetectResult aBJniDetectResult) {
        float[] fArr;
        int i10;
        if (!this.f2742g.recapEnable || this.f2752q == null || !e.d() || aBJniDetectResult == null || (fArr = aBJniDetectResult.faceKeyPoint) == null || !aBJniDetectResult.faceExist || aBJniDetectResult.outOfRegion) {
            return;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        if (this.f2753r == null) {
            this.f2753r = new byte[38400];
        }
        int GetRecapPatch = ALBiometricsJni.GetRecapPatch(this.f2753r);
        if (GetRecapPatch == 0) {
            e eVar = this.f2752q;
            byte[] bArr = this.f2753r;
            if (!ALBiometricsJni.isLoaded()) {
                i10 = e.f2703a;
            } else if (copyOf == null) {
                i10 = e.f2706d;
            } else if (eVar.f2712h == null) {
                i10 = e.f2708f;
            } else {
                if (!eVar.f2717m && !eVar.f2718n && System.currentTimeMillis() - eVar.f2719o > 200) {
                    eVar.f2719o = System.currentTimeMillis();
                    if (eVar.f2715k == null) {
                        HandlerThread handlerThread = new HandlerThread("ALBiometrics.ABFaceRecapDetector");
                        eVar.f2715k = handlerThread;
                        handlerThread.start();
                        eVar.f2716l = new Handler(eVar.f2715k.getLooper());
                    }
                    eVar.f2716l.post(new e.AnonymousClass2(bArr));
                }
                GetRecapPatch = 0;
            }
            GetRecapPatch = i10;
        }
        if (GetRecapPatch != 0) {
            a(TrackLog.createSdkExceptionLog("face recap fail: ".concat(String.valueOf(GetRecapPatch))));
        }
    }

    private boolean a(int i10, int i11, int i12) {
        int i13;
        if (ALBiometricsJni.IsEnabled()) {
            i13 = i12;
        } else {
            ALBiometricsJni.SetParameter(1, this.f2742g.validRegionLeft);
            ALBiometricsJni.SetParameter(2, this.f2742g.validRegionTop);
            ALBiometricsJni.SetParameter(3, this.f2742g.validRegionRight);
            ALBiometricsJni.SetParameter(4, this.f2742g.validRegionBottom);
            if (this.f2742g.lessImageMode) {
                ALBiometricsJni.SetParameter(26, r1.bigImageSize);
            }
            ALBiometricsJni.SetParameter(37, this.f2742g.detectWrongAction ? 1.0f : 0.0f);
            ALBiometricsJni.SetParameter(38, this.f2742g.detectOcclusion ? 1.0f : 0.0f);
            int i14 = this.f2742g.bgDetectTimeIntervals;
            if (i14 >= 0) {
                ALBiometricsJni.SetParameter(39, i14);
            }
            int i15 = this.f2742g.bgDetectColorThreshold;
            if (i15 >= 0) {
                ALBiometricsJni.SetParameter(40, i15);
            }
            this.f2750o = -1;
            this.f2751p = -1;
            String str = this.f2743h + f2735a;
            String str2 = this.f2743h + f2736b;
            String str3 = this.f2743h + f2737c;
            String str4 = this.f2743h + f2738d;
            ALBiometricsParams aLBiometricsParams = this.f2742g;
            int init = ALBiometricsJni.init(i10, i11, i12, str, str2, str3, str4, aLBiometricsParams.secToken, aLBiometricsParams.mBiometricsType);
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.valueOf(i10));
            hashMap.put("height", Integer.valueOf(i11));
            hashMap.put(Key.ROTATION, Integer.valueOf(i12));
            hashMap.put("fdPath", this.f2743h + f2735a);
            hashMap.put("ldPath", this.f2743h + f2736b);
            hashMap.put("ldClaPath", this.f2743h + f2737c);
            hashMap.put("fcPath", this.f2743h + f2738d);
            hashMap.put("errorCode", Integer.valueOf(init));
            hashMap.put(aq.f3108d, this.f2742g.secToken);
            ALBiometricsJni.bhL(8, JsonUtils.toJSON(hashMap));
            if (init != 0) {
                a(GlobalErrorCode.ERROR_ALGO_INIT_FAIL, JsonUtils.toJSON(hashMap));
                return false;
            }
            this.f2747l = i10;
            this.f2748m = i11;
            i13 = i12;
            this.f2749n = i13;
            a(this.f2744i, false);
        }
        if (!ALBiometricsJni.IsEnabled()) {
            return true;
        }
        if (i10 == this.f2747l && i11 == this.f2748m && i13 == this.f2749n) {
            return true;
        }
        ALBiometricsJni.release();
        return true;
    }

    private void a(float f10) {
        this.f2754s = f10;
    }

    @Override // com.alibaba.security.biometrics.service.build.j
    public final void a(int i10) {
        this.f2750o = 0;
        this.f2751p = i10;
    }

    private f a(Rect rect) {
        this.B = rect;
        return this;
    }

    public final void a(int i10, String str) {
        if (this.f2774w != null) {
            Bundle bundle = new Bundle();
            bundle.putString(ALBiometricsKeys.KEY_ERROR_MESSAGE, str);
            this.f2774w.e(i10, bundle);
        }
    }

    public final boolean a(byte[] bArr, int i10, int i11, int i12, ABJniDetectResult aBJniDetectResult) {
        if (this.f2774w == null) {
            return false;
        }
        if (this.f2750o == 1 && (aBJniDetectResult.reflectResult == 0 || aBJniDetectResult.reflectFrames >= 5)) {
            this.f2750o = 2;
        }
        if (this.f2750o == 0) {
            this.f2750o = 1;
        }
        ABDetectFrame aBDetectFrame = new ABDetectFrame(aBJniDetectResult, bArr, i10, i11, i12);
        if (aBJniDetectResult.detectState() == ABJniDetectState.DETECT_STATE_FAIL) {
            int a10 = a(aBJniDetectResult.failReason());
            Bundle bundle = new Bundle();
            bundle.putString("alg_m", aBJniDetectResult.failLog);
            bundle.putInt("alg_fr", aBJniDetectResult.failReason() == null ? Response.Code.INTERNET_PERMISSION_ERROR : aBJniDetectResult.failReason().getValue());
            bundle.putString(ALBiometricsKeys.KEY_RESULT_MESSAGE, aBJniDetectResult.failReason().getMessage());
            bundle.putInt("ec", aBJniDetectResult.f2423ec);
            bundle.putInt("etcc", aBJniDetectResult.etcc);
            bundle.putInt("ecpc", aBJniDetectResult.ecpc);
            bundle.putString("ecResult", aBJniDetectResult.ecResult);
            bundle.putString(ALBiometricsKeys.KEY_ERROR_MESSAGE, "algo detect fail");
            this.f2774w.d(a10, bundle);
        } else if (aBJniDetectResult.detectState() == ABJniDetectState.DETECT_STATE_SUC) {
            this.f2756z = aBJniDetectResult.bigImgBuffer;
            this.A = aBJniDetectResult.faceKeyPointInBigImg;
            this.C = aBJniDetectResult.globalImgBuffer;
            this.D = aBJniDetectResult.localImgBuffer;
            this.E = aBJniDetectResult.frameBuffer;
            this.F = aBJniDetectResult.faceKeyPoint;
            int i13 = aBJniDetectResult.faceLeft;
            int i14 = aBJniDetectResult.faceTop;
            int i15 = aBJniDetectResult.faceWidth;
            this.B = new Rect(i13, i14, i13 + i15, i15 + i14);
            this.f2745j.clear();
            this.f2745j.add(new i(aBJniDetectResult.actionImgBuffer[0], aBJniDetectResult.actionImgWidth, aBJniDetectResult.actionImgHeight, aBJniDetectResult.iso));
            this.f2745j.add(new i(aBJniDetectResult.actionImgBuffer[1], aBJniDetectResult.actionImgWidth, aBJniDetectResult.actionImgHeight, aBJniDetectResult.iso));
            ABDetectType a11 = this.f2774w.a(aBDetectFrame, this.f2744i);
            if (a11 != ABDetectType.DONE || a11 != ABDetectType.NONE) {
                a(a11, true);
            }
        } else if (aBJniDetectResult.detectState() == ABJniDetectState.DETECT_STATE_DETECTING) {
            String message = aBJniDetectResult.promptMessage().getMessage();
            Bundle bundle2 = new Bundle();
            bundle2.putInt(ALBiometricsKeys.KEY_RESULT_CODE, aBJniDetectResult.promptMessage().getValue());
            bundle2.putString(ALBiometricsKeys.KEY_RESULT_MESSAGE, message);
            aBDetectFrame.setMsgCode(a(aBJniDetectResult.promptMessage()));
            this.f2774w.e(aBDetectFrame.getMsgCode(), bundle2);
        }
        this.f2774w.a(aBDetectFrame);
        return true;
    }

    private static ABJniDetectType a(ABDetectType aBDetectType) {
        if (aBDetectType == ABDetectType.AIMLESS) {
            return ABJniDetectType.DETECT_TYPE_AIMLESS;
        }
        if (aBDetectType == ABDetectType.BLINK) {
            return ABJniDetectType.DETECT_TYPE_BLINK;
        }
        if (aBDetectType == ABDetectType.POS_PITCH) {
            return ABJniDetectType.DETECT_TYPE_PITCH;
        }
        if (aBDetectType == ABDetectType.POS_PITCH_DOWN) {
            return ABJniDetectType.DETECT_TYPE_PITCH;
        }
        if (aBDetectType == ABDetectType.POS_PITCH_UP) {
            return ABJniDetectType.DETECT_TYPE_PITCH;
        }
        if (aBDetectType == ABDetectType.KEEP_STILL) {
            return ABJniDetectType.DETECT_TYPE_STILL;
        }
        if (aBDetectType == ABDetectType.POS_YAW) {
            return ABJniDetectType.DETECT_TYPE_YAW;
        }
        if (aBDetectType == ABDetectType.MOUTH) {
            return ABJniDetectType.DETECT_TYPE_MOUTH;
        }
        if (aBDetectType == ABDetectType.PITCH_STILL) {
            return ABJniDetectType.DETECT_TYPE_PITCH_STILL;
        }
        if (aBDetectType == ABDetectType.YAW_STILL) {
            return ABJniDetectType.DETECT_TYPE_YAW_STILL;
        }
        if (aBDetectType == ABDetectType.MOUTH_STILL) {
            return ABJniDetectType.DETECT_TYPE_MOUTH_STILL;
        }
        if (aBDetectType == ABDetectType.BLINK_STILL) {
            return ABJniDetectType.DETECT_TYPE_BLINK_STILL;
        }
        return ABJniDetectType.DETECT_TYPE_AIMLESS;
    }

    private static int a(ABJniFailReason aBJniFailReason) {
        if (ABJniFailReason.FAIL_ACTION_MOUTH_OCCLUSION.equals(aBJniFailReason)) {
            return 6;
        }
        if (ABJniFailReason.FAIL_ACTION_PITCH_FACE_DISAPPEAR.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_PITCH_FACE_CHANGE.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_FACE_DISAPPEAR.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_FACE_CHANGE.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_MOUTH_FACE_DISAPPEAR.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_MOUTH_FACE_CHANGE.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_OCCLUSION.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_FACE_DISAPPEAR.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_FACE_CHANGE.equals(aBJniFailReason)) {
            return 1;
        }
        if (ABJniFailReason.FAIL_ACTION_PITCH_GET_YAW.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_PITCH_GET_MOUTH.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_GET_PITCH.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_GET_MOUTH.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_MOUTH_GET_PITCH.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_MOUTH_GET_YAW.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_GET_YAW.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_GET_MOUTH.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_GET_PITCH.equals(aBJniFailReason)) {
            return 0;
        }
        if (ABJniFailReason.FAIL_STILL_TIMEOUT.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_TIMEOUT.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_MOUTH_TIMEOUT.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_PITCH_TIMEOUT.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_BLINK_TIMEOUT.equals(aBJniFailReason) || ABJniFailReason.FAIL_NO_FACE_DETECT.equals(aBJniFailReason)) {
            return 2;
        }
        if (ABJniFailReason.FAIL_ACTION_PITCH_NOT_3D.equals(aBJniFailReason) || ABJniFailReason.FAIL_ACTION_YAW_NOT_3D.equals(aBJniFailReason)) {
            return 5;
        }
        if (ABJniFailReason.FAIL_NONE.equals(aBJniFailReason)) {
            return -1;
        }
        if (ABJniFailReason.FAIL_STILL_OUT_OF_REGION.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_TOO_SMALL.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_TOO_BIG.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_LIGHT_UNEVEN.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_NOT_STILL.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_TOO_DARK.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_PITCH_TOO_BIG.equals(aBJniFailReason) || ABJniFailReason.FAIL_STILL_YAW_TOO_BIG.equals(aBJniFailReason)) {
            return 2;
        }
        if (aBJniFailReason != null) {
            return aBJniFailReason.getValue();
        }
        return -1;
    }

    private static int a(ABJniPromptMessage aBJniPromptMessage) {
        if (ABJniPromptMessage.PROMPT_PUT_FACE_IN_REGION.equals(aBJniPromptMessage)) {
            return 1002;
        }
        if (ABJniPromptMessage.PROMPT_MOVE_CLOSE.equals(aBJniPromptMessage)) {
            return 1008;
        }
        if (ABJniPromptMessage.PROMPT_MOVE_FAR.equals(aBJniPromptMessage)) {
            return 1007;
        }
        if (ABJniPromptMessage.PROMPT_FACE_YAW_TOO_BIG.equals(aBJniPromptMessage)) {
            return 1013;
        }
        if (ABJniPromptMessage.PROMPT_FACE_PITCH_TOO_BIG.equals(aBJniPromptMessage)) {
            return 1054;
        }
        if (ABJniPromptMessage.PROMPT_TOO_DARK.equals(aBJniPromptMessage)) {
            return 1001;
        }
        if (ABJniPromptMessage.PROMPT_FACE_UNEVEN.equals(aBJniPromptMessage)) {
            return 1055;
        }
        if (ABJniPromptMessage.PROMPT_KEEP_STILL.equals(aBJniPromptMessage)) {
            return 1004;
        }
        return ABJniPromptMessage.PROMPT_GESTURE_SMALL.equals(aBJniPromptMessage) ? 1053 : 0;
    }
}
