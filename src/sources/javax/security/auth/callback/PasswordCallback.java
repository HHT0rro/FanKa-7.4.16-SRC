package javax.security.auth.callback;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PasswordCallback implements Callback, Serializable {
    private static final long serialVersionUID = 2267422647454909926L;
    private boolean echoOn;
    private char[] inputPassword;
    private String prompt;

    public PasswordCallback(String prompt, boolean echoOn) {
        if (prompt == null || prompt.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.prompt = prompt;
        this.echoOn = echoOn;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public boolean isEchoOn() {
        return this.echoOn;
    }

    public void setPassword(char[] password) {
        this.inputPassword = password == null ? null : (char[]) password.clone();
    }

    public char[] getPassword() {
        char[] cArr = this.inputPassword;
        if (cArr == null) {
            return null;
        }
        return (char[]) cArr.clone();
    }

    public void clearPassword() {
        if (this.inputPassword != null) {
            int i10 = 0;
            while (true) {
                char[] cArr = this.inputPassword;
                if (i10 < cArr.length) {
                    cArr[i10] = ' ';
                    i10++;
                } else {
                    return;
                }
            }
        }
    }
}
