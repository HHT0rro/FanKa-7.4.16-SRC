package com.wangmai.common.nativepot;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AdBaseInfo {
    public String desc;
    public WMDownloadAppInfo downloadAppInfo;
    public String iconURL;
    public String imageUrl;
    public List<String> imageUrls;
    public InteractionType interactionType;
    public MaterialType materialType;
    public int pictureHeight;
    public int pictureWidth;
    public String title;
    public int videoHeight;
    public int videoWidth;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum InteractionType {
        NORMAL,
        DOWNLOAD
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum MaterialType {
        NORMAL,
        VIDEO,
        HTML
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class WMDownloadAppInfo {
        public String appDescContent;
        public String appDescUrl;
        public String appDeveloper;
        public String appIconUrl;
        public String appName;
        public long appSize;
        public String appVersion;
        public List<Permission> permissionList;
        public String permissionUrl;
        public String privacyUrl;

        public String getAppDescContent() {
            return this.appDescContent;
        }

        public String getAppDescUrl() {
            return this.appDescUrl;
        }

        public String getAppDeveloper() {
            return this.appDeveloper;
        }

        public String getAppIconUrl() {
            return this.appIconUrl;
        }

        public String getAppName() {
            return this.appName;
        }

        public long getAppSize() {
            return this.appSize;
        }

        public String getAppVersion() {
            return this.appVersion;
        }

        public List<Permission> getPermissionList() {
            return this.permissionList;
        }

        public String getPermissionUrl() {
            return this.permissionUrl;
        }

        public String getPrivacyUrl() {
            return this.privacyUrl;
        }

        public void setAppDescContent(String str) {
            this.appDescContent = str;
        }

        public void setAppDescUrl(String str) {
            this.appDescUrl = str;
        }

        public void setAppDeveloper(String str) {
            this.appDeveloper = str;
        }

        public void setAppIconUrl(String str) {
            this.appIconUrl = str;
        }

        public void setAppName(String str) {
            this.appName = str;
        }

        public void setAppSize(long j10) {
            this.appSize = j10;
        }

        public void setAppVersion(String str) {
            this.appVersion = str;
        }

        public void setPermissionList(List<Permission> list) {
            this.permissionList = list;
        }

        public void setPermissionUrl(String str) {
            this.permissionUrl = str;
        }

        public void setPrivacyUrl(String str) {
            this.privacyUrl = str;
        }

        public String toString() {
            return "DownloadAppInfo{appName='" + this.appName + "', appVersion='" + this.appVersion + "', appDeveloper='" + this.appDeveloper + "', appDescUrl='" + this.appDescUrl + "', appDescContent='" + this.appDescContent + "', permissionUrl='" + this.permissionUrl + "', permissionList=" + ((Object) this.permissionList) + ", privacyUrl='" + this.privacyUrl + "', appIconUrl='" + this.appIconUrl + "', appSize=" + this.appSize + '}';
        }
    }

    public String getDesc() {
        return this.desc;
    }

    public WMDownloadAppInfo getDownloadAppInfo() {
        return this.downloadAppInfo;
    }

    public String getIconURL() {
        return this.iconURL;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public List<String> getImageUrls() {
        return this.imageUrls;
    }

    public InteractionType getInteractionType() {
        return this.interactionType;
    }

    public MaterialType getMaterialType() {
        return this.materialType;
    }

    public int getPictureHeight() {
        return this.pictureHeight;
    }

    public int getPictureWidth() {
        return this.pictureWidth;
    }

    public String getTitle() {
        return this.title;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public AdBaseInfo setDesc(String str) {
        this.desc = str;
        return this;
    }

    public AdBaseInfo setDownloadAppInfo(WMDownloadAppInfo wMDownloadAppInfo) {
        this.downloadAppInfo = wMDownloadAppInfo;
        return this;
    }

    public AdBaseInfo setIconURL(String str) {
        this.iconURL = str;
        return this;
    }

    public AdBaseInfo setImageUrl(String str) {
        this.imageUrl = str;
        return this;
    }

    public AdBaseInfo setImageUrls(List<String> list) {
        this.imageUrls = list;
        return this;
    }

    public AdBaseInfo setInteractionType(InteractionType interactionType) {
        this.interactionType = interactionType;
        return this;
    }

    public AdBaseInfo setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
        return this;
    }

    public AdBaseInfo setPictureHeight(int i10) {
        this.pictureHeight = i10;
        return this;
    }

    public AdBaseInfo setPictureWidth(int i10) {
        this.pictureWidth = i10;
        return this;
    }

    public AdBaseInfo setTitle(String str) {
        this.title = str;
        return this;
    }

    public AdBaseInfo setVideoHeight(int i10) {
        this.videoHeight = i10;
        return this;
    }

    public AdBaseInfo setVideoWidth(int i10) {
        this.videoWidth = i10;
        return this;
    }

    public String toString() {
        return "AdBaseInfo{title='" + this.title + "', iconURL='" + this.iconURL + "', desc='" + this.desc + "', imageUrls=" + ((Object) this.imageUrls) + ", materialType=" + ((Object) this.materialType) + ", interactionType=" + ((Object) this.interactionType) + ", downloadAppInfo=" + ((Object) this.downloadAppInfo) + '}';
    }
}
