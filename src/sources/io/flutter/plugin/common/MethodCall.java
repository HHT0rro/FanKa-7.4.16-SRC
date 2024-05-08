package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MethodCall {
    public final Object arguments;
    public final String method;

    public MethodCall(@NonNull String str, @Nullable Object obj) {
        this.method = str;
        this.arguments = obj;
    }

    @Nullable
    public <T> T argument(@NonNull String str) {
        Object obj = this.arguments;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return (T) ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return (T) ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    @Nullable
    public <T> T arguments() {
        return (T) this.arguments;
    }

    public boolean hasArgument(@NonNull String str) {
        Object obj = this.arguments;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).has(str);
        }
        throw new ClassCastException();
    }
}
