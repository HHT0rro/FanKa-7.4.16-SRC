package com.alibaba.security.biometrics.service.model.result;

import com.alibaba.security.biometrics.service.model.detector.MineInfo;
import com.alipay.sdk.util.i;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ABActionResult implements Serializable {
    private static final long serialVersionUID = 1;
    public int at;
    public long et;

    /* renamed from: td, reason: collision with root package name */
    public int f2887td;

    /* renamed from: r, reason: collision with root package name */
    public int f2886r = 0;

    /* renamed from: ec, reason: collision with root package name */
    public int f2885ec = -1;
    public int ecpc = -1;
    public int etcc = -1;
    public String ecResult = "";
    public List<ABImageResult> is = new ArrayList();
    public List<MineInfo> ms = new ArrayList();
    public long bt = System.currentTimeMillis();

    public void addImageResult(ABImageResult aBImageResult) {
        this.is.add(aBImageResult);
    }

    public void addMine(MineInfo mineInfo) {
        this.ms.add(mineInfo);
    }

    public int getAt() {
        return this.at;
    }

    public long getBt() {
        return this.bt;
    }

    public int getEc() {
        return this.f2885ec;
    }

    public String getEcResult() {
        return this.ecResult;
    }

    public int getEcpc() {
        return this.ecpc;
    }

    public long getEt() {
        return this.et;
    }

    public int getEtcc() {
        return this.etcc;
    }

    public List<ABImageResult> getIs() {
        return this.is;
    }

    public List<MineInfo> getMs() {
        return this.ms;
    }

    public int getR() {
        return this.f2886r;
    }

    public int getTd() {
        return this.f2887td;
    }

    public void setAt(int i10) {
        this.at = i10;
    }

    public void setBt(long j10) {
        this.bt = j10;
    }

    public void setEc(int i10) {
        this.f2885ec = i10;
    }

    public void setEcResult(String str) {
        this.ecResult = str;
    }

    public void setEcpc(int i10) {
        this.ecpc = i10;
    }

    public void setEt(long j10) {
        this.et = j10;
    }

    public void setEtcc(int i10) {
        this.etcc = i10;
    }

    public void setIs(List<ABImageResult> list) {
        this.is = list;
    }

    public void setMs(List<MineInfo> list) {
        this.ms = list;
    }

    public void setR(int i10) {
        this.f2886r = i10;
    }

    public void setTd(int i10) {
        this.f2887td = i10;
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss.SSS", Locale.getDefault());
        return "ActionResult{actionType=" + this.at + "(2:mouth,3:yaw,10:pitchdown,11:still,6:none), result=" + this.f2886r + "(see LivnessResult.result/r),3d=" + this.f2887td + ", beginttime=" + simpleDateFormat.format(new Date(this.bt)) + ", endtime=" + simpleDateFormat.format(new Date(this.et)) + ", images=" + ((Object) this.is) + ", mines=" + ((Object) this.ms) + ", ec=" + this.f2885ec + ", ecpc=" + this.ecpc + ", etcc=" + this.etcc + i.f4738d;
    }
}
