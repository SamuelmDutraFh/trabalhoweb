$(function(){
	$('#tabelaClientes tbody tr td').dblclick(function(){
		if($('td > input').length > 0){
			return;
		}
		let conteudoOriginal = $(this).text()
		let novoElemento = $('<input/>', {type:'text', value:conteudoOriginal})
		$(this).html(novoElemento.bind('blur keydown', function(e){
			let keyCode = e.which
			if(keyCode == 13){
				let conteudoNovo = $(this).val()
				if(conteudoNovo != ""){
					$(this).parent().html(conteudoNovo)
				}
			}
			if(e.type == "blur"){
				$(this).parent().html(conteudoOriginal)
			}
		}))
		$(this).children().select()
	})
})