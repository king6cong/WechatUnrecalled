package com.fkzhang.wechatunrecalled;

/**
 * Created by fkzhang on 1/16/2016.
 */
public class WechatPackageNames {
    public String packageNameBase;
    public String recallClass;
    public String packageName;
    public String recallMethod;
    public String snsClass;
    public String snsMethod;
    public String dbClass1;
    public String dbMethod1;
    public String dbField;
    public String dbMethod2;
    public String updateMsgId;
    public String contextGetter;
    public String iconClass;
    public String iconMethod;
    public String imageClass;
    public String imageMethod1;
    public String imageMethod2;
    public String avatarClass;
    public String avatarMethod1;
    public String avatarMethod2;
    public String blobDecodeMethod;
    public String commentContentField;
    public String commentClass;
    public String commentTimeField;
    public String snsContentClass;
    public String snsContentField;
    public String luckyRevealImageView;
    public String snsAttrClass;
    public String snsAttrField;
    public String snsLuckyMoneyClass1;
    public String snsLuckyMoneyBlur;
    public String snsLuckyMoneyOrignal;
    public String snsLuckyMoneyClass2;

    public WechatPackageNames(String packageName, String versionName) {
        this.packageName = packageName;
        this.packageNameBase = packageName.substring(0, packageName.lastIndexOf("."));

        initNames();
        if (versionName.contains("6.3.13")) {
            set6313();
        } else if (versionName.contains("6.3.11")) {
            set6311();
        } else if (versionName.contains("6.3.9")) {
            set639();
        } else if (versionName.contains("6.3.8")) {
            set638();
        } else if (versionName.contains("6.3.5")) {
            set635();
        } else if (versionName.contains("6.3.0")) {
            set630();
        } else if (versionName.contains("6.2.5")) {
            set625();
        } else if (versionName.contains("6.0.0")) {
            set600();
        }
    }

    private void set600() {
        recallClass += "u";
        recallMethod = "D";
        snsClass += "d.g";
        snsMethod += "g.af";
        dbClass1 += "bh";
        dbMethod1 = "sS";
        dbMethod2 = "qQ";
        dbField = "dGo";
        contextGetter += "ai";
        iconClass += ".booter.notification.a.d";
        iconMethod = "mX";
        imageClass += ".z.ar";
        imageMethod1 = "zZ";
        imageMethod2 = "g";
        avatarClass += ".p.af";
        avatarMethod1 = "uQ";
        avatarMethod2 = "b";
        commentClass += "aaq";
        blobDecodeMethod = "m";
        commentContentField = "fWd";
        snsContentClass += "adq";
        snsContentField = "iZr";
        snsAttrClass += "abb";
        snsAttrField = "iWH";
        commentTimeField = "iuc";
    }

    private void set625() {
        recallClass += "p";
        recallMethod = "B";
        snsClass += "g.l";
        snsMethod += "g.d";
        dbClass1 += "ah";
        dbMethod1 = "tI";
        dbMethod2 = "rG";
        dbField = "bvg";
        updateMsgId = "aNG";
        contextGetter += "x";
        iconClass += ".am.a";
        iconMethod = "aDA";
        imageClass += ".z.n";
        imageMethod1 = "Ao";
        imageMethod2 = "hs";
        avatarClass += ".p.n";
        avatarMethod1 = "vC";
        avatarMethod2 = "b";
        commentClass += "alf";
        blobDecodeMethod = "ag";
        commentContentField = "eGr";
        snsContentClass += "aok";
        snsContentField = "ixy";
        snsAttrClass += "alr";
        snsAttrField = "ivq";
        commentTimeField = "eDv";
    }

    private void set630() {
        recallClass += "q";
        recallMethod = "C";
        snsClass += "h.l";
        snsMethod += "g.d";
        dbClass1 += "ah";
        dbMethod1 = "tL";
        dbMethod2 = "rJ";
        dbField = "bts";
        updateMsgId = "aPp";
        contextGetter += "y";
        iconClass += ".an.a";
        iconMethod = "aFK";
        imageClass += ".z.n";
        imageMethod1 = "Ar";
        imageMethod2 = "hv";
        avatarClass += ".p.n";
        avatarMethod1 = "vF";
        avatarMethod2 = "b";
        commentClass += "alx";
        blobDecodeMethod = "aj";
        commentContentField = "eNl";
        snsContentClass += "apb";
        snsContentField = "iIM";
        snsAttrClass += "amj";
        snsAttrField = "iGA";
        commentTimeField = "eKp";
    }

