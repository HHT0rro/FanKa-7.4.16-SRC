package com.tencent.youtu.ytposedetect.data;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class YTActRefData {
    public YTActRefImage best;
    public YTActRefImage eye;
    public YTActRefImage mouth;

    public boolean isEmpty() {
        return this.eye == null && this.mouth == null && this.best == null;
    }

    public String toString() {
        return "YTActRefData{eye=" + ((Object) this.eye) + ", mouth=" + ((Object) this.mouth) + ", best=" + ((Object) this.best) + '}';
    }
}
