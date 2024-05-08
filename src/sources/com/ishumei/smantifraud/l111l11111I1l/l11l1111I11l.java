package com.ishumei.smantifraud.l111l11111I1l;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111I11l {
    private static List<String> l1111l111111Il() {
        ArrayList arrayList = new ArrayList();
        try {
            Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
            if (context != null) {
                for (Sensor sensor : ((SensorManager) context.getSystemService("sensor")).getSensorList(-1)) {
                    arrayList.add(sensor.getType() + "," + sensor.getVendor());
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