    private void set635() {
        recallClass += "q";
        recallMethod = "C";
        snsClass += "h.l";
        snsMethod += "g.d";
        dbClass1 += "ai";
        dbMethod1 = "tO";
        dbMethod2 = "rM";
        dbField = "bts";
        updateMsgId = "aPy";
        contextGetter += "y";
        iconClass += ".an.a";
        iconMethod = "aFT";
        imageClass += ".z.n";
        imageMethod1 = "Aw";
        imageMethod2 = "hv";
        avatarClass += ".p.n";
        avatarMethod1 = "vI";
        avatarMethod2 = "b";
        commentClass += "alx";
        blobDecodeMethod = "ak";
        commentContentField = "eNp";
        snsContentClass += "apb";
        snsContentField = "iIO";
        snsAttrClass += "amj";
        snsAttrField = "iGC";
        commentTimeField = "eKt";
    }

    private void set638() {
        recallClass += "r";
        recallMethod = "I";
        snsClass += "h.l";
        snsMethod += "g.d";
        dbClass1 += "ah";
        dbMethod1 = "tl";
        dbMethod2 = "rj";
        dbField = "bww";
        updateMsgId = "aTT";
        contextGetter += "z";
        iconClass += ".an.a";
        iconMethod = "aKh";
        imageClass += ".z.n";
        imageMethod1 = "zV";
        imageMethod2 = "hC";
        avatarClass += ".p.n";
        avatarMethod1 = "vf";
        avatarMethod2 = "b";
        commentClass += "aoq";
        blobDecodeMethod = "ak";
        commentContentField = "fdy";
        snsContentClass += "asd";
        snsContentField = "jjP";
        snsAttrClass += "apc";
        snsAttrField = "jhw";
        commentTimeField = "faB";
    }

    private void set639() {
        recallClass += "q";
        recallMethod = "J";
        snsClass += "h.l";
        snsMethod += "h.d";
        dbClass1 += "ah";
        dbMethod1 = "tr";
        dbMethod2 = "rk";
        dbField = "bzj";
        updateMsgId = "aVP";
        contextGetter += "y";
        iconClass += ".ap.a";
        iconMethod = "aMW";
        imageClass += ".aa.n";
        imageMethod1 = "zZ";
        imageMethod2 = "hF";
        avatarClass += ".q.n";
        avatarMethod1 = "vi";
        avatarMethod2 = "b";
        commentClass += "api";
        blobDecodeMethod = "al";
        commentContentField = "fmw";
        snsContentClass += "asz";
        snsContentField = "jBA";
        snsAttrClass += "apw";
        snsAttrField = "jzc";
        commentTimeField = "fjz";
        luckyRevealImageView = this.packageName +
                ".plugin.sns.lucky.ui.LuckyRevealImageView";
    }


    private void set6311() {
        recallClass += "q";
        recallMethod = "J";
        snsClass += "h.l";
        snsMethod += "h.d";
        dbClass1 += "ah";
        dbMethod1 = "tD";
        dbMethod2 = "rs";
        dbField = "bCw";// look for: ah.tD().rs() or in com.tencent.mm.storage.ah
        updateMsgId = "aXP";
        contextGetter += "y";
        iconClass += ".aq.a";
        iconMethod = "aOQ";
        imageClass += ".ab.n";
        imageMethod1 = "Ao";
        imageMethod2 = "hM";
        avatarClass += ".q.n";
        avatarMethod1 = "vu";
        avatarMethod2 = "b";
        commentClass += "apu";
        blobDecodeMethod = "am";
        commentContentField = "fsI";
        snsContentClass += "atp";
        snsContentField = "jMu";
        snsAttrClass += "aqi";
        snsAttrField = "jJX";
        commentTimeField = "fpL";
        luckyRevealImageView = this.packageName +
                ".plugin.sns.lucky.ui.LuckyRevealImageView";
    }

    private void set6313() {
        set6311();
        luckyRevealImageView = "";
        snsLuckyMoneyClass1 = packageName + ".plugin.sns.data.h";
        snsLuckyMoneyClass2 += "add";
        snsLuckyMoneyOrignal = "h";
        snsLuckyMoneyBlur = "g";
    }

    private void initNames() {
        recallClass = this.packageName + ".sdk.platformtools.";
        recallMethod = "";
        snsClass = this.packageName + ".plugin.sns.";
        snsMethod = this.packageName + ".sdk.";
        dbClass1 = this.packageName + ".model.";
        dbMethod1 = "";
        dbMethod2 = "";
        dbField = "";
        updateMsgId = "";
        contextGetter = recallClass;
        iconClass = this.packageName;
        iconMethod = "";
        imageClass = this.packageName;
        imageMethod1 = "";
        imageMethod2 = "";
        avatarClass = this.packageName;
        avatarMethod1 = "";
        avatarMethod2 = "";
        commentClass = this.packageName + ".protocal.b.";
        blobDecodeMethod = "";
        commentContentField = "";
        commentTimeField = "";
        snsContentClass = commentClass;
        snsContentField = "";
        snsAttrClass = commentClass;
        snsAttrField = "";
        luckyRevealImageView = "";
        snsLuckyMoneyClass1 = "";
        snsLuckyMoneyOrignal = "";
        snsLuckyMoneyBlur = "";
        snsLuckyMoneyClass2 = packageName + ".protocal.b.";
    }
}
