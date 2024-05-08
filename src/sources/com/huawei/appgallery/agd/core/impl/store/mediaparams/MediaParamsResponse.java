package com.huawei.appgallery.agd.core.impl.store.mediaparams;

import android.text.TextUtils;
import com.huawei.appgallery.agd.serverreq.bean.BaseResponseBean;
import com.huawei.appgallery.agd.serverreq.json.JsonBean;
import com.huawei.appgallery.agd.serverreq.json.annotation.NetworkTransmission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MediaParamsResponse extends BaseResponseBean {

    @NetworkTransmission
    private int autoDownload;

    @NetworkTransmission
    private List<SlotDiversionInfo> slotDivInfos;

    @NetworkTransmission
    private List<CardTemplate> templates;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class CardTemplate extends JsonBean {

        @NetworkTransmission
        private String content;

        @NetworkTransmission
        private String uri;

        public String getContent() {
            return this.content;
        }

        public String getUri() {
            return this.uri;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setUri(String str) {
            this.uri = str;
        }

        public String toString() {
            return "{\"uri\":\"" + this.uri + "\",\"content\":\"" + this.content + "\"}";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SlotDiversionInfo extends JsonBean {

        @NetworkTransmission
        private int adSwitch;
        private boolean isOnlyPps = false;

        @NetworkTransmission
        private String ppsSlotId;

        @NetworkTransmission
        private String slotId;

        public int getAdSwitch() {
            return this.adSwitch;
        }

        public String getPpsSlotId() {
            return this.ppsSlotId;
        }

        public String getSlotId() {
            return this.slotId;
        }

        public boolean isOnlyPps() {
            return this.isOnlyPps;
        }

        public boolean isPrefAG() {
            int i10 = this.adSwitch;
            if (i10 != 0) {
                return i10 == 1 && TextUtils.isEmpty(this.ppsSlotId);
            }
            return true;
        }

        public void setAdSwitch(int i10) {
            this.adSwitch = i10;
        }

        public void setOnlyPps(boolean z10) {
            this.isOnlyPps = z10;
        }

        public void setPpsSlotId(String str) {
            this.ppsSlotId = str;
        }

        public void setSlotId(String str) {
            this.slotId = str;
        }

        public String toString() {
            return "SlotDiversionInfo{slotId='" + this.slotId + "', ppsSlotId='" + this.ppsSlotId + "', adSwitch=" + this.adSwitch + '}';
        }
    }

    public int getAutoDownload() {
        return this.autoDownload;
    }

    public List<SlotDiversionInfo> getSlotDivInfos() {
        return this.slotDivInfos;
    }

    public List<CardTemplate> getTemplates() {
        return this.templates;
    }

    public JSONArray getTemplatesJsonArray() {
        List<CardTemplate> list = this.templates;
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (CardTemplate cardTemplate : this.templates) {
                HashMap hashMap = new HashMap();
                hashMap.put("uri", cardTemplate.uri);
                hashMap.put("content", cardTemplate.content);
                arrayList.add(hashMap);
            }
            return new JSONArray((Collection) arrayList);
        }
        return new JSONArray();
    }

    public void setAutoDownload(int i10) {
        this.autoDownload = i10;
    }

    public void setSlotDivInfos(List<SlotDiversionInfo> list) {
        this.slotDivInfos = list;
    }

    public void setTemplates(List<CardTemplate> list) {
        this.templates = list;
    }
}
