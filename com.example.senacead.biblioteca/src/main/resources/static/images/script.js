function atualizarFilme(id, data) {
    $.ajax({
        url: `/filme/${id}`,
        type: 'PUT',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function () {
            alert('Filme atualizado com sucesso!');
        },
        error: function () {
            alert('Erro ao atualizar o filme.');
        }
    });
}

function excluirFilme(id) {
    $.ajax({
        url: `/filme/${id}`,
        type: 'DELETE',
        success: function () {
            alert('Filme excluído com sucesso!');
            location.reload();
        },
        error: function () {
            alert('Erro ao excluir o filme.');
        }
    });
   

function obterAnalises(id) {
    $.ajax({
        url: `/analises/${id}`, 
        type: 'GET',
        success: function (analises) {
            console.log(analises); 
            analises.forEach(analise => {
                $('#analises').append(`
                    <div>
                        <p>Analise: ${analise.analiseA}</p>
                        <p>Nota: ${analise.nota}</p>
                    </div>
                `);
            });
        },
        error: function () {
            alert('Erro ao carregar as análises.');
        }
    });
}


function adicionarAnalise(id, analiseData) {
    $.ajax({
        url: `/analises/${id}`,
        type: 'POST',
        data: JSON.stringify(analiseData), 
        contentType: 'application/json',
        success: function () {
            alert('Análise enviada com sucesso!');
            location.reload(); 
        },
        error: function () {
            alert('Erro ao adicionar a análise.');
        }
    });
}


function excluirAnalise(id) {
    $.ajax({
        url: `/analises/${id}`, 
        type: 'DELETE',
        success: function () {
            alert('Análise excluída com sucesso!');
            location.reload();
        },
        error: function () {
            alert('Erro ao excluir a análise.');
        }
    });
}


}

