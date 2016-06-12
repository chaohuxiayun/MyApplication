package com.example.administrator.myapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/6/12.
 */
public class GuPiao {

    /**
     * name : 青岛啤酒
     * code : 00168
     * date : 2015/07/29 11:59
     * openningPrice : 42.5
     * closingPrice : 42.05
     * hPrice : 42.5
     * lPrice : 41.6
     * currentPrice : 41.75
     * growth : -0.3
     * growthPercent : -0.713
     * dealnumber : 947355
     * turnover : 39639371
     * 52hPrice : 64
     * 52lPrice : 41.15
     */

    private StockinfoBean stockinfo;
    /**
     * shanghai : {"name":"上证指数","curdot":3655.265,"curprice":-7.737,"rate":-0.21,"dealnumber":2200597,"turnover":28321565}
     * shenzhen : {"name":"深证成指","curdot":12262.868,"curprice":-53.908,"rate":-0.44,"dealnumber":150072036,"turnover":26837342}
     * DJI : {"name":"道琼斯","date":"2015-07-29 05:28:06","curdot":17630.27,"rate":1.09,"growth":189.68,"startdot":17561.78,"closedot":17440.59,"hdot":17561.78,"ldot":17399.17,"turnover":0}
     * IXIC : {"name":"纳斯达克","date":"2015-07-29 05:39:57","curdot":5089.21,"rate":0.98,"growth":49.43,"startdot":5063.44,"closedot":5039.78,"hdot":5097.69,"ldot":5025.61,"turnover":2013976426}
     * INX : {"name":"纳斯达克","date":"2015-07-29 05:39:57","curdot":2093.25,"rate":1.24,"growth":25.61,"startdot":2070.75,"closedot":2067.64,"hdot":2095.6,"ldot":2069.09,"turnover":0}
     * HSI : {"name":"恒生指数","date":"2015/07/29 12:05","curdot":24515.8,"rate":0.05,"growth":11.86,"startdot":24630.44,"closedot":24503.94,"hdot":24718.64,"ldot":24468.55,"turnover":43951640,"52hdot":28588.52,"52ldot":22529.75}
     */

    private MarketBean market;

    public StockinfoBean getStockinfo() {
        return stockinfo;
    }

    public void setStockinfo(StockinfoBean stockinfo) {
        this.stockinfo = stockinfo;
    }

    public MarketBean getMarket() {
        return market;
    }

    public void setMarket(MarketBean market) {
        this.market = market;
    }

    public static class StockinfoBean {
        private String name;
        private String code;
        private String date;
        private double openningPrice;
        private double closingPrice;
        private double hPrice;
        private double lPrice;
        private double currentPrice;
        private double growth;
        private double growthPercent;
        private int dealnumber;
        private int turnover;
        @SerializedName("52hPrice")
        private int value52hPrice;
        @SerializedName("52lPrice")
        private double value52lPrice;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getOpenningPrice() {
            return openningPrice;
        }

        public void setOpenningPrice(double openningPrice) {
            this.openningPrice = openningPrice;
        }

        public double getClosingPrice() {
            return closingPrice;
        }

        public void setClosingPrice(double closingPrice) {
            this.closingPrice = closingPrice;
        }

        public double getHPrice() {
            return hPrice;
        }

        public void setHPrice(double hPrice) {
            this.hPrice = hPrice;
        }

        public double getLPrice() {
            return lPrice;
        }

        public void setLPrice(double lPrice) {
            this.lPrice = lPrice;
        }

        public double getCurrentPrice() {
            return currentPrice;
        }

        public void setCurrentPrice(double currentPrice) {
            this.currentPrice = currentPrice;
        }

        public double getGrowth() {
            return growth;
        }

        public void setGrowth(double growth) {
            this.growth = growth;
        }

        public double getGrowthPercent() {
            return growthPercent;
        }

        public void setGrowthPercent(double growthPercent) {
            this.growthPercent = growthPercent;
        }

        public int getDealnumber() {
            return dealnumber;
        }

        public void setDealnumber(int dealnumber) {
            this.dealnumber = dealnumber;
        }

        public int getTurnover() {
            return turnover;
        }

        public void setTurnover(int turnover) {
            this.turnover = turnover;
        }

        public int getValue52hPrice() {
            return value52hPrice;
        }

        public void setValue52hPrice(int value52hPrice) {
            this.value52hPrice = value52hPrice;
        }

        public double getValue52lPrice() {
            return value52lPrice;
        }

        public void setValue52lPrice(double value52lPrice) {
            this.value52lPrice = value52lPrice;
        }
    }

