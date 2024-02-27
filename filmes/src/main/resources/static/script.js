const detalheBtn = document.querySelectorAll('.detalheBtn');
const tituloDetalhes = document.querySelector('.titulo-detalhe');
const subtituloDetalhes = document.querySelector('.subtitulo-detalhe');
const generoDetalhes = document.querySelector('.genero-detalhe');
const anoDetalhes = document.querySelector('.data-detalhe');
const sinopseDetalhes = document.querySelector('.sinopse-detalhe');
const detailContainer = document.querySelector('.detail-cont');

function extrairAno(data) {
    // Divida a string da data usando o separador "-"
    var partesData = data.split('-');
    
    // A primeira parte é o ano
    var ano = partesData[0];
    
    // Retorne o ano como uma string
    return ano;
}

    for (let i = 0; i < detalheBtn.length; i++) {
        detalheBtn[i].addEventListener('click', function() {
            $(document).ready(function() {
                $.ajax({
                    url: "/listar-filmes-json",
                    type: "GET",
                    success: function(filmes) {
                        tituloDetalhes.textContent = filmes[i].titulo;
                        const subtitle = "Título: "+filmes[i].titulo;
                        subtituloDetalhes.textContent = subtitle;
                        const genero = "Gênero: "+filmes[i].genero;
                        generoDetalhes.textContent = genero;
                        const data = extrairAno(filmes[i].anoLancamento);
                        const ano = "Ano de Lançamento: "+ data;
                        anoDetalhes.textContent = ano;
                        sinopseDetalhes.textContent = filmes[i].sinopse;
                        detailContainer.style.display = 'block';
                        detailContainer.scrollIntoView({
                            behavior: 'smooth', // Adiciona um efeito de rolagem suave
                            block: 'start' // Alinha o elemento no topo da janela de visualização
                        });
                    },
                    error: function(xhr, status, error) {
                        console.error("Erro ao obter lista de filmes:", status, error);
                    }
                });
            });
    
        })
        
    }
