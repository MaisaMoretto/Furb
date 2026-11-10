function autenticar() {
    var vLogin = document.getElementById('login').value;
    var vSenha = document.getElementById('senha').value;

    if (vLogin != '' && vSenha != '') {
        localStorage.setItem('usuario', vLogin);
        localStorage.setItem('autenticado', 'true');
    }
}

/* Identificação do usuário no cabeçalho (todas as páginas) */
function mostraUsuario() {
    var vArea = document.getElementById('area-usuario');

    if (localStorage.getItem('autenticado') == 'true') {
        vArea.innerHTML = '<a href="cadastro.html"><img src="imagens/usuario.jpg" alt="Foto do usuário"></a> '
            + localStorage.getItem('usuario');
    } else {
        vArea.innerHTML = 'Usuário não autenticado';
    }
}

/* Opção default custom */
function trocaEstilo(pValor) {
    var vForm = document.getElementById('formulario');

    if (pValor == 'custom') {
        vForm.classList.add('custom');
    } else {
        vForm.classList.remove('custom');
    }
}