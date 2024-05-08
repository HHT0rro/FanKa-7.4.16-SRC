package com.huawei.hmf.services.codec;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import com.huawei.hmf.services.internal.GenericTypeReflector;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MessageCodec {
    private static final String LIST_ITEM_VALUE = "_list_item_";
    private static final String LIST_SIZE = "_list_size_";
    private static final String TAG = "MessageCodec";
    private static final int VAL_ENTITY = 0;
    private static final int VAL_LIST = 1;
    private static final int VAL_NULL = -1;
    private static final String VAL_TYPE = "_val_type_";

    private void readField(Type type, Object obj, Field field, Bundle bundle) throws IllegalAccessException {
        Object readValue;
        if (Modifier.isTransient(field.getModifiers()) || (readValue = readValue(type, field, bundle)) == null) {
            return;
        }
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        field.set(obj, readValue);
        field.setAccessible(isAccessible);
    }

    private Object readValue(Type type, Field field, Bundle bundle) {
        String name = field.getName();
        Object obj = bundle.get(name);
        if (!(obj instanceof Bundle) || field.getDeclaringClass() == Variant.class) {
            return obj;
        }
        try {
            Bundle bundle2 = (Bundle) obj;
            int i10 = bundle2.getInt("_val_type_", -1);
            if (i10 == 1) {
                return readList(GenericTypeReflector.resolve(type, field.getDeclaringClass(), field.getGenericType()), bundle2);
            }
            if (i10 == 0) {
                Type resolve = GenericTypeReflector.resolve(type, field.getDeclaringClass(), field.getGenericType());
                return decode((Bundle) obj, GenericTypeReflector.getType(resolve).newInstance(), resolve);
            }
            return obj;
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("decode, read value of the field exception, field name: ");
            sb2.append(name);
            return null;
        }
    }

    private void writeField(Object obj, Field field, Bundle bundle) throws IllegalAccessException {
        if (Modifier.isTransient(field.getModifiers())) {
            return;
        }
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        writeValue(field.getName(), field.get(obj), bundle);
        field.setAccessible(isAccessible);
    }

    private void writeValue(String str, Object obj, Bundle bundle) {
        if (obj == null) {
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            bundle.putShort(str, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof CharSequence) {
            bundle.putCharSequence(str, (CharSequence) obj);
            return;
        }
        if (obj instanceof IBinder) {
            bundle.putBinder(str, (IBinder) obj);
            return;
        }
        if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
            return;
        }
        if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
            return;
        }
        if (obj instanceof List) {
            writeList(str, (List) obj, bundle);
            return;
        }
        if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        } else if (obj.getClass() != Object.class) {
            Bundle encode = encode(obj, new Bundle());
            encode.putInt("_val_type_", 0);
            bundle.putBundle(str, encode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T decode(Bundle bundle, Type type) {
        Object obj = (T) null;
        if (bundle != null && type != null) {
            Class<?> type2 = GenericTypeReflector.getType(type);
            try {
                if (type2 == List.class) {
                    obj = (T) readList(type, bundle);
                } else {
                    obj = decode(bundle, (Bundle) type2.newInstance());
                }
            } catch (Exception unused) {
            }
        }
        return (T) obj;
    }

    public Bundle encode(Object obj, Bundle bundle) {
        for (Class<?> cls = obj.getClass(); cls != null && cls != Object.class; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                try {
                    writeField(obj, field, bundle);
                } catch (IllegalAccessException | IllegalArgumentException unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("encode, get value of the field exception, field name: ");
                    sb2.append(field.getName());
                }
            }
        }
        return bundle;
    }

    public List<Object> readList(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        int i10 = bundle.getInt(LIST_SIZE);
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = bundle.get(LIST_ITEM_VALUE + i11);
            if (!obj.getClass().isPrimitive() && !(obj instanceof String) && !(obj instanceof Serializable)) {
                if (obj instanceof Bundle) {
                    Bundle bundle2 = (Bundle) obj;
                    int i12 = bundle2.getInt("_val_type_", -1);
                    if (i12 == 1) {
                        throw new InstantiationException("Nested List can not be supported");
                    }
                    if (i12 == 0) {
                        arrayList.add(decode(bundle2, (Bundle) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                    } else {
                        throw new InstantiationException("Unknown type can not be supported");
                    }
                } else {
                    continue;
                }
            } else {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public void writeList(String str, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt(LIST_SIZE, list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            writeValue(LIST_ITEM_VALUE + i10, list.get(i10), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }

    public <T> T decode(Bundle bundle, T t2) {
        return (bundle == null || t2 == null) ? t2 : (T) decode(bundle, t2, t2.getClass());
    }

    private <T> T decode(Bundle bundle, T t2, Type type) {
        if (bundle != null && t2 != null) {
            for (Class<?> cls = t2.getClass(); cls != null && cls != Object.class; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    try {
                        readField(type, t2, field, bundle);
                    } catch (IllegalAccessException | IllegalArgumentException unused) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("decode, set value of the field exception, field name:");
                        sb2.append(field.getName());
                    }
                }
                type = GenericTypeReflector.resolve(type, cls, cls.getGenericSuperclass());
            }
        }
        return t2;
    }
}
