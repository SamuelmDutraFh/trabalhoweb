$(function() {
	let table = $('#minhaTabela').DataTable({
        "language": {
        	"decimal":        ",",
            "emptyTable":     "Sem registros",
            "info":           "Mostrando _START_ a _END_ de _TOTAL_ resgistros",
            "infoEmpty":      "Mostrando 0 a 0 de 0 resgistros",
            "infoFiltered":   "(filtered from _MAX_ total entries)",
            "infoPostFix":    "",
            "thousands":      ".",
            "lengthMenu":     "Mostrar _MENU_ registros",
            "loadingRecords": "Carregando...",
            "processing":     "Processando...",
            "search":         "Busca:",
            "zeroRecords":    "Nenhum registro encontrado",
            "paginate": {
                "first":      "Primeira",
                "last":       "Última",
                "next":       "Próxima",
                "previous":   "Anterior"
            },
            "aria": {
                "sortAscending":  ": activate to sort column ascending",
                "sortDescending": ": activate to sort column descending"
            }
        }
    });
	let table2 = $('#tabelaClientesCadastroPedido').DataTable({
		"bLengthChange": false,
		"pageLength": 3,
		"columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            }
        ],
		"language": {
			"decimal":        ",",
			"emptyTable":     "Sem registros",
			"info":           "Mostrando _START_ a _END_ de _TOTAL_ resgistros",
			"infoEmpty":      "Mostrando 0 a 0 de 0 resgistros",
			"infoFiltered":   "(filtered from _MAX_ total entries)",
			"infoPostFix":    "",
			"thousands":      ".",
			"lengthMenu":     "Mostrar _MENU_ registros",
			"loadingRecords": "Carregando...",
			"processing":     "Processando...",
			"search":         "Busca:",
			"zeroRecords":    "Nenhum registro encontrado",
			"paginate": {
				"first":      "Primeira",
				"last":       "Última",
				"next":       "Próxima",
				"previous":   "Anterior"
			},
			"aria": {
				"sortAscending":  ": activate to sort column ascending",
				"sortDescending": ": activate to sort column descending"
			}
		}
	});
	let table3 = $('#tabelaProdutosCadastroPedido').DataTable({
		"bLengthChange": false,
		"pageLength": 3,
		"columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            }
        ],
		"language": {
			"decimal":        ",",
			"emptyTable":     "Sem registros",
			"info":           "Mostrando _START_ a _END_ de _TOTAL_ resgistros",
			"infoEmpty":      "Mostrando 0 a 0 de 0 resgistros",
			"infoFiltered":   "(filtered from _MAX_ total entries)",
			"infoPostFix":    "",
			"thousands":      ".",
			"lengthMenu":     "Mostrar _MENU_ registros",
			"loadingRecords": "Carregando...",
			"processing":     "Processando...",
			"search":         "Busca:",
			"zeroRecords":    "Nenhum registro encontrado",
			"paginate": {
				"first":      "Primeira",
				"last":       "Última",
				"next":       "Próxima",
				"previous":   "Anterior"
			},
			"aria": {
				"sortAscending":  ": activate to sort column ascending",
				"sortDescending": ": activate to sort column descending"
			}
		}
	});
	
	window.setTimeout(function() {
	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
	        $(this).remove(); 
	    });
	}, 3000);
})
$('#confirmacaoExclusaoModal').on(
		'show.bs.modal',
		function(event) {

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

			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir o cliente <strong>'
							+ nomeCliente + '</strong>?');
		});

$('#confirmacaoExclusaoProdutoModal').on(
		'show.bs.modal',
		function(event) {

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

			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir o produto <strong>'
							+ descricaoProduto + '</strong>?');
		});

$(function() {

//	$('#minhaTabela').DataTable()

	$('.js-atualizar-produto-pedido').on('click', function(event) {
		event.preventDefault()

		var btnAdicionar = $(event.currentTarget)
		var urlAdicionar = btnAdicionar.attr('href');

		var response = $.ajax({
			url : urlAdicionar,
			type : 'POST'
		})

	})
	$('.js-atualizar-cliente-pedido').on('click', function(event) {
	})

});