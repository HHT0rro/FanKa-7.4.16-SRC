package com.alicom.tools.networking;

import android.text.TextUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RequestManager {
    private static volatile RequestManager mInstance;
    private Request request;
    private int type = 0;
    private int connectTime = 3000;
    private int readTime = 3000;

    public static RequestManager getInstance() {
        if (mInstance == null) {
            synchronized (RequestManager.class) {
                if (mInstance == null) {
                    mInstance = new RequestManager();
                }
            }
        }
        return mInstance;
    }

    public ResultMsg excuse() {
        String str = NetConstant.MSG_ALICOMNETWORK_HOST;
        ResultMsg resultMsg = new ResultMsg();
        Request request = this.request;
        if (request == null) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_PARAMAERROR);
            str = NetConstant.MSG_ALICOMNETWORK_PARAMAERROR;
        } else if (TextUtils.isEmpty(request.getBaseUrl())) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_URL);
            str = NetConstant.MSG_ALICOMNETWORK_URL;
        } else {
            try {
                if (TextUtils.isEmpty(new URL(this.request.getBaseUrl()).getHost())) {
                    resultMsg.setCode("100001");
                    resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_HOST);
                    resultMsg.setSuccess(false);
                    return resultMsg;
                }
                if (TextUtils.isEmpty(this.request.getMethod()) && TextUtils.isEmpty(this.request.getAction())) {
                    resultMsg.setCode("100002");
                    str = NetConstant.MSG_ALICOMNETWORK_API;
                } else if (this.request.isSign() && TextUtils.isEmpty(this.request.getAccessKeySecret())) {
                    resultMsg.setCode("100003");
                    str = NetConstant.MSG_ALICOMNETWORK_SECREKEY;
                } else {
                    try {
                        String callHttpsApi = this.request.getBaseUrl().startsWith("https://") ? AlicomHttpUtils.callHttpsApi(this.request, this.connectTime, this.readTime, this.type) : AlicomHttpUtils.callApi(this.request, this.connectTime, this.readTime, this.type);
                        if (!TextUtils.isEmpty(callHttpsApi) && !"{}".equals(callHttpsApi)) {
                            resultMsg.setCode("100000");
                            resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_SUCCESS);
                            resultMsg.setSuccess(true);
                            resultMsg.setResult(callHttpsApi);
                            return resultMsg;
                        }
                        resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_DATAERROR);
                        resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_DATAERROR);
                        resultMsg.setSuccess(false);
                        return resultMsg;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_NETWORK);
                        str = e2.getLocalizedMessage();
                    }
                }
            } catch (MalformedURLException e10) {
                e10.printStackTrace();
                resultMsg.setCode("100001");
            }
        }
        resultMsg.setMsg(str);
        resultMsg.setSuccess(false);
        return resultMsg;
    }

    public void excuse(RequestCallback requestCallback) {
        String str = NetConstant.MSG_ALICOMNETWORK_HOST;
        if (requestCallback == null) {
            return;
        }
        ResultMsg resultMsg = new ResultMsg();
        Request request = this.request;
        if (request == null) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_PARAMAERROR);
            str = NetConstant.MSG_ALICOMNETWORK_PARAMAERROR;
        } else if (TextUtils.isEmpty(request.getBaseUrl())) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_URL);
            str = NetConstant.MSG_ALICOMNETWORK_URL;
        } else {
            try {
                if (TextUtils.isEmpty(new URL(this.request.getBaseUrl()).getHost())) {
                    resultMsg.setCode("100001");
                    resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_HOST);
                    resultMsg.setSuccess(false);
                    requestCallback.onResult(resultMsg);
                    return;
                }
                if (TextUtils.isEmpty(this.request.getMethod()) && TextUtils.isEmpty(this.request.getAction())) {
                    resultMsg.setCode("100002");
                    str = NetConstant.MSG_ALICOMNETWORK_API;
                } else {
                    if (!this.request.isSign() || !TextUtils.isEmpty(this.request.getAccessKeySecret())) {
                        try {
                            String callHttpsApi = this.request.getBaseUrl().startsWith("https://") ? AlicomHttpUtils.callHttpsApi(this.request, this.connectTime, this.readTime, this.type) : AlicomHttpUtils.callApi(this.request, this.connectTime, this.readTime, this.type);
                            if (!TextUtils.isEmpty(callHttpsApi) && !"{}".equals(callHttpsApi)) {
                                resultMsg.setCode("100000");
                                resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_SUCCESS);
                                resultMsg.setSuccess(true);
                                resultMsg.setResult(callHttpsApi);
                                requestCallback.onResult(resultMsg);
                                return;
                            }
                            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_DATAERROR);
                            resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_DATAERROR);
                            resultMsg.setSuccess(false);
                            requestCallback.onResult(resultMsg);
                            return;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_NETWORK);
                            resultMsg.setMsg(e2.getLocalizedMessage());
                            resultMsg.setSuccess(false);
                            requestCallback.onResult(resultMsg);
                            return;
                        }
                    }
                    resultMsg.setCode("100003");
                    str = NetConstant.MSG_ALICOMNETWORK_SECREKEY;
                }
            } catch (MalformedURLException e10) {
                e10.printStackTrace();
                resultMsg.setCode("100001");
            }
        }
        resultMsg.setMsg(str);
        resultMsg.setSuccess(false);
        requestCallback.onResult(resultMsg);
    }

    public ResultMsg excusePopRequest() {
        String str = NetConstant.MSG_ALICOMNETWORK_HOST;
        ResultMsg resultMsg = new ResultMsg();
        Request request = this.request;
        if (request == null) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_PARAMAERROR);
            str = NetConstant.MSG_ALICOMNETWORK_PARAMAERROR;
        } else if (TextUtils.isEmpty(request.getBaseUrl())) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_URL);
            str = NetConstant.MSG_ALICOMNETWORK_URL;
        } else {
            try {
                if (TextUtils.isEmpty(new URL(this.request.getBaseUrl()).getHost())) {
                    resultMsg.setCode("100001");
                    resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_HOST);
                    resultMsg.setSuccess(false);
                    return resultMsg;
                }
                if (TextUtils.isEmpty(this.request.getMethod()) && TextUtils.isEmpty(this.request.getAction())) {
                    resultMsg.setCode("100002");
                    str = NetConstant.MSG_ALICOMNETWORK_API;
                } else if (this.request.isSign() && TextUtils.isEmpty(this.request.getAccessKeySecret())) {
                    resultMsg.setCode("100003");
                    str = NetConstant.MSG_ALICOMNETWORK_SECREKEY;
                } else {
                    try {
                        this.request.setRequestMethod("POST");
                        this.type = 0;
                        String callHttpsApi = this.request.getBaseUrl().startsWith("https://") ? AlicomHttpUtils.callHttpsApi(this.request, this.connectTime, this.readTime, this.type) : AlicomHttpUtils.callApi(this.request, this.connectTime, this.readTime, this.type);
                        if (!TextUtils.isEmpty(callHttpsApi) && !"{}".equals(callHttpsApi)) {
                            resultMsg.setCode("100000");
                            resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_SUCCESS);
                            resultMsg.setSuccess(true);
                            resultMsg.setResult(callHttpsApi);
                            return resultMsg;
                        }
                        resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_DATAERROR);
                        resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_DATAERROR);
                        resultMsg.setSuccess(false);
                        return resultMsg;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_NETWORK);
                        str = e2.getLocalizedMessage();
                    }
                }
            } catch (MalformedURLException e10) {
                e10.printStackTrace();
                resultMsg.setCode("100001");
            }
        }
        resultMsg.setMsg(str);
        resultMsg.setSuccess(false);
        return resultMsg;
    }

    public void excusePopRequest(RequestCallback requestCallback) {
        String str = NetConstant.MSG_ALICOMNETWORK_HOST;
        if (requestCallback == null) {
            return;
        }
        ResultMsg resultMsg = new ResultMsg();
        Request request = this.request;
        if (request == null) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_PARAMAERROR);
            str = NetConstant.MSG_ALICOMNETWORK_PARAMAERROR;
        } else if (TextUtils.isEmpty(request.getBaseUrl())) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_URL);
            str = NetConstant.MSG_ALICOMNETWORK_URL;
        } else {
            try {
                if (TextUtils.isEmpty(new URL(this.request.getBaseUrl()).getHost())) {
                    resultMsg.setCode("100001");
                    resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_HOST);
                    resultMsg.setSuccess(false);
                    requestCallback.onResult(resultMsg);
                    return;
                }
                if (TextUtils.isEmpty(this.request.getMethod()) && TextUtils.isEmpty(this.request.getAction())) {
                    resultMsg.setCode("100002");
                    str = NetConstant.MSG_ALICOMNETWORK_API;
                } else {
                    if (!this.request.isSign() || !TextUtils.isEmpty(this.request.getAccessKeySecret())) {
                        try {
                            this.type = 0;
                            String callHttpsApi = this.request.getBaseUrl().startsWith("https://") ? AlicomHttpUtils.callHttpsApi(this.request, this.connectTime, this.readTime, this.type) : AlicomHttpUtils.callApi(this.request, this.connectTime, this.readTime, this.type);
                            if (!TextUtils.isEmpty(callHttpsApi) && !"{}".equals(callHttpsApi)) {
                                resultMsg.setCode("100000");
                                resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_SUCCESS);
                                resultMsg.setSuccess(true);
                                resultMsg.setResult(callHttpsApi);
                                requestCallback.onResult(resultMsg);
                                return;
                            }
                            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_DATAERROR);
                            resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_DATAERROR);
                            resultMsg.setSuccess(false);
                            requestCallback.onResult(resultMsg);
                            return;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_NETWORK);
                            resultMsg.setMsg(e2.getLocalizedMessage());
                            resultMsg.setSuccess(false);
                            requestCallback.onResult(resultMsg);
                            return;
                        }
                    }
                    resultMsg.setCode("100003");
                    str = NetConstant.MSG_ALICOMNETWORK_SECREKEY;
                }
            } catch (MalformedURLException e10) {
                e10.printStackTrace();
                resultMsg.setCode("100001");
            }
        }
        resultMsg.setMsg(str);
        resultMsg.setSuccess(false);
        requestCallback.onResult(resultMsg);
    }

    public ResultMsg excuseTopRequest() {
        String str = NetConstant.MSG_ALICOMNETWORK_HOST;
        ResultMsg resultMsg = new ResultMsg();
        Request request = this.request;
        if (request == null) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_PARAMAERROR);
            str = NetConstant.MSG_ALICOMNETWORK_PARAMAERROR;
        } else if (TextUtils.isEmpty(request.getBaseUrl())) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_URL);
            str = NetConstant.MSG_ALICOMNETWORK_URL;
        } else {
            try {
                if (TextUtils.isEmpty(new URL(this.request.getBaseUrl()).getHost())) {
                    resultMsg.setCode("100001");
                    resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_HOST);
                    resultMsg.setSuccess(false);
                    return resultMsg;
                }
                if (TextUtils.isEmpty(this.request.getMethod()) && TextUtils.isEmpty(this.request.getAction())) {
                    resultMsg.setCode("100002");
                    str = NetConstant.MSG_ALICOMNETWORK_API;
                } else if (this.request.isSign() && TextUtils.isEmpty(this.request.getAccessKeySecret())) {
                    resultMsg.setCode("100003");
                    str = NetConstant.MSG_ALICOMNETWORK_SECREKEY;
                } else {
                    try {
                        this.type = 1;
                        String callHttpsApi = this.request.getBaseUrl().startsWith("https://") ? AlicomHttpUtils.callHttpsApi(this.request, this.connectTime, this.readTime, this.type) : AlicomHttpUtils.callApi(this.request, this.connectTime, this.readTime, this.type);
                        if (!TextUtils.isEmpty(callHttpsApi) && !"{}".equals(callHttpsApi)) {
                            resultMsg.setCode("100000");
                            resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_SUCCESS);
                            resultMsg.setSuccess(true);
                            resultMsg.setResult(callHttpsApi);
                            return resultMsg;
                        }
                        resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_DATAERROR);
                        resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_DATAERROR);
                        resultMsg.setSuccess(false);
                        return resultMsg;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_NETWORK);
                        str = e2.getLocalizedMessage();
                    }
                }
            } catch (MalformedURLException e10) {
                e10.printStackTrace();
                resultMsg.setCode("100001");
            }
        }
        resultMsg.setMsg(str);
        resultMsg.setSuccess(false);
        return resultMsg;
    }

    public void excuseTopRequest(RequestCallback requestCallback) {
        String str = NetConstant.MSG_ALICOMNETWORK_HOST;
        if (requestCallback == null) {
            return;
        }
        ResultMsg resultMsg = new ResultMsg();
        Request request = this.request;
        if (request == null) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_PARAMAERROR);
            str = NetConstant.MSG_ALICOMNETWORK_PARAMAERROR;
        } else if (TextUtils.isEmpty(request.getBaseUrl())) {
            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_URL);
            str = NetConstant.MSG_ALICOMNETWORK_URL;
        } else {
            try {
                if (TextUtils.isEmpty(new URL(this.request.getBaseUrl()).getHost())) {
                    resultMsg.setCode("100001");
                    resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_HOST);
                    resultMsg.setSuccess(false);
                    requestCallback.onResult(resultMsg);
                    return;
                }
                if (TextUtils.isEmpty(this.request.getMethod()) && TextUtils.isEmpty(this.request.getAction())) {
                    resultMsg.setCode("100002");
                    str = NetConstant.MSG_ALICOMNETWORK_API;
                } else {
                    if (!this.request.isSign() || !TextUtils.isEmpty(this.request.getAccessKeySecret())) {
                        try {
                            this.type = 1;
                            String callHttpsApi = this.request.getBaseUrl().startsWith("https://") ? AlicomHttpUtils.callHttpsApi(this.request, this.connectTime, this.readTime, this.type) : AlicomHttpUtils.callApi(this.request, this.connectTime, this.readTime, this.type);
                            if (!TextUtils.isEmpty(callHttpsApi) && !"{}".equals(callHttpsApi)) {
                                resultMsg.setCode("100000");
                                resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_SUCCESS);
                                resultMsg.setSuccess(true);
                                resultMsg.setResult(callHttpsApi);
                                requestCallback.onResult(resultMsg);
                                return;
                            }
                            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_DATAERROR);
                            resultMsg.setMsg(NetConstant.MSG_ALICOMNETWORK_DATAERROR);
                            resultMsg.setSuccess(false);
                            requestCallback.onResult(resultMsg);
                            return;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            resultMsg.setCode(NetConstant.CODE_ALICOMNETWORK_NETWORK);
                            resultMsg.setMsg(e2.getLocalizedMessage());
                            resultMsg.setSuccess(false);
                            requestCallback.onResult(resultMsg);
                            return;
                        }
                    }
                    resultMsg.setCode("100003");
                    str = NetConstant.MSG_ALICOMNETWORK_SECREKEY;
                }
            } catch (MalformedURLException e10) {
                e10.printStackTrace();
                resultMsg.setCode("100001");
            }
        }
        resultMsg.setMsg(str);
        resultMsg.setSuccess(false);
        requestCallback.onResult(resultMsg);
    }

    public RequestManager request(Request request) {
        this.request = request;
        return mInstance;
    }

    public RequestManager setConnectTime(int i10) {
        this.connectTime = i10;
        return mInstance;
    }

    public RequestManager setReadTime(int i10) {
        this.readTime = i10;
        return mInstance;
    }

    public RequestManager setType(int i10) {
        this.type = i10;
        return mInstance;
    }
}
