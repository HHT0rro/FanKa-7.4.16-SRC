package com.huawei.appgallery.agd.serverreq.utils.os;

import androidx.annotation.NonNull;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HwDeviceIdEx {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f27555b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static HwDeviceIdEx f27556c;

    /* renamed from: a, reason: collision with root package name */
    public UniqueId f27557a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class UniqueId {
        public static final int REAL_TYPE_NULL = 99;
        public static final int REAL_TYPE_UDID = 9;
        public static final int REAL_TYPE_UUID_HASH = 4;

        /* renamed from: id, reason: collision with root package name */
        public final String f27558id;
        public final int realType;
        public final int type;

        public UniqueId(int i10, String str) {
            this.realType = i10;
            this.type = i10;
            this.f27558id = str;
        }
    }

    public static HwDeviceIdEx getInstance() {
        HwDeviceIdEx hwDeviceIdEx;
        synchronized (f27555b) {
            if (f27556c == null) {
                f27556c = new HwDeviceIdEx();
            }
            hwDeviceIdEx = f27556c;
        }
        return hwDeviceIdEx;
    }

    @NonNull
    public static String getUUID() {
        return HEX.encodeString(SHA256.digest(UUID.randomUUID().toString()));
    }

    @NonNull
    public final UniqueId a() {
        return new UniqueId(4, getUUID());
    }

    public int getDeviceIdType() {
        return this.f27557a.type;
    }

    public String getDeviceUniqueId() {
        if (this.f27557a == null) {
            this.f27557a = a();
        }
        return this.f27557a.f27558id;
    }
}
