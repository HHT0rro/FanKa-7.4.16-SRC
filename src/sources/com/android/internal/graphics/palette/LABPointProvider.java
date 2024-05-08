package com.android.internal.graphics.palette;

import android.graphics.Color;
import android.graphics.ColorSpace;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class LABPointProvider implements PointProvider {
    final ColorSpace.Connector mRgbToLab = ColorSpace.connect(ColorSpace.get(ColorSpace.Named.SRGB), ColorSpace.get(ColorSpace.Named.CIE_LAB));
    final ColorSpace.Connector mLabToRgb = ColorSpace.connect(ColorSpace.get(ColorSpace.Named.CIE_LAB), ColorSpace.get(ColorSpace.Named.SRGB));

    @Override // com.android.internal.graphics.palette.PointProvider
    public float[] fromInt(int color) {
        float r10 = Color.red(color) / 255.0f;
        float g3 = Color.green(color) / 255.0f;
        float b4 = Color.blue(color) / 255.0f;
        float[] transform = this.mRgbToLab.transform(r10, g3, b4);
        return transform;
    }

    @Override // com.android.internal.graphics.palette.PointProvider
    public int toInt(float[] centroid) {
        float[] rgb = this.mLabToRgb.transform(centroid);
        int color = Color.rgb(rgb[0], rgb[1], rgb[2]);
        return color;
    }

    @Override // com.android.internal.graphics.palette.PointProvider
    public float distance(float[] a10, float[] b4) {
        double dL = a10[0] - b4[0];
        double dA = a10[1] - b4[1];
        double dB = a10[2] - b4[2];
        return (float) ((dL * dL) + (dA * dA) + (dB * dB));
    }
}
