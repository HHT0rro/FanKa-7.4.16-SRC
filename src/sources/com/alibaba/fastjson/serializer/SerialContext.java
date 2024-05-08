package com.alibaba.fastjson.serializer;

import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SerialContext {
    public final int features;
    public final Object fieldName;
    public final Object object;
    public final SerialContext parent;

    public SerialContext(SerialContext serialContext, Object obj, Object obj2, int i10, int i11) {
        this.parent = serialContext;
        this.object = obj;
        this.fieldName = obj2;
        this.features = i10;
    }

    public Object getFieldName() {
        return this.fieldName;
    }

    public Object getObject() {
        return this.object;
    }

    public SerialContext getParent() {
        return this.parent;
    }

    public String getPath() {
        return toString();
    }

    public String toString() {
        if (this.parent == null) {
            return "$";
        }
        StringBuilder sb2 = new StringBuilder();
        toString(sb2);
        return sb2.toString();
    }

    public void toString(StringBuilder sb2) {
        boolean z10;
        SerialContext serialContext = this.parent;
        if (serialContext == null) {
            sb2.append('$');
            return;
        }
        serialContext.toString(sb2);
        Object obj = this.fieldName;
        if (obj == null) {
            sb2.append(".null");
            return;
        }
        if (obj instanceof Integer) {
            sb2.append('[');
            sb2.append(((Integer) this.fieldName).intValue());
            sb2.append(']');
            return;
        }
        sb2.append('.');
        String obj2 = this.fieldName.toString();
        int i10 = 0;
        while (true) {
            if (i10 >= obj2.length()) {
                z10 = false;
                break;
            }
            char charAt = obj2.charAt(i10);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && charAt <= 128))) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            for (int i11 = 0; i11 < obj2.length(); i11++) {
                char charAt2 = obj2.charAt(i11);
                if (charAt2 == '\\') {
                    sb2.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    sb2.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    sb2.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                } else if ((charAt2 >= '0' && charAt2 <= '9') || ((charAt2 >= 'A' && charAt2 <= 'Z') || ((charAt2 >= 'a' && charAt2 <= 'z') || charAt2 > 128))) {
                    sb2.append(charAt2);
                } else {
                    sb2.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    sb2.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                }
                sb2.append(charAt2);
            }
            return;
        }
        sb2.append(obj2);
    }
}
