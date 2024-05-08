package m2;

import com.effectsar.labcv.licenselibrary.HttpRequestProvider;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: EffectHttpRequestProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a implements HttpRequestProvider {
    @Override // com.effectsar.labcv.licenselibrary.HttpRequestProvider
    public HttpRequestProvider.ResponseInfo getRequest(HttpRequestProvider.RequestInfo requestInfo) {
        return new HttpRequestProvider.ResponseInfo();
    }

    @Override // com.effectsar.labcv.licenselibrary.HttpRequestProvider
    public HttpRequestProvider.ResponseInfo postRequest(HttpRequestProvider.RequestInfo requestInfo) {
        HttpRequestProvider.ResponseInfo responseInfo = new HttpRequestProvider.ResponseInfo();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(requestInfo.url).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            for (Map.Entry<String, String> entry : requestInfo.requestHead.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(requestInfo.bodydata.getBytes());
            outputStream.flush();
            int responseCode = httpURLConnection.getResponseCode();
            responseInfo.status_code = responseCode;
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb2.append(readLine);
                }
                inputStream.close();
                String sb3 = sb2.toString();
                responseInfo.bodydata = sb3;
                responseInfo.bodySize = sb3.length();
                responseInfo.userdata = requestInfo.userdata;
                responseInfo.isSuc = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return responseInfo;
    }
}
