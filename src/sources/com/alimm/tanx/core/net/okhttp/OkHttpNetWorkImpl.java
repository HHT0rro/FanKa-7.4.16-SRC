package com.alimm.tanx.core.net.okhttp;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.net.INetWork;
import com.alimm.tanx.core.net.bean.DownLoadRequestBean;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.AdNetWorkCallBack;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;
import com.alimm.tanx.core.net.okhttp.callback.ResultCall;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.bean.UtErrorBean;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.EncryptUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class OkHttpNetWorkImpl<T> implements INetWork<T>, NotConfused {
    public static final String TAG = "OkHttpNetWorkImpl";
    public long netTime = 0;

    private String getTag(RequestBean requestBean, NetWorkCallBack netWorkCallBack) {
        if (TextUtils.isEmpty(requestBean.getTag())) {
            return netWorkCallBack != null ? netWorkCallBack.getClass().toString() : "";
        }
        return requestBean.getTag();
    }

    private boolean isNull(RequestBean requestBean, NetWorkCallBack netWorkCallBack) {
        if (requestBean != null) {
            return false;
        }
        if (netWorkCallBack == null) {
            return true;
        }
        UtErrorCode utErrorCode = UtErrorCode.NETWORK_PARAM_ERROR;
        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
        return true;
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void cancelOkHttpTag(String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtils.e("OkHttp ", "tag为空，无法cancelOkHttpTag");
            TanxBaseUt.utError(UtErrorCode.ERROR_LOGIC.getIntCode(), "OkHttp ", "tag为空，无法cancelOkHttpTag", "");
        } else {
            tanxc_do.tanxc_do().tanxc_do(str);
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpDownload(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        try {
            if (isNull(requestBean, onDownloadListener)) {
                return;
            }
            DownLoadRequestBean downLoadRequestBean = (DownLoadRequestBean) requestBean;
            tanxc_do.tanxc_try().tanxc_for(downLoadRequestBean.getUrl()).tanxc_int(getTag(downLoadRequestBean, onDownloadListener)).tanxc_do(downLoadRequestBean.getPath()).tanxc_if(downLoadRequestBean.getFileName()).tanxc_do(downLoadRequestBean.isResume()).tanxc_do().tanxc_do(onDownloadListener);
        } catch (Exception e2) {
            LogUtils.e("sendHttpDownload", e2);
            UtErrorCode utErrorCode = UtErrorCode.OK_HTTP_ERROR;
            onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), utErrorCode.getMsg() + "  " + LogUtils.getStackTraceMessage(e2));
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpGet(RequestBean requestBean, Class cls, NetWorkCallBack netWorkCallBack) {
        sendHttpGet(requestBean, cls, true, true, netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpPost(final RequestBean requestBean, final Class cls, final NetWorkCallBack netWorkCallBack) {
        final long currentTimeMillis = System.currentTimeMillis();
        this.netTime = 0L;
        try {
            if (isNull(requestBean, netWorkCallBack)) {
                return;
            }
            tanxc_do.tanxc_if(false).tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean, netWorkCallBack)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_for(EncryptUtils.encrypt(requestBean.getJson())).tanxc_if(requestBean.isOnlyOneNet()).tanxc_do(requestBean.getTryAgainCount()).tanxc_do().tanxc_do(new ResultCall() { // from class: com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.2
                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void inProgress(float f10) {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onAfter() {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onBefore() {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onError(int i10, String str) {
                    OkHttpNetWorkImpl.this.netTime = System.currentTimeMillis() - currentTimeMillis;
                    LogUtils.d("splashTimeConsuming", "netTimeAll onError->" + OkHttpNetWorkImpl.this.netTime);
                    NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                    if (netWorkCallBack2 != null) {
                        netWorkCallBack2.error(i10, "", str);
                    }
                    LogUtils.e(OkHttpNetWorkImpl.TAG, str, "OkHttp");
                    TanxBaseUt.utNetError(i10, OkHttpNetWorkImpl.TAG, new UtErrorBean(requestBean, i10, str), "OkHttp");
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onSuccess(String str) {
                    OkHttpNetWorkImpl.this.netTime = System.currentTimeMillis() - currentTimeMillis;
                    LogUtils.d("splashTimeConsuming", "netTimeAll onSuccess->" + OkHttpNetWorkImpl.this.netTime);
                    LogUtils.d(OkHttpNetWorkImpl.TAG, str);
                    if (netWorkCallBack != null) {
                        try {
                            if (TextUtils.isEmpty(str)) {
                                onError(UtErrorCode.DATA_PARSE_ERROR.getIntCode(), "response:" + str);
                            } else {
                                String decrypt = EncryptUtils.decrypt(str);
                                LogUtils.d(OkHttpNetWorkImpl.TAG, "AdResp decrypt -> " + decrypt);
                                if (TextUtils.isEmpty(decrypt)) {
                                    onError(UtErrorCode.DECRYPT_ERROR.getIntCode(), "decrypt error:" + str);
                                } else {
                                    NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                                    if (netWorkCallBack2 instanceof AdNetWorkCallBack) {
                                        ((AdNetWorkCallBack) netWorkCallBack2).succ(JSON.parseObject(decrypt, cls), decrypt);
                                    } else {
                                        netWorkCallBack2.succ(JSON.parseObject(decrypt, cls));
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            onError(UtErrorCode.NETWORK_ERROR.getIntCode(), LogUtils.getStackTraceMessage(e2));
                            e2.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e2) {
            LogUtils.e("sendHttpPost", e2);
            UtErrorCode utErrorCode = UtErrorCode.OK_HTTP_ERROR;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg() + "  " + LogUtils.getStackTraceMessage(e2));
        }
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public T sendSyncHttpPost2Gzip(RequestBean requestBean, Class<T> cls) {
        String string;
        if (requestBean == null) {
            return null;
        }
        try {
            Response tanxc_do = tanxc_do.tanxc_if(true).tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_for(EncryptUtils.encrypt(requestBean.getJson(), false)).tanxc_if(requestBean.isOnlyOneNet()).tanxc_do(requestBean.getTryAgainCount()).tanxc_do().tanxc_do(false);
            if (tanxc_do != null) {
                String str = "";
                if (tanxc_do.body() != null && (string = tanxc_do.body().string()) != null) {
                    str = string;
                }
                LogUtils.d(TAG, "result:->" + str);
                String decrypt = EncryptUtils.decrypt(str, false);
                if (!TextUtils.isEmpty(decrypt)) {
                    return (T) JSON.parseObject(decrypt, cls);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtils.e("sendSyncHttpPost2Gzip", e2);
        }
        return null;
    }

    private boolean isNull(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        if (requestBean != null) {
            return false;
        }
        if (onDownloadListener == null) {
            return true;
        }
        UtErrorCode utErrorCode = UtErrorCode.NETWORK_PARAM_ERROR;
        onDownloadListener.onDownloadFailed(utErrorCode.getIntCode(), "downLoad接口请求参数判空:" + utErrorCode.getMsg());
        return true;
    }

    @Override // com.alimm.tanx.core.net.INetWork
    public void sendHttpGet(RequestBean requestBean, final Class cls, boolean z10, final boolean z11, final NetWorkCallBack netWorkCallBack) {
        try {
            if (isNull(requestBean, netWorkCallBack)) {
                return;
            }
            tanxc_do.tanxc_new().tanxc_do(requestBean.getUrl()).tanxc_if(getTag(requestBean, netWorkCallBack)).tanxc_do(requestBean.getHeads()).tanxc_if(requestBean.getParams()).tanxc_if(requestBean.getCacheOfflineTime()).tanxc_do(requestBean.getCacheOnlineTime()).tanxc_do(requestBean.isOnlyOneNet()).tanxc_for(requestBean.getTryAgainCount()).tanxc_do().tanxc_do(new ResultCall() { // from class: com.alimm.tanx.core.net.okhttp.OkHttpNetWorkImpl.1
                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void inProgress(float f10) {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onAfter() {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onBefore() {
                }

                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onError(int i10, String str) {
                    NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                    if (netWorkCallBack2 != null) {
                        netWorkCallBack2.error(i10, "", str);
                    }
                    LogUtils.e(OkHttpNetWorkImpl.TAG, str, "OkHttp");
                    TanxBaseUt.utError(i10, OkHttpNetWorkImpl.TAG, str, "OkHttp");
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.alimm.tanx.core.net.okhttp.callback.ResultCall
                public void onSuccess(String str) {
                    NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                    if (netWorkCallBack2 != 0) {
                        try {
                            if (z11) {
                                netWorkCallBack2.succ(JSON.parseObject(str, cls));
                            } else {
                                netWorkCallBack2.succ(str);
                            }
                        } catch (Exception e2) {
                            onError(UtErrorCode.NETWORK_ERROR.getIntCode(), e2.getMessage());
                            e2.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e2) {
            LogUtils.e("sendHttpGet", e2);
            UtErrorCode utErrorCode = UtErrorCode.OK_HTTP_ERROR;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg() + "  " + LogUtils.getStackTraceMessage(e2));
        }
    }

    private String getTag(RequestBean requestBean, OnDownloadListener onDownloadListener) {
        if (TextUtils.isEmpty(requestBean.getTag())) {
            return onDownloadListener != null ? onDownloadListener.getClass().toString() : "";
        }
        return requestBean.getTag();
    }

    private String getTag(RequestBean requestBean) {
        if (TextUtils.isEmpty(requestBean.getTag())) {
            return System.currentTimeMillis() + "";
        }
        return requestBean.getTag();
    }
}
