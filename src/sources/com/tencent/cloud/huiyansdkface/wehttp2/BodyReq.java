package com.tencent.cloud.huiyansdkface.wehttp2;

import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.openalliance.ad.constant.u;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.okhttp3.MultipartBody;
import com.tencent.cloud.huiyansdkface.okhttp3.RequestBody;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class BodyReq extends BaseReq<BodyReq> {

    /* renamed from: f, reason: collision with root package name */
    private RequestBody f42204f;

    /* renamed from: g, reason: collision with root package name */
    private File f42205g;

    /* renamed from: h, reason: collision with root package name */
    private List<MultiPart> f42206h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, String> f42207i;

    /* renamed from: j, reason: collision with root package name */
    private MediaType f42208j;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class MultiPart {

        /* renamed from: a, reason: collision with root package name */
        public String f42209a;

        /* renamed from: b, reason: collision with root package name */
        public String f42210b;

        /* renamed from: c, reason: collision with root package name */
        public File f42211c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f42212d;

        /* renamed from: e, reason: collision with root package name */
        public String f42213e;

        /* renamed from: f, reason: collision with root package name */
        public MediaType f42214f;

        public MultiPart(String str, String str2, MediaType mediaType) {
            this.f42209a = str;
            this.f42213e = str2;
            this.f42214f = mediaType;
        }

        public MultiPart(String str, String str2, File file, MediaType mediaType) {
            this.f42209a = str;
            if (str2 != null) {
                try {
                    str2 = URLEncoder.encode(str2, "UTF8");
                } catch (UnsupportedEncodingException unused) {
                }
            }
            this.f42210b = str2;
            this.f42211c = file;
            this.f42214f = mediaType;
        }

        public MultiPart(String str, byte[] bArr, MediaType mediaType) {
            this.f42209a = str;
            this.f42212d = bArr;
            this.f42214f = mediaType;
        }

        public static MultiPart create(String str, File file, MediaType mediaType) {
            return new MultiPart(str, null, file, mediaType);
        }

        public static MultiPart create(String str, String str2, MediaType mediaType) {
            return new MultiPart(str, str2, mediaType);
        }

        public static MultiPart create(String str, String str2, File file, MediaType mediaType) {
            return new MultiPart(str, str2, file, mediaType);
        }

        public static MultiPart create(String str, String str2, byte[] bArr, MediaType mediaType) {
            MultiPart multiPart = new MultiPart(str, bArr, mediaType);
            multiPart.f42210b = str2;
            return multiPart;
        }

        public static MultiPart create(String str, byte[] bArr, MediaType mediaType) {
            return new MultiPart(str, bArr, mediaType);
        }
    }

    public BodyReq(WeOkHttp weOkHttp, String str, String str2) {
        super(weOkHttp, str, str2);
        this.f42206h = new ArrayList();
        this.f42207i = new HashMap();
    }

    private MediaType a(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file 不能为null");
        }
        String name = file.getName();
        return name.endsWith(".png") ? MediaType.f41430a : (name.endsWith(".jpg") || name.endsWith(".jpeg")) ? MediaType.f41431b : name.endsWith(".gif") ? MediaType.f41432c : MediaType.f41439j;
    }

    private String a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append("=");
            try {
                sb2.append(URLEncoder.encode(entry.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            sb2.append(SymbolValues.CHAR_AND_SYMBOL);
        }
        String sb3 = sb2.toString();
        return sb3.endsWith("&") ? sb3.substring(0, sb3.length() - 1) : sb3;
    }

    private boolean d() {
        return this.f42208j != null && MediaType.f41438i.type().equals(this.f42208j.type());
    }

    public BodyReq addBodyQuery(String str, String str2) {
        this.f42207i.put(str, str2);
        return this;
    }

    public BodyReq addBodyQuery(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            this.f42207i.putAll(map);
        }
        return this;
    }

    public BodyReq addPart(String str, File file) {
        addPart(str, file, a(file));
        return this;
    }

    public BodyReq addPart(String str, File file, MediaType mediaType) {
        return addPart(str, file != null ? file.getName() : null, file, mediaType);
    }

    public BodyReq addPart(String str, String str2, MediaType mediaType) {
        if (str2 == null || TextUtils.isEmpty(str)) {
            return this;
        }
        this.f42206h.add(MultiPart.create(str, str2, mediaType));
        return this;
    }

    public BodyReq addPart(String str, String str2, File file) {
        return addPart(str, str2, file, a(file));
    }

    public BodyReq addPart(String str, String str2, File file, MediaType mediaType) {
        if (file == null) {
            throw new IllegalArgumentException("file cannot be null");
        }
        if (!d()) {
            multiPart();
        }
        this.f42206h.add(MultiPart.create(str, str2, file, mediaType));
        return this;
    }

    public BodyReq addPart(String str, String str2, byte[] bArr, MediaType mediaType) {
        if (!d()) {
            multiPart();
        }
        this.f42206h.add(MultiPart.create(str, str2, bArr, mediaType));
        return this;
    }

    public BodyReq addPart(String str, byte[] bArr, MediaType mediaType) {
        if (bArr == null || TextUtils.isEmpty(str)) {
            return this;
        }
        if (mediaType == null) {
            mediaType = MediaType.f41439j;
        }
        this.f42206h.add(MultiPart.create(str, bArr, mediaType));
        return this;
    }

    @Deprecated
    public BodyReq body(Object obj) {
        MediaType mediaType;
        Object invoke;
        if (obj == null) {
            return bodyJson("");
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Field[] declaredFields2 = obj.getClass().getSuperclass().getDeclaredFields();
        int length = declaredFields.length + declaredFields2.length;
        Field[] fieldArr = new Field[length];
        for (int i10 = 0; i10 < declaredFields.length; i10++) {
            fieldArr[i10] = declaredFields[i10];
        }
        for (int length2 = declaredFields.length; length2 < length; length2++) {
            fieldArr[length2] = declaredFields2[length2 - declaredFields.length];
        }
        if (length == 0) {
            return bodyJson("");
        }
        HashMap hashMap = new HashMap();
        boolean z10 = false;
        for (int i11 = 0; i11 < length; i11++) {
            try {
                Field field = fieldArr[i11];
                int modifiers = field.getModifiers();
                if ((modifiers & 8) == 0) {
                    String name = field.getName();
                    if ((modifiers & 1) != 0) {
                        Object obj2 = field.get(obj);
                        if (obj2 != null) {
                            hashMap.put(name, obj2);
                            if (field.getType().equals(File.class)) {
                                z10 = true;
                            }
                        }
                    } else {
                        Class<?> cls = obj.getClass();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(MonitorConstants.CONNECT_TYPE_GET);
                        sb2.append(name.substring(0, 1).toUpperCase());
                        sb2.append(name.length() == 1 ? "" : name.substring(1));
                        Method method = cls.getMethod(sb2.toString(), new Class[0]);
                        if (method != null && (invoke = method.invoke(obj, new Object[0])) != null) {
                            hashMap.put(name, invoke);
                            if (!field.getType().equals(File.class)) {
                            }
                            z10 = true;
                        }
                    }
                }
            } catch (NoSuchMethodException unused) {
            } catch (Exception e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(e2.getClass().getSimpleName());
                sb3.append(u.bD);
                sb3.append(e2.getMessage());
            }
        }
        if (!z10 && ((mediaType = this.f42208j) == null || MediaType.f41436g.equals(mediaType))) {
            return bodyJson(obj);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            boolean z11 = value instanceof File;
            String str = (String) entry.getKey();
            if (z11) {
                addPart(str, (File) value);
            } else {
                addBodyQuery(str, String.valueOf(value));
            }
        }
        return this;
    }

    public BodyReq bodyFile(File file) {
        return bodyFile(file, a(file));
    }

    public BodyReq bodyFile(File file, MediaType mediaType) {
        if (file == null) {
            throw new IllegalArgumentException("file cannot be null.");
        }
        if (mediaType == null) {
            return bodyFile(file);
        }
        this.f42208j = mediaType;
        this.f42205g = file;
        return this;
    }

    public BodyReq bodyJson(Object obj) {
        String str;
        if (obj == null) {
            str = "";
        } else {
            TypeAdapter adapter = this.f42177d.config().adapter();
            if (adapter == null) {
                return body(obj);
            }
            str = adapter.to(obj);
        }
        return bodyJson(str);
    }

    public BodyReq bodyJson(String str) {
        MediaType mediaType = MediaType.f41436g;
        this.f42208j = mediaType;
        this.f42204f = RequestBody.create(mediaType, str);
        return this;
    }

    @Deprecated
    public BodyReq bodyJson(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null || map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return bodyJson(jSONObject.toString());
    }

    public BodyReq bodyJson(JSONArray jSONArray) {
        if (jSONArray != null) {
            return bodyJson(jSONArray.toString());
        }
        throw new IllegalArgumentException("array 不能为null");
    }

    public BodyReq bodyJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            return bodyJson(jSONObject.toString());
        }
        throw new IllegalArgumentException("object 不能为null");
    }

    public BodyReq bodyPart(Object obj) {
        multiPart();
        return body(obj);
    }

    public BodyReq bodyText(String str) {
        MediaType mediaType = MediaType.f41433d;
        this.f42208j = mediaType;
        this.f42204f = RequestBody.create(mediaType, str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    @Override // com.tencent.cloud.huiyansdkface.wehttp2.BaseReq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.cloud.huiyansdkface.okhttp3.Call c() {
        /*
            r6 = this;
            boolean r0 = r6.d()
            if (r0 == 0) goto L85
            com.tencent.cloud.huiyansdkface.okhttp3.MultipartBody$Builder r0 = new com.tencent.cloud.huiyansdkface.okhttp3.MultipartBody$Builder
            r0.<init>()
            com.tencent.cloud.huiyansdkface.okhttp3.MediaType r1 = r6.f42208j
            r0.setType(r1)
            java.util.Map<java.lang.String, java.lang.String> r1 = r6.f42207i
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator2()
        L1a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L38
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L1a
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r0.addFormDataPart(r2, r3)
            goto L1a
        L38:
            java.util.List<com.tencent.cloud.huiyansdkface.wehttp2.BodyReq$MultiPart> r1 = r6.f42206h
            java.util.Iterator r1 = r1.iterator2()
        L3e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L80
            java.lang.Object r2 = r1.next()
            com.tencent.cloud.huiyansdkface.wehttp2.BodyReq$MultiPart r2 = (com.tencent.cloud.huiyansdkface.wehttp2.BodyReq.MultiPart) r2
            java.io.File r3 = r2.f42211c
            if (r3 == 0) goto L5c
            java.lang.String r4 = r2.f42209a
            java.lang.String r5 = r2.f42210b
            com.tencent.cloud.huiyansdkface.okhttp3.MediaType r2 = r2.f42214f
            com.tencent.cloud.huiyansdkface.okhttp3.RequestBody r2 = com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.create(r2, r3)
            r0.addFormDataPart(r4, r5, r2)
            goto L3e
        L5c:
            byte[] r3 = r2.f42212d
            if (r3 == 0) goto L72
            java.lang.String r4 = r2.f42209a
            java.lang.String r5 = r2.f42210b
            com.tencent.cloud.huiyansdkface.okhttp3.MediaType r2 = r2.f42214f
            com.tencent.cloud.huiyansdkface.okhttp3.RequestBody r2 = com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.create(r2, r3)
        L6a:
            com.tencent.cloud.huiyansdkface.okhttp3.MultipartBody$Part r2 = com.tencent.cloud.huiyansdkface.okhttp3.MultipartBody.Part.createFormData(r4, r5, r2)
            r0.addPart(r2)
            goto L3e
        L72:
            java.lang.String r3 = r2.f42213e
            if (r3 == 0) goto L3e
            java.lang.String r4 = r2.f42209a
            r5 = 0
            com.tencent.cloud.huiyansdkface.okhttp3.MediaType r2 = r2.f42214f
            com.tencent.cloud.huiyansdkface.okhttp3.RequestBody r2 = com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.create(r2, r3)
            goto L6a
        L80:
            com.tencent.cloud.huiyansdkface.okhttp3.MultipartBody r0 = r0.build()
            goto Lad
        L85:
            com.tencent.cloud.huiyansdkface.okhttp3.MediaType r0 = r6.f42208j
            if (r0 != 0) goto La3
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.f42207i
            int r0 = r0.size()
            if (r0 <= 0) goto La0
            com.tencent.cloud.huiyansdkface.okhttp3.MediaType r0 = com.tencent.cloud.huiyansdkface.okhttp3.MediaType.f41437h
            r6.f42208j = r0
            java.util.Map<java.lang.String, java.lang.String> r1 = r6.f42207i
            java.lang.String r1 = r6.a(r1)
            com.tencent.cloud.huiyansdkface.okhttp3.RequestBody r0 = com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.create(r0, r1)
            goto Lad
        La0:
            com.tencent.cloud.huiyansdkface.okhttp3.RequestBody r0 = com.tencent.cloud.huiyansdkface.okhttp3.internal.Util.f41603d
            goto Lad
        La3:
            com.tencent.cloud.huiyansdkface.okhttp3.RequestBody r1 = r6.f42204f
            if (r1 != 0) goto Laf
            java.io.File r1 = r6.f42205g
            com.tencent.cloud.huiyansdkface.okhttp3.RequestBody r0 = com.tencent.cloud.huiyansdkface.okhttp3.RequestBody.create(r0, r1)
        Lad:
            r6.f42204f = r0
        Laf:
            com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl$Builder r0 = r6.b()
            com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl r0 = r0.build()
            com.tencent.cloud.huiyansdkface.okhttp3.Request$Builder r1 = r6.a()
            com.tencent.cloud.huiyansdkface.okhttp3.Request$Builder r1 = r1.url(r0)
            java.lang.String r2 = r6.f42174a
            if (r2 != 0) goto Lc7
            java.lang.String r2 = "POST"
            r6.f42174a = r2
        Lc7:
            java.lang.String r2 = r6.f42174a
            com.tencent.cloud.huiyansdkface.okhttp3.RequestBody r3 = r6.f42204f
            r1.method(r2, r3)
            java.lang.Class<com.tencent.cloud.huiyansdkface.wehttp2.LogTag> r2 = com.tencent.cloud.huiyansdkface.wehttp2.LogTag.class
            com.tencent.cloud.huiyansdkface.wehttp2.LogTag r3 = new com.tencent.cloud.huiyansdkface.wehttp2.LogTag
            com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp r4 = r6.f42177d
            com.tencent.cloud.huiyansdkface.wehttp2.WeConfig r4 = r4.config()
            com.tencent.cloud.huiyansdkface.wehttp2.WeLog$ILogTag r4 = r4.iLogTag()
            java.lang.Object r5 = r1.tag()
            java.lang.String r0 = r4.tag(r0, r5)
            r3.<init>(r0)
            r1.tag(r2, r3)
            com.tencent.cloud.huiyansdkface.wehttp2.WeOkHttp r0 = r6.f42177d
            com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient r0 = r0.client()
            com.tencent.cloud.huiyansdkface.okhttp3.Request r1 = r1.build()
            com.tencent.cloud.huiyansdkface.okhttp3.Call r0 = r0.newCall(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.wehttp2.BodyReq.c():com.tencent.cloud.huiyansdkface.okhttp3.Call");
    }

    public BodyReq formData() {
        this.f42208j = MultipartBody.f41450e;
        return this;
    }

    public BodyReq multiPart() {
        this.f42208j = MultipartBody.f41446a;
        return this;
    }

    public BodyReq multiPart(String str) {
        this.f42208j = MediaType.parse("multipart/" + str);
        return this;
    }
}
