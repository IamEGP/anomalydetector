package com.sample.dataProcessing;

public enum Anomaly {

        ECONETZW("ECONETZW", 1),
        INFOBIP("INFOBIP", 2),
        BULKSMS("BULKSMS", 3),
        AWS("AWS", 4),
        NOT_FOUND("NOT FOUND", -1);

        public String value;
        public Integer integerValue;

        private Anomaly(String value, Integer integerValue) {
            this.value = value;
            this.integerValue = integerValue;
        }

        static public Anomaly fromString(String stringValue) {
            switch (stringValue) {
                case "ECONETZW": {
                    return Anomaly.ECONETZW;
                }
                case "INFOBIP": {
                    return Anomaly.INFOBIP;
                }
                case "BULKSMS": {
                    return Anomaly.BULKSMS;
                }
                case "AWS": {
                    return Anomaly.AWS;
                }

                default: {
                    return Anomaly.NOT_FOUND;
                }

            }
        }
    }

