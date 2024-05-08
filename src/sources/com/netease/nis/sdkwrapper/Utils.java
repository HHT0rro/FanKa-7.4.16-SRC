package com.netease.nis.sdkwrapper;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.ads.ContentClassification;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Utils {
    static {
        System.loadLibrary("secsdk");
    }

    public static String a(String str) {
        if (str.startsWith("[")) {
            return str.replace(".", "/");
        }
        if (str.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
            return "I";
        }
        if (str.equals("float")) {
            return "F";
        }
        if (str.equals("long")) {
            return ContentClassification.AD_CONTENT_CLASSIFICATION_J;
        }
        if (str.equals("double")) {
            return "D";
        }
        if (str.equals("short")) {
            return ExifInterface.LATITUDE_SOUTH;
        }
        if (str.equals("char")) {
            return "C";
        }
        if (str.equals("boolean")) {
            return "Z";
        }
        if (str.equals("byte")) {
            return "B";
        }
        return ("L" + str + ";").replace(".", "/");
    }

    public static String b(Class cls, String str, String str2) {
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            Field.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                String replace = field.getType().toString().replace("class ", "").replace("interface ", "");
                if (Modifier.isStatic(field.getModifiers()) && field.getName().equals(str) && str2.equals(a(replace))) {
                    return field.getDeclaringClass().getName().replace(".", "/");
                }
            }
            return "";
        } catch (NoClassDefFoundError unused) {
            return "NoClassDefFoundError";
        }
    }

    public static String getFieldSCDesc(Class cls, String str, String str2) {
        while (cls != null) {
            String b4 = b(cls, str, str2);
            if (b4 != "") {
                return b4;
            }
            cls = cls.getSuperclass();
        }
        return "";
    }

    public static Object getStaticFO(String str, String str2) {
        try {
            Field field = Class.forName(str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.')).getField(str2);
            Class<?> type = field.getType();
            if (type == Integer.TYPE) {
                return Integer.valueOf(field.getInt(null));
            }
            if (type == Float.TYPE) {
                return Float.valueOf(field.getFloat(null));
            }
            if (type == Long.TYPE) {
                return Long.valueOf(field.getLong(null));
            }
            if (type == Double.TYPE) {
                return Double.valueOf(field.getDouble(null));
            }
            if (type == Short.TYPE) {
                return Short.valueOf(field.getShort(null));
            }
            if (type == Character.TYPE) {
                return Character.valueOf(field.getChar(null));
            }
            if (type == Boolean.TYPE) {
                return Boolean.valueOf(field.getBoolean(null));
            }
            if (type == Byte.TYPE) {
                return Byte.valueOf(field.getByte(null));
            }
            return field.get(null);
        } catch (Exception e2) {
            e2.toString();
            return null;
        }
    }

    public static native Object rL(Object[] objArr);

    public static void showRiskMessage(Context context, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Toast.makeText(context, str, 0).show();
            return;
        }
        Looper.prepare();
        Toast.makeText(context, str, 0).show();
        Looper.loop();
    }
}
