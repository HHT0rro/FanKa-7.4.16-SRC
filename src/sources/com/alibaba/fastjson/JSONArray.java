package com.alibaba.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JSONArray extends JSON implements List<Object>, Cloneable, RandomAccess, Serializable {
    private static final long serialVersionUID = 1;
    public transient Type componentType;
    private final List<Object> list;
    public transient Object relatedArray;

    public JSONArray() {
        this.list = new ArrayList();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        JSONObject.SecureObjectInputStream.ensureFields();
        if (JSONObject.SecureObjectInputStream.fields != null && !JSONObject.SecureObjectInputStream.fields_error) {
            try {
                new JSONObject.SecureObjectInputStream(objectInputStream).defaultReadObject();
                return;
            } catch (NotActiveException unused) {
            }
        }
        objectInputStream.defaultReadObject();
        for (Object obj : this.list) {
            if (obj != null) {
                ParserConfig.global.checkAutoType(obj.getClass().getName(), null);
            }
        }
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Object> collection) {
        return this.list.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public void clear() {
        this.list.clear();
    }

    public Object clone() {
        return new JSONArray(new ArrayList(this.list));
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return this.list.equals(obj);
    }

    public JSONArray fluentAdd(Object obj) {
        this.list.add(obj);
        return this;
    }

    public JSONArray fluentAddAll(Collection<? extends Object> collection) {
        this.list.addAll(collection);
        return this;
    }

    public JSONArray fluentClear() {
        this.list.clear();
        return this;
    }

    public JSONArray fluentRemove(Object obj) {
        this.list.remove(obj);
        return this;
    }

    public JSONArray fluentRemoveAll(Collection<?> collection) {
        this.list.removeAll(collection);
        return this;
    }

    public JSONArray fluentRetainAll(Collection<?> collection) {
        this.list.retainAll(collection);
        return this;
    }

    public JSONArray fluentSet(int i10, Object obj) {
        set(i10, obj);
        return this;
    }

    @Override // java.util.List
    public Object get(int i10) {
        return this.list.get(i10);
    }

    public BigDecimal getBigDecimal(int i10) {
        return TypeUtils.castToBigDecimal(get(i10));
    }

    public BigInteger getBigInteger(int i10) {
        return TypeUtils.castToBigInteger(get(i10));
    }

    public Boolean getBoolean(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return null;
        }
        return TypeUtils.castToBoolean(obj);
    }

    public boolean getBooleanValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return false;
        }
        return TypeUtils.castToBoolean(obj).booleanValue();
    }

    public Byte getByte(int i10) {
        return TypeUtils.castToByte(get(i10));
    }

    public byte getByteValue(int i10) {
        Byte castToByte = TypeUtils.castToByte(get(i10));
        if (castToByte == null) {
            return (byte) 0;
        }
        return castToByte.byteValue();
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public Date getDate(int i10) {
        return TypeUtils.castToDate(get(i10));
    }

    public Double getDouble(int i10) {
        return TypeUtils.castToDouble(get(i10));
    }

    public double getDoubleValue(int i10) {
        Double castToDouble = TypeUtils.castToDouble(get(i10));
        return castToDouble == null ? ShadowDrawableWrapper.COS_45 : castToDouble.doubleValue();
    }

    public Float getFloat(int i10) {
        return TypeUtils.castToFloat(get(i10));
    }

    public float getFloatValue(int i10) {
        Float castToFloat = TypeUtils.castToFloat(get(i10));
        if (castToFloat == null) {
            return 0.0f;
        }
        return castToFloat.floatValue();
    }

    public int getIntValue(int i10) {
        Integer castToInt = TypeUtils.castToInt(get(i10));
        if (castToInt == null) {
            return 0;
        }
        return castToInt.intValue();
    }

    public Integer getInteger(int i10) {
        return TypeUtils.castToInt(get(i10));
    }

    public JSONArray getJSONArray(int i10) {
        Object obj = this.list.get(i10);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        if (obj instanceof List) {
            return new JSONArray((List<Object>) obj);
        }
        return (JSONArray) JSON.toJSON(obj);
    }

    public JSONObject getJSONObject(int i10) {
        Object obj = this.list.get(i10);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        if (obj instanceof Map) {
            return new JSONObject((Map<String, Object>) obj);
        }
        return (JSONObject) JSON.toJSON(obj);
    }

    public Long getLong(int i10) {
        return TypeUtils.castToLong(get(i10));
    }

    public long getLongValue(int i10) {
        Long castToLong = TypeUtils.castToLong(get(i10));
        if (castToLong == null) {
            return 0L;
        }
        return castToLong.longValue();
    }

    public <T> T getObject(int i10, Class<T> cls) {
        return (T) TypeUtils.castToJavaBean(this.list.get(i10), cls);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public Short getShort(int i10) {
        return TypeUtils.castToShort(get(i10));
    }

    public short getShortValue(int i10) {
        Short castToShort = TypeUtils.castToShort(get(i10));
        if (castToShort == null) {
            return (short) 0;
        }
        return castToShort.shortValue();
    }

    public java.sql.Date getSqlDate(int i10) {
        return TypeUtils.castToSqlDate(get(i10));
    }

    public String getString(int i10) {
        return TypeUtils.castToString(get(i10));
    }

    public Timestamp getTimestamp(int i10) {
        return TypeUtils.castToTimestamp(get(i10));
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Object> iterator2() {
        return this.list.iterator2();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    @Override // java.util.List
    public Object set(int i10, Object obj) {
        if (i10 == -1) {
            this.list.add(obj);
            return null;
        }
        if (this.list.size() <= i10) {
            for (int size = this.list.size(); size < i10; size++) {
                this.list.add(null);
            }
            this.list.add(obj);
            return null;
        }
        return this.list.set(i10, obj);
    }

    public void setComponentType(Type type) {
        this.componentType = type;
    }

    public void setRelatedArray(Object obj) {
        this.relatedArray = obj;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int size() {
        return this.list.size();
    }

    @Override // java.util.List
    public List<Object> subList(int i10, int i11) {
        return this.list.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return this.list.toArray();
    }

    public <T> List<T> toJavaList(Class<T> cls) {
        ArrayList arrayList = new ArrayList(size());
        ParserConfig globalInstance = ParserConfig.getGlobalInstance();
        Iterator<Object> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(TypeUtils.cast(iterator2.next(), (Class) cls, globalInstance));
        }
        return arrayList;
    }

    @Override // java.util.List
    public void add(int i10, Object obj) {
        this.list.add(i10, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends Object> collection) {
        return this.list.addAll(i10, collection);
    }

    public JSONArray fluentAdd(int i10, Object obj) {
        this.list.add(i10, obj);
        return this;
    }

    public JSONArray fluentAddAll(int i10, Collection<? extends Object> collection) {
        this.list.addAll(i10, collection);
        return this;
    }

    public JSONArray fluentRemove(int i10) {
        this.list.remove(i10);
        return this;
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i10) {
        return this.list.listIterator(i10);
    }

    @Override // java.util.List
    public Object remove(int i10) {
        return this.list.remove(i10);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.list.toArray(tArr);
    }

    public JSONArray(List<Object> list) {
        this.list = list;
    }

    public <T> T getObject(int i10, Type type) {
        Object obj = this.list.get(i10);
        if (type instanceof Class) {
            return (T) TypeUtils.castToJavaBean(obj, (Class) type);
        }
        return (T) JSON.parseObject(JSON.toJSONString(obj), type, new Feature[0]);
    }

    public JSONArray(int i10) {
        this.list = new ArrayList(i10);
    }
}
