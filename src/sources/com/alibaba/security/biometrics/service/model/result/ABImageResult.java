package com.alibaba.security.biometrics.service.model.result;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ABImageResult implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: b, reason: collision with root package name */
    public float f2888b;
    public byte[] bf;

    /* renamed from: d, reason: collision with root package name */
    public String f2889d;
    public int dt;
    public int[] fr;

    /* renamed from: gb, reason: collision with root package name */
    public float f2890gb;
    public float[] landmarks;

    /* renamed from: mb, reason: collision with root package name */
    public float f2891mb;

    /* renamed from: p, reason: collision with root package name */
    public String f2892p;

    /* renamed from: q, reason: collision with root package name */
    public float f2893q;

    /* renamed from: t, reason: collision with root package name */
    public long f2894t;

    public float getB() {
        return this.f2888b;
    }

    public byte[] getBf() {
        return this.bf;
    }

    public String getD() {
        return this.f2889d;
    }

    public int getDt() {
        return this.dt;
    }

    public int[] getFr() {
        return this.fr;
    }

    public float getGb() {
        return this.f2890gb;
    }

    public float[] getLandmarks() {
        return this.landmarks;
    }

    public float getMb() {
        return this.f2891mb;
    }

    public String getP() {
        return this.f2892p;
    }

    public float getQ() {
        return this.f2893q;
    }

    public long getT() {
        return this.f2894t;
    }

    public void setB(float f10) {
        this.f2888b = f10;
    }

    public void setBf(byte[] bArr) {
        this.bf = bArr;
    }

    public void setD(String str) {
        this.f2889d = str;
    }

    public void setDt(int i10) {
        this.dt = i10;
    }

    public ABImageResult setFr(int[] iArr) {
        this.fr = iArr;
        return this;
    }

    public void setGb(float f10) {
        this.f2890gb = f10;
    }

    public ABImageResult setLandmarks(float[] fArr) {
        this.landmarks = fArr;
        return this;
    }

    public void setMb(float f10) {
        this.f2891mb = f10;
    }

    public void setP(String str) {
        this.f2892p = str;
    }

    public void setQ(float f10) {
        this.f2893q = f10;
    }

    public void setT(long j10) {
        this.f2894t = j10;
    }

    public String toString() {
        return "ImageResult{q=" + this.f2893q + ", p='" + this.f2892p + "', gb=" + this.f2890gb + ", mb=" + this.f2891mb + ", b=" + this.f2888b + ", t=" + this.f2894t + '}';
    }
}
