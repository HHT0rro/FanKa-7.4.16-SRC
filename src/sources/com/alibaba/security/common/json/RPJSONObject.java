package com.alibaba.security.common.json;

import com.alibaba.security.common.json.annotation.RPJSONField;
import com.alibaba.security.common.json.parser.ParserConfig;
import com.alibaba.security.common.json.util.RPTypeUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPJSONObject extends RPJSON implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {
    private final Map<String, Object> map;

    public RPJSONObject() {
        this(16, false);
    }

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        return new RPJSONObject(new LinkedHashMap(this.map));
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public BigDecimal getBigDecimal(String str) {
        return RPTypeUtils.castToBigDecimal(get(str));
    }

    public BigInteger getBigInteger(String str) {
        return RPTypeUtils.castToBigInteger(get(str));
    }

    public Boolean getBoolean(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return RPTypeUtils.castToBoolean(obj);
    }

    public boolean getBooleanValue(String str) {
        Boolean castToBoolean = RPTypeUtils.castToBoolean(get(str));
        if (castToBoolean == null) {
            return false;
        }
        return castToBoolean.booleanValue();
    }

    public Byte getByte(String str) {
        return RPTypeUtils.castToByte(get(str));
    }

    public byte getByteValue(String str) {
        Byte castToByte = RPTypeUtils.castToByte(get(str));
        if (castToByte == null) {
            return (byte) 0;
        }
        return castToByte.byteValue();
    }

    public byte[] getBytes(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return RPTypeUtils.castToBytes(obj);
    }

    public Date getDate(String str) {
        return RPTypeUtils.castToDate(get(str));
    }

    public Double getDouble(String str) {
        return RPTypeUtils.castToDouble(get(str));
    }

    public double getDoubleValue(String str) {
        Double castToDouble = RPTypeUtils.castToDouble(get(str));
        return castToDouble == null ? ShadowDrawableWrapper.COS_45 : castToDouble.doubleValue();
    }

    public Float getFloat(String str) {
        return RPTypeUtils.castToFloat(get(str));
    }

    public float getFloatValue(String str) {
        Float castToFloat = RPTypeUtils.castToFloat(get(str));
        if (castToFloat == null) {
            return 0.0f;
        }
        return castToFloat.floatValue();
    }

    public Map<String, Object> getInnerMap() {
        return this.map;
    }

    public int getIntValue(String str) {
        Integer castToInt = RPTypeUtils.castToInt(get(str));
        if (castToInt == null) {
            return 0;
        }
        return castToInt.intValue();
    }

    public Integer getInteger(String str) {
        return RPTypeUtils.castToInt(get(str));
    }

    public RPJSONArray getJSONArray(String str) {
        Object obj = this.map.get(str);
        if (obj instanceof RPJSONArray) {
            return (RPJSONArray) obj;
        }
        if (obj instanceof String) {
            return (RPJSONArray) RPJSON.parse((String) obj);
        }
        return (RPJSONArray) RPJSON.toJSON(obj);
    }

    public RPJSONObject getJSONObject(String str) {
        Object obj = this.map.get(str);
        if (obj instanceof RPJSONObject) {
            return (RPJSONObject) obj;
        }
        if (obj instanceof String) {
            return RPJSON.parseObject((String) obj);
        }
        return (RPJSONObject) RPJSON.toJSON(obj);
    }

    public Long getLong(String str) {
        return RPTypeUtils.castToLong(get(str));
    }

    public long getLongValue(String str) {
        Long castToLong = RPTypeUtils.castToLong(get(str));
        if (castToLong == null) {
            return 0L;
        }
        return castToLong.longValue();
    }

    public <T> T getObject(String str, Class<T> cls) {
        return (T) RPTypeUtils.castToJavaBean(this.map.get(str), cls);
    }

    public Short getShort(String str) {
        return RPTypeUtils.castToShort(get(str));
    }

    public short getShortValue(String str) {
        Short castToShort = RPTypeUtils.castToShort(get(str));
        if (castToShort == null) {
            return (short) 0;
        }
        return castToShort.shortValue();
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class<?>[] parameterTypes = method.getParameterTypes();
        String str = null;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() == Void.TYPE) {
                RPJSONField rPJSONField = (RPJSONField) method.getAnnotation(RPJSONField.class);
                String name = (rPJSONField == null || rPJSONField.name().length() == 0) ? null : rPJSONField.name();
                if (name == null) {
                    String name2 = method.getName();
                    if (name2.startsWith("set")) {
                        String substring = name2.substring(3);
                        if (substring.length() != 0) {
                            name = Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                        } else {
                            throw new RPJSONException("illegal setter");
                        }
                    } else {
                        throw new RPJSONException("illegal setter");
                    }
                }
                this.map.put(name, objArr[0]);
                return null;
            }
            throw new RPJSONException("illegal setter");
        }
        if (parameterTypes.length == 0) {
            if (method.getReturnType() != Void.TYPE) {
                RPJSONField rPJSONField2 = (RPJSONField) method.getAnnotation(RPJSONField.class);
                if (rPJSONField2 != null && rPJSONField2.name().length() != 0) {
                    str = rPJSONField2.name();
                }
                if (str == null) {
                    String name3 = method.getName();
                    if (name3.startsWith(MonitorConstants.CONNECT_TYPE_GET)) {
                        String substring2 = name3.substring(3);
                        if (substring2.length() != 0) {
                            str = Character.toLowerCase(substring2.charAt(0)) + substring2.substring(1);
                        } else {
                            throw new RPJSONException("illegal getter");
                        }
                    } else if (name3.startsWith("is")) {
                        String substring3 = name3.substring(2);
                        if (substring3.length() != 0) {
                            str = Character.toLowerCase(substring3.charAt(0)) + substring3.substring(1);
                        } else {
                            throw new RPJSONException("illegal getter");
                        }
                    } else {
                        if (name3.startsWith(TTDownloadField.TT_HASHCODE)) {
                            return Integer.valueOf(hashCode());
                        }
                        if (name3.startsWith("toString")) {
                            return toString();
                        }
                        throw new RPJSONException("illegal getter");
                    }
                }
                return RPTypeUtils.cast(this.map.get(str), method.getGenericReturnType(), ParserConfig.global);
            }
            throw new RPJSONException("illegal getter");
        }
        throw new UnsupportedOperationException(method.toGenericString());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public Set<String> h() {
        return this.map.h();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.map.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.map.values();
    }

    public RPJSONObject(Map<String, Object> map) {
        this.map = map;
    }

    @Override // java.util.Map
    public Object put(String str, Object obj) {
        return this.map.put(str, obj);
    }

    public RPJSONObject(boolean z10) {
        this(16, z10);
    }

    public RPJSONObject(int i10) {
        this(i10, false);
    }

    public RPJSONObject(int i10, boolean z10) {
        if (z10) {
            this.map = new LinkedHashMap(i10);
        } else {
            this.map = new HashMap(i10);
        }
    }
}
