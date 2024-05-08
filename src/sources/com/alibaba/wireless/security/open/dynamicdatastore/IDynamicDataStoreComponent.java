package com.alibaba.wireless.security.open.dynamicdatastore;

import com.alibaba.wireless.security.framework.InterfacePluginInfo;
import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;

@InterfacePluginInfo(pluginName = "main")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IDynamicDataStoreComponent extends IComponent {
    @Deprecated
    boolean getBoolean(String str) throws SecException;

    @Deprecated
    byte[] getByteArray(String str) throws SecException;

    @Deprecated
    byte[] getByteArrayDDp(String str) throws SecException;

    byte[] getByteArrayDDpEx(String str, int i10) throws SecException;

    @Deprecated
    float getFloat(String str) throws SecException;

    @Deprecated
    int getInt(String str) throws SecException;

    @Deprecated
    long getLong(String str) throws SecException;

    @Deprecated
    String getString(String str) throws SecException;

    @Deprecated
    String getStringDDp(String str) throws SecException;

    String getStringDDpEx(String str, int i10) throws SecException;

    @Deprecated
    int putBoolean(String str, boolean z10) throws SecException;

    @Deprecated
    int putByteArray(String str, byte[] bArr) throws SecException;

    @Deprecated
    int putByteArrayDDp(String str, byte[] bArr) throws SecException;

    boolean putByteArrayDDpEx(String str, byte[] bArr, int i10) throws SecException;

    @Deprecated
    int putFloat(String str, float f10) throws SecException;

    @Deprecated
    int putInt(String str, int i10) throws SecException;

    @Deprecated
    int putLong(String str, long j10) throws SecException;

    @Deprecated
    int putString(String str, String str2) throws SecException;

    @Deprecated
    int putStringDDp(String str, String str2) throws SecException;

    boolean putStringDDpEx(String str, String str2, int i10) throws SecException;

    @Deprecated
    void removeBoolean(String str) throws SecException;

    @Deprecated
    void removeByteArray(String str) throws SecException;

    @Deprecated
    void removeByteArrayDDp(String str) throws SecException;

    void removeByteArrayDDpEx(String str, int i10) throws SecException;

    @Deprecated
    void removeFloat(String str) throws SecException;

    @Deprecated
    void removeInt(String str) throws SecException;

    @Deprecated
    void removeLong(String str) throws SecException;

    @Deprecated
    void removeString(String str) throws SecException;

    @Deprecated
    void removeStringDDp(String str) throws SecException;

    void removeStringDDpEx(String str, int i10) throws SecException;
}
