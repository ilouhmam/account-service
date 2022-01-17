function fn() {
    karate.log('karate.env system property was:', karate.env);
    karate.log("Your OS Is",karate.os);
    var config = {
            baseUrl: karate.properties['baseUrl'] || 'http://localhost:8081'
        };
    //karate.configure('connectTimeout', 5000);
    //karate.configure('readTimeout', 5000);
    return config;
}