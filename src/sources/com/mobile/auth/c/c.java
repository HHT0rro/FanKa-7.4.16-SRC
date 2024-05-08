package com.mobile.auth.c;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {
    public static String a(Context context) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        try {
            File c4 = c(context);
            StringBuilder sb2 = new StringBuilder();
            if (c4 == null || !c4.exists()) {
                return "";
            }
            try {
                fileInputStream = new FileInputStream(c4);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    sb2.append(readLine);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    th.printStackTrace();
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (Exception e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e12) {
                                            e = e12;
                                            e.printStackTrace();
                                            return sb2.toString();
                                        }
                                    }
                                    return sb2.toString();
                                } finally {
                                }
                            }
                        }
                        bufferedReader.close();
                        try {
                            inputStreamReader.close();
                        } catch (Exception e13) {
                            e13.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                        } catch (Exception e14) {
                            e = e14;
                            e.printStackTrace();
                            return sb2.toString();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                fileInputStream = null;
                bufferedReader = null;
            }
            return sb2.toString();
        } catch (Throwable th5) {
            try {
                ExceptionProcessor.processException(th5);
                return null;
            } catch (Throwable th6) {
                ExceptionProcessor.processException(th6);
                return null;
            }
        }
    }

    public static void a(Context context, String str) {
        try {
            File c4 = c(context);
            if (c4 == null || !c4.exists()) {
                a(b(context), str);
            } else {
                a(c4, str);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private static void a(File file, String str) {
        FileWriter fileWriter;
        if (file == null) {
            return;
        }
        try {
            if (!file.exists()) {
                return;
            }
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    fileWriter = new FileWriter(file, false);
                    try {
                        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                        try {
                            if (TextUtils.isEmpty(str)) {
                                str = "";
                            }
                            bufferedWriter2.write(str);
                            bufferedWriter2.flush();
                            try {
                                bufferedWriter2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            try {
                                fileWriter.close();
                            } catch (Exception e10) {
                                e = e10;
                                e.printStackTrace();
                            }
                        } catch (Exception e11) {
                            e = e11;
                            bufferedWriter = bufferedWriter2;
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (Exception e12) {
                                    e12.printStackTrace();
                                }
                            }
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (Exception e13) {
                                    e = e13;
                                    e.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (Exception e14) {
                                    e14.printStackTrace();
                                }
                            }
                            if (fileWriter == null) {
                                throw th;
                            }
                            try {
                                fileWriter.close();
                                throw th;
                            } catch (Exception e15) {
                                e15.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (Exception e16) {
                        e = e16;
                    }
                } catch (Exception e17) {
                    e = e17;
                    fileWriter = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            try {
                ExceptionProcessor.processException(th4);
            } catch (Throwable th5) {
                ExceptionProcessor.processException(th5);
            }
        }
    }

    private static File b(Context context) {
        if (context != null) {
            try {
                try {
                    File file = new File(((Object) context.getFilesDir()) + "/eAccount/Log/");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, "ipa_ol.ds");
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file2.createNewFile();
                    return file2;
                } catch (Throwable th) {
                    try {
                        ExceptionProcessor.processException(th);
                        return null;
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private static File c(Context context) {
        try {
            if (context != null) {
                try {
                    File file = new File(((Object) context.getFilesDir()) + "/eAccount/Log/");
                    if (!file.exists()) {
                        return null;
                    }
                    File file2 = new File(file, "ipa_ol.ds");
                    if (file2.exists()) {
                        return file2;
                    }
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
