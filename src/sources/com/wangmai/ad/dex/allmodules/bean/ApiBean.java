package com.wangmai.ad.dex.allmodules.bean;

import android.content.Context;
import appa.appa.appf.appd;
import com.wangmai.ad.dex.allmodules.appc.appb;
import com.wangmai.ad.dex.allmodules.bean.RequestBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class ApiBean {
    private AdPrice adPrice;
    private List<String> invalidCridList;
    private Optimization optimization = new Optimization();
    private RespObj respObj;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class AdPrice {
        private double dspBidPrice;
        private double mediaBidPrice;

        public double getDspBidPrice() {
            return this.dspBidPrice;
        }

        public double getMediaBidPrice() {
            return this.mediaBidPrice;
        }

        public void setDspBidPrice(double d10) {
            this.dspBidPrice = d10;
        }

        public void setMediaBidPrice(double d10) {
            this.mediaBidPrice = d10;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class CloseObj {
        private int closeBtn;
        private int closeRand;

        public int getCloseBtn() {
            return this.closeBtn;
        }

        public int getCloseRand() {
            return this.closeRand;
        }

        public void setCloseBtn(int i10) {
            this.closeBtn = i10;
        }

        public void setCloseRand(int i10) {
            this.closeRand = i10;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class DownloadAppInfo {
        private String app_name;
        private String desc;
        private String desc_url;
        private String developer;
        private String icon_url;
        private long packet_size;
        private String permission_url;
        private List<Integer> permissions;
        private List<Permission> permissions_list_bean = new ArrayList();
        private String privacy;
        private String version;

        public String getApp_name() {
            return this.app_name;
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

        public String getIcon_url() {
            return this.icon_url;
        }

        public long getPacket_size() {
            return this.packet_size;
        }

        public String getPermission_url() {
            return this.permission_url;
        }

        public List<Integer> getPermissions() {
            return this.permissions;
        }

        public List<Permission> getPermissions_list_bean(Context context) {
            try {
                Map<Integer, Permission> appa2 = appb.appa(context);
                if (this.permissions != null && this.permissions.size() != 0) {
                    for (int i10 = 0; i10 < this.permissions.size(); i10++) {
                        Permission permission = appa2.get(Integer.valueOf(this.permissions.get(i10).intValue()));
                        if (permission != null) {
                            this.permissions_list_bean.add(permission);
                        }
                    }
                }
                return this.permissions_list_bean;
            } catch (Throwable th) {
                appd.appe("api response ", "getPermissions_list_ error:" + th.toString());
                return null;
            }
        }

        public String getPrivacy() {
            return this.privacy;
        }

        public String getVersion() {
            return this.version;
        }

        public DownloadAppInfo setApp_name(String str) {
            this.app_name = str;
            return this;
        }

        public DownloadAppInfo setDesc(String str) {
            this.desc = str;
            return this;
        }

        public DownloadAppInfo setDesc_url(String str) {
            this.desc_url = str;
            return this;
        }

        public DownloadAppInfo setDeveloper(String str) {
            this.developer = str;
            return this;
        }

        public DownloadAppInfo setIcon_url(String str) {
            this.icon_url = str;
            return this;
        }

        public DownloadAppInfo setPacket_size(long j10) {
            this.packet_size = j10;
            return this;
        }

        public DownloadAppInfo setPermission_url(String str) {
            this.permission_url = str;
            return this;
        }

        public DownloadAppInfo setPermissions(List<Integer> list) {
            this.permissions = list;
            return this;
        }

        public DownloadAppInfo setPermissionsListBean(List<Permission> list) {
            this.permissions_list_bean = list;
            return this;
        }

        public DownloadAppInfo setPrivacy(String str) {
            this.privacy = str;
            return this;
        }

        public DownloadAppInfo setVersion(String str) {
            this.version = str;
            return this;
        }

        public String toString() {
            return "{\"app_name\":\"" + this.app_name + "\",\"developer\":\"" + this.developer + "\",\"version\":\"" + this.version + "\",\"packet_size\":\"" + this.packet_size + "\",\"privacy\":\"" + this.privacy + "\",\"permission_url\":\"" + this.permission_url + "\",\"permissions_list\":" + ((Object) this.permissions) + ",\"desc_url\":" + this.desc_url + ",\"desc\":" + this.desc + '}';
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class DpLandingPageObj {
        private int openBtn;
        private double openRand;

        public int getOpenBtn() {
            return this.openBtn;
        }

        public double getOpenRand() {
            return this.openRand;
        }

        public DpLandingPageObj setOpenBtn(int i10) {
            this.openBtn = i10;
            return this;
        }

        public DpLandingPageObj setOpenRand(double d10) {
            this.openRand = d10;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class Extvalue {
        private String endbuttonurl;
        private int endcomments;
        private String enddesc;
        private String endiconurl;
        private String endimgurl;
        private int endrating;
        private String endtitle;
        private String preimgurl;

        public String getEndbuttonurl() {
            return this.endbuttonurl;
        }

        public int getEndcomments() {
            return this.endcomments;
        }

        public String getEnddesc() {
            return this.enddesc;
        }

        public String getEndiconurl() {
            return this.endiconurl;
        }

        public String getEndimgurl() {
            return this.endimgurl;
        }

        public int getEndrating() {
            return this.endrating;
        }

        public String getEndtitle() {
            return this.endtitle;
        }

        public String getPreimgurl() {
            return this.preimgurl;
        }

        public void setEndbuttonurl(String str) {
            this.endbuttonurl = str;
        }

        public void setEndcomments(int i10) {
            this.endcomments = i10;
        }

        public void setEnddesc(String str) {
            this.enddesc = str;
        }

        public void setEndiconurl(String str) {
            this.endiconurl = str;
        }

        public void setEndimgurl(String str) {
            this.endimgurl = str;
        }

        public void setEndrating(int i10) {
            this.endrating = i10;
        }

        public void setEndtitle(String str) {
            this.endtitle = str;
        }

        public void setPreimgurl(String str) {
            this.preimgurl = str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class InteractiveObj {
        public static final int Shake = 1;
        public static final int Swipe = 2;
        private String data;
        private Integer type;

        public String getData() {
            return this.data;
        }

        public Integer getType() {
            return this.type;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setType(Integer num) {
            this.type = num;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class Optimization {
        private RequestBean.DataBean.SdkBean.AdCache adCache;
        private CloseObj closeObj;
        private DpLandingPageObj dpLandingPageObj;
        private List<InteractiveObj> interactiveObjs;
        private int modelStoreStatus;
        private List<String> modelStores;
        private ReportObject reportObject;
        private int simulateClickFrequency;
        private int simulateClickInterval;
        private int simulateClickWait;
        private int slideClickFrequency;
        private int slideClickInterval;
        private int slideClickPixel;
        private SlideObject slideObject;

        public RequestBean.DataBean.SdkBean.AdCache getAdCache() {
            return this.adCache;
        }

        public CloseObj getCloseObj() {
            return this.closeObj;
        }

        public DpLandingPageObj getDpLandingPageObj() {
            return this.dpLandingPageObj;
        }

        public List<InteractiveObj> getInteractiveObjs() {
            return this.interactiveObjs;
        }

        public int getModelStoreStatus() {
            return this.modelStoreStatus;
        }

        public List<String> getModelStores() {
            return this.modelStores;
        }

        public ReportObject getReportObject() {
            return this.reportObject;
        }

        public int getSimulateClickFrequency() {
            return this.simulateClickFrequency;
        }

        public int getSimulateClickInterval() {
            return this.simulateClickInterval;
        }

        public int getSimulateClickWait() {
            return this.simulateClickWait;
        }

        public int getSlideClickFrequency() {
            return this.slideClickFrequency;
        }

        public int getSlideClickInterval() {
            return this.slideClickInterval;
        }

        public int getSlideClickPixel() {
            return this.slideClickPixel;
        }

        public SlideObject getSlideObject() {
            return this.slideObject;
        }

        public void setAdCache(RequestBean.DataBean.SdkBean.AdCache adCache) {
            this.adCache = adCache;
        }

        public void setCloseObj(CloseObj closeObj) {
            this.closeObj = closeObj;
        }

        public Optimization setDpLandingPageObj(DpLandingPageObj dpLandingPageObj) {
            this.dpLandingPageObj = dpLandingPageObj;
            return this;
        }

        public void setInteractiveObjs(List<InteractiveObj> list) {
            this.interactiveObjs = list;
        }

        public void setModelStoreStatus(int i10) {
            this.modelStoreStatus = i10;
        }

        public void setModelStores(List<String> list) {
            this.modelStores = list;
        }

        public void setReportObject(ReportObject reportObject) {
            this.reportObject = reportObject;
        }

        public void setSimulateClickFrequency(int i10) {
            this.simulateClickFrequency = i10;
        }

        public void setSimulateClickInterval(int i10) {
            this.simulateClickInterval = i10;
        }

        public void setSimulateClickWait(int i10) {
            this.simulateClickWait = i10;
        }

        public void setSlideClickFrequency(int i10) {
            this.slideClickFrequency = i10;
        }

        public void setSlideClickInterval(int i10) {
            this.slideClickInterval = i10;
        }

        public void setSlideClickPixel(int i10) {
            this.slideClickPixel = i10;
        }

        public void setSlideObject(SlideObject slideObject) {
            this.slideObject = slideObject;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class Permission {
        private String description;
        private String permissionValue;
        private String title;

        public String getDescription() {
            return this.description;
        }

        public String getPermissionValue() {
            return this.permissionValue;
        }

        public String getTitle() {
            return this.title;
        }

        public Permission setDescription(String str) {
            this.description = str;
            return this;
        }

        public Permission setPermissionValue(String str) {
            this.permissionValue = str;
            return this;
        }

        public Permission setTitle(String str) {
            this.title = str;
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class ReportObject {
        private int shcrandom;
        private int shcswitch;
        private int shrand;
        private int shswitch;

        public int getShcrandom() {
            return this.shcrandom;
        }

        public int getShcswitch() {
            return this.shcswitch;
        }

        public int getShrand() {
            return this.shrand;
        }

        public int getShswitch() {
            return this.shswitch;
        }

        public void setShcrandom(int i10) {
            this.shcrandom = i10;
        }

        public void setShcswitch(int i10) {
            this.shcswitch = i10;
        }

        public void setShrand(int i10) {
            this.shrand = i10;
        }

        public void setShswitch(int i10) {
            this.shswitch = i10;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class RespObj {
        private int error_code;
        private String nurl;
        private String request_id;
        private WxadBean wxad;

        public int getError_code() {
            return this.error_code;
        }

        public String getNurl() {
            return this.nurl;
        }

        public String getRequest_id() {
            return this.request_id;
        }

        public WxadBean getWxad() {
            WxadBean wxadBean = this.wxad;
            if (wxadBean != null) {
                return wxadBean;
            }
            WxadBean wxadBean2 = new WxadBean();
            this.wxad = wxadBean2;
            return wxadBean2;
        }

        public void setError_code(int i10) {
            this.error_code = i10;
        }

        public void setNurl(String str) {
            this.nurl = str;
        }

        public void setRequest_id(String str) {
            this.request_id = str;
        }

        public void setWxad(WxadBean wxadBean) {
            this.wxad = wxadBean;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class SlideObject {
        private int slideProbability;

        public int getSlideProbability() {
            return this.slideProbability;
        }

        public void setSlideProbability(int i10) {
            this.slideProbability = i10;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class Video {
        private int duration;
        private Extvalue ext;
        private List<String> incentiveCallbackTrackers;
        private int orientation;
        private TrackingBean v_tracking;
        private int v_type;
        private String v_url;

        public int getDuration() {
            return this.duration;
        }

        public Extvalue getExt() {
            return this.ext;
        }

        public List<String> getIncentiveCallbackTrackers() {
            return this.incentiveCallbackTrackers;
        }

        public int getOrientation() {
            if (this.orientation == 0) {
                this.orientation = 2;
            }
            return this.orientation;
        }

        public TrackingBean getV_tracking() {
            return this.v_tracking;
        }

        public int getV_type() {
            return this.v_type;
        }

        public String getV_url() {
            return this.v_url;
        }

        public void setDuration(int i10) {
            this.duration = i10;
        }

        public void setExt(Extvalue extvalue) {
            this.ext = extvalue;
        }

        public void setIncentiveCallbackTrackers(List<String> list) {
            this.incentiveCallbackTrackers = list;
        }

        public void setOrientation(int i10) {
            this.orientation = i10;
        }

        public void setV_tracking(TrackingBean trackingBean) {
            this.v_tracking = trackingBean;
        }

        public void setV_type(int i10) {
            this.v_type = i10;
        }

        public void setV_url(String str) {
            this.v_url = str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class WxadBean {
        private String adLogo;
        private String ad_title;
        private String app_package;
        private int app_size;
        private String brand_name;
        private String class_name;
        private List<String> click_url;
        private int creative_type;
        private String deep_link;
        private String description;
        private DownloadAppInfo download_app_info;
        private List<String> download_track_urls;
        private List<String> downloaded_track_urls;
        private List<String> dp_app_installed_urls;
        private List<String> dp_app_uninstalled_urls;
        private List<String> dp_failed_track_urls;
        private List<String> dp_success_track_urls;
        private List<String> dp_try_track_urls;
        private int effective_time;
        private String icon_src;
        private String image_src;
        private List<String> installed_track_urls;
        private int interaction_type;
        private String landing_page_url;
        private int material_height;
        private int material_width;
        private String mini_program_id;
        private String mini_program_path;
        private List<String> mini_program_success_track_urls;
        private Integer mini_program_type;
        private List<String> open_track_urls;
        private long sdk_dp_app_state_total_time;
        private List<String> sdk_track_event_type;
        private String sdk_track_url;
        private List<String> silent_track_urls;
        private String source;
        private Video video;
        private List<String> win_notice_url;

        public String getAdLogo() {
            return this.adLogo;
        }

        public String getAd_title() {
            return this.ad_title;
        }

        public String getApp_package() {
            return this.app_package;
        }

        public int getApp_size() {
            return this.app_size;
        }

        public String getBrand_name() {
            if (this.brand_name == null) {
                this.brand_name = "";
            }
            return this.brand_name;
        }

        public String getClass_name() {
            return this.class_name;
        }

        public List<String> getClick_url() {
            if (this.click_url == null) {
                this.click_url = new ArrayList();
            }
            return this.click_url;
        }

        public int getCreative_type() {
            return this.creative_type;
        }

        public String getDeep_link() {
            String str = this.deep_link;
            return str == null ? "" : str;
        }

        public String getDescription() {
            return this.description;
        }

        public DownloadAppInfo getDownload_app_info() {
            return this.download_app_info;
        }

        public List<String> getDownload_track_urls() {
            if (this.download_track_urls == null) {
                this.download_track_urls = new ArrayList();
            }
            return this.download_track_urls;
        }

        public List<String> getDownloaded_track_urls() {
            if (this.download_track_urls == null) {
                this.download_track_urls = new ArrayList();
            }
            return this.downloaded_track_urls;
        }

        public List<String> getDp_app_installed_urls() {
            if (this.dp_app_installed_urls == null) {
                this.dp_app_installed_urls = new ArrayList();
            }
            return this.dp_app_installed_urls;
        }

        public List<String> getDp_app_uninstalled_urls() {
            if (this.dp_app_uninstalled_urls == null) {
                this.dp_app_uninstalled_urls = new ArrayList();
            }
            return this.dp_app_uninstalled_urls;
        }

        public List<String> getDp_failed_track_urls() {
            if (this.dp_failed_track_urls == null) {
                this.dp_failed_track_urls = new ArrayList();
            }
            return this.dp_failed_track_urls;
        }

        public List<String> getDp_success_track_urls() {
            if (this.dp_success_track_urls == null) {
                this.dp_success_track_urls = new ArrayList();
            }
            return this.dp_success_track_urls;
        }

        public List<String> getDp_try_track_urls() {
            if (this.dp_try_track_urls == null) {
                this.dp_try_track_urls = new ArrayList();
            }
            return this.dp_try_track_urls;
        }

        public int getEffective_time() {
            return this.effective_time;
        }

        public String getIcon_src() {
            return this.icon_src;
        }

        public String getImage_src() {
            return this.image_src;
        }

        public List<String> getInstalled_track_urls() {
            if (this.installed_track_urls == null) {
                this.installed_track_urls = new ArrayList();
            }
            return this.installed_track_urls;
        }

        public int getInteraction_type() {
            return this.interaction_type;
        }

        public String getLanding_page_url() {
            String str = this.landing_page_url;
            return str == null ? "" : str;
        }

        public int getMaterial_height() {
            return this.material_height;
        }

        public int getMaterial_width() {
            return this.material_width;
        }

        public String getMini_program_id() {
            return this.mini_program_id;
        }

        public String getMini_program_path() {
            return this.mini_program_path;
        }

        public List<String> getMini_program_success_track_urls() {
            return this.mini_program_success_track_urls;
        }

        public Integer getMini_program_type() {
            return this.mini_program_type;
        }

        public List<String> getOpen_track_urls() {
            if (this.open_track_urls == null) {
                this.open_track_urls = new ArrayList();
            }
            return this.open_track_urls;
        }

        public long getSdk_dp_app_state_total_time() {
            return this.sdk_dp_app_state_total_time;
        }

        public List<String> getSdk_track_event_type() {
            return this.sdk_track_event_type;
        }

        public String getSdk_track_url() {
            return this.sdk_track_url;
        }

        public List<String> getSilent_track_urls() {
            return this.silent_track_urls;
        }

        public String getSource() {
            return this.source;
        }

        public Video getVideo() {
            return this.video;
        }

        public List<String> getWin_notice_url() {
            if (this.win_notice_url == null) {
                this.win_notice_url = new ArrayList();
            }
            return this.win_notice_url;
        }

        public WxadBean setAdLogo(String str) {
            this.adLogo = str;
            return this;
        }

        public void setAd_title(String str) {
            this.ad_title = str;
        }

        public void setApp_package(String str) {
            this.app_package = str;
        }

        public void setApp_size(int i10) {
            this.app_size = i10;
        }

        public void setBrand_name(String str) {
            this.brand_name = str;
        }

        public void setClass_name(String str) {
            this.class_name = str;
        }

        public void setClick_url(List<String> list) {
            this.click_url = list;
        }

        public void setCreative_type(int i10) {
            this.creative_type = i10;
        }

        public void setDeep_link(String str) {
            this.deep_link = str;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public WxadBean setDownload_app_info(DownloadAppInfo downloadAppInfo) {
            this.download_app_info = downloadAppInfo;
            return this;
        }

        public void setDownload_track_urls(List<String> list) {
            this.download_track_urls = list;
        }

        public void setDownloaded_track_urls(List<String> list) {
            this.downloaded_track_urls = list;
        }

        public void setDp_app_installed_urls(List<String> list) {
            this.dp_app_installed_urls = list;
        }

        public void setDp_app_uninstalled_urls(List<String> list) {
            this.dp_app_uninstalled_urls = list;
        }

        public void setDp_failed_track_urls(List<String> list) {
            this.dp_failed_track_urls = list;
        }

        public void setDp_success_track_urls(List<String> list) {
            this.dp_success_track_urls = list;
        }

        public void setDp_try_track_urls(List<String> list) {
            this.dp_try_track_urls = list;
        }

        public WxadBean setEffective_time(int i10) {
            this.effective_time = i10;
            return this;
        }

        public void setIcon_src(String str) {
            this.icon_src = str;
        }

        public void setImage_src(String str) {
            this.image_src = str;
        }

        public void setInstalled_track_urls(List<String> list) {
            this.installed_track_urls = list;
        }

        public void setInteraction_type(int i10) {
            this.interaction_type = i10;
        }

        public void setLanding_page_url(String str) {
            this.landing_page_url = str;
        }

        public void setMaterial_height(int i10) {
            this.material_height = i10;
        }

        public void setMaterial_width(int i10) {
            this.material_width = i10;
        }

        public void setMini_program_id(String str) {
            this.mini_program_id = str;
        }

        public void setMini_program_path(String str) {
            this.mini_program_path = str;
        }

        public void setMini_program_success_track_urls(List<String> list) {
            this.mini_program_success_track_urls = list;
        }

        public void setMini_program_type(Integer num) {
            this.mini_program_type = num;
        }

        public void setOpen_track_urls(List<String> list) {
            this.open_track_urls = list;
        }

        public void setSdk_dp_app_state_total_time(long j10) {
            this.sdk_dp_app_state_total_time = j10;
        }

        public void setSdk_track_event_type(List<String> list) {
            this.sdk_track_event_type = list;
        }

        public void setSdk_track_url(String str) {
            this.sdk_track_url = str;
        }

        public WxadBean setSilent_track_urls(List<String> list) {
            this.silent_track_urls = list;
            return this;
        }

        public WxadBean setSource(String str) {
            this.source = str;
            return this;
        }

        public void setVideo(Video video) {
            this.video = video;
        }

        public void setWin_notice_url(List<String> list) {
            this.win_notice_url = list;
        }
    }

    public AdPrice getAdPrice() {
        return this.adPrice;
    }

    public List<String> getInvalidCridList() {
        return this.invalidCridList;
    }

    public Optimization getOptimization() {
        return this.optimization;
    }

    public RespObj getRespObj() {
        return this.respObj;
    }

    public void setAdPrice(AdPrice adPrice) {
        this.adPrice = adPrice;
    }

    public void setInvalidCridList(List<String> list) {
        this.invalidCridList = list;
    }

    public void setOptimization(Optimization optimization) {
        this.optimization = optimization;
    }

    public void setRespObj(RespObj respObj) {
        this.respObj = respObj;
    }
}
