const detalheBtn = document.querySelectorAll('.detalheBtn');
const tituloDetalhes = document.querySelector('.titulo-detalhe');
const subtituloDetalhes = document.querySelector('.subtitulo-detalhe');
const generoDetalhes = document.querySelector('.genero-detalhe');
const anoDetalhes = document.querySelector('.data-detalhe');
const sinopseDetalhes = document.querySelector('.sinopse-detalhe');
const detailContainer = document.querySelector('.detail-cont');
const indexFilme = document.querySelector('.indexFilme');
const analiseBtn = document.querySelector('.enviarAnalise');

analiseBtn.addEventListener('click', function() {
    
    // Função para obter o filme por ID

    fetch(`/filme/${idFilme.value}`) // Faz uma requisição GET para o endpoint /filme/{id}
        .then(response => {
            if (!response.ok) {
                throw new Error('Falha ao obter o filme.'); // Lança um erro se a resposta não for bem-sucedida
            }
            return response.json(); // Converte a resposta para JSON
        })
        .then(filme => {
            // Aqui você pode fazer o que quiser com o filme retornado, por exemplo, exibir os detalhes na tela
            console.log(filme);
        })
        .catch(error => {
            console.error('Erro:', error); // Captura e exibe qualquer erro que ocorra durante a requisição
        });



})

function extrairAno(data) {
    // Divida a string da data usando o separador "-"
    var partesData = data.split('-');
    
    // A primeira parte é o ano
    var ano = partesData[0];
    
    // Retorne o ano como uma string
    return ano;
}

// EVENTLISTENER PARA OS BOTOES DE DETALHES 
for (let i = 0; i < detalheBtn.length; i++) {
        detalheBtn[i].addEventListener('click', function() {
            $(document).ready(function() {
                $.ajax({
                    url: "/listar-filmes-json",
                    type: "GET",
                    success: function(filmes) {
                        indexFilme.value = i;
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




