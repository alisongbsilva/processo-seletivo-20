# Como executar a aplicação

Basta seguir os passos abaixo: 

**1.** Instalar JDK versão 17;

**2.** Instalar a IDE Java (recomendado: Intellij IDEA, Eclipse ou Netbeans);

**3.** Instalar e configurar o Tomcat versão 9;

**4.** Instalar servidor MySQL e realizar a configuração básica (recomendado: MySQL Workbench);

**5.** Importar base de dados incluída na pasta SQL (recomendado: funcionarios_prova_schema.sql);

**6.** Clonar o projeto, abrir como projeto Maven;

**7.** Habilitar o JDK 17 para ser utilizado pelo projeto;

**8.** Configurar os dados do seu banco no arquivo *src -> META-INF -> persistence.xml*;

**9.** Configurar a base de dados MySQL na aba database da IDE;

**9.** Configurar para o projeto abrir utizando o Tomcat 9 pela URL *http://localhost:8080/funcionarios_war/*, na porta 8080, adicione Build artifact e Deployment para **funcionarios:war**;

**10.** Compilar e executar a aplicação através da IDE Java, então a interface da aplicação será aberta no navegador.



# Versões de importação da base de dados inclusas

**funcionarios_prova.sql :** somente os dados e estrutura do banco pronto para adicionar em uma base já existente;
**funcionarios_prova_schema.sql :** base de dados completa, a base já é criada com estrutura e dados e está pronta para uso;
**funcionarios_prova_setor.sql :** dados e estrutura para importar em uma base já existente, porém sem dados de funcionários, somente setores.
