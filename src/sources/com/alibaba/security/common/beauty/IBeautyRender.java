package com.alibaba.security.common.beauty;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IBeautyRender {
    void draw(byte[] bArr, float[] fArr);

    void onChanged(int i10, int i11);

    void onCreated(Context context, int i10, int i11, int i12, int i13);

    void release();
}
