function () {
    var env = karate.env = null ? "dev" : karate.env; // get system property 'karate.env'
    karate.log('karate.env system property was:', env);

    karate.configure('logPrettyRequest', true);
    karate.configure('logPrettyResponse', true);
    karate.configure('connectTimeout', 30 * 1000);
    karate.configure('readTimeout', 30 * 1000);

    var config = {
        env: env,
        myVarName: 'someValue',
        demoBaseUrl: 'http://127.0.0.1:8083'
    }

    for (p in config) {
        karate.log ("##### config." + p, ": " + config[p])
    }

    return config;
}

