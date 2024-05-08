package ca;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e {
    public static int a(@NonNull String str, int i10) {
        String str2;
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i10))).intValue();
        } catch (ClassNotFoundException e2) {
            e = e2;
            str2 = "ClassNotFoundException while getting system property: ";
            fa.a.b("SystemPropertiesEx", str2, e);
            return i10;
        } catch (Exception e10) {
            e = e10;
            str2 = "Exception while getting system property: ";
            fa.a.b("SystemPropertiesEx", str2, e);
            return i10;
        }
    }

    public static String b(@NonNull String str) {
        String str2;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (ClassNotFoundException e2) {
            e = e2;
            str2 = "ClassNotFoundException while getting system property: ";
            fa.a.b("SystemPropertiesEx", str2, e);
            return "";
        } catch (Exception e10) {
            e = e10;
            str2 = "Exception while getting system property: ";
            fa.a.b("SystemPropertiesEx", str2, e);
            return "";
        }
    }

    public static String c(@NonNull String str, @Nullable String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e2) {
            fa.a.b("SystemPropertiesEx", "ClassNotFoundException while getting system property: ", e2);
            return "";
        } catch (Exception e10) {
            fa.a.b("SystemPropertiesEx", "Exception while getting system property: ", e10);
            return str2;
        }
    }

    public static boolean d(@NonNull String str, boolean z10) {
        String str2;
        try {
            return ((Boolean) Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE).invoke(null, str, Boolean.valueOf(z10))).booleanValue();
        } catch (ClassNotFoundException e2) {
            e = e2;
            str2 = "ClassNotFoundException while getting system property: ";
            fa.a.b("SystemPropertiesEx", str2, e);
            return z10;
        } catch (Exception e10) {
            e = e10;
            str2 = "Exception while getting system property: ";
            fa.a.b("SystemPropertiesEx", str2, e);
            return z10;
        }
    }
}
