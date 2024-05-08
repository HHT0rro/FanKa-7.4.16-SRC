package com.tencent.cloud.huiyansdkface.a.a;

import com.huawei.openalliance.ad.constant.u;
import com.tencent.connect.share.QzonePublish;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<EnumC0613a, Object> f40264a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.e.b f40265b;

    /* renamed from: com.tencent.cloud.huiyansdkface.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum EnumC0613a {
        PREVIEW_SIZE("previewSize"),
        PICTURE_SIZE("pictureSize"),
        ZOOM("zoom"),
        FLASH_MODE("flashMode"),
        FOCUS_MODE("focusMode"),
        FPS("fps"),
        VIDEO_SIZE(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE);


        /* renamed from: h, reason: collision with root package name */
        private String f40274h;

        EnumC0613a(String str) {
            this.f40274h = str;
        }
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.d a() {
        return (com.tencent.cloud.huiyansdkface.a.a.a.d) this.f40264a.get(EnumC0613a.PREVIEW_SIZE);
    }

    public a a(float f10) {
        if (f10 >= 0.0f && f10 <= 1.0f) {
            this.f40264a.put(EnumC0613a.ZOOM, Float.valueOf(f10));
        }
        return this;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.a.a.b bVar) {
        if (bVar != null) {
            this.f40264a.put(EnumC0613a.FPS, bVar);
        }
        return this;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.a.a.d dVar) {
        if (dVar != null) {
            this.f40264a.put(EnumC0613a.PREVIEW_SIZE, dVar);
        }
        return this;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.e.b bVar) {
        this.f40265b = bVar;
        return this;
    }

    public a a(String str) {
        if (str != null) {
            this.f40264a.put(EnumC0613a.FLASH_MODE, str);
        }
        return this;
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.b b() {
        return (com.tencent.cloud.huiyansdkface.a.a.a.b) this.f40264a.get(EnumC0613a.FPS);
    }

    public a b(com.tencent.cloud.huiyansdkface.a.a.a.d dVar) {
        if (dVar != null) {
            this.f40264a.put(EnumC0613a.VIDEO_SIZE, dVar);
        }
        return this;
    }

    public a b(String str) {
        if (str != null) {
            this.f40264a.put(EnumC0613a.FOCUS_MODE, str);
        }
        return this;
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.d c() {
        return (com.tencent.cloud.huiyansdkface.a.a.a.d) this.f40264a.get(EnumC0613a.PICTURE_SIZE);
    }

    public a c(com.tencent.cloud.huiyansdkface.a.a.a.d dVar) {
        if (dVar != null) {
            this.f40264a.put(EnumC0613a.PICTURE_SIZE, dVar);
        }
        return this;
    }

    public float d() {
        Object obj = this.f40264a.get(EnumC0613a.ZOOM);
        if (obj == null) {
            return -1.0f;
        }
        return ((Float) obj).floatValue();
    }

    public String e() {
        return (String) this.f40264a.get(EnumC0613a.FLASH_MODE);
    }

    public String f() {
        return (String) this.f40264a.get(EnumC0613a.FOCUS_MODE);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CameraConfig:\n--------------------------------------\n");
        for (Map.Entry<EnumC0613a, Object> entry : this.f40264a.entrySet()) {
            sb2.append((Object) entry.getKey());
            sb2.append(u.bD);
            Object value = entry.getValue();
            if (value != null) {
                if (!(value instanceof com.tencent.cloud.huiyansdkface.a.a.a.d) && (value instanceof String)) {
                    sb2.append(value);
                } else {
                    sb2.append(value.toString());
                }
                sb2.append("\n");
            }
        }
        sb2.append("--------------------------------------");
        return sb2.toString();
    }
}
