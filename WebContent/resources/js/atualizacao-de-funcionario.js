var atualizacao = new Vue({
    el:"#atualizacao",
    data: {
        setores: [],
        funcionario: {
            nome: "",
            setor: {
                id : 0
            },
        salario: 0,
        email: "",
        idade: 0
        }
    },
    created: function(){
        let vm = this;
        vm.listarSetores();
        vm.editarFuncionario();
    },
    methods:{
        listarSetores: function(){
            const vm = this;
            axios.get("/funcionarios_war/rs/setores")
                .then(response => {
                    vm.setores = response.data;
                }).catch(error => {
                    alert("Erro interno! Não foi possível listar setores.");
                })
        },
        editarFuncionario(){
            const vm = this;
            const id = window.location.href.split("?").pop();
            axios.get(`/funcionarios_war/rs/funcionarios/${id}`)
                .then(response => {vm.funcionario =response.data;
                }).catch(function (error) {
                
                //vm.mostraAlertaErro("Erro interno", "Não foi possível buscar funcionário.");
            })
        },
        atualizarFuncionario(){
            const vm = this;
            axios.put(`/funcionarios_war/rs/funcionarios/${vm.funcionario.id}`, vm.funcionario)
                .then(response => {
                    alert(response.data);
                    vm.returnInicio();
                }).catch(error => {
                    alert("Erro interno! Não foi possível cadastrar funcionário.");
                })
        },
        returnInicio(){
            window.location.href = "/funcionarios_war/";
        }

    }
})