package com.alibaba.security.biometrics.skin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;
import com.alibaba.security.biometrics.skin.model.BaseSkinData;
import com.alibaba.security.biometrics.skin.model.ButtonSkinData;
import com.alibaba.security.biometrics.skin.model.ControlSkinData;
import com.alibaba.security.biometrics.skin.model.DetectAnimSkinData;
import com.alibaba.security.biometrics.skin.model.DialogSkinData;
import com.alibaba.security.biometrics.skin.model.ImageViewSkinData;
import com.alibaba.security.biometrics.skin.model.NavigatorSkinData;
import com.alibaba.security.biometrics.skin.model.TextViewSkinData;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.utils.FileUtils;
import com.alibaba.security.common.utils.JsonUtils;
import com.huawei.quickcard.base.Attributes;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPSkinManager implements ISkinParse {
    private static final String KEY_GLOBAL = "global";
    private static final String KEY_NATIVE = "native";
    private static final String KEY_WEB = "web";
    private static final String NAME_SKIN = "RPSkin.json";
    private static final String PATH_RES = "Resources";
    private static final String TAG = "RPSkinManager";
    private Context mContext;
    private final Map<String, BaseSkinData> mGlobalDataPools;
    private boolean mIsAssets;
    private final Map<String, BaseSkinData> mNativeGlobalDataPools;
    private final Map<String, Map<String, BaseSkinData>> mNativeSkinDataPools;
    private final RPWebViewMediaCacheManager mRPWebViewMediaCacheManager;
    private String mSkinDir;
    private final Map<String, Map<String, Object>> mWebGlobalSkinDataPools;
    private final Map<String, Map<String, Map<String, Object>>> mWebSkinDataPools;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class HOLDER {
        private static final RPSkinManager SINGLE = new RPSkinManager();

        private HOLDER() {
        }
    }

    private Bitmap createAssetsBitmap(String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = this.mContext.getAssets().open(str);
        } catch (Exception unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            return decodeStream;
        } catch (Exception unused3) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private Bitmap createFileBitmap(String str) {
        try {
            return BitmapFactory.decodeFile(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static RPSkinManager getInstance() {
        return HOLDER.SINGLE;
    }

    private <T extends BaseSkinData> T getSkinData(String str, String str2, String str3, Class<T> cls) {
        Map<String, BaseSkinData> map;
        Map<String, BaseSkinData> map2;
        Map<String, BaseSkinData> map3;
        Map<String, Map<String, BaseSkinData>> map4 = this.mNativeSkinDataPools;
        T t2 = (map4 == null || (map3 = map4.get(mergeKey(str, str2))) == null) ? null : (T) map3.get(str3);
        if (t2 == null && (map2 = this.mNativeGlobalDataPools) != null) {
            t2 = (T) map2.get(str3);
        }
        if (t2 == null && (map = this.mGlobalDataPools) != null) {
            t2 = (T) map.get(str3);
        }
        if (t2 == null) {
            return null;
        }
        try {
            t2.setKey(str + "_" + str2 + "_" + str3);
            return t2;
        } catch (Exception unused) {
            return null;
        }
    }

    private String mergeKey(String str, String str2) {
        return str + "_" + str2;
    }

    private void parseNativeData(Map<String, BaseSkinData> map, Map.Entry<String, Object> entry) {
        BaseSkinData baseSkinData;
        String key = entry.getKey();
        Object value = entry.getValue();
        if (!key.endsWith("Button") && !key.endsWith(Attributes.InputType.BUTTON)) {
            if (!key.endsWith("Text") && !key.endsWith("text")) {
                if (!key.endsWith("ImageView") && !key.endsWith("imageview")) {
                    if (!key.endsWith("Dialog") && !key.endsWith("dialog")) {
                        if (key.equalsIgnoreCase("detectAnimation")) {
                            baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), DetectAnimSkinData.class, true);
                        } else if (!key.endsWith("navigator") && !key.endsWith("Navigator")) {
                            baseSkinData = (key.endsWith("control") || key.endsWith("Control")) ? (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), ControlSkinData.class, true) : null;
                        } else {
                            baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), NavigatorSkinData.class, true);
                        }
                    } else {
                        baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), DialogSkinData.class, true);
                    }
                } else {
                    baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), ImageViewSkinData.class, true);
                }
            } else {
                baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), TextViewSkinData.class, true);
            }
        } else {
            baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), ButtonSkinData.class, true);
        }
        if (baseSkinData != null) {
            baseSkinData.parse(this);
            baseSkinData.webConvert(this);
            map.put(key, baseSkinData);
        }
    }

    private void parseWebData(Map<String, Object> map) {
        Map map2;
        Map map3;
        if (map == null || !map.containsKey("web") || (map2 = (Map) map.get("web")) == null || (map3 = (Map) JsonUtils.parseObject(JsonUtils.toJSON(map2), Map.class)) == null) {
            return;
        }
        if (map3.containsKey("global")) {
            Iterator iterator2 = ((Map) map3.get("global")).entrySet().iterator2();
            while (iterator2.hasNext()) {
                parseWebData(this.mWebGlobalSkinDataPools, (Map.Entry) iterator2.next());
            }
        }
        map3.remove("global");
        for (Map.Entry entry : map3.entrySet()) {
            HashMap hashMap = new HashMap();
            this.mWebSkinDataPools.put((String) entry.getKey(), hashMap);
            Iterator iterator22 = ((Map) entry.getValue()).entrySet().iterator2();
            while (iterator22.hasNext()) {
                parseWebData(hashMap, (Map.Entry) iterator22.next());
            }
        }
    }

    @Override // com.alibaba.security.biometrics.skin.interfaces.ISkinParse
    public String convertWebPath(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mSkinDir);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(PATH_RES);
        sb2.append(str2);
        sb2.append(str);
        return (String) this.mRPWebViewMediaCacheManager.putSkinImage(this.mContext, sb2.toString(), this.mIsAssets).second;
    }

    public String getAllWebSkinData() {
        HashMap hashMap = new HashMap();
        this.mWebSkinDataPools.put("global", this.mWebGlobalSkinDataPools);
        Map<String, Map<String, Map<String, Object>>> map = this.mWebSkinDataPools;
        if (map != null && !map.isEmpty()) {
            hashMap.put("web", this.mWebSkinDataPools);
        }
        Map<String, BaseSkinData> map2 = this.mGlobalDataPools;
        if (map2 != null && !map2.isEmpty()) {
            hashMap.put("global", this.mGlobalDataPools);
        }
        return JsonUtils.toJSON(hashMap);
    }

    public <T extends BaseSkinData> T getGlobalSkinData(String str, Class<T> cls) {
        Map<String, BaseSkinData> map;
        Map<String, BaseSkinData> map2 = this.mNativeGlobalDataPools;
        BaseSkinData baseSkinData = map2 != null ? map2.get(str) : null;
        if (baseSkinData == null && (map = this.mGlobalDataPools) != null) {
            baseSkinData = map.get(str);
        }
        if (baseSkinData == null) {
            return null;
        }
        try {
            T t2 = (T) JsonUtils.parseObject(JsonUtils.toJSON(baseSkinData), (Class) cls);
            t2.setKey("global_".concat(String.valueOf(str)));
            return t2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public <T extends BaseSkinData> T getNativeSkinData(String str, String str2, Class<T> cls) {
        return (T) getSkinData("native", str, str2, cls);
    }

    public void init(Context context, String str, boolean z10) {
        Map map;
        Map map2;
        long currentTimeMillis = System.currentTimeMillis();
        this.mContext = context;
        this.mIsAssets = z10;
        this.mSkinDir = str;
        String readStrFromFile = FileUtils.readStrFromFile(context, str + File.separator + NAME_SKIN, z10);
        if (TextUtils.isEmpty(readStrFromFile)) {
            return;
        }
        try {
            Map<String, Object> parseObject = JsonUtils.parseObject(readStrFromFile);
            if (parseObject.containsKey("global")) {
                Iterator iterator2 = ((Map) JsonUtils.parseObject(JsonUtils.toJSON((Map) parseObject.get("global")), Map.class)).entrySet().iterator2();
                while (iterator2.hasNext()) {
                    parseNativeData(this.mGlobalDataPools, (Map.Entry) iterator2.next());
                }
            }
            if (parseObject.containsKey("native") && (map = (Map) parseObject.get("native")) != null && (map2 = (Map) JsonUtils.parseObject(JsonUtils.toJSON(map), Map.class)) != null) {
                if (map2.get("global") != null) {
                    Iterator iterator22 = ((Map) map2.get("global")).entrySet().iterator2();
                    while (iterator22.hasNext()) {
                        parseNativeData(this.mNativeGlobalDataPools, (Map.Entry) iterator22.next());
                    }
                }
                map2.remove("global");
                for (Map.Entry entry : map2.entrySet()) {
                    HashMap hashMap = new HashMap();
                    this.mNativeSkinDataPools.put(mergeKey("native", (String) entry.getKey()), hashMap);
                    Iterator iterator23 = ((Map) entry.getValue()).entrySet().iterator2();
                    while (iterator23.hasNext()) {
                        parseNativeData(hashMap, (Map.Entry) iterator23.next());
                    }
                }
            }
            parseWebData(parseObject);
            RPLogging.d(TAG, "init skin consume time： " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e2) {
            RPLogging.e(TAG, e2);
            release();
        }
    }

    @Override // com.alibaba.security.biometrics.skin.interfaces.ISkinParse
    public Bitmap parseBitmap(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mSkinDir);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(PATH_RES);
        sb2.append(str2);
        sb2.append(str);
        String sb3 = sb2.toString();
        if (this.mIsAssets) {
            return createAssetsBitmap(sb3);
        }
        return createFileBitmap(sb3);
    }

    public void release() {
        Map<String, BaseSkinData> map = this.mGlobalDataPools;
        if (map != null) {
            map.clear();
        }
        Map<String, Map<String, BaseSkinData>> map2 = this.mNativeSkinDataPools;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Map<String, Map<String, Object>>> map3 = this.mWebSkinDataPools;
        if (map3 != null) {
            map3.clear();
        }
        Map<String, BaseSkinData> map4 = this.mNativeGlobalDataPools;
        if (map4 != null) {
            map4.clear();
        }
        Map<String, Map<String, Object>> map5 = this.mWebGlobalSkinDataPools;
        if (map5 != null) {
            map5.clear();
        }
    }

    private RPSkinManager() {
        this.mRPWebViewMediaCacheManager = RPWebViewMediaCacheManager.getInstance();
        this.mGlobalDataPools = new HashMap();
        this.mNativeSkinDataPools = new HashMap();
        this.mWebSkinDataPools = new HashMap();
        this.mNativeGlobalDataPools = new HashMap();
        this.mWebGlobalSkinDataPools = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void parseWebData(Map<String, Map<String, Object>> map, Map.Entry<String, Object> entry) {
        BaseSkinData baseSkinData;
        String key = entry.getKey();
        Object value = entry.getValue();
        if (!key.endsWith("Button") && !key.endsWith(Attributes.InputType.BUTTON)) {
            if (!key.endsWith("Text") && !key.endsWith("text")) {
                if (!key.endsWith("ImageView") && !key.endsWith("imageview")) {
                    if (!key.endsWith("Dialog") && !key.endsWith("dialog")) {
                        if (key.equalsIgnoreCase("detectAnimation")) {
                            baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), DetectAnimSkinData.class, true);
                        } else {
                            baseSkinData = (key.endsWith("navigator") || key.endsWith("Navigator")) ? (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), NavigatorSkinData.class, true) : null;
                        }
                    } else {
                        baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), DialogSkinData.class, true);
                    }
                } else {
                    baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), ImageViewSkinData.class, true);
                }
            } else {
                baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), TextViewSkinData.class, true);
            }
        } else {
            baseSkinData = (BaseSkinData) JsonUtils.parseObject(JsonUtils.toJSON(value), ButtonSkinData.class, true);
        }
        if (baseSkinData != null) {
            baseSkinData.webConvert(this);
            map.put(key, JsonUtils.parseObject(JsonUtils.toJSON(baseSkinData), Map.class));
            return;
        }
        if (key.endsWith("Container") || key.endsWith("container")) {
            try {
                Map<String, Object> parseObject = JsonUtils.parseObject(JsonUtils.toJSON(value));
                for (Map.Entry<String, Object> entry2 : parseObject.entrySet()) {
                    if (!entry2.getKey().endsWith("src") && !entry2.getKey().endsWith("Src")) {
                        if (entry2.getKey().endsWith("backgroundImage") || entry2.getKey().endsWith("BackgroundImage")) {
                            parseObject.put(entry2.getKey(), convertWebPath(entry2.getValue().toString()));
                        }
                    }
                    parseObject.put(entry2.getKey(), convertWebPath(entry2.getValue().toString()));
                }
                map.put(key, parseObject);
            } catch (Exception unused) {
            }
        }
    }
}
