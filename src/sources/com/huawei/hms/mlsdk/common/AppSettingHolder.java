package com.huawei.hms.mlsdk.common;

import com.alipay.sdk.util.i;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class AppSettingHolder<T> {
    private final String persistenceKey;
    private final T setting;

    private AppSettingHolder(String str, T t2) {
        Objects.requireNonNull(str, "Null PersistentKey");
        Objects.requireNonNull(t2, "Null setting");
        this.persistenceKey = str;
        this.setting = t2;
    }

    public static <T> AppSettingHolder<T> create(String str, T t2) {
        return new AppSettingHolder<>(str, t2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppSettingHolder)) {
            return false;
        }
        AppSettingHolder appSettingHolder = (AppSettingHolder) obj;
        return this.persistenceKey.equals(appSettingHolder.persistenceKey) && this.setting.equals(appSettingHolder.setting);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.persistenceKey, this.setting});
    }

    public final String toString() {
        String str = this.persistenceKey;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 97 + String.valueOf(this.setting).length());
        sb2.append("MlModelDriverInstanceKey{persistentKey=");
        sb2.append(str);
        sb2.append(", setting=");
        sb2.append((Object) this.setting);
        sb2.append(i.f4738d);
        return sb2.toString();
    }
}
