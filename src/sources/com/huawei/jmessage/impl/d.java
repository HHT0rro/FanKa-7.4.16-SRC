package com.huawei.jmessage.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.jmessage.api.MessageChannelPayload;
import com.huawei.jmessage.f;
import com.huawei.jmessage.impl.c;
import com.koushikdutta.quack.JavaScriptObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageChannelPayloadFactory.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d implements c.InterfaceC0327c<MessageChannelPayload> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f32048a = "MCPFactory";

    /* renamed from: b, reason: collision with root package name */
    private static final String f32049b = "method";

    /* renamed from: c, reason: collision with root package name */
    private static final String f32050c = "args";

    /* renamed from: d, reason: collision with root package name */
    private static final String f32051d = "success";

    /* renamed from: e, reason: collision with root package name */
    private static final String f32052e = "error";

    /* renamed from: f, reason: collision with root package name */
    private static final String f32053f = "notImplemented";

    private static MessageChannelPayload b(@NonNull JavaScriptObject javaScriptObject) {
        if (!c.d(javaScriptObject)) {
            Log.e(f32048a, "The message channel payload must be JSON object.");
            return null;
        }
        Object obj = javaScriptObject.get("method");
        if (obj instanceof String) {
            String str = (String) obj;
            if (!str.isEmpty()) {
                MessageChannelPayload.Builder builder = new MessageChannelPayload.Builder(str);
                Object obj2 = javaScriptObject.get(f32050c);
                if (c.d(obj2)) {
                    builder.args(c.b((JavaScriptObject) obj2));
                } else {
                    Log.e(f32048a, "The 'args' must be JSON object.");
                }
                Object obj3 = javaScriptObject.get("success");
                if (c.c(obj3)) {
                    builder.success(new f((JavaScriptObject) obj3));
                }
                Object obj4 = javaScriptObject.get("error");
                if (c.c(obj4)) {
                    builder.error(new f((JavaScriptObject) obj4));
                }
                Object obj5 = javaScriptObject.get(f32053f);
                if (c.c(obj5)) {
                    builder.notImplemented(new f((JavaScriptObject) obj5));
                }
                return builder.build();
            }
        }
        Log.e(f32048a, "The 'method' must not be null or empty.");
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.jmessage.impl.c.InterfaceC0327c
    public MessageChannelPayload a(@NonNull JavaScriptObject javaScriptObject) {
        return b(javaScriptObject);
    }
}
