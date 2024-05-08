package com.alibaba.security.biometrics.service.util.params;

import com.alibaba.security.common.utils.JsonUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JsonBundleConverter extends BundleConverter {
    @Override // com.alibaba.security.biometrics.service.util.params.BundleConverter
    public Object deserialize(Object obj) {
        if (obj != null && (obj instanceof String)) {
            return JsonUtils.parseObject((String) obj, this.type);
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.service.util.params.BundleConverter
    public String serialize(Object obj) {
        return JsonUtils.toJSON(obj);
    }
}
