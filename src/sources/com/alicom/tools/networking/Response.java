package com.alicom.tools.networking;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Response {

    @SerializationName("Code")
    private String code;

    @SerializationName("HostId")
    private String hostId;

    @SerializationName("Message")
    private String message;

    @SerializationName("Recommend")
    private String recommend;

    @SerializationName("RequestId")
    private String requestId;

    public String getCode() {
        return this.code;
    }

    public String getHostId() {
        return this.hostId;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRecommend() {
        return this.recommend;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setHostId(String str) {
        this.hostId = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRecommend(String str) {
        this.recommend = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String toString() {
        return "Response{requestId='" + this.requestId + "', hostId='" + this.hostId + "', code='" + this.code + "', message='" + this.message + "', recommend='" + this.recommend + "'}";
    }
}
