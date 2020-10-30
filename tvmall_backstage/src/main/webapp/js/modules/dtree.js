layui.define(["jquery", "layer", "form"],
    function(e) {
        var y = layui.$,
            f = layui.layer,
            r = layui.form,
            m = "dtree-nav-ul-sid",
            k = "dtree-nav-item",
            S = "dtree-nav-div",
            v = "dtreefont-special",
            t = "dtree-toolbar",
            g = "dtree-toolbar-tool",
            l = "dtree-toolbar-fixed",
            D = "dtree-nav-checkbox-div",
            N = "d-click-checkbar",
            n = "t-click",
            c = "dtree",
            s = "dtree-nav-first-line",
            d = "dtree-nav-line",
            h = "dtree-nav-last-line",
            i = "dtree-nav-this",
            C = "dtree-nav-show",
            x = "dtree-nav-hide",
            T = "dtree-disabled",
            I = "dtree-icon-hide",
            o = y("body"),
            u = "dtree",
            a = {},
            p = "dtree-icon-fuxuankuangxuanzhong",
            b = "dtree-icon-fuxuankuang",
            j = "dtree-icon-fuxuankuang-banxuan",
            P = "dtree-icon-move-down",
            A = "dtree-icon-move-up",
            w = "dtree-icon-refresh",
            q = "dtree-icon-roundcheckfill",
            L = "dtree-icon-roundclosefill",
            R = "dtree-icon-roundcheck",
            O = "dtree-icon-delete1",
            E = "dtree-icon-search_list_light",
            F = "dtree-icon-pulldown",
            M = "dtree-icon-pullup",
            _ = "dtree-icon-roundadd",
            U = "dtree-icon-bianji",
            B = "dtree-icon-roundclose",
            W = {
                "-1": {
                    open: "dtree-icon-null-open",
                    close: "dtree-icon-null-close"
                },
                0 : {
                    open: "dtree-icon-wenjianjiazhankai",
                    close: "dtree-icon-weibiaoti5"
                },
                1 : {
                    open: "dtree-icon-jian",
                    close: "dtree-icon-jia"
                },
                2 : {
                    open: "dtree-icon-xiangxia1",
                    close: "dtree-icon-xiangyou"
                }
            },
            H = {
                "-1": "dtree-icon-null",
                0 : "dtree-icon-weibiaoti5",
                1 : "dtree-icon-yonghu",
                2 : "dtree-icon-fenzhijigou",
                3 : "dtree-icon-fenguangbaobiao",
                4 : "dtree-icon-xinxipilu",
                5 : "dtree-icon-shuye1",
                6 : "dtree-icon-caidan_xunzhang",
                7 : "dtree-icon-normal-file",
                8 : "dtree-icon-dian",
                9 : "dtree-icon-set-sm",
                10 : "dtree-icon-rate"
            },
            $ = "dtree-",
            J = "checkNodeClick",
            z = "itemNodeClick",
            G = "pulldown",
            X = "pullup",
            K = "addToolbar",
            Q = "editToolbar",
            V = "delToolbar",
            Y = "moveDown",
            Z = "moveUp",
            ee = "refresh",
            te = "checkAll",
            oe = "unCheckAll",
            ae = "invertAll",
            ie = "remove",
            ne = "searchNode",
            se = {
                getElemId: function(e) {
                    var t = e.elem || "",
                        o = e.obj || y(t);
                    return 0 == o.length ? "": y(o)[0].id
                },
                escape: function(e) {
                    return "string" != typeof e ? "": e.replace(de.escape,
                        function(e) {
                            return le.escape[e]
                        })
                },
                unescape: function(e) {
                    return "string" != typeof e ? "": e.replace(de.unescape,
                        function(e) {
                            return le.unescape[e]
                        })
                },
                cloneObj: function(e, t) {
                    var o = {};
                    e instanceof Array && (o = []);
                    var a = "";
                    for (var i in void 0 !== t && (a = t.join(",")), e) if ( - 1 == a.indexOf(i)) {
                        var n = e[i];
                        o[i] = "object" == typeof n ? se.cloneObj(n, void 0 !== typeof t ? t: []) : n
                    }
                    return o
                },
                trimToDot: function(e) {
                    return e.replace(/ /g, ".")
                }
            },
            re = Object.keys ||
                function(e) {
                    e = Object(e);
                    var t = [];
                    for (var o in e) t.push(o);
                    return t
                },
            le = {
                escape: {
                    "&": "&amp;",
                    "<": "&lt;",
                    ">": "&gt;",
                    "'": "&quo;"
                }
            };
        le.unescape = function(e) {
            e = Object(e);
            var t = {};
            for (var o in e) t[e[o]] = o;
            return t
        } (le.escape);
        var de = {
                escape: RegExp("[" + re(le.escape).join("") + "]", "g"),
                unescape: RegExp("(" + re(le.unescape).join("|") + ")", "g")
            },
            ce = function(a) {
                var e = a.data ? a.data: {},
                    t = "boolean" != typeof a.async || a.async;
                y.ajax({
                    type: a.type ? a.type: "POST",
                    headers: a.headers,
                    url: a.url,
                    dataType: a.dataType ? a.dataType: "json",
                    data: e,
                    async: t,
                    contentType: a.contentType ? a.contentType: "application/x-www-form-urlencoded",
                    success: a.success,
                    error: function(e, t, o) {
                        "function" == typeof a.error ? a.error(e, t, o) : f.msg("异步加载失败： " + t, {
                            icon: 5,
                            shift: 6
                        })
                    },
                    statusCode: {
                        404 : function() {
                            f.msg("未找到指定请求，请检查访问路径！", {
                                icon: 5,
                                shift: 6
                            })
                        },
                        500 : function() {
                            f.msg("系统错误！", {
                                icon: 5,
                                shift: 6
                            })
                        }
                    },
                    complete: function(e, t) {
                        "function" == typeof a.complete && a.complete(e, t)
                    }
                })
            },
            he = function(e) {
                var t = "?";
                for (var o in e) t += o + "=" + e[o] + "&";
                return t = t.substring(0, t.length - 1)
            },
            ue = function(e) {
                this.formatter = {
                    title: !1
                },
                    this.response = {
                        statusName: "code",
                        statusCode: 200,
                        message: "message",
                        rootName: "data",
                        treeId: "id",
                        parentId: "parentId",
                        title: "title",
                        ficonClass: "ficonClass",
                        iconClass: "iconClass",
                        childName: "children",
                        last: "last",
                        spread: "spread",
                        disabled: "disabled",
                        hide: "hide",
                        checkArr: "checkArr",
                        checked: "checked",
                        type: "type",
                        basicData: "basicData"
                    },
                    this.defaultRequest = {
                        nodeId: "nodeId",
                        parentId: "parentId",
                        context: "context",
                        leaf: "leaf",
                        level: "level",
                        spread: "spread",
                        dataType: "dataType",
                        checked: "checked",
                        initchecked: "initchecked",
                        basicData: "basicData",
                        recordData: "recordData"
                    },
                    this.toolbarFun = {
                        addTreeNode: function(e, t) {},
                        editTreeNode: function(e, t) {},
                        editTreeLoad: function(e) {},
                        delTreeNode: function(e, t) {},
                        loadToolbarBefore: function(e, t, o) {
                            return e
                        }
                    },
                    this.toolbarStyle = {
                        title: "节点",
                        area: ["60%", "80%"]
                    },
                    this.menubarFun = {
                        remove: function(e) {
                            return ! 0
                        }
                    },
                    this.menubarTips = {
                        toolbar: [],
                        group: [Y, Z, ee, te, oe, ae, ie, ne],
                        freedom: []
                    },
                    this.checkbarFun = {
                        chooseBefore: function(e, t) {
                            return ! 0
                        },
                        chooseDone: function(e) {}
                    },
                    this.iframe = {
                        iframeElem: "",
                        iframeUrl: "",
                        iframeLoad: "leaf",
                        iframeDefaultRequest: {
                            nodeId: "nodeId",
                            parentId: "parentId",
                            context: "context",
                            leaf: "leaf",
                            level: "level",
                            spread: "spread",
                            dataType: "dataType",
                            checked: "checked",
                            initchecked: "initchecked",
                            basicData: "basicData",
                            recordData: "recordData"
                        },
                        iframeRequest: {}
                    },
                    this.iframeFun = {
                        iframeDone: function(e) {}
                    },
                    this.style = {
                        item: "",
                        itemThis: "",
                        dfont: "",
                        icon: "",
                        cbox: "",
                        chs: ""
                    },
                    this.usefontStyle = {
                        fnode: {
                            node: {
                                open: "",
                                close: ""
                            },
                            leaf: ""
                        },
                        snode: {
                            node: {
                                open: "",
                                close: ""
                            },
                            leaf: ""
                        },
                        checkbox: {
                            on: "",
                            out: "",
                            noall: ""
                        },
                        menubar: {
                            movedown: "",
                            moveup: "",
                            refresh: "",
                            checkAll: "",
                            unCheckAll: "",
                            invertAll: "",
                            remove: "",
                            search: ""
                        },
                        menubarExt: "",
                        toolbar: {
                            menubar: {
                                movedown: "",
                                moveup: "",
                                refresh: "",
                                checkAll: "",
                                unCheckAll: "",
                                invertAll: "",
                                remove: "",
                                search: ""
                            },
                            menubarExt: "",
                            pulldown: "",
                            pullup: "",
                            add: "",
                            edit: "",
                            del: ""
                        },
                        toolbarExt: ""
                    },
                    this.node = {
                        nodeId: "",
                        parentId: "",
                        context: "",
                        leaf: "",
                        level: "",
                        spread: "",
                        dataType: "",
                        checked: "",
                        initchecked: "",
                        basicData: "",
                        recordData: ""
                    },
                    this.toolbarMenu = {},
                    this.checkbarNode = [],
                    this.errData = [],
                    this.checkArrLen = 0,
                    this.temp = [],
                    this.setting(e)
            };
        ue.prototype.setting = function(e) {
            this.options = e || {},
                this.elem = this.options.elem || "",
                this.obj = this.options.obj || y(this.elem),
                this.accordion = "boolean" == typeof this.options.accordion && this.options.accordion,
                this.accordion ? this.initLevel = 1 : this.initLevel = this.options.initLevel || 2,
                this.type = this.options.type || "load",
                this.cache = "boolean" != typeof this.options.cache || this.options.cache,
                this.record = "boolean" == typeof this.options.record && this.options.record,
                this.load = "boolean" != typeof this.options.load || this.options.load,
                this.none = this.options.none || "无数据",
                this.iconfont = this.options.iconfont || "dtreefont",
                this.iconfontStyle = this.options.iconfontStyle || {},
                this.nodeIconArray = y.extend(W, this.options.nodeIconArray) || W,
                this.leafIconArray = y.extend(H, this.options.leafIconArray) || H,
                this.skin = this.options.skin || "theme",
                "layui" == this.skin ? (this.line = "boolean" != typeof this.options.line || this.options.line, this.ficon = this.options.ficon || "7", this.fnodeIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? "-1" == this.ficon ? "-1": "1": this.ficon[0], this.fleafIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? this.ficon: this.ficon[1], this.icon = this.options.icon || "-1", this.nodeIcon = "string" == typeof this.icon || "number" == typeof this.icon ? (this.icon, "-1") : this.icon[0]) : "laySimple" == this.skin ? (this.line = "boolean" == typeof this.options.line && this.options.line, this.ficon = this.options.ficon || ["2", "-1"], this.fnodeIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? "-1" == this.ficon ? "-1": "2": this.ficon[0], this.fleafIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? this.ficon: this.ficon[1], this.icon = this.options.icon || "-1", this.nodeIcon = "string" == typeof this.icon || "number" == typeof this.icon ? (this.icon, "-1") : this.icon[0]) : (this.line = "boolean" == typeof this.options.line && this.options.line, this.ficon = this.options.ficon || "8", this.fnodeIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? "-1" == this.ficon ? "-1": "1": this.ficon[0], this.fleafIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? this.ficon: this.ficon[1], this.icon = this.options.icon || "5", this.nodeIcon = "string" == typeof this.icon || "number" == typeof this.icon ? "-1" == this.icon ? "-1": "0": this.icon[0]),
                this.leafIcon = "string" == typeof this.icon || "number" == typeof this.icon ? this.icon: this.icon[1],
                this.url = this.options.url || "",
                this.async = "boolean" != typeof this.options.async || this.options.async,
                this.headers = this.options.headers || {},
                this.method = this.options.method || "post",
                this.dataType = this.options.dataType || "json",
                this.contentType = this.options.contentType || "application/x-www-form-urlencoded",
                this.defaultRequest = y.extend(this.defaultRequest, this.options.defaultRequest) || this.defaultRequest,
                this.filterRequest = this.options.filterRequest || [],
                this.request = this.options.request || {},
                this.response = y.extend(this.response, this.options.response) || this.response,
                this.data = this.options.data || null,
                this.dataFormat = this.options.dataFormat || "levelRelationship",
                this.dataStyle = this.options.dataStyle || "defaultStyle",
                this.errDataShow = "boolean" == typeof this.options.errDataShow && this.options.errDataShow,
                this.success = this.options.success ||
                    function(e, t) {},
                this.done = this.options.done ||
                    function(e, t) {},
                this.formatter = y.extend(this.formatter, this.options.formatter) || this.formatter,
                this.error = this.options.error ||
                    function(e, t, o) {
                        f.msg(t, {
                            icon: 2
                        })
                    },
                this.complete = this.options.complete ||
                    function(e, t) {},
                this.checkbar = this.options.checkbar || !1,
                this.checkbarLoad = this.options.checkbarLoad || "node",
                this.checkbarType = this.options.checkbarType || "all",
                this.checkbarData = this.options.checkbarData || "choose",
                this.checkbarFun = y.extend(this.checkbarFun, this.options.checkbarFun) || this.checkbarFun,
                this.menubar = this.options.menubar || !1,
                this.menubarTips = y.extend(this.menubarTips, this.options.menubarTips) || this.menubarTips,
                this.menubarFun = y.extend(this.menubarFun, this.options.menubarFun) || this.menubarFun,
                this.toolbar = this.options.toolbar || !1,
                this.toolbarWay = this.options.toolbarWay || "contextmenu",
                this.toolbarStyle = y.extend(this.toolbarStyle, this.options.toolbarStyle) || this.toolbarStyle,
                this.toolbarScroll = this.options.toolbarScroll || this.elem,
                this.toolbarLoad = this.options.toolbarLoad || "node",
                this.toolbarShow = this.options.toolbarShow || ["add", "edit", "delete"],
                this.toolbarBtn = this.options.toolbarBtn || null,
                this.toolbarExt = this.options.toolbarExt || [],
                this.toolbarFun = y.extend(this.toolbarFun, this.options.toolbarFun) || this.toolbarFun,
                this.useIframe = this.options.useIframe || !1,
            this.options.iframe && (this.iframe.iframeElem = this.options.iframe.iframeElem || this.iframe.iframeElem, this.iframe.iframeUrl = this.options.iframe.iframeUrl || this.iframe.iframeUrl, this.iframe.iframeLoad = this.options.iframe.iframeLoad || this.iframe.iframeLoad, this.iframe.iframeDefaultRequest = y.extend(this.iframe.iframeDefaultRequest, this.options.iframe.iframeDefaultRequest) || this.iframe.iframeDefaultRequest, this.iframe.iframeRequest = y.extend(this.iframe.iframeRequest, this.options.iframe.iframeRequest) || this.iframe.iframeRequest),
                this.iframeFun = y.extend(this.iframeFun, this.options.iframeFun) || this.iframeFun,
                this.drawable = "boolean" == typeof this.options.drawable && this.options.drawable,
                this.ensureTheme()
        },
            ue.prototype.reloadSetting = function(e) {
                this.options = y.extend(this.options, e) || this.options,
                    this.elem = this.options.elem || this.elem,
                    void 0 === this.options.obj ? this.elem && 0 < y(this.elem).length && (this.obj = y(this.elem)) : this.obj = this.options.obj || this.obj,
                    this.accordion = "boolean" == typeof this.options.accordion ? this.options.accordion: this.accordion,
                    this.accordion ? this.initLevel = 1 : this.initLevel = this.options.initLevel || this.initLevel,
                    this.type = this.options.type || this.type,
                    this.cache = "boolean" == typeof this.options.cache ? this.options.cache: this.cache,
                    this.record = "boolean" == typeof this.options.record ? this.options.record: this.record,
                    this.load = "boolean" == typeof this.options.load ? this.options.load: this.load,
                    this.none = this.options.none || this.none,
                    this.line = "boolean" == typeof this.options.line ? this.options.line: this.line,
                    this.iconfont = this.options.iconfont || this.iconfont,
                    this.iconfontStyle = this.options.iconfontStyle || this.iconfontStyle,
                    this.nodeIconArray = y.extend(W, this.options.nodeIconArray) || this.nodeIconArray,
                    this.leafIconArray = y.extend(H, this.options.leafIconArray) || this.leafIconArray,
                    this.skin = this.options.skin || this.skin,
                    "layui" == this.skin ? (this.line = "boolean" != typeof this.options.line || this.options.line, this.ficon = this.options.ficon || this.ficon, this.fnodeIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? "-1" == this.ficon ? "-1": "1": this.ficon[0], this.fleafIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? this.ficon: this.ficon[1], this.icon = this.options.icon || this.icon, this.nodeIcon = "string" == typeof this.icon || "number" == typeof this.icon ? (this.icon, "-1") : this.icon[0]) : "laySimple" == this.skin ? (this.line = "boolean" == typeof this.options.line && this.options.line, this.ficon = this.options.ficon || this.ficon, this.fnodeIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? "-1" == this.ficon ? "-1": "2": this.ficon[0], this.fleafIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? this.ficon: this.ficon[1], this.icon = this.options.icon || this.icon, this.nodeIcon = "string" == typeof this.icon || "number" == typeof this.icon ? (this.icon, "-1") : this.icon[0]) : (this.line = "boolean" == typeof this.options.line && this.options.line, this.ficon = this.options.ficon || this.ficon, this.fnodeIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? "-1" == this.ficon ? "-1": "1": this.ficon[0], this.fleafIcon = "string" == typeof this.ficon || "number" == typeof this.ficon ? this.ficon: this.ficon[1], this.icon = this.options.icon || this.icon, this.nodeIcon = "string" == typeof this.icon || "number" == typeof this.icon ? "-1" == this.icon ? "-1": "0": this.icon[0]),
                    this.leafIcon = "string" == typeof this.icon || "number" == typeof this.icon ? this.icon: this.icon[1],
                    this.url = this.options.url || this.url,
                    this.async = "boolean" == typeof this.options.async ? this.options.async: this.async,
                    this.headers = this.options.headers || this.headers,
                    this.method = this.options.method || this.method,
                    this.dataType = this.options.dataType || this.dataType,
                    this.contentType = this.options.contentType || this.contentType,
                    this.defaultRequest = y.extend(this.defaultRequest, this.options.defaultRequest) || this.defaultRequest,
                    this.filterRequest = this.options.filterRequest || this.filterRequest,
                    this.request = this.options.request || this.request,
                    this.response = y.extend(this.response, this.options.response) || this.response,
                    this.data = this.options.data || this.data,
                    this.dataFormat = this.options.dataFormat || this.dataFormat,
                    this.dataStyle = this.options.dataStyle || this.dataStyle,
                    this.errDataShow = "boolean" == typeof this.options.errDataShow ? this.options.errDataShow: this.errDataShow,
                    this.success = this.options.success || this.success,
                    this.done = this.options.done || this.done,
                    this.formatter = y.extend(this.formatter, this.options.formatter) || this.formatter,
                    this.error = this.options.error || this.error,
                    this.complete = this.options.complete || this.complete,
                    this.checkbar = this.options.checkbar || this.checkbar,
                    this.checkbarLoad = this.options.checkbarLoad || this.checkbarLoad,
                    this.checkbarType = this.options.checkbarType || this.checkbarType,
                    this.checkbarData = this.options.checkbarData || this.checkbarData,
                    this.checkbarFun = y.extend(this.checkbarFun, this.options.checkbarFun) || this.checkbarFun,
                    this.menubar = this.options.menubar || this.menubar,
                    this.menubarTips = y.extend(this.menubarTips, this.options.menubarTips) || this.menubarTips,
                    this.menubarFun = y.extend(this.menubarFun, this.options.menubarFun) || this.menubarFun,
                    this.toolbar = this.options.toolbar || this.toolbar,
                    this.toolbarWay = this.options.toolbarWay || this.toolbarWay,
                    this.toolbarStyle = y.extend(this.toolbarStyle, this.options.toolbarStyle) || this.toolbarStyle,
                    this.toolbarScroll = this.options.toolbarScroll || this.toolbarScroll,
                    this.toolbarLoad = this.options.toolbarLoad || this.toolbarLoad,
                    this.toolbarShow = this.options.toolbarShow || this.toolbarShow,
                    this.toolbarBtn = this.options.toolbarBtn || this.toolbarBtn,
                    this.toolbarExt = this.options.toolbarExt || this.toolbarExt,
                    this.toolbarFun = y.extend(this.toolbarFun, this.options.toolbarFun) || this.toolbarFun,
                    this.useIframe = this.options.useIframe || this.useIframe,
                this.options.iframe && (this.iframe.iframeElem = this.options.iframe.iframeElem || this.iframe.iframeElem, this.iframe.iframeUrl = this.options.iframe.iframeUrl || this.iframe.iframeUrl, this.iframe.iframeLoad = this.options.iframe.iframeLoad || this.iframe.iframeLoad, this.iframe.iframeDefaultRequest = y.extend(this.iframe.iframeDefaultRequest, this.options.iframe.iframeDefaultRequest) || this.iframe.iframeDefaultRequest, this.iframe.iframeRequest = y.extend(this.iframe.iframeRequest, this.options.iframe.iframeRequest) || this.iframe.iframeRequest),
                    this.iframeFun = y.extend(this.iframeFun, this.options.iframeFun) || this.iframeFun,
                    this.drawable = "boolean" == typeof this.options.drawable ? this.options.drawable: this.drawable,
                    this.ensureTheme()
            },
            ue.prototype.ensureTheme = function() {
                this.style.item = $ + this.skin + "-item",
                    this.style.itemThis = $ + this.skin + "-item-this",
                    this.style.dfont = $ + this.skin + "-dtreefont",
                    this.style.ficon = $ + this.skin + "-ficon",
                    this.style.icon = $ + this.skin + "-icon",
                    this.style.cbox = $ + this.skin + "-checkbox",
                    this.style.chs = $ + this.skin + "-choose";
                var e = this.iconfont,
                    t = [];
                "string" == typeof e ? t.push(e) : t = e;
                var o = this.iconfontStyle,
                    a = [];
                null == o.length ? a.push(o) : a = o;
                for (var i = 0; i < t.length; i++) {
                    var n = t[i],
                        s = a[i];
                    void 0 !== s && (this.useDefaultOrUserDefineFnodeStyle(n, s.fnode), this.useDefaultOrUserDefineSnodeStyle(n, s.snode), this.useDefaultOrUserDefineCheckboxStyle(n, s.checkbox), this.useDefaultOrUserDefineMenubarStyle(n, s.menubar), this.useDefaultOrUserDefineMenubarExtStyle(n, s.menubarExt), this.useDefaultOrUserDefineToolbarStyle(n, s.toolbar), this.useDefaultOrUserDefineToolbarExtStyle(n, s.toolbarExt))
                }
            },
            ue.prototype.useDefaultOrUserDefineFnodeStyle = function(e, t) {
                var o = this.usefontStyle.fnode.node.open,
                    a = this.usefontStyle.fnode.node.close,
                    i = this.usefontStyle.fnode.leaf;
                if (void 0 === t) this.usefontStyle.fnode.node.open = "" == o ? e + " " + this.nodeIconArray[this.fnodeIcon].open: o,
                    this.usefontStyle.fnode.node.close = "" == a ? e + " " + this.nodeIconArray[this.fnodeIcon].close: a,
                    this.usefontStyle.fnode.leaf = "" == i ? e + " " + this.leafIconArray[this.fleafIcon] : i;
                else {
                    var n = t.node,
                        s = t.leaf;
                    if (void 0 === n) this.usefontStyle.fnode.node.open = "" == o ? e + " " + this.nodeIconArray[this.fnodeIcon].open: o,
                        this.usefontStyle.fnode.node.close = "" == a ? e + " " + this.nodeIconArray[this.fnodeIcon].close: a;
                    else {
                        var r = n.open,
                            l = n.close;
                        this.usefontStyle.fnode.node.open = void 0 === r ? "" == o ? e + " " + this.nodeIconArray[this.fnodeIcon].open: o: e + " " + r,
                            this.usefontStyle.fnode.node.close = void 0 === l ? "" == a ? e + " " + this.nodeIconArray[this.fnodeIcon].close: a: e + " " + l
                    }
                    this.usefontStyle.fnode.leaf = void 0 === s ? "" == i ? e + " " + this.leafIconArray[this.fleafIcon] : i: e + " " + s
                }
            },
            ue.prototype.useDefaultOrUserDefineSnodeStyle = function(e, t) {
                var o = this.usefontStyle.snode.node.open,
                    a = this.usefontStyle.snode.node.close,
                    i = this.usefontStyle.snode.leaf;
                if (void 0 === t) this.usefontStyle.snode.node.open = "" == o ? e + " " + this.nodeIconArray[this.nodeIcon].open: o,
                    this.usefontStyle.snode.node.close = "" == a ? e + " " + this.nodeIconArray[this.nodeIcon].close: a,
                    this.usefontStyle.snode.leaf = "" == i ? e + " " + this.leafIconArray[this.leafIcon] : i;
                else {
                    var n = t.node,
                        s = t.leaf;
                    if (void 0 === n) this.usefontStyle.snode.node.open = "" == o ? e + " " + this.nodeIconArray[this.nodeIcon].open: o,
                        this.usefontStyle.snode.node.close = "" == a ? e + " " + this.nodeIconArray[this.nodeIcon].close: a;
                    else {
                        var r = n.open,
                            l = n.close;
                        this.usefontStyle.snode.node.open = void 0 === r ? "" == o ? e + " " + this.nodeIconArray[this.nodeIcon].open: o: e + " " + r,
                            this.usefontStyle.snode.node.close = void 0 === l ? "" == a ? e + " " + this.nodeIconArray[this.nodeIcon].close: a: e + " " + l
                    }
                    this.usefontStyle.snode.leaf = void 0 === s ? "" == i ? e + " " + this.leafIconArray[this.leafIcon] : i: e + " " + s
                }
            },
            ue.prototype.useDefaultOrUserDefineCheckboxStyle = function(e, t) {
                var o = this.usefontStyle.checkbox.on,
                    a = this.usefontStyle.checkbox.out,
                    i = this.usefontStyle.checkbox.noall;
                if (void 0 === t) this.usefontStyle.checkbox.on = "" == o ? e + " " + p: o,
                    this.usefontStyle.checkbox.out = "" == a ? e + " " + b: a,
                    this.usefontStyle.checkbox.noall = "" == i ? e + " " + j: i;
                else {
                    var n = t.on,
                        s = t.out,
                        r = t.noall;
                    this.usefontStyle.checkbox.on = void 0 === n ? "" == o ? e + " " + p: o: e + " " + n,
                        this.usefontStyle.checkbox.out = void 0 === s ? "" == a ? e + " " + b: a: e + " " + s,
                        this.usefontStyle.checkbox.noall = void 0 === r ? "" == i ? e + " " + j: i: e + " " + r
                }
            },
            ue.prototype.useDefaultOrUserDefineMenubarStyle = function(e, t) {
                var o = this.usefontStyle.menubar.movedown,
                    a = this.usefontStyle.menubar.moveup,
                    i = this.usefontStyle.menubar.refresh,
                    n = this.usefontStyle.menubar.checkAll,
                    s = this.usefontStyle.menubar.unCheckAll,
                    r = this.usefontStyle.menubar.invertAll,
                    l = this.usefontStyle.menubar.remove,
                    d = this.usefontStyle.menubar.search;
                if (void 0 === t) this.usefontStyle.menubar.movedown = "" == o ? e + " " + P: o,
                    this.usefontStyle.menubar.moveup = "" == a ? e + " " + A: a,
                    this.usefontStyle.menubar.refresh = "" == i ? e + " " + w: i,
                    this.usefontStyle.menubar.checkAll = "" == n ? e + " " + q: n,
                    this.usefontStyle.menubar.unCheckAll = "" == s ? e + " " + L: s,
                    this.usefontStyle.menubar.invertAll = "" == r ? e + " " + R: r,
                    this.usefontStyle.menubar.remove = "" == l ? e + " " + O: l,
                    this.usefontStyle.menubar.search = "" == d ? e + " " + E: d;
                else {
                    var c = t.movedown,
                        h = t.moveup,
                        u = t.refresh,
                        f = t.checkAll,
                        p = t.unCheckAll,
                        b = t.invertAll,
                        m = t.remove,
                        y = t.search;
                    this.usefontStyle.menubar.movedown = void 0 === c ? "" == o ? e + " " + P: o: e + " " + c,
                        this.usefontStyle.menubar.moveup = void 0 === h ? "" == a ? e + " " + A: a: e + " " + h,
                        this.usefontStyle.menubar.refresh = void 0 === u ? "" == i ? e + " " + w: i: e + " " + u,
                        this.usefontStyle.menubar.checkAll = void 0 === f ? "" == n ? e + " " + q: n: e + " " + f,
                        this.usefontStyle.menubar.unCheckAll = void 0 === p ? "" == s ? e + " " + L: s: e + " " + p,
                        this.usefontStyle.menubar.invertAll = void 0 === b ? "" == r ? e + " " + R: r: e + " " + b,
                        this.usefontStyle.menubar.remove = void 0 === m ? "" == l ? e + " " + O: l: e + " " + m,
                        this.usefontStyle.menubar.search = void 0 === y ? "" == d ? e + " " + E: d: e + " " + y
                }
            },
            ue.prototype.useDefaultOrUserDefineMenubarExtStyle = function(e, t) {
                var o = this.usefontStyle.menubarExt;
                this.usefontStyle.menubarExt = void 0 === t ? "" == o ? e: o: t
            },
            ue.prototype.useDefaultOrUserDefineToolbarStyle = function(e, t) {
                var o = this.usefontStyle.toolbar.menubar.movedown,
                    a = this.usefontStyle.toolbar.menubar.moveup,
                    i = this.usefontStyle.toolbar.menubar.refresh,
                    n = this.usefontStyle.toolbar.menubar.checkAll,
                    s = this.usefontStyle.toolbar.menubar.unCheckAll,
                    r = this.usefontStyle.toolbar.menubar.invertAll,
                    l = this.usefontStyle.toolbar.menubar.remove,
                    d = this.usefontStyle.toolbar.menubar.search,
                    c = this.usefontStyle.toolbar.menubarExt,
                    h = this.usefontStyle.toolbar.pulldown,
                    u = this.usefontStyle.toolbar.pullup,
                    f = this.usefontStyle.toolbar.add,
                    p = this.usefontStyle.toolbar.edit,
                    b = this.usefontStyle.toolbar.del;
                if (void 0 === t) this.usefontStyle.toolbar.menubar.movedown = "" == o ? e + " " + this.usefontStyle.menubar.movedown: o,
                    this.usefontStyle.toolbar.menubar.moveup = "" == a ? e + " " + this.usefontStyle.menubar.moveup: a,
                    this.usefontStyle.toolbar.menubar.refresh = "" == i ? e + " " + this.usefontStyle.menubar.refresh: i,
                    this.usefontStyle.toolbar.menubar.checkAll = "" == n ? e + " " + this.usefontStyle.menubar.checkAll: n,
                    this.usefontStyle.toolbar.menubar.unCheckAll = "" == s ? e + " " + this.usefontStyle.menubar.unCheckAll: s,
                    this.usefontStyle.toolbar.menubar.invertAll = "" == r ? e + " " + this.usefontStyle.menubar.invertAll: r,
                    this.usefontStyle.toolbar.menubar.remove = "" == l ? e + " " + this.usefontStyle.menubar.remove: l,
                    this.usefontStyle.toolbar.menubar.search = "" == d ? e + " " + this.usefontStyle.menubar.search: d,
                    this.usefontStyle.toolbar.menubarExt = "" == c ? this.usefontStyle.menubarExt: c,
                    this.usefontStyle.toolbar.pulldown = "" == h ? e + " " + F: h,
                    this.usefontStyle.toolbar.pullup = "" == u ? e + " " + M: u,
                    this.usefontStyle.toolbar.add = "" == f ? e + " " + _: f,
                    this.usefontStyle.toolbar.edit = "" == p ? e + " " + U: p,
                    this.usefontStyle.toolbar.del = "" == b ? e + " " + B: b;
                else {
                    var m = t.menubar,
                        y = t.menubarExt,
                        v = t.pulldown,
                        g = t.pullup,
                        k = t.add,
                        S = t.edit,
                        D = t.del;
                    if (void 0 === m) this.usefontStyle.toolbar.menubar.movedown = "" == o ? e + " " + this.usefontStyle.menubar.movedown: o,
                        this.usefontStyle.toolbar.menubar.moveup = "" == a ? e + " " + this.usefontStyle.menubar.moveup: a,
                        this.usefontStyle.toolbar.menubar.refresh = "" == i ? e + " " + this.usefontStyle.menubar.refresh: i,
                        this.usefontStyle.toolbar.menubar.checkAll = "" == n ? e + " " + this.usefontStyle.menubar.checkAll: n,
                        this.usefontStyle.toolbar.menubar.unCheckAll = "" == tempUncheckAll ? e + " " + this.usefontStyle.menubar.unCheckAll: tempUncheckAll,
                        this.usefontStyle.toolbar.menubar.invertAll = "" == r ? e + " " + this.usefontStyle.menubar.invertAll: r,
                        this.usefontStyle.toolbar.menubar.remove = "" == l ? e + " " + this.usefontStyle.menubar.remove: l,
                        this.usefontStyle.toolbar.menubar.search = "" == d ? e + " " + this.usefontStyle.menubar.search: d;
                    else {
                        var N = m.movedown,
                            C = m.moveup,
                            x = m.refresh,
                            T = m.checkAll,
                            I = m.unCheckAll,
                            j = m.invertAll,
                            P = m.remove,
                            A = m.search;
                        this.usefontStyle.toolbar.menubar.movedown = void 0 === N ? "" == o ? e + " " + this.usefontStyle.menubar.movedown: o: e + " " + N,
                            this.usefontStyle.toolbar.menubar.moveup = void 0 === C ? "" == a ? e + " " + this.usefontStyle.menubar.moveup: a: e + " " + C,
                            this.usefontStyle.toolbar.menubar.refresh = void 0 === x ? "" == i ? e + " " + this.usefontStyle.menubar.refresh: i: e + " " + x,
                            this.usefontStyle.toolbar.menubar.checkAll = void 0 === T ? "" == n ? e + " " + this.usefontStyle.menubar.checkAll: n: e + " " + T,
                            this.usefontStyle.toolbar.menubar.unCheckAll = void 0 === I ? "" == tempUncheckAll ? e + " " + this.usefontStyle.menubar.unCheckAll: tempUncheckAll: e + " " + I,
                            this.usefontStyle.toolbar.menubar.invertAll = void 0 === j ? "" == r ? e + " " + this.usefontStyle.menubar.invertAll: r: e + " " + j,
                            this.usefontStyle.toolbar.menubar.remove = void 0 === P ? "" == l ? e + " " + this.usefontStyle.menubar.remove: l: e + " " + P,
                            this.usefontStyle.toolbar.menubar.search = void 0 === A ? "" == d ? e + " " + this.usefontStyle.menubar.search: d: e + " " + A
                    }
                    this.usefontStyle.toolbar.menubarExt = void 0 === y ? "" == c ? this.usefontStyle.menubarExt: c: y,
                        this.usefontStyle.toolbar.pulldown = void 0 === v ? "" == h ? e + " " + F: h: e + " " + v,
                        this.usefontStyle.toolbar.pullup = void 0 === g ? "" == u ? e + " " + M: u: e + " " + g,
                        this.usefontStyle.toolbar.add = void 0 === k ? "" == f ? e + " " + _: f: e + " " + k,
                        this.usefontStyle.toolbar.edit = void 0 === S ? "" == p ? e + " " + U: p: e + " " + S,
                        this.usefontStyle.toolbar.del = void 0 === D ? "" == b ? e + " " + B: b: e + " " + D
                }
            },
            ue.prototype.useDefaultOrUserDefineToolbarExtStyle = function(e, t) {
                var o = this.usefontStyle.toolbarExt;
                this.usefontStyle.toolbarExt = void 0 === t ? "" == o ? e: o: t
            },
            ue.prototype.operateIcon = function(e, t) {
                var o = this,
                    a = e.attr("data-iconClass"),
                    i = t.attr("data-iconClass");
                return {
                    open: function() {
                        e.attr("data-spread", "open"),
                            t.attr("data-spread", "open"),
                        a || (e.removeClass(o.usefontStyle.fnode.node.close), e.addClass(o.usefontStyle.fnode.node.open)),
                        i || (t.removeClass(o.usefontStyle.snode.node.close), t.addClass(o.usefontStyle.snode.node.open))
                    },
                    close: function() {
                        e.attr("data-spread", "close"),
                            t.attr("data-spread", "close"),
                        a || (e.removeClass(o.usefontStyle.fnode.node.open), e.addClass(o.usefontStyle.fnode.node.close)),
                        i || (t.removeClass(o.usefontStyle.snode.node.open), t.addClass(o.usefontStyle.snode.node.close))
                    },
                    openWithLeaf: function() {
                        e.attr("data-spread", "open"),
                            t.attr("data-spread", "open"),
                        a || (e.removeClass(o.usefontStyle.fnode.leaf), e.addClass(o.usefontStyle.fnode.node.open)),
                        i || (t.removeClass(o.usefontStyle.snode.leaf), t.addClass(o.usefontStyle.snode.node.open))
                    },
                    closeWithLeaf: function() {
                        e.attr("data-spread", "last"),
                            t.attr("data-spread", "last"),
                        a || (e.removeClass(o.usefontStyle.fnode.node.open), e.removeClass(o.usefontStyle.fnode.node.close), e.addClass(o.usefontStyle.fnode.leaf)),
                        i || (t.removeClass(o.usefontStyle.snode.node.open), t.removeClass(o.usefontStyle.snode.node.close), t.addClass(o.usefontStyle.snode.leaf))
                    }
                }
            },
            ue.prototype.showLine = function(e) {
                var t = this;
                t.line && (e && 0 < e.length ? e.each(function() {
                    t.showLineLi(y(this))
                }) : t.obj.find("li[data-id]").each(function() {
                    t.showLineLi(y(this))
                }))
            },
            ue.prototype.showLineLi = function(e) {
                var t = e.children("div"),
                    o = e.next("li"),
                    a = e.parent("ul");
                if (a[0].id == this.obj[0].id) e.removeClass(d),
                    e.removeClass(h),
                    e.addClass(s);
                else {
                    var i = a.parent("li").next("li");
                    if (0 == i.length) 0 == o.length ? (e.removeClass(d), e.removeClass(s), e.addClass(h)) : (e.removeClass(s), e.removeClass(h), e.addClass(d));
                    else {
                        var n = i.children("div");
                        0 == o.length && "leaf" == t.children("cite").attr("data-leaf") && "leaf" == n.children("cite").attr("data-leaf") ? (e.removeClass(s), e.removeClass(d), e.addClass(h)) : (e.removeClass(s), e.removeClass(h), e.addClass(d))
                    }
                }
            },
            ue.prototype.reload = function(e) {
                this.reloadSetting(e),
                    this.init()
            },
            ue.prototype.init = function() {
                var i = this;
                if ("object" == typeof i) if (i.data) {
                    if (void 0 === i.data.length) return void f.msg("数据解析异常，data数据格式不正确", {
                        icon: 5
                    });
                    if (0 == i.data.length) return void i.obj.html(i.getNoneDom().text());
                    i.obj.html(""),
                        setTimeout(function() {
                                if (i.success(i.data, i.obj), "list" == i.dataFormat) {
                                    var e = i.obj.attr("data-id"),
                                        t = i.queryListTreeByPid(e, i.data);
                                    i.loadListTree(t, i.data, 1)
                                } else i.loadTree(i.data, 1);
                                i.showLine(),
                                i.toolbar && "contextmenu" != i.toolbarWay && i.setToolbarDom().setToolbarPlace(i.toolbarMenu),
                                    i.msgErrData(),
                                    i.done(i.data, i.obj)
                            },
                            100)
                } else {
                    if (!i.url) return void f.msg("数据请求异常，url参数未指定", {
                        icon: 5
                    });
                    i.obj.html("");
                    var o = i.load ? f.load(1) : "";
                    ce({
                        async: i.async,
                        headers: i.headers,
                        type: i.method,
                        url: i.url,
                        dataType: i.dataType,
                        contentType: i.contentType,
                        data: i.getFilterRequestParam(i.getRequestParam()),
                        success: function(e) {
                            "string" == typeof e && (e = y.parseJSON(e));
                            if (("layuiStyle" == i.dataStyle ? e[i.response.statusName] : e.status[i.response.statusName]) == i.response.statusCode) {
                                var t = e[i.response.rootName];
                                if (void 0 === t.length) return void f.msg("数据解析异常，url回调后的数据格式不正确", {
                                    icon: 5
                                });
                                if (0 == t.length) return void i.obj.html(i.getNoneDom().text());
                                if (i.success(e, i.obj), "list" == i.dataFormat) {
                                    var o = i.obj.attr("data-id"),
                                        a = i.queryListTreeByPid(o, t);
                                    i.loadListTree(a, t, 1)
                                } else i.loadTree(t, 1);
                                i.showLine(),
                                i.toolbar && "contextmenu" != i.toolbarWay && i.setToolbarDom().setToolbarPlace(i.toolbarMenu),
                                    i.msgErrData(),
                                    i.done(e, i.obj)
                            } else "layuiStyle" == i.dataStyle ? f.msg(e[i.response.message], {
                                icon: 2
                            }) : f.msg(e.status[i.response.message], {
                                icon: 2
                            })
                        },
                        error: function(e, t, o) {
                            i.error(e, t, o)
                        },
                        complete: function(e, t) {
                            i.load && f.close(o),
                                i.complete(e, t)
                        }
                    })
                } else f.msg("树组件未成功加载，请检查配置", {
                    icon: 5
                })
            },
            ue.prototype.getChild = function(e, t) {
                var i = this,
                    n = e.next("ul");
                if (i.setNodeParam(e), void 0 !== t) {
                    if (void 0 === t.length) return void f.msg("数据解析异常，data数据格式不正确", {
                        icon: 5
                    });
                    if (n.html(""), "list" == i.dataFormat) {
                        var o = i.node.nodeId,
                            a = parseInt(i.node.level) + 1,
                            s = i.queryListTreeByPid(o, t);
                        i.loadListTree(s, i.data, a)
                    } else i.loadTree(t, a);
                    i.showLine(),
                    i.toolbar && "contextmenu" != i.toolbarWay && i.setToolbarDom().setToolbarPlace(i.toolbarMenu),
                        i.msgErrData()
                } else {
                    if (!i.url) return void f.msg("数据请求异常，url参数未指定", {
                        icon: 5
                    });
                    n.html("");
                    var r = i.load ? f.load(1) : "";
                    ce({
                        async: i.async,
                        headers: i.headers,
                        type: i.method,
                        url: i.url,
                        dataType: i.dataType,
                        data: i.getFilterRequestParam(i.getRequestParam()),
                        success: function(e) {
                            "string" == typeof e && (e = y.parseJSON(e));
                            if (("layuiStyle" == i.dataStyle ? e[i.response.statusName] : e.status[i.response.statusName]) == i.response.statusCode) {
                                var t = i.node.nodeId,
                                    o = parseInt(i.node.level) + 1;
                                if ("list" == i.dataFormat) {
                                    var a = i.queryListTreeByPid(t, e[i.response.rootName]);
                                    i.loadListTree(a, e[i.response.rootName], o, n)
                                } else i.loadTree(e[i.response.rootName], o, n);
                                i.showLine(),
                                i.toolbar && "contextmenu" != i.toolbarWay && i.setToolbarDom().setToolbarPlace(i.toolbarMenu),
                                    i.msgErrData(),
                                    n.addClass(C)
                            } else "layuiStyle" == i.dataStyle ? f.msg(e[i.response.message], {
                                icon: 2
                            }) : f.msg(e.status[i.response.message], {
                                icon: 2
                            })
                        },
                        error: function(e, t, o) {
                            i.error()
                        },
                        complete: function(e, t) {
                            i.load && f.close(r),
                                i.complete()
                        }
                    })
                }
            },
            ue.prototype.loadListTree = function(e, t, o, a) {
                var i = this;
                if (a = a || i.getNodeDom().nowOrRootUl(), 0 < e.length) for (var n = 0; n < e.length; n++) {
                    var s = e[n];
                    if ("object" == typeof s) {
                        var r = i.parseData(s),
                            l = i.queryListTreeByPid(r.treeId(), t);
                        if (a.append(i.getLiItemDom(r.treeId(), r.parentId(), r.title(), r.fmtTitle(), r.last(l.length), r.ficonClass(), r.iconClass(), r.checkArr(), o, r.spread(o), r.disabled(), r.hide(), r.basicData(), r.recordData(), a.hasClass(c) ? "root": "item")), 0 < l.length) {
                            var d = parseInt(o) + 1;
                            i.loadListTree(l, t, d, i.obj.find("ul[data-id='" + r.treeId() + "']"))
                        }
                    }
                }
            },
            ue.prototype.queryListTreeByPid = function(e, t) {
                var o = [];
                if (t) for (var a = 0; a < t.length; a++) {
                    var i = t[a];
                    "object" == typeof i && ("null" == e || null == e ? null == i[this.response.parentId] && o.push(i) : i[this.response.parentId] == e && (i[this.response.treeId] == e ? this.errData.push(i) : o.push(i)))
                }
                return o
            },
            ue.prototype.loadTree = function(e, t, o) {
                var a = this;
                if (e) {
                    o = o || a.getNodeDom().nowOrRootUl();
                    for (var i = 0; i < e.length; i++) {
                        var n = e[i];
                        if ("object" == typeof n) {
                            n[a.response.treeId] == n[a.response.parentId] && a.errData.push(n);
                            var s = a.parseData(n),
                                r = s.children();
                            if (o.append(a.getLiItemDom(s.treeId(), s.parentId(), s.title(), s.fmtTitle(), s.last(r.length), s.ficonClass(), s.iconClass(), s.checkArr(), t, s.spread(t), s.disabled(), s.hide(), s.basicData(), s.recordData(), o.hasClass(c) ? "root": "item")), 0 != r.length) {
                                var l = parseInt(t) + 1;
                                a.loadTree(r, l, a.obj.find("ul[data-id='" + s.treeId() + "']"))
                            }
                        }
                    }
                }
            },
            ue.prototype.msgErrData = function() {
                var e = this;
                if (0 < e.errData.length && e.errDataShow) {
                    for (var t = "",
                             o = 0; o < e.errData.length; o++) {
                        t += "数据：【" + e.errData[o][e.response.title] + "】中节点id和上级id值一致！ \n"
                    }
                    f.msg(t, {
                        icon: 2,
                        time: 5e3
                    })
                }
                e.errData = []
            },
            ue.prototype.parseData = function(o) {
                var a = this;
                return {
                    treeId: function() {
                        return o[a.response.treeId]
                    },
                    parentId: function() {
                        return o[a.response.parentId]
                    },
                    fmtTitle: function() {
                        if ("function" != typeof a.formatter.title) return o[a.response.title];
                        var e = a.formatter.title(o),
                            t = o[a.response.title];
                        return (t = "" == e || null == e || null == e ? t: e) || ""
                    },
                    title: function() {
                        return o[a.response.title]
                    },
                    level: function() {
                        return o[a.response.level] || ""
                    },
                    ficonClass: function() {
                        return o[a.response.ficonClass] || ""
                    },
                    iconClass: function() {
                        return o[a.response.iconClass] || ""
                    },
                    last: function(e) {
                        return 0 == e ? "boolean" != typeof o[a.response.last] || o[a.response.last] : "boolean" == typeof o[a.response.last] && o[a.response.last]
                    },
                    spread: function(e) {
                        return e < a.initLevel ? "boolean" != typeof o[a.response.spread] || o[a.response.spread] : "boolean" == typeof o[a.response.spread] && o[a.response.spread]
                    },
                    disabled: function() {
                        return "boolean" == typeof o[a.response.disabled] && o[a.response.disabled]
                    },
                    hide: function() {
                        return "boolean" == typeof o[a.response.hide] && o[a.response.hide]
                    },
                    checkArr: function() {
                        var e = [],
                            t = o[a.response.checkArr];
                        return "string" == typeof t && (t = -1 < t.indexOf("{") && -1 < t.indexOf("}") ? JSON.parse(t) : {
                            type: "0",
                            checked: t
                        }),
                        "object" == typeof t && (void 0 === t.length ? e.push(t) : e = t),
                        0 < e.length && e.length > a.checkArrLen && (a.checkArrLen = e.length),
                            e
                    },
                    children: function() {
                        return o[a.response.childName] || []
                    },
                    basicData: function() {
                        return se.escape(JSON.stringify(o[a.response.basicData])) || JSON.stringify({})
                    },
                    recordData: function() {
                        var e = a.record ? se.cloneObj(o, [a.response.treeId, a.response.parentId, a.response.title, a.response.iconClass, a.response.childName, a.response.last, a.response.spread, a.response.disabled, a.response.hide, a.response.checkArr, a.response.checked, a.response.type, a.response.basicData]) : {};
                        return se.escape(JSON.stringify(e))
                    },
                    data: function() {
                        return o
                    }
                }
            },
            ue.prototype.getNoneDom = function() {
                var e = this.obj[0].id,
                    t = this.none;
                return {
                    text: function() {
                        return "<div class='dtree-none-text' dtree-id='" + e + "'>" + t + "</div>"
                    }
                }
            },
            ue.prototype.getDom = function(r, e, t, o, l, s, d, c, a, h, u, i) {
                var f = this,
                    p = f.obj[0].id,
                    b = (f.toolbar, f.checkbar);
                return {
                    fnode: function() {
                        var e = f.fnodeIcon,
                            t = f.fleafIcon,
                            o = f.usefontStyle.fnode.leaf,
                            a = f.usefontStyle.fnode.node.open,
                            i = f.usefontStyle.fnode.node.close;
                        if (s) {
                            var n = f.iconfont;
                            i = "string" == typeof n ? a = o = n + " " + s: (o = n[0] + " " + s, a = n[0] + " " + s, n[0] + " " + s)
                        }
                        return "-1" != e && "-1" != t ? l ? "<i class='" + o + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='last' data-id='" + r + "' dtree-id='" + p + "'></i>": h ? "<i class='" + a + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='open' data-id='" + r + "' dtree-id='" + p + "'></i>": "<i class='" + i + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='close' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + s + "'></i>": "-1" != e && "-1" == t ? l ? "<i class='" + o + " " + I + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='last' data-id='" + r + "' dtree-id='" + p + "'></i>": h ? "<i class='" + a + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='open' data-id='" + r + "' dtree-id='" + p + "'></i>": "<i class='" + i + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='close' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + s + "'></i>": "-1" == e && "-1" != t ? l ? "<i class='" + o + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='last' data-id='" + r + "' dtree-id='" + p + "'></i>": h ? "<i class='" + a + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='open' data-id='" + r + "' dtree-id='" + p + "'></i>": "<i class='" + i + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='close' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + s + "'></i>": "-1" == e && "-1" == t ? l ? "<i class='" + o + " " + I + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='last' data-id='" + r + "' dtree-id='" + p + "' style='display:none;'></i>": h ? "<i class='" + a + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='open' data-id='" + r + "' dtree-id='" + p + "'></i>": "<i class='" + i + " " + f.style.dfont + " " + f.style.ficon + "' data-spread='close' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + s + "'></i>": void 0
                    },
                    node: function() {
                        var e = f.nodeIcon,
                            t = f.leafIcon,
                            o = f.usefontStyle.snode.leaf,
                            a = f.usefontStyle.snode.node.open,
                            i = f.usefontStyle.snode.node.close;
                        if (d) {
                            var n = f.iconfont;
                            i = "string" == typeof n ? a = o = n + " " + d: (o = n[0] + " " + d, a = n[0] + " " + d, n[0] + " " + d)
                        }
                        return "-1" != e && "-1" != t ? l ? "<i class='" + o + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": h ? "<i class='" + a + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": "-1" != e && "-1" == t ? l ? "<i class='" + o + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": h ? "<i class='" + a + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": "-1" == e && "-1" != t ? l ? "<i class='" + o + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": h ? "<i class='" + a + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": "-1" == e && "-1" == t ? l ? "<i class='" + o + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": h ? "<i class='" + a + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + r + "' dtree-id='" + p + "' data-iconClass='" + d + "'></i>": void 0
                    },
                    checkbox: function() {
                        var e = !1;
                        if ("node" == f.checkbarLoad ? b && (e = !0) : l && b && (e = !0), e) {
                            var t = "<div class='" + D + "' data-id='" + r + "' dtree-id='" + p + "'>";
                            if (c && 0 < c.length) for (var o = 0; o < c.length; o++) {
                                var a = c[o],
                                    i = a.checked,
                                    n = f.usefontStyle.checkbox.out;
                                n = "2" == i ? f.usefontStyle.checkbox.noall + " " + f.style.chs: "1" == i ? f.usefontStyle.checkbox.on + " " + f.style.chs: f.usefontStyle.checkbox.out;
                                var s = "";
                                u && (s = T),
                                    t += "<i class='" + n + " " + f.style.dfont + " " + f.style.cbox + " " + s + "' data-id='" + r + "' dtree-id='" + p + "' data-checked='" + a.checked + "' data-initchecked='" + a.checked + "' data-type='" + a.type + "' dtree-click='" + J + "' data-par='." + N + "' dtree-disabled='" + u + "'></i>"
                            }
                            return t += "</div>"
                        }
                        return ""
                    },
                    text: function() {
                        var e = "";
                        return u && (e = T),
                        "<cite class='" + n + " " + e + "' data-id='" + r + "' data-leaf='" + (l ? "leaf": "node") + "' dtree-disabled='" + u + "' data-title='" + t + "' >" + o + "</cite>"
                    },
                    ul: function() {
                        return l ? "<ul class='" + m + "' data-id='" + r + "' dtree-id='" + p + "'></ul>": h ? "<ul class='" + m + " " + C + "' data-id='" + r + "' dtree-id='" + p + "'></ul>": "<ul class='" + m + "' data-id='" + r + "' dtree-id='" + p + "'></ul>"
                    }
                }
            },
            ue.prototype.replaceDom = function(l, d, c, h, u, e) {
                var f = this,
                    p = f.obj[0].id,
                    b = (f.toolbar, f.checkbar);
                return {
                    fnode: function(e) {
                        var t = "",
                            o = f.fnodeIcon,
                            a = (f.fleafIcon, f.usefontStyle.fnode.leaf),
                            i = f.usefontStyle.fnode.node.open,
                            n = f.usefontStyle.fnode.node.close;
                        if (e) {
                            var s = f.iconfont;
                            n = "string" == typeof s ? i = a = s + " " + e: (a = s[0] + " " + e, i = s[0] + " " + e, s[0] + " " + e)
                        }
                        "-1" != o && "-1" != leafIcon ? t = c ? "<i class='" + a + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + iconClass + "'></i>": h ? "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + iconClass + "'></i>": "<i class='" + n + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": "-1" != nodeIcon && "-1" == leafIcon ? t = c ? "<i class='" + a + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + iconClass + "'></i>": h ? "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + iconClass + "'></i>": "<i class='" + n + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": "-1" == nodeIcon && "-1" != leafIcon ? t = c ? "<i class='" + a + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + iconClass + "'></i>": h ? "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + iconClass + "'></i>": "<i class='" + n + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": "-1" == nodeIcon && "-1" == leafIcon && (t = c ? "<i class='" + a + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + iconClass + "'></i>": h ? "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + iconClass + "'></i>": "<i class='" + n + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>"),
                        "" != t && f.getNodeDom(l).fnode().replaceWith(y(t))
                    },
                    node: function(e) {
                        var t = "",
                            o = f.nodeIcon,
                            a = f.leafIcon,
                            i = f.usefontStyle.snode.leaf,
                            n = f.usefontStyle.snode.node.open,
                            s = f.usefontStyle.snode.node.close;
                        if (e) {
                            var r = f.iconfont;
                            s = "string" == typeof r ? n = i = r + " " + e: (i = r[0] + " " + e, n = r[0] + " " + e, r[0] + " " + e)
                        }
                        "-1" != o && "-1" != a ? t = c ? "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": h ? "<i class='" + n + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": "<i class='" + s + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": "-1" != o && "-1" == a ? t = c ? "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": h ? "<i class='" + n + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": "<i class='" + s + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": "-1" == o && "-1" != a ? t = c ? "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": h ? "<i class='" + n + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": "<i class='" + s + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": "-1" == o && "-1" == a && (t = c ? "<i class='" + i + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='last' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": h ? "<i class='" + n + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='open' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>": "<i class='" + s + " " + v + " " + f.style.dfont + " " + f.style.icon + "' data-spread='close' data-id='" + d + "' dtree-id='" + p + "' data-iconClass='" + e + "'></i>"),
                        "" != t && f.getNodeDom(l).snode().replaceWith(y(t))
                    },
                    checkbox: function(e) {
                        var t = !1;
                        if ("node" == f.checkbarLoad ? b && (t = !0) : c && b && (t = !0), t) {
                            var o = "<div class='" + D + "' data-id='" + d + "' dtree-id='" + p + "'>";
                            if (e && 0 < e.length) for (var a = 0; a < e.length; a++) {
                                var i = e[a],
                                    n = i.checked,
                                    s = f.usefontStyle.checkbox.out;
                                s = "2" == n ? f.usefontStyle.checkbox.noall + " " + f.style.chs: "1" == n ? f.usefontStyle.checkbox.on + " " + f.style.chs: f.usefontStyle.checkbox.out;
                                var r = "";
                                u && (r = T),
                                    o += "<i class='" + s + " " + f.style.dfont + " " + f.style.cbox + " " + r + "' data-id='" + d + "' dtree-id='" + p + "' data-checked='" + i.checked + "' data-initchecked='" + i.checked + "' data-type='" + i.type + "' dtree-click='" + J + "' data-par='." + N + "' dtree-disabled='" + u + "'></i>"
                            }
                            o += "</div>",
                                f.getNodeDom(l).snode().next("div").replaceWith(y(o))
                        }
                    },
                    text: function(e) {
                        var t = "";
                        u && (t = T);
                        var o = "<cite class='" + n + " " + t + "' data-id='" + d + "' data-leaf='" + (c ? "leaf": "node") + "' dtree-disabled='" + u + "' >" + e + "</cite>";
                        f.getNodeDom(l).cite().replaceWith(y(o))
                    },
                    ul: function() {
                        var e = c ? "<ul class='" + m + "' data-id='" + d + "' dtree-id='" + p + "'></ul>": h ? "<ul class='" + m + " " + C + "' data-id='" + d + "' dtree-id='" + p + "'></ul>": "<ul class='" + m + "' data-id='" + d + "' dtree-id='" + p + "'></ul>";
                        f.getNodeDom(l).nextUl().replaceWith(y(e))
                    },
                    basicData: function(e) {
                        e = "{}" == e ? "": e,
                            l.attr("data-basic", e)
                    },
                    recordData: function(e) {
                        e = "{}" == e ? "": e,
                            l.attr("data-record", e)
                    },
                    p_li: function() {
                        l.parent("li").attr("data-id", d)
                    }
                }
            },
            ue.prototype.getLiItemDom = function(e, t, o, a, i, n, s, r, l, d, c, h, u, f, p) {
                var b = this,
                    m = b.obj[0].id,
                    y = b.getDom(e, t, o, a, i, n, s, r, l, d, c, h);
                u = "{}" == u ? "": u,
                    f = "{}" == f ? "": f;
                var v = "<div class='" + S + " " + b.style.item + "' data-id='" + e + "' dtree-id='" + m + "' dtree-click='" + z + "' data-basic='" + u + "' data-record='" + f + "' dtree-disabled='" + c + "' dtree-hide='" + h + "' ";
                b.toolbar && "contextmenu" == b.toolbarWay ? ("node" == b.toolbarLoad && (v += " d-contextmenu='true'>"), "noleaf" == b.toolbarLoad && (v += i ? " d-contextmenu='false'>": " d-contextmenu='true'>"), "leaf" == b.toolbarLoad && (v += i ? " d-contextmenu='true'>": " d-contextmenu='false'>")) : v += " d-contextmenu='false'>";
                var g = "";
                return h && (g = x),
                    ["<li class='" + N + " " + k + " " + g + " 'data-id='" + e + "'data-pid='" + ("root" == p ? void 0 !== typeof t && "" != t ? t: "-1": t) + "'dtree-id='" + m + "'data-index='" + l + "'dtree-hide='" + h + "'>" + v, y.fnode(), y.node(), y.checkbox(), y.text(), "</div>", y.ul(), "</li>"].join("")
            },
            ue.prototype.dataInit = function(e) {
                var t = this,
                    o = t.obj.find("div[data-id='" + e + "']");
                t.getNodeDom(o).parentLi().find("." + i).removeClass(i),
                    t.getNodeDom(o).parentLi().find("." + t.style.itemThis).removeClass(t.style.itemThis),
                    o.addClass(i),
                    o.addClass(t.style.itemThis),
                    t.setNodeParam(o);
                var a = o.parents("." + k);
                return a.children("ul").addClass(C),
                    a.children("." + S).children("i[data-spread]." + se.trimToDot(t.usefontStyle.fnode.node.close)).addClass(t.usefontStyle.fnode.node.open),
                    a.children("." + S).children("i[data-spread]." + se.trimToDot(t.usefontStyle.fnode.node.close)).removeClass(t.usefontStyle.fnode.node.close),
                    a.children("." + S).children("i[data-spread]." + se.trimToDot(t.usefontStyle.snode.node.close)).addClass(t.usefontStyle.snode.node.open),
                    a.children("." + S).children("i[data-spread]." + se.trimToDot(t.usefontStyle.snode.node.close)).removeClass(t.usefontStyle.snode.node.close),
                    t.getNowParam()
            },
            ue.prototype.escape = function(e) {
                return se.escape(e)
            },
            ue.prototype.unescape = function(e) {
                return se.unescape(e)
            },
            ue.prototype.navThis = function(e) {
                var t = this,
                    o = "object" == typeof e ? e: 0 == t.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']").length ? null: t.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']");
                null != o && (t.obj.find("div[data-id]").parent().find("." + i).removeClass(i), t.obj.find("div[data-id]").parent().find("." + t.style.itemThis).removeClass(t.style.itemThis), o.addClass(i), o.addClass(t.style.itemThis))
            },
            ue.prototype.accordionUL = function(e) {
                if (this.accordion) {
                    e.closest("li[data-index]").siblings("li[data-index]").children("ul[data-id]").removeClass(C);
                    var t = e.closest("li[data-index]").siblings("li[data-index]").children("ul[data-id]").prev("div");
                    if (t.length && 0 < t.length) for (var o = 0; o < t.length; o++) {
                        var a = y(t[o]),
                            i = this.getNodeDom(a).fnode(),
                            n = this.getNodeDom(a).snode();
                        "last" != i.attr("data-spread") && this.operateIcon(i, n).close()
                    }
                }
            },
            ue.prototype.clickSpread = function(e) {
                var t = this,
                    o = t.getNodeDom(e).fnode(),
                    a = t.getNodeDom(e).snode(),
                    i = (t.getNodeDom(e).cite(), o.attr("data-spread")),
                    n = e.next("ul");
                0 < n.length && ("close" == i ? ("load" == t.type ? t.cache ? n.html() ? n.addClass(C) : t.getChild(e) : (n.html(""), t.getChild(e)) : n.addClass(C), t.accordionUL(n), t.operateIcon(o, a).open()) : "open" == i && (n.removeClass(C), t.operateIcon(o, a).close()))
            },
            ue.prototype.setDisabledNodes = function(e) {
                for (var t = e.split(","), o = 0; o < t.length; o++) {
                    var a = this.getNodeDom(t[o]).div(),
                        i = a.children("div." + D).children("i[data-par]"),
                        n = a.children("cite[data-leaf]");
                    null != a && "true" != a.attr("dtree-disabled") && (a.attr("dtree-disabled", "true"), i.attr("dtree-disabled", "true"), i.addClass(T), n.attr("dtree-disabled", "true"), n.addClass(T))
                }
            },
            ue.prototype.cancelDisabledNodes = function(e) {
                for (var t = e.split(","), o = 0; o < t.length; o++) {
                    var a = this.getNodeDom(t[o]).div(),
                        i = a.children("div." + D).children("i[data-par]"),
                        n = a.children("cite[data-leaf]");
                    null != a && "true" == a.attr("dtree-disabled") && (a.attr("dtree-disabled", "false"), i.attr("dtree-disabled", "false"), i.removeClass(T), n.attr("dtree-disabled", "false"), n.removeClass(T))
                }
            },
            ue.prototype.getDisabledNodesParam = function(e) {
                for (var t = e.split(","), o = [], a = 0; a < t.length; a++) {
                    var i = this.getNodeDom(t[a]).div();
                    null != i && "true" == i.attr("dtree-disabled") && o.push(this.getRequestParam(this.getTempNodeParam(i)))
                }
                return o
            },
            ue.prototype.getAllDisabledNodesParam = function() {
                var t = this,
                    o = [];
                return t.obj.find("div[dtree-click='" + z + "'][dtree-disabled='true']").each(function() {
                    var e = y(this);
                    o.push(t.getRequestParam(t.getTempNodeParam(e)))
                }),
                    o
            },
            ue.prototype.setHideNodes = function(e) {
                for (var t = e.split(","), o = 0; o < t.length; o++) {
                    var a = this.getNodeDom(t[o]).div(),
                        i = a.parent("li[dtree-hide]");
                    null != a && "true" != a.attr("dtree-hide") && (a.attr("dtree-hide", "true"), i.attr("dtree-hide", "true"), i.addClass(x))
                }
            },
            ue.prototype.cancelHideNodes = function(e) {
                for (var t = e.split(","), o = 0; o < t.length; o++) {
                    var a = this.getNodeDom(t[o]).div(),
                        i = a.parent("li[dtree-hide]");
                    null != a && "true" == a.attr("dtree-hide") && (a.attr("dtree-hide", "false"), i.attr("dtree-hide", "false"), i.removeClass(x))
                }
            },
            ue.prototype.getHideNodesParam = function(e) {
                for (var t = e.split(","), o = [], a = 0; a < t.length; a++) {
                    var i = this.getNodeDom(t[a]).div();
                    null != i && "true" == i.attr("dtree-hide") && o.push(this.getRequestParam(this.getTempNodeParam(i)))
                }
                return o
            },
            ue.prototype.getAllHideNodesParam = function() {
                var t = this,
                    o = [];
                return t.obj.find("div[dtree-click='" + z + "'][dtree-hide='true']").each(function() {
                    var e = y(this);
                    o.push(t.getRequestParam(t.getTempNodeParam(e)))
                }),
                    o
            },
            ue.prototype.refreshTree = function() {
                this.obj.html(""),
                    this.initNodeParam(),
                    this.init()
            },
            ue.prototype.partialRefreshAdd = function(e, t) {
                var o = this;
                $ul = e.next("ul");
                var a = e.find("i[data-spread]");
                if ("last" == a.eq(0).attr("data-spread") ? o.operateIcon(a.eq(0), a.eq(1)).openWithLeaf() : o.operateIcon(a.eq(0), a.eq(1)).open(), $ul.addClass(C), o.accordionUL($ul), t) if (t.length && 0 < t.length) o.getChild(e, t);
                else {
                    var i = o.parseData(t);
                    if (i.treeId()) {
                        var n = parseInt(e.parent("li").attr("data-index")) + 1;
                        $ul.append(o.getLiItemDom(i.treeId(), i.parentId(), i.title(), i.fmtTitle(), i.last(0), i.ficonClass(), i.iconClass(), i.checkArr(), n, i.spread(), i.disabled(), i.hide(), i.basicData(), i.recordData(), "item")),
                            $thisDiv = $ul.find("div[data-id='" + i.treeId() + "']"),
                            o.setNodeParam($thisDiv),
                            o.showLine($ul.find("li"))
                    } else f.msg("添加失败,节点ID为undefined！", {
                        icon: 5
                    }),
                        o.setNodeParam(e)
                } else o.getChild(e)
            },
            ue.prototype.partialRefreshEdit = function(e, t) {
                var o = this;
                if ($ul = e.next("ul"), t) if ("object" == typeof t) {
                    var a = o.parseData(t);
                    if (a.treeId()) {
                        var i = o.replaceDom(e, a.treeId(), a.last(0), a.spread(), a.disabled(), a.hide());
                        i.node(a.iconClass()),
                            i.checkbox(a.checkArr()),
                            i.text(a.title()),
                            i.ul(),
                            i.basicData(a.basicData()),
                            i.recordData(a.recordData()),
                            o.setNodeParam(e)
                    } else f.msg("编辑失败,节点ID为undefined！", {
                        icon: 5
                    }),
                        o.setNodeParam(e)
                } else o.getNodeDom(e).cite().html(t)
            },
            ue.prototype.partialRefreshDel = function(e) {
                var t = this;
                if ($p_li = e.parent("li"), $p_ul = t.getNodeDom(e).parentUl(), $p_div = t.getNodeDom(e).parentDiv(), $p_li.remove(), t.showLine($p_ul.find("li")), 0 == $p_ul.children("li").length) {
                    var o = $p_div.find("i[data-spread]");
                    t.operateIcon(o.eq(0), o.eq(1)).closeWithLeaf()
                }
                t.initNodeParam()
            },
            ue.prototype.chooseDataInit = function(e) {
                for (var t = this,
                         o = e.split(","), a = 0; a < o.length; a++) t.obj.find("i[dtree-click='" + J + "']").each(function() {
                    y(this).attr("data-id") == o[a] && t.checkStatus(y(this)).check()
                });
                var i = t.obj.find("i[dtree-click='" + J + "'][data-checked='1']").parents("." + k);
                return i.children("ul").addClass(C),
                    i.children("." + S).children("i[data-spread]." + se.trimToDot(t.usefontStyle.fnode.node.close)).addClass(t.usefontStyle.fnode.node.open),
                    i.children("." + S).children("i[data-spread]." + se.trimToDot(t.usefontStyle.fnode.node.close)).removeClass(t.usefontStyle.fnode.node.close),
                    i.children("." + S).children("i[data-spread]." + se.trimToDot(t.usefontStyle.snode.node.close)).addClass(t.usefontStyle.snode.node.open),
                    i.children("." + S).children("i[data-spread]." + se.trimToDot(t.usefontStyle.snode.node.close)).removeClass(t.usefontStyle.snode.node.close),
                    t.getCheckbarNodesParam()
            },
            ue.prototype.checkAllOrNot = function(e) {
                var t = this,
                    o = e.attr("data-par"),
                    a = e.attr("data-type"),
                    i = e.closest(o),
                    n = e.parents(o),
                    s = i.find(o);
                if ("1" == e.attr("data-checked")) {
                    t.checkStatus(e).noCheck();
                    var r = s.find(">." + S + ">." + D + ">i[data-type='" + a + "']");
                    t.checkStatus(r).noCheck();
                    for (var l = 1,
                             d = n; l < d.length; l++) {
                        if (0 == d.eq(l).find(">." + m + " ." + D + ">i[data-type='" + a + "'][data-checked='1']").length) {
                            var c = d.eq(l).find(">." + S + ">." + D + ">i[data-type='" + a + "']");
                            t.checkStatus(c).noCheck()
                        }
                    }
                } else {
                    t.checkStatus(e).check();
                    r = s.find(">." + S + ">." + D + ">i[data-type='" + a + "']");
                    t.checkStatus(r).check();
                    for (l = 1, d = n; l < d.length; l++) {
                        c = d.eq(l).find(">." + S + ">." + D + ">i[data-type='" + a + "']");
                        t.checkStatus(c).check()
                    }
                }
            },
            ue.prototype.checkAllOrNoallOrNot = function(e) {
                var t = this,
                    o = (e.closest("." + S), e.attr("data-par")),
                    a = e.attr("data-type"),
                    i = e.closest(o),
                    n = e.parents(o),
                    s = i.find(o);
                if ("1" == e.attr("data-checked")) {
                    t.checkStatus(e).noCheck();
                    var r = s.find(">." + S + ">." + D + ">i[data-type='" + a + "']");
                    t.checkStatus(r).noCheck();
                    for (var l = 1,
                             d = n; l < d.length; l++) {
                        var c = d.eq(l).find(">." + m + " ." + D + ">i[data-type='" + a + "'][data-checked='1']").length,
                            h = d.eq(l).find(">." + S + ">." + D + ">i[data-type='" + a + "']");
                        0 == c ? t.checkStatus(h).noCheck() : t.checkStatus(h).noallCheck()
                    }
                } else {
                    t.checkStatus(e).check();
                    r = s.find(">." + S + ">." + D + ">i[data-type='" + a + "']");
                    t.checkStatus(r).check();
                    for (l = 1, d = n; l < d.length; l++) {
                        var u = d.eq(l).find(">." + m + " ." + D + ">i[data-type='" + a + "'][data-checked='1']").length,
                            f = d.eq(l).find(">." + m + " ." + D + ">i[data-type='" + a + "']").length;
                        h = d.eq(l).find(">." + S + ">." + D + ">i[data-type='" + a + "']");
                        u != f ? t.checkStatus(h).noallCheck() : t.checkStatus(h).check()
                    }
                }
            },
            ue.prototype.checkAllOrPcascOrNot = function(e) {
                e.closest("." + S);
                var t = e.attr("data-par"),
                    o = e.attr("data-type"),
                    a = e.closest(t),
                    i = (e.parents(t), a.find(t));
                if ("1" == e.attr("data-checked")) {
                    this.checkStatus(e).noCheck();
                    var n = i.find(">." + S + ">." + D + ">i[data-type='" + o + "']");
                    this.checkStatus(n).noCheck()
                } else {
                    this.checkStatus(e).check();
                    n = i.find(">." + S + ">." + D + ">i[data-type='" + o + "']");
                    this.checkStatus(n).check()
                }
            },
            ue.prototype.checkOrNot = function(e) {
                e.closest("." + S);
                var t = e.attr("data-par"),
                    o = (e.attr("data-type"), e.closest(t));
                e.parents(t),
                    o.find(t);
                "1" == e.attr("data-checked") ? this.checkStatus(e).noCheck() : this.checkStatus(e).check()
            },
            ue.prototype.checkOnly = function(e) {
                e.closest("." + S);
                var t = e.attr("data-par"),
                    o = (e.attr("data-type"), e.closest(t)),
                    a = (e.parents(t), o.find(t), e.attr("data-checked")),
                    i = this.obj.find("i[data-checked]");
                this.checkStatus(i).noCheck(),
                "1" != a && this.checkStatus(e).check()
            },
            ue.prototype.changeCheck = function() {
                var e = this,
                    t = e.temp[0];
                "all" == e.checkbarType ? e.checkAllOrNot(t) : "no-all" == e.checkbarType ? e.checkAllOrNoallOrNot(t) : "p-casc" == e.checkbarType ? e.checkAllOrPcascOrNot(t) : "self" == e.checkbarType ? e.checkOrNot(t) : "only" == e.checkbarType ? e.checkOnly(t) : e.checkAllOrNot(t);
                var o = e.setAndGetCheckbarNodesParam();
                e.checkbarFun.chooseDone(o),
                    layui.event.call(this, u, "chooseDone(" + y(e.obj)[0].id + ")", {
                        checkbarParams: o
                    }),
                    e.temp = []
            },
            ue.prototype.initNoAllCheck = function() {
                var e = this.obj.find("i[data-checked='1']");
                if (0 < e.length) for (var t = 0; t < e.length; t++) for (var o = y(e[t]), a = o.attr("data-par"), i = o.attr("data-type"), n = o.closest(a), s = o.parents(a), r = (n.find(a), 1), l = s; r < l.length; r++) {
                    var d = l.eq(r).find(">." + m + " ." + D + ">i[data-type='" + i + "'][data-checked='1']").length,
                        c = l.eq(r).find(">." + m + " ." + D + ">i[data-type='" + i + "']").length,
                        h = l.eq(r).find(">." + S + ">." + D + ">i[data-type='" + i + "']");
                    d != c ? this.checkStatus(h).noallCheck() : this.checkStatus(h).check()
                }
            },
            ue.prototype.initAllCheck = function() {
                var e = this.obj.find("i[data-checked='1']");
                if (0 < e.length) for (var t = 0; t < e.length; t++) for (var o = y(e[t]), a = o.attr("data-par"), i = o.attr("data-type"), n = o.closest(a), s = o.parents(a), r = (n.find(a), 1), l = s; r < l.length; r++) {
                    var d = l.eq(r).find(">." + S + ">." + D + ">i[data-type='" + i + "']");
                    this.checkStatus(d).check()
                }
            },
            ue.prototype.checkStatus = function(e) {
                var t = this;
                return {
                    check: function() {
                        e.removeClass(t.usefontStyle.checkbox.out),
                            e.removeClass(t.usefontStyle.checkbox.noall),
                            e.addClass(t.usefontStyle.checkbox.on),
                            e.addClass(t.style.chs),
                            e.attr("data-checked", "1")
                    },
                    noCheck: function() {
                        e.removeClass(t.usefontStyle.checkbox.noall),
                            e.removeClass(t.usefontStyle.checkbox.on),
                            e.removeClass(t.style.chs),
                            e.addClass(t.usefontStyle.checkbox.out),
                            e.attr("data-checked", "0")
                    },
                    noallCheck: function() {
                        e.removeClass(t.usefontStyle.checkbox.out),
                            e.removeClass(t.usefontStyle.checkbox.on),
                            e.addClass(t.usefontStyle.checkbox.noall),
                            e.addClass(t.style.chs),
                            e.attr("data-checked", "2")
                    }
                }
            },
            ue.prototype.setAndGetCheckbarNodesParam = function() {
                var o = this;
                return o.checkbarNode = [],
                    "change" == o.checkbarData ? o.obj.find("i[data-par][dtree-disabled='false']").each(function() {
                        var e = y(this),
                            t = e.closest("." + S);
                        e.attr("data-checked") != e.attr("data-initchecked") && o.checkbarNode.push(o.getRequestParam(o.getCheckbarNodeParam(t, e)))
                    }) : "all" == o.checkbarData ? o.obj.find("i[data-par][data-checked][dtree-disabled='false']").each(function() {
                        var e = y(this),
                            t = e.closest("." + S);
                        o.checkbarNode.push(o.getRequestParam(o.getCheckbarNodeParam(t, e)))
                    }) : "choose" == o.checkbarData ? o.obj.find("i[data-par][data-checked='1'][dtree-disabled='false']").each(function() {
                        var e = y(this),
                            t = e.closest("." + S);
                        o.checkbarNode.push(o.getRequestParam(o.getCheckbarNodeParam(t, e)))
                    }) : "halfChoose" == o.checkbarData && (o.obj.find("i[data-par][data-checked='1'][dtree-disabled='false']").each(function() {
                        var e = y(this),
                            t = e.closest("." + S);
                        o.checkbarNode.push(o.getRequestParam(o.getCheckbarNodeParam(t, e)))
                    }), o.obj.find("i[data-par][data-checked='2'][dtree-disabled='false']").each(function() {
                        var e = y(this),
                            t = e.closest("." + S);
                        o.checkbarNode.push(o.getRequestParam(o.getCheckbarNodeParam(t, e)))
                    })),
                    o.checkbarNode
            },
            ue.prototype.getCheckbarNodesParam = function() {
                return this.setAndGetCheckbarNodesParam()
            },
            ue.prototype.getCheckbarNodeParam = function(e, t) {
                var o = this,
                    a = {};
                return a.nodeId = e.attr("data-id"),
                    a.parentId = o.getNodeDom(e).parentLi().attr("data-pid"),
                    a.context = "function" == typeof o.formatter.title ? o.getNodeDom(e).cite().attr("data-title") : o.getNodeDom(e).cite().text(),
                    a.leaf = "leaf" == o.getNodeDom(e).cite().attr("data-leaf"),
                    a.level = o.getNodeDom(e).parentLi().attr("data-index"),
                    a.spread = "open" == o.getNodeDom(e).fnode().attr("data-spread"),
                    a.basicData = e.attr("data-basic"),
                    a.recordData = e.attr("data-record"),
                    a.dataType = t.attr("data-type"),
                    a.checked = t.attr("data-checked"),
                    a.initchecked = t.attr("data-initchecked"),
                    a
            },
            ue.prototype.changeCheckbarNodes = function() {
                var t = !1;
                return this.obj.find("i[data-par]").each(function() {
                    var e = y(this);
                    if ($div = e.closest("." + S), e.attr("data-checked") != e.attr("data-initchecked")) return t = !0
                }),
                    t
            },
            ue.prototype.initTreePlus = function() {
                var e = this;
                e.obj.prevAll("div#dtree_menubar_" + e.obj[0].id).remove(),
                    e.toolbarMenu = {},
                e.menubar && e.menubarTips.group && 0 < e.menubarTips.group.length && e.obj.before("<div class='dtree-menubar' id='dtree_menubar_" + e.obj[0].id + "'><div class='layui-btn-group'></div></div>"),
                e.toolbar && "contextmenu" == e.toolbarWay && (e.obj.prevAll("div#dtree_toolbar_" + e.obj[0].id).remove(), e.obj.before("<div class='" + t + " layui-nav' id='dtree_toolbar_" + e.obj[0].id + "'><div class='layui-nav-item'><dl class='layui-nav-child layui-anim'></dl></div></div>"))
            },
            ue.prototype.openTreePlus = function() {
                var e = this,
                    t = [];
                if (e.toolbar && e.getToolbarDom(), e.menubar) {
                    var o = e.menubarTips,
                        a = o.toolbar,
                        i = o.group;
                    o.freedom;
                    if (a && 0 < a.length) for (var n = 0; n < a.length; n++) {
                        var s = a[n];
                        "string" == typeof s && e.getMenubarToolDom(s),
                        "object" == typeof s && e.getExtMenubarToolDom(s)
                    }
                    if (i && 0 < i.length) {
                        for (n = 0; n < i.length; n++) {
                            var r = i[n];
                            "string" == typeof r && t.push(e.getMenubarDom(r)),
                            "object" == typeof r && t.push(e.getExtMenubarDom(r))
                        }
                        e.obj.prevAll("div#dtree_menubar_" + e.obj[0].id).children("div.layui-btn-group").append(t.join(""))
                    }
                }
            },
            ue.prototype.getMenubarDom = function(e) {
                var t = this,
                    o = t.obj[0].id,
                    a = "";
                switch (e) {
                    case Y:
                        a = "<button type='button' class='layui-btn layui-btn-sm layui-btn-primary' dtree-id='" + o + "' d-menu='" + Y + "' title='展开全部节点'><i class='" + t.usefontStyle.menubar.movedown + "'></i></button>";
                        break;
                    case Z:
                        a = "<button type='button' class='layui-btn layui-btn-sm layui-btn-primary' dtree-id='" + o + "' d-menu='" + Z + "' title='收缩全部节点'><i class='" + t.usefontStyle.menubar.moveup + "'></i></button>";
                        break;
                    case ee:
                        a = "<button type='button' class='layui-btn layui-btn-sm layui-btn-primary' dtree-id='" + o + "' d-menu='" + ee + "' title='刷新'><i class='" + t.usefontStyle.menubar.refresh + "'></i></button>";
                        break;
                    case te:
                        a = t.checkbar && "only" != t.checkbarType ? "<button type='button' class='layui-btn layui-btn-sm layui-btn-primary' dtree-id='" + o + "' d-menu='" + te + "' title='全选节点'><i class='" + t.usefontStyle.menubar.checkAll + "'></i></button>": "";
                        break;
                    case oe:
                        a = t.checkbar && "only" != t.checkbarType ? "<button type='button' class='layui-btn layui-btn-sm layui-btn-primary' dtree-id='" + o + "' d-menu='" + oe + "' title='全不选节点'><i class='" + t.usefontStyle.menubar.unCheckAll + "'></i></button>": "";
                        break;
                    case ae:
                        a = t.checkbar && "only" != t.checkbarType ? "<button type='button' class='layui-btn layui-btn-sm layui-btn-primary' dtree-id='" + o + "' d-menu='" + ae + "' title='反选节点'><i class='" + t.usefontStyle.menubar.invertAll + "'></i></button>": "";
                        break;
                    case ie:
                        a = t.checkbar ? "<button type='button' class='layui-btn layui-btn-sm layui-btn-primary' dtree-id='" + o + "' d-menu='" + ie + "' title='删除选中节点'><i class='" + t.usefontStyle.menubar.remove + "'></i></button>": "";
                        break;
                    case ne:
                        a = "<button type='button' class='layui-btn layui-btn-sm layui-btn-primary' dtree-id='" + o + "' d-menu='" + ne + "' title='查询节点'><i class='" + t.usefontStyle.menubar.search + "'></i></button>"
                }
                return a
            },
            ue.prototype.getExtMenubarDom = function(e) {
                return "<button type='button' class='layui-btn layui-btn-sm layui-btn-primary' dtree-id='" + this.obj[0].id + "' d-menu='" + e.menubarId + "' title='" + e.title + "'><i class='" + this.usefontStyle.menubarExt + " " + e.icon + "'></i></button>"
            },
            ue.prototype.getMenubarToolDom = function(e) {
                var t = this;
                t.obj[0].id;
                switch (e) {
                    case Y:
                        t.toolbarMenu[Y] = t.setToolbarDom().setMenuToolbarOption(Y, t.toolbarStyle.title, t.usefontStyle.toolbar.menubar.movedown, "展开全部");
                        break;
                    case Z:
                        t.toolbarMenu[Z] = t.setToolbarDom().setMenuToolbarOption(Z, t.toolbarStyle.title, t.usefontStyle.toolbar.menubar.moveup, "收缩全部");
                        break;
                    case ee:
                        t.toolbarMenu[ee] = t.setToolbarDom().setMenuToolbarOption(ee, t.toolbarStyle.title, t.usefontStyle.toolbar.menubar.refresh, "刷新");
                        break;
                    case te:
                        t.checkbar && "only" != t.checkbarType && (t.toolbarMenu[te] = t.setToolbarDom().setMenuToolbarOption(te, t.toolbarStyle.title, t.usefontStyle.toolbar.menubar.checkAll, "全选节点"));
                        break;
                    case oe:
                        t.checkbar && "only" != t.checkbarType && (t.toolbarMenu[oe] = t.setToolbarDom().setMenuToolbarOption(oe, t.toolbarStyle.title, t.usefontStyle.toolbar.menubar.unCheckAll, "全不选节点"));
                        break;
                    case ae:
                        t.checkbar && "only" != t.checkbarType && (t.toolbarMenu[ae] = t.setToolbarDom().setMenuToolbarOption(ae, t.toolbarStyle.title, t.usefontStyle.toolbar.menubar.invertAll, "反选节点"));
                        break;
                    case ie:
                        t.checkbar && (t.toolbarMenu[ie] = t.setToolbarDom().setMenuToolbarOption(ie, t.toolbarStyle.title, t.usefontStyle.toolbar.menubar.remove, "删除选中"));
                        break;
                    case ne:
                        t.toolbarMenu[ne] = t.setToolbarDom().setMenuToolbarOption(ne, t.toolbarStyle.title, t.usefontStyle.toolbar.menubar.searchNode, "查询")
                }
            },
            ue.prototype.getExtMenubarToolDom = function(e) {
                this.toolbarMenu[e.menubarId] = this.setToolbarDom().setMenuToolbarOption(e.menubarId, e.title, this.usefontStyle.toolbar.menubarExt + " " + e.icon, "")
            },
            ue.prototype.menubarMethod = function() {
                var c = this;
                return {
                    openAllNode: function(e) {
                        for (var t = e || c.obj.children("li").children("ul"), o = 0; o < t.length; o++) {
                            var a = y(t[o]),
                                i = a.prev("div"),
                                n = c.getNodeDom(i).fnode(),
                                s = c.getNodeDom(i).snode(),
                                r = c.getNodeDom(i).cite(),
                                l = n.attr("data-spread");
                            if ("leaf" != r.attr("data-leaf")) {
                                "open" == l || ("load" == c.type ? c.cache ? a.html() ? a.addClass(C) : c.getChild(i) : (a.html(""), c.getChild(i)) : a.addClass(C), c.operateIcon(n, s).open());
                                var d = a.children("li").children("ul");
                                c.menubarMethod().openAllNode(d)
                            }
                        }
                    },
                    closeAllNode: function() {
                        c.obj.find("." + m).each(function() {
                            var e = y(this),
                                t = e.prev("div"),
                                o = c.getNodeDom(t).fnode(),
                                a = c.getNodeDom(t).snode(),
                                i = c.getNodeDom(t).cite();
                            o.attr("data-spread"),
                                i.attr("data-leaf");
                            e.removeClass(C),
                                c.operateIcon(o, a).close()
                        })
                    },
                    refreshTree: function() {
                        c.refreshTree()
                    },
                    checkAll: function() {
                        var e = c.obj.find("i[data-par][data-checked!='1']");
                        0 < e.length && c.checkStatus(e).check()
                    },
                    unCheckAll: function() {
                        var e = c.obj.find("i[data-par][data-checked!='0']");
                        0 < e.length && c.checkStatus(e).noCheck()
                    },
                    invertAll: function() {
                        if (0 < c.obj.find("i[data-par]").length) {
                            var t = !1;
                            c.obj.find("i[data-par]").each(function() {
                                var e = y(this);
                                "2" == e.attr("data-checked") ? t = !0 : "0" == e.attr("data-checked") ? c.checkStatus(e).check() : "1" == e.attr("data-checked") && c.checkStatus(e).noCheck()
                            }),
                                t ? c.initNoAllCheck() : c.initAllCheck()
                        }
                    },
                    remove: function() {
                        if (0 == c.obj.find("i[data-par][data-checked='1']").length) f.msg("请至少选中一个节点", {
                            icon: 2
                        });
                        else {
                            c.checkbarNode = [];
                            c.obj.find("i[data-par][data-checked='1']").each(function() {
                                var e = y(this),
                                    t = e.closest("." + S);
                                c.checkbarNode.push(c.getRequestParam(c.getCheckbarNodeParam(t, e)))
                            }),
                                f.confirm("确定要删除选中节点？", {
                                        icon: 3,
                                        title: "删除选中节点"
                                    },
                                    function(e) {
                                        c.menubarFun.remove(c.checkbarNode) && (c.obj.find("i[data-par][data-checked='1']").closest("." + S).next("ul").remove(), c.obj.find("i[data-par][data-checked='1']").closest("." + S).remove(), c.checkbarNode = []),
                                            f.close(e)
                                    })
                        }
                    },
                    searchNode: function() {
                        f.prompt({
                                formType: 0,
                                value: "",
                                title: "查询节点"
                            },
                            function(e, t, o) {
                                e ? c.searchNode(e) || f.msg("该名称节点不存在！", {
                                    icon: 5
                                }) : f.msg("未指定查询节点名称", {
                                    icon: 5
                                });
                                f.close(t)
                            })
                    },
                    extMethod: function(e, t, o) {
                        if (c.menubar && c.menubarTips.group && 0 < c.menubarTips.group.length && "group" == o) for (var a = 0; a < c.menubarTips.group.length; a++) {
                            if (e == (i = c.menubarTips.group[a]).menubarId) {
                                i.handler(c.getRequestParam(c.getNodeParam(t), t));
                                break
                            }
                        }
                        if (c.menubar && c.menubarTips.toolbar && 0 < c.menubarTips.toolbar.length && "toolbar" == o) for (a = 0; a < c.menubarTips.toolbar.length; a++) {
                            if (e == (i = c.menubarTips.toolbar[a]).menubarId) {
                                i.handler(c.getRequestParam(c.getNodeParam(t), t));
                                break
                            }
                        }
                        if (c.menubar && c.menubarTips.freedom && 0 < c.menubarTips.freedom.length && "freedom" == o) for (a = 0; a < c.menubarTips.freedom.length; a++) {
                            var i;
                            if (e == (i = c.menubarTips.freedom[a]).menubarId) {
                                i.handler(c.getRequestParam(c.getNodeParam(t), t));
                                break
                            }
                        }
                    }
                }
            },
            ue.prototype.menubarListener = function(e, t) {
                var o = this,
                    a = o.getNodeDom().nowDiv();
                switch (e) {
                    case Y:
                        o.menubarMethod().openAllNode();
                        break;
                    case Z:
                        o.menubarMethod().closeAllNode();
                        break;
                    case ee:
                        o.menubarMethod().refreshTree();
                        break;
                    case te:
                        o.menubarMethod().checkAll();
                        break;
                    case oe:
                        o.menubarMethod().unCheckAll();
                        break;
                    case ae:
                        o.menubarMethod().invertAll();
                        break;
                    case ie:
                        o.menubarMethod().remove();
                        break;
                    case ne:
                        o.menubarMethod().searchNode();
                        break;
                    default:
                        o.menubarMethod().extMethod(e, a, t)
                }
            },
            ue.prototype.searchNode = function(a) {
                var e = !1,
                    i = [];
                if (this.obj.find("cite[data-leaf]").each(function() {
                    var e = y(this);
                    if ( - 1 < e.html().indexOf(a)) {
                        if ("leaf" == e.attr("data-leaf")) {
                            var t = "";
                            e.parents("li").each(function() {
                                t = "-" + y(this).find("cite[data-leaf]").html() + t
                            }),
                                t = t.substring(1, t.length),
                                e.attr("title", t)
                        }
                        var o = 0;
                        e.parents("li").each(function() {
                            if ( - 1 < y(this).find("cite[data-leaf]").html().indexOf(a) && o++, 2 <= o) return ! 0
                        }),
                        o < 2 && i.push(e.closest("li").prop("outerHTML"))
                    }
                }), 0 < i.length) {
                    e = !0,
                        this.obj.html("");
                    for (var t = 0; t < i.length; t++) this.obj.append(i[t])
                }
                return e
            },
            ue.prototype.getToolbarDom = function() {
                var e = this,
                    t = e.toolbarShow,
                    o = e.toolbarExt;
                e.toolbarWay;
                if (0 < t.length) for (var a = 0; a < t.length; a++) {
                    var i = t[a];
                    "pulldown" == i && (e.toolbarMenu[G] = e.setToolbarDom().setToolbarOption(G, e.toolbarStyle.title, e.usefontStyle.toolbar.pulldown, "展开")),
                    "pullup" == i && (e.toolbarMenu[X] = e.setToolbarDom().setToolbarOption(X, e.toolbarStyle.title, e.usefontStyle.toolbar.pullup, "收缩")),
                    "add" == i && (e.toolbarMenu[K] = e.setToolbarDom().setToolbarOption(K, e.toolbarStyle.title, e.usefontStyle.toolbar.add, "新增")),
                    "edit" == i && (e.toolbarMenu[Q] = e.setToolbarDom().setToolbarOption(Q, e.toolbarStyle.title, e.usefontStyle.toolbar.edit, "编辑")),
                    "delete" == i && (e.toolbarMenu[V] = e.setToolbarDom().setToolbarOption(V, e.toolbarStyle.title, e.usefontStyle.toolbar.del, "删除"))
                }
                if (0 < o.length) for (a = 0; a < o.length; a++) {
                    var n = o[a];
                    e.toolbarMenu[n.toolbarId] = e.setToolbarDom().setToolbarOption(n.toolbarId, n.title, e.usefontStyle.toolbarExt + " " + n.icon, "")
                }
            },
            ue.prototype.setToolbarDom = function() {
                var n = this,
                    s = n.toolbarWay;
                return {
                    setToolbarOption: function(e, t, o, a) {
                        return "contextmenu" == s ? "<dd><a dtree-tool='" + e + "'><i class='" + o + "'></i>&nbsp;" + a + t + "</a></dd>": "fixed" == s || "follow" == s ? "<a dtree-tool='" + e + "' title='" + a + t + "'><i class='" + o + "'></i></a>": void 0
                    },
                    setMenuToolbarOption: function(e, t, o, a) {
                        var i = n.obj[0].id;
                        return "contextmenu" == s ? "<dd><a dtree-id='" + i + "' d-menu='" + e + "'><i class='" + o + "'></i>&nbsp;" + a + t + "</a></dd>": "fixed" == s || "follow" == s ? "<a dtree-id='" + i + "' d-menu='" + e + "' title='" + a + t + "'><i class='" + o + "'></i></a>": void 0
                    },
                    setToolbarPlace: function(e) {
                        if ("contextmenu" == s) {
                            if (e) for (var t in n.obj.prevAll("div#dtree_toolbar_" + n.obj[0].id).find("div.layui-nav-item>dl.layui-nav-child").html(""), e) n.obj.prevAll("div#dtree_toolbar_" + n.obj[0].id).find("div.layui-nav-item>dl.layui-nav-child").append(e[t])
                        } else "fixed" != s && "follow" != s || n.obj.find("cite[data-leaf][dtree-disabled='false']").each(function() {
                            var e = y(this);
                            n.dynamicToolbarDom(e)
                        })
                    }
                }
            },
            ue.prototype.dynamicToolbarDom = function(e) {
                var t = this,
                    o = t.toolbarWay;
                if (0 == e.next("em." + l).length) {
                    var a = e.parent("div"),
                        i = t.getRequestParam(t.getTempNodeParam(a)),
                        n = t.toolbarFun.loadToolbarBefore(se.cloneObj(t.toolbarMenu), i, a),
                        s = ["<em class='" + l + " " + ("follow" == o ? x: "") + "'>"];
                    if (n) for (var r in n) s.push(n[r]);
                    s.push("</em>"),
                        e.after(s.join(""))
                }
            },
            ue.prototype.toolbarHide = function() {
                this.toolbar && "contextmenu" == this.toolbarWay && this.obj.prevAll("div#dtree_toolbar_" + this.obj[0].id).find(".layui-nav-child").removeClass("layui-anim-fadein layui-show")
            },
            ue.prototype.toolbarMethod = function() {
                var c = this;
                return {
                    pulldown: function(e) {
                        if (e) for (var t = e,
                                        o = 0; o < t.length; o++) {
                            var a = y(t[o]),
                                i = a.prev("div"),
                                n = c.getNodeDom(i).fnode(),
                                s = c.getNodeDom(i).snode(),
                                r = c.getNodeDom(i).cite(),
                                l = n.attr("data-spread");
                            if ("leaf" != r.attr("data-leaf")) {
                                "open" == l || ("load" == c.type ? c.cache ? a.html() ? a.addClass(C) : c.getChild(i) : (a.html(""), c.getChild(i)) : a.addClass(C), c.operateIcon(n, s).open());
                                var d = a.children("li").children("ul");
                                c.toolbarMethod().pulldown(d)
                            }
                        }
                    },
                    pullup: function(e) {
                        e.find("." + m).each(function() {
                            var e = y(this),
                                t = e.prev("div"),
                                o = c.getNodeDom(t).fnode(),
                                a = c.getNodeDom(t).snode(),
                                i = c.getNodeDom(t).cite();
                            o.attr("data-spread"),
                                i.attr("data-leaf");
                            e.removeClass(C),
                                c.operateIcon(o, a).close()
                        })
                    }
                }
            },
            ue.prototype.toolbarListener = function(e, d) {
                var c = this,
                    a = d.children("cite[data-leaf]"),
                    h = d.next("ul"),
                    u = d.parent("li[data-index]"),
                    i = u.parent("ul").prev("div"),
                    n = a.html();
                switch (e) {
                    case G:
                        c.toolbarMethod().pulldown(h);
                        break;
                    case X:
                        c.toolbarMethod().pullup(u);
                        break;
                    case K:
                        var t = c.loadToolBar(n, K);
                        f.open({
                            title: "新增" + c.toolbarStyle.title,
                            type: 1,
                            area: c.toolbarStyle.area,
                            content: t,
                            success: function(e, l) {
                                r.render(),
                                    r.on("submit(dtree_addNode_form)",
                                        function(e) {
                                            e = e.field;
                                            var t = d.attr("data-id"),
                                                o = d.attr("data-id") + "_node_" + h[0].childNodes.length,
                                                a = parseInt(u.attr("data-index")) + 1,
                                                i = [];
                                            if (0 < c.checkArrLen) for (var n = 0; n < c.checkArrLen; n++) i.push({
                                                type: n,
                                                checked: "0"
                                            });
                                            h.append(c.getLiItemDom(o, t, e.addNodeName, e.addNodeName, !0, "", "", i, a, !1, !1, !1, "", "", "item")),
                                                h.find("li[data-id='" + o + "']").hide();
                                            var s = h.find("div[data-id='" + o + "']");
                                            node = c.getNodeParam(s);
                                            var r = c.getRequestParam(node);
                                            return r = y.extend(r, e),
                                                c.temp = [o, h, d, a],
                                                c.toolbarFun.addTreeNode(r, d),
                                                f.close(l),
                                                !1
                                        })
                            }
                        });
                        break;
                    case Q:
                        t = c.loadToolBar(n, Q);
                        f.open({
                            title: "编辑" + c.toolbarStyle.title,
                            type: 1,
                            area: c.toolbarStyle.area,
                            content: t,
                            success: function(e, o) {
                                c.toolbarFun.editTreeLoad(c.getRequestParam(c.getNodeParam(d))),
                                    r.render(),
                                    r.on("submit(dtree_editNode_form)",
                                        function(e) {
                                            e = e.field;
                                            a.html(e.editNodeName),
                                                node = c.getNodeParam(d);
                                            var t = c.getRequestParam(node);
                                            t = y.extend(t, e),
                                                c.temp = [a, d, n, i],
                                                c.toolbarFun.editTreeNode(t, d),
                                                f.close(o)
                                        })
                            }
                        });
                        break;
                    case V:
                        f.confirm("确定要删除该" + c.toolbarStyle.title + "？", {
                                icon: 3,
                                title: "删除" + c.toolbarStyle.title
                            },
                            function(e) {
                                c.getNodeParam(d);
                                c.temp = [u, i],
                                    c.toolbarFun.delTreeNode(c.getRequestParam(c.getNodeParam(d)), d),
                                    f.close(e)
                            });
                        break;
                    default:
                        if (0 < c.toolbarExt.length) for (var o = 0; o < c.toolbarExt.length; o++) {
                            var s = c.toolbarExt[o];
                            if (e == s.toolbarId) {
                                s.handler(c.getRequestParam(c.getNodeParam(d)), d);
                                break
                            }
                        }
                }
            },
            ue.prototype.loadToolBar = function(e, t) {
                var o = this,
                    a = (o.toolbarShow, o.toolbarBtn),
                    i = "";
                switch (t) {
                    case K:
                        var n = [{
                                label: "当前选中",
                                name: "nodeTitle",
                                type: "text",
                                value: e,
                                defElem: "nowChoose",
                                readonly: !0
                            },
                                {
                                    label: "新增" + o.toolbarStyle.title,
                                    name: "addNodeName",
                                    type: "text",
                                    value: "",
                                    defElem: "nowChange",
                                    verify: "required"
                                },
                                {
                                    type: "submit",
                                    value: "确认添加",
                                    defElem: "btn",
                                    filter: "dtree_addNode_form"
                                }],
                            s = ['<div class="' + g + '"><form class="layui-form layui-form-pane" lay-filter="dtree_addNode_form">'];
                        if (null != a && 0 < a.length && null != a[0] && null != a[0] && 0 < a[0].length) for (var r = a[0], l = 0; l < r.length; l++) {
                            "nowChoose" == (p = r[l].defElem) ? y.extend(n[0], r[l]) : "nowChange" == p ? y.extend(n[1], r[l]) : "btn" == p ? y.extend(n[2], r[l]) : n.push(r[l])
                        }
                        for (var d = 0; d < n.length; d++) {
                            switch ((m = n[d].type) || (m = "text"), m) {
                                case "text":
                                    s.push(o.loadToolBarDetail(n[d]).text());
                                    break;
                                case "textarea":
                                    s.push(o.loadToolBarDetail(n[d]).textarea());
                                    break;
                                case "select":
                                    s.push(o.loadToolBarDetail(n[d]).select());
                                    break;
                                case "hidden":
                                    s.push(o.loadToolBarDetail(n[d]).hidden())
                            }
                        }
                        var c = ['<div class="layui-form-item">', '<div class="layui-input-block" style="margin-left:0px;text-align:center;">'];
                        for (d = 0; d < n.length; d++) {
                            switch ((m = n[d].type) || (m = "text"), m) {
                                case "submit":
                                    c.push(o.loadToolBarDetail(n[d]).submit());
                                    break;
                                case "button":
                                    c.push(o.loadToolBarDetail(n[d]).button());
                                    break;
                                case "reset":
                                    c.push(o.loadToolBarDetail(n[d]).reset())
                            }
                        }
                        c.push("</div></div>"),
                            s.push(c.join("")),
                            s.push("</form></div>"),
                            i = s.join("");
                        break;
                    case Q:
                        var h = [{
                                label: "当前选中",
                                name: "nodeTitle",
                                type: "text",
                                value: e,
                                defElem: "nowChoose",
                                readonly: !0
                            },
                                {
                                    label: "编辑" + o.toolbarStyle.title,
                                    name: "editNodeName",
                                    type: "text",
                                    value: "",
                                    defElem: "nowChange",
                                    verify: "required"
                                },
                                {
                                    type: "submit",
                                    value: "确认编辑",
                                    defElem: "btn",
                                    filter: "dtree_editNode_form"
                                }],
                            u = ['<div class="' + g + '"><form class="layui-form layui-form-pane" lay-filter="dtree_editNode_form">'];
                        if (null != a && 0 < a.length && null != a[1] && null != a[1] && 0 < a[1].length) {
                            var f = a[1];
                            for (l = 0; l < f.length; l++) {
                                var p;
                                "nowChoose" == (p = f[l].defElem) ? y.extend(h[0], f[l]) : "nowChange" == p ? y.extend(h[1], f[l]) : "btn" == p ? y.extend(h[2], f[l]) : h.push(f[l])
                            }
                        }
                        for (d = 0; d < h.length; d++) {
                            switch ((m = h[d].type) || (m = "text"), m) {
                                case "text":
                                    u.push(o.loadToolBarDetail(h[d]).text());
                                    break;
                                case "textarea":
                                    u.push(o.loadToolBarDetail(h[d]).textarea());
                                    break;
                                case "select":
                                    u.push(o.loadToolBarDetail(h[d]).select());
                                    break;
                                case "hidden":
                                    u.push(o.loadToolBarDetail(h[d]).hidden())
                            }
                        }
                        var b = ['<div class="layui-form-item">', '<div class="layui-input-block" style="margin-left:0px;text-align:center;">'];
                        for (d = 0; d < h.length; d++) {
                            var m;
                            switch ((m = h[d].type) || (m = "text"), m) {
                                case "submit":
                                    b.push(o.loadToolBarDetail(h[d]).submit());
                                    break;
                                case "button":
                                    b.push(o.loadToolBarDetail(h[d]).button());
                                    break;
                                case "reset":
                                    b.push(o.loadToolBarDetail(h[d]).reset())
                            }
                        }
                        b.push("</div></div>"),
                            u.push(b.join("")),
                            u.push("</form></div>"),
                            i = u.join("")
                }
                return i
            },
            ue.prototype.loadToolBarDetail = function(a) {
                var i = "boolean" == typeof a.readonly && a.readonly,
                    n = "boolean" == typeof a.disabled && a.disabled,
                    s = a.id ? a.id: "",
                    r = a.name ? a.name: "",
                    l = a.value ? a.value: "",
                    d = a.verify ? a.verify: "",
                    e = a.placeholder ? a.placeholder: l;
                return {
                    text: function() {
                        return ['<div class="layui-form-item">', '<label class="layui-form-label" title="' + a.label + '">' + a.label + "：</label>", '<div class="layui-input-block f-input-par">', '<input type="text" class="layui-input f-input" value="' + l + '" placeholder="' + e + '" lay-verify="' + d + '" ', "" != s ? 'id="' + s + '" ': "", "" != r ? 'name="' + r + '" ': "", i ? "readonly ": "", n ? "disabled ": "", "/>", "</div>", "</div>"].join("")
                    },
                    textarea: function() {
                        return ['<div class="layui-form-item layui-form-text">', '<label class="layui-form-label" title="' + a.label + '">' + a.label + "：</label>", '<div class="layui-input-block f-input-par">', '<textarea class="layui-textarea f-input" value="' + l + '" placeholder="' + e + '" lay-verify="' + d + '" ', "" != s ? 'id="' + s + '" ': "", "" != r ? 'name="' + r + '" ': "", i ? "readonly ": "", n ? "disabled ": "", ">" + l + "</textarea>", "</div>", "</div>"].join("")
                    },
                    hidden: function() {
                        return ['<input type="hidden" class="layui-input f-input" value="' + l + '" lay-verify="' + d + '" ', "" != s ? 'id="' + s + '" ': "", "" != r ? 'name="' + r + '" ': "", i ? "readonly ": "", n ? "disabled ": "", "/>"].join("")
                    },
                    select: function() {
                        var e = "object" == typeof a.optionsData ? a.optionsData: a.optionsData(),
                            t = "";
                        for (var o in e) l == e[o] ? t += "<option value='" + o + "' selected>" + e[o] + "</option>": t += "<option value='" + o + "'>" + e[o] + "</option>";
                        return ['<div class="layui-form-item">', '<label class="layui-form-label" title="' + a.label + '">' + a.label + "：</label>", '<div class="layui-input-block f-input-par">', '<select lay-verify="' + d + '" ', "" != s ? 'id="' + s + '" ': "", "" != r ? 'name="' + r + '" ': "", i ? "readonly ": "", n ? "disabled ": "", ">", t, "</select>", "</div>", "</div>"].join("")
                    },
                    submit: function() {
                        return ['<button type="button" class="layui-btn layui-btn-normal btn-w100" lay-submit lay-filter="' + a.filter + '" ', "" != s ? 'id="' + s + '" ': "", "" != r ? 'name="' + r + '" ': "", ">" + l + "</button>"].join("")
                    },
                    button: function() {
                        return ['<button type="button" class="layui-btn layui-btn-normal btn-w100" ', "" != s ? 'id="' + s + '" ': "", "" != r ? 'name="' + r + '" ': "", " >" + l + "</button>"].join("")
                    },
                    reset: function() {
                        return ['<button type="reset" class="layui-btn layui-btn-primary btn-w100" ', "" != s ? 'id="' + s + '" ': "", "" != r ? 'name="' + r + '" ': "", ">" + l + "</button>"].join("")
                    }
                }
            },
            ue.prototype.changeTreeNodeAdd = function(e) {
                var t = this,
                    o = t.temp,
                    a = o[0],
                    i = o[1],
                    n = o[2],
                    s = o[3],
                    r = !1;
                if (console.log(e), e) {
                    var l = t.obj.find("[data-id='" + a + "']");
                    if ("object" == typeof e) {
                        l.remove();
                        var d = t.parseData(e);
                        if (!d.treeId()) return f.msg("添加失败,节点ID为undefined！", {
                            icon: 5
                        }),
                            i.find("li[data-id='" + a + "']").remove(),
                            t.setNodeParam(n),
                            void(t.temp = []);
                        i.append(t.getLiItemDom(d.treeId(), d.parentId(), d.title(), d.fmtTitle(), d.last(0), d.ficonClass(), d.iconClass(), d.checkArr(), s, d.spread(), d.disabled(), d.hide(), d.basicData(), d.recordData(), "item")),
                            l = i.find("div[data-id='" + d.treeId() + "']"),
                            t.setNodeParam(l)
                    } else "refresh" == e ? r = !0 : "string" != typeof e && "number" != typeof e && 1 != e || (l.attr("data-id", e), i.find("li[data-id='" + e + "']").show(), t.setNodeParam(l));
                    var c = n.find("i[data-spread]");
                    "last" == c.eq(0).attr("data-spread") ? t.operateIcon(c.eq(0), c.eq(1)).openWithLeaf() : t.operateIcon(c.eq(0), c.eq(1)).open(),
                        i.addClass(C),
                        t.accordionUL(i),
                        r ? t.getChild(n) : (t.showLine(i.find("li")), t.toolbar && "contextmenu" != t.toolbarWay && t.dynamicToolbarDom(l.find("cite[data-leaf]")))
                } else i.find("li[data-id='" + a + "']").remove(),
                    t.setNodeParam(n);
                t.temp = []
            },
            ue.prototype.changeTreeNodeDone = function(e) {
                r.val("dtree_editNode_form", e),
                    r.render()
            },
            ue.prototype.changeTreeNodeEdit = function(e) {
                var t = this,
                    o = t.temp,
                    a = o[0],
                    i = o[1],
                    n = o[2];
                o[3];
                if (e) {
                    if ("object" == typeof e) {
                        var s = t.parseData(data);
                        if (s.treeId()) {
                            var r = t.replaceDom(i, s.treeId(), s.last(0), s.spread(), s.disabled(), s.hide());
                            r.node(s.iconClass()),
                                r.checkbox(s.checkArr()),
                                r.text(s.title()),
                                r.ul(),
                                r.basicData(s.basicData()),
                                r.recordData(s.recordData()),
                                t.setNodeParam(i)
                        } else f.msg("编辑失败,节点ID为undefined！", {
                            icon: 5
                        }),
                            t.setNodeParam(i)
                    }
                } else a.html(n),
                    t.getNodeParam(i);
                t.temp = []
            },
            ue.prototype.changeTreeNodeDel = function(e) {
                var t = this,
                    o = t.temp,
                    a = o[0],
                    i = a.parent("ul"),
                    n = o[1];
                if (e) {
                    if (a.remove(), t.showLine(i.find("li")), 0 == i.children("li").length) {
                        var s = n.find("i[data-spread]");
                        t.operateIcon(s.eq(0), s.eq(1)).closeWithLeaf()
                    }
                    t.initNodeParam()
                }
                t.temp = []
            },
            ue.prototype.loadIframe = function(e, t) {
                var o = this,
                    a = o.getNodeDom(e).cite();
                if (!o.useIframe) return ! 1;
                var i = o.iframe.iframeElem,
                    n = o.iframe.iframeUrl,
                    s = "leaf" != o.iframe.iframeLoad || "leaf" == a.attr("data-leaf");
                if (s) {
                    if (! (0 < y(i).length)) return f.msg("iframe绑定异常，请确认页面中是否有iframe页对应的容器", {
                        icon: 5
                    }),
                        !1;
                    if (!n) return f.msg("数据请求异常，iframeUrl参数未指定", {
                        icon: 5
                    }),
                        !1;
                    var r = he(t); - 1 < n.indexOf("?") && (r = "&" + r.substring(1, r.length));
                    var l = n + r;
                    y(i).attr("src", l)
                }
                return s
            },
            ue.prototype.getIframeRequestParam = function(e) {
                var t = this.iframe.iframeRequest,
                    o = this.iframe.iframeDefaultRequest,
                    a = e || this.node,
                    i = {};
                for (var n in t) i[n] = t[n];
                for (var n in o) {
                    var s = o[n],
                        r = a[n];
                    "boolean" == typeof r ? i[s] = r: r && (i[s] = r)
                }
                var l = /[\u4E00-\u9FA5\uF900-\uFA2D]/;
                for (var n in i) if (l.test(i[n])) {
                    var d = i[n];
                    i[n] = encodeURI(encodeURI(d))
                }
                return i
            },
            ue.prototype.getNodeDom = function(e) {
                var t = this,
                    o = "object" == typeof e ? e: 0 == t.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']").length ? null: t.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']");
                return {
                    div: function() {
                        return o
                    },
                    fnode: function() {
                        return null == o ? null: o.find("i[data-spread]").eq(0)
                    },
                    snode: function() {
                        return null == o ? null: o.find("i[data-spread]").eq(1)
                    },
                    checkbox: function() {
                        return null == o ? null: o.find("i[data-par]")
                    },
                    cite: function() {
                        return null == o ? null: o.find("cite[data-leaf]")
                    },
                    nextUl: function() {
                        return null == o ? null: o.next("ul")
                    },
                    parentLi: function() {
                        return null == o ? null: o.parent("li")
                    },
                    parentUl: function() {
                        return null == o ? null: o.parent("li").parent("ul")
                    },
                    parentDiv: function() {
                        return null == o ? null: o.parent("li").parent("ul").prev("div")
                    },
                    nowDiv: function() {
                        return 0 == t.obj.find("div[dtree-click='" + z + "'][data-id]").parent().find("." + i).length ? null: t.obj.find("div[dtree-click='" + z + "'][data-id]").parent().find("." + i)
                    },
                    nowOrRootDiv: function() {
                        return 0 == t.obj.find("div[dtree-click='" + z + "'][data-id]").parent().find("." + i).length ? t.obj.children("li").eq(0).children("div").eq(0) : t.obj.find("div[dtree-click='" + z + "'][data-id]").parent().find("." + i)
                    },
                    nowOrRootUl: function() {
                        return 0 == t.obj.find("div[dtree-click='" + z + "'][data-id]").parent().find("." + i).length ? t.obj: t.obj.find("div[dtree-click='" + z + "'][data-id]").parent().find("." + i).next("ul")
                    }
                }
            },
            ue.prototype.getNowNodeUl = function() {
                return this.getNodeDom().nowOrRootUl()
            },
            ue.prototype.getNowNode = function() {
                return this.getNodeDom().nowOrRootDiv()
            },
            ue.prototype.getNowNodeOrNull = function() {
                return this.getNodeDom().nowDiv()
            },
            ue.prototype.getNode = function(e) {
                return this.getNodeDom(e).div()
            },
            ue.prototype.setNodeParam = function(e) {
                var t = this;
                if (t.node.nodeId = e.attr("data-id"), t.node.parentId = t.getNodeDom(e).parentLi().attr("data-pid"), t.node.context = "function" == typeof t.formatter.title ? t.getNodeDom(e).cite().attr("data-title") : t.getNodeDom(e).cite().text(), t.node.leaf = "leaf" == t.getNodeDom(e).cite().attr("data-leaf"), t.node.level = t.getNodeDom(e).parentLi().attr("data-index"), t.node.spread = "open" == t.getNodeDom(e).fnode().attr("data-spread"), t.node.basicData = e.attr("data-basic"), t.node.recordData = e.attr("data-record"), t.getNodeDom(e).checkbox()) {
                    var o = "",
                        a = "",
                        i = "";
                    t.getNodeDom(e).checkbox().each(function() {
                        o += y(this).attr("data-type") + ",",
                            a += y(this).attr("data-checked") + ",",
                            i += y(this).attr("data-initchecked") + ","
                    }),
                        o = o.substring(0, o.length - 1),
                        a = a.substring(0, a.length - 1),
                        i = i.substring(0, i.length - 1),
                        t.node.dataType = o,
                        t.node.checked = a,
                        t.node.initchecked = i
                }
            },
            ue.prototype.getNodeParam = function(e) {
                return e ? this.setNodeParam(e) : 0 == this.obj.find("div[data-id]").parent().find("." + i).length && this.initNodeParam(),
                    this.node
            },
            ue.prototype.getTempNodeParam = function(e) {
                var t = this,
                    o = {};
                if (o.nodeId = e.attr("data-id"), o.parentId = t.getNodeDom(e).parentLi().attr("data-pid"), o.context = "function" == typeof t.formatter.title ? t.getNodeDom(e).cite().attr("data-title") : t.getNodeDom(e).cite().text(), o.leaf = "leaf" == t.getNodeDom(e).cite().attr("data-leaf"), o.level = t.getNodeDom(e).parentLi().attr("data-index"), o.spread = "open" == t.getNodeDom(e).fnode().attr("data-spread"), o.basicData = e.attr("data-basic"), o.recordData = e.attr("data-record"), t.getNodeDom(e).checkbox()) {
                    var a = "",
                        i = "",
                        n = "";
                    t.getNodeDom(e).checkbox().each(function() {
                        a += y(this).attr("data-type") + ",",
                            i += y(this).attr("data-checked") + ",",
                            n += y(this).attr("data-initchecked") + ","
                    }),
                        a = a.substring(0, a.length - 1),
                        i = i.substring(0, i.length - 1),
                        n = n.substring(0, n.length - 1),
                        o.dataType = a,
                        o.checked = i,
                        o.initchecked = n
                }
                return o
            },
            ue.prototype.initNodeParam = function() {
                var e = this;
                e.node.nodeId = "",
                    e.node.parentId = "",
                    e.node.context = "",
                    e.node.leaf = "",
                    e.node.level = "",
                    e.node.spread = "",
                    e.node.dataType = "",
                    e.node.checked = "",
                    e.node.initchecked = "",
                    e.node.basicData = "",
                    e.node.recordData = ""
            },
            ue.prototype.getRequestParam = function(e) {
                var t = this.request,
                    o = this.defaultRequest,
                    a = e || this.node,
                    i = {};
                for (var n in t) i[n] = t[n];
                for (var n in o) {
                    var s = o[n],
                        r = a[n];
                    "boolean" == typeof r ? i[s] = r: r && (i[s] = r)
                }
                return i
            },
            ue.prototype.getFilterRequestParam = function(e) {
                var t = this.filterRequest;
                return se.cloneObj(e, t)
            },
            ue.prototype.getNowParam = function() {
                return this.getRequestParam(this.getNodeParam())
            },
            ue.prototype.getParam = function(e) {
                var t = "object" == typeof e ? e: 0 == this.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']").length ? null: this.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']");
                return null != t ? this.callbackData().node(this.getTempNodeParam(t)) : {}
            },
            ue.prototype.getParentParam = function(e) {
                var t = "object" == typeof e ? e: 0 == this.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']").length ? null: this.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']");
                return null != t ? this.callbackData().parentNode(t) : {}
            },
            ue.prototype.getAllParentParam = function(e) {
                var t = this,
                    o = "object" == typeof e ? e: 0 == t.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']").length ? null: t.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']"),
                    a = [];
                if (null != o) for (var i = t.getTempNodeParam(o).level, n = 1; n < i; n++) a.unshift(t.callbackData().parentNode(o)),
                    o = t.getNodeDom(o).parentDiv();
                return a
            },
            ue.prototype.getChildParam = function(e) {
                var t = "object" == typeof e ? e: 0 == this.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']").length ? null: this.obj.find("div[dtree-click='" + z + "'][data-id='" + e + "']");
                return null != t ? this.callbackData().childNode(t) : []
            },
            ue.prototype.callbackData = function() {
                var a = this;
                return {
                    dom: function(e) {
                        return e
                    },
                    node: function(e) {
                        return a.getRequestParam(e)
                    },
                    childNode: function(e) {
                        var t = e.next("ul").find("li." + k + " div." + S),
                            o = [];
                        return t && 0 < t.length && t.each(function() {
                            var e = y(this);
                            o.push(a.getRequestParam(a.getTempNodeParam(e)))
                        }),
                            o
                    },
                    parentNode: function(e) {
                        var t = a.getNodeDom(e).parentLi().attr("data-pid"),
                            o = a.obj.find("div[data-id='" + t + "']");
                        return 0 < o.length ? a.getRequestParam(a.getTempNodeParam(o)) : {}
                    }
                }
            },
            ue.prototype.bindBrowserEvent = function() {
                var s = this;
                s.obj.on("click", "i[data-spread]",
                    function(e) {
                        e.stopPropagation();
                        var t = y(this),
                            o = t.parent("div"),
                            a = s.getNodeParam(o);
                        s.toolbarHide(),
                            s.navThis(o),
                            s.clickSpread(o),
                            layui.event.call(this, u, "changeTree(" + y(s.obj)[0].id + ")", {
                                dom: s.callbackData().dom(t),
                                param: s.callbackData().node(a),
                                show: "open" == s.callbackData().dom(t).attr("data-spread")
                            })
                    }),
                    s.obj.on("click", "div[dtree-click='" + z + "'][dtree-disabled='false']",
                        function(e) {
                            e.stopPropagation();
                            var t = y(this),
                                o = (t.find("cite"), s.getNodeParam(t));
                            if (s.toolbarHide(), s.navThis(t), s.useIframe) {
                                var a = s.getFilterRequestParam(s.getIframeRequestParam(o));
                                s.loadIframe(t, a) && (s.iframeFun.iframeDone(a), layui.event.call(this, u, "iframeDone(" + y(s.obj)[0].id + ")", {
                                    iframeParam: a,
                                    dom: s.callbackData().dom(t)
                                }))
                            } else layui.event.call(this, u, "node(" + y(s.obj)[0].id + ")", {
                                param: s.callbackData().node(o),
                                childParams: s.callbackData().childNode(t),
                                parentParam: s.callbackData().parentNode(t),
                                dom: s.callbackData().dom(t)
                            })
                        }),
                    s.obj.on("dblclick", "div[dtree-click='" + z + "'][dtree-disabled='false']",
                        function(e) {
                            e.stopPropagation();
                            var t = y(this),
                                o = (t.find("cite"), s.getNodeParam(t));
                            s.toolbarHide(),
                                s.navThis(t),
                                layui.event.call(this, u, "nodedblclick(" + y(s.obj)[0].id + ")", {
                                    param: s.callbackData().node(o),
                                    childParams: s.callbackData().childNode(t),
                                    parentParam: s.callbackData().parentNode(t),
                                    dom: s.callbackData().dom(t)
                                })
                        }),
                s.checkbar && s.obj.on("click", "i[dtree-click='" + J + "'][dtree-disabled='false']",
                    function(e) {
                        s.toolbarHide();
                        var t = y(this),
                            o = t.closest("div[dtree-click='" + z + "']"),
                            a = s.getNodeParam(o),
                            i = s.checkbarFun.chooseBefore(t, s.getRequestParam(a));
                        s.temp = [t],
                        i && s.changeCheck(),
                            e.stopPropagation()
                    }),
                s.menubar && (s.obj.prevAll("div#dtree_menubar_" + s.obj[0].id).on("click", "button[d-menu]",
                    function(e) {
                        e.stopPropagation(),
                            s.toolbarHide(),
                            s.menubarListener(y(this).attr("d-menu"), "group")
                    }), s.obj.prevAll("div#dtree_toolbar_" + s.obj[0].id).on("click", "a[d-menu]",
                    function(e) {
                        e.stopPropagation(),
                            s.toolbarHide(),
                            s.menubarListener(y(this).attr("d-menu"), "toolbar")
                    }), s.obj.closest("body").find("*[dtree-id='" + s.obj[0].id + "'][dtree-menu]").on("click",
                    function(e) {
                        e.stopPropagation(),
                            s.toolbarHide(),
                            s.menubarListener(y(this).attr("dtree-menu"), "freedom")
                    })),
                s.toolbar && ("contextmenu" == s.toolbarWay ? (s.obj.on("contextmenu", "div[dtree-click='" + z + "'][d-contextmenu='true'][dtree-disabled='false']",
                    function(e) {
                        var t = y(this),
                            o = s.getNodeParam(t);
                        s.toolbarHide(),
                            s.setToolbarDom().setToolbarPlace(s.toolbarFun.loadToolbarBefore(se.cloneObj(s.toolbarMenu), s.getRequestParam(o), t));
                        var a = (e = e || window.event).pageX - t.offset().left + 75,
                            i = t.offset().top - s.obj.closest(s.toolbarScroll).offset().top + 10;
                        s.navThis(t);
                        var n = s.obj.prevAll("div#dtree_toolbar_" + s.obj[0].id);
                        return n.find(".layui-nav-child").addClass("layui-anim-fadein layui-show"),
                            n.css({
                                left: a + "px",
                                top: i + "px"
                            }),
                            e.stopPropagation(),
                            !1
                    }), s.obj.closest(s.toolbarScroll).scroll(function() {
                    s.toolbarHide()
                }), s.obj.prevAll("div#dtree_toolbar_" + s.obj[0].id).on("click", "a[dtree-tool]",
                    function(e) {
                        e.stopPropagation();
                        var t = s.getNodeDom().nowOrRootDiv();
                        s.getNodeParam(t);
                        s.toolbarHide();
                        var o = y(this).attr("dtree-tool");
                        s.toolbarListener(o, t)
                    })) : "fixed" == s.toolbarWay ? s.obj.on("click", "a[dtree-tool]",
                    function(e) {
                        e.stopPropagation();
                        var t = y(this),
                            o = t.parent("em." + l).prev("cite").parent("div"),
                            a = (s.getNodeParam(o), t.attr("dtree-tool"));
                        s.toolbarHide(),
                            s.navThis(o),
                            s.toolbarListener(a, o)
                    }) : "follow" == s.toolbarWay && (s.obj.on("mouseover mouseout", "div[dtree-click='" + z + "'][dtree-disabled='false']",
                    function(e) {
                        var t = y(this).children("em." + l);
                        "mouseover" == e.type ? (t.removeClass(x), e.stopPropagation()) : "mouseout" == e.type && (t.addClass(x), e.stopPropagation())
                    }), s.obj.on("click", "a[dtree-tool]",
                    function(e) {
                        e.stopPropagation();
                        var t = y(this),
                            o = t.parent("em." + l).prev("cite").parent("div"),
                            a = (s.getNodeParam(o), t.attr("dtree-tool"));
                        s.toolbarHide(),
                            s.navThis(o),
                            s.toolbarListener(a, o)
                    })))
            },
            o.on("click",
                function(e) {
                    y("div." + t).find(".layui-show").removeClass("layui-anim-fadein layui-show")
                }),
            ue.prototype.unbindBrowserEvent = function() {
                var e = this;
                e.obj.unbind(),
                e.menubar && (e.obj.prevAll("div#dtree_menubar_" + e.obj[0].id).unbind(), 0 < e.obj.closest("body").find("*[dtree-id='" + e.obj[0].id + "'][dtree-menu]").length && e.obj.closest("body").find("*[dtree-id='" + e.obj[0].id + "'][dtree-menu]").unbind()),
                e.toolbar && "contextmenu" == e.toolbarWay && (e.obj.prevAll("div#dtree_toolbar_" + e.obj[0].id).unbind(), 0 < e.obj.closest(e.toolbarScroll).length && e.obj.closest(e.toolbarScroll).unbind())
            },
            e("dtree", {
                render: function(e) {
                    var t = null,
                        o = se.getElemId(e);
                    return "" == o ? f.msg("页面中未找到绑定id", {
                        icon: 5
                    }) : ("object" == typeof(t = a[o]) ? (t.reloadSetting(e), t.initTreePlus(), t.openTreePlus(), t.initNodeParam(), t.init(), t.unbindBrowserEvent()) : (t = new ue(e), (a[o] = t).initTreePlus(), t.openTreePlus(), t.init()), t.bindBrowserEvent()),
                        t
                },
                reload: function(e, t) {
                    "string" == typeof e && (e = a[e]),
                        void 0 !== e ? (e.reloadSetting(t), e.initTreePlus(), e.openTreePlus(), e.initNodeParam(), e.init(), e.unbindBrowserEvent(), e.bindBrowserEvent()) : f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                            icon: 2
                        })
                },
                on: function(e, t) {
                    return 0 < e.indexOf("'") && (e = e.replace(/'/g, "")),
                    0 < e.indexOf('"') && (e = e.replace(/"/g, "")),
                        layui.onevent.call(this, u, e, t)
                },
                click: function(e, t) {
                    "string" == typeof e && (e = a[e]),
                        void 0 !== e ? y("div[dtree-click='" + z + "'][dtree-id='" + e.obj[0].id + "'][data-id='" + t + "']").click() : f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                            icon: 2
                        })
                },
                getNowParam: function(e) {
                    if ("string" == typeof e && (e = a[e]), void 0 !== e) return e.getNowParam();
                    f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                        icon: 2
                    })
                },
                getParam: function(e, t) {
                    if ("string" == typeof e && (e = a[e]), void 0 !== e) return e.getParam(t);
                    f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                        icon: 2
                    })
                },
                getParentParam: function(e, t) {
                    if ("string" == typeof e && (e = a[e]), void 0 !== e) return e.getParentParam(t);
                    f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                        icon: 2
                    })
                },
                getAllParentParam: function(e, t) {
                    if ("string" == typeof e && (e = a[e]), void 0 !== e) return e.getAllParentParam(t);
                    f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                        icon: 2
                    })
                },
                getChildParam: function(e, t) {
                    if ("string" == typeof e && (e = a[e]), void 0 !== e) return e.getChildParam(t);
                    f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                        icon: 2
                    })
                },
                getCheckbarNodesParam: function(e) {
                    return "string" == typeof e && (e = a[e]),
                        void 0 === e ? (f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                            icon: 2
                        }), {}) : e.getCheckbarNodesParam()
                },
                dataInit: function(e, t) {
                    if ("string" == typeof e && (e = a[e]), void 0 !== e) return t ? e.dataInit(t) : void 0;
                    f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                        icon: 2
                    })
                },
                chooseDataInit: function(e, t) {
                    if ("string" == typeof e && (e = a[e]), void 0 !== e) return t ? e.chooseDataInit(t) : void 0;
                    f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                        icon: 2
                    })
                },
                changeCheckbarNodes: function(e) {
                    if ("string" == typeof e && (e = a[e]), void 0 !== e) return e.changeCheckbarNodes();
                    f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                        icon: 2
                    })
                },
                initNoAllCheck: function(e) {
                    if ("string" == typeof e && (e = a[e]), void 0 !== e) return e.initNoAllCheck();
                    f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                        icon: 2
                    })
                },
                initAllCheck: function(e) {
                    if ("string" == typeof e && (e = a[e]), void 0 !== e) return e.initAllCheck();
                    f.msg("方法获取失败，请检查ID或对象传递是否正确", {
                        icon: 2
                    })
                },
                escape: function(e) {
                    return se.escape(e)
                },
                unescape: function(e) {
                    return se.unescape(e)
                },
                version: function() {
                    return "v2.5.0"
                }
            })
    });