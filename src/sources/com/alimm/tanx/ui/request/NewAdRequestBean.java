package com.alimm.tanx.ui.request;

import com.alimm.tanx.core.ad.bean.BaseBean;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class NewAdRequestBean extends BaseBean {
    public AdAppBean app;
    public AdContentBean content;
    public AdDeviceBean device;
    public boolean https_required;

    /* renamed from: id, reason: collision with root package name */
    public String f4199id;
    public List<AdImpBean> imp;
    public int render_type;
    public int version;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class AdAppBean extends BaseBean {
        public String app_name;
        public String app_version;
        public String package_name;
        public String sdk_version;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class AdContentBean extends BaseBean {
        public List<String> category;
        public List<String> keywords;
        public List<String> query_term;
        public List<String> suggestion;
        public String title;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class AdDeviceBean extends BaseBean {
        public String ali_aaid;
        public String android_id;
        public String brand;
        public String clientId;
        public int device_type;
        public AdGeoBean geo;
        public String guid;
        public int height;
        public String imei;
        public List<String> installed_app;
        public String model;
        public int network;
        public String oaid;
        public int operator;
        public int orientation;
        public String os;
        public String osv;
        public int pixel_ratio;
        public String pseudoId;
        public String user_agent;
        public String widevineId;
        public int width;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class AdGeoBean extends BaseBean {
        public double lat;
        public double lon;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class AdImpBean extends BaseBean {

        /* renamed from: id, reason: collision with root package name */
        public String f4200id;
        public String[] native_template_id;
        public String pid;
        public int pos;
        public int slot_num;
    }
}
