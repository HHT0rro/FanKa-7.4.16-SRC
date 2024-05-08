package com.ishumei.smantifraud.l111l1111l1Il.l1111l111111Il;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l111l1111llIl {
    public final byte[] l1111l111111Il;
    private Map<String, String> l111l11111I1l;
    private List<com.ishumei.smantifraud.l1111l111111Il> l111l11111Il;
    private int l111l11111lIl;
    private boolean l111l1111l1Il;
    private long l111l1111llIl;

    public l111l1111llIl() {
    }

    private l111l1111llIl(int i10, byte[] bArr, Map<String, String> map, List<com.ishumei.smantifraud.l1111l111111Il> list, boolean z10, long j10) {
        this.l111l11111lIl = i10;
        this.l1111l111111Il = bArr;
        this.l111l11111I1l = map;
        this.l111l11111Il = list == null ? null : Collections.unmodifiableList(list);
        this.l111l1111l1Il = z10;
        this.l111l1111llIl = j10;
    }

    @Deprecated
    private l111l1111llIl(int i10, byte[] bArr, Map<String, String> map, boolean z10) {
        this(i10, bArr, map, z10, 0L);
    }

    @Deprecated
    private l111l1111llIl(int i10, byte[] bArr, Map<String, String> map, boolean z10, long j10) {
        this(i10, bArr, map, l1111l111111Il(map), z10, 0L);
    }

    public l111l1111llIl(int i10, byte[] bArr, boolean z10, long j10, List<com.ishumei.smantifraud.l1111l111111Il> list) {
        this(i10, bArr, l1111l111111Il(list), list, false, j10);
    }

    private l111l1111llIl(byte[] bArr) {
        this(200, bArr, false, 0L, (List<com.ishumei.smantifraud.l1111l111111Il>) Collections.emptyList());
    }

    @Deprecated
    private l111l1111llIl(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

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

    private static List<com.ishumei.smantifraud.l1111l111111Il> l1111l111111Il(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new com.ishumei.smantifraud.l1111l111111Il(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private static Map<String, String> l1111l111111Il(List<com.ishumei.smantifraud.l1111l111111Il> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (com.ishumei.smantifraud.l1111l111111Il l1111l111111il : list) {
            treeMap.put(l1111l111111il.l1111l111111Il(), l1111l111111il.l111l11111lIl());
        }
        return treeMap;
    }
}
