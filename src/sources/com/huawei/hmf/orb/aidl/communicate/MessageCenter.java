package com.huawei.hmf.orb.aidl.communicate;

import android.text.TextUtils;
import com.huawei.hmf.orb.IMessageEntity;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class MessageCenter {
    private static final String TAG = "MessageCenter";
    private static MessageCenter instance = new MessageCenter();
    private Map<String, CallObject> msg = new HashMap();

    private MessageCenter() {
    }

    public static MessageCenter getInstance() {
        return instance;
    }

    public AIDLRequest<IMessageEntity> makeRequest(String str) {
        return makeRequest(str, false);
    }

    public CallObject query(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.msg.get(str);
        }
        throw new IllegalArgumentException("URI cannot be null.");
    }

    public void register(String str, Class<? extends AIDLRequest<?>> cls) {
        register(str, cls, true);
    }

    public AIDLRequest<IMessageEntity> makeRequest(String str, boolean z10) {
        CallObject query = query(str);
        if (query == null) {
            return null;
        }
        if (!z10 || query.isExport()) {
            return query.makeRequest();
        }
        return null;
    }

    public void register(String str, Class<? extends AIDLRequest<?>> cls, boolean z10) {
        if (cls != null) {
            if (!TextUtils.isEmpty(str)) {
                CallObject callObject = new CallObject(z10);
                callObject.requestClass = cls;
                this.msg.put(str, callObject);
                return;
            }
            throw new IllegalArgumentException("URI cannot be null.");
        }
        throw new IllegalArgumentException("requestClass cannot be null.");
    }
}
