app.controller("auth-ctrl", function($scope, $http) {
	$http.get(`/rest/authorities/list`).then(resp => {
		$scope.db = resp.data;
		console.log(resp.data)
	})

	$scope.index_of = function(userName, roles) {
		return $scope.db.authorities
			.findIndex(a => a.account.username === userName && a.role.id === roles);
	}

	$scope.update = function(userName, roles) {
		var index = $scope.index_of(userName, roles);
		if (index >= 0) {
			var id = $scope.db.authorities[index].id;
			$http.delete(`/rest/authorities/${id}`).then(resp => {
				$scope.db.authorities.splice(index, 1);
			})
		}
		else {
			var authorities = {
				account: { userName: userName },
				roles: { id: roles }
			};
			$http.post(`/rest/authorities/create`, authorities).then(resp => {
				$scope.db.authorities.push(resp.data);
			});
		}
	}
});