package com.bumptech.glide.load.engine.bitmap_recycle;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("( ");
        for (Map.Entry<K, V> entry : entrySet()) {
            sb2.append('{');
            sb2.append((Object) entry.getKey());
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
            sb2.append((Object) entry.getValue());
            sb2.append("}, ");
        }
        if (!isEmpty()) {
            sb2.replace(sb2.length() - 2, sb2.length(), "");
        }
        sb2.append(" )");
        return sb2.toString();
    }
}
