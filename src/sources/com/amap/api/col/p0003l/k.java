package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.amap.api.col.p0003l.cs;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileProvider;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import com.huawei.quickcard.base.Attributes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* compiled from: AMapCustomStyleManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class k implements cs.a {
    private boolean B;
    private AMap3DModelTileOverlay D;
    private a F;

    /* renamed from: b, reason: collision with root package name */
    private IAMapDelegate f6601b;

    /* renamed from: c, reason: collision with root package name */
    private CustomMapStyleOptions f6602c;

    /* renamed from: i, reason: collision with root package name */
    private int f6608i;

    /* renamed from: j, reason: collision with root package name */
    private Context f6609j;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6616q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6617r;

    /* renamed from: v, reason: collision with root package name */
    private cs f6621v;

    /* renamed from: w, reason: collision with root package name */
    private cs f6622w;

    /* renamed from: a, reason: collision with root package name */
    private final String f6600a = "__MACOSX";

    /* renamed from: d, reason: collision with root package name */
    private boolean f6603d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6604e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6605f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6606g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6607h = false;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f6610k = null;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f6611l = null;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f6612m = null;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f6613n = null;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f6614o = null;

    /* renamed from: p, reason: collision with root package name */
    private byte[] f6615p = null;

    /* renamed from: s, reason: collision with root package name */
    private boolean f6618s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f6619t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f6620u = false;

    /* renamed from: x, reason: collision with root package name */
    private byte[] f6623x = null;

    /* renamed from: y, reason: collision with root package name */
    private byte[] f6624y = null;

    /* renamed from: z, reason: collision with root package name */
    private byte[] f6625z = null;
    private boolean A = false;
    private HashMap<String, byte[]> C = new HashMap<>();
    private MyTrafficStyle E = new MyTrafficStyle();

    /* compiled from: AMapCustomStyleManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a();
    }

    public k(IAMapDelegate iAMapDelegate, Context context, boolean z10) {
        this.f6608i = -1;
        this.f6616q = false;
        this.f6617r = false;
        this.B = false;
        this.f6601b = iAMapDelegate;
        this.f6609j = context;
        this.f6616q = false;
        this.f6617r = false;
        this.B = z10;
        this.f6608i = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
    }

    private void b(String str) {
        AMap3DModelTileProvider aMap3DModelTileProvider = new AMap3DModelTileProvider();
        aMap3DModelTileProvider.setUrl("https://restapi.amap.com/rest/lbs/geohub/3d/tiles?z=%d&x=%d&y=%d&id=" + str);
        AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions = new AMap3DModelTileOverlayOptions();
        aMap3DModelTileOverlayOptions.setTileProvider(aMap3DModelTileProvider);
        try {
            this.D = this.f6601b.add3DModelTileOverlay(aMap3DModelTileOverlayOptions);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static byte[] c(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                dx.a(th);
                th.printStackTrace();
                return null;
            } finally {
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
            }
        }
    }

    private void f() {
        IAMapDelegate iAMapDelegate = this.f6601b;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null && this.f6615p != null) {
            this.f6601b.getGLMapEngine().setTrafficStyleWithTexture(this.f6608i, this.f6615p, new MyTrafficStyle());
        }
        IAMapDelegate iAMapDelegate2 = this.f6601b;
        if (iAMapDelegate2 != null && iAMapDelegate2.getGLMapEngine() != null && this.f6612m != null) {
            this.f6601b.getGLMapEngine().setBackgroundTexture(this.f6608i, this.f6612m);
        }
        AMap3DModelTileOverlay aMap3DModelTileOverlay = this.D;
        if (aMap3DModelTileOverlay != null) {
            aMap3DModelTileOverlay.remove();
        }
        this.f6620u = false;
    }

    private void g() {
        if (this.B) {
            if (this.f6611l == null) {
                this.f6611l = c(FileUtil.readFileContentsFromAssets(this.f6609j, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_ABROAD));
            }
        } else if (this.f6611l == null) {
            this.f6611l = c(FileUtil.readFileContentsFromAssets(this.f6609j, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA));
        }
        this.f6601b.getGLMapEngine().setCustomStyleData(this.f6608i, this.f6611l, this.f6610k);
        this.f6619t = false;
        this.C.clear();
    }

    private void h() {
        if (this.f6618s) {
            if (this.f6613n == null) {
                this.f6613n = FileUtil.readFileContentsFromAssets(this.f6609j, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME_FOR_CUSTOM);
            }
            this.f6618s = false;
            this.f6601b.getGLMapEngine().setCustomStyleTexture(this.f6608i, this.f6613n);
        }
    }

    private void i() {
        CustomMapStyleOptions customMapStyleOptions = this.f6602c;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId(null);
            this.f6602c.setStyleDataPath(null);
            this.f6602c.setStyleData(null);
            this.f6602c.setStyleTexturePath(null);
            this.f6602c.setStyleTextureData(null);
            this.f6602c.setStyleExtraData(null);
            this.f6602c.setStyleExtraPath(null);
        }
    }

    public final void a() {
        IAMapDelegate iAMapDelegate;
        if (this.f6602c == null || this.f6617r) {
            return;
        }
        try {
            MapConfig mapConfig = this.f6601b.getMapConfig();
            if (mapConfig == null) {
                return;
            }
            synchronized (this) {
                if (mapConfig.isHideLogoEnable() && (iAMapDelegate = this.f6601b) != null && iAMapDelegate.getUiSettings() != null) {
                    if (this.f6601b.getUiSettings().isLogoEnable()) {
                        if (this.f6602c.isEnable()) {
                            if (this.f6619t) {
                                this.f6601b.getUiSettings().setLogoEnable(false);
                            }
                        } else {
                            this.f6601b.getUiSettings().setLogoEnable(true);
                        }
                    } else if (!this.f6619t) {
                        this.f6601b.getUiSettings().setLogoEnable(true);
                    }
                }
                if (this.f6603d) {
                    if (this.f6602c.isEnable()) {
                        this.f6601b.getGLMapEngine().setNativeMapModeAndStyle(this.f6608i, 0, 0);
                        mapConfig.setCustomStyleEnable(true);
                        this.f6603d = false;
                    } else {
                        this.f6601b.getGLMapEngine().setNativeMapModeAndStyle(this.f6608i, mapConfig.getMapStyleMode(), mapConfig.getMapStyleTime());
                        this.f6619t = false;
                        if (mapConfig.isCustomStyleEnable()) {
                            if (mapConfig.getMapStyleMode() == 0 && mapConfig.getMapStyleTime() == 0) {
                                g();
                            }
                            h();
                            if (this.f6620u) {
                                f();
                            }
                            mapConfig.setCustomStyleEnable(false);
                        }
                        this.f6603d = false;
                        return;
                    }
                }
                if (this.f6605f) {
                    String styleTexturePath = this.f6602c.getStyleTexturePath();
                    if (this.f6602c.getStyleTextureData() == null && !TextUtils.isEmpty(styleTexturePath)) {
                        this.f6602c.setStyleTextureData(FileUtil.readFileContents(styleTexturePath));
                    }
                    if (this.f6602c.getStyleTextureData() != null) {
                        this.A = true;
                        if (mapConfig.isProFunctionAuthEnable()) {
                            this.f6618s = true;
                            this.f6601b.getGLMapEngine().setCustomStyleTexture(this.f6608i, this.f6602c.getStyleTextureData());
                            mapConfig.setUseProFunction(true);
                        } else {
                            h();
                        }
                    } else {
                        h();
                        this.A = false;
                    }
                    this.f6605f = false;
                }
                if (this.f6604e) {
                    String styleDataPath = this.f6602c.getStyleDataPath();
                    if (this.f6602c.getStyleData() == null && !TextUtils.isEmpty(styleDataPath)) {
                        this.f6602c.setStyleData(FileUtil.readFileContents(styleDataPath));
                    }
                    if (this.f6602c.getStyleData() == null && this.f6623x == null) {
                        if (this.f6619t) {
                            this.f6603d = true;
                            this.f6602c.setEnable(false);
                        }
                        this.f6604e = false;
                    }
                    if (this.f6614o == null) {
                        this.f6614o = c(FileUtil.readFileContentsFromAssets(this.f6609j, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_STYLE_DATA_0_FOR_TEXTURE));
                    }
                    byte[] bArr = this.f6623x;
                    if (bArr == null) {
                        bArr = this.f6602c.getStyleData();
                    }
                    if (!b(bArr)) {
                        dd.a();
                    } else {
                        this.f6601b.getGLMapEngine().setCustomStyleData(this.f6608i, bArr, this.f6614o);
                        this.f6619t = true;
                        IAMapDelegate iAMapDelegate2 = this.f6601b;
                        if (iAMapDelegate2 != null) {
                            iAMapDelegate2.resetRenderTime();
                        }
                    }
                    this.f6604e = false;
                }
                if (this.f6606g) {
                    String styleExtraPath = this.f6602c.getStyleExtraPath();
                    if (this.f6602c.getStyleExtraData() == null && !TextUtils.isEmpty(styleExtraPath)) {
                        this.f6602c.setStyleExtraData(FileUtil.readFileContents(styleExtraPath));
                    }
                    if (this.f6602c.getStyleExtraData() != null || this.f6624y != null) {
                        byte[] bArr2 = this.f6624y;
                        if (bArr2 == null) {
                            bArr2 = this.f6602c.getStyleExtraData();
                        }
                        if (bArr2 != null) {
                            a(bArr2);
                            this.f6620u = true;
                        }
                    }
                    this.f6606g = false;
                }
                if (this.f6607h) {
                    a(mapConfig);
                    this.f6607h = false;
                }
            }
        } catch (Throwable th) {
            gy.b(th, "AMapCustomStyleManager", "updateStyle");
            dx.a(th);
        }
    }

    public final boolean d() {
        return this.f6602c != null;
    }

    public final void e() {
        synchronized (this) {
            CustomMapStyleOptions customMapStyleOptions = this.f6602c;
            if (customMapStyleOptions != null) {
                customMapStyleOptions.setEnable(false);
                i();
                this.f6603d = true;
            }
        }
    }

    private static boolean b(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
        } catch (Throwable th) {
            gy.b(th, "AMapCustomStyleManager", "checkData");
            dx.a(th);
        }
        if (bArr.length < 8) {
            return false;
        }
        return ((bArr[4] & 255) | ((((bArr[7] << 24) & (-16777216)) | ((bArr[6] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK)) | ((bArr[5] << 8) & 65280))) == 2001;
    }

    public final void b() {
        if (this.f6602c == null) {
            return;
        }
        synchronized (this) {
            IAMapDelegate iAMapDelegate = this.f6601b;
            if (iAMapDelegate != null && iAMapDelegate.getMapConfig() != null && !this.f6601b.getMapConfig().isProFunctionAuthEnable()) {
                this.f6602c.setStyleId(null);
                this.f6623x = null;
                this.f6624y = null;
                this.f6625z = null;
            }
            this.f6605f = true;
            this.f6604e = true;
            if (this.f6620u) {
                this.f6606g = true;
            }
            this.f6603d = true;
            this.f6607h = true;
        }
    }

    private static String c(String str) {
        int indexOf;
        return (str == null || (indexOf = str.indexOf("99999_")) == -1) ? str : str.substring(0, indexOf).replace("99999_", "");
    }

    public final void c() {
        if (this.f6602c == null) {
            this.f6602c = new CustomMapStyleOptions();
        }
    }

    @Override // com.amap.api.col.3l.cs.a
    public final void b(byte[] bArr, int i10) {
        MapConfig mapConfig;
        a aVar;
        if (this.f6602c != null) {
            synchronized (this) {
                IAMapDelegate iAMapDelegate = this.f6601b;
                if (iAMapDelegate != null && (mapConfig = iAMapDelegate.getMapConfig()) != null && mapConfig.isProFunctionAuthEnable()) {
                    mapConfig.setUseProFunction(true);
                    if (i10 == 1) {
                        this.f6623x = bArr;
                        this.f6604e = true;
                    } else if (i10 == 0) {
                        this.f6624y = bArr;
                        this.f6606g = true;
                    } else if (i10 == 2) {
                        String str = this.f6602c.getStyleId() + "_sdk_780.data";
                        String str2 = this.f6602c.getStyleId() + "_abroad_sdk.json";
                        Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr, new String[]{str, str2});
                        if (uncompressToByteWithKeys != null) {
                            byte[] bArr2 = uncompressToByteWithKeys.get(str);
                            if (bArr2 != null) {
                                this.f6623x = bArr2;
                                this.f6604e = true;
                            }
                            if (uncompressToByteWithKeys.get(str2) != null && (aVar = this.F) != null) {
                                aVar.a();
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(byte[] bArr) {
        cw a10;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (bArr == null || (a10 = cz.a(bArr)) == null || a10.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(a10.a());
            JSONObject optJSONObject3 = jSONObject.optJSONObject("mapStyle");
            String str = null;
            boolean z10 = true;
            if (optJSONObject3 != null && (optJSONObject2 = optJSONObject3.optJSONObject("bg")) != null) {
                z10 = optJSONObject2.optBoolean(Attributes.Visibility.VISIBLE, true);
                str = optJSONObject2.optString("lineColor", null);
            }
            a(str, z10);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("layer");
            if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("traffic")) != null) {
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("multiFillColors");
                if (optJSONObject.optBoolean(Attributes.Visibility.VISIBLE) && optJSONObject5 != null) {
                    int a11 = cz.a(optJSONObject5.optString(Attributes.Style.SMOOTH));
                    int a12 = cz.a(optJSONObject5.optString("slow"));
                    int a13 = cz.a(optJSONObject5.optString("congested"));
                    int a14 = cz.a(optJSONObject5.optString("seriousCongested"));
                    this.E.setSmoothColor(a11);
                    this.E.setSlowColor(a12);
                    this.E.setCongestedColor(a13);
                    this.E.setSeriousCongestedColor(a14);
                    if (this.f6615p == null) {
                        this.f6615p = FileUtil.readFileContentsFromAssets(this.f6609j, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_TRL_NAME);
                    }
                    this.f6601b.setTrafficStyleWithTexture(this.f6615p, this.E);
                }
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("third_layer");
            if (optJSONObject6 != null) {
                a(optJSONObject6);
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("model_layer");
            if (optJSONObject7 != null) {
                b(optJSONObject7.optString("id"));
            }
        } catch (Throwable th) {
            gy.b(th, "AMapCustomStyleManager", "setExtraStyle");
            dx.a(th);
        }
    }

    private void a(JSONObject jSONObject) {
        this.f6601b.getGLMapEngine().setCustomThirdLayerStyle(this.f6608i, jSONObject.toString());
    }

    private void a(String str, boolean z10) {
        boolean z11;
        int a10 = !TextUtils.isEmpty(str) ? cz.a(str) : Integer.MIN_VALUE;
        IAMapDelegate iAMapDelegate = this.f6601b;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        if (this.f6612m == null) {
            this.f6612m = FileUtil.readFileContentsFromAssets(this.f6609j, AMapEngineUtils.MAP_MAP_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
        }
        byte[] bArr = this.f6612m;
        if (bArr != null) {
            if (!z10) {
                a10 = 0;
            } else if (a10 == Integer.MIN_VALUE) {
                z11 = true;
                this.f6601b.getGLMapEngine().setBackgroundTexture(this.f6608i, dx.a((byte[]) bArr.clone(), 0, a10, z11));
            }
            z11 = false;
            this.f6601b.getGLMapEngine().setBackgroundTexture(this.f6608i, dx.a((byte[]) bArr.clone(), 0, a10, z11));
        }
    }

    public final void a(CustomMapStyleOptions customMapStyleOptions) {
        IAMapDelegate iAMapDelegate;
        if (this.f6602c == null || customMapStyleOptions == null) {
            return;
        }
        synchronized (this) {
            if (!this.f6616q) {
                this.f6616q = true;
                if (this.f6602c.isEnable()) {
                    this.f6603d = true;
                }
            }
            if (this.f6602c.isEnable() != customMapStyleOptions.isEnable()) {
                this.f6602c.setEnable(customMapStyleOptions.isEnable());
                this.f6603d = true;
                du.b(this.f6609j, customMapStyleOptions.isEnable());
            }
            if (this.f6602c.isEnable()) {
                if (!TextUtils.equals(this.f6602c.getStyleId(), customMapStyleOptions.getStyleId())) {
                    this.f6602c.setStyleId(customMapStyleOptions.getStyleId());
                    String styleId = this.f6602c.getStyleId();
                    if (!TextUtils.isEmpty(styleId) && (iAMapDelegate = this.f6601b) != null && iAMapDelegate.getMapConfig() != null && this.f6601b.getMapConfig().isProFunctionAuthEnable()) {
                        if (this.f6621v == null) {
                            if (this.B) {
                                this.f6621v = new cs(this.f6609j, this, 2, "abroad_sdk_json_sdk_780_zip");
                            } else {
                                this.f6621v = new cs(this.f6609j, this, 1, "sdk_780");
                            }
                        }
                        this.f6621v.a(styleId);
                        this.f6621v.b();
                        if (this.f6622w == null) {
                            this.f6622w = new cs(this.f6609j, this, 0, null);
                        }
                        this.f6622w.a(styleId);
                        this.f6622w.b();
                    }
                }
                if (!TextUtils.equals(this.f6602c.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                    this.f6602c.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                    this.f6604e = true;
                }
                if (this.f6602c.getStyleData() != customMapStyleOptions.getStyleData()) {
                    this.f6602c.setStyleData(customMapStyleOptions.getStyleData());
                    this.f6604e = true;
                }
                if (!TextUtils.equals(this.f6602c.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                    this.f6602c.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                    this.f6605f = true;
                }
                if (this.f6602c.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                    this.f6602c.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                    this.f6605f = true;
                }
                if (!TextUtils.equals(this.f6602c.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                    this.f6602c.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                    this.f6606g = true;
                }
                if (this.f6602c.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                    this.f6602c.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                    this.f6606g = true;
                }
                if (!TextUtils.equals(this.f6602c.getStyleResDataPath(), customMapStyleOptions.getStyleResDataPath())) {
                    this.f6602c.setStyleResDataPath(customMapStyleOptions.getStyleResDataPath());
                    this.f6607h = true;
                }
                if (this.f6602c.getStyleResData() != customMapStyleOptions.getStyleResData()) {
                    this.f6602c.setStyleResData(customMapStyleOptions.getStyleResData());
                    this.f6607h = true;
                }
                du.a(this.f6609j, true);
            } else {
                i();
                du.a(this.f6609j, false);
            }
        }
    }

    @Override // com.amap.api.col.3l.cs.a
    public final void a(byte[] bArr, int i10) {
        b(bArr, i10);
    }

    private void a(MapConfig mapConfig) {
        byte[] bArr;
        if (!mapConfig.isProFunctionAuthEnable()) {
            this.C.clear();
            return;
        }
        String styleResDataPath = this.f6602c.getStyleResDataPath();
        if (this.f6602c.getStyleResData() == null && !TextUtils.isEmpty(styleResDataPath)) {
            this.f6602c.setStyleResData(FileUtil.readFileContents(styleResDataPath));
        }
        if (this.f6602c.getStyleResData() == null && this.f6625z == null) {
            return;
        }
        byte[] bArr2 = this.f6625z;
        if (bArr2 == null) {
            bArr2 = this.f6602c.getStyleResData();
        }
        if (bArr2 != null) {
            mapConfig.setUseProFunction(true);
            this.C.clear();
            Map<String, byte[]> uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr2, null);
            if (uncompressToByteWithKeys != null) {
                for (String str : uncompressToByteWithKeys.h()) {
                    if (str != null && !str.contains("__MACOSX") && (bArr = uncompressToByteWithKeys.get(str)) != null) {
                        if (FileUtil.isGzip(bArr)) {
                            this.C.put(str, bArr);
                        } else {
                            this.C.put(str, FileUtil.compress(bArr));
                        }
                    }
                }
            }
        }
    }

    public final byte[] a(String str) {
        MapConfig mapConfig;
        if (str == null || (mapConfig = this.f6601b.getMapConfig()) == null) {
            return null;
        }
        if (!mapConfig.isProFunctionAuthEnable()) {
            return FileUtil.readFileContentsFromAssetsByPreName(this.f6609j, AMapEngineUtils.MAP_MAP_ASSETS_NAME, c(str));
        }
        for (String str2 : this.C.h()) {
            if (str.contains(str2)) {
                return this.C.get(str2);
            }
        }
        return null;
    }

    public final void a(a aVar) {
        this.F = aVar;
    }
}
