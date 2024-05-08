package com.ss.android.socialbase.downloader.utils;

import com.alibaba.wireless.security.SecExceptionCode;
import com.android.internal.logging.nano.MetricsProto;
import com.baidu.mobads.sdk.internal.by;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huawei.openalliance.ad.constant.ad;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadHttpUtils {
    public static String httpCodeToMessage(int i10) {
        if (i10 == 449) {
            return "Retry With";
        }
        if (i10 == 451) {
            return "Unavailable For Legal Reasons";
        }
        if (i10 == 600) {
            return "Unparseable Response Headers";
        }
        if (i10 == 509) {
            return "Bandwidth Limit Exceeded";
        }
        if (i10 == 510) {
            return "Not Extended";
        }
        switch (i10) {
            case 100:
                return "Continue";
            case 101:
                return "Switching Protocols";
            case 102:
                return "Processing";
            default:
                switch (i10) {
                    case 200:
                        return by.f9988k;
                    case 201:
                        return "Created";
                    case 202:
                        return "Accepted";
                    case 203:
                        return "Non-Authoritative Information";
                    case 204:
                        return "No Content";
                    case 205:
                        return "Reset Content";
                    case 206:
                        return "Partial Content";
                    case 207:
                        return "Multi-Status";
                    default:
                        switch (i10) {
                            case 300:
                                return "Multiple Choices";
                            case 301:
                                return "Moved Permanently";
                            case 302:
                                return "Move Temporarily";
                            case 303:
                                return "See Other";
                            case 304:
                                return "Not Modified";
                            case 305:
                                return "Use Proxy";
                            case 306:
                                return "Switch Proxy";
                            case 307:
                                return "Temporary Redirect";
                            default:
                                switch (i10) {
                                    case 400:
                                        return "Bad Request";
                                    case 401:
                                        return "Unauthorized";
                                    case 402:
                                        return "Payment Required";
                                    case 403:
                                        return "Forbidden";
                                    case 404:
                                        return "Not Found";
                                    case 405:
                                        return "Method Not Allowed";
                                    case 406:
                                        return "Not Acceptable";
                                    case 407:
                                        return "Proxy Authentication Required";
                                    case 408:
                                        return "Request Timeout";
                                    case 409:
                                        return "Conflict";
                                    case 410:
                                        return "Gone";
                                    case 411:
                                        return "Length Required";
                                    case 412:
                                        return "Precondition Failed";
                                    case 413:
                                        return "Request Entity Too Large";
                                    case 414:
                                        return "Request-URI Too Long";
                                    case 415:
                                        return "Unsupported Media Type";
                                    case 416:
                                        return "Requested Range Not Satisfiable";
                                    case TTAdConstant.LIVE_FEED_URL_CODE /* 417 */:
                                        return "Expectation Failed";
                                    case TTAdConstant.DEEPLINK_FALL_BACK_CODE /* 418 */:
                                        return "I'm a teapot";
                                    default:
                                        switch (i10) {
                                            case 421:
                                                return "Too Many Connections";
                                            case SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED /* 422 */:
                                                return "Unprocessable Entity";
                                            case 423:
                                                return "Locked";
                                            case ad.f32204q /* 424 */:
                                                return "Failed Dependency";
                                            case ad.f32205r /* 425 */:
                                                return "Unordered Collection";
                                            case 426:
                                                return "Upgrade Required";
                                            default:
                                                switch (i10) {
                                                    case 500:
                                                        return "Internal Server Error";
                                                    case 501:
                                                        return "Not Implemented";
                                                    case 502:
                                                        return "Bad Gateway";
                                                    case 503:
                                                        return "Service Unavailable";
                                                    case 504:
                                                        return "Gateway Timeout";
                                                    case 505:
                                                        return "HTTP Version Not Supported";
                                                    case MetricsProto.MetricsEvent.ACTION_PRINTER_SELECT_DROPDOWN /* 506 */:
                                                        return "Variant Also Negotiates";
                                                    case MetricsProto.MetricsEvent.ACTION_PRINTER_SELECT_ALL /* 507 */:
                                                        return "Insufficient Storage";
                                                    default:
                                                        return "";
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
