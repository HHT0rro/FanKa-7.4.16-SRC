package com.kwad.sdk.ip.direct;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements Comparable<c> {
    private String ip;
    private boolean success;
    private int weight;
    private float aIG = -1.0f;
    private int aIM = 20;
    private int aIL = 3;
    private StringBuffer aIN = new StringBuffer();

    public c(String str) {
        this.ip = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return (int) (this.aIG - cVar.aIG);
    }

    public final int IQ() {
        return this.aIL;
    }

    public final float IR() {
        return this.aIG;
    }

    public final void bC(boolean z10) {
        this.success = z10;
    }

    public final void dB(int i10) {
        this.weight = i10;
    }

    public final String getIp() {
        return this.ip;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void i(float f10) {
        this.aIG = f10;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.ip + "', pingCount=" + this.aIL + ", pingWaitTime=" + this.aIM + ", pingTime='" + this.aIG + " ms', success=" + this.success + '}';
    }
}