    public static class MarketBean {
        /**
         * name : 上证指数
         * curdot : 3655.265
         * curprice : -7.737
         * rate : -0.21
         * dealnumber : 2200597
         * turnover : 28321565
         */

        private ShanghaiBean shanghai;
        /**
         * name : 深证成指
         * curdot : 12262.868
         * curprice : -53.908
         * rate : -0.44
         * dealnumber : 150072036
         * turnover : 26837342
         */

        private ShenzhenBean shenzhen;
        /**
         * name : 道琼斯
         * date : 2015-07-29 05:28:06
         * curdot : 17630.27
         * rate : 1.09
         * growth : 189.68
         * startdot : 17561.78
         * closedot : 17440.59
         * hdot : 17561.78
         * ldot : 17399.17
         * turnover : 0
         */

        private DJIBean DJI;
        /**
         * name : 纳斯达克
         * date : 2015-07-29 05:39:57
         * curdot : 5089.21
         * rate : 0.98
         * growth : 49.43
         * startdot : 5063.44
         * closedot : 5039.78
         * hdot : 5097.69
         * ldot : 5025.61
         * turnover : 2013976426
         */

        private IXICBean IXIC;
        /**
         * name : 纳斯达克
         * date : 2015-07-29 05:39:57
         * curdot : 2093.25
         * rate : 1.24
         * growth : 25.61
         * startdot : 2070.75
         * closedot : 2067.64
         * hdot : 2095.6
         * ldot : 2069.09
         * turnover : 0
         */

        private INXBean INX;
        /**
         * name : 恒生指数
         * date : 2015/07/29 12:05
         * curdot : 24515.8
         * rate : 0.05
         * growth : 11.86
         * startdot : 24630.44
         * closedot : 24503.94
         * hdot : 24718.64
         * ldot : 24468.55
         * turnover : 43951640
         * 52hdot : 28588.52
         * 52ldot : 22529.75
         */

        private HSIBean HSI;

        public ShanghaiBean getShanghai() {
            return shanghai;
        }

        public void setShanghai(ShanghaiBean shanghai) {
            this.shanghai = shanghai;
        }

        public ShenzhenBean getShenzhen() {
            return shenzhen;
        }

        public void setShenzhen(ShenzhenBean shenzhen) {
            this.shenzhen = shenzhen;
        }

        public DJIBean getDJI() {
            return DJI;
        }

        public void setDJI(DJIBean DJI) {
            this.DJI = DJI;
        }

        public IXICBean getIXIC() {
            return IXIC;
        }

        public void setIXIC(IXICBean IXIC) {
            this.IXIC = IXIC;
        }

        public INXBean getINX() {
            return INX;
        }

        public void setINX(INXBean INX) {
            this.INX = INX;
        }

        public HSIBean getHSI() {
            return HSI;
        }

        public void setHSI(HSIBean HSI) {
            this.HSI = HSI;
        }

        public static class ShanghaiBean {
            private String name;
            private double curdot;
            private double curprice;
            private double rate;
            private int dealnumber;
            private int turnover;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getCurdot() {
                return curdot;
            }

            public void setCurdot(double curdot) {
                this.curdot = curdot;
            }

            public double getCurprice() {
                return curprice;
            }

            public void setCurprice(double curprice) {
                this.curprice = curprice;
            }

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public int getDealnumber() {
                return dealnumber;
            }

            public void setDealnumber(int dealnumber) {
                this.dealnumber = dealnumber;
            }

            public int getTurnover() {
                return turnover;
            }

            public void setTurnover(int turnover) {
                this.turnover = turnover;
            }
        }

        public static class ShenzhenBean {
            private String name;
            private double curdot;
            private double curprice;
            private double rate;
            private int dealnumber;
            private int turnover;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getCurdot() {
                return curdot;
            }

            public void setCurdot(double curdot) {
                this.curdot = curdot;
            }

            public double getCurprice() {
                return curprice;
            }

            public void setCurprice(double curprice) {
                this.curprice = curprice;
            }

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public int getDealnumber() {
                return dealnumber;
            }

            public void setDealnumber(int dealnumber) {
                this.dealnumber = dealnumber;
            }

            public int getTurnover() {
                return turnover;
            }

            public void setTurnover(int turnover) {
                this.turnover = turnover;
            }
        }

        public static class DJIBean {
            private String name;
            private String date;
            private double curdot;
            private double rate;
            private double growth;
            private double startdot;
            private double closedot;
            private double hdot;
            private double ldot;
            private int turnover;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public double getCurdot() {
                return curdot;
            }

            public void setCurdot(double curdot) {
                this.curdot = curdot;
            }

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public double getGrowth() {
                return growth;
            }

