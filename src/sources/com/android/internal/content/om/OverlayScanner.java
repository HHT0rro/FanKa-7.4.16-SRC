package com.android.internal.content.om;

import android.content.pm.parsing.ApkLite;
import android.content.pm.parsing.ApkLiteParseUtils;
import android.content.pm.parsing.FrameworkParsingPackageUtils;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import com.android.internal.content.om.OverlayConfigParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OverlayScanner {
    private final ArrayMap<String, ParsedOverlayInfo> mParsedOverlayInfos = new ArrayMap<>();
    private final List<Pair<String, File>> mExcludedOverlayPackages = new ArrayList();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ParsedOverlayInfo {
        public final boolean isStatic;
        public final String packageName;
        public final File path;
        public final File preInstalledApexPath;
        public final int priority;
        public final String targetPackageName;
        public final int targetSdkVersion;

        public ParsedOverlayInfo(String packageName, String targetPackageName, int targetSdkVersion, boolean isStatic, int priority, File path, File preInstalledApexPath) {
            this.packageName = packageName;
            this.targetPackageName = targetPackageName;
            this.targetSdkVersion = targetSdkVersion;
            this.isStatic = isStatic;
            this.priority = priority;
            this.path = path;
            this.preInstalledApexPath = preInstalledApexPath;
        }

        public String toString() {
            return getClass().getSimpleName() + String.format("{packageName=%s, targetPackageName=%s, targetSdkVersion=%s, isStatic=%s, priority=%s, path=%s, preInstalledApexPath=%s}", this.packageName, this.targetPackageName, Integer.valueOf(this.targetSdkVersion), Boolean.valueOf(this.isStatic), Integer.valueOf(this.priority), this.path, this.preInstalledApexPath);
        }

        public File getOriginalPartitionPath() {
            File file = this.preInstalledApexPath;
            return file != null ? file : this.path;
        }
    }

    public final ParsedOverlayInfo getParsedInfo(String packageName) {
        return this.mParsedOverlayInfos.get(packageName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Collection<ParsedOverlayInfo> getAllParsedInfos() {
        return this.mParsedOverlayInfos.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isExcludedOverlayPackage(String packageName, OverlayConfigParser.OverlayPartition overlayPartition) {
        for (int i10 = 0; i10 < this.mExcludedOverlayPackages.size(); i10++) {
            Pair<String, File> pair = this.mExcludedOverlayPackages.get(i10);
            if (((String) pair.first).equals(packageName) && overlayPartition.containsOverlay((File) pair.second)) {
                return true;
            }
        }
        return false;
    }

    public void scanDir(File partitionOverlayDir) {
        ParsedOverlayInfo info;
        if (!partitionOverlayDir.exists() || !partitionOverlayDir.isDirectory()) {
            return;
        }
        if (!partitionOverlayDir.canRead()) {
            Log.w("OverlayConfig", "Directory " + ((Object) partitionOverlayDir) + " cannot be read");
            return;
        }
        File[] files = partitionOverlayDir.listFiles();
        if (files == null) {
            return;
        }
        for (File f10 : files) {
            if (f10.isDirectory()) {
                scanDir(f10);
            }
            if (f10.isFile() && f10.getPath().endsWith(".apk") && (info = parseOverlayManifest(f10, this.mExcludedOverlayPackages)) != null) {
                this.mParsedOverlayInfos.put(info.packageName, info);
            }
        }
    }

    public ParsedOverlayInfo parseOverlayManifest(File overlayApk, List<Pair<String, File>> outExcludedOverlayPackages) {
        ParseTypeImpl input = ParseTypeImpl.forParsingWithoutPlatformCompat();
        ParseResult<ApkLite> ret = ApkLiteParseUtils.parseApkLite(input.reset(), overlayApk, 128);
        if (ret.isError()) {
            Log.w("OverlayConfig", "Got exception loading overlay.", ret.getException());
            return null;
        }
        ApkLite apkLite = (ApkLite) ret.getResult();
        if (apkLite.getTargetPackageName() == null) {
            return null;
        }
        String propName = apkLite.getRequiredSystemPropertyName();
        String propValue = apkLite.getRequiredSystemPropertyValue();
        if ((!TextUtils.isEmpty(propName) || !TextUtils.isEmpty(propValue)) && !FrameworkParsingPackageUtils.checkRequiredSystemProperties(propName, propValue)) {
            outExcludedOverlayPackages.add(Pair.create(apkLite.getPackageName(), overlayApk));
            return null;
        }
        return new ParsedOverlayInfo(apkLite.getPackageName(), apkLite.getTargetPackageName(), apkLite.getTargetSdkVersion(), apkLite.isOverlayIsStatic(), apkLite.getOverlayPriority(), new File(apkLite.getPath()), null);
    }
}
