package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MemoryInfo implements b, Serializable {
    private static final long serialVersionUID = -4944913077323984734L;
    public int mAvailableMB;
    public int mFdCount;
    public int mJavaHeapLimitMB;
    public int mJavaHeapMB;
    public int mPssMB;
    public int mRssMB;
    public int mThreadsCount;
    public int mTotalMB;
    public int mVssMB;
    public List<String> mFds = new ArrayList();
    public List<ThreadInfo> mJavaThreads = new ArrayList();
    public List<ThreadInfo> mNativeThreads = new ArrayList();
    public List<ThreadInfo> mAllThreads = new ArrayList();

    public MemoryInfo() {
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mTotalMB = jSONObject.optInt("mTotalMB");
        this.mAvailableMB = jSONObject.optInt("mAvailableMB");
        this.mJavaHeapLimitMB = jSONObject.optInt("mJavaHeapLimitMB");
        this.mJavaHeapMB = jSONObject.optInt("mJavaHeapMB");
        this.mVssMB = jSONObject.optInt("mVssMB");
        this.mRssMB = jSONObject.optInt("mRssMB");
        this.mPssMB = jSONObject.optInt("mPssMB");
        this.mThreadsCount = jSONObject.optInt("mThreadsCount");
        this.mFdCount = jSONObject.optInt("mFdCount");
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("mFds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                    String optString = optJSONArray.optString(i10);
                    if (optString != null && !optString.isEmpty()) {
                        this.mFds.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("mJavaThreads");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i11);
                    if (optJSONObject != null) {
                        ThreadInfo threadInfo = new ThreadInfo();
                        threadInfo.parseJson(optJSONObject);
                        this.mJavaThreads.add(threadInfo);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("mNativeThreads");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i12);
                    if (optJSONObject2 != null) {
                        ThreadInfo threadInfo2 = new ThreadInfo();
                        threadInfo2.parseJson(optJSONObject2);
                        this.mNativeThreads.add(threadInfo2);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("mAllThreads");
            if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                return;
            }
            for (int i13 = 0; i13 < optJSONArray4.length(); i13++) {
                JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i13);
                if (optJSONObject3 != null) {
                    ThreadInfo threadInfo3 = new ThreadInfo();
                    threadInfo3.parseJson(optJSONObject3);
                    this.mAllThreads.add(threadInfo3);
                }
            }
        } catch (Exception e2) {
            c.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "mTotalMB", this.mTotalMB);
        t.putValue(jSONObject, "mAvailableMB", this.mAvailableMB);
        t.putValue(jSONObject, "mJavaHeapLimitMB", this.mJavaHeapLimitMB);
        t.putValue(jSONObject, "mJavaHeapMB", this.mJavaHeapMB);
        t.putValue(jSONObject, "mVssMB", this.mVssMB);
        t.putValue(jSONObject, "mRssMB", this.mRssMB);
        t.putValue(jSONObject, "mPssMB", this.mPssMB);
        t.putValue(jSONObject, "mThreadsCount", this.mThreadsCount);
        t.putValue(jSONObject, "mFdCount", this.mFdCount);
        t.putValue(jSONObject, "mFds", this.mFds);
        t.putValue(jSONObject, "mJavaThreads", this.mJavaThreads);
        t.putValue(jSONObject, "mNativeThreads", this.mNativeThreads);
        t.putValue(jSONObject, "mAllThreads", this.mAllThreads);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\t总RAM容量: ");
        sb2.append(this.mTotalMB);
        sb2.append(" (MB)\n\t剩余RAM容量: ");
        sb2.append(this.mAvailableMB);
        sb2.append(" (MB)\n\t本进程Java堆上限: ");
        sb2.append(this.mJavaHeapLimitMB);
        sb2.append(" (MB)\n\t本进程Java堆已使用: ");
        sb2.append(this.mJavaHeapMB);
        sb2.append(" (MB)\n\t虚拟地址空间已使用Vss: ");
        sb2.append(this.mVssMB);
        sb2.append(" (MB)\n\t实际空间使用量(包含共享库) Rss: ");
        sb2.append(this.mRssMB);
        sb2.append(" (MB)\n\t实际空间使用量(共享库已经均摊)(高内存杀进程的依据）Pss: ");
        sb2.append(this.mPssMB);
        sb2.append(" (MB)\n\t打开文件描述符数: ");
        sb2.append(this.mFdCount);
        sb2.append("\n");
        if (this.mFds.size() > 0) {
            sb2.append("\t文件描述符详情: \n");
            for (String str : this.mFds) {
                sb2.append("\t");
                sb2.append(str);
                sb2.append("\n");
            }
        }
        sb2.append("\t正在运行线程数: ");
        sb2.append(this.mThreadsCount);
        sb2.append("\tJava: ");
        sb2.append(this.mJavaThreads.size());
        sb2.append("\tNative: ");
        sb2.append(this.mThreadsCount - this.mJavaThreads.size());
        sb2.append("\n\n");
        if (this.mAllThreads.size() > 0) {
            sb2.append("\t全部线程名: \n");
            for (ThreadInfo threadInfo : this.mAllThreads) {
                sb2.append("\t");
                sb2.append(threadInfo.mName);
                sb2.append("\n");
            }
        }
        if (this.mJavaThreads.size() > 0) {
            sb2.append("Java线程堆栈: \n");
            for (ThreadInfo threadInfo2 : this.mJavaThreads) {
                sb2.append(threadInfo2.mName);
                sb2.append("\n");
                sb2.append(threadInfo2.mTrace.replace("#", "\n"));
                sb2.append("\n");
            }
        }
        if (this.mNativeThreads.size() > 0) {
            sb2.append("\tNative线程堆栈: \n");
            for (ThreadInfo threadInfo3 : this.mNativeThreads) {
                sb2.append("\t");
                sb2.append(threadInfo3.mName);
                sb2.append("\t(tid=");
                sb2.append(threadInfo3.mTid);
                sb2.append(", index=");
                sb2.append(threadInfo3.mIndex);
                sb2.append("):\n");
                sb2.append(threadInfo3.mTrace);
            }
        }
        return sb2.substring(0);
    }

    public MemoryInfo(String str) {
        try {
            if (TextUtils.isEmpty(str) || "Unknown".equals(str)) {
                return;
            }
            parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            c.printStackTraceOnly(e2);
        }
    }
}
