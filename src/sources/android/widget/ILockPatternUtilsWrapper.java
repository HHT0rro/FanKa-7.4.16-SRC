package android.widget;

import com.android.internal.widget.ILockPatternUtilsExt;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ILockPatternUtilsWrapper {
    default ILockPatternUtilsExt getLockPatternUtilsExt() {
        return null;
    }

    default boolean getDebug() {
        return false;
    }

    default String getTag() {
        return null;
    }

    default boolean getBoolean(String secureSettingKey, boolean defaultValue, int userId) {
        return false;
    }

    default void setBoolean(String secureSettingKey, boolean enabled, int userId) {
    }

    default long getLong(String secureSettingKey, long defaultValue, int userHandle) {
        return 0L;
    }

    default void setLong(String secureSettingKey, long value, int userHandle) {
    }
}
