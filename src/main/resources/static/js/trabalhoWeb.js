$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	
	var button = $(event.relatedTarget);
	var idCliente = button.data('id');
	var nomeCliente = button.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + idCliente);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o cliente <strong>' + nomeCliente + '</strong>?');
});



$('#confirmacaoExclusaoProdutoModal').on('show.bs.modal', function(event) {
	
	var button = $(event.relatedTarget);
	var idProduto = button.data('id');
	var descricaoProduto = button.data('descricao');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + idProduto);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o produto <strong>' + descricaoProduto + '</strong>?');
});

$(function (){
	
	$('.js-atualizar-produto-pedido').on('click', function (event){
		event.preventDefault()
		
		var btnAdicionar = $(event.currentTarget)
		var urlAdicionar = btnAdicionar.attr('href');
		
		var response = $.ajax({
			url: urlAdicionar,
			type: 'POST'
		})
		
	})
	$('.js-atualizar-cliente-pedido').on('click', function (event){})
});