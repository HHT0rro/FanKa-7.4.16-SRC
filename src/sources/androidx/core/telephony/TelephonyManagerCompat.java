package androidx.core.telephony;

import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    @RequiresApi(23)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        @Nullable
        @RequiresPermission(g.f36117c)
        @DoNotInline
        public static String getDeviceId(TelephonyManager telephonyManager, int i10) {
            return telephonyManager.getDeviceId(i10);
        }
    }

    @RequiresApi(26)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        @Nullable
        @RequiresPermission(g.f36117c)
        @DoNotInline
        public static String getImei(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    @RequiresApi(30)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static int getSubscriptionId(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }

    private TelephonyManagerCompat() {
    }

    @Nullable
    @RequiresPermission(g.f36117c)
    public static String getImei(@NonNull TelephonyManager telephonyManager) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return Api26Impl.getImei(telephonyManager);
        }
        int subscriptionId = getSubscriptionId(telephonyManager);
        if (subscriptionId != Integer.MAX_VALUE && subscriptionId != -1) {
            int slotIndex = SubscriptionManagerCompat.getSlotIndex(subscriptionId);
            if (i10 >= 23) {
                return Api23Impl.getDeviceId(telephonyManager, slotIndex);
            }
            try {
                if (sGetDeviceIdMethod == null) {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDeviceId", Integer.TYPE);
                    sGetDeviceIdMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                return (String) sGetDeviceIdMethod.invoke(telephonyManager, Integer.valueOf(slotIndex));
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
        return telephonyManager.getDeviceId();
    }

    public static int getSubscriptionId(@NonNull TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getSubscriptionId(telephonyManager);
        }
        try {
            if (sGetSubIdMethod == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);
                sGetSubIdMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSubIdMethod.invoke(telephonyManager, new Object[0]);
            if (num == null || num.intValue() == -1) {
                return Integer.MAX_VALUE;
            }
            return num.intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return Integer.MAX_VALUE;
        }
    }
}
