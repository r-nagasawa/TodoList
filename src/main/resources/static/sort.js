
function sortTodo(){
	var select = document.querySelector("select[name=sort]");
	let value = select.value;
	//List<TodoList> todo;
	if(value == 'Descending'){
		//todo.sort(date);
		alert("アラートです")
		//tx.executeSql('SELECT * FROM todo order by date;', [], function (tx, results) {
			//(省略)
		//});
		//todo.sort(date);
	}else if(value == 'Ascending'){
		alert("テストです")
		//昇順並び替え処理
		
	}
}