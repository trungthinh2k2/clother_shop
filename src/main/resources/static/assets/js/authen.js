app.run(function($http, $rootScope){
    $http.get(`/security/rest/security/authentication`).then(resp => {
        if (resp.data) {
            $auth = $rootScope.$auth = resp.data;
            $http.defaults.headers.common["Authorization"] = $auth.token;
            console.log("Authentication data:", $rootScope.$auth);
        }
    });
})