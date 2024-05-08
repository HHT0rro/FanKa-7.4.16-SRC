package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.utils.i;
import com.kwad.sdk.crash.utils.j;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class ExceptionMessage implements b, Serializable {
    private static final long serialVersionUID = -5338556142957298914L;
    public long mCurrentTimeStamp;
    public int mPid;
    public int mTid;
    public long mUsageTimeMills;
    public String mCrashDetail = "Unknown";
    public String mMemoryInfo = "Unknown";
    public String mDiskInfo = "Unknown";
    public String mProcessName = "Unknown";
    public int mExceptionType = 0;
    public String mCrashType = getTypeCommon();
    public String mThreadName = "Unknown";
    public String mIsAppOnForeground = "Unknown";
    public String mLogUUID = "Unknown";
    public String mVirtualApp = "Unknown";
    public String mCustomMsg = "Unknown";
    public String mThreadOverflow = "Unknown";
    public String mFdOverflow = "Unknown";
    public String mTaskId = "Unknown";
    public String mErrorMessage = "";
    public String mVersionCode = "Unknown";
    public boolean mVersionConflict = false;
    public String mAppVersionBeforeLastUpload = "Unknown";
    public String mJNIError = "";
    public String mGCInfo = "";
    public String mLockInfo = "";
    public String mMonitorInfo = "";
    public String mSlowLooper = "";
    public String mSlowOperation = "";
    public String mBuildConfigInfo = "";
    public String mAbi = "Unknown";
    public String mDumpsys = "";
    public int mCrashSource = 0;

    public static final String getSdkCrashVersionName(String str, int i10) {
        return str + "-" + i10;
    }

    public static final String getSdkVersionNameSuffix(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "" : "-car" : "-pct" : "-ec" : "-ct" : "-ad";
    }

    private void setIsForeground() {
        try {
            com.kwad.sdk.core.c.b.DD();
            this.mIsAppOnForeground = com.kwad.sdk.core.c.b.isAppOnForeground() ? "Foreground" : "Background";
        } catch (Exception unused) {
        }
    }

    public String getReportMsg() {
        return "UUID=" + this.mLogUUID + ",crashTime=" + i.ax(this.mCurrentTimeStamp) + ",customMsg=" + this.mCustomMsg;
    }

    public final String getTypeCommon() {
        return getTypePrefix() + "COMMON";
    }

    public final String getTypeFdOOM() {
        return getTypePrefix() + "FD_OOM";
    }

    public final String getTypeHeapOOM() {
        return getTypePrefix() + "HEAP_OOM";
    }

    public abstract String getTypePrefix();

    public final String getTypeThreadOOM() {
        return getTypePrefix() + "THREAD_OOM";
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mCrashDetail = jSONObject.optString("mCrashDetail");
        this.mMemoryInfo = jSONObject.optString("mMemoryInfo");
        this.mDiskInfo = jSONObject.optString("mDiskInfo");
        this.mProcessName = jSONObject.optString("mProcessName");
        this.mCrashType = jSONObject.optString("mCrashType");
        this.mThreadName = jSONObject.optString("mThreadName");
        this.mIsAppOnForeground = jSONObject.optString("mIsAppOnForeground");
        this.mLogUUID = jSONObject.optString("mLogUUID");
        this.mVirtualApp = jSONObject.optString("mVirtualApp");
        this.mCustomMsg = jSONObject.optString("mCustomMsg");
        this.mThreadOverflow = jSONObject.optString("mThreadOverflow");
        this.mFdOverflow = jSONObject.optString("mFdOverflow");
        this.mTaskId = jSONObject.optString("mTaskId");
        this.mErrorMessage = jSONObject.optString("mErrorMessage");
        this.mCurrentTimeStamp = jSONObject.optLong("mCurrentTimeStamp");
        this.mUsageTimeMills = jSONObject.optLong("mUsageTimeMills");
        this.mPid = jSONObject.optInt("mPid");
        this.mTid = jSONObject.optInt("mTid");
        this.mVersionCode = jSONObject.optString("mVersionCode");
        this.mVersionConflict = jSONObject.optBoolean("mVersionConflict");
        this.mAppVersionBeforeLastUpload = jSONObject.optString("mAppVersionBeforeLastUpload");
        this.mJNIError = jSONObject.optString("mJNIError");
        this.mGCInfo = jSONObject.optString("mGCInfo");
        this.mLockInfo = jSONObject.optString("mLockInfo");
        this.mMonitorInfo = jSONObject.optString("mMonitorInfo");
        this.mSlowLooper = jSONObject.optString("mSlowLooper");
        this.mSlowOperation = jSONObject.optString("mSlowOperation");
        this.mBuildConfigInfo = jSONObject.optString("mBuildConfigInfo");
        this.mAbi = jSONObject.optString("mAbi");
        this.mDumpsys = jSONObject.optString("mDumpsys");
        this.mCrashSource = jSONObject.optInt("mCrashSource");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "mCrashDetail", this.mCrashDetail);
        t.putValue(jSONObject, "mMemoryInfo", this.mMemoryInfo);
        t.putValue(jSONObject, "mDiskInfo", this.mDiskInfo);
        t.putValue(jSONObject, "mProcessName", this.mProcessName);
        t.putValue(jSONObject, "mCrashType", this.mCrashType);
        t.putValue(jSONObject, "mThreadName", this.mThreadName);
        setIsForeground();
        t.putValue(jSONObject, "mIsAppOnForeground", this.mIsAppOnForeground);
        t.putValue(jSONObject, "mLogUUID", this.mLogUUID);
        t.putValue(jSONObject, "mVirtualApp", this.mVirtualApp);
        t.putValue(jSONObject, "mCustomMsg", this.mCustomMsg);
        t.putValue(jSONObject, "mThreadOverflow", this.mThreadOverflow);
        t.putValue(jSONObject, "mFdOverflow", this.mFdOverflow);
        t.putValue(jSONObject, "mTaskId", this.mTaskId);
        t.putValue(jSONObject, "mErrorMessage", this.mErrorMessage);
        t.putValue(jSONObject, "mCurrentTimeStamp", this.mCurrentTimeStamp);
        t.putValue(jSONObject, "mUsageTimeMills", this.mUsageTimeMills);
        t.putValue(jSONObject, "mPid", this.mPid);
        t.putValue(jSONObject, "mTid", this.mTid);
        t.putValue(jSONObject, "mVersionCode", this.mVersionCode);
        t.putValue(jSONObject, "mVersionConflict", this.mVersionConflict);
        t.putValue(jSONObject, "mAppVersionBeforeLastUpload", this.mAppVersionBeforeLastUpload);
        t.putValue(jSONObject, "mJNIError", this.mJNIError);
        t.putValue(jSONObject, "mGCInfo", this.mGCInfo);
        t.putValue(jSONObject, "mLockInfo", this.mLockInfo);
        t.putValue(jSONObject, "mMonitorInfo", this.mMonitorInfo);
        t.putValue(jSONObject, "mSlowLooper", this.mSlowLooper);
        t.putValue(jSONObject, "mSlowOperation", this.mSlowOperation);
        t.putValue(jSONObject, "mBuildConfigInfo", this.mBuildConfigInfo);
        t.putValue(jSONObject, "mAbi", this.mAbi);
        t.putValue(jSONObject, "mDumpsys", this.mDumpsys);
        t.putValue(jSONObject, "mCrashSource", this.mCrashSource);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("异常状态汇总:\nUUID: ");
            sb2.append(this.mLogUUID);
            sb2.append("\nCPU架构: ");
            sb2.append(this.mAbi);
            sb2.append("\n异常进程: ");
            sb2.append(this.mProcessName);
            sb2.append(" (");
            sb2.append(this.mPid);
            sb2.append(")\n");
            sb2.append("异常线程: ");
            sb2.append(this.mThreadName);
            sb2.append(" (");
            sb2.append(this.mTid);
            sb2.append(")\n");
            sb2.append("异常类型: ");
            sb2.append(this.mCrashType);
            sb2.append("\n应用多开环境: ");
            sb2.append(this.mVirtualApp);
            sb2.append("\nTaskId: ");
            sb2.append(this.mTaskId);
            sb2.append("\nmTid: ");
            sb2.append(this.mTid);
            sb2.append("\n自定义信息: ");
            sb2.append(this.mCustomMsg);
            sb2.append("\n前后台状态: ");
            sb2.append(this.mIsAppOnForeground);
            sb2.append("\n异常发生时间: ");
            sb2.append(i.ax(this.mCurrentTimeStamp));
            sb2.append("\n版本号: ");
            sb2.append(this.mVersionCode);
            sb2.append("\n升级前版本号: ");
            sb2.append(this.mAppVersionBeforeLastUpload);
            sb2.append("\n使用时长: ");
            sb2.append(j.ay(this.mUsageTimeMills));
            sb2.append("\n异常详情: \n");
            if (this instanceof JavaExceptionMessage) {
                sb2.append(this.mCrashDetail.replace("##", "\n\t").replace("#", "\n"));
            } else {
                sb2.append(this.mCrashDetail);
            }
            sb2.append("\n磁盘详情: \n");
            sb2.append(this.mDiskInfo);
            sb2.append("\n");
            if (!TextUtils.isEmpty(this.mErrorMessage)) {
                sb2.append("异常上报Debug: \n");
                sb2.append(this.mErrorMessage);
                sb2.append("\n");
            }
            if (!TextUtils.isEmpty(this.mBuildConfigInfo)) {
                sb2.append("BuildConfig信息: \n");
                sb2.append(this.mBuildConfigInfo);
                sb2.append("\n");
            }
            if (!TextUtils.isEmpty(this.mJNIError)) {
                sb2.append("JNI异常: \n");
                sb2.append(this.mJNIError);
                sb2.append("\n");
            }
            if (!TextUtils.isEmpty(this.mGCInfo)) {
                sb2.append("GC耗时: \n");
                sb2.append(this.mGCInfo);
                sb2.append("\n");
            }
            if (!TextUtils.isEmpty(this.mLockInfo)) {
                sb2.append("锁耗时(dvm_lock_sample): \n");
                sb2.append(this.mLockInfo);
                sb2.append("\n");
            }
            if (!TextUtils.isEmpty(this.mMonitorInfo)) {
                sb2.append("锁耗时(monitor): \n");
                sb2.append(this.mMonitorInfo);
                sb2.append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowLooper)) {
                sb2.append("Looper耗时: \n");
                sb2.append(this.mSlowLooper);
                sb2.append("\n");
            }
            if (!TextUtils.isEmpty(this.mSlowOperation)) {
                sb2.append("AMS调度耗时: \n");
                sb2.append(this.mSlowOperation);
                sb2.append("\n");
            }
            sb2.append("内存详情: \n");
            sb2.append(this.mMemoryInfo);
            sb2.append("\n");
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
        return sb2.substring(0);
    }
}
