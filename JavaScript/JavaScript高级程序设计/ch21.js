

// IE7 之前的版本
function createXHR() {
    if (typeof arguments.callee.activeXString != "string") {
        var versions = ["MSXML2.XMLHttp.6.0", "MSXML2.XMLHttp.3.0",
                        "MSXML2.XMLHttp"];
        var i, len;
        for (i = 0, len = versions.length; i < len; i++) {
            try {
                new ActiveXObject(versions[i]);
                arguments.callee.activeXString = versions[i];
                break;
            } catch (ex) {

            }
        }
        return new ActiveXObject(arguments.callee.activeXString);
    }
}