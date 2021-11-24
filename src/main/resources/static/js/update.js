// (1) 회원정보 수정
function update(userId, event) {
	event.preventDefault();		// 폼태크 액션 방지
	let data = $("#profileUpdate").serialize();
	
	console.log(data);
	
	$.ajax({
		type:"put",
		url:`/api/user/${userId}`,
		data: data,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "json"
	}).done(res => {
		console.log("update 성공", res)
		location.href = `/user/${userId}`;
	}).fail(err => { // HttpStatus 상태코드 200번대가 아닐 때
		if(err.data == null){
			alert(err.responseJSON.message);
		}else{
			alert(JSON.stringify(err.responseJSON.data));	
		}	
	});
}