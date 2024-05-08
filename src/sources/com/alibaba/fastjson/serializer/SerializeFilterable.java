package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class SerializeFilterable {
    public List<BeforeFilter> beforeFilters = null;
    public List<AfterFilter> afterFilters = null;
    public List<PropertyFilter> propertyFilters = null;
    public List<ValueFilter> valueFilters = null;
    public List<NameFilter> nameFilters = null;
    public List<PropertyPreFilter> propertyPreFilters = null;
    public List<LabelFilter> labelFilters = null;
    public List<ContextValueFilter> contextValueFilters = null;
    public boolean writeDirect = true;

    public void addFilter(SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        if (serializeFilter instanceof PropertyPreFilter) {
            getPropertyPreFilters().add((PropertyPreFilter) serializeFilter);
        }
        if (serializeFilter instanceof NameFilter) {
            getNameFilters().add((NameFilter) serializeFilter);
        }
        if (serializeFilter instanceof ValueFilter) {
            getValueFilters().add((ValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof ContextValueFilter) {
            getContextValueFilters().add((ContextValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof PropertyFilter) {
            getPropertyFilters().add((PropertyFilter) serializeFilter);
        }
        if (serializeFilter instanceof BeforeFilter) {
            getBeforeFilters().add((BeforeFilter) serializeFilter);
        }
        if (serializeFilter instanceof AfterFilter) {
            getAfterFilters().add((AfterFilter) serializeFilter);
        }
        if (serializeFilter instanceof LabelFilter) {
            getLabelFilters().add((LabelFilter) serializeFilter);
        }
    }

    public boolean apply(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<PropertyFilter> list = jSONSerializer.propertyFilters;
        if (list != null) {
            Iterator<PropertyFilter> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (!iterator2.next().apply(obj, str, obj2)) {
                    return false;
                }
            }
        }
        List<PropertyFilter> list2 = this.propertyFilters;
        if (list2 == null) {
            return true;
        }
        Iterator<PropertyFilter> iterator22 = list2.iterator2();
        while (iterator22.hasNext()) {
            if (!iterator22.next().apply(obj, str, obj2)) {
                return false;
            }
        }
        return true;
    }

    public boolean applyName(JSONSerializer jSONSerializer, Object obj, String str) {
        List<PropertyPreFilter> list = jSONSerializer.propertyPreFilters;
        if (list != null) {
            Iterator<PropertyPreFilter> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (!iterator2.next().apply(jSONSerializer, obj, str)) {
                    return false;
                }
            }
        }
        List<PropertyPreFilter> list2 = this.propertyPreFilters;
        if (list2 == null) {
            return true;
        }
        Iterator<PropertyPreFilter> iterator22 = list2.iterator2();
        while (iterator22.hasNext()) {
            if (!iterator22.next().apply(jSONSerializer, obj, str)) {
                return false;
            }
        }
        return true;
    }

    public List<AfterFilter> getAfterFilters() {
        if (this.afterFilters == null) {
            this.afterFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.afterFilters;
    }

    public List<BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters == null) {
            this.beforeFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.beforeFilters;
    }

    public List<ContextValueFilter> getContextValueFilters() {
        if (this.contextValueFilters == null) {
            this.contextValueFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.contextValueFilters;
    }

    public List<LabelFilter> getLabelFilters() {
        if (this.labelFilters == null) {
            this.labelFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.labelFilters;
    }

    public List<NameFilter> getNameFilters() {
        if (this.nameFilters == null) {
            this.nameFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.nameFilters;
    }

    public List<PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters == null) {
            this.propertyFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.propertyFilters;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters == null) {
            this.propertyPreFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.propertyPreFilters;
    }

    public List<ValueFilter> getValueFilters() {
        if (this.valueFilters == null) {
            this.valueFilters = new ArrayList();
            this.writeDirect = false;
        }
        return this.valueFilters;
    }

    public String processKey(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<NameFilter> list = jSONSerializer.nameFilters;
        if (list != null) {
            Iterator<NameFilter> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                str = iterator2.next().process(obj, str, obj2);
            }
        }
        List<NameFilter> list2 = this.nameFilters;
        if (list2 != null) {
            Iterator<NameFilter> iterator22 = list2.iterator2();
            while (iterator22.hasNext()) {
                str = iterator22.next().process(obj, str, obj2);
            }
        }
        return str;
    }

    public Object processValue(JSONSerializer jSONSerializer, BeanContext beanContext, Object obj, String str, Object obj2, int i10) {
        boolean z10;
        if (obj2 != null) {
            int i11 = jSONSerializer.out.features;
            SerializerFeature serializerFeature = SerializerFeature.WriteNonStringValueAsString;
            if ((SerializerFeature.isEnabled(i11, i10, serializerFeature) || !(beanContext == null || (beanContext.getFeatures() & serializerFeature.mask) == 0)) && (((z10 = obj2 instanceof Number)) || (obj2 instanceof Boolean))) {
                String str2 = null;
                if (z10 && beanContext != null) {
                    str2 = beanContext.getFormat();
                }
                if (str2 != null) {
                    obj2 = new DecimalFormat(str2).format(obj2);
                } else {
                    obj2 = obj2.toString();
                }
            } else if (beanContext != null && beanContext.isJsonDirect()) {
                obj2 = JSON.parse((String) obj2);
            }
        }
        List<ValueFilter> list = jSONSerializer.valueFilters;
        if (list != null) {
            Iterator<ValueFilter> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                obj2 = iterator2.next().process(obj, str, obj2);
            }
        }
        List<ValueFilter> list2 = this.valueFilters;
        if (list2 != null) {
            Iterator<ValueFilter> iterator22 = list2.iterator2();
            while (iterator22.hasNext()) {
                obj2 = iterator22.next().process(obj, str, obj2);
            }
        }
        List<ContextValueFilter> list3 = jSONSerializer.contextValueFilters;
        if (list3 != null) {
            Iterator<ContextValueFilter> iterator23 = list3.iterator2();
            while (iterator23.hasNext()) {
                obj2 = iterator23.next().process(beanContext, obj, str, obj2);
            }
        }
        List<ContextValueFilter> list4 = this.contextValueFilters;
        if (list4 != null) {
            Iterator<ContextValueFilter> iterator24 = list4.iterator2();
            while (iterator24.hasNext()) {
                obj2 = iterator24.next().process(beanContext, obj, str, obj2);
            }
        }
        return obj2;
    }

    public boolean writeDirect(JSONSerializer jSONSerializer) {
        return jSONSerializer.out.writeDirect && this.writeDirect && jSONSerializer.writeDirect;
    }
}
