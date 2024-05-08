package com.tencent.youtu.ytposedetect.data;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class YTActRefImage {
    public String checksum;
    public byte[] image;
    public float[] xys;

    public String toString() {
        return "YTActRefImage{image=" + Arrays.toString(this.image) + ", xys=" + Arrays.toString(this.xys) + ", checksum='" + this.checksum + "'}";
    }
}
