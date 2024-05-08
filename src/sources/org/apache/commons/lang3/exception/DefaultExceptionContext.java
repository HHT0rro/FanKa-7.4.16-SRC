package org.apache.commons.lang3.exception;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DefaultExceptionContext implements ExceptionContext, Serializable {
    private static final long serialVersionUID = 20110706;
    private final List<Pair<String, Object>> contextValues = new ArrayList();

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Pair<String, Object>> getContextEntries() {
        return this.contextValues;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Set<String> getContextLabels() {
        HashSet hashSet = new HashSet();
        Iterator<Pair<String, Object>> iterator2 = this.contextValues.iterator2();
        while (iterator2.hasNext()) {
            hashSet.add(iterator2.next().getKey());
        }
        return hashSet;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public List<Object> getContextValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Pair<String, Object> pair : this.contextValues) {
            if (StringUtils.equals(str, pair.getKey())) {
                arrayList.add(pair.getValue());
            }
        }
        return arrayList;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public Object getFirstContextValue(String str) {
        for (Pair<String, Object> pair : this.contextValues) {
            if (StringUtils.equals(str, pair.getKey())) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public String getFormattedExceptionMessage(String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder(256);
        if (str != null) {
            sb2.append(str);
        }
        if (!this.contextValues.isEmpty()) {
            if (sb2.length() > 0) {
                sb2.append('\n');
            }
            sb2.append("Exception Context:\n");
            int i10 = 0;
            for (Pair<String, Object> pair : this.contextValues) {
                sb2.append("\t[");
                i10++;
                sb2.append(i10);
                sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                sb2.append(pair.getKey());
                sb2.append("=");
                Object value = pair.getValue();
                if (value == null) {
                    sb2.append("null");
                } else {
                    try {
                        str2 = value.toString();
                    } catch (Exception e2) {
                        str2 = "Exception thrown on toString(): " + ExceptionUtils.getStackTrace(e2);
                    }
                    sb2.append(str2);
                }
                sb2.append("]\n");
            }
            sb2.append("---------------------------------");
        }
        return sb2.toString();
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext addContextValue(String str, Object obj) {
        this.contextValues.add(new ImmutablePair(str, obj));
        return this;
    }

    @Override // org.apache.commons.lang3.exception.ExceptionContext
    public DefaultExceptionContext setContextValue(String str, Object obj) {
        Iterator<Pair<String, Object>> iterator2 = this.contextValues.iterator2();
        while (iterator2.hasNext()) {
            if (StringUtils.equals(str, iterator2.next().getKey())) {
                iterator2.remove();
            }
        }
        addContextValue(str, obj);
        return this;
    }
}
