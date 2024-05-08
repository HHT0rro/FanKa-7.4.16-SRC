package com.wangmai.common.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SdkTrackEventBean {
    public String media_slot_id;
    public String request_id;
    public long request_time;
    public List<EventBean> track_event;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum TrackEventEnum {
        NotSet(0),
        AdInit(1),
        AdConfigReq(2),
        AdConfigRespSuccess(3),
        AdConfigRespFailure(4),
        AdBidReq(5),
        AdBidRespSuccess(6),
        AdBidRespFailure(7),
        AdSdkBidReq(8),
        AdSdkBidRespSuccess(9),
        AdSdkBidRespFailure(10),
        AdCacheReq(11),
        AdCacheRespSuccess(12),
        AdCacheRespFailure(13),
        AdBidFinish(14),
        AdWin(15),
        AdSdkPrepareSuccess(16),
        AdSdkPrepareFailure(17),
        AdSdkDisplayReq(18),
        AdSdkDisplayRespSuccess(19),
        AdSdkDisplayRespFailure(20),
        AdClick(21);

        public int typeId;

        TrackEventEnum(int i10) {
            this.typeId = i10;
        }
    }

    public void addEvent(EventBean eventBean) {
        if (this.track_event == null) {
            this.track_event = new ArrayList();
        }
        this.track_event.add(eventBean);
    }

    public String getMedia_slot_id() {
        return this.media_slot_id;
    }

    public String getRequest_id() {
        return this.request_id;
    }

    public long getRequest_time() {
        return this.request_time;
    }

    public List<EventBean> getTrack_event() {
        return this.track_event;
    }

    public void setMedia_slot_id(String str) {
        this.media_slot_id = str;
    }

    public void setRequest_id(String str) {
        this.request_id = str;
    }

    public void setRequest_time(long j10) {
        this.request_time = j10;
    }

    public void setTrack_event(List<EventBean> list) {
        this.track_event = list;
    }

    public String toString() {
        return "SdkTrackReportBean{request_id='" + this.request_id + "', request_time=" + this.request_time + ", media_slot_id='" + this.media_slot_id + "', dot=" + ((Object) this.track_event) + '}';
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class EventBean {
        public String ext1;
        public String ext2;
        public Map<String, String> ext_data;
        public int third_id;
        public String third_slot_id;
        public long time;
        public TrackEventEnum type;

        public EventBean() {
            this.time = System.currentTimeMillis();
        }

        public String getExt1() {
            return this.ext1;
        }

        public String getExt2() {
            return this.ext2;
        }

        public Map<String, String> getExt_data() {
            return this.ext_data;
        }

        public int getThird_id() {
            return this.third_id;
        }

        public String getThird_slot_id() {
            return this.third_slot_id;
        }

        public long getTime() {
            return this.time;
        }

        public TrackEventEnum getType() {
            return this.type;
        }

        public void setExt1(String str) {
            this.ext1 = str;
        }

        public void setExt2(String str) {
            this.ext2 = str;
        }

        public void setExt_data(Map<String, String> map) {
            this.ext_data = map;
        }

        public void setThird_id(int i10) {
            this.third_id = i10;
        }

        public void setThird_slot_id(String str) {
            this.third_slot_id = str;
        }

        public void setTime(long j10) {
            this.time = j10;
        }

        public void setType(TrackEventEnum trackEventEnum) {
            this.type = trackEventEnum;
        }

        public String toString() {
            return "TrackBean{type=" + ((Object) this.type) + ", time=" + this.time + ", third_id=" + this.third_id + ", third_slot_id='" + this.third_slot_id + "', ext1='" + this.ext1 + "', ext2='" + this.ext2 + "'}";
        }

        public EventBean(TrackEventEnum trackEventEnum) {
            this.type = trackEventEnum;
            this.time = System.currentTimeMillis();
        }

        public EventBean(TrackEventEnum trackEventEnum, long j10) {
            this.type = trackEventEnum;
            this.time = j10;
        }

        public EventBean(TrackEventEnum trackEventEnum, String str) {
            this.type = trackEventEnum;
            this.ext1 = str;
            this.time = System.currentTimeMillis();
        }

        public EventBean(TrackEventEnum trackEventEnum, long j10, String str) {
            this.type = trackEventEnum;
            this.time = j10;
            this.ext1 = str;
        }
    }
}
