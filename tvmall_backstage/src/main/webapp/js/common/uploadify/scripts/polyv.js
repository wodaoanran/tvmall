!
function(e, t) {
    if ("object" == typeof exports && "object" == typeof module) module.exports = t();
    else if ("function" == typeof define && define.amd) define([], t);
    else {
        var i = t();
        for (var n in i)("object" == typeof exports ? exports: e)[n] = i[n]
    }
} (window,
function() {
    return function(e) {
        var t = {};
        function i(n) {
            if (t[n]) return t[n].exports;
            var o = t[n] = {
                i: n,
                l: !1,
                exports: {}
            };
            return e[n].call(o.exports, o, o.exports, i),
            o.l = !0,
            o.exports
        }
        return i.m = e,
        i.c = t,
        i.d = function(e, t, n) {
            i.o(e, t) || Object.defineProperty(e, t, {
                enumerable: !0,
                get: n
            })
        },
        i.r = function(e) {
            "undefined" != typeof Symbol && Symbol.toStringTag && Object.defineProperty(e, Symbol.toStringTag, {
                value: "Module"
            }),
            Object.defineProperty(e, "__esModule", {
                value: !0
            })
        },
        i.t = function(e, t) {
            if (1 & t && (e = i(e)), 8 & t) return e;
            if (4 & t && "object" == typeof e && e && e.__esModule) return e;
            var n = Object.create(null);
            if (i.r(n), Object.defineProperty(n, "default", {
                enumerable: !0,
                value: e
            }), 2 & t && "string" != typeof e) for (var o in e) i.d(n, o,
            function(t) {
                return e[t]
            }.bind(null, o));
            return n
        },
        i.n = function(e) {
            var t = e && e.__esModule ?
            function() {
                return e.
            default
            }:
            function() {
                return e
            };
            return i.d(t, "a", t),
            t
        },
        i.o = function(e, t) {
            return Object.prototype.hasOwnProperty.call(e, t)
        },
        i.p = "",
        i(i.s = 0)
    } ([function(e, t, i) {
        "use strict";
        function n(e) {
            return (n = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ?
            function(e) {
                return typeof e
            }: function(e) {
                return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol": typeof e
            })(e)
        }
        function o(e, t) {
            for (var i = 0; i < t.length; i++) {
                var n = t[i];
                n.enumerable = n.enumerable || !1,
                n.configurable = !0,
                "value" in n && (n.writable = !0),
                Object.defineProperty(e, n.key, n)
            }
        }
        i.r(t),
        i.d(t, "PolyvUpload",
        function() {
            return r
        });
        var r = function() {
            function e(t) { !
                function(e, t) {
                    if (! (e instanceof t)) throw new TypeError("Cannot call a class as a function")
                } (this, e);
                var i = window.location,
                n = window.location.protocol;
                if (! ((t.userid && t.ts && t.hash && t.sign || t.requestUrl) && t.uploadButtton)) throw new TypeError("缺少必选的上传参数！");
                t.width && "number" != typeof t.width && (delete t.width, console.log("上传参数width必须为数字类型")),
                t.height && "number" != typeof t.height && (delete t.width, console.log("上传参数height必须为数字类型")),
                t.fileLimit && "number" != typeof t.fileLimit && (delete t.fileLimit, console.log("上传参数fileLimit必须为数字类型"));
                var o = n + "//static.polyv.net/file/plug-in-v2/";
                this.options = {
                    userid: t.userid,
                    ts: t.ts,
                    ptime: t.ts,
                    hash: t.hash,
                    sign: t.sign,
                    component: t.component || "all",
                    cataid: t.cataid || 1,
                    luping: (t.luping || 0) + "",
                    defaultTagPlaceholder: t.defaultTagPlaceholder || '标签 用" , "分隔',
                    defaultDescPlaceholder: t.defaultDescPlaceholder || "添加描述",
                    extra: JSON.stringify(t.extra || {}),
                    fileLimit: t.fileLimit,
                    fileLimitTips: t.fileLimitTips || "该视频文件过大，请重新选择",
                    response: t.response ||
                    function() {},
                    openWrap: t.openWrap ||
                    function() {},
                    uploadSuccess: t.uploadSuccess ||
                    function() {},
                    uploadFail: t.uploadFail ||
                    function() {},
                    url: i.href,
                    urlPrefix: o,
                    source: "polyv-upload"
                },
                this.uploadButton = document.getElementById(t.uploadButtton),
                this.width = t.width ? t.width < 900 ? 900 : t.width: 1e3,
                this.height = t.height ? t.height < 500 ? 500 : t.height: 600,
                this.requestUrl = t.requestUrl,
                this.retryTimes = 5,
                this.url = o + "/build/index.html",
                this._init()
            }
            return function(e, t, i) {
                t && o(e.prototype, t),
                i && o(e, i)
            } (e, [{
                key: "_addHander",
                value: function(e, t, i) {
                    e.addEventListener ? e.addEventListener(t, i, !1) : e.attachEvent ? e.attachEvent("on" + t, i) : e["on" + t] = i
                }
            },
            {
                key: "_checkH5Support",
                value: function() {
                    var e = document.createElement("input"),
                    t = !(!window.File || !window.FileList),
                    i = new XMLHttpRequest,
                    n = !!window.FormData;
                    return "multip" in e && t && "onprogress" in i && "upload" in i && n
                }
            },
            {
                key: "_init",
                value: function() {
                    var e = this;
                    console.log("v2.0.1 2018/10/29"),
                    this._checkH5Support() || (this.url = this.options.urlPrefix + "/upload-flash/index.html"),
                    this._addHander(this.uploadButton, "click",
                    function() {
                        e.openWrap()
                    }),
                    this._addHander(window, "message", this._receiveMsg.bind(this));
                    var t = 0;
                    this.requestUrl ? (this._getSign({
                        success: function(i) {
                            e._initIframe(function() {
                                e.update(i),
                                console.log("(插件内部)第" + t+++"次刷新...")
                            })
                        }
                    }), setInterval(function() {
                        e._getSign({
                            success: function(i) {
                                e.update(i),
                                console.log("(插件内部)第" + t+++"次刷新...")
                            }
                        })
                    },
                    15e4)) : this._initIframe()
                }
            },
            {
                key: "_getSign",
                value: function(e) {
                    var t = e.success,
                    i = e.fail,
                    n = this,
                    o = new XMLHttpRequest;
                    o.open("GET", this.requestUrl + "?id=" + encodeURI((new Date).getTime())),
                    o.onreadystatechange = function() {
                        if (4 === o.readyState) if (200 === o.status && "function" == typeof t) try {
                            t(JSON.parse(o.responseText)),
                            n.retryTimes = 5
                        } catch(e) {
                            if (n.retryTimes <= 0) return void i({});
                            n.retryTimes--,
                            n._getSign({
                                success: t,
                                fail: i
                            })
                        } else "function" == typeof i && i(JSON.parse(o.responseText))
                    },
                    o.send(null)
                }
            },
            {
                key: "_initIframe",
                value: function(e) {
                    var t = this._createIframe();
                    function i(e) {
                        e.readyState && "complete" !== e.readyState || this.update()
                    }
                    this.frameMsg = t.contentWindow,
                    "function" == typeof e && e(),
                    t.attachEvent ? t.attachEvent("onload", i.bind(this, t)) : t.onload = i.bind(this, t)
                }
            },
            {
                key: "_createIframe",
                value: function() {
                    var e = document.createElement("div"),
                    t = document.createElement("div"),
                    i = document.createElement("div"),
                    n = document.createElement("span"),
                    o = document.createElement("iframe");
                    return e.setAttribute("id", "polyv-wrapAll"),
                    e.style.display = "none",
                    t.style.cssText = "display: block;position: fixed;left: 0;top: 0;width: 100%;height: 100%;z-index: 1001;background-color: #000;-moz-opacity: 0.5;opacity: .50;filter: alpha(opacity=50);",
                    i.style.cssText = "display: block;position: fixed;left: 0;top: 0;bottom: 0;right: 0;width: ".concat(this.width, "px;height: ").concat(this.height, "px;margin: auto;z-index: 1002;box-shadow: 0 0 25px rgba(0,0,0,0.7);border-radius: 10px;"),
                    n.innerHTML = "&times;",
                    n.style.cssText = "width: 26px;height: 26px;position: absolute;top: 0px;right: 0px;cursor: pointer;background: #eee;text-align: center;line-height: 26px;color: #666;font-size: 16px;font-family: microsoft yahei;border-radius: 0 10px 0 0;",
                    n.onclick = function() {
                        e.style.display = "none"
                    },
                    o.setAttribute("src", this.url),
                    o.setAttribute("id", "polyv-iframe"),
                    o.setAttribute("width", this.width),
                    o.setAttribute("height", this.height),
                    o.style.cssText = "width: 100%;height: 100%;z-index: 1002;border:none;border-radius: 10px;background-color: #fff;",
                    i.appendChild(o),
                    i.appendChild(n),
                    e.appendChild(t),
                    e.appendChild(i),
                    document.getElementsByTagName("body")[0].appendChild(e),
                    o
                }
            },
            {
                key: "_receiveMsg",
                value: function(e) {
                    console.log(e);
                    try {
                        var t = JSON.parse(e.data)
                    } catch(e) {
                        return
                    }
                    switch (t.type) {
                    case "VIDEO_INFO":
                        "function" == typeof this.options.response && this.options.response(t.data);
                        break;
                    case "FILE_COMPLETE":
                        "function" == typeof this.options.uploadSuccess && this.options.uploadSuccess(t.data);
                        break;
                    case "FILE_FAIL":
                        "function" == typeof this.options.uploadFail && this.options.uploadFail(t.data)
                    }
                }
            },
            {
                key: "update",
                value: function() {
                    if ("object" === n(arguments[0])) {
                        for (var e in arguments[0]) arguments[0].hasOwnProperty(e) && (this.options[e] = arguments[0][e]);
                        arguments[0].ts && (this.options.ptime = arguments[0].ts)
                    }
                    this.frameMsg.postMessage(JSON.stringify(this.options), this.url)
                }
            },
            {
                key: "openWrap",
                value: function() {
                    this.frameMsg.postMessage(JSON.stringify({
                        openWrap: !0
                    }), this.url),
                    this.options.openWrap && this.options.openWrap(),
                    document.getElementById("polyv-wrapAll").style.display = "block"
                }
            },
            {
                key: "closeWrap",
                value: function() {
                    document.getElementById("polyv-wrapAll").style.display = "none"
                }
            }]),
            e
        } ()
    }])
});