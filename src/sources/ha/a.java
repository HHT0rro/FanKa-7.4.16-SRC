package ha;

import com.huawei.appgallery.agd.serverreq.json.ReflectAPI;
import com.huawei.secure.android.common.util.SafeString;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class a {
    public static Class a(Field field) {
        int i10;
        if (Map.class.isAssignableFrom(field.getType())) {
            i10 = 1;
        } else {
            if (!List.class.isAssignableFrom(field.getType())) {
                return null;
            }
            i10 = 0;
        }
        return b(field, i10);
    }

    public static Class b(Field field, int i10) {
        Type[] actualTypeArguments;
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) == null || actualTypeArguments.length <= i10 || actualTypeArguments[i10] == null) {
            return null;
        }
        if (actualTypeArguments[i10] instanceof Class) {
            return (Class) actualTypeArguments[i10];
        }
        String obj = actualTypeArguments[i10].toString();
        int indexOf = obj.indexOf("class ");
        if (indexOf < 0) {
            indexOf = 0;
        }
        int indexOf2 = obj.indexOf("<");
        if (indexOf2 < 0) {
            indexOf2 = obj.length();
        }
        try {
            return Class.forName(SafeString.substring(obj, indexOf, indexOf2));
        } catch (ClassNotFoundException unused) {
            fa.a.c(ReflectAPI.f27532a, "CLASS for name error!");
            return null;
        }
    }

    public static Field[] c(Class cls) {
        Field[] c4 = cls.getSuperclass() != null ? c(cls.getSuperclass()) : null;
        Field[] declaredFields = cls.getDeclaredFields();
        if (c4 == null || c4.length <= 0) {
            return declaredFields;
        }
        Field[] fieldArr = new Field[declaredFields.length + c4.length];
        System.arraycopy(c4, 0, fieldArr, 0, c4.length);
        System.arraycopy(declaredFields, 0, fieldArr, c4.length, declaredFields.length);
        return fieldArr;
    }
}
