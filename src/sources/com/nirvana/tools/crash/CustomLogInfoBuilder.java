package com.nirvana.tools.crash;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.u;
import com.uc.crashsdk.export.CustomLogInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class CustomLogInfoBuilder {
    private static final String KEY_CT = "exception";
    private static final String LINE_SEP = "\n";
    private static final String LOG_KEY_AC = "k_ac";
    private static final String LOG_KEY_CT = "k_ct";
    private static final String LOG_KEY_STACK_FUNC = "stackFunc";
    private static final String LOG_KEY_STACK_HASH = "stackHash";
    private static final String LOG_SECTION_SEP = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";
    public static final String LOG_TYPE = "exception";
    private String stack;
    private Map<String, String> kvInfoMap = new HashMap(20);
    private List<String> sectionList = new ArrayList(5);
    private CustomLogInfo mCustomLogInfo = new CustomLogInfo(new StringBuffer(), "exception");

    public CustomLogInfoBuilder(String str) {
        this.kvInfoMap.put(LOG_KEY_CT, "exception");
        this.kvInfoMap.put(LOG_KEY_AC, str);
    }

    public CustomLogInfoBuilder addLogCat(boolean z10) {
        this.mCustomLogInfo.mAddLogcat = z10;
        return this;
    }

    public CustomLogInfoBuilder addSection(String str) {
        this.sectionList.add(str);
        return this;
    }

    public CustomLogInfo build() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : this.kvInfoMap.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(u.bD);
            stringBuffer.append(entry.getValue());
            stringBuffer.append("\n");
        }
        if (!TextUtils.isEmpty(this.stack)) {
            stringBuffer.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
            stringBuffer.append(this.stack);
            stringBuffer.append("\n");
        }
        for (String str : this.sectionList) {
            stringBuffer.append("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
            stringBuffer.append(str);
            stringBuffer.append("\n");
        }
        this.mCustomLogInfo.mData = stringBuffer;
        return this.mCustomLogInfo;
    }

    public CustomLogInfoBuilder put(String str, String str2) {
        if (!LOG_KEY_AC.equals(str) && !LOG_KEY_CT.equals(str)) {
            this.kvInfoMap.put(str, str2);
        }
        return this;
    }

    public CustomLogInfoBuilder stack(String str) {
        this.stack = "Exception message:\nBack traces starts.\n" + str + "Back traces ends.";
        return this;
    }

    public CustomLogInfoBuilder stack(Throwable th) {
        return stack(Log.getStackTraceString(th));
    }

    public CustomLogInfoBuilder stackFunc(String str) {
        this.kvInfoMap.put(LOG_KEY_STACK_FUNC, str);
        return this;
    }

    public CustomLogInfoBuilder stackHash(String str) {
        this.kvInfoMap.put(LOG_KEY_STACK_HASH, str);
        return this;
    }

    public CustomLogInfoBuilder uploadNow(boolean z10) {
        this.mCustomLogInfo.mUploadNow = z10;
        return this;
    }
}
