package com.tencent.connect.common;

import android.content.Intent;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UIListenerManager {

    /* renamed from: a, reason: collision with root package name */
    private static UIListenerManager f42571a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, ApiTask> f42572b;

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ApiTask {
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(int i10, IUiListener iUiListener) {
            this.mRequestCode = i10;
            this.mListener = iUiListener;
        }
    }

    private UIListenerManager() {
        Map<String, ApiTask> synchronizedMap = Collections.synchronizedMap(new HashMap());
        this.f42572b = synchronizedMap;
        if (synchronizedMap == null) {
            this.f42572b = Collections.synchronizedMap(new HashMap());
        }
    }

    private IUiListener a(int i10, IUiListener iUiListener) {
        if (i10 == 11101) {
            SLog.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i10 == 11105) {
            SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i10 == 11106) {
            SLog.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iUiListener;
    }

    public static UIListenerManager getInstance() {
        if (f42571a == null) {
            f42571a = new UIListenerManager();
        }
        return f42571a;
    }

    public IUiListener getListnerWithAction(String str) {
        ApiTask apiTask;
        if (str == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.f42572b) {
            apiTask = this.f42572b.get(str);
            this.f42572b.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i10) {
        String a10 = i.a(i10);
        if (a10 == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "getListner action is null! rquestCode=" + i10);
            return null;
        }
        return getListnerWithAction(a10);
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra == 0) {
                String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                if (stringExtra2 != null) {
                    try {
                        iUiListener.onComplete(l.d(stringExtra2));
                        return;
                    } catch (JSONException e2) {
                        iUiListener.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                        SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e2);
                        return;
                    }
                }
                SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                iUiListener.onComplete(new JSONObject());
                return;
            }
            SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
            iUiListener.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
            return;
        }
        if ("action_share".equals(stringExtra)) {
            String stringExtra3 = intent.getStringExtra("result");
            String stringExtra4 = intent.getStringExtra("response");
            if (CardEventType.CLICK_ACTION_CANCEL.equals(stringExtra3)) {
                iUiListener.onCancel();
                return;
            }
            if ("error".equals(stringExtra3)) {
                iUiListener.onError(new UiError(-6, "unknown error", stringExtra4 + ""));
                return;
            }
            if ("complete".equals(stringExtra3)) {
                try {
                    iUiListener.onComplete(new JSONObject(stringExtra4 == null ? "{\"ret\": 0}" : stringExtra4));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                    iUiListener.onError(new UiError(-4, "json error", stringExtra4 + ""));
                }
            }
        }
    }

    public boolean onActivityResult(int i10, int i11, Intent intent, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.UIListenerManager", "onActivityResult req=" + i10 + " res=" + i11);
        IUiListener listnerWithRequestCode = getListnerWithRequestCode(i10);
        if (listnerWithRequestCode == null) {
            if (iUiListener != null) {
                listnerWithRequestCode = a(i10, iUiListener);
            } else {
                SLog.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
                return false;
            }
        }
        if (i11 != -1) {
            listnerWithRequestCode.onCancel();
        } else {
            if (intent == null) {
                listnerWithRequestCode.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
                return true;
            }
            String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
            if ("action_login".equals(stringExtra)) {
                int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (intExtra == 0) {
                    String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                    if (stringExtra2 != null) {
                        try {
                            listnerWithRequestCode.onComplete(l.d(stringExtra2));
                        } catch (JSONException e2) {
                            listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                            SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e2);
                        }
                    } else {
                        SLog.d("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                        listnerWithRequestCode.onComplete(new JSONObject());
                    }
                } else {
                    SLog.e("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onError = " + intExtra + "");
                    listnerWithRequestCode.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                }
            } else if (!"action_share".equals(stringExtra) && !"action_request_avatar".equals(stringExtra) && !"action_request_dynamic_avatar".equals(stringExtra) && !"action_request_set_emotion".equals(stringExtra)) {
                int intExtra2 = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
                if (intExtra2 == 0) {
                    String stringExtra3 = intent.getStringExtra(Constants.KEY_RESPONSE);
                    if (stringExtra3 != null) {
                        try {
                            listnerWithRequestCode.onComplete(l.d(stringExtra3));
                        } catch (JSONException unused) {
                            listnerWithRequestCode.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra3));
                        }
                    } else {
                        listnerWithRequestCode.onComplete(new JSONObject());
                    }
                } else {
                    listnerWithRequestCode.onError(new UiError(intExtra2, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
                }
            } else {
                String stringExtra4 = intent.getStringExtra("result");
                String stringExtra5 = intent.getStringExtra("response");
                if (CardEventType.CLICK_ACTION_CANCEL.equals(stringExtra4)) {
                    listnerWithRequestCode.onCancel();
                } else if ("error".equals(stringExtra4)) {
                    listnerWithRequestCode.onError(new UiError(-6, "unknown error", stringExtra5 + ""));
                } else if ("complete".equals(stringExtra4)) {
                    try {
                        listnerWithRequestCode.onComplete(new JSONObject(stringExtra5 == null ? "{\"ret\": 0}" : stringExtra5));
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                        listnerWithRequestCode.onError(new UiError(-4, "json error", stringExtra5 + ""));
                    }
                }
            }
        }
        return true;
    }

    public Object setListenerWithRequestcode(int i10, IUiListener iUiListener) {
        ApiTask put;
        String a10 = i.a(i10);
        if (a10 == null) {
            SLog.e("openSDK_LOG.UIListenerManager", "setListener action is null! rquestCode=" + i10);
            return null;
        }
        synchronized (this.f42572b) {
            put = this.f42572b.put(a10, new ApiTask(i10, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        ApiTask put;
        int a10 = i.a(str);
        if (a10 == -1) {
            SLog.e("openSDK_LOG.UIListenerManager", "setListnerWithAction fail, action = " + str);
            return null;
        }
        synchronized (this.f42572b) {
            put = this.f42572b.put(str, new ApiTask(a10, iUiListener));
        }
        if (put == null) {
            return null;
        }
        return put.mListener;
    }
}
