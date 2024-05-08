package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.apm.common.utility.Logger;
import com.kwad.sdk.utils.s;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.plugin.PluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RangerInjector {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void a(String str, long j10, long j11, String str2, String str3);

        void onError(String str);
    }

    public static void a(String str, final String str2, final b bVar) {
        try {
            TracePlugin pluginByClass = Matrix.with().getPluginByClass(TracePlugin.class);
            if (pluginByClass == null) {
                bVar.onError("getPluginByClass is null");
                return;
            }
            final PluginListener pluginListener = (PluginListener) s.getField(pluginByClass, "pluginListener");
            if (pluginListener != null) {
                try {
                    s.a(pluginByClass, "pluginListener", Proxy.newProxyInstance(pluginByClass.getClass().getClassLoader(), new Class[]{Class.forName(str)}, new InvocationHandler() { // from class: com.kwad.sdk.ranger.RangerInjector.1
                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            if (method != null) {
                                try {
                                    com.kwad.sdk.core.e.c.i("perfMonitor.RangerInjector", "originPluginListener callback:" + method.getName());
                                } catch (Throwable th) {
                                    b bVar2 = bVar;
                                    if (bVar2 != null) {
                                        bVar2.onError(Log.getStackTraceString(th));
                                    }
                                    return null;
                                }
                            }
                            if (method.getName().contains(String.this)) {
                                Issue issue = (Issue) objArr[0];
                                com.kwad.sdk.core.e.c.i("perfMonitor.RangerInjector", "originPluginListener callback:" + issue.toString());
                                try {
                                    JSONObject content = issue.getContent();
                                    String p10 = RangerInjector.p(content);
                                    long q10 = RangerInjector.q(content);
                                    long r10 = RangerInjector.r(content);
                                    String s2 = RangerInjector.s(content);
                                    String t2 = RangerInjector.t(content);
                                    b bVar3 = bVar;
                                    if (bVar3 != null) {
                                        bVar3.a(p10, r10, q10, s2, t2);
                                    }
                                } catch (Throwable unused) {
                                }
                                pluginListener.onReportIssue(issue);
                            } else if (TextUtils.equals(method.getName(), "onInit")) {
                                pluginListener.onInit((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStart")) {
                                pluginListener.onStart((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStop")) {
                                pluginListener.onStop((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onDestroy")) {
                                pluginListener.onDestroy((Plugin) objArr[0]);
                            } else {
                                try {
                                    method.invoke(pluginListener, objArr);
                                } catch (Throwable th2) {
                                    com.kwad.sdk.core.e.c.e("perfMonitor.RangerInjector", Log.getStackTraceString(th2));
                                }
                            }
                            return null;
                        }
                    }));
                } catch (Exception e2) {
                    bVar.onError(Log.getStackTraceString(e2));
                }
            }
        } catch (Exception e10) {
            bVar.onError(Log.getStackTraceString(e10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String p(JSONObject jSONObject) {
        try {
            return jSONObject.optString("threadStack");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long q(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("cost");
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long r(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("time");
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(JSONObject jSONObject) {
        try {
            return jSONObject.optString("scene");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String t(JSONObject jSONObject) {
        try {
            return jSONObject.optString("process");
        } catch (Exception unused) {
            return "";
        }
    }

    @Keep
    public static void tryProxyOtherOutput(String str, String str2, String str3, final String str4, final a aVar) {
        try {
            final Logger.ILogWritter iLogWritter = (Logger.ILogWritter) s.aq(str, str2);
            if (iLogWritter == null) {
                return;
            }
            Integer num = (Integer) s.aq(str, str3);
            final int intValue = num != null ? num.intValue() : 4;
            s.setStaticField(Class.forName(str), str2, new Logger.ILogWritter() { // from class: com.kwad.sdk.ranger.RangerInjector.2
                @Keep
                public final boolean isLoggable(int i10) {
                    return true;
                }

                @Keep
                public final void logD(String str5, String str6) {
                    try {
                        if (intValue > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logE(String str5, String str6, Throwable th) {
                    try {
                        if (TextUtils.equals(str5, str4) && aVar != null) {
                            Log.getStackTraceString(th);
                        }
                        if (intValue > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logI(String str5, String str6) {
                    try {
                        if (intValue > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logK(String str5, String str6) {
                    try {
                        iLogWritter.logK(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logV(String str5, String str6) {
                    try {
                        if (intValue > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logW(String str5, String str6) {
                    try {
                        if (intValue > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logD(String str5, String str6, Throwable th) {
                    try {
                        if (intValue > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logI(String str5, String str6, Throwable th) {
                    try {
                        if (intValue > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logV(String str5, String str6, Throwable th) {
                    try {
                        if (intValue > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logW(String str5, String str6, Throwable th) {
                    try {
                        if (intValue > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logE(String str5, String str6) {
                    try {
                        if (intValue > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str6);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.w("perfMonitor.RangerInjector", Log.getStackTraceString(th));
        }
    }
}
