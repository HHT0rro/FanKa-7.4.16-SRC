package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeConfigLoader implements ConfigLoader {

    /* renamed from: a, reason: collision with root package name */
    private Context f42353a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f42354b;

    /* renamed from: c, reason: collision with root package name */
    private WeConfig f42355c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f42356d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f42357e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f42358f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f42359g = false;

    /* renamed from: h, reason: collision with root package name */
    private ExtConfigLoader f42360h = new ExtConfigLoader() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfigLoader.1
        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeConfigLoader.ExtConfigLoader
        public void onLoad(String str, Object obj, WeConfig weConfig) {
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeConfigLoader.ExtConfigLoader
        public Map<String, Object> onSave(WeConfig weConfig) {
            return Collections.emptyMap();
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ExtConfigLoader {
        void onLoad(String str, Object obj, WeConfig weConfig);

        Map<String, Object> onSave(WeConfig weConfig);
    }

    public WeConfigLoader(Context context, WeConfig weConfig, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (weConfig == null) {
            throw new IllegalArgumentException("weConfig must not be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("saveConfigName is empty");
        }
        this.f42355c = weConfig;
        Context applicationContext = context.getApplicationContext();
        this.f42353a = applicationContext;
        this.f42354b = applicationContext.getSharedPreferences("wehttp_config_save_" + str, 0);
    }

    public Map<String, Object> a(WeConfig weConfig) {
        return this.f42360h.onSave(weConfig);
    }

    public void a(String str, Object obj, WeConfig weConfig) {
        this.f42360h.onLoad(str, obj, weConfig);
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.ConfigLoader
    public void loadOnce() {
        if (this.f42356d) {
            return;
        }
        this.f42356d = true;
        for (Map.Entry<String, ?> entry : this.f42354b.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                if ("baseUrl".equals(key)) {
                    this.f42355c.baseUrl((String) value);
                } else if ("certVerify".equals(key)) {
                    if (this.f42357e) {
                        this.f42355c.setCertVerify(((Boolean) value).booleanValue());
                    }
                } else if ("pinList".equals(key)) {
                    if (this.f42357e) {
                        Set<String> set = (Set) value;
                        if (!set.isEmpty()) {
                            for (String str : set) {
                                if (str.contains(":::")) {
                                    String[] split = str.split(":::");
                                    this.f42355c.addPin4Host(split[0], split[1]);
                                }
                            }
                        }
                    }
                } else if (key.startsWith("_header_")) {
                    if (this.f42358f) {
                        this.f42355c.header(key.substring(8), (String) value);
                    }
                } else if (!key.startsWith("_param_")) {
                    a(key, value, this.f42355c);
                } else if (this.f42359g) {
                    this.f42355c.params(key.substring(7), (String) value);
                }
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.ConfigLoader
    public void save() {
        int i10;
        Map<String, String> headers;
        Map<String, String> params;
        SharedPreferences.Editor edit = this.f42354b.edit();
        String baseUrl = this.f42355c.getBaseUrl();
        if (baseUrl != null) {
            edit.putString("baseUrl", baseUrl);
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (this.f42357e) {
            boolean isCertVerify = this.f42355c.isCertVerify();
            if (isCertVerify) {
                i10++;
                edit.putBoolean("certVerify", isCertVerify);
            }
            List<Pin> pinList = this.f42355c.getPinList();
            if (pinList != null && pinList.size() > 0) {
                HashSet hashSet = new HashSet();
                for (Pin pin : pinList) {
                    if (pin.getPattern() != null && pin.getPin() != null) {
                        hashSet.add(pin.getPattern() + ":::" + pin.getPin());
                    }
                }
                if (hashSet.size() > 0) {
                    i10++;
                    edit.putStringSet("pinList", hashSet);
                }
            }
        }
        if (this.f42359g && (params = this.f42355c.getParams()) != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                i10++;
                edit.putString("_param_" + entry.getKey(), entry.getValue());
            }
        }
        if (this.f42358f && (headers = this.f42355c.getHeaders()) != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry2 : headers.entrySet()) {
                i10++;
                edit.putString("_header_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, Object> a10 = a(this.f42355c);
        if (a10 != null && a10.size() > 0) {
            for (Map.Entry<String, Object> entry3 : a10.entrySet()) {
                String key = entry3.getKey();
                Object value = entry3.getValue();
                if (key != null && value != null) {
                    i10++;
                    if (value instanceof String) {
                        edit.putString(key, (String) value);
                    } else if (value instanceof Long) {
                        edit.putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Integer) {
                        edit.putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof Set) {
                        edit.putStringSet(key, (Set) value);
                    } else {
                        i10--;
                    }
                }
            }
        }
        if (i10 > 0) {
            edit.commit();
        }
    }

    public WeConfigLoader setExtConfigLoader(ExtConfigLoader extConfigLoader) {
        if (extConfigLoader != null) {
            this.f42360h = extConfigLoader;
        }
        return this;
    }

    public WeConfigLoader setSaveHeader(boolean z10) {
        this.f42358f = z10;
        return this;
    }

    public WeConfigLoader setSaveParam(boolean z10) {
        this.f42359g = z10;
        return this;
    }

    public WeConfigLoader setSavePin(boolean z10) {
        this.f42357e = z10;
        return this;
    }
}
