package com.alibaba.security.biometrics.service.model;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.detector.ABFaceFrame;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ABDetectContext {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2863a = "ABDetectContext";

    /* renamed from: b, reason: collision with root package name */
    private static ABDetectContext f2864b;

    /* renamed from: c, reason: collision with root package name */
    private ALBiometricsResult f2865c;

    /* renamed from: d, reason: collision with root package name */
    private ABActionResult f2866d;

    /* renamed from: e, reason: collision with root package name */
    private ABFaceFrame f2867e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2869g;

    /* renamed from: h, reason: collision with root package name */
    private int f2870h;

    /* renamed from: q, reason: collision with root package name */
    private List<ABDetectType> f2879q;

    /* renamed from: f, reason: collision with root package name */
    private int f2868f = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f2872j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f2873k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f2874l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f2875m = 270;

    /* renamed from: n, reason: collision with root package name */
    private long f2876n = -1;

    /* renamed from: o, reason: collision with root package name */
    private int f2877o = 0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f2878p = false;

    /* renamed from: r, reason: collision with root package name */
    private int f2880r = -1;

    /* renamed from: s, reason: collision with root package name */
    private ABDetectType f2881s = ABDetectType.DONE;

    /* renamed from: u, reason: collision with root package name */
    private boolean f2883u = false;

    /* renamed from: i, reason: collision with root package name */
    private Bundle f2871i = new Bundle();

    /* renamed from: t, reason: collision with root package name */
    private ABDetectPhase f2882t = ABDetectPhase.INIT;

    private ABDetectContext() {
    }

    private void a() {
        this.f2869g = false;
        this.f2870h = -100;
        this.f2872j = 0;
        this.f2867e = null;
        this.f2877o = 0;
        this.f2876n = 0L;
        this.f2878p = false;
    }

    public static ABDetectContext getInstance() {
        if (f2864b == null) {
            f2864b = new ABDetectContext();
        }
        return f2864b;
    }

    public void destroy() {
        List<ABDetectType> list = this.f2879q;
        if (list != null) {
            list.clear();
        }
    }

    public int getActionCount() {
        List<ABDetectType> list = this.f2879q;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<ABDetectType> getActions() {
        return this.f2879q;
    }

    public ABFaceFrame getBestFrame() {
        return this.f2867e;
    }

    public ABDetectType getCurrentAction() {
        return this.f2881s;
    }

    public int getCurrentActionIndex() {
        return this.f2880r;
    }

    public ABActionResult getCurrentActionResult() {
        return this.f2866d;
    }

    public int getCurrentActionStep() {
        return this.f2880r + 1;
    }

    public ABDetectPhase getCurrentPhase() {
        return this.f2882t;
    }

    public int getDisplayHeight() {
        return this.f2874l;
    }

    public int getDisplayWidth() {
        return this.f2873k;
    }

    public int getFrameCount() {
        return this.f2872j;
    }

    public int getLastDetectFailedType() {
        return this.f2870h;
    }

    public int getQualityImageCount() {
        return this.f2877o;
    }

    public long getQualityImageTime() {
        return this.f2876n;
    }

    public Bundle getRecordData() {
        return this.f2871i;
    }

    public ALBiometricsResult getResult() {
        if (this.f2865c == null) {
            this.f2865c = new ALBiometricsResult();
        }
        return this.f2865c;
    }

    public int getRetryTimes() {
        return this.f2868f;
    }

    public int getRotationAngle() {
        return this.f2875m;
    }

    public boolean isEverFaceDetected() {
        return this.f2869g;
    }

    public boolean isLastAction() {
        List<ABDetectType> list = this.f2879q;
        return list == null || this.f2880r >= list.size() - 1;
    }

    public boolean isNeedContinueImage() {
        return this.f2878p;
    }

    public boolean isRunning() {
        return this.f2883u;
    }

    public ABDetectType offerAction() {
        this.f2881s = ABDetectType.DONE;
        if (this.f2879q != null && this.f2880r < r0.size() - 1) {
            int i10 = this.f2880r + 1;
            this.f2880r = i10;
            this.f2881s = this.f2879q.get(i10);
        }
        return this.f2881s;
    }

    public void reset() {
        this.f2869g = false;
        this.f2870h = -100;
        this.f2872j = 0;
        this.f2867e = null;
        this.f2877o = 0;
        this.f2876n = 0L;
        this.f2878p = false;
    }

    public void setActions(List<ABDetectType> list) {
        this.f2879q = list;
        this.f2880r = -1;
        this.f2881s = ABDetectType.NONE;
    }

    public void setBestFrame(ABFaceFrame aBFaceFrame) {
        this.f2867e = aBFaceFrame;
    }

    public void setCurrentActionResult(ABActionResult aBActionResult) {
        this.f2866d = aBActionResult;
    }

    public void setCurrentPhase(ABDetectPhase aBDetectPhase) {
        this.f2882t = aBDetectPhase;
    }

    public void setDisplayHeight(int i10) {
        this.f2874l = i10;
    }

    public void setDisplayWidth(int i10) {
        this.f2873k = i10;
    }

    public void setEverFaceDetected(boolean z10) {
        this.f2869g = z10;
    }

    public void setFrameCount(int i10) {
        this.f2872j = i10;
    }

    public void setLastDetectFailedType(int i10) {
        this.f2870h = i10;
    }

    public void setNeedContinueImage(boolean z10) {
        this.f2878p = z10;
    }

    public void setQualityImageCount(int i10) {
        this.f2877o = i10;
    }

    public void setQualityImageTime(long j10) {
        this.f2876n = j10;
    }

    public void setResult(ALBiometricsResult aLBiometricsResult) {
        this.f2865c = aLBiometricsResult;
    }

    public void setRetryTimes(int i10) {
        this.f2868f = i10;
    }

    public void setRotationAngle(int i10) {
        this.f2875m = i10;
    }

    public void start() {
        this.f2883u = true;
        this.f2882t = ABDetectPhase.INIT;
        setRetryTimes(0);
    }

    public void stop() {
        this.f2883u = false;
    }
}
