package com.mobile.auth.gatewayauth.model;

import com.mobile.auth.gatewayauth.ExceptionProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class VRBInfo {
    private AlibabaAliqinPnsNumberVerifyResponse alibaba_aliqin_pns_number_verify_response;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class AlibabaAliqinPnsNumberVerifyResponse {
        private String request_id;
        private Result result;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class Result {
            private String code;
            private String message;
            private Module module;

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
            public static class Module {
                private String verify_id;
                private String verify_result;

                public String getVerify_id() {
                    try {
                        return this.verify_id;
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

                public String getVerify_result() {
                    try {
                        return this.verify_result;
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

                public void setVerify_id(String str) {
                    try {
                        this.verify_id = str;
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }

                public void setVerify_result(String str) {
                    try {
                        this.verify_result = str;
                    } catch (Throwable th) {
                        try {
                            ExceptionProcessor.processException(th);
                        } catch (Throwable th2) {
                            ExceptionProcessor.processException(th2);
                        }
                    }
                }
            }

            public String getCode() {
                try {
                    return this.code;
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

            public String getMessage() {
                try {
                    return this.message;
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

            public Module getModule() {
                try {
                    return this.module;
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

            public void setCode(String str) {
                try {
                    this.code = str;
                } catch (Throwable th) {
                    try {
                        ExceptionProcessor.processException(th);
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }
            }

            public void setMessage(String str) {
                try {
                    this.message = str;
                } catch (Throwable th) {
                    try {
                        ExceptionProcessor.processException(th);
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }
            }

            public void setModule(Module module) {
                try {
                    this.module = module;
                } catch (Throwable th) {
                    try {
                        ExceptionProcessor.processException(th);
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                    }
                }
            }
        }

        public String getRequest_id() {
            try {
                return this.request_id;
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

        public Result getResult() {
            try {
                return this.result;
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

        public void setRequest_id(String str) {
            try {
                this.request_id = str;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }

        public void setResult(Result result) {
            try {
                this.result = result;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                }
            }
        }
    }

    public AlibabaAliqinPnsNumberVerifyResponse getAlibaba_aliqin_pns_number_verify_response() {
        try {
            return this.alibaba_aliqin_pns_number_verify_response;
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

    public void setAlibaba_aliqin_pns_number_verify_response(AlibabaAliqinPnsNumberVerifyResponse alibabaAliqinPnsNumberVerifyResponse) {
        try {
            this.alibaba_aliqin_pns_number_verify_response = alibabaAliqinPnsNumberVerifyResponse;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
