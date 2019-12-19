function () {
    var env = karate.env; // get system property 'karate.env'

    karate.configure('logPrettyRequest', true);
    karate.configure('logPrettyResponse', true);
    karate.configure('connectTimeout', 30 * 1000);
    karate.configure('readTimeout', 30 * 1000);

    var port = karate.properties['demo.server.port'];
    karate.log('karate.env system property was:', env);

    if (!env) {
        env = 'dev';
    }
    var config = {
        env: env,
        myVarName: 'someValue',
        demoBaseUrl: 'http://127.0.0.1:' + port
    }
    if (env == 'dev') {
        // customize
        // e.g. config.foo = 'bar';
    } else if (env == 'e2e') {
        // customize
    }
    for(p in config) {
        karate.log ("##### config." + p, ": " + config[p])
    }
    return config;
}