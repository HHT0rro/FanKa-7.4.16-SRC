package com.android.framework.protobuf.nano.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.android.framework.protobuf.nano.InvalidProtocolBufferNanoException;
import com.android.framework.protobuf.nano.MessageNano;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ParcelableMessageNanoCreator<T extends MessageNano> implements Parcelable.Creator<T> {
    private static final String TAG = "PMNCreator";
    private final Class<T> mClazz;

    public ParcelableMessageNanoCreator(Class<T> clazz) {
        this.mClazz = clazz;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.android.framework.protobuf.nano.MessageNano] */
    @Override // android.os.Parcelable.Creator
    public T createFromParcel(Parcel in) {
        String className = in.readString();
        byte[] data = in.createByteArray();
        T proto = null;
        try {
            Class<?> clazz = Class.forName(className, false, getClass().getClassLoader()).asSubclass(MessageNano.class);
            Object instance = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
            proto = (MessageNano) instance;
            MessageNano.mergeFrom(proto, data);
            return proto;
        } catch (InvalidProtocolBufferNanoException e2) {
            Log.e(TAG, "Exception trying to create proto from parcel", e2);
            return proto;
        } catch (ClassNotFoundException e10) {
            Log.e(TAG, "Exception trying to create proto from parcel", e10);
            return proto;
        } catch (IllegalAccessException e11) {
            Log.e(TAG, "Exception trying to create proto from parcel", e11);
            return proto;
        } catch (InstantiationException e12) {
            Log.e(TAG, "Exception trying to create proto from parcel", e12);
            return proto;
        } catch (NoSuchMethodException e13) {
            Log.e(TAG, "Exception trying to create proto from parcel", e13);
            return proto;
        } catch (InvocationTargetException e14) {
            Log.e(TAG, "Exception trying to create proto from parcel", e14);
            return proto;
        }
    }

    @Override // android.os.Parcelable.Creator
    public T[] newArray(int i10) {
        return (T[]) ((MessageNano[]) Array.newInstance((Class<?>) this.mClazz, i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends MessageNano> void writeToParcel(Class<T> clazz, MessageNano message, Parcel out) {
        out.writeString(clazz.getName());
        out.writeByteArray(MessageNano.toByteArray(message));
    }
}
