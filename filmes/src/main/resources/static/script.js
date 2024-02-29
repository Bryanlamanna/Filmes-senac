const detalheBtn = document.querySelectorAll('.detalheBtn');
const tituloDetalhes = document.querySelector('.titulo-detalhe');
const subtituloDetalhes = document.querySelector('.subtitulo-detalhe');
const generoDetalhes = document.querySelector('.genero-detalhe');
const anoDetalhes = document.querySelector('.data-detalhe');
const sinopseDetalhes = document.querySelector('.sinopse-detalhe');
const detailContainer = document.querySelector('.detail-cont');
const indexFilme = document.querySelectorAll('.indexFilme');


listarAnalises();

// Função para fazer a solicitação AJAX e listar as análises no console
function listarAnalises() {
    // Fazendo a solicitação AJAX usando o método fetch
    fetch('/listar-analises-json')
    .then(response => {
        // Verifica se a resposta da solicitação foi bem-sucedida
        if (!response.ok) {
            throw new Error('Erro ao buscar as análises');
        }
        // Parseia a resposta JSON
        return response.json();
    })
    .then(data => {
        // Lista as análises no console
        console.log('Lista de Análises:');
        console.log(data);
    })
    .catch(error => {
        // Trata qualquer erro que ocorra durante a solicitação
        console.error('Erro:', error);
    });
}

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
                        
                        indexFilme.forEach(index => index.value = i);
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




