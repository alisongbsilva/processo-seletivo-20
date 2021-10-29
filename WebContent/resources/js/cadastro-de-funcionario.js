var cadastro = new Vue({
    el:"#cadastro",
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
        cadastrarFuncionario(){
            const vm = this;
            axios.post("/funcionarios_war/rs/funcionarios", vm.funcionario)
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