var users = new Vue({
	el:"#showUsers",
	data:{
		usersList:[],
		user:{},
		genderOptions:[
			{text:'男',value:'M'},
			{text:'女',value:'F'}
		],
		nowIndex:-100,
	},
	methods:{
		findUsers : function(){
			this.$http.get("/users/findUsers").then(function(res){
				console.log(res.data);
				users.usersList = res.data;
			},function(){
				console.log("请求失败");
			});
		},
		bfUpdateUsers:function(us,index){
			users.user = us;
			users.nowIndex=index;
		},
		updateUsers:function(){
			this.$http.post("/users/updateUser",this.user).then(function(res){
				if(res.data){
					console.log("修改成功");
					this.user.gender == 'M'?this.user.gender='男':this.user.gender='女';
					Vue.set(this.usersList,this.nowIndex,this.user);
					this.user={};
				}else{
					console.log("修改失败");
				}
			}),function(){
				console.log("/修改异常");
			}
		},
		bfDeleteUsers:function(us,index){
			users.user = us;
			users.nowIndex=index;
		},
		deleteUsers:function(){
			this.$http.get("/users/deleteUser",{uid:this.user.uid}).then(function(res){
				if(res.data){
					console.log("/删除成功");
					this.usersList.splice(this.nowIndex,1);
					this.user={};
				}else{
					console.log("/删除失败");
				}
			},function(){
				console.log("/修改异常");
			});
		},
		insertUsers:function(){
			this.$http.post("/users/insertUser",this.user).then(function(res){
				if(res.data != null){
					console.log("添加成功");
					this.user.gender == 'M'?this.user.gender='男':this.user.gender='女';
					this.usersList.push(res.data);
					this.user={};
				}else{
					console.log("添加失败");
				}
			}),function(){
				console.log("/添加异常");
			}
		}
	}
});

users.findUsers();