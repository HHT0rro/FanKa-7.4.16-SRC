package com.mobile.auth.c;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.b.f;
import com.mobile.auth.d.i;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36712a = "d";

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f36713b = {15, 31, 94, 10, 90, 15, 91, 24, 10, 30, 88, 7, 89, 10, 95, 30};

    public static /* synthetic */ String a(Context context, Queue queue) {
        try {
            return b(context, (Queue<String>) queue);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ Queue a(Context context, List list, int i10) {
        try {
            return c(context, list, i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static /* synthetic */ void a(Context context) {
        try {
            c(context);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private static void a(Context context, int i10) {
        try {
            try {
                com.mobile.auth.d.b.a(context, "key_c_l_l_v", i10);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r6, java.lang.String r7) {
        /*
            int r0 = r7.hashCode()     // Catch: java.lang.Throwable -> L45
            r1 = 64897(0xfd81, float:9.094E-41)
            r2 = 2
            r3 = 1
            r4 = -1
            r5 = 0
            if (r0 == r1) goto L2c
            r1 = 78159(0x1314f, float:1.09524E-40)
            if (r0 == r1) goto L22
            r1 = 66247144(0x3f2d9e8, float:1.42735105E-36)
            if (r0 == r1) goto L18
            goto L36
        L18:
            java.lang.String r0 = "ERROR"
            boolean r7 = r7.equals(r0)     // Catch: java.lang.Throwable -> L45
            if (r7 == 0) goto L36
            r7 = 1
            goto L37
        L22:
            java.lang.String r0 = "OFF"
            boolean r7 = r7.equals(r0)     // Catch: java.lang.Throwable -> L45
            if (r7 == 0) goto L36
            r7 = 2
            goto L37
        L2c:
            java.lang.String r0 = "ALL"
            boolean r7 = r7.equals(r0)     // Catch: java.lang.Throwable -> L45
            if (r7 == 0) goto L36
            r7 = 0
            goto L37
        L36:
            r7 = -1
        L37:
            if (r7 == 0) goto L40
            if (r7 == r3) goto L41
            if (r7 == r2) goto L3e
            goto L40
        L3e:
            r4 = -2
            goto L41
        L40:
            r4 = 0
        L41:
            a(r6, r4)     // Catch: java.lang.Throwable -> L45
            goto L4e
        L45:
            r6 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r6)     // Catch: java.lang.Throwable -> L4a
            goto L4e
        L4a:
            r6 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r6)
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.c.d.a(android.content.Context, java.lang.String):void");
    }

    public static void a(Context context, List<String> list) {
        try {
            int b4 = b(context);
            if (b4 == -2) {
                return;
            }
            b(context, list, b4);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static /* synthetic */ void a(Context context, Queue queue, int i10) {
        try {
            b(context, (Queue<String>) queue, i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private static int b(Context context) {
        try {
            return com.mobile.auth.d.b.b(context, "key_c_l_l_v", 0);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return 0;
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                    return -1;
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                    return -1;
                }
            }
        }
    }

    private static String b(Context context, String str) {
        try {
            return a.a(context, "https://api-e189.21cn.com/gw/client/accountMsg.do", str);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private static String b(Context context, Queue<String> queue) {
        try {
            JSONArray jSONArray = new JSONArray();
            String jSONArray2 = jSONArray.toString();
            if (!queue.isEmpty()) {
                Iterator<String> it = queue.iterator2();
                while (it.hasNext()) {
                    try {
                        jSONArray.put(new JSONObject(it.next()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (jSONArray.length() <= 0) {
                return "";
            }
            String jSONArray3 = jSONArray.toString();
            if (!TextUtils.isEmpty(jSONArray3)) {
                try {
                    jSONArray2 = URLEncoder.encode(com.mobile.auth.b.b.a(com.mobile.auth.b.a.b(jSONArray3, f.a(f36713b))), "UTF-8");
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            return b(context, jSONArray2);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    private static void b(final Context context, final List<String> list, final int i10) {
        try {
            i.a().a(new Runnable() { // from class: com.mobile.auth.c.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Queue a10 = d.a(context, list, i10);
                        if (a10.isEmpty()) {
                            return;
                        }
                        String a11 = d.a(context, a10);
                        JSONObject jSONObject = null;
                        int i11 = -1;
                        try {
                            if (!TextUtils.isEmpty(a11)) {
                                JSONObject jSONObject2 = new JSONObject(a11);
                                try {
                                    i11 = jSONObject2.getInt("code");
                                    jSONObject = jSONObject2;
                                } catch (Exception e2) {
                                    e = e2;
                                    jSONObject = jSONObject2;
                                    e.printStackTrace();
                                    if (jSONObject != null) {
                                    }
                                    d.a(context, a10, i10);
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                        }
                        if (jSONObject != null || i11 != 0) {
                            d.a(context, a10, i10);
                        } else {
                            d.a(context);
                            a10.clear();
                        }
                    } catch (Throwable th) {
                        try {
                            th.printStackTrace();
                        } catch (Throwable th2) {
                            try {
                                ExceptionProcessor.processException(th2);
                            } catch (Throwable th3) {
                                ExceptionProcessor.processException(th3);
                            }
                        }
                    }
                }
            });
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private static void b(Context context, Queue<String> queue, int i10) {
        JSONObject jSONObject;
        try {
            String str = "";
            JSONArray jSONArray = new JSONArray();
            if (queue != null && !queue.isEmpty()) {
                Iterator<String> it = queue.iterator2();
                int i11 = 0;
                while (it.hasNext()) {
                    try {
                        jSONObject = new JSONObject(it.next());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (i10 != -1 || jSONObject.getInt("rt") != 0) {
                        jSONArray.put(jSONObject);
                        i11++;
                        if (i11 > 10) {
                            break;
                        }
                    }
                }
            }
            if (jSONArray.length() > 0) {
                try {
                    str = com.mobile.auth.b.a.a(jSONArray.toString(), f.a(f36713b));
                } catch (Exception e10) {
                    str = null;
                    e10.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c.a(context, str);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private static synchronized Queue<String> c(Context context, List<String> list, int i10) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        synchronized (d.class) {
            try {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                String a10 = c.a(context);
                if (!TextUtils.isEmpty(a10)) {
                    try {
                        JSONArray jSONArray = new JSONArray(com.mobile.auth.b.a.c(a10, f.a(f36713b)));
                        int length = jSONArray.length();
                        for (int i11 = 0; i11 < length && i11 <= 10; i11++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i11);
                            if (jSONObject != null) {
                                concurrentLinkedQueue.add(jSONObject.toString());
                            }
                        }
                        c.a(context, "");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (i10 == -1) {
                    for (String str : list) {
                        try {
                            if (new JSONObject(str).getInt("rt") != 0) {
                                concurrentLinkedQueue.add(str);
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                } else if (i10 == 0) {
                    concurrentLinkedQueue.addAll(list);
                }
                while (concurrentLinkedQueue.size() > 10) {
                    concurrentLinkedQueue.poll();
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        }
        return concurrentLinkedQueue;
    }

    private static void c(Context context) {
        try {
            c.a(context, "");
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
