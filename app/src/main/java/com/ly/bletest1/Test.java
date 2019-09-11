package com.ly.bletest1;

import java.util.List;

/**
 * @创建者 ly
 * @创建时间 2019/9/6
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class Test {

    /**
     * datas : {"cdma":[{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-88","pn":"24"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-100","pn":"192"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-93","pn":"360"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-98","pn":"309"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-100","pn":"477"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-101","pn":"318"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-98","pn":"240"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-99","pn":"471"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-92","pn":"207"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-92","pn":"384"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-93","pn":"324"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-100","pn":"84"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-99","pn":"411"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-99","pn":"378"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-100","pn":"141"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-98","pn":"195"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-98","pn":"108"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-98","pn":"375"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-99","pn":"447"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-98","pn":"111"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-99","pn":"426"},{"create_time":"2019-09-06 13:39:27","nid":"20","bid":"4490","sid":"14206","rx":"-84","pn":"45"}],"gsm":[{"create_time":"2019-09-06 13:39:27","lac":"29580","cellid":"5400","mcc":"460","mnc":"0","psc_pci":"268435455","sig1":"62","sig1_dbm":"-196","sig2":"99","sig2_dbm":"1"},{"create_time":"2019-09-06 13:39:27","lac":"29580","cellid":"37421","mcc":"460","mnc":"0","psc_pci":"268435455","sig1":"44","sig1_dbm":"-268","sig2":"99","sig2_dbm":"1"},{"create_time":"2019-09-06 13:39:27","lac":"29580","cellid":"37423","mcc":"460","mnc":"0","psc_pci":"268435455","sig1":"34","sig1_dbm":"-308","sig2":"99","sig2_dbm":"1"},{"create_time":"2019-09-06 13:39:27","lac":"29580","cellid":"19171","mcc":"460","mnc":"0","psc_pci":"268435455","sig1":"21","sig1_dbm":"-360","sig2":"99","sig2_dbm":"1"},{"create_time":"2019-09-06 13:39:27","lac":"29467","cellid":"10243","mcc":"460","mnc":"1","psc_pci":"268435455","sig1":"32","sig1_dbm":"-316","sig2":"99","sig2_dbm":"1"},{"create_time":"2019-09-06 13:39:27","lac":"29467","cellid":"53271","mcc":"460","mnc":"1","psc_pci":"268435455","sig1":"25","sig1_dbm":"-344","sig2":"99","sig2_dbm":"1"},{"create_time":"2019-09-06 13:39:27","lac":"29467","cellid":"53272","mcc":"460","mnc":"1","psc_pci":"268435455","sig1":"25","sig1_dbm":"-344","sig2":"99","sig2_dbm":"1"},{"create_time":"2019-09-06 13:39:27","lac":"29467","cellid":"51471","mcc":"460","mnc":"1","psc_pci":"268435455","sig1":"22","sig1_dbm":"-356","sig2":"99","sig2_dbm":"1"},{"create_time":"2019-09-06 13:39:27","lac":"29467","cellid":"10242","mcc":"460","mnc":"1","psc_pci":"268435455","sig1":"21","sig1_dbm":"-360","sig2":"99","sig2_dbm":"1"}],"wcdma":[{"create_time":"2019-09-06 13:39:27","lac":"58131","cellid":"220649769","mcc":"460","mnc":"1","psc_pci":"506","sig1":"33","sig1_dbm":"-352","sig2":"39","sig2_dbm":"-20"},{"create_time":"2019-09-06 13:39:27","lac":"58131","cellid":"220649769","mcc":"460","mnc":"1","psc_pci":"506","sig1":"33","sig1_dbm":"-352","sig2":"39","sig2_dbm":"-20"}],"lte":[{"create_time":"2019-09-06 13:39:27","lac":"29580","cellid":"252216966","mcc":"460","mnc":"0","psc_pci":"180","sig1":"51","sig1_dbm":"-360","sig2":"23","sig2_dbm":"-34"},{"create_time":"2019-09-06 13:39:27","lac":"29466","cellid":"185570051","mcc":"460","mnc":"1","psc_pci":"478","sig1":"61","sig1_dbm":"-320","sig2":"17","sig2_dbm":"-46"},{"create_time":"2019-09-06 13:39:27","lac":"29466","cellid":"185570052","mcc":"460","mnc":"1","psc_pci":"18","sig1":"30","sig1_dbm":"-444","sig2":"13","sig2_dbm":"-54"},{"create_time":"2019-09-06 13:39:27","lac":"29466","cellid":"185570054","mcc":"460","mnc":"1","psc_pci":"307","sig1":"26","sig1_dbm":"-460","sig2":"6","sig2_dbm":"-68"},{"create_time":"2019-09-06 13:39:27","lac":"29466","cellid":"185570058","mcc":"460","mnc":"1","psc_pci":"336","sig1":"21","sig1_dbm":"-480","sig2":"13","sig2_dbm":"-54"},{"create_time":"2019-09-06 13:39:27","lac":"29466","cellid":"185570062","mcc":"460","mnc":"1","psc_pci":"18","sig1":"21","sig1_dbm":"-480","sig2":"11","sig2_dbm":"-58"},{"create_time":"2019-09-06 13:39:27","lac":"29466","cellid":"185570068","mcc":"460","mnc":"1","psc_pci":"263","sig1":"17","sig1_dbm":"-496","sig2":"6","sig2_dbm":"-68"},{"create_time":"2019-09-06 13:39:27","lac":"34684","cellid":"142376198","mcc":"460","mnc":"11","psc_pci":"368","sig1":"53","sig1_dbm":"-352","sig2":"26","sig2_dbm":"-28"}]}
     */

    private DatasBean datas;

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<CdmaBean> cdma;
        private List<GsmBean> gsm;
        private List<WcdmaBean> wcdma;
        private List<LteBean> lte;

        public List<CdmaBean> getCdma() {
            return cdma;
        }

        public void setCdma(List<CdmaBean> cdma) {
            this.cdma = cdma;
        }

        public List<GsmBean> getGsm() {
            return gsm;
        }

        public void setGsm(List<GsmBean> gsm) {
            this.gsm = gsm;
        }

        public List<WcdmaBean> getWcdma() {
            return wcdma;
        }

        public void setWcdma(List<WcdmaBean> wcdma) {
            this.wcdma = wcdma;
        }

        public List<LteBean> getLte() {
            return lte;
        }

        public void setLte(List<LteBean> lte) {
            this.lte = lte;
        }

        public static class CdmaBean {
            /**
             * create_time : 2019-09-06 13:39:27
             * nid : 20
             * bid : 4490
             * sid : 14206
             * rx : -88
             * pn : 24
             */

            private String create_time;
            private String nid;
            private String bid;
            private String sid;
            private String rx;
            private String pn;

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getNid() {
                return nid;
            }

            public void setNid(String nid) {
                this.nid = nid;
            }

            public String getBid() {
                return bid;
            }

            public void setBid(String bid) {
                this.bid = bid;
            }

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }

            public String getRx() {
                return rx;
            }

            public void setRx(String rx) {
                this.rx = rx;
            }

            public String getPn() {
                return pn;
            }

            public void setPn(String pn) {
                this.pn = pn;
            }
        }

        public static class GsmBean {
            /**
             * create_time : 2019-09-06 13:39:27
             * lac : 29580
             * cellid : 5400
             * mcc : 460
             * mnc : 0
             * psc_pci : 268435455
             * sig1 : 62
             * sig1_dbm : -196
             * sig2 : 99
             * sig2_dbm : 1
             */

            private String create_time;
            private String lac;
            private String cellid;
            private String mcc;
            private String mnc;
            private String psc_pci;
            private String sig1;
            private String sig1_dbm;
            private String sig2;
            private String sig2_dbm;

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getLac() {
                return lac;
            }

            public void setLac(String lac) {
                this.lac = lac;
            }

            public String getCellid() {
                return cellid;
            }

            public void setCellid(String cellid) {
                this.cellid = cellid;
            }

            public String getMcc() {
                return mcc;
            }

            public void setMcc(String mcc) {
                this.mcc = mcc;
            }

            public String getMnc() {
                return mnc;
            }

            public void setMnc(String mnc) {
                this.mnc = mnc;
            }

            public String getPsc_pci() {
                return psc_pci;
            }

            public void setPsc_pci(String psc_pci) {
                this.psc_pci = psc_pci;
            }

            public String getSig1() {
                return sig1;
            }

            public void setSig1(String sig1) {
                this.sig1 = sig1;
            }

            public String getSig1_dbm() {
                return sig1_dbm;
            }

            public void setSig1_dbm(String sig1_dbm) {
                this.sig1_dbm = sig1_dbm;
            }

            public String getSig2() {
                return sig2;
            }

            public void setSig2(String sig2) {
                this.sig2 = sig2;
            }

            public String getSig2_dbm() {
                return sig2_dbm;
            }

            public void setSig2_dbm(String sig2_dbm) {
                this.sig2_dbm = sig2_dbm;
            }
        }

        public static class WcdmaBean {
            /**
             * create_time : 2019-09-06 13:39:27
             * lac : 58131
             * cellid : 220649769
             * mcc : 460
             * mnc : 1
             * psc_pci : 506
             * sig1 : 33
             * sig1_dbm : -352
             * sig2 : 39
             * sig2_dbm : -20
             */

            private String create_time;
            private String lac;
            private String cellid;
            private String mcc;
            private String mnc;
            private String psc_pci;
            private String sig1;
            private String sig1_dbm;
            private String sig2;
            private String sig2_dbm;

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getLac() {
                return lac;
            }

            public void setLac(String lac) {
                this.lac = lac;
            }

            public String getCellid() {
                return cellid;
            }

            public void setCellid(String cellid) {
                this.cellid = cellid;
            }

            public String getMcc() {
                return mcc;
            }

            public void setMcc(String mcc) {
                this.mcc = mcc;
            }

            public String getMnc() {
                return mnc;
            }

            public void setMnc(String mnc) {
                this.mnc = mnc;
            }

            public String getPsc_pci() {
                return psc_pci;
            }

            public void setPsc_pci(String psc_pci) {
                this.psc_pci = psc_pci;
            }

            public String getSig1() {
                return sig1;
            }

            public void setSig1(String sig1) {
                this.sig1 = sig1;
            }

            public String getSig1_dbm() {
                return sig1_dbm;
            }

            public void setSig1_dbm(String sig1_dbm) {
                this.sig1_dbm = sig1_dbm;
            }

            public String getSig2() {
                return sig2;
            }

            public void setSig2(String sig2) {
                this.sig2 = sig2;
            }

            public String getSig2_dbm() {
                return sig2_dbm;
            }

            public void setSig2_dbm(String sig2_dbm) {
                this.sig2_dbm = sig2_dbm;
            }
        }

        public static class LteBean {
            /**
             * create_time : 2019-09-06 13:39:27
             * lac : 29580
             * cellid : 252216966
             * mcc : 460
             * mnc : 0
             * psc_pci : 180
             * sig1 : 51
             * sig1_dbm : -360
             * sig2 : 23
             * sig2_dbm : -34
             */

            private String create_time;
            private String lac;
            private String cellid;
            private String mcc;
            private String mnc;
            private String psc_pci;
            private String sig1;
            private String sig1_dbm;
            private String sig2;
            private String sig2_dbm;

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getLac() {
                return lac;
            }

            public void setLac(String lac) {
                this.lac = lac;
            }

            public String getCellid() {
                return cellid;
            }

            public void setCellid(String cellid) {
                this.cellid = cellid;
            }

            public String getMcc() {
                return mcc;
            }

            public void setMcc(String mcc) {
                this.mcc = mcc;
            }

            public String getMnc() {
                return mnc;
            }

            public void setMnc(String mnc) {
                this.mnc = mnc;
            }

            public String getPsc_pci() {
                return psc_pci;
            }

            public void setPsc_pci(String psc_pci) {
                this.psc_pci = psc_pci;
            }

            public String getSig1() {
                return sig1;
            }

            public void setSig1(String sig1) {
                this.sig1 = sig1;
            }

            public String getSig1_dbm() {
                return sig1_dbm;
            }

            public void setSig1_dbm(String sig1_dbm) {
                this.sig1_dbm = sig1_dbm;
            }

            public String getSig2() {
                return sig2;
            }

            public void setSig2(String sig2) {
                this.sig2 = sig2;
            }

            public String getSig2_dbm() {
                return sig2_dbm;
            }

            public void setSig2_dbm(String sig2_dbm) {
                this.sig2_dbm = sig2_dbm;
            }
        }
    }
}
