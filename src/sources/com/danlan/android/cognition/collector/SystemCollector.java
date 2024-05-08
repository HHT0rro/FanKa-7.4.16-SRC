package com.danlan.android.cognition.collector;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.danlan.android.cognition.CacheDataManager;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.CMDUtil;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class SystemCollector extends SubCollector {
    private static final String FLASH_LOCK_UNLOCKED = StringFog.decrypt("EQ==");
    private Context mcontext;

    public SystemCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    private String bytesToHex(byte[] bArr) {
        char[] charArray = StringFog.decrypt("ERIWEBUWEhYZGmVhYmdhZw==").toCharArray();
        char[] cArr = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = i10 * 2;
            cArr[i12] = charArray[i11 >>> 4];
            cArr[i12 + 1] = charArray[i11 & 15];
        }
        return new String(cArr);
    }

    public static String checkAdbRoot() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("UkZWVUhAQQ9AR0YNU0xLVQ=="), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static String checkRoDebug() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKR0RBUUZGQkZPRA=="), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static String checkRoKernelQemu() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKSERRSkRNDVVGTFY="), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static String checkRoSecure() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKUERAUVNE"), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    private String deviceUniqueId(Constructor constructor, Method method, Object obj) {
        try {
            return Base64.encodeToString((byte[]) method.invoke(constructor.newInstance(obj), StringFog.decrypt("RUZSSkJGcU9IUlFGaEc=")), 2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAdbSecure() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQkVBClJEQFFRRA=="), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    public static String getAdbdState() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("SE1NVw9QUkIPQkBBRQ=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    private String getBootId() {
        String str;
        try {
            str = CacheDataManager.getCacheId(this.mContext, StringFog.decrypt("Q0xLV2hH"));
            try {
                if (TextUtils.isEmpty(str) && NativeLib.checkLoadSo()) {
                    str = NativeLib.du(StringFog.decrypt("Q0xLV2hH"));
                    CacheDataManager.saveCacheId(this.mContext, StringFog.decrypt("Q0xLV2hH"), str);
                }
                if (str == null) {
                    return "";
                }
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                if (str == null) {
                    return "";
                }
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
        return str;
    }

    public static String getDescription() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPR0FQQlFNUVVKS00="), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    private String getDeviceUniqueIdFromDrm() {
        if (Build.VERSION.SDK_INT < 23) {
            return "";
        }
        String cacheId = CacheDataManager.getCacheId(this.mContext, StringFog.decrypt("TEZASkBnVkxoRw=="));
        if (!TextUtils.isEmpty(cacheId)) {
            return cacheId;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            Class<?> cls = Class.forName(StringFog.decrypt("QE1AUU5KQA9MRkBKQA1pREVKRWdTTg=="));
            Class<Long> cls2 = Long.TYPE;
            Constructor constructor = UUID.class.getConstructor(cls2, cls2);
            Constructor<?> constructor2 = cls.getConstructor(UUID.class);
            Method method = cls.getMethod(StringFog.decrypt("RkZQc1NMVERTV11hWFdBYFNRRVo="), String.class);
            sb2.append(deviceUniqueId(constructor2, method, constructor.newInstance(-1301668207276963122L, -6645017420763422227L)));
            sb2.append(StringFog.decrypt("fg=="));
            sb2.append(deviceUniqueId(constructor2, method, constructor.newInstance(1186680826959645954L, -5988876978535335093L)));
            sb2.append(StringFog.decrypt("fg=="));
            sb2.append(deviceUniqueId(constructor2, method, constructor.newInstance(-2129748144642739255L, 8654423357094679310L)));
            sb2.append(StringFog.decrypt("fg=="));
            sb2.append(deviceUniqueId(constructor2, method, constructor.newInstance(-7348484286925749626L, -6083546864340672619L)));
            if (TextUtils.isEmpty(sb2.toString())) {
                return cacheId;
            }
            cacheId = sb2.toString();
            CacheDataManager.saveCacheId(this.mContext, StringFog.decrypt("TEZASkBnVkxoRw=="), cacheId);
            return cacheId;
        } catch (Throwable th) {
            th.printStackTrace();
            return cacheId;
        }
    }

    private String getDeviceUniqueIdFromDrm2() {
        return "";
    }

    private String getOdmBuildFingerprint() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKTEVOCkNUSkhHD0VNT0ZGVlNTSkpV"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    private String getRoFirstBoot() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKUVRNUEhMRgpFSFFXVUNMS1c="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    private String getRoSerialNo() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKUERRTUBNTUs="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    private String getSerialNumber() {
        try {
            return NativeLib.checkLoadSo() ? NativeLib.du(StringFog.decrypt("UkZWSkBPalRMQUFR")) : StringFog.decrypt("VE1PTU5USg==");
        } catch (Throwable th) {
            th.printStackTrace();
            return StringFog.decrypt("VE1PTU5USg==");
        }
    }

    private String getSystemBuildFingerprint() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKUFhQUERMDUZWSE9AD0dKSkREUVRTSE1Q"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    private String getSystemExtBuildFingerprint() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKUFhQUERMfEFbVQ1GVEhPQA1HSkpGRFFUUUhNUA=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    private String getUUIDAndBuildDate() {
        String str;
        try {
            str = CacheDataManager.getCacheId(this.mContext, StringFog.decrypt("VFZNRw=="));
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str) && NativeLib.checkLoadSo()) {
                str = NativeLib.du(StringFog.decrypt("VFZNRw==")) + StringFog.decrypt("DA==") + NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPR0VXRA1RVUI="), StringFog.decrypt("VE1PTU5USg=="));
                CacheDataManager.saveCacheId(this.mContext, StringFog.decrypt("VFZNRw=="), str);
            }
            if (str == null) {
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
            if (str == null) {
                return "";
            }
            return str;
        }
        return str;
    }

    public static String getVbmetaDigest() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQU5MUA9XQUlGVUIKRUhEQVBV"), StringFog.decrypt("DBI=")) : StringFog.decrypt("DBI=");
    }

    private String getVendorBuildFingerprint() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKVURNQE5TDUZWSE9AD0dKSkREUVRTSE1Q"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public static boolean isOpenDevelopmentSetting(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), StringFog.decrypt("RUZSRk1MVExETVB8UkZQVUhNQ1B+RkpAQ09BRw=="), 0) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isUSBDebugSetting(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), StringFog.decrypt("QEdGfERNRUNNRkA="), 0) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            safeJSONObject.put(StringFog.decrypt("TlByRlNQTU5P"), getOSVersion());
            safeJSONObject.put(StringFog.decrypt("Q1ZNT0V3TUxE"), getBuildTime());
            safeJSONObject.put(StringFog.decrypt("Q1ZNT0V2V0RT"), getBuildUser());
            safeJSONObject.put(StringFog.decrypt("Q1ZNT0V3XVFE"), getBuildType());
            safeJSONObject.put(StringFog.decrypt("UkdPdURRV0hOTQ=="), getSdkVersion());
            safeJSONObject.put(StringFog.decrypt("TUJKRFRCQ0Q="), getLanguage());
            safeJSONObject.put(StringFog.decrypt("VFBBUWBEQU9V"), getUserAgent());
            safeJSONObject.put(StringFog.decrypt("VFNQSkxG"), getSystemStartupTime());
            safeJSONObject.put(StringFog.decrypt("U1ZKV0hOQQ=="), getSystemRunTime());
            safeJSONObject.put(StringFog.decrypt("VUpJRltMSkQ="), getTimezone());
            safeJSONObject.put(StringFog.decrypt("TlFNRk9XRVVITEo="), getOrientation());
            safeJSONObject.put(StringFog.decrypt("QE1AUU5KQH5IRw=="), getAndroidId());
            safeJSONObject.put(StringFog.decrypt("U0pKRFVMSkQ="), getRingtoneConfig());
            safeJSONObject.put(StringFog.decrypt("SE1HUUROQU9VQkh8V0ZWUkhMSg=="), getIncrementalVersion());
            safeJSONObject.put(StringFog.decrypt("R0pWUFV8RVFIfEhGV0ZI"), getFirstApiLevel());
            safeJSONObject.put(StringFog.decrypt("UkZHVlNKUFh+U0VXQkt7V0RRV0pOTQ=="), getSecurityPatchVersion());
            safeJSONObject.put(StringFog.decrypt("U0pIfERAR01IUFA="), getRilEcclistInfo());
            safeJSONObject.put(StringFog.decrypt("QktFUUBAUERTSldXSEBX"), getCharacteristics());
            safeJSONObject.put(StringFog.decrypt("Q0xLV0hORUZEfEZWSE9AfkVCUEY="), getBootImageBuildDate());
            safeJSONObject.put(StringFog.decrypt("SFBrU0RNYERXcEFXVUpKRg=="), isOpenDevelopmentSetting(this.mcontext));
            safeJSONObject.put(StringFog.decrypt("SFBxUENnQUNURHdGVVdNT0Y="), isUSBDebugSetting(this.mcontext));
            safeJSONObject.put(StringFog.decrypt("SFBgRldKR0R0TUhMQkhBRQ=="), isDeviceOemUnlocked());
            safeJSONObject.put(StringFog.decrypt("SFBgRldKR0R0TUhMQkhBRWRNRUFNRg=="), isDeviceOemUnlockEnabled());
            safeJSONObject.put(StringFog.decrypt("SFBlQEJGV1JIQU1PSFddckRXUEpPRA=="), isAccessibilityEnabled());
            safeJSONObject.put(StringFog.decrypt("RE1FQU1GQGBCQEFQUkpGSE1KUFo="), getEnabledAccessibilityService());
            safeJSONObject.put(StringFog.decrypt("QEdGc05RUA=="), getAdbPort());
            safeJSONObject.put(StringFog.decrypt("QEdGR3JXRVVE"), getAdbdState());
            safeJSONObject.put(StringFog.decrypt("QEdGcERAUVNE"), getAdbSecure());
            safeJSONObject.put(StringFog.decrypt("SUJXZkxWSEBVTFZlSE9BUg=="), isHaveEmulatorFiles());
            safeJSONObject.put(StringFog.decrypt("U0x7R0RBUUY="), checkRoDebug());
            safeJSONObject.put(StringFog.decrypt("U0x7SERRSkRNfFVGTFY="), checkRoKernelQemu());
            safeJSONObject.put(StringFog.decrypt("U0x7QkVBe1NOTFA="), checkAdbRoot());
            safeJSONObject.put(StringFog.decrypt("U0x7UERAUVNE"), checkRoSecure());
            safeJSONObject.put(StringFog.decrypt("U0x7R0RQR1NIU1BKTk0="), getDescription());
            safeJSONObject.put(StringFog.decrypt("V0F7R0hEQVJV"), getVbmetaDigest());
            safeJSONObject.put(StringFog.decrypt("RVFJfFRNTVBURntKRQ=="), getDeviceUniqueIdFromDrm());
            safeJSONObject.put(StringFog.decrypt("RVFJfFRNTVBURntKRRE="), getDeviceUniqueIdFromDrm2());
            safeJSONObject.put(StringFog.decrypt("Q0xLV35KQA=="), getBootId());
            safeJSONObject.put(StringFog.decrypt("VFZNR35BUUhNR3tHQFdB"), getUUIDAndBuildDate());
            safeJSONObject.put(StringFog.decrypt("UkZWSkBPe09UTkZGUw=="), getSerialNumber());
            safeJSONObject.put(StringFog.decrypt("UlpXV0ROe0RZV3tBVEpIRX5FTU1GRlZRU0pKVw=="), getSystemExtBuildFingerprint());
            safeJSONObject.put(StringFog.decrypt("UlpXV0ROe0NUSkhHfkVNT0ZGVlNTSkpV"), getSystemBuildFingerprint());
            safeJSONObject.put(StringFog.decrypt("TkdJfENWTU1FfEJKT0RBU1FRTU1V"), getOdmBuildFingerprint());
            safeJSONObject.put(StringFog.decrypt("V0ZKR05Re0NUSkhHfkVNT0ZGVlNTSkpV"), getVendorBuildFingerprint());
            safeJSONObject.put(StringFog.decrypt("U1ZKV0hOQX5HSlZQVXxGTk5X"), getRoFirstBoot());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("UlpXV0RO"), safeJSONObject);
        collectDone();
    }

    public String getAdbPort() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("QE1AUU5KQA9JTFdXD0JAQw9TS1FV"), "") : "";
    }

    public String getAndroidId() {
        try {
            String string = Settings.Secure.getString(this.mcontext.getContentResolver(), StringFog.decrypt("QE1AUU5KQH5IRw=="));
            if (string == null) {
                return "";
            }
            if (string.equals(StringFog.decrypt("GBQTF0UWEkUXGxZGFBcdQg=="))) {
                return "";
            }
            if (string.length() < 15) {
                return "";
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public String getBootImageBuildDate() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQU5MUEhMQkNGD0FRSE1HCkdAV0E="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getBuildTime() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPR0VXRA1RVUI="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getBuildType() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPV11TRA=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getBuildUser() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPVldGUw=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public String getCharacteristics() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPQExCU0JHVURRTVBVSkdS"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public SafeJSONObject getEnabledAccessibilityService() {
        HashSet hashSet;
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            List<AccessibilityServiceInfo> enabledAccessibilityServiceList = ((AccessibilityManager) this.mcontext.getSystemService(StringFog.decrypt("QEBHRlJQTUNIT01XWA=="))).getEnabledAccessibilityServiceList(-1);
            if (enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.size() > 0) {
                for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                    String id2 = accessibilityServiceInfo.getId();
                    if (!TextUtils.isEmpty(id2)) {
                        boolean z10 = false;
                        if (id2.contains(StringFog.decrypt("Dg=="))) {
                            id2 = id2.split(StringFog.decrypt("Dg=="))[0];
                        }
                        if (safeJSONObject.has(id2)) {
                            hashSet = (HashSet) safeJSONObject.get(id2);
                            z10 = true;
                        } else {
                            hashSet = new HashSet();
                        }
                        try {
                            int capabilities = accessibilityServiceInfo.getCapabilities();
                            if ((capabilities & 1) != 0) {
                                hashSet.add(1);
                            }
                            if ((capabilities & 128) != 0) {
                                hashSet.add(128);
                            }
                            if ((capabilities & 32) != 0) {
                                hashSet.add(32);
                            }
                        } catch (Exception unused) {
                        }
                        if (!z10) {
                            safeJSONObject.put(id2, hashSet);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return safeJSONObject;
    }

    public String getFirstApiLevel() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpFSFFXVX5CVEp+T0FXRE8="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    @Nullable
    public final String getGSFId() {
        Cursor query;
        try {
            query = this.mcontext.getContentResolver().query(Uri.parse(StringFog.decrypt("QkxKV0RNUBsODEdMTA1DTk5ESEYPQkpFU0xNRw9EV0cPRFdGU1VNQkRQ")), null, null, new String[]{StringFog.decrypt("QE1AUU5KQH5IRw==")}, null);
        } catch (Exception unused) {
        }
        if (query == null) {
            return null;
        }
        if (query.moveToFirst() && query.getColumnCount() >= 2) {
            String hexString = Long.toHexString(Long.parseLong(query.getString(1)));
            query.close();
            return hexString.toUpperCase().trim();
        }
        query.close();
        return null;
    }

    public String getIncrementalVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPVUFRUkpLTw9KSkBTRklET1dFTw=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public final String getOSVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPVUFRUkpLTw9RQU9EQldE"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    @Nullable
    public final String getOrientation() {
        String str;
        int i10 = this.mcontext.getResources().getConfiguration().orientation;
        if (i10 == 2) {
            str = "TUJKR1JARVFE";
        } else {
            if (i10 != 1) {
                return null;
            }
            str = "UUxWV1NCTVU=";
        }
        return StringFog.decrypt(str);
    }

    public String getRilEcclistInfo() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKUUhPCkRCQEhKUlc="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public String getRingtoneConfig() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQE5NQkhGDVZKT0RQTk9G"), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    public String getSecurityPatchVersion() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("U0wKQVRKSEUPVUFRUkpLTw9QQUBUUU1VWHxUQlVATA=="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public SafeJSONObject getServiceListInfo() {
        String[] strArr = {StringFog.decrypt("VUtBUUxCSFJEUVJKQkY="), StringFog.decrypt("R0pKRERRVFNITVA="), StringFog.decrypt("T0VH"), StringFog.decrypt("TEpASg=="), StringFog.decrypt("UVFNTVU=")};
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        ArrayList arrayList = new ArrayList();
        List<String> executeCMD = CMDUtil.executeCMD(new String[]{StringFog.decrypt("UkZWVUhAQQFNSldX")}, 1);
        int size = executeCMD.size();
        if (size != 0) {
            safeJSONObject.put(StringFog.decrypt("T1ZJ"), size - 1);
            for (String str : executeCMD) {
                if (!TextUtils.isEmpty(str)) {
                    int i10 = 0;
                    while (true) {
                        if (i10 < 5) {
                            String str2 = strArr[i10];
                            if (str.contains("\t" + str2 + StringFog.decrypt("Gw=="))) {
                                arrayList.add(str2);
                                break;
                            }
                            i10++;
                        }
                    }
                }
            }
        } else {
            safeJSONObject.put(StringFog.decrypt("T1ZJ"), 0);
        }
        safeJSONObject.put(StringFog.decrypt("UlNBQEhCSH5SRlZVSEBB"), arrayList);
        return safeJSONObject;
    }

    public final long getSystemRunTime() {
        try {
            return SystemClock.elapsedRealtime() / 1000;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final long getSystemStartupTime() {
        try {
            return (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final String getTimezone() {
        return NativeLib.checkLoadSo() ? NativeLib.pg(StringFog.decrypt("UUZWUEhQUA9SWlcNVUpJRFtMSkY="), StringFog.decrypt("VE1PTU5USg==")) : StringFog.decrypt("VE1PTU5USg==");
    }

    public final String getUserAgent() {
        String property = System.getProperty(StringFog.decrypt("SVdQUw9CQ0RPVw=="));
        try {
            try {
                return WebSettings.getDefaultUserAgent(this.mcontext) + StringFog.decrypt("fnw=") + property;
            } catch (Exception unused) {
                return new WebView(this.mcontext).getSettings().getUserAgentString() + StringFog.decrypt("fnw=") + property;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final boolean isAccessibilityEnabled() {
        try {
            return ((AccessibilityManager) this.mcontext.getSystemService(StringFog.decrypt("QEBHRlJQTUNIT01XWA=="))).isEnabled();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean isDeviceOemUnlockEnabled() {
        if (NativeLib.checkLoadSo()) {
            try {
                String pg = NativeLib.pg(StringFog.decrypt("UlpXDU5GSX5UTUhMQkh7QE1PS1RERw=="), StringFog.decrypt("VE1PTU5USg=="));
                char c4 = 65535;
                if (pg.hashCode() == 49) {
                    if (pg.equals(StringFog.decrypt("EA=="))) {
                        c4 = 0;
                    }
                }
                return c4 == 0;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final boolean isDeviceOemUnlocked() {
        if (NativeLib.checkLoadSo()) {
            try {
                String pg = NativeLib.pg(StringFog.decrypt("U0wKQU5MUA9HT0VQSQ1ITkJIQUc="), StringFog.decrypt("VE1PTU5USg=="));
                char c4 = 65535;
                if (pg.hashCode() == 48) {
                    if (pg.equals(FLASH_LOCK_UNLOCKED)) {
                        c4 = 0;
                    }
                }
                return c4 == 0;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean isHaveEmulatorFiles() {
        String[] strArr = {StringFog.decrypt("DlBdUA5HQVdIQEFQDm9qeXJ6d3dsGRQR"), StringFog.decrypt("DlBdUA5HQVdIQEFQDlNIQFVFS1FMDFRNQFdCTFNOCUdTQklGQ1ZCR0RRChM=")};
        for (int i10 = 0; i10 < 2; i10++) {
            String str = strArr[i10];
            if (NativeLib.checkLoadSo() && NativeLib.cf(str) == 1) {
                return true;
            }
        }
        return false;
    }
}
