package com.alibaba.security.common.json;

import com.alibaba.security.common.json.util.RPTypeUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPJSONArray extends RPJSON implements List<Object>, Cloneable, RandomAccess, Serializable {
    public transient Type componentType;
    private final List<Object> list;
    public transient Object relatedArray;

    public RPJSONArray() {
        this.list = new ArrayList(10);
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
        return new RPJSONArray(new ArrayList(this.list));
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

    @Override // java.util.List
    public Object get(int i10) {
        return this.list.get(i10);
    }

    public BigDecimal getBigDecimal(int i10) {
        return RPTypeUtils.castToBigDecimal(get(i10));
    }

    public BigInteger getBigInteger(int i10) {
        return RPTypeUtils.castToBigInteger(get(i10));
    }

    public Boolean getBoolean(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return null;
        }
        return RPTypeUtils.castToBoolean(obj);
    }

    public boolean getBooleanValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return false;
        }
        return RPTypeUtils.castToBoolean(obj).booleanValue();
    }

    public Byte getByte(int i10) {
        return RPTypeUtils.castToByte(get(i10));
    }

    public byte getByteValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return (byte) 0;
        }
        return RPTypeUtils.castToByte(obj).byteValue();
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public Date getDate(int i10) {
        return RPTypeUtils.castToDate(get(i10));
    }

    public Double getDouble(int i10) {
        return RPTypeUtils.castToDouble(get(i10));
    }

    public double getDoubleValue(int i10) {
        Object obj = get(i10);
        return obj == null ? ShadowDrawableWrapper.COS_45 : RPTypeUtils.castToDouble(obj).doubleValue();
    }

    public Float getFloat(int i10) {
        return RPTypeUtils.castToFloat(get(i10));
    }

    public float getFloatValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0.0f;
        }
        return RPTypeUtils.castToFloat(obj).floatValue();
    }

    public int getIntValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0;
        }
        return RPTypeUtils.castToInt(obj).intValue();
    }

    public Integer getInteger(int i10) {
        return RPTypeUtils.castToInt(get(i10));
    }

    public RPJSONArray getJSONArray(int i10) {
        Object obj = this.list.get(i10);
        if (obj instanceof RPJSONArray) {
            return (RPJSONArray) obj;
        }
        return (RPJSONArray) RPJSON.toJSON(obj);
    }

    public RPJSONObject getJSONObject(int i10) {
        Object obj = this.list.get(i10);
        if (obj instanceof RPJSONObject) {
            return (RPJSONObject) obj;
        }
        return (RPJSONObject) RPJSON.toJSON(obj);
    }

    public Long getLong(int i10) {
        return RPTypeUtils.castToLong(get(i10));
    }

    public long getLongValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return 0L;
        }
        return RPTypeUtils.castToLong(obj).longValue();
    }

    public <T> T getObject(int i10, Class<T> cls) {
        return (T) RPTypeUtils.castToJavaBean(this.list.get(i10), cls);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public Short getShort(int i10) {
        return RPTypeUtils.castToShort(get(i10));
    }

    public short getShortValue(int i10) {
        Object obj = get(i10);
        if (obj == null) {
            return (short) 0;
        }
        return RPTypeUtils.castToShort(obj).shortValue();
    }

    public String getString(int i10) {
        return RPTypeUtils.castToString(get(i10));
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

    @Override // java.util.List
    public void add(int i10, Object obj) {
        this.list.add(i10, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends Object> collection) {
        return this.list.addAll(i10, collection);
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

    public RPJSONArray(List<Object> list) {
        this.list = list;
    }

    public RPJSONArray(int i10) {
        this.list = new ArrayList(i10);
    }
}