            public void setGrowth(double growth) {
                this.growth = growth;
            }

            public double getStartdot() {
                return startdot;
            }

            public void setStartdot(double startdot) {
                this.startdot = startdot;
            }

            public double getClosedot() {
                return closedot;
            }

            public void setClosedot(double closedot) {
                this.closedot = closedot;
            }

            public double getHdot() {
                return hdot;
            }

            public void setHdot(double hdot) {
                this.hdot = hdot;
            }

            public double getLdot() {
                return ldot;
            }

            public void setLdot(double ldot) {
                this.ldot = ldot;
            }

            public int getTurnover() {
                return turnover;
            }

            public void setTurnover(int turnover) {
                this.turnover = turnover;
            }
        }

        public static class IXICBean {
            private String name;
            private String date;
            private double curdot;
            private double rate;
            private double growth;
            private double startdot;
            private double closedot;
            private double hdot;
            private double ldot;
            private int turnover;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public double getCurdot() {
                return curdot;
            }

            public void setCurdot(double curdot) {
                this.curdot = curdot;
            }

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public double getGrowth() {
                return growth;
            }

            public void setGrowth(double growth) {
                this.growth = growth;
            }

            public double getStartdot() {
                return startdot;
            }

            public void setStartdot(double startdot) {
                this.startdot = startdot;
            }

            public double getClosedot() {
                return closedot;
            }

            public void setClosedot(double closedot) {
                this.closedot = closedot;
            }

            public double getHdot() {
                return hdot;
            }

            public void setHdot(double hdot) {
                this.hdot = hdot;
            }

            public double getLdot() {
                return ldot;
            }

            public void setLdot(double ldot) {
                this.ldot = ldot;
            }

            public int getTurnover() {
                return turnover;
            }

            public void setTurnover(int turnover) {
                this.turnover = turnover;
            }
        }

        public static class INXBean {
            private String name;
            private String date;
            private double curdot;
            private double rate;
            private double growth;
            private double startdot;
            private double closedot;
            private double hdot;
            private double ldot;
            private int turnover;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public double getCurdot() {
                return curdot;
            }

            public void setCurdot(double curdot) {
                this.curdot = curdot;
            }

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public double getGrowth() {
                return growth;
            }

            public void setGrowth(double growth) {
                this.growth = growth;
            }

            public double getStartdot() {
                return startdot;
            }

            public void setStartdot(double startdot) {
                this.startdot = startdot;
            }

            public double getClosedot() {
                return closedot;
            }

            public void setClosedot(double closedot) {
                this.closedot = closedot;
            }

            public double getHdot() {
                return hdot;
            }

            public void setHdot(double hdot) {
                this.hdot = hdot;
            }

            public double getLdot() {
                return ldot;
            }

            public void setLdot(double ldot) {
                this.ldot = ldot;
            }

            public int getTurnover() {
                return turnover;
            }

            public void setTurnover(int turnover) {
                this.turnover = turnover;
            }
        }

        public static class HSIBean {
            private String name;
            private String date;
            private double curdot;
            private double rate;
            private double growth;
            private double startdot;
            private double closedot;
            private double hdot;
            private double ldot;
            private int turnover;
            @SerializedName("52hdot")
            private double value52hdot;
            @SerializedName("52ldot")
            private double value52ldot;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public double getCurdot() {
                return curdot;
            }

            public void setCurdot(double curdot) {
                this.curdot = curdot;
            }

            public double getRate() {
                return rate;
            }

            public void setRate(double rate) {
                this.rate = rate;
            }

            public double getGrowth() {
                return growth;
            }

            public void setGrowth(double growth) {
                this.growth = growth;
            }

            public double getStartdot() {
                return startdot;
            }

            public void setStartdot(double startdot) {
                this.startdot = startdot;
            }

            public double getClosedot() {
                return closedot;
            }

            public void setClosedot(double closedot) {
                this.closedot = closedot;
            }

            public double getHdot() {
                return hdot;
            }

            public void setHdot(double hdot) {
                this.hdot = hdot;
            }

            public double getLdot() {
                return ldot;
            }

            public void setLdot(double ldot) {
                this.ldot = ldot;
            }

            public int getTurnover() {
                return turnover;
            }

            public void setTurnover(int turnover) {
                this.turnover = turnover;
            }

            public double getValue52hdot() {
                return value52hdot;
            }

            public void setValue52hdot(double value52hdot) {
                this.value52hdot = value52hdot;
            }

            public double getValue52ldot() {
                return value52ldot;
            }

            public void setValue52ldot(double value52ldot) {
                this.value52ldot = value52ldot;
            }
        }
    }
}

