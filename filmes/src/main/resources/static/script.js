const detalheBtn = document.querySelectorAll('.detalheBtn');
const tituloDetalhes = document.getElementById('titulo-detalhe');
const generoDetalhes = document.getElementById('genero-detalhe');
const anoDetalhes = document.getElementById('data-detalhe');
const sinopseDetalhes = document.getElementById('sinopse-detalhe');

/*CODIGO PARA ABRIR DETALHES DE FILME QUANDO O USUARIO CLICAR EM 'DETALHE' NA LISTA DE FILMES */

for (let i = 0; i < detalheBtn.length; i++) {
    detalheBtn[i].addEventListener('click', function() {

        $(document).ready(function() {
            $.ajax({
                url: "/listar-filmes-json",
                type: "GET",
                success: function(filmes) {
                    cconsole.log(filmes[i]);
                    tituloDetalhes.textContent = filmes[i].titulo;
                    generoDetalhes.textContent = filmes[i].genero;
                    anoDetalhes.textContent = filmes[i].anoLancamento;
                    sinopseDetalhes.textContent = filmes[i].sinopse;
                },
                error: function(xhr, status, error) {
                    console.error("Erro ao obter analise:", status, error);
                }
            });
        });

        window.location.href = "/detalhes";

    })
} 

