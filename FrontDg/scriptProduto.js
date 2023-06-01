const nome = document.getElementById('nome')
const valor = document.getElementById('valor')
const listaDOM = document.getElementById("ulProdutos")
const btn = document.getElementById("btn")
const btnAlt = document.getElementById("btnAlt")
const btnDel = document.getElementById("btnDel")
let produtos = []
const pTotal = document.getElementById('pTotal')

async function getProdutos() {
    listaDOM.innerHTML = ""
    produtos = await (await fetch('http://localhost:8090/produtos')).json()
    for (let i = 0; i < produtos.length; i++) {
        const pNome = document.createElement("p")
        const pValor = document.createElement("p")
        const li = document.createElement("li")
        pNome.innerText = produtos[i].nome
        pValor.innerHTML = produtos[i].valor
        const botao = document.createElement("button")
        botao.innerHTML = 'selecionar'
        botao.id = `${i}`
        botao.classList = "btn btn-primary"
        botao.onclick = function () { selecionar(botao.id); }
        li.appendChild(pNome)
        li.appendChild(pValor)
        li.appendChild(botao)
        listaDOM.appendChild(li)
    }
    getTotal()

}


let idBackEnd = 0
let idDel = 0
function selecionar(id) {
    nome.value = produtos[id].nome
    valor.value = produtos[id].valor
    idBackEnd = produtos[id].id
    idDel = id
}


function deletar() {
    fetch("http://localhost:8090/produtos/" + idBackEnd,
        {
            method: "DELETE",
        })
        .then(function (res) {
            getProdutos()
            limpar()
        })
        .catch(function (res) { console.log(res) })
};

btnDel.addEventListener('click', function (event) {
    event.preventDefault();
    deletar()
    produtos.splice(idDel, 1)
    getTotal()
    Enviar()
})


function alterar() {
    fetch("http://localhost:8090/produtos",
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "PUT",
            body: JSON.stringify({
                id: idBackEnd,
                nome: nome.value,
                valorProduto: valor.value,
            })
        })
        .then(function (res) {
            getProdutos()
            limpar()
            validarValor()

        })
        .catch(function (res) { console.log(res) })
};

btnAlt.addEventListener('click', function (event) {
    event.preventDefault();
    alterar();
    getTotal()
})
function cadastrar() {
    fetch("http://localhost:8090/produtos",
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({
                id: 0,
                nome: nome.value,
                valorProduto: valor.value,
            })
        })
        .then(function (res) {
            getProdutos()
            validar()
            validarValor()
            limpar()
        })
        .catch(function (res) { console.log(res) })
};

btn.addEventListener('click', function (event) {
    event.preventDefault();
    cadastrar();
    getTotal()

})

getProdutos()

const getTotal = () => {
    const url = 'http://localhost:8090/produtos/total'
    fetch(url)
        .then(response => response.text())
        .then(total => {
            pTotal.innerHTML = total
        })
}
getTotal()

function validar() {
    for (let i = 0; i < produtos.length; i++) {
        if (nome.value === produtos[i].nome) {
            alert("O nome deve ser único")
        }
    }
}

function limpar() {
    // nome.value = ''
    valor.value = ''
}

function validarValor() {
   if(valor.value == ''){
    alert("Preencha todos os campos")
   }
}

function Enviar() {
listaDOM.innerHTML = " "  
// alert("try")     
}
Enviar()