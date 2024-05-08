package com.wangmai.common.bean;

import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MaterialInformationBean {
    public AdMaterialInfo adm;
    public String media_slot_id;
    public String request_id;
    public int third_id;
    public String third_slot_id;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AdMaterialInfo {
        public int action_type;
        public String crid;
        public String deeplink;
        public String desc;
        public AppInformation download_app;
        public List<Image> image;
        public String landingpage;
        public double price;
        public String title;
        public int type;
        public Video video;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class AppInformation {
            public String bundle;
            public String desc;
            public String desc_url;
            public String developer;
            public String icon;
            public String name;
            public List<Permission> permission;
            public String permission_url;
            public String privacy_policy_url;
            public int size;
            public String ver;

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
            public static class Permission {
                public String desc;
                public String name;

                public String getDesc() {
                    return this.desc;
                }

                public String getName() {
                    return this.name;
                }

                public void setDesc(String str) {
                    this.desc = str;
                }

                public void setName(String str) {
                    this.name = str;
                }
            }

            public String getBundle() {
                return this.bundle;
            }

            public String getDesc() {
                return this.desc;
            }

            public String getDesc_url() {
                return this.desc_url;
            }

            public String getDeveloper() {
                return this.developer;
            }

            public String getIcon() {
                return this.icon;
            }

            public String getName() {
                return this.name;
            }

            public List<Permission> getPermission() {
                return this.permission;
            }

            public String getPermission_url() {
                return this.permission_url;
            }

            public String getPrivacy_policy_url() {
                return this.privacy_policy_url;
            }

            public int getSize() {
                return this.size;
            }

            public String getVer() {
                return this.ver;
            }

            public void setBundle(String str) {
                this.bundle = str;
            }

            public void setDesc(String str) {
                this.desc = str;
            }

            public void setDesc_url(String str) {
                this.desc_url = str;
            }

            public void setDeveloper(String str) {
                this.developer = str;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setPermission(List<Permission> list) {
                this.permission = list;
            }

            public void setPermission_url(String str) {
                this.permission_url = str;
            }

            public void setPrivacy_policy_url(String str) {
                this.privacy_policy_url = str;
            }

            public void setSize(int i10) {
                this.size = i10;
            }

            public void setVer(String str) {
                this.ver = str;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class Image {

            /* renamed from: h, reason: collision with root package name */
            public int f46921h;
            public String url;

            /* renamed from: w, reason: collision with root package name */
            public int f46922w;

            public int getH() {
                return this.f46921h;
            }

            public String getUrl() {
                return this.url;
            }

            public int getW() {
                return this.f46922w;
            }

            public void setH(int i10) {
                this.f46921h = i10;
            }

            public void setUrl(String str) {
                this.url = str;
            }

            public void setW(int i10) {
                this.f46922w = i10;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class Video {
            public int duration;

            /* renamed from: h, reason: collision with root package name */
            public int f46923h;
            public int size;
            public String url;

            /* renamed from: w, reason: collision with root package name */
            public int f46924w;

            public int getDuration() {
                return this.duration;
            }

            public int getH() {
                return this.f46923h;
            }

            public int getSize() {
                return this.size;
            }

            public String getUrl() {
                return this.url;
            }

            public int getW() {
                return this.f46924w;
            }

            public void setDuration(int i10) {
                this.duration = i10;
            }

            public void setH(int i10) {
                this.f46923h = i10;
            }

            public void setSize(int i10) {
                this.size = i10;
            }

            public void setUrl(String str) {
                this.url = str;
            }

            public void setW(int i10) {
                this.f46924w = i10;
            }
        }

        public int getAction_type() {
            return this.action_type;
        }

        public String getCrid() {
            return this.crid;
        }

        public String getDeeplink() {
            return this.deeplink;
        }

        public String getDesc() {
            return this.desc;
        }

        public AppInformation getDownload_app() {
            return this.download_app;
        }

        public List<Image> getImage() {
            return this.image;
        }

        public String getLandingpage() {
            return this.landingpage;
        }

        public double getPrice() {
            return this.price;
        }

        public String getTitle() {
            return this.title;
        }

        public int getType() {
            return this.type;
        }

        public Video getVideo() {
            return this.video;
        }

        public void setAction_type(int i10) {
            this.action_type = i10;
        }

        public void setCrid(String str) {
            this.crid = str;
        }

        public void setDeeplink(String str) {
            this.deeplink = str;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setDownload_app(AppInformation appInformation) {
            this.download_app = appInformation;
        }

        public void setImage(List<Image> list) {
            this.image = list;
        }

        public void setLandingpage(String str) {
            this.landingpage = str;
        }

        public void setPrice(double d10) {
            this.price = d10;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(int i10) {
            this.type = i10;
        }

        public void setVideo(Video video) {
            this.video = video;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InteractionType {
        public static final int APPLET = 3;
        public static final int DOWNLOAD = 1;
        public static final int LAND_PAGE = 2;
        public static final int UNKNOWN = 9;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface MaterialType {
        public static final int H5 = 3;
        public static final int IMAGE = 1;
        public static final int UNKNOWN = 9;
        public static final int VIDEO = 2;
    }

    public MaterialInformationBean(String str, String str2, int i10, String str3) {
        this.request_id = str;
        this.media_slot_id = str2;
        this.third_id = i10;
        this.third_slot_id = str3;
    }

    public AdMaterialInfo getAdm() {
        return this.adm;
    }

    public String getDemandAdSlotId() {
        return this.third_slot_id;
    }

    public int getDemandPlatformId() {
        return this.third_id;
    }

    public String getMediaAdSlotId() {
        return this.media_slot_id;
    }

    public String getRequestId() {
        return this.request_id;
    }

    public void setAdm(AdMaterialInfo adMaterialInfo) {
        this.adm = adMaterialInfo;
    }

    public void setDemandAdSlotId(String str) {
        this.third_slot_id = str;
    }

    public void setDemandPlatformId(int i10) {
        this.third_id = i10;
    }

    public void setMediaAdSlotId(String str) {
        this.media_slot_id = str;
    }

    public void setRequestId(String str) {
        this.request_id = str;
    }
}
