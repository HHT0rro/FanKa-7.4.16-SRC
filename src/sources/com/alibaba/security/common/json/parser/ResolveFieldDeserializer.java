package com.alibaba.security.common.json.parser;

import com.alibaba.security.common.json.RPJSONArray;
import com.alibaba.security.common.json.parser.deserializer.FieldDeserializer;
import com.alibaba.security.common.json.util.RPTypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class ResolveFieldDeserializer extends FieldDeserializer {
    private final Collection collection;
    private final int index;
    private final Object key;
    private final List list;
    private final Map map;
    private final DefaultJSONParser parser;

    public ResolveFieldDeserializer(DefaultJSONParser defaultJSONParser, List list, int i10) {
        super(null, null, 0);
        this.parser = defaultJSONParser;
        this.index = i10;
        this.list = list;
        this.key = null;
        this.map = null;
        this.collection = null;
    }

    @Override // com.alibaba.security.common.json.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
    }

    @Override // com.alibaba.security.common.json.parser.deserializer.FieldDeserializer
    public void setValue(Object obj, Object obj2) {
        RPJSONArray rPJSONArray;
        Object relatedArray;
        Map map = this.map;
        if (map != null) {
            map.put(this.key, obj2);
            return;
        }
        Collection collection = this.collection;
        if (collection != null) {
            collection.add(obj2);
            return;
        }
        this.list.set(this.index, obj2);
        List list = this.list;
        if (!(list instanceof RPJSONArray) || (relatedArray = (rPJSONArray = (RPJSONArray) list).getRelatedArray()) == null || Array.getLength(relatedArray) <= this.index) {
            return;
        }
        if (rPJSONArray.getComponentType() != null) {
            obj2 = RPTypeUtils.cast(obj2, rPJSONArray.getComponentType(), this.parser.config);
        }
        Array.set(relatedArray, this.index, obj2);
    }

    public ResolveFieldDeserializer(Map map, Object obj) {
        super(null, null, 0);
        this.parser = null;
        this.index = -1;
        this.list = null;
        this.key = obj;
        this.map = map;
        this.collection = null;
    }

    public ResolveFieldDeserializer(Collection collection) {
        super(null, null, 0);
        this.parser = null;
        this.index = -1;
        this.list = null;
        this.key = null;
        this.map = null;
        this.collection = collection;
    }
}
