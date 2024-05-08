package ba;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.RequestBean;
import com.huawei.appgallery.marketinstallerservice.internal.framework.storekit.bean.ResponseBean;
import ga.c;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b extends AsyncTask<RequestBean, Void, ResponseBean> {

    /* renamed from: a, reason: collision with root package name */
    public RequestBean f1457a;

    /* renamed from: b, reason: collision with root package name */
    public ja.b f1458b;

    /* renamed from: c, reason: collision with root package name */
    public a f1459c;

    /* renamed from: d, reason: collision with root package name */
    public ga.b f1460d = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {
        void a(b bVar);

        void b(b bVar);
    }

    public b(RequestBean requestBean, ja.b bVar) {
        this.f1457a = requestBean;
        this.f1458b = bVar;
    }

    public final ResponseBean a(Context context) {
        ResponseBean h10 = h(context);
        i(h10);
        return h10;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResponseBean doInBackground(RequestBean... requestBeanArr) {
        ResponseBean a10 = a(this.f1457a.getContext());
        ja.b bVar = this.f1458b;
        if (bVar != null) {
            bVar.b(this.f1457a, a10);
        }
        return a10;
    }

    public final void c(Context context, ResponseBean responseBean, String str) {
        String genBody = this.f1457a.genBody();
        fa.a.a("StoreAgent", "callStore, method:" + this.f1457a.getMethod() + ", url:" + str);
        ga.b bVar = new ga.b();
        this.f1460d = bVar;
        String str2 = new String(bVar.c(context, str, genBody, "UTF-8"), "UTF-8");
        if (da.b.b(str2)) {
            fa.a.d("StoreAgent", "getServerData success");
            f(str2, responseBean);
        } else {
            fa.a.c("StoreAgent", "resData error,res==null or res is not JSONString!");
            responseBean.setResponseCode(1);
            responseBean.setErrCause(ResponseBean.a.JSON_ERROR);
        }
    }

    public void d(ResponseBean responseBean) {
        ResponseBean.a aVar;
        if (isCancelled() || this.f1458b == null) {
            return;
        }
        if (responseBean == null) {
            fa.a.c("StoreAgent", "notifyResult, response is null");
            responseBean = this.f1457a.getResponseBean();
            if (responseBean == null) {
                responseBean = new ResponseBean();
                aVar = ResponseBean.a.PARAM_ERROR;
            } else {
                aVar = ResponseBean.a.UNKNOWN_EXCEPTION;
            }
            responseBean.setErrCause(aVar);
            responseBean.setResponseCode(1);
        }
        this.f1458b.a(this.f1457a, responseBean);
    }

    public final void e(ResponseBean responseBean, int i10, ResponseBean.a aVar) {
        if (responseBean != null) {
            responseBean.setResponseCode(i10);
            responseBean.setErrCause(aVar);
        }
        fa.a.c("StoreAgent", "invoke Store error method:" + this.f1457a.getMethod());
    }

    public final void f(String str, ResponseBean responseBean) {
        StringBuilder sb2;
        String message;
        try {
            responseBean.fromJson(new JSONObject(str));
            responseBean.setResponseCode(0);
        } catch (ClassNotFoundException e2) {
            sb2 = new StringBuilder();
            sb2.append("parse json error ClassNotFoundException, json");
            message = e2.getMessage();
            sb2.append(message);
            fa.a.c("StoreAgent", sb2.toString());
        } catch (IllegalAccessException e10) {
            sb2 = new StringBuilder();
            sb2.append("parse json error IllegalAccessException, json");
            message = e10.getMessage();
            sb2.append(message);
            fa.a.c("StoreAgent", sb2.toString());
        } catch (IllegalArgumentException e11) {
            sb2 = new StringBuilder();
            sb2.append("parse json error IllegalArgumentException, json");
            message = e11.getMessage();
            sb2.append(message);
            fa.a.c("StoreAgent", sb2.toString());
        } catch (InstantiationException e12) {
            sb2 = new StringBuilder();
            sb2.append("parse json error InstantiationException, json");
            message = e12.getMessage();
            sb2.append(message);
            fa.a.c("StoreAgent", sb2.toString());
        } catch (JSONException e13) {
            sb2 = new StringBuilder();
            sb2.append("parse json error JSONException, json");
            message = e13.getMessage();
            sb2.append(message);
            fa.a.c("StoreAgent", sb2.toString());
        }
    }

    public final void g(Executor executor) {
        executeOnExecutor(executor, this.f1457a);
    }

    public final ResponseBean h(Context context) {
        ResponseBean.a aVar;
        ResponseBean.a aVar2;
        ResponseBean.a aVar3;
        int i10 = 5;
        ResponseBean responseBean = null;
        try {
            responseBean = this.f1457a.getResponseBean();
        } catch (FileNotFoundException unused) {
            aVar2 = ResponseBean.a.RESPONSE_EXCEPTION;
            i10 = 7;
            e(null, i10, aVar2);
            return k(responseBean);
        } catch (IllegalArgumentException unused2) {
            aVar2 = ResponseBean.a.PARAM_ERROR;
            e(null, i10, aVar2);
            return k(responseBean);
        } catch (ConnectException unused3) {
            aVar = ResponseBean.a.CONNECT_EXCEPTION;
            e(null, 1, aVar);
            return k(responseBean);
        } catch (SocketTimeoutException | ConnectTimeoutException unused4) {
            aVar2 = ResponseBean.a.CONNECT_EXCEPTION;
            i10 = 2;
            e(null, i10, aVar2);
            return k(responseBean);
        } catch (IOException unused5) {
            aVar = ResponseBean.a.IO_EXCEPTION;
            e(null, 1, aVar);
            return k(responseBean);
        } catch (Throwable unused6) {
            aVar = ResponseBean.a.UNKNOWN_EXCEPTION;
            e(null, 1, aVar);
            return k(responseBean);
        }
        if (c.e(context)) {
            String serviceUrl = this.f1457a.getServiceUrl();
            if (!TextUtils.isEmpty(serviceUrl)) {
                c(context, responseBean, serviceUrl);
                return k(responseBean);
            }
            responseBean.setResponseCode(5);
            aVar3 = ResponseBean.a.PARAM_ERROR;
        } else {
            responseBean.setResponseCode(3);
            aVar3 = ResponseBean.a.NO_NETWORK;
        }
        responseBean.setErrCause(aVar3);
        return k(responseBean);
    }

    public void i(ResponseBean responseBean) {
    }

    @Override // android.os.AsyncTask
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ResponseBean responseBean) {
        a aVar = this.f1459c;
        if (aVar != null) {
            aVar.a(this);
        } else {
            d(responseBean);
        }
    }

    public final ResponseBean k(ResponseBean responseBean) {
        if (responseBean != null) {
            return responseBean;
        }
        ResponseBean responseBean2 = new ResponseBean();
        responseBean2.setResponseCode(5);
        responseBean2.setErrCause(ResponseBean.a.PARAM_ERROR);
        return responseBean2;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        a aVar = this.f1459c;
        if (aVar != null) {
            aVar.b(this);
        }
    }
}
