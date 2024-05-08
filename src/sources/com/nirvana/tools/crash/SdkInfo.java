package com.nirvana.tools.crash;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SdkInfo {
    private String appId;
    private List<String> ignoreInterfaces;
    private List<String> nativeLibraries;
    private List<String> packageNames;
    private List<String> sdkInterfaces;
    private String sdkName;
    private String sdkVersion;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class SdkInfoBuilder {
        private String appId;
        private List<String> ignoreInterfaces;
        private List<String> nativeLibraries;
        private List<String> packageNames;
        private List<String> sdkInterfaces;
        private String sdkName;
        private String sdkVersion;

        private SdkInfoBuilder() {
        }

        public static SdkInfoBuilder aSdkInfo() {
            return new SdkInfoBuilder();
        }

        public final SdkInfoBuilder appId(String str) {
            this.appId = str;
            return this;
        }

        public final SdkInfo build() {
            SdkInfo sdkInfo = new SdkInfo();
            sdkInfo.setSdkName(this.sdkName);
            sdkInfo.setAppId(this.appId);
            sdkInfo.setPackageNames(this.packageNames);
            sdkInfo.setSdkInterfaces(this.sdkInterfaces);
            sdkInfo.setNativeLibraries(this.nativeLibraries);
            sdkInfo.setSdkVersion(this.sdkVersion);
            sdkInfo.setIgnoreInterfaces(this.ignoreInterfaces);
            return sdkInfo;
        }

        public final SdkInfoBuilder ignoreInterfaces(List<String> list) {
            this.ignoreInterfaces = list;
            return this;
        }

        public final SdkInfoBuilder nativeLibraries(List<String> list) {
            this.nativeLibraries = list;
            return this;
        }

        public final SdkInfoBuilder packageNames(List<String> list) {
            this.packageNames = list;
            return this;
        }

        public final SdkInfoBuilder sdkInterfaces(List<String> list) {
            this.sdkInterfaces = list;
            return this;
        }

        public final SdkInfoBuilder sdkName(String str) {
            this.sdkName = str;
            return this;
        }

        public final SdkInfoBuilder sdkVersion(String str) {
            this.sdkVersion = str;
            return this;
        }
    }

    public String getAppId() {
        return this.appId;
    }

    public List<String> getIgnoreInterfaces() {
        return this.ignoreInterfaces;
    }

    public List<String> getNativeLibraries() {
        return this.nativeLibraries;
    }

    public List<String> getPackageNames() {
        return this.packageNames;
    }

    public List<String> getSdkInterfaces() {
        return this.sdkInterfaces;
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setIgnoreInterfaces(List<String> list) {
        this.ignoreInterfaces = list;
    }

    public void setNativeLibraries(List<String> list) {
        this.nativeLibraries = list;
    }

    public void setPackageNames(List<String> list) {
        this.packageNames = list;
    }

    public void setSdkInterfaces(List<String> list) {
        this.sdkInterfaces = list;
    }

    public void setSdkName(String str) {
        this.sdkName = str;
    }

    public void setSdkVersion(String str) {
        this.sdkVersion = str;
    }
}
