/* Exemplo de Javascript*/

function validacao() {
    
    if (document.form.nome.value === "") {
        alert("Preenchimento obrigatório!");
        document.form.nome.focus();
        return false;
    }
    
    if (document.form.nome.value.length < 4) {
        alert("Digite no mínimo 4 caracteres!");
        document.form.nome.focus();
        return false;
    }
    
    if (document.form.email.value === "" || document.form.email.value.indexOf('@') === -1) {
        alert("Digite um email válido!");
        document.form.nome.focus();
        return false;
    }
}
