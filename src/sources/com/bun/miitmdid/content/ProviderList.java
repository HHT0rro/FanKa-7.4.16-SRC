package com.bun.miitmdid.content;

import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ProviderList {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum DEVICE_PROVIDER {
        UNSUPPORT(-1, "unsupport"),
        HUA_WEI(0, "HUAWEI"),
        XIAOMI(1, "Xiaomi"),
        VIVO(2, ADEvent.VIVO),
        OPPO(3, "oppo"),
        MOTO(4, "motorola"),
        LENOVO(5, "lenovo"),
        ASUS(6, "asus"),
        SAMSUNG(7, "samsung"),
        MEIZU(8, "meizu"),
        NUBIA(10, "nubia"),
        ZTE(11, "ZTE"),
        ONEPLUS(12, "OnePlus"),
        BLACKSHARK(13, "blackshark"),
        FREEMEOS(30, "freemeos"),
        SSUIOS(31, "ssui");

        public int index;
        public String name;

        DEVICE_PROVIDER(int i10, String str) {
            this.index = i10;
            this.name = str;
        }

        public static DEVICE_PROVIDER fromName(String str) {
            if (TextUtils.isEmpty(str)) {
                return UNSUPPORT;
            }
            for (DEVICE_PROVIDER device_provider : values()) {
                if (device_provider.name.equalsIgnoreCase(str)) {
                    return device_provider;
                }
            }
            return UNSUPPORT;
        }
    }
}
